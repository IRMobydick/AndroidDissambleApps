package com.paypal.android.sdk;

import java.math.BigDecimal;
import java.util.Map;

public final class Y extends Z
{
  public Y(L paramL, d paramd, h paramh, String paramString1, String paramString2, String paramString3, q paramq, Map paramMap, ak[] paramArrayOfak, String paramString4, boolean paramBoolean, String paramString5, String paramString6, String paramString7)
  {
    super(a.g, paramL, paramd, paramh, paramString1, paramString2, paramString3, paramq, paramMap, paramArrayOfak, paramString4, paramBoolean, paramString5, paramString6, paramString7);
  }

  public final String d()
  {
    String str = l.a(n().a().doubleValue(), n().b());
    return "{\"create_time\": \"2014-02-12T22:29:49Z\", \"id\": \"PAY-1CH415761F1235919KIQMTGY\", \"intent\": \"sale\", \"links\": [{\"href\": \"https://stage2p1197.qa.paypal.com:11888/v1/payments/payment/PAY-1CH415761F1235919KIQMTGY\",\"method\": \"GET\", \"rel\": \"self\"}], \"payer\": {\"payer_info\": {\"email\": \"tnm10@paypal.com\", \"first_name\": \"George\", \"last_name\": \"Martin\", \"payer_id\": \"QLR7PGAJCMCA8\"}, \"payment_method\": \"paypal\"}, \"state\": \"approved\", \"transactions\": [{\"amount\": {\"currency\": \"USD\", \"details\": {\"subtotal\": \"" + str + "\"}, " + "\"total\": \"" + str + "\"}, " + "\"description\": \"Awesome sauce.\", \"related_resources\": [" + "{\"sale\": {" + "\"amount\": {\"currency\": \"USD\", " + "\"total\": \"" + str + "\"}, " + "\"create_time\": \"2013-08-30T16:34:35Z\", \"id\": \"86118515DF398913H\", " + "\"links\": [{" + "\"href\": \"https://stage2p1197.qa.paypal.com:11888/v1/payments/sale/86118515DF398913H\", \"method\": \"GET\", " + "\"rel\": \"self\"}, " + "{\"href\": \"https://stage2p1197.qa.paypal.com:11888/v1/payments/sale/86118515DF398913H/refund\", " + "\"method\": \"POST\", \"rel\": \"refund\"" + "}, {" + "\"href\": \"https://stage2p1197.qa.paypal.com:11888/v1/payments/payment/PAY-1CH415761F1235919KIQMTGY\",\"method\": \"GET\", " + "\"rel\": \"parent_payment\"}" + "], \"parent_payment\": \"PAY-1CH415761F1235919KIQMTGY\", " + "\"state\": \"pending\", \"update_time\": \"2013-08-30T16:34:38Z\"" + "}}" + "]}" + "], \"update_time\": \"2013-08-30T16:34:38Z\"" + "}";
  }

  protected final String l()
  {
    return "paypal";
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.paypal.android.sdk.Y
 * JD-Core Version:    0.6.2
 */