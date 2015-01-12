package com.ubercab.client.feature.signup.event;

import com.ubercab.client.feature.signup.SignupData;

public final class SignupValidatedEvent
{
  private final SignupData mData;

  public SignupValidatedEvent(SignupData paramSignupData)
  {
    this.mData = paramSignupData;
  }

  public SignupData getData()
  {
    return this.mData;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.signup.event.SignupValidatedEvent
 * JD-Core Version:    0.6.2
 */