package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import java.util.HashSet;
import java.util.Set;

public class nj
  implements Parcelable.Creator
{
  static void a(ks.g paramg, Parcel paramParcel, int paramInt)
  {
    int i = c.a(paramParcel);
    Set localSet = paramg.e();
    if (localSet.contains(Integer.valueOf(1)))
      c.a(paramParcel, 1, paramg.f());
    if (localSet.contains(Integer.valueOf(2)))
      c.a(paramParcel, 2, paramg.g());
    if (localSet.contains(Integer.valueOf(3)))
      c.a(paramParcel, 3, paramg.h(), true);
    c.a(paramParcel, i);
  }

  public ks.g a(Parcel paramParcel)
  {
    boolean bool = false;
    int i = a.b(paramParcel);
    HashSet localHashSet = new HashSet();
    String str = null;
    int j = 0;
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
        localHashSet.add(Integer.valueOf(1));
        break;
      case 2:
        bool = a.c(paramParcel, k);
        localHashSet.add(Integer.valueOf(2));
        break;
      case 3:
        str = a.o(paramParcel, k);
        localHashSet.add(Integer.valueOf(3));
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new b("Overread allowed size end=" + i, paramParcel);
    return new ks.g(localHashSet, j, bool, str);
  }

  public ks.g[] a(int paramInt)
  {
    return new ks.g[paramInt];
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.nj
 * JD-Core Version:    0.6.0
 */