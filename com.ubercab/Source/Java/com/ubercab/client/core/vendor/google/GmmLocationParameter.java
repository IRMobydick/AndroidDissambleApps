package com.ubercab.client.core.vendor.google;

import java.util.List;

final class GmmLocationParameter
{
  private List<String> mAddressTypes;
  private String mDescriptionType;
  private String mLocationType;
  private String mValue;

  GmmLocationParameter(String paramString1, List<String> paramList, String paramString2, String paramString3)
  {
    this.mLocationType = paramString1;
    this.mAddressTypes = paramList;
    this.mDescriptionType = paramString2;
    this.mValue = paramString3;
  }

  public List<String> getAddressTypes()
  {
    return this.mAddressTypes;
  }

  public String getDescriptionType()
  {
    return this.mDescriptionType;
  }

  public String getLocationType()
  {
    return this.mLocationType;
  }

  public String getValue()
  {
    return this.mValue;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.vendor.google.GmmLocationParameter
 * JD-Core Version:    0.6.2
 */