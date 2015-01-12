package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class d
  implements SafeParcelable
{
  public static final Parcelable.Creator<d> CREATOR = new e();
  private final int BR;
  OfferWalletObject asA;
  LoyaltyWalletObject asz;

  d()
  {
    this.BR = 2;
  }

  d(int paramInt, LoyaltyWalletObject paramLoyaltyWalletObject, OfferWalletObject paramOfferWalletObject)
  {
    this.BR = paramInt;
    this.asz = paramLoyaltyWalletObject;
    this.asA = paramOfferWalletObject;
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
    e.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wallet.d
 * JD-Core Version:    0.6.2
 */