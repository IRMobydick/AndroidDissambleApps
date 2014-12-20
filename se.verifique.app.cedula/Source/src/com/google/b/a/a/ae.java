package com.google.b.a.a;

import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;

class ae extends TimerTask
{
  private ae(z paramz)
  {
  }

  public void run()
  {
    if ((z.b(this.a) == ad.b) && (z.e(this.a).isEmpty()) && (z.f(this.a) + z.g(this.a) < z.h(this.a).a()))
    {
      ar.c("Disconnecting due to inactivity");
      z.i(this.a);
    }
    while (true)
    {
      return;
      z.j(this.a).schedule(new ae(this.a), z.g(this.a));
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.b.a.a.ae
 * JD-Core Version:    0.6.0
 */