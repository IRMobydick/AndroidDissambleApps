package com.ubercab.client.feature.payment;

import android.app.ActionBar;
import android.app.Activity;
import android.graphics.Bitmap;
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
import org.apache.http.util.EncodingUtils;

public class AddFundsWebViewFragment extends RiderFragment
{
  private static final String ARG_POST_DATA = "post_data";
  private static final String ARG_TITLE = "title";
  private static final String ARG_URL = "url";
  private static final String CALLBACK_TXN_SUCCESS = "TXN_SUCCESS";
  private static final String ENCODING_BASE_64 = "base64";
  private static final String URL_TRANSACTION_COMPLETE_PREFIX = "https://native.uber.com/add_funds_response";

  @Inject
  ActionBar mActionBar;
  private String mPostData;

  @InjectView(2131427617)
  ProgressBar mProgressBar;
  private String mTitle;
  private String mUrl;

  @InjectView(2131427616)
  WebView mWebView;

  private void loadWebView()
  {
    this.mWebView.getSettings().setJavaScriptEnabled(true);
    WebViewClient local1 = new WebViewClient()
    {
      public void onPageFinished(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        if (AddFundsWebViewFragment.this.isResumed())
          AddFundsWebViewFragment.this.mProgressBar.setVisibility(8);
      }

      public void onPageStarted(WebView paramAnonymousWebView, String paramAnonymousString, Bitmap paramAnonymousBitmap)
      {
        if (AddFundsWebViewFragment.this.isResumed())
          AddFundsWebViewFragment.this.mProgressBar.setVisibility(0);
      }

      public boolean shouldOverrideUrlLoading(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        if (paramAnonymousString.startsWith("https://native.uber.com/add_funds_response"))
        {
          if (!paramAnonymousString.contains("TXN_SUCCESS"))
            break label46;
          AddFundsWebViewFragment.this.showToast(AddFundsWebViewFragment.this.getString(2131558433));
        }
        while (true)
        {
          AddFundsWebViewFragment.this.getActivity().finish();
          return false;
          label46: AddFundsWebViewFragment.this.showToast(AddFundsWebViewFragment.this.getString(2131558432));
        }
      }
    };
    this.mWebView.setWebViewClient(local1);
    if (this.mUrl != null)
    {
      this.mWebView.postUrl(this.mUrl, EncodingUtils.getBytes(this.mPostData, "base64"));
      return;
    }
    this.mProgressBar.setVisibility(8);
    showToast(getString(2131558845));
  }

  public static AddFundsWebViewFragment newInstance(String paramString1, String paramString2, String paramString3)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("post_data", paramString3);
    localBundle.putString("title", paramString1);
    localBundle.putString("url", paramString2);
    AddFundsWebViewFragment localAddFundsWebViewFragment = new AddFundsWebViewFragment();
    localAddFundsWebViewFragment.setArguments(localBundle);
    return localAddFundsWebViewFragment;
  }

  protected ImpressionEventName getImpressionAnalyticsName()
  {
    return RiderEvents.Impression.WALLET_FUND_3DS_ADD;
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Bundle localBundle = getArguments();
    if (localBundle != null)
    {
      this.mPostData = localBundle.getString("post_data");
      this.mTitle = localBundle.getString("title");
      this.mUrl = localBundle.getString("url");
    }
    this.mActionBar.setTitle(this.mTitle);
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(2130903139, paramViewGroup, false);
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
 * Qualified Name:     com.ubercab.client.feature.payment.AddFundsWebViewFragment
 * JD-Core Version:    0.6.2
 */