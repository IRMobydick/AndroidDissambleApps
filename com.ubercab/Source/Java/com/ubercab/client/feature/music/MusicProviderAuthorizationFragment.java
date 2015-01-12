package com.ubercab.client.feature.music;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.net.Uri;
import android.net.Uri.Builder;
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
import com.ubercab.client.feature.music.event.CancelAuthorizationEvent;
import com.ubercab.common.base.Joiner;
import com.ubercab.library.app.UberFragment;
import javax.inject.Inject;

public class MusicProviderAuthorizationFragment extends UberFragment
  implements DialogInterface.OnCancelListener
{
  private static final String AUTHORITY = "accounts.spotify.com";
  private static final String AUTH_REDIRECT_URI = "uber://spotify/auth";
  private static final String AUTH_RESPONSE_PARAM = "code";
  private static final String AUTH_RESPONSE_TYPE = "code";
  private static final String[] AUTH_SCOPES = { "user-library-read", "playlist-read-private", "streaming", "user-read-private", "user-trial-start" };
  private static final String AUTH_UTM_CAMPAIGN = "acquisition_uber_all";
  private static final String AUTH_UTM_CONTENT = "all501433";
  private static final String AUTH_UTM_MEDIUM = "growth_acquisition";
  private static final String AUTH_UTM_MOBILE = "mobile";
  private static final String AUTH_UTM_SOURCE = "uber";
  private static final String PARAM_CLIENT_ID = "client_id";
  private static final String PARAM_REDIRECT_URI = "redirect_uri";
  private static final String PARAM_RESPONSE_TYPE = "response_type";
  private static final String PARAM_SCOPES = "scope";
  private static final String PARAM_UTM_CAMPAIGN = "utm_campaign";
  private static final String PARAM_UTM_CONTENT = "utm_content";
  private static final String PARAM_UTM_MEDIUM = "utm_medium";
  private static final String PARAM_UTM_SOURCE = "utm_source";
  private static final String PARAM_UTM_TERM = "utm_term";
  private static final String PATH = "authorize";
  private static final String SCHEME = "https";

  @Inject
  Bus mBus;

  @InjectView(2131427505)
  WebView mWebView;

  private void loadWebView()
  {
    this.mWebView.getSettings().setJavaScriptEnabled(true);
    WebViewClient local1 = new WebViewClient()
    {
      public void onPageFinished(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        if (MusicProviderAuthorizationFragment.this.isAdded())
        {
          MusicProviderAuthorizationFragment.this.mWebView.setVisibility(0);
          MusicProviderAuthorizationFragment.this.hideLoadingDialog();
        }
      }

      public boolean shouldOverrideUrlLoading(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        return MusicProviderAuthorizationFragment.this.shouldOverrideUrlLoading(paramAnonymousString);
      }
    };
    this.mWebView.setWebViewClient(local1);
    String str = new Uri.Builder().scheme("https").authority("accounts.spotify.com").appendPath("authorize").appendQueryParameter("client_id", getString(2131559306)).appendQueryParameter("response_type", "code").appendQueryParameter("redirect_uri", "uber://spotify/auth").appendQueryParameter("scope", Joiner.on(" ").join(AUTH_SCOPES)).appendQueryParameter("utm_source", "uber").appendQueryParameter("utm_medium", "growth_acquisition").appendQueryParameter("utm_campaign", "acquisition_uber_all").appendQueryParameter("utm_content", "all501433").appendQueryParameter("utm_term", "mobile").build().toString();
    showLoadingDialog(getString(2131558909), this);
    this.mWebView.loadUrl(str);
  }

  static MusicProviderAuthorizationFragment newInstance()
  {
    return new MusicProviderAuthorizationFragment();
  }

  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.mBus.post(new CancelAuthorizationEvent());
    this.mWebView.stopLoading();
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(2130903100, paramViewGroup, false);
    ButterKnife.inject(this, localView);
    return localView;
  }

  public void onDestroyView()
  {
    super.onDestroyView();
    ButterKnife.reset(this);
  }

  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    loadWebView();
  }

  boolean shouldOverrideUrlLoading(String paramString)
  {
    if (paramString.startsWith("uber://spotify/auth"))
    {
      String str = Uri.parse(paramString).getQueryParameter("code");
      this.mBus.post(new AuthorizationResponseEvent(str));
      return true;
    }
    return false;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.music.MusicProviderAuthorizationFragment
 * JD-Core Version:    0.6.2
 */