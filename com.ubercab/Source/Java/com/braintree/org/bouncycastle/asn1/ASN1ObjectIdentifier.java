package com.braintree.org.bouncycastle.asn1;

public class ASN1ObjectIdentifier extends DERObjectIdentifier
{
  public ASN1ObjectIdentifier(String paramString)
  {
    super(paramString);
  }

  ASN1ObjectIdentifier(byte[] paramArrayOfByte)
  {
    super(paramArrayOfByte);
  }

  public ASN1ObjectIdentifier branch(String paramString)
  {
    return new ASN1ObjectIdentifier(getId() + "." + paramString);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.braintree.org.bouncycastle.asn1.ASN1ObjectIdentifier
 * JD-Core Version:    0.6.2
 */