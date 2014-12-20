package a.a.a;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class cq
  implements co
{
  private int[] a = new int[16];
  private int b;
  private Reader c;
  private boolean d;
  private boolean e;
  private int f;
  private int g;
  private int h;
  private int i;
  private int j;

  protected cq(InputStream paramInputStream, String paramString, int paramInt)
  {
    this.c = new InputStreamReader(paramInputStream, paramString);
    this.e = false;
    this.i = paramInt;
    this.h = 1;
    this.f = 1;
    this.d = false;
  }

  public int a()
  {
    return this.f;
  }

  public void a(int paramInt)
  {
    this.e = true;
    if (this.b >= 16)
    {
      System.arraycopy(this.a, 0, this.a, 1, 15);
      this.b = (-1 + this.b);
    }
    int[] arrayOfInt = this.a;
    int k = this.b;
    this.b = (k + 1);
    arrayOfInt[k] = paramInt;
    if (paramInt == 10)
      this.h = (-1 + this.h);
    this.f = this.g;
  }

  public void a(aw paramaw)
  {
  }

  public int b()
  {
    return this.h;
  }

  public int c()
  {
    int k = 10;
    int i2;
    if (this.e)
    {
      int[] arrayOfInt = this.a;
      int i1 = -1 + this.b;
      this.b = i1;
      i2 = arrayOfInt[i1];
      if (this.b == 0)
        this.e = false;
      if (i2 == k)
      {
        this.f = 1;
        this.h = (1 + this.h);
        k = i2;
      }
    }
    int m;
    while (true)
    {
      return k;
      this.f = (1 + this.f);
      k = i2;
      continue;
      this.g = this.f;
      if (this.j > 0)
      {
        this.f = (1 + this.f);
        this.j = (-1 + this.j);
        k = 32;
        continue;
      }
      m = e();
      if (m < 0)
      {
        this.d = true;
        k = -1;
        continue;
      }
      if (m != k)
        break;
      this.f = 1;
      this.h = (1 + this.h);
      k = m;
    }
    int n;
    if (m == 13)
    {
      n = e();
      if (n == k)
        break label285;
      if (n != -1)
        a(n);
    }
    while (true)
    {
      this.f = 1;
      this.h = (1 + this.h);
      break;
      if (m == 9)
      {
        this.j = (-1 + (this.i - (-1 + this.f) % this.i));
        this.f = (1 + this.f);
        k = 32;
        break;
      }
      this.f = (1 + this.f);
      k = m;
      break;
      label285: k = n;
    }
  }

  public boolean d()
  {
    return this.d;
  }

  public int e()
  {
    try
    {
      k = this.c.read();
      if (k < 0)
        this.d = true;
      return k;
    }
    catch (IOException localIOException)
    {
      while (true)
      {
        this.d = true;
        int k = -1;
      }
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     a.a.a.cq
 * JD-Core Version:    0.6.0
 */