package com.paypal.android.sdk;

import java.math.BigDecimal;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class U extends Z
{
  private String b;
  private String c;
  private String d;
  private int e;
  private int f;
  private String g;

  public U(L paramL, d paramd, h paramh, String paramString1, String paramString2, String paramString3, String paramString4, q paramq, Map paramMap, ak[] paramArrayOfak, String paramString5, boolean paramBoolean, String paramString6, String paramString7, String paramString8)
  {
    super(a.f, paramL, paramd, paramh, paramString1, paramString2, paramString4, paramq, paramMap, paramArrayOfak, paramString5, paramBoolean, paramString6, paramString7, paramString8);
    this.g = paramString3;
  }

  public U(L paramL, d paramd, h paramh, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, String paramString6, q paramq, Map paramMap, ak[] paramArrayOfak, String paramString7, boolean paramBoolean, String paramString8, String paramString9, String paramString10)
  {
    super(a.f, paramL, paramd, paramh, paramString1, paramString2, paramString6, paramq, paramMap, paramArrayOfak, paramString7, paramBoolean, paramString8, paramString9, paramString10);
    this.b = paramString3;
    this.c = paramString4;
    this.d = paramString5;
    this.e = paramInt1;
    this.f = paramInt2;
  }

  public final String d()
  {
    String str1 = l.a(n().a().doubleValue(), n().b());
    StringBuilder localStringBuilder = new StringBuilder("{\"id\":\"PAY-6RV70583SB702805EKEYSZ6Y\",\"intent\":\"sale\",\"create_time\": \"2014-02-12T22:29:49Z\",\"update_time\": \"2014-02-12T22:29:50Z\",\"payer\":{\"funding_instruments\":[{\"credit_card\":{\"expire_month\":\"").append(this.e).append("\",\"expire_year\":\"").append(this.f).append("\",\"number\":\"");
    if (this.b != null);
    for (String str2 = this.c.substring(-4 + this.c.length()); ; str2 = "xxxxxxxxxx1111")
      return str2 + "\",\"type\":\"VISA\"}" + "}]," + "\"payment_method\":\"credit_card\"}," + "\"state\":\"approved\",\"transactions\":" + "[{" + "\"amount\":{\"currency\":\"USD\"," + "\"total\":\"" + str1 + "\"},\"description\":\"I am a sanity check payment.\"," + "\"item_list\":{},\"payee\":" + "{\"merchant_id\":\"PKKPTJKL75YDS\"},\"related_resources\":" + "[{\"sale\":{\"amount\":{\"currency\":\"USD\",\"total\":\"" + str1 + "\"},\"id\":\"0EW02334X44816642\"," + "\"parent_payment\":\"PAY-123456789012345689\",\"state\":\"completed\"}}]}]}";
  }

  public final String f()
  {
    return this.c;
  }

  public final String g()
  {
    return this.b;
  }

  public final String h()
  {
    return this.d;
  }

  public final int i()
  {
    return this.e;
  }

  public final int j()
  {
    return this.f;
  }

  protected final JSONArray k()
  {
    JSONArray localJSONArray = new JSONArray();
    if (this.b != null)
    {
      JSONObject localJSONObject1 = new JSONObject();
      localJSONObject1.accumulate("cvv2", this.d);
      localJSONObject1.accumulate("expire_month", Integer.valueOf(this.e));
      localJSONObject1.accumulate("expire_year", Integer.valueOf(this.f));
      localJSONObject1.accumulate("number", this.c);
      localJSONObject1.accumulate("type", this.b);
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.accumulate("credit_card", localJSONObject1);
      localJSONArray.put(localJSONObject2);
      return localJSONArray;
    }
    JSONObject localJSONObject3 = new JSONObject();
    localJSONObject3.accumulate("payer_id", this.a);
    localJSONObject3.accumulate("credit_card_id", this.g);
    JSONObject localJSONObject4 = new JSONObject();
    localJSONObject4.accumulate("credit_card_token", localJSONObject3);
    localJSONArray.put(localJSONObject4);
    return localJSONArray;
  }

  protected final String l()
  {
    return "credit_card";
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.paypal.android.sdk.U
 * JD-Core Version:    0.6.2
 */