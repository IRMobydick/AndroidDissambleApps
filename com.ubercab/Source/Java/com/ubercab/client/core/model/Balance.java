package com.ubercab.client.core.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class Balance
  implements Parcelable
{
  public static Parcelable.Creator<Balance> CREATOR = new Parcelable.Creator()
  {
    public Balance createFromParcel(Parcel paramAnonymousParcel)
    {
      return new Balance(paramAnonymousParcel, null);
    }

    public Balance[] newArray(int paramAnonymousInt)
    {
      return new Balance[paramAnonymousInt];
    }
  };
  private Float currency_amount;
  private String currency_code;
  private Integer rewards_amount;
  Float rewards_to_currency_ratio;

  public Balance()
  {
  }

  private Balance(Parcel paramParcel)
  {
    this.rewards_amount = ((Integer)paramParcel.readValue(Integer.class.getClassLoader()));
    this.currency_code = paramParcel.readString();
    this.currency_amount = ((Float)paramParcel.readValue(Float.class.getClassLoader()));
    this.rewards_to_currency_ratio = ((Float)paramParcel.readValue(Float.class.getClassLoader()));
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    Balance localBalance;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localBalance = (Balance)paramObject;
      if (this.currency_amount != null)
      {
        if (this.currency_amount.equals(localBalance.currency_amount));
      }
      else
        while (localBalance.currency_amount != null)
          return false;
      if (this.currency_code != null)
      {
        if (this.currency_code.equals(localBalance.currency_code));
      }
      else
        while (localBalance.currency_code != null)
          return false;
      if (this.rewards_amount != null)
      {
        if (this.rewards_amount.equals(localBalance.rewards_amount));
      }
      else
        while (localBalance.rewards_amount != null)
          return false;
      if (this.rewards_to_currency_ratio == null)
        break;
    }
    while (this.rewards_to_currency_ratio.equals(localBalance.rewards_to_currency_ratio));
    while (true)
    {
      return false;
      if (localBalance.rewards_to_currency_ratio == null)
        break;
    }
  }

  public float getCurrencyAmount()
  {
    if (this.currency_amount == null)
      return 0.0F;
    return this.currency_amount.floatValue();
  }

  public String getCurrencyCode()
  {
    return this.currency_code;
  }

  public int getRewardsAmount()
  {
    if (this.rewards_amount == null)
      return 0;
    return this.rewards_amount.intValue();
  }

  public float getRewardsToCurrencyRatio()
  {
    if (this.rewards_to_currency_ratio == null)
      return 0.0F;
    return this.rewards_to_currency_ratio.floatValue();
  }

  public int hashCode()
  {
    int i;
    int k;
    label35: int m;
    if (this.currency_code != null)
    {
      i = this.currency_code.hashCode();
      int j = i * 31;
      if (this.currency_amount == null)
        break label103;
      k = this.currency_amount.hashCode();
      m = 31 * (j + k);
      if (this.rewards_amount == null)
        break label108;
    }
    label103: label108: for (int n = this.rewards_amount.hashCode(); ; n = 0)
    {
      int i1 = 31 * (m + n);
      Float localFloat = this.rewards_to_currency_ratio;
      int i2 = 0;
      if (localFloat != null)
        i2 = this.rewards_to_currency_ratio.hashCode();
      return i1 + i2;
      i = 0;
      break;
      k = 0;
      break label35;
    }
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeValue(this.rewards_amount);
    paramParcel.writeString(this.currency_code);
    paramParcel.writeValue(this.currency_amount);
    paramParcel.writeValue(this.rewards_to_currency_ratio);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.model.Balance
 * JD-Core Version:    0.6.2
 */