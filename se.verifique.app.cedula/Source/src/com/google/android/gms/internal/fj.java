package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import com.google.android.gms.common.c;
import com.google.android.gms.common.d;

public class fj extends jr
{
  final int a;

  public fj(Context paramContext, c paramc, d paramd, int paramInt)
  {
    super(paramContext, paramc, paramd, new String[0]);
    this.a = paramInt;
  }

  protected fq a(IBinder paramIBinder)
  {
    return fs.a(paramIBinder);
  }

  protected String a()
  {
    return "com.google.android.gms.ads.service.START";
  }

  protected void a(ko paramko, jy paramjy)
  {
    Bundle localBundle = new Bundle();
    paramko.g(paramjy, this.a, j().getPackageName(), localBundle);
  }

  protected String b()
  {
    return "com.google.android.gms.ads.internal.request.IAdRequestService";
  }

  public fq c()
  {
    return (fq)super.m();
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.fj
 * JD-Core Version:    0.6.0
 */