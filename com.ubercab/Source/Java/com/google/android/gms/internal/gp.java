package com.google.android.gms.internal;

import android.content.Context;
import android.webkit.WebSettings;

@ez
public final class gp
{
  public static void a(Context paramContext, WebSettings paramWebSettings)
  {
    gn.a(paramContext, paramWebSettings);
    paramWebSettings.setMediaPlaybackRequiresUserGesture(false);
  }

  public static String getDefaultUserAgent(Context paramContext)
  {
    return WebSettings.getDefaultUserAgent(paramContext);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.gp
 * JD-Core Version:    0.6.2
 */