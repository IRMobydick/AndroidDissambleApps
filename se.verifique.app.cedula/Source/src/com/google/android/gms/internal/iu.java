package com.google.android.gms.internal;

import android.text.TextUtils;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.net.URI;
import java.net.URISyntaxException;

public class iu extends WebViewClient
{
  private final String a = b(paramString);
  private boolean b = false;
  private final hk c;
  private final ez d;

  public iu(ez paramez, hk paramhk, String paramString)
  {
    this.c = paramhk;
    this.d = paramez;
  }

  private String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString));
    while (true)
    {
      return paramString;
      try
      {
        if (!paramString.endsWith("/"))
          continue;
        String str = paramString.substring(0, -1 + paramString.length());
        paramString = str;
      }
      catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
      {
        hi.b(localIndexOutOfBoundsException.getMessage());
      }
    }
  }

  protected boolean a(String paramString)
  {
    int i = 0;
    String str1 = b(paramString);
    if (TextUtils.isEmpty(str1));
    while (true)
    {
      return i;
      try
      {
        URI localURI1 = new URI(str1);
        if ("passback".equals(localURI1.getScheme()))
        {
          hi.a("Passback received");
          this.d.b();
          i = 1;
          continue;
        }
        if (TextUtils.isEmpty(this.a))
          continue;
        URI localURI2 = new URI(this.a);
        String str2 = localURI2.getHost();
        String str3 = localURI1.getHost();
        String str4 = localURI2.getPath();
        String str5 = localURI1.getPath();
        if ((!kt.a(str2, str3)) || (!kt.a(str4, str5)))
          continue;
        hi.a("Passback received");
        this.d.b();
        i = 1;
      }
      catch (URISyntaxException localURISyntaxException)
      {
        hi.b(localURISyntaxException.getMessage());
      }
    }
  }

  public void onLoadResource(WebView paramWebView, String paramString)
  {
    hi.a("JavascriptAdWebViewClient::onLoadResource: " + paramString);
    if (!a(paramString))
      this.c.f().onLoadResource(this.c, paramString);
  }

  public void onPageFinished(WebView paramWebView, String paramString)
  {
    hi.a("JavascriptAdWebViewClient::onPageFinished: " + paramString);
    if (!this.b)
    {
      this.d.a();
      this.b = true;
    }
  }

  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    hi.a("JavascriptAdWebViewClient::shouldOverrideUrlLoading: " + paramString);
    if (a(paramString))
      hi.a("shouldOverrideUrlLoading: received passback url");
    for (boolean bool = true; ; bool = this.c.f().shouldOverrideUrlLoading(this.c, paramString))
      return bool;
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.iu
 * JD-Core Version:    0.6.0
 */