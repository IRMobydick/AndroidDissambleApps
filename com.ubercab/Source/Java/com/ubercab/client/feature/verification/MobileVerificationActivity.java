package com.ubercab.client.feature.verification;

import android.app.ActionBar;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import com.squareup.otto.Subscribe;
import com.ubercab.client.core.app.RiderPingActivity;
import com.ubercab.client.core.content.event.PingEvent;
import com.ubercab.client.core.model.Client;
import com.ubercab.client.core.model.Ping;
import com.ubercab.client.core.util.PingUtils;
import com.ubercab.client.feature.verification.event.PhoneNumberChangeEvent;
import com.ubercab.client.feature.verification.event.SelectPhoneNumberChangeEvent;

public class MobileVerificationActivity extends RiderPingActivity
{
  private static final String BUNDLE_ACTION = "com.ubercab.ACTION";
  private String mAction;

  private void putMobileVerificationSmsFragment()
  {
    if (findFragment(MobileVerificationSmsFragment.class) == null)
      putFragment(2131427908, MobileVerificationSmsFragment.newInstance(), true);
  }

  private void putMobileVerificationTokenFragment()
  {
    if (findFragment(MobileVerificationTokenFragment.class) == null)
      putFragment(2131427908, MobileVerificationTokenFragment.newInstance(), true);
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903223);
    getActionBar().setDisplayHomeAsUpEnabled(true);
    this.mAction = getIntent().getAction();
    if ("com.ubercab.ACTION_MOBILE_VERIFICATION_SMS".equals(this.mAction))
      putMobileVerificationSmsFragment();
    if ("com.ubercab.ACTION_MOBILE_VERIFICATION_TOKEN".equals(this.mAction))
      putMobileVerificationTokenFragment();
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if ((paramMenuItem.getItemId() == 16908332) && (getFragmentManager().getBackStackEntryCount() > 0))
    {
      getFragmentManager().popBackStack();
      return true;
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }

  @Subscribe
  public void onPhoneNumberChangeEvent(PhoneNumberChangeEvent paramPhoneNumberChangeEvent)
  {
    popFragment();
  }

  @Subscribe
  public void onPingEvent(PingEvent paramPingEvent)
  {
    Ping localPing = paramPingEvent.getPing();
    if ((PingUtils.hasClient(localPing)) && (localPing.getClient().hasConfirmedMobile()))
      finish();
  }

  protected void onRestoreInstanceState(Bundle paramBundle)
  {
    super.onRestoreInstanceState(paramBundle);
    this.mAction = paramBundle.getString("com.ubercab.ACTION");
  }

  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putString("com.ubercab.ACTION", this.mAction);
  }

  @Subscribe
  public void onSelectPhoneNumberChangeEvent(SelectPhoneNumberChangeEvent paramSelectPhoneNumberChangeEvent)
  {
    if (findFragment(MobileVerificationChangeNumberFragment.class) == null)
      pushFragment(2131427908, MobileVerificationChangeNumberFragment.newInstance(), true);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.verification.MobileVerificationActivity
 * JD-Core Version:    0.6.2
 */