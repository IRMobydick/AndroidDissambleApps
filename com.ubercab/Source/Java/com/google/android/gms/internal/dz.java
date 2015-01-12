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

@ez
public class dz extends ei.a
  implements ServiceConnection
{
  private final Activity nr;
  private el sm;
  private dw sn;
  private final ec so;
  private ee sq;
  private Context sw;
  private eg sx;
  private ea sy;
  private String sz = null;

  public dz(Activity paramActivity)
  {
    this.nr = paramActivity;
    this.so = ec.j(this.nr.getApplicationContext());
  }

  public static void a(Context paramContext, boolean paramBoolean, dv paramdv)
  {
    Intent localIntent = new Intent();
    localIntent.setClassName(paramContext, "com.google.android.gms.ads.purchase.InAppPurchaseActivity");
    localIntent.putExtra("com.google.android.gms.ads.internal.purchase.useClientJar", paramBoolean);
    dv.a(localIntent, paramdv);
    paramContext.startActivity(localIntent);
  }

  private void a(String paramString, boolean paramBoolean, int paramInt, Intent paramIntent)
  {
    try
    {
      this.sm.a(new eb(this.sw, paramString, paramBoolean, paramInt, paramIntent, this.sy));
      return;
    }
    catch (RemoteException localRemoteException)
    {
      gs.W("Fail to invoke PlayStorePurchaseListener.");
    }
  }

  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 1001);
    try
    {
      int i = ed.d(paramIntent);
      if ((paramInt2 == -1) && (i == 0))
      {
        if (this.sq.a(this.sz, paramInt2, paramIntent))
          a(this.sx.getProductId(), true, paramInt2, paramIntent);
        while (true)
        {
          this.sx.recordPlayBillingResolution(i);
          return;
          a(this.sx.getProductId(), false, paramInt2, paramIntent);
        }
      }
    }
    catch (RemoteException localRemoteException)
    {
      while (true)
      {
        gs.W("Fail to process purchase result.");
        return;
        this.so.a(this.sy);
        a(this.sx.getProductId(), false, paramInt2, paramIntent);
      }
    }
    finally
    {
      this.sz = null;
      this.nr.finish();
    }
  }

  public void onCreate()
  {
    dv localdv = dv.c(this.nr.getIntent());
    this.sm = localdv.lM;
    this.sq = localdv.lT;
    this.sx = localdv.si;
    this.sn = new dw(this.nr.getApplicationContext());
    this.sw = localdv.sj;
    Intent localIntent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
    localIntent.setPackage("com.android.vending");
    this.nr.bindService(localIntent, this, 1);
  }

  public void onDestroy()
  {
    this.nr.unbindService(this);
    this.sn.destroy();
  }

  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    this.sn.r(paramIBinder);
    try
    {
      this.sz = this.sq.ct();
      Bundle localBundle = this.sn.a(this.nr.getPackageName(), this.sx.getProductId(), this.sz);
      PendingIntent localPendingIntent = (PendingIntent)localBundle.getParcelable("BUY_INTENT");
      if (localPendingIntent == null)
      {
        int i = ed.b(localBundle);
        this.sx.recordPlayBillingResolution(i);
        a(this.sx.getProductId(), false, i, null);
        this.nr.finish();
        return;
      }
      this.sy = new ea(this.sx.getProductId(), this.sz);
      this.so.b(this.sy);
      this.nr.startIntentSenderForResult(localPendingIntent.getIntentSender(), 1001, new Intent(), Integer.valueOf(0).intValue(), Integer.valueOf(0).intValue(), Integer.valueOf(0).intValue());
      return;
    }
    catch (RemoteException localRemoteException)
    {
      gs.d("Error when connecting in-app billing service", localRemoteException);
      this.nr.finish();
      return;
    }
    catch (IntentSender.SendIntentException localSendIntentException)
    {
      label188: break label188;
    }
  }

  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    gs.U("In-app billing service disconnected.");
    this.sn.destroy();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.dz
 * JD-Core Version:    0.6.2
 */