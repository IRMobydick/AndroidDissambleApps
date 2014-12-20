package a.a.a;

import java.util.Iterator;
import java.util.List;

class bq
  implements bd
{
  public String a(String paramString, Object paramObject, aa paramaa)
  {
    short s;
    List localList;
    String str;
    if ("new-inline-tags".equals(paramString))
    {
      s = 2;
      localList = paramaa.ap.a(s);
      if (!localList.isEmpty());
    }
    else
    {
      for (str = ""; ; str = "")
      {
        return str;
        if ("new-blocklevel-tags".equals(paramString))
        {
          s = 4;
          break;
        }
        if ("new-empty-tags".equals(paramString))
        {
          s = 1;
          break;
        }
        if (!"new-pre-tags".equals(paramString))
          continue;
        s = 8;
        break;
      }
    }
    StringBuffer localStringBuffer = new StringBuffer();
    Iterator localIterator = localList.iterator();
    while (true)
    {
      if (!localIterator.hasNext())
      {
        str = localStringBuffer.toString();
        break;
      }
      localStringBuffer.append(localIterator.next());
      localStringBuffer.append(" ");
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     a.a.a.bq
 * JD-Core Version:    0.6.0
 */