package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class c
  implements Parcelable.Creator
{
  static void a(LaunchOptions paramLaunchOptions, Parcel paramParcel, int paramInt)
  {
    int i = com.google.android.gms.common.internal.safeparcel.c.a(paramParcel);
    com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 1, paramLaunchOptions.a());
    com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 2, paramLaunchOptions.b());
    com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 3, paramLaunchOptions.c(), false);
    com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, i);
  }

  public LaunchOptions a(Parcel paramParcel)
  {
    boolean bool = false;
    int i = a.b(paramParcel);
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
        break;
      case 2:
        bool = a.c(paramParcel, k);
        break;
      case 3:
        str = a.o(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new b("Overread allowed size end=" + i, paramParcel);
    return new LaunchOptions(j, bool, str);
  }

  public LaunchOptions[] a(int paramInt)
  {
    return new LaunchOptions[paramInt];
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.cast.c
 * JD-Core Version:    0.6.0
 */