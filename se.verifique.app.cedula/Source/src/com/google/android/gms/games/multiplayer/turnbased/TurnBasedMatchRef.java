package com.google.android.gms.games.multiplayer.turnbased;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.data.f;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.multiplayer.ParticipantRef;
import java.util.ArrayList;

public final class TurnBasedMatchRef extends f
  implements TurnBasedMatch
{
  private final Game c;
  private final int d;

  public String c()
  {
    return e("external_match_id");
  }

  public String d()
  {
    return e("creator_external");
  }

  public int describeContents()
  {
    return 0;
  }

  public long e()
  {
    return b("creation_timestamp");
  }

  public boolean equals(Object paramObject)
  {
    return TurnBasedMatchEntity.a(this, paramObject);
  }

  public int f()
  {
    return c("status");
  }

  public int g()
  {
    return c("user_match_status");
  }

  public String h()
  {
    return e("description");
  }

  public int hashCode()
  {
    return TurnBasedMatchEntity.a(this);
  }

  public int i()
  {
    return c("variant");
  }

  public Game i_()
  {
    return this.c;
  }

  public String j()
  {
    return e("last_updater_external");
  }

  public long k()
  {
    return b("last_updated_timestamp");
  }

  public ArrayList l()
  {
    ArrayList localArrayList = new ArrayList(this.d);
    for (int i = 0; i < this.d; i++)
      localArrayList.add(new ParticipantRef(this.a, i + this.b));
    return localArrayList;
  }

  public String m()
  {
    return e("pending_participant_external");
  }

  public byte[] n()
  {
    return g("data");
  }

  public int o()
  {
    return c("version");
  }

  public String p()
  {
    return e("rematch_id");
  }

  public byte[] q()
  {
    return g("previous_match_data");
  }

  public int r()
  {
    return c("match_number");
  }

  public Bundle s()
  {
    if (!d("has_automatch_criteria"));
    for (Bundle localBundle = null; ; localBundle = a.a(c("automatch_min_players"), c("automatch_max_players"), b("automatch_bit_mask")))
      return localBundle;
  }

  public int t()
  {
    if (!d("has_automatch_criteria"));
    for (int i = 0; ; i = c("automatch_max_players"))
      return i;
  }

  public String toString()
  {
    return TurnBasedMatchEntity.b(this);
  }

  public boolean u()
  {
    return d("upsync_required");
  }

  public String v()
  {
    return e("description_participant_id");
  }

  public TurnBasedMatch w()
  {
    return new TurnBasedMatchEntity(this);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ((TurnBasedMatchEntity)w()).writeToParcel(paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchRef
 * JD-Core Version:    0.6.0
 */