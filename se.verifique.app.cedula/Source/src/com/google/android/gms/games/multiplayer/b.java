package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.games.GameEntity;
import java.util.ArrayList;

public class b
  implements Parcelable.Creator
{
  static void a(InvitationEntity paramInvitationEntity, Parcel paramParcel, int paramInt)
  {
    int i = c.a(paramParcel);
    c.a(paramParcel, 1, paramInvitationEntity.d(), paramInt, false);
    c.a(paramParcel, 1000, paramInvitationEntity.b());
    c.a(paramParcel, 2, paramInvitationEntity.e(), false);
    c.a(paramParcel, 3, paramInvitationEntity.g());
    c.a(paramParcel, 4, paramInvitationEntity.h());
    c.a(paramParcel, 5, paramInvitationEntity.f(), paramInt, false);
    c.b(paramParcel, 6, paramInvitationEntity.l(), false);
    c.a(paramParcel, 7, paramInvitationEntity.i());
    c.a(paramParcel, 8, paramInvitationEntity.j());
    c.a(paramParcel, i);
  }

  public InvitationEntity a(Parcel paramParcel)
  {
    ArrayList localArrayList = null;
    int i = 0;
    int j = a.b(paramParcel);
    long l = 0L;
    int k = 0;
    ParticipantEntity localParticipantEntity = null;
    int m = 0;
    String str = null;
    GameEntity localGameEntity = null;
    int n = 0;
    while (paramParcel.dataPosition() < j)
    {
      int i1 = a.a(paramParcel);
      switch (a.a(i1))
      {
      default:
        a.b(paramParcel, i1);
        break;
      case 1:
        localGameEntity = (GameEntity)a.a(paramParcel, i1, GameEntity.CREATOR);
        break;
      case 1000:
        n = a.g(paramParcel, i1);
        break;
      case 2:
        str = a.o(paramParcel, i1);
        break;
      case 3:
        l = a.i(paramParcel, i1);
        break;
      case 4:
        m = a.g(paramParcel, i1);
        break;
      case 5:
        localParticipantEntity = (ParticipantEntity)a.a(paramParcel, i1, ParticipantEntity.CREATOR);
        break;
      case 6:
        localArrayList = a.c(paramParcel, i1, ParticipantEntity.CREATOR);
        break;
      case 7:
        k = a.g(paramParcel, i1);
        break;
      case 8:
        i = a.g(paramParcel, i1);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new com.google.android.gms.common.internal.safeparcel.b("Overread allowed size end=" + j, paramParcel);
    return new InvitationEntity(n, localGameEntity, str, l, m, localParticipantEntity, localArrayList, k, i);
  }

  public InvitationEntity[] a(int paramInt)
  {
    return new InvitationEntity[paramInt];
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.multiplayer.b
 * JD-Core Version:    0.6.0
 */