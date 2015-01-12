package com.ubercab.client.core.model;

import java.util.List;

public final class TripPendingRating
{
  private TripPendingRatingDriver driver;
  private Long dropoffEpoch;
  ExtraPaymentData extraPaymentData;
  private String fareBilledToCardString;
  private String fareString;
  private List<FeedbackType> feedbackTypes;
  String id;
  private VehicleView vehicleView;

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    TripPendingRating localTripPendingRating;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localTripPendingRating = (TripPendingRating)paramObject;
      if (this.driver != null)
      {
        if (this.driver.equals(localTripPendingRating.driver));
      }
      else
        while (localTripPendingRating.driver != null)
          return false;
      if (this.dropoffEpoch != null)
      {
        if (this.dropoffEpoch.equals(localTripPendingRating.dropoffEpoch));
      }
      else
        while (localTripPendingRating.dropoffEpoch != null)
          return false;
      if (this.extraPaymentData != null)
      {
        if (this.extraPaymentData.equals(localTripPendingRating.extraPaymentData));
      }
      else
        while (localTripPendingRating.extraPaymentData != null)
          return false;
      if (this.fareBilledToCardString != null)
      {
        if (this.fareBilledToCardString.equals(localTripPendingRating.fareBilledToCardString));
      }
      else
        while (localTripPendingRating.fareBilledToCardString != null)
          return false;
      if (this.fareString != null)
      {
        if (this.fareString.equals(localTripPendingRating.fareString));
      }
      else
        while (localTripPendingRating.fareString != null)
          return false;
      if (this.feedbackTypes != null)
      {
        if (this.feedbackTypes.equals(localTripPendingRating.feedbackTypes));
      }
      else
        while (localTripPendingRating.feedbackTypes != null)
          return false;
      if (this.id != null)
      {
        if (this.id.equals(localTripPendingRating.id));
      }
      else
        while (localTripPendingRating.id != null)
          return false;
      if (this.vehicleView == null)
        break;
    }
    while (this.vehicleView.equals(localTripPendingRating.vehicleView));
    while (true)
    {
      return false;
      if (localTripPendingRating.vehicleView == null)
        break;
    }
  }

  public TripPendingRatingDriver getDriver()
  {
    return this.driver;
  }

  public Long getDropOffEpoch()
  {
    return this.dropoffEpoch;
  }

  public ExtraPaymentData getExtraPaymentData()
  {
    return this.extraPaymentData;
  }

  public String getFareBilledToCardString()
  {
    return this.fareBilledToCardString;
  }

  public String getFareString()
  {
    return this.fareString;
  }

  public List<FeedbackType> getFeedbackTypes()
  {
    return this.feedbackTypes;
  }

  public String getId()
  {
    return this.id;
  }

  public VehicleView getVehicleView()
  {
    return this.vehicleView;
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
      if (this.extraPaymentData == null)
        break label209;
      k = this.extraPaymentData.hashCode();
      int m = 31 * (j + k);
      if (this.dropoffEpoch == null)
        break label214;
      n = this.dropoffEpoch.hashCode();
      int i1 = 31 * (m + n);
      if (this.fareString == null)
        break label220;
      i2 = this.fareString.hashCode();
      int i3 = 31 * (i1 + i2);
      if (this.vehicleView == null)
        break label226;
      i4 = this.vehicleView.hashCode();
      int i5 = 31 * (i3 + i4);
      if (this.fareBilledToCardString == null)
        break label232;
      i6 = this.fareBilledToCardString.hashCode();
      i7 = 31 * (i5 + i6);
      if (this.driver == null)
        break label238;
    }
    label209: label214: label220: label226: label232: label238: for (int i8 = this.driver.hashCode(); ; i8 = 0)
    {
      int i9 = 31 * (i7 + i8);
      List localList = this.feedbackTypes;
      int i10 = 0;
      if (localList != null)
        i10 = this.feedbackTypes.hashCode();
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

  public void setDriver(TripPendingRatingDriver paramTripPendingRatingDriver)
  {
    this.driver = paramTripPendingRatingDriver;
  }

  public void setDropOffEpoch(Long paramLong)
  {
    this.dropoffEpoch = paramLong;
  }

  public void setFareBilledToCardString(String paramString)
  {
    this.fareBilledToCardString = paramString;
  }

  public void setFareString(String paramString)
  {
    this.fareString = paramString;
  }

  public void setFeedbackTypes(List<FeedbackType> paramList)
  {
    this.feedbackTypes = paramList;
  }

  public void setId(String paramString)
  {
    this.id = paramString;
  }

  public void setVehicleView(VehicleView paramVehicleView)
  {
    this.vehicleView = paramVehicleView;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.model.TripPendingRating
 * JD-Core Version:    0.6.2
 */