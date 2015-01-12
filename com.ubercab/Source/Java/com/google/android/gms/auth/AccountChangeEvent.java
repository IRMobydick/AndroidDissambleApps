package com.google.android.gms.auth;

import android.os.Parcel;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.o;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class AccountChangeEvent
  implements SafeParcelable
{
  public static final AccountChangeEventCreator CREATOR = new AccountChangeEventCreator();
  final String Dd;
  final int Di;
  final long Dj;
  final int Dk;
  final int Dl;
  final String Dm;

  AccountChangeEvent(int paramInt1, long paramLong, String paramString1, int paramInt2, int paramInt3, String paramString2)
  {
    this.Di = paramInt1;
    this.Dj = paramLong;
    this.Dd = ((String)o.i(paramString1));
    this.Dk = paramInt2;
    this.Dl = paramInt3;
    this.Dm = paramString2;
  }

  public AccountChangeEvent(long paramLong, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    this.Di = 1;
    this.Dj = paramLong;
    this.Dd = ((String)o.i(paramString1));
    this.Dk = paramInt1;
    this.Dl = paramInt2;
    this.Dm = paramString2;
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (paramObject == this);
    AccountChangeEvent localAccountChangeEvent;
    do
    {
      return true;
      if (!(paramObject instanceof AccountChangeEvent))
        break;
      localAccountChangeEvent = (AccountChangeEvent)paramObject;
    }
    while ((this.Di == localAccountChangeEvent.Di) && (this.Dj == localAccountChangeEvent.Dj) && (n.equal(this.Dd, localAccountChangeEvent.Dd)) && (this.Dk == localAccountChangeEvent.Dk) && (this.Dl == localAccountChangeEvent.Dl) && (n.equal(this.Dm, localAccountChangeEvent.Dm)));
    return false;
    return false;
  }

  public String getAccountName()
  {
    return this.Dd;
  }

  public String getChangeData()
  {
    return this.Dm;
  }

  public int getChangeType()
  {
    return this.Dk;
  }

  public int getEventIndex()
  {
    return this.Dl;
  }

  public int hashCode()
  {
    Object[] arrayOfObject = new Object[6];
    arrayOfObject[0] = Integer.valueOf(this.Di);
    arrayOfObject[1] = Long.valueOf(this.Dj);
    arrayOfObject[2] = this.Dd;
    arrayOfObject[3] = Integer.valueOf(this.Dk);
    arrayOfObject[4] = Integer.valueOf(this.Dl);
    arrayOfObject[5] = this.Dm;
    return n.hashCode(arrayOfObject);
  }

  public String toString()
  {
    String str = "UNKNOWN";
    switch (this.Dk)
    {
    default:
    case 1:
    case 2:
    case 4:
    case 3:
    }
    while (true)
    {
      return "AccountChangeEvent {accountName = " + this.Dd + ", changeType = " + str + ", changeData = " + this.Dm + ", eventIndex = " + this.Dl + "}";
      str = "ADDED";
      continue;
      str = "REMOVED";
      continue;
      str = "RENAMED_TO";
      continue;
      str = "RENAMED_FROM";
    }
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AccountChangeEventCreator.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.auth.AccountChangeEvent
 * JD-Core Version:    0.6.2
 */