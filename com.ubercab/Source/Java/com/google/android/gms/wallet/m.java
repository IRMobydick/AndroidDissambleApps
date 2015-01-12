package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class m
  implements Parcelable.Creator<NotifyTransactionStatusRequest>
{
  static void a(NotifyTransactionStatusRequest paramNotifyTransactionStatusRequest, Parcel paramParcel, int paramInt)
  {
    int i = b.D(paramParcel);
    b.c(paramParcel, 1, paramNotifyTransactionStatusRequest.BR);
    b.a(paramParcel, 2, paramNotifyTransactionStatusRequest.asB, false);
    b.c(paramParcel, 3, paramNotifyTransactionStatusRequest.status);
    b.a(paramParcel, 4, paramNotifyTransactionStatusRequest.atB, false);
    b.H(paramParcel, i);
  }

  public NotifyTransactionStatusRequest dy(Parcel paramParcel)
  {
    String str1 = null;
    int i = 0;
    int j = a.C(paramParcel);
    String str2 = null;
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
        str2 = a.o(paramParcel, m);
        break;
      case 3:
        i = a.g(paramParcel, m);
        break;
      case 4:
        str1 = a.o(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    return new NotifyTransactionStatusRequest(k, str2, i, str1);
  }

  public NotifyTransactionStatusRequest[] fz(int paramInt)
  {
    return new NotifyTransactionStatusRequest[paramInt];
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wallet.m
 * JD-Core Version:    0.6.2
 */