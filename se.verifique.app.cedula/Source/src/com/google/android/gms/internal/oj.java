package com.google.android.gms.internal;

import android.content.Context;
import java.util.HashSet;

final class oj
{
  public final oh a;
  public final String b;
  public final Context c;
  public final mw d;
  public final ev e;
  public u f;
  public gr g;
  public al h;
  public gi i;
  public gk j;
  public ae k;
  public ej l;
  public eb m;
  public dw n;
  public gp o = null;
  public boolean p = false;
  private HashSet q = null;

  public oj(Context paramContext, al paramal, String paramString, ev paramev)
  {
    if (paramal.f)
      this.a = null;
    while (true)
    {
      this.h = paramal;
      this.b = paramString;
      this.c = paramContext;
      this.e = paramev;
      this.d = new mw(new oi(this));
      return;
      this.a = new oh(paramContext);
      this.a.setMinimumWidth(paramal.h);
      this.a.setMinimumHeight(paramal.e);
      this.a.setVisibility(4);
    }
  }

  public HashSet a()
  {
    return this.q;
  }

  public void a(HashSet paramHashSet)
  {
    this.q = paramHashSet;
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.oj
 * JD-Core Version:    0.6.0
 */