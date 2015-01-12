package com.ubercab.client.feature.music;

import android.webkit.WebView;
import butterknife.ButterKnife.Finder;

public class MusicProviderAuthorizationFragment$$ViewInjector
{
  public static void inject(ButterKnife.Finder paramFinder, MusicProviderAuthorizationFragment paramMusicProviderAuthorizationFragment, Object paramObject)
  {
    paramMusicProviderAuthorizationFragment.mWebView = ((WebView)paramFinder.findRequiredView(paramObject, 2131427505, "field 'mWebView'"));
  }

  public static void reset(MusicProviderAuthorizationFragment paramMusicProviderAuthorizationFragment)
  {
    paramMusicProviderAuthorizationFragment.mWebView = null;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.music.MusicProviderAuthorizationFragment..ViewInjector
 * JD-Core Version:    0.6.2
 */