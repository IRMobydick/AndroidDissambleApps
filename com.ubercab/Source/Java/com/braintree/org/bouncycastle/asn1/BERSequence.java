package com.braintree.org.bouncycastle.asn1;

import java.io.IOException;
import java.util.Enumeration;

public class BERSequence extends DERSequence
{
  public BERSequence()
  {
  }

  public BERSequence(ASN1EncodableVector paramASN1EncodableVector)
  {
    super(paramASN1EncodableVector);
  }

  public BERSequence(DEREncodable paramDEREncodable)
  {
    super(paramDEREncodable);
  }

  void encode(DEROutputStream paramDEROutputStream)
    throws IOException
  {
    if (((paramDEROutputStream instanceof ASN1OutputStream)) || ((paramDEROutputStream instanceof BEROutputStream)))
    {
      paramDEROutputStream.write(48);
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
 * Qualified Name:     com.braintree.org.bouncycastle.asn1.BERSequence
 * JD-Core Version:    0.6.2
 */