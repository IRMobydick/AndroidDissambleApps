package com.ubercab.client.core.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class TripExpenseInfo
  implements Parcelable
{
  public static final Parcelable.Creator<TripExpenseInfo> CREATOR = new Parcelable.Creator()
  {
    public TripExpenseInfo createFromParcel(Parcel paramAnonymousParcel)
    {
      return new TripExpenseInfo(paramAnonymousParcel, null);
    }

    public TripExpenseInfo[] newArray(int paramAnonymousInt)
    {
      return new TripExpenseInfo[paramAnonymousInt];
    }
  };
  private String code;
  private boolean expenseTrip;
  private String memo;

  public TripExpenseInfo()
  {
  }

  private TripExpenseInfo(Parcel paramParcel)
  {
    this.code = paramParcel.readString();
    if (paramParcel.readByte() != 0);
    for (boolean bool = true; ; bool = false)
    {
      this.expenseTrip = bool;
      this.memo = paramParcel.readString();
      return;
    }
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    TripExpenseInfo localTripExpenseInfo;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localTripExpenseInfo = (TripExpenseInfo)paramObject;
      if (this.expenseTrip != localTripExpenseInfo.expenseTrip)
        return false;
      if (this.code != null)
      {
        if (this.code.equals(localTripExpenseInfo.code));
      }
      else
        while (localTripExpenseInfo.code != null)
          return false;
      if (this.memo == null)
        break;
    }
    while (this.memo.equals(localTripExpenseInfo.memo));
    while (true)
    {
      return false;
      if (localTripExpenseInfo.memo == null)
        break;
    }
  }

  public String getCode()
  {
    return this.code;
  }

  public String getMemo()
  {
    return this.memo;
  }

  public int hashCode()
  {
    int i;
    int j;
    if (this.memo != null)
    {
      i = this.memo.hashCode();
      j = i * 31;
      if (this.code == null)
        break label71;
    }
    label71: for (int k = this.code.hashCode(); ; k = 0)
    {
      int m = 31 * (j + k);
      boolean bool = this.expenseTrip;
      int n = 0;
      if (bool)
        n = 1;
      return m + n;
      i = 0;
      break;
    }
  }

  public boolean isExpenseTrip()
  {
    return this.expenseTrip;
  }

  public void setCode(String paramString)
  {
    this.code = paramString;
  }

  public void setExpenseTrip(boolean paramBoolean)
  {
    this.expenseTrip = paramBoolean;
  }

  public void setMemo(String paramString)
  {
    this.memo = paramString;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.code);
    if (this.expenseTrip);
    for (int i = 1; ; i = 0)
    {
      paramParcel.writeByte((byte)i);
      paramParcel.writeString(this.memo);
      return;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.model.TripExpenseInfo
 * JD-Core Version:    0.6.2
 */