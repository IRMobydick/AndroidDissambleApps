package com.ubercab.client.feature.share;

import android.app.ActionBar;
import android.os.Bundle;
import com.ubercab.client.core.app.RiderPingActivity;

public class ShareActivity extends RiderPingActivity
{
  private void putShareFragment()
  {
    if (findFragment(ShareFragment.class) == null)
      putFragment(2131427699, new ShareFragment(), true);
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903166);
    getActionBar().setTitle(getString(2131559053));
    putShareFragment();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.share.ShareActivity
 * JD-Core Version:    0.6.2
 */