package com.mobileapptracker;

final class ah
  implements Runnable
{
  ah(MobileAppTracker paramMobileAppTracker, boolean paramBoolean)
  {
  }

  public final void run()
  {
    if (this.a)
    {
      this.b.params.setIsPayingUser(Integer.toString(1));
      return;
    }
    this.b.params.setIsPayingUser(Integer.toString(0));
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.mobileapptracker.ah
 * JD-Core Version:    0.6.2
 */