package com.braintree.org.bouncycastle.asn1;

public class ASN1ParsingException extends IllegalStateException
{
  private Throwable cause;

  ASN1ParsingException(String paramString)
  {
    super(paramString);
  }

  ASN1ParsingException(String paramString, Throwable paramThrowable)
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
 * Qualified Name:     com.braintree.org.bouncycastle.asn1.ASN1ParsingException
 * JD-Core Version:    0.6.2
 */