package com.ubercab.client.core.network.events;

import com.ubercab.client.feature.signup.SignupData;

public final class VerifyProfileEvent
{
  private final SignupData mSignupData;

  public VerifyProfileEvent(SignupData paramSignupData)
  {
    this.mSignupData = paramSignupData;
  }

  public SignupData getSignupData()
  {
    return this.mSignupData;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.network.events.VerifyProfileEvent
 * JD-Core Version:    0.6.2
 */