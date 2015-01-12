package org.jsoup.helper;

import java.util.Collection;
import java.util.Iterator;

public final class StringUtil
{
  private static final String[] padding = { "", " ", "  ", "   ", "    ", "     ", "      ", "       ", "        ", "         ", "          " };

  public static boolean in(String paramString, String[] paramArrayOfString)
  {
    int i = paramArrayOfString.length;
    for (int j = 0; j < i; j++)
      if (paramArrayOfString[j].equals(paramString))
        return true;
    return false;
  }

  public static boolean isBlank(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0));
    while (true)
    {
      return true;
      int i = paramString.length();
      for (int j = 0; j < i; j++)
        if (!isWhitespace(paramString.codePointAt(j)))
          return false;
    }
  }

  public static boolean isNumeric(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0))
      return false;
    int i = paramString.length();
    for (int j = 0; ; j++)
    {
      if (j >= i)
        break label42;
      if (!Character.isDigit(paramString.codePointAt(j)))
        break;
    }
    label42: return true;
  }

  public static boolean isWhitespace(int paramInt)
  {
    return (paramInt == 32) || (paramInt == 9) || (paramInt == 10) || (paramInt == 12) || (paramInt == 13);
  }

  public static String join(Collection paramCollection, String paramString)
  {
    return join(paramCollection.iterator(), paramString);
  }

  public static String join(Iterator paramIterator, String paramString)
  {
    String str;
    if (!paramIterator.hasNext())
      str = "";
    do
    {
      return str;
      str = paramIterator.next().toString();
    }
    while (!paramIterator.hasNext());
    StringBuilder localStringBuilder = new StringBuilder(64).append(str);
    while (paramIterator.hasNext())
    {
      localStringBuilder.append(paramString);
      localStringBuilder.append(paramIterator.next());
    }
    return localStringBuilder.toString();
  }

  public static String normaliseWhitespace(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramString.length());
    int i = 0;
    int j = 0;
    int k = paramString.length();
    int m = 0;
    if (m < k)
    {
      int n = paramString.codePointAt(m);
      if (isWhitespace(n))
        if (i != 0)
          j = 1;
      while (true)
      {
        m += Character.charCount(n);
        break;
        if (n != 32)
          j = 1;
        localStringBuilder.append(' ');
        i = 1;
        continue;
        localStringBuilder.appendCodePoint(n);
        i = 0;
      }
    }
    if (j != 0)
      paramString = localStringBuilder.toString();
    return paramString;
  }

  public static String padding(int paramInt)
  {
    if (paramInt < 0)
      throw new IllegalArgumentException("width must be > 0");
    if (paramInt < padding.length)
      return padding[paramInt];
    char[] arrayOfChar = new char[paramInt];
    for (int i = 0; i < paramInt; i++)
      arrayOfChar[i] = ' ';
    return String.valueOf(arrayOfChar);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     org.jsoup.helper.StringUtil
 * JD-Core Version:    0.6.2
 */