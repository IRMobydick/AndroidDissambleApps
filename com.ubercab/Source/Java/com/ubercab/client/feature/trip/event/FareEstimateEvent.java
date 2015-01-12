package com.ubercab.client.feature.trip.event;

import com.ubercab.client.core.model.FareEstimateRange;

public final class FareEstimateEvent
{
  private final FareEstimateRange mFareEstimateRange;
  private final String mFareEstimateString;
  private final String mFareEstimateTagline;

  public FareEstimateEvent(String paramString1, FareEstimateRange paramFareEstimateRange, String paramString2)
  {
    this.mFareEstimateString = paramString1;
    this.mFareEstimateRange = paramFareEstimateRange;
    this.mFareEstimateTagline = paramString2;
  }

  public FareEstimateEvent(String paramString1, String paramString2)
  {
    this(paramString1, null, paramString2);
  }

  public FareEstimateRange getFareEstimateRange()
  {
    return this.mFareEstimateRange;
  }

  public String getFareEstimateString()
  {
    return this.mFareEstimateString;
  }

  public String getFareEstimateTagline()
  {
    return this.mFareEstimateTagline;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.trip.event.FareEstimateEvent
 * JD-Core Version:    0.6.2
 */