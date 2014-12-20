package com.google.a;

import com.google.android.gms.ads.e;

@Deprecated
public final class c
{
  public static final c a = new c(-1, -2, "mb");
  public static final c b = new c(320, 50, "mb");
  public static final c c = new c(300, 250, "as");
  public static final c d = new c(468, 60, "as");
  public static final c e = new c(728, 90, "as");
  public static final c f = new c(160, 600, "as");
  private final e g;

  private c(int paramInt1, int paramInt2, String paramString)
  {
    this(new e(paramInt1, paramInt2));
  }

  public c(e parame)
  {
    this.g = parame;
  }

  public int a()
  {
    return this.g.b();
  }

  public int b()
  {
    return this.g.a();
  }

  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof c));
    c localc;
    for (boolean bool = false; ; bool = this.g.equals(localc.g))
    {
      return bool;
      localc = (c)paramObject;
    }
  }

  public int hashCode()
  {
    return this.g.hashCode();
  }

  public String toString()
  {
    return this.g.toString();
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.a.c
 * JD-Core Version:    0.6.0
 */