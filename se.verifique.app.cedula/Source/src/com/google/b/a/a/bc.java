package com.google.b.a.a;

class bc
  implements ba
{
  private final long a;
  private final int b;
  private double c;
  private long d;
  private final Object e = new Object();

  public bc()
  {
    this(60, 2000L);
  }

  public bc(int paramInt, long paramLong)
  {
    this.b = paramInt;
    this.c = this.b;
    this.a = paramLong;
  }

  public boolean a()
  {
    int i;
    synchronized (this.e)
    {
      long l = System.currentTimeMillis();
      if (this.c < this.b)
      {
        double d1 = (l - this.d) / this.a;
        if (d1 > 0.0D)
          this.c = Math.min(this.b, d1 + this.c);
      }
      this.d = l;
      if (this.c >= 1.0D)
      {
        this.c -= 1.0D;
        i = 1;
      }
      else
      {
        ar.d("Excessive tracking detected.  Tracking call ignored.");
        i = 0;
      }
    }
    return i;
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.b.a.a.bc
 * JD-Core Version:    0.6.0
 */