package com.mobileapptracker;

final class ab
  implements Runnable
{
  ab(MobileAppTracker paramMobileAppTracker, boolean paramBoolean)
  {
  }

  public final void run()
  {
    if (this.a)
    {
      this.b.params.setExistingUser(Integer.toString(1));
      return;
    }
    this.b.params.setExistingUser(Integer.toString(0));
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.mobileapptracker.ab
 * JD-Core Version:    0.6.2
 */