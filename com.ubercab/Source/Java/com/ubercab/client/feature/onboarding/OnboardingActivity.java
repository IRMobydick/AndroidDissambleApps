package com.ubercab.client.feature.onboarding;

import android.content.Context;
import android.os.Bundle;
import com.ubercab.client.core.app.RiderPublicActivity;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class OnboardingActivity extends RiderPublicActivity
{
  private void putOnboardingFragment()
  {
    if (findFragment(OnBoardingFragment.class) != null)
      return;
    putFragment(2131427539, OnBoardingFragment.newInstance(), true);
  }

  protected void attachBaseContext(Context paramContext)
  {
    super.attachBaseContext(new CalligraphyContextWrapper(paramContext));
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903116);
    putOnboardingFragment();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.onboarding.OnboardingActivity
 * JD-Core Version:    0.6.2
 */