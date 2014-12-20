package com.google.android.gms.drive.internal;

import com.google.android.gms.internal.no;
import com.google.android.gms.internal.nr;
import java.util.List;

public final class d extends nr
{
  public int a;
  public String b;
  public long c;
  public long d;

  public d()
  {
    a();
  }

  public d a()
  {
    this.a = 1;
    this.b = "";
    this.c = -1L;
    this.d = -1L;
    this.e = null;
    this.f = -1;
    return this;
  }

  public void a(no paramno)
  {
    paramno.a(1, this.a);
    paramno.a(2, this.b);
    paramno.b(3, this.c);
    paramno.b(4, this.d);
    super.a(paramno);
  }

  protected int b()
  {
    return super.b() + no.b(1, this.a) + no.b(2, this.b) + no.c(3, this.c) + no.c(4, this.d);
  }

  public boolean equals(Object paramObject)
  {
    boolean bool = false;
    if (paramObject == this)
      bool = true;
    while (true)
    {
      return bool;
      if (!(paramObject instanceof d))
        continue;
      d locald = (d)paramObject;
      if (this.a != locald.a)
        continue;
      if (this.b == null)
      {
        if (locald.b != null)
          continue;
        if ((this.c != locald.c) || (this.d != locald.d))
          continue;
        if ((this.e == null) || (this.e.isEmpty()))
        {
          if ((locald.e != null) && (!locald.e.isEmpty()))
            continue;
          bool = true;
          continue;
        }
      }
      else
      {
        if (this.b.equals(locald.b))
          break;
        continue;
      }
      bool = this.e.equals(locald.e);
    }
  }

  public int hashCode()
  {
    int i = 0;
    int j = 31 * (527 + this.a);
    int k;
    int m;
    if (this.b == null)
    {
      k = 0;
      m = 31 * (31 * (31 * (k + j) + (int)(this.c ^ this.c >>> 32)) + (int)(this.d ^ this.d >>> 32));
      if ((this.e != null) && (!this.e.isEmpty()))
        break label100;
    }
    while (true)
    {
      return m + i;
      k = this.b.hashCode();
      break;
      label100: i = this.e.hashCode();
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.d
 * JD-Core Version:    0.6.0
 */