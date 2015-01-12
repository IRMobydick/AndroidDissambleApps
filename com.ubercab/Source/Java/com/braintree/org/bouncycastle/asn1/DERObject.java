package com.braintree.org.bouncycastle.asn1;

import java.io.IOException;

public abstract class DERObject extends ASN1Encodable
  implements DERTags
{
  abstract void encode(DEROutputStream paramDEROutputStream)
    throws IOException;

  public abstract boolean equals(Object paramObject);

  public abstract int hashCode();

  public DERObject toASN1Object()
  {
    return this;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.braintree.org.bouncycastle.asn1.DERObject
 * JD-Core Version:    0.6.2
 */