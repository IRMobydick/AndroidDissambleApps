package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ls
  implements SafeParcelable
{
  public static final lt CREATOR = new lt();
  private final int BR;
  public final String packageName;
  public final int uid;

  ls(int paramInt1, int paramInt2, String paramString)
  {
    this.BR = paramInt1;
    this.uid = paramInt2;
    this.packageName = paramString;
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof ls));
    ls localls;
    do
    {
      return false;
      localls = (ls)paramObject;
    }
    while ((localls.uid != this.uid) || (!n.equal(localls.packageName, this.packageName)));
    return true;
  }

  int getVersionCode()
  {
    return this.BR;
  }

  public int hashCode()
  {
    return this.uid;
  }

  public String toString()
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = Integer.valueOf(this.uid);
    arrayOfObject[1] = this.packageName;
    return String.format("%d:%s", arrayOfObject);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    lt.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ls
 * JD-Core Version:    0.6.2
 */