package a.a.a;

import java.io.UnsupportedEncodingException;

public final class do
{
  private static short[] a = new short[''];

  static
  {
    a("\r\n\f", 24);
    a(" \t", 8);
    a("-.:_", 4);
    a("0123456789", 5);
    a("abcdefghijklmnopqrstuvwxyz", 38);
    a("ABCDEFGHIJKLMNOPQRSTUVWXYZ", 70);
  }

  public static char a(char paramChar, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!paramBoolean2)
    {
      if (!paramBoolean1)
        break label22;
      if (g(paramChar))
        paramChar = j(paramChar);
    }
    while (true)
    {
      return paramChar;
      label22: if (!h(paramChar))
        continue;
      paramChar = i(paramChar);
    }
  }

  public static String a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      String str = new String(paramArrayOfByte, paramInt1, paramInt2, "UTF8");
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
    }
    throw new Error("UTF-8 to string conversion failed: " + localUnsupportedEncodingException.getMessage());
  }

  private static void a(String paramString, short paramShort)
  {
    for (int i = 0; ; i++)
    {
      if (i >= paramString.length())
        return;
      int j = paramString.charAt(i);
      short[] arrayOfShort = a;
      arrayOfShort[j] = (paramShort | arrayOfShort[j]);
    }
  }

  static boolean a(char paramChar)
  {
    if (((paramChar < 'A') || (paramChar > 'Z')) && ((paramChar < 'a') || (paramChar > 'z')) && ((paramChar < 'À') || (paramChar > 'Ö')) && ((paramChar < 'Ø') || (paramChar > 'ö')) && ((paramChar < 'ø') || (paramChar > 'ÿ')) && ((paramChar < 'Ā') || (paramChar > 'ı')) && ((paramChar < 'Ĵ') || (paramChar > 'ľ')) && ((paramChar < 'Ł') || (paramChar > 'ň')) && ((paramChar < 'Ŋ') || (paramChar > 'ž')) && ((paramChar < 'ƀ') || (paramChar > 'ǃ')) && ((paramChar < 'Ǎ') || (paramChar > 'ǰ')) && ((paramChar < 'Ǵ') || (paramChar > 'ǵ')) && ((paramChar < 'Ǻ') || (paramChar > 'ȗ')) && ((paramChar < 'ɐ') || (paramChar > 'ʨ')) && ((paramChar < 'ʻ') || (paramChar > 'ˁ')) && (paramChar != 'Ά') && ((paramChar < 'Έ') || (paramChar > 'Ί')) && (paramChar != 'Ό') && ((paramChar < 'Ύ') || (paramChar > 'Ρ')) && ((paramChar < 'Σ') || (paramChar > 'ώ')) && ((paramChar < 'ϐ') || (paramChar > 'ϖ')) && (paramChar != 'Ϛ') && (paramChar != 'Ϝ') && (paramChar != 'Ϟ') && (paramChar != 'Ϡ') && ((paramChar < 'Ϣ') || (paramChar > 'ϳ')) && ((paramChar < 'Ё') || (paramChar > 'Ќ')) && ((paramChar < 'Ў') || (paramChar > 'я')) && ((paramChar < 'ё') || (paramChar > 'ќ')) && ((paramChar < 'ў') || (paramChar > 'ҁ')) && ((paramChar < 'Ґ') || (paramChar > 'ӄ')) && ((paramChar < 'Ӈ') || (paramChar > 'ӈ')) && ((paramChar < 'Ӌ') || (paramChar > 'ӌ')) && ((paramChar < 'Ӑ') || (paramChar > 'ӫ')) && ((paramChar < 'Ӯ') || (paramChar > 'ӵ')) && ((paramChar < 'Ӹ') || (paramChar > 'ӹ')) && ((paramChar < 'Ա') || (paramChar > 'Ֆ')) && (paramChar != 'ՙ') && ((paramChar < 'ա') || (paramChar > 'ֆ')) && ((paramChar < 'א') || (paramChar > 'ת')) && ((paramChar < 'װ') || (paramChar > 'ײ')) && ((paramChar < 'ء') || (paramChar > 'غ')) && ((paramChar < 'ف') || (paramChar > 'ي')) && ((paramChar < 'ٱ') || (paramChar > 'ڷ')) && ((paramChar < 'ں') || (paramChar > 'ھ')) && ((paramChar < 'ۀ') || (paramChar > 'ێ')) && ((paramChar < 'ې') || (paramChar > 'ۓ')) && (paramChar != 'ە') && ((paramChar < 'ۥ') || (paramChar > 'ۦ')) && ((paramChar < 'अ') || (paramChar > 'ह')) && (paramChar != 'ऽ') && ((paramChar < 'क़') || (paramChar > 'ॡ')) && ((paramChar < 'অ') || (paramChar > 'ঌ')) && ((paramChar < 'এ') || (paramChar > 'ঐ')) && ((paramChar < 'ও') || (paramChar > 'ন')) && ((paramChar < 'প') || (paramChar > 'র')) && (paramChar != 'ল') && ((paramChar < 'শ') || (paramChar > 'হ')) && ((paramChar < 'ড়') || (paramChar > 'ঢ়')) && ((paramChar < 'য়') || (paramChar > 'ৡ')) && ((paramChar < 'ৰ') || (paramChar > 'ৱ')) && ((paramChar < 'ਅ') || (paramChar > 'ਊ')) && ((paramChar < 'ਏ') || (paramChar > 'ਐ')) && ((paramChar < 'ਓ') || (paramChar > 'ਨ')) && ((paramChar < 'ਪ') || (paramChar > 'ਰ')) && ((paramChar < 'ਲ') || (paramChar > 'ਲ਼')) && ((paramChar < 'ਵ') || (paramChar > 'ਸ਼')) && ((paramChar < 'ਸ') || (paramChar > 'ਹ')) && ((paramChar < 'ਖ਼') || (paramChar > 'ੜ')) && (paramChar != 'ਫ਼') && ((paramChar < 'ੲ') || (paramChar > 'ੴ')) && ((paramChar < 'અ') || (paramChar > 'ઋ')) && (paramChar != 'ઍ') && ((paramChar < 'એ') || (paramChar > 'ઑ')) && ((paramChar < 'ઓ') || (paramChar > 'ન')) && ((paramChar < 'પ') || (paramChar > 'ર')) && ((paramChar < 'લ') || (paramChar > 'ળ')) && ((paramChar < 'વ') || (paramChar > 'હ')) && (paramChar != 'ઽ') && (paramChar != 'ૠ') && ((paramChar < 'ଅ') || (paramChar > 'ଌ')) && ((paramChar < 'ଏ') || (paramChar > 'ଐ')) && ((paramChar < 'ଓ') || (paramChar > 'ନ')) && ((paramChar < 'ପ') || (paramChar > 'ର')) && ((paramChar < 'ଲ') || (paramChar > 'ଳ')) && ((paramChar < 'ଶ') || (paramChar > 'ହ')) && (paramChar != 'ଽ') && ((paramChar < 'ଡ଼') || (paramChar > 'ଢ଼')) && ((paramChar < 'ୟ') || (paramChar > 'ୡ')) && ((paramChar < 'அ') || (paramChar > 'ஊ')) && ((paramChar < 'எ') || (paramChar > 'ஐ')) && ((paramChar < 'ஒ') || (paramChar > 'க')) && ((paramChar < 'ங') || (paramChar > 'ச')) && (paramChar != 'ஜ') && ((paramChar < 'ஞ') || (paramChar > 'ட')) && ((paramChar < 'ண') || (paramChar > 'த')) && ((paramChar < 'ந') || (paramChar > 'ப')) && ((paramChar < 'ம') || (paramChar > 'வ')) && ((paramChar < 'ஷ') || (paramChar > 'ஹ')) && ((paramChar < 'అ') || (paramChar > 'ఌ')) && ((paramChar < 'ఎ') || (paramChar > 'ఐ')) && ((paramChar < 'ఒ') || (paramChar > 'న')) && ((paramChar < 'ప') || (paramChar > 'ళ')) && ((paramChar < 'వ') || (paramChar > 'హ')) && ((paramChar < 'ౠ') || (paramChar > 'ౡ')) && ((paramChar < 'ಅ') || (paramChar > 'ಌ')) && ((paramChar < 'ಎ') || (paramChar > 'ಐ')) && ((paramChar < 'ಒ') || (paramChar > 'ನ')) && ((paramChar < 'ಪ') || (paramChar > 'ಳ')) && ((paramChar < 'ವ') || (paramChar > 'ಹ')) && (paramChar != 'ೞ') && ((paramChar < 'ೠ') || (paramChar > 'ೡ')) && ((paramChar < 'അ') || (paramChar > 'ഌ')) && ((paramChar < 'എ') || (paramChar > 'ഐ')) && ((paramChar < 'ഒ') || (paramChar > 'ന')) && ((paramChar < 'പ') || (paramChar > 'ഹ')) && ((paramChar < 'ൠ') || (paramChar > 'ൡ')) && ((paramChar < 'ก') || (paramChar > 'ฮ')) && (paramChar != 'ะ') && ((paramChar < 'า') || (paramChar > 'ำ')) && ((paramChar < 'เ') || (paramChar > 'ๅ')) && ((paramChar < 'ກ') || (paramChar > 'ຂ')) && (paramChar != 'ຄ') && ((paramChar < 'ງ') || (paramChar > 'ຈ')) && (paramChar != 'ຊ') && (paramChar != 'ຍ') && ((paramChar < 'ດ') || (paramChar > 'ທ')) && ((paramChar < 'ນ') || (paramChar > 'ຟ')) && ((paramChar < 'ມ') || (paramChar > 'ຣ')) && (paramChar != 'ລ') && (paramChar != 'ວ') && ((paramChar < 'ສ') || (paramChar > 'ຫ')) && ((paramChar < 'ອ') || (paramChar > 'ຮ')) && (paramChar != 'ະ') && ((paramChar < 'າ') || (paramChar > 'ຳ')) && (paramChar != 'ຽ') && ((paramChar < 'ເ') || (paramChar > 'ໄ')) && ((paramChar < 'ཀ') || (paramChar > 'ཇ')) && ((paramChar < 'ཉ') || (paramChar > 'ཀྵ')) && ((paramChar < 'Ⴀ') || (paramChar > 'Ⴥ')) && ((paramChar < 'ა') || (paramChar > 'ჶ')) && (paramChar != 'ᄀ') && ((paramChar < 'ᄂ') || (paramChar > 'ᄃ')) && ((paramChar < 'ᄅ') || (paramChar > 'ᄇ')) && (paramChar != 'ᄉ') && ((paramChar < 'ᄋ') || (paramChar > 'ᄌ')) && ((paramChar < 'ᄎ') || (paramChar > 'ᄒ')) && (paramChar != 'ᄼ') && (paramChar != 'ᄾ') && (paramChar != 'ᅀ') && (paramChar != 'ᅌ') && (paramChar != 'ᅎ') && (paramChar != 'ᅐ') && ((paramChar < 'ᅔ') || (paramChar > 'ᅕ')) && (paramChar != 'ᅙ') && ((paramChar < 'ᅟ') || (paramChar > 'ᅡ')) && (paramChar != 'ᅣ') && (paramChar != 'ᅥ') && (paramChar != 'ᅧ') && (paramChar != 'ᅩ') && ((paramChar < 'ᅭ') || (paramChar > 'ᅮ')) && ((paramChar < 'ᅲ') || (paramChar > 'ᅳ')) && (paramChar != 'ᅵ') && (paramChar != 'ᆞ') && (paramChar != 'ᆨ') && (paramChar != 'ᆫ') && ((paramChar < 'ᆮ') || (paramChar > 'ᆯ')) && ((paramChar < 'ᆷ') || (paramChar > 'ᆸ')) && (paramChar != 'ᆺ') && ((paramChar < 'ᆼ') || (paramChar > 'ᇂ')) && (paramChar != 'ᇫ') && (paramChar != 'ᇰ') && (paramChar != 'ᇹ') && ((paramChar < 'Ḁ') || (paramChar > 'ẛ')) && ((paramChar < 'Ạ') || (paramChar > 'ỹ')) && ((paramChar < 'ἀ') || (paramChar > 'ἕ')) && ((paramChar < 'Ἐ') || (paramChar > 'Ἕ')) && ((paramChar < 'ἠ') || (paramChar > 'ὅ')) && ((paramChar < 'Ὀ') || (paramChar > 'Ὅ')) && ((paramChar < 'ὐ') || (paramChar > 'ὗ')) && (paramChar != 'Ὑ') && (paramChar != 'Ὓ') && (paramChar != 'Ὕ') && ((paramChar < 'Ὗ') || (paramChar > 'ώ')) && ((paramChar < 'ᾀ') || (paramChar > 'ᾴ')) && ((paramChar < 'ᾶ') || (paramChar > 'ᾼ')) && (paramChar != 'ι') && ((paramChar < 'ῂ') || (paramChar > 'ῄ')) && ((paramChar < 'ῆ') || (paramChar > 'ῌ')) && ((paramChar < 'ῐ') || (paramChar > 'ΐ')) && ((paramChar < 'ῖ') || (paramChar > 'Ί')) && ((paramChar < 'ῠ') || (paramChar > 'Ῥ')) && ((paramChar < 'ῲ') || (paramChar > 'ῴ')) && ((paramChar < 'ῶ') || (paramChar > 'ῼ')) && (paramChar != 'Ω') && ((paramChar < 'K') || (paramChar > 'Å')) && (paramChar != '℮') && ((paramChar < 'ↀ') || (paramChar > 'ↂ')) && ((paramChar < 'ぁ') || (paramChar > 'ゔ')) && ((paramChar < 'ァ') || (paramChar > 'ヺ')) && ((paramChar < 'ㄅ') || (paramChar > 'ㄬ')) && ((paramChar < 44032) || (paramChar > 55203)) && ((paramChar < '一') || (paramChar > 40869)) && (paramChar != '〇') && ((paramChar < '〡') || (paramChar > '〩')) && ((paramChar < '一') || (paramChar > 40869)) && (paramChar != '〇') && ((paramChar < '〡') || (paramChar > '〩')));
    for (int i = 0; ; i = 1)
      return i;
  }

  static boolean a(int paramInt)
  {
    if (paramInt != 0);
    for (int i = 1; ; i = 0)
      return i;
  }

  public static boolean a(String paramString1, String paramString2, int paramInt)
  {
    int i = 0;
    int j = paramString1.length();
    int k = 0;
    while (true)
    {
      if (j >= paramInt);
      while (true)
      {
        return i;
        String str = paramString2.substring(k, k + j);
        if (!paramString1.equalsIgnoreCase(str))
          break;
        if (paramString1.equals(str))
          continue;
        i = 1;
      }
      k++;
      paramInt--;
    }
  }

  static boolean a(String[] paramArrayOfString, String paramString)
  {
    int i = 0;
    int j = paramArrayOfString.length;
    for (int k = 0; ; k++)
    {
      if (k >= j);
      while (true)
      {
        return i;
        if (!paramArrayOfString[k].equalsIgnoreCase(paramString))
          break;
        i = 1;
      }
    }
  }

  public static byte[] a(String paramString)
  {
    try
    {
      byte[] arrayOfByte = paramString.getBytes("UTF8");
      return arrayOfByte;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
    }
    throw new Error("String to UTF-8 conversion failed: " + localUnsupportedEncodingException.getMessage());
  }

  static int b(int paramInt)
  {
    return paramInt & 0xFF;
  }

  public static int b(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0));
    for (int i = paramString.charAt(-1 + paramString.length()); ; i = 0)
      return i;
  }

  static boolean b(char paramChar)
  {
    if ((!a(paramChar)) && (paramChar != '.') && (paramChar != '_') && (paramChar != ':') && (paramChar != '-') && ((paramChar < '̀') || (paramChar > 'ͅ')) && ((paramChar < '͠') || (paramChar > '͡')) && ((paramChar < '҃') || (paramChar > '҆')) && ((paramChar < '֑') || (paramChar > '֡')) && ((paramChar < '֣') || (paramChar > 'ֹ')) && ((paramChar < 'ֻ') || (paramChar > 'ֽ')) && (paramChar != 'ֿ') && ((paramChar < 'ׁ') || (paramChar > 'ׂ')) && (paramChar != 'ׄ') && ((paramChar < 'ً') || (paramChar > 'ْ')) && (paramChar != 'ٰ') && ((paramChar < 'ۖ') || (paramChar > 'ۜ')) && ((paramChar < '۝') || (paramChar > '۟')) && ((paramChar < '۠') || (paramChar > 'ۤ')) && ((paramChar < 'ۧ') || (paramChar > 'ۨ')) && ((paramChar < '۪') || (paramChar > 'ۭ')) && ((paramChar < 'ँ') || (paramChar > 'ः')) && (paramChar != '़') && ((paramChar < 'ा') || (paramChar > 'ौ')) && (paramChar != '्') && ((paramChar < '॑') || (paramChar > '॔')) && ((paramChar < 'ॢ') || (paramChar > 'ॣ')) && ((paramChar < 'ঁ') || (paramChar > 'ঃ')) && (paramChar != '়') && (paramChar != 'া') && (paramChar != 'ি') && ((paramChar < 'ী') || (paramChar > 'ৄ')) && ((paramChar < 'ে') || (paramChar > 'ৈ')) && ((paramChar < 'ো') || (paramChar > '্')) && (paramChar != 'ৗ') && ((paramChar < 'ৢ') || (paramChar > 'ৣ')) && (paramChar != 'ਂ') && (paramChar != '਼') && (paramChar != 'ਾ') && (paramChar != 'ਿ') && ((paramChar < 'ੀ') || (paramChar > 'ੂ')) && ((paramChar < 'ੇ') || (paramChar > 'ੈ')) && ((paramChar < 'ੋ') || (paramChar > '੍')) && ((paramChar < 'ੰ') || (paramChar > 'ੱ')) && ((paramChar < 'ઁ') || (paramChar > 'ઃ')) && (paramChar != '઼') && ((paramChar < 'ા') || (paramChar > 'ૅ')) && ((paramChar < 'ે') || (paramChar > 'ૉ')) && ((paramChar < 'ો') || (paramChar > '્')) && ((paramChar < 'ଁ') || (paramChar > 'ଃ')) && (paramChar != '଼') && ((paramChar < 'ା') || (paramChar > 'ୃ')) && ((paramChar < 'େ') || (paramChar > 'ୈ')) && ((paramChar < 'ୋ') || (paramChar > '୍')) && ((paramChar < 'ୖ') || (paramChar > 'ୗ')) && ((paramChar < 'ஂ') || (paramChar > 'ஃ')) && ((paramChar < 'ா') || (paramChar > 'ூ')) && ((paramChar < 'ெ') || (paramChar > 'ை')) && ((paramChar < 'ொ') || (paramChar > '்')) && (paramChar != 'ௗ') && ((paramChar < 'ఁ') || (paramChar > 'ః')) && ((paramChar < 'ా') || (paramChar > 'ౄ')) && ((paramChar < 'ె') || (paramChar > 'ై')) && ((paramChar < 'ొ') || (paramChar > '్')) && ((paramChar < 'ౕ') || (paramChar > 'ౖ')) && ((paramChar < 'ಂ') || (paramChar > 'ಃ')) && ((paramChar < 'ಾ') || (paramChar > 'ೄ')) && ((paramChar < 'ೆ') || (paramChar > 'ೈ')) && ((paramChar < 'ೊ') || (paramChar > '್')) && ((paramChar < 'ೕ') || (paramChar > 'ೖ')) && ((paramChar < 'ം') || (paramChar > 'ഃ')) && ((paramChar < 'ാ') || (paramChar > 'ൃ')) && ((paramChar < 'െ') || (paramChar > 'ൈ')) && ((paramChar < 'ൊ') || (paramChar > '്')) && (paramChar != 'ൗ') && (paramChar != 'ั') && ((paramChar < 'ิ') || (paramChar > 'ฺ')) && ((paramChar < '็') || (paramChar > '๎')) && (paramChar != 'ັ') && ((paramChar < 'ິ') || (paramChar > 'ູ')) && ((paramChar < 'ົ') || (paramChar > 'ຼ')) && ((paramChar < '່') || (paramChar > 'ໍ')) && ((paramChar < '༘') || (paramChar > '༙')) && (paramChar != '༵') && (paramChar != '༷') && (paramChar != '༹') && (paramChar != '༾') && (paramChar != '༿') && ((paramChar < 'ཱ') || (paramChar > '྄')) && ((paramChar < '྆') || (paramChar > 'ྋ')) && ((paramChar < 'ྐ') || (paramChar > 'ྕ')) && (paramChar != 'ྗ') && ((paramChar < 'ྙ') || (paramChar > 'ྭ')) && ((paramChar < 'ྱ') || (paramChar > 'ྷ')) && (paramChar != 'ྐྵ') && ((paramChar < '⃐') || (paramChar > '⃜')) && (paramChar != '⃡') && ((paramChar < '〪') || (paramChar > '〯')) && (paramChar != '゙') && (paramChar != '゚') && ((paramChar < '0') || (paramChar > '9')) && ((paramChar < '٠') || (paramChar > '٩')) && ((paramChar < '۰') || (paramChar > '۹')) && ((paramChar < '०') || (paramChar > '९')) && ((paramChar < '০') || (paramChar > '৯')) && ((paramChar < '੦') || (paramChar > '੯')) && ((paramChar < '૦') || (paramChar > '૯')) && ((paramChar < '୦') || (paramChar > '୯')) && ((paramChar < '௧') || (paramChar > '௯')) && ((paramChar < '౦') || (paramChar > '౯')) && ((paramChar < '೦') || (paramChar > '೯')) && ((paramChar < '൦') || (paramChar > '൯')) && ((paramChar < '๐') || (paramChar > '๙')) && ((paramChar < '໐') || (paramChar > '໙')) && ((paramChar < '༠') || (paramChar > '༩')) && (paramChar != '·') && (paramChar != 'ː') && (paramChar != 'ˑ') && (paramChar != '·') && (paramChar != 'ـ') && (paramChar != 'ๆ') && (paramChar != 'ໆ') && (paramChar != '々') && ((paramChar < '〱') || (paramChar > '〵')) && ((paramChar < 'ゝ') || (paramChar > 'ゞ')) && ((paramChar < 'ー') || (paramChar > 'ヾ')));
    for (int i = 0; ; i = 1)
      return i;
  }

  public static boolean c(char paramChar)
  {
    return a(0x8 & k(paramChar));
  }

  public static boolean d(char paramChar)
  {
    return a(0x1 & k(paramChar));
  }

  public static boolean e(char paramChar)
  {
    return a(0x2 & k(paramChar));
  }

  public static boolean f(char paramChar)
  {
    return a(0x4 & k(paramChar));
  }

  public static boolean g(char paramChar)
  {
    return a(0x20 & k(paramChar));
  }

  public static boolean h(char paramChar)
  {
    return a(0x40 & k(paramChar));
  }

  public static char i(char paramChar)
  {
    if (a(0x40 & k(paramChar)))
      paramChar = -65 + (paramChar + 'a');
    return paramChar;
  }

  public static char j(char paramChar)
  {
    if (a(0x20 & k(paramChar)))
      paramChar = -97 + (paramChar + 'A');
    return paramChar;
  }

  private static short k(char paramChar)
  {
    if (paramChar < '');
    for (int i = a[paramChar]; ; i = 0)
      return i;
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     a.a.a.do
 * JD-Core Version:    0.6.0
 */