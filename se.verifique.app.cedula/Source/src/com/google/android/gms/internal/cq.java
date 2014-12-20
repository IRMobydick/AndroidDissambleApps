package com.google.android.gms.internal;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.a.a;
import com.google.android.gms.a.b;
import com.google.android.gms.a.d;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class cq
  implements SafeParcelable
{
  public static final dj a = new dj();
  public final int b;
  public final ej c;
  public final dw d;
  public final dy e;
  public final Context f;

  cq(int paramInt, IBinder paramIBinder1, IBinder paramIBinder2, IBinder paramIBinder3, IBinder paramIBinder4)
  {
    this.b = paramInt;
    this.c = ((ej)d.a(b.a(paramIBinder1)));
    this.d = ((dw)d.a(b.a(paramIBinder2)));
    this.e = ((dy)d.a(b.a(paramIBinder3)));
    this.f = ((Context)d.a(b.a(paramIBinder4)));
  }

  public cq(dy paramdy, ej paramej, dw paramdw, Context paramContext)
  {
    this.b = 1;
    this.e = paramdy;
    this.c = paramej;
    this.d = paramdw;
    this.f = paramContext;
  }

  public static cq a(Intent paramIntent)
  {
    try
    {
      Bundle localBundle = paramIntent.getBundleExtra("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo");
      localBundle.setClassLoader(cq.class.getClassLoader());
      localcq = (cq)localBundle.getParcelable("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo");
      return localcq;
    }
    catch (Exception localException)
    {
      while (true)
        cq localcq = null;
    }
  }

  public static void a(Intent paramIntent, cq paramcq)
  {
    Bundle localBundle = new Bundle(1);
    localBundle.putParcelable("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo", paramcq);
    paramIntent.putExtra("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo", localBundle);
  }

  IBinder a()
  {
    return d.a(this.c).asBinder();
  }

  IBinder b()
  {
    return d.a(this.d).asBinder();
  }

  IBinder c()
  {
    return d.a(this.e).asBinder();
  }

  IBinder d()
  {
    return d.a(this.f).asBinder();
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    dj.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.cq
 * JD-Core Version:    0.6.0
 */