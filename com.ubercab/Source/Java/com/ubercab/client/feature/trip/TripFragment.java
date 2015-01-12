package com.ubercab.client.feature.trip;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.FragmentManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;
import com.ubercab.client.core.analytics.AnalyticsManager;
import com.ubercab.client.core.analytics.event.ContactDriverEvent;
import com.ubercab.client.core.analytics.event.LocationEvent;
import com.ubercab.client.core.analytics.event.NearestCabEvent;
import com.ubercab.client.core.analytics.event.RequestVehicleEvent;
import com.ubercab.client.core.analytics.event.TripEvent;
import com.ubercab.client.core.app.RiderDialogFragment;
import com.ubercab.client.core.app.RiderFragment;
import com.ubercab.client.core.content.PingProvider;
import com.ubercab.client.core.content.RiderLocationProvider;
import com.ubercab.client.core.content.SessionPreferences;
import com.ubercab.client.core.content.event.PinLocationEvent;
import com.ubercab.client.core.content.event.PingEvent;
import com.ubercab.client.core.location.RiderLocation;
import com.ubercab.client.core.metrics.analytics.RiderEvents.Impression;
import com.ubercab.client.core.metrics.analytics.RiderEvents.Tap;
import com.ubercab.client.core.model.AppConfig;
import com.ubercab.client.core.model.Balance;
import com.ubercab.client.core.model.Capabilities;
import com.ubercab.client.core.model.City;
import com.ubercab.client.core.model.Client;
import com.ubercab.client.core.model.CnLocation;
import com.ubercab.client.core.model.FareEstimateRange;
import com.ubercab.client.core.model.FareSplit;
import com.ubercab.client.core.model.FareSplitClient;
import com.ubercab.client.core.model.LegacyMobileMessage;
import com.ubercab.client.core.model.LocationHistoryResponse;
import com.ubercab.client.core.model.LocationSearchResult;
import com.ubercab.client.core.model.LocationSearchResults;
import com.ubercab.client.core.model.MobileMessage;
import com.ubercab.client.core.model.MobileMessageDisplayProperties;
import com.ubercab.client.core.model.PaymentProfile;
import com.ubercab.client.core.model.Ping;
import com.ubercab.client.core.model.ReverseGeocode;
import com.ubercab.client.core.model.RewardInfo;
import com.ubercab.client.core.model.RiderAppConfig;
import com.ubercab.client.core.model.Surge;
import com.ubercab.client.core.model.Trip;
import com.ubercab.client.core.model.TripDriver;
import com.ubercab.client.core.model.TripExpenseInfo;
import com.ubercab.client.core.model.VehicleView;
import com.ubercab.client.core.network.LocationClient;
import com.ubercab.client.core.network.RiderClient;
import com.ubercab.client.core.network.events.LocationHistoryResponseEvent;
import com.ubercab.client.core.network.events.PickupCancelClientResponseEvent;
import com.ubercab.client.core.network.events.SetDestinationResponseEvent;
import com.ubercab.client.core.ui.MenuAdapter;
import com.ubercab.client.core.ui.MenuAdapter.Item;
import com.ubercab.client.core.util.AndroidUtils;
import com.ubercab.client.core.util.PingUtils;
import com.ubercab.client.core.vendor.google.GmmProductSurge;
import com.ubercab.client.core.vendor.google.GmmUtils;
import com.ubercab.client.core.vendor.google.GoogleWalletActivity;
import com.ubercab.client.core.vendor.paypal.PayPalUtils;
import com.ubercab.client.feature.estimate.FareEstimateActivity;
import com.ubercab.client.feature.estimate.RewardPointsFareEstimateFragment;
import com.ubercab.client.feature.faresplit.minion.event.FareSplitInvitationEvent;
import com.ubercab.client.feature.mobilemessage.MobileMessageManager;
import com.ubercab.client.feature.mobilemessage.MobileMessagePopupWindow;
import com.ubercab.client.feature.mobilemessage.event.LegacyMobileMessageEvent;
import com.ubercab.client.feature.mobilemessage.event.MobileMessageConfirmActionEvent;
import com.ubercab.client.feature.mobilemessage.event.MobileMessageForLookingEvent;
import com.ubercab.client.feature.music.overlay.AddMusicOverlayView;
import com.ubercab.client.feature.payment.AddFundsActivity;
import com.ubercab.client.feature.promo.PromoFragment;
import com.ubercab.client.feature.promo.event.PromoCodeAcceptedConfirmedEvent;
import com.ubercab.client.feature.search.LocationSearchActivity;
import com.ubercab.client.feature.surge.SurgeActivity;
import com.ubercab.client.feature.trip.confirm.ConfirmationView;
import com.ubercab.client.feature.trip.event.AddBusinessCardExpenseInfoEvent;
import com.ubercab.client.feature.trip.event.AddDestinationEvent;
import com.ubercab.client.feature.trip.event.ChangeTripPaymentEvent;
import com.ubercab.client.feature.trip.event.ConfirmClearDestinationEvent;
import com.ubercab.client.feature.trip.event.CreateGoogleWalletPaymentProfileEvent;
import com.ubercab.client.feature.trip.event.DestinationChangedEvent;
import com.ubercab.client.feature.trip.event.DismissFareDetailEvent;
import com.ubercab.client.feature.trip.event.FareEstimateEvent;
import com.ubercab.client.feature.trip.event.FooterSizeChangedEvent;
import com.ubercab.client.feature.trip.event.GetFareEstimateEvent;
import com.ubercab.client.feature.trip.event.HoldToCancelTripEvent;
import com.ubercab.client.feature.trip.event.SelectPaymentEvent;
import com.ubercab.client.feature.trip.event.ShareEtaEvent;
import com.ubercab.client.feature.trip.event.ShowFareDetailEvent;
import com.ubercab.client.feature.trip.event.ShowFareQuoteEvent;
import com.ubercab.client.feature.trip.event.SplitFareEvent;
import com.ubercab.client.feature.trip.event.TripFragmentReadyEvent;
import com.ubercab.client.feature.trip.event.TripUIStateChangedEvent;
import com.ubercab.client.feature.trip.map.MapFragment;
import com.ubercab.client.feature.trip.map.MapTouchEventListener;
import com.ubercab.client.feature.trip.map.PinView;
import com.ubercab.client.feature.trip.overlay.DestinationTutorialOverlayView;
import com.ubercab.client.feature.trip.overlay.DestinationTutorialOverlayView.Listener;
import com.ubercab.client.feature.trip.overlay.DispatchDestinationOverlayView;
import com.ubercab.client.feature.trip.overlay.DispatchDestinationOverlayView.Listener;
import com.ubercab.client.feature.trip.overlay.LegacyMobileMessageOverlayView;
import com.ubercab.client.feature.trip.overlay.NoLocationOverlayView;
import com.ubercab.client.feature.trip.rates.BaseRateCardPopupWindow;
import com.ubercab.client.feature.trip.rates.BaseRateCardPopupWindow.Listener;
import com.ubercab.client.feature.trip.slider.VehicleTextBitmap;
import com.ubercab.common.base.Objects;
import com.ubercab.library.app.annotation.ForActivity;
import com.ubercab.library.location.model.UberLatLng;
import com.ubercab.library.map.UberCameraPosition;
import com.ubercab.library.map.UberMap.OnCameraChangeListener;
import com.ubercab.library.metrics.analytics.AnalyticsClient;
import com.ubercab.library.metrics.analytics.AnalyticsEvent.Builder;
import com.ubercab.library.metrics.analytics.event.ImpressionEventName;
import com.ubercab.library.util.LocationUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import timber.log.Timber;

public class TripFragment extends RiderFragment
  implements HeaderView.Listener, FooterView.Listener, DestinationTutorialOverlayView.Listener, UberMap.OnCameraChangeListener, MapTouchEventListener, DispatchDestinationOverlayView.Listener, BaseRateCardPopupWindow.Listener
{
  private static final String BUNDLE_CONFIRMATION_SURGE_FARE_ID = "com.ubercab.COMFIRMATION_SURGE_FARE_ID";
  private static final String BUNDLE_GMM_IS_INTENT_CONSUMED = "com.ubercab.BUNDLE_GMM_IS_INTENT_CONSUMED";
  private static final String BUNDLE_GMM_PRODUCT_SURGE_DISPLAYED = "com.ubercab.BUNDLE_GMM_SURGE_DISPLAYED";
  private static final String BUNDLE_IS_USING_CREDITS = "com.ubercab.IS_USING_CREDITS";
  private static final String BUNDLE_IS_USING_POINTS = "com.ubercab.IS_USING_POINTS";
  private static final String BUNDLE_LOCATION_PREVIOUS_PICKUP = "com.ubercab.LOCATION_PREVIOUS_PICKUP";
  private static final String BUNDLE_PAYMENT_EXPENSE_INFO = "com.ubercab.PAYMENT_EXPENSE_INFO";
  private static final String BUNDLE_PIN_LOCATION_INITIALIZED = "com.ubercab.PIN_LOCATION_INITIALIZED";
  private static final String BUNDLE_RATE_CARD_VISIBLE = "com.ubercab.RATE_CARD_VISIBLE";
  private static final String BUNDLE_SELECTED_PAYMENT_PROFILE = "com.ubercab.SELECTED_PAYMENT_PROFILE";
  private static final int RATE_CARD_DISPLAY_DELAY = 250;
  private static final int REQUEST_CODE_FARE_ESTIMATE = 5001;
  private static final int REQUEST_CODE_LOCATION_SEARCH_DESTINATION = 2008;
  private static final int REQUEST_CODE_LOCATION_SEARCH_DESTINATION_REQUIRED = 2009;
  private static final int REQUEST_CODE_LOCATION_SEARCH_PICKUP = 2007;
  private static final int REQUEST_CODE_LOCATION_SEARCH_RATE_CARD_DESTINATION = 3008;
  private static final int REQUEST_CODE_LOCATION_SEARCH_RATE_CARD_PICKUP = 3007;
  private static final int REQUEST_CODE_SURGE = 3001;

  @Inject
  AnalyticsClient mAnalyticsClient;

  @Inject
  AnalyticsManager mAnalyticsManager;
  private int mAnimTimeLong;

  @Inject
  Bus mBus;
  private long mConfirmationSurgeFareId;

  @ForActivity
  @Inject
  Context mContext;
  private PopupWindow.OnDismissListener mDismissListenerFareDetail;
  private TripExpenseInfo mExpenseInfo;
  private String mFareEstimatePointsRange;
  private MapFragment mFragmentMap;
  private GmmProductSurge mGmmProductSurgeDisplayed;
  private boolean mGotFirstPing;
  private boolean mIsDraggingMap;
  private boolean mIsExpenseScreenShown;
  private boolean mIsGmmIntentConsumed;
  private boolean mIsMapMovedByUser;
  private boolean mIsPinLocationInitialized;
  private boolean mIsRateCardShown;
  private boolean mIsUsingCredits = true;
  private boolean mIsUsingPoints;

  @Inject
  LegacyFareEstimateManager mLegacyFareEstimateManager;

  @Inject
  LocationClient mLocationClient;
  private RiderLocation mLocationPreviousPickup;

  @Inject
  RiderLocationProvider mLocationProvider;

  @Inject
  MobileMessageManager mMobileMessageManager;
  private MobileMessagePopupWindow mMobileMessagePopupWindow;

  @Inject
  MultiFareEstimateManager mMultiFareEstimateManager;

  @Inject
  PingProvider mPingProvider;
  private Handler mRateCardDisplayHandler;
  private Runnable mRateCardDisplayRunnable;
  private BaseRateCardPopupWindow mRateCardPopupWindow;

  @Inject
  RiderClient mRiderClient;
  private PaymentProfile mSelectedPaymentProfile;

  @Inject
  SessionPreferences mSessionPreferences;

  @Inject
  TripUIStateManager mTripUIStateManager;

  @InjectView(2131427784)
  AddMusicOverlayView mViewAddMusicOverlay;

  @InjectView(2131427786)
  DestinationTutorialOverlayView mViewDestinationTutorialOverlay;

  @InjectView(2131427772)
  DispatchDestinationOverlayView mViewDispatchDestinationOverlay;

  @InjectView(2131427779)
  FooterView mViewFooter;

  @InjectView(2131427777)
  HeaderView mViewHeader;

  @InjectView(2131427787)
  LegacyMobileMessageOverlayView mViewLegacyMobileMessageOverlay;

  @InjectView(2131427775)
  NoLocationOverlayView mViewNoLocationOverlay;

  @InjectView(2131427776)
  PinView mViewPin;

  private void checkForAndConsumeGmmIntent(Intent paramIntent)
  {
    Ping localPing = this.mPingProvider.get();
    if (!PingUtils.isClientStatusLooking(localPing));
    int i;
    Uri localUri;
    boolean bool1;
    do
    {
      do
      {
        return;
        if ((0x100000 & paramIntent.getFlags()) == 0)
          break;
        i = 1;
        localUri = paramIntent.getData();
      }
      while ((localUri == null) || (i != 0) || (this.mIsGmmIntentConsumed));
      bool1 = "setPickup".equals(localUri.getQueryParameter("action"));
    }
    while ((!"uber".equals(paramIntent.getScheme())) || (!bool1));
    RiderLocation localRiderLocation1 = this.mLocationProvider.getDeviceLocation();
    RiderLocation localRiderLocation2 = GmmUtils.createPickupLocation(localUri, localRiderLocation1);
    if (localRiderLocation2 != null)
      this.mLocationProvider.updatePinLocation(localRiderLocation2);
    RiderLocation localRiderLocation3 = GmmUtils.createDropoffLocation(localUri, localRiderLocation1);
    if (localRiderLocation3 != null)
    {
      if (!localRiderLocation3.equals(localRiderLocation1))
        break label324;
      localRiderLocation3.setTitle(getString(2131558934));
    }
    while (true)
    {
      this.mTripUIStateManager.setPreTripDestination(localRiderLocation3);
      String str1 = GmmUtils.parseProductId(localUri);
      String str2 = null;
      if (str1 != null)
      {
        boolean bool2 = PingUtils.hasVehicleViews(localPing);
        str2 = null;
        if (bool2)
        {
          Iterator localIterator = localPing.getCity().getVehicleViews().values().iterator();
          VehicleView localVehicleView;
          do
          {
            boolean bool3 = localIterator.hasNext();
            str2 = null;
            if (!bool3)
              break;
            localVehicleView = (VehicleView)localIterator.next();
          }
          while (!str1.equals(localVehicleView.getUuid()));
          str2 = localVehicleView.getId();
        }
      }
      Float localFloat = GmmUtils.parseSurge(localUri);
      GmmProductSurge localGmmProductSurge = new GmmProductSurge(str1, localFloat);
      this.mGmmProductSurgeDisplayed = localGmmProductSurge;
      if (str2 != null)
      {
        this.mTripUIStateManager.setSelectedVehicleViewId(str2);
        if (localRiderLocation2 != null)
          showConfirmingState();
      }
      this.mIsGmmIntentConsumed = true;
      this.mAnalyticsManager.nearestCabEvent().locationChangeRequest();
      return;
      i = 0;
      break;
      label324: if (!localRiderLocation3.hasReverseGeocodeData())
        localRiderLocation3.setTitle(getString(2131558803));
    }
  }

  private String getActionBarTitleForLocationSearch(int paramInt)
  {
    if (isRequestCodeFromRateCard(paramInt))
      return getString(2131558852);
    return null;
  }

  private boolean isExpenseTrip()
  {
    return (this.mExpenseInfo != null) && (this.mExpenseInfo.isExpenseTrip());
  }

  private static boolean isRequestCodeFromRateCard(int paramInt)
  {
    return (paramInt == 3007) || (paramInt == 3008);
  }

  public static TripFragment newInstance()
  {
    return new TripFragment();
  }

  private boolean shouldTrackMapChanges()
  {
    Ping localPing = this.mPingProvider.get();
    if (localPing == null);
    while (this.mTripUIStateManager.showNewConfirmation())
      return false;
    return PingUtils.isClientStatusLooking(localPing);
  }

  private void showConfirmingState()
  {
    Ping localPing = this.mPingProvider.get();
    String str = this.mTripUIStateManager.getSelectedVehicleViewId();
    if (!PingUtils.hasVehicleView(localPing, str))
      return;
    VehicleView localVehicleView = this.mPingProvider.get().getCity().findVehicleView(str);
    if (!localVehicleView.isDestinationEnabled())
      this.mTripUIStateManager.clearDestination();
    Surge localSurge = localVehicleView.getSurge();
    this.mAnalyticsManager.tripEvent().setPickup(localVehicleView.getId(), localSurge.getFareId(), localSurge.getMultiplier());
    if (localSurge.getMultiplier() > 1.0F)
    {
      boolean bool = "sobriety".equals(localSurge.getScreenType());
      startActivityForResult(SurgeActivity.newIntent(this.mContext, str, bool, this.mGmmProductSurgeDisplayed), 3001);
      return;
    }
    this.mConfirmationSurgeFareId = 0L;
    this.mTripUIStateManager.setIsConfirming(true);
  }

  private boolean showMobileMessage(MobileMessage paramMobileMessage)
  {
    if (this.mViewLegacyMobileMessageOverlay.isShown());
    while ((this.mMobileMessagePopupWindow != null) && ((this.mMobileMessagePopupWindow.isShowing()) || (this.mMobileMessagePopupWindow.isShowingInProgress())))
      return false;
    this.mMobileMessagePopupWindow = new MobileMessagePopupWindow(getActivity());
    return this.mMobileMessagePopupWindow.showMobileMessage(paramMobileMessage);
  }

  private void showRateCard(String paramString, int paramInt)
  {
    Activity localActivity = getActivity();
    if (!AndroidUtils.isWindowValid(localActivity.getWindow()))
      return;
    RiderLocation localRiderLocation1 = this.mTripUIStateManager.getDestination();
    RiderLocation localRiderLocation2 = this.mLocationProvider.getPinLocation();
    if ((this.mRateCardPopupWindow != null) && (this.mRateCardPopupWindow.isShowing()))
    {
      this.mRateCardPopupWindow.setDestinationLocation(localRiderLocation1);
      this.mRateCardPopupWindow.setPickupLocation(localRiderLocation2);
      return;
    }
    String str = "none";
    Ping localPing = this.mPingProvider.get();
    if (PingUtils.hasRiderAppConfig(localPing))
      str = localPing.getAppConfig().getRiderConfig().getFareEstimateFlowVariant();
    this.mRateCardPopupWindow = BaseRateCardPopupWindow.getInstance(localActivity, paramString, localRiderLocation2, localRiderLocation1, paramInt, str);
    this.mRateCardPopupWindow.showAtLocation(localActivity.getWindow().getDecorView(), 48, 0, 0);
    this.mRateCardPopupWindow.addListener(this);
    this.mRateCardPopupWindow.setOnDismissListener(this.mDismissListenerFareDetail);
    this.mTripUIStateManager.setShowingFareDetails(true);
    this.mIsRateCardShown = true;
  }

  private void showRateCardAfterDelay()
  {
    this.mRateCardDisplayHandler.postDelayed(this.mRateCardDisplayRunnable, 250L);
  }

  private void startLocationSearchActivityForDestination(int paramInt)
  {
    Ping localPing = this.mPingProvider.get();
    RiderLocation localRiderLocation1 = this.mTripUIStateManager.getDestination();
    String str = this.mTripUIStateManager.getSelectedVehicleViewId();
    if (PingUtils.hasTrip(localPing));
    for (RiderLocation localRiderLocation2 = RiderLocation.create(localPing.getTrip().getPickupLocation()); ; localRiderLocation2 = this.mLocationProvider.getPinLocation())
    {
      startActivityForResult(LocationSearchActivity.newIntent(getActivity(), "com.ubercab.ACTION_DESTINATION", localRiderLocation2, localRiderLocation1, str, getActionBarTitleForLocationSearch(paramInt), isRequestCodeFromRateCard(paramInt)), paramInt);
      return;
    }
  }

  private void startLocationSearchActivityForPickup(int paramInt)
  {
    RiderLocation localRiderLocation1 = this.mLocationProvider.getPinLocation();
    RiderLocation localRiderLocation2 = this.mTripUIStateManager.getDestination();
    String str = this.mTripUIStateManager.getSelectedVehicleViewId();
    Intent localIntent = LocationSearchActivity.newIntent(getActivity(), "com.ubercab.ACTION_PICKUP_LOCATION", localRiderLocation1, localRiderLocation2, str, getActionBarTitleForLocationSearch(paramInt), isRequestCodeFromRateCard(paramInt));
    if ((PingUtils.isClientStatusLooking(this.mPingProvider.get())) && (localRiderLocation1 == null))
      this.mAnalyticsManager.locationEvent().pickupSearchWithoutLocationServices();
    startActivityForResult(localIntent, paramInt);
  }

  private void syncPinToCamera()
  {
    if ((this.mIsDraggingMap) || (!this.mIsMapMovedByUser));
    UberLatLng localUberLatLng;
    RiderLocation localRiderLocation1;
    Ping localPing;
    do
    {
      return;
      localUberLatLng = this.mFragmentMap.getCameraLatLng();
      localRiderLocation1 = this.mLocationProvider.getPinLocation();
      localPing = this.mPingProvider.get();
    }
    while ((localRiderLocation1 == null) || (!PingUtils.isClientStatusLooking(localPing)));
    if (!LocationUtils.equalWithinDistance(localRiderLocation1.getUberLatLng(), localUberLatLng))
    {
      RiderLocation localRiderLocation3 = RiderLocation.create(localUberLatLng);
      this.mLocationProvider.updatePinLocation(localRiderLocation3);
      return;
    }
    int i = this.mTripUIStateManager.getState();
    RiderLocation localRiderLocation2 = this.mTripUIStateManager.getDestination();
    String str = this.mTripUIStateManager.getSelectedVehicleViewId();
    this.mViewHeader.updateUI(i, localPing, localRiderLocation1, localRiderLocation2, str);
  }

  private void updateDestinationOverlayUI()
  {
    int i = this.mTripUIStateManager.getState();
    this.mViewDestinationTutorialOverlay.updateUI(i);
    DispatchDestinationOverlayView localDispatchDestinationOverlayView = this.mViewDispatchDestinationOverlay;
    if (this.mTripUIStateManager.getDestination() != null);
    for (boolean bool = true; ; bool = false)
    {
      localDispatchDestinationOverlayView.updateUI(i, bool);
      return;
    }
  }

  private void updateMapPadding()
  {
    View localView = getView();
    if (localView == null)
      return;
    if (localView.getHeight() == 0)
    {
      localView.postDelayed(new Runnable()
      {
        public void run()
        {
          TripFragment.this.updateMapPadding();
        }
      }
      , 100L);
      return;
    }
    int i = this.mViewHeader.getHeightForPadding();
    int j = this.mViewFooter.getHeightForPadding();
    this.mViewPin.setPadding(i, j);
    this.mFragmentMap.setPadding(0, i, 0, j);
    this.mFragmentMap.setMyLocationTranslationY(-this.mViewFooter.getHeightForMyLocation());
  }

  private void updateMusicOverlayUI(int paramInt)
  {
    int i = 8;
    Ping localPing = this.mPingProvider.get();
    if ((PingUtils.hasTripDriver(localPing)) && (localPing.getTrip().getDriver().getCapabilities() != null) && (localPing.getTrip().getDriver().getCapabilities().isMusicEnabled()) && (paramInt == 3) && (!this.mSessionPreferences.isAddMusicDismissed()))
    {
      boolean bool1 = PingUtils.hasClient(localPing);
      boolean bool2 = false;
      if (bool1)
        bool2 = localPing.getClient().isAdmin();
      boolean bool3 = PingUtils.hasAppConfig(localPing);
      boolean bool4 = false;
      if (bool3)
        bool4 = localPing.getAppConfig().getMusicTrayEnabled();
      if ((bool2) || (bool4))
        i = 0;
    }
    this.mViewAddMusicOverlay.setVisibility(i);
  }

  private void updateUI()
  {
    Ping localPing = this.mPingProvider.get();
    if (!PingUtils.hasClient(localPing))
      return;
    getActivity().invalidateOptionsMenu();
    String str = this.mTripUIStateManager.getSelectedVehicleViewId();
    RiderLocation localRiderLocation1 = this.mLocationProvider.getPinLocation();
    if (PingUtils.hasTripPickup(localPing))
      localRiderLocation1 = RiderLocation.create(localPing.getTrip().getPickupLocation());
    int i = this.mTripUIStateManager.getState();
    boolean bool1;
    label105: boolean bool2;
    boolean bool6;
    label184: PinView localPinView;
    if (localRiderLocation1 != null)
    {
      bool1 = true;
      if ((i != 0) || (bool1))
        break label247;
      this.mViewNoLocationOverlay.setVisibility(0);
      this.mViewHeader.setPickupHintText(getString(2131559044));
      RiderLocation localRiderLocation2 = this.mTripUIStateManager.getDestination();
      bool2 = this.mTripUIStateManager.showNewConfirmation();
      this.mViewHeader.updateUI(i, localPing, localRiderLocation1, localRiderLocation2, str);
      this.mViewDestinationTutorialOverlay.updateUI(i);
      FooterView localFooterView = this.mViewFooter;
      PaymentProfile localPaymentProfile = this.mSelectedPaymentProfile;
      boolean bool3 = this.mIsUsingPoints;
      boolean bool4 = this.mIsUsingCredits;
      boolean bool5 = isExpenseTrip();
      if (localRiderLocation2 == null)
        break label273;
      bool6 = true;
      localFooterView.updateUI(i, localPing, str, localPaymentProfile, bool3, bool4, bool5, bool1, bool6, bool2);
      localPinView = this.mViewPin;
      if (localRiderLocation2 == null)
        break label279;
    }
    label273: label279: for (boolean bool7 = true; ; bool7 = false)
    {
      localPinView.updateUI(i, localPing, str, bool1, bool7, bool2);
      updateMapPadding();
      return;
      bool1 = false;
      break;
      label247: this.mViewHeader.setPickupHintText(getString(2131558883));
      this.mViewNoLocationOverlay.setVisibility(8);
      break label105;
      bool6 = false;
      break label184;
    }
  }

  void clearDestination()
  {
    this.mTripUIStateManager.clearDestination();
    this.mAnalyticsManager.tripEvent().locationRemoveDropoff();
  }

  PaymentProfile getSelectedPaymentProfile()
  {
    return this.mSelectedPaymentProfile;
  }

  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 != -1)
    {
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = Integer.valueOf(paramInt2);
      arrayOfObject[1] = Integer.valueOf(paramInt1);
      Timber.w("Bad activity result [%d] for request [%d]", arrayOfObject);
    }
    do
    {
      return;
      if (paramInt1 == 2007)
      {
        RiderLocation localRiderLocation3 = (RiderLocation)paramIntent.getParcelableExtra("com.ubercab.LOCATION");
        this.mLocationProvider.updatePinLocation(localRiderLocation3);
        return;
      }
      if (paramInt1 == 2008)
      {
        sendSetDestinationRequest((RiderLocation)paramIntent.getParcelableExtra("com.ubercab.LOCATION"));
        return;
      }
      if (paramInt1 == 2009)
      {
        sendSetDestinationRequest((RiderLocation)paramIntent.getParcelableExtra("com.ubercab.LOCATION"));
        showConfirmingState();
        return;
      }
      if (paramInt1 == 5001)
      {
        RiderLocation localRiderLocation2 = (RiderLocation)paramIntent.getParcelableExtra("com.ubercab.LOCATION_DESTINATION");
        this.mTripUIStateManager.setPreTripDestination(localRiderLocation2);
        return;
      }
      if (paramInt1 == 3001)
      {
        this.mConfirmationSurgeFareId = paramIntent.getLongExtra("com.ubercab.FARE_ID", 0L);
        this.mTripUIStateManager.setIsConfirming(true);
        return;
      }
      if (paramInt1 == 3007)
      {
        RiderLocation localRiderLocation1 = (RiderLocation)paramIntent.getParcelableExtra("com.ubercab.LOCATION");
        this.mLocationProvider.updatePinLocation(localRiderLocation1);
        showRateCardAfterDelay();
        return;
      }
    }
    while (paramInt1 != 3008);
    sendSetDestinationRequest((RiderLocation)paramIntent.getParcelableExtra("com.ubercab.LOCATION"));
    showRateCardAfterDelay();
  }

  @Subscribe
  public void onAddDestinationEvent(AddDestinationEvent paramAddDestinationEvent)
  {
    startLocationSearchActivityForDestination(2008);
  }

  boolean onBackPressed()
  {
    if ((this.mMobileMessagePopupWindow != null) && (this.mMobileMessagePopupWindow.isShowing()))
    {
      this.mMobileMessagePopupWindow.closePopup();
      return true;
    }
    if (this.mTripUIStateManager.getState() == 1)
    {
      this.mTripUIStateManager.setIsConfirming(false);
      Ping localPing = this.mPingProvider.get();
      this.mAnalyticsManager.tripEvent().confirmPickupCancel(localPing, this.mTripUIStateManager.getSelectedVehicleViewId(), this.mConfirmationSurgeFareId);
      return true;
    }
    if (this.mViewLegacyMobileMessageOverlay.isShown())
    {
      this.mViewLegacyMobileMessageOverlay.setVisibility(8);
      return true;
    }
    if ((this.mRateCardPopupWindow != null) && (this.mRateCardPopupWindow.isShowing()))
    {
      this.mRateCardPopupWindow.dismiss();
      return true;
    }
    return false;
  }

  public void onCameraChange(UberCameraPosition paramUberCameraPosition)
  {
    Ping localPing = this.mPingProvider.get();
    if (!shouldTrackMapChanges())
      return;
    UberLatLng localUberLatLng = this.mFragmentMap.getCameraLatLng();
    if (localUberLatLng == null);
    Object[] arrayOfObject;
    for (String str1 = null; ; str1 = String.format("%f:%f", arrayOfObject))
    {
      this.mAnalyticsClient.addEvent(new AnalyticsEvent.Builder("impression").setName(RiderEvents.Impression.MAP_VIEW).setValuePosition(Long.valueOf(()paramUberCameraPosition.getZoom())).setValue(str1).build());
      if (!this.mIsDraggingMap)
        break label193;
      RiderLocation localRiderLocation1 = this.mLocationProvider.getPinLocation();
      if ((localRiderLocation1 != null) && (LocationUtils.equalWithinDistance(localRiderLocation1.getUberLatLng(), paramUberCameraPosition.getTarget())))
        break;
      int i = this.mTripUIStateManager.getState();
      RiderLocation localRiderLocation2 = this.mTripUIStateManager.getDestination();
      String str2 = this.mTripUIStateManager.getSelectedVehicleViewId();
      this.mViewHeader.updateUI(i, localPing, null, localRiderLocation2, str2);
      return;
      arrayOfObject = new Object[2];
      arrayOfObject[0] = Double.valueOf(localUberLatLng.getLatitude());
      arrayOfObject[1] = Double.valueOf(localUberLatLng.getLongitude());
    }
    label193: syncPinToCamera();
  }

  public void onCancelPressed(boolean paramBoolean)
  {
    this.mAnalyticsClient.sendTapEvent(RiderEvents.Tap.CONFIRMATION_CANCEL);
    this.mBus.post(new HoldToCancelTripEvent(paramBoolean));
  }

  public void onClickAddDestinationAddress()
  {
    RiderLocation localRiderLocation1 = this.mLocationProvider.getPinLocation();
    RiderLocation localRiderLocation2 = this.mTripUIStateManager.getDestination();
    startActivityForResult(LocationSearchActivity.newIntent(getActivity(), "com.ubercab.ACTION_DESTINATION", localRiderLocation1, localRiderLocation2), 2008);
  }

  public void onClickDestinationAddress()
  {
    this.mAnalyticsClient.sendTapEvent(RiderEvents.Tap.SEARCH_DROPOFF_OPEN_MAP);
    startLocationSearchActivityForDestination(2008);
  }

  public void onClickDestinationAddressClear()
  {
    if (!PingUtils.hasTrip(this.mPingProvider.get()))
    {
      this.mAnalyticsClient.sendTapEvent(RiderEvents.Tap.DESTINATION_REMOVE);
      clearDestination();
      return;
    }
    if (this.mTripUIStateManager.getState() == 5)
    {
      this.mBus.post(new ConfirmClearDestinationEvent());
      return;
    }
    clearDestination();
    sendSetDestinationRequest(null);
  }

  public void onClickDispatchDestinationAddress()
  {
    startLocationSearchActivityForDestination(2008);
  }

  public void onClickPickupAddress()
  {
    this.mAnalyticsClient.sendTapEvent(RiderEvents.Tap.SEARCH_PICKUP_OPEN_MAP);
    startLocationSearchActivityForPickup(2007);
  }

  @OnClick({2131427895})
  public void onClickPin()
  {
    this.mAnalyticsClient.sendTapEvent(RiderEvents.Tap.SET_PICKUP_LOCATION_PIN);
    String str = this.mTripUIStateManager.getSelectedVehicleViewId();
    MobileMessage localMobileMessage = this.mMobileMessageManager.findMessageForVehicleViewAfterRequesting(str);
    if ((localMobileMessage != null) && (this.mMobileMessageManager.isPreloaded(localMobileMessage.getId())) && (showMobileMessage(localMobileMessage)))
      return;
    showConfirmingState();
  }

  public void onClickRateCardDestinationAddress()
  {
    this.mTripUIStateManager.setRateCardFareEstimateRequested(true);
    startLocationSearchActivityForDestination(3008);
  }

  public void onClickRateCardPickupAddress()
  {
    startLocationSearchActivityForPickup(3007);
  }

  public void onContactDriverClicked()
  {
    Activity localActivity = getActivity();
    MenuAdapter.Item[] arrayOfItem = new MenuAdapter.Item[2];
    arrayOfItem[0] = new MenuAdapter.Item(0, 2130837775, getString(2131558466));
    arrayOfItem[1] = new MenuAdapter.Item(1, 2130837795, getString(2131558926));
    MenuAdapter localMenuAdapter = new MenuAdapter(localActivity, arrayOfItem);
    DialogInterface.OnClickListener local5 = new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        Ping localPing = TripFragment.this.mPingProvider.get();
        if (!PingUtils.hasTrip(localPing))
          return;
        String str = localPing.getTrip().getDriver().getMobile();
        switch (paramAnonymousInt)
        {
        default:
          return;
        case 0:
          TripFragment.this.startActivity(new Intent("android.intent.action.CALL", Uri.parse("tel:" + str)));
          TripFragment.this.mAnalyticsManager.contactDriverEvent().voice();
          TripFragment.this.mAnalyticsClient.sendTapEvent(RiderEvents.Tap.CONTACT_DRIVER_VOICE);
          return;
        case 1:
        }
        TripFragment.this.startActivity(new Intent("android.intent.action.SENDTO", Uri.parse("sms:" + str)));
        TripFragment.this.mAnalyticsManager.contactDriverEvent().sms();
        TripFragment.this.mAnalyticsClient.sendTapEvent(RiderEvents.Tap.CONTACT_DRIVER_TEXT);
      }
    };
    new AlertDialog.Builder(getActivity()).setAdapter(localMenuAdapter, local5).show();
    this.mAnalyticsManager.contactDriverEvent().open();
    this.mAnalyticsClient.sendTapEvent(RiderEvents.Tap.CONTACT_DRIVER_OPEN);
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mAnimTimeLong = getResources().getInteger(17694722);
    if (paramBundle != null)
    {
      this.mIsUsingCredits = paramBundle.getBoolean("com.ubercab.IS_USING_CREDITS", true);
      this.mIsUsingPoints = paramBundle.getBoolean("com.ubercab.IS_USING_POINTS", false);
      this.mExpenseInfo = ((TripExpenseInfo)paramBundle.getParcelable("com.ubercab.PAYMENT_EXPENSE_INFO"));
      this.mIsGmmIntentConsumed = paramBundle.getBoolean("com.ubercab.BUNDLE_GMM_IS_INTENT_CONSUMED");
      this.mGmmProductSurgeDisplayed = ((GmmProductSurge)paramBundle.getParcelable("com.ubercab.BUNDLE_GMM_SURGE_DISPLAYED"));
      this.mConfirmationSurgeFareId = paramBundle.getLong("com.ubercab.COMFIRMATION_SURGE_FARE_ID");
      this.mLocationPreviousPickup = ((RiderLocation)paramBundle.getParcelable("com.ubercab.LOCATION_PREVIOUS_PICKUP"));
      this.mSelectedPaymentProfile = ((PaymentProfile)paramBundle.getParcelable("com.ubercab.SELECTED_PAYMENT_PROFILE"));
      this.mIsPinLocationInitialized = paramBundle.getBoolean("com.ubercab.PIN_LOCATION_INITIALIZED");
      this.mIsRateCardShown = paramBundle.getBoolean("com.ubercab.RATE_CARD_VISIBLE");
    }
  }

  public void onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    paramMenuInflater.inflate(2131689478, paramMenu);
    String str1 = getString(2131559068);
    paramMenu.findItem(2131427941).setTitle(str1);
    String str2 = getString(2131558476);
    paramMenu.findItem(2131427942).setTitle(str2);
    final MenuItem localMenuItem = paramMenu.findItem(2131427940);
    localMenuItem.setTitle(getString(2131559078));
    localMenuItem.getActionView().setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        TripFragment.this.onOptionsItemSelected(localMenuItem);
      }
    });
    String str3 = getString(2131558470);
    paramMenu.findItem(2131427943).setTitle(str3);
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(2130903193, paramViewGroup, false);
    ButterKnife.inject(this, localView);
    return localView;
  }

  @Subscribe
  public void onDestinationChangedEvent(DestinationChangedEvent paramDestinationChangedEvent)
  {
    updateUI();
    updateDestinationOverlayUI();
  }

  public void onDestroyView()
  {
    super.onDestroyView();
    this.mViewHeader.removeListener(this);
    this.mViewFooter.removeListener(this);
    this.mFragmentMap.removeTouchEventListener(this);
    this.mFragmentMap.removeOnCameraChangeListener(this);
    ButterKnife.reset(this);
    if ((this.mRateCardPopupWindow != null) && (this.mRateCardPopupWindow.isShowing()))
    {
      this.mRateCardPopupWindow.dismiss();
      this.mRateCardPopupWindow = null;
    }
    if ((this.mMobileMessagePopupWindow != null) && (this.mMobileMessagePopupWindow.isShowing()))
    {
      this.mMobileMessagePopupWindow.dismiss();
      this.mMobileMessagePopupWindow = null;
    }
  }

  @Subscribe
  public void onDismissFareDetailEvent(DismissFareDetailEvent paramDismissFareDetailEvent)
  {
    this.mRateCardPopupWindow.removeListener(this);
    this.mRateCardPopupWindow = null;
    this.mTripUIStateManager.setShowingFareDetails(false);
    this.mIsRateCardShown = false;
  }

  public void onDrawVehicleBitmaps(List<VehicleTextBitmap> paramList)
  {
    this.mMobileMessageManager.setVehicleTextBitmaps(paramList);
  }

  public void onEarnPointsClicked()
  {
    this.mIsUsingPoints = false;
    updateUI();
  }

  @Subscribe
  public void onFareEstimateEvent(FareEstimateEvent paramFareEstimateEvent)
  {
    if (this.mSelectedPaymentProfile == null)
      this.mFareEstimatePointsRange = null;
    Float localFloat;
    FareEstimateRange localFareEstimateRange;
    do
    {
      RewardInfo localRewardInfo;
      do
      {
        return;
        localRewardInfo = this.mSelectedPaymentProfile.getRewardInfo();
      }
      while ((localRewardInfo == null) || (localRewardInfo.getBalance() == null));
      localFloat = Float.valueOf(localRewardInfo.getBalance().getRewardsToCurrencyRatio());
      localFareEstimateRange = paramFareEstimateEvent.getFareEstimateRange();
    }
    while ((localFloat == null) || (localFareEstimateRange == null));
    this.mFareEstimatePointsRange = LegacyFareEstimateManager.getFareEstimatePointsRange(localFareEstimateRange, localFloat);
  }

  public void onFareQuoteClicked(ConfirmationView paramConfirmationView)
  {
    Ping localPing = this.mPingProvider.get();
    String str = this.mTripUIStateManager.getSelectedVehicleViewId();
    if (!PingUtils.hasVehicleView(localPing, str))
      return;
    VehicleView localVehicleView = localPing.getCity().findVehicleView(str);
    if ((localVehicleView.isAllowFareEstimate()) && (localVehicleView.isDestinationEnabled()))
    {
      Intent localIntent = new Intent(this.mContext, FareEstimateActivity.class);
      localIntent.putExtra("com.ubercab.FARE_ID", this.mConfirmationSurgeFareId);
      localIntent.putExtra("com.ubercab.LOCATION_DESTINATION", this.mTripUIStateManager.getDestination());
      PaymentProfile localPaymentProfile = this.mSelectedPaymentProfile;
      RewardInfo localRewardInfo = null;
      if (localPaymentProfile != null)
        localRewardInfo = this.mSelectedPaymentProfile.getRewardInfo();
      boolean bool = PingUtils.hasExperimentSerial(localPing, "amex_rewards", 1);
      if ((this.mIsUsingPoints) && (bool) && (localRewardInfo != null))
      {
        Balance localBalance = localRewardInfo.getBalance();
        if (localBalance != null)
          localIntent.putExtra("com.ubercab.CURRENCY_TO_POINTS_RATIO", localBalance.getRewardsToCurrencyRatio());
      }
      startActivityForResult(localIntent, 5001);
      this.mAnalyticsManager.tripEvent().fareEstimateOpen();
      this.mAnalyticsClient.sendTapEvent(RiderEvents.Tap.SEARCH_DROPOFF_OPEN_FARE_ESTIMATE);
      return;
    }
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(this.mContext);
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = localVehicleView.getDescription();
    localBuilder.setMessage(getString(2131558855, arrayOfObject)).setPositiveButton(getString(2131558485), null).create().show();
  }

  @Subscribe
  public void onGetFareEstimateEvent(GetFareEstimateEvent paramGetFareEstimateEvent)
  {
    sendSetDestinationRequest(this.mTripUIStateManager.getDestination());
  }

  @Subscribe
  @Deprecated
  public void onLegacyMobileMessageEvent(LegacyMobileMessageEvent paramLegacyMobileMessageEvent)
  {
    boolean bool = TripUIStateManager.isLooking(this.mTripUIStateManager.getState());
    if ((!this.mViewLegacyMobileMessageOverlay.isShown()) && (bool))
    {
      LegacyMobileMessage localLegacyMobileMessage = paramLegacyMobileMessageEvent.getLegacyMobileMessage();
      this.mViewLegacyMobileMessageOverlay.populateHTML(localLegacyMobileMessage);
    }
  }

  @Subscribe
  public void onLocationHistoryResponse(LocationHistoryResponseEvent paramLocationHistoryResponseEvent)
  {
    this.mIsPinLocationInitialized = true;
    if (!paramLocationHistoryResponseEvent.isSuccess());
    LocationSearchResult localLocationSearchResult;
    do
    {
      RiderLocation localRiderLocation;
      do
      {
        return;
        localRiderLocation = this.mLocationProvider.getPinLocation();
      }
      while ((localRiderLocation != null) && (localRiderLocation.isExternalLocation()));
      localLocationSearchResult = ((LocationHistoryResponse)paramLocationHistoryResponseEvent.getModel()).getPickups().getPrimaryResult();
    }
    while (localLocationSearchResult == null);
    this.mAnalyticsManager.nearestCabEvent().snappedLocationPickupRequest();
    this.mAnalyticsManager.requestVehicleEvent().setLocationWasSnapped(true);
    this.mLocationProvider.updatePinLocation(RiderLocation.create(localLocationSearchResult));
    this.mAnalyticsClient.sendImpressionEvent(RiderEvents.Impression.PICKUP_LOCATION_SNAPPED);
  }

  public void onMapTouchEventActionDown()
  {
    this.mIsDraggingMap = true;
    this.mIsMapMovedByUser = true;
    this.mAnalyticsClient.sendTapEvent(RiderEvents.Tap.MAP_PAN);
    if (!shouldTrackMapChanges());
    while ((!PingUtils.isClientStatusLooking(this.mPingProvider.get())) || (this.mLocationProvider.getPinLocation() != null))
      return;
    this.mLocationProvider.updatePinLocation(RiderLocation.create(MapFragment.DEFAULT_LATLNG));
    this.mAnalyticsManager.locationEvent().noLocationTapToRemoveOverlay();
  }

  public void onMapTouchEventActionMove()
  {
  }

  public void onMapTouchEventActionUp()
  {
    if (!shouldTrackMapChanges())
      return;
    getView().postDelayed(new Runnable()
    {
      public void run()
      {
        TripFragment.access$002(TripFragment.this, false);
        if (TripFragment.this.isResumed())
          TripFragment.this.syncPinToCamera();
      }
    }
    , this.mAnimTimeLong);
  }

  @Subscribe
  public void onMobileMessageConfirmActionEvent(MobileMessageConfirmActionEvent paramMobileMessageConfirmActionEvent)
  {
    MobileMessage localMobileMessage = paramMobileMessageConfirmActionEvent.getMessage();
    if (localMobileMessage.getDisplayProps() == null);
    String str;
    do
    {
      return;
      str = localMobileMessage.getDisplayProps().getShowAfterRequestingVehicleViewId();
    }
    while ((this.mTripUIStateManager.getState() != 0) || (!Objects.equal(str, this.mTripUIStateManager.getSelectedVehicleViewId())));
    showConfirmingState();
  }

  @Subscribe
  public void onMobileMessageForLookingEvent(MobileMessageForLookingEvent paramMobileMessageForLookingEvent)
  {
    if (this.mTripUIStateManager.isShowingFareDetails());
    while (!TripUIStateManager.isLooking(this.mTripUIStateManager.getState()))
      return;
    MobileMessage localMobileMessage = paramMobileMessageForLookingEvent.getMessage();
    if ((localMobileMessage.getDisplayProps() != null) && (localMobileMessage.getDisplayProps().getAutoSelectVehicleView()));
    for (int i = 1; ; i = 0)
    {
      if (i != 0)
        this.mTripUIStateManager.setSelectedVehicleViewId(localMobileMessage.getVehicleViewId());
      showMobileMessage(localMobileMessage);
      return;
    }
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default:
      return false;
    case 16908332:
      onBackPressed();
      return true;
    case 2131427941:
      this.mBus.post(new ShareEtaEvent());
      return true;
    case 2131427943:
      this.mBus.post(new com.ubercab.client.feature.trip.event.CancelTripEvent());
      this.mAnalyticsClient.sendTapEvent(RiderEvents.Tap.TRIP_CANCEL);
      return true;
    case 2131427942:
      String str = this.mPingProvider.get().getTrip().getPaymentProfileId();
      this.mBus.post(new ChangeTripPaymentEvent(str, this.mExpenseInfo));
      this.mAnalyticsClient.sendTapEvent(RiderEvents.Tap.PAYMENT_BUTTON_TRIP);
      return true;
    case 2131427940:
    }
    this.mBus.post(new SplitFareEvent());
    return true;
  }

  public void onPause()
  {
    super.onPause();
    this.mLegacyFareEstimateManager.stop();
    this.mMultiFareEstimateManager.stop();
  }

  @Subscribe
  public void onPickupCancelClientResponseEvent(PickupCancelClientResponseEvent paramPickupCancelClientResponseEvent)
  {
    hideLoadingDialog();
    this.mAnalyticsManager.cancelTripEvent().cancelTripResponse(paramPickupCancelClientResponseEvent.getStatusCode());
  }

  @Subscribe
  public void onPinLocationEvent(PinLocationEvent paramPinLocationEvent)
  {
    RiderLocation localRiderLocation1 = paramPinLocationEvent.getLocation();
    if (!this.mIsPinLocationInitialized)
      this.mLocationClient.history(localRiderLocation1.getUberLatLng().getLatitude(), localRiderLocation1.getUberLatLng().getLongitude());
    Ping localPing = this.mPingProvider.get();
    if (localPing == null)
      return;
    int i;
    if (PingUtils.isClientStatusLooking(localPing))
    {
      i = this.mTripUIStateManager.getState();
      if (!localRiderLocation1.hasReverseGeocodeData())
        break label163;
    }
    label163: for (RiderLocation localRiderLocation2 = localRiderLocation1; ; localRiderLocation2 = null)
    {
      RiderLocation localRiderLocation3 = this.mTripUIStateManager.getDestination();
      String str = this.mTripUIStateManager.getSelectedVehicleViewId();
      this.mViewHeader.updateUI(i, localPing, localRiderLocation2, localRiderLocation3, str);
      if ((this.mLocationPreviousPickup != null) && (!localRiderLocation1.getUberLatLng().equals(this.mLocationPreviousPickup.getUberLatLng())))
      {
        this.mRiderClient.pingClient();
        this.mAnalyticsManager.nearestCabEvent().movePinRequest();
      }
      this.mAnalyticsManager.requestVehicleEvent().updateLocation(localRiderLocation1);
      return;
    }
  }

  @Subscribe
  public void onPingEvent(PingEvent paramPingEvent)
  {
    Ping localPing = paramPingEvent.getPing();
    if (!PingUtils.hasClient(localPing))
      return;
    FareSplitClient localFareSplitClient = localPing.getFareSplit().getClientSelf();
    if ((localFareSplitClient != null) && (localFareSplitClient.getStatus().equals("Pending")))
      this.mBus.post(new FareSplitInvitationEvent());
    Client localClient = localPing.getClient();
    RiderLocation localRiderLocation = this.mLocationProvider.getPinLocation();
    ReverseGeocode localReverseGeocode = localClient.getReverseGeocode();
    if ((localRiderLocation != null) && (localReverseGeocode != null) && (this.mIsPinLocationInitialized))
    {
      boolean bool1 = "manual".equals(localRiderLocation.getType());
      boolean bool2 = "external".equals(localRiderLocation.getType());
      boolean bool3 = localRiderLocation.isDeviceLocation();
      boolean bool4 = LocationUtils.equalWithinDistance(new UberLatLng(localReverseGeocode.getLatitude(), localReverseGeocode.getLongitude()), this.mFragmentMap.getCameraLatLng());
      if ((!localRiderLocation.hasReverseGeocodeData()) && ((bool1) || (bool2) || (bool3)) && (bool4) && (!this.mIsDraggingMap))
      {
        this.mAnalyticsManager.locationEvent().updateReverseGeocode();
        this.mLocationProvider.updatePinLocation(RiderLocation.create(localReverseGeocode));
      }
    }
    if (this.mSelectedPaymentProfile == null)
      if (localClient.isLastSelectedPaymentProfileGoogleWallet())
        this.mSelectedPaymentProfile = PaymentProfile.GOOGLE_WALLET;
    while (true)
    {
      if ((!this.mGotFirstPing) && (this.mExpenseInfo == null))
      {
        this.mGotFirstPing = true;
        this.mExpenseInfo = new TripExpenseInfo();
        this.mExpenseInfo.setExpenseTrip(paramPingEvent.getPing().lastIsSendExpense());
        if ((this.mSelectedPaymentProfile != null) && (this.mSelectedPaymentProfile.isBusinessCard()))
          this.mIsUsingCredits = false;
      }
      this.mLocationPreviousPickup = localRiderLocation;
      updateUI();
      return;
      if ((localClient.getPaymentProfiles().isEmpty()) && (GoogleWalletActivity.isEligible(this.mContext)))
      {
        this.mSelectedPaymentProfile = PaymentProfile.GOOGLE_WALLET;
      }
      else
      {
        this.mSelectedPaymentProfile = localClient.findLastSelectedPaymentProfile();
        continue;
        if (this.mSelectedPaymentProfile != PaymentProfile.GOOGLE_WALLET)
        {
          this.mSelectedPaymentProfile = localClient.findPaymentProfileWithId(this.mSelectedPaymentProfile.getId());
          if (this.mSelectedPaymentProfile == null)
            this.mSelectedPaymentProfile = localClient.findLastSelectedPaymentProfile();
        }
      }
    }
  }

  public void onPrepareOptionsMenu(Menu paramMenu)
  {
    Ping localPing = this.mPingProvider.get();
    if (!PingUtils.hasClient(localPing))
      return;
    String str = localPing.getClient().getStatus();
    boolean bool1;
    int i;
    label73: int j;
    label93: boolean bool3;
    label122: boolean bool4;
    label173: MenuItem localMenuItem3;
    if ((!str.equals("Looking")) && (!str.equals("Dispatching")))
    {
      bool1 = true;
      boolean bool2 = PingUtils.isTripMaster(localPing);
      if ((!PingUtils.hasTrip(localPing)) || (!localPing.getTrip().getCanShareETA()))
        break label284;
      i = 1;
      if ((!PingUtils.hasTrip(localPing)) || (!localPing.getTrip().getCanSplitFare()))
        break label290;
      j = 1;
      MenuItem localMenuItem1 = paramMenu.findItem(2131427941);
      if ((!bool1) || (!bool2) || (i == 0))
        break label296;
      bool3 = true;
      localMenuItem1.setVisible(bool3);
      paramMenu.findItem(2131427942).setVisible(bool1);
      MenuItem localMenuItem2 = paramMenu.findItem(2131427943);
      if ((!bool1) || (!bool2))
        break label302;
      bool4 = true;
      localMenuItem2.setVisible(bool4);
      localMenuItem3 = paramMenu.findItem(2131427940);
      if ((!bool1) || (j == 0))
        break label308;
    }
    TextView localTextView;
    label284: label290: label296: label302: label308: for (boolean bool5 = true; ; bool5 = false)
    {
      localMenuItem3.setVisible(bool5);
      localTextView = (TextView)localMenuItem3.getActionView().findViewById(2131427767);
      if (localPing.getFareSplit().getClients().size() <= 1)
        break label314;
      localTextView.setVisibility(0);
      localTextView.setText(String.valueOf(localPing.getFareSplit().getClients().size()));
      return;
      bool1 = false;
      break;
      i = 0;
      break label73;
      j = 0;
      break label93;
      bool3 = false;
      break label122;
      bool4 = false;
      break label173;
    }
    label314: localTextView.setVisibility(8);
  }

  @Subscribe
  public void onPromoCodeAcceptedConfirmedEvent(PromoCodeAcceptedConfirmedEvent paramPromoCodeAcceptedConfirmedEvent)
  {
    PromoFragment localPromoFragment = (PromoFragment)getFragmentManager().findFragmentByTag(PromoFragment.TAG);
    if (localPromoFragment != null)
      localPromoFragment.dismiss();
  }

  public void onPromoCodeClicked(ConfirmationView paramConfirmationView)
  {
    if (getFragmentManager().findFragmentByTag(PromoFragment.TAG) == null)
      PromoFragment.newInstance().show(getFragmentManager(), PromoFragment.TAG);
  }

  public void onRequestUberClicked(ConfirmationView paramConfirmationView)
  {
    if (this.mSelectedPaymentProfile == PaymentProfile.GOOGLE_WALLET)
    {
      this.mBus.post(new CreateGoogleWalletPaymentProfileEvent());
      return;
    }
    if (this.mSelectedPaymentProfile == null)
    {
      new AlertDialog.Builder(this.mContext).setMessage(getString(2131558986)).setPositiveButton(getString(2131558485), null).create().show();
      return;
    }
    if ((this.mSelectedPaymentProfile.isBusinessCard()) && (!this.mIsExpenseScreenShown))
    {
      this.mBus.post(new AddBusinessCardExpenseInfoEvent(this.mSelectedPaymentProfile, this.mExpenseInfo));
      return;
    }
    sendPickupRequest(this.mSelectedPaymentProfile.getId(), false);
  }

  public void onResume()
  {
    super.onResume();
    checkForAndConsumeGmmIntent(getActivity().getIntent());
    this.mAnalyticsManager.tripEvent().setAppContext("map");
    this.mBus.post(new TripFragmentReadyEvent());
    this.mLegacyFareEstimateManager.start();
    this.mMultiFareEstimateManager.start();
    if (this.mIsRateCardShown)
      showRateCardAfterDelay();
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putBoolean("com.ubercab.IS_USING_CREDITS", this.mIsUsingCredits);
    paramBundle.putBoolean("com.ubercab.IS_USING_POINTS", this.mIsUsingPoints);
    paramBundle.putBoolean("com.ubercab.BUNDLE_GMM_IS_INTENT_CONSUMED", this.mIsGmmIntentConsumed);
    paramBundle.putParcelable("com.ubercab.BUNDLE_GMM_SURGE_DISPLAYED", this.mGmmProductSurgeDisplayed);
    paramBundle.putLong("com.ubercab.COMFIRMATION_SURGE_FARE_ID", this.mConfirmationSurgeFareId);
    paramBundle.putParcelable("com.ubercab.LOCATION_PREVIOUS_PICKUP", this.mLocationPreviousPickup);
    paramBundle.putParcelable("com.ubercab.SELECTED_PAYMENT_PROFILE", this.mSelectedPaymentProfile);
    paramBundle.putParcelable("com.ubercab.PAYMENT_EXPENSE_INFO", this.mExpenseInfo);
    paramBundle.putBoolean("com.ubercab.PIN_LOCATION_INITIALIZED", this.mIsPinLocationInitialized);
    paramBundle.putBoolean("com.ubercab.RATE_CARD_VISIBLE", this.mIsRateCardShown);
  }

  public void onSelectPaymentClicked(ConfirmationView paramConfirmationView)
  {
    this.mBus.post(new SelectPaymentEvent(this.mSelectedPaymentProfile, this.mIsUsingCredits, this.mIsUsingPoints, this.mExpenseInfo));
  }

  @Subscribe
  public void onSetDestinationResponseEvent(SetDestinationResponseEvent paramSetDestinationResponseEvent)
  {
    if (!paramSetDestinationResponseEvent.isSuccess())
      showToast(paramSetDestinationResponseEvent.getErrorMessage(getActivity()));
  }

  public void onShowDestinationAddress(int paramInt)
  {
    AnalyticsEvent.Builder localBuilder;
    if (this.mTripUIStateManager.getState() == 2)
    {
      this.mViewDestinationTutorialOverlay.reveal(paramInt);
      if (!this.mViewDestinationTutorialOverlay.isShown())
        break label79;
      this.mViewDispatchDestinationOverlay.setVisibility(8);
      localBuilder = new AnalyticsEvent.Builder("impression").setName(RiderEvents.Impression.DESTINATION_SET_PRE_DISPATCH);
      if (!this.mTripUIStateManager.hasDestination())
        break label90;
    }
    label79: label90: for (String str = "yes"; ; str = "no")
    {
      localBuilder.setValue(str).build();
      return;
      this.mViewDispatchDestinationOverlay.reveal(paramInt);
      break;
    }
  }

  @Subscribe
  public void onShowFareDetailEvent(ShowFareDetailEvent paramShowFareDetailEvent)
  {
    showRateCard(paramShowFareDetailEvent.getVehicleViewId(), paramShowFareDetailEvent.getFooterHeight());
  }

  @Subscribe
  public void onShowFareQuoteEvent(ShowFareQuoteEvent paramShowFareQuoteEvent)
  {
    String str = this.mTripUIStateManager.getSelectedVehicleViewId();
    MobileMessage localMobileMessage = this.mMobileMessageManager.findMessageForVehicleViewFareEstimate(str);
    if ((localMobileMessage != null) && (this.mMobileMessageManager.isPreloaded(localMobileMessage.getId())))
    {
      showMobileMessage(localMobileMessage);
      return;
    }
    if ((PingUtils.hasExperimentSerial(this.mPingProvider.get(), "amex_rewards", 1)) && (this.mIsUsingPoints) && (!TextUtils.isEmpty(this.mFareEstimatePointsRange)))
    {
      RewardPointsFareEstimateFragment localRewardPointsFareEstimateFragment = RewardPointsFareEstimateFragment.newInstance(this.mFareEstimatePointsRange);
      localRewardPointsFareEstimateFragment.show(getFragmentManager(), localRewardPointsFareEstimateFragment.getClass().getName());
      return;
    }
    new AlertDialog.Builder(this.mContext).setMessage(getString(2131558854)).setPositiveButton(getString(2131558973), null).create().show();
  }

  @Subscribe
  public void onTripUIStateChangedEvent(TripUIStateChangedEvent paramTripUIStateChangedEvent)
  {
    int i = paramTripUIStateChangedEvent.getState();
    this.mAnalyticsManager.tripEvent().setTripUIState(i);
    ImpressionEventName localImpressionEventName = TripAnalyticsUtils.convertTripUIStateToV2EventName(i);
    if (localImpressionEventName != null)
      this.mAnalyticsClient.sendImpressionEvent(localImpressionEventName);
    if (paramTripUIStateChangedEvent.getState() > 1)
      this.mTripUIStateManager.setRateCardFareEstimateRequested(false);
    updateUI();
    updateDestinationOverlayUI();
    updateMusicOverlayUI(i);
  }

  public void onUsePointsClicked()
  {
    this.mIsUsingPoints = true;
    updateUI();
  }

  public void onVehicleBannerBarClicked(String paramString)
  {
    MobileMessage localMobileMessage = this.mMobileMessageManager.findMessageForVehicleView(paramString, false);
    if (localMobileMessage != null)
      this.mBus.post(new MobileMessageForLookingEvent(localMobileMessage));
    String str;
    do
    {
      return;
      str = this.mTripUIStateManager.getSelectedVehicleViewId();
    }
    while (TextUtils.isEmpty(str));
    showRateCard(str, this.mViewFooter.getHeightForModal());
  }

  public void onVehicleSliderSizeChanged(boolean paramBoolean)
  {
    this.mBus.post(new FooterSizeChangedEvent(paramBoolean, this.mViewFooter.getMinHeight(), this.mViewFooter.getMaxHeight()));
    updateMapPadding();
  }

  public void onVehicleViewChanged(String paramString)
  {
    this.mTripUIStateManager.setSelectedVehicleViewId(paramString);
  }

  public void onVehicleViewClicked(String paramString)
  {
    if ((this.mRateCardPopupWindow == null) || (!this.mRateCardPopupWindow.isShowing()))
      this.mBus.post(new ShowFareDetailEvent(paramString, this.mViewFooter.getHeightForModal()));
    for (String str = "show_detail"; ; str = "dismiss_detail")
    {
      this.mAnalyticsClient.addEvent(new AnalyticsEvent.Builder("tap").setName(RiderEvents.Tap.PRODUCT_SELECT_PARENT).setValue(str).build());
      return;
      this.mRateCardPopupWindow.dismiss();
    }
  }

  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    setHasOptionsMenu(true);
    this.mFragmentMap = ((MapFragment)getActivity().getFragmentManager().findFragmentById(2131427774));
    this.mFragmentMap.addOnCameraChangeListener(this);
    this.mFragmentMap.addTouchEventListener(this);
    this.mViewHeader.addListener(this);
    this.mViewFooter.addListener(this);
    this.mViewDestinationTutorialOverlay.addListener(this);
    this.mViewDispatchDestinationOverlay.addListener(this);
    this.mDismissListenerFareDetail = new PopupWindow.OnDismissListener()
    {
      public void onDismiss()
      {
        TripFragment.this.mBus.post(new DismissFareDetailEvent());
      }
    };
    this.mRateCardDisplayHandler = new Handler();
    this.mRateCardDisplayRunnable = new Runnable()
    {
      public void run()
      {
        if (!TripFragment.this.isResumed())
          return;
        if (TripFragment.this.mViewFooter == null)
        {
          Timber.w("Rate card not displayed due to null footer.", new Object[0]);
          return;
        }
        String str = TripFragment.this.mTripUIStateManager.getSelectedVehicleViewId();
        if (TextUtils.isEmpty(str))
        {
          Timber.w("Rate card not displayed due to empty vvid.", new Object[0]);
          return;
        }
        TripFragment.this.mBus.post(new ShowFareDetailEvent(str, TripFragment.this.mViewFooter.getHeightForModal()));
      }
    };
  }

  void sendCancelTripRequest()
  {
    showLoadingDialogSticky(getString(2131558471), null);
    this.mRiderClient.pickupCancelClient();
    this.mAnalyticsManager.cancelTripEvent().cancelTripRequest(this.mPingProvider.get().getClient().getStatus());
  }

  void sendPickupRequest(String paramString, boolean paramBoolean)
  {
    String str1 = this.mTripUIStateManager.getSelectedVehicleViewId();
    if (TextUtils.isEmpty(str1))
      return;
    CnLocation localCnLocation1 = this.mLocationProvider.getPinLocation().getCnLocation();
    RiderLocation localRiderLocation1 = this.mLocationProvider.getDeviceLocation();
    CnLocation localCnLocation2;
    RiderLocation localRiderLocation2;
    if (localRiderLocation1 != null)
    {
      localCnLocation2 = localRiderLocation1.getCnLocation();
      localRiderLocation2 = this.mTripUIStateManager.getDestination();
      if (localRiderLocation2 == null)
        break label133;
    }
    Ping localPing;
    VehicleView localVehicleView;
    label133: for (CnLocation localCnLocation3 = localRiderLocation2.getCnLocation(); ; localCnLocation3 = null)
    {
      localPing = this.mPingProvider.get();
      boolean bool1 = PingUtils.hasVehicleView(localPing, str1);
      bool2 = false;
      if (!bool1)
        break label146;
      localVehicleView = localPing.getCity().findVehicleView(str1);
      if ((localCnLocation3 != null) || (!localVehicleView.isDestinationRequired()))
        break label139;
      this.mViewHeader.showDestinationError();
      return;
      localCnLocation2 = null;
      break;
    }
    label139: boolean bool2 = localVehicleView.isCashOnly();
    label146: this.mTripUIStateManager.setPickupRequestPending(true);
    String str2;
    RiderClient localRiderClient;
    int i;
    long l;
    boolean bool3;
    if ("PayPal".equals(this.mSelectedPaymentProfile.getCardType()))
    {
      str2 = PayPalUtils.getCorrelationId(getActivity());
      localRiderClient = this.mRiderClient;
      i = Integer.parseInt(str1);
      l = this.mConfirmationSurgeFareId;
      bool3 = this.mIsUsingCredits;
      if ((!this.mIsUsingPoints) || (bool2))
        break label296;
    }
    label296: for (boolean bool4 = true; ; bool4 = false)
    {
      localRiderClient.pickup(localCnLocation2, localCnLocation1, localCnLocation3, i, l, paramString, paramBoolean, bool3, bool4, this.mExpenseInfo, str2);
      setExpenseScreenShown(false);
      RequestVehicleEvent localRequestVehicleEvent = this.mAnalyticsManager.requestVehicleEvent();
      boolean bool5 = isExpenseTrip();
      boolean bool6 = this.mIsUsingCredits;
      localRequestVehicleEvent.requestVehicleRequest(localPing, str1, localCnLocation1, localCnLocation3, bool5, bool6);
      return;
      str2 = null;
      break;
    }
  }

  void sendSetDestinationRequest(RiderLocation paramRiderLocation)
  {
    Ping localPing = this.mPingProvider.get();
    CnLocation localCnLocation1;
    long l;
    if (PingUtils.hasTrip(localPing))
    {
      this.mTripUIStateManager.setPendingTripDestination(paramRiderLocation);
      localCnLocation1 = localPing.getTrip().getPickupLocation();
      l = this.mConfirmationSurgeFareId;
      if (paramRiderLocation == null)
        break label119;
    }
    label119: for (CnLocation localCnLocation2 = paramRiderLocation.getCnLocation(); ; localCnLocation2 = null)
    {
      String str = this.mTripUIStateManager.getSelectedVehicleViewId();
      this.mRiderClient.setDestination(Integer.valueOf(str).intValue(), l, localCnLocation1, localCnLocation2);
      return;
      RiderLocation localRiderLocation = this.mLocationProvider.getPinLocation();
      localCnLocation1 = null;
      if (localRiderLocation == null)
        break;
      this.mTripUIStateManager.setPreTripDestination(paramRiderLocation);
      localCnLocation1 = this.mLocationProvider.getPinLocation().getCnLocation();
      break;
    }
  }

  void setExpenseInfo(TripExpenseInfo paramTripExpenseInfo)
  {
    this.mExpenseInfo = paramTripExpenseInfo;
  }

  void setExpenseScreenShown(boolean paramBoolean)
  {
    this.mIsExpenseScreenShown = paramBoolean;
  }

  void setIsUsingCredits(boolean paramBoolean)
  {
    this.mIsUsingCredits = paramBoolean;
  }

  void setIsUsingPoints(boolean paramBoolean)
  {
    this.mIsUsingPoints = paramBoolean;
  }

  void setSelectedPaymentProfile(PaymentProfile paramPaymentProfile)
  {
    this.mSelectedPaymentProfile = paramPaymentProfile;
  }

  void showAddFunds()
  {
    startActivity(AddFundsActivity.newIntent(this.mContext, this.mSelectedPaymentProfile.getUuid()));
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.trip.TripFragment
 * JD-Core Version:    0.6.2
 */