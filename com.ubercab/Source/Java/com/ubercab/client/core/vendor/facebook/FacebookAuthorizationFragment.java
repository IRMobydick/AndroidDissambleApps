package com.ubercab.client.core.vendor.facebook;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.squareup.otto.Bus;
import com.ubercab.client.core.app.RiderFragment;
import javax.inject.Inject;

public class FacebookAuthorizationFragment extends RiderFragment
{
  private static final String URL = "url";

  @Inject
  Bus mBus;
  private String mUrl;

  @InjectView(2131427423)
  WebView mWebView;

  private static String[] getPairs(String paramString)
  {
    return paramString.split("\\?|#|&");
  }

  private void loadWebView()
  {
    this.mWebView.getSettings().setJavaScriptEnabled(true);
    WebViewClient local1 = new WebViewClient()
    {
      public void onPageFinished(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        if (FacebookAuthorizationFragment.this.isResumed())
        {
          FacebookAuthorizationFragment.this.hideLoadingDialog();
          FacebookAuthorizationFragment.this.getView().setVisibility(0);
        }
      }

      public boolean shouldOverrideUrlLoading(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        return FacebookAuthorizationFragment.this.shouldOverrideUrlLoading(paramAnonymousString);
      }
    };
    this.mWebView.setWebViewClient(local1);
    showLoadingDialogSticky(getString(2131558882), null);
    this.mWebView.loadUrl(this.mUrl);
  }

  public static FacebookAuthorizationFragment newInstance(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("url", paramString);
    FacebookAuthorizationFragment localFacebookAuthorizationFragment = new FacebookAuthorizationFragment();
    localFacebookAuthorizationFragment.setArguments(localBundle);
    return localFacebookAuthorizationFragment;
  }

  private static String parseToken(String paramString)
  {
    for (String str : getPairs(paramString))
      if (str.startsWith("access_token"))
        return str.split("=")[1];
    return null;
  }

  private static long parseTokenExpiresIn(String paramString)
  {
    for (String str : getPairs(paramString))
      if (str.startsWith("expires_in"))
        return Long.parseLong(str.split("=")[1]);
    return 0L;
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Bundle localBundle = getArguments();
    if (localBundle != null)
      this.mUrl = localBundle.getString("url");
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(2130903070, paramViewGroup, false);
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

  boolean shouldOverrideUrlLoading(String paramString)
  {
    if (paramString.startsWith("https://www.facebook.com/connect/login_success.html#access_token"))
    {
      String str = parseToken(paramString);
      long l = parseTokenExpiresIn(paramString);
      this.mBus.post(new FacebookTokenEvent(str, l));
      return true;
    }
    if (paramString.startsWith("https://www.facebook.com/connect/login_success.html?error=access_denied"))
    {
      this.mBus.post(new FacebookTokenEvent());
      return true;
    }
    return false;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.vendor.facebook.FacebookAuthorizationFragment
 * JD-Core Version:    0.6.2
 */