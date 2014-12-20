package com.google.android.gms.internal;

import android.content.Context;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class bt
{
  public static List a(JSONObject paramJSONObject, String paramString)
  {
    JSONArray localJSONArray = paramJSONObject.optJSONArray(paramString);
    ArrayList localArrayList;
    if (localJSONArray != null)
    {
      localArrayList = new ArrayList(localJSONArray.length());
      for (int i = 0; i < localJSONArray.length(); i++)
        localArrayList.add(localJSONArray.getString(i));
    }
    for (List localList = Collections.unmodifiableList(localArrayList); ; localList = null)
      return localList;
  }

  public static void a(Context paramContext, String paramString1, gi paramgi, String paramString2, boolean paramBoolean, List paramList)
  {
    if (paramBoolean);
    for (String str1 = "1"; ; str1 = "0")
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        String str2 = ((String)localIterator.next()).replaceAll("@gw_adlocid@", paramString2).replaceAll("@gw_adnetrefresh@", str1).replaceAll("@gw_qdata@", paramgi.o.f).replaceAll("@gw_sdkver@", paramString1).replaceAll("@gw_sessid@", gm.a).replaceAll("@gw_seqnum@", paramgi.i);
        if (paramgi.l != null)
          str2 = str2.replaceAll("@gw_adnetid@", paramgi.l.b).replaceAll("@gw_allocid@", paramgi.l.d);
        new hg(paramContext, paramString1, str2).e();
      }
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.bt
 * JD-Core Version:    0.6.0
 */