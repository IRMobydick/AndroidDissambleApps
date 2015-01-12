package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSource;

public class li
  implements SafeParcelable
{
  public static final Parcelable.Creator<li> CREATOR = new lj();
  private final int BR;
  private final DataSource Sq;

  li(int paramInt, DataSource paramDataSource)
  {
    this.BR = paramInt;
    this.Sq = paramDataSource;
  }

  public int describeContents()
  {
    return 0;
  }

  public DataSource getDataSource()
  {
    return this.Sq;
  }

  int getVersionCode()
  {
    return this.BR;
  }

  public String toString()
  {
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = this.Sq;
    return String.format("ApplicationUnregistrationRequest{%s}", arrayOfObject);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    lj.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.li
 * JD-Core Version:    0.6.2
 */