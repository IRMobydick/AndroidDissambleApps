package com.google.i18n.phonenumbers;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ShortNumberInfo
{
  private static final ShortNumberInfo INSTANCE;
  private static final Set<String> REGIONS_WHERE_EMERGENCY_NUMBERS_MUST_BE_EXACT;
  private static final Logger logger = Logger.getLogger(ShortNumberInfo.class.getName());
  private final PhoneNumberUtil phoneUtil;

  static
  {
    INSTANCE = new ShortNumberInfo(PhoneNumberUtil.getInstance());
    REGIONS_WHERE_EMERGENCY_NUMBERS_MUST_BE_EXACT = new HashSet();
    REGIONS_WHERE_EMERGENCY_NUMBERS_MUST_BE_EXACT.add("BR");
    REGIONS_WHERE_EMERGENCY_NUMBERS_MUST_BE_EXACT.add("CL");
    REGIONS_WHERE_EMERGENCY_NUMBERS_MUST_BE_EXACT.add("NI");
  }

  ShortNumberInfo(PhoneNumberUtil paramPhoneNumberUtil)
  {
    this.phoneUtil = paramPhoneNumberUtil;
  }

  public static ShortNumberInfo getInstance()
  {
    return INSTANCE;
  }

  private String getRegionCodeForShortNumberFromRegionList(Phonenumber.PhoneNumber paramPhoneNumber, List<String> paramList)
  {
    if (paramList.size() == 0);
    String str1;
    String str2;
    Phonemetadata.PhoneMetadata localPhoneMetadata;
    do
    {
      Iterator localIterator;
      while (!localIterator.hasNext())
      {
        return null;
        if (paramList.size() == 1)
          return (String)paramList.get(0);
        str1 = this.phoneUtil.getNationalSignificantNumber(paramPhoneNumber);
        localIterator = paramList.iterator();
      }
      str2 = (String)localIterator.next();
      localPhoneMetadata = MetadataManager.getShortNumberMetadataForRegion(str2);
    }
    while ((localPhoneMetadata == null) || (!this.phoneUtil.isNumberMatchingDesc(str1, localPhoneMetadata.getShortCode())));
    return str2;
  }

  private boolean matchesEmergencyNumberHelper(String paramString1, String paramString2, boolean paramBoolean)
  {
    String str1 = PhoneNumberUtil.extractPossibleNumber(paramString1);
    if (PhoneNumberUtil.PLUS_CHARS_PATTERN.matcher(str1).lookingAt());
    Phonemetadata.PhoneMetadata localPhoneMetadata;
    do
    {
      return false;
      localPhoneMetadata = MetadataManager.getShortNumberMetadataForRegion(paramString2);
    }
    while ((localPhoneMetadata == null) || (!localPhoneMetadata.hasEmergency()));
    Pattern localPattern = Pattern.compile(localPhoneMetadata.getEmergency().getNationalNumberPattern());
    String str2 = PhoneNumberUtil.normalizeDigitsOnly(str1);
    if ((!paramBoolean) || (REGIONS_WHERE_EMERGENCY_NUMBERS_MUST_BE_EXACT.contains(paramString2)))
      return localPattern.matcher(str2).matches();
    return localPattern.matcher(str2).lookingAt();
  }

  public boolean connectsToEmergencyNumber(String paramString1, String paramString2)
  {
    return matchesEmergencyNumberHelper(paramString1, paramString2, true);
  }

  String getExampleShortNumber(String paramString)
  {
    Phonemetadata.PhoneMetadata localPhoneMetadata = MetadataManager.getShortNumberMetadataForRegion(paramString);
    if (localPhoneMetadata == null)
      return "";
    Phonemetadata.PhoneNumberDesc localPhoneNumberDesc = localPhoneMetadata.getShortCode();
    if (localPhoneNumberDesc.hasExampleNumber())
      return localPhoneNumberDesc.getExampleNumber();
    return "";
  }

  String getExampleShortNumberForCost(String paramString, ShortNumberCost paramShortNumberCost)
  {
    Phonemetadata.PhoneMetadata localPhoneMetadata = MetadataManager.getShortNumberMetadataForRegion(paramString);
    if (localPhoneMetadata == null)
      return "";
    int i = 1.$SwitchMap$com$google$i18n$phonenumbers$ShortNumberInfo$ShortNumberCost[paramShortNumberCost.ordinal()];
    Phonemetadata.PhoneNumberDesc localPhoneNumberDesc = null;
    switch (i)
    {
    case 2:
    default:
    case 4:
    case 3:
    case 1:
    }
    while ((localPhoneNumberDesc != null) && (localPhoneNumberDesc.hasExampleNumber()))
    {
      return localPhoneNumberDesc.getExampleNumber();
      localPhoneNumberDesc = localPhoneMetadata.getTollFree();
      continue;
      localPhoneNumberDesc = localPhoneMetadata.getStandardRate();
      continue;
      localPhoneNumberDesc = localPhoneMetadata.getPremiumRate();
    }
    return "";
  }

  public ShortNumberCost getExpectedCost(Phonenumber.PhoneNumber paramPhoneNumber)
  {
    List localList = this.phoneUtil.getRegionCodesForCountryCode(paramPhoneNumber.getCountryCode());
    ShortNumberCost localShortNumberCost1;
    if (localList.size() == 0)
      localShortNumberCost1 = ShortNumberCost.UNKNOWN_COST;
    while (true)
    {
      return localShortNumberCost1;
      String str1 = this.phoneUtil.getNationalSignificantNumber(paramPhoneNumber);
      if (localList.size() == 1)
        return getExpectedCostForRegion(str1, (String)localList.get(0));
      localShortNumberCost1 = ShortNumberCost.TOLL_FREE;
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        ShortNumberCost localShortNumberCost2 = getExpectedCostForRegion(str1, (String)localIterator.next());
        switch (1.$SwitchMap$com$google$i18n$phonenumbers$ShortNumberInfo$ShortNumberCost[localShortNumberCost2.ordinal()])
        {
        case 4:
        default:
          Logger localLogger = logger;
          Level localLevel = Level.SEVERE;
          String str2 = String.valueOf(String.valueOf(localShortNumberCost2));
          localLogger.log(localLevel, 30 + str2.length() + "Unrecognised cost for region: " + str2);
          break;
        case 1:
          return ShortNumberCost.PREMIUM_RATE;
        case 2:
          localShortNumberCost1 = ShortNumberCost.UNKNOWN_COST;
          break;
        case 3:
          if (localShortNumberCost1 != ShortNumberCost.UNKNOWN_COST)
            localShortNumberCost1 = ShortNumberCost.STANDARD_RATE;
          break;
        }
      }
    }
  }

  public ShortNumberCost getExpectedCostForRegion(String paramString1, String paramString2)
  {
    Phonemetadata.PhoneMetadata localPhoneMetadata = MetadataManager.getShortNumberMetadataForRegion(paramString2);
    if (localPhoneMetadata == null)
      return ShortNumberCost.UNKNOWN_COST;
    if (this.phoneUtil.isNumberMatchingDesc(paramString1, localPhoneMetadata.getPremiumRate()))
      return ShortNumberCost.PREMIUM_RATE;
    if (this.phoneUtil.isNumberMatchingDesc(paramString1, localPhoneMetadata.getStandardRate()))
      return ShortNumberCost.STANDARD_RATE;
    if (this.phoneUtil.isNumberMatchingDesc(paramString1, localPhoneMetadata.getTollFree()))
      return ShortNumberCost.TOLL_FREE;
    if (isEmergencyNumber(paramString1, paramString2))
      return ShortNumberCost.TOLL_FREE;
    return ShortNumberCost.UNKNOWN_COST;
  }

  Set<String> getSupportedRegions()
  {
    return Collections.unmodifiableSet(MetadataManager.getShortNumberMetadataSupportedRegions());
  }

  public boolean isCarrierSpecific(Phonenumber.PhoneNumber paramPhoneNumber)
  {
    String str1 = getRegionCodeForShortNumberFromRegionList(paramPhoneNumber, this.phoneUtil.getRegionCodesForCountryCode(paramPhoneNumber.getCountryCode()));
    String str2 = this.phoneUtil.getNationalSignificantNumber(paramPhoneNumber);
    Phonemetadata.PhoneMetadata localPhoneMetadata = MetadataManager.getShortNumberMetadataForRegion(str1);
    return (localPhoneMetadata != null) && (this.phoneUtil.isNumberMatchingDesc(str2, localPhoneMetadata.getCarrierSpecific()));
  }

  public boolean isEmergencyNumber(String paramString1, String paramString2)
  {
    return matchesEmergencyNumberHelper(paramString1, paramString2, false);
  }

  public boolean isPossibleShortNumber(Phonenumber.PhoneNumber paramPhoneNumber)
  {
    List localList = this.phoneUtil.getRegionCodesForCountryCode(paramPhoneNumber.getCountryCode());
    String str = this.phoneUtil.getNationalSignificantNumber(paramPhoneNumber);
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      Phonemetadata.PhoneMetadata localPhoneMetadata = MetadataManager.getShortNumberMetadataForRegion((String)localIterator.next());
      if (this.phoneUtil.isNumberPossibleForDesc(str, localPhoneMetadata.getGeneralDesc()))
        return true;
    }
    return false;
  }

  public boolean isPossibleShortNumberForRegion(String paramString1, String paramString2)
  {
    Phonemetadata.PhoneMetadata localPhoneMetadata = MetadataManager.getShortNumberMetadataForRegion(paramString2);
    if (localPhoneMetadata == null)
      return false;
    Phonemetadata.PhoneNumberDesc localPhoneNumberDesc = localPhoneMetadata.getGeneralDesc();
    return this.phoneUtil.isNumberPossibleForDesc(paramString1, localPhoneNumberDesc);
  }

  public boolean isValidShortNumber(Phonenumber.PhoneNumber paramPhoneNumber)
  {
    List localList = this.phoneUtil.getRegionCodesForCountryCode(paramPhoneNumber.getCountryCode());
    String str1 = this.phoneUtil.getNationalSignificantNumber(paramPhoneNumber);
    String str2 = getRegionCodeForShortNumberFromRegionList(paramPhoneNumber, localList);
    if ((localList.size() > 1) && (str2 != null))
      return true;
    return isValidShortNumberForRegion(str1, str2);
  }

  public boolean isValidShortNumberForRegion(String paramString1, String paramString2)
  {
    Phonemetadata.PhoneMetadata localPhoneMetadata = MetadataManager.getShortNumberMetadataForRegion(paramString2);
    if (localPhoneMetadata == null)
      return false;
    Phonemetadata.PhoneNumberDesc localPhoneNumberDesc1 = localPhoneMetadata.getGeneralDesc();
    if ((!localPhoneNumberDesc1.hasNationalNumberPattern()) || (!this.phoneUtil.isNumberMatchingDesc(paramString1, localPhoneNumberDesc1)))
      return false;
    Phonemetadata.PhoneNumberDesc localPhoneNumberDesc2 = localPhoneMetadata.getShortCode();
    if (!localPhoneNumberDesc2.hasNationalNumberPattern())
    {
      Logger localLogger = logger;
      Level localLevel = Level.WARNING;
      String str1 = String.valueOf(paramString2);
      if (str1.length() != 0);
      for (String str2 = "No short code national number pattern found for region: ".concat(str1); ; str2 = new String("No short code national number pattern found for region: "))
      {
        localLogger.log(localLevel, str2);
        return false;
      }
    }
    return this.phoneUtil.isNumberMatchingDesc(paramString1, localPhoneNumberDesc2);
  }

  public static enum ShortNumberCost
  {
    static
    {
      STANDARD_RATE = new ShortNumberCost("STANDARD_RATE", 1);
      PREMIUM_RATE = new ShortNumberCost("PREMIUM_RATE", 2);
      UNKNOWN_COST = new ShortNumberCost("UNKNOWN_COST", 3);
      ShortNumberCost[] arrayOfShortNumberCost = new ShortNumberCost[4];
      arrayOfShortNumberCost[0] = TOLL_FREE;
      arrayOfShortNumberCost[1] = STANDARD_RATE;
      arrayOfShortNumberCost[2] = PREMIUM_RATE;
      arrayOfShortNumberCost[3] = UNKNOWN_COST;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.i18n.phonenumbers.ShortNumberInfo
 * JD-Core Version:    0.6.2
 */