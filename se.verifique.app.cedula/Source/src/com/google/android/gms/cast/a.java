package com.google.android.gms.cast;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import java.util.ArrayList;

public class a
  implements Parcelable.Creator
{
  static void a(ApplicationMetadata paramApplicationMetadata, Parcel paramParcel, int paramInt)
  {
    int i = c.a(paramParcel);
    c.a(paramParcel, 1, paramApplicationMetadata.a());
    c.a(paramParcel, 2, paramApplicationMetadata.b(), false);
    c.a(paramParcel, 3, paramApplicationMetadata.c(), false);
    c.b(paramParcel, 4, paramApplicationMetadata.f(), false);
    c.a(paramParcel, 5, paramApplicationMetadata.d, false);
    c.a(paramParcel, 6, paramApplicationMetadata.d(), false);
    c.a(paramParcel, 7, paramApplicationMetadata.e(), paramInt, false);
    c.a(paramParcel, i);
  }

  public ApplicationMetadata a(Parcel paramParcel)
  {
    Uri localUri = null;
    int i = com.google.android.gms.common.internal.safeparcel.a.b(paramParcel);
    int j = 0;
    String str1 = null;
    ArrayList localArrayList1 = null;
    ArrayList localArrayList2 = null;
    String str2 = null;
    String str3 = null;
    while (paramParcel.dataPosition() < i)
    {
      int k = com.google.android.gms.common.internal.safeparcel.a.a(paramParcel);
      switch (com.google.android.gms.common.internal.safeparcel.a.a(k))
      {
      default:
        com.google.android.gms.common.internal.safeparcel.a.b(paramParcel, k);
        break;
      case 1:
        j = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, k);
        break;
      case 2:
        str3 = com.google.android.gms.common.internal.safeparcel.a.o(paramParcel, k);
        break;
      case 3:
        str2 = com.google.android.gms.common.internal.safeparcel.a.o(paramParcel, k);
        break;
      case 4:
        localArrayList2 = com.google.android.gms.common.internal.safeparcel.a.c(paramParcel, k, WebImage.CREATOR);
        break;
      case 5:
        localArrayList1 = com.google.android.gms.common.internal.safeparcel.a.B(paramParcel, k);
        break;
      case 6:
        str1 = com.google.android.gms.common.internal.safeparcel.a.o(paramParcel, k);
        break;
      case 7:
        localUri = (Uri)com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, k, Uri.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new b("Overread allowed size end=" + i, paramParcel);
    return new ApplicationMetadata(j, str3, str2, localArrayList2, localArrayList1, str1, localUri);
  }

  public ApplicationMetadata[] a(int paramInt)
  {
    return new ApplicationMetadata[paramInt];
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.cast.a
 * JD-Core Version:    0.6.0
 */