package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Resources;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import java.util.Map;

@ez
public final class ce
  implements by
{
  private static int a(DisplayMetrics paramDisplayMetrics, Map<String, String> paramMap, String paramString, int paramInt)
  {
    String str = (String)paramMap.get(paramString);
    if (str != null);
    try
    {
      int i = gr.a(paramDisplayMetrics, Integer.parseInt(str));
      paramInt = i;
      return paramInt;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      gs.W("Could not parse " + paramString + " in a video GMSG: " + str);
    }
    return paramInt;
  }

  public void a(gv paramgv, Map<String, String> paramMap)
  {
    String str1 = (String)paramMap.get("action");
    if (str1 == null)
    {
      gs.W("Action missing from video GMSG.");
      return;
    }
    dk localdk = paramgv.dt();
    if (localdk == null)
    {
      gs.W("Could not get ad overlay for a video GMSG.");
      return;
    }
    boolean bool1 = "new".equalsIgnoreCase(str1);
    boolean bool2 = "position".equalsIgnoreCase(str1);
    if ((bool1) || (bool2))
    {
      DisplayMetrics localDisplayMetrics1 = paramgv.getContext().getResources().getDisplayMetrics();
      int i = a(localDisplayMetrics1, paramMap, "x", 0);
      int j = a(localDisplayMetrics1, paramMap, "y", 0);
      int k = a(localDisplayMetrics1, paramMap, "w", -1);
      int m = a(localDisplayMetrics1, paramMap, "h", -1);
      if ((bool1) && (localdk.bV() == null))
      {
        localdk.c(i, j, k, m);
        return;
      }
      localdk.b(i, j, k, m);
      return;
    }
    do localdo = localdk.bV();
    if (localdo == null)
    {
      do.a(paramgv, "no_video_view", null);
      return;
    }
    if ("click".equalsIgnoreCase(str1))
    {
      DisplayMetrics localDisplayMetrics2 = paramgv.getContext().getResources().getDisplayMetrics();
      int n = a(localDisplayMetrics2, paramMap, "x", 0);
      int i1 = a(localDisplayMetrics2, paramMap, "y", 0);
      long l = SystemClock.uptimeMillis();
      MotionEvent localMotionEvent = MotionEvent.obtain(l, l, 0, n, i1, 0);
      localdo.b(localMotionEvent);
      localMotionEvent.recycle();
      return;
    }
    if ("controls".equalsIgnoreCase(str1))
    {
      String str3 = (String)paramMap.get("enabled");
      if (str3 == null)
      {
        gs.W("Enabled parameter missing from controls video GMSG.");
        return;
      }
      localdo.q(Boolean.parseBoolean(str3));
      return;
    }
    if ("currentTime".equalsIgnoreCase(str1))
    {
      String str2 = (String)paramMap.get("time");
      if (str2 == null)
      {
        gs.W("Time parameter missing from currentTime video GMSG.");
        return;
      }
      try
      {
        localdo.seekTo((int)(1000.0F * Float.parseFloat(str2)));
        return;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        gs.W("Could not parse time parameter from currentTime video GMSG: " + str2);
        return;
      }
    }
    if ("hide".equalsIgnoreCase(str1))
    {
      localdo.setVisibility(4);
      return;
    }
    if ("load".equalsIgnoreCase(str1))
    {
      localdo.ch();
      return;
    }
    if ("pause".equalsIgnoreCase(str1))
    {
      localdo.pause();
      return;
    }
    if ("play".equalsIgnoreCase(str1))
    {
      localdo.play();
      return;
    }
    if ("show".equalsIgnoreCase(str1))
    {
      localdo.setVisibility(0);
      return;
    }
    if ("src".equalsIgnoreCase(str1))
    {
      localdo.C((String)paramMap.get("src"));
      return;
    }
    gs.W("Unknown video action: " + str1);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ce
 * JD-Core Version:    0.6.2
 */