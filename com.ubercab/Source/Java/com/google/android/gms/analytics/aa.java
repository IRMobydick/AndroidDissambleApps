package com.google.android.gms.analytics;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class aa
{
  private final Map<String, Integer> AU = new HashMap();
  private final Map<String, String> AV = new HashMap();
  private final boolean AW;
  private final String AX;

  aa(String paramString, boolean paramBoolean)
  {
    this.AW = paramBoolean;
    this.AX = paramString;
  }

  void e(String paramString, int paramInt)
  {
    if (!this.AW)
      return;
    Integer localInteger = (Integer)this.AU.get(paramString);
    if (localInteger == null)
      localInteger = Integer.valueOf(0);
    this.AU.put(paramString, Integer.valueOf(paramInt + localInteger.intValue()));
  }

  String eL()
  {
    if (!this.AW)
      return "";
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.AX);
    Iterator localIterator1 = this.AU.keySet().iterator();
    while (localIterator1.hasNext())
    {
      String str2 = (String)localIterator1.next();
      localStringBuilder.append("&").append(str2).append("=").append(this.AU.get(str2));
    }
    Iterator localIterator2 = this.AV.keySet().iterator();
    while (localIterator2.hasNext())
    {
      String str1 = (String)localIterator2.next();
      localStringBuilder.append("&").append(str1).append("=").append((String)this.AV.get(str1));
    }
    return localStringBuilder.toString();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.analytics.aa
 * JD-Core Version:    0.6.2
 */