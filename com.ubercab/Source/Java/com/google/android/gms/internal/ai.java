package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import java.util.concurrent.Future;

@ez
public class ai
{
  protected ah a(Context paramContext, gt paramgt, final gk<ah> paramgk)
  {
    final aj localaj = new aj(paramContext, paramgt);
    localaj.a(new ah.a()
    {
      public void aM()
      {
        paramgk.a(localaj);
      }
    });
    return localaj;
  }

  public Future<ah> a(final Context paramContext, final gt paramgt, final String paramString)
  {
    final gk localgk = new gk();
    gr.wC.post(new Runnable()
    {
      public void run()
      {
        ai.this.a(paramContext, paramgt, localgk).f(paramString);
      }
    });
    return localgk;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ai
 * JD-Core Version:    0.6.2
 */