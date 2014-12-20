package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class fu extends fs
{
  private static final Object a = new Object();
  private static fu b;
  private final Context c;
  private final gg d;
  private final bh e;
  private final ao f;

  fu(Context paramContext, ao paramao, bh parambh, gg paramgg)
  {
    this.c = paramContext;
    this.d = paramgg;
    this.e = parambh;
    this.f = paramao;
  }

  private static du a(Context paramContext, ao paramao, bh parambh, gg paramgg, ds paramds)
  {
    hi.a("Starting ad request from service.");
    parambh.a();
    gf localgf = new gf(paramContext);
    du localdu;
    if (localgf.l == -1)
    {
      hi.a("Device is offline.");
      localdu = new du(2);
    }
    while (true)
    {
      return localdu;
      fy localfy = new fy(paramds.g.packageName);
      if (paramds.d.d != null)
      {
        String str4 = paramds.d.d.getString("_ad");
        if (str4 != null)
        {
          localdu = fx.a(paramContext, paramds, str4);
          continue;
        }
      }
      Location localLocation = parambh.a(250L);
      String str1 = paramao.a();
      String str2 = fx.a(paramds, localgf, localLocation, paramao.b());
      if (str2 == null)
      {
        localdu = new du(0);
        continue;
      }
      ho localho = a(str2);
      hh.a.post(new fv(paramContext, paramds, localfy, localho, str1));
      gd localgd = localfy.b();
      if ((localgd == null) || (TextUtils.isEmpty(localgd.c())))
      {
        localdu = new du(localfy.a());
        continue;
      }
      String str3 = null;
      if (localgd.e())
        str3 = paramgg.a(paramds.h.packageName);
      localdu = a(paramContext, paramds.l.c, localgd.c(), str3, localgd);
    }
  }

  public static du a(Context paramContext, String paramString1, String paramString2, String paramString3, gd paramgd)
  {
    try
    {
      localgc = new gc();
      URL localURL1 = new URL(paramString2);
      l = SystemClock.elapsedRealtime();
      localURL2 = localURL1;
      i = 0;
      localHttpURLConnection = (HttpURLConnection)localURL2.openConnection();
    }
    catch (IOException localIOException)
    {
      try
      {
        gc localgc;
        long l;
        URL localURL2;
        int i;
        gw.a(paramContext, paramString1, false, localHttpURLConnection);
        if (!TextUtils.isEmpty(paramString3))
          localHttpURLConnection.addRequestProperty("x-afma-drt-cookie", paramString3);
        if ((paramgd != null) && (!TextUtils.isEmpty(paramgd.b())))
        {
          localHttpURLConnection.setDoOutput(true);
          byte[] arrayOfByte = paramgd.b().getBytes();
          localHttpURLConnection.setFixedLengthStreamingMode(arrayOfByte.length);
          BufferedOutputStream localBufferedOutputStream = new BufferedOutputStream(localHttpURLConnection.getOutputStream());
          localBufferedOutputStream.write(arrayOfByte);
          localBufferedOutputStream.close();
        }
        int j = localHttpURLConnection.getResponseCode();
        Map localMap = localHttpURLConnection.getHeaderFields();
        Object localObject1;
        if ((j >= 200) && (j < 300))
        {
          String str2 = localURL2.toString();
          String str3 = gw.a(new InputStreamReader(localHttpURLConnection.getInputStream()));
          a(str2, localMap, str3, j);
          localgc.a(str2, localMap, str3);
          du localdu4 = localgc.a(l);
          localHttpURLConnection.disconnect();
          localObject1 = localdu4;
        }
        while (true)
        {
          return localObject1;
          a(localURL2.toString(), localMap, null, j);
          if ((j >= 300) && (j < 400))
          {
            String str1 = localHttpURLConnection.getHeaderField("Location");
            if (TextUtils.isEmpty(str1))
            {
              hi.e("No location header to follow redirect.");
              du localdu3 = new du(0);
              localHttpURLConnection.disconnect();
              localObject1 = localdu3;
              continue;
            }
            localURL2 = new URL(str1);
            i++;
            if (i > 5)
            {
              hi.e("Too many redirects.");
              du localdu2 = new du(0);
              localHttpURLConnection.disconnect();
              localObject1 = localdu2;
              continue;
            }
          }
          else
          {
            hi.e("Received error HTTP response code: " + j);
            du localdu1 = new du(0);
            localHttpURLConnection.disconnect();
            localObject1 = localdu1;
            continue;
          }
          localgc.a(localMap);
          localHttpURLConnection.disconnect();
          break;
          localIOException = localIOException;
          hi.e("Error while connecting to ad server: " + localIOException.getMessage());
          localObject1 = new du(2);
        }
      }
      finally
      {
        HttpURLConnection localHttpURLConnection;
        localHttpURLConnection.disconnect();
      }
    }
    throw localObject2;
  }

  public static fu a(Context paramContext, ao paramao, bh parambh, gg paramgg)
  {
    synchronized (a)
    {
      if (b == null)
        b = new fu(paramContext.getApplicationContext(), paramao, parambh, paramgg);
      fu localfu = b;
      return localfu;
    }
  }

  private static ho a(String paramString)
  {
    return new fw(paramString);
  }

  private static void a(String paramString1, Map paramMap, String paramString2, int paramInt)
  {
    if (hi.a(2))
    {
      hi.d("Http Response: {\n  URL:\n    " + paramString1 + "\n  Headers:");
      if (paramMap != null)
      {
        Iterator localIterator1 = paramMap.keySet().iterator();
        while (localIterator1.hasNext())
        {
          String str1 = (String)localIterator1.next();
          hi.d("    " + str1 + ":");
          Iterator localIterator2 = ((List)paramMap.get(str1)).iterator();
          while (localIterator2.hasNext())
          {
            String str2 = (String)localIterator2.next();
            hi.d("      " + str2);
          }
        }
      }
      hi.d("  Body:");
      if (paramString2 != null)
        for (int i = 0; i < Math.min(paramString2.length(), 100000); i += 1000)
          hi.d(paramString2.substring(i, Math.min(paramString2.length(), i + 1000)));
      hi.d("    null");
      hi.d("  Response Code:\n    " + paramInt + "\n}");
    }
  }

  public du a(ds paramds)
  {
    return a(this.c, this.f, this.e, this.d, paramds);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.fu
 * JD-Core Version:    0.6.0
 */