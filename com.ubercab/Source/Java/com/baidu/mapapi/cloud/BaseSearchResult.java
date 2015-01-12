package com.baidu.mapapi.cloud;

import org.json.JSONException;
import org.json.JSONObject;

public abstract class BaseSearchResult
{
  public static final int STATUS_CODE_AK_ERROR = 5;
  public static final int STATUS_CODE_PARAM_ERROR = 2;
  public static final int STATUS_CODE_PERMISSION_AND_QUOTA_ERROR = 201;
  public static final int STATUS_CODE_PERMISSION_ERROR = 3;
  public static final int STATUS_CODE_QUOTA_ERROR = 4;
  public static final int STATUS_CODE_SECURITY_CODE_ERROR = 102;
  public static final int STATUS_CODE_SERVER_ERROR = 1;
  public static final int STATUS_CODE_SERVICE_DISABLED = 101;
  public static final int STATUS_CODE_SUCCEED;
  public int size;
  public int status = -1;
  public int total;

  void a(JSONObject paramJSONObject)
    throws JSONException
  {
    this.status = paramJSONObject.optInt("status");
    if (this.status >= 202)
      this.status = 201;
    this.size = paramJSONObject.optInt("size");
    this.total = paramJSONObject.optInt("total");
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.mapapi.cloud.BaseSearchResult
 * JD-Core Version:    0.6.2
 */