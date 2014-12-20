package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;

final class a extends b
{
  public GameEntity a(Parcel paramParcel)
  {
    GameEntity localGameEntity;
    if ((GameEntity.a(GameEntity.A())) || (GameEntity.a(GameEntity.class.getCanonicalName())))
    {
      localGameEntity = super.a(paramParcel);
      return localGameEntity;
    }
    String str1 = paramParcel.readString();
    String str2 = paramParcel.readString();
    String str3 = paramParcel.readString();
    String str4 = paramParcel.readString();
    String str5 = paramParcel.readString();
    String str6 = paramParcel.readString();
    String str7 = paramParcel.readString();
    Uri localUri1;
    label77: String str8;
    Uri localUri2;
    label91: String str9;
    Uri localUri3;
    label105: boolean bool1;
    if (str7 == null)
    {
      localUri1 = null;
      str8 = paramParcel.readString();
      if (str8 != null)
        break label192;
      localUri2 = null;
      str9 = paramParcel.readString();
      if (str9 != null)
        break label202;
      localUri3 = null;
      if (paramParcel.readInt() <= 0)
        break label212;
      bool1 = true;
      label115: if (paramParcel.readInt() <= 0)
        break label218;
    }
    label192: label202: label212: label218: for (boolean bool2 = true; ; bool2 = false)
    {
      localGameEntity = new GameEntity(4, str1, str2, str3, str4, str5, str6, localUri1, localUri2, localUri3, bool1, bool2, paramParcel.readString(), paramParcel.readInt(), paramParcel.readInt(), paramParcel.readInt(), false, false, null, null, null, false, false, false);
      break;
      localUri1 = Uri.parse(str7);
      break label77;
      localUri2 = Uri.parse(str8);
      break label91;
      localUri3 = Uri.parse(str9);
      break label105;
      bool1 = false;
      break label115;
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.a
 * JD-Core Version:    0.6.0
 */