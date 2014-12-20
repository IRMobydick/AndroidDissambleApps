package com.google.android.gms.games.multiplayer;

import android.net.Uri;
import android.os.Parcelable;
import com.google.android.gms.common.data.d;
import com.google.android.gms.games.Player;

public abstract interface Participant extends Parcelable, d
{
  public abstract String c();

  public abstract int d();

  public abstract boolean e();

  public abstract String f();

  public abstract Uri g();

  public abstract int g_();

  @Deprecated
  public abstract String h();

  public abstract Uri i();

  @Deprecated
  public abstract String j();

  public abstract String k();

  public abstract Player l();

  public abstract ParticipantResult m();
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.multiplayer.Participant
 * JD-Core Version:    0.6.0
 */