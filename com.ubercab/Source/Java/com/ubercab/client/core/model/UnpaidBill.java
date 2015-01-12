package com.ubercab.client.core.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class UnpaidBill
  implements Parcelable
{
  public static Parcelable.Creator<UnpaidBill> CREATOR = new Parcelable.Creator()
  {
    public UnpaidBill createFromParcel(Parcel paramAnonymousParcel)
    {
      return new UnpaidBill(paramAnonymousParcel, null);
    }

    public UnpaidBill[] newArray(int paramAnonymousInt)
    {
      return new UnpaidBill[paramAnonymousInt];
    }
  };
  private ClientTransaction client_transaction;
  private Integer id;

  public UnpaidBill()
  {
  }

  private UnpaidBill(Parcel paramParcel)
  {
    this.id = ((Integer)paramParcel.readValue(Integer.class.getClassLoader()));
    this.client_transaction = ((ClientTransaction)paramParcel.readParcelable(ClientTransaction.class.getClassLoader()));
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    UnpaidBill localUnpaidBill;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localUnpaidBill = (UnpaidBill)paramObject;
      if (this.client_transaction != null)
      {
        if (this.client_transaction.equals(localUnpaidBill.client_transaction));
      }
      else
        while (localUnpaidBill.client_transaction != null)
          return false;
      if (this.id == null)
        break;
    }
    while (this.id.equals(localUnpaidBill.id));
    while (true)
    {
      return false;
      if (localUnpaidBill.id == null)
        break;
    }
  }

  public ClientTransaction getClientTransaction()
  {
    return this.client_transaction;
  }

  public int getId()
  {
    if (this.id == null)
      return 0;
    return this.id.intValue();
  }

  public int hashCode()
  {
    if (this.id != null);
    for (int i = this.id.hashCode(); ; i = 0)
    {
      int j = i * 31;
      ClientTransaction localClientTransaction = this.client_transaction;
      int k = 0;
      if (localClientTransaction != null)
        k = this.client_transaction.hashCode();
      return j + k;
    }
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeValue(this.id);
    paramParcel.writeParcelable(this.client_transaction, 0);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.model.UnpaidBill
 * JD-Core Version:    0.6.2
 */