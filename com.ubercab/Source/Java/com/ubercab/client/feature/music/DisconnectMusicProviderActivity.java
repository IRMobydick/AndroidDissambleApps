package com.ubercab.client.feature.music;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.squareup.otto.Subscribe;
import com.ubercab.client.core.app.RiderPublicActivity;
import com.ubercab.client.core.network.RiderClient;
import com.ubercab.library.ui.ConfirmDialogFragment;
import javax.inject.Inject;

public class DisconnectMusicProviderActivity extends RiderPublicActivity
{
  private static final String EXTRA_MUSIC_PROVIDER_ID = "com.ubercab.MUSIC_PROVIDER_ID";
  private static final String EXTRA_MUSIC_PROVIDER_NAME = "com.ubercab.MUSIC_PROVIDER_NAME";
  private static final int REQUEST_CODE_CONFIRM_DISCONNECT = 1;

  @Inject
  ActionBar mActionBar;
  private String mProviderId;
  private String mProviderName;

  @Inject
  RiderClient mRiderClient;

  public static Intent newIntent(Context paramContext, String paramString1, String paramString2)
  {
    Intent localIntent = new Intent(paramContext, DisconnectMusicProviderActivity.class);
    localIntent.putExtra("com.ubercab.MUSIC_PROVIDER_ID", paramString1);
    localIntent.putExtra("com.ubercab.MUSIC_PROVIDER_NAME", paramString2);
    return localIntent;
  }

  private void putDisconnectMusicProviderFragment(String paramString)
  {
    if (findFragment(DisconnectMusicProviderFragment.class) == null)
      putFragment(2131427511, DisconnectMusicProviderFragment.newInstance(paramString), true);
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903103);
    Bundle localBundle = getIntent().getExtras();
    if (localBundle != null)
    {
      this.mProviderId = localBundle.getString("com.ubercab.MUSIC_PROVIDER_ID");
      this.mProviderName = localBundle.getString("com.ubercab.MUSIC_PROVIDER_NAME");
      this.mActionBar.setTitle(this.mProviderName.toUpperCase());
      putDisconnectMusicProviderFragment(this.mProviderName);
    }
  }

  public void onDialogResult(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    if ((paramInt1 == 1) && (paramInt2 == -1))
    {
      this.mRiderClient.deleteThirdPartyIdentity(this.mProviderId);
      finish();
    }
  }

  @Subscribe
  public void onDisconnectMusicProviderEvent(DisconnectMusicProviderEvent paramDisconnectMusicProviderEvent)
  {
    String str = getString(2131558811);
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = this.mProviderName;
    ConfirmDialogFragment.show(this, 1, str, getString(2131558810, arrayOfObject), getString(2131558809), getString(2131558467));
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.music.DisconnectMusicProviderActivity
 * JD-Core Version:    0.6.2
 */