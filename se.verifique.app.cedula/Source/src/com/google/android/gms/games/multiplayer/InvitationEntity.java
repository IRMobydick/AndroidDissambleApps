package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.internal.kt;
import com.google.android.gms.internal.kv;
import com.google.android.gms.internal.kx;
import java.util.ArrayList;

public final class InvitationEntity extends GamesDowngradeableSafeParcel
  implements Invitation
{
  public static final Parcelable.Creator CREATOR = new a();
  private final int a;
  private final GameEntity b;
  private final String c;
  private final long d;
  private final int e;
  private final ParticipantEntity f;
  private final ArrayList g;
  private final int h;
  private final int i;

  InvitationEntity(int paramInt1, GameEntity paramGameEntity, String paramString, long paramLong, int paramInt2, ParticipantEntity paramParticipantEntity, ArrayList paramArrayList, int paramInt3, int paramInt4)
  {
    this.a = paramInt1;
    this.b = paramGameEntity;
    this.c = paramString;
    this.d = paramLong;
    this.e = paramInt2;
    this.f = paramParticipantEntity;
    this.g = paramArrayList;
    this.h = paramInt3;
    this.i = paramInt4;
  }

  InvitationEntity(Invitation paramInvitation)
  {
    this.a = 2;
    this.b = new GameEntity(paramInvitation.d());
    this.c = paramInvitation.e();
    this.d = paramInvitation.g();
    this.e = paramInvitation.h();
    this.h = paramInvitation.i();
    this.i = paramInvitation.j();
    String str = paramInvitation.f().k();
    Object localObject = null;
    ArrayList localArrayList = paramInvitation.l();
    int j = localArrayList.size();
    this.g = new ArrayList(j);
    for (int k = 0; k < j; k++)
    {
      Participant localParticipant = (Participant)localArrayList.get(k);
      if (localParticipant.k().equals(str))
        localObject = localParticipant;
      this.g.add((ParticipantEntity)localParticipant.a());
    }
    kx.a(localObject, "Must have a valid inviter!");
    this.f = ((ParticipantEntity)localObject.a());
  }

  static int a(Invitation paramInvitation)
  {
    Object[] arrayOfObject = new Object[8];
    arrayOfObject[0] = paramInvitation.d();
    arrayOfObject[1] = paramInvitation.e();
    arrayOfObject[2] = Long.valueOf(paramInvitation.g());
    arrayOfObject[3] = Integer.valueOf(paramInvitation.h());
    arrayOfObject[4] = paramInvitation.f();
    arrayOfObject[5] = paramInvitation.l();
    arrayOfObject[6] = Integer.valueOf(paramInvitation.i());
    arrayOfObject[7] = Integer.valueOf(paramInvitation.j());
    return kt.a(arrayOfObject);
  }

  static boolean a(Invitation paramInvitation, Object paramObject)
  {
    int j = 1;
    if (!(paramObject instanceof Invitation))
      j = 0;
    while (true)
    {
      return j;
      if (paramInvitation == paramObject)
        continue;
      Invitation localInvitation = (Invitation)paramObject;
      if ((kt.a(localInvitation.d(), paramInvitation.d())) && (kt.a(localInvitation.e(), paramInvitation.e())) && (kt.a(Long.valueOf(localInvitation.g()), Long.valueOf(paramInvitation.g()))) && (kt.a(Integer.valueOf(localInvitation.h()), Integer.valueOf(paramInvitation.h()))) && (kt.a(localInvitation.f(), paramInvitation.f())) && (kt.a(localInvitation.l(), paramInvitation.l())) && (kt.a(Integer.valueOf(localInvitation.i()), Integer.valueOf(paramInvitation.i()))) && (kt.a(Integer.valueOf(localInvitation.j()), Integer.valueOf(paramInvitation.j()))))
        continue;
      j = 0;
    }
  }

  static String b(Invitation paramInvitation)
  {
    return kt.a(paramInvitation).a("Game", paramInvitation.d()).a("InvitationId", paramInvitation.e()).a("CreationTimestamp", Long.valueOf(paramInvitation.g())).a("InvitationType", Integer.valueOf(paramInvitation.h())).a("Inviter", paramInvitation.f()).a("Participants", paramInvitation.l()).a("Variant", Integer.valueOf(paramInvitation.i())).a("AvailableAutoMatchSlots", Integer.valueOf(paramInvitation.j())).toString();
  }

  public int b()
  {
    return this.a;
  }

  public Invitation c()
  {
    return this;
  }

  public Game d()
  {
    return this.b;
  }

  public int describeContents()
  {
    return 0;
  }

  public String e()
  {
    return this.c;
  }

  public boolean equals(Object paramObject)
  {
    return a(this, paramObject);
  }

  public Participant f()
  {
    return this.f;
  }

  public long g()
  {
    return this.d;
  }

  public int h()
  {
    return this.e;
  }

  public int hashCode()
  {
    return a(this);
  }

  public int i()
  {
    return this.h;
  }

  public int j()
  {
    return this.i;
  }

  public ArrayList l()
  {
    return new ArrayList(this.g);
  }

  public String toString()
  {
    return b(this);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (!D())
      b.a(this, paramParcel, paramInt);
    while (true)
    {
      return;
      this.b.writeToParcel(paramParcel, paramInt);
      paramParcel.writeString(this.c);
      paramParcel.writeLong(this.d);
      paramParcel.writeInt(this.e);
      this.f.writeToParcel(paramParcel, paramInt);
      int j = this.g.size();
      paramParcel.writeInt(j);
      for (int k = 0; k < j; k++)
        ((ParticipantEntity)this.g.get(k)).writeToParcel(paramParcel, paramInt);
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.multiplayer.InvitationEntity
 * JD-Core Version:    0.6.0
 */