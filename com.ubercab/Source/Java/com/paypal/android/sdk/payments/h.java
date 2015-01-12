package com.paypal.android.sdk.payments;

import com.paypal.android.sdk.R;
import com.paypal.android.sdk.bD;
import com.paypal.android.sdk.bE;
import com.paypal.android.sdk.br;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

abstract class h
  implements l
{
  private ac a;

  protected h(ac paramac)
  {
    this.a = paramac;
  }

  private String a(bE parambE, boolean paramBoolean)
  {
    String str = bD.b + ":" + b() + ":" + parambE.a();
    if (paramBoolean)
      str = str + "|error";
    return str;
  }

  protected final ac a()
  {
    return this.a;
  }

  public final void a(bE parambE, boolean paramBoolean, String paramString1, String paramString2, String paramString3)
  {
    String str1 = br.d().c().toString();
    HashMap localHashMap = new HashMap();
    boolean bool;
    String str2;
    if (!R.a(paramString1))
    {
      bool = true;
      localHashMap.put("gn", a(parambE, bool));
      localHashMap.put("v31", a(parambE, bool));
      str2 = a(parambE, bool) + ":" + parambE.a(this.a.d(), paramBoolean);
      if (!bool)
        break label253;
    }
    label253: for (String str3 = str2 + "|error"; ; str3 = str2)
    {
      localHashMap.put("c25", str3);
      localHashMap.put("v25", "D=c25");
      localHashMap.put("c37", bD.a + "::");
      localHashMap.put("c50", str1);
      localHashMap.put("c35", "out");
      a(localHashMap, parambE, paramString2, paramString3);
      if (paramString1 != null)
        localHashMap.put("c29", paramString1);
      a("2.2.2", localHashMap);
      return;
      bool = false;
      break;
    }
  }

  abstract void a(String paramString, Map paramMap);

  protected void a(Map paramMap, bE parambE, String paramString1, String paramString2)
  {
  }

  protected abstract String b();
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.paypal.android.sdk.payments.h
 * JD-Core Version:    0.6.2
 */