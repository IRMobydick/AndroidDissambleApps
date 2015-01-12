package com.mobileapptracker;

import android.content.Context;
import android.webkit.WebSettings;
import android.webkit.WebView;
import java.lang.ref.WeakReference;

final class br
  implements Runnable
{
  private final WeakReference b;

  public br(Parameters paramParameters, Context paramContext)
  {
    this.b = new WeakReference(paramContext);
  }

  public final void run()
  {
    try
    {
      WebView localWebView = new WebView((Context)this.b.get());
      String str = localWebView.getSettings().getUserAgentString();
      localWebView.destroy();
      Parameters.a(this.a, str);
      return;
    }
    catch (Exception localException)
    {
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.mobileapptracker.br
 * JD-Core Version:    0.6.2
 */