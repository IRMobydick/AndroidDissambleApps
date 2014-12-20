package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class c
  implements Parcelable.Creator
{
  static void a(ParcelableCollaborator paramParcelableCollaborator, Parcel paramParcel, int paramInt)
  {
    int i = com.google.android.gms.common.internal.safeparcel.c.a(paramParcel);
    com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 1, paramParcelableCollaborator.a);
    com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 2, paramParcelableCollaborator.b);
    com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 3, paramParcelableCollaborator.c);
    com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 4, paramParcelableCollaborator.d, false);
    com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 5, paramParcelableCollaborator.e, false);
    com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 6, paramParcelableCollaborator.f, false);
    com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 7, paramParcelableCollaborator.g, false);
    com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 8, paramParcelableCollaborator.h, false);
    com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, i);
  }

  public ParcelableCollaborator a(Parcel paramParcel)
  {
    boolean bool1 = false;
    String str1 = null;
    int i = a.b(paramParcel);
    String str2 = null;
    String str3 = null;
    String str4 = null;
    String str5 = null;
    boolean bool2 = false;
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
        bool2 = a.c(paramParcel, k);
        break;
      case 3:
        bool1 = a.c(paramParcel, k);
        break;
      case 4:
        str5 = a.o(paramParcel, k);
        break;
      case 5:
        str4 = a.o(paramParcel, k);
        break;
      case 6:
        str3 = a.o(paramParcel, k);
        break;
      case 7:
        str2 = a.o(paramParcel, k);
        break;
      case 8:
        str1 = a.o(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new b("Overread allowed size end=" + i, paramParcel);
    return new ParcelableCollaborator(j, bool2, bool1, str5, str4, str3, str2, str1);
  }

  public ParcelableCollaborator[] a(int paramInt)
  {
    return new ParcelableCollaborator[paramInt];
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.realtime.internal.c
 * JD-Core Version:    0.6.0
 */