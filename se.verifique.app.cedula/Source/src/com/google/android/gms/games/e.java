package com.google.android.gms.games;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class e
  implements Parcelable.Creator
{
  static void a(PlayerLevel paramPlayerLevel, Parcel paramParcel, int paramInt)
  {
    int i = c.a(paramParcel);
    c.a(paramParcel, 1, paramPlayerLevel.b());
    c.a(paramParcel, 1000, paramPlayerLevel.a());
    c.a(paramParcel, 2, paramPlayerLevel.c());
    c.a(paramParcel, 3, paramPlayerLevel.d());
    c.a(paramParcel, i);
  }

  public PlayerLevel a(Parcel paramParcel)
  {
    long l1 = 0L;
    int i = 0;
    int j = a.b(paramParcel);
    long l2 = l1;
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
        i = a.g(paramParcel, m);
        break;
      case 1000:
        k = a.g(paramParcel, m);
        break;
      case 2:
        l2 = a.i(paramParcel, m);
        break;
      case 3:
        l1 = a.i(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new b("Overread allowed size end=" + j, paramParcel);
    return new PlayerLevel(k, i, l2, l1);
  }

  public PlayerLevel[] a(int paramInt)
  {
    return new PlayerLevel[paramInt];
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.e
 * JD-Core Version:    0.6.0
 */