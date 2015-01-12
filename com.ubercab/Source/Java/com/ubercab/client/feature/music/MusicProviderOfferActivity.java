package com.ubercab.client.feature.music;

import android.os.Bundle;
import com.ubercab.client.core.app.RiderPublicActivity;

public class MusicProviderOfferActivity extends RiderPublicActivity
{
  private void putMusicProviderOfferFragment()
  {
    if (findFragment(MusicProviderOfferFragment.class) == null)
      putFragment(2131427521, MusicProviderOfferFragment.newInstance(), true);
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903108);
    putMusicProviderOfferFragment();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.music.MusicProviderOfferActivity
 * JD-Core Version:    0.6.2
 */