package com.ubercab.client.feature.signup;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.squareup.otto.Subscribe;
import com.ubercab.client.core.app.RiderPublicActivity;
import com.ubercab.client.feature.promo.PromoFragment;
import com.ubercab.client.feature.signup.event.SignupSelectPromoCodeEvent;

public class SignupPaymentLastStepActivity extends RiderPublicActivity
{
  private static final String EXTRA_PAYMENT_UUID = "uuid";

  public static Intent newIntent(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent(paramContext, SignupPaymentLastStepActivity.class);
    localIntent.putExtra("uuid", paramString);
    return localIntent;
  }

  private void putSignupPaymentLastStepFragment(String paramString)
  {
    if (findFragment(SignupPaymentLastStepFragment.class) == null)
      putFragment(2131427721, SignupPaymentLastStepFragment.newInstance(paramString), true);
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903177);
    putSignupPaymentLastStepFragment(getIntent().getStringExtra("uuid"));
  }

  @Subscribe
  public void onSignupSelectPromoCodeEvent(SignupSelectPromoCodeEvent paramSignupSelectPromoCodeEvent)
  {
    if (findFragment(PromoFragment.class) == null)
      PromoFragment.newInstance().show(getFragmentManager(), PromoFragment.class.getName());
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.signup.SignupPaymentLastStepActivity
 * JD-Core Version:    0.6.2
 */