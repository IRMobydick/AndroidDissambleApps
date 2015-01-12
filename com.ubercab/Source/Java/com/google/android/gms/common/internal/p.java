package com.google.android.gms.common.internal;

import android.content.Context;
import android.os.IBinder;
import android.view.View;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.dynamic.e;
import com.google.android.gms.dynamic.g;
import com.google.android.gms.dynamic.g.a;

public final class p extends g<m>
{
  private static final p Mi = new p();

  private p()
  {
    super("com.google.android.gms.common.ui.SignInButtonCreatorImpl");
  }

  public static View b(Context paramContext, int paramInt1, int paramInt2)
    throws g.a
  {
    return Mi.c(paramContext, paramInt1, paramInt2);
  }

  private View c(Context paramContext, int paramInt1, int paramInt2)
    throws g.a
  {
    try
    {
      d locald = e.k(paramContext);
      View localView = (View)e.f(((m)L(paramContext)).a(locald, paramInt1, paramInt2));
      return localView;
    }
    catch (Exception localException)
    {
      throw new g.a("Could not get button with size " + paramInt1 + " and color " + paramInt2, localException);
    }
  }

  public m S(IBinder paramIBinder)
  {
    return m.a.R(paramIBinder);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.internal.p
 * JD-Core Version:    0.6.2
 */