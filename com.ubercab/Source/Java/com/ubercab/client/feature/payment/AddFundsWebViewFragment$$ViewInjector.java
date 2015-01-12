package com.ubercab.client.feature.payment;

import android.webkit.WebView;
import android.widget.ProgressBar;
import butterknife.ButterKnife.Finder;

public class AddFundsWebViewFragment$$ViewInjector
{
  public static void inject(ButterKnife.Finder paramFinder, AddFundsWebViewFragment paramAddFundsWebViewFragment, Object paramObject)
  {
    paramAddFundsWebViewFragment.mProgressBar = ((ProgressBar)paramFinder.findRequiredView(paramObject, 2131427617, "field 'mProgressBar'"));
    paramAddFundsWebViewFragment.mWebView = ((WebView)paramFinder.findRequiredView(paramObject, 2131427616, "field 'mWebView'"));
  }

  public static void reset(AddFundsWebViewFragment paramAddFundsWebViewFragment)
  {
    paramAddFundsWebViewFragment.mProgressBar = null;
    paramAddFundsWebViewFragment.mWebView = null;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.payment.AddFundsWebViewFragment..ViewInjector
 * JD-Core Version:    0.6.2
 */