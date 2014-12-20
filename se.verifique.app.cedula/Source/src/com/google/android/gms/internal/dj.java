package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class dj
  implements Parcelable.Creator
{
  static void a(cq paramcq, Parcel paramParcel, int paramInt)
  {
    int i = c.a(paramParcel);
    c.a(paramParcel, 1, paramcq.b);
    c.a(paramParcel, 2, paramcq.a(), false);
    c.a(paramParcel, 3, paramcq.b(), false);
    c.a(paramParcel, 4, paramcq.c(), false);
    c.a(paramParcel, 5, paramcq.d(), false);
    c.a(paramParcel, i);
  }

  public cq a(Parcel paramParcel)
  {
    IBinder localIBinder1 = null;
    int i = a.b(paramParcel);
    int j = 0;
    IBinder localIBinder2 = null;
    IBinder localIBinder3 = null;
    IBinder localIBinder4 = null;
    while (paramParcel.dataPosition() < i)
    {
      int k = a.a(paramParcel);
      switch (a.a(k))
      {
      default:
        a.b(paramParcel, k);
        break;
      case 1:
        j = a.g(paramParcel, k);
        break;
      case 2:
        localIBinder4 = a.p(paramParcel, k);
        break;
      case 3:
        localIBinder3 = a.p(paramParcel, k);
        break;
      case 4:
        localIBinder2 = a.p(paramParcel, k);
        break;
      case 5:
        localIBinder1 = a.p(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new b("Overread allowed size end=" + i, paramParcel);
    return new cq(j, localIBinder4, localIBinder3, localIBinder2, localIBinder1);
  }

  public cq[] a(int paramInt)
  {
    return new cq[paramInt];
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.dj
 * JD-Core Version:    0.6.0
 */