package com.google.android.gms.internal;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;

public class do extends ef
  implements ServiceConnection
{
  private final Activity a;
  private final dr b;
  private Context c;
  private ej d;
  private dy e;
  private dk f;
  private dp g;
  private dw h;
  private String i;

  public static void a(Context paramContext, boolean paramBoolean, cq paramcq)
  {
    Intent localIntent = new Intent();
    localIntent.setClassName(paramContext, "com.google.android.gms.ads.purchase.InAppPurchaseActivity");
    localIntent.putExtra("com.google.android.gms.ads.internal.purchase.useClientJar", paramBoolean);
    cq.a(localIntent, paramcq);
    paramContext.startActivity(localIntent);
  }

  private void a(String paramString, boolean paramBoolean, int paramInt, Intent paramIntent)
  {
    try
    {
      this.d.a(new dq(this.c, paramString, paramBoolean, paramInt, paramIntent, this.g));
      return;
    }
    catch (RemoteException localRemoteException)
    {
      while (true)
        hi.e("Fail to invoke PlayStorePurchaseListener.");
    }
  }

  public void a()
  {
    cq localcq = cq.a(this.a.getIntent());
    this.d = localcq.c;
    this.h = localcq.d;
    this.e = localcq.e;
    this.f = new dk(this.a.getApplicationContext());
    this.c = localcq.f;
    Activity localActivity = this.a;
    Intent localIntent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
    this.a.getApplicationContext();
    localActivity.bindService(localIntent, this, 1);
  }

  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 1001);
    try
    {
      int j = dv.a(paramIntent);
      if ((paramInt2 == -1) && (j == 0))
      {
        if (this.h.a(this.i, paramInt2, paramIntent))
          a(this.e.a(), true, paramInt2, paramIntent);
        while (true)
        {
          this.e.c(j);
          return;
          a(this.e.a(), false, paramInt2, paramIntent);
        }
      }
    }
    catch (RemoteException localRemoteException)
    {
      while (true)
      {
        hi.e("Fail to process purchase result.");
        this.i = null;
        this.a.finish();
        continue;
        this.b.a(this.g);
        a(this.e.a(), false, paramInt2, paramIntent);
      }
    }
    finally
    {
      this.i = null;
      this.a.finish();
    }
    throw localObject;
  }

  public void b()
  {
    this.a.unbindService(this);
    this.f.a();
  }

  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    this.f.a(paramIBinder);
    try
    {
      this.i = this.h.a();
      Bundle localBundle = this.f.a(this.a.getPackageName(), this.e.a(), this.i);
      PendingIntent localPendingIntent = (PendingIntent)localBundle.getParcelable("BUY_INTENT");
      if (localPendingIntent == null)
      {
        int j = dv.a(localBundle);
        this.e.c(j);
        a(this.e.a(), false, j, null);
        this.a.finish();
      }
      else
      {
        this.g = new dp(this.e.a(), this.i);
        this.b.b(this.g);
        this.a.startIntentSenderForResult(localPendingIntent.getIntentSender(), 1001, new Intent(), Integer.valueOf(0).intValue(), Integer.valueOf(0).intValue(), Integer.valueOf(0).intValue());
      }
    }
    catch (RemoteException localRemoteException)
    {
      hi.c("Error when connecting in-app billing service", localRemoteException);
      this.a.finish();
    }
    catch (IntentSender.SendIntentException localSendIntentException)
    {
      label192: break label192;
    }
  }

  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    hi.c("In-app billing service disconnected.");
    this.f.a();
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.do
 * JD-Core Version:    0.6.0
 */