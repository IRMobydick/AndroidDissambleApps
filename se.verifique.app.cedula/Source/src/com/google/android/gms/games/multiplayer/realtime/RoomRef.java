package com.google.android.gms.games.multiplayer.realtime;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.data.f;
import com.google.android.gms.games.multiplayer.ParticipantRef;
import java.util.ArrayList;

public final class RoomRef extends f
  implements Room
{
  private final int c;

  public String c()
  {
    return e("creator_external");
  }

  public long d()
  {
    return b("creation_timestamp");
  }

  public int describeContents()
  {
    return 0;
  }

  public int e()
  {
    return c("status");
  }

  public boolean equals(Object paramObject)
  {
    return RoomEntity.a(this, paramObject);
  }

  public String f()
  {
    return e("description");
  }

  public int g()
  {
    return c("variant");
  }

  public Bundle h()
  {
    if (!d("has_automatch_criteria"));
    for (Bundle localBundle = null; ; localBundle = b.a(c("automatch_min_players"), c("automatch_max_players"), b("automatch_bit_mask")))
      return localBundle;
  }

  public String h_()
  {
    return e("external_match_id");
  }

  public int hashCode()
  {
    return RoomEntity.a(this);
  }

  public int i()
  {
    return c("automatch_wait_estimate_sec");
  }

  public Room j()
  {
    return new RoomEntity(this);
  }

  public ArrayList l()
  {
    ArrayList localArrayList = new ArrayList(this.c);
    for (int i = 0; i < this.c; i++)
      localArrayList.add(new ParticipantRef(this.a, i + this.b));
    return localArrayList;
  }

  public String toString()
  {
    return RoomEntity.b(this);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ((RoomEntity)j()).writeToParcel(paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.multiplayer.realtime.RoomRef
 * JD-Core Version:    0.6.0
 */