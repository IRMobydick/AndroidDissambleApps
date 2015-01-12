package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.ArrayList;

public class AccountChangeEventsResponseCreator
  implements Parcelable.Creator<AccountChangeEventsResponse>
{
  public static final int CONTENT_DESCRIPTION;

  static void a(AccountChangeEventsResponse paramAccountChangeEventsResponse, Parcel paramParcel, int paramInt)
  {
    int i = b.D(paramParcel);
    b.c(paramParcel, 1, paramAccountChangeEventsResponse.Di);
    b.c(paramParcel, 2, paramAccountChangeEventsResponse.me, false);
    b.H(paramParcel, i);
  }

  public AccountChangeEventsResponse createFromParcel(Parcel paramParcel)
  {
    int i = a.C(paramParcel);
    int j = 0;
    ArrayList localArrayList = null;
    while (paramParcel.dataPosition() < i)
    {
      int k = a.B(paramParcel);
      switch (a.aD(k))
      {
      default:
        a.b(paramParcel, k);
        break;
      case 1:
        j = a.g(paramParcel, k);
        break;
      case 2:
        localArrayList = a.c(paramParcel, k, AccountChangeEvent.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    return new AccountChangeEventsResponse(j, localArrayList);
  }

  public AccountChangeEventsResponse[] newArray(int paramInt)
  {
    return new AccountChangeEventsResponse[paramInt];
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.auth.AccountChangeEventsResponseCreator
 * JD-Core Version:    0.6.2
 */