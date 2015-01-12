package com.ubercab.client.feature.forceupgrade;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import com.ubercab.client.core.app.RiderPublicActivity;
import javax.inject.Inject;

public class ForceUpgradeActivity extends RiderPublicActivity
{

  @Inject
  ActionBar mActionBar;

  private void putForceUpgradeFragment(String paramString)
  {
    if (findFragment(ForceUpgradeFragment.class) == null)
      putFragment(2131427473, ForceUpgradeFragment.newInstance(paramString), false);
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903088);
    this.mActionBar.setTitle(getString(2131559320));
    Bundle localBundle = getIntent().getExtras();
    if (localBundle != null)
    {
      putForceUpgradeFragment(localBundle.getString("forceUpgradeUrl"));
      return;
    }
    putForceUpgradeFragment(null);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.forceupgrade.ForceUpgradeActivity
 * JD-Core Version:    0.6.2
 */