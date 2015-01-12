package com.ubercab.client.feature.payment.expense;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.squareup.otto.Subscribe;
import com.ubercab.client.core.app.RiderPingActivity;
import com.ubercab.client.core.metrics.analytics.RiderEvents.Tap;
import com.ubercab.client.core.model.PaymentProfile;
import com.ubercab.client.core.model.TripExpenseInfo;
import com.ubercab.client.feature.payment.event.CancelExpenseInfoEvent;
import com.ubercab.client.feature.payment.event.SaveExpenseInfoEvent;
import com.ubercab.library.metrics.analytics.AnalyticsClient;
import javax.inject.Inject;

public class ExpenseInfoActivity extends RiderPingActivity
{
  public static final String EXTRA_ACTIVITY_STARTED = "EXTRA_ACTIVITY_STARTED";
  public static final String EXTRA_PAYMENT_PROFILE_ID = "EXTRA_PAYMENT_PROFILE_ID";
  public static final String EXTRA_SHOW_SKIP_BUTTON = "EXTRA_SHOW_SKIP_BUTTON";

  @Inject
  AnalyticsClient mAnalyticsClient;

  public static Intent newIntent(Context paramContext, TripExpenseInfo paramTripExpenseInfo, boolean paramBoolean, PaymentProfile paramPaymentProfile)
  {
    Intent localIntent = new Intent(paramContext, ExpenseInfoActivity.class);
    localIntent.putExtra("com.ubercab.EXPENSE_INFO", paramTripExpenseInfo);
    localIntent.putExtra("EXTRA_SHOW_SKIP_BUTTON", paramBoolean);
    localIntent.putExtra("EXTRA_ACTIVITY_STARTED", true);
    if (paramPaymentProfile != null)
    {
      localIntent.putExtra("com.ubercab.PAYMENT_PROFILE", paramPaymentProfile);
      localIntent.putExtra("EXTRA_PAYMENT_PROFILE_ID", paramPaymentProfile.getId());
    }
    return localIntent;
  }

  private void putExpenseInfoFragment()
  {
    if (findFragment(ExpenseInfoFragment.class) == null)
      putFragment(2131427451, new ExpenseInfoFragment(), true);
  }

  public void onBackPressed()
  {
    this.mAnalyticsClient.sendTapEvent(RiderEvents.Tap.EXPENSE_INFO_CANCEL);
    super.onBackPressed();
  }

  @Subscribe
  public void onCancelExpenseInfoEvent(CancelExpenseInfoEvent paramCancelExpenseInfoEvent)
  {
    setResult(0, getIntent());
    this.mAnalyticsClient.sendTapEvent(RiderEvents.Tap.EXPENSE_INFO_CANCEL);
    finish();
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903081);
    putExpenseInfoFragment();
  }

  @Subscribe
  public void onSaveExpenseInfoEvent(SaveExpenseInfoEvent paramSaveExpenseInfoEvent)
  {
    Intent localIntent = getIntent();
    TripExpenseInfo localTripExpenseInfo = (TripExpenseInfo)localIntent.getParcelableExtra("com.ubercab.EXPENSE_INFO");
    localTripExpenseInfo.setCode(paramSaveExpenseInfoEvent.getCode());
    localTripExpenseInfo.setMemo(paramSaveExpenseInfoEvent.getMemo());
    setResult(-1, localIntent);
    this.mAnalyticsClient.sendTapEvent(RiderEvents.Tap.EXPENSE_INFO_SAVE);
    finish();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.payment.expense.ExpenseInfoActivity
 * JD-Core Version:    0.6.2
 */