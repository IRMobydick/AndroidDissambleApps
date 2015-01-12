package com.google.android.gms.auth;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class AccountChangeEventsRequest
  implements SafeParcelable
{
  public static final AccountChangeEventsRequestCreator CREATOR = new AccountChangeEventsRequestCreator();
  String Dd;
  final int Di;
  int Dl;

  public AccountChangeEventsRequest()
  {
    this.Di = 1;
  }

  AccountChangeEventsRequest(int paramInt1, int paramInt2, String paramString)
  {
    this.Di = paramInt1;
    this.Dl = paramInt2;
    this.Dd = paramString;
  }

  public int describeContents()
  {
    return 0;
  }

  public String getAccountName()
  {
    return this.Dd;
  }

  public int getEventIndex()
  {
    return this.Dl;
  }

  public AccountChangeEventsRequest setAccountName(String paramString)
  {
    this.Dd = paramString;
    return this;
  }

  public AccountChangeEventsRequest setEventIndex(int paramInt)
  {
    this.Dl = paramInt;
    return this;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AccountChangeEventsRequestCreator.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.auth.AccountChangeEventsRequest
 * JD-Core Version:    0.6.2
 */