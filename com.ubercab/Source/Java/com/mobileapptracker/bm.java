package com.mobileapptracker;

final class bm
  implements Runnable
{
  bm(MobileAppTracker paramMobileAppTracker, boolean paramBoolean)
  {
  }

  public final void run()
  {
    if (this.a)
    {
      this.b.params.setAllowDuplicates(Integer.toString(1));
      return;
    }
    this.b.params.setAllowDuplicates(Integer.toString(0));
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.mobileapptracker.bm
 * JD-Core Version:    0.6.2
 */