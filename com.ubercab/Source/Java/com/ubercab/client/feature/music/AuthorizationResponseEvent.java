package com.ubercab.client.feature.music;

final class AuthorizationResponseEvent
{
  private final String mAuthorizationCode;

  AuthorizationResponseEvent(String paramString)
  {
    this.mAuthorizationCode = paramString;
  }

  String getAuthorizationCode()
  {
    return this.mAuthorizationCode;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.music.AuthorizationResponseEvent
 * JD-Core Version:    0.6.2
 */