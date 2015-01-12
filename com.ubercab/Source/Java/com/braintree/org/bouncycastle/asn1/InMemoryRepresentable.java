package com.braintree.org.bouncycastle.asn1;

import java.io.IOException;

public abstract interface InMemoryRepresentable
{
  public abstract DERObject getLoadedObject()
    throws IOException;
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.braintree.org.bouncycastle.asn1.InMemoryRepresentable
 * JD-Core Version:    0.6.2
 */