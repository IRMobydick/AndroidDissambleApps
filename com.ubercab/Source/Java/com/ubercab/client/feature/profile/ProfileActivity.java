package com.ubercab.client.feature.profile;

import android.content.Intent;
import android.os.Bundle;
import com.squareup.otto.Subscribe;
import com.ubercab.client.core.analytics.AnalyticsManager;
import com.ubercab.client.core.analytics.event.SignOutEvent;
import com.ubercab.client.core.app.RiderPingActivity;
import com.ubercab.client.core.app.event.SignoutEvent;
import com.ubercab.client.core.content.RiderLocationProvider;
import com.ubercab.client.core.model.MusicProvider;
import com.ubercab.client.core.network.RiderClient;
import com.ubercab.client.feature.music.DisconnectMusicProviderActivity;
import com.ubercab.client.feature.music.MusicProviderAuthorizationActivity;
import com.ubercab.client.feature.music.MusicProviderSelectedEvent;
import com.ubercab.client.feature.search.LocationSearchFragment;
import com.ubercab.client.feature.search.event.AddFavoriteLocationEvent;
import com.ubercab.client.feature.search.event.LocationResultClickEvent;
import com.ubercab.client.feature.search.event.RemoveFavoriteLocationEvent;
import com.ubercab.client.feature.search.event.SelectFavoriteLocationEvent;
import javax.inject.Inject;

public class ProfileActivity extends RiderPingActivity
{
  private static final int REQUEST_CODE_SPOTIFY_AUTH = 1;
  private static final String SPOTIFY_ID = "spotify";

  @Inject
  AnalyticsManager mAnalyticsManager;

  @Inject
  RiderLocationProvider mLocationProvider;

  @Inject
  RiderClient mRiderClient;

  private void putLocationSearchFragmentForTaggedLocation(String paramString, boolean paramBoolean)
  {
    if (findFragment(LocationSearchFragment.class) == null)
      if (!paramBoolean)
        break label36;
    label36: for (String str = "com.ubercab.ACTION_ADD_FAVORITE_LOCATION"; ; str = "com.ubercab.ACTION_EDIT_FAVORITE_LOCATION")
    {
      pushFragment(2131427665, LocationSearchFragment.newInstance(str, paramString, this.mLocationProvider.getPinLocation()), true);
      return;
    }
  }

  private void putProfileFragment()
  {
    if (findFragment(ProfileFragment.class) == null)
      putFragment(2131427665, ProfileFragment.newInstance(), true);
  }

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == -1) && (paramInt1 == 1))
    {
      String str = paramIntent.getStringExtra("com.ubercab.AUTHORIZATION_CODE");
      this.mRiderClient.createThirdPartyIdentity("spotify", str);
    }
  }

  @Subscribe
  public void onAddFavoriteLocationEvent(AddFavoriteLocationEvent paramAddFavoriteLocationEvent)
  {
    putLocationSearchFragmentForTaggedLocation(paramAddFavoriteLocationEvent.getTag(), true);
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903155);
    putProfileFragment();
  }

  @Subscribe
  public void onLocationClickEvent(LocationResultClickEvent paramLocationResultClickEvent)
  {
    putLocationSearchFragmentForTaggedLocation(paramLocationResultClickEvent.getTag(), false);
  }

  @Subscribe
  public void onMusicProviderSelectedEvent(MusicProviderSelectedEvent paramMusicProviderSelectedEvent)
  {
    if (paramMusicProviderSelectedEvent.getMusicProvider().isLinked())
    {
      startActivity(DisconnectMusicProviderActivity.newIntent(this, "spotify", "Spotify"));
      return;
    }
    startActivityForResult(new Intent(this, MusicProviderAuthorizationActivity.class), 1);
  }

  @Subscribe
  public void onRemoveFavoriteLocationEvent(RemoveFavoriteLocationEvent paramRemoveFavoriteLocationEvent)
  {
    popFragment();
  }

  @Subscribe
  public void onSelectFavoriteLocationEvent(SelectFavoriteLocationEvent paramSelectFavoriteLocationEvent)
  {
    popFragment();
  }

  @Subscribe
  public void onSignoutEvent(SignoutEvent paramSignoutEvent)
  {
    startLauncherActivityAndClearTask();
    this.mAnalyticsManager.signOutEvent().userInitiated();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.profile.ProfileActivity
 * JD-Core Version:    0.6.2
 */