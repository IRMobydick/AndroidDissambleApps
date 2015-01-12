package com.google.android.gms.internal;

import android.graphics.drawable.Drawable;
import com.google.android.gms.common.internal.n;

public final class iz extends ja<a, Drawable>
{
  public iz()
  {
    super(10);
  }

  public static final class a
  {
    public final int Lp;
    public final int Lq;

    public a(int paramInt1, int paramInt2)
    {
      this.Lp = paramInt1;
      this.Lq = paramInt2;
    }

    public boolean equals(Object paramObject)
    {
      boolean bool = true;
      if (!(paramObject instanceof a))
        bool = false;
      a locala;
      do
      {
        do
          return bool;
        while (this == paramObject);
        locala = (a)paramObject;
      }
      while ((locala.Lp == this.Lp) && (locala.Lq == this.Lq));
      return false;
    }

    public int hashCode()
    {
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = Integer.valueOf(this.Lp);
      arrayOfObject[1] = Integer.valueOf(this.Lq);
      return n.hashCode(arrayOfObject);
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.iz
 * JD-Core Version:    0.6.2
 */