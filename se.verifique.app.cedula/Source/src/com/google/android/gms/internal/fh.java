package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.a;
import com.google.android.gms.common.c;
import com.google.android.gms.common.d;

public final class fh extends fe
  implements c, d
{
  private final fc a;
  private final fj b;
  private final Object c = new Object();

  public fh(Context paramContext, ds paramds, fc paramfc)
  {
    super(paramds, paramfc);
    this.a = paramfc;
    this.b = new fj(paramContext, this, this, paramds.l.e);
    this.b.f();
  }

  public void a(Bundle paramBundle)
  {
    e();
  }

  public void a(a parama)
  {
    this.a.a(new du(0));
  }

  public void c()
  {
    synchronized (this.c)
    {
      if ((this.b.g()) || (this.b.h()))
        this.b.i();
      return;
    }
  }

  public fq d()
  {
    fq localfq1;
    synchronized (this.c)
    {
      try
      {
        fq localfq2 = this.b.c();
        localfq1 = localfq2;
      }
      catch (IllegalStateException localIllegalStateException)
      {
        localfq1 = null;
      }
    }
    return localfq1;
  }

  public void m_()
  {
    hi.a("Disconnected from remote ad request service.");
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.fh
 * JD-Core Version:    0.6.0
 */