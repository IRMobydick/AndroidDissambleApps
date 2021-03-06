package com.google.android.gms.wallet.fragment;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;

public final class WalletFragmentInitParams
  implements SafeParcelable
{
  public static final Parcelable.Creator CREATOR = new a();
  final int a;
  private String b;
  private MaskedWalletRequest c;
  private int d;
  private MaskedWallet e;

  private WalletFragmentInitParams()
  {
    this.a = 1;
    this.d = -1;
  }

  WalletFragmentInitParams(int paramInt1, String paramString, MaskedWalletRequest paramMaskedWalletRequest, int paramInt2, MaskedWallet paramMaskedWallet)
  {
    this.a = paramInt1;
    this.b = paramString;
    this.c = paramMaskedWalletRequest;
    this.d = paramInt2;
    this.e = paramMaskedWallet;
  }

  public String a()
  {
    return this.b;
  }

  public MaskedWalletRequest b()
  {
    return this.c;
  }

  public int c()
  {
    return this.d;
  }

  public MaskedWallet d()
  {
    return this.e;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    a.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.wallet.fragment.WalletFragmentInitParams
 * JD-Core Version:    0.6.0
 */