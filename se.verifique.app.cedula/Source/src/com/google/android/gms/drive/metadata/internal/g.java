package com.google.android.gms.drive.metadata.internal;

import com.google.android.gms.drive.metadata.a;
import com.google.android.gms.internal.lt;
import com.google.android.gms.internal.me;
import com.google.android.gms.internal.ml;
import java.util.HashMap;
import java.util.Map;

public final class g
{
  private static Map a = new HashMap();

  static
  {
    a(lt.a);
    a(lt.y);
    a(lt.r);
    a(lt.w);
    a(lt.z);
    a(lt.l);
    a(lt.m);
    a(lt.j);
    a(lt.o);
    a(lt.u);
    a(lt.b);
    a(lt.t);
    a(lt.d);
    a(lt.k);
    a(lt.e);
    a(lt.f);
    a(lt.g);
    a(lt.q);
    a(lt.n);
    a(lt.s);
    a(lt.v);
    a(lt.A);
    a(lt.B);
    a(lt.i);
    a(lt.h);
    a(lt.x);
    a(lt.p);
    a(lt.c);
    a(lt.C);
    a(me.a);
    a(me.c);
    a(me.d);
    a(me.e);
    a(me.b);
    a(ml.a);
    a(ml.b);
  }

  public static a a(String paramString)
  {
    return (a)a.get(paramString);
  }

  private static void a(a parama)
  {
    if (a.containsKey(parama.a()))
      throw new IllegalArgumentException("Duplicate field name registered: " + parama.a());
    a.put(parama.a(), parama);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.metadata.internal.g
 * JD-Core Version:    0.6.0
 */