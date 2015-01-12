package com.braintree.org.bouncycastle.asn1;

import java.io.InputStream;

public abstract interface ASN1OctetStringParser extends DEREncodable, InMemoryRepresentable
{
  public abstract InputStream getOctetStream();
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.braintree.org.bouncycastle.asn1.ASN1OctetStringParser
 * JD-Core Version:    0.6.2
 */