package com.braintree.org.bouncycastle.asn1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Enumeration;

public class DERSequence extends ASN1Sequence
{
  public DERSequence()
  {
  }

  public DERSequence(ASN1EncodableVector paramASN1EncodableVector)
  {
    for (int i = 0; i != paramASN1EncodableVector.size(); i++)
      addObject(paramASN1EncodableVector.get(i));
  }

  public DERSequence(DEREncodable paramDEREncodable)
  {
    addObject(paramDEREncodable);
  }

  public DERSequence(ASN1Encodable[] paramArrayOfASN1Encodable)
  {
    for (int i = 0; i != paramArrayOfASN1Encodable.length; i++)
      addObject(paramArrayOfASN1Encodable[i]);
  }

  void encode(DEROutputStream paramDEROutputStream)
    throws IOException
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    DEROutputStream localDEROutputStream = new DEROutputStream(localByteArrayOutputStream);
    Enumeration localEnumeration = getObjects();
    while (localEnumeration.hasMoreElements())
      localDEROutputStream.writeObject(localEnumeration.nextElement());
    localDEROutputStream.close();
    paramDEROutputStream.writeEncoded(48, localByteArrayOutputStream.toByteArray());
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.braintree.org.bouncycastle.asn1.DERSequence
 * JD-Core Version:    0.6.2
 */