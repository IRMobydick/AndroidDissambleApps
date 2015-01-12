package org.jsoup.nodes;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.CharsetEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.MissingResourceException;
import java.util.Properties;
import java.util.Set;
import java.util.regex.Pattern;
import org.jsoup.parser.Parser;

public class Entities
{
  private static final Map<String, Character> base;
  private static final Map<Character, String> baseByVal;
  private static final Map<String, Character> full;
  private static final Map<Character, String> fullByVal;
  private static final Pattern strictUnescapePattern;
  private static final Pattern unescapePattern = Pattern.compile("&(#(x|X)?([0-9a-fA-F]+)|[a-zA-Z]+\\d*);?");
  private static final Object[][] xhtmlArray;
  private static final Map<Character, String> xhtmlByVal;

  static
  {
    strictUnescapePattern = Pattern.compile("&(#(x|X)?([0-9a-fA-F]+)|[a-zA-Z]+\\d*);");
    Object[][] arrayOfObject; = new Object[5][];
    Object[] arrayOfObject1 = new Object[2];
    arrayOfObject1[0] = "quot";
    arrayOfObject1[1] = Integer.valueOf(34);
    arrayOfObject;[0] = arrayOfObject1;
    Object[] arrayOfObject2 = new Object[2];
    arrayOfObject2[0] = "amp";
    arrayOfObject2[1] = Integer.valueOf(38);
    arrayOfObject;[1] = arrayOfObject2;
    Object[] arrayOfObject3 = new Object[2];
    arrayOfObject3[0] = "apos";
    arrayOfObject3[1] = Integer.valueOf(39);
    arrayOfObject;[2] = arrayOfObject3;
    Object[] arrayOfObject4 = new Object[2];
    arrayOfObject4[0] = "lt";
    arrayOfObject4[1] = Integer.valueOf(60);
    arrayOfObject;[3] = arrayOfObject4;
    Object[] arrayOfObject5 = new Object[2];
    arrayOfObject5[0] = "gt";
    arrayOfObject5[1] = Integer.valueOf(62);
    arrayOfObject;[4] = arrayOfObject5;
    xhtmlArray = arrayOfObject;;
    xhtmlByVal = new HashMap();
    base = loadEntities("entities-base.properties");
    baseByVal = toCharacterKey(base);
    full = loadEntities("entities-full.properties");
    fullByVal = toCharacterKey(full);
    for (Object[] arrayOfObject6 : xhtmlArray)
    {
      Character localCharacter = Character.valueOf((char)((Integer)arrayOfObject6[1]).intValue());
      xhtmlByVal.put(localCharacter, (String)arrayOfObject6[0]);
    }
  }

  static String escape(String paramString, CharsetEncoder paramCharsetEncoder, EscapeMode paramEscapeMode)
  {
    StringBuilder localStringBuilder = new StringBuilder(2 * paramString.length());
    Map localMap = paramEscapeMode.getMap();
    int i = paramString.length();
    int j = 0;
    if (j < i)
    {
      int k = paramString.codePointAt(j);
      char c;
      if (k < 65536)
      {
        c = (char)k;
        if (localMap.containsKey(Character.valueOf(c)))
          localStringBuilder.append('&').append((String)localMap.get(Character.valueOf(c))).append(';');
      }
      while (true)
      {
        j += Character.charCount(k);
        break;
        if (paramCharsetEncoder.canEncode(c))
        {
          localStringBuilder.append(c);
        }
        else
        {
          localStringBuilder.append("&#x").append(Integer.toHexString(k)).append(';');
          continue;
          String str = new String(Character.toChars(k));
          if (paramCharsetEncoder.canEncode(str))
            localStringBuilder.append(str);
          else
            localStringBuilder.append("&#x").append(Integer.toHexString(k)).append(';');
        }
      }
    }
    return localStringBuilder.toString();
  }

  static String escape(String paramString, Document.OutputSettings paramOutputSettings)
  {
    return escape(paramString, paramOutputSettings.encoder(), paramOutputSettings.escapeMode());
  }

  public static Character getCharacterByName(String paramString)
  {
    return (Character)full.get(paramString);
  }

  public static boolean isBaseNamedEntity(String paramString)
  {
    return base.containsKey(paramString);
  }

  public static boolean isNamedEntity(String paramString)
  {
    return full.containsKey(paramString);
  }

  private static Map<String, Character> loadEntities(String paramString)
  {
    Properties localProperties = new Properties();
    HashMap localHashMap = new HashMap();
    try
    {
      InputStream localInputStream = Entities.class.getResourceAsStream(paramString);
      localProperties.load(localInputStream);
      localInputStream.close();
      Iterator localIterator = localProperties.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        Character localCharacter = Character.valueOf((char)Integer.parseInt((String)localEntry.getValue(), 16));
        localHashMap.put((String)localEntry.getKey(), localCharacter);
      }
    }
    catch (IOException localIOException)
    {
      throw new MissingResourceException("Error loading entities resource: " + localIOException.getMessage(), "Entities", paramString);
    }
    return localHashMap;
  }

  private static Map<Character, String> toCharacterKey(Map<String, Character> paramMap)
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      Character localCharacter = (Character)localEntry.getValue();
      String str = (String)localEntry.getKey();
      if (localHashMap.containsKey(localCharacter))
      {
        if (str.toLowerCase().equals(str))
          localHashMap.put(localCharacter, str);
      }
      else
        localHashMap.put(localCharacter, str);
    }
    return localHashMap;
  }

  static String unescape(String paramString)
  {
    return unescape(paramString, false);
  }

  static String unescape(String paramString, boolean paramBoolean)
  {
    return Parser.unescapeEntities(paramString, paramBoolean);
  }

  public static enum EscapeMode
  {
    private Map<Character, String> map;

    static
    {
      base = new EscapeMode("base", 1, Entities.baseByVal);
      extended = new EscapeMode("extended", 2, Entities.fullByVal);
      EscapeMode[] arrayOfEscapeMode = new EscapeMode[3];
      arrayOfEscapeMode[0] = xhtml;
      arrayOfEscapeMode[1] = base;
      arrayOfEscapeMode[2] = extended;
    }

    private EscapeMode(Map<Character, String> paramMap)
    {
      this.map = paramMap;
    }

    public Map<Character, String> getMap()
    {
      return this.map;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     org.jsoup.nodes.Entities
 * JD-Core Version:    0.6.2
 */