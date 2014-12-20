package com.google.android.gms.games.multiplayer.turnbased;

import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.common.data.d;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.multiplayer.f;

public abstract interface TurnBasedMatch extends Parcelable, d, f
{
  public static final int[] a_;

  static
  {
    int[] arrayOfInt = new int[4];
    arrayOfInt[0] = 0;
    arrayOfInt[1] = 1;
    arrayOfInt[2] = 2;
    arrayOfInt[3] = 3;
    a_ = arrayOfInt;
  }

  public abstract String c();

  public abstract String d();

  public abstract long e();

  public abstract int f();

  public abstract int g();

  public abstract String h();

  public abstract int i();

  public abstract Game i_();

  public abstract String j();

  public abstract long k();

  public abstract String m();

  public abstract byte[] n();

  public abstract int o();

  public abstract String p();

  public abstract byte[] q();

  public abstract int r();

  public abstract Bundle s();

  public abstract int t();

  public abstract boolean u();

  public abstract String v();
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch
 * JD-Core Version:    0.6.0
 */