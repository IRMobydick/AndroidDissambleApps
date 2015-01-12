package com.ubercab.library.location.client;

import com.ubercab.library.location.model.UberLocation;

public abstract interface UberLocationListener
{
  public abstract void onLocationChanged(UberLocation paramUberLocation);

  public abstract void onLocationFailed(UberLocationClientError paramUberLocationClientError);
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.location.client.UberLocationListener
 * JD-Core Version:    0.6.2
 */