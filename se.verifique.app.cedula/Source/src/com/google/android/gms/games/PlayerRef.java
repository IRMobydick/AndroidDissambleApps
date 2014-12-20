package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.f;
import com.google.android.gms.games.internal.player.MostRecentGameInfo;
import com.google.android.gms.games.internal.player.MostRecentGameInfoRef;
import com.google.android.gms.games.internal.player.b;

public final class PlayerRef extends f
  implements Player
{
  private final b c;
  private final PlayerLevelInfo d;
  private final MostRecentGameInfoRef e;

  public PlayerRef(DataHolder paramDataHolder, int paramInt)
  {
    this(paramDataHolder, paramInt, null);
  }

  public PlayerRef(DataHolder paramDataHolder, int paramInt, String paramString)
  {
    super(paramDataHolder, paramInt);
    this.c = new b(paramString);
    this.e = new MostRecentGameInfoRef(paramDataHolder, paramInt, this.c);
    int j;
    PlayerLevel localPlayerLevel1;
    if (p())
    {
      int i = c(this.c.k);
      j = c(this.c.n);
      localPlayerLevel1 = new PlayerLevel(i, b(this.c.l), b(this.c.m));
      if (i == j)
        break label187;
    }
    label187: for (PlayerLevel localPlayerLevel2 = new PlayerLevel(j, b(this.c.m), b(this.c.o)); ; localPlayerLevel2 = localPlayerLevel1)
      for (this.d = new PlayerLevelInfo(b(this.c.j), b(this.c.p), localPlayerLevel1, localPlayerLevel2); ; this.d = null)
        return;
  }

  private boolean p()
  {
    int i = 0;
    if (i(this.c.j));
    while (true)
    {
      return i;
      if (b(this.c.j) == -1L)
        continue;
      i = 1;
    }
  }

  public String b_()
  {
    return e(this.c.a);
  }

  public String c()
  {
    return e(this.c.b);
  }

  public Uri d()
  {
    return h(this.c.c);
  }

  public int describeContents()
  {
    return 0;
  }

  public String e()
  {
    return e(this.c.d);
  }

  public boolean equals(Object paramObject)
  {
    return PlayerEntity.a(this, paramObject);
  }

  public Uri f()
  {
    return h(this.c.e);
  }

  public String g()
  {
    return e(this.c.f);
  }

  public long h()
  {
    return b(this.c.g);
  }

  public int hashCode()
  {
    return PlayerEntity.a(this);
  }

  public long i()
  {
    long l;
    if ((!a(this.c.i)) || (i(this.c.i)))
      l = -1L;
    while (true)
    {
      return l;
      l = b(this.c.i);
    }
  }

  public int j()
  {
    return c(this.c.h);
  }

  public boolean k()
  {
    return d(this.c.r);
  }

  public String l()
  {
    return e(this.c.q);
  }

  public PlayerLevelInfo m()
  {
    return this.d;
  }

  public MostRecentGameInfo n()
  {
    if (i(this.c.s));
    for (MostRecentGameInfoRef localMostRecentGameInfoRef = null; ; localMostRecentGameInfoRef = this.e)
      return localMostRecentGameInfoRef;
  }

  public Player o()
  {
    return new PlayerEntity(this);
  }

  public String toString()
  {
    return PlayerEntity.b(this);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ((PlayerEntity)o()).writeToParcel(paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.PlayerRef
 * JD-Core Version:    0.6.0
 */