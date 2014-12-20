package com.google.android.gms.games.multiplayer.realtime;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import java.util.ArrayList;

final class c extends d
{
  public RoomEntity a(Parcel paramParcel)
  {
    if ((RoomEntity.a(RoomEntity.m())) || (RoomEntity.a(RoomEntity.class.getCanonicalName())));
    String str1;
    String str2;
    long l;
    int i;
    String str3;
    int j;
    Bundle localBundle;
    ArrayList localArrayList;
    for (RoomEntity localRoomEntity = super.a(paramParcel); ; localRoomEntity = new RoomEntity(2, str1, str2, l, i, str3, j, localBundle, localArrayList, -1))
    {
      return localRoomEntity;
      str1 = paramParcel.readString();
      str2 = paramParcel.readString();
      l = paramParcel.readLong();
      i = paramParcel.readInt();
      str3 = paramParcel.readString();
      j = paramParcel.readInt();
      localBundle = paramParcel.readBundle();
      int k = paramParcel.readInt();
      localArrayList = new ArrayList(k);
      for (int m = 0; m < k; m++)
        localArrayList.add(ParticipantEntity.CREATOR.createFromParcel(paramParcel));
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.multiplayer.realtime.c
 * JD-Core Version:    0.6.0
 */