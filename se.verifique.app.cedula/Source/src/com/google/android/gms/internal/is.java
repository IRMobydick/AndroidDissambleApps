package com.google.android.gms.internal;

import android.content.Context;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class is extends hm
{
  public is(hk paramhk, boolean paramBoolean)
  {
    super(paramhk, paramBoolean);
  }

  protected WebResourceResponse a(Context paramContext, String paramString1, String paramString2)
  {
    HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL(paramString2).openConnection();
    try
    {
      gw.a(paramContext, paramString1, true, localHttpURLConnection);
      localHttpURLConnection.connect();
      WebResourceResponse localWebResourceResponse = new WebResourceResponse("application/javascript", "UTF-8", new ByteArrayInputStream(gw.a(new InputStreamReader(localHttpURLConnection.getInputStream())).getBytes("UTF-8")));
      return localWebResourceResponse;
    }
    finally
    {
      localHttpURLConnection.disconnect();
    }
    throw localObject;
  }

  public WebResourceResponse shouldInterceptRequest(WebView paramWebView, String paramString)
  {
    Object localObject;
    try
    {
      if (!"mraid.js".equalsIgnoreCase(new File(paramString).getName()))
      {
        localObject = super.shouldInterceptRequest(paramWebView, paramString);
      }
      else if (!(paramWebView instanceof hk))
      {
        hi.e("Tried to intercept request from a WebView that wasn't an AdWebView.");
        localObject = super.shouldInterceptRequest(paramWebView, paramString);
      }
      else
      {
        hk localhk = (hk)paramWebView;
        localhk.f().c();
        if (localhk.e().f)
        {
          hi.d("shouldInterceptRequest(http://media.admob.com/mraid/v1/mraid_app_interstitial.js)");
          localObject = a(localhk.getContext(), this.a.h().c, "http://media.admob.com/mraid/v1/mraid_app_interstitial.js");
        }
        else if (localhk.i())
        {
          hi.d("shouldInterceptRequest(http://media.admob.com/mraid/v1/mraid_app_expanded_banner.js)");
          localObject = a(localhk.getContext(), this.a.h().c, "http://media.admob.com/mraid/v1/mraid_app_expanded_banner.js");
        }
        else
        {
          hi.d("shouldInterceptRequest(http://media.admob.com/mraid/v1/mraid_app_banner.js)");
          WebResourceResponse localWebResourceResponse = a(localhk.getContext(), this.a.h().c, "http://media.admob.com/mraid/v1/mraid_app_banner.js");
          localObject = localWebResourceResponse;
        }
      }
    }
    catch (IOException localIOException)
    {
      hi.e("Could not fetching MRAID JS. " + localIOException.getMessage());
      localObject = super.shouldInterceptRequest(paramWebView, paramString);
    }
    return (WebResourceResponse)localObject;
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.is
 * JD-Core Version:    0.6.0
 */