package com.google.android.gms.games.internal.game;

import android.os.Parcel;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.SnapshotMetadataEntity;
import com.google.android.gms.internal.kt;
import com.google.android.gms.internal.kv;
import java.util.ArrayList;

public final class ExtendedGameEntity extends GamesDowngradeableSafeParcel
  implements ExtendedGame
{
  public static final b a = new a();
  private final int b;
  private final GameEntity c;
  private final int d;
  private final boolean e;
  private final int f;
  private final long g;
  private final long h;
  private final String i;
  private final long j;
  private final String k;
  private final ArrayList l;
  private final SnapshotMetadataEntity m;

  ExtendedGameEntity(int paramInt1, GameEntity paramGameEntity, int paramInt2, boolean paramBoolean, int paramInt3, long paramLong1, long paramLong2, String paramString1, long paramLong3, String paramString2, ArrayList paramArrayList, SnapshotMetadataEntity paramSnapshotMetadataEntity)
  {
    this.b = paramInt1;
    this.c = paramGameEntity;
    this.d = paramInt2;
    this.e = paramBoolean;
    this.f = paramInt3;
    this.g = paramLong1;
    this.h = paramLong2;
    this.i = paramString1;
    this.j = paramLong3;
    this.k = paramString2;
    this.l = paramArrayList;
    this.m = paramSnapshotMetadataEntity;
  }

  public ExtendedGameEntity(ExtendedGame paramExtendedGame)
  {
    this.b = 2;
    Game localGame = paramExtendedGame.d_();
    GameEntity localGameEntity;
    SnapshotMetadata localSnapshotMetadata;
    if (localGame == null)
    {
      localGameEntity = null;
      this.c = localGameEntity;
      this.d = paramExtendedGame.d();
      this.e = paramExtendedGame.e();
      this.f = paramExtendedGame.f();
      this.g = paramExtendedGame.g();
      this.h = paramExtendedGame.h();
      this.i = paramExtendedGame.i();
      this.j = paramExtendedGame.j();
      this.k = paramExtendedGame.k();
      localSnapshotMetadata = paramExtendedGame.l();
      if (localSnapshotMetadata != null)
        break label212;
    }
    while (true)
    {
      this.m = localSnapshotMetadataEntity;
      ArrayList localArrayList = paramExtendedGame.c();
      int n = localArrayList.size();
      this.l = new ArrayList(n);
      for (int i1 = 0; i1 < n; i1++)
        this.l.add((GameBadgeEntity)((GameBadge)localArrayList.get(i1)).a());
      localGameEntity = new GameEntity(localGame);
      break;
      label212: localSnapshotMetadataEntity = new SnapshotMetadataEntity(localSnapshotMetadata);
    }
  }

  static int a(ExtendedGame paramExtendedGame)
  {
    Object[] arrayOfObject = new Object[9];
    arrayOfObject[0] = paramExtendedGame.d_();
    arrayOfObject[1] = Integer.valueOf(paramExtendedGame.d());
    arrayOfObject[2] = Boolean.valueOf(paramExtendedGame.e());
    arrayOfObject[3] = Integer.valueOf(paramExtendedGame.f());
    arrayOfObject[4] = Long.valueOf(paramExtendedGame.g());
    arrayOfObject[5] = Long.valueOf(paramExtendedGame.h());
    arrayOfObject[6] = paramExtendedGame.i();
    arrayOfObject[7] = Long.valueOf(paramExtendedGame.j());
    arrayOfObject[8] = paramExtendedGame.k();
    return kt.a(arrayOfObject);
  }

  static boolean a(ExtendedGame paramExtendedGame, Object paramObject)
  {
    int n = 1;
    if (!(paramObject instanceof ExtendedGame))
      n = 0;
    while (true)
    {
      return n;
      if (paramExtendedGame == paramObject)
        continue;
      ExtendedGame localExtendedGame = (ExtendedGame)paramObject;
      if ((kt.a(localExtendedGame.d_(), paramExtendedGame.d_())) && (kt.a(Integer.valueOf(localExtendedGame.d()), Integer.valueOf(paramExtendedGame.d()))) && (kt.a(Boolean.valueOf(localExtendedGame.e()), Boolean.valueOf(paramExtendedGame.e()))) && (kt.a(Integer.valueOf(localExtendedGame.f()), Integer.valueOf(paramExtendedGame.f()))) && (kt.a(Long.valueOf(localExtendedGame.g()), Long.valueOf(paramExtendedGame.g()))) && (kt.a(Long.valueOf(localExtendedGame.h()), Long.valueOf(paramExtendedGame.h()))) && (kt.a(localExtendedGame.i(), paramExtendedGame.i())) && (kt.a(Long.valueOf(localExtendedGame.j()), Long.valueOf(paramExtendedGame.j()))) && (kt.a(localExtendedGame.k(), paramExtendedGame.k())))
        continue;
      n = 0;
    }
  }

  static String b(ExtendedGame paramExtendedGame)
  {
    return kt.a(paramExtendedGame).a("Game", paramExtendedGame.d_()).a("Availability", Integer.valueOf(paramExtendedGame.d())).a("Owned", Boolean.valueOf(paramExtendedGame.e())).a("AchievementUnlockedCount", Integer.valueOf(paramExtendedGame.f())).a("LastPlayedServerTimestamp", Long.valueOf(paramExtendedGame.g())).a("PriceMicros", Long.valueOf(paramExtendedGame.h())).a("FormattedPrice", paramExtendedGame.i()).a("FullPriceMicros", Long.valueOf(paramExtendedGame.j())).a("FormattedFullPrice", paramExtendedGame.k()).a("Snapshot", paramExtendedGame.l()).toString();
  }

  public ArrayList c()
  {
    return new ArrayList(this.l);
  }

  public int d()
  {
    return this.d;
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean e()
  {
    return this.e;
  }

  public boolean equals(Object paramObject)
  {
    return a(this, paramObject);
  }

  public int f()
  {
    return this.f;
  }

  public long g()
  {
    return this.g;
  }

  public long h()
  {
    return this.h;
  }

  public int hashCode()
  {
    return a(this);
  }

  public String i()
  {
    return this.i;
  }

  public long j()
  {
    return this.j;
  }

  public String k()
  {
    return this.k;
  }

  public SnapshotMetadata l()
  {
    return this.m;
  }

  public int m()
  {
    return this.b;
  }

  public GameEntity n()
  {
    return this.c;
  }

  public ExtendedGame o()
  {
    return this;
  }

  public String toString()
  {
    return b(this);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int n = 0;
    if (!D())
    {
      b.a(this, paramParcel, paramInt);
      return;
    }
    this.c.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.d);
    if (this.e);
    for (int i1 = 1; ; i1 = 0)
    {
      paramParcel.writeInt(i1);
      paramParcel.writeInt(this.f);
      paramParcel.writeLong(this.g);
      paramParcel.writeLong(this.h);
      paramParcel.writeString(this.i);
      paramParcel.writeLong(this.j);
      paramParcel.writeString(this.k);
      int i2 = this.l.size();
      paramParcel.writeInt(i2);
      while (n < i2)
      {
        ((GameBadgeEntity)this.l.get(n)).writeToParcel(paramParcel, paramInt);
        n++;
      }
      break;
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.internal.game.ExtendedGameEntity
 * JD-Core Version:    0.6.0
 */