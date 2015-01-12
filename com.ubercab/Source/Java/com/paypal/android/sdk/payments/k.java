package com.paypal.android.sdk.payments;

import com.paypal.android.sdk.J;
import com.paypal.android.sdk.R;
import com.paypal.android.sdk.b;
import com.paypal.android.sdk.bD;
import com.paypal.android.sdk.bp;
import com.paypal.android.sdk.bs;
import com.paypal.android.sdk.c;
import java.util.Map;

final class k extends h
{
  public k(PayPalService paramPayPalService)
  {
    super(new ac(paramPayPalService));
  }

  protected final void a(String paramString, Map paramMap)
  {
    if (!a().a().a.c())
    {
      a().a().a = new bp();
      paramMap.put("v49", paramString);
      paramMap.put("v51", b.a().c().d());
      paramMap.put("v52", bD.a + " " + bD.d);
      paramMap.put("v53", bD.e);
    }
    R localR = new R(a().a().a.b(), paramMap, bD.c, bD.b, true);
    a().c().a(localR, null);
  }

  protected final String b()
  {
    return "mpl";
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.paypal.android.sdk.payments.k
 * JD-Core Version:    0.6.2
 */