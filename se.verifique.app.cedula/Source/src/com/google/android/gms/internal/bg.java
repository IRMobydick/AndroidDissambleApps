package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Resources;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import java.util.Map;

public final class bg
  implements bb
{
  private static int a(DisplayMetrics paramDisplayMetrics, Map paramMap, String paramString, int paramInt)
  {
    String str = (String)paramMap.get(paramString);
    if (str != null);
    try
    {
      int i = hh.a(paramDisplayMetrics, Integer.parseInt(str));
      paramInt = i;
      return paramInt;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      while (true)
        hi.e("Could not parse " + paramString + " in a video GMSG: " + str);
    }
  }

  public void a(hk paramhk, Map paramMap)
  {
    String str1 = (String)paramMap.get("action");
    if (str1 == null)
      hi.e("Action missing from video GMSG.");
    while (true)
    {
      return;
      co localco = paramhk.d();
      if (localco == null)
      {
        hi.e("Could not get ad overlay for a video GMSG.");
        continue;
      }
      boolean bool1 = "new".equalsIgnoreCase(str1);
      boolean bool2 = "position".equalsIgnoreCase(str1);
      if ((bool1) || (bool2))
      {
        DisplayMetrics localDisplayMetrics1 = paramhk.getContext().getResources().getDisplayMetrics();
        int i = a(localDisplayMetrics1, paramMap, "x", 0);
        int j = a(localDisplayMetrics1, paramMap, "y", 0);
        int k = a(localDisplayMetrics1, paramMap, "w", -1);
        int m = a(localDisplayMetrics1, paramMap, "h", -1);
        if ((bool1) && (localco.b() == null))
        {
          localco.b(i, j, k, m);
          continue;
        }
        localco.a(i, j, k, m);
        continue;
      }
      cw localcw = localco.b();
      if (localcw == null)
      {
        cw.a(paramhk, "no_video_view", null);
        continue;
      }
      if ("click".equalsIgnoreCase(str1))
      {
        DisplayMetrics localDisplayMetrics2 = paramhk.getContext().getResources().getDisplayMetrics();
        int n = a(localDisplayMetrics2, paramMap, "x", 0);
        int i1 = a(localDisplayMetrics2, paramMap, "y", 0);
        long l = SystemClock.uptimeMillis();
        MotionEvent localMotionEvent = MotionEvent.obtain(l, l, 0, n, i1, 0);
        localcw.a(localMotionEvent);
        localMotionEvent.recycle();
        continue;
      }
      if ("controls".equalsIgnoreCase(str1))
      {
        String str3 = (String)paramMap.get("enabled");
        if (str3 == null)
        {
          hi.e("Enabled parameter missing from controls video GMSG.");
          continue;
        }
        localcw.a(Boolean.parseBoolean(str3));
        continue;
      }
      if ("currentTime".equalsIgnoreCase(str1))
      {
        String str2 = (String)paramMap.get("time");
        if (str2 == null)
        {
          hi.e("Time parameter missing from currentTime video GMSG.");
          continue;
        }
        try
        {
          localcw.a((int)(1000.0F * Float.parseFloat(str2)));
        }
        catch (NumberFormatException localNumberFormatException)
        {
          hi.e("Could not parse time parameter from currentTime video GMSG: " + str2);
        }
        continue;
      }
      if ("hide".equalsIgnoreCase(str1))
      {
        localcw.setVisibility(4);
        continue;
      }
      if ("load".equalsIgnoreCase(str1))
      {
        localcw.b();
        continue;
      }
      if ("pause".equalsIgnoreCase(str1))
      {
        localcw.c();
        continue;
      }
      if ("play".equalsIgnoreCase(str1))
      {
        localcw.d();
        continue;
      }
      if ("show".equalsIgnoreCase(str1))
      {
        localcw.setVisibility(0);
        continue;
      }
      if ("src".equalsIgnoreCase(str1))
      {
        localcw.a((String)paramMap.get("src"));
        continue;
      }
      hi.e("Unknown video action: " + str1);
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.bg
 * JD-Core Version:    0.6.0
 */