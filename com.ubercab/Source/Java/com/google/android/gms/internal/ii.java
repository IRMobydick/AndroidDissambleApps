package com.google.android.gms.internal;

import android.text.TextUtils;
import java.io.IOException;

public abstract class ii
{
  protected final ip Go;
  private final String Gp;
  private ir Gq;

  protected ii(String paramString1, String paramString2, String paramString3)
  {
    ik.aF(paramString1);
    this.Gp = paramString1;
    this.Go = new ip(paramString2);
    if (!TextUtils.isEmpty(paramString3))
      this.Go.aK(paramString3);
  }

  public final void a(ir paramir)
  {
    this.Gq = paramir;
    if (this.Gq == null)
      fA();
  }

  protected final void a(String paramString1, long paramLong, String paramString2)
    throws IOException
  {
    this.Go.a("Sending text message: %s to: %s", new Object[] { paramString1, paramString2 });
    this.Gq.a(this.Gp, paramString1, paramLong, paramString2);
  }

  public void aD(String paramString)
  {
  }

  public void b(long paramLong, int paramInt)
  {
  }

  public void fA()
  {
  }

  protected final long fz()
  {
    return this.Gq.fx();
  }

  public final String getNamespace()
  {
    return this.Gp;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ii
 * JD-Core Version:    0.6.2
 */