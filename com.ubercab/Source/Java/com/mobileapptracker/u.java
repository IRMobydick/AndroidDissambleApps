package com.mobileapptracker;

import java.util.Date;

final class u
  implements Runnable
{
  u(MobileAppTracker paramMobileAppTracker, Date paramDate)
  {
  }

  public final void run()
  {
    this.b.params.setEventDate2(Long.toString(this.a.getTime() / 1000L));
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.mobileapptracker.u
 * JD-Core Version:    0.6.2
 */