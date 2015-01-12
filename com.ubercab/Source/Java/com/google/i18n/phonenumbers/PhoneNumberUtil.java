package com.google.i18n.phonenumbers;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumberUtil
{
  private static final Map<Character, Character> ALL_PLUS_NUMBER_GROUPING_SYMBOLS;
  private static final Map<Character, Character> ALPHA_MAPPINGS;
  private static final Map<Character, Character> ALPHA_PHONE_MAPPINGS;
  private static final Pattern CAPTURING_DIGIT_PATTERN;
  private static final String CAPTURING_EXTN_DIGITS = "(\\p{Nd}{1,7})";
  private static final Pattern CC_PATTERN;
  private static final String COLOMBIA_MOBILE_TO_FIXED_LINE_PREFIX = "3";
  private static final String DEFAULT_EXTN_PREFIX = " ext. ";
  static final MetadataLoader DEFAULT_METADATA_LOADER = new MetadataLoader()
  {
    public InputStream loadMetadata(String paramAnonymousString)
    {
      return PhoneNumberUtil.class.getResourceAsStream(paramAnonymousString);
    }
  };
  private static final Map<Character, Character> DIALLABLE_CHAR_MAPPINGS;
  private static final String DIGITS = "\\p{Nd}";
  private static final Pattern EXTN_PATTERN;
  static final String EXTN_PATTERNS_FOR_MATCHING;
  private static final String EXTN_PATTERNS_FOR_PARSING;
  private static final Pattern FG_PATTERN;
  private static final Pattern FIRST_GROUP_ONLY_PREFIX_PATTERN;
  private static final Pattern FIRST_GROUP_PATTERN;
  private static final int MAX_INPUT_STRING_LENGTH = 250;
  static final int MAX_LENGTH_COUNTRY_CODE = 3;
  static final int MAX_LENGTH_FOR_NSN = 17;
  private static final String META_DATA_FILE_PREFIX = "/com/google/i18n/phonenumbers/data/PhoneNumberMetadataProto";
  private static final int MIN_LENGTH_FOR_NSN = 2;
  private static final Map<Integer, String> MOBILE_TOKEN_MAPPINGS;
  private static final int NANPA_COUNTRY_CODE = 1;
  static final Pattern NON_DIGITS_PATTERN;
  private static final Pattern NP_PATTERN;
  static final String PLUS_CHARS = "+＋";
  static final Pattern PLUS_CHARS_PATTERN;
  static final char PLUS_SIGN = '+';
  static final int REGEX_FLAGS = 66;
  public static final String REGION_CODE_FOR_NON_GEO_ENTITY = "001";
  private static final String RFC3966_EXTN_PREFIX = ";ext=";
  private static final String RFC3966_ISDN_SUBADDRESS = ";isub=";
  private static final String RFC3966_PHONE_CONTEXT = ";phone-context=";
  private static final String RFC3966_PREFIX = "tel:";
  private static final String SECOND_NUMBER_START = "[\\\\/] *x";
  static final Pattern SECOND_NUMBER_START_PATTERN;
  private static final Pattern SEPARATOR_PATTERN;
  private static final char STAR_SIGN = '*';
  private static final Pattern UNIQUE_INTERNATIONAL_PREFIX;
  private static final String UNKNOWN_REGION = "ZZ";
  private static final String UNWANTED_END_CHARS = "[[\\P{N}&&\\P{L}]&&[^#]]+$";
  static final Pattern UNWANTED_END_CHAR_PATTERN;
  private static final String VALID_ALPHA;
  private static final Pattern VALID_ALPHA_PHONE_PATTERN;
  private static final String VALID_PHONE_NUMBER;
  private static final Pattern VALID_PHONE_NUMBER_PATTERN;
  static final String VALID_PUNCTUATION = "-x‐-―−ー－-／  ­​⁠　()（）［］.\\[\\]/~⁓∼～";
  private static final String VALID_START_CHAR = "[+＋\\p{Nd}]";
  private static final Pattern VALID_START_CHAR_PATTERN;
  private static PhoneNumberUtil instance;
  private static final Logger logger = Logger.getLogger(PhoneNumberUtil.class.getName());
  private final Map<Integer, List<String>> countryCallingCodeToRegionCodeMap;
  private final Map<Integer, Phonemetadata.PhoneMetadata> countryCodeToNonGeographicalMetadataMap = Collections.synchronizedMap(new HashMap());
  private final Set<Integer> countryCodesForNonGeographicalRegion = new HashSet();
  private final String currentFilePrefix;
  private final MetadataLoader metadataLoader;
  private final Set<String> nanpaRegions = new HashSet(35);
  private final RegexCache regexCache = new RegexCache(100);
  private final Map<String, Phonemetadata.PhoneMetadata> regionToMetadataMap = Collections.synchronizedMap(new HashMap());
  private final Set<String> supportedRegions = new HashSet(320);

  static
  {
    HashMap localHashMap1 = new HashMap();
    localHashMap1.put(Integer.valueOf(52), "1");
    localHashMap1.put(Integer.valueOf(54), "9");
    MOBILE_TOKEN_MAPPINGS = Collections.unmodifiableMap(localHashMap1);
    HashMap localHashMap2 = new HashMap();
    localHashMap2.put(Character.valueOf('0'), Character.valueOf('0'));
    localHashMap2.put(Character.valueOf('1'), Character.valueOf('1'));
    localHashMap2.put(Character.valueOf('2'), Character.valueOf('2'));
    localHashMap2.put(Character.valueOf('3'), Character.valueOf('3'));
    localHashMap2.put(Character.valueOf('4'), Character.valueOf('4'));
    localHashMap2.put(Character.valueOf('5'), Character.valueOf('5'));
    localHashMap2.put(Character.valueOf('6'), Character.valueOf('6'));
    localHashMap2.put(Character.valueOf('7'), Character.valueOf('7'));
    localHashMap2.put(Character.valueOf('8'), Character.valueOf('8'));
    localHashMap2.put(Character.valueOf('9'), Character.valueOf('9'));
    HashMap localHashMap3 = new HashMap(40);
    localHashMap3.put(Character.valueOf('A'), Character.valueOf('2'));
    localHashMap3.put(Character.valueOf('B'), Character.valueOf('2'));
    localHashMap3.put(Character.valueOf('C'), Character.valueOf('2'));
    localHashMap3.put(Character.valueOf('D'), Character.valueOf('3'));
    localHashMap3.put(Character.valueOf('E'), Character.valueOf('3'));
    localHashMap3.put(Character.valueOf('F'), Character.valueOf('3'));
    localHashMap3.put(Character.valueOf('G'), Character.valueOf('4'));
    localHashMap3.put(Character.valueOf('H'), Character.valueOf('4'));
    localHashMap3.put(Character.valueOf('I'), Character.valueOf('4'));
    localHashMap3.put(Character.valueOf('J'), Character.valueOf('5'));
    localHashMap3.put(Character.valueOf('K'), Character.valueOf('5'));
    localHashMap3.put(Character.valueOf('L'), Character.valueOf('5'));
    localHashMap3.put(Character.valueOf('M'), Character.valueOf('6'));
    localHashMap3.put(Character.valueOf('N'), Character.valueOf('6'));
    localHashMap3.put(Character.valueOf('O'), Character.valueOf('6'));
    localHashMap3.put(Character.valueOf('P'), Character.valueOf('7'));
    localHashMap3.put(Character.valueOf('Q'), Character.valueOf('7'));
    localHashMap3.put(Character.valueOf('R'), Character.valueOf('7'));
    localHashMap3.put(Character.valueOf('S'), Character.valueOf('7'));
    localHashMap3.put(Character.valueOf('T'), Character.valueOf('8'));
    localHashMap3.put(Character.valueOf('U'), Character.valueOf('8'));
    localHashMap3.put(Character.valueOf('V'), Character.valueOf('8'));
    localHashMap3.put(Character.valueOf('W'), Character.valueOf('9'));
    localHashMap3.put(Character.valueOf('X'), Character.valueOf('9'));
    localHashMap3.put(Character.valueOf('Y'), Character.valueOf('9'));
    localHashMap3.put(Character.valueOf('Z'), Character.valueOf('9'));
    ALPHA_MAPPINGS = Collections.unmodifiableMap(localHashMap3);
    HashMap localHashMap4 = new HashMap(100);
    localHashMap4.putAll(ALPHA_MAPPINGS);
    localHashMap4.putAll(localHashMap2);
    ALPHA_PHONE_MAPPINGS = Collections.unmodifiableMap(localHashMap4);
    HashMap localHashMap5 = new HashMap();
    localHashMap5.putAll(localHashMap2);
    localHashMap5.put(Character.valueOf('+'), Character.valueOf('+'));
    localHashMap5.put(Character.valueOf('*'), Character.valueOf('*'));
    DIALLABLE_CHAR_MAPPINGS = Collections.unmodifiableMap(localHashMap5);
    HashMap localHashMap6 = new HashMap();
    Iterator localIterator = ALPHA_MAPPINGS.keySet().iterator();
    while (localIterator.hasNext())
    {
      char c = ((Character)localIterator.next()).charValue();
      localHashMap6.put(Character.valueOf(Character.toLowerCase(c)), Character.valueOf(c));
      localHashMap6.put(Character.valueOf(c), Character.valueOf(c));
    }
    localHashMap6.putAll(localHashMap2);
    localHashMap6.put(Character.valueOf('-'), Character.valueOf('-'));
    localHashMap6.put(Character.valueOf(65293), Character.valueOf('-'));
    localHashMap6.put(Character.valueOf('‐'), Character.valueOf('-'));
    localHashMap6.put(Character.valueOf('‑'), Character.valueOf('-'));
    localHashMap6.put(Character.valueOf('‒'), Character.valueOf('-'));
    localHashMap6.put(Character.valueOf('–'), Character.valueOf('-'));
    localHashMap6.put(Character.valueOf('—'), Character.valueOf('-'));
    localHashMap6.put(Character.valueOf('―'), Character.valueOf('-'));
    localHashMap6.put(Character.valueOf('−'), Character.valueOf('-'));
    localHashMap6.put(Character.valueOf('/'), Character.valueOf('/'));
    localHashMap6.put(Character.valueOf(65295), Character.valueOf('/'));
    localHashMap6.put(Character.valueOf(' '), Character.valueOf(' '));
    localHashMap6.put(Character.valueOf('　'), Character.valueOf(' '));
    localHashMap6.put(Character.valueOf('⁠'), Character.valueOf(' '));
    localHashMap6.put(Character.valueOf('.'), Character.valueOf('.'));
    localHashMap6.put(Character.valueOf(65294), Character.valueOf('.'));
    ALL_PLUS_NUMBER_GROUPING_SYMBOLS = Collections.unmodifiableMap(localHashMap6);
    UNIQUE_INTERNATIONAL_PREFIX = Pattern.compile("[\\d]+(?:[~⁓∼～][\\d]+)?");
    String str1 = String.valueOf(Arrays.toString(ALPHA_MAPPINGS.keySet().toArray()).replaceAll("[, \\[\\]]", ""));
    String str2 = String.valueOf(Arrays.toString(ALPHA_MAPPINGS.keySet().toArray()).toLowerCase().replaceAll("[, \\[\\]]", ""));
    String str3;
    String str7;
    if (str2.length() != 0)
    {
      str3 = str1.concat(str2);
      VALID_ALPHA = str3;
      PLUS_CHARS_PATTERN = Pattern.compile("[+＋]+");
      SEPARATOR_PATTERN = Pattern.compile("[-x‐-―−ー－-／  ­​⁠　()（）［］.\\[\\]/~⁓∼～]+");
      CAPTURING_DIGIT_PATTERN = Pattern.compile("(\\p{Nd})");
      VALID_START_CHAR_PATTERN = Pattern.compile("[+＋\\p{Nd}]");
      SECOND_NUMBER_START_PATTERN = Pattern.compile("[\\\\/] *x");
      UNWANTED_END_CHAR_PATTERN = Pattern.compile("[[\\P{N}&&\\P{L}]&&[^#]]+$");
      VALID_ALPHA_PHONE_PATTERN = Pattern.compile("(?:.*?[A-Za-z]){3}.*");
      String str4 = String.valueOf(String.valueOf("\\p{Nd}{2}|[+＋]*+(?:[-x‐-―−ー－-／  ­​⁠　()（）［］.\\[\\]/~⁓∼～*]*\\p{Nd}){3,}[-x‐-―−ー－-／  ­​⁠　()（）［］.\\[\\]/~⁓∼～*"));
      String str5 = String.valueOf(String.valueOf(VALID_ALPHA));
      String str6 = String.valueOf(String.valueOf("\\p{Nd}"));
      VALID_PHONE_NUMBER = 2 + str4.length() + str5.length() + str6.length() + str4 + str5 + str6 + "]*";
      str7 = String.valueOf("xｘ#＃~～");
      if (str7.length() == 0)
        break label1585;
    }
    label1585: for (String str8 = ",".concat(str7); ; str8 = new String(","))
    {
      EXTN_PATTERNS_FOR_PARSING = createExtnPattern(str8);
      EXTN_PATTERNS_FOR_MATCHING = createExtnPattern("xｘ#＃~～");
      String str9 = String.valueOf(String.valueOf(EXTN_PATTERNS_FOR_PARSING));
      EXTN_PATTERN = Pattern.compile(5 + str9.length() + "(?:" + str9 + ")$", 66);
      String str10 = String.valueOf(String.valueOf(VALID_PHONE_NUMBER));
      String str11 = String.valueOf(String.valueOf(EXTN_PATTERNS_FOR_PARSING));
      VALID_PHONE_NUMBER_PATTERN = Pattern.compile(5 + str10.length() + str11.length() + str10 + "(?:" + str11 + ")?", 66);
      NON_DIGITS_PATTERN = Pattern.compile("(\\D+)");
      FIRST_GROUP_PATTERN = Pattern.compile("(\\$\\d)");
      NP_PATTERN = Pattern.compile("\\$NP");
      FG_PATTERN = Pattern.compile("\\$FG");
      CC_PATTERN = Pattern.compile("\\$CC");
      FIRST_GROUP_ONLY_PREFIX_PATTERN = Pattern.compile("\\(?\\$1\\)?");
      instance = null;
      return;
      str3 = new String(str1);
      break;
    }
  }

  PhoneNumberUtil(String paramString, MetadataLoader paramMetadataLoader, Map<Integer, List<String>> paramMap)
  {
    this.currentFilePrefix = paramString;
    this.metadataLoader = paramMetadataLoader;
    this.countryCallingCodeToRegionCodeMap = paramMap;
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      List localList = (List)localEntry.getValue();
      if ((localList.size() == 1) && ("001".equals(localList.get(0))))
        this.countryCodesForNonGeographicalRegion.add(localEntry.getKey());
      else
        this.supportedRegions.addAll(localList);
    }
    if (this.supportedRegions.remove("001"))
      logger.log(Level.WARNING, "invalid metadata (country calling code was mapped to the non-geo entity as well as specific region(s))");
    this.nanpaRegions.addAll((Collection)paramMap.get(Integer.valueOf(1)));
  }

  private void buildNationalNumberForParsing(String paramString, StringBuilder paramStringBuilder)
  {
    int i = paramString.indexOf(";phone-context=");
    int k;
    int n;
    if (i > 0)
    {
      k = i + ";phone-context=".length();
      if (paramString.charAt(k) == '+')
      {
        int i1 = paramString.indexOf(';', k);
        if (i1 > 0)
          paramStringBuilder.append(paramString.substring(k, i1));
      }
      else
      {
        int m = paramString.indexOf("tel:");
        if (m < 0)
          break label133;
        n = m + "tel:".length();
        label82: paramStringBuilder.append(paramString.substring(n, i));
      }
    }
    while (true)
    {
      int j = paramStringBuilder.indexOf(";isub=");
      if (j > 0)
        paramStringBuilder.delete(j, paramStringBuilder.length());
      return;
      paramStringBuilder.append(paramString.substring(k));
      break;
      label133: n = 0;
      break label82;
      paramStringBuilder.append(extractPossibleNumber(paramString));
    }
  }

  private boolean checkRegionForParsing(String paramString1, String paramString2)
  {
    return (isValidRegionCode(paramString2)) || ((paramString1 != null) && (paramString1.length() != 0) && (PLUS_CHARS_PATTERN.matcher(paramString1).lookingAt()));
  }

  public static String convertAlphaCharactersInNumber(String paramString)
  {
    return normalizeHelper(paramString, ALPHA_PHONE_MAPPINGS, false);
  }

  private static String createExtnPattern(String paramString)
  {
    String str1 = String.valueOf(String.valueOf(";ext=(\\p{Nd}{1,7})|[  \\t,]*(?:e?xt(?:ensi(?:ó?|ó))?n?|ｅ?ｘｔｎ?|["));
    String str2 = String.valueOf(String.valueOf(paramString));
    String str3 = String.valueOf(String.valueOf("(\\p{Nd}{1,7})"));
    String str4 = String.valueOf(String.valueOf("\\p{Nd}"));
    return 48 + str1.length() + str2.length() + str3.length() + str4.length() + str1 + str2 + "]|int|anexo|ｉｎｔ)" + "[:\\.．]?[  \\t,-]*" + str3 + "#?|" + "[- ]+(" + str4 + "{1,5})#";
  }

  public static PhoneNumberUtil createInstance(MetadataLoader paramMetadataLoader)
  {
    if (paramMetadataLoader == null)
      throw new IllegalArgumentException("metadataLoader could not be null.");
    return new PhoneNumberUtil("/com/google/i18n/phonenumbers/data/PhoneNumberMetadataProto", paramMetadataLoader, CountryCodeToRegionCodeMap.getCountryCodeToRegionCodeMap());
  }

  static String extractPossibleNumber(String paramString)
  {
    Matcher localMatcher1 = VALID_START_CHAR_PATTERN.matcher(paramString);
    if (localMatcher1.find())
    {
      String str1 = paramString.substring(localMatcher1.start());
      Matcher localMatcher2 = UNWANTED_END_CHAR_PATTERN.matcher(str1);
      Logger localLogger;
      Level localLevel;
      String str2;
      if (localMatcher2.find())
      {
        str1 = str1.substring(0, localMatcher2.start());
        localLogger = logger;
        localLevel = Level.FINER;
        str2 = String.valueOf(str1);
        if (str2.length() == 0)
          break label122;
      }
      label122: for (String str3 = "Stripped trailing characters: ".concat(str2); ; str3 = new String("Stripped trailing characters: "))
      {
        localLogger.log(localLevel, str3);
        Matcher localMatcher3 = SECOND_NUMBER_START_PATTERN.matcher(str1);
        if (localMatcher3.find())
          str1 = str1.substring(0, localMatcher3.start());
        return str1;
      }
    }
    return "";
  }

  private String formatNsn(String paramString, Phonemetadata.PhoneMetadata paramPhoneMetadata, PhoneNumberFormat paramPhoneNumberFormat)
  {
    return formatNsn(paramString, paramPhoneMetadata, paramPhoneNumberFormat, null);
  }

  private String formatNsn(String paramString1, Phonemetadata.PhoneMetadata paramPhoneMetadata, PhoneNumberFormat paramPhoneNumberFormat, String paramString2)
  {
    if ((paramPhoneMetadata.intlNumberFormats().size() == 0) || (paramPhoneNumberFormat == PhoneNumberFormat.NATIONAL));
    Phonemetadata.NumberFormat localNumberFormat;
    for (List localList = paramPhoneMetadata.numberFormats(); ; localList = paramPhoneMetadata.intlNumberFormats())
    {
      localNumberFormat = chooseFormattingPatternForNumber(localList, paramString1);
      if (localNumberFormat != null)
        break;
      return paramString1;
    }
    return formatNsnUsingPattern(paramString1, localNumberFormat, paramPhoneNumberFormat, paramString2);
  }

  private String formatNsnUsingPattern(String paramString1, Phonemetadata.NumberFormat paramNumberFormat, PhoneNumberFormat paramPhoneNumberFormat, String paramString2)
  {
    String str1 = paramNumberFormat.getFormat();
    Matcher localMatcher1 = this.regexCache.getPatternForRegex(paramNumberFormat.getPattern()).matcher(paramString1);
    String str3;
    if ((paramPhoneNumberFormat == PhoneNumberFormat.NATIONAL) && (paramString2 != null) && (paramString2.length() > 0) && (paramNumberFormat.getDomesticCarrierCodeFormattingRule().length() > 0))
    {
      String str4 = paramNumberFormat.getDomesticCarrierCodeFormattingRule();
      String str5 = CC_PATTERN.matcher(str4).replaceFirst(paramString2);
      str3 = localMatcher1.replaceAll(FIRST_GROUP_PATTERN.matcher(str1).replaceFirst(str5));
    }
    while (true)
    {
      if (paramPhoneNumberFormat == PhoneNumberFormat.RFC3966)
      {
        Matcher localMatcher2 = SEPARATOR_PATTERN.matcher(str3);
        if (localMatcher2.lookingAt())
          str3 = localMatcher2.replaceFirst("");
        str3 = localMatcher2.reset(str3).replaceAll("-");
      }
      return str3;
      String str2 = paramNumberFormat.getNationalPrefixFormattingRule();
      if ((paramPhoneNumberFormat == PhoneNumberFormat.NATIONAL) && (str2 != null) && (str2.length() > 0))
        str3 = localMatcher1.replaceAll(FIRST_GROUP_PATTERN.matcher(str1).replaceFirst(str2));
      else
        str3 = localMatcher1.replaceAll(str1);
    }
  }

  static boolean formattingRuleHasFirstGroupOnly(String paramString)
  {
    return (paramString.length() == 0) || (FIRST_GROUP_ONLY_PREFIX_PATTERN.matcher(paramString).matches());
  }

  private int getCountryCodeForValidRegion(String paramString)
  {
    Phonemetadata.PhoneMetadata localPhoneMetadata = getMetadataForRegion(paramString);
    if (localPhoneMetadata == null)
    {
      String str1 = String.valueOf(paramString);
      if (str1.length() != 0);
      for (String str2 = "Invalid region code: ".concat(str1); ; str2 = new String("Invalid region code: "))
        throw new IllegalArgumentException(str2);
    }
    return localPhoneMetadata.getCountryCode();
  }

  public static String getCountryMobileToken(int paramInt)
  {
    if (MOBILE_TOKEN_MAPPINGS.containsKey(Integer.valueOf(paramInt)))
      return (String)MOBILE_TOKEN_MAPPINGS.get(Integer.valueOf(paramInt));
    return "";
  }

  public static PhoneNumberUtil getInstance()
  {
    try
    {
      if (instance == null)
        setInstance(createInstance(DEFAULT_METADATA_LOADER));
      PhoneNumberUtil localPhoneNumberUtil = instance;
      return localPhoneNumberUtil;
    }
    finally
    {
    }
  }

  private Phonemetadata.PhoneMetadata getMetadataForRegionOrCallingCode(int paramInt, String paramString)
  {
    if ("001".equals(paramString))
      return getMetadataForNonGeographicalRegion(paramInt);
    return getMetadataForRegion(paramString);
  }

  private PhoneNumberType getNumberTypeHelper(String paramString, Phonemetadata.PhoneMetadata paramPhoneMetadata)
  {
    Phonemetadata.PhoneNumberDesc localPhoneNumberDesc = paramPhoneMetadata.getGeneralDesc();
    if ((!localPhoneNumberDesc.hasNationalNumberPattern()) || (!isNumberMatchingDesc(paramString, localPhoneNumberDesc)))
      return PhoneNumberType.UNKNOWN;
    if (isNumberMatchingDesc(paramString, paramPhoneMetadata.getPremiumRate()))
      return PhoneNumberType.PREMIUM_RATE;
    if (isNumberMatchingDesc(paramString, paramPhoneMetadata.getTollFree()))
      return PhoneNumberType.TOLL_FREE;
    if (isNumberMatchingDesc(paramString, paramPhoneMetadata.getSharedCost()))
      return PhoneNumberType.SHARED_COST;
    if (isNumberMatchingDesc(paramString, paramPhoneMetadata.getVoip()))
      return PhoneNumberType.VOIP;
    if (isNumberMatchingDesc(paramString, paramPhoneMetadata.getPersonalNumber()))
      return PhoneNumberType.PERSONAL_NUMBER;
    if (isNumberMatchingDesc(paramString, paramPhoneMetadata.getPager()))
      return PhoneNumberType.PAGER;
    if (isNumberMatchingDesc(paramString, paramPhoneMetadata.getUan()))
      return PhoneNumberType.UAN;
    if (isNumberMatchingDesc(paramString, paramPhoneMetadata.getVoicemail()))
      return PhoneNumberType.VOICEMAIL;
    if (isNumberMatchingDesc(paramString, paramPhoneMetadata.getFixedLine()))
    {
      if (paramPhoneMetadata.isSameMobileAndFixedLinePattern())
        return PhoneNumberType.FIXED_LINE_OR_MOBILE;
      if (isNumberMatchingDesc(paramString, paramPhoneMetadata.getMobile()))
        return PhoneNumberType.FIXED_LINE_OR_MOBILE;
      return PhoneNumberType.FIXED_LINE;
    }
    if ((!paramPhoneMetadata.isSameMobileAndFixedLinePattern()) && (isNumberMatchingDesc(paramString, paramPhoneMetadata.getMobile())))
      return PhoneNumberType.MOBILE;
    return PhoneNumberType.UNKNOWN;
  }

  private String getRegionCodeForNumberFromRegionList(Phonenumber.PhoneNumber paramPhoneNumber, List<String> paramList)
  {
    String str1 = getNationalSignificantNumber(paramPhoneNumber);
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      String str2 = (String)localIterator.next();
      Phonemetadata.PhoneMetadata localPhoneMetadata = getMetadataForRegion(str2);
      if (localPhoneMetadata.hasLeadingDigits())
      {
        if (this.regexCache.getPatternForRegex(localPhoneMetadata.getLeadingDigits()).matcher(str1).lookingAt())
          return str2;
      }
      else if (getNumberTypeHelper(str1, localPhoneMetadata) != PhoneNumberType.UNKNOWN)
        return str2;
    }
    return null;
  }

  private boolean hasFormattingPatternForNumber(Phonenumber.PhoneNumber paramPhoneNumber)
  {
    int i = paramPhoneNumber.getCountryCode();
    Phonemetadata.PhoneMetadata localPhoneMetadata = getMetadataForRegionOrCallingCode(i, getRegionCodeForCountryCode(i));
    if (localPhoneMetadata == null);
    String str;
    do
    {
      return false;
      str = getNationalSignificantNumber(paramPhoneNumber);
    }
    while (chooseFormattingPatternForNumber(localPhoneMetadata.numberFormats(), str) == null);
    return true;
  }

  private boolean hasUnexpectedItalianLeadingZero(Phonenumber.PhoneNumber paramPhoneNumber)
  {
    return (paramPhoneNumber.isItalianLeadingZero()) && (!isLeadingZeroPossible(paramPhoneNumber.getCountryCode()));
  }

  private boolean hasValidCountryCallingCode(int paramInt)
  {
    return this.countryCallingCodeToRegionCodeMap.containsKey(Integer.valueOf(paramInt));
  }

  private boolean isNationalNumberSuffixOfTheOther(Phonenumber.PhoneNumber paramPhoneNumber1, Phonenumber.PhoneNumber paramPhoneNumber2)
  {
    String str1 = String.valueOf(paramPhoneNumber1.getNationalNumber());
    String str2 = String.valueOf(paramPhoneNumber2.getNationalNumber());
    return (str1.endsWith(str2)) || (str2.endsWith(str1));
  }

  private boolean isShorterThanPossibleNormalNumber(Phonemetadata.PhoneMetadata paramPhoneMetadata, String paramString)
  {
    return testNumberLengthAgainstPattern(this.regexCache.getPatternForRegex(paramPhoneMetadata.getGeneralDesc().getPossibleNumberPattern()), paramString) == ValidationResult.TOO_SHORT;
  }

  private boolean isValidRegionCode(String paramString)
  {
    return (paramString != null) && (this.supportedRegions.contains(paramString));
  }

  static boolean isViablePhoneNumber(String paramString)
  {
    if (paramString.length() < 2)
      return false;
    return VALID_PHONE_NUMBER_PATTERN.matcher(paramString).matches();
  }

  private static Phonemetadata.PhoneMetadataCollection loadMetadataAndCloseInput(ObjectInputStream paramObjectInputStream)
  {
    Phonemetadata.PhoneMetadataCollection localPhoneMetadataCollection = new Phonemetadata.PhoneMetadataCollection();
    try
    {
      localPhoneMetadataCollection.readExternal(paramObjectInputStream);
      try
      {
        paramObjectInputStream.close();
      }
      catch (IOException localIOException4)
      {
        logger.log(Level.WARNING, "error closing input stream (ignored)", localIOException4);
      }
      finally
      {
        return localPhoneMetadataCollection;
      }
    }
    catch (IOException localIOException2)
    {
      logger.log(Level.WARNING, "error reading input (ignored)", localIOException2);
      try
      {
        paramObjectInputStream.close();
      }
      catch (IOException localIOException3)
      {
        logger.log(Level.WARNING, "error closing input stream (ignored)", localIOException3);
      }
      finally
      {
        return localPhoneMetadataCollection;
      }
    }
    finally
    {
      try
      {
        paramObjectInputStream.close();
        return localPhoneMetadataCollection;
      }
      catch (IOException localIOException1)
      {
        localIOException1 = localIOException1;
        logger.log(Level.WARNING, "error closing input stream (ignored)", localIOException1);
        return localPhoneMetadataCollection;
      }
      finally
      {
      }
    }
    return localPhoneMetadataCollection;
  }

  private void maybeAppendFormattedExtension(Phonenumber.PhoneNumber paramPhoneNumber, Phonemetadata.PhoneMetadata paramPhoneMetadata, PhoneNumberFormat paramPhoneNumberFormat, StringBuilder paramStringBuilder)
  {
    if ((paramPhoneNumber.hasExtension()) && (paramPhoneNumber.getExtension().length() > 0))
    {
      if (paramPhoneNumberFormat == PhoneNumberFormat.RFC3966)
        paramStringBuilder.append(";ext=").append(paramPhoneNumber.getExtension());
    }
    else
      return;
    if (paramPhoneMetadata.hasPreferredExtnPrefix())
    {
      paramStringBuilder.append(paramPhoneMetadata.getPreferredExtnPrefix()).append(paramPhoneNumber.getExtension());
      return;
    }
    paramStringBuilder.append(" ext. ").append(paramPhoneNumber.getExtension());
  }

  static String normalize(String paramString)
  {
    if (VALID_ALPHA_PHONE_PATTERN.matcher(paramString).matches())
      return normalizeHelper(paramString, ALPHA_PHONE_MAPPINGS, true);
    return normalizeDigitsOnly(paramString);
  }

  static void normalize(StringBuilder paramStringBuilder)
  {
    String str = normalize(paramStringBuilder.toString());
    paramStringBuilder.replace(0, paramStringBuilder.length(), str);
  }

  static String normalizeDiallableCharsOnly(String paramString)
  {
    return normalizeHelper(paramString, DIALLABLE_CHAR_MAPPINGS, true);
  }

  static StringBuilder normalizeDigits(String paramString, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramString.length());
    char[] arrayOfChar = paramString.toCharArray();
    int i = arrayOfChar.length;
    int j = 0;
    if (j < i)
    {
      char c = arrayOfChar[j];
      int k = Character.digit(c, 10);
      if (k != -1)
        localStringBuilder.append(k);
      while (true)
      {
        j++;
        break;
        if (paramBoolean)
          localStringBuilder.append(c);
      }
    }
    return localStringBuilder;
  }

  public static String normalizeDigitsOnly(String paramString)
  {
    return normalizeDigits(paramString, false).toString();
  }

  private static String normalizeHelper(String paramString, Map<Character, Character> paramMap, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramString.length());
    int i = 0;
    if (i < paramString.length())
    {
      char c = paramString.charAt(i);
      Character localCharacter = (Character)paramMap.get(Character.valueOf(Character.toUpperCase(c)));
      if (localCharacter != null)
        localStringBuilder.append(localCharacter);
      while (true)
      {
        i++;
        break;
        if (!paramBoolean)
          localStringBuilder.append(c);
      }
    }
    return localStringBuilder.toString();
  }

  private void parseHelper(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, Phonenumber.PhoneNumber paramPhoneNumber)
    throws NumberParseException
  {
    if (paramString1 == null)
      throw new NumberParseException(NumberParseException.ErrorType.NOT_A_NUMBER, "The phone number supplied was null.");
    if (paramString1.length() > 250)
      throw new NumberParseException(NumberParseException.ErrorType.TOO_LONG, "The string supplied was too long to parse.");
    StringBuilder localStringBuilder1 = new StringBuilder();
    buildNationalNumberForParsing(paramString1, localStringBuilder1);
    if (!isViablePhoneNumber(localStringBuilder1.toString()))
      throw new NumberParseException(NumberParseException.ErrorType.NOT_A_NUMBER, "The string supplied did not seem to be a phone number.");
    if ((paramBoolean2) && (!checkRegionForParsing(localStringBuilder1.toString(), paramString2)))
      throw new NumberParseException(NumberParseException.ErrorType.INVALID_COUNTRY_CODE, "Missing or invalid default region.");
    if (paramBoolean1)
      paramPhoneNumber.setRawInput(paramString1);
    String str1 = maybeStripExtension(localStringBuilder1);
    if (str1.length() > 0)
      paramPhoneNumber.setExtension(str1);
    Phonemetadata.PhoneMetadata localPhoneMetadata = getMetadataForRegion(paramString2);
    Object localObject = new StringBuilder();
    while (true)
    {
      try
      {
        int k = maybeExtractCountryCode(localStringBuilder1.toString(), localPhoneMetadata, (StringBuilder)localObject, paramBoolean1, paramPhoneNumber);
        i = k;
        if (i != 0)
        {
          String str2 = getRegionCodeForCountryCode(i);
          if (!str2.equals(paramString2))
            localPhoneMetadata = getMetadataForRegionOrCallingCode(i, str2);
          if (((StringBuilder)localObject).length() >= 2)
            break;
          throw new NumberParseException(NumberParseException.ErrorType.TOO_SHORT_NSN, "The string supplied is too short to be a phone number.");
        }
      }
      catch (NumberParseException localNumberParseException)
      {
        int i;
        Matcher localMatcher = PLUS_CHARS_PATTERN.matcher(localStringBuilder1.toString());
        if ((localNumberParseException.getErrorType() == NumberParseException.ErrorType.INVALID_COUNTRY_CODE) && (localMatcher.lookingAt()))
        {
          i = maybeExtractCountryCode(localStringBuilder1.substring(localMatcher.end()), localPhoneMetadata, (StringBuilder)localObject, paramBoolean1, paramPhoneNumber);
          if (i != 0)
            continue;
          throw new NumberParseException(NumberParseException.ErrorType.INVALID_COUNTRY_CODE, "Could not interpret numbers after plus-sign.");
        }
        throw new NumberParseException(localNumberParseException.getErrorType(), localNumberParseException.getMessage());
      }
      normalize(localStringBuilder1);
      ((StringBuilder)localObject).append(localStringBuilder1);
      if (paramString2 != null)
        paramPhoneNumber.setCountryCode(localPhoneMetadata.getCountryCode());
      else if (paramBoolean1)
        paramPhoneNumber.clearCountryCodeSource();
    }
    if (localPhoneMetadata != null)
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      StringBuilder localStringBuilder3 = new StringBuilder((CharSequence)localObject);
      maybeStripNationalPrefixAndCarrierCode(localStringBuilder3, localPhoneMetadata, localStringBuilder2);
      if (!isShorterThanPossibleNormalNumber(localPhoneMetadata, localStringBuilder3.toString()))
      {
        localObject = localStringBuilder3;
        if (paramBoolean1)
          paramPhoneNumber.setPreferredDomesticCarrierCode(localStringBuilder2.toString());
      }
    }
    int j = ((StringBuilder)localObject).length();
    if (j < 2)
      throw new NumberParseException(NumberParseException.ErrorType.TOO_SHORT_NSN, "The string supplied is too short to be a phone number.");
    if (j > 17)
      throw new NumberParseException(NumberParseException.ErrorType.TOO_LONG, "The string supplied is too long to be a phone number.");
    setItalianLeadingZerosForPhoneNumber(((StringBuilder)localObject).toString(), paramPhoneNumber);
    paramPhoneNumber.setNationalNumber(Long.parseLong(((StringBuilder)localObject).toString()));
  }

  private boolean parsePrefixAsIdd(Pattern paramPattern, StringBuilder paramStringBuilder)
  {
    Matcher localMatcher1 = paramPattern.matcher(paramStringBuilder);
    int i;
    if (localMatcher1.lookingAt())
    {
      i = localMatcher1.end();
      Matcher localMatcher2 = CAPTURING_DIGIT_PATTERN.matcher(paramStringBuilder.substring(i));
      if ((!localMatcher2.find()) || (!normalizeDigitsOnly(localMatcher2.group(1)).equals("0")));
    }
    else
    {
      return false;
    }
    paramStringBuilder.delete(0, i);
    return true;
  }

  private void prefixNumberWithCountryCallingCode(int paramInt, PhoneNumberFormat paramPhoneNumberFormat, StringBuilder paramStringBuilder)
  {
    switch (3.$SwitchMap$com$google$i18n$phonenumbers$PhoneNumberUtil$PhoneNumberFormat[paramPhoneNumberFormat.ordinal()])
    {
    default:
      return;
    case 1:
      paramStringBuilder.insert(0, paramInt).insert(0, '+');
      return;
    case 2:
      paramStringBuilder.insert(0, " ").insert(0, paramInt).insert(0, '+');
      return;
    case 3:
    }
    paramStringBuilder.insert(0, "-").insert(0, paramInt).insert(0, '+').insert(0, "tel:");
  }

  private boolean rawInputContainsNationalPrefix(String paramString1, String paramString2, String paramString3)
  {
    String str = normalizeDigitsOnly(paramString1);
    boolean bool1 = str.startsWith(paramString2);
    boolean bool2 = false;
    if (bool1);
    try
    {
      boolean bool3 = isValidNumber(parse(str.substring(paramString2.length()), paramString3));
      bool2 = bool3;
      return bool2;
    }
    catch (NumberParseException localNumberParseException)
    {
    }
    return false;
  }

  static void setInstance(PhoneNumberUtil paramPhoneNumberUtil)
  {
    try
    {
      instance = paramPhoneNumberUtil;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  static void setItalianLeadingZerosForPhoneNumber(String paramString, Phonenumber.PhoneNumber paramPhoneNumber)
  {
    if ((paramString.length() > 1) && (paramString.charAt(0) == '0'))
    {
      paramPhoneNumber.setItalianLeadingZero(true);
      for (int i = 1; (i < -1 + paramString.length()) && (paramString.charAt(i) == '0'); i++);
      if (i != 1)
        paramPhoneNumber.setNumberOfLeadingZeros(i);
    }
  }

  private ValidationResult testNumberLengthAgainstPattern(Pattern paramPattern, String paramString)
  {
    Matcher localMatcher = paramPattern.matcher(paramString);
    if (localMatcher.matches())
      return ValidationResult.IS_POSSIBLE;
    if (localMatcher.lookingAt())
      return ValidationResult.TOO_LONG;
    return ValidationResult.TOO_SHORT;
  }

  boolean canBeInternationallyDialled(Phonenumber.PhoneNumber paramPhoneNumber)
  {
    Phonemetadata.PhoneMetadata localPhoneMetadata = getMetadataForRegion(getRegionCodeForNumber(paramPhoneNumber));
    if (localPhoneMetadata == null);
    while (!isNumberMatchingDesc(getNationalSignificantNumber(paramPhoneNumber), localPhoneMetadata.getNoInternationalDialling()))
      return true;
    return false;
  }

  Phonemetadata.NumberFormat chooseFormattingPatternForNumber(List<Phonemetadata.NumberFormat> paramList, String paramString)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      Phonemetadata.NumberFormat localNumberFormat = (Phonemetadata.NumberFormat)localIterator.next();
      int i = localNumberFormat.leadingDigitsPatternSize();
      if (((i == 0) || (this.regexCache.getPatternForRegex(localNumberFormat.getLeadingDigitsPattern(i - 1)).matcher(paramString).lookingAt())) && (this.regexCache.getPatternForRegex(localNumberFormat.getPattern()).matcher(paramString).matches()))
        return localNumberFormat;
    }
    return null;
  }

  int extractCountryCode(StringBuilder paramStringBuilder1, StringBuilder paramStringBuilder2)
  {
    if ((paramStringBuilder1.length() == 0) || (paramStringBuilder1.charAt(0) == '0'))
      return 0;
    int i = paramStringBuilder1.length();
    for (int j = 1; (j <= 3) && (j <= i); j++)
    {
      int k = Integer.parseInt(paramStringBuilder1.substring(0, j));
      if (this.countryCallingCodeToRegionCodeMap.containsKey(Integer.valueOf(k)))
      {
        paramStringBuilder2.append(paramStringBuilder1.substring(j));
        return k;
      }
    }
    return 0;
  }

  public Iterable<PhoneNumberMatch> findNumbers(CharSequence paramCharSequence, String paramString)
  {
    return findNumbers(paramCharSequence, paramString, Leniency.VALID, 9223372036854775807L);
  }

  public Iterable<PhoneNumberMatch> findNumbers(final CharSequence paramCharSequence, final String paramString, final Leniency paramLeniency, final long paramLong)
  {
    return new Iterable()
    {
      public Iterator<PhoneNumberMatch> iterator()
      {
        return new PhoneNumberMatcher(PhoneNumberUtil.this, paramCharSequence, paramString, paramLeniency, paramLong);
      }
    };
  }

  public String format(Phonenumber.PhoneNumber paramPhoneNumber, PhoneNumberFormat paramPhoneNumberFormat)
  {
    if ((paramPhoneNumber.getNationalNumber() == 0L) && (paramPhoneNumber.hasRawInput()))
    {
      String str = paramPhoneNumber.getRawInput();
      if (str.length() > 0)
        return str;
    }
    StringBuilder localStringBuilder = new StringBuilder(20);
    format(paramPhoneNumber, paramPhoneNumberFormat, localStringBuilder);
    return localStringBuilder.toString();
  }

  public void format(Phonenumber.PhoneNumber paramPhoneNumber, PhoneNumberFormat paramPhoneNumberFormat, StringBuilder paramStringBuilder)
  {
    paramStringBuilder.setLength(0);
    int i = paramPhoneNumber.getCountryCode();
    String str = getNationalSignificantNumber(paramPhoneNumber);
    if (paramPhoneNumberFormat == PhoneNumberFormat.E164)
    {
      paramStringBuilder.append(str);
      prefixNumberWithCountryCallingCode(i, PhoneNumberFormat.E164, paramStringBuilder);
      return;
    }
    if (!hasValidCountryCallingCode(i))
    {
      paramStringBuilder.append(str);
      return;
    }
    Phonemetadata.PhoneMetadata localPhoneMetadata = getMetadataForRegionOrCallingCode(i, getRegionCodeForCountryCode(i));
    paramStringBuilder.append(formatNsn(str, localPhoneMetadata, paramPhoneNumberFormat));
    maybeAppendFormattedExtension(paramPhoneNumber, localPhoneMetadata, paramPhoneNumberFormat, paramStringBuilder);
    prefixNumberWithCountryCallingCode(i, paramPhoneNumberFormat, paramStringBuilder);
  }

  public String formatByPattern(Phonenumber.PhoneNumber paramPhoneNumber, PhoneNumberFormat paramPhoneNumberFormat, List<Phonemetadata.NumberFormat> paramList)
  {
    int i = paramPhoneNumber.getCountryCode();
    String str1 = getNationalSignificantNumber(paramPhoneNumber);
    if (!hasValidCountryCallingCode(i))
      return str1;
    Phonemetadata.PhoneMetadata localPhoneMetadata = getMetadataForRegionOrCallingCode(i, getRegionCodeForCountryCode(i));
    StringBuilder localStringBuilder = new StringBuilder(20);
    Phonemetadata.NumberFormat localNumberFormat1 = chooseFormattingPatternForNumber(paramList, str1);
    if (localNumberFormat1 == null)
    {
      localStringBuilder.append(str1);
      maybeAppendFormattedExtension(paramPhoneNumber, localPhoneMetadata, paramPhoneNumberFormat, localStringBuilder);
      prefixNumberWithCountryCallingCode(i, paramPhoneNumberFormat, localStringBuilder);
      return localStringBuilder.toString();
    }
    Phonemetadata.NumberFormat localNumberFormat2 = new Phonemetadata.NumberFormat();
    localNumberFormat2.mergeFrom(localNumberFormat1);
    String str2 = localNumberFormat1.getNationalPrefixFormattingRule();
    if (str2.length() > 0)
    {
      String str3 = localPhoneMetadata.getNationalPrefix();
      if (str3.length() <= 0)
        break label197;
      String str4 = NP_PATTERN.matcher(str2).replaceFirst(str3);
      localNumberFormat2.setNationalPrefixFormattingRule(FG_PATTERN.matcher(str4).replaceFirst("\\$1"));
    }
    while (true)
    {
      localStringBuilder.append(formatNsnUsingPattern(str1, localNumberFormat2, paramPhoneNumberFormat));
      break;
      label197: localNumberFormat2.clearNationalPrefixFormattingRule();
    }
  }

  public String formatInOriginalFormat(Phonenumber.PhoneNumber paramPhoneNumber, String paramString)
  {
    Object localObject;
    if ((paramPhoneNumber.hasRawInput()) && ((hasUnexpectedItalianLeadingZero(paramPhoneNumber)) || (!hasFormattingPatternForNumber(paramPhoneNumber))))
    {
      localObject = paramPhoneNumber.getRawInput();
      return localObject;
    }
    if (!paramPhoneNumber.hasCountryCodeSource())
      return format(paramPhoneNumber, PhoneNumberFormat.NATIONAL);
    String str2;
    String str3;
    String str4;
    switch (3.$SwitchMap$com$google$i18n$phonenumbers$Phonenumber$PhoneNumber$CountryCodeSource[paramPhoneNumber.getCountryCodeSource().ordinal()])
    {
    default:
      str2 = getRegionCodeForCountryCode(paramPhoneNumber.getCountryCode());
      str3 = getNddPrefixForRegion(str2, true);
      str4 = format(paramPhoneNumber, PhoneNumberFormat.NATIONAL);
      if ((str3 == null) || (str3.length() == 0))
        localObject = str4;
      break;
    case 1:
    case 2:
    case 3:
    }
    while (true)
    {
      String str1 = paramPhoneNumber.getRawInput();
      if ((localObject == null) || (str1.length() <= 0) || (normalizeDiallableCharsOnly((String)localObject).equals(normalizeDiallableCharsOnly(str1))))
        break;
      return str1;
      localObject = format(paramPhoneNumber, PhoneNumberFormat.INTERNATIONAL);
      continue;
      localObject = formatOutOfCountryCallingNumber(paramPhoneNumber, paramString);
      continue;
      localObject = format(paramPhoneNumber, PhoneNumberFormat.INTERNATIONAL).substring(1);
      continue;
      if (rawInputContainsNationalPrefix(paramPhoneNumber.getRawInput(), str3, str2))
      {
        localObject = str4;
      }
      else
      {
        Phonemetadata.PhoneMetadata localPhoneMetadata = getMetadataForRegion(str2);
        String str5 = getNationalSignificantNumber(paramPhoneNumber);
        Phonemetadata.NumberFormat localNumberFormat1 = chooseFormattingPatternForNumber(localPhoneMetadata.numberFormats(), str5);
        if (localNumberFormat1 == null)
        {
          localObject = str4;
        }
        else
        {
          String str6 = localNumberFormat1.getNationalPrefixFormattingRule();
          int i = str6.indexOf("$1");
          if (i <= 0)
          {
            localObject = str4;
          }
          else if (normalizeDigitsOnly(str6.substring(0, i)).length() == 0)
          {
            localObject = str4;
          }
          else
          {
            Phonemetadata.NumberFormat localNumberFormat2 = new Phonemetadata.NumberFormat();
            localNumberFormat2.mergeFrom(localNumberFormat1);
            localNumberFormat2.clearNationalPrefixFormattingRule();
            ArrayList localArrayList = new ArrayList(1);
            localArrayList.add(localNumberFormat2);
            localObject = formatByPattern(paramPhoneNumber, PhoneNumberFormat.NATIONAL, localArrayList);
          }
        }
      }
    }
  }

  public String formatNationalNumberWithCarrierCode(Phonenumber.PhoneNumber paramPhoneNumber, String paramString)
  {
    int i = paramPhoneNumber.getCountryCode();
    String str = getNationalSignificantNumber(paramPhoneNumber);
    if (!hasValidCountryCallingCode(i))
      return str;
    Phonemetadata.PhoneMetadata localPhoneMetadata = getMetadataForRegionOrCallingCode(i, getRegionCodeForCountryCode(i));
    StringBuilder localStringBuilder = new StringBuilder(20);
    localStringBuilder.append(formatNsn(str, localPhoneMetadata, PhoneNumberFormat.NATIONAL, paramString));
    maybeAppendFormattedExtension(paramPhoneNumber, localPhoneMetadata, PhoneNumberFormat.NATIONAL, localStringBuilder);
    prefixNumberWithCountryCallingCode(i, PhoneNumberFormat.NATIONAL, localStringBuilder);
    return localStringBuilder.toString();
  }

  public String formatNationalNumberWithPreferredCarrierCode(Phonenumber.PhoneNumber paramPhoneNumber, String paramString)
  {
    if (paramPhoneNumber.hasPreferredDomesticCarrierCode())
      paramString = paramPhoneNumber.getPreferredDomesticCarrierCode();
    return formatNationalNumberWithCarrierCode(paramPhoneNumber, paramString);
  }

  String formatNsnUsingPattern(String paramString, Phonemetadata.NumberFormat paramNumberFormat, PhoneNumberFormat paramPhoneNumberFormat)
  {
    return formatNsnUsingPattern(paramString, paramNumberFormat, paramPhoneNumberFormat, null);
  }

  public String formatNumberForMobileDialing(Phonenumber.PhoneNumber paramPhoneNumber, String paramString, boolean paramBoolean)
  {
    int i = paramPhoneNumber.getCountryCode();
    if (!hasValidCountryCallingCode(i))
    {
      if (paramPhoneNumber.hasRawInput())
        return paramPhoneNumber.getRawInput();
      return "";
    }
    Object localObject = "";
    Phonenumber.PhoneNumber localPhoneNumber = new Phonenumber.PhoneNumber().mergeFrom(paramPhoneNumber).clearExtension();
    String str1 = getRegionCodeForCountryCode(i);
    PhoneNumberType localPhoneNumberType = getNumberType(localPhoneNumber);
    int j;
    int k;
    if (localPhoneNumberType != PhoneNumberType.UNKNOWN)
    {
      j = 1;
      if (!paramString.equals(str1))
        break label440;
      if ((localPhoneNumberType != PhoneNumberType.FIXED_LINE) && (localPhoneNumberType != PhoneNumberType.MOBILE) && (localPhoneNumberType != PhoneNumberType.FIXED_LINE_OR_MOBILE))
        break label155;
      k = 1;
      label113: if ((!str1.equals("CO")) || (localPhoneNumberType != PhoneNumberType.FIXED_LINE))
        break label161;
      localObject = formatNationalNumberWithCarrierCode(localPhoneNumber, "3");
      label142: if (!paramBoolean)
        break label478;
    }
    while (true)
    {
      return localObject;
      j = 0;
      break;
      label155: k = 0;
      break label113;
      label161: if ((str1.equals("BR")) && (k != 0))
      {
        if (localPhoneNumber.hasPreferredDomesticCarrierCode());
        for (String str4 = formatNationalNumberWithPreferredCarrierCode(localPhoneNumber, ""); ; str4 = "")
        {
          localObject = str4;
          break;
        }
      }
      if ((j != 0) && (str1.equals("HU")))
      {
        String str2 = String.valueOf(String.valueOf(getNddPrefixForRegion(str1, true)));
        String str3 = String.valueOf(String.valueOf(format(localPhoneNumber, PhoneNumberFormat.NATIONAL)));
        localObject = 1 + str2.length() + str3.length() + str2 + " " + str3;
        break label142;
      }
      if (i == 1)
      {
        Phonemetadata.PhoneMetadata localPhoneMetadata = getMetadataForRegion(paramString);
        if ((canBeInternationallyDialled(localPhoneNumber)) && (!isShorterThanPossibleNormalNumber(localPhoneMetadata, getNationalSignificantNumber(localPhoneNumber))))
        {
          localObject = format(localPhoneNumber, PhoneNumberFormat.INTERNATIONAL);
          break label142;
        }
        localObject = format(localPhoneNumber, PhoneNumberFormat.NATIONAL);
        break label142;
      }
      if (((str1.equals("001")) || (((str1.equals("MX")) || (str1.equals("CL"))) && (k != 0))) && (canBeInternationallyDialled(localPhoneNumber)))
      {
        localObject = format(localPhoneNumber, PhoneNumberFormat.INTERNATIONAL);
        break label142;
      }
      localObject = format(localPhoneNumber, PhoneNumberFormat.NATIONAL);
      break label142;
      label440: if ((j == 0) || (!canBeInternationallyDialled(localPhoneNumber)))
        break label142;
      if (paramBoolean)
        return format(localPhoneNumber, PhoneNumberFormat.INTERNATIONAL);
      return format(localPhoneNumber, PhoneNumberFormat.E164);
      label478: localObject = normalizeDiallableCharsOnly((String)localObject);
    }
  }

  public String formatOutOfCountryCallingNumber(Phonenumber.PhoneNumber paramPhoneNumber, String paramString)
  {
    String str1;
    if (!isValidRegionCode(paramString))
    {
      Logger localLogger = logger;
      Level localLevel = Level.WARNING;
      String str5 = String.valueOf(String.valueOf(paramString));
      localLogger.log(localLevel, 79 + str5.length() + "Trying to format number from invalid region " + str5 + ". International formatting applied.");
      str1 = format(paramPhoneNumber, PhoneNumberFormat.INTERNATIONAL);
    }
    int i;
    do
    {
      return str1;
      i = paramPhoneNumber.getCountryCode();
      str1 = getNationalSignificantNumber(paramPhoneNumber);
    }
    while (!hasValidCountryCallingCode(i));
    if (i == 1)
    {
      if (isNANPACountry(paramString))
      {
        String str4 = String.valueOf(String.valueOf(format(paramPhoneNumber, PhoneNumberFormat.NATIONAL)));
        return 12 + str4.length() + i + " " + str4;
      }
    }
    else if (i == getCountryCodeForValidRegion(paramString))
      return format(paramPhoneNumber, PhoneNumberFormat.NATIONAL);
    Phonemetadata.PhoneMetadata localPhoneMetadata1 = getMetadataForRegion(paramString);
    String str2 = localPhoneMetadata1.getInternationalPrefix();
    String str3 = "";
    StringBuilder localStringBuilder;
    if (UNIQUE_INTERNATIONAL_PREFIX.matcher(str2).matches())
    {
      str3 = str2;
      Phonemetadata.PhoneMetadata localPhoneMetadata2 = getMetadataForRegionOrCallingCode(i, getRegionCodeForCountryCode(i));
      localStringBuilder = new StringBuilder(formatNsn(str1, localPhoneMetadata2, PhoneNumberFormat.INTERNATIONAL));
      maybeAppendFormattedExtension(paramPhoneNumber, localPhoneMetadata2, PhoneNumberFormat.INTERNATIONAL, localStringBuilder);
      if (str3.length() <= 0)
        break label323;
      localStringBuilder.insert(0, " ").insert(0, i).insert(0, " ").insert(0, str3);
    }
    while (true)
    {
      return localStringBuilder.toString();
      if (!localPhoneMetadata1.hasPreferredInternationalPrefix())
        break;
      str3 = localPhoneMetadata1.getPreferredInternationalPrefix();
      break;
      label323: prefixNumberWithCountryCallingCode(i, PhoneNumberFormat.INTERNATIONAL, localStringBuilder);
    }
  }

  public String formatOutOfCountryKeepingAlphaChars(Phonenumber.PhoneNumber paramPhoneNumber, String paramString)
  {
    String str1 = paramPhoneNumber.getRawInput();
    if (str1.length() == 0)
      return formatOutOfCountryCallingNumber(paramPhoneNumber, paramString);
    int i = paramPhoneNumber.getCountryCode();
    if (!hasValidCountryCallingCode(i))
      return str1;
    String str2 = normalizeHelper(str1, ALL_PLUS_NUMBER_GROUPING_SYMBOLS, true);
    String str3 = getNationalSignificantNumber(paramPhoneNumber);
    if (str3.length() > 3)
    {
      int j = str2.indexOf(str3.substring(0, 3));
      if (j != -1)
        str2 = str2.substring(j);
    }
    Phonemetadata.PhoneMetadata localPhoneMetadata = getMetadataForRegion(paramString);
    if (i == 1)
    {
      if (isNANPACountry(paramString))
      {
        String str6 = String.valueOf(String.valueOf(str2));
        return 12 + str6.length() + i + " " + str6;
      }
    }
    else if ((localPhoneMetadata != null) && (i == getCountryCodeForValidRegion(paramString)))
    {
      Phonemetadata.NumberFormat localNumberFormat1 = chooseFormattingPatternForNumber(localPhoneMetadata.numberFormats(), str3);
      if (localNumberFormat1 == null)
        return str2;
      Phonemetadata.NumberFormat localNumberFormat2 = new Phonemetadata.NumberFormat();
      localNumberFormat2.mergeFrom(localNumberFormat1);
      localNumberFormat2.setPattern("(\\d+)(.*)");
      localNumberFormat2.setFormat("$1$2");
      return formatNsnUsingPattern(str2, localNumberFormat2, PhoneNumberFormat.NATIONAL);
    }
    Object localObject = "";
    StringBuilder localStringBuilder;
    if (localPhoneMetadata != null)
    {
      String str5 = localPhoneMetadata.getInternationalPrefix();
      if (UNIQUE_INTERNATIONAL_PREFIX.matcher(str5).matches())
        localObject = str5;
    }
    else
    {
      localStringBuilder = new StringBuilder(str2);
      maybeAppendFormattedExtension(paramPhoneNumber, getMetadataForRegionOrCallingCode(i, getRegionCodeForCountryCode(i)), PhoneNumberFormat.INTERNATIONAL, localStringBuilder);
      if (((String)localObject).length() <= 0)
        break label360;
      localStringBuilder.insert(0, " ").insert(0, i).insert(0, " ").insert(0, (String)localObject);
    }
    while (true)
    {
      return localStringBuilder.toString();
      localObject = localPhoneMetadata.getPreferredInternationalPrefix();
      break;
      label360: Logger localLogger = logger;
      Level localLevel = Level.WARNING;
      String str4 = String.valueOf(String.valueOf(paramString));
      localLogger.log(localLevel, 79 + str4.length() + "Trying to format number from invalid region " + str4 + ". International formatting applied.");
      prefixNumberWithCountryCallingCode(i, PhoneNumberFormat.INTERNATIONAL, localStringBuilder);
    }
  }

  public AsYouTypeFormatter getAsYouTypeFormatter(String paramString)
  {
    return new AsYouTypeFormatter(paramString);
  }

  public int getCountryCodeForRegion(String paramString)
  {
    if (!isValidRegionCode(paramString))
    {
      Logger localLogger = logger;
      Level localLevel = Level.WARNING;
      if (paramString == null)
        paramString = "null";
      String str = String.valueOf(String.valueOf(paramString));
      localLogger.log(localLevel, 43 + str.length() + "Invalid or missing region code (" + str + ") provided.");
      return 0;
    }
    return getCountryCodeForValidRegion(paramString);
  }

  public Phonenumber.PhoneNumber getExampleNumber(String paramString)
  {
    return getExampleNumberForType(paramString, PhoneNumberType.FIXED_LINE);
  }

  public Phonenumber.PhoneNumber getExampleNumberForNonGeoEntity(int paramInt)
  {
    Phonemetadata.PhoneMetadata localPhoneMetadata = getMetadataForNonGeographicalRegion(paramInt);
    if (localPhoneMetadata != null)
    {
      Phonemetadata.PhoneNumberDesc localPhoneNumberDesc = localPhoneMetadata.getGeneralDesc();
      try
      {
        if (localPhoneNumberDesc.hasExampleNumber())
        {
          String str = String.valueOf(String.valueOf(localPhoneNumberDesc.getExampleNumber()));
          Phonenumber.PhoneNumber localPhoneNumber = parse(12 + str.length() + "+" + paramInt + str, "ZZ");
          return localPhoneNumber;
        }
      }
      catch (NumberParseException localNumberParseException)
      {
        logger.log(Level.SEVERE, localNumberParseException.toString());
      }
    }
    while (true)
    {
      return null;
      logger.log(Level.WARNING, 61 + "Invalid or unknown country calling code provided: " + paramInt);
    }
  }

  public Phonenumber.PhoneNumber getExampleNumberForType(String paramString, PhoneNumberType paramPhoneNumberType)
  {
    if (!isValidRegionCode(paramString))
    {
      Logger localLogger = logger;
      Level localLevel = Level.WARNING;
      String str1 = String.valueOf(paramString);
      if (str1.length() != 0);
      for (String str2 = "Invalid or unknown region code provided: ".concat(str1); ; str2 = new String("Invalid or unknown region code provided: "))
      {
        localLogger.log(localLevel, str2);
        return null;
      }
    }
    Phonemetadata.PhoneNumberDesc localPhoneNumberDesc = getNumberDescByType(getMetadataForRegion(paramString), paramPhoneNumberType);
    try
    {
      if (localPhoneNumberDesc.hasExampleNumber())
      {
        Phonenumber.PhoneNumber localPhoneNumber = parse(localPhoneNumberDesc.getExampleNumber(), paramString);
        return localPhoneNumber;
      }
    }
    catch (NumberParseException localNumberParseException)
    {
      logger.log(Level.SEVERE, localNumberParseException.toString());
    }
    return null;
  }

  public int getLengthOfGeographicalAreaCode(Phonenumber.PhoneNumber paramPhoneNumber)
  {
    Phonemetadata.PhoneMetadata localPhoneMetadata = getMetadataForRegion(getRegionCodeForNumber(paramPhoneNumber));
    if (localPhoneMetadata == null);
    while (((!localPhoneMetadata.hasNationalPrefix()) && (!paramPhoneNumber.isItalianLeadingZero())) || (!isNumberGeographical(paramPhoneNumber)))
      return 0;
    return getLengthOfNationalDestinationCode(paramPhoneNumber);
  }

  public int getLengthOfNationalDestinationCode(Phonenumber.PhoneNumber paramPhoneNumber)
  {
    Phonenumber.PhoneNumber localPhoneNumber;
    if (paramPhoneNumber.hasExtension())
    {
      localPhoneNumber = new Phonenumber.PhoneNumber();
      localPhoneNumber.mergeFrom(paramPhoneNumber);
      localPhoneNumber.clearExtension();
    }
    String[] arrayOfString;
    while (true)
    {
      String str = format(localPhoneNumber, PhoneNumberFormat.INTERNATIONAL);
      arrayOfString = NON_DIGITS_PATTERN.split(str);
      if (arrayOfString.length > 3)
        break;
      return 0;
      localPhoneNumber = paramPhoneNumber;
    }
    if ((getNumberType(paramPhoneNumber) == PhoneNumberType.MOBILE) && (!getCountryMobileToken(paramPhoneNumber.getCountryCode()).equals("")))
      return arrayOfString[2].length() + arrayOfString[3].length();
    return arrayOfString[2].length();
  }

  Phonemetadata.PhoneMetadata getMetadataForNonGeographicalRegion(int paramInt)
  {
    synchronized (this.countryCodeToNonGeographicalMetadataMap)
    {
      if (!this.countryCallingCodeToRegionCodeMap.containsKey(Integer.valueOf(paramInt)))
        return null;
      if (!this.countryCodeToNonGeographicalMetadataMap.containsKey(Integer.valueOf(paramInt)))
        loadMetadataFromFile(this.currentFilePrefix, "001", paramInt, this.metadataLoader);
      return (Phonemetadata.PhoneMetadata)this.countryCodeToNonGeographicalMetadataMap.get(Integer.valueOf(paramInt));
    }
  }

  Phonemetadata.PhoneMetadata getMetadataForRegion(String paramString)
  {
    if (!isValidRegionCode(paramString))
      return null;
    synchronized (this.regionToMetadataMap)
    {
      if (!this.regionToMetadataMap.containsKey(paramString))
        loadMetadataFromFile(this.currentFilePrefix, paramString, 0, this.metadataLoader);
      return (Phonemetadata.PhoneMetadata)this.regionToMetadataMap.get(paramString);
    }
  }

  public String getNationalSignificantNumber(Phonenumber.PhoneNumber paramPhoneNumber)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramPhoneNumber.isItalianLeadingZero())
    {
      char[] arrayOfChar = new char[paramPhoneNumber.getNumberOfLeadingZeros()];
      Arrays.fill(arrayOfChar, '0');
      localStringBuilder.append(new String(arrayOfChar));
    }
    localStringBuilder.append(paramPhoneNumber.getNationalNumber());
    return localStringBuilder.toString();
  }

  public String getNddPrefixForRegion(String paramString, boolean paramBoolean)
  {
    Phonemetadata.PhoneMetadata localPhoneMetadata = getMetadataForRegion(paramString);
    String str1;
    if (localPhoneMetadata == null)
    {
      Logger localLogger = logger;
      Level localLevel = Level.WARNING;
      if (paramString == null)
        paramString = "null";
      String str2 = String.valueOf(String.valueOf(paramString));
      localLogger.log(localLevel, 43 + str2.length() + "Invalid or missing region code (" + str2 + ") provided.");
      str1 = null;
    }
    do
    {
      return str1;
      str1 = localPhoneMetadata.getNationalPrefix();
      if (str1.length() == 0)
        return null;
    }
    while (!paramBoolean);
    return str1.replace("~", "");
  }

  Phonemetadata.PhoneNumberDesc getNumberDescByType(Phonemetadata.PhoneMetadata paramPhoneMetadata, PhoneNumberType paramPhoneNumberType)
  {
    switch (3.$SwitchMap$com$google$i18n$phonenumbers$PhoneNumberUtil$PhoneNumberType[paramPhoneNumberType.ordinal()])
    {
    default:
      return paramPhoneMetadata.getGeneralDesc();
    case 1:
      return paramPhoneMetadata.getPremiumRate();
    case 2:
      return paramPhoneMetadata.getTollFree();
    case 3:
      return paramPhoneMetadata.getMobile();
    case 4:
    case 5:
      return paramPhoneMetadata.getFixedLine();
    case 6:
      return paramPhoneMetadata.getSharedCost();
    case 7:
      return paramPhoneMetadata.getVoip();
    case 8:
      return paramPhoneMetadata.getPersonalNumber();
    case 9:
      return paramPhoneMetadata.getPager();
    case 10:
      return paramPhoneMetadata.getUan();
    case 11:
    }
    return paramPhoneMetadata.getVoicemail();
  }

  public PhoneNumberType getNumberType(Phonenumber.PhoneNumber paramPhoneNumber)
  {
    String str = getRegionCodeForNumber(paramPhoneNumber);
    Phonemetadata.PhoneMetadata localPhoneMetadata = getMetadataForRegionOrCallingCode(paramPhoneNumber.getCountryCode(), str);
    if (localPhoneMetadata == null)
      return PhoneNumberType.UNKNOWN;
    return getNumberTypeHelper(getNationalSignificantNumber(paramPhoneNumber), localPhoneMetadata);
  }

  public String getRegionCodeForCountryCode(int paramInt)
  {
    List localList = (List)this.countryCallingCodeToRegionCodeMap.get(Integer.valueOf(paramInt));
    if (localList == null)
      return "ZZ";
    return (String)localList.get(0);
  }

  public String getRegionCodeForNumber(Phonenumber.PhoneNumber paramPhoneNumber)
  {
    int i = paramPhoneNumber.getCountryCode();
    List localList = (List)this.countryCallingCodeToRegionCodeMap.get(Integer.valueOf(i));
    if (localList == null)
    {
      String str1 = getNationalSignificantNumber(paramPhoneNumber);
      Logger localLogger = logger;
      Level localLevel = Level.WARNING;
      String str2 = String.valueOf(String.valueOf(str1));
      localLogger.log(localLevel, 54 + str2.length() + "Missing/invalid country_code (" + i + ") for number " + str2);
      return null;
    }
    if (localList.size() == 1)
      return (String)localList.get(0);
    return getRegionCodeForNumberFromRegionList(paramPhoneNumber, localList);
  }

  public List<String> getRegionCodesForCountryCode(int paramInt)
  {
    Object localObject = (List)this.countryCallingCodeToRegionCodeMap.get(Integer.valueOf(paramInt));
    if (localObject == null)
      localObject = new ArrayList(0);
    return Collections.unmodifiableList((List)localObject);
  }

  public Set<Integer> getSupportedGlobalNetworkCallingCodes()
  {
    return Collections.unmodifiableSet(this.countryCodesForNonGeographicalRegion);
  }

  public Set<String> getSupportedRegions()
  {
    return Collections.unmodifiableSet(this.supportedRegions);
  }

  public boolean isAlphaNumber(String paramString)
  {
    if (!isViablePhoneNumber(paramString))
      return false;
    StringBuilder localStringBuilder = new StringBuilder(paramString);
    maybeStripExtension(localStringBuilder);
    return VALID_ALPHA_PHONE_PATTERN.matcher(localStringBuilder).matches();
  }

  boolean isLeadingZeroPossible(int paramInt)
  {
    Phonemetadata.PhoneMetadata localPhoneMetadata = getMetadataForRegionOrCallingCode(paramInt, getRegionCodeForCountryCode(paramInt));
    if (localPhoneMetadata == null)
      return false;
    return localPhoneMetadata.isLeadingZeroPossible();
  }

  public boolean isMobileNumberPortableRegion(String paramString)
  {
    Phonemetadata.PhoneMetadata localPhoneMetadata = getMetadataForRegion(paramString);
    if (localPhoneMetadata == null)
    {
      Logger localLogger = logger;
      Level localLevel = Level.WARNING;
      String str1 = String.valueOf(paramString);
      if (str1.length() != 0);
      for (String str2 = "Invalid or unknown region code provided: ".concat(str1); ; str2 = new String("Invalid or unknown region code provided: "))
      {
        localLogger.log(localLevel, str2);
        return false;
      }
    }
    return localPhoneMetadata.isMobileNumberPortableRegion();
  }

  public boolean isNANPACountry(String paramString)
  {
    return this.nanpaRegions.contains(paramString);
  }

  boolean isNumberGeographical(Phonenumber.PhoneNumber paramPhoneNumber)
  {
    PhoneNumberType localPhoneNumberType = getNumberType(paramPhoneNumber);
    return (localPhoneNumberType == PhoneNumberType.FIXED_LINE) || (localPhoneNumberType == PhoneNumberType.FIXED_LINE_OR_MOBILE);
  }

  public MatchType isNumberMatch(Phonenumber.PhoneNumber paramPhoneNumber1, Phonenumber.PhoneNumber paramPhoneNumber2)
  {
    Phonenumber.PhoneNumber localPhoneNumber1 = new Phonenumber.PhoneNumber();
    localPhoneNumber1.mergeFrom(paramPhoneNumber1);
    Phonenumber.PhoneNumber localPhoneNumber2 = new Phonenumber.PhoneNumber();
    localPhoneNumber2.mergeFrom(paramPhoneNumber2);
    localPhoneNumber1.clearRawInput();
    localPhoneNumber1.clearCountryCodeSource();
    localPhoneNumber1.clearPreferredDomesticCarrierCode();
    localPhoneNumber2.clearRawInput();
    localPhoneNumber2.clearCountryCodeSource();
    localPhoneNumber2.clearPreferredDomesticCarrierCode();
    if ((localPhoneNumber1.hasExtension()) && (localPhoneNumber1.getExtension().length() == 0))
      localPhoneNumber1.clearExtension();
    if ((localPhoneNumber2.hasExtension()) && (localPhoneNumber2.getExtension().length() == 0))
      localPhoneNumber2.clearExtension();
    if ((localPhoneNumber1.hasExtension()) && (localPhoneNumber2.hasExtension()) && (!localPhoneNumber1.getExtension().equals(localPhoneNumber2.getExtension())))
      return MatchType.NO_MATCH;
    int i = localPhoneNumber1.getCountryCode();
    int j = localPhoneNumber2.getCountryCode();
    if ((i != 0) && (j != 0))
    {
      if (localPhoneNumber1.exactlySameAs(localPhoneNumber2))
        return MatchType.EXACT_MATCH;
      if ((i == j) && (isNationalNumberSuffixOfTheOther(localPhoneNumber1, localPhoneNumber2)))
        return MatchType.SHORT_NSN_MATCH;
      return MatchType.NO_MATCH;
    }
    localPhoneNumber1.setCountryCode(j);
    if (localPhoneNumber1.exactlySameAs(localPhoneNumber2))
      return MatchType.NSN_MATCH;
    if (isNationalNumberSuffixOfTheOther(localPhoneNumber1, localPhoneNumber2))
      return MatchType.SHORT_NSN_MATCH;
    return MatchType.NO_MATCH;
  }

  public MatchType isNumberMatch(Phonenumber.PhoneNumber paramPhoneNumber, String paramString)
  {
    try
    {
      MatchType localMatchType3 = isNumberMatch(paramPhoneNumber, parse(paramString, "ZZ"));
      localMatchType2 = localMatchType3;
      return localMatchType2;
    }
    catch (NumberParseException localNumberParseException1)
    {
      while (true)
      {
        MatchType localMatchType2;
        if (localNumberParseException1.getErrorType() == NumberParseException.ErrorType.INVALID_COUNTRY_CODE)
        {
          String str = getRegionCodeForCountryCode(paramPhoneNumber.getCountryCode());
          try
          {
            if (!str.equals("ZZ"))
            {
              localMatchType2 = isNumberMatch(paramPhoneNumber, parse(paramString, str));
              if (localMatchType2 == MatchType.EXACT_MATCH)
                return MatchType.NSN_MATCH;
            }
            else
            {
              Phonenumber.PhoneNumber localPhoneNumber = new Phonenumber.PhoneNumber();
              parseHelper(paramString, null, false, false, localPhoneNumber);
              MatchType localMatchType1 = isNumberMatch(paramPhoneNumber, localPhoneNumber);
              return localMatchType1;
            }
          }
          catch (NumberParseException localNumberParseException2)
          {
          }
        }
      }
    }
    return MatchType.NOT_A_NUMBER;
  }

  public MatchType isNumberMatch(String paramString1, String paramString2)
  {
    try
    {
      MatchType localMatchType3 = isNumberMatch(parse(paramString1, "ZZ"), paramString2);
      return localMatchType3;
    }
    catch (NumberParseException localNumberParseException1)
    {
      if (localNumberParseException1.getErrorType() == NumberParseException.ErrorType.INVALID_COUNTRY_CODE)
        try
        {
          MatchType localMatchType2 = isNumberMatch(parse(paramString2, "ZZ"), paramString1);
          return localMatchType2;
        }
        catch (NumberParseException localNumberParseException2)
        {
          if (localNumberParseException2.getErrorType() == NumberParseException.ErrorType.INVALID_COUNTRY_CODE)
            try
            {
              Phonenumber.PhoneNumber localPhoneNumber1 = new Phonenumber.PhoneNumber();
              Phonenumber.PhoneNumber localPhoneNumber2 = new Phonenumber.PhoneNumber();
              parseHelper(paramString1, null, false, false, localPhoneNumber1);
              parseHelper(paramString2, null, false, false, localPhoneNumber2);
              MatchType localMatchType1 = isNumberMatch(localPhoneNumber1, localPhoneNumber2);
              return localMatchType1;
            }
            catch (NumberParseException localNumberParseException3)
            {
            }
        }
    }
    return MatchType.NOT_A_NUMBER;
  }

  boolean isNumberMatchingDesc(String paramString, Phonemetadata.PhoneNumberDesc paramPhoneNumberDesc)
  {
    Matcher localMatcher = this.regexCache.getPatternForRegex(paramPhoneNumberDesc.getNationalNumberPattern()).matcher(paramString);
    return (isNumberPossibleForDesc(paramString, paramPhoneNumberDesc)) && (localMatcher.matches());
  }

  boolean isNumberPossibleForDesc(String paramString, Phonemetadata.PhoneNumberDesc paramPhoneNumberDesc)
  {
    return this.regexCache.getPatternForRegex(paramPhoneNumberDesc.getPossibleNumberPattern()).matcher(paramString).matches();
  }

  public boolean isPossibleNumber(Phonenumber.PhoneNumber paramPhoneNumber)
  {
    return isPossibleNumberWithReason(paramPhoneNumber) == ValidationResult.IS_POSSIBLE;
  }

  public boolean isPossibleNumber(String paramString1, String paramString2)
  {
    try
    {
      boolean bool = isPossibleNumber(parse(paramString1, paramString2));
      return bool;
    }
    catch (NumberParseException localNumberParseException)
    {
    }
    return false;
  }

  public ValidationResult isPossibleNumberWithReason(Phonenumber.PhoneNumber paramPhoneNumber)
  {
    String str = getNationalSignificantNumber(paramPhoneNumber);
    int i = paramPhoneNumber.getCountryCode();
    if (!hasValidCountryCallingCode(i))
      return ValidationResult.INVALID_COUNTRY_CODE;
    Phonemetadata.PhoneNumberDesc localPhoneNumberDesc = getMetadataForRegionOrCallingCode(i, getRegionCodeForCountryCode(i)).getGeneralDesc();
    if (!localPhoneNumberDesc.hasNationalNumberPattern())
    {
      logger.log(Level.FINER, "Checking if number is possible with incomplete metadata.");
      int j = str.length();
      if (j < 2)
        return ValidationResult.TOO_SHORT;
      if (j > 17)
        return ValidationResult.TOO_LONG;
      return ValidationResult.IS_POSSIBLE;
    }
    return testNumberLengthAgainstPattern(this.regexCache.getPatternForRegex(localPhoneNumberDesc.getPossibleNumberPattern()), str);
  }

  public boolean isValidNumber(Phonenumber.PhoneNumber paramPhoneNumber)
  {
    return isValidNumberForRegion(paramPhoneNumber, getRegionCodeForNumber(paramPhoneNumber));
  }

  public boolean isValidNumberForRegion(Phonenumber.PhoneNumber paramPhoneNumber, String paramString)
  {
    boolean bool = true;
    int i = paramPhoneNumber.getCountryCode();
    Phonemetadata.PhoneMetadata localPhoneMetadata = getMetadataForRegionOrCallingCode(i, paramString);
    if ((localPhoneMetadata == null) || ((!"001".equals(paramString)) && (i != getCountryCodeForValidRegion(paramString))))
      bool = false;
    String str;
    do
    {
      int j;
      do
      {
        return bool;
        Phonemetadata.PhoneNumberDesc localPhoneNumberDesc = localPhoneMetadata.getGeneralDesc();
        str = getNationalSignificantNumber(paramPhoneNumber);
        if (localPhoneNumberDesc.hasNationalNumberPattern())
          break;
        j = str.length();
      }
      while ((j > 2) && (j <= 17));
      return false;
    }
    while (getNumberTypeHelper(str, localPhoneMetadata) != PhoneNumberType.UNKNOWN);
    return false;
  }

  void loadMetadataFromFile(String paramString1, String paramString2, int paramInt, MetadataLoader paramMetadataLoader)
  {
    boolean bool = "001".equals(paramString2);
    String str1 = String.valueOf(String.valueOf(paramString1));
    String str2;
    String str4;
    InputStream localInputStream;
    String str16;
    label130: String str17;
    if (bool)
    {
      str2 = String.valueOf(paramInt);
      String str3 = String.valueOf(String.valueOf(str2));
      str4 = 1 + str1.length() + str3.length() + str1 + "_" + str3;
      localInputStream = paramMetadataLoader.loadMetadata(str4);
      if (localInputStream != null)
        break label210;
      Logger localLogger4 = logger;
      Level localLevel4 = Level.SEVERE;
      String str15 = String.valueOf(str4);
      if (str15.length() == 0)
        break label180;
      str16 = "missing metadata: ".concat(str15);
      localLogger4.log(localLevel4, str16);
      str17 = String.valueOf(str4);
      if (str17.length() == 0)
        break label195;
    }
    label180: label195: for (String str18 = "missing metadata: ".concat(str17); ; str18 = new String("missing metadata: "))
    {
      throw new IllegalStateException(str18);
      str2 = paramString2;
      break;
      str16 = new String("missing metadata: ");
      break label130;
    }
    try
    {
      label210: ObjectInputStream localObjectInputStream = new ObjectInputStream(localInputStream);
      List localList;
      String str12;
      String str14;
      try
      {
        localList = loadMetadataAndCloseInput(localObjectInputStream).getMetadataList();
        if (!localList.isEmpty())
          break label435;
        Logger localLogger3 = logger;
        Level localLevel3 = Level.SEVERE;
        String str11 = String.valueOf(str4);
        if (str11.length() == 0)
          break label405;
        str12 = "empty metadata: ".concat(str11);
        localLogger3.log(localLevel3, str12);
        String str13 = String.valueOf(str4);
        if (str13.length() == 0)
          break label420;
        str14 = "empty metadata: ".concat(str13);
        label310: throw new IllegalStateException(str14);
      }
      catch (IOException localIOException1)
      {
      }
      label322: Logger localLogger1 = logger;
      Level localLevel1 = Level.SEVERE;
      String str5 = String.valueOf(str4);
      String str6;
      label357: String str7;
      if (str5.length() != 0)
      {
        str6 = "cannot load/parse metadata: ".concat(str5);
        localLogger1.log(localLevel1, str6, localIOException1);
        str7 = String.valueOf(str4);
        if (str7.length() == 0)
          break label569;
      }
      label405: label420: label435: label569: for (String str8 = "cannot load/parse metadata: ".concat(str7); ; str8 = new String("cannot load/parse metadata: "))
      {
        throw new RuntimeException(str8, localIOException1);
        str12 = new String("empty metadata: ");
        break;
        str14 = new String("empty metadata: ");
        break label310;
        Logger localLogger2;
        Level localLevel2;
        String str9;
        if (localList.size() > 1)
        {
          localLogger2 = logger;
          localLevel2 = Level.WARNING;
          str9 = String.valueOf(str4);
          if (str9.length() == 0)
            break label525;
        }
        Phonemetadata.PhoneMetadata localPhoneMetadata;
        for (String str10 = "invalid metadata (too many entries): ".concat(str9); ; str10 = new String("invalid metadata (too many entries): "))
        {
          localLogger2.log(localLevel2, str10);
          localPhoneMetadata = (Phonemetadata.PhoneMetadata)localList.get(0);
          if (!bool)
            break;
          this.countryCodeToNonGeographicalMetadataMap.put(Integer.valueOf(paramInt), localPhoneMetadata);
          return;
        }
        this.regionToMetadataMap.put(paramString2, localPhoneMetadata);
        return;
        str6 = new String("cannot load/parse metadata: ");
        break label357;
      }
    }
    catch (IOException localIOException2)
    {
      label525: break label322;
    }
  }

  int maybeExtractCountryCode(String paramString, Phonemetadata.PhoneMetadata paramPhoneMetadata, StringBuilder paramStringBuilder, boolean paramBoolean, Phonenumber.PhoneNumber paramPhoneNumber)
    throws NumberParseException
  {
    if (paramString.length() == 0)
      return 0;
    StringBuilder localStringBuilder1 = new StringBuilder(paramString);
    String str1 = "NonMatch";
    if (paramPhoneMetadata != null)
      str1 = paramPhoneMetadata.getInternationalPrefix();
    Phonenumber.PhoneNumber.CountryCodeSource localCountryCodeSource = maybeStripInternationalPrefixAndNormalize(localStringBuilder1, str1);
    if (paramBoolean)
      paramPhoneNumber.setCountryCodeSource(localCountryCodeSource);
    if (localCountryCodeSource != Phonenumber.PhoneNumber.CountryCodeSource.FROM_DEFAULT_COUNTRY)
    {
      if (localStringBuilder1.length() <= 2)
        throw new NumberParseException(NumberParseException.ErrorType.TOO_SHORT_AFTER_IDD, "Phone number had an IDD, but after this was not long enough to be a viable phone number.");
      int j = extractCountryCode(localStringBuilder1, paramStringBuilder);
      if (j != 0)
      {
        paramPhoneNumber.setCountryCode(j);
        return j;
      }
      throw new NumberParseException(NumberParseException.ErrorType.INVALID_COUNTRY_CODE, "Country calling code supplied was not recognised.");
    }
    if (paramPhoneMetadata != null)
    {
      int i = paramPhoneMetadata.getCountryCode();
      String str2 = String.valueOf(i);
      String str3 = localStringBuilder1.toString();
      if (str3.startsWith(str2))
      {
        StringBuilder localStringBuilder2 = new StringBuilder(str3.substring(str2.length()));
        Phonemetadata.PhoneNumberDesc localPhoneNumberDesc = paramPhoneMetadata.getGeneralDesc();
        Pattern localPattern1 = this.regexCache.getPatternForRegex(localPhoneNumberDesc.getNationalNumberPattern());
        maybeStripNationalPrefixAndCarrierCode(localStringBuilder2, paramPhoneMetadata, null);
        Pattern localPattern2 = this.regexCache.getPatternForRegex(localPhoneNumberDesc.getPossibleNumberPattern());
        if (((!localPattern1.matcher(localStringBuilder1).matches()) && (localPattern1.matcher(localStringBuilder2).matches())) || (testNumberLengthAgainstPattern(localPattern2, localStringBuilder1.toString()) == ValidationResult.TOO_LONG))
        {
          paramStringBuilder.append(localStringBuilder2);
          if (paramBoolean)
            paramPhoneNumber.setCountryCodeSource(Phonenumber.PhoneNumber.CountryCodeSource.FROM_NUMBER_WITHOUT_PLUS_SIGN);
          paramPhoneNumber.setCountryCode(i);
          return i;
        }
      }
    }
    paramPhoneNumber.setCountryCode(0);
    return 0;
  }

  String maybeStripExtension(StringBuilder paramStringBuilder)
  {
    Matcher localMatcher = EXTN_PATTERN.matcher(paramStringBuilder);
    if ((localMatcher.find()) && (isViablePhoneNumber(paramStringBuilder.substring(0, localMatcher.start()))))
    {
      int i = 1;
      int j = localMatcher.groupCount();
      while (i <= j)
      {
        if (localMatcher.group(i) != null)
        {
          String str = localMatcher.group(i);
          paramStringBuilder.delete(localMatcher.start(), paramStringBuilder.length());
          return str;
        }
        i++;
      }
    }
    return "";
  }

  Phonenumber.PhoneNumber.CountryCodeSource maybeStripInternationalPrefixAndNormalize(StringBuilder paramStringBuilder, String paramString)
  {
    if (paramStringBuilder.length() == 0)
      return Phonenumber.PhoneNumber.CountryCodeSource.FROM_DEFAULT_COUNTRY;
    Matcher localMatcher = PLUS_CHARS_PATTERN.matcher(paramStringBuilder);
    if (localMatcher.lookingAt())
    {
      paramStringBuilder.delete(0, localMatcher.end());
      normalize(paramStringBuilder);
      return Phonenumber.PhoneNumber.CountryCodeSource.FROM_NUMBER_WITH_PLUS_SIGN;
    }
    Pattern localPattern = this.regexCache.getPatternForRegex(paramString);
    normalize(paramStringBuilder);
    if (parsePrefixAsIdd(localPattern, paramStringBuilder))
      return Phonenumber.PhoneNumber.CountryCodeSource.FROM_NUMBER_WITH_IDD;
    return Phonenumber.PhoneNumber.CountryCodeSource.FROM_DEFAULT_COUNTRY;
  }

  boolean maybeStripNationalPrefixAndCarrierCode(StringBuilder paramStringBuilder1, Phonemetadata.PhoneMetadata paramPhoneMetadata, StringBuilder paramStringBuilder2)
  {
    int i = paramStringBuilder1.length();
    String str1 = paramPhoneMetadata.getNationalPrefixForParsing();
    if ((i == 0) || (str1.length() == 0));
    Matcher localMatcher;
    Pattern localPattern;
    boolean bool;
    int j;
    StringBuilder localStringBuilder;
    do
    {
      String str2;
      do
      {
        do
        {
          return false;
          localMatcher = this.regexCache.getPatternForRegex(str1).matcher(paramStringBuilder1);
        }
        while (!localMatcher.lookingAt());
        localPattern = this.regexCache.getPatternForRegex(paramPhoneMetadata.getGeneralDesc().getNationalNumberPattern());
        bool = localPattern.matcher(paramStringBuilder1).matches();
        j = localMatcher.groupCount();
        str2 = paramPhoneMetadata.getNationalPrefixTransformRule();
        if ((str2 != null) && (str2.length() != 0) && (localMatcher.group(j) != null))
          break;
      }
      while ((bool) && (!localPattern.matcher(paramStringBuilder1.substring(localMatcher.end())).matches()));
      if ((paramStringBuilder2 != null) && (j > 0) && (localMatcher.group(j) != null))
        paramStringBuilder2.append(localMatcher.group(1));
      paramStringBuilder1.delete(0, localMatcher.end());
      return true;
      localStringBuilder = new StringBuilder(paramStringBuilder1);
      localStringBuilder.replace(0, i, localMatcher.replaceFirst(str2));
    }
    while ((bool) && (!localPattern.matcher(localStringBuilder.toString()).matches()));
    if ((paramStringBuilder2 != null) && (j > 1))
      paramStringBuilder2.append(localMatcher.group(1));
    paramStringBuilder1.replace(0, paramStringBuilder1.length(), localStringBuilder.toString());
    return true;
  }

  public Phonenumber.PhoneNumber parse(String paramString1, String paramString2)
    throws NumberParseException
  {
    Phonenumber.PhoneNumber localPhoneNumber = new Phonenumber.PhoneNumber();
    parse(paramString1, paramString2, localPhoneNumber);
    return localPhoneNumber;
  }

  public void parse(String paramString1, String paramString2, Phonenumber.PhoneNumber paramPhoneNumber)
    throws NumberParseException
  {
    parseHelper(paramString1, paramString2, false, true, paramPhoneNumber);
  }

  public Phonenumber.PhoneNumber parseAndKeepRawInput(String paramString1, String paramString2)
    throws NumberParseException
  {
    Phonenumber.PhoneNumber localPhoneNumber = new Phonenumber.PhoneNumber();
    parseAndKeepRawInput(paramString1, paramString2, localPhoneNumber);
    return localPhoneNumber;
  }

  public void parseAndKeepRawInput(String paramString1, String paramString2, Phonenumber.PhoneNumber paramPhoneNumber)
    throws NumberParseException
  {
    parseHelper(paramString1, paramString2, true, true, paramPhoneNumber);
  }

  public boolean truncateTooLongNumber(Phonenumber.PhoneNumber paramPhoneNumber)
  {
    if (isValidNumber(paramPhoneNumber))
      return true;
    Phonenumber.PhoneNumber localPhoneNumber = new Phonenumber.PhoneNumber();
    localPhoneNumber.mergeFrom(paramPhoneNumber);
    long l = paramPhoneNumber.getNationalNumber();
    do
    {
      l /= 10L;
      localPhoneNumber.setNationalNumber(l);
      if ((isPossibleNumberWithReason(localPhoneNumber) == ValidationResult.TOO_SHORT) || (l == 0L))
        return false;
    }
    while (!isValidNumber(localPhoneNumber));
    paramPhoneNumber.setNationalNumber(l);
    return true;
  }

  public static abstract enum Leniency
  {
    static
    {
      // Byte code:
      //   0: new 16	com/google/i18n/phonenumbers/PhoneNumberUtil$Leniency$1
      //   3: dup
      //   4: ldc 17
      //   6: iconst_0
      //   7: invokespecial 21	com/google/i18n/phonenumbers/PhoneNumberUtil$Leniency$1:<init>	(Ljava/lang/String;I)V
      //   10: putstatic 23	com/google/i18n/phonenumbers/PhoneNumberUtil$Leniency:POSSIBLE	Lcom/google/i18n/phonenumbers/PhoneNumberUtil$Leniency;
      //   13: new 25	com/google/i18n/phonenumbers/PhoneNumberUtil$Leniency$2
      //   16: dup
      //   17: ldc 26
      //   19: iconst_1
      //   20: invokespecial 27	com/google/i18n/phonenumbers/PhoneNumberUtil$Leniency$2:<init>	(Ljava/lang/String;I)V
      //   23: putstatic 29	com/google/i18n/phonenumbers/PhoneNumberUtil$Leniency:VALID	Lcom/google/i18n/phonenumbers/PhoneNumberUtil$Leniency;
      //   26: new 31	com/google/i18n/phonenumbers/PhoneNumberUtil$Leniency$3
      //   29: dup
      //   30: ldc 32
      //   32: iconst_2
      //   33: invokespecial 33	com/google/i18n/phonenumbers/PhoneNumberUtil$Leniency$3:<init>	(Ljava/lang/String;I)V
      //   36: putstatic 35	com/google/i18n/phonenumbers/PhoneNumberUtil$Leniency:STRICT_GROUPING	Lcom/google/i18n/phonenumbers/PhoneNumberUtil$Leniency;
      //   39: new 37	com/google/i18n/phonenumbers/PhoneNumberUtil$Leniency$4
      //   42: dup
      //   43: ldc 38
      //   45: iconst_3
      //   46: invokespecial 39	com/google/i18n/phonenumbers/PhoneNumberUtil$Leniency$4:<init>	(Ljava/lang/String;I)V
      //   49: putstatic 41	com/google/i18n/phonenumbers/PhoneNumberUtil$Leniency:EXACT_GROUPING	Lcom/google/i18n/phonenumbers/PhoneNumberUtil$Leniency;
      //   52: iconst_4
      //   53: anewarray 2	com/google/i18n/phonenumbers/PhoneNumberUtil$Leniency
      //   56: astore_0
      //   57: aload_0
      //   58: iconst_0
      //   59: getstatic 23	com/google/i18n/phonenumbers/PhoneNumberUtil$Leniency:POSSIBLE	Lcom/google/i18n/phonenumbers/PhoneNumberUtil$Leniency;
      //   62: aastore
      //   63: aload_0
      //   64: iconst_1
      //   65: getstatic 29	com/google/i18n/phonenumbers/PhoneNumberUtil$Leniency:VALID	Lcom/google/i18n/phonenumbers/PhoneNumberUtil$Leniency;
      //   68: aastore
      //   69: aload_0
      //   70: iconst_2
      //   71: getstatic 35	com/google/i18n/phonenumbers/PhoneNumberUtil$Leniency:STRICT_GROUPING	Lcom/google/i18n/phonenumbers/PhoneNumberUtil$Leniency;
      //   74: aastore
      //   75: aload_0
      //   76: iconst_3
      //   77: getstatic 41	com/google/i18n/phonenumbers/PhoneNumberUtil$Leniency:EXACT_GROUPING	Lcom/google/i18n/phonenumbers/PhoneNumberUtil$Leniency;
      //   80: aastore
      //   81: aload_0
      //   82: putstatic 43	com/google/i18n/phonenumbers/PhoneNumberUtil$Leniency:$VALUES	[Lcom/google/i18n/phonenumbers/PhoneNumberUtil$Leniency;
      //   85: return
    }

    abstract boolean verify(Phonenumber.PhoneNumber paramPhoneNumber, String paramString, PhoneNumberUtil paramPhoneNumberUtil);
  }

  public static enum MatchType
  {
    static
    {
      NSN_MATCH = new MatchType("NSN_MATCH", 3);
      EXACT_MATCH = new MatchType("EXACT_MATCH", 4);
      MatchType[] arrayOfMatchType = new MatchType[5];
      arrayOfMatchType[0] = NOT_A_NUMBER;
      arrayOfMatchType[1] = NO_MATCH;
      arrayOfMatchType[2] = SHORT_NSN_MATCH;
      arrayOfMatchType[3] = NSN_MATCH;
      arrayOfMatchType[4] = EXACT_MATCH;
    }
  }

  public static enum PhoneNumberFormat
  {
    static
    {
      PhoneNumberFormat[] arrayOfPhoneNumberFormat = new PhoneNumberFormat[4];
      arrayOfPhoneNumberFormat[0] = E164;
      arrayOfPhoneNumberFormat[1] = INTERNATIONAL;
      arrayOfPhoneNumberFormat[2] = NATIONAL;
      arrayOfPhoneNumberFormat[3] = RFC3966;
    }
  }

  public static enum PhoneNumberType
  {
    static
    {
      FIXED_LINE_OR_MOBILE = new PhoneNumberType("FIXED_LINE_OR_MOBILE", 2);
      TOLL_FREE = new PhoneNumberType("TOLL_FREE", 3);
      PREMIUM_RATE = new PhoneNumberType("PREMIUM_RATE", 4);
      SHARED_COST = new PhoneNumberType("SHARED_COST", 5);
      VOIP = new PhoneNumberType("VOIP", 6);
      PERSONAL_NUMBER = new PhoneNumberType("PERSONAL_NUMBER", 7);
      PAGER = new PhoneNumberType("PAGER", 8);
      UAN = new PhoneNumberType("UAN", 9);
      VOICEMAIL = new PhoneNumberType("VOICEMAIL", 10);
      UNKNOWN = new PhoneNumberType("UNKNOWN", 11);
      PhoneNumberType[] arrayOfPhoneNumberType = new PhoneNumberType[12];
      arrayOfPhoneNumberType[0] = FIXED_LINE;
      arrayOfPhoneNumberType[1] = MOBILE;
      arrayOfPhoneNumberType[2] = FIXED_LINE_OR_MOBILE;
      arrayOfPhoneNumberType[3] = TOLL_FREE;
      arrayOfPhoneNumberType[4] = PREMIUM_RATE;
      arrayOfPhoneNumberType[5] = SHARED_COST;
      arrayOfPhoneNumberType[6] = VOIP;
      arrayOfPhoneNumberType[7] = PERSONAL_NUMBER;
      arrayOfPhoneNumberType[8] = PAGER;
      arrayOfPhoneNumberType[9] = UAN;
      arrayOfPhoneNumberType[10] = VOICEMAIL;
      arrayOfPhoneNumberType[11] = UNKNOWN;
    }
  }

  public static enum ValidationResult
  {
    static
    {
      INVALID_COUNTRY_CODE = new ValidationResult("INVALID_COUNTRY_CODE", 1);
      TOO_SHORT = new ValidationResult("TOO_SHORT", 2);
      TOO_LONG = new ValidationResult("TOO_LONG", 3);
      ValidationResult[] arrayOfValidationResult = new ValidationResult[4];
      arrayOfValidationResult[0] = IS_POSSIBLE;
      arrayOfValidationResult[1] = INVALID_COUNTRY_CODE;
      arrayOfValidationResult[2] = TOO_SHORT;
      arrayOfValidationResult[3] = TOO_LONG;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.i18n.phonenumbers.PhoneNumberUtil
 * JD-Core Version:    0.6.2
 */