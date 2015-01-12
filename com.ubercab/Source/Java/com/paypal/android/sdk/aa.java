package com.paypal.android.sdk;

import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class aa extends X
{
  public String a;
  public long b;

  public aa(String paramString1, L paramL, d paramd, h paramh, String paramString2)
  {
  }

  public final String a()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("response_type", "token");
    localHashMap.put("grant_type", "client_credentials");
    localHashMap.put("request_authn_mechanism", "true");
    localHashMap.put("device_info", n.a().toString());
    localHashMap.put("app_info", i.a().toString());
    localHashMap.put("risk_data", R.b(aW.a().b().toString()));
    return R.a(localHashMap);
  }

  public final void b()
  {
    JSONObject localJSONObject = z();
    try
    {
      this.a = localJSONObject.getString("access_token");
      localJSONObject.getString("app_id");
      this.b = localJSONObject.getLong("expires_in");
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
    return "{\"scope\":\"https://api.paypal.com/v1/payments/.* https://api.paypal.com/v1/vault/credit-card https://api.paypal.com/v1/vault/credit-card/.* openid\",\"access_token\":\"iPVzWUwTo1fEG6n.2sTZCahv8wa2b8uGpBs1KZ-6XxA\",\"token_type\":\"Bearer\",\"app_id\":\"APP-10NHR005R4826426K\",\"expires_in\":900}";
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.paypal.android.sdk.aa
 * JD-Core Version:    0.6.2
 */