package com.mobileapptracker;

final class j
  implements Runnable
{
  j(MobileAppTracker paramMobileAppTracker, boolean paramBoolean)
  {
  }

  public final void run()
  {
    if (this.a)
    {
      this.b.params.setAppAdTrackingEnabled(Integer.toString(1));
      return;
    }
    this.b.params.setAppAdTrackingEnabled(Integer.toString(0));
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.mobileapptracker.j
 * JD-Core Version:    0.6.2
 */