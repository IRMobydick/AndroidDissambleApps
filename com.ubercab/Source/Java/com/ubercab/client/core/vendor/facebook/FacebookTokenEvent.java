package com.ubercab.client.core.vendor.facebook;

final class FacebookTokenEvent
{
  private final String mToken;
  private final long mTokenExpiry;

  FacebookTokenEvent()
  {
    this(null, 0L);
  }

  FacebookTokenEvent(String paramString, long paramLong)
  {
    this.mToken = paramString;
    this.mTokenExpiry = paramLong;
  }

  String getToken()
  {
    return this.mToken;
  }

  long getTokenExpiry()
  {
    return this.mTokenExpiry;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.vendor.facebook.FacebookTokenEvent
 * JD-Core Version:    0.6.2
 */