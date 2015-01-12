package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.n.a;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class mh
  implements SafeParcelable
{
  public static final mi CREATOR = new mi();
  private final int BR;
  private final int aeh;
  private final int afp;
  private final mj afq;

  mh(int paramInt1, int paramInt2, int paramInt3, mj parammj)
  {
    this.BR = paramInt1;
    this.aeh = paramInt2;
    this.afp = paramInt3;
    this.afq = parammj;
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    mh localmh;
    do
    {
      return true;
      if (!(paramObject instanceof mh))
        return false;
      localmh = (mh)paramObject;
    }
    while ((this.aeh == localmh.aeh) && (this.afp == localmh.afp) && (this.afq.equals(localmh.afq)));
    return false;
  }

  public int getVersionCode()
  {
    return this.BR;
  }

  public int hashCode()
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = Integer.valueOf(this.aeh);
    arrayOfObject[1] = Integer.valueOf(this.afp);
    return n.hashCode(arrayOfObject);
  }

  public int mc()
  {
    return this.aeh;
  }

  public int mg()
  {
    return this.afp;
  }

  public mj mh()
  {
    return this.afq;
  }

  public String toString()
  {
    return n.h(this).a("transitionTypes", Integer.valueOf(this.aeh)).a("loiteringTimeMillis", Integer.valueOf(this.afp)).a("placeFilter", this.afq).toString();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    mi.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.mh
 * JD-Core Version:    0.6.2
 */