package com.braintree.org.bouncycastle.asn1;

import java.io.IOException;

public class DERVisibleString extends ASN1Object
  implements DERString
{
  String string;

  public DERVisibleString(String paramString)
  {
    this.string = paramString;
  }

  public DERVisibleString(byte[] paramArrayOfByte)
  {
    char[] arrayOfChar = new char[paramArrayOfByte.length];
    for (int i = 0; i != arrayOfChar.length; i++)
      arrayOfChar[i] = ((char)(0xFF & paramArrayOfByte[i]));
    this.string = new String(arrayOfChar);
  }

  public static DERVisibleString getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    return getInstance(paramASN1TaggedObject.getObject());
  }

  public static DERVisibleString getInstance(Object paramObject)
  {
    if ((paramObject == null) || ((paramObject instanceof DERVisibleString)))
      return (DERVisibleString)paramObject;
    if ((paramObject instanceof ASN1OctetString))
      return new DERVisibleString(((ASN1OctetString)paramObject).getOctets());
    if ((paramObject instanceof ASN1TaggedObject))
      return getInstance(((ASN1TaggedObject)paramObject).getObject());
    throw new IllegalArgumentException("illegal object in getInstance: " + paramObject.getClass().getName());
  }

  boolean asn1Equals(DERObject paramDERObject)
  {
    if (!(paramDERObject instanceof DERVisibleString))
      return false;
    return getString().equals(((DERVisibleString)paramDERObject).getString());
  }

  void encode(DEROutputStream paramDEROutputStream)
    throws IOException
  {
    paramDEROutputStream.writeEncoded(26, getOctets());
  }

  public byte[] getOctets()
  {
    char[] arrayOfChar = this.string.toCharArray();
    byte[] arrayOfByte = new byte[arrayOfChar.length];
    for (int i = 0; i != arrayOfChar.length; i++)
      arrayOfByte[i] = ((byte)arrayOfChar[i]);
    return arrayOfByte;
  }

  public String getString()
  {
    return this.string;
  }

  public int hashCode()
  {
    return getString().hashCode();
  }

  public String toString()
  {
    return this.string;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.braintree.org.bouncycastle.asn1.DERVisibleString
 * JD-Core Version:    0.6.2
 */