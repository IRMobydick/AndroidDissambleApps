package com.google.b.a.a;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.analytics.internal.Command;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

class ai extends Thread
  implements h
{
  private static ai g;
  private final LinkedBlockingQueue a = new LinkedBlockingQueue();
  private volatile boolean b = false;
  private volatile boolean c = false;
  private volatile List d;
  private volatile String e;
  private volatile String f;
  private volatile be h;
  private final Context i;

  private ai(Context paramContext)
  {
    super("GAThread");
    if (paramContext != null);
    for (this.i = paramContext.getApplicationContext(); ; this.i = paramContext)
    {
      start();
      return;
    }
  }

  static int a(String paramString)
  {
    int j = 1;
    if (!TextUtils.isEmpty(paramString))
    {
      int k = -1 + paramString.length();
      j = 0;
      for (int m = k; m >= 0; m--)
      {
        int n = paramString.charAt(m);
        j = n + (0xFFFFFFF & j << 6) + (n << 14);
        int i1 = 0xFE00000 & j;
        if (i1 == 0)
          continue;
        j ^= i1 >> 21;
      }
    }
    return j;
  }

  static ai a(Context paramContext)
  {
    if (g == null)
      g = new ai(paramContext);
    return g;
  }

  private String a(Throwable paramThrowable)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    PrintStream localPrintStream = new PrintStream(localByteArrayOutputStream);
    paramThrowable.printStackTrace(localPrintStream);
    localPrintStream.flush();
    return new String(localByteArrayOutputStream.toByteArray());
  }

  static String b(Context paramContext)
  {
    Object localObject = null;
    try
    {
      FileInputStream localFileInputStream = paramContext.openFileInput("gaInstallData");
      arrayOfByte = new byte[8192];
      j = localFileInputStream.read(arrayOfByte, 0, 8192);
      if (localFileInputStream.available() > 0)
      {
        ar.a("Too much campaign data, ignoring it.");
        localFileInputStream.close();
        paramContext.deleteFile("gaInstallData");
      }
      else
      {
        localFileInputStream.close();
        paramContext.deleteFile("gaInstallData");
        if (j <= 0)
          ar.d("Campaign file is empty.");
      }
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      byte[] arrayOfByte;
      int j;
      ar.b("No campaign data found.");
      break label149;
      String str = new String(arrayOfByte, 0, j);
      ar.b("Campaign found: " + str);
      localObject = str;
    }
    catch (IOException localIOException)
    {
      ar.a("Error reading campaign data.");
      paramContext.deleteFile("gaInstallData");
    }
    label149: return localObject;
  }

  private String b(Map paramMap)
  {
    String str;
    if (paramMap.containsKey("useSecure"))
      if (bj.a((String)paramMap.get("useSecure"), true))
        str = "https:";
    while (true)
    {
      return str;
      str = "http:";
      continue;
      str = "https:";
    }
  }

  private boolean c(Map paramMap)
  {
    int j;
    if (paramMap.get("&sf") == null)
      j = 0;
    while (true)
    {
      return j;
      double d1 = bj.a((String)paramMap.get("&sf"), 100.0D);
      if (d1 >= 100.0D)
      {
        j = 0;
        continue;
      }
      if (a((String)paramMap.get("&cid")) % 10000 >= d1 * 100.0D)
      {
        if (paramMap.get("&t") == null);
        for (String str = "unknown"; ; str = (String)paramMap.get("&t"))
        {
          Object[] arrayOfObject = new Object[1];
          arrayOfObject[0] = str;
          ar.c(String.format("%s hit sampled out", arrayOfObject));
          j = 1;
          break;
        }
      }
      j = 0;
    }
  }

  private void d(Map paramMap)
  {
    i locali = i.a();
    bj.a(paramMap, "&an", locali.a("&an"));
    bj.a(paramMap, "&av", locali.a("&av"));
    bj.a(paramMap, "&aid", locali.a("&aid"));
    bj.a(paramMap, "&aiid", locali.a("&aiid"));
    paramMap.put("&v", "1");
  }

  public void a()
  {
    a(new ak(this));
  }

  void a(Runnable paramRunnable)
  {
    this.a.add(paramRunnable);
  }

  public void a(Map paramMap)
  {
    HashMap localHashMap = new HashMap(paramMap);
    String str = (String)paramMap.get("&ht");
    if (str != null);
    try
    {
      Long.valueOf(str).longValue();
      if (str == null)
        localHashMap.put("&ht", Long.toString(System.currentTimeMillis()));
      a(new aj(this, localHashMap));
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      while (true)
        str = null;
    }
  }

  public void b()
  {
    a(new al(this));
  }

  public LinkedBlockingQueue c()
  {
    return this.a;
  }

  public Thread d()
  {
    return this;
  }

  protected void e()
  {
    this.h.f();
    this.d = new ArrayList();
    this.d.add(new Command("appendVersion", "&_v".substring(1), "ma3.0.2"));
    this.d.add(new Command("appendQueueTime", "&qt".substring(1), null));
    this.d.add(new Command("appendCacheBuster", "&z".substring(1), null));
  }

  public void run()
  {
    try
    {
      Thread.sleep(5000L);
    }
    catch (InterruptedException localInterruptedException1)
    {
      try
      {
        while (true)
        {
          if (this.h == null)
            this.h = new z(this.i, this);
          e();
          this.f = j.a().a("&cid");
          this.e = b(this.i);
          while (!this.c)
            try
            {
              Runnable localRunnable = (Runnable)this.a.take();
              if (this.b)
                continue;
              localRunnable.run();
            }
            catch (InterruptedException localInterruptedException2)
            {
              ar.b(localInterruptedException2.toString());
            }
            catch (Throwable localThrowable2)
            {
              ar.a("Error on GAThread: " + a(localThrowable2));
              ar.a("Google Analytics is shutting down.");
              this.b = true;
            }
          localInterruptedException1 = localInterruptedException1;
          ar.d("sleep interrupted in GAThread initialize");
        }
      }
      catch (Throwable localThrowable1)
      {
        while (true)
        {
          ar.a("Error initializing the GAThread: " + a(localThrowable1));
          ar.a("Google Analytics will not start up.");
          this.b = true;
        }
      }
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.b.a.a.ai
 * JD-Core Version:    0.6.0
 */