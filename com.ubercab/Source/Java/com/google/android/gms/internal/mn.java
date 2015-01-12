package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.n.a;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.concurrent.TimeUnit;

public final class mn
  implements SafeParcelable
{
  public static final mo CREATOR = new mo();
  static final long afA = TimeUnit.HOURS.toMillis(1L);
  final int BR;
  private final long aes;
  private final mj afB;
  private final int mPriority;

  public mn(int paramInt1, mj parammj, long paramLong, int paramInt2)
  {
    this.BR = paramInt1;
    this.afB = parammj;
    this.aes = paramLong;
    this.mPriority = paramInt2;
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    mn localmn;
    do
    {
      return true;
      if (!(paramObject instanceof mn))
        return false;
      localmn = (mn)paramObject;
    }
    while ((n.equal(this.afB, localmn.afB)) && (this.aes == localmn.aes) && (this.mPriority == localmn.mPriority));
    return false;
  }

  public long getInterval()
  {
    return this.aes;
  }

  public int getPriority()
  {
    return this.mPriority;
  }

  public int hashCode()
  {
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = this.afB;
    arrayOfObject[1] = Long.valueOf(this.aes);
    arrayOfObject[2] = Integer.valueOf(this.mPriority);
    return n.hashCode(arrayOfObject);
  }

  public mj mh()
  {
    return this.afB;
  }

  public String toString()
  {
    return n.h(this).a("filter", this.afB).a("interval", Long.valueOf(this.aes)).a("priority", Integer.valueOf(this.mPriority)).toString();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    mo.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.mn
 * JD-Core Version:    0.6.2
 */