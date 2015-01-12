package com.mobileapptracker;

import java.util.Date;

final class t
  implements Runnable
{
  t(MobileAppTracker paramMobileAppTracker, Date paramDate)
  {
  }

  public final void run()
  {
    this.b.params.setEventDate1(Long.toString(this.a.getTime() / 1000L));
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.mobileapptracker.t
 * JD-Core Version:    0.6.2
 */