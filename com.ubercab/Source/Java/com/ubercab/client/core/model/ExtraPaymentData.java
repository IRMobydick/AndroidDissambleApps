package com.ubercab.client.core.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class ExtraPaymentData
  implements Parcelable
{
  public static Parcelable.Creator<ExtraPaymentData> CREATOR = new Parcelable.Creator()
  {
    public ExtraPaymentData createFromParcel(Parcel paramAnonymousParcel)
    {
      return new ExtraPaymentData(paramAnonymousParcel, null);
    }

    public ExtraPaymentData[] newArray(int paramAnonymousInt)
    {
      return new ExtraPaymentData[paramAnonymousInt];
    }
  };
  Boolean useAmexReward;

  public ExtraPaymentData()
  {
  }

  private ExtraPaymentData(Parcel paramParcel)
  {
    this.useAmexReward = ((Boolean)paramParcel.readValue(Boolean.class.getClassLoader()));
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    ExtraPaymentData localExtraPaymentData;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localExtraPaymentData = (ExtraPaymentData)paramObject;
      if (this.useAmexReward == null)
        break;
    }
    while (this.useAmexReward.equals(localExtraPaymentData.useAmexReward));
    while (true)
    {
      return false;
      if (localExtraPaymentData.useAmexReward == null)
        break;
    }
  }

  public int hashCode()
  {
    if (this.useAmexReward != null)
      return this.useAmexReward.hashCode();
    return 0;
  }

  public boolean useRewards()
  {
    if (this.useAmexReward == null)
      return false;
    return this.useAmexReward.booleanValue();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeValue(this.useAmexReward);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.model.ExtraPaymentData
 * JD-Core Version:    0.6.2
 */