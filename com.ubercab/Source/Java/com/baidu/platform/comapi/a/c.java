package com.baidu.platform.comapi.a;

import java.io.Serializable;

public class c
  implements Serializable
{
  public d a;
  public d b;

  public c()
  {
    if (this.a == null)
      this.a = new d();
    if (this.b == null)
      this.b = new d();
  }

  public void a(d paramd)
  {
    this.a = paramd;
  }

  public void b(d paramd)
  {
    this.b = paramd;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.platform.comapi.a.c
 * JD-Core Version:    0.6.2
 */