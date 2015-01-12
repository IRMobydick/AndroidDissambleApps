package com.ubercab.client.feature.payment;

import android.app.ActionBar;
import android.os.Bundle;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.ubercab.client.core.app.RiderPublicActivity;
import com.ubercab.ui.UberTextView;

public class VerifyAlipayActivity extends RiderPublicActivity
{

  @InjectView(2131427922)
  UberTextView mTextCompleteFollowingSteps;

  @InjectView(2131427921)
  UberTextView mTextHeader;

  @InjectView(2131427926)
  UberTextView mTextRetry;

  @InjectView(2131427923)
  UberTextView mTextStepOne;

  @InjectView(2131427925)
  UberTextView mTextStepThree;

  @InjectView(2131427924)
  UberTextView mTextStepTwo;

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903227);
    ButterKnife.inject(this);
    String str = getString(2131559326);
    getActionBar().setTitle(str);
    this.mTextCompleteFollowingSteps.setText(getString(2131559327));
    this.mTextHeader.setText(getString(2131559350));
    this.mTextRetry.setText(getString(2131559328));
    this.mTextStepOne.setText(getString(2131559329));
    this.mTextStepTwo.setText(getString(2131559330));
    this.mTextStepThree.setText(getString(2131559331));
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.payment.VerifyAlipayActivity
 * JD-Core Version:    0.6.2
 */