package com.ubercab.client.core.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;

public final class ClientTransaction
  implements Parcelable
{
  public static Parcelable.Creator<ClientTransaction> CREATOR = new Parcelable.Creator()
  {
    public ClientTransaction createFromParcel(Parcel paramAnonymousParcel)
    {
      return new ClientTransaction(paramAnonymousParcel, null);
    }

    public ClientTransaction[] newArray(int paramAnonymousInt)
    {
      return new ClientTransaction[paramAnonymousInt];
    }
  };
  String amount;
  String amount_string;

  public ClientTransaction()
  {
  }

  private ClientTransaction(Parcel paramParcel)
  {
    this.amount_string = paramParcel.readString();
    this.amount = paramParcel.readString();
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    ClientTransaction localClientTransaction;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localClientTransaction = (ClientTransaction)paramObject;
      if (this.amount != null)
      {
        if (this.amount.equals(localClientTransaction.amount));
      }
      else
        while (localClientTransaction.amount != null)
          return false;
      if (this.amount_string == null)
        break;
    }
    while (this.amount_string.equals(localClientTransaction.amount_string));
    while (true)
    {
      return false;
      if (localClientTransaction.amount_string == null)
        break;
    }
  }

  public String getAmount()
  {
    return this.amount;
  }

  public String getAmountString()
  {
    return this.amount_string;
  }

  public String getDisplayAmount()
  {
    if (!TextUtils.isEmpty(this.amount_string))
      return this.amount_string;
    if (!TextUtils.isEmpty(this.amount))
      return this.amount;
    return "";
  }

  public int hashCode()
  {
    if (this.amount_string != null);
    for (int i = this.amount_string.hashCode(); ; i = 0)
    {
      int j = i * 31;
      String str = this.amount;
      int k = 0;
      if (str != null)
        k = this.amount.hashCode();
      return j + k;
    }
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.amount_string);
    paramParcel.writeString(this.amount);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.model.ClientTransaction
 * JD-Core Version:    0.6.2
 */