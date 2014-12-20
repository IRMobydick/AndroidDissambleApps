package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import java.util.HashSet;
import java.util.Set;

public class mz
  implements Parcelable.Creator
{
  static void a(kp paramkp, Parcel paramParcel, int paramInt)
  {
    int i = c.a(paramParcel);
    Set localSet = paramkp.e();
    if (localSet.contains(Integer.valueOf(1)))
      c.a(paramParcel, 1, paramkp.f());
    if (localSet.contains(Integer.valueOf(2)))
      c.a(paramParcel, 2, paramkp.g(), true);
    if (localSet.contains(Integer.valueOf(4)))
      c.a(paramParcel, 4, paramkp.h(), paramInt, true);
    if (localSet.contains(Integer.valueOf(5)))
      c.a(paramParcel, 5, paramkp.i(), true);
    if (localSet.contains(Integer.valueOf(6)))
      c.a(paramParcel, 6, paramkp.j(), paramInt, true);
    if (localSet.contains(Integer.valueOf(7)))
      c.a(paramParcel, 7, paramkp.k(), true);
    c.a(paramParcel, i);
  }

  public kp a(Parcel paramParcel)
  {
    String str1 = null;
    int i = a.b(paramParcel);
    HashSet localHashSet = new HashSet();
    int j = 0;
    Object localObject1 = null;
    String str2 = null;
    Object localObject2 = null;
    String str3 = null;
    while (paramParcel.dataPosition() < i)
    {
      int k = a.a(paramParcel);
      switch (a.a(k))
      {
      case 3:
      default:
        a.b(paramParcel, k);
        break;
      case 1:
        j = a.g(paramParcel, k);
        localHashSet.add(Integer.valueOf(1));
        break;
      case 2:
        str3 = a.o(paramParcel, k);
        localHashSet.add(Integer.valueOf(2));
        break;
      case 4:
        kn localkn2 = (kn)a.a(paramParcel, k, kn.a);
        localHashSet.add(Integer.valueOf(4));
        localObject2 = localkn2;
        break;
      case 5:
        str2 = a.o(paramParcel, k);
        localHashSet.add(Integer.valueOf(5));
        break;
      case 6:
        kn localkn1 = (kn)a.a(paramParcel, k, kn.a);
        localHashSet.add(Integer.valueOf(6));
        localObject1 = localkn1;
        break;
      case 7:
        str1 = a.o(paramParcel, k);
        localHashSet.add(Integer.valueOf(7));
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new b("Overread allowed size end=" + i, paramParcel);
    return new kp(localHashSet, j, str3, localObject2, str2, localObject1, str1);
  }

  public kp[] a(int paramInt)
  {
    return new kp[paramInt];
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.mz
 * JD-Core Version:    0.6.0
 */