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

@ez
public class gy extends gw
{
  public gy(gv paramgv, boolean paramBoolean)
  {
    super(paramgv, paramBoolean);
  }

  protected WebResourceResponse d(Context paramContext, String paramString1, String paramString2)
    throws IOException
  {
    HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL(paramString2).openConnection();
    try
    {
      gj.a(paramContext, paramString1, true, localHttpURLConnection, true);
      localHttpURLConnection.addRequestProperty("Cache-Control", "max-stale=3600");
      localHttpURLConnection.connect();
      WebResourceResponse localWebResourceResponse = new WebResourceResponse("application/javascript", "UTF-8", new ByteArrayInputStream(gj.a(new InputStreamReader(localHttpURLConnection.getInputStream())).getBytes("UTF-8")));
      return localWebResourceResponse;
    }
    finally
    {
      localHttpURLConnection.disconnect();
    }
  }

  public WebResourceResponse shouldInterceptRequest(WebView paramWebView, String paramString)
  {
    try
    {
      if (!"mraid.js".equalsIgnoreCase(new File(paramString).getName()))
        return super.shouldInterceptRequest(paramWebView, paramString);
      if (!(paramWebView instanceof gv))
      {
        gs.W("Tried to intercept request from a WebView that wasn't an AdWebView.");
        return super.shouldInterceptRequest(paramWebView, paramString);
      }
      gv localgv = (gv)paramWebView;
      localgv.du().bX();
      if (localgv.Y().og)
      {
        gs.V("shouldInterceptRequest(https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/mraid/v2/mraid_app_interstitial.js)");
        return d(localgv.getContext(), this.md.dx().wD, "https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/mraid/v2/mraid_app_interstitial.js");
      }
      if (localgv.dy())
      {
        gs.V("shouldInterceptRequest(https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/mraid/v2/mraid_app_expanded_banner.js)");
        return d(localgv.getContext(), this.md.dx().wD, "https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/mraid/v2/mraid_app_expanded_banner.js");
      }
      gs.V("shouldInterceptRequest(https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/mraid/v2/mraid_app_banner.js)");
      WebResourceResponse localWebResourceResponse = d(localgv.getContext(), this.md.dx().wD, "https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/mraid/v2/mraid_app_banner.js");
      return localWebResourceResponse;
    }
    catch (IOException localIOException)
    {
      gs.W("Could not fetch MRAID JS. " + localIOException.getMessage());
    }
    return super.shouldInterceptRequest(paramWebView, paramString);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.gy
 * JD-Core Version:    0.6.2
 */