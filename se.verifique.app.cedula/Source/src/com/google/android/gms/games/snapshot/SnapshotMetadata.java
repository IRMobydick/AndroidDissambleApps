package com.google.android.gms.games.snapshot;

import android.net.Uri;
import android.os.Parcelable;
import com.google.android.gms.common.data.d;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.Player;

public abstract interface SnapshotMetadata extends Parcelable, d
{
  public abstract Player c();

  public abstract String d();

  public abstract Uri e();

  @Deprecated
  public abstract String f();

  public abstract float g();

  public abstract String h();

  public abstract String i();

  public abstract String j();

  public abstract long k();

  public abstract long l();

  public abstract Game l_();
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.snapshot.SnapshotMetadata
 * JD-Core Version:    0.6.0
 */