package com.ubercab.client.core.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;

public final class RewardInfo
  implements Parcelable
{
  public static Parcelable.Creator<RewardInfo> CREATOR = new Parcelable.Creator()
  {
    public RewardInfo createFromParcel(Parcel paramAnonymousParcel)
    {
      return new RewardInfo(paramAnonymousParcel, null);
    }

    public RewardInfo[] newArray(int paramAnonymousInt)
    {
      return new RewardInfo[paramAnonymousInt];
    }
  };
  private static final String ELIGIBLE_FOR_EARN_AND_BURN = "B";
  private static final String ELIGIBLE_FOR_EARN_ONLY = "E";
  private static final String NOT_ELIGIBLE = "N";
  Balance balance;
  String eligibleFor;
  Boolean enabled;
  Boolean enrolled;

  public RewardInfo()
  {
  }

  private RewardInfo(Parcel paramParcel)
  {
    this.balance = ((Balance)paramParcel.readParcelable(Balance.class.getClassLoader()));
    this.eligibleFor = paramParcel.readString();
    this.enabled = ((Boolean)paramParcel.readValue(Boolean.class.getClassLoader()));
    this.enrolled = ((Boolean)paramParcel.readValue(Boolean.class.getClassLoader()));
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean eligibleToUsePoints()
  {
    return (!TextUtils.isEmpty(this.eligibleFor)) && ("B".equals(this.eligibleFor));
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    RewardInfo localRewardInfo;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localRewardInfo = (RewardInfo)paramObject;
      if (this.enabled != null)
      {
        if (this.enabled.equals(localRewardInfo.enabled));
      }
      else
        while (localRewardInfo.enabled != null)
          return false;
      if (this.balance != null)
      {
        if (this.balance.equals(localRewardInfo.balance));
      }
      else
        while (localRewardInfo.balance != null)
          return false;
      if (this.eligibleFor != null)
      {
        if (this.eligibleFor.equals(localRewardInfo.eligibleFor));
      }
      else
        while (localRewardInfo.eligibleFor != null)
          return false;
      if (this.enrolled == null)
        break;
    }
    while (this.enrolled.equals(localRewardInfo.enrolled));
    while (true)
    {
      return false;
      if (localRewardInfo.enrolled == null)
        break;
    }
  }

  public Balance getBalance()
  {
    return this.balance;
  }

  public boolean hasBalance()
  {
    return this.balance != null;
  }

  public boolean hasTakenEnrollAction()
  {
    return this.enrolled != null;
  }

  public int hashCode()
  {
    int i;
    int k;
    label35: int m;
    if (this.balance != null)
    {
      i = this.balance.hashCode();
      int j = i * 31;
      if (this.eligibleFor == null)
        break label103;
      k = this.eligibleFor.hashCode();
      m = 31 * (j + k);
      if (this.enabled == null)
        break label108;
    }
    label103: label108: for (int n = this.enabled.hashCode(); ; n = 0)
    {
      int i1 = 31 * (m + n);
      Boolean localBoolean = this.enrolled;
      int i2 = 0;
      if (localBoolean != null)
        i2 = this.enrolled.hashCode();
      return i1 + i2;
      i = 0;
      break;
      k = 0;
      break label35;
    }
  }

  public boolean isEarnOnly()
  {
    return (!TextUtils.isEmpty(this.eligibleFor)) && ("E".equals(this.eligibleFor));
  }

  public boolean isEligible()
  {
    return (!TextUtils.isEmpty(this.eligibleFor)) && (!"N".equals(this.eligibleFor));
  }

  public boolean isEnabled()
  {
    if (this.enabled == null)
      return false;
    return this.enabled.booleanValue();
  }

  public boolean isEnrolled()
  {
    if (this.enrolled == null)
      return false;
    return this.enrolled.booleanValue();
  }

  public boolean usePointsDisabled()
  {
    return (!TextUtils.isEmpty(this.eligibleFor)) && ("B".equals(this.eligibleFor)) && (!isEnabled());
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(this.balance, paramInt);
    paramParcel.writeString(this.eligibleFor);
    paramParcel.writeValue(this.enabled);
    paramParcel.writeValue(this.enrolled);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.model.RewardInfo
 * JD-Core Version:    0.6.2
 */