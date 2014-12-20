package com.google.android.gms.internal;

import android.content.Context;
import android.webkit.WebSettings;

public final class hf
{
  public static String a(Context paramContext)
  {
    return WebSettings.getDefaultUserAgent(paramContext);
  }

  public static void a(Context paramContext, WebSettings paramWebSettings)
  {
    he.a(paramContext, paramWebSettings);
    paramWebSettings.setMediaPlaybackRequiresUserGesture(false);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.hf
 * JD-Core Version:    0.6.0
 */