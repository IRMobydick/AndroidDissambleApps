package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.common.internal.o;

@ez
public final class cy
  implements MediationBannerListener, MediationInterstitialListener
{
  private final cv qF;

  public cy(cv paramcv)
  {
    this.qF = paramcv;
  }

  public void onAdClicked(MediationBannerAdapter paramMediationBannerAdapter)
  {
    o.aT("onAdClicked must be called on the main UI thread.");
    gs.S("Adapter called onAdClicked.");
    try
    {
      this.qF.onAdClicked();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      gs.d("Could not call onAdClicked.", localRemoteException);
    }
  }

  public void onAdClicked(MediationInterstitialAdapter paramMediationInterstitialAdapter)
  {
    o.aT("onAdClicked must be called on the main UI thread.");
    gs.S("Adapter called onAdClicked.");
    try
    {
      this.qF.onAdClicked();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      gs.d("Could not call onAdClicked.", localRemoteException);
    }
  }

  public void onAdClosed(MediationBannerAdapter paramMediationBannerAdapter)
  {
    o.aT("onAdClosed must be called on the main UI thread.");
    gs.S("Adapter called onAdClosed.");
    try
    {
      this.qF.onAdClosed();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      gs.d("Could not call onAdClosed.", localRemoteException);
    }
  }

  public void onAdClosed(MediationInterstitialAdapter paramMediationInterstitialAdapter)
  {
    o.aT("onAdClosed must be called on the main UI thread.");
    gs.S("Adapter called onAdClosed.");
    try
    {
      this.qF.onAdClosed();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      gs.d("Could not call onAdClosed.", localRemoteException);
    }
  }

  public void onAdFailedToLoad(MediationBannerAdapter paramMediationBannerAdapter, int paramInt)
  {
    o.aT("onAdFailedToLoad must be called on the main UI thread.");
    gs.S("Adapter called onAdFailedToLoad with error. " + paramInt);
    try
    {
      this.qF.onAdFailedToLoad(paramInt);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      gs.d("Could not call onAdFailedToLoad.", localRemoteException);
    }
  }

  public void onAdFailedToLoad(MediationInterstitialAdapter paramMediationInterstitialAdapter, int paramInt)
  {
    o.aT("onAdFailedToLoad must be called on the main UI thread.");
    gs.S("Adapter called onAdFailedToLoad with error " + paramInt + ".");
    try
    {
      this.qF.onAdFailedToLoad(paramInt);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      gs.d("Could not call onAdFailedToLoad.", localRemoteException);
    }
  }

  public void onAdLeftApplication(MediationBannerAdapter paramMediationBannerAdapter)
  {
    o.aT("onAdLeftApplication must be called on the main UI thread.");
    gs.S("Adapter called onAdLeftApplication.");
    try
    {
      this.qF.onAdLeftApplication();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      gs.d("Could not call onAdLeftApplication.", localRemoteException);
    }
  }

  public void onAdLeftApplication(MediationInterstitialAdapter paramMediationInterstitialAdapter)
  {
    o.aT("onAdLeftApplication must be called on the main UI thread.");
    gs.S("Adapter called onAdLeftApplication.");
    try
    {
      this.qF.onAdLeftApplication();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      gs.d("Could not call onAdLeftApplication.", localRemoteException);
    }
  }

  public void onAdLoaded(MediationBannerAdapter paramMediationBannerAdapter)
  {
    o.aT("onAdLoaded must be called on the main UI thread.");
    gs.S("Adapter called onAdLoaded.");
    try
    {
      this.qF.onAdLoaded();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      gs.d("Could not call onAdLoaded.", localRemoteException);
    }
  }

  public void onAdLoaded(MediationInterstitialAdapter paramMediationInterstitialAdapter)
  {
    o.aT("onAdLoaded must be called on the main UI thread.");
    gs.S("Adapter called onAdLoaded.");
    try
    {
      this.qF.onAdLoaded();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      gs.d("Could not call onAdLoaded.", localRemoteException);
    }
  }

  public void onAdOpened(MediationBannerAdapter paramMediationBannerAdapter)
  {
    o.aT("onAdOpened must be called on the main UI thread.");
    gs.S("Adapter called onAdOpened.");
    try
    {
      this.qF.onAdOpened();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      gs.d("Could not call onAdOpened.", localRemoteException);
    }
  }

  public void onAdOpened(MediationInterstitialAdapter paramMediationInterstitialAdapter)
  {
    o.aT("onAdOpened must be called on the main UI thread.");
    gs.S("Adapter called onAdOpened.");
    try
    {
      this.qF.onAdOpened();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      gs.d("Could not call onAdOpened.", localRemoteException);
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.cy
 * JD-Core Version:    0.6.2
 */