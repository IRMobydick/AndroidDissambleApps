package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class iw
  implements Parcelable.Creator
{
  static void a(fg paramfg, Parcel paramParcel, int paramInt)
  {
    int i = c.a(paramParcel);
    c.a(paramParcel, 1, paramfg.c, paramInt, false);
    c.a(paramParcel, 1000, paramfg.b);
    c.a(paramParcel, 2, paramfg.d, false);
    c.a(paramParcel, 3, paramfg.e);
    c.a(paramParcel, i);
  }

  public fg a(Parcel paramParcel)
  {
    Object localObject1 = null;
    boolean bool1 = false;
    int i = a.b(paramParcel);
    Object localObject2 = null;
    int j = 0;
    if (paramParcel.dataPosition() < i)
    {
      int k = a.a(paramParcel);
      boolean bool2;
      Object localObject3;
      Object localObject4;
      int m;
      switch (a.a(k))
      {
      default:
        a.b(paramParcel, k);
        bool2 = bool1;
        localObject3 = localObject1;
        localObject4 = localObject2;
        m = j;
      case 1:
      case 1000:
      case 2:
      case 3:
      }
      while (true)
      {
        j = m;
        localObject2 = localObject4;
        localObject1 = localObject3;
        bool1 = bool2;
        break;
        fk[] arrayOffk = (fk[])a.b(paramParcel, k, fk.b);
        m = j;
        Object localObject5 = localObject1;
        localObject4 = arrayOffk;
        bool2 = bool1;
        localObject3 = localObject5;
        continue;
        int n = a.g(paramParcel, k);
        boolean bool4 = bool1;
        localObject3 = localObject1;
        localObject4 = localObject2;
        m = n;
        bool2 = bool4;
        continue;
        String str = a.o(paramParcel, k);
        localObject4 = localObject2;
        m = j;
        boolean bool3 = bool1;
        localObject3 = str;
        bool2 = bool3;
        continue;
        bool2 = a.c(paramParcel, k);
        localObject3 = localObject1;
        localObject4 = localObject2;
        m = j;
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new b("Overread allowed size end=" + i, paramParcel);
    return new fg(j, localObject2, localObject1, bool1);
  }

  public fg[] a(int paramInt)
  {
    return new fg[paramInt];
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.iw
 * JD-Core Version:    0.6.0
 */