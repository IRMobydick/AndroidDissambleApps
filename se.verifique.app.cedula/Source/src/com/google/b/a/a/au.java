package com.google.b.a.a;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public class au
{
  private Map a = new HashMap();

  public static au a(String paramString, Boolean paramBoolean)
  {
    am.a().a(an.H);
    au localau = new au();
    localau.a("&t", "exception");
    localau.a("&exd", paramString);
    localau.a("&exf", a(paramBoolean));
    return localau;
  }

  public static au a(String paramString1, String paramString2, String paramString3, Long paramLong)
  {
    am.a().a(an.Y);
    au localau = new au();
    localau.a("&t", "event");
    localau.a("&ec", paramString1);
    localau.a("&ea", paramString2);
    localau.a("&el", paramString3);
    if (paramLong == null);
    for (String str = null; ; str = Long.toString(paramLong.longValue()))
    {
      localau.a("&ev", str);
      return localau;
    }
  }

  static String a(Boolean paramBoolean)
  {
    String str;
    if (paramBoolean == null)
      str = null;
    while (true)
    {
      return str;
      if (paramBoolean.booleanValue())
      {
        str = "1";
        continue;
      }
      str = "0";
    }
  }

  public au a(String paramString)
  {
    am.a().a(an.d);
    String str = bj.b(paramString);
    if (TextUtils.isEmpty(str));
    while (true)
    {
      return this;
      Map localMap = bj.a(str);
      a("&cc", (String)localMap.get("utm_content"));
      a("&cm", (String)localMap.get("utm_medium"));
      a("&cn", (String)localMap.get("utm_campaign"));
      a("&cs", (String)localMap.get("utm_source"));
      a("&ck", (String)localMap.get("utm_term"));
      a("&ci", (String)localMap.get("utm_id"));
      a("&gclid", (String)localMap.get("gclid"));
      a("&dclid", (String)localMap.get("dclid"));
      a("&gmob_t", (String)localMap.get("gmob_t"));
    }
  }

  public au a(String paramString1, String paramString2)
  {
    am.a().a(an.a);
    if (paramString1 != null)
      this.a.put(paramString1, paramString2);
    while (true)
    {
      return this;
      ar.d(" MapBuilder.set() called with a null paramName.");
    }
  }

  public Map a()
  {
    return new HashMap(this.a);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.b.a.a.au
 * JD-Core Version:    0.6.0
 */