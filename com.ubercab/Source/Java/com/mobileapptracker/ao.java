package com.mobileapptracker;

import android.content.Context;

final class ao
  implements Runnable
{
  ao(MobileAppTracker paramMobileAppTracker, String paramString)
  {
  }

  public final void run()
  {
    if ((this.a == null) || (this.a.equals("")))
    {
      this.b.params.setPackageName(this.b.mContext.getPackageName());
      return;
    }
    this.b.params.setPackageName(this.a);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.mobileapptracker.ao
 * JD-Core Version:    0.6.2
 */