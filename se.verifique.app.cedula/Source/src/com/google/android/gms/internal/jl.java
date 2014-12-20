package com.google.android.gms.internal;

public final class jl
{
  public final int a;
  public final int b;

  public jl(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
  }

  public boolean equals(Object paramObject)
  {
    int i = 1;
    if (!(paramObject instanceof jl))
      i = 0;
    while (true)
    {
      return i;
      if (this == paramObject)
        continue;
      jl localjl = (jl)paramObject;
      if ((localjl.a == this.a) && (localjl.b == this.b))
        continue;
      i = 0;
    }
  }

  public int hashCode()
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = Integer.valueOf(this.a);
    arrayOfObject[1] = Integer.valueOf(this.b);
    return kt.a(arrayOfObject);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.jl
 * JD-Core Version:    0.6.0
 */