package com.paypal.android.sdk;

import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

public final class ac extends S
{
  public String a;
  private String b;
  private String c;
  private String d;
  private int e;
  private int f;
  private String g;
  private String h;
  private Date i;

  public ac(L paramL, d paramd, h paramh, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2)
  {
    super(a.h, paramL, paramd, paramh, paramString1);
    this.a = paramString2;
    this.b = paramString3;
    if (paramString4 == null)
      throw new RuntimeException("cardNumber should not be null.  If it is, then you're probably trying to tokenize a card that's already been tokenized.");
    this.c = paramString4;
    this.d = paramString5;
    this.e = paramInt1;
    this.f = paramInt2;
  }

  public final String a()
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.accumulate("payer_id", this.a);
    localJSONObject.accumulate("cvv2", this.d);
    localJSONObject.accumulate("expire_month", Integer.valueOf(this.e));
    localJSONObject.accumulate("expire_year", Integer.valueOf(this.f));
    localJSONObject.accumulate("number", this.c);
    localJSONObject.accumulate("type", this.b);
    return localJSONObject.toString();
  }

  public final void b()
  {
    JSONObject localJSONObject = z();
    try
    {
      this.g = localJSONObject.getString("id");
      String str = localJSONObject.getString("number");
      if ((this.h == null) || (!this.h.endsWith(str.substring(-4 + str.length()))))
        this.h = str;
      this.i = v.a(localJSONObject.getString("valid_until"));
      return;
    }
    catch (JSONException localJSONException)
    {
      c();
    }
  }

  public final void c()
  {
    a(z());
  }

  public final String d()
  {
    return "{\"id\":\"CARD-50Y58962PH1899901KFFBSDA\",\"valid_until\":\"2016-03-19T00:00:00.000Z\",\"state\":\"ok\",\"type\":\"visa\",\"number\":\"xxxxxxxxxxxx" + this.c.substring(-4 + this.c.length()) + "\",\"expire_month\":\"" + this.e + "\",\"expire_year\":\"" + this.f + "\",\"links\":[" + "{\"href\":\"https://api.sandbox.paypal.com/v1/vault/credit-card/CARD-50Y58962PH1899901KFFBSDA\"," + "\"rel\":\"self\",\"method\":\"GET\"" + "}]" + "}";
  }

  public final String f()
  {
    return this.g;
  }

  public final String g()
  {
    return this.h;
  }

  public final Date h()
  {
    return this.i;
  }

  public final String i()
  {
    return this.b;
  }

  public final int j()
  {
    return this.e;
  }

  public final int k()
  {
    return this.f;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.paypal.android.sdk.ac
 * JD-Core Version:    0.6.2
 */