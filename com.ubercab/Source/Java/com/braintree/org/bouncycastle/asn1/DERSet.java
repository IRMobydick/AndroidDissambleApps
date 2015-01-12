package com.braintree.org.bouncycastle.asn1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Enumeration;

public class DERSet extends ASN1Set
{
  public DERSet()
  {
  }

  public DERSet(ASN1EncodableVector paramASN1EncodableVector)
  {
    this(paramASN1EncodableVector, true);
  }

  DERSet(ASN1EncodableVector paramASN1EncodableVector, boolean paramBoolean)
  {
    for (int i = 0; i != paramASN1EncodableVector.size(); i++)
      addObject(paramASN1EncodableVector.get(i));
    if (paramBoolean)
      sort();
  }

  public DERSet(DEREncodable paramDEREncodable)
  {
    addObject(paramDEREncodable);
  }

  public DERSet(ASN1Encodable[] paramArrayOfASN1Encodable)
  {
    for (int i = 0; i != paramArrayOfASN1Encodable.length; i++)
      addObject(paramArrayOfASN1Encodable[i]);
    sort();
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
    paramDEROutputStream.writeEncoded(49, localByteArrayOutputStream.toByteArray());
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.braintree.org.bouncycastle.asn1.DERSet
 * JD-Core Version:    0.6.2
 */