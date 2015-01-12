package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.o;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class mt
  implements SafeParcelable
{
  public static final mu CREATOR = new mu();
  public static final mt aic = y("test_type", 1);
  public static final mt aid = y("trellis_store", 2);
  public static final mt aie = y("labeled_place", 6);
  public static final Set<mt> aif;
  final int BR;
  final int aig;
  final String uO;

  static
  {
    mt[] arrayOfmt = new mt[3];
    arrayOfmt[0] = aic;
    arrayOfmt[1] = aid;
    arrayOfmt[2] = aie;
    aif = Collections.unmodifiableSet(new HashSet(Arrays.asList(arrayOfmt)));
  }

  mt(int paramInt1, String paramString, int paramInt2)
  {
    o.aZ(paramString);
    this.BR = paramInt1;
    this.uO = paramString;
    this.aig = paramInt2;
  }

  private static mt y(String paramString, int paramInt)
  {
    return new mt(0, paramString, paramInt);
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    mt localmt;
    do
    {
      return true;
      if (!(paramObject instanceof mt))
        return false;
      localmt = (mt)paramObject;
    }
    while ((this.uO.equals(localmt.uO)) && (this.aig == localmt.aig));
    return false;
  }

  public int hashCode()
  {
    return this.uO.hashCode();
  }

  public String toString()
  {
    return this.uO;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    mu.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.mt
 * JD-Core Version:    0.6.2
 */