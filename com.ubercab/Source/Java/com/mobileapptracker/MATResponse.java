package com.mobileapptracker;

import org.json.JSONObject;

public abstract interface MATResponse
{
  public abstract void didFailWithError(JSONObject paramJSONObject);

  public abstract void didSucceedWithData(JSONObject paramJSONObject);

  public abstract void enqueuedActionWithRefId(String paramString);
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.mobileapptracker.MATResponse
 * JD-Core Version:    0.6.2
 */