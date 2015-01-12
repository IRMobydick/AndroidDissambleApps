package com.ubercab.client.feature.about;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.ubercab.client.core.app.RiderFragment;
import com.ubercab.client.core.metrics.analytics.RiderEvents.Impression;
import com.ubercab.library.metrics.analytics.event.ImpressionEventName;
import javax.inject.Inject;

public class WebViewFragment extends RiderFragment
{
  private static final String IMPRESSION_ANALYTICS_IDENTIFIER = "analytics";
  private static final String TITLE = "title";
  private static final String URL = "url";

  @Inject
  ActionBar mActionBar;
  private ImpressionEventName mImpressionAnalyticsIdentifier;

  @InjectView(2131427419)
  ProgressBar mProgressBarLoading;
  private String mTitle;
  private String mUrl;

  @InjectView(2131427418)
  WebView mWebView;

  private void loadWebView()
  {
    this.mWebView.getSettings().setJavaScriptEnabled(true);
    WebViewClient local1 = new WebViewClient()
    {
      public void onPageFinished(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        if (WebViewFragment.this.isResumed())
          WebViewFragment.this.mProgressBarLoading.setVisibility(8);
      }

      public void onPageStarted(WebView paramAnonymousWebView, String paramAnonymousString, Bitmap paramAnonymousBitmap)
      {
        if (WebViewFragment.this.isResumed())
          WebViewFragment.this.mProgressBarLoading.setVisibility(0);
      }

      public boolean shouldOverrideUrlLoading(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        if ((paramAnonymousString.startsWith("http://")) || (paramAnonymousString.startsWith("https://")))
        {
          WebViewFragment.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(paramAnonymousString)));
          return true;
        }
        return false;
      }
    };
    this.mWebView.setWebViewClient(local1);
    this.mWebView.loadUrl(this.mUrl);
  }

  public static WebViewFragment newInstance(String paramString1, String paramString2)
  {
    return newInstance(paramString1, paramString2, null);
  }

  public static WebViewFragment newInstance(String paramString1, String paramString2, ImpressionEventName paramImpressionEventName)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("title", paramString1);
    localBundle.putString("url", paramString2);
    if (paramImpressionEventName != null)
      localBundle.putString("analytics", paramImpressionEventName.name());
    WebViewFragment localWebViewFragment = new WebViewFragment();
    localWebViewFragment.setArguments(localBundle);
    return localWebViewFragment;
  }

  protected ImpressionEventName getImpressionAnalyticsName()
  {
    return this.mImpressionAnalyticsIdentifier;
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Bundle localBundle = getArguments();
    if (localBundle != null)
    {
      this.mTitle = localBundle.getString("title");
      this.mUrl = localBundle.getString("url");
      String str = localBundle.getString("analytics");
      if (str != null)
        this.mImpressionAnalyticsIdentifier = RiderEvents.Impression.valueOf(str);
    }
    this.mActionBar.setTitle(this.mTitle);
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(2130903067, paramViewGroup, false);
    ButterKnife.inject(this, localView);
    return localView;
  }

  public void onDestroy()
  {
    super.onDestroy();
    ButterKnife.reset(this);
  }

  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    loadWebView();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.about.WebViewFragment
 * JD-Core Version:    0.6.2
 */