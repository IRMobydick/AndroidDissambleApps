package com.google.android.gms.internal;

import android.text.TextUtils;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.common.internal.n;
import java.net.URI;
import java.net.URISyntaxException;

@ez
public class ha extends WebViewClient
{
  private final gv md;
  private final String xc = Z(paramString);
  private boolean xd = false;
  private final fc xe;

  public ha(fc paramfc, gv paramgv, String paramString)
  {
    this.md = paramgv;
    this.xe = paramfc;
  }

  private String Z(String paramString)
  {
    if (TextUtils.isEmpty(paramString));
    while (true)
    {
      return paramString;
      try
      {
        if (paramString.endsWith("/"))
        {
          String str = paramString.substring(0, -1 + paramString.length());
          return str;
        }
      }
      catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
      {
        gs.T(localIndexOutOfBoundsException.getMessage());
      }
    }
    return paramString;
  }

  protected boolean Y(String paramString)
  {
    String str1 = Z(paramString);
    if (TextUtils.isEmpty(str1));
    while (true)
    {
      return false;
      try
      {
        URI localURI1 = new URI(str1);
        if ("passback".equals(localURI1.getScheme()))
        {
          gs.S("Passback received");
          this.xe.cz();
          return true;
        }
        if (!TextUtils.isEmpty(this.xc))
        {
          URI localURI2 = new URI(this.xc);
          String str2 = localURI2.getHost();
          String str3 = localURI1.getHost();
          String str4 = localURI2.getPath();
          String str5 = localURI1.getPath();
          if ((n.equal(str2, str3)) && (n.equal(str4, str5)))
          {
            gs.S("Passback received");
            this.xe.cz();
            return true;
          }
        }
      }
      catch (URISyntaxException localURISyntaxException)
      {
        gs.T(localURISyntaxException.getMessage());
      }
    }
    return false;
  }

  public void onLoadResource(WebView paramWebView, String paramString)
  {
    gs.S("JavascriptAdWebViewClient::onLoadResource: " + paramString);
    if (!Y(paramString))
      this.md.du().onLoadResource(this.md, paramString);
  }

  public void onPageFinished(WebView paramWebView, String paramString)
  {
    gs.S("JavascriptAdWebViewClient::onPageFinished: " + paramString);
    if (!this.xd)
    {
      this.xe.cy();
      this.xd = true;
    }
  }

  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    gs.S("JavascriptAdWebViewClient::shouldOverrideUrlLoading: " + paramString);
    if (Y(paramString))
    {
      gs.S("shouldOverrideUrlLoading: received passback url");
      return true;
    }
    return this.md.du().shouldOverrideUrlLoading(this.md, paramString);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ha
 * JD-Core Version:    0.6.2
 */