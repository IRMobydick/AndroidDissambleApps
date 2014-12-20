package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.concurrent.TimeUnit;

public final class jq
  implements SafeParcelable
{
  public static final ms a = new ms();
  static final long b = TimeUnit.HOURS.toMillis(1L);
  final int c;
  private final jm d;
  private final long e;
  private final int f;

  public jq(int paramInt1, jm paramjm, long paramLong, int paramInt2)
  {
    this.c = paramInt1;
    this.d = paramjm;
    this.e = paramLong;
    this.f = paramInt2;
  }

  public jm a()
  {
    return this.d;
  }

  public long b()
  {
    return this.e;
  }

  public int c()
  {
    return this.f;
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    int i = 1;
    if (this == paramObject);
    while (true)
    {
      return i;
      if (!(paramObject instanceof jq))
      {
        i = 0;
        continue;
      }
      jq localjq = (jq)paramObject;
      if ((kt.a(this.d, localjq.d)) && (this.e == localjq.e) && (this.f == localjq.f))
        continue;
      i = 0;
    }
  }

  public int hashCode()
  {
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = this.d;
    arrayOfObject[1] = Long.valueOf(this.e);
    arrayOfObject[2] = Integer.valueOf(this.f);
    return kt.a(arrayOfObject);
  }

  public String toString()
  {
    return kt.a(this).a("filter", this.d).a("interval", Long.valueOf(this.e)).a("priority", Integer.valueOf(this.f)).toString();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ms.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.jq
 * JD-Core Version:    0.6.0
 */