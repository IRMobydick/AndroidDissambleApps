package android.support.v4.c;

public class c
{
  private static final Object a = new Object();
  private boolean b = false;
  private int[] c;
  private Object[] d;
  private int e;

  public c()
  {
    this(10);
  }

  public c(int paramInt)
  {
    int i = d(paramInt);
    this.c = new int[i];
    this.d = new Object[i];
    this.e = 0;
  }

  static int c(int paramInt)
  {
    for (int i = 4; ; i++)
    {
      if (i < 32)
      {
        if (paramInt > -12 + (1 << i))
          continue;
        paramInt = -12 + (1 << i);
      }
      return paramInt;
    }
  }

  private void c()
  {
    int i = this.e;
    int[] arrayOfInt = this.c;
    Object[] arrayOfObject = this.d;
    int j = 0;
    int k = 0;
    while (j < i)
    {
      Object localObject = arrayOfObject[j];
      if (localObject != a)
      {
        if (j != k)
        {
          arrayOfInt[k] = arrayOfInt[j];
          arrayOfObject[k] = localObject;
        }
        k++;
      }
      j++;
    }
    this.b = false;
    this.e = k;
  }

  static int d(int paramInt)
  {
    return c(paramInt * 4) / 4;
  }

  public int a()
  {
    if (this.b)
      c();
    return this.e;
  }

  public int a(int paramInt)
  {
    if (this.b)
      c();
    return this.c[paramInt];
  }

  public Object b(int paramInt)
  {
    if (this.b)
      c();
    return this.d[paramInt];
  }

  public void b()
  {
    int i = this.e;
    Object[] arrayOfObject = this.d;
    for (int j = 0; j < i; j++)
      arrayOfObject[j] = null;
    this.e = 0;
    this.b = false;
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.c.c
 * JD-Core Version:    0.6.0
 */