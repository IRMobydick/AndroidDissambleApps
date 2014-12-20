package com.google.android.gms.internal;

import android.content.Context;
import android.view.View;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import java.io.File;

public final class he
{
  public static void a(Context paramContext, WebSettings paramWebSettings)
  {
    paramWebSettings.setAppCachePath(paramContext.getCacheDir().getAbsolutePath());
    paramWebSettings.setAppCacheMaxSize(0L);
    paramWebSettings.setAppCacheEnabled(true);
    paramWebSettings.setDatabasePath(paramContext.getDatabasePath("com.google.android.gms.ads.db").getAbsolutePath());
    paramWebSettings.setDatabaseEnabled(true);
    paramWebSettings.setDomStorageEnabled(true);
    paramWebSettings.setDisplayZoomControls(false);
    paramWebSettings.setBuiltInZoomControls(true);
    paramWebSettings.setSupportZoom(true);
  }

  public static void a(View paramView)
  {
    paramView.setLayerType(1, null);
  }

  public static void a(Window paramWindow)
  {
    paramWindow.setFlags(16777216, 16777216);
  }

  public static void a(WebView paramWebView)
  {
    paramWebView.onPause();
  }

  public static void b(View paramView)
  {
    paramView.setLayerType(0, null);
  }

  public static void b(WebView paramWebView)
  {
    paramWebView.onResume();
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.he
 * JD-Core Version:    0.6.0
 */