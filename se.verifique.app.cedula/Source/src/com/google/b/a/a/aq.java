package com.google.b.a.a;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class aq
{
  static String a(ap paramap, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramap.a());
    if (paramap.c() > 0L)
    {
      long l = paramLong - paramap.c();
      if (l >= 0L)
        localStringBuilder.append("&qt").append("=").append(l);
    }
    localStringBuilder.append("&z").append("=").append(paramap.b());
    return localStringBuilder.toString();
  }

  static String a(String paramString)
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

  static Map a(Map paramMap)
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if ((!((String)localEntry.getKey()).startsWith("&")) || (localEntry.getValue() == null))
        continue;
      String str = ((String)localEntry.getKey()).substring(1);
      if (TextUtils.isEmpty(str))
        continue;
      localHashMap.put(str, localEntry.getValue());
    }
    return localHashMap;
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.b.a.a.aq
 * JD-Core Version:    0.6.0
 */