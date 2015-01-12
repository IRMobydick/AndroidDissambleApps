package com.braintree.org.bouncycastle.asn1;

import java.math.BigInteger;

public class ASN1Integer extends DERInteger
{
  public ASN1Integer(int paramInt)
  {
    super(paramInt);
  }

  public ASN1Integer(BigInteger paramBigInteger)
  {
    super(paramBigInteger);
  }

  ASN1Integer(byte[] paramArrayOfByte)
  {
    super(paramArrayOfByte);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.braintree.org.bouncycastle.asn1.ASN1Integer
 * JD-Core Version:    0.6.2
 */