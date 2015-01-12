package com.google.android.gms.common.data;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.o;

public abstract class d
{
  protected final DataHolder II;
  protected int JX;
  private int JY;

  public d(DataHolder paramDataHolder, int paramInt)
  {
    this.II = ((DataHolder)o.i(paramDataHolder));
    ap(paramInt);
  }

  protected void a(String paramString, CharArrayBuffer paramCharArrayBuffer)
  {
    this.II.a(paramString, this.JX, this.JY, paramCharArrayBuffer);
  }

  public boolean aQ(String paramString)
  {
    return this.II.aQ(paramString);
  }

  protected Uri aR(String paramString)
  {
    return this.II.g(paramString, this.JX, this.JY);
  }

  protected boolean aS(String paramString)
  {
    return this.II.h(paramString, this.JX, this.JY);
  }

  protected void ap(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.II.getCount()));
    for (boolean bool = true; ; bool = false)
    {
      o.I(bool);
      this.JX = paramInt;
      this.JY = this.II.ar(this.JX);
      return;
    }
  }

  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof d;
    boolean bool2 = false;
    if (bool1)
    {
      d locald = (d)paramObject;
      boolean bool3 = n.equal(Integer.valueOf(locald.JX), Integer.valueOf(this.JX));
      bool2 = false;
      if (bool3)
      {
        boolean bool4 = n.equal(Integer.valueOf(locald.JY), Integer.valueOf(this.JY));
        bool2 = false;
        if (bool4)
        {
          DataHolder localDataHolder1 = locald.II;
          DataHolder localDataHolder2 = this.II;
          bool2 = false;
          if (localDataHolder1 == localDataHolder2)
            bool2 = true;
        }
      }
    }
    return bool2;
  }

  protected boolean getBoolean(String paramString)
  {
    return this.II.d(paramString, this.JX, this.JY);
  }

  protected byte[] getByteArray(String paramString)
  {
    return this.II.f(paramString, this.JX, this.JY);
  }

  protected float getFloat(String paramString)
  {
    return this.II.e(paramString, this.JX, this.JY);
  }

  protected int getInteger(String paramString)
  {
    return this.II.b(paramString, this.JX, this.JY);
  }

  protected long getLong(String paramString)
  {
    return this.II.a(paramString, this.JX, this.JY);
  }

  protected String getString(String paramString)
  {
    return this.II.c(paramString, this.JX, this.JY);
  }

  protected int gz()
  {
    return this.JX;
  }

  public int hashCode()
  {
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = Integer.valueOf(this.JX);
    arrayOfObject[1] = Integer.valueOf(this.JY);
    arrayOfObject[2] = this.II;
    return n.hashCode(arrayOfObject);
  }

  public boolean isDataValid()
  {
    return !this.II.isClosed();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.data.d
 * JD-Core Version:    0.6.2
 */