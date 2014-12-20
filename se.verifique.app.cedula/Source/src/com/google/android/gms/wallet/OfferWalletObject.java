package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.wobs.CommonWalletObject;
import com.google.android.gms.wallet.wobs.c;

public final class OfferWalletObject
  implements SafeParcelable
{
  public static final Parcelable.Creator CREATOR = new n();
  String a;
  String b;
  CommonWalletObject c;
  private final int d;

  OfferWalletObject()
  {
    this.d = 3;
  }

  OfferWalletObject(int paramInt, String paramString1, String paramString2, CommonWalletObject paramCommonWalletObject)
  {
    this.d = paramInt;
    this.b = paramString2;
    if (paramInt < 3);
    for (this.c = CommonWalletObject.a().a(paramString1).a(); ; this.c = paramCommonWalletObject)
      return;
  }

  public int a()
  {
    return this.d;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    n.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.wallet.OfferWalletObject
 * JD-Core Version:    0.6.0
 */