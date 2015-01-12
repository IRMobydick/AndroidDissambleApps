package com.ubercab.client.core.util;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextObjectParser
{
  private static final String REPLACEMENT_CHAR_ERROR = "";
  private static final String REPLACEMENT_CHAR_NOT_FOUND = "";
  private final Object mContextObject;

  public TextObjectParser(Object paramObject)
  {
    this.mContextObject = paramObject;
  }

  private static String getFromMap(Map<Object, Object> paramMap, String paramString)
  {
    Object localObject = paramMap.get(paramString);
    if (localObject != null)
      return localObject.toString();
    return "";
  }

  private String getFromObjectContext(String paramString)
  {
    if ((paramString == null) || (this.mContextObject == null))
      return "";
    if ((this.mContextObject instanceof Map))
      return getFromMap((Map)this.mContextObject, paramString);
    while (true)
    {
      int j;
      try
      {
        Object localObject = this.mContextObject;
        Class localClass = this.mContextObject.getClass();
        String[] arrayOfString = paramString.split("\\.");
        int i = arrayOfString.length;
        j = 0;
        if (j < i)
        {
          Field localField = localClass.getDeclaredField(arrayOfString[j]);
          localField.setAccessible(true);
          localObject = localField.get(localObject);
          if (localObject != null)
            localClass = localObject.getClass();
        }
        else
        {
          if (localObject != null)
            return localObject.toString();
          return "";
        }
      }
      catch (Exception localException)
      {
        return "";
      }
      j++;
    }
  }

  public String parse(String paramString)
  {
    if (paramString == null)
      return null;
    StringBuffer localStringBuffer = new StringBuffer(paramString.length());
    Matcher localMatcher = Pattern.compile("\\{\\{(.*?)\\}\\}").matcher(paramString);
    while (localMatcher.find())
      localMatcher.appendReplacement(localStringBuffer, getFromObjectContext(localMatcher.group(1).trim()));
    localMatcher.appendTail(localStringBuffer);
    return localStringBuffer.toString();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.util.TextObjectParser
 * JD-Core Version:    0.6.2
 */