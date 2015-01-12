package com.braintreegateway.encryption;

import java.security.SecureRandom;

public final class Random
{
  public static byte[] secureRandomBytes(int paramInt)
  {
    PRNGFixes.apply();
    SecureRandom localSecureRandom = new SecureRandom();
    byte[] arrayOfByte = new byte[paramInt];
    localSecureRandom.nextBytes(arrayOfByte);
    return arrayOfByte;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.braintreegateway.encryption.Random
 * JD-Core Version:    0.6.2
 */