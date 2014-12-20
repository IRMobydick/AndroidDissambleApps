package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.games.GameEntity;
import java.util.ArrayList;

final class a extends b
{
  public InvitationEntity a(Parcel paramParcel)
  {
    if ((InvitationEntity.a(InvitationEntity.k())) || (InvitationEntity.a(InvitationEntity.class.getCanonicalName())));
    GameEntity localGameEntity;
    String str;
    long l;
    int i;
    ParticipantEntity localParticipantEntity;
    ArrayList localArrayList;
    for (InvitationEntity localInvitationEntity = super.a(paramParcel); ; localInvitationEntity = new InvitationEntity(2, localGameEntity, str, l, i, localParticipantEntity, localArrayList, -1, 0))
    {
      return localInvitationEntity;
      localGameEntity = (GameEntity)GameEntity.CREATOR.createFromParcel(paramParcel);
      str = paramParcel.readString();
      l = paramParcel.readLong();
      i = paramParcel.readInt();
      localParticipantEntity = (ParticipantEntity)ParticipantEntity.CREATOR.createFromParcel(paramParcel);
      int j = paramParcel.readInt();
      localArrayList = new ArrayList(j);
      for (int k = 0; k < j; k++)
        localArrayList.add(ParticipantEntity.CREATOR.createFromParcel(paramParcel));
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.multiplayer.a
 * JD-Core Version:    0.6.0
 */