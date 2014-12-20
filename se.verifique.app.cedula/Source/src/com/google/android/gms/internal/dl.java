package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.SystemClock;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class dl extends gr
  implements ServiceConnection
{
  private final Object a = new Object();
  private boolean b = false;
  private Context c;
  private ej d;
  private dk e;
  private dr f;
  private List g = null;
  private dw h;

  public dl(Context paramContext, ej paramej, dw paramdw)
  {
    this.c = paramContext;
    this.d = paramej;
    this.h = paramdw;
    this.e = new dk(paramContext);
    this.f = dr.a(this.c);
    this.g = this.f.a(10L);
  }

  private void a(long paramLong)
  {
    do
    {
      if (b(paramLong))
        continue;
      hi.e("Timeout waiting for pending transaction to be processed.");
    }
    while (!this.b);
  }

  private void a(dp paramdp, String paramString1, String paramString2)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("RESPONSE_CODE", 0);
    localIntent.putExtra("INAPP_PURCHASE_DATA", paramString1);
    localIntent.putExtra("INAPP_DATA_SIGNATURE", paramString2);
    hh.a.post(new dm(this, paramdp, localIntent));
  }

  private boolean b(long paramLong)
  {
    long l = 60000L - (SystemClock.elapsedRealtime() - paramLong);
    int i;
    if (l <= 0L)
      i = 0;
    while (true)
    {
      return i;
      try
      {
        this.a.wait(l);
        i = 1;
      }
      catch (InterruptedException localInterruptedException)
      {
        while (true)
          hi.e("waitWithTimeout_lock interrupted");
      }
    }
  }

  private void c()
  {
    if (this.g.isEmpty())
      return;
    HashMap localHashMap = new HashMap();
    Iterator localIterator1 = this.g.iterator();
    while (localIterator1.hasNext())
    {
      dp localdp2 = (dp)localIterator1.next();
      localHashMap.put(localdp2.c, localdp2);
    }
    String str1;
    for (Object localObject = null; ; localObject = str1)
    {
      Bundle localBundle = this.e.b(this.c.getPackageName(), (String)localObject);
      if (localBundle == null);
      do
      {
        do
        {
          Iterator localIterator2 = localHashMap.keySet().iterator();
          while (localIterator2.hasNext())
          {
            String str2 = (String)localIterator2.next();
            this.f.a((dp)localHashMap.get(str2));
          }
          break;
        }
        while (dv.a(localBundle) != 0);
        ArrayList localArrayList1 = localBundle.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
        ArrayList localArrayList2 = localBundle.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
        ArrayList localArrayList3 = localBundle.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
        str1 = localBundle.getString("INAPP_CONTINUATION_TOKEN");
        for (int i = 0; i < localArrayList1.size(); i++)
        {
          if (!localHashMap.containsKey(localArrayList1.get(i)))
            continue;
          String str3 = (String)localArrayList1.get(i);
          String str4 = (String)localArrayList2.get(i);
          String str5 = (String)localArrayList3.get(i);
          dp localdp1 = (dp)localHashMap.get(str3);
          String str6 = dv.a(str4);
          if (!localdp1.b.equals(str6))
            continue;
          a(localdp1, str4, str5);
          localHashMap.remove(str3);
        }
      }
      while ((str1 == null) || (localHashMap.isEmpty()));
    }
  }

  public void a()
  {
    synchronized (this.a)
    {
      Context localContext = this.c;
      Intent localIntent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
      localContext.bindService(localIntent, this, 1);
      a(SystemClock.elapsedRealtime());
      this.c.unbindService(this);
      this.e.a();
      return;
    }
  }

  public void b()
  {
    synchronized (this.a)
    {
      this.c.unbindService(this);
      this.e.a();
      return;
    }
  }

  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    synchronized (this.a)
    {
      this.e.a(paramIBinder);
      c();
      this.b = true;
      this.a.notify();
      return;
    }
  }

  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    hi.c("In-app billing service disconnected.");
    this.e.a();
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.dl
 * JD-Core Version:    0.6.0
 */