package com.google.android.gms.analytics;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class x
{
  static String a(w paramw, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramw.eF());
    if (paramw.eH() > 0L)
    {
      long l = paramLong - paramw.eH();
      if (l >= 0L)
        localStringBuilder.append("&qt").append("=").append(l);
    }
    localStringBuilder.append("&z").append("=").append(paramw.eG());
    return localStringBuilder.toString();
  }

  static String encode(String paramString)
  {
    try
    {
      String str = URLEncoder.encode(paramString, "UTF-8");
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
    }
    throw new AssertionError("URL encoding failed for: " + paramString);
  }

  static Map<String, String> z(Map<String, String> paramMap)
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if ((((String)localEntry.getKey()).startsWith("&")) && (localEntry.getValue() != null))
      {
        String str = ((String)localEntry.getKey()).substring(1);
        if (!TextUtils.isEmpty(str))
          localHashMap.put(str, localEntry.getValue());
      }
    }
    return localHashMap;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.analytics.x
 * JD-Core Version:    0.6.2
 */