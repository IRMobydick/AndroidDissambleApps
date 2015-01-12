package com.braintreegateway.encryption;

public class Braintree
{
  private final String publicKey;

  public Braintree(String paramString)
  {
    this.publicKey = paramString;
  }

  private String getPrefix()
  {
    return "$bt3|android_" + "2.0.0".replace(".", "_") + "$";
  }

  public String encrypt(String paramString)
    throws BraintreeEncryptionException
  {
    byte[] arrayOfByte = Random.secureRandomBytes(32);
    String str1 = Aes.encrypt(paramString, arrayOfByte, Random.secureRandomBytes(16));
    String str2 = Rsa.encrypt(arrayOfByte, this.publicKey);
    return getPrefix() + str2 + "$" + str1;
  }

  public String getPublicKey()
  {
    return this.publicKey;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.braintreegateway.encryption.Braintree
 * JD-Core Version:    0.6.2
 */