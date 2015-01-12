package com.mobileapptracker;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

final class bd
  implements Runnable
{
  bd(MobileAppTracker paramMobileAppTracker, Activity paramActivity)
  {
  }

  public final void run()
  {
    this.b.params.setReferralSource(this.a.getCallingPackage());
    Intent localIntent = this.a.getIntent();
    if (localIntent != null)
    {
      Uri localUri = localIntent.getData();
      if (localUri != null)
        this.b.params.setReferralUrl(localUri.toString());
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.mobileapptracker.bd
 * JD-Core Version:    0.6.2
 */