package com.mobileapptracker;

final class k
  implements Runnable
{
  k(MobileAppTracker paramMobileAppTracker, String paramString)
  {
  }

  public final void run()
  {
    if ((this.a == null) || (this.a.equals("")))
    {
      this.b.params.setCurrencyCode("USD");
      return;
    }
    this.b.params.setCurrencyCode(this.a);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.mobileapptracker.k
 * JD-Core Version:    0.6.2
 */