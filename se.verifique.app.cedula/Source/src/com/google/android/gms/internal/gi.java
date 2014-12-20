package com.google.android.gms.internal;

import java.util.Collections;
import java.util.List;
import org.json.JSONObject;

public final class gi
{
  public final ai a;
  public final hk b;
  public final List c;
  public final int d;
  public final List e;
  public final List f;
  public final int g;
  public final long h;
  public final String i;
  public final JSONObject j;
  public final boolean k;
  public final bl l;
  public final by m;
  public final String n;
  public final bm o;
  public final bo p;
  public final long q;
  public final al r;
  public final long s;
  public final long t;
  public final long u;
  public final String v;

  public gi(ai paramai, hk paramhk, List paramList1, int paramInt1, List paramList2, List paramList3, int paramInt2, long paramLong1, String paramString1, boolean paramBoolean, bl parambl, by paramby, String paramString2, bm parambm, bo parambo, long paramLong2, al paramal, long paramLong3, long paramLong4, long paramLong5, String paramString3, JSONObject paramJSONObject)
  {
    this.a = paramai;
    this.b = paramhk;
    List localList1;
    List localList2;
    if (paramList1 != null)
    {
      localList1 = Collections.unmodifiableList(paramList1);
      this.c = localList1;
      this.d = paramInt1;
      if (paramList2 == null)
        break label175;
      localList2 = Collections.unmodifiableList(paramList2);
      label48: this.e = localList2;
      if (paramList3 == null)
        break label181;
    }
    label175: label181: for (List localList3 = Collections.unmodifiableList(paramList3); ; localList3 = null)
    {
      this.f = localList3;
      this.g = paramInt2;
      this.h = paramLong1;
      this.i = paramString1;
      this.k = paramBoolean;
      this.l = parambl;
      this.m = paramby;
      this.n = paramString2;
      this.o = parambm;
      this.p = parambo;
      this.q = paramLong2;
      this.r = paramal;
      this.s = paramLong3;
      this.t = paramLong4;
      this.u = paramLong5;
      this.v = paramString3;
      this.j = paramJSONObject;
      return;
      localList1 = null;
      break;
      localList2 = null;
      break label48;
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.gi
 * JD-Core Version:    0.6.0
 */