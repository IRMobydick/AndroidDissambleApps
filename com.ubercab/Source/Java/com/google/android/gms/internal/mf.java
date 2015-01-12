package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class mf
  implements SafeParcelable
{
  public static final mg CREATOR = new mg();
  final int BR;
  private final boolean afn;
  private final List<mp> afo;

  mf(int paramInt, boolean paramBoolean, List<mp> paramList)
  {
    this.BR = paramInt;
    this.afn = paramBoolean;
    this.afo = paramList;
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean me()
  {
    return this.afn;
  }

  public List<mp> mf()
  {
    return this.afo;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    mg.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.mf
 * JD-Core Version:    0.6.2
 */