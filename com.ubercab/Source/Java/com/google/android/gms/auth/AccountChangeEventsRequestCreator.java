package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class AccountChangeEventsRequestCreator
  implements Parcelable.Creator<AccountChangeEventsRequest>
{
  public static final int CONTENT_DESCRIPTION;

  static void a(AccountChangeEventsRequest paramAccountChangeEventsRequest, Parcel paramParcel, int paramInt)
  {
    int i = b.D(paramParcel);
    b.c(paramParcel, 1, paramAccountChangeEventsRequest.Di);
    b.c(paramParcel, 2, paramAccountChangeEventsRequest.Dl);
    b.a(paramParcel, 3, paramAccountChangeEventsRequest.Dd, false);
    b.H(paramParcel, i);
  }

  public AccountChangeEventsRequest createFromParcel(Parcel paramParcel)
  {
    int i = 0;
    int j = a.C(paramParcel);
    String str = null;
    int k = 0;
    while (paramParcel.dataPosition() < j)
    {
      int m = a.B(paramParcel);
      switch (a.aD(m))
      {
      default:
        a.b(paramParcel, m);
        break;
      case 1:
        k = a.g(paramParcel, m);
        break;
      case 2:
        i = a.g(paramParcel, m);
        break;
      case 3:
        str = a.o(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    return new AccountChangeEventsRequest(k, i, str);
  }

  public AccountChangeEventsRequest[] newArray(int paramInt)
  {
    return new AccountChangeEventsRequest[paramInt];
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.auth.AccountChangeEventsRequestCreator
 * JD-Core Version:    0.6.2
 */