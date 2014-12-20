package com.google.android.gms.games.multiplayer;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.games.PlayerEntity;

final class c extends d
{
  public ParticipantEntity a(Parcel paramParcel)
  {
    boolean bool1 = true;
    ParticipantEntity localParticipantEntity;
    if ((ParticipantEntity.a(ParticipantEntity.p())) || (ParticipantEntity.a(ParticipantEntity.class.getCanonicalName())))
    {
      localParticipantEntity = super.a(paramParcel);
      return localParticipantEntity;
    }
    String str1 = paramParcel.readString();
    String str2 = paramParcel.readString();
    String str3 = paramParcel.readString();
    Uri localUri1;
    label56: String str4;
    Uri localUri2;
    label70: int i;
    String str5;
    boolean bool2;
    if (str3 == null)
    {
      localUri1 = null;
      str4 = paramParcel.readString();
      if (str4 != null)
        break label160;
      localUri2 = null;
      i = paramParcel.readInt();
      str5 = paramParcel.readString();
      if (paramParcel.readInt() <= 0)
        break label170;
      bool2 = bool1;
      label92: if (paramParcel.readInt() <= 0)
        break label176;
      label99: if (!bool1)
        break label181;
    }
    label160: label170: label176: label181: for (PlayerEntity localPlayerEntity = (PlayerEntity)PlayerEntity.CREATOR.createFromParcel(paramParcel); ; localPlayerEntity = null)
    {
      localParticipantEntity = new ParticipantEntity(3, str1, str2, localUri1, localUri2, i, str5, bool2, localPlayerEntity, 7, null, null, null);
      break;
      localUri1 = Uri.parse(str3);
      break label56;
      localUri2 = Uri.parse(str4);
      break label70;
      bool2 = false;
      break label92;
      bool1 = false;
      break label99;
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.multiplayer.c
 * JD-Core Version:    0.6.0
 */