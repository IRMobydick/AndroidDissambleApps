package com.ubercab.client.feature.payment;

import com.braintreegateway.encryption.Braintree;
import com.braintreegateway.encryption.BraintreeEncryptionException;
import timber.log.Timber;
import timber.log.Timber.Tree;

public class UberBraintree
{
  private static final String TAG = "Braintree";
  private final Braintree mBraintree;

  UberBraintree(Braintree paramBraintree)
  {
    this.mBraintree = paramBraintree;
  }

  public String encrypt(String paramString)
  {
    try
    {
      String str = this.mBraintree.encrypt(paramString);
      return str;
    }
    catch (BraintreeEncryptionException localBraintreeEncryptionException)
    {
      Timber.tag("Braintree").e(localBraintreeEncryptionException, "encrypt failed", new Object[0]);
    }
    return null;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.payment.UberBraintree
 * JD-Core Version:    0.6.2
 */