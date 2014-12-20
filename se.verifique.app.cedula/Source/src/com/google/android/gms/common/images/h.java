package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class h
  implements Parcelable.Creator
{
  static void a(WebImage paramWebImage, Parcel paramParcel, int paramInt)
  {
    int i = c.a(paramParcel);
    c.a(paramParcel, 1, paramWebImage.a());
    c.a(paramParcel, 2, paramWebImage.b(), paramInt, false);
    c.a(paramParcel, 3, paramWebImage.c());
    c.a(paramParcel, 4, paramWebImage.d());
    c.a(paramParcel, i);
  }

  public WebImage a(Parcel paramParcel)
  {
    int i = 0;
    int j = a.b(paramParcel);
    Object localObject1 = null;
    int k = 0;
    int m = 0;
    if (paramParcel.dataPosition() < j)
    {
      int n = a.a(paramParcel);
      int i1;
      int i2;
      Object localObject2;
      int i3;
      switch (a.a(n))
      {
      default:
        a.b(paramParcel, n);
        i1 = i;
        i2 = k;
        localObject2 = localObject1;
        i3 = m;
      case 1:
      case 2:
      case 3:
      case 4:
      }
      while (true)
      {
        m = i3;
        localObject1 = localObject2;
        k = i2;
        i = i1;
        break;
        int i7 = a.g(paramParcel, n);
        int i8 = i;
        i2 = k;
        localObject2 = localObject1;
        i3 = i7;
        i1 = i8;
        continue;
        Uri localUri = (Uri)a.a(paramParcel, n, Uri.CREATOR);
        i3 = m;
        int i6 = k;
        localObject2 = localUri;
        i1 = i;
        i2 = i6;
        continue;
        int i4 = a.g(paramParcel, n);
        localObject2 = localObject1;
        i3 = m;
        int i5 = i;
        i2 = i4;
        i1 = i5;
        continue;
        i1 = a.g(paramParcel, n);
        i2 = k;
        localObject2 = localObject1;
        i3 = m;
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new b("Overread allowed size end=" + j, paramParcel);
    return new WebImage(m, localObject1, k, i);
  }

  public WebImage[] a(int paramInt)
  {
    return new WebImage[paramInt];
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.images.h
 * JD-Core Version:    0.6.0
 */