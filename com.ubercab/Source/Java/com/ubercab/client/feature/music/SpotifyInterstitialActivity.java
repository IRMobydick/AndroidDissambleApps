package com.ubercab.client.feature.music;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import com.squareup.otto.Subscribe;
import com.ubercab.client.core.app.RiderPublicActivity;
import com.ubercab.client.core.util.AndroidUtils;
import com.ubercab.client.feature.music.event.DownloadAppEvent;
import com.ubercab.client.feature.music.event.OpenAppEvent;

public class SpotifyInterstitialActivity extends RiderPublicActivity
{
  private static final String SPOTIFY_PACKAGE_NAME = "com.spotify.music";

  private void downloadSpotify(String paramString)
  {
    Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + paramString));
    try
    {
      startActivity(localIntent);
      return;
    }
    catch (Exception localException)
    {
    }
  }

  private void openSpotify(String paramString)
  {
    Intent localIntent = getPackageManager().getLaunchIntentForPackage(paramString);
    try
    {
      startActivity(localIntent);
      return;
    }
    catch (Exception localException)
    {
    }
  }

  private void putSpotifyInterstitialFragment(boolean paramBoolean)
  {
    if (findFragment(MusicProviderOfferFragment.class) == null)
      putFragment(2131427523, SpotifyInterstitialFragment.newInstance(paramBoolean), true);
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903110);
    putSpotifyInterstitialFragment(AndroidUtils.isPackageInstalled(this, "com.spotify.music"));
  }

  @Subscribe
  public void onDowloadAppEvent(DownloadAppEvent paramDownloadAppEvent)
  {
    downloadSpotify(paramDownloadAppEvent.getPackageName());
    finish();
  }

  @Subscribe
  public void onOpenAppEvent(OpenAppEvent paramOpenAppEvent)
  {
    openSpotify(paramOpenAppEvent.getPackageName());
    finish();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.music.SpotifyInterstitialActivity
 * JD-Core Version:    0.6.2
 */