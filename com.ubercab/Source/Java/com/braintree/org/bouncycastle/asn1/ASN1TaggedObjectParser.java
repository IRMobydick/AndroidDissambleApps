package com.braintree.org.bouncycastle.asn1;

import java.io.IOException;

public abstract interface ASN1TaggedObjectParser extends DEREncodable, InMemoryRepresentable
{
  public abstract DEREncodable getObjectParser(int paramInt, boolean paramBoolean)
    throws IOException;

  public abstract int getTagNo();
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.braintree.org.bouncycastle.asn1.ASN1TaggedObjectParser
 * JD-Core Version:    0.6.2
 */