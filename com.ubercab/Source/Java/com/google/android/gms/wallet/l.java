package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.ArrayList;

public class l
  implements Parcelable.Creator<MaskedWalletRequest>
{
  static void a(MaskedWalletRequest paramMaskedWalletRequest, Parcel paramParcel, int paramInt)
  {
    int i = b.D(paramParcel);
    b.c(paramParcel, 1, paramMaskedWalletRequest.getVersionCode());
    b.a(paramParcel, 2, paramMaskedWalletRequest.asC, false);
    b.a(paramParcel, 3, paramMaskedWalletRequest.atp);
    b.a(paramParcel, 4, paramMaskedWalletRequest.atq);
    b.a(paramParcel, 5, paramMaskedWalletRequest.atr);
    b.a(paramParcel, 6, paramMaskedWalletRequest.ats, false);
    b.a(paramParcel, 7, paramMaskedWalletRequest.asw, false);
    b.a(paramParcel, 8, paramMaskedWalletRequest.att, false);
    b.a(paramParcel, 9, paramMaskedWalletRequest.asL, paramInt, false);
    b.a(paramParcel, 10, paramMaskedWalletRequest.atu);
    b.a(paramParcel, 11, paramMaskedWalletRequest.atv);
    b.a(paramParcel, 12, paramMaskedWalletRequest.atw, paramInt, false);
    b.a(paramParcel, 13, paramMaskedWalletRequest.atx);
    b.a(paramParcel, 14, paramMaskedWalletRequest.aty);
    b.c(paramParcel, 15, paramMaskedWalletRequest.atz, false);
    b.H(paramParcel, i);
  }

  public MaskedWalletRequest dx(Parcel paramParcel)
  {
    int i = a.C(paramParcel);
    int j = 0;
    String str1 = null;
    boolean bool1 = false;
    boolean bool2 = false;
    boolean bool3 = false;
    String str2 = null;
    String str3 = null;
    String str4 = null;
    Cart localCart = null;
    boolean bool4 = false;
    boolean bool5 = false;
    CountrySpecification[] arrayOfCountrySpecification = null;
    boolean bool6 = true;
    boolean bool7 = true;
    ArrayList localArrayList = null;
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
        str1 = a.o(paramParcel, k);
        break;
      case 3:
        bool1 = a.c(paramParcel, k);
        break;
      case 4:
        bool2 = a.c(paramParcel, k);
        break;
      case 5:
        bool3 = a.c(paramParcel, k);
        break;
      case 6:
        str2 = a.o(paramParcel, k);
        break;
      case 7:
        str3 = a.o(paramParcel, k);
        break;
      case 8:
        str4 = a.o(paramParcel, k);
        break;
      case 9:
        localCart = (Cart)a.a(paramParcel, k, Cart.CREATOR);
        break;
      case 10:
        bool4 = a.c(paramParcel, k);
        break;
      case 11:
        bool5 = a.c(paramParcel, k);
        break;
      case 12:
        arrayOfCountrySpecification = (CountrySpecification[])a.b(paramParcel, k, CountrySpecification.CREATOR);
        break;
      case 13:
        bool6 = a.c(paramParcel, k);
        break;
      case 14:
        bool7 = a.c(paramParcel, k);
        break;
      case 15:
        localArrayList = a.c(paramParcel, k, com.google.android.gms.identity.intents.model.CountrySpecification.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    return new MaskedWalletRequest(j, str1, bool1, bool2, bool3, str2, str3, str4, localCart, bool4, bool5, arrayOfCountrySpecification, bool6, bool7, localArrayList);
  }

  public MaskedWalletRequest[] fy(int paramInt)
  {
    return new MaskedWalletRequest[paramInt];
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wallet.l
 * JD-Core Version:    0.6.2
 */