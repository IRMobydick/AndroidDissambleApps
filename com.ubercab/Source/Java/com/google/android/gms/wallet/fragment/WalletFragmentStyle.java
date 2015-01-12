package com.google.android.gms.wallet.fragment;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.google.android.gms.R.style;
import com.google.android.gms.R.styleable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class WalletFragmentStyle
  implements SafeParcelable
{
  public static final Parcelable.Creator<WalletFragmentStyle> CREATOR = new c();
  final int BR;
  Bundle auo;
  int aup;

  public WalletFragmentStyle()
  {
    this.BR = 1;
    this.auo = new Bundle();
  }

  WalletFragmentStyle(int paramInt1, Bundle paramBundle, int paramInt2)
  {
    this.BR = paramInt1;
    this.auo = paramBundle;
    this.aup = paramInt2;
  }

  private void a(TypedArray paramTypedArray, int paramInt, String paramString)
  {
    if (this.auo.containsKey(paramString));
    TypedValue localTypedValue;
    do
    {
      return;
      localTypedValue = paramTypedArray.peekValue(paramInt);
    }
    while (localTypedValue == null);
    this.auo.putLong(paramString, Dimension.a(localTypedValue));
  }

  private void a(TypedArray paramTypedArray, int paramInt, String paramString1, String paramString2)
  {
    if ((this.auo.containsKey(paramString1)) || (this.auo.containsKey(paramString2)));
    TypedValue localTypedValue;
    do
    {
      return;
      localTypedValue = paramTypedArray.peekValue(paramInt);
    }
    while (localTypedValue == null);
    if ((localTypedValue.type >= 28) && (localTypedValue.type <= 31))
    {
      this.auo.putInt(paramString1, localTypedValue.data);
      return;
    }
    this.auo.putInt(paramString2, localTypedValue.resourceId);
  }

  private void b(TypedArray paramTypedArray, int paramInt, String paramString)
  {
    if (this.auo.containsKey(paramString));
    TypedValue localTypedValue;
    do
    {
      return;
      localTypedValue = paramTypedArray.peekValue(paramInt);
    }
    while (localTypedValue == null);
    this.auo.putInt(paramString, localTypedValue.data);
  }

  public int a(String paramString, DisplayMetrics paramDisplayMetrics, int paramInt)
  {
    if (this.auo.containsKey(paramString))
      paramInt = Dimension.a(this.auo.getLong(paramString), paramDisplayMetrics);
    return paramInt;
  }

  public void aa(Context paramContext)
  {
    if (this.aup <= 0);
    for (int i = R.style.WalletFragmentDefaultStyle; ; i = this.aup)
    {
      TypedArray localTypedArray = paramContext.obtainStyledAttributes(i, R.styleable.WalletFragmentStyle);
      a(localTypedArray, R.styleable.WalletFragmentStyle_buyButtonWidth, "buyButtonWidth");
      a(localTypedArray, R.styleable.WalletFragmentStyle_buyButtonHeight, "buyButtonHeight");
      b(localTypedArray, R.styleable.WalletFragmentStyle_buyButtonText, "buyButtonText");
      b(localTypedArray, R.styleable.WalletFragmentStyle_buyButtonAppearance, "buyButtonAppearance");
      b(localTypedArray, R.styleable.WalletFragmentStyle_maskedWalletDetailsTextAppearance, "maskedWalletDetailsTextAppearance");
      b(localTypedArray, R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance, "maskedWalletDetailsHeaderTextAppearance");
      a(localTypedArray, R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground, "maskedWalletDetailsBackgroundColor", "maskedWalletDetailsBackgroundResource");
      b(localTypedArray, R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance, "maskedWalletDetailsButtonTextAppearance");
      a(localTypedArray, R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonBackground, "maskedWalletDetailsButtonBackgroundColor", "maskedWalletDetailsButtonBackgroundResource");
      b(localTypedArray, R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoTextColor, "maskedWalletDetailsLogoTextColor");
      b(localTypedArray, R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoImageType, "maskedWalletDetailsLogoImageType");
      localTypedArray.recycle();
      return;
    }
  }

  public int describeContents()
  {
    return 0;
  }

  public WalletFragmentStyle setBuyButtonAppearance(int paramInt)
  {
    this.auo.putInt("buyButtonAppearance", paramInt);
    return this;
  }

  public WalletFragmentStyle setBuyButtonHeight(int paramInt)
  {
    this.auo.putLong("buyButtonHeight", Dimension.fE(paramInt));
    return this;
  }

  public WalletFragmentStyle setBuyButtonHeight(int paramInt, float paramFloat)
  {
    this.auo.putLong("buyButtonHeight", Dimension.a(paramInt, paramFloat));
    return this;
  }

  public WalletFragmentStyle setBuyButtonText(int paramInt)
  {
    this.auo.putInt("buyButtonText", paramInt);
    return this;
  }

  public WalletFragmentStyle setBuyButtonWidth(int paramInt)
  {
    this.auo.putLong("buyButtonWidth", Dimension.fE(paramInt));
    return this;
  }

  public WalletFragmentStyle setBuyButtonWidth(int paramInt, float paramFloat)
  {
    this.auo.putLong("buyButtonWidth", Dimension.a(paramInt, paramFloat));
    return this;
  }

  public WalletFragmentStyle setMaskedWalletDetailsBackgroundColor(int paramInt)
  {
    this.auo.remove("maskedWalletDetailsBackgroundResource");
    this.auo.putInt("maskedWalletDetailsBackgroundColor", paramInt);
    return this;
  }

  public WalletFragmentStyle setMaskedWalletDetailsBackgroundResource(int paramInt)
  {
    this.auo.remove("maskedWalletDetailsBackgroundColor");
    this.auo.putInt("maskedWalletDetailsBackgroundResource", paramInt);
    return this;
  }

  public WalletFragmentStyle setMaskedWalletDetailsButtonBackgroundColor(int paramInt)
  {
    this.auo.remove("maskedWalletDetailsButtonBackgroundResource");
    this.auo.putInt("maskedWalletDetailsButtonBackgroundColor", paramInt);
    return this;
  }

  public WalletFragmentStyle setMaskedWalletDetailsButtonBackgroundResource(int paramInt)
  {
    this.auo.remove("maskedWalletDetailsButtonBackgroundColor");
    this.auo.putInt("maskedWalletDetailsButtonBackgroundResource", paramInt);
    return this;
  }

  public WalletFragmentStyle setMaskedWalletDetailsButtonTextAppearance(int paramInt)
  {
    this.auo.putInt("maskedWalletDetailsButtonTextAppearance", paramInt);
    return this;
  }

  public WalletFragmentStyle setMaskedWalletDetailsHeaderTextAppearance(int paramInt)
  {
    this.auo.putInt("maskedWalletDetailsHeaderTextAppearance", paramInt);
    return this;
  }

  public WalletFragmentStyle setMaskedWalletDetailsLogoImageType(int paramInt)
  {
    this.auo.putInt("maskedWalletDetailsLogoImageType", paramInt);
    return this;
  }

  public WalletFragmentStyle setMaskedWalletDetailsLogoTextColor(int paramInt)
  {
    this.auo.putInt("maskedWalletDetailsLogoTextColor", paramInt);
    return this;
  }

  public WalletFragmentStyle setMaskedWalletDetailsTextAppearance(int paramInt)
  {
    this.auo.putInt("maskedWalletDetailsTextAppearance", paramInt);
    return this;
  }

  public WalletFragmentStyle setStyleResourceId(int paramInt)
  {
    this.aup = paramInt;
    return this;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    c.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wallet.fragment.WalletFragmentStyle
 * JD-Core Version:    0.6.2
 */