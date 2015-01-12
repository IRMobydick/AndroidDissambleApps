package com.ubercab.client.feature.search;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import butterknife.OnTouch;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;
import com.ubercab.client.core.analytics.AnalyticsManager;
import com.ubercab.client.core.analytics.event.PageEvent;
import com.ubercab.client.core.analytics.event.TripEvent;
import com.ubercab.client.core.app.RiderFragment;
import com.ubercab.client.core.app.RiderPreferences;
import com.ubercab.client.core.content.PingProvider;
import com.ubercab.client.core.content.RiderLocationProvider;
import com.ubercab.client.core.location.RiderLocation;
import com.ubercab.client.core.metrics.analytics.RiderEvents.Impression;
import com.ubercab.client.core.metrics.analytics.RiderEvents.Tap;
import com.ubercab.client.core.model.AppConfig;
import com.ubercab.client.core.model.FavoriteLocationDistanceConstraints;
import com.ubercab.client.core.model.LocationAutocompleteResponse;
import com.ubercab.client.core.model.LocationHistoryResponse;
import com.ubercab.client.core.model.LocationSearchResponse;
import com.ubercab.client.core.model.LocationSearchResult;
import com.ubercab.client.core.model.LocationSearchResults;
import com.ubercab.client.core.model.Ping;
import com.ubercab.client.core.model.RiderAppConfig;
import com.ubercab.client.core.network.LocationClient;
import com.ubercab.client.core.network.events.LocationAutocompleteResponseEvent;
import com.ubercab.client.core.network.events.LocationDetailResponseEvent;
import com.ubercab.client.core.network.events.LocationHistoryResponseEvent;
import com.ubercab.client.core.network.events.LocationSearchResponseEvent;
import com.ubercab.client.core.util.AndroidUtils;
import com.ubercab.client.core.util.PingUtils;
import com.ubercab.client.feature.search.event.AddFavoriteLocationEvent;
import com.ubercab.client.feature.search.event.EditFavoriteLocationEvent;
import com.ubercab.client.feature.search.event.GetLocationDetailsEvent;
import com.ubercab.client.feature.search.event.LocationResultClickEvent;
import com.ubercab.client.feature.search.event.LocationSelectedEvent;
import com.ubercab.client.feature.search.event.LocationSkippedEvent;
import com.ubercab.client.feature.search.event.RemoveFavoriteLocationEvent;
import com.ubercab.client.feature.search.event.SelectFavoriteLocationEvent;
import com.ubercab.client.feature.trip.TripAnalyticsUtils;
import com.ubercab.client.feature.trip.rates.RateCardPopupWindow;
import com.ubercab.common.base.Function;
import com.ubercab.common.base.Predicate;
import com.ubercab.common.collect.ImmutableList;
import com.ubercab.common.collect.Iterables;
import com.ubercab.common.collect.Lists;
import com.ubercab.geo.GeoManager;
import com.ubercab.library.app.annotation.ForActivity;
import com.ubercab.library.location.model.UberLatLng;
import com.ubercab.library.metrics.analytics.AnalyticsClient;
import com.ubercab.library.metrics.analytics.AnalyticsEvent.Builder;
import com.ubercab.library.util.KeyboardUtils;
import com.ubercab.ui.TextWatcherAdapter;
import com.ubercab.ui.UberEditText;
import com.ubercab.ui.UberTextView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import timber.log.Timber;

public class LocationSearchFragment extends RiderFragment
  implements LocationSearchFooterView.Listener
{
  public static final String ACTION_ADD_FAVORITE_LOCATION = "com.ubercab.ACTION_ADD_FAVORITE_LOCATION";
  public static final String ACTION_DESTINATION = "com.ubercab.ACTION_DESTINATION";
  public static final String ACTION_DESTINATION_ETA = "com.ubercab.ACTION_DESTINATION_ETA";
  public static final String ACTION_EDIT_FAVORITE_LOCATION = "com.ubercab.ACTION_EDIT_FAVORITE_LOCATION";
  public static final String ACTION_PICKUP_LOCATION = "com.ubercab.ACTION_PICKUP_LOCATION";
  private static final String ARG_ACTION = "com.ubercab.ARG_ACTION";
  private static final String ARG_ACTION_BAR_TITLE = "com.ubercab.ARG_ACTION_BAR_TITLE";
  private static final String ARG_LOCATION_DESTINATION = "com.ubercab.ARG_LOCATION_DESTINATION";
  private static final String ARG_LOCATION_PICKUP = "com.ubercab.ARG_LOCATION_PICKUP";
  private static final String ARG_LOCATION_TAG = "com.ubercab.ARG_LOCATION_TAG";
  private static final String ARG_SHOW_RATES = "com.ubercab.ARG_SHOW_RATES";
  private static final String ARG_VEHICLE_VIEW_ID = "com.ubercab.ARG_VEHICLE_VIEW_ID";
  private static final String BUNDLE_FAVORITE_LOCATION_ADD_IMPRESSION = "com.ubercab.FAVORITE_LOCATION_ADD_IMPRESSION";
  private static final String BUNDLE_RATE_CARD_VISIBLE = "com.ubercab.RATE_CARD_VISIBLE";
  private static final int DEFAULT_MAX_RESULTS = 5;
  private static final long DELAY_DEBOUNCE_KEY_INPUT_MS = 250L;
  private static final int MIN_DISTANCE_BETWEEN_LOCATIONS = 20;
  private static final int RATE_CARD_DISPLAY_DELAY = 250;
  private static final String SEARCH_TEXT_AUTOFILL_TAG = "autofill";
  private String mAction;

  @Inject
  ActionBar mActionBar;
  private String mActionBarTitle;
  private boolean mAllowSkip;

  @Inject
  AnalyticsClient mAnalyticsClient;

  @Inject
  AnalyticsManager mAnalyticsManager;

  @Inject
  Bus mBus;
  private List<LocationSearchResult> mCachedLocations = new ArrayList();

  @ForActivity
  @Inject
  Context mContext;
  private RiderLocation mDestination;

  @InjectView(2131427491)
  UberEditText mEditTextSearch;
  private FavoriteLocationDistanceConstraints mFavoriteLocationDistanceConstraints;
  private List<LocationSearchResult> mFilteredCachedLocations = new ArrayList();
  private LocationSearchFooterView mFooterView;

  @Inject
  GeoManager mGeoManager;

  @InjectView(2131427492)
  ImageButton mImageButtonClear;
  private String mInitialLocationText;
  private boolean mIsDisplayingFullTextSearchResults;
  private boolean mIsFavoriteLocationImpressionCountRecorded;
  private boolean mIsFavoriteLocationsEnabled;
  private boolean mIsRateCardShown;

  @Inject
  LayoutInflater mLayoutInflater;

  @InjectView(2131427495)
  ListView mListViewLocation;

  @Inject
  LocationClient mLocationClient;

  @Inject
  RiderLocationProvider mLocationProvider;
  private LocationSearchAdapter mLocationSearchAdapter;
  private LocationSearchAdapter mLocationSearchFooterAdapter;
  private LocationSearchAdapter mLocationSearchHeaderAdapter;
  private LocationSearchMergedDividerAdapter mLocationSearchMergedDividerAdapter;
  private String mLocationTag;
  private RiderLocation mPickupLocation;

  @Inject
  PingProvider mPingProvider;
  private boolean mPrefilledTextApplied;
  private Handler mRateCardDisplayHandler;
  private Runnable mRateCardDisplayRunnable;
  private RateCardPopupWindow mRateCardPopupWindow;

  @Inject
  RiderPreferences mRiderPreferences;

  @InjectView(2131427490)
  LocationSearchIconView mSearchIcon;
  private boolean mShowRateBreakdown;
  private Runnable mTextInputCallback;
  private Handler mTextInputHandler;

  @InjectView(2131427498)
  UberTextView mTextViewEmpty;

  @InjectView(2131427493)
  UberTextView mTextViewSkip;
  private TextWatcher mTextWatcherSearch;
  private String mVehicleViewId;

  @InjectView(2131427494)
  ViewGroup mViewGroupContent;

  @InjectView(2131427497)
  LinearLayout mViewGroupEmpty;

  @InjectView(2131427496)
  ViewGroup mViewGroupLoading;

  private void clearHeaderFooterAdapters()
  {
    this.mLocationSearchHeaderAdapter.update(null);
    this.mLocationSearchFooterAdapter.update(null);
  }

  private void clearSearchText()
  {
    this.mEditTextSearch.setText("");
  }

  private void displayRateCard()
  {
    Activity localActivity = (Activity)this.mContext;
    if (!AndroidUtils.isWindowValid(localActivity.getWindow()));
    do
    {
      return;
      if (TextUtils.isEmpty(this.mVehicleViewId))
      {
        Timber.w("Error displaying rate card due to null vehicle view ID", new Object[0]);
        return;
      }
    }
    while ((this.mRateCardPopupWindow != null) && (this.mRateCardPopupWindow.isShowing()));
    this.mRateCardPopupWindow = new RateCardPopupWindow(localActivity, this.mVehicleViewId, this.mPickupLocation, this.mDestination, 0, true);
    this.mRateCardPopupWindow.showAtLocation(localActivity.getWindow().getDecorView(), 48, 0, 0);
    this.mAnalyticsClient.sendTapEvent(RiderEvents.Tap.FARE_ESTIMATE_OPEN_INFO);
    this.mRateCardPopupWindow.setOnDismissListener(new PopupWindow.OnDismissListener()
    {
      public void onDismiss()
      {
        LocationSearchFragment.access$1102(LocationSearchFragment.this, false);
        LocationSearchFragment.this.mAnalyticsClient.sendTapEvent(RiderEvents.Tap.FARE_ESTIMATE_DISMISS_INFO);
      }
    });
    this.mIsRateCardShown = true;
  }

  private void displayRateCardAfterDelay()
  {
    this.mRateCardDisplayHandler.postDelayed(this.mRateCardDisplayRunnable, 250L);
  }

  private LocationSearchResult getFavoriteLocation(String paramString)
  {
    if (this.mIsFavoriteLocationsEnabled)
      return this.mRiderPreferences.getFavoriteLocation(paramString);
    return null;
  }

  private List<LocationSearchResultWrapper> getFooterLocationResults()
  {
    Map localMap = getTaggedLocationMapping();
    ArrayList localArrayList = new ArrayList();
    if ((!"com.ubercab.ACTION_PICKUP_LOCATION".equals(this.mAction)) || (!this.mIsFavoriteLocationsEnabled) || (isFavoriteLocationMaxCountReached()));
    while (true)
    {
      return localArrayList;
      if (localMap.isEmpty())
      {
        LocationSearchResultWrapper[] arrayOfLocationSearchResultWrapper = new LocationSearchResultWrapper[2];
        arrayOfLocationSearchResultWrapper[0] = new LocationSearchResultWrapper(this.mContext, "home");
        arrayOfLocationSearchResultWrapper[1] = new LocationSearchResultWrapper(this.mContext, "work");
        return Arrays.asList(arrayOfLocationSearchResultWrapper);
      }
      for (String str : LocationSearchResult.HOME_WORK_TAGS)
        if (!localMap.containsKey(str))
          localArrayList.add(new LocationSearchResultWrapper(this.mContext, str));
    }
  }

  private List<LocationSearchResultWrapper> getHeaderLocationResults()
  {
    if ((!this.mIsFavoriteLocationsEnabled) || (isFavoriteLocationAction()) || (isFavoriteLocationMaxCountReached()))
    {
      localArrayList = new ArrayList();
      return localArrayList;
    }
    Map localMap = getTaggedLocationMapping();
    ArrayList localArrayList = new ArrayList();
    String[] arrayOfString = LocationSearchResult.HOME_WORK_TAGS;
    int i = arrayOfString.length;
    int j = 0;
    label55: String str;
    if (j < i)
    {
      str = arrayOfString[j];
      if (!localMap.containsKey(str))
        break label129;
      LocationSearchResult localLocationSearchResult = (LocationSearchResult)localMap.get(str);
      if (isLocationValidForDistanceConstraints(localLocationSearchResult))
        localArrayList.add(new LocationSearchResultWrapper(this.mContext, localLocationSearchResult, str));
    }
    while (true)
    {
      j++;
      break label55;
      break;
      label129: if ("com.ubercab.ACTION_DESTINATION".equals(this.mAction))
        localArrayList.add(new LocationSearchResultWrapper(this.mContext, str));
    }
  }

  private String getLocalizedTag(String paramString)
  {
    if (LocationSearchResult.isTagHome(paramString))
      return getString(2131558891);
    if (LocationSearchResult.isTagWork(paramString))
      return getString(2131559348);
    return null;
  }

  private String getSearchText()
  {
    return this.mEditTextSearch.getText().toString();
  }

  private Map<String, LocationSearchResult> getTaggedLocationMapping()
  {
    HashMap localHashMap = new HashMap();
    for (String str : LocationSearchResult.HOME_WORK_TAGS)
    {
      LocationSearchResult localLocationSearchResult = this.mRiderPreferences.getFavoriteLocation(str);
      if (localLocationSearchResult != null)
        localHashMap.put(str, localLocationSearchResult);
    }
    return localHashMap;
  }

  private void handleSearchResult(LocationSearchResult paramLocationSearchResult)
  {
    if (isFavoriteLocationAction())
    {
      saveFavoriteLocation(this.mLocationTag, paramLocationSearchResult);
      this.mBus.post(new SelectFavoriteLocationEvent());
      return;
    }
    selectLocation(paramLocationSearchResult);
  }

  private void hideLoadingSpinner()
  {
    this.mSearchIcon.hideLoading();
  }

  private void incrementFavoriteLocationAddImpression()
  {
    int i = getTaggedLocationMapping().size();
    if ((this.mIsFavoriteLocationsEnabled) && (i == 0) && (!isFavoriteLocationMaxCountReached()) && (!this.mIsFavoriteLocationImpressionCountRecorded))
    {
      this.mIsFavoriteLocationImpressionCountRecorded = true;
      this.mRiderPreferences.incrementFavoriteLocationImpressionCount();
    }
  }

  private void initActionBar()
  {
    if (TextUtils.isEmpty(this.mActionBarTitle))
    {
      this.mActionBar.hide();
      return;
    }
    this.mActionBar.setTitle(this.mActionBarTitle);
    this.mActionBar.setDisplayHomeAsUpEnabled(true);
  }

  private void initFooterView()
  {
    if (this.mGeoManager.getGeo() == 3)
      this.mFooterView.hidePoweredByGoogle();
    String str = "";
    boolean bool = "com.ubercab.ACTION_EDIT_FAVORITE_LOCATION".equals(this.mAction);
    if (LocationSearchResult.isTagHome(this.mLocationTag))
      str = getString(2131558891);
    while (bool)
    {
      this.mFooterView.setRemoveButtonText(str);
      this.mFooterView.showRemoveButton();
      this.mFooterView.hideSearchMore();
      return;
      if (LocationSearchResult.isTagWork(this.mLocationTag))
        str = getString(2131559348);
    }
    this.mFooterView.hideRemoveButton();
  }

  private void initPrefilledText()
  {
    Resources localResources = this.mContext.getResources();
    String str1 = this.mAction;
    int i = -1;
    switch (str1.hashCode())
    {
    default:
      switch (i)
      {
      default:
      case 0:
      case 1:
      case 2:
      case 3:
      }
      break;
    case -669628160:
    case 1712228054:
    case -278828126:
    case 423766043:
    }
    do
    {
      do
      {
        return;
        if (!str1.equals("com.ubercab.ACTION_PICKUP_LOCATION"))
          break;
        i = 0;
        break;
        if (!str1.equals("com.ubercab.ACTION_DESTINATION"))
          break;
        i = 1;
        break;
        if (!str1.equals("com.ubercab.ACTION_ADD_FAVORITE_LOCATION"))
          break;
        i = 2;
        break;
        if (!str1.equals("com.ubercab.ACTION_EDIT_FAVORITE_LOCATION"))
          break;
        i = 3;
        break;
      }
      while (this.mPickupLocation == null);
      setPrefilledTextFromLocation(this.mPickupLocation);
      return;
    }
    while (this.mDestination == null);
    setPrefilledTextFromLocation(this.mDestination);
    return;
    String str2 = getLocalizedTag(this.mLocationTag);
    UberEditText localUberEditText = this.mEditTextSearch;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = str2.toLowerCase();
    localUberEditText.setHint(localResources.getString(2131558873, arrayOfObject));
    return;
    setPrefilledTextFromLocation(RiderLocation.create(getFavoriteLocation(this.mLocationTag)));
  }

  private void initSearchBarIcon()
  {
    int i = 2130837749;
    if (isFavoriteLocationAction())
    {
      if (!LocationSearchResult.isTagHome(this.mLocationTag))
        break label34;
      i = 2130837762;
    }
    while (true)
    {
      this.mSearchIcon.setDefaultIconResource(i);
      return;
      label34: if (LocationSearchResult.isTagWork(this.mLocationTag))
        i = 2130837773;
    }
  }

  private boolean isFavoriteLocationAction()
  {
    return ("com.ubercab.ACTION_ADD_FAVORITE_LOCATION".equals(this.mAction)) || ("com.ubercab.ACTION_EDIT_FAVORITE_LOCATION".equals(this.mAction));
  }

  private boolean isFavoriteLocationMaxCountReached()
  {
    int i = getResources().getInteger(2131492874);
    return this.mRiderPreferences.getFavoriteLocationImpressionCount() > i;
  }

  private static boolean isSameLocation(RiderLocation paramRiderLocation1, RiderLocation paramRiderLocation2)
  {
    boolean bool = true;
    if ((paramRiderLocation1 == null) || (paramRiderLocation2 == null))
      bool = false;
    do
    {
      do
        return bool;
      while ((!TextUtils.isEmpty(paramRiderLocation1.getReference())) && (paramRiderLocation1.getReference().equals(paramRiderLocation2.getReference())));
      if ((paramRiderLocation1.getUberLatLng() == null) || (paramRiderLocation2.getUberLatLng() == null))
        break;
    }
    while (UberLatLng.distanceInMeters(paramRiderLocation1.getUberLatLng(), paramRiderLocation2.getUberLatLng()) < 20.0D);
    return false;
    return false;
  }

  private boolean isSearchTextEmptyOrPrefilled()
  {
    return (TextUtils.isEmpty(getSearchText().trim())) || (this.mEditTextSearch.getTag() != null);
  }

  public static LocationSearchFragment newInstance(String paramString1, RiderLocation paramRiderLocation1, RiderLocation paramRiderLocation2, String paramString2, String paramString3, boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("com.ubercab.ARG_ACTION", paramString1);
    localBundle.putParcelable("com.ubercab.ARG_LOCATION_PICKUP", paramRiderLocation1);
    localBundle.putParcelable("com.ubercab.ARG_LOCATION_DESTINATION", paramRiderLocation2);
    localBundle.putString("com.ubercab.ARG_ACTION_BAR_TITLE", paramString3);
    localBundle.putBoolean("com.ubercab.ARG_SHOW_RATES", paramBoolean);
    localBundle.putString("com.ubercab.ARG_VEHICLE_VIEW_ID", paramString2);
    LocationSearchFragment localLocationSearchFragment = new LocationSearchFragment();
    localLocationSearchFragment.setArguments(localBundle);
    return localLocationSearchFragment;
  }

  public static LocationSearchFragment newInstance(String paramString1, String paramString2, RiderLocation paramRiderLocation)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("com.ubercab.ARG_ACTION", paramString1);
    localBundle.putParcelable("com.ubercab.ARG_LOCATION_PICKUP", paramRiderLocation);
    localBundle.putString("com.ubercab.ARG_LOCATION_TAG", paramString2);
    LocationSearchFragment localLocationSearchFragment = new LocationSearchFragment();
    localLocationSearchFragment.setArguments(localBundle);
    return localLocationSearchFragment;
  }

  private void refreshFooterView()
  {
    boolean bool = true;
    if ((isSearchTextEmptyOrPrefilled()) || (this.mIsDisplayingFullTextSearchResults))
    {
      this.mFooterView.hideSearchMore();
      return;
    }
    Object[] arrayOfObject = new Object[bool];
    arrayOfObject[0] = getSearchText();
    String str = getString(2131558915, arrayOfObject);
    if (this.mLocationSearchAdapter.getCount() > 0);
    while (true)
    {
      this.mFooterView.showSearchMore(bool, str);
      return;
      bool = false;
    }
  }

  private void removeFavoriteLocation(String paramString)
  {
    if (!this.mIsFavoriteLocationsEnabled)
      return;
    this.mRiderPreferences.removeFavoriteLocation(paramString);
  }

  private void saveFavoriteLocation(String paramString, LocationSearchResult paramLocationSearchResult)
  {
    if (!this.mIsFavoriteLocationsEnabled)
      return;
    this.mRiderPreferences.setFavoriteLocation(paramString, paramLocationSearchResult);
  }

  private void selectLocation(LocationSearchResult paramLocationSearchResult)
  {
    List localList = transformFromWrappers(this.mLocationSearchAdapter.getItems());
    RiderLocation localRiderLocation = RiderLocation.create(paramLocationSearchResult);
    String str1 = this.mAction;
    int i = -1;
    label92: String str3;
    int j;
    label112: Integer localInteger2;
    String str4;
    switch (str1.hashCode())
    {
    default:
      switch (i)
      {
      default:
        String str2 = paramLocationSearchResult.getServiceType();
        str3 = getSearchText();
        if (str3 == null)
        {
          j = -1;
          Integer localInteger1 = Integer.valueOf(j);
          localInteger2 = Integer.valueOf(TripAnalyticsUtils.indexInLocationResultList(localList, paramLocationSearchResult));
          str4 = String.format("%s:%d:%d:%f:%f", new Object[] { str2, localInteger1, Integer.valueOf(TripAnalyticsUtils.indexInLocationResultSublist(localList, paramLocationSearchResult)), paramLocationSearchResult.getLatitude(), paramLocationSearchResult.getLongitude() });
          if (!"com.ubercab.ACTION_PICKUP_LOCATION".equals(this.mAction))
            break label400;
        }
        break;
      case 0:
      case 1:
      case 2:
      }
      break;
    case -669628160:
    case 1712228054:
    case 458188937:
    }
    label400: for (RiderEvents.Tap localTap = RiderEvents.Tap.SEARCH_PICKUP_SELECT; ; localTap = RiderEvents.Tap.SEARCH_DROPOFF_SELECT)
    {
      this.mAnalyticsClient.addEvent(new AnalyticsEvent.Builder("tap").setName(localTap).setValue(str4).setValuePosition(Long.valueOf(localInteger2.intValue())).build());
      return;
      if (!str1.equals("com.ubercab.ACTION_PICKUP_LOCATION"))
        break;
      i = 0;
      break;
      if (!str1.equals("com.ubercab.ACTION_DESTINATION"))
        break;
      i = 1;
      break;
      if (!str1.equals("com.ubercab.ACTION_DESTINATION_ETA"))
        break;
      i = 2;
      break;
      if (isSameLocation(localRiderLocation, this.mDestination))
      {
        showToast(getString(2131558819));
        return;
      }
      this.mAnalyticsManager.tripEvent().locationSelectPickup(paramLocationSearchResult, localList);
      this.mBus.post(new LocationSelectedEvent(localRiderLocation));
      break label92;
      if (isSameLocation(localRiderLocation, this.mPickupLocation))
      {
        showToast(getString(2131558818));
        return;
      }
      this.mAnalyticsManager.tripEvent().locationSelectDropoff(paramLocationSearchResult, localList);
      this.mBus.post(new LocationSelectedEvent(localRiderLocation));
      break label92;
      j = str3.length();
      break label112;
    }
  }

  private void sendFavoriteLocationImpressionEvent(String paramString, boolean paramBoolean, int paramInt)
  {
    if (paramBoolean);
    for (RiderEvents.Impression localImpression = RiderEvents.Impression.FAVORITES_SAVED; ; localImpression = RiderEvents.Impression.FAVORITES_ADD)
    {
      this.mAnalyticsClient.addEvent(new AnalyticsEvent.Builder("impression").setName(localImpression).setValue(paramString).setValuePosition(Long.valueOf(paramInt)).build());
      return;
    }
  }

  private void sendFavoriteLocationRemoveEvent(String paramString)
  {
    this.mAnalyticsClient.addEvent(new AnalyticsEvent.Builder("tap").setName(RiderEvents.Tap.FAVORITES_REMOVE).setValue(paramString).build());
  }

  private void sendFavoriteLocationTapEvent(String paramString, boolean paramBoolean, int paramInt)
  {
    RiderEvents.Tap localTap;
    if ("com.ubercab.ACTION_PICKUP_LOCATION".equals(this.mAction))
      if (paramBoolean)
        localTap = RiderEvents.Tap.SEARCH_PICKUP_OPEN_ADDFAVORITE;
    while (localTap == null)
    {
      return;
      localTap = RiderEvents.Tap.SEARCH_PICKUP_OPEN_EDITFAVORITE;
      continue;
      boolean bool = "com.ubercab.ACTION_DESTINATION".equals(this.mAction);
      localTap = null;
      if (bool)
      {
        if (paramBoolean);
        for (localTap = RiderEvents.Tap.SEARCH_DROPOFF_OPEN_ADDFAVORITE; ; localTap = RiderEvents.Tap.SEARCH_DROPOFF_OPEN_EDITFAVORITE)
          break;
      }
    }
    this.mAnalyticsClient.addEvent(new AnalyticsEvent.Builder("tap").setName(localTap).setValue(paramString).setValuePosition(Long.valueOf(paramInt)).build());
  }

  private void sendImpressionEvents(List<LocationSearchResultWrapper> paramList, int paramInt)
  {
    int i = 0;
    if (i < paramList.size())
    {
      LocationSearchResultWrapper localLocationSearchResultWrapper = (LocationSearchResultWrapper)paramList.get(i);
      if (localLocationSearchResultWrapper.getLocationSearchResult() != null);
      for (boolean bool = true; ; bool = false)
      {
        sendFavoriteLocationImpressionEvent(localLocationSearchResultWrapper.getTag(), bool, i + paramInt);
        i++;
        break;
      }
    }
  }

  private void sendLocationPredictionsRequest(String paramString, boolean paramBoolean)
  {
    if (isSearchTextEmptyOrPrefilled())
      return;
    showLoadingSpinner();
    double d1 = 0.0D;
    double d2 = 0.0D;
    if (this.mPickupLocation != null)
    {
      d1 = this.mPickupLocation.getUberLatLng().getLatitude();
      d2 = this.mPickupLocation.getUberLatLng().getLongitude();
    }
    if (paramBoolean)
    {
      this.mLocationClient.search(d1, d2, paramString);
      return;
    }
    this.mLocationClient.autocomplete(d1, d2, paramString);
  }

  private void sendPreferredLocationsRequest()
  {
    showLoadingSpinner();
    double d1 = 0.0D;
    double d2 = 0.0D;
    if (this.mPickupLocation != null)
    {
      d1 = this.mPickupLocation.getUberLatLng().getLatitude();
      d2 = this.mPickupLocation.getUberLatLng().getLongitude();
    }
    this.mLocationClient.history(d1, d2);
  }

  private void setPrefilledTextFromLocation(RiderLocation paramRiderLocation)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    String str1 = paramRiderLocation.getNickname();
    String str2 = paramRiderLocation.getDisplayAddressDescription();
    if (!TextUtils.isEmpty(str1))
      localStringBuilder.append(str1);
    if ((TextUtils.isEmpty(str1)) || (!str2.startsWith(str1)))
      localStringBuilder.append(str2);
    this.mInitialLocationText = localStringBuilder.toString();
    this.mPrefilledTextApplied = true;
    this.mEditTextSearch.setTag("autofill");
    this.mEditTextSearch.setText(this.mInitialLocationText);
    this.mEditTextSearch.setSelection(this.mInitialLocationText.length(), 0);
    this.mImageButtonClear.setVisibility(0);
  }

  private void showLoadingSpinner()
  {
    this.mSearchIcon.displayLoading();
  }

  private List<LocationSearchResult> transformFromWrappers(List<LocationSearchResultWrapper> paramList)
  {
    return Lists.newArrayList(Iterables.transform(paramList, new Function()
    {
      public LocationSearchResult apply(LocationSearchResultWrapper paramAnonymousLocationSearchResultWrapper)
      {
        return paramAnonymousLocationSearchResultWrapper.getLocationSearchResult();
      }
    }));
  }

  private List<LocationSearchResultWrapper> transformToWrappers(List<LocationSearchResult> paramList)
  {
    return Lists.newArrayList(Iterables.transform(paramList, new Function()
    {
      public LocationSearchResultWrapper apply(LocationSearchResult paramAnonymousLocationSearchResult)
      {
        return new LocationSearchResultWrapper(LocationSearchFragment.this.mContext, paramAnonymousLocationSearchResult);
      }
    }));
  }

  private void updateList()
  {
    String str1 = getSearchText();
    if (isSearchTextEmptyOrPrefilled())
      updateLocationAdapters();
    do
    {
      return;
      clearHeaderFooterAdapters();
      final String str2 = str1.toLowerCase();
      this.mFilteredCachedLocations = Lists.newArrayList(Iterables.limit(Iterables.filter(this.mCachedLocations, new Predicate()
      {
        public boolean apply(LocationSearchResult paramAnonymousLocationSearchResult)
        {
          String str1 = paramAnonymousLocationSearchResult.getNickname();
          String str2 = paramAnonymousLocationSearchResult.getLongAddress();
          return ((str1 != null) && (str1.toLowerCase().contains(str2))) || ((str2 != null) && (str2.toLowerCase().contains(str2)));
        }
      }), 5));
      if (this.mFilteredCachedLocations.size() <= 5)
        sendLocationPredictionsRequest(str1, false);
    }
    while (this.mFilteredCachedLocations.isEmpty());
    this.mLocationSearchAdapter.update(transformToWrappers(this.mFilteredCachedLocations));
  }

  private void updateListVisibility()
  {
    int i = 8;
    int j = 1;
    int k;
    label35: int m;
    label48: ViewGroup localViewGroup;
    if (this.mLocationSearchAdapter.getCount() == 0)
    {
      k = j;
      if ((k == 0) || (isSearchTextEmptyOrPrefilled()) || (!this.mIsDisplayingFullTextSearchResults))
        break label77;
      LinearLayout localLinearLayout = this.mViewGroupEmpty;
      if (j == 0)
        break label82;
      m = 0;
      localLinearLayout.setVisibility(m);
      localViewGroup = this.mViewGroupContent;
      if (j == 0)
        break label88;
    }
    while (true)
    {
      localViewGroup.setVisibility(i);
      return;
      k = 0;
      break;
      label77: j = 0;
      break label35;
      label82: m = i;
      break label48;
      label88: i = 0;
    }
  }

  private void updateListWithPredictions(List<LocationSearchResult> paramList)
  {
    ArrayList localArrayList = Lists.newArrayList(this.mFilteredCachedLocations);
    Iterator localIterator = paramList.iterator();
    while (true)
    {
      final LocationSearchResult localLocationSearchResult;
      if (localIterator.hasNext())
      {
        localLocationSearchResult = (LocationSearchResult)localIterator.next();
        if (localArrayList.size() < 5);
      }
      else
      {
        List localList = getMatchedFavoriteLocations();
        localList.addAll(transformToWrappers(localArrayList));
        this.mLocationSearchAdapter.update(localList);
        return;
      }
      if (!Iterables.any(this.mFilteredCachedLocations, new Predicate()
      {
        public boolean apply(LocationSearchResult paramAnonymousLocationSearchResult)
        {
          return paramAnonymousLocationSearchResult.isDuplicate(localLocationSearchResult);
        }
      }))
        localArrayList.add(localLocationSearchResult);
    }
  }

  private void updateLocationAdapters()
  {
    List localList1 = getHeaderLocationResults();
    List localList2 = getFooterLocationResults();
    ArrayList localArrayList1 = new ArrayList(localList1);
    localArrayList1.addAll(localList2);
    this.mLocationSearchHeaderAdapter.update(localList1);
    this.mLocationSearchFooterAdapter.update(localList2);
    final HashSet localHashSet = new HashSet();
    Iterator localIterator = localArrayList1.iterator();
    while (localIterator.hasNext())
    {
      LocationSearchResultWrapper localLocationSearchResultWrapper = (LocationSearchResultWrapper)localIterator.next();
      if (localLocationSearchResultWrapper.getLocationSearchResult() != null)
        localHashSet.add(localLocationSearchResultWrapper.getLocationSearchResult().getHash());
    }
    ArrayList localArrayList2 = Lists.newArrayList(Iterables.limit(Iterables.filter(this.mCachedLocations, new Predicate()
    {
      public boolean apply(LocationSearchResult paramAnonymousLocationSearchResult)
      {
        return !localHashSet.contains(paramAnonymousLocationSearchResult.getHash());
      }
    }), 5));
    sendImpressionEvents(localList1, 0);
    sendImpressionEvents(localList2, localArrayList2.size() + localList1.size());
    this.mLocationSearchAdapter.update(transformToWrappers(localArrayList2));
  }

  List<LocationSearchResultWrapper> getMatchedFavoriteLocations()
  {
    ArrayList localArrayList = new ArrayList();
    for (String str : LocationSearchResult.HOME_WORK_TAGS)
    {
      LocationSearchResult localLocationSearchResult = getFavoriteLocation(str);
      if (isFavoriteLocationMatched(getLocalizedTag(str), localLocationSearchResult))
        localArrayList.add(new LocationSearchResultWrapper(this.mContext, localLocationSearchResult, str));
    }
    return localArrayList;
  }

  boolean isFavoriteLocationMatched(String paramString, LocationSearchResult paramLocationSearchResult)
  {
    if (paramLocationSearchResult == null);
    label92: label96: 
    while (true)
    {
      return false;
      Locale localLocale = Locale.getDefault();
      String str1 = getSearchText().toLowerCase(localLocale);
      String str2 = paramLocationSearchResult.getTitle();
      int i;
      if ((!TextUtils.isEmpty(str2)) && (str2.toLowerCase(localLocale).contains(str1)))
      {
        i = 1;
        if ((TextUtils.isEmpty(paramString)) || (!paramString.toLowerCase(localLocale).contains(str1)))
          break label92;
      }
      for (int j = 1; ; j = 0)
      {
        if ((j == 0) && (i == 0))
          break label96;
        return true;
        i = 0;
        break;
      }
    }
  }

  boolean isLocationValidForDistanceConstraints(LocationSearchResult paramLocationSearchResult)
  {
    if (this.mFavoriteLocationDistanceConstraints == null)
      return true;
    boolean bool = true;
    if ("com.ubercab.ACTION_PICKUP_LOCATION".equals(this.mAction))
      bool = isWithinMaximumPickupDistance(paramLocationSearchResult);
    while (!"com.ubercab.ACTION_DESTINATION".equals(this.mAction))
      return bool;
    if ((isWithinMaximumDropoffDistance(paramLocationSearchResult)) && (isOverMinimumDropoffDistance(paramLocationSearchResult)));
    for (bool = true; ; bool = false)
      break;
  }

  boolean isOverMinimumDropoffDistance(LocationSearchResult paramLocationSearchResult)
  {
    Integer localInteger = this.mFavoriteLocationDistanceConstraints.getMinimumDropoffDistanceInMeters();
    if (localInteger == null);
    while ((this.mPickupLocation == null) || (UberLatLng.distanceInMeters(this.mPickupLocation.getUberLatLng(), paramLocationSearchResult.getUberLatLng()) >= localInteger.intValue()))
      return true;
    return false;
  }

  boolean isWithinMaximumDropoffDistance(LocationSearchResult paramLocationSearchResult)
  {
    Integer localInteger = this.mFavoriteLocationDistanceConstraints.getMaximumDropoffDistanceInMeters();
    if (localInteger == null);
    while ((this.mPickupLocation == null) || (UberLatLng.distanceInMeters(this.mPickupLocation.getUberLatLng(), paramLocationSearchResult.getUberLatLng()) <= localInteger.intValue()))
      return true;
    return false;
  }

  boolean isWithinMaximumPickupDistance(LocationSearchResult paramLocationSearchResult)
  {
    Integer localInteger = this.mFavoriteLocationDistanceConstraints.getMaximumPickupDistanceInMeters();
    if (localInteger == null);
    RiderLocation localRiderLocation;
    do
    {
      return true;
      localRiderLocation = this.mLocationProvider.getPinLocation();
    }
    while ((localRiderLocation == null) || (UberLatLng.distanceInMeters(localRiderLocation.getUberLatLng(), paramLocationSearchResult.getUberLatLng()) <= localInteger.intValue()));
    return false;
  }

  @Subscribe
  public void onAddFavoriteLocationEvent(AddFavoriteLocationEvent paramAddFavoriteLocationEvent)
  {
    if ("com.ubercab.ACTION_DESTINATION".equals(this.mAction));
    for (int i = paramAddFavoriteLocationEvent.getPosition(); ; i = this.mLocationSearchHeaderAdapter.getCount() + this.mLocationSearchAdapter.getCount() + paramAddFavoriteLocationEvent.getPosition())
    {
      sendFavoriteLocationTapEvent(paramAddFavoriteLocationEvent.getTag(), true, i);
      return;
    }
  }

  @OnClick({2131427492})
  public void onClickImageButtonClear()
  {
    clearSearchText();
    updateList();
  }

  @OnClick({2131427490})
  public void onClickLocationSearchIcon()
  {
    this.mEditTextSearch.requestFocus();
  }

  public void onClickRemoveTagged()
  {
    sendFavoriteLocationRemoveEvent(this.mLocationTag);
    removeFavoriteLocation(this.mLocationTag);
    this.mBus.post(new RemoveFavoriteLocationEvent());
  }

  public void onClickSearchMore()
  {
    sendLocationPredictionsRequest(getSearchText(), true);
    this.mAnalyticsClient.sendTapEvent(RiderEvents.Tap.SEARCH_MANUAL_SEARCH_PAGE);
  }

  @OnClick({2131427493})
  public void onClickTextViewSkip()
  {
    KeyboardUtils.hideKeyboard(getActivity(), getActivity().getCurrentFocus());
    this.mBus.post(new LocationSkippedEvent());
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mAction = getArguments().getString("com.ubercab.ARG_ACTION");
    this.mActionBarTitle = getArguments().getString("com.ubercab.ARG_ACTION_BAR_TITLE");
    this.mDestination = ((RiderLocation)getArguments().getParcelable("com.ubercab.ARG_LOCATION_DESTINATION"));
    this.mLocationTag = getArguments().getString("com.ubercab.ARG_LOCATION_TAG");
    this.mPickupLocation = ((RiderLocation)getArguments().getParcelable("com.ubercab.ARG_LOCATION_PICKUP"));
    this.mShowRateBreakdown = getArguments().getBoolean("com.ubercab.ARG_SHOW_RATES", false);
    this.mVehicleViewId = getArguments().getString("com.ubercab.ARG_VEHICLE_VIEW_ID");
    Ping localPing = this.mPingProvider.get();
    if (PingUtils.hasRiderAppConfig(localPing))
      this.mFavoriteLocationDistanceConstraints = localPing.getAppConfig().getRiderConfig().getFavoriteLocationDistanceConstraints();
    this.mIsFavoriteLocationsEnabled = this.mRiderPreferences.isFakeFavoriteLocationsEnabledForHomeWork();
    initActionBar();
    this.mTextInputHandler = new Handler();
    this.mTextInputCallback = new Runnable()
    {
      public void run()
      {
        LocationSearchFragment.this.updateList();
      }
    };
    this.mRateCardDisplayHandler = new Handler();
    this.mRateCardDisplayRunnable = new Runnable()
    {
      public void run()
      {
        if (!LocationSearchFragment.this.isResumed())
          return;
        if (TextUtils.isEmpty(LocationSearchFragment.this.mVehicleViewId))
        {
          Timber.w("Rate card not displayed due to empty vvid.", new Object[0]);
          return;
        }
        LocationSearchFragment.this.displayRateCard();
      }
    };
    if (paramBundle != null)
    {
      this.mIsRateCardShown = paramBundle.getBoolean("com.ubercab.RATE_CARD_VISIBLE", false);
      this.mIsFavoriteLocationImpressionCountRecorded = paramBundle.getBoolean("com.ubercab.FAVORITE_LOCATION_ADD_IMPRESSION", false);
    }
  }

  public void onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    if (this.mShowRateBreakdown)
      paramMenuInflater.inflate(2131689473, paramMenu);
    super.onCreateOptionsMenu(paramMenu, paramMenuInflater);
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(2130903096, paramViewGroup, false);
    ButterKnife.inject(this, localView);
    return localView;
  }

  public void onDestroyView()
  {
    super.onDestroyView();
    this.mEditTextSearch.removeTextChangedListener(this.mTextWatcherSearch);
    this.mFooterView.removeListener(this);
    ButterKnife.reset(this);
  }

  @Subscribe
  public void onEditFavoriteLocationEvent(EditFavoriteLocationEvent paramEditFavoriteLocationEvent)
  {
    int i = paramEditFavoriteLocationEvent.getPosition();
    sendFavoriteLocationTapEvent(paramEditFavoriteLocationEvent.getTag(), false, i);
  }

  @Subscribe
  public void onGetLocationDetailsEvent(GetLocationDetailsEvent paramGetLocationDetailsEvent)
  {
    this.mLocationClient.details(paramGetLocationDetailsEvent.getReference(), paramGetLocationDetailsEvent.getType());
  }

  @Subscribe
  public void onLocationAutocompleteEvent(LocationAutocompleteResponseEvent paramLocationAutocompleteResponseEvent)
  {
    hideLoadingSpinner();
    this.mViewGroupLoading.setVisibility(8);
    String str = paramLocationAutocompleteResponseEvent.getQuery();
    if (!getSearchText().equals(str))
      return;
    if (!paramLocationAutocompleteResponseEvent.isSuccess())
    {
      showToast(getString(2131558911));
      return;
    }
    this.mIsDisplayingFullTextSearchResults = false;
    updateListWithPredictions(((LocationAutocompleteResponse)paramLocationAutocompleteResponseEvent.getModel()).getPredictions());
  }

  @Subscribe
  public void onLocationClickEvent(LocationResultClickEvent paramLocationResultClickEvent)
  {
    handleSearchResult(paramLocationResultClickEvent.getLocationResult());
  }

  @Subscribe
  public void onLocationDetailResponse(LocationDetailResponseEvent paramLocationDetailResponseEvent)
  {
    if (!paramLocationDetailResponseEvent.isSuccess())
    {
      showToast(getString(2131558913));
      return;
    }
    LocationSearchResult localLocationSearchResult = (LocationSearchResult)paramLocationDetailResponseEvent.getModel();
    this.mIsDisplayingFullTextSearchResults = false;
    handleSearchResult(localLocationSearchResult);
  }

  @Subscribe
  public void onLocationHistoryResponse(LocationHistoryResponseEvent paramLocationHistoryResponseEvent)
  {
    hideLoadingSpinner();
    this.mViewGroupLoading.setVisibility(8);
    if (!paramLocationHistoryResponseEvent.isSuccess())
    {
      showToast(getString(2131558912));
      return;
    }
    if ("com.ubercab.ACTION_PICKUP_LOCATION".equals(this.mAction))
    {
      this.mCachedLocations = ((LocationHistoryResponse)paramLocationHistoryResponseEvent.getModel()).getPickups().getAllResults();
      this.mAnalyticsManager.pageEvent().pickupSearchResultImpressions(this.mCachedLocations.size());
      this.mAnalyticsClient.addEvent(new AnalyticsEvent.Builder("impression").setName(RiderEvents.Impression.SEARCH_PICKUP_SUGGESTIONS).setValuePosition(Long.valueOf(this.mCachedLocations.size())).build());
    }
    while (true)
    {
      updateList();
      return;
      this.mCachedLocations = ((LocationHistoryResponse)paramLocationHistoryResponseEvent.getModel()).getDropoffs().getAllResults();
      this.mAnalyticsManager.pageEvent().dropoffSearchResultImpressions(this.mCachedLocations.size());
      this.mAnalyticsClient.addEvent(new AnalyticsEvent.Builder("impression").setName(RiderEvents.Impression.SEARCH_DROPOFF_SUGGESTIONS).setValuePosition(Long.valueOf(this.mCachedLocations.size())).build());
    }
  }

  @Subscribe
  public void onLocationSearchEvent(LocationSearchResponseEvent paramLocationSearchResponseEvent)
  {
    hideLoadingSpinner();
    this.mViewGroupLoading.setVisibility(8);
    String str = paramLocationSearchResponseEvent.getQuery();
    if (!getSearchText().equals(str))
      return;
    if (!paramLocationSearchResponseEvent.isSuccess())
    {
      showToast(getString(2131558911));
      return;
    }
    this.mIsDisplayingFullTextSearchResults = true;
    updateListWithPredictions(((LocationSearchResponse)paramLocationSearchResponseEvent.getModel()).getPredictions());
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default:
      return super.onOptionsItemSelected(paramMenuItem);
    case 2131427935:
    }
    displayRateCard();
    return true;
  }

  public void onResume()
  {
    super.onResume();
    if (this.mLocationSearchAdapter.isEmpty())
    {
      this.mViewGroupLoading.setVisibility(0);
      sendPreferredLocationsRequest();
    }
    if (this.mIsRateCardShown)
      displayRateCardAfterDelay();
    incrementFavoriteLocationAddImpression();
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putBoolean("com.ubercab.RATE_CARD_VISIBLE", this.mIsRateCardShown);
    paramBundle.putBoolean("com.ubercab.FAVORITE_LOCATION_ADD_IMPRESSION", this.mIsFavoriteLocationImpressionCountRecorded);
  }

  @Subscribe
  public void onSelectFavoriteLocation(SelectFavoriteLocationEvent paramSelectFavoriteLocationEvent)
  {
    this.mRiderPreferences.clearFavoriteLocationImpressionCount();
    KeyboardUtils.hideKeyboard(this.mContext, this.mEditTextSearch);
  }

  @OnTouch({2131427495})
  public boolean onTouchListViewLocations()
  {
    KeyboardUtils.hideKeyboard(getActivity(), this.mEditTextSearch);
    return false;
  }

  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    setHasOptionsMenu(true);
    this.mFooterView = ((LocationSearchFooterView)this.mLayoutInflater.inflate(2130903165, this.mListViewLocation, false));
    this.mFooterView.addListener(this);
    this.mLocationSearchAdapter = new LocationSearchAdapter(this.mContext, this.mBus, true, true);
    this.mLocationSearchHeaderAdapter = new LocationSearchAdapter(this.mContext, this.mBus, true, true);
    this.mLocationSearchFooterAdapter = new LocationSearchAdapter(this.mContext, this.mBus, true, true);
    ImmutableList localImmutableList = ImmutableList.of(this.mLocationSearchHeaderAdapter, this.mLocationSearchAdapter, this.mLocationSearchFooterAdapter);
    this.mLocationSearchMergedDividerAdapter = new LocationSearchMergedDividerAdapter(this.mContext, localImmutableList);
    this.mLocationSearchMergedDividerAdapter.registerDataSetObserver(new DataSetObserver()
    {
      public void onChanged()
      {
        super.onChanged();
        LocationSearchFragment.this.updateListVisibility();
        LocationSearchFragment.this.refreshFooterView();
      }
    });
    this.mTextViewEmpty.setText(getString(2131558942));
    this.mListViewLocation.addFooterView(this.mFooterView, null, false);
    this.mListViewLocation.setAdapter(this.mLocationSearchMergedDividerAdapter);
    String str = this.mAction;
    int i = -1;
    label264: UberTextView localUberTextView;
    switch (str.hashCode())
    {
    default:
      switch (i)
      {
      default:
        initPrefilledText();
        initSearchBarIcon();
        initFooterView();
        localUberTextView = this.mTextViewSkip;
        if (!this.mAllowSkip);
        break;
      case 0:
      case 1:
      case 2:
      }
      break;
    case -669628160:
    case 1712228054:
    case 458188937:
    }
    for (int j = 0; ; j = 8)
    {
      localUberTextView.setVisibility(j);
      this.mEditTextSearch.setOnEditorActionListener(new TextView.OnEditorActionListener()
      {
        public boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          if ((paramAnonymousKeyEvent != null) && (paramAnonymousKeyEvent.getKeyCode() == 66) && (paramAnonymousKeyEvent.getAction() == 0));
          for (int i = 1; ; i = 0)
          {
            boolean bool;
            if (paramAnonymousInt != 3)
            {
              bool = false;
              if (i == 0);
            }
            else
            {
              KeyboardUtils.hideKeyboard(LocationSearchFragment.this.mEditTextSearch.getContext(), paramAnonymousTextView);
              LocationSearchFragment.this.sendLocationPredictionsRequest(LocationSearchFragment.access$500(LocationSearchFragment.this), true);
              LocationSearchFragment.this.mAnalyticsClient.sendTapEvent(RiderEvents.Tap.SEARCH_MANUAL_SEARCH_KEYBOARD);
              bool = true;
            }
            return bool;
          }
        }
      });
      this.mTextWatcherSearch = new TextWatcherAdapter()
      {
        public void afterTextChanged(Editable paramAnonymousEditable)
        {
          LocationSearchFragment.this.mTextInputHandler.removeCallbacks(LocationSearchFragment.this.mTextInputCallback);
          LocationSearchFragment.this.mTextInputHandler.postDelayed(LocationSearchFragment.this.mTextInputCallback, 250L);
          ImageButton localImageButton = LocationSearchFragment.this.mImageButtonClear;
          if (!TextUtils.isEmpty(LocationSearchFragment.this.getSearchText().trim()));
          for (int i = 0; ; i = 8)
          {
            localImageButton.setVisibility(i);
            return;
          }
        }

        public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && (paramAnonymousCharSequence.equals(LocationSearchFragment.this.mInitialLocationText)) && (!LocationSearchFragment.this.mPrefilledTextApplied))
            return;
          LocationSearchFragment.this.mEditTextSearch.setTag(null);
        }
      };
      this.mEditTextSearch.addTextChangedListener(this.mTextWatcherSearch);
      if (isFavoriteLocationAction())
        KeyboardUtils.showKeyboard(this.mContext, this.mEditTextSearch);
      return;
      if (!str.equals("com.ubercab.ACTION_PICKUP_LOCATION"))
        break;
      i = 0;
      break;
      if (!str.equals("com.ubercab.ACTION_DESTINATION"))
        break;
      i = 1;
      break;
      if (!str.equals("com.ubercab.ACTION_DESTINATION_ETA"))
        break;
      i = 2;
      break;
      this.mEditTextSearch.setHint(getString(2131559003));
      this.mAnalyticsManager.tripEvent().locationOpenPickup();
      break label264;
      this.mEditTextSearch.setHint(getString(2131558805));
      this.mAnalyticsManager.tripEvent().locationOpenDropoff();
      break label264;
      this.mEditTextSearch.setHint(getString(2131558805));
      this.mAnalyticsManager.tripEvent().locationOpenDropoff();
      this.mAllowSkip = true;
      break label264;
    }
  }

  void resetDistanceConstraintsToNull()
  {
    this.mFavoriteLocationDistanceConstraints = null;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.search.LocationSearchFragment
 * JD-Core Version:    0.6.2
 */