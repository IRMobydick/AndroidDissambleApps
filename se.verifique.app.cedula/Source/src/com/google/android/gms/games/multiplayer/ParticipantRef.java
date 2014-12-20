package com.google.android.gms.games.multiplayer;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.f;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerRef;

public final class ParticipantRef extends f
  implements Participant
{
  private final PlayerRef c;

  public ParticipantRef(DataHolder paramDataHolder, int paramInt)
  {
    super(paramDataHolder, paramInt);
    this.c = new PlayerRef(paramDataHolder, paramInt);
  }

  public String c()
  {
    return e("client_address");
  }

  public int d()
  {
    return c("capabilities");
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean e()
  {
    if (c("connected") > 0);
    for (int i = 1; ; i = 0)
      return i;
  }

  public boolean equals(Object paramObject)
  {
    return ParticipantEntity.a(this, paramObject);
  }

  public String f()
  {
    if (i("external_player_id"));
    for (String str = e("default_display_name"); ; str = this.c.c())
      return str;
  }

  public Uri g()
  {
    if (i("external_player_id"));
    for (Uri localUri = h("default_display_image_uri"); ; localUri = this.c.d())
      return localUri;
  }

  public int g_()
  {
    return c("player_status");
  }

  public String h()
  {
    if (i("external_player_id"));
    for (String str = e("default_display_image_url"); ; str = this.c.e())
      return str;
  }

  public int hashCode()
  {
    return ParticipantEntity.a(this);
  }

  public Uri i()
  {
    if (i("external_player_id"));
    for (Uri localUri = h("default_display_hi_res_image_uri"); ; localUri = this.c.f())
      return localUri;
  }

  public String j()
  {
    if (i("external_player_id"));
    for (String str = e("default_display_hi_res_image_url"); ; str = this.c.g())
      return str;
  }

  public String k()
  {
    return e("external_participant_id");
  }

  public Player l()
  {
    if (i("external_player_id"));
    for (PlayerRef localPlayerRef = null; ; localPlayerRef = this.c)
      return localPlayerRef;
  }

  public ParticipantResult m()
  {
    if (i("result_type"));
    int i;
    int j;
    for (ParticipantResult localParticipantResult = null; ; localParticipantResult = new ParticipantResult(k(), i, j))
    {
      return localParticipantResult;
      i = c("result_type");
      j = c("placing");
    }
  }

  public Participant n()
  {
    return new ParticipantEntity(this);
  }

  public String toString()
  {
    return ParticipantEntity.b(this);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ((ParticipantEntity)n()).writeToParcel(paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.multiplayer.ParticipantRef
 * JD-Core Version:    0.6.0
 */