package com.paypal.android.sdk;

import android.os.Build;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class W extends X
{
  public final o a;
  public final boolean b;
  public String c;
  public String d;
  public String e;
  public long f;
  private String g;
  private final boolean h;
  private final String i;

  public W(L paramL, d paramd, h paramh, o paramo, String paramString1, boolean paramBoolean1, String paramString2, boolean paramBoolean2, String paramString3)
  {
    super(a.d, paramL, paramd, paramh, "Bearer " + paramString1);
    this.a = paramo;
    this.b = paramBoolean1;
    this.g = paramString2;
    this.h = paramBoolean2;
    this.i = paramString3;
  }

  public final String a()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("grant_type", "password");
    localHashMap.put("response_type", this.g);
    if ((this.g != null) && (this.g.equals("token")))
      localHashMap.put("scope_consent_context", "access_token");
    if (!R.c(this.i))
      localHashMap.put("scope", this.i);
    localHashMap.put("risk_data", R.b(aW.a().b().toString()));
    if (this.a.a())
    {
      localHashMap.put("email", R.b(this.a.b()));
      localHashMap.put("password", R.b(this.a.c()));
    }
    while (true)
    {
      localHashMap.put("remember_me", "true");
      localHashMap.put("device_name", R.b(Build.DEVICE));
      localHashMap.put("redirect_uri", R.b("urn:ietf:wg:oauth:2.0:oob"));
      return R.a(localHashMap);
      this.a.d().c();
      localHashMap.put("phone", R.b("+" + this.a.d().c() + " " + this.a.d().a()));
      localHashMap.put("pin", this.a.e());
    }
  }

  public final void b()
  {
    JSONObject localJSONObject = z();
    try
    {
      this.d = localJSONObject.getString("nonce");
      if (this.h)
      {
        this.c = localJSONObject.getString("code");
        return;
      }
      this.e = localJSONObject.getString("access_token");
      this.f = localJSONObject.getLong("expires_in");
      return;
    }
    catch (JSONException localJSONException)
    {
      b(localJSONObject);
    }
  }

  public final void c()
  {
    b(z());
  }

  public final String d()
  {
    return "{ \"access_token\": \"mock_access_token\", \"code\": \"EJhi9jOPswug9TDOv93qg4Y28xIlqPDpAoqd7biDLpeGCPvORHjP1Fh4CbFPgKMGCHejdDwe9w1uDWnjPCp1lkaFBjVmjvjpFtnr6z1YeBbmfZYqa9faQT_71dmgZhMIFVkbi4yO7hk0LBHXt_wtdsw\", \"nonce\": \"2013-09-17T21:52:45ZLGVU-xDKZfHnlNZVtyUE2w\", \"scope\": \"https://api.paypal.com/v1/payments/.* https://uri.paypal.com/services/payments/futurepayments https://api.paypal.com/v1/payments/.*\", \"token_type\": \"Bearer\",\"expires_in\":28800,\"visitor_id\":\"zVxjDBTRRNfYXdOb19-lcTblxm-6bzXGvSlP76ZiHOudKaAvoxrW8Cg5pA6EjIPpiz4zlw\" }";
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.paypal.android.sdk.W
 * JD-Core Version:    0.6.2
 */