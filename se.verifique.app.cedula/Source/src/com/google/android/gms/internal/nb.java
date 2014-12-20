package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import java.util.HashSet;
import java.util.Set;

public class nb
  implements Parcelable.Creator
{
  static void a(ks.a parama, Parcel paramParcel, int paramInt)
  {
    int i = c.a(paramParcel);
    Set localSet = parama.e();
    if (localSet.contains(Integer.valueOf(1)))
      c.a(paramParcel, 1, parama.f());
    if (localSet.contains(Integer.valueOf(2)))
      c.a(paramParcel, 2, parama.g());
    if (localSet.contains(Integer.valueOf(3)))
      c.a(paramParcel, 3, parama.h());
    c.a(paramParcel, i);
  }

  public ks.a a(Parcel paramParcel)
  {
    int i = 0;
    int j = a.b(paramParcel);
    HashSet localHashSet = new HashSet();
    int k = 0;
    int m = 0;
    while (paramParcel.dataPosition() < j)
    {
      int n = a.a(paramParcel);
      switch (a.a(n))
      {
      default:
        a.b(paramParcel, n);
        break;
      case 1:
        m = a.g(paramParcel, n);
        localHashSet.add(Integer.valueOf(1));
        break;
      case 2:
        k = a.g(paramParcel, n);
        localHashSet.add(Integer.valueOf(2));
        break;
      case 3:
        i = a.g(paramParcel, n);
        localHashSet.add(Integer.valueOf(3));
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new b("Overread allowed size end=" + j, paramParcel);
    return new ks.a(localHashSet, m, k, i);
  }

  public ks.a[] a(int paramInt)
  {
    return new ks.a[paramInt];
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.nb
 * JD-Core Version:    0.6.0
 */