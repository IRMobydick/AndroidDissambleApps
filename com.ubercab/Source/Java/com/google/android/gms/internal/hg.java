package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class hg
  implements SafeParcelable
{
  public static final hh CREATOR = new hh();
  final int BR;
  final String BZ;
  final String Ca;
  final String Cb;

  hg(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    this.BR = paramInt;
    this.BZ = paramString1;
    this.Ca = paramString2;
    this.Cb = paramString3;
  }

  public hg(String paramString1, String paramString2, String paramString3)
  {
    this(1, paramString1, paramString2, paramString3);
  }

  public int describeContents()
  {
    return 0;
  }

  public String toString()
  {
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = this.BZ;
    arrayOfObject[1] = this.Ca;
    arrayOfObject[2] = this.Cb;
    return String.format("DocumentId[packageName=%s, corpusName=%s, uri=%s]", arrayOfObject);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    hh.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.hg
 * JD-Core Version:    0.6.2
 */