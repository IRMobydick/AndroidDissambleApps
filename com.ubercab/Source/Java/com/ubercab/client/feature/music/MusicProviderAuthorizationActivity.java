package com.ubercab.client.feature.music;

import android.content.Intent;
import android.os.Bundle;
import com.squareup.otto.Subscribe;
import com.ubercab.client.core.app.RiderPublicActivity;
import com.ubercab.client.feature.music.event.CancelAuthorizationEvent;

public class MusicProviderAuthorizationActivity extends RiderPublicActivity
{
  public static final String EXTRA_AUTHORIZATION_CODE = "com.ubercab.AUTHORIZATION_CODE";

  private void putAuthorizationFragment()
  {
    if (findFragment(MusicProviderAuthorizationFragment.class) == null)
      putFragment(2131427504, MusicProviderAuthorizationFragment.newInstance(), true);
  }

  @Subscribe
  public void onAuthorizationResponseEvent(AuthorizationResponseEvent paramAuthorizationResponseEvent)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("com.ubercab.AUTHORIZATION_CODE", paramAuthorizationResponseEvent.getAuthorizationCode());
    setResult(-1, localIntent);
    finish();
  }

  @Subscribe
  public void onCancelAuthorizationEvent(CancelAuthorizationEvent paramCancelAuthorizationEvent)
  {
    setResult(0, null);
    finish();
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903099);
    putAuthorizationFragment();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.music.MusicProviderAuthorizationActivity
 * JD-Core Version:    0.6.2
 */