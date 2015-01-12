package com.braintree.org.bouncycastle.asn1;

import java.io.IOException;
import java.util.Enumeration;

public class BERSet extends DERSet
{
  public BERSet()
  {
  }

  public BERSet(ASN1EncodableVector paramASN1EncodableVector)
  {
    super(paramASN1EncodableVector, false);
  }

  BERSet(ASN1EncodableVector paramASN1EncodableVector, boolean paramBoolean)
  {
    super(paramASN1EncodableVector, paramBoolean);
  }

  public BERSet(DEREncodable paramDEREncodable)
  {
    super(paramDEREncodable);
  }

  void encode(DEROutputStream paramDEROutputStream)
    throws IOException
  {
    if (((paramDEROutputStream instanceof ASN1OutputStream)) || ((paramDEROutputStream instanceof BEROutputStream)))
    {
      paramDEROutputStream.write(49);
      paramDEROutputStream.write(128);
      Enumeration localEnumeration = getObjects();
      while (localEnumeration.hasMoreElements())
        paramDEROutputStream.writeObject(localEnumeration.nextElement());
      paramDEROutputStream.write(0);
      paramDEROutputStream.write(0);
      return;
    }
    super.encode(paramDEROutputStream);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.braintree.org.bouncycastle.asn1.BERSet
 * JD-Core Version:    0.6.2
 */