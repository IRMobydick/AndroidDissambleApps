package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.a.d;
import com.google.android.gms.ads.c.b;
import com.google.android.gms.ads.c.c;
import com.google.android.gms.ads.c.e;
import com.google.android.gms.ads.h;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONObject;

public final class cg extends bz
{
  private final b a;

  public cg(b paramb)
  {
    this.a = paramb;
  }

  private Bundle a(String paramString1, int paramInt, String paramString2)
  {
    hi.e("Server parameters: " + paramString1);
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
      hi.c("Could not get Server Parameters Bundle.", localThrowable);
      throw new RemoteException();
    }
    Object localObject = localBundle;
    label121: if ((this.a instanceof com.google.a.a.a.a))
    {
      ((Bundle)localObject).putString("adJson", paramString2);
      ((Bundle)localObject).putInt("tagForChildDirectedTreatment", paramInt);
    }
    return (Bundle)localObject;
  }

  public com.google.android.gms.a.a a()
  {
    if (!(this.a instanceof c))
    {
      hi.e("MediationAdapter is not a MediationBannerAdapter: " + this.a.getClass().getCanonicalName());
      throw new RemoteException();
    }
    try
    {
      com.google.android.gms.a.a locala = d.a(((c)this.a).d());
      return locala;
    }
    catch (Throwable localThrowable)
    {
      hi.c("Could not get banner view from adapter.", localThrowable);
    }
    throw new RemoteException();
  }

  public void a(com.google.android.gms.a.a parama, ai paramai, String paramString, cb paramcb)
  {
    a(parama, paramai, paramString, null, paramcb);
  }

  public void a(com.google.android.gms.a.a parama, ai paramai, String paramString1, String paramString2, cb paramcb)
  {
    Bundle localBundle = null;
    if (!(this.a instanceof e))
    {
      hi.e("MediationAdapter is not a MediationInterstitialAdapter: " + this.a.getClass().getCanonicalName());
      throw new RemoteException();
    }
    hi.a("Requesting interstitial ad from adapter.");
    try
    {
      e locale = (e)this.a;
      if (paramai.f != null);
      for (HashSet localHashSet = new HashSet(paramai.f); ; localHashSet = null)
      {
        cf localcf = new cf(new Date(paramai.c), paramai.e, localHashSet, paramai.g, paramai.h);
        if (paramai.n != null)
          localBundle = paramai.n.getBundle(locale.getClass().getName());
        locale.a((Context)d.a(parama), new ci(paramcb), a(paramString1, paramai.h, paramString2), localcf, localBundle);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      hi.c("Could not request interstitial ad from adapter.", localThrowable);
    }
    throw new RemoteException();
  }

  public void a(com.google.android.gms.a.a parama, al paramal, ai paramai, String paramString, cb paramcb)
  {
    a(parama, paramal, paramai, paramString, null, paramcb);
  }

  public void a(com.google.android.gms.a.a parama, al paramal, ai paramai, String paramString1, String paramString2, cb paramcb)
  {
    Bundle localBundle = null;
    if (!(this.a instanceof c))
    {
      hi.e("MediationAdapter is not a MediationBannerAdapter: " + this.a.getClass().getCanonicalName());
      throw new RemoteException();
    }
    hi.a("Requesting banner ad from adapter.");
    try
    {
      c localc = (c)this.a;
      if (paramai.f != null);
      for (HashSet localHashSet = new HashSet(paramai.f); ; localHashSet = null)
      {
        cf localcf = new cf(new Date(paramai.c), paramai.e, localHashSet, paramai.g, paramai.h);
        if (paramai.n != null)
          localBundle = paramai.n.getBundle(localc.getClass().getName());
        localc.a((Context)d.a(parama), new ci(paramcb), a(paramString1, paramai.h, paramString2), h.a(paramal.g, paramal.d, paramal.c), localcf, localBundle);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      hi.c("Could not request banner ad from adapter.", localThrowable);
    }
    throw new RemoteException();
  }

  public void b()
  {
    if (!(this.a instanceof e))
    {
      hi.e("MediationAdapter is not a MediationInterstitialAdapter: " + this.a.getClass().getCanonicalName());
      throw new RemoteException();
    }
    hi.a("Showing interstitial from adapter.");
    try
    {
      ((e)this.a).e();
      return;
    }
    catch (Throwable localThrowable)
    {
      hi.c("Could not show interstitial from adapter.", localThrowable);
    }
    throw new RemoteException();
  }

  public void c()
  {
    try
    {
      this.a.a();
      return;
    }
    catch (Throwable localThrowable)
    {
      hi.c("Could not destroy adapter.", localThrowable);
    }
    throw new RemoteException();
  }

  public void d()
  {
    try
    {
      this.a.b();
      return;
    }
    catch (Throwable localThrowable)
    {
      hi.c("Could not pause adapter.", localThrowable);
    }
    throw new RemoteException();
  }

  public void e()
  {
    try
    {
      this.a.c();
      return;
    }
    catch (Throwable localThrowable)
    {
      hi.c("Could not resume adapter.", localThrowable);
    }
    throw new RemoteException();
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.cg
 * JD-Core Version:    0.6.0
 */