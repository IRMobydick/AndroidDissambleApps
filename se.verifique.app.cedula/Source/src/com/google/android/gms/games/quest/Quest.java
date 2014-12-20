package com.google.android.gms.games.quest;

import android.net.Uri;
import android.os.Parcelable;
import com.google.android.gms.common.data.d;
import com.google.android.gms.games.Game;
import java.util.List;

public abstract interface Quest extends Parcelable, d
{
  public static final int[] b_;
  public static final String[] c_;

  static
  {
    int[] arrayOfInt = new int[6];
    arrayOfInt[0] = 1;
    arrayOfInt[1] = 2;
    arrayOfInt[2] = 3;
    arrayOfInt[3] = 4;
    arrayOfInt[4] = 6;
    arrayOfInt[5] = 5;
    b_ = arrayOfInt;
    String[] arrayOfString = new String[3];
    arrayOfString[0] = Integer.toString(1);
    arrayOfString[1] = Integer.toString(2);
    arrayOfString[2] = Integer.toString(3);
    c_ = arrayOfString;
  }

  public abstract String c();

  public abstract String d();

  public abstract Uri e();

  @Deprecated
  public abstract String f();

  public abstract Uri g();

  @Deprecated
  public abstract String h();

  public abstract List i();

  public abstract Game j();

  public abstract int k();

  public abstract String k_();

  public abstract int l();

  public abstract long m();

  public abstract long n();

  public abstract long o();

  public abstract long p();

  public abstract long q();
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.quest.Quest
 * JD-Core Version:    0.6.0
 */