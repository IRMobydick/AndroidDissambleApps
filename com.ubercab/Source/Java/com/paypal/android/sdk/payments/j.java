package com.paypal.android.sdk.payments;

import com.paypal.android.sdk.J;
import com.paypal.android.sdk.R;
import com.paypal.android.sdk.b;
import com.paypal.android.sdk.bB;
import com.paypal.android.sdk.bD;
import com.paypal.android.sdk.bE;
import com.paypal.android.sdk.bm;
import com.paypal.android.sdk.bs;
import com.paypal.android.sdk.c;
import com.paypal.android.sdk.i;
import java.util.Map;

final class j extends h
{
  public j(PayPalService paramPayPalService)
  {
    super(new ac(paramPayPalService));
  }

  protected final void a(String paramString, Map paramMap)
  {
    if (!a().a().b.c())
      a().a().b = new bB();
    paramMap.put("v49", paramString);
    paramMap.put("v51", b.a().c().d());
    paramMap.put("v52", bD.a + " " + bD.d);
    paramMap.put("v53", bD.e);
    paramMap.put("clid", a().b());
    paramMap.put("apid", i.b() + "|" + paramString + "|" + a().f());
    R localR = new R(a().a().b.b(), paramMap, bD.c, bD.b, false);
    bs localbs = a().a();
    String str = null;
    if (localbs != null)
    {
      bm localbm = a().a().c;
      str = null;
      if (localbm != null)
        str = a().a().c.b();
    }
    a().c().a(localR, str);
  }

  protected final void a(Map paramMap, bE parambE, String paramString1, String paramString2)
  {
    paramMap.put("g", a().e());
    paramMap.put("vers", bD.a + ":" + a().d() + ":");
    paramMap.put("srce", "msdk");
    paramMap.put("sv", "mobile");
    paramMap.put("bchn", "msdk");
    paramMap.put("adte", "FALSE");
    paramMap.put("bzsr", "mobile");
    if (R.d(paramString1))
      paramMap.put("calc", paramString1);
    if (R.d(paramString2))
      paramMap.put("prid", paramString2);
    if (parambE.b());
    for (String str = "cl"; ; str = "im")
    {
      paramMap.put("e", str);
      return;
    }
  }

  protected final String b()
  {
    return "msdk";
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.paypal.android.sdk.payments.j
 * JD-Core Version:    0.6.2
 */