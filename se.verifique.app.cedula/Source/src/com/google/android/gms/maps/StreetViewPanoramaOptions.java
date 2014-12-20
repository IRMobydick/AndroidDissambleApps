package com.google.android.gms.maps;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.a.a;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;

public final class StreetViewPanoramaOptions
  implements SafeParcelable
{
  public static final b a = new b();
  private final int b;
  private StreetViewPanoramaCamera c;
  private String d;
  private LatLng e;
  private Integer f;
  private Boolean g = Boolean.valueOf(true);
  private Boolean h = Boolean.valueOf(true);
  private Boolean i = Boolean.valueOf(true);
  private Boolean j = Boolean.valueOf(true);
  private Boolean k;

  public StreetViewPanoramaOptions()
  {
    this.b = 1;
  }

  StreetViewPanoramaOptions(int paramInt, StreetViewPanoramaCamera paramStreetViewPanoramaCamera, String paramString, LatLng paramLatLng, Integer paramInteger, byte paramByte1, byte paramByte2, byte paramByte3, byte paramByte4, byte paramByte5)
  {
    this.b = paramInt;
    this.c = paramStreetViewPanoramaCamera;
    this.e = paramLatLng;
    this.f = paramInteger;
    this.d = paramString;
    this.g = a.a(paramByte1);
    this.h = a.a(paramByte2);
    this.i = a.a(paramByte3);
    this.j = a.a(paramByte4);
    this.k = a.a(paramByte5);
  }

  int a()
  {
    return this.b;
  }

  byte b()
  {
    return a.a(this.g);
  }

  byte c()
  {
    return a.a(this.h);
  }

  byte d()
  {
    return a.a(this.i);
  }

  public int describeContents()
  {
    return 0;
  }

  byte e()
  {
    return a.a(this.j);
  }

  byte f()
  {
    return a.a(this.k);
  }

  public StreetViewPanoramaCamera g()
  {
    return this.c;
  }

  public LatLng h()
  {
    return this.e;
  }

  public Integer i()
  {
    return this.f;
  }

  public String j()
  {
    return this.d;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    b.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.StreetViewPanoramaOptions
 * JD-Core Version:    0.6.0
 */