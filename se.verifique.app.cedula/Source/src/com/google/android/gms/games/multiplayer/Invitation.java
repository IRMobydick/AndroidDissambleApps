package com.google.android.gms.games.multiplayer;

import android.os.Parcelable;
import com.google.android.gms.common.data.d;
import com.google.android.gms.games.Game;

public abstract interface Invitation extends Parcelable, d, f
{
  public abstract Game d();

  public abstract String e();

  public abstract Participant f();

  public abstract long g();

  public abstract int h();

  public abstract int i();

  public abstract int j();
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.multiplayer.Invitation
 * JD-Core Version:    0.6.0
 */