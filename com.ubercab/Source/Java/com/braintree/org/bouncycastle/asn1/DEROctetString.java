package com.braintree.org.bouncycastle.asn1;

import java.io.IOException;

public class DEROctetString extends ASN1OctetString
{
  public DEROctetString(DEREncodable paramDEREncodable)
  {
    super(paramDEREncodable);
  }

  public DEROctetString(byte[] paramArrayOfByte)
  {
    super(paramArrayOfByte);
  }

  static void encode(DEROutputStream paramDEROutputStream, byte[] paramArrayOfByte)
    throws IOException
  {
    paramDEROutputStream.writeEncoded(4, paramArrayOfByte);
  }

  void encode(DEROutputStream paramDEROutputStream)
    throws IOException
  {
    paramDEROutputStream.writeEncoded(4, this.string);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.braintree.org.bouncycastle.asn1.DEROctetString
 * JD-Core Version:    0.6.2
 */