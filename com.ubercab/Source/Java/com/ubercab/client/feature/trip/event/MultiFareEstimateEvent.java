package com.ubercab.client.feature.trip.event;

import java.util.Map;

public final class MultiFareEstimateEvent
{
  public static final int STATE_FAILURE = 2;
  public static final int STATE_PENDING = 0;
  public static final int STATE_SUCCESS = 1;
  private final Map<String, String> mFareEstimates;
  private final int mState;

  public MultiFareEstimateEvent(Map<String, String> paramMap, int paramInt)
  {
    this.mFareEstimates = paramMap;
    this.mState = paramInt;
  }

  public Map<String, String> getFareEstimates()
  {
    return this.mFareEstimates;
  }

  public int getState()
  {
    return this.mState;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.trip.event.MultiFareEstimateEvent
 * JD-Core Version:    0.6.2
 */