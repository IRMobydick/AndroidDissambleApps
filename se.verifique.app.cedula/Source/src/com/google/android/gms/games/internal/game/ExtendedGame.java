package com.google.android.gms.games.internal.game;

import android.os.Parcelable;
import com.google.android.gms.common.data.d;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import java.util.ArrayList;

public abstract interface ExtendedGame extends Parcelable, d
{
  public abstract ArrayList c();

  public abstract int d();

  public abstract Game d_();

  public abstract boolean e();

  public abstract int f();

  public abstract long g();

  public abstract long h();

  public abstract String i();

  public abstract long j();

  public abstract String k();

  public abstract SnapshotMetadata l();
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.internal.game.ExtendedGame
 * JD-Core Version:    0.6.0
 */