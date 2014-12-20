package com.google.b.a.a;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class ag
{
  private final Map a;
  private final long b;
  private final String c;
  private final List d;

  public ag(Map paramMap, long paramLong, String paramString, List paramList)
  {
    this.a = paramMap;
    this.b = paramLong;
    this.c = paramString;
    this.d = paramList;
  }

  public Map a()
  {
    return this.a;
  }

  public long b()
  {
    return this.b;
  }

  public String c()
  {
    return this.c;
  }

  public List d()
  {
    return this.d;
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PATH: ");
    localStringBuilder.append(this.c);
    if (this.a != null)
    {
      localStringBuilder.append("  PARAMS: ");
      Iterator localIterator = this.a.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        localStringBuilder.append((String)localEntry.getKey());
        localStringBuilder.append("=");
        localStringBuilder.append((String)localEntry.getValue());
        localStringBuilder.append(",  ");
      }
    }
    return localStringBuilder.toString();
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.b.a.a.ag
 * JD-Core Version:    0.6.0
 */