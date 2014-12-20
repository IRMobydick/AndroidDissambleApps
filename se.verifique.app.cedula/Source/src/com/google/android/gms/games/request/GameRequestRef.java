package com.google.android.gms.games.request;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.f;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameRef;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerRef;
import java.util.ArrayList;
import java.util.List;

public final class GameRequestRef extends f
  implements GameRequest
{
  private final int c;

  public int a_(String paramString)
  {
    int i = this.b;
    int k;
    if (i < this.b + this.c)
    {
      k = this.a.a(i);
      if (!this.a.c("recipient_external_player_id", i, k).equals(paramString));
    }
    for (int j = this.a.b("recipient_status", i, k); ; j = -1)
    {
      return j;
      i++;
      break;
    }
  }

  public GameRequest c()
  {
    return new GameRequestEntity(this);
  }

  public String d()
  {
    return e("external_request_id");
  }

  public int describeContents()
  {
    return 0;
  }

  public Game e()
  {
    return new GameRef(this.a, this.b);
  }

  public boolean equals(Object paramObject)
  {
    return GameRequestEntity.a(this, paramObject);
  }

  public Player f()
  {
    return new PlayerRef(this.a, b(), "sender_");
  }

  public byte[] h()
  {
    return g("data");
  }

  public int hashCode()
  {
    return GameRequestEntity.a(this);
  }

  public int i()
  {
    return c("type");
  }

  public long j()
  {
    return b("creation_timestamp");
  }

  public long k()
  {
    return b("expiration_timestamp");
  }

  public int l()
  {
    return c("status");
  }

  public List n()
  {
    ArrayList localArrayList = new ArrayList(this.c);
    for (int i = 0; i < this.c; i++)
      localArrayList.add(new PlayerRef(this.a, i + this.b, "recipient_"));
    return localArrayList;
  }

  public String toString()
  {
    return GameRequestEntity.b(this);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ((GameRequestEntity)c()).writeToParcel(paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.request.GameRequestRef
 * JD-Core Version:    0.6.0
 */