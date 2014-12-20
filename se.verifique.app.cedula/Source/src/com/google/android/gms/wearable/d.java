package com.google.android.gms.wearable;

import android.net.Uri;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class d
  implements Parcelable.Creator
{
  static void a(Asset paramAsset, Parcel paramParcel, int paramInt)
  {
    int i = c.a(paramParcel);
    c.a(paramParcel, 1, paramAsset.a);
    c.a(paramParcel, 2, paramAsset.a(), false);
    c.a(paramParcel, 3, paramAsset.b(), false);
    c.a(paramParcel, 4, paramAsset.b, paramInt, false);
    c.a(paramParcel, 5, paramAsset.c, paramInt, false);
    c.a(paramParcel, i);
  }

  public Asset a(Parcel paramParcel)
  {
    Uri localUri = null;
    int i = a.b(paramParcel);
    int j = 0;
    ParcelFileDescriptor localParcelFileDescriptor = null;
    String str = null;
    byte[] arrayOfByte = null;
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
        arrayOfByte = a.r(paramParcel, k);
        break;
      case 3:
        str = a.o(paramParcel, k);
        break;
      case 4:
        localParcelFileDescriptor = (ParcelFileDescriptor)a.a(paramParcel, k, ParcelFileDescriptor.CREATOR);
        break;
      case 5:
        localUri = (Uri)a.a(paramParcel, k, Uri.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new b("Overread allowed size end=" + i, paramParcel);
    return new Asset(j, arrayOfByte, str, localParcelFileDescriptor, localUri);
  }

  public Asset[] a(int paramInt)
  {
    return new Asset[paramInt];
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.d
 * JD-Core Version:    0.6.0
 */