package com.google.android.gms.games.internal.game;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.games.GameEntity;
import java.util.ArrayList;

final class a extends b
{
  public ExtendedGameEntity a(Parcel paramParcel)
  {
    if ((ExtendedGameEntity.a(ExtendedGameEntity.p())) || (ExtendedGameEntity.a(ExtendedGameEntity.class.getCanonicalName())));
    GameEntity localGameEntity;
    int i;
    boolean bool;
    int j;
    long l1;
    long l2;
    String str1;
    long l3;
    String str2;
    ArrayList localArrayList;
    for (ExtendedGameEntity localExtendedGameEntity = super.a(paramParcel); ; localExtendedGameEntity = new ExtendedGameEntity(2, localGameEntity, i, bool, j, l1, l2, str1, l3, str2, localArrayList, null))
    {
      return localExtendedGameEntity;
      localGameEntity = (GameEntity)GameEntity.CREATOR.createFromParcel(paramParcel);
      i = paramParcel.readInt();
      if (paramParcel.readInt() == 1);
      for (bool = true; ; bool = false)
      {
        j = paramParcel.readInt();
        l1 = paramParcel.readLong();
        l2 = paramParcel.readLong();
        str1 = paramParcel.readString();
        l3 = paramParcel.readLong();
        str2 = paramParcel.readString();
        int k = paramParcel.readInt();
        localArrayList = new ArrayList(k);
        for (int m = 0; m < k; m++)
          localArrayList.add(GameBadgeEntity.a.a(paramParcel));
      }
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.internal.game.a
 * JD-Core Version:    0.6.0
 */