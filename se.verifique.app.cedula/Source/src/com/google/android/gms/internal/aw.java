package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.ads.e.a;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class aw
  implements SafeParcelable
{
  public static final an a = new an();
  public final int b;
  public final int c;
  public final int d;
  public final int e;
  public final int f;
  public final int g;
  public final int h;
  public final int i;
  public final int j;
  public final String k;
  public final int l;
  public final String m;
  public final int n;
  public final int o;
  public final String p;

  aw(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, String paramString1, int paramInt10, String paramString2, int paramInt11, int paramInt12, String paramString3)
  {
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramInt3;
    this.e = paramInt4;
    this.f = paramInt5;
    this.g = paramInt6;
    this.h = paramInt7;
    this.i = paramInt8;
    this.j = paramInt9;
    this.k = paramString1;
    this.l = paramInt10;
    this.m = paramString2;
    this.n = paramInt11;
    this.o = paramInt12;
    this.p = paramString3;
  }

  public aw(a parama)
  {
    this.b = 1;
    this.c = parama.a();
    this.d = parama.b();
    this.e = parama.c();
    this.f = parama.d();
    this.g = parama.e();
    this.h = parama.f();
    this.i = parama.g();
    this.j = parama.h();
    this.k = parama.i();
    this.l = parama.j();
    this.m = parama.k();
    this.n = parama.l();
    this.o = parama.m();
    this.p = parama.n();
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    an.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.aw
 * JD-Core Version:    0.6.0
 */