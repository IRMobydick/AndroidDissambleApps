package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class il
  implements SafeParcelable
{
  public static final Parcelable.Creator<il> CREATOR = new im();
  private final int BR;
  private double FA;
  private boolean FB;
  private int GB;
  private int GC;
  private ApplicationMetadata GN;

  public il()
  {
    this(3, (0.0D / 0.0D), false, -1, null, -1);
  }

  il(int paramInt1, double paramDouble, boolean paramBoolean, int paramInt2, ApplicationMetadata paramApplicationMetadata, int paramInt3)
  {
    this.BR = paramInt1;
    this.FA = paramDouble;
    this.FB = paramBoolean;
    this.GB = paramInt2;
    this.GN = paramApplicationMetadata;
    this.GC = paramInt3;
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (paramObject == this);
    il localil;
    do
    {
      return true;
      if (!(paramObject instanceof il))
        return false;
      localil = (il)paramObject;
    }
    while ((this.FA == localil.FA) && (this.FB == localil.FB) && (this.GB == localil.GB) && (ik.a(this.GN, localil.GN)) && (this.GC == localil.GC));
    return false;
  }

  public double fE()
  {
    return this.FA;
  }

  public boolean fM()
  {
    return this.FB;
  }

  public int fN()
  {
    return this.GB;
  }

  public int fO()
  {
    return this.GC;
  }

  public ApplicationMetadata getApplicationMetadata()
  {
    return this.GN;
  }

  public int getVersionCode()
  {
    return this.BR;
  }

  public int hashCode()
  {
    Object[] arrayOfObject = new Object[5];
    arrayOfObject[0] = Double.valueOf(this.FA);
    arrayOfObject[1] = Boolean.valueOf(this.FB);
    arrayOfObject[2] = Integer.valueOf(this.GB);
    arrayOfObject[3] = this.GN;
    arrayOfObject[4] = Integer.valueOf(this.GC);
    return n.hashCode(arrayOfObject);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    im.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.il
 * JD-Core Version:    0.6.2
 */