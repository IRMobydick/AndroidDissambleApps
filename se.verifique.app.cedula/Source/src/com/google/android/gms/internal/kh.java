package com.google.android.gms.internal;

import android.content.ComponentName;
import android.os.IBinder;
import java.util.HashSet;

final class kh
{
  private final String b;
  private final ki c;
  private final HashSet d;
  private int e;
  private boolean f;
  private IBinder g;
  private ComponentName h;

  public kh(kg paramkg, String paramString)
  {
    this.b = paramString;
    this.c = new ki(this);
    this.d = new HashSet();
    this.e = 0;
  }

  public ki a()
  {
    return this.c;
  }

  public void a(jz paramjz)
  {
    this.d.add(paramjz);
  }

  public void a(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }

  public String b()
  {
    return this.b;
  }

  public void b(jz paramjz)
  {
    this.d.remove(paramjz);
  }

  public boolean c()
  {
    return this.f;
  }

  public boolean c(jz paramjz)
  {
    return this.d.contains(paramjz);
  }

  public int d()
  {
    return this.e;
  }

  public boolean e()
  {
    return this.d.isEmpty();
  }

  public IBinder f()
  {
    return this.g;
  }

  public ComponentName g()
  {
    return this.h;
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.kh
 * JD-Core Version:    0.6.0
 */