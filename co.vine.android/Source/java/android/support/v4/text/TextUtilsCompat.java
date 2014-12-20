package android.support.v4.text;

import java.util.Locale;

public class TextUtilsCompat
{
  private static String ARAB_SCRIPT_SUBTAG;
  private static String HEBR_SCRIPT_SUBTAG;
  public static final Locale ROOT = new Locale("", "");

  static
  {
    ARAB_SCRIPT_SUBTAG = "Arab";
    HEBR_SCRIPT_SUBTAG = "Hebr";
  }

  private static int getLayoutDirectionFromFirstChar(Locale paramLocale)
  {
    int i = 0;
    switch (Character.getDirectionality(paramLocale.getDisplayName(paramLocale).charAt(0)))
    {
    default:
    case 1:
    case 2:
    }
    while (true)
    {
      return i;
      i = 1;
    }
  }

  public static int getLayoutDirectionFromLocale(Locale paramLocale)
  {
    String str;
    int i;
    if ((paramLocale != null) && (!paramLocale.equals(ROOT)))
    {
      str = ICUCompat.getScript(ICUCompat.addLikelySubtags(paramLocale.toString()));
      if (str == null)
        i = getLayoutDirectionFromFirstChar(paramLocale);
    }
    while (true)
    {
      return i;
      if ((str.equalsIgnoreCase(ARAB_SCRIPT_SUBTAG)) || (str.equalsIgnoreCase(HEBR_SCRIPT_SUBTAG)))
      {
        i = 1;
        continue;
      }
      i = 0;
    }
  }

  public static String htmlEncode(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    if (i < paramString.length())
    {
      char c = paramString.charAt(i);
      switch (c)
      {
      default:
        localStringBuilder.append(c);
      case '<':
      case '>':
      case '&':
      case '\'':
      case '"':
      }
      while (true)
      {
        i++;
        break;
        localStringBuilder.append("&lt;");
        continue;
        localStringBuilder.append("&gt;");
        continue;
        localStringBuilder.append("&amp;");
        continue;
        localStringBuilder.append("&#39;");
        continue;
        localStringBuilder.append("&quot;");
      }
    }
    return localStringBuilder.toString();
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.text.TextUtilsCompat
 * JD-Core Version:    0.6.0
 */