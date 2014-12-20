package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcelable;
import com.google.android.gms.common.data.d;
import com.google.android.gms.games.internal.player.MostRecentGameInfo;

public abstract interface Player extends Parcelable, d
{
  public abstract String b_();

  public abstract String c();

  public abstract Uri d();

  @Deprecated
  public abstract String e();

  public abstract Uri f();

  @Deprecated
  public abstract String g();

  public abstract long h();

  public abstract long i();

  public abstract int j();

  public abstract boolean k();

  public abstract String l();

  public abstract PlayerLevelInfo m();

  public abstract MostRecentGameInfo n();
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.Player
 * JD-Core Version:    0.6.0
 */