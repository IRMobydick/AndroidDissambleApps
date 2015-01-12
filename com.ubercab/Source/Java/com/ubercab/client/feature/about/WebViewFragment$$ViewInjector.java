package com.ubercab.client.feature.about;

import android.webkit.WebView;
import android.widget.ProgressBar;
import butterknife.ButterKnife.Finder;

public class WebViewFragment$$ViewInjector
{
  public static void inject(ButterKnife.Finder paramFinder, WebViewFragment paramWebViewFragment, Object paramObject)
  {
    paramWebViewFragment.mWebView = ((WebView)paramFinder.findRequiredView(paramObject, 2131427418, "field 'mWebView'"));
    paramWebViewFragment.mProgressBarLoading = ((ProgressBar)paramFinder.findRequiredView(paramObject, 2131427419, "field 'mProgressBarLoading'"));
  }

  public static void reset(WebViewFragment paramWebViewFragment)
  {
    paramWebViewFragment.mWebView = null;
    paramWebViewFragment.mProgressBarLoading = null;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.about.WebViewFragment..ViewInjector
 * JD-Core Version:    0.6.2
 */