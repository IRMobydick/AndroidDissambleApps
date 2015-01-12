package com.ubercab.client.feature.music;

import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import com.squareup.otto.Bus;
import com.ubercab.client.core.app.RiderFragment;
import com.ubercab.client.feature.music.event.DownloadAppEvent;
import com.ubercab.client.feature.music.event.OpenAppEvent;
import com.ubercab.ui.UberButton;
import javax.inject.Inject;

public class SpotifyInterstitialFragment extends RiderFragment
{
  private static final String ARG_IS_APP_INSTALLED = "com.ubercab.ARG_IS_APP_INSTALLED";
  private static final String SPOTIFY = "Spotify";
  private static final String SPOTIFY_PACKAGE_NAME = "com.spotify.music";

  @Inject
  ActionBar mActionBar;
  private boolean mAppIsInstalled;

  @Inject
  Bus mBus;

  @InjectView(2131427526)
  UberButton mButtonSpotifyAction;

  static Fragment newInstance(boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("com.ubercab.ARG_IS_APP_INSTALLED", paramBoolean);
    SpotifyInterstitialFragment localSpotifyInterstitialFragment = new SpotifyInterstitialFragment();
    localSpotifyInterstitialFragment.setArguments(localBundle);
    return localSpotifyInterstitialFragment;
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mActionBar.setTitle(getString(2131558908, new Object[] { "Spotify" }).toUpperCase());
    Bundle localBundle = getArguments();
    if (localBundle != null)
      this.mAppIsInstalled = localBundle.getBoolean("com.ubercab.ARG_IS_APP_INSTALLED");
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(2130903111, paramViewGroup, false);
    ButterKnife.inject(this, localView);
    return localView;
  }

  public void onDestroyView()
  {
    super.onDestroyView();
    ButterKnife.reset(this);
  }

  @OnClick({2131427526})
  void onSpotifyActionClick()
  {
    if (this.mAppIsInstalled)
    {
      this.mBus.post(new OpenAppEvent("com.spotify.music"));
      return;
    }
    this.mBus.post(new DownloadAppEvent("com.spotify.music"));
  }

  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    if (this.mAppIsInstalled)
    {
      this.mButtonSpotifyAction.setText(getString(2131558977, new Object[] { "Spotify" }));
      return;
    }
    this.mButtonSpotifyAction.setText(getString(2131558815, new Object[] { "Spotify" }));
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.music.SpotifyInterstitialFragment
 * JD-Core Version:    0.6.2
 */