package com.google.android.gms.internal;

import java.util.List;

public abstract class nr extends ns
{
  protected List e;

  public void a(no paramno)
  {
    if (this.e == null);
    for (int i = 0; ; i = this.e.size())
      for (int j = 0; j < i; j++)
      {
        nu localnu = (nu)this.e.get(j);
        paramno.e(localnu.a);
        paramno.b(localnu.b);
      }
  }

  protected int b()
  {
    if (this.e == null);
    int k;
    for (int i = 0; ; i = this.e.size())
    {
      int j = 0;
      k = 0;
      while (j < i)
      {
        nu localnu = (nu)this.e.get(j);
        k = k + no.f(localnu.a) + localnu.b.length;
        j++;
      }
    }
    return k;
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.nr
 * JD-Core Version:    0.6.0
 */