package com.google.android.gms.games;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.kt;
import com.google.android.gms.internal.kv;
import com.google.android.gms.internal.kx;

public final class PlayerLevel
  implements SafeParcelable
{
  public static final e a = new e();
  private final int b;
  private final int c;
  private final long d;
  private final long e;

  PlayerLevel(int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    boolean bool2;
    if (paramLong1 >= 0L)
    {
      bool2 = bool1;
      kx.a(bool2, "Min XP must be positive!");
      if (paramLong2 <= paramLong1)
        break label66;
    }
    while (true)
    {
      kx.a(bool1, "Max XP must be more than min XP!");
      this.b = paramInt1;
      this.c = paramInt2;
      this.d = paramLong1;
      this.e = paramLong2;
      return;
      bool2 = false;
      break;
      label66: bool1 = false;
    }
  }

  public PlayerLevel(int paramInt, long paramLong1, long paramLong2)
  {
    this(1, paramInt, paramLong1, paramLong2);
  }

  public int a()
  {
    return this.b;
  }

  public int b()
  {
    return this.c;
  }

  public long c()
  {
    return this.d;
  }

  public long d()
  {
    return this.e;
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    int i = 1;
    if (!(paramObject instanceof PlayerLevel))
      i = 0;
    while (true)
    {
      return i;
      if (this == paramObject)
        continue;
      PlayerLevel localPlayerLevel = (PlayerLevel)paramObject;
      if ((kt.a(Integer.valueOf(localPlayerLevel.b()), Integer.valueOf(b()))) && (kt.a(Long.valueOf(localPlayerLevel.c()), Long.valueOf(c()))) && (kt.a(Long.valueOf(localPlayerLevel.d()), Long.valueOf(d()))))
        continue;
      i = 0;
    }
  }

  public int hashCode()
  {
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = Integer.valueOf(this.c);
    arrayOfObject[1] = Long.valueOf(this.d);
    arrayOfObject[2] = Long.valueOf(this.e);
    return kt.a(arrayOfObject);
  }

  public String toString()
  {
    return kt.a(this).a("LevelNumber", Integer.valueOf(b())).a("MinXp", Long.valueOf(c())).a("MaxXp", Long.valueOf(d())).toString();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    e.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.PlayerLevel
 * JD-Core Version:    0.6.0
 */