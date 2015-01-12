package com.ubercab.client.feature.signup;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.ubercab.client.core.app.RiderPublicActivity;
import com.ubercab.client.core.model.PaymentProfile;
import java.util.List;

public class SignupPaymentOtpActivity extends RiderPublicActivity
{
  private static final String EXTRA_PAYMENT_UUID = "uuid";

  public static boolean isEligible(List<PaymentProfile> paramList)
  {
    return (paramList != null) && (!paramList.isEmpty()) && (((PaymentProfile)paramList.get(0)).isMobileWallet());
  }

  public static Intent newIntent(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent(paramContext, SignupPaymentOtpActivity.class);
    localIntent.putExtra("uuid", paramString);
    return localIntent;
  }

  private void putSignupPaymentOtpFragment(String paramString)
  {
    if (findFragment(SignupPaymentOtpFragment.class) == null)
      putFragment(2131427551, SignupPaymentOtpFragment.newInstance(paramString), true);
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903126);
    putSignupPaymentOtpFragment(getIntent().getStringExtra("uuid"));
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.signup.SignupPaymentOtpActivity
 * JD-Core Version:    0.6.2
 */