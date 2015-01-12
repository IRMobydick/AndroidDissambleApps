package com.ubercab.payment.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.ubercab.payment.R.drawable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class CreditCardUtils
{
  private static final Map<String, Card> CARDS = new HashMap()
  {
  };
  private static final int CARD_LENGTH_CVC_DEFAULT_MAX = 3;
  private static final int CARD_LENGTH_CVC_DEFAULT_MIN = 3;
  private static final int CARD_LENGTH_NUMBER_DEFAULT_MAX = 16;
  private static final int CARD_LENGTH_NUMBER_DEFAULT_MIN = 12;
  public static final String CARD_TYPE_ALIPAY = "Alipay";
  public static final String CARD_TYPE_AMEX = "American Express";
  public static final String CARD_TYPE_DELEGATE = "Delegate";
  public static final String CARD_TYPE_DINERS_CLUB_14_DIGITS = "Diners Club 14 Digit";
  public static final String CARD_TYPE_DINERS_CLUB_16_DIGITS = "Diners Club 16 Digit";
  public static final String CARD_TYPE_DISCOVER = "Discover";
  public static final String CARD_TYPE_GOOGLE_WALLET = "Google Wallet";
  public static final String CARD_TYPE_JCB = "JCB";
  public static final String CARD_TYPE_LASER = "Laser";
  public static final String CARD_TYPE_MAESTRO = "Maestro";
  public static final String CARD_TYPE_MASTER = "MasterCard";
  public static final String CARD_TYPE_PAYPAL = "PayPal";
  public static final String CARD_TYPE_PAYTM = "Paytm";
  public static final String CARD_TYPE_UNION_PAY = "Union";
  public static final String CARD_TYPE_UNKNOWN = "";
  public static final String CARD_TYPE_VISA = "Visa";
  private static final char MASKED_CHARACTER = '•';

  private static boolean defaultIsValidCvc(String paramString)
  {
    if (TextUtils.isEmpty(paramString));
    do
    {
      return false;
      paramString.replaceAll("\\s", "");
    }
    while ((!TextUtils.isDigitsOnly(paramString)) || (paramString.length() != 3));
    return true;
  }

  public static String getFormattedNumber(String paramString1, String paramString2)
  {
    Card localCard = (Card)CARDS.get(paramString1);
    if (localCard != null)
      return localCard.getFormatted(paramString2);
    if (TextUtils.isEmpty(paramString2))
      return "";
    String str = paramString2.replaceAll("\\s", "");
    if (str.length() > 16)
      str = str.substring(0, 16);
    return str.replaceAll("\\S{4}", "$0 ").trim();
  }

  public static String getFormattedNumberMasked(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2))
      return "";
    int i = getMaxLengthNumber(paramString1);
    return getFormattedNumber(paramString1, padStart(paramString2.substring(Math.max(0, -4 + paramString2.length())), i, '•'));
  }

  public static Drawable getImage(Context paramContext, String paramString)
  {
    if (paramContext == null)
      throw new IllegalArgumentException("context is null");
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramString.equals("Alipay"))
        return paramContext.getResources().getDrawable(R.drawable.ub__creditcard_alipay);
      if (paramString.equals("American Express"))
        return paramContext.getResources().getDrawable(R.drawable.ub__creditcard_amex);
      if (paramString.equals("Discover"))
        return paramContext.getResources().getDrawable(R.drawable.ub__creditcard_discover);
      if (paramString.equals("MasterCard"))
        return paramContext.getResources().getDrawable(R.drawable.ub__creditcard_mastercard);
      if (paramString.equals("Visa"))
        return paramContext.getResources().getDrawable(R.drawable.ub__creditcard_visa);
      if (paramString.equals("PayPal"))
        return paramContext.getResources().getDrawable(R.drawable.ub__creditcard_paypal);
      if (paramString.equals("Paytm"))
        return paramContext.getResources().getDrawable(R.drawable.ub__creditcard_paytm);
      if (paramString.equals("Google Wallet"))
        return paramContext.getResources().getDrawable(R.drawable.ub__creditcard_googlewallet);
      if (paramString.equals("Delegate"))
        return paramContext.getResources().getDrawable(R.drawable.ub__creditcard_delegate);
    }
    return paramContext.getResources().getDrawable(R.drawable.ub__creditcard_uber);
  }

  public static int getMaxLengthCvc(String paramString)
  {
    Card localCard = (Card)CARDS.get(paramString);
    if (localCard != null)
      return localCard.getMaxLengthCvc();
    return 3;
  }

  private static int getMaxLengthNumber(String paramString)
  {
    Card localCard = (Card)CARDS.get(paramString);
    if (localCard != null)
      return localCard.getMaxLengthNumber();
    return 16;
  }

  public static String getType(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      return "";
    Iterator localIterator = CARDS.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (((Card)CARDS.get(str)).isType(paramString))
        return str;
    }
    return "";
  }

  public static boolean isValidCvc(String paramString1, String paramString2)
  {
    Card localCard = (Card)CARDS.get(paramString1);
    boolean bool2;
    if (localCard != null)
      bool2 = localCard.isValidCvc(paramString2);
    int i;
    do
    {
      boolean bool1;
      do
      {
        return bool2;
        bool1 = TextUtils.isEmpty(paramString2);
        bool2 = false;
      }
      while (bool1);
      i = paramString2.length();
      bool2 = false;
    }
    while (i < 3);
    return true;
  }

  public static boolean isValidNumber(String paramString1, String paramString2)
  {
    Card localCard = (Card)CARDS.get(paramString1);
    boolean bool2;
    if (localCard != null)
      bool2 = localCard.isValidNumber(paramString2);
    int i;
    do
    {
      boolean bool1;
      do
      {
        return bool2;
        bool1 = TextUtils.isEmpty(paramString2);
        bool2 = false;
      }
      while (bool1);
      i = paramString2.replaceAll("\\s", "").length();
      bool2 = false;
    }
    while (i < 12);
    return true;
  }

  private static boolean luhnsAlgorithm(String paramString)
  {
    boolean bool1 = true;
    if (TextUtils.isEmpty(paramString));
    while (!TextUtils.isDigitsOnly(paramString))
      return false;
    char[] arrayOfChar = paramString.replaceAll("\\s", "").toCharArray();
    int i = 0;
    int j = 0;
    int k = 0;
    int m = -1 + arrayOfChar.length;
    boolean bool2 = true;
    if (m >= 0)
    {
      int n = Character.getNumericValue(arrayOfChar[m]);
      if (bool2 == bool1)
        k = n;
      if (bool2 % true == 0)
        j += n / 5 + n * 2 % 10;
      while (true)
      {
        m--;
        bool2++;
        break;
        i += n;
      }
    }
    boolean bool3;
    boolean bool4;
    if ((i + j) % 10 == 0)
    {
      bool3 = bool1;
      if (k != 9 * (i + j - k) % 10)
        break label164;
      bool4 = bool1;
      label146: if ((!bool3) || (!bool4))
        break label170;
    }
    while (true)
    {
      return bool1;
      bool3 = false;
      break;
      label164: bool4 = false;
      break label146;
      label170: bool1 = false;
    }
  }

  public static String padStart(String paramString, int paramInt, char paramChar)
  {
    if (paramString.length() >= paramInt)
      return paramString;
    StringBuilder localStringBuilder = new StringBuilder(paramInt);
    for (int i = paramString.length(); i < paramInt; i++)
      localStringBuilder.append(paramChar);
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }

  private static class AmericanExpressCard
    implements CreditCardUtils.Card
  {
    public String getFormatted(String paramString)
    {
      if (paramString == null)
        paramString = "";
      String str = paramString.replaceAll("\\s", "");
      if (str.length() > 15)
        str = str.substring(0, 15);
      return str.replaceFirst("\\S{4}", "$0 ").replaceFirst("\\S{6}", "$0 ").trim();
    }

    public int getMaxLengthCvc()
    {
      return 4;
    }

    public int getMaxLengthNumber()
    {
      return 15;
    }

    public String getType()
    {
      return "amex";
    }

    public boolean isType(String paramString)
    {
      if (TextUtils.isEmpty(paramString))
        return false;
      String str = paramString.replaceAll("\\s", "");
      return Pattern.compile("^3[47].*").matcher(str).matches();
    }

    public boolean isValidCvc(String paramString)
    {
      if (TextUtils.isEmpty(paramString));
      do
      {
        return false;
        paramString.replaceAll("\\s", "");
      }
      while ((!TextUtils.isDigitsOnly(paramString)) || (paramString.length() != 4));
      return true;
    }

    public boolean isValidNumber(String paramString)
    {
      if (TextUtils.isEmpty(paramString));
      String str;
      do
      {
        return false;
        str = paramString.replaceAll("\\s", "");
      }
      while ((!TextUtils.isDigitsOnly(str)) || (str.length() != 15));
      return CreditCardUtils.luhnsAlgorithm(str);
    }
  }

  private static abstract interface Card
  {
    public abstract String getFormatted(String paramString);

    public abstract int getMaxLengthCvc();

    public abstract int getMaxLengthNumber();

    public abstract String getType();

    public abstract boolean isType(String paramString);

    public abstract boolean isValidCvc(String paramString);

    public abstract boolean isValidNumber(String paramString);
  }

  private static class DinersClub14DigitCard
    implements CreditCardUtils.Card
  {
    public String getFormatted(String paramString)
    {
      if (paramString == null)
        paramString = "";
      String str = paramString.replaceAll("\\s", "");
      if (str.length() > 14)
        str = str.substring(0, 14);
      return str.replaceAll("\\S{4}", "$0 ").trim();
    }

    public int getMaxLengthCvc()
    {
      return 3;
    }

    public int getMaxLengthNumber()
    {
      return 14;
    }

    public String getType()
    {
      return "dinersclub14";
    }

    public boolean isType(String paramString)
    {
      if (TextUtils.isEmpty(paramString))
        return false;
      String str = paramString.replaceAll("\\s", "");
      return Pattern.compile("^(36).*").matcher(str).matches();
    }

    public boolean isValidCvc(String paramString)
    {
      return CreditCardUtils.defaultIsValidCvc(paramString);
    }

    public boolean isValidNumber(String paramString)
    {
      if (TextUtils.isEmpty(paramString));
      String str;
      do
      {
        return false;
        str = paramString.replaceAll("\\s", "");
      }
      while ((!TextUtils.isDigitsOnly(str)) || (str.length() != 14));
      return CreditCardUtils.luhnsAlgorithm(str);
    }
  }

  private static class DinersClub16DigitCard
    implements CreditCardUtils.Card
  {
    public String getFormatted(String paramString)
    {
      if (paramString == null)
        paramString = "";
      String str = paramString.replaceAll("\\s", "");
      if (str.length() > 16)
        str = str.substring(0, 16);
      return str.replaceAll("\\S{4}", "$0 ").trim();
    }

    public int getMaxLengthCvc()
    {
      return 3;
    }

    public int getMaxLengthNumber()
    {
      return 16;
    }

    public String getType()
    {
      return "dinersclub16";
    }

    public boolean isType(String paramString)
    {
      if (TextUtils.isEmpty(paramString))
        return false;
      String str = paramString.replaceAll("\\s", "");
      return Pattern.compile("^(38|30).*").matcher(str).matches();
    }

    public boolean isValidCvc(String paramString)
    {
      return CreditCardUtils.defaultIsValidCvc(paramString);
    }

    public boolean isValidNumber(String paramString)
    {
      if (TextUtils.isEmpty(paramString));
      String str;
      do
      {
        return false;
        str = paramString.replaceAll("\\s", "");
      }
      while ((!TextUtils.isDigitsOnly(str)) || (str.length() != 16));
      return CreditCardUtils.luhnsAlgorithm(str);
    }
  }

  private static class DiscoverCard
    implements CreditCardUtils.Card
  {
    public String getFormatted(String paramString)
    {
      if (paramString == null)
        paramString = "";
      String str = paramString.replaceAll("\\s", "");
      if (str.length() > 16)
        str = str.substring(0, 16);
      return str.replaceAll("\\S{4}", "$0 ").trim();
    }

    public int getMaxLengthCvc()
    {
      return 3;
    }

    public int getMaxLengthNumber()
    {
      return 16;
    }

    public String getType()
    {
      return "discover";
    }

    public boolean isType(String paramString)
    {
      if (TextUtils.isEmpty(paramString))
        return false;
      String str = paramString.replaceAll("\\s", "");
      return Pattern.compile("^(6011|65|64[4-9]).*").matcher(str).matches();
    }

    public boolean isValidCvc(String paramString)
    {
      return CreditCardUtils.defaultIsValidCvc(paramString);
    }

    public boolean isValidNumber(String paramString)
    {
      if (TextUtils.isEmpty(paramString));
      String str;
      do
      {
        return false;
        str = paramString.replaceAll("\\s", "");
      }
      while ((!TextUtils.isDigitsOnly(str)) || (str.length() != 16));
      return CreditCardUtils.luhnsAlgorithm(str);
    }
  }

  private static class JCBCard
    implements CreditCardUtils.Card
  {
    public String getFormatted(String paramString)
    {
      if (paramString == null)
        paramString = "";
      String str = paramString.replaceAll("\\s", "");
      if (str.length() > 16)
        str = str.substring(0, 16);
      return str.replaceAll("\\S{4}", "$0 ").trim();
    }

    public int getMaxLengthCvc()
    {
      return 3;
    }

    public int getMaxLengthNumber()
    {
      return 16;
    }

    public String getType()
    {
      return "jcb";
    }

    public boolean isType(String paramString)
    {
      if (TextUtils.isEmpty(paramString))
        return false;
      String str = paramString.replaceAll("\\s", "");
      return Pattern.compile("^35.*").matcher(str).matches();
    }

    public boolean isValidCvc(String paramString)
    {
      return CreditCardUtils.defaultIsValidCvc(paramString);
    }

    public boolean isValidNumber(String paramString)
    {
      if (TextUtils.isEmpty(paramString));
      String str;
      do
      {
        return false;
        str = paramString.replaceAll("\\s", "");
      }
      while ((!TextUtils.isDigitsOnly(str)) || (str.length() != 16));
      return CreditCardUtils.luhnsAlgorithm(str);
    }
  }

  private static class LaserCard
    implements CreditCardUtils.Card
  {
    public String getFormatted(String paramString)
    {
      if (paramString == null)
        paramString = "";
      String str = paramString.replaceAll("\\s", "");
      if (str.length() > 19)
        str = str.substring(0, 19);
      return str.replaceAll("\\S{4}", "$0 ").trim();
    }

    public int getMaxLengthCvc()
    {
      return 3;
    }

    public int getMaxLengthNumber()
    {
      return 19;
    }

    public String getType()
    {
      return "laser";
    }

    public boolean isType(String paramString)
    {
      if (TextUtils.isEmpty(paramString))
        return false;
      String str = paramString.replaceAll("\\s", "");
      return Pattern.compile("^(6706|6771|6709).*").matcher(str).matches();
    }

    public boolean isValidCvc(String paramString)
    {
      return CreditCardUtils.defaultIsValidCvc(paramString);
    }

    public boolean isValidNumber(String paramString)
    {
      if (TextUtils.isEmpty(paramString));
      String str;
      do
      {
        return false;
        str = paramString.replaceAll("\\s", "");
      }
      while ((!TextUtils.isDigitsOnly(str)) || (str.length() < 16) || (str.length() > 19));
      return CreditCardUtils.luhnsAlgorithm(str);
    }
  }

  private static class MaestroCard
    implements CreditCardUtils.Card
  {
    public String getFormatted(String paramString)
    {
      if (paramString == null)
        paramString = "";
      String str = paramString.replaceAll("\\s", "");
      if (str.length() > 19)
        str = str.substring(0, 19);
      return str.replaceAll("\\S{4}", "$0 ").trim();
    }

    public int getMaxLengthCvc()
    {
      return 3;
    }

    public int getMaxLengthNumber()
    {
      return 19;
    }

    public String getType()
    {
      return "maestro";
    }

    public boolean isType(String paramString)
    {
      if (TextUtils.isEmpty(paramString))
        return false;
      String str = paramString.replaceAll("\\s", "");
      return Pattern.compile("^(5018|5020|5038|6304|6759|676[1-3]).*").matcher(str).matches();
    }

    public boolean isValidCvc(String paramString)
    {
      return CreditCardUtils.defaultIsValidCvc(paramString);
    }

    public boolean isValidNumber(String paramString)
    {
      if (TextUtils.isEmpty(paramString));
      String str;
      do
      {
        return false;
        str = paramString.replaceAll("\\s", "");
      }
      while ((!TextUtils.isDigitsOnly(str)) || (str.length() < 12) || (str.length() > 19));
      return CreditCardUtils.luhnsAlgorithm(str);
    }
  }

  private static class MasterCard
    implements CreditCardUtils.Card
  {
    public String getFormatted(String paramString)
    {
      if (paramString == null)
        paramString = "";
      String str = paramString.replaceAll("\\s", "");
      if (str.length() > 16)
        str = str.substring(0, 16);
      return str.replaceAll("\\S{4}", "$0 ").trim();
    }

    public int getMaxLengthCvc()
    {
      return 3;
    }

    public int getMaxLengthNumber()
    {
      return 16;
    }

    public String getType()
    {
      return "mastercard";
    }

    public boolean isType(String paramString)
    {
      if (TextUtils.isEmpty(paramString))
        return false;
      String str = paramString.replaceAll("\\s", "");
      return Pattern.compile("^5[1-5].*").matcher(str).matches();
    }

    public boolean isValidCvc(String paramString)
    {
      return CreditCardUtils.defaultIsValidCvc(paramString);
    }

    public boolean isValidNumber(String paramString)
    {
      if (TextUtils.isEmpty(paramString));
      String str;
      do
      {
        return false;
        str = paramString.replaceAll("\\s", "");
      }
      while ((!TextUtils.isDigitsOnly(str)) || (str.length() != 16));
      return CreditCardUtils.luhnsAlgorithm(str);
    }
  }

  private static class UnionPayCard
    implements CreditCardUtils.Card
  {
    public String getFormatted(String paramString)
    {
      if (paramString == null)
        paramString = "";
      String str = paramString.replaceAll("\\s", "");
      if (str.length() > 19)
        str = str.substring(0, 19);
      return str.replaceAll("\\S{4}", "$0 ").trim();
    }

    public int getMaxLengthCvc()
    {
      return 3;
    }

    public int getMaxLengthNumber()
    {
      return 19;
    }

    public String getType()
    {
      return "unionpay";
    }

    public boolean isType(String paramString)
    {
      if (TextUtils.isEmpty(paramString))
        return false;
      String str = paramString.replaceAll("\\s", "");
      return Pattern.compile("^62.*").matcher(str).matches();
    }

    public boolean isValidCvc(String paramString)
    {
      return CreditCardUtils.defaultIsValidCvc(paramString);
    }

    public boolean isValidNumber(String paramString)
    {
      if (TextUtils.isEmpty(paramString));
      String str;
      do
      {
        return false;
        str = paramString.replaceAll("\\s", "");
      }
      while ((!TextUtils.isDigitsOnly(str)) || (str.length() < 16) || (str.length() > 19));
      return true;
    }
  }

  private static class VisaCard
    implements CreditCardUtils.Card
  {
    public String getFormatted(String paramString)
    {
      if (paramString == null)
        paramString = "";
      String str = paramString.replaceAll("\\s", "");
      if (str.length() > 16)
        str = str.substring(0, 16);
      return str.replaceAll("\\S{4}", "$0 ").trim();
    }

    public int getMaxLengthCvc()
    {
      return 3;
    }

    public int getMaxLengthNumber()
    {
      return 16;
    }

    public String getType()
    {
      return "visa";
    }

    public boolean isType(String paramString)
    {
      if (TextUtils.isEmpty(paramString))
        return false;
      String str = paramString.replaceAll("\\s", "");
      return Pattern.compile("^4.*").matcher(str).matches();
    }

    public boolean isValidCvc(String paramString)
    {
      return CreditCardUtils.defaultIsValidCvc(paramString);
    }

    public boolean isValidNumber(String paramString)
    {
      if (TextUtils.isEmpty(paramString));
      String str;
      do
      {
        return false;
        str = paramString.replaceAll("\\s", "");
      }
      while ((!TextUtils.isDigitsOnly(str)) || (str.length() < 13) || (str.length() > 16));
      return CreditCardUtils.luhnsAlgorithm(str);
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.payment.util.CreditCardUtils
 * JD-Core Version:    0.6.2
 */