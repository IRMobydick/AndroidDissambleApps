package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.ArrayList;

public class ParcelableClientSettingsCreator
  implements Parcelable.Creator<ClientSettings.ParcelableClientSettings>
{
  public static final int CONTENT_DESCRIPTION;

  static void a(ClientSettings.ParcelableClientSettings paramParcelableClientSettings, Parcel paramParcel, int paramInt)
  {
    int i = b.D(paramParcel);
    b.a(paramParcel, 1, paramParcelableClientSettings.getAccountName(), false);
    b.c(paramParcel, 1000, paramParcelableClientSettings.getVersionCode());
    b.b(paramParcel, 2, paramParcelableClientSettings.getScopes(), false);
    b.c(paramParcel, 3, paramParcelableClientSettings.getGravityForPopups());
    b.a(paramParcel, 4, paramParcelableClientSettings.getRealClientPackageName(), false);
    b.H(paramParcel, i);
  }

  public ClientSettings.ParcelableClientSettings createFromParcel(Parcel paramParcel)
  {
    int i = 0;
    String str1 = null;
    int j = a.C(paramParcel);
    ArrayList localArrayList = null;
    String str2 = null;
    int k = 0;
    while (paramParcel.dataPosition() < j)
    {
      int m = a.B(paramParcel);
      switch (a.aD(m))
      {
      default:
        a.b(paramParcel, m);
        break;
      case 1:
        str2 = a.o(paramParcel, m);
        break;
      case 1000:
        k = a.g(paramParcel, m);
        break;
      case 2:
        localArrayList = a.C(paramParcel, m);
        break;
      case 3:
        i = a.g(paramParcel, m);
        break;
      case 4:
        str1 = a.o(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    return new ClientSettings.ParcelableClientSettings(k, str2, localArrayList, i, str1);
  }

  public ClientSettings.ParcelableClientSettings[] newArray(int paramInt)
  {
    return new ClientSettings.ParcelableClientSettings[paramInt];
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.internal.ParcelableClientSettingsCreator
 * JD-Core Version:    0.6.2
 */