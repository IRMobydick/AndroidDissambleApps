package com.paypal.android.sdk;

import com.paypal.android.sdk.payments.PayPalService;
import java.util.HashMap;
import java.util.Map;

public final class bt
{
  private static final String a = PayPalService.class.getSimpleName();
  private static Map b = new HashMap();

  public static bm a(String paramString)
  {
    bm localbm = (bm)b.get(paramString);
    new StringBuilder("getLoginAccessToken(").append(paramString).append(") returns String:").append(localbm).toString();
    return localbm;
  }

  public static void a(bm parambm, String paramString)
  {
    b.put(paramString, parambm);
    new StringBuilder("setLoginAccessToken(").append(parambm).append(",").append(paramString).append(")").toString();
  }

  public static void b(String paramString)
  {
    b.remove(paramString);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.paypal.android.sdk.bt
 * JD-Core Version:    0.6.2
 */