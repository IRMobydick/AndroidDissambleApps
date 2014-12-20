package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.games.internal.player.MostRecentGameInfo;
import com.google.android.gms.games.internal.player.MostRecentGameInfoEntity;
import com.google.android.gms.internal.jn;
import com.google.android.gms.internal.kt;
import com.google.android.gms.internal.kv;

public final class PlayerEntity extends GamesDowngradeableSafeParcel
  implements Player
{
  public static final Parcelable.Creator CREATOR = new c();
  private final int a;
  private final String b;
  private final String c;
  private final Uri d;
  private final Uri e;
  private final long f;
  private final int g;
  private final long h;
  private final String i;
  private final String j;
  private final String k;
  private final MostRecentGameInfoEntity l;
  private final PlayerLevelInfo m;
  private final boolean n;

  PlayerEntity(int paramInt1, String paramString1, String paramString2, Uri paramUri1, Uri paramUri2, long paramLong1, int paramInt2, long paramLong2, String paramString3, String paramString4, String paramString5, MostRecentGameInfoEntity paramMostRecentGameInfoEntity, PlayerLevelInfo paramPlayerLevelInfo, boolean paramBoolean)
  {
    this.a = paramInt1;
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramUri1;
    this.i = paramString3;
    this.e = paramUri2;
    this.j = paramString4;
    this.f = paramLong1;
    this.g = paramInt2;
    this.h = paramLong2;
    this.k = paramString5;
    this.n = paramBoolean;
    this.l = paramMostRecentGameInfoEntity;
    this.m = paramPlayerLevelInfo;
  }

  public PlayerEntity(Player paramPlayer)
  {
    this.a = 10;
    this.b = paramPlayer.b_();
    this.c = paramPlayer.c();
    this.d = paramPlayer.d();
    this.i = paramPlayer.e();
    this.e = paramPlayer.f();
    this.j = paramPlayer.g();
    this.f = paramPlayer.h();
    this.g = paramPlayer.j();
    this.h = paramPlayer.i();
    this.k = paramPlayer.l();
    this.n = paramPlayer.k();
    MostRecentGameInfo localMostRecentGameInfo = paramPlayer.n();
    MostRecentGameInfoEntity localMostRecentGameInfoEntity;
    if (localMostRecentGameInfo == null)
    {
      localMostRecentGameInfoEntity = null;
      this.l = localMostRecentGameInfoEntity;
      this.m = paramPlayer.m();
      jn.a(this.b);
      jn.a(this.c);
      if (this.f <= 0L)
        break label192;
    }
    label192: for (boolean bool = true; ; bool = false)
    {
      jn.a(bool);
      return;
      localMostRecentGameInfoEntity = new MostRecentGameInfoEntity(localMostRecentGameInfo);
      break;
    }
  }

  static int a(Player paramPlayer)
  {
    Object[] arrayOfObject = new Object[7];
    arrayOfObject[0] = paramPlayer.b_();
    arrayOfObject[1] = paramPlayer.c();
    arrayOfObject[2] = paramPlayer.d();
    arrayOfObject[3] = paramPlayer.f();
    arrayOfObject[4] = Long.valueOf(paramPlayer.h());
    arrayOfObject[5] = paramPlayer.l();
    arrayOfObject[6] = paramPlayer.m();
    return kt.a(arrayOfObject);
  }

  static boolean a(Player paramPlayer, Object paramObject)
  {
    int i1 = 1;
    if (!(paramObject instanceof Player))
      i1 = 0;
    while (true)
    {
      return i1;
      if (paramPlayer == paramObject)
        continue;
      Player localPlayer = (Player)paramObject;
      if ((kt.a(localPlayer.b_(), paramPlayer.b_())) && (kt.a(localPlayer.c(), paramPlayer.c())) && (kt.a(localPlayer.d(), paramPlayer.d())) && (kt.a(localPlayer.f(), paramPlayer.f())) && (kt.a(Long.valueOf(localPlayer.h()), Long.valueOf(paramPlayer.h()))) && (kt.a(localPlayer.l(), paramPlayer.l())) && (kt.a(localPlayer.m(), paramPlayer.m())))
        continue;
      i1 = 0;
    }
  }

  static String b(Player paramPlayer)
  {
    return kt.a(paramPlayer).a("PlayerId", paramPlayer.b_()).a("DisplayName", paramPlayer.c()).a("IconImageUri", paramPlayer.d()).a("IconImageUrl", paramPlayer.e()).a("HiResImageUri", paramPlayer.f()).a("HiResImageUrl", paramPlayer.g()).a("RetrievedTimestamp", Long.valueOf(paramPlayer.h())).a("Title", paramPlayer.l()).a("LevelInfo", paramPlayer.m()).toString();
  }

  public String b_()
  {
    return this.b;
  }

  public String c()
  {
    return this.c;
  }

  public Uri d()
  {
    return this.d;
  }

  public int describeContents()
  {
    return 0;
  }

  public String e()
  {
    return this.i;
  }

  public boolean equals(Object paramObject)
  {
    return a(this, paramObject);
  }

  public Uri f()
  {
    return this.e;
  }

  public String g()
  {
    return this.j;
  }

  public long h()
  {
    return this.f;
  }

  public int hashCode()
  {
    return a(this);
  }

  public long i()
  {
    return this.h;
  }

  public int j()
  {
    return this.g;
  }

  public boolean k()
  {
    return this.n;
  }

  public String l()
  {
    return this.k;
  }

  public PlayerLevelInfo m()
  {
    return this.m;
  }

  public MostRecentGameInfo n()
  {
    return this.l;
  }

  public int o()
  {
    return this.a;
  }

  public Player p()
  {
    return this;
  }

  public String toString()
  {
    return b(this);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    String str1 = null;
    if (!D())
    {
      d.a(this, paramParcel, paramInt);
      return;
    }
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    String str2;
    if (this.d == null)
    {
      str2 = null;
      label42: paramParcel.writeString(str2);
      if (this.e != null)
        break label83;
    }
    while (true)
    {
      paramParcel.writeString(str1);
      paramParcel.writeLong(this.f);
      break;
      str2 = this.d.toString();
      break label42;
      label83: str1 = this.e.toString();
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.PlayerEntity
 * JD-Core Version:    0.6.0
 */