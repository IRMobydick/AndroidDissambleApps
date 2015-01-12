package com.ubercab.client.feature.signup.event;

public final class SignupPendingEvent
{
  private final String mEmail;

  public SignupPendingEvent(String paramString)
  {
    this.mEmail = paramString;
  }

  public String getEmail()
  {
    return this.mEmail;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.signup.event.SignupPendingEvent
 * JD-Core Version:    0.6.2
 */