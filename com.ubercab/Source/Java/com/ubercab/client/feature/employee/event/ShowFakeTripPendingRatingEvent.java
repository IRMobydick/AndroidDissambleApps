package com.ubercab.client.feature.employee.event;

import com.ubercab.client.core.model.TripPendingRating;

public final class ShowFakeTripPendingRatingEvent
{
  private final TripPendingRating mTripPendingRating;

  public ShowFakeTripPendingRatingEvent(TripPendingRating paramTripPendingRating)
  {
    this.mTripPendingRating = paramTripPendingRating;
  }

  public TripPendingRating getTripPendingRating()
  {
    return this.mTripPendingRating;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.employee.event.ShowFakeTripPendingRatingEvent
 * JD-Core Version:    0.6.2
 */