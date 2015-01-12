package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@ez
public class dx extends gg
  implements ServiceConnection
{
  private Context mContext;
  private final Object mw = new Object();
  private boolean sl = false;
  private el sm;
  private dw sn;
  private ec so;
  private List<ea> sp = null;
  private ee sq;

  public dx(Context paramContext, el paramel, ee paramee)
  {
    this.mContext = paramContext;
    this.sm = paramel;
    this.sq = paramee;
    this.sn = new dw(paramContext);
    this.so = ec.j(this.mContext);
    this.sp = this.so.d(10L);
  }

  private void a(final ea paramea, String paramString1, String paramString2)
  {
    final Intent localIntent = new Intent();
    localIntent.putExtra("RESPONSE_CODE", 0);
    localIntent.putExtra("INAPP_PURCHASE_DATA", paramString1);
    localIntent.putExtra("INAPP_DATA_SIGNATURE", paramString2);
    gr.wC.post(new Runnable()
    {
      public void run()
      {
        try
        {
          if (dx.a(dx.this).a(paramea.sB, -1, localIntent))
          {
            dx.c(dx.this).a(new eb(dx.b(dx.this), paramea.sC, true, -1, localIntent, paramea));
            return;
          }
          dx.c(dx.this).a(new eb(dx.b(dx.this), paramea.sC, false, -1, localIntent, paramea));
          return;
        }
        catch (RemoteException localRemoteException)
        {
          gs.W("Fail to verify and dispatch pending transaction");
        }
      }
    });
  }

  private void b(long paramLong)
  {
    do
      if (!c(paramLong))
        gs.W("Timeout waiting for pending transaction to be processed.");
    while (!this.sl);
  }

  private boolean c(long paramLong)
  {
    long l = 60000L - (SystemClock.elapsedRealtime() - paramLong);
    if (l <= 0L)
      return false;
    try
    {
      this.mw.wait(l);
      return true;
    }
    catch (InterruptedException localInterruptedException)
    {
      while (true)
        gs.W("waitWithTimeout_lock interrupted");
    }
  }

  private void cp()
  {
    if (this.sp.isEmpty())
      return;
    HashMap localHashMap = new HashMap();
    Iterator localIterator1 = this.sp.iterator();
    while (localIterator1.hasNext())
    {
      ea localea2 = (ea)localIterator1.next();
      localHashMap.put(localea2.sC, localea2);
    }
    String str1;
    for (Object localObject = null; ; localObject = str1)
    {
      Bundle localBundle = this.sn.d(this.mContext.getPackageName(), (String)localObject);
      if (localBundle == null);
      do
      {
        do
        {
          Iterator localIterator2 = localHashMap.keySet().iterator();
          while (localIterator2.hasNext())
          {
            String str2 = (String)localIterator2.next();
            this.so.a((ea)localHashMap.get(str2));
          }
          break;
        }
        while (ed.b(localBundle) != 0);
        ArrayList localArrayList1 = localBundle.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
        ArrayList localArrayList2 = localBundle.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
        ArrayList localArrayList3 = localBundle.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
        str1 = localBundle.getString("INAPP_CONTINUATION_TOKEN");
        for (int i = 0; i < localArrayList1.size(); i++)
          if (localHashMap.containsKey(localArrayList1.get(i)))
          {
            String str3 = (String)localArrayList1.get(i);
            String str4 = (String)localArrayList2.get(i);
            String str5 = (String)localArrayList3.get(i);
            ea localea1 = (ea)localHashMap.get(str3);
            String str6 = ed.D(str4);
            if (localea1.sB.equals(str6))
            {
              a(localea1, str4, str5);
              localHashMap.remove(str3);
            }
          }
      }
      while ((str1 == null) || (localHashMap.isEmpty()));
    }
  }

  public void co()
  {
    synchronized (this.mw)
    {
      Context localContext = this.mContext;
      Intent localIntent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
      localContext.bindService(localIntent, this, 1);
      b(SystemClock.elapsedRealtime());
      this.mContext.unbindService(this);
      this.sn.destroy();
      return;
    }
  }

  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    synchronized (this.mw)
    {
      this.sn.r(paramIBinder);
      cp();
      this.sl = true;
      this.mw.notify();
      return;
    }
  }

  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    gs.U("In-app billing service disconnected.");
    this.sn.destroy();
  }

  public void onStop()
  {
    synchronized (this.mw)
    {
      this.mContext.unbindService(this);
      this.sn.destroy();
      return;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.dx
 * JD-Core Version:    0.6.2
 */