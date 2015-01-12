package com.ubercab.client.feature.profile;

import android.app.ActionBar;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import com.ubercab.client.core.app.RiderApplication;
import com.ubercab.client.core.app.RiderFragment;
import com.ubercab.client.core.app.RiderPreferences;
import com.ubercab.client.core.content.event.PingEvent;
import com.ubercab.client.core.model.AppConfig;
import com.ubercab.client.core.model.Client;
import com.ubercab.client.core.model.LocationSearchResult;
import com.ubercab.client.core.model.MusicProvider;
import com.ubercab.client.core.model.Ping;
import com.ubercab.client.core.network.events.ThirdPartyAuthResponseEvent;
import com.ubercab.client.core.ui.MergedSectionAdapter;
import com.ubercab.client.core.util.PingUtils;
import com.ubercab.client.feature.music.MusicProviderAdapter;
import com.ubercab.client.feature.search.LocationSearchAdapter;
import com.ubercab.client.feature.search.LocationSearchResultWrapper;
import com.ubercab.library.app.annotation.ForActivity;
import com.ubercab.library.util.PhoneNumberUtils;
import com.ubercab.ui.UberEditText;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

public class ProfileFragment extends RiderFragment
{
  private static final String SPOTIFY = "Spotify";
  private static final String SPOTIFY_ID = "spotify";

  @Inject
  ActionBar mActionBar;

  @Inject
  Bus mBus;
  private List<MusicProvider> mConnectedAccounts;

  @ForActivity
  @Inject
  Context mContext;
  private Drawable mDrawableDefaultPicture;

  @InjectView(2131427660)
  ImageView mImageViewProfile;

  @Inject
  LayoutInflater mLayoutInflater;
  private MusicProviderAdapter mMusicProviderAdapter;

  @Inject
  Picasso mPicasso;

  @Inject
  RiderPreferences mRiderPreferences;

  @InjectView(2131427663)
  UberEditText mTextViewEmail;

  @InjectView(2131427661)
  UberEditText mTextViewFirstName;

  @InjectView(2131427662)
  UberEditText mTextViewLastName;

  @InjectView(2131427664)
  UberEditText mTextViewPhone;

  private void addConnectedAccountsSection(List<ListAdapter> paramList, List<String> paramList1)
  {
    this.mMusicProviderAdapter = new MusicProviderAdapter(this.mContext, this.mBus, this.mConnectedAccounts);
    paramList1.add(getString(2131558521));
    paramList.add(this.mMusicProviderAdapter);
  }

  private void addTaggedLocationsSection(List<ListAdapter> paramList, List<String> paramList1)
  {
    if (!this.mRiderPreferences.isFakeFavoriteLocationsEnabledForHomeWork())
      return;
    LocationSearchAdapter localLocationSearchAdapter = new LocationSearchAdapter(this.mContext, this.mBus, false, false);
    paramList.add(localLocationSearchAdapter);
    paramList1.add(getString(2131559004));
    localLocationSearchAdapter.update(getTaggedLocations());
  }

  private List<LocationSearchResultWrapper> getTaggedLocations()
  {
    ArrayList localArrayList = new ArrayList();
    String[] arrayOfString = LocationSearchResult.HOME_WORK_TAGS;
    int i = arrayOfString.length;
    int j = 0;
    if (j < i)
    {
      String str = arrayOfString[j];
      LocationSearchResult localLocationSearchResult = this.mRiderPreferences.getFavoriteLocation(str);
      if (localLocationSearchResult == null)
        localArrayList.add(new LocationSearchResultWrapper(this.mContext, str));
      while (true)
      {
        j++;
        break;
        localArrayList.add(new LocationSearchResultWrapper(this.mContext, localLocationSearchResult, str));
      }
    }
    return localArrayList;
  }

  private void initializeSections(ListView paramListView)
  {
    paramListView.addHeaderView(this.mLayoutInflater.inflate(2130903154, paramListView, false));
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    addConnectedAccountsSection(localArrayList2, localArrayList1);
    addTaggedLocationsSection(localArrayList2, localArrayList1);
    paramListView.setAdapter(new MergedSectionAdapter(this.mContext, localArrayList2, localArrayList1));
  }

  static ProfileFragment newInstance()
  {
    return new ProfileFragment();
  }

  @OnClick({2131427667})
  public void onClickButtonSignout()
  {
    RiderApplication.get(getActivity()).signout();
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mActionBar.setTitle(getString(2131559013));
    this.mConnectedAccounts = new ArrayList();
    this.mDrawableDefaultPicture = getResources().getDrawable(2130837854);
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(2130903156, paramViewGroup, false);
    initializeSections((ListView)localView.findViewById(2131427666));
    ButterKnife.inject(this, localView);
    return localView;
  }

  public void onDestroyView()
  {
    super.onDestroyView();
    ButterKnife.reset(this);
  }

  @Subscribe
  public void onPingEvent(PingEvent paramPingEvent)
  {
    Ping localPing = paramPingEvent.getPing();
    if (!PingUtils.hasClient(localPing))
      return;
    Client localClient = localPing.getClient();
    String str1 = PhoneNumberUtils.getDisplayPhoneNumber(localClient.getMobileDigits(), localClient.getMobileCountryIso2());
    this.mTextViewPhone.setText(str1);
    this.mTextViewEmail.setText(localClient.getEmail());
    this.mTextViewLastName.setText(localClient.getLastName());
    this.mTextViewFirstName.setText(localClient.getFirstName());
    String str2 = localClient.getPictureUrl();
    if (!TextUtils.isEmpty(str2))
    {
      this.mPicasso.load(str2).placeholder(this.mDrawableDefaultPicture).error(this.mDrawableDefaultPicture).into(this.mImageViewProfile);
      label117: boolean bool = PingUtils.hasAppConfig(localPing);
      i = 0;
      if (bool)
        if (localPing.getAppConfig().getSpotifyLinkAndUnlinkDisabled())
          break label223;
    }
    label223: for (int i = 1; ; i = 0)
    {
      this.mConnectedAccounts.clear();
      if ((!localClient.isAdmin()) && (i == 0))
        break;
      MusicProvider localMusicProvider = new MusicProvider();
      localMusicProvider.setId("spotify");
      localMusicProvider.setName("Spotify");
      this.mConnectedAccounts.add(localMusicProvider);
      this.mMusicProviderAdapter.update(localPing);
      return;
      this.mImageViewProfile.setImageDrawable(this.mDrawableDefaultPicture);
      break label117;
    }
  }

  @Subscribe
  public void onThirdPartyAuthResponseEvent(ThirdPartyAuthResponseEvent paramThirdPartyAuthResponseEvent)
  {
    if (paramThirdPartyAuthResponseEvent.isSuccess())
      this.mMusicProviderAdapter.update((Ping)paramThirdPartyAuthResponseEvent.getModel());
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.profile.ProfileFragment
 * JD-Core Version:    0.6.2
 */