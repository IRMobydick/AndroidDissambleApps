package com.ubercab.client.feature.payment;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import com.ubercab.client.core.app.RiderPublicActivity;

public class PaymentOtpActivity extends RiderPublicActivity
{
  private static final String EXTRA_PAYMENT_UUID = "uuid";

  public static Intent newIntent(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent(paramContext, PaymentOtpActivity.class);
    localIntent.putExtra("uuid", paramString);
    return localIntent;
  }

  private void putPaymentOtpFragment(String paramString)
  {
    if (findFragment(PaymentOtpFragment.class) == null)
      putFragment(2131427551, PaymentOtpFragment.newInstance(paramString), true);
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903126);
    String str = getIntent().getStringExtra("uuid");
    getActionBar().setDisplayHomeAsUpEnabled(true);
    putPaymentOtpFragment(str);
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 16908332)
    {
      setResult(0);
      finish();
      return true;
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.payment.PaymentOtpActivity
 * JD-Core Version:    0.6.2
 */