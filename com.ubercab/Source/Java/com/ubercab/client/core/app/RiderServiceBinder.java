package com.ubercab.client.core.app;

import com.ubercab.library.app.UberServiceBinder;

public class RiderServiceBinder extends UberServiceBinder
{
  private RiderService mService;

  public RiderServiceBinder(RiderService paramRiderService)
  {
    super(paramRiderService);
    this.mService = paramRiderService;
  }

  public RiderService getService()
  {
    return this.mService;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.app.RiderServiceBinder
 * JD-Core Version:    0.6.2
 */