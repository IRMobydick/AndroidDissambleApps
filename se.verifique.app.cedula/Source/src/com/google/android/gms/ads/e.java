package com.google.android.gms.ads;

import android.content.Context;
import android.content.res.Resources;
import com.google.android.gms.internal.al;
import com.google.android.gms.internal.hh;

public final class e
{
  public static final e a = new e(320, 50, "320x50_mb");
  public static final e b = new e(468, 60, "468x60_as");
  public static final e c = new e(320, 100, "320x100_as");
  public static final e d = new e(728, 90, "728x90_as");
  public static final e e = new e(300, 250, "300x250_as");
  public static final e f = new e(160, 600, "160x600_as");
  public static final e g = new e(-1, -2, "smart_banner");
  private final int h;
  private final int i;
  private final String j;

  public e(int paramInt1, int paramInt2)
  {
  }

  e(int paramInt1, int paramInt2, String paramString)
  {
    if ((paramInt1 < 0) && (paramInt1 != -1))
      throw new IllegalArgumentException("Invalid width for AdSize: " + paramInt1);
    if ((paramInt2 < 0) && (paramInt2 != -2))
      throw new IllegalArgumentException("Invalid height for AdSize: " + paramInt2);
    this.h = paramInt1;
    this.i = paramInt2;
    this.j = paramString;
  }

  public int a()
  {
    return this.i;
  }

  public int a(Context paramContext)
  {
    if (this.i == -2);
    for (int k = al.b(paramContext.getResources().getDisplayMetrics()); ; k = hh.a(paramContext, this.i))
      return k;
  }

  public int b()
  {
    return this.h;
  }

  public int b(Context paramContext)
  {
    if (this.h == -1);
    for (int k = al.a(paramContext.getResources().getDisplayMetrics()); ; k = hh.a(paramContext, this.h))
      return k;
  }

  public boolean equals(Object paramObject)
  {
    int k = 1;
    if (paramObject == this);
    while (true)
    {
      return k;
      if (!(paramObject instanceof e))
      {
        k = 0;
        continue;
      }
      e locale = (e)paramObject;
      if ((this.h == locale.h) && (this.i == locale.i) && (this.j.equals(locale.j)))
        continue;
      k = 0;
    }
  }

  public int hashCode()
  {
    return this.j.hashCode();
  }

  public String toString()
  {
    return this.j;
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.e
 * JD-Core Version:    0.6.0
 */