package com.google.android.gms.auth.api;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.ArrayList;

public class GoogleAuthApiRequestCreator
  implements Parcelable.Creator<GoogleAuthApiRequest>
{
  public static final int CONTENT_DESCRIPTION;

  static void a(GoogleAuthApiRequest paramGoogleAuthApiRequest, Parcel paramParcel, int paramInt)
  {
    int i = b.D(paramParcel);
    b.a(paramParcel, 1, paramGoogleAuthApiRequest.name, false);
    b.c(paramParcel, 1000, paramGoogleAuthApiRequest.versionCode);
    b.a(paramParcel, 2, paramGoogleAuthApiRequest.version, false);
    b.a(paramParcel, 3, paramGoogleAuthApiRequest.Dt, false);
    b.a(paramParcel, 4, paramGoogleAuthApiRequest.yR, false);
    b.a(paramParcel, 5, paramGoogleAuthApiRequest.Du, false);
    b.a(paramParcel, 6, paramGoogleAuthApiRequest.Dv, false);
    b.b(paramParcel, 7, paramGoogleAuthApiRequest.Dw, false);
    b.a(paramParcel, 8, paramGoogleAuthApiRequest.Dx, false);
    b.c(paramParcel, 9, paramGoogleAuthApiRequest.Dy);
    b.a(paramParcel, 10, paramGoogleAuthApiRequest.Dz, false);
    b.a(paramParcel, 11, paramGoogleAuthApiRequest.DA, false);
    b.a(paramParcel, 12, paramGoogleAuthApiRequest.DB);
    b.H(paramParcel, i);
  }

  public GoogleAuthApiRequest createFromParcel(Parcel paramParcel)
  {
    int i = a.C(paramParcel);
    int j = 0;
    String str1 = null;
    String str2 = null;
    String str3 = null;
    String str4 = null;
    Bundle localBundle1 = null;
    String str5 = null;
    ArrayList localArrayList = null;
    String str6 = null;
    int k = 0;
    Bundle localBundle2 = null;
    byte[] arrayOfByte = null;
    long l = 0L;
    while (paramParcel.dataPosition() < i)
    {
      int m = a.B(paramParcel);
      switch (a.aD(m))
      {
      default:
        a.b(paramParcel, m);
        break;
      case 1:
        str1 = a.o(paramParcel, m);
        break;
      case 1000:
        j = a.g(paramParcel, m);
        break;
      case 2:
        str2 = a.o(paramParcel, m);
        break;
      case 3:
        str3 = a.o(paramParcel, m);
        break;
      case 4:
        str4 = a.o(paramParcel, m);
        break;
      case 5:
        localBundle1 = a.q(paramParcel, m);
        break;
      case 6:
        str5 = a.o(paramParcel, m);
        break;
      case 7:
        localArrayList = a.C(paramParcel, m);
        break;
      case 8:
        str6 = a.o(paramParcel, m);
        break;
      case 9:
        k = a.g(paramParcel, m);
        break;
      case 10:
        localBundle2 = a.q(paramParcel, m);
        break;
      case 11:
        arrayOfByte = a.r(paramParcel, m);
        break;
      case 12:
        l = a.i(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    return new GoogleAuthApiRequest(j, str1, str2, str3, str4, localBundle1, str5, localArrayList, str6, k, localBundle2, arrayOfByte, l);
  }

  public GoogleAuthApiRequest[] newArray(int paramInt)
  {
    return new GoogleAuthApiRequest[paramInt];
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.auth.api.GoogleAuthApiRequestCreator
 * JD-Core Version:    0.6.2
 */