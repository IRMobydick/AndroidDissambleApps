package com.braintree.org.bouncycastle.asn1;

import java.io.IOException;

public class DERNull extends ASN1Null
{
  public static final DERNull INSTANCE = new DERNull();
  byte[] zeroBytes = new byte[0];

  void encode(DEROutputStream paramDEROutputStream)
    throws IOException
  {
    paramDEROutputStream.writeEncoded(5, this.zeroBytes);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.braintree.org.bouncycastle.asn1.DERNull
 * JD-Core Version:    0.6.2
 */