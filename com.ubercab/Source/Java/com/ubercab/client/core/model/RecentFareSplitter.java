package com.ubercab.client.core.model;

public final class RecentFareSplitter
{
  private String mobileCountryIso2;
  private String mobileDigits;
  private String name;
  private String pictureUrl;

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    RecentFareSplitter localRecentFareSplitter;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localRecentFareSplitter = (RecentFareSplitter)paramObject;
      if (this.mobileCountryIso2 != null)
      {
        if (this.mobileCountryIso2.equals(localRecentFareSplitter.mobileCountryIso2));
      }
      else
        while (localRecentFareSplitter.mobileCountryIso2 != null)
          return false;
      if (this.mobileDigits != null)
      {
        if (this.mobileDigits.equals(localRecentFareSplitter.mobileDigits));
      }
      else
        while (localRecentFareSplitter.mobileDigits != null)
          return false;
      if (this.name != null)
      {
        if (this.name.equals(localRecentFareSplitter.name));
      }
      else
        while (localRecentFareSplitter.name != null)
          return false;
      if (this.pictureUrl == null)
        break;
    }
    while (this.pictureUrl.equals(localRecentFareSplitter.pictureUrl));
    while (true)
    {
      return false;
      if (localRecentFareSplitter.pictureUrl == null)
        break;
    }
  }

  public String getMobileCountryIso2()
  {
    return this.mobileCountryIso2;
  }

  public String getMobileDigits()
  {
    return this.mobileDigits;
  }

  public String getName()
  {
    return this.name;
  }

  public String getPictureUrl()
  {
    return this.pictureUrl;
  }

  public int hashCode()
  {
    int i;
    int k;
    label35: int m;
    if (this.name != null)
    {
      i = this.name.hashCode();
      int j = i * 31;
      if (this.mobileDigits == null)
        break label103;
      k = this.mobileDigits.hashCode();
      m = 31 * (j + k);
      if (this.mobileCountryIso2 == null)
        break label108;
    }
    label103: label108: for (int n = this.mobileCountryIso2.hashCode(); ; n = 0)
    {
      int i1 = 31 * (m + n);
      String str = this.pictureUrl;
      int i2 = 0;
      if (str != null)
        i2 = this.pictureUrl.hashCode();
      return i1 + i2;
      i = 0;
      break;
      k = 0;
      break label35;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.model.RecentFareSplitter
 * JD-Core Version:    0.6.2
 */