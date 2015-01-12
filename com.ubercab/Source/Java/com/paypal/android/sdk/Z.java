package com.paypal.android.sdk;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class Z extends S
{
  public String a;
  private q b;
  private Map c;
  private ak[] d;
  private String e;
  private boolean f;
  private String g;
  private String h;
  private String i;
  private String j;
  private String k;

  public Z(a parama, L paramL, d paramd, h paramh, String paramString1, String paramString2, String paramString3, q paramq, Map paramMap, ak[] paramArrayOfak, String paramString4, boolean paramBoolean, String paramString5, String paramString6, String paramString7)
  {
    super(parama, paramL, paramd, paramh, paramString1);
    this.a = paramString3;
    this.b = paramq;
    this.c = paramMap;
    this.d = paramArrayOfak;
    this.e = paramString4;
    this.f = paramBoolean;
    this.g = paramString7;
    if (R.c(this.g))
      this.g = "sale";
    this.g = this.g.toLowerCase(Locale.US);
    a("PayPal-Request-Id", paramString2);
    if (R.d(paramString5))
      a("PayPal-Partner-Attribution-Id", paramString5);
    if (R.d(paramString6))
      a("Paypal-Application-Correlation-Id", paramString6);
  }

  private static String a(JSONArray paramJSONArray)
  {
    if (paramJSONArray == null);
    while (true)
    {
      return null;
      try
      {
        JSONObject localJSONObject1 = paramJSONArray.getJSONObject(0);
        if (localJSONObject1 != null)
        {
          JSONArray localJSONArray = localJSONObject1.getJSONArray("related_resources");
          if (localJSONArray != null)
          {
            JSONObject localJSONObject2 = localJSONArray.getJSONObject(0);
            if (localJSONObject2 != null)
            {
              JSONObject localJSONObject3 = localJSONObject2.getJSONObject("authorization");
              if (localJSONObject3 != null)
              {
                String str = localJSONObject3.optString("id");
                return str;
              }
            }
          }
        }
      }
      catch (JSONException localJSONException)
      {
      }
    }
    return null;
  }

  public final String a()
  {
    JSONObject localJSONObject1 = new JSONObject();
    localJSONObject1.accumulate("intent", this.g);
    JSONObject localJSONObject2 = new JSONObject();
    JSONArray localJSONArray1 = k();
    if (localJSONArray1 != null)
      localJSONObject2.accumulate("funding_instruments", localJSONArray1);
    localJSONObject2.accumulate("payment_method", l());
    localJSONObject1.accumulate("payer", localJSONObject2);
    q localq = this.b;
    JSONObject localJSONObject3 = new JSONObject();
    localJSONObject3.accumulate("currency", localq.b().getCurrencyCode());
    localJSONObject3.accumulate("total", localq.a().toPlainString());
    Object localObject;
    if ((this.c != null) && (!this.c.isEmpty()))
    {
      if ((this.c != null) && (!this.c.isEmpty()))
        break label275;
      localObject = null;
    }
    while (true)
    {
      localJSONObject3.accumulate("details", localObject);
      JSONObject localJSONObject4 = new JSONObject();
      localJSONObject4.accumulate("amount", localJSONObject3);
      localJSONObject4.accumulate("description", this.e);
      if ((this.d != null) && (this.d.length > 0))
      {
        JSONObject localJSONObject5 = new JSONObject();
        localJSONObject5.accumulate("items", ak.a(this.d));
        localJSONObject4.accumulate("item_list", localJSONObject5);
      }
      JSONArray localJSONArray2 = new JSONArray();
      localJSONArray2.put(localJSONObject4);
      localJSONObject1.accumulate("transactions", localJSONArray2);
      return localJSONObject1.toString();
      label275: localObject = new JSONObject();
      if (this.c.containsKey("shipping"))
        ((JSONObject)localObject).accumulate("shipping", this.c.get("shipping"));
      if (this.c.containsKey("subtotal"))
        ((JSONObject)localObject).accumulate("subtotal", this.c.get("subtotal"));
      if (this.c.containsKey("tax"))
        ((JSONObject)localObject).accumulate("tax", this.c.get("tax"));
    }
  }

  public final void b()
  {
    JSONObject localJSONObject = z();
    try
    {
      this.h = localJSONObject.getString("state");
      this.i = localJSONObject.optString("id");
      this.j = localJSONObject.optString("create_time");
      this.k = a(localJSONObject.getJSONArray("transactions"));
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

  protected JSONArray k()
  {
    return null;
  }

  protected abstract String l();

  public final boolean m()
  {
    return this.f;
  }

  protected final q n()
  {
    return this.b;
  }

  public final String o()
  {
    return this.h;
  }

  public final String p()
  {
    return this.i;
  }

  public final String q()
  {
    return this.g;
  }

  public final String r()
  {
    return this.j;
  }

  public final String s()
  {
    return this.k;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.paypal.android.sdk.Z
 * JD-Core Version:    0.6.2
 */