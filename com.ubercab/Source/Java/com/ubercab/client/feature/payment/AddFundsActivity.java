package com.ubercab.client.feature.payment;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import com.ubercab.client.core.metrics.analytics.RiderEvents.Tap;
import com.ubercab.client.core.model.PaymentProfile;
import com.ubercab.library.metrics.analytics.AnalyticsClient;
import javax.inject.Inject;

public class AddFundsActivity extends PaymentBaseActivity
{
  private static final String EXTRA_PAYMENT_DEFAULT_VALUE = "default_value";
  private static final String EXTRA_UUID = "uuid";

  @Inject
  AnalyticsClient mAnalyticsClient;

  public static boolean isEligible(PaymentProfile paramPaymentProfile)
  {
    return paramPaymentProfile.isMobileWallet();
  }

  public static Intent newIntent(Context paramContext, String paramString)
  {
    return newIntent(paramContext, paramString, 0);
  }

  public static Intent newIntent(Context paramContext, String paramString, int paramInt)
  {
    Intent localIntent = new Intent(paramContext, AddFundsActivity.class);
    localIntent.putExtra("uuid", paramString);
    localIntent.putExtra("default_value", paramInt);
    return localIntent;
  }

  private void putAddFundsFragment(String paramString, int paramInt)
  {
    if (findFragment(AddFundsFragment.class) != null)
      return;
    putFragment(2131427551, AddFundsFragment.newInstance(paramString, paramInt), true);
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903123);
    String str = getIntent().getStringExtra("uuid");
    int i = getIntent().getIntExtra("default_value", 0);
    getActionBar().setDisplayHomeAsUpEnabled(true);
    getActionBar().setTitle(getString(2131558434));
    putAddFundsFragment(str, i);
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 16908332)
    {
      this.mAnalyticsClient.sendTapEvent(RiderEvents.Tap.WALLET_FUND_ADD_MONEY_CANCEL);
      finish();
      return true;
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.payment.AddFundsActivity
 * JD-Core Version:    0.6.2
 */