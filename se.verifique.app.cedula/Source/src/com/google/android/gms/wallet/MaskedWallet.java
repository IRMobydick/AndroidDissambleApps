package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.identity.intents.model.UserAddress;

public final class MaskedWallet
  implements SafeParcelable
{
  public static final Parcelable.Creator CREATOR = new k();
  String a;
  String b;
  String[] c;
  String d;
  Address e;
  Address f;
  LoyaltyWalletObject[] g;
  OfferWalletObject[] h;
  UserAddress i;
  UserAddress j;
  InstrumentInfo[] k;
  private final int l;

  private MaskedWallet()
  {
    this.l = 2;
  }

  MaskedWallet(int paramInt, String paramString1, String paramString2, String[] paramArrayOfString, String paramString3, Address paramAddress1, Address paramAddress2, LoyaltyWalletObject[] paramArrayOfLoyaltyWalletObject, OfferWalletObject[] paramArrayOfOfferWalletObject, UserAddress paramUserAddress1, UserAddress paramUserAddress2, InstrumentInfo[] paramArrayOfInstrumentInfo)
  {
    this.l = paramInt;
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramArrayOfString;
    this.d = paramString3;
    this.e = paramAddress1;
    this.f = paramAddress2;
    this.g = paramArrayOfLoyaltyWalletObject;
    this.h = paramArrayOfOfferWalletObject;
    this.i = paramUserAddress1;
    this.j = paramUserAddress2;
    this.k = paramArrayOfInstrumentInfo;
  }

  public int a()
  {
    return this.l;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    k.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.wallet.MaskedWallet
 * JD-Core Version:    0.6.0
 */