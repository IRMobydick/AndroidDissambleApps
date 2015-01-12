package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.ads.purchase.InAppPurchase;

@ez
public class ep
  implements InAppPurchase
{
  private final eg sx;

  public ep(eg parameg)
  {
    this.sx = parameg;
  }

  public String getProductId()
  {
    try
    {
      String str = this.sx.getProductId();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      gs.d("Could not forward getProductId to InAppPurchase", localRemoteException);
    }
    return null;
  }

  public void recordPlayBillingResolution(int paramInt)
  {
    try
    {
      this.sx.recordPlayBillingResolution(paramInt);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      gs.d("Could not forward recordPlayBillingResolution to InAppPurchase", localRemoteException);
    }
  }

  public void recordResolution(int paramInt)
  {
    try
    {
      this.sx.recordResolution(paramInt);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      gs.d("Could not forward recordResolution to InAppPurchase", localRemoteException);
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ep
 * JD-Core Version:    0.6.2
 */