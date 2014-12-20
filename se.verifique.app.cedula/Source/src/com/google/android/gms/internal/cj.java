package com.google.android.gms.internal;

import android.app.Activity;
import android.os.RemoteException;
import com.google.a.a.b;
import com.google.a.a.c;
import com.google.a.a.e;
import com.google.a.a.g;
import com.google.a.a.j;
import com.google.android.gms.a.a;
import com.google.android.gms.a.d;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public final class cj extends bz
{
  private final b a;
  private final j b;

  public cj(b paramb, j paramj)
  {
    this.a = paramb;
    this.b = paramj;
  }

  private g a(String paramString1, int paramInt, String paramString2)
  {
    HashMap localHashMap;
    if (paramString1 != null)
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString1);
        localHashMap = new HashMap(localJSONObject.length());
        Iterator localIterator = localJSONObject.keys();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          localHashMap.put(str, localJSONObject.getString(str));
        }
      }
      catch (Throwable localThrowable)
      {
        hi.c("Could not get MediationServerParameters.", localThrowable);
        throw new RemoteException();
      }
    else
      localHashMap = new HashMap(0);
    Class localClass = this.a.c();
    g localg = null;
    if (localClass != null)
    {
      localg = (g)localClass.newInstance();
      localg.a(localHashMap);
    }
    return localg;
  }

  public a a()
  {
    if (!(this.a instanceof c))
    {
      hi.e("MediationAdapter is not a MediationBannerAdapter: " + this.a.getClass().getCanonicalName());
      throw new RemoteException();
    }
    try
    {
      a locala = d.a(((c)this.a).d());
      return locala;
    }
    catch (Throwable localThrowable)
    {
      hi.c("Could not get banner view from adapter.", localThrowable);
    }
    throw new RemoteException();
  }

  public void a(a parama, ai paramai, String paramString, cb paramcb)
  {
    a(parama, paramai, paramString, null, paramcb);
  }

  public void a(a parama, ai paramai, String paramString1, String paramString2, cb paramcb)
  {
    if (!(this.a instanceof e))
    {
      hi.e("MediationAdapter is not a MediationInterstitialAdapter: " + this.a.getClass().getCanonicalName());
      throw new RemoteException();
    }
    hi.a("Requesting interstitial ad from adapter.");
    try
    {
      ((e)this.a).a(new ck(paramcb), (Activity)d.a(parama), a(paramString1, paramai.h, paramString2), cl.a(paramai), this.b);
      return;
    }
    catch (Throwable localThrowable)
    {
      hi.c("Could not request interstitial ad from adapter.", localThrowable);
    }
    throw new RemoteException();
  }

  public void a(a parama, al paramal, ai paramai, String paramString, cb paramcb)
  {
    a(parama, paramal, paramai, paramString, null, paramcb);
  }

  public void a(a parama, al paramal, ai paramai, String paramString1, String paramString2, cb paramcb)
  {
    if (!(this.a instanceof c))
    {
      hi.e("MediationAdapter is not a MediationBannerAdapter: " + this.a.getClass().getCanonicalName());
      throw new RemoteException();
    }
    hi.a("Requesting banner ad from adapter.");
    try
    {
      ((c)this.a).a(new ck(paramcb), (Activity)d.a(parama), a(paramString1, paramai.h, paramString2), cl.a(paramal), cl.a(paramai), this.b);
      return;
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
      ((e)this.a).d();
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
    throw new RemoteException();
  }

  public void e()
  {
    throw new RemoteException();
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.cj
 * JD-Core Version:    0.6.0
 */