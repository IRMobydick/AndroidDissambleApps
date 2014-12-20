package com.google.android.gms.games.multiplayer.turnbased;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import com.google.android.gms.internal.kt;
import com.google.android.gms.internal.kv;
import java.util.ArrayList;

public final class TurnBasedMatchEntity
  implements SafeParcelable, TurnBasedMatch
{
  public static final b b = new b();
  private final int c;
  private final GameEntity d;
  private final String e;
  private final String f;
  private final long g;
  private final String h;
  private final long i;
  private final String j;
  private final int k;
  private final int l;
  private final int m;
  private final byte[] n;
  private final ArrayList o;
  private final String p;
  private final byte[] q;
  private final int r;
  private final Bundle s;
  private final int t;
  private final boolean u;
  private final String v;
  private final String w;

  TurnBasedMatchEntity(int paramInt1, GameEntity paramGameEntity, String paramString1, String paramString2, long paramLong1, String paramString3, long paramLong2, String paramString4, int paramInt2, int paramInt3, int paramInt4, byte[] paramArrayOfByte1, ArrayList paramArrayList, String paramString5, byte[] paramArrayOfByte2, int paramInt5, Bundle paramBundle, int paramInt6, boolean paramBoolean, String paramString6, String paramString7)
  {
    this.c = paramInt1;
    this.d = paramGameEntity;
    this.e = paramString1;
    this.f = paramString2;
    this.g = paramLong1;
    this.h = paramString3;
    this.i = paramLong2;
    this.j = paramString4;
    this.k = paramInt2;
    this.t = paramInt6;
    this.l = paramInt3;
    this.m = paramInt4;
    this.n = paramArrayOfByte1;
    this.o = paramArrayList;
    this.p = paramString5;
    this.q = paramArrayOfByte2;
    this.r = paramInt5;
    this.s = paramBundle;
    this.u = paramBoolean;
    this.v = paramString6;
    this.w = paramString7;
  }

  public TurnBasedMatchEntity(TurnBasedMatch paramTurnBasedMatch)
  {
    this.c = 2;
    this.d = new GameEntity(paramTurnBasedMatch.i_());
    this.e = paramTurnBasedMatch.c();
    this.f = paramTurnBasedMatch.d();
    this.g = paramTurnBasedMatch.e();
    this.h = paramTurnBasedMatch.j();
    this.i = paramTurnBasedMatch.k();
    this.j = paramTurnBasedMatch.m();
    this.k = paramTurnBasedMatch.f();
    this.t = paramTurnBasedMatch.g();
    this.l = paramTurnBasedMatch.i();
    this.m = paramTurnBasedMatch.o();
    this.p = paramTurnBasedMatch.p();
    this.r = paramTurnBasedMatch.r();
    this.s = paramTurnBasedMatch.s();
    this.u = paramTurnBasedMatch.u();
    this.v = paramTurnBasedMatch.h();
    this.w = paramTurnBasedMatch.v();
    byte[] arrayOfByte1 = paramTurnBasedMatch.n();
    byte[] arrayOfByte2;
    if (arrayOfByte1 == null)
    {
      this.n = null;
      arrayOfByte2 = paramTurnBasedMatch.q();
      if (arrayOfByte2 != null)
        break label314;
      this.q = null;
    }
    while (true)
    {
      ArrayList localArrayList = paramTurnBasedMatch.l();
      int i1 = localArrayList.size();
      this.o = new ArrayList(i1);
      for (int i2 = 0; i2 < i1; i2++)
        this.o.add((ParticipantEntity)(ParticipantEntity)((Participant)localArrayList.get(i2)).a());
      this.n = new byte[arrayOfByte1.length];
      System.arraycopy(arrayOfByte1, 0, this.n, 0, arrayOfByte1.length);
      break;
      label314: this.q = new byte[arrayOfByte2.length];
      System.arraycopy(arrayOfByte2, 0, this.q, 0, arrayOfByte2.length);
    }
  }

  static int a(TurnBasedMatch paramTurnBasedMatch)
  {
    Object[] arrayOfObject = new Object[18];
    arrayOfObject[0] = paramTurnBasedMatch.i_();
    arrayOfObject[1] = paramTurnBasedMatch.c();
    arrayOfObject[2] = paramTurnBasedMatch.d();
    arrayOfObject[3] = Long.valueOf(paramTurnBasedMatch.e());
    arrayOfObject[4] = paramTurnBasedMatch.j();
    arrayOfObject[5] = Long.valueOf(paramTurnBasedMatch.k());
    arrayOfObject[6] = paramTurnBasedMatch.m();
    arrayOfObject[7] = Integer.valueOf(paramTurnBasedMatch.f());
    arrayOfObject[8] = Integer.valueOf(paramTurnBasedMatch.g());
    arrayOfObject[9] = paramTurnBasedMatch.h();
    arrayOfObject[10] = Integer.valueOf(paramTurnBasedMatch.i());
    arrayOfObject[11] = Integer.valueOf(paramTurnBasedMatch.o());
    arrayOfObject[12] = paramTurnBasedMatch.l();
    arrayOfObject[13] = paramTurnBasedMatch.p();
    arrayOfObject[14] = Integer.valueOf(paramTurnBasedMatch.r());
    arrayOfObject[15] = paramTurnBasedMatch.s();
    arrayOfObject[16] = Integer.valueOf(paramTurnBasedMatch.t());
    arrayOfObject[17] = Boolean.valueOf(paramTurnBasedMatch.u());
    return kt.a(arrayOfObject);
  }

  static boolean a(TurnBasedMatch paramTurnBasedMatch, Object paramObject)
  {
    int i1 = 1;
    if (!(paramObject instanceof TurnBasedMatch))
      i1 = 0;
    while (true)
    {
      return i1;
      if (paramTurnBasedMatch == paramObject)
        continue;
      TurnBasedMatch localTurnBasedMatch = (TurnBasedMatch)paramObject;
      if ((kt.a(localTurnBasedMatch.i_(), paramTurnBasedMatch.i_())) && (kt.a(localTurnBasedMatch.c(), paramTurnBasedMatch.c())) && (kt.a(localTurnBasedMatch.d(), paramTurnBasedMatch.d())) && (kt.a(Long.valueOf(localTurnBasedMatch.e()), Long.valueOf(paramTurnBasedMatch.e()))) && (kt.a(localTurnBasedMatch.j(), paramTurnBasedMatch.j())) && (kt.a(Long.valueOf(localTurnBasedMatch.k()), Long.valueOf(paramTurnBasedMatch.k()))) && (kt.a(localTurnBasedMatch.m(), paramTurnBasedMatch.m())) && (kt.a(Integer.valueOf(localTurnBasedMatch.f()), Integer.valueOf(paramTurnBasedMatch.f()))) && (kt.a(Integer.valueOf(localTurnBasedMatch.g()), Integer.valueOf(paramTurnBasedMatch.g()))) && (kt.a(localTurnBasedMatch.h(), paramTurnBasedMatch.h())) && (kt.a(Integer.valueOf(localTurnBasedMatch.i()), Integer.valueOf(paramTurnBasedMatch.i()))) && (kt.a(Integer.valueOf(localTurnBasedMatch.o()), Integer.valueOf(paramTurnBasedMatch.o()))) && (kt.a(localTurnBasedMatch.l(), paramTurnBasedMatch.l())) && (kt.a(localTurnBasedMatch.p(), paramTurnBasedMatch.p())) && (kt.a(Integer.valueOf(localTurnBasedMatch.r()), Integer.valueOf(paramTurnBasedMatch.r()))) && (kt.a(localTurnBasedMatch.s(), paramTurnBasedMatch.s())) && (kt.a(Integer.valueOf(localTurnBasedMatch.t()), Integer.valueOf(paramTurnBasedMatch.t()))) && (kt.a(Boolean.valueOf(localTurnBasedMatch.u()), Boolean.valueOf(paramTurnBasedMatch.u()))))
        continue;
      i1 = 0;
    }
  }

  static String b(TurnBasedMatch paramTurnBasedMatch)
  {
    return kt.a(paramTurnBasedMatch).a("Game", paramTurnBasedMatch.i_()).a("MatchId", paramTurnBasedMatch.c()).a("CreatorId", paramTurnBasedMatch.d()).a("CreationTimestamp", Long.valueOf(paramTurnBasedMatch.e())).a("LastUpdaterId", paramTurnBasedMatch.j()).a("LastUpdatedTimestamp", Long.valueOf(paramTurnBasedMatch.k())).a("PendingParticipantId", paramTurnBasedMatch.m()).a("MatchStatus", Integer.valueOf(paramTurnBasedMatch.f())).a("TurnStatus", Integer.valueOf(paramTurnBasedMatch.g())).a("Description", paramTurnBasedMatch.h()).a("Variant", Integer.valueOf(paramTurnBasedMatch.i())).a("Data", paramTurnBasedMatch.n()).a("Version", Integer.valueOf(paramTurnBasedMatch.o())).a("Participants", paramTurnBasedMatch.l()).a("RematchId", paramTurnBasedMatch.p()).a("PreviousData", paramTurnBasedMatch.q()).a("MatchNumber", Integer.valueOf(paramTurnBasedMatch.r())).a("AutoMatchCriteria", paramTurnBasedMatch.s()).a("AvailableAutoMatchSlots", Integer.valueOf(paramTurnBasedMatch.t())).a("LocallyModified", Boolean.valueOf(paramTurnBasedMatch.u())).a("DescriptionParticipantId", paramTurnBasedMatch.v()).toString();
  }

  public String c()
  {
    return this.e;
  }

  public String d()
  {
    return this.f;
  }

  public int describeContents()
  {
    return 0;
  }

  public long e()
  {
    return this.g;
  }

  public boolean equals(Object paramObject)
  {
    return a(this, paramObject);
  }

  public int f()
  {
    return this.k;
  }

  public int g()
  {
    return this.t;
  }

  public String h()
  {
    return this.v;
  }

  public int hashCode()
  {
    return a(this);
  }

  public int i()
  {
    return this.l;
  }

  public Game i_()
  {
    return this.d;
  }

  public String j()
  {
    return this.h;
  }

  public long k()
  {
    return this.i;
  }

  public ArrayList l()
  {
    return new ArrayList(this.o);
  }

  public String m()
  {
    return this.j;
  }

  public byte[] n()
  {
    return this.n;
  }

  public int o()
  {
    return this.m;
  }

  public String p()
  {
    return this.p;
  }

  public byte[] q()
  {
    return this.q;
  }

  public int r()
  {
    return this.r;
  }

  public Bundle s()
  {
    return this.s;
  }

  public int t()
  {
    if (this.s == null);
    for (int i1 = 0; ; i1 = this.s.getInt("max_automatch_players"))
      return i1;
  }

  public String toString()
  {
    return b(this);
  }

  public boolean u()
  {
    return this.u;
  }

  public String v()
  {
    return this.w;
  }

  public int w()
  {
    return this.c;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    b.a(this, paramParcel, paramInt);
  }

  public TurnBasedMatch x()
  {
    return this;
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchEntity
 * JD-Core Version:    0.6.0
 */