package com.ubercab.client.feature.payment;

import android.app.ActionBar;
import android.os.Bundle;
import android.view.MenuItem;
import com.squareup.otto.Subscribe;
import com.ubercab.client.core.content.PingProvider;
import com.ubercab.client.core.model.AppConfig;
import com.ubercab.client.core.model.Ping;
import com.ubercab.client.core.model.RiderAppConfig;
import com.ubercab.client.core.util.PingUtils;
import com.ubercab.client.feature.payment.event.ChooseInternationalCreditCardEvent;
import com.ubercab.client.feature.payment.event.PaymentProfileAddedEvent;
import com.ubercab.geo.GeoManager;
import javax.inject.Inject;

public class AddPaymentActivity extends PaymentBaseActivity
{

  @Inject
  GeoManager mGeoManager;

  @Inject
  PingProvider mPingProvider;

  private void putAddPaymentFragment()
  {
    if (findFragment(AddPaymentFragment.class) != null)
      return;
    putFragment(2131427551, AddPaymentFragment.newInstance(), true);
  }

  private void putChoosePaymentFragment()
  {
    if (findFragment(ChoosePaymentFragment.class) != null)
      return;
    putFragment(2131427551, ChoosePaymentFragment.newInstance(), true);
  }

  public void onBackPressed()
  {
    AddPaymentFragment localAddPaymentFragment = (AddPaymentFragment)findFragment(AddPaymentFragment.class);
    if ((localAddPaymentFragment != null) && (localAddPaymentFragment.onBackPressed()))
      return;
    super.onBackPressed();
  }

  @Subscribe
  public void onChooseInternationalCreditCardEvent(ChooseInternationalCreditCardEvent paramChooseInternationalCreditCardEvent)
  {
    putAddPaymentFragment();
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903122);
    getActionBar().setDisplayHomeAsUpEnabled(true);
    Ping localPing = this.mPingProvider.get();
    boolean bool1 = PingUtils.hasRiderAppConfig(localPing);
    boolean bool2 = false;
    if (bool1)
      bool2 = localPing.getAppConfig().getRiderConfig().isPayTmEnabled();
    if ((ChoosePaymentFragment.isEligible(this.mGeoManager)) && (bool2))
    {
      putChoosePaymentFragment();
      return;
    }
    putAddPaymentFragment();
  }

  public void onDialogResult(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    ChoosePaymentFragment localChoosePaymentFragment = (ChoosePaymentFragment)findFragment(ChoosePaymentFragment.class);
    if (localChoosePaymentFragment != null)
      localChoosePaymentFragment.onDialogResult(paramInt1, paramInt2);
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 16908332)
    {
      AddPaymentFragment localAddPaymentFragment = (AddPaymentFragment)findFragment(AddPaymentFragment.class);
      if (localAddPaymentFragment != null)
        localAddPaymentFragment.onHomePressed();
      setResult(0);
      finish();
      return true;
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }

  @Subscribe
  public void onPaymentProfileAddedEvent(PaymentProfileAddedEvent paramPaymentProfileAddedEvent)
  {
    finish();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.payment.AddPaymentActivity
 * JD-Core Version:    0.6.2
 */