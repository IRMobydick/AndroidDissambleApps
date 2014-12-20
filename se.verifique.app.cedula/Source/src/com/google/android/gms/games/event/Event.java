package com.google.android.gms.games.event;

import android.net.Uri;
import android.os.Parcelable;
import com.google.android.gms.common.data.d;
import com.google.android.gms.games.Player;

public abstract interface Event extends Parcelable, d
{
  public abstract String c();

  public abstract String c_();

  public abstract String d();

  public abstract Uri e();

  @Deprecated
  public abstract String f();

  public abstract Player g();

  public abstract long h();

  public abstract String i();

  public abstract boolean j();
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.event.Event
 * JD-Core Version:    0.6.0
 */