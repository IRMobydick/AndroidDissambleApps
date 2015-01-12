package com.braintree.org.bouncycastle.asn1;

import java.io.IOException;

public abstract interface ASN1SetParser extends DEREncodable, InMemoryRepresentable
{
  public abstract DEREncodable readObject()
    throws IOException;
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.braintree.org.bouncycastle.asn1.ASN1SetParser
 * JD-Core Version:    0.6.2
 */