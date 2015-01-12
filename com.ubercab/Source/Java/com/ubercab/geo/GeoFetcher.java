package com.ubercab.geo;

public abstract class GeoFetcher
{
  protected Listener mListener;

  public abstract void connect();

  public abstract void disconnect();

  public void removeListener()
  {
    this.mListener = null;
  }

  public void setListener(Listener paramListener)
  {
    this.mListener = paramListener;
  }

  public static abstract interface Listener
  {
    public abstract void onGeoLocationReceived(double paramDouble1, double paramDouble2);

    public abstract void onGeoNoLocationReceived();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.geo.GeoFetcher
 * JD-Core Version:    0.6.2
 */