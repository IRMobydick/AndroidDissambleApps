package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;

final class c extends d
{
  public PlayerEntity a(Parcel paramParcel)
  {
    PlayerEntity localPlayerEntity;
    if ((PlayerEntity.a(PlayerEntity.q())) || (PlayerEntity.a(PlayerEntity.class.getCanonicalName())))
    {
      localPlayerEntity = super.a(paramParcel);
      return localPlayerEntity;
    }
    String str1 = paramParcel.readString();
    String str2 = paramParcel.readString();
    String str3 = paramParcel.readString();
    String str4 = paramParcel.readString();
    Uri localUri1;
    if (str3 == null)
    {
      localUri1 = null;
      label59: if (str4 != null)
        break label112;
    }
    label112: for (Uri localUri2 = null; ; localUri2 = Uri.parse(str4))
    {
      localPlayerEntity = new PlayerEntity(10, str1, str2, localUri1, localUri2, paramParcel.readLong(), -1, -1L, null, null, null, null, null, true);
      break;
      localUri1 = Uri.parse(str3);
      break label59;
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.c
 * JD-Core Version:    0.6.0
 */