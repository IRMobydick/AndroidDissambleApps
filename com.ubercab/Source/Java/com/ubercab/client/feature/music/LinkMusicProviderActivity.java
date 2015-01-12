package com.ubercab.client.feature.music;

import android.os.Bundle;
import com.ubercab.client.core.app.RiderPublicActivity;

public class LinkMusicProviderActivity extends RiderPublicActivity
{
  private void putLinkMusicProviderFragment()
  {
    if (findFragment(LinkMusicProviderFragment.class) == null)
      putFragment(2131427517, LinkMusicProviderFragment.newInstance(), true);
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903106);
    putLinkMusicProviderFragment();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.music.LinkMusicProviderActivity
 * JD-Core Version:    0.6.2
 */