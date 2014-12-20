package com.google.android.gms.wallet.fragment;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class WalletFragmentOptions
  implements SafeParcelable
{
  public static final Parcelable.Creator CREATOR = new b();
  final int a;
  private int b;
  private int c;
  private WalletFragmentStyle d;
  private int e;

  private WalletFragmentOptions()
  {
    this.a = 1;
  }

  WalletFragmentOptions(int paramInt1, int paramInt2, int paramInt3, WalletFragmentStyle paramWalletFragmentStyle, int paramInt4)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.d = paramWalletFragmentStyle;
    this.e = paramInt4;
  }

  public int a()
  {
    return this.b;
  }

  public int b()
  {
    return this.c;
  }

  public WalletFragmentStyle c()
  {
    return this.d;
  }

  public int d()
  {
    return this.e;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    b.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.wallet.fragment.WalletFragmentOptions
 * JD-Core Version:    0.6.0
 */