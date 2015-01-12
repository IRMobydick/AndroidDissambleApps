package com.braintree.org.bouncycastle.asn1;

import java.io.IOException;

public class ASN1Exception extends IOException
{
  private Throwable cause;

  ASN1Exception(String paramString)
  {
    super(paramString);
  }

  ASN1Exception(String paramString, Throwable paramThrowable)
  {
    super(paramString);
    this.cause = paramThrowable;
  }

  public Throwable getCause()
  {
    return this.cause;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.braintree.org.bouncycastle.asn1.ASN1Exception
 * JD-Core Version:    0.6.2
 */