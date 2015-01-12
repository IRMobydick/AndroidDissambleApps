package com.ubercab.client.feature.trip.event;

public final class ShowFareDetailEvent
{
  private int mFooterHeight;
  private String mVehicleViewId;

  public ShowFareDetailEvent(String paramString, int paramInt)
  {
    this.mVehicleViewId = paramString;
    this.mFooterHeight = paramInt;
  }

  public int getFooterHeight()
  {
    return this.mFooterHeight;
  }

  public String getVehicleViewId()
  {
    return this.mVehicleViewId;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.trip.event.ShowFareDetailEvent
 * JD-Core Version:    0.6.2
 */