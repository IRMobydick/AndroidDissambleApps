package com.google.android.gms.games.request;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.internal.kt;
import com.google.android.gms.internal.kv;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class GameRequestEntity
  implements SafeParcelable, GameRequest
{
  public static final a a = new a();
  private final int b;
  private final GameEntity c;
  private final PlayerEntity d;
  private final byte[] e;
  private final String f;
  private final ArrayList g;
  private final int h;
  private final long i;
  private final long j;
  private final Bundle k;
  private final int l;

  GameRequestEntity(int paramInt1, GameEntity paramGameEntity, PlayerEntity paramPlayerEntity, byte[] paramArrayOfByte, String paramString, ArrayList paramArrayList, int paramInt2, long paramLong1, long paramLong2, Bundle paramBundle, int paramInt3)
  {
    this.b = paramInt1;
    this.c = paramGameEntity;
    this.d = paramPlayerEntity;
    this.e = paramArrayOfByte;
    this.f = paramString;
    this.g = paramArrayList;
    this.h = paramInt2;
    this.i = paramLong1;
    this.j = paramLong2;
    this.k = paramBundle;
    this.l = paramInt3;
  }

  public GameRequestEntity(GameRequest paramGameRequest)
  {
    this.b = 2;
    this.c = new GameEntity(paramGameRequest.e());
    this.d = new PlayerEntity(paramGameRequest.f());
    this.f = paramGameRequest.d();
    this.h = paramGameRequest.i();
    this.i = paramGameRequest.j();
    this.j = paramGameRequest.k();
    this.l = paramGameRequest.l();
    byte[] arrayOfByte = paramGameRequest.h();
    if (arrayOfByte == null)
      this.e = null;
    while (true)
    {
      List localList = paramGameRequest.n();
      int m = localList.size();
      this.g = new ArrayList(m);
      this.k = new Bundle();
      for (int n = 0; n < m; n++)
      {
        Player localPlayer = (Player)((Player)localList.get(n)).a();
        String str = localPlayer.b_();
        this.g.add((PlayerEntity)localPlayer);
        this.k.putInt(str, paramGameRequest.a_(str));
      }
      this.e = new byte[arrayOfByte.length];
      System.arraycopy(arrayOfByte, 0, this.e, 0, arrayOfByte.length);
    }
  }

  static int a(GameRequest paramGameRequest)
  {
    Object[] arrayOfObject = new Object[8];
    arrayOfObject[0] = paramGameRequest.e();
    arrayOfObject[1] = paramGameRequest.n();
    arrayOfObject[2] = paramGameRequest.d();
    arrayOfObject[3] = paramGameRequest.f();
    arrayOfObject[4] = c(paramGameRequest);
    arrayOfObject[5] = Integer.valueOf(paramGameRequest.i());
    arrayOfObject[6] = Long.valueOf(paramGameRequest.j());
    arrayOfObject[7] = Long.valueOf(paramGameRequest.k());
    return kt.a(arrayOfObject);
  }

  static boolean a(GameRequest paramGameRequest, Object paramObject)
  {
    int m = 1;
    if (!(paramObject instanceof GameRequest))
      m = 0;
    while (true)
    {
      return m;
      if (paramGameRequest == paramObject)
        continue;
      GameRequest localGameRequest = (GameRequest)paramObject;
      if ((kt.a(localGameRequest.e(), paramGameRequest.e())) && (kt.a(localGameRequest.n(), paramGameRequest.n())) && (kt.a(localGameRequest.d(), paramGameRequest.d())) && (kt.a(localGameRequest.f(), paramGameRequest.f())) && (Arrays.equals(c(localGameRequest), c(paramGameRequest))) && (kt.a(Integer.valueOf(localGameRequest.i()), Integer.valueOf(paramGameRequest.i()))) && (kt.a(Long.valueOf(localGameRequest.j()), Long.valueOf(paramGameRequest.j()))) && (kt.a(Long.valueOf(localGameRequest.k()), Long.valueOf(paramGameRequest.k()))))
        continue;
      m = 0;
    }
  }

  static String b(GameRequest paramGameRequest)
  {
    return kt.a(paramGameRequest).a("Game", paramGameRequest.e()).a("Sender", paramGameRequest.f()).a("Recipients", paramGameRequest.n()).a("Data", paramGameRequest.h()).a("RequestId", paramGameRequest.d()).a("Type", Integer.valueOf(paramGameRequest.i())).a("CreationTimestamp", Long.valueOf(paramGameRequest.j())).a("ExpirationTimestamp", Long.valueOf(paramGameRequest.k())).toString();
  }

  private static int[] c(GameRequest paramGameRequest)
  {
    List localList = paramGameRequest.n();
    int m = localList.size();
    int[] arrayOfInt = new int[m];
    for (int n = 0; n < m; n++)
      arrayOfInt[n] = paramGameRequest.a_(((Player)localList.get(n)).b_());
    return arrayOfInt;
  }

  public int a_(String paramString)
  {
    return this.k.getInt(paramString, 0);
  }

  public int b()
  {
    return this.b;
  }

  public Bundle c()
  {
    return this.k;
  }

  public String d()
  {
    return this.f;
  }

  public int describeContents()
  {
    return 0;
  }

  public Game e()
  {
    return this.c;
  }

  public boolean equals(Object paramObject)
  {
    return a(this, paramObject);
  }

  public Player f()
  {
    return this.d;
  }

  public GameRequest g()
  {
    return this;
  }

  public byte[] h()
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

  public long j()
  {
    return this.i;
  }

  public long k()
  {
    return this.j;
  }

  public int l()
  {
    return this.l;
  }

  public List n()
  {
    return new ArrayList(this.g);
  }

  public String toString()
  {
    return b(this);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    a.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.request.GameRequestEntity
 * JD-Core Version:    0.6.0
 */