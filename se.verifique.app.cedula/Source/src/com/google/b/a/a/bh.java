package com.google.b.a.a;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public class bh
{
  private final String a;
  private final bi b;
  private final Map c = new HashMap();
  private ba d;
  private final j e;
  private final bb f;
  private final i g;

  bh(String paramString1, String paramString2, bi parambi)
  {
    this(paramString1, paramString2, parambi, j.a(), bb.a(), i.a(), new bc());
  }

  bh(String paramString1, String paramString2, bi parambi, j paramj, bb parambb, i parami, ba paramba)
  {
    if (TextUtils.isEmpty(paramString1))
      throw new IllegalArgumentException("Tracker name cannot be empty.");
    this.a = paramString1;
    this.b = parambi;
    this.c.put("&tid", paramString2);
    this.c.put("useSecure", "1");
    this.e = paramj;
    this.f = parambb;
    this.g = parami;
    this.d = paramba;
  }

  public void a(String paramString1, String paramString2)
  {
    am.a().a(an.k);
    if (paramString2 == null)
      this.c.remove(paramString1);
    while (true)
    {
      return;
      this.c.put(paramString1, paramString2);
    }
  }

  public void a(Map paramMap)
  {
    am.a().a(an.l);
    HashMap localHashMap = new HashMap();
    localHashMap.putAll(this.c);
    if (paramMap != null)
      localHashMap.putAll(paramMap);
    if (TextUtils.isEmpty((CharSequence)localHashMap.get("&tid")))
    {
      Object[] arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = "&tid";
      ar.d(String.format("Missing tracking id (%s) parameter.", arrayOfObject2));
    }
    String str = (String)localHashMap.get("&t");
    if (TextUtils.isEmpty(str))
    {
      Object[] arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = "&t";
      ar.d(String.format("Missing hit type (%s) parameter.", arrayOfObject1));
      str = "";
    }
    if ((!str.equals("transaction")) && (!str.equals("item")) && (!this.d.a()))
      ar.d("Too many hits sent too quickly, rate limiting invoked.");
    while (true)
    {
      return;
      this.b.a(localHashMap);
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.b.a.a.bh
 * JD-Core Version:    0.6.0
 */