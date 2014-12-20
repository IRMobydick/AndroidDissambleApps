package com.google.android.gms.games;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.kt;
import com.google.android.gms.internal.kx;

public final class PlayerLevelInfo
  implements SafeParcelable
{
  public static final f a = new f();
  private final int b;
  private final long c;
  private final long d;
  private final PlayerLevel e;
  private final PlayerLevel f;

  PlayerLevelInfo(int paramInt, long paramLong1, long paramLong2, PlayerLevel paramPlayerLevel1, PlayerLevel paramPlayerLevel2)
  {
    if (paramLong1 != -1L);
    for (boolean bool = true; ; bool = false)
    {
      kx.a(bool);
      kx.a(paramPlayerLevel1);
      kx.a(paramPlayerLevel2);
      this.b = paramInt;
      this.c = paramLong1;
      this.d = paramLong2;
      this.e = paramPlayerLevel1;
      this.f = paramPlayerLevel2;
      return;
    }
  }

  public PlayerLevelInfo(long paramLong1, long paramLong2, PlayerLevel paramPlayerLevel1, PlayerLevel paramPlayerLevel2)
  {
    this(1, paramLong1, paramLong2, paramPlayerLevel1, paramPlayerLevel2);
  }

  public int a()
  {
    return this.b;
  }

  public long b()
  {
    return this.c;
  }

  public long c()
  {
    return this.d;
  }

  public PlayerLevel d()
  {
    return this.e;
  }

  public int describeContents()
  {
    return 0;
  }

  public PlayerLevel e()
  {
    return this.f;
  }

  public boolean equals(Object paramObject)
  {
    int i = 1;
    if (!(paramObject instanceof PlayerLevelInfo))
      i = 0;
    while (true)
    {
      return i;
      if (paramObject == this)
        continue;
      PlayerLevelInfo localPlayerLevelInfo = (PlayerLevelInfo)paramObject;
      if ((kt.a(Long.valueOf(this.c), Long.valueOf(localPlayerLevelInfo.c))) && (kt.a(Long.valueOf(this.d), Long.valueOf(localPlayerLevelInfo.d))) && (kt.a(this.e, localPlayerLevelInfo.e)) && (kt.a(this.f, localPlayerLevelInfo.f)))
        continue;
      i = 0;
    }
  }

  public int hashCode()
  {
    Object[] arrayOfObject = new Object[4];
    arrayOfObject[0] = Long.valueOf(this.c);
    arrayOfObject[1] = Long.valueOf(this.d);
    arrayOfObject[2] = this.e;
    arrayOfObject[3] = this.f;
    return kt.a(arrayOfObject);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    f.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.PlayerLevelInfo
 * JD-Core Version:    0.6.0
 */