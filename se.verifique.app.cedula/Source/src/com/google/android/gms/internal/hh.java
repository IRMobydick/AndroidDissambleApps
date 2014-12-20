package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings.Secure;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

public final class hh
{
  public static final Handler a = new Handler(Looper.getMainLooper());

  public static int a(Context paramContext, int paramInt)
  {
    return a(paramContext.getResources().getDisplayMetrics(), paramInt);
  }

  public static int a(DisplayMetrics paramDisplayMetrics, int paramInt)
  {
    return (int)TypedValue.applyDimension(1, paramInt, paramDisplayMetrics);
  }

  public static String a(Context paramContext)
  {
    String str = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
    if ((str == null) || (a()))
      str = "emulator";
    return a(str);
  }

  public static String a(String paramString)
  {
    int i = 0;
    if (i < 2);
    while (true)
    {
      try
      {
        MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
        localMessageDigest.update(paramString.getBytes());
        Locale localLocale = Locale.US;
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = new BigInteger(1, localMessageDigest.digest());
        String str2 = String.format(localLocale, "%032X", arrayOfObject);
        str1 = str2;
        return str1;
      }
      catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
      {
        i++;
      }
      break;
      String str1 = null;
    }
  }

  public static void a(ViewGroup paramViewGroup, al paramal, String paramString)
  {
    a(paramViewGroup, paramal, paramString, -16777216, -1);
  }

  private static void a(ViewGroup paramViewGroup, al paramal, String paramString, int paramInt1, int paramInt2)
  {
    if (paramViewGroup.getChildCount() != 0);
    while (true)
    {
      return;
      Context localContext = paramViewGroup.getContext();
      TextView localTextView = new TextView(localContext);
      localTextView.setGravity(17);
      localTextView.setText(paramString);
      localTextView.setTextColor(paramInt1);
      localTextView.setBackgroundColor(paramInt2);
      FrameLayout localFrameLayout = new FrameLayout(localContext);
      localFrameLayout.setBackgroundColor(paramInt1);
      int i = a(localContext, 3);
      localFrameLayout.addView(localTextView, new FrameLayout.LayoutParams(paramal.h - i, paramal.e - i, 17));
      paramViewGroup.addView(localFrameLayout, paramal.h, paramal.e);
    }
  }

  public static void a(ViewGroup paramViewGroup, al paramal, String paramString1, String paramString2)
  {
    hi.e(paramString2);
    a(paramViewGroup, paramal, paramString1, -65536, -16777216);
  }

  public static boolean a()
  {
    return Build.DEVICE.startsWith("generic");
  }

  public static boolean b()
  {
    if (Looper.myLooper() == Looper.getMainLooper());
    for (int i = 1; ; i = 0)
      return i;
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.hh
 * JD-Core Version:    0.6.0
 */