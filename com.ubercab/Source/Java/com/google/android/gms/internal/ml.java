package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.n.a;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ml
  implements SafeParcelable
{
  public static final mm CREATOR = new mm();
  final int BR;
  private final String afz;
  private final String mTag;

  ml(int paramInt, String paramString1, String paramString2)
  {
    this.BR = paramInt;
    this.afz = paramString1;
    this.mTag = paramString2;
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof ml));
    ml localml;
    do
    {
      return false;
      localml = (ml)paramObject;
    }
    while ((!n.equal(this.afz, localml.afz)) || (!n.equal(this.mTag, localml.mTag)));
    return true;
  }

  public String getTag()
  {
    return this.mTag;
  }

  public int hashCode()
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = this.afz;
    arrayOfObject[1] = this.mTag;
    return n.hashCode(arrayOfObject);
  }

  public String mk()
  {
    return this.afz;
  }

  public String toString()
  {
    return n.h(this).a("mPlaceId", this.afz).a("mTag", this.mTag).toString();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    mm.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ml
 * JD-Core Version:    0.6.2
 */