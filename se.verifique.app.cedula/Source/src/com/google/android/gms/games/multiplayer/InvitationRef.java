package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import com.google.android.gms.common.data.f;
import com.google.android.gms.games.Game;
import java.util.ArrayList;

public final class InvitationRef extends f
  implements Invitation
{
  private final Game c;
  private final ParticipantRef d;
  private final ArrayList e;

  public Invitation c()
  {
    return new InvitationEntity(this);
  }

  public Game d()
  {
    return this.c;
  }

  public int describeContents()
  {
    return 0;
  }

  public String e()
  {
    return e("external_invitation_id");
  }

  public boolean equals(Object paramObject)
  {
    return InvitationEntity.a(this, paramObject);
  }

  public Participant f()
  {
    return this.d;
  }

  public long g()
  {
    return Math.max(b("creation_timestamp"), b("last_modified_timestamp"));
  }

  public int h()
  {
    return c("type");
  }

  public int hashCode()
  {
    return InvitationEntity.a(this);
  }

  public int i()
  {
    return c("variant");
  }

  public int j()
  {
    if (!d("has_automatch_criteria"));
    for (int i = 0; ; i = c("automatch_max_players"))
      return i;
  }

  public ArrayList l()
  {
    return this.e;
  }

  public String toString()
  {
    return InvitationEntity.b(this);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ((InvitationEntity)c()).writeToParcel(paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.multiplayer.InvitationRef
 * JD-Core Version:    0.6.0
 */