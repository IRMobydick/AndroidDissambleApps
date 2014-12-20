package com.google.android.gms.internal;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.a.a;
import com.google.android.gms.a.b;
import com.google.android.gms.a.d;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class ch
  implements SafeParcelable
{
  public static final cu a = new cu();
  public final int b;
  public final ce c;
  public final oe d;
  public final cv e;
  public final hk f;
  public final aq g;
  public final String h;
  public final boolean i;
  public final String j;
  public final da k;
  public final int l;
  public final int m;
  public final String n;
  public final ev o;
  public final bc p;
  public final String q;
  public final v r;

  ch(int paramInt1, ce paramce, IBinder paramIBinder1, IBinder paramIBinder2, IBinder paramIBinder3, IBinder paramIBinder4, String paramString1, boolean paramBoolean, String paramString2, IBinder paramIBinder5, int paramInt2, int paramInt3, String paramString3, ev paramev, IBinder paramIBinder6, String paramString4, v paramv)
  {
    this.b = paramInt1;
    this.c = paramce;
    this.d = ((oe)d.a(b.a(paramIBinder1)));
    this.e = ((cv)d.a(b.a(paramIBinder2)));
    this.f = ((hk)d.a(b.a(paramIBinder3)));
    this.g = ((aq)d.a(b.a(paramIBinder4)));
    this.h = paramString1;
    this.i = paramBoolean;
    this.j = paramString2;
    this.k = ((da)d.a(b.a(paramIBinder5)));
    this.l = paramInt2;
    this.m = paramInt3;
    this.n = paramString3;
    this.o = paramev;
    this.p = ((bc)d.a(b.a(paramIBinder6)));
    this.q = paramString4;
    this.r = paramv;
  }

  public ch(ce paramce, oe paramoe, cv paramcv, da paramda, ev paramev)
  {
    this.b = 4;
    this.c = paramce;
    this.d = paramoe;
    this.e = paramcv;
    this.f = null;
    this.g = null;
    this.h = null;
    this.i = false;
    this.j = null;
    this.k = paramda;
    this.l = -1;
    this.m = 4;
    this.n = null;
    this.o = paramev;
    this.p = null;
    this.q = null;
    this.r = null;
  }

  public ch(oe paramoe, cv paramcv, aq paramaq, da paramda, hk paramhk, boolean paramBoolean, int paramInt, String paramString, ev paramev, bc parambc)
  {
    this.b = 4;
    this.c = null;
    this.d = paramoe;
    this.e = paramcv;
    this.f = paramhk;
    this.g = paramaq;
    this.h = null;
    this.i = paramBoolean;
    this.j = null;
    this.k = paramda;
    this.l = paramInt;
    this.m = 3;
    this.n = paramString;
    this.o = paramev;
    this.p = parambc;
    this.q = null;
    this.r = null;
  }

  public ch(oe paramoe, cv paramcv, aq paramaq, da paramda, hk paramhk, boolean paramBoolean, int paramInt, String paramString1, String paramString2, ev paramev, bc parambc)
  {
    this.b = 4;
    this.c = null;
    this.d = paramoe;
    this.e = paramcv;
    this.f = paramhk;
    this.g = paramaq;
    this.h = paramString2;
    this.i = paramBoolean;
    this.j = paramString1;
    this.k = paramda;
    this.l = paramInt;
    this.m = 3;
    this.n = null;
    this.o = paramev;
    this.p = parambc;
    this.q = null;
    this.r = null;
  }

  public ch(oe paramoe, cv paramcv, da paramda, hk paramhk, int paramInt, ev paramev, String paramString, v paramv)
  {
    this.b = 4;
    this.c = null;
    this.d = paramoe;
    this.e = paramcv;
    this.f = paramhk;
    this.g = null;
    this.h = null;
    this.i = false;
    this.j = null;
    this.k = paramda;
    this.l = paramInt;
    this.m = 1;
    this.n = null;
    this.o = paramev;
    this.p = null;
    this.q = paramString;
    this.r = paramv;
  }

  public ch(oe paramoe, cv paramcv, da paramda, hk paramhk, boolean paramBoolean, int paramInt, ev paramev)
  {
    this.b = 4;
    this.c = null;
    this.d = paramoe;
    this.e = paramcv;
    this.f = paramhk;
    this.g = null;
    this.h = null;
    this.i = paramBoolean;
    this.j = null;
    this.k = paramda;
    this.l = paramInt;
    this.m = 2;
    this.n = null;
    this.o = paramev;
    this.p = null;
    this.q = null;
    this.r = null;
  }

  public static ch a(Intent paramIntent)
  {
    try
    {
      Bundle localBundle = paramIntent.getBundleExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
      localBundle.setClassLoader(ch.class.getClassLoader());
      localch = (ch)localBundle.getParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
      return localch;
    }
    catch (Exception localException)
    {
      while (true)
        ch localch = null;
    }
  }

  public static void a(Intent paramIntent, ch paramch)
  {
    Bundle localBundle = new Bundle(1);
    localBundle.putParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", paramch);
    paramIntent.putExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", localBundle);
  }

  IBinder a()
  {
    return d.a(this.d).asBinder();
  }

  IBinder b()
  {
    return d.a(this.e).asBinder();
  }

  IBinder c()
  {
    return d.a(this.f).asBinder();
  }

  IBinder d()
  {
    return d.a(this.g).asBinder();
  }

  public int describeContents()
  {
    return 0;
  }

  IBinder e()
  {
    return d.a(this.p).asBinder();
  }

  IBinder f()
  {
    return d.a(this.k).asBinder();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    cu.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ch
 * JD-Core Version:    0.6.0
 */