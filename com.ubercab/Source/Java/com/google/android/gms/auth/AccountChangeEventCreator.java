package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class AccountChangeEventCreator
  implements Parcelable.Creator<AccountChangeEvent>
{
  public static final int CONTENT_DESCRIPTION;

  static void a(AccountChangeEvent paramAccountChangeEvent, Parcel paramParcel, int paramInt)
  {
    int i = b.D(paramParcel);
    b.c(paramParcel, 1, paramAccountChangeEvent.Di);
    b.a(paramParcel, 2, paramAccountChangeEvent.Dj);
    b.a(paramParcel, 3, paramAccountChangeEvent.Dd, false);
    b.c(paramParcel, 4, paramAccountChangeEvent.Dk);
    b.c(paramParcel, 5, paramAccountChangeEvent.Dl);
    b.a(paramParcel, 6, paramAccountChangeEvent.Dm, false);
    b.H(paramParcel, i);
  }

  public AccountChangeEvent createFromParcel(Parcel paramParcel)
  {
    String str1 = null;
    int i = 0;
    int j = a.C(paramParcel);
    long l = 0L;
    int k = 0;
    String str2 = null;
    int m = 0;
    while (paramParcel.dataPosition() < j)
    {
      int n = a.B(paramParcel);
      switch (a.aD(n))
      {
      default:
        a.b(paramParcel, n);
        break;
      case 1:
        m = a.g(paramParcel, n);
        break;
      case 2:
        l = a.i(paramParcel, n);
        break;
      case 3:
        str2 = a.o(paramParcel, n);
        break;
      case 4:
        k = a.g(paramParcel, n);
        break;
      case 5:
        i = a.g(paramParcel, n);
        break;
      case 6:
        str1 = a.o(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    return new AccountChangeEvent(m, l, str2, k, i, str1);
  }

  public AccountChangeEvent[] newArray(int paramInt)
  {
    return new AccountChangeEvent[paramInt];
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.auth.AccountChangeEventCreator
 * JD-Core Version:    0.6.2
 */