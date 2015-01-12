package com.paypal.android.sdk;

import java.util.HashMap;
import java.util.List;

public final class T extends X
{
  public String a;
  private List b;
  private String c;

  public T(L paramL, d paramd, h paramh, String paramString1, String paramString2, String paramString3, List paramList)
  {
    super(a.e, paramL, paramd, paramh, "Bearer " + paramString3);
    this.a = paramString1;
    this.c = paramString2;
    this.b = paramList;
  }

  public final String a()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("code", this.a);
    localHashMap.put("nonce", this.c);
    localHashMap.put("scope", R.a(this.b, " "));
    return R.a(localHashMap);
  }

  public final void b()
  {
  }

  public final void c()
  {
    b(z());
  }

  public final String d()
  {
    return "{\"code\":\"EOTHbvqh0vwM2ldM2QIXbjVw0hZNuZEJLqdWmfTBLLSvGfqgyy9GKvjGybIxyGMd7gHXCXVtymqFQHS-J-4-Ir6u2LUVVdyLKonwTtdFw9qhBaMb4NZuZHKS0bGxdZlRAB3_Fk8HX2r3z8j03xScx4M\",\"scope\":\"https://uri.paypal.com/services/payments/futurepayments\"}";
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.paypal.android.sdk.T
 * JD-Core Version:    0.6.2
 */