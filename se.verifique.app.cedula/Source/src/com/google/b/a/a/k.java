package com.google.b.a.a;

class k extends Thread
{
  k(j paramj, String paramString)
  {
    super(paramString);
  }

  public void run()
  {
    synchronized (j.a(this.a))
    {
      j.a(this.a, this.a.c());
      j.a(this.a, true);
      j.a(this.a).notifyAll();
      return;
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.b.a.a.k
 * JD-Core Version:    0.6.0
 */