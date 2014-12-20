package com.google.b.a.a;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

class bj
{
  private static final char[] a;

  static
  {
    char[] arrayOfChar = new char[16];
    arrayOfChar[0] = 48;
    arrayOfChar[1] = 49;
    arrayOfChar[2] = 50;
    arrayOfChar[3] = 51;
    arrayOfChar[4] = 52;
    arrayOfChar[5] = 53;
    arrayOfChar[6] = 54;
    arrayOfChar[7] = 55;
    arrayOfChar[8] = 56;
    arrayOfChar[9] = 57;
    arrayOfChar[10] = 65;
    arrayOfChar[11] = 66;
    arrayOfChar[12] = 67;
    arrayOfChar[13] = 68;
    arrayOfChar[14] = 69;
    arrayOfChar[15] = 70;
    a = arrayOfChar;
  }

  public static double a(String paramString, double paramDouble)
  {
    if (paramString == null);
    while (true)
    {
      return paramDouble;
      try
      {
        double d = Double.parseDouble(paramString);
        paramDouble = d;
      }
      catch (NumberFormatException localNumberFormatException)
      {
      }
    }
  }

  static String a(Locale paramLocale)
  {
    String str = null;
    if (paramLocale == null);
    while (true)
    {
      return str;
      if (TextUtils.isEmpty(paramLocale.getLanguage()))
        continue;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramLocale.getLanguage().toLowerCase());
      if (!TextUtils.isEmpty(paramLocale.getCountry()))
        localStringBuilder.append("-").append(paramLocale.getCountry().toLowerCase());
      str = localStringBuilder.toString();
    }
  }

  public static Map a(String paramString)
  {
    HashMap localHashMap = new HashMap();
    String[] arrayOfString1 = paramString.split("&");
    int i = arrayOfString1.length;
    int j = 0;
    if (j < i)
    {
      String[] arrayOfString2 = arrayOfString1[j].split("=");
      if (arrayOfString2.length > 1)
        localHashMap.put(arrayOfString2[0], arrayOfString2[1]);
      while (true)
      {
        j++;
        break;
        if ((arrayOfString2.length != 1) || (arrayOfString2[0].length() == 0))
          continue;
        localHashMap.put(arrayOfString2[0], null);
      }
    }
    return localHashMap;
  }

  public static void a(Map paramMap, String paramString1, String paramString2)
  {
    if (!paramMap.containsKey(paramString1))
      paramMap.put(paramString1, paramString2);
  }

  public static boolean a(String paramString, boolean paramBoolean)
  {
    if (paramString != null)
      if ((!paramString.equalsIgnoreCase("true")) && (!paramString.equalsIgnoreCase("yes")) && (!paramString.equalsIgnoreCase("1")))
        break label35;
    for (paramBoolean = true; ; paramBoolean = false)
      label35: 
      do
        return paramBoolean;
      while ((!paramString.equalsIgnoreCase("false")) && (!paramString.equalsIgnoreCase("no")) && (!paramString.equalsIgnoreCase("0")));
  }

  public static String b(String paramString)
  {
    String str1;
    if (TextUtils.isEmpty(paramString))
      str1 = null;
    while (true)
    {
      return str1;
      if (paramString.contains("?"))
      {
        String[] arrayOfString2 = paramString.split("[\\?]");
        if (arrayOfString2.length > 1)
          paramString = arrayOfString2[1];
      }
      if (paramString.contains("%3D"));
      StringBuilder localStringBuilder;
      do
      {
        try
        {
          String str2 = URLDecoder.decode(paramString, "UTF-8");
          paramString = str2;
          Map localMap = a(paramString);
          String[] arrayOfString1 = new String[9];
          arrayOfString1[0] = "dclid";
          arrayOfString1[1] = "utm_source";
          arrayOfString1[2] = "gclid";
          arrayOfString1[3] = "utm_campaign";
          arrayOfString1[4] = "utm_medium";
          arrayOfString1[5] = "utm_term";
          arrayOfString1[6] = "utm_content";
          arrayOfString1[7] = "utm_id";
          arrayOfString1[8] = "gmob_t";
          localStringBuilder = new StringBuilder();
          for (int i = 0; i < arrayOfString1.length; i++)
          {
            if (TextUtils.isEmpty((CharSequence)localMap.get(arrayOfString1[i])))
              continue;
            if (localStringBuilder.length() > 0)
              localStringBuilder.append("&");
            localStringBuilder.append(arrayOfString1[i]).append("=").append((String)localMap.get(arrayOfString1[i]));
          }
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          str1 = null;
        }
        break;
      }
      while (paramString.contains("="));
      str1 = null;
      continue;
      str1 = localStringBuilder.toString();
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.b.a.a.bj
 * JD-Core Version:    0.6.0
 */