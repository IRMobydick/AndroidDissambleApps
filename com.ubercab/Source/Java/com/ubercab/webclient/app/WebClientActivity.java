package com.ubercab.webclient.app;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebSettings.RenderPriority;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.ImageView;
import com.inauth.mme.InAuthManager;
import com.mobileapptracker.MobileAppTracker;
import com.ubercab.client.core.app.RiderApplication;
import com.ubercab.client.core.ui.AnimationListenerAdapter;
import com.ubercab.library.util.DeviceUtils;
import com.ubercab.webclient.utils.AndroidUtils;
import com.ubercab.webclient.utils.HttpUtils;
import com.ubercab.webclient.utils.UberUtils;
import java.io.File;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import javax.inject.Inject;
import org.json.JSONObject;

public class WebClientActivity extends Activity
  implements View.OnClickListener
{
  private static final String JS_EVENT_BACK_BUTTON = "backbutton";
  private static final String JS_EVENT_PAUSE = "pause";
  private static final String JS_EVENT_RESUME = "resume";
  private static final String JS_OBJECT_NAME = "uberNative";
  private static final int LOAD_TIMEOUT = 45000;
  private static final int MAX_TRIES = 3;
  private static final String WWW_COOKIE_TOKEN_NAME = "token";
  private static final String WWW_GATEWAY_INSTANCE = "Uber.Gateway";
  private ImageButton mButtonRefresh;
  private ImageView mImageViewSplash;

  @Inject
  InAuthManager mInAuthManager;
  private int mLoadAttempts;

  @Inject
  MobileAppTracker mMobileAppTracker;
  private WebView mWebView;
  private boolean mWebViewIsLoaded;

  private void checkLoadingState()
  {
    if (this.mWebViewIsLoaded)
      return;
    this.mWebView.stopLoading();
    if (this.mLoadAttempts >= 3)
    {
      this.mLoadAttempts = 0;
      showNetworkError();
      return;
    }
    this.mLoadAttempts = (1 + this.mLoadAttempts);
    loadWebView();
  }

  private void dispatchEvent(String paramString)
  {
    String str = String.format("javascript:%s.dispatchEvent('%s')", new Object[] { "Uber.Gateway", paramString });
    this.mWebView.loadUrl(str);
  }

  private void handleJsEvent(String paramString)
  {
    if (paramString.equals("backbutton"))
    {
      if (this.mWebView.canGoBack())
        this.mWebView.goBack();
    }
    else
      return;
    finish();
  }

  private boolean hasDataConnection()
  {
    NetworkInfo localNetworkInfo = ((ConnectivityManager)getSystemService("connectivity")).getActiveNetworkInfo();
    return (localNetworkInfo != null) && (localNetworkInfo.isConnectedOrConnecting());
  }

  @TargetApi(19)
  private void initWebClient()
  {
    String str1 = getDir("database", 0).getPath();
    WebSettings localWebSettings = this.mWebView.getSettings();
    localWebSettings.setDatabaseEnabled(true);
    localWebSettings.setDomStorageEnabled(true);
    localWebSettings.setJavaScriptEnabled(true);
    localWebSettings.setGeolocationEnabled(true);
    localWebSettings.setCacheMode(-1);
    localWebSettings.setGeolocationDatabasePath(str1);
    this.mWebView.setScrollBarStyle(33554432);
    if (!AndroidUtils.hasKitKat())
      localWebSettings.setRenderPriority(WebSettings.RenderPriority.HIGH);
    WebChromeClient local1 = new WebChromeClient()
    {
      public void onGeolocationPermissionsShowPrompt(String paramAnonymousString, GeolocationPermissions.Callback paramAnonymousCallback)
      {
        paramAnonymousCallback.invoke(paramAnonymousString, true, false);
      }
    };
    WebViewClient local2 = new WebViewClient()
    {
      public boolean shouldOverrideUrlLoading(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        if (!UberUtils.isUberUrl(paramAnonymousString))
        {
          WebClientActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(paramAnonymousString)));
          return true;
        }
        return false;
      }
    };
    final String str2 = DeviceUtils.getDeviceId(this);
    final HashMap localHashMap = new HashMap();
    String str3 = this.mMobileAppTracker.getGoogleAdvertisingId();
    if (!TextUtils.isEmpty(str3))
      localHashMap.put("googleAdvertisingId", str3);
    String str4 = this.mInAuthManager.getInAuthPID();
    if (!TextUtils.isEmpty(str4))
      localHashMap.put("authId", str4);
    UberJsInterface local3 = new UberJsInterface(AndroidUtils.getLanguageCode())
    {
      @JavascriptInterface
      public String getDeviceInfo()
        throws Exception
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("app", "client");
        localJSONObject.put("device", "android");
        localJSONObject.put("version", "3.23.2");
        localJSONObject.put("language", this.val$language);
        localJSONObject.put("deviceModel", Build.MODEL);
        localJSONObject.put("deviceOS", Build.VERSION.RELEASE);
        localJSONObject.put("deviceId", str2);
        if (!localHashMap.isEmpty())
          localJSONObject.put("deviceIds", new JSONObject(localHashMap));
        return localJSONObject.toString();
      }

      @JavascriptInterface
      public void handleEvent(final String paramAnonymousString)
      {
        new Thread()
        {
          public void run()
          {
            WebClientActivity.this.runOnUiThread(new Thread()
            {
              public void run()
              {
                WebClientActivity.this.handleJsEvent(WebClientActivity.3.2.this.val$eventName);
              }
            });
          }
        }
        .start();
      }

      @JavascriptInterface
      public void load()
      {
        new Thread()
        {
          public void run()
          {
            WebClientActivity.this.runOnUiThread(new Thread()
            {
              public void run()
              {
                WebClientActivity.this.showWebView();
              }
            });
          }
        }
        .start();
      }
    };
    this.mWebView.setWebChromeClient(local1);
    this.mWebView.setWebViewClient(local2);
    this.mWebView.addJavascriptInterface(local3, "uberNative");
  }

  private void injectGravyToken()
  {
    String str = UberUtils.getAndClearGravyToken(this);
    if (TextUtils.isEmpty(str))
      return;
    CookieManager localCookieManager = CookieManager.getInstance();
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.add(1, 1);
    localCookieManager.setCookie("https://m.uber.com", HttpUtils.formatCookie("token", str, localCalendar.getTime()));
    syncCookies();
  }

  private void loadWebView()
  {
    if (!hasDataConnection())
    {
      showNetworkError();
      return;
    }
    this.mWebView.loadUrl("https://m.uber.com");
    this.mButtonRefresh.setVisibility(8);
    startTimeoutTracking();
  }

  private void showNetworkError()
  {
    this.mButtonRefresh.setVisibility(0);
  }

  private void showWebView()
  {
    if (this.mWebViewIsLoaded)
      return;
    this.mWebView.setVisibility(0);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setInterpolator(new AccelerateInterpolator());
    localAlphaAnimation.setDuration(750L);
    localAlphaAnimation.setAnimationListener(new AnimationListenerAdapter()
    {
      public void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        WebClientActivity.this.mImageViewSplash.setVisibility(8);
      }
    });
    this.mImageViewSplash.setAnimation(localAlphaAnimation);
    this.mWebViewIsLoaded = true;
  }

  private void startTimeoutTracking()
  {
    new Timer().schedule(new TimerTask()
    {
      public void run()
      {
        WebClientActivity.this.runOnUiThread(new Runnable()
        {
          public void run()
          {
            WebClientActivity.this.checkLoadingState();
          }
        });
      }
    }
    , 45000L);
  }

  private void syncCookies()
  {
    CookieSyncManager localCookieSyncManager = CookieSyncManager.getInstance();
    if (localCookieSyncManager != null)
      localCookieSyncManager.sync();
  }

  public void onBackPressed()
  {
    if (!this.mWebViewIsLoaded)
    {
      super.onBackPressed();
      return;
    }
    dispatchEvent("backbutton");
  }

  public void onClick(View paramView)
  {
    loadWebView();
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    CookieSyncManager.createInstance(this);
    setContentView(2130903231);
    RiderApplication.get(this).inject(this);
    this.mWebView = ((WebView)findViewById(2131427929));
    this.mImageViewSplash = ((ImageView)findViewById(2131427930));
    this.mButtonRefresh = ((ImageButton)findViewById(2131427931));
    this.mButtonRefresh.setOnClickListener(this);
    initWebClient();
    injectGravyToken();
    loadWebView();
  }

  @TargetApi(11)
  protected void onPause()
  {
    super.onPause();
    syncCookies();
    dispatchEvent("pause");
    if (AndroidUtils.hasHoneycomb())
      this.mWebView.onPause();
  }

  @TargetApi(11)
  protected void onResume()
  {
    super.onResume();
    syncCookies();
    if (AndroidUtils.hasHoneycomb())
      this.mWebView.onResume();
    dispatchEvent("resume");
  }

  public class UberJsInterface
  {
    public UberJsInterface()
    {
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.webclient.app.WebClientActivity
 * JD-Core Version:    0.6.2
 */