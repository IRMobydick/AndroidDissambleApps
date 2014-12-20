package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class bl
{
  public final String a;
  public final String b;
  public final List c;
  public final String d;
  public final String e;
  public final List f;
  public final String g;

  public bl(JSONObject paramJSONObject)
  {
    this.b = paramJSONObject.getString("id");
    JSONArray localJSONArray = paramJSONObject.getJSONArray("adapters");
    ArrayList localArrayList = new ArrayList(localJSONArray.length());
    for (int i = 0; i < localJSONArray.length(); i++)
      localArrayList.add(localJSONArray.getString(i));
    this.c = Collections.unmodifiableList(localArrayList);
    this.d = paramJSONObject.optString("allocation_id", null);
    this.f = bt.a(paramJSONObject, "imp_urls");
    JSONObject localJSONObject1 = paramJSONObject.optJSONObject("ad");
    String str2;
    JSONObject localJSONObject2;
    if (localJSONObject1 != null)
    {
      str2 = localJSONObject1.toString();
      this.a = str2;
      localJSONObject2 = paramJSONObject.optJSONObject("data");
      if (localJSONObject2 == null)
        break label175;
    }
    label175: for (String str3 = localJSONObject2.toString(); ; str3 = null)
    {
      this.g = str3;
      if (localJSONObject2 != null)
        str1 = localJSONObject2.optString("class_name");
      this.e = str1;
      return;
      str2 = null;
      break;
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.bl
 * JD-Core Version:    0.6.0
 */