package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;

@ez
public final class eb extends ek.a
  implements ServiceConnection
{
  private Context mContext;
  private boolean sD = false;
  private int sE;
  private Intent sF;
  private dw sn;
  private String su;
  private ea sy;

  public eb(Context paramContext, String paramString, boolean paramBoolean, int paramInt, Intent paramIntent, ea paramea)
  {
    this.su = paramString;
    this.sE = paramInt;
    this.sF = paramIntent;
    this.sD = paramBoolean;
    this.mContext = paramContext;
    this.sy = paramea;
  }

  public void finishPurchase()
  {
    int i = ed.d(this.sF);
    if ((this.sE != -1) || (i != 0))
      return;
    this.sn = new dw(this.mContext);
    Context localContext = this.mContext;
    Intent localIntent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
    localContext.bindService(localIntent, this, 1);
  }

  public String getProductId()
  {
    return this.su;
  }

  public Intent getPurchaseData()
  {
    return this.sF;
  }

  public int getResultCode()
  {
    return this.sE;
  }

  public boolean isVerified()
  {
    return this.sD;
  }

  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    gs.U("In-app billing service connected.");
    this.sn.r(paramIBinder);
    String str = ed.E(ed.e(this.sF));
    if (str == null)
      return;
    if (this.sn.c(this.mContext.getPackageName(), str) == 0)
      ec.j(this.mContext).a(this.sy);
    this.mContext.unbindService(this);
    this.sn.destroy();
  }

  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    gs.U("In-app billing service disconnected.");
    this.sn.destroy();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.eb
 * JD-Core Version:    0.6.2
 */