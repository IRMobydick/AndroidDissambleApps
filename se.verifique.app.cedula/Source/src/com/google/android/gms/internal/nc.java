package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import java.util.HashSet;
import java.util.Set;

public class nc
  implements Parcelable.Creator
{
  static void a(ks.b paramb, Parcel paramParcel, int paramInt)
  {
    int i = c.a(paramParcel);
    Set localSet = paramb.e();
    if (localSet.contains(Integer.valueOf(1)))
      c.a(paramParcel, 1, paramb.f());
    if (localSet.contains(Integer.valueOf(2)))
      c.a(paramParcel, 2, paramb.g(), paramInt, true);
    if (localSet.contains(Integer.valueOf(3)))
      c.a(paramParcel, 3, paramb.h(), paramInt, true);
    if (localSet.contains(Integer.valueOf(4)))
      c.a(paramParcel, 4, paramb.i());
    c.a(paramParcel, i);
  }

  public ks.b a(Parcel paramParcel)
  {
    Object localObject1 = null;
    int i = 0;
    int j = a.b(paramParcel);
    HashSet localHashSet = new HashSet();
    Object localObject2 = null;
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
        localHashSet.add(Integer.valueOf(1));
        break;
      case 2:
        ks.b.a locala = (ks.b.a)a.a(paramParcel, m, ks.b.a.a);
        localHashSet.add(Integer.valueOf(2));
        localObject2 = locala;
        break;
      case 3:
        ks.b.b localb = (ks.b.b)a.a(paramParcel, m, ks.b.b.a);
        localHashSet.add(Integer.valueOf(3));
        localObject1 = localb;
        break;
      case 4:
        i = a.g(paramParcel, m);
        localHashSet.add(Integer.valueOf(4));
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new b("Overread allowed size end=" + j, paramParcel);
    return new ks.b(localHashSet, k, localObject2, localObject1, i);
  }

  public ks.b[] a(int paramInt)
  {
    return new ks.b[paramInt];
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.nc
 * JD-Core Version:    0.6.0
 */