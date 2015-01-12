package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ig
  implements SafeParcelable
{
  public static final Parcelable.Creator<ig> CREATOR = new ih();
  private final int BR;
  private String Gn;

  public ig()
  {
    this(1, null);
  }

  ig(int paramInt, String paramString)
  {
    this.BR = paramInt;
    this.Gn = paramString;
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (paramObject == this)
      return true;
    if (!(paramObject instanceof ig))
      return false;
    ig localig = (ig)paramObject;
    return ik.a(this.Gn, localig.Gn);
  }

  public String fy()
  {
    return this.Gn;
  }

  public int getVersionCode()
  {
    return this.BR;
  }

  public int hashCode()
  {
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = this.Gn;
    return n.hashCode(arrayOfObject);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ih.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ig
 * JD-Core Version:    0.6.2
 */