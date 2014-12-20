package com.google.android.gms.games.internal.request;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.request.GameRequest;
import com.google.android.gms.games.request.GameRequestEntity;
import com.google.android.gms.internal.jn;
import com.google.android.gms.internal.kt;
import java.util.ArrayList;

public final class GameRequestCluster
  implements SafeParcelable, GameRequest
{
  public static final a a = new a();
  private final int b;
  private final ArrayList c;

  GameRequestCluster(int paramInt, ArrayList paramArrayList)
  {
    this.b = paramInt;
    this.c = paramArrayList;
    o();
  }

  private void o()
  {
    boolean bool1;
    GameRequest localGameRequest1;
    int j;
    label39: GameRequest localGameRequest2;
    if (!this.c.isEmpty())
    {
      bool1 = true;
      jn.a(bool1);
      localGameRequest1 = (GameRequest)this.c.get(0);
      int i = this.c.size();
      j = 1;
      if (j >= i)
        return;
      localGameRequest2 = (GameRequest)this.c.get(j);
      if (localGameRequest1.i() != localGameRequest2.i())
        break label120;
    }
    label120: for (boolean bool2 = true; ; bool2 = false)
    {
      jn.a(bool2, "All the requests must be of the same type");
      jn.a(localGameRequest1.f().equals(localGameRequest2.f()), "All the requests must be from the same sender");
      j += 1;
      break label39;
      bool1 = false;
      break;
    }
  }

  public int a_(String paramString)
  {
    throw new UnsupportedOperationException("Method not supported on a cluster");
  }

  public int b()
  {
    return this.b;
  }

  public ArrayList c()
  {
    return new ArrayList(this.c);
  }

  public String d()
  {
    return ((GameRequestEntity)this.c.get(0)).d();
  }

  public int describeContents()
  {
    return 0;
  }

  public Game e()
  {
    throw new UnsupportedOperationException("Method not supported on a cluster");
  }

  public boolean equals(Object paramObject)
  {
    int k;
    if (!(paramObject instanceof GameRequestCluster))
      k = 0;
    while (true)
    {
      return k;
      if (this == paramObject)
      {
        k = 1;
        continue;
      }
      GameRequestCluster localGameRequestCluster = (GameRequestCluster)paramObject;
      if (localGameRequestCluster.c.size() != this.c.size())
      {
        k = 0;
        continue;
      }
      int i = this.c.size();
      for (int j = 0; ; j++)
      {
        if (j >= i)
          break label111;
        if (((GameRequest)this.c.get(j)).equals((GameRequest)localGameRequestCluster.c.get(j)))
          continue;
        k = 0;
        break;
      }
      label111: k = 1;
    }
  }

  public Player f()
  {
    return ((GameRequestEntity)this.c.get(0)).f();
  }

  public ArrayList g()
  {
    throw new UnsupportedOperationException("Method not supported on a cluster");
  }

  public byte[] h()
  {
    throw new UnsupportedOperationException("Method not supported on a cluster");
  }

  public int hashCode()
  {
    return kt.a(this.c.toArray());
  }

  public int i()
  {
    return ((GameRequestEntity)this.c.get(0)).i();
  }

  public long j()
  {
    throw new UnsupportedOperationException("Method not supported on a cluster");
  }

  public long k()
  {
    throw new UnsupportedOperationException("Method not supported on a cluster");
  }

  public int l()
  {
    throw new UnsupportedOperationException("Method not supported on a cluster");
  }

  public GameRequest m()
  {
    return this;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    a.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.internal.request.GameRequestCluster
 * JD-Core Version:    0.6.0
 */