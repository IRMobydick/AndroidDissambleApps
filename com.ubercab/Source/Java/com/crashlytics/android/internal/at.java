package com.crashlytics.android.internal;

import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;

final class at extends InputStream
{
  private int a;
  private int b;

  private at(aq paramaq, as paramas)
  {
    this.a = aq.a(paramaq, 4 + paramas.b);
    this.b = paramas.c;
  }

  public final int read()
    throws IOException
  {
    if (this.b == 0)
      return -1;
    aq.a(this.c).seek(this.a);
    int i = aq.a(this.c).read();
    this.a = aq.a(this.c, 1 + this.a);
    this.b = (-1 + this.b);
    return i;
  }

  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    aq.a(paramArrayOfByte, "buffer");
    if (((paramInt1 | paramInt2) < 0) || (paramInt2 > paramArrayOfByte.length - paramInt1))
      throw new ArrayIndexOutOfBoundsException();
    if (this.b > 0)
    {
      if (paramInt2 > this.b)
        paramInt2 = this.b;
      aq.a(this.c, this.a, paramArrayOfByte, paramInt1, paramInt2);
      this.a = aq.a(this.c, paramInt2 + this.a);
      this.b -= paramInt2;
      return paramInt2;
    }
    return -1;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.crashlytics.android.internal.at
 * JD-Core Version:    0.6.2
 */