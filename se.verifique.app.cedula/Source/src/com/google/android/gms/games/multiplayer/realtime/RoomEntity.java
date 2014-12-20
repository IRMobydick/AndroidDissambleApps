package com.google.android.gms.games.multiplayer.realtime;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import com.google.android.gms.internal.kt;
import com.google.android.gms.internal.kv;
import java.util.ArrayList;

public final class RoomEntity extends GamesDowngradeableSafeParcel
  implements Room
{
  public static final Parcelable.Creator CREATOR = new c();
  private final int a;
  private final String b;
  private final String c;
  private final long d;
  private final int e;
  private final String f;
  private final int g;
  private final Bundle h;
  private final ArrayList i;
  private final int j;

  RoomEntity(int paramInt1, String paramString1, String paramString2, long paramLong, int paramInt2, String paramString3, int paramInt3, Bundle paramBundle, ArrayList paramArrayList, int paramInt4)
  {
    this.a = paramInt1;
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramLong;
    this.e = paramInt2;
    this.f = paramString3;
    this.g = paramInt3;
    this.h = paramBundle;
    this.i = paramArrayList;
    this.j = paramInt4;
  }

  public RoomEntity(Room paramRoom)
  {
    this.a = 2;
    this.b = paramRoom.h_();
    this.c = paramRoom.c();
    this.d = paramRoom.d();
    this.e = paramRoom.e();
    this.f = paramRoom.f();
    this.g = paramRoom.g();
    this.h = paramRoom.h();
    ArrayList localArrayList = paramRoom.l();
    int k = localArrayList.size();
    this.i = new ArrayList(k);
    for (int m = 0; m < k; m++)
      this.i.add((ParticipantEntity)((Participant)localArrayList.get(m)).a());
    this.j = paramRoom.i();
  }

  static int a(Room paramRoom)
  {
    Object[] arrayOfObject = new Object[9];
    arrayOfObject[0] = paramRoom.h_();
    arrayOfObject[1] = paramRoom.c();
    arrayOfObject[2] = Long.valueOf(paramRoom.d());
    arrayOfObject[3] = Integer.valueOf(paramRoom.e());
    arrayOfObject[4] = paramRoom.f();
    arrayOfObject[5] = Integer.valueOf(paramRoom.g());
    arrayOfObject[6] = paramRoom.h();
    arrayOfObject[7] = paramRoom.l();
    arrayOfObject[8] = Integer.valueOf(paramRoom.i());
    return kt.a(arrayOfObject);
  }

  static boolean a(Room paramRoom, Object paramObject)
  {
    int k = 1;
    if (!(paramObject instanceof Room))
      k = 0;
    while (true)
    {
      return k;
      if (paramRoom == paramObject)
        continue;
      Room localRoom = (Room)paramObject;
      if ((kt.a(localRoom.h_(), paramRoom.h_())) && (kt.a(localRoom.c(), paramRoom.c())) && (kt.a(Long.valueOf(localRoom.d()), Long.valueOf(paramRoom.d()))) && (kt.a(Integer.valueOf(localRoom.e()), Integer.valueOf(paramRoom.e()))) && (kt.a(localRoom.f(), paramRoom.f())) && (kt.a(Integer.valueOf(localRoom.g()), Integer.valueOf(paramRoom.g()))) && (kt.a(localRoom.h(), paramRoom.h())) && (kt.a(localRoom.l(), paramRoom.l())) && (kt.a(Integer.valueOf(localRoom.i()), Integer.valueOf(paramRoom.i()))))
        continue;
      k = 0;
    }
  }

  static String b(Room paramRoom)
  {
    return kt.a(paramRoom).a("RoomId", paramRoom.h_()).a("CreatorId", paramRoom.c()).a("CreationTimestamp", Long.valueOf(paramRoom.d())).a("RoomStatus", Integer.valueOf(paramRoom.e())).a("Description", paramRoom.f()).a("Variant", Integer.valueOf(paramRoom.g())).a("AutoMatchCriteria", paramRoom.h()).a("Participants", paramRoom.l()).a("AutoMatchWaitEstimateSeconds", Integer.valueOf(paramRoom.i())).toString();
  }

  public String c()
  {
    return this.c;
  }

  public long d()
  {
    return this.d;
  }

  public int describeContents()
  {
    return 0;
  }

  public int e()
  {
    return this.e;
  }

  public boolean equals(Object paramObject)
  {
    return a(this, paramObject);
  }

  public String f()
  {
    return this.f;
  }

  public int g()
  {
    return this.g;
  }

  public Bundle h()
  {
    return this.h;
  }

  public String h_()
  {
    return this.b;
  }

  public int hashCode()
  {
    return a(this);
  }

  public int i()
  {
    return this.j;
  }

  public int j()
  {
    return this.a;
  }

  public Room k()
  {
    return this;
  }

  public ArrayList l()
  {
    return new ArrayList(this.i);
  }

  public String toString()
  {
    return b(this);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (!D())
      d.a(this, paramParcel, paramInt);
    while (true)
    {
      return;
      paramParcel.writeString(this.b);
      paramParcel.writeString(this.c);
      paramParcel.writeLong(this.d);
      paramParcel.writeInt(this.e);
      paramParcel.writeString(this.f);
      paramParcel.writeInt(this.g);
      paramParcel.writeBundle(this.h);
      int k = this.i.size();
      paramParcel.writeInt(k);
      for (int m = 0; m < k; m++)
        ((ParticipantEntity)this.i.get(m)).writeToParcel(paramParcel, paramInt);
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.multiplayer.realtime.RoomEntity
 * JD-Core Version:    0.6.0
 */