package com.paypal.android.sdk;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Currency;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public final class l
{
  private static List a = Arrays.asList(new String[] { "AUD", "BRL", "CAD", "CHF", "CZK", "DKK", "EUR", "GBP", "HKD", "HUF", "ILS", "JPY", "MXN", "MYR", "NOK", "NZD", "PHP", "PLN", "SEK", "SGD", "THB", "TWD", "TRY", "USD" });
  private static String b = "JPY, HUF, TWD";
  private static final Locale c = Locale.US;
  private static final Locale d = Locale.GERMANY;
  private static List e = null;
  private static NumberFormat f = null;

  private static int a(Locale paramLocale, Currency paramCurrency)
  {
    if (f == null)
      f = NumberFormat.getCurrencyInstance(paramLocale);
    f.setCurrency(paramCurrency);
    if (f.format(1234.5599999999999D).indexOf("1") != 0)
      return 0;
    return 1;
  }

  public static String a(double paramDouble, String paramString)
  {
    return a(paramDouble, paramString, (DecimalFormat)NumberFormat.getInstance(c));
  }

  private static String a(double paramDouble, String paramString, DecimalFormat paramDecimalFormat)
  {
    String str = "#######0";
    if (b.indexOf(paramString.toUpperCase(Locale.US)) == -1);
    for (int i = 1; ; i = 0)
    {
      if (i != 0)
        str = "#####0.00";
      paramDecimalFormat.applyPattern(str);
      return paramDecimalFormat.format(paramDouble);
    }
  }

  public static String a(double paramDouble, Currency paramCurrency)
  {
    DecimalFormat localDecimalFormat;
    String str;
    if (a(paramCurrency).equals(","))
    {
      localDecimalFormat = (DecimalFormat)NumberFormat.getInstance(d);
      str = "#######0";
      if (b.indexOf(paramCurrency.getCurrencyCode().toUpperCase(Locale.US)) != -1)
        break label83;
    }
    label83: for (int i = 1; ; i = 0)
    {
      if (i != 0)
        str = "#####0.00";
      localDecimalFormat.applyPattern(str);
      return localDecimalFormat.format(paramDouble);
      localDecimalFormat = (DecimalFormat)NumberFormat.getInstance(c);
      break;
    }
  }

  private static String a(Currency paramCurrency)
  {
    DecimalFormat localDecimalFormat = new DecimalFormat("0.00");
    localDecimalFormat.setCurrency(paramCurrency);
    if (localDecimalFormat.format(1.56D).indexOf(".") > 0)
      return ".";
    return ",";
  }

  public static String a(Locale paramLocale, double paramDouble, Currency paramCurrency)
  {
    return a(paramLocale, paramDouble, paramCurrency, true);
  }

  private static String a(Locale paramLocale, double paramDouble, Currency paramCurrency, boolean paramBoolean)
  {
    int i;
    String str1;
    String str2;
    if (a(paramLocale, paramCurrency) == 0)
    {
      i = 1;
      str1 = paramCurrency.getSymbol();
      str2 = paramCurrency.getCurrencyCode();
    }
    while (true)
    {
      try
      {
        StringBuilder localStringBuilder1 = new StringBuilder();
        if (i != 0)
          break label180;
        str3 = str2 + " ";
        StringBuilder localStringBuilder2 = localStringBuilder1.append(str3);
        if (i == 0)
          break label187;
        str4 = str1;
        StringBuilder localStringBuilder3 = localStringBuilder2.append(str4).append(a(paramDouble, paramCurrency));
        if (i != 0)
          break label194;
        str5 = " " + str1;
        StringBuilder localStringBuilder4 = localStringBuilder3.append(str5);
        if (i != 0)
        {
          str6 = " " + str2;
          return str6;
        }
        String str6 = "";
        continue;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        return "";
      }
      i = 0;
      break;
      label180: String str3 = "";
      continue;
      label187: String str4 = "";
      continue;
      label194: String str5 = "";
    }
  }

  public static String a(Locale paramLocale, String paramString1, double paramDouble, String paramString2, boolean paramBoolean)
  {
    String str1 = Currency.getInstance(paramString2).getSymbol();
    int i;
    String str2;
    label61: String str3;
    label83: DecimalFormat localDecimalFormat;
    label110: StringBuilder localStringBuilder3;
    if (a(paramLocale, Currency.getInstance(paramString2)) == 0)
    {
      i = 1;
      StringBuilder localStringBuilder1 = new StringBuilder();
      if (i == 0)
        break label169;
      str2 = str1 + " ";
      StringBuilder localStringBuilder2 = localStringBuilder1.append(str2);
      if (!paramString1.equalsIgnoreCase("AU"))
        break label176;
      str3 = "AUD";
      if (!a(Currency.getInstance(str3)).equals(","))
        break label544;
      localDecimalFormat = (DecimalFormat)NumberFormat.getInstance(d);
      localStringBuilder3 = localStringBuilder2.append(a(paramDouble, paramString2, localDecimalFormat));
      if (i != 0)
        break label558;
    }
    label169: label558: for (String str4 = " " + str1; ; str4 = "")
    {
      return str4;
      i = 0;
      break;
      str2 = "";
      break label61;
      label176: if (paramString1.equalsIgnoreCase("GB"))
      {
        str3 = "GBP";
        break label83;
      }
      if (paramString1.equalsIgnoreCase("UK"))
      {
        str3 = "GBP";
        break label83;
      }
      if (paramString1.equalsIgnoreCase("CA"))
      {
        str3 = "CAD";
        break label83;
      }
      if (paramString1.equalsIgnoreCase("AT"))
      {
        str3 = "EUR";
        break label83;
      }
      if (paramString1.equalsIgnoreCase("CZ"))
      {
        str3 = "CZK";
        break label83;
      }
      if (paramString1.equalsIgnoreCase("DK"))
      {
        str3 = "DKK";
        break label83;
      }
      if (paramString1.equalsIgnoreCase("FR"))
      {
        str3 = "EUR";
        break label83;
      }
      if (paramString1.equalsIgnoreCase("DE"))
      {
        str3 = "EUR";
        break label83;
      }
      if (paramString1.equalsIgnoreCase("HU"))
      {
        str3 = "HUF";
        break label83;
      }
      if (paramString1.equalsIgnoreCase("IE"))
      {
        str3 = "EUR";
        break label83;
      }
      if (paramString1.equalsIgnoreCase("IT"))
      {
        str3 = "EUR";
        break label83;
      }
      if (paramString1.equalsIgnoreCase("NL"))
      {
        str3 = "EUR";
        break label83;
      }
      if (paramString1.equalsIgnoreCase("PL"))
      {
        str3 = "PLN";
        break label83;
      }
      if (paramString1.equalsIgnoreCase("PT"))
      {
        str3 = "EUR";
        break label83;
      }
      if (paramString1.equalsIgnoreCase("ES"))
      {
        str3 = "EUR";
        break label83;
      }
      if (paramString1.equalsIgnoreCase("SE"))
      {
        str3 = "SEK";
        break label83;
      }
      if (!paramString1.equalsIgnoreCase("ZA"))
      {
        if (paramString1.equalsIgnoreCase("NZ"))
        {
          str3 = "NZD";
          break label83;
        }
        if (paramString1.equalsIgnoreCase("LT"))
        {
          str3 = "EUR";
          break label83;
        }
        if (paramString1.equalsIgnoreCase("JP"))
        {
          str3 = "JPY";
          break label83;
        }
        if (paramString1.equalsIgnoreCase("BR"))
        {
          str3 = "BRL";
          break label83;
        }
        if (paramString1.equalsIgnoreCase("MY"))
        {
          str3 = "MYR";
          break label83;
        }
        if (paramString1.equalsIgnoreCase("MX"))
        {
          str3 = "MXN";
          break label83;
        }
      }
      str3 = "USD";
      break label83;
      localDecimalFormat = (DecimalFormat)NumberFormat.getInstance(c);
      break label110;
    }
  }

  public static List a()
  {
    if (e == null)
    {
      e = new ArrayList();
      Iterator localIterator = a.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        e.add(Currency.getInstance(str));
      }
      Collections.sort(e, new m());
    }
    return e;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.paypal.android.sdk.l
 * JD-Core Version:    0.6.2
 */