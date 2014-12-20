package com.google.android.gms.location;

import android.os.Parcel;
import android.os.SystemClock;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.kt;

public final class LocationRequest
  implements SafeParcelable
{
  public static final d h = new d();
  int a;
  long b;
  long c;
  boolean d;
  long e;
  int f;
  float g;
  private final int i;

  public LocationRequest()
  {
    this.i = 1;
    this.a = 102;
    this.b = 3600000L;
    this.c = 600000L;
    this.d = false;
    this.e = 9223372036854775807L;
    this.f = 2147483647;
    this.g = 0.0F;
  }

  LocationRequest(int paramInt1, int paramInt2, long paramLong1, long paramLong2, boolean paramBoolean, long paramLong3, int paramInt3, float paramFloat)
  {
    this.i = paramInt1;
    this.a = paramInt2;
    this.b = paramLong1;
    this.c = paramLong2;
    this.d = paramBoolean;
    this.e = paramLong3;
    this.f = paramInt3;
    this.g = paramFloat;
  }

  public static String a(int paramInt)
  {
    String str;
    switch (paramInt)
    {
    case 101:
    case 103:
    default:
      str = "???";
    case 100:
    case 102:
    case 104:
    case 105:
    }
    while (true)
    {
      return str;
      str = "PRIORITY_HIGH_ACCURACY";
      continue;
      str = "PRIORITY_BALANCED_POWER_ACCURACY";
      continue;
      str = "PRIORITY_LOW_POWER";
      continue;
      str = "PRIORITY_NO_POWER";
    }
  }

  int a()
  {
    return this.i;
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    int j = 1;
    if (this == paramObject);
    while (true)
    {
      return j;
      if (!(paramObject instanceof LocationRequest))
      {
        j = 0;
        continue;
      }
      LocationRequest localLocationRequest = (LocationRequest)paramObject;
      if ((this.a == localLocationRequest.a) && (this.b == localLocationRequest.b) && (this.c == localLocationRequest.c) && (this.d == localLocationRequest.d) && (this.e == localLocationRequest.e) && (this.f == localLocationRequest.f) && (this.g == localLocationRequest.g))
        continue;
      j = 0;
    }
  }

  public int hashCode()
  {
    Object[] arrayOfObject = new Object[7];
    arrayOfObject[0] = Integer.valueOf(this.a);
    arrayOfObject[1] = Long.valueOf(this.b);
    arrayOfObject[2] = Long.valueOf(this.c);
    arrayOfObject[3] = Boolean.valueOf(this.d);
    arrayOfObject[4] = Long.valueOf(this.e);
    arrayOfObject[5] = Integer.valueOf(this.f);
    arrayOfObject[6] = Float.valueOf(this.g);
    return kt.a(arrayOfObject);
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Request[").append(a(this.a));
    if (this.a != 105)
    {
      localStringBuilder.append(" requested=");
      localStringBuilder.append(this.b + "ms");
    }
    localStringBuilder.append(" fastest=");
    localStringBuilder.append(this.c + "ms");
    if (this.e != 9223372036854775807L)
    {
      long l = this.e - SystemClock.elapsedRealtime();
      localStringBuilder.append(" expireIn=");
      localStringBuilder.append(l + "ms");
    }
    if (this.f != 2147483647)
      localStringBuilder.append(" num=").append(this.f);
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    d.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.location.LocationRequest
 * JD-Core Version:    0.6.0
 */