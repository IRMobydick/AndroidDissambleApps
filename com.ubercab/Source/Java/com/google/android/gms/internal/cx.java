package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.a;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.dynamic.e;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONObject;

@ez
public final class cx extends cu.a
{
  private final MediationAdapter qE;

  public cx(MediationAdapter paramMediationAdapter)
  {
    this.qE = paramMediationAdapter;
  }

  private Bundle a(String paramString1, int paramInt, String paramString2)
    throws RemoteException
  {
    gs.W("Server parameters: " + paramString1);
    Bundle localBundle;
    try
    {
      localObject = new Bundle();
      if (paramString1 == null)
        break label121;
      JSONObject localJSONObject = new JSONObject(paramString1);
      localBundle = new Bundle();
      Iterator localIterator = localJSONObject.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localBundle.putString(str, localJSONObject.getString(str));
      }
    }
    catch (Throwable localThrowable)
    {
      gs.d("Could not get Server Parameters Bundle.", localThrowable);
      throw new RemoteException();
    }
    Object localObject = localBundle;
    label121: if ((this.qE instanceof AdMobAdapter))
    {
      ((Bundle)localObject).putString("adJson", paramString2);
      ((Bundle)localObject).putInt("tagForChildDirectedTreatment", paramInt);
    }
    return localObject;
  }

  public void a(d paramd, av paramav, String paramString, cv paramcv)
    throws RemoteException
  {
    a(paramd, paramav, paramString, null, paramcv);
  }

  public void a(d paramd, av paramav, String paramString1, String paramString2, cv paramcv)
    throws RemoteException
  {
    if (!(this.qE instanceof MediationInterstitialAdapter))
    {
      gs.W("MediationAdapter is not a MediationInterstitialAdapter: " + this.qE.getClass().getCanonicalName());
      throw new RemoteException();
    }
    gs.S("Requesting interstitial ad from adapter.");
    try
    {
      MediationInterstitialAdapter localMediationInterstitialAdapter = (MediationInterstitialAdapter)this.qE;
      HashSet localHashSet;
      cw localcw;
      if (paramav.nV != null)
      {
        localHashSet = new HashSet(paramav.nV);
        localcw = new cw(new Date(paramav.nT), paramav.nU, localHashSet, paramav.ob, paramav.nW, paramav.nX);
        if (paramav.od == null)
          break label190;
      }
      label190: for (Bundle localBundle = paramav.od.getBundle(localMediationInterstitialAdapter.getClass().getName()); ; localBundle = null)
      {
        localMediationInterstitialAdapter.requestInterstitialAd((Context)e.f(paramd), new cy(paramcv), a(paramString1, paramav.nX, paramString2), localcw, localBundle);
        return;
        localHashSet = null;
        break;
      }
    }
    catch (Throwable localThrowable)
    {
      gs.d("Could not request interstitial ad from adapter.", localThrowable);
    }
    throw new RemoteException();
  }

  public void a(d paramd, ay paramay, av paramav, String paramString, cv paramcv)
    throws RemoteException
  {
    a(paramd, paramay, paramav, paramString, null, paramcv);
  }

  public void a(d paramd, ay paramay, av paramav, String paramString1, String paramString2, cv paramcv)
    throws RemoteException
  {
    if (!(this.qE instanceof MediationBannerAdapter))
    {
      gs.W("MediationAdapter is not a MediationBannerAdapter: " + this.qE.getClass().getCanonicalName());
      throw new RemoteException();
    }
    gs.S("Requesting banner ad from adapter.");
    try
    {
      MediationBannerAdapter localMediationBannerAdapter = (MediationBannerAdapter)this.qE;
      if (paramav.nV != null);
      for (HashSet localHashSet = new HashSet(paramav.nV); ; localHashSet = null)
      {
        cw localcw = new cw(new Date(paramav.nT), paramav.nU, localHashSet, paramav.ob, paramav.nW, paramav.nX);
        Bundle localBundle1 = paramav.od;
        Bundle localBundle2 = null;
        if (localBundle1 != null)
          localBundle2 = paramav.od.getBundle(localMediationBannerAdapter.getClass().getName());
        localMediationBannerAdapter.requestBannerAd((Context)e.f(paramd), new cy(paramcv), a(paramString1, paramav.nX, paramString2), a.a(paramay.width, paramay.height, paramay.of), localcw, localBundle2);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      gs.d("Could not request banner ad from adapter.", localThrowable);
    }
    throw new RemoteException();
  }

  public void destroy()
    throws RemoteException
  {
    try
    {
      this.qE.onDestroy();
      return;
    }
    catch (Throwable localThrowable)
    {
      gs.d("Could not destroy adapter.", localThrowable);
    }
    throw new RemoteException();
  }

  public d getView()
    throws RemoteException
  {
    if (!(this.qE instanceof MediationBannerAdapter))
    {
      gs.W("MediationAdapter is not a MediationBannerAdapter: " + this.qE.getClass().getCanonicalName());
      throw new RemoteException();
    }
    try
    {
      d locald = e.k(((MediationBannerAdapter)this.qE).getBannerView());
      return locald;
    }
    catch (Throwable localThrowable)
    {
      gs.d("Could not get banner view from adapter.", localThrowable);
    }
    throw new RemoteException();
  }

  public void pause()
    throws RemoteException
  {
    try
    {
      this.qE.onPause();
      return;
    }
    catch (Throwable localThrowable)
    {
      gs.d("Could not pause adapter.", localThrowable);
    }
    throw new RemoteException();
  }

  public void resume()
    throws RemoteException
  {
    try
    {
      this.qE.onResume();
      return;
    }
    catch (Throwable localThrowable)
    {
      gs.d("Could not resume adapter.", localThrowable);
    }
    throw new RemoteException();
  }

  public void showInterstitial()
    throws RemoteException
  {
    if (!(this.qE instanceof MediationInterstitialAdapter))
    {
      gs.W("MediationAdapter is not a MediationInterstitialAdapter: " + this.qE.getClass().getCanonicalName());
      throw new RemoteException();
    }
    gs.S("Showing interstitial from adapter.");
    try
    {
      ((MediationInterstitialAdapter)this.qE).showInterstitial();
      return;
    }
    catch (Throwable localThrowable)
    {
      gs.d("Could not show interstitial from adapter.", localThrowable);
    }
    throw new RemoteException();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.cx
 * JD-Core Version:    0.6.2
 */