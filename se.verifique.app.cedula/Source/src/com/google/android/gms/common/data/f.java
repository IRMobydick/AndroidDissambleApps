package com.google.android.gms.common.data;

import android.net.Uri;
import com.google.android.gms.internal.kt;
import com.google.android.gms.internal.kx;

public abstract class f
{
  protected final DataHolder a;
  protected int b;
  private int c;

  public f(DataHolder paramDataHolder, int paramInt)
  {
    this.a = ((DataHolder)kx.a(paramDataHolder));
    a(paramInt);
  }

  protected void a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.a.g()));
    for (boolean bool = true; ; bool = false)
    {
      kx.a(bool);
      this.b = paramInt;
      this.c = this.a.a(this.b);
      return;
    }
  }

  public boolean a(String paramString)
  {
    return this.a.a(paramString);
  }

  protected int b()
  {
    return this.b;
  }

  protected long b(String paramString)
  {
    return this.a.a(paramString, this.b, this.c);
  }

  protected int c(String paramString)
  {
    return this.a.b(paramString, this.b, this.c);
  }

  protected boolean d(String paramString)
  {
    return this.a.d(paramString, this.b, this.c);
  }

  protected String e(String paramString)
  {
    return this.a.c(paramString, this.b, this.c);
  }

  public boolean equals(Object paramObject)
  {
    int i = 0;
    if ((paramObject instanceof f))
    {
      f localf = (f)paramObject;
      if ((kt.a(Integer.valueOf(localf.b), Integer.valueOf(this.b))) && (kt.a(Integer.valueOf(localf.c), Integer.valueOf(this.c))) && (localf.a == this.a))
        i = 1;
    }
    return i;
  }

  protected float f(String paramString)
  {
    return this.a.e(paramString, this.b, this.c);
  }

  protected byte[] g(String paramString)
  {
    return this.a.f(paramString, this.b, this.c);
  }

  protected Uri h(String paramString)
  {
    return this.a.g(paramString, this.b, this.c);
  }

  public int hashCode()
  {
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = Integer.valueOf(this.b);
    arrayOfObject[1] = Integer.valueOf(this.c);
    arrayOfObject[2] = this.a;
    return kt.a(arrayOfObject);
  }

  protected boolean i(String paramString)
  {
    return this.a.h(paramString, this.b, this.c);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.data.f
 * JD-Core Version:    0.6.0
 */