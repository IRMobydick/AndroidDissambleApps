package com.google.android.gms.internal;

import android.content.Context;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@ez
public final class cr
{
  public static List<String> a(JSONObject paramJSONObject, String paramString)
    throws JSONException
  {
    JSONArray localJSONArray = paramJSONObject.optJSONArray(paramString);
    if (localJSONArray != null)
    {
      ArrayList localArrayList = new ArrayList(localJSONArray.length());
      for (int i = 0; i < localJSONArray.length(); i++)
        localArrayList.add(localJSONArray.getString(i));
      return Collections.unmodifiableList(localArrayList);
    }
    return null;
  }

  public static void a(Context paramContext, String paramString1, fz paramfz, String paramString2, boolean paramBoolean, List<String> paramList)
  {
    if (paramBoolean);
    for (String str1 = "1"; ; str1 = "0")
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        String str2 = ((String)localIterator.next()).replaceAll("@gw_adlocid@", paramString2).replaceAll("@gw_adnetrefresh@", str1).replaceAll("@gw_qdata@", paramfz.vq.qi).replaceAll("@gw_sdkver@", paramString1).replaceAll("@gw_sessid@", gb.vK).replaceAll("@gw_seqnum@", paramfz.tA);
        if (paramfz.qy != null)
          str2 = str2.replaceAll("@gw_adnetid@", paramfz.qy.pX).replaceAll("@gw_allocid@", paramfz.qy.pZ);
        new gq(paramContext, paramString1, str2).start();
      }
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.cr
 * JD-Core Version:    0.6.2
 */