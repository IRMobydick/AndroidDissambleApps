package com.ubercab.client.core.locale;

public enum Regions
{
  private final String mIso2;

  static
  {
    CHINA = new Regions("CHINA", 1, "ZH");
    TAIWAN = new Regions("TAIWAN", 2, "TW");
    JAPAN = new Regions("JAPAN", 3, "JP");
    KOREA = new Regions("KOREA", 4, "KR");
    Regions[] arrayOfRegions = new Regions[5];
    arrayOfRegions[0] = UNKNOWN;
    arrayOfRegions[1] = CHINA;
    arrayOfRegions[2] = TAIWAN;
    arrayOfRegions[3] = JAPAN;
    arrayOfRegions[4] = KOREA;
  }

  private Regions(String paramString)
  {
    this.mIso2 = paramString;
  }

  public static Regions fromIso2(String paramString)
  {
    for (Regions localRegions : values())
      if (paramString.equals(localRegions.mIso2))
        return localRegions;
    return UNKNOWN;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.locale.Regions
 * JD-Core Version:    0.6.2
 */