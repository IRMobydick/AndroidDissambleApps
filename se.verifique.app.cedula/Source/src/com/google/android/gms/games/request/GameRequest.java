package com.google.android.gms.games.request;

import android.os.Parcelable;
import com.google.android.gms.common.data.d;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.Player;
import java.util.List;

public abstract interface GameRequest extends Parcelable, d
{
  public abstract int a_(String paramString);

  public abstract String d();

  public abstract Game e();

  public abstract Player f();

  public abstract byte[] h();

  public abstract int i();

  public abstract long j();

  public abstract long k();

  public abstract int l();

  public abstract List n();
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.request.GameRequest
 * JD-Core Version:    0.6.0
 */