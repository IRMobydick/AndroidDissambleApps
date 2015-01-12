package com.ubercab.client.core.vendor.facebook;

import android.webkit.WebView;
import butterknife.ButterKnife.Finder;

public class FacebookAuthorizationFragment$$ViewInjector
{
  public static void inject(ButterKnife.Finder paramFinder, FacebookAuthorizationFragment paramFacebookAuthorizationFragment, Object paramObject)
  {
    paramFacebookAuthorizationFragment.mWebView = ((WebView)paramFinder.findRequiredView(paramObject, 2131427423, "field 'mWebView'"));
  }

  public static void reset(FacebookAuthorizationFragment paramFacebookAuthorizationFragment)
  {
    paramFacebookAuthorizationFragment.mWebView = null;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.vendor.facebook.FacebookAuthorizationFragment..ViewInjector
 * JD-Core Version:    0.6.2
 */