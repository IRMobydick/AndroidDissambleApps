package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class n
  implements SafeParcelable
{
  public static final Parcelable.Creator<n> CREATOR = new o();
  private final int BR;
  String auM;
  String description;

  n()
  {
    this.BR = 1;
  }

  n(int paramInt, String paramString1, String paramString2)
  {
    this.BR = paramInt;
    this.auM = paramString1;
    this.description = paramString2;
  }

  public int describeContents()
  {
    return 0;
  }

  public int getVersionCode()
  {
    return this.BR;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    o.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wallet.wobs.n
 * JD-Core Version:    0.6.2
 */