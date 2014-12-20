package com.google.android.gms.games.internal.game;

import android.net.Uri;
import android.os.Parcel;

final class c extends d
{
  public GameBadgeEntity a(Parcel paramParcel)
  {
    GameBadgeEntity localGameBadgeEntity;
    if ((GameBadgeEntity.a(GameBadgeEntity.h())) || (GameBadgeEntity.a(GameBadgeEntity.class.getCanonicalName())))
    {
      localGameBadgeEntity = super.a(paramParcel);
      return localGameBadgeEntity;
    }
    int i = paramParcel.readInt();
    String str1 = paramParcel.readString();
    String str2 = paramParcel.readString();
    String str3 = paramParcel.readString();
    if (str3 == null);
    for (Uri localUri = null; ; localUri = Uri.parse(str3))
    {
      localGameBadgeEntity = new GameBadgeEntity(1, i, str1, str2, localUri);
      break;
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.internal.game.c
 * JD-Core Version:    0.6.0
 */