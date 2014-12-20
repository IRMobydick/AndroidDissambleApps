package com.google.android.gms.maps;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.a.b;
import com.google.android.gms.maps.model.CameraPosition;

public final class GoogleMapOptions
  implements SafeParcelable
{
  public static final a a = new a();
  private final int b;
  private Boolean c;
  private Boolean d;
  private int e = -1;
  private CameraPosition f;
  private Boolean g;
  private Boolean h;
  private Boolean i;
  private Boolean j;
  private Boolean k;
  private Boolean l;

  public GoogleMapOptions()
  {
    this.b = 1;
  }

  GoogleMapOptions(int paramInt1, byte paramByte1, byte paramByte2, int paramInt2, CameraPosition paramCameraPosition, byte paramByte3, byte paramByte4, byte paramByte5, byte paramByte6, byte paramByte7, byte paramByte8)
  {
    this.b = paramInt1;
    this.c = com.google.android.gms.maps.a.a.a(paramByte1);
    this.d = com.google.android.gms.maps.a.a.a(paramByte2);
    this.e = paramInt2;
    this.f = paramCameraPosition;
    this.g = com.google.android.gms.maps.a.a.a(paramByte3);
    this.h = com.google.android.gms.maps.a.a.a(paramByte4);
    this.i = com.google.android.gms.maps.a.a.a(paramByte5);
    this.j = com.google.android.gms.maps.a.a.a(paramByte6);
    this.k = com.google.android.gms.maps.a.a.a(paramByte7);
    this.l = com.google.android.gms.maps.a.a.a(paramByte8);
  }

  int a()
  {
    return this.b;
  }

  byte b()
  {
    return com.google.android.gms.maps.a.a.a(this.c);
  }

  byte c()
  {
    return com.google.android.gms.maps.a.a.a(this.d);
  }

  byte d()
  {
    return com.google.android.gms.maps.a.a.a(this.g);
  }

  public int describeContents()
  {
    return 0;
  }

  byte e()
  {
    return com.google.android.gms.maps.a.a.a(this.h);
  }

  byte f()
  {
    return com.google.android.gms.maps.a.a.a(this.i);
  }

  byte g()
  {
    return com.google.android.gms.maps.a.a.a(this.j);
  }

  byte h()
  {
    return com.google.android.gms.maps.a.a.a(this.k);
  }

  byte i()
  {
    return com.google.android.gms.maps.a.a.a(this.l);
  }

  public int j()
  {
    return this.e;
  }

  public CameraPosition k()
  {
    return this.f;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (b.a())
      c.a(this, paramParcel, paramInt);
    while (true)
    {
      return;
      a.a(this, paramParcel, paramInt);
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.GoogleMapOptions
 * JD-Core Version:    0.6.0
 */