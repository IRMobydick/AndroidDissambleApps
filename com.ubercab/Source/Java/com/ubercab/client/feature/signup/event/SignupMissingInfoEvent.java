package com.ubercab.client.feature.signup.event;

import com.ubercab.client.feature.signup.SignupData;

public final class SignupMissingInfoEvent
{
  private final SignupData mData;

  public SignupMissingInfoEvent(SignupData paramSignupData)
  {
    this.mData = paramSignupData;
  }

  public SignupData getData()
  {
    return this.mData;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.signup.event.SignupMissingInfoEvent
 * JD-Core Version:    0.6.2
 */