package com.baidu.lbsapi.auth;

import java.util.Hashtable;

class g
  implements Runnable
{
  g(e parame, int paramInt, boolean paramBoolean, String paramString1, String paramString2, Hashtable paramHashtable)
  {
  }

  public void run()
  {
    if (a.a)
      a.a("status = " + this.a + "; forced = " + this.b + "checkAK = " + e.a(this.f, this.c));
    if ((this.a == 601) || (this.b) || (this.a == -1) || (e.a(this.f, this.c)))
    {
      if (a.a)
        a.a("authenticate sendAuthRequest");
      e.a(this.f, this.b, this.d, this.e, this.c);
      return;
    }
    if (602 == this.a)
    {
      if (a.a)
        a.a("authenticate wait  ");
      e.b().b();
      e.a(this.f, null, this.c);
      return;
    }
    if (a.a)
      a.a("authenticate else  ");
    e.a(this.f, null, this.c);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.lbsapi.auth.g
 * JD-Core Version:    0.6.2
 */