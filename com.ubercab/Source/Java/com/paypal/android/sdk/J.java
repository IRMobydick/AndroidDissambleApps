package com.paypal.android.sdk;

import android.os.Message;
import java.util.List;
import java.util.Map;

public class J
  implements L
{
  private d a;
  private h b;
  private K c;
  private g d;
  private final A e = new A();
  private H f;
  private long g = 0L;

  static
  {
    J.class.getSimpleName();
  }

  public J(g paramg, d paramd, h paramh, boolean paramBoolean, int paramInt)
  {
    this.d = paramg;
    this.a = paramd;
    this.b = paramh;
    this.c = new K(this);
    String str1 = paramg.a();
    String str2 = this.a.d();
    if (R.a(str2))
      throw new RuntimeException("User agent not set correctly.  It must be set to a non-null, non-empty string in the coreEnvironment.");
    this.f = new H(str1, paramd, this, 90000, str2, Q.a(this.b, paramd), paramBoolean, 500);
  }

  private void b(al paramal)
  {
    this.f.a(paramal);
  }

  public final String a(a parama)
  {
    if ((this.d != null) && (this.d.b() != null))
      return (String)this.d.b().get(parama);
    return null;
  }

  public final void a()
  {
    this.f.a();
  }

  public final void a(C paramC)
  {
    this.e.a(paramC);
  }

  public final void a(R paramR, String paramString)
  {
    if (paramR.e)
    {
      b(new P(this, this.a, this.b, paramR));
      return;
    }
    b(new O(this, this.a, this.b, paramR, paramString));
  }

  public final void a(al paramal)
  {
    if (!paramal.e())
    {
      Message localMessage = new Message();
      localMessage.what = 2;
      localMessage.obj = paramal;
      this.c.sendMessage(localMessage);
    }
  }

  public final void a(o paramo, String paramString1, boolean paramBoolean1, String paramString2, boolean paramBoolean2, String paramString3)
  {
    b(new W(this, this.a, this.b, paramo, paramString1, paramBoolean1, paramString2, paramBoolean2, paramString3));
  }

  public final void a(String paramString)
  {
    b(new aa(this.d.a(), this, this.a, this.b, paramString));
  }

  public final void a(String paramString1, String paramString2)
  {
    b(new V(this, this.a, this.b, paramString1, paramString2));
  }

  public final void a(String paramString1, String paramString2, String paramString3, q paramq, Map paramMap, ak[] paramArrayOfak, String paramString4, boolean paramBoolean, String paramString5, String paramString6, String paramString7)
  {
    b(new Y(this, this.a, this.b, paramString1, paramString2, null, paramq, paramMap, paramArrayOfak, paramString4, paramBoolean, paramString5, paramString6, paramString7));
  }

  public final void a(String paramString1, String paramString2, String paramString3, String paramString4, q paramq, Map paramMap, ak[] paramArrayOfak, String paramString5, boolean paramBoolean, String paramString6, String paramString7, String paramString8)
  {
    b(new U(this, this.a, this.b, paramString1, paramString2, paramString3, paramString4, paramq, paramMap, paramArrayOfak, paramString5, paramBoolean, paramString6, paramString7, paramString8));
  }

  public final void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2)
  {
    b(new ac(this, this.a, this.b, paramString1, paramString2, paramString3, paramString4, paramString5, paramInt1, paramInt2));
  }

  public final void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, String paramString6, q paramq, Map paramMap, ak[] paramArrayOfak, String paramString7, boolean paramBoolean, String paramString8, String paramString9, String paramString10)
  {
    b(new U(this, this.a, this.b, paramString1, paramString2, paramString3, paramString4, paramString5, paramInt1, paramInt2, null, paramq, paramMap, paramArrayOfak, paramString7, paramBoolean, paramString8, paramString9, paramString10));
  }

  public final void a(String paramString1, String paramString2, String paramString3, String paramString4, List paramList)
  {
    b(new T(this, this.a, this.b, paramString2, paramString3, paramString4, paramList));
  }

  public final String b()
  {
    return this.d.a();
  }

  public final void b(C paramC)
  {
    this.e.b(paramC);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.paypal.android.sdk.J
 * JD-Core Version:    0.6.2
 */