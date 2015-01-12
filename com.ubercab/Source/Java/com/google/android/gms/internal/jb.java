package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class jb
  implements SafeParcelable
{
  public static final jc CREATOR = new jc();
  final int BR;
  public final String Mq;
  public final int Mr;

  public jb(int paramInt1, String paramString, int paramInt2)
  {
    this.BR = paramInt1;
    this.Mq = paramString;
    this.Mr = paramInt2;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    jc.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.jb
 * JD-Core Version:    0.6.2
 */