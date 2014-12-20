package com.google.android.gms.wallet.fragment;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class WalletFragmentStyle
  implements SafeParcelable
{
  public static final Parcelable.Creator CREATOR = new c();
  final int a;
  Bundle b;
  int c;

  public WalletFragmentStyle()
  {
    this.a = 1;
    this.b = new Bundle();
  }

  WalletFragmentStyle(int paramInt1, Bundle paramBundle, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramBundle;
    this.c = paramInt2;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    c.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.wallet.fragment.WalletFragmentStyle
 * JD-Core Version:    0.6.0
 */