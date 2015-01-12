package com.google.android.gms.internal;

import org.json.JSONException;
import org.json.JSONObject;

@ez
public class bq
{
  private u pw;
  private ah px;
  private JSONObject py;

  public bq(u paramu, ah paramah, JSONObject paramJSONObject)
  {
    this.pw = paramu;
    this.px = paramah;
    this.py = paramJSONObject;
  }

  public void as()
  {
    this.pw.aj();
  }

  public void b(String paramString, int paramInt)
  {
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      localJSONObject1.put("asset", paramInt);
      localJSONObject1.put("template", paramString);
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("ad", this.py);
      localJSONObject2.put("click", localJSONObject1);
      this.px.a("google.afma.nativeAds.handleClick", localJSONObject2);
      return;
    }
    catch (JSONException localJSONException)
    {
      gs.b("Unable to create click JSON.", localJSONException);
    }
  }

  public static abstract interface a
  {
    public abstract void a(bq parambq);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.bq
 * JD-Core Version:    0.6.2
 */