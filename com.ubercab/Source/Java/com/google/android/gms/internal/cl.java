package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@ez
public final class cl
{
  public final String pW;
  public final String pX;
  public final List<String> pY;
  public final String pZ;
  public final String qa;
  public final List<String> qb;
  public final String qc;

  public cl(JSONObject paramJSONObject)
    throws JSONException
  {
    this.pX = paramJSONObject.getString("id");
    JSONArray localJSONArray = paramJSONObject.getJSONArray("adapters");
    ArrayList localArrayList = new ArrayList(localJSONArray.length());
    for (int i = 0; i < localJSONArray.length(); i++)
      localArrayList.add(localJSONArray.getString(i));
    this.pY = Collections.unmodifiableList(localArrayList);
    this.pZ = paramJSONObject.optString("allocation_id", null);
    this.qb = cr.a(paramJSONObject, "imp_urls");
    JSONObject localJSONObject1 = paramJSONObject.optJSONObject("ad");
    String str1;
    JSONObject localJSONObject2;
    if (localJSONObject1 != null)
    {
      str1 = localJSONObject1.toString();
      this.pW = str1;
      localJSONObject2 = paramJSONObject.optJSONObject("data");
      if (localJSONObject2 == null)
        break label175;
    }
    label175: for (String str2 = localJSONObject2.toString(); ; str2 = null)
    {
      this.qc = str2;
      String str3 = null;
      if (localJSONObject2 != null)
        str3 = localJSONObject2.optString("class_name");
      this.qa = str3;
      return;
      str1 = null;
      break;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.cl
 * JD-Core Version:    0.6.2
 */