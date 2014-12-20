package com.google.android.gms.internal;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.ads.e.a;
import java.util.Collections;
import java.util.Date;
import java.util.Map;
import java.util.Set;

public final class ah
{
  public static final String a = hh.a("emulator");
  private final Date b;
  private final String c;
  private final int d;
  private final Set e;
  private final Location f;
  private final boolean g;
  private final Bundle h;
  private final Map i;
  private final String j;
  private final a k;
  private final int l;
  private final Set m;

  public ah(aj paramaj)
  {
    this(paramaj, null);
  }

  public ah(aj paramaj, a parama)
  {
    this.b = aj.a(paramaj);
    this.c = aj.b(paramaj);
    this.d = aj.c(paramaj);
    this.e = Collections.unmodifiableSet(aj.d(paramaj));
    this.f = aj.e(paramaj);
    this.g = aj.f(paramaj);
    this.h = aj.g(paramaj);
    this.i = Collections.unmodifiableMap(aj.h(paramaj));
    this.j = aj.i(paramaj);
    this.k = parama;
    this.l = aj.j(paramaj);
    this.m = Collections.unmodifiableSet(aj.k(paramaj));
  }

  public Bundle a(Class paramClass)
  {
    return this.h.getBundle(paramClass.getName());
  }

  public Date a()
  {
    return this.b;
  }

  public boolean a(Context paramContext)
  {
    return this.m.contains(hh.a(paramContext));
  }

  public String b()
  {
    return this.c;
  }

  public int c()
  {
    return this.d;
  }

  public Set d()
  {
    return this.e;
  }

  public Location e()
  {
    return this.f;
  }

  public boolean f()
  {
    return this.g;
  }

  public String g()
  {
    return this.j;
  }

  public a h()
  {
    return this.k;
  }

  public Map i()
  {
    return this.i;
  }

  public Bundle j()
  {
    return this.h;
  }

  public int k()
  {
    return this.l;
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ah
 * JD-Core Version:    0.6.0
 */