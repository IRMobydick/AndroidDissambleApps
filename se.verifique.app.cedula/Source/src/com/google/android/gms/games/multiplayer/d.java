package com.google.android.gms.games.multiplayer;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.games.PlayerEntity;

public class d
  implements Parcelable.Creator
{
  static void a(ParticipantEntity paramParticipantEntity, Parcel paramParcel, int paramInt)
  {
    int i = c.a(paramParcel);
    c.a(paramParcel, 1, paramParticipantEntity.k(), false);
    c.a(paramParcel, 1000, paramParticipantEntity.n());
    c.a(paramParcel, 2, paramParticipantEntity.f(), false);
    c.a(paramParcel, 3, paramParticipantEntity.g(), paramInt, false);
    c.a(paramParcel, 4, paramParticipantEntity.i(), paramInt, false);
    c.a(paramParcel, 5, paramParticipantEntity.g_());
    c.a(paramParcel, 6, paramParticipantEntity.c(), false);
    c.a(paramParcel, 7, paramParticipantEntity.e());
    c.a(paramParcel, 8, paramParticipantEntity.l(), paramInt, false);
    c.a(paramParcel, 9, paramParticipantEntity.d());
    c.a(paramParcel, 10, paramParticipantEntity.m(), paramInt, false);
    c.a(paramParcel, 11, paramParticipantEntity.h(), false);
    c.a(paramParcel, 12, paramParticipantEntity.j(), false);
    c.a(paramParcel, i);
  }

  public ParticipantEntity a(Parcel paramParcel)
  {
    int i = a.b(paramParcel);
    int j = 0;
    String str1 = null;
    String str2 = null;
    Uri localUri1 = null;
    Uri localUri2 = null;
    int k = 0;
    String str3 = null;
    boolean bool = false;
    PlayerEntity localPlayerEntity = null;
    int m = 0;
    ParticipantResult localParticipantResult = null;
    String str4 = null;
    String str5 = null;
    while (paramParcel.dataPosition() < i)
    {
      int n = a.a(paramParcel);
      switch (a.a(n))
      {
      default:
        a.b(paramParcel, n);
        break;
      case 1:
        str1 = a.o(paramParcel, n);
        break;
      case 1000:
        j = a.g(paramParcel, n);
        break;
      case 2:
        str2 = a.o(paramParcel, n);
        break;
      case 3:
        localUri1 = (Uri)a.a(paramParcel, n, Uri.CREATOR);
        break;
      case 4:
        localUri2 = (Uri)a.a(paramParcel, n, Uri.CREATOR);
        break;
      case 5:
        k = a.g(paramParcel, n);
        break;
      case 6:
        str3 = a.o(paramParcel, n);
        break;
      case 7:
        bool = a.c(paramParcel, n);
        break;
      case 8:
        localPlayerEntity = (PlayerEntity)a.a(paramParcel, n, PlayerEntity.CREATOR);
        break;
      case 9:
        m = a.g(paramParcel, n);
        break;
      case 10:
        localParticipantResult = (ParticipantResult)a.a(paramParcel, n, ParticipantResult.a);
        break;
      case 11:
        str4 = a.o(paramParcel, n);
        break;
      case 12:
        str5 = a.o(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new b("Overread allowed size end=" + i, paramParcel);
    return new ParticipantEntity(j, str1, str2, localUri1, localUri2, k, str3, bool, localPlayerEntity, m, localParticipantResult, str4, str5);
  }

  public ParticipantEntity[] a(int paramInt)
  {
    return new ParticipantEntity[paramInt];
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.multiplayer.d
 * JD-Core Version:    0.6.0
 */