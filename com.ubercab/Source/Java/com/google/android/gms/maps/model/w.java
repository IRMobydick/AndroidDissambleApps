package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class w
  implements Parcelable.Creator<TileOverlayOptions>
{
  static void a(TileOverlayOptions paramTileOverlayOptions, Parcel paramParcel, int paramInt)
  {
    int i = b.D(paramParcel);
    b.c(paramParcel, 1, paramTileOverlayOptions.getVersionCode());
    b.a(paramParcel, 2, paramTileOverlayOptions.mR(), false);
    b.a(paramParcel, 3, paramTileOverlayOptions.isVisible());
    b.a(paramParcel, 4, paramTileOverlayOptions.getZIndex());
    b.a(paramParcel, 5, paramTileOverlayOptions.getFadeIn());
    b.H(paramParcel, i);
  }

  public TileOverlayOptions cV(Parcel paramParcel)
  {
    boolean bool1 = false;
    int i = a.C(paramParcel);
    IBinder localIBinder = null;
    float f = 0.0F;
    boolean bool2 = true;
    int j = 0;
    while (paramParcel.dataPosition() < i)
    {
      int k = a.B(paramParcel);
      switch (a.aD(k))
      {
      default:
        a.b(paramParcel, k);
        break;
      case 1:
        j = a.g(paramParcel, k);
        break;
      case 2:
        localIBinder = a.p(paramParcel, k);
        break;
      case 3:
        bool1 = a.c(paramParcel, k);
        break;
      case 4:
        f = a.l(paramParcel, k);
        break;
      case 5:
        bool2 = a.c(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    return new TileOverlayOptions(j, localIBinder, bool1, f, bool2);
  }

  public TileOverlayOptions[] eL(int paramInt)
  {
    return new TileOverlayOptions[paramInt];
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.w
 * JD-Core Version:    0.6.2
 */