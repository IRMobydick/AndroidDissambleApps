package com.google.android.gms.identity.intents;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.identity.intents.model.CountrySpecification;
import java.util.ArrayList;

public class a
  implements Parcelable.Creator<UserAddressRequest>
{
  static void a(UserAddressRequest paramUserAddressRequest, Parcel paramParcel, int paramInt)
  {
    int i = b.D(paramParcel);
    b.c(paramParcel, 1, paramUserAddressRequest.getVersionCode());
    b.c(paramParcel, 2, paramUserAddressRequest.adK, false);
    b.H(paramParcel, i);
  }

  public UserAddressRequest cp(Parcel paramParcel)
  {
    int i = com.google.android.gms.common.internal.safeparcel.a.C(paramParcel);
    int j = 0;
    ArrayList localArrayList = null;
    while (paramParcel.dataPosition() < i)
    {
      int k = com.google.android.gms.common.internal.safeparcel.a.B(paramParcel);
      switch (com.google.android.gms.common.internal.safeparcel.a.aD(k))
      {
      default:
        com.google.android.gms.common.internal.safeparcel.a.b(paramParcel, k);
        break;
      case 1:
        j = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, k);
        break;
      case 2:
        localArrayList = com.google.android.gms.common.internal.safeparcel.a.c(paramParcel, k, CountrySpecification.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    return new UserAddressRequest(j, localArrayList);
  }

  public UserAddressRequest[] dX(int paramInt)
  {
    return new UserAddressRequest[paramInt];
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.identity.intents.a
 * JD-Core Version:    0.6.2
 */