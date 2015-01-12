package com.ubercab.client.feature.signin.event;

import com.ubercab.client.core.model.Ping;

public final class SignInSuccessfulEvent
{
  private Ping mPing;

  public SignInSuccessfulEvent(Ping paramPing)
  {
    this.mPing = paramPing;
  }

  public Ping getPing()
  {
    return this.mPing;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.signin.event.SignInSuccessfulEvent
 * JD-Core Version:    0.6.2
 */