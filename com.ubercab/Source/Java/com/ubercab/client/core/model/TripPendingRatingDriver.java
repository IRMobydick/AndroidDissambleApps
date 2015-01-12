package com.ubercab.client.core.model;

public final class TripPendingRatingDriver
{
  private Boolean displayCompany;
  private String id;
  private String mobile;
  private String name;
  private String partnerCompany;
  private String pictureUrl;
  private String rating;
  private String status;

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    TripPendingRatingDriver localTripPendingRatingDriver;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localTripPendingRatingDriver = (TripPendingRatingDriver)paramObject;
      if (this.displayCompany != null)
      {
        if (this.displayCompany.equals(localTripPendingRatingDriver.displayCompany));
      }
      else
        while (localTripPendingRatingDriver.displayCompany != null)
          return false;
      if (this.id != null)
      {
        if (this.id.equals(localTripPendingRatingDriver.id));
      }
      else
        while (localTripPendingRatingDriver.id != null)
          return false;
      if (this.mobile != null)
      {
        if (this.mobile.equals(localTripPendingRatingDriver.mobile));
      }
      else
        while (localTripPendingRatingDriver.mobile != null)
          return false;
      if (this.name != null)
      {
        if (this.name.equals(localTripPendingRatingDriver.name));
      }
      else
        while (localTripPendingRatingDriver.name != null)
          return false;
      if (this.partnerCompany != null)
      {
        if (this.partnerCompany.equals(localTripPendingRatingDriver.partnerCompany));
      }
      else
        while (localTripPendingRatingDriver.partnerCompany != null)
          return false;
      if (this.pictureUrl != null)
      {
        if (this.pictureUrl.equals(localTripPendingRatingDriver.pictureUrl));
      }
      else
        while (localTripPendingRatingDriver.pictureUrl != null)
          return false;
      if (this.rating != null)
      {
        if (this.rating.equals(localTripPendingRatingDriver.rating));
      }
      else
        while (localTripPendingRatingDriver.rating != null)
          return false;
      if (this.status == null)
        break;
    }
    while (this.status.equals(localTripPendingRatingDriver.status));
    while (true)
    {
      return false;
      if (localTripPendingRatingDriver.status == null)
        break;
    }
  }

  public String getId()
  {
    return this.id;
  }

  public String getMobile()
  {
    return this.mobile;
  }

  public String getName()
  {
    return this.name;
  }

  public String getPartnerCompany()
  {
    return this.partnerCompany;
  }

  public String getPictureUrl()
  {
    return this.pictureUrl;
  }

  public String getRating()
  {
    return this.rating;
  }

  public String getStatus()
  {
    return this.status;
  }

  public int hashCode()
  {
    int i;
    int k;
    label35: int n;
    label59: int i2;
    label85: int i4;
    label111: int i6;
    label137: int i7;
    if (this.id != null)
    {
      i = this.id.hashCode();
      int j = i * 31;
      if (this.name == null)
        break label207;
      k = this.name.hashCode();
      int m = 31 * (j + k);
      if (this.mobile == null)
        break label212;
      n = this.mobile.hashCode();
      int i1 = 31 * (m + n);
      if (this.status == null)
        break label218;
      i2 = this.status.hashCode();
      int i3 = 31 * (i1 + i2);
      if (this.rating == null)
        break label224;
      i4 = this.rating.hashCode();
      int i5 = 31 * (i3 + i4);
      if (this.pictureUrl == null)
        break label230;
      i6 = this.pictureUrl.hashCode();
      i7 = 31 * (i5 + i6);
      if (this.partnerCompany == null)
        break label236;
    }
    label207: label212: label218: label224: label230: label236: for (int i8 = this.partnerCompany.hashCode(); ; i8 = 0)
    {
      int i9 = 31 * (i7 + i8);
      Boolean localBoolean = this.displayCompany;
      int i10 = 0;
      if (localBoolean != null)
        i10 = this.displayCompany.hashCode();
      return i9 + i10;
      i = 0;
      break;
      k = 0;
      break label35;
      n = 0;
      break label59;
      i2 = 0;
      break label85;
      i4 = 0;
      break label111;
      i6 = 0;
      break label137;
    }
  }

  public boolean isDisplayCompany()
  {
    if (this.displayCompany == null)
      return false;
    return this.displayCompany.booleanValue();
  }

  public void setName(String paramString)
  {
    this.name = paramString;
  }

  public void setPictureUrl(String paramString)
  {
    this.pictureUrl = paramString;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.model.TripPendingRatingDriver
 * JD-Core Version:    0.6.2
 */