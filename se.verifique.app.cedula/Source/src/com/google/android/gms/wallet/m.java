package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class m
  implements Parcelable.Creator
{
  static void a(NotifyTransactionStatusRequest paramNotifyTransactionStatusRequest, Parcel paramParcel, int paramInt)
  {
    int i = c.a(paramParcel);
    c.a(paramParcel, 1, paramNotifyTransactionStatusRequest.a);
    c.a(paramParcel, 2, paramNotifyTransactionStatusRequest.b, false);
    c.a(paramParcel, 3, paramNotifyTransactionStatusRequest.c);
    c.a(paramParcel, 4, paramNotifyTransactionStatusRequest.d, false);
    c.a(paramParcel, i);
  }

  public NotifyTransactionStatusRequest a(Parcel paramParcel)
  {
    String str1 = null;
    int i = 0;
    int j = a.b(paramParcel);
    String str2 = null;
    int k = 0;
    while (paramParcel.dataPosition() < j)
    {
      int m = a.a(paramParcel);
      switch (a.a(m))
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
      throw new b("Overread allowed size end=" + j, paramParcel);
    return new NotifyTransactionStatusRequest(k, str2, i, str1);
  }

  public NotifyTransactionStatusRequest[] a(int paramInt)
  {
    return new NotifyTransactionStatusRequest[paramInt];
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.wallet.m
 * JD-Core Version:    0.6.0
 */