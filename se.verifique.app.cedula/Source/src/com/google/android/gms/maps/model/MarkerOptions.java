package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class MarkerOptions
  implements SafeParcelable
{
  public static final g a = new g();
  private final int b;
  private LatLng c;
  private String d;
  private String e;
  private a f;
  private float g = 0.5F;
  private float h = 1.0F;
  private boolean i;
  private boolean j = true;
  private boolean k = false;
  private float l = 0.0F;
  private float m = 0.5F;
  private float n = 0.0F;
  private float o = 1.0F;

  public MarkerOptions()
  {
    this.b = 1;
  }

  MarkerOptions(int paramInt, LatLng paramLatLng, String paramString1, String paramString2, IBinder paramIBinder, float paramFloat1, float paramFloat2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    this.b = paramInt;
    this.c = paramLatLng;
    this.d = paramString1;
    this.e = paramString2;
    if (paramIBinder == null);
    for (a locala = null; ; locala = new a(com.google.android.gms.a.b.a(paramIBinder)))
    {
      this.f = locala;
      this.g = paramFloat1;
      this.h = paramFloat2;
      this.i = paramBoolean1;
      this.j = paramBoolean2;
      this.k = paramBoolean3;
      this.l = paramFloat3;
      this.m = paramFloat4;
      this.n = paramFloat5;
      this.o = paramFloat6;
      return;
    }
  }

  int a()
  {
    return this.b;
  }

  IBinder b()
  {
    if (this.f == null);
    for (IBinder localIBinder = null; ; localIBinder = this.f.a().asBinder())
      return localIBinder;
  }

  public LatLng c()
  {
    return this.c;
  }

  public String d()
  {
    return this.d;
  }

  public int describeContents()
  {
    return 0;
  }

  public String e()
  {
    return this.e;
  }

  public float f()
  {
    return this.g;
  }

  public float g()
  {
    return this.h;
  }

  public boolean h()
  {
    return this.i;
  }

  public boolean i()
  {
    return this.j;
  }

  public boolean j()
  {
    return this.k;
  }

  public float k()
  {
    return this.l;
  }

  public float l()
  {
    return this.m;
  }

  public float m()
  {
    return this.n;
  }

  public float n()
  {
    return this.o;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (com.google.android.gms.maps.a.b.a())
      y.a(this, paramParcel, paramInt);
    while (true)
    {
      return;
      g.a(this, paramParcel, paramInt);
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.MarkerOptions
 * JD-Core Version:    0.6.0
 */