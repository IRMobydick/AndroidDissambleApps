package com.braintree.org.bouncycastle.asn1;

import java.io.IOException;

public class DERBMPString extends ASN1Object
  implements DERString
{
  String string;

  public DERBMPString(String paramString)
  {
    this.string = paramString;
  }

  public DERBMPString(byte[] paramArrayOfByte)
  {
    char[] arrayOfChar = new char[paramArrayOfByte.length / 2];
    for (int i = 0; i != arrayOfChar.length; i++)
      arrayOfChar[i] = ((char)(paramArrayOfByte[(i * 2)] << 8 | 0xFF & paramArrayOfByte[(1 + i * 2)]));
    this.string = new String(arrayOfChar);
  }

  public static DERBMPString getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    DERObject localDERObject = paramASN1TaggedObject.getObject();
    if ((paramBoolean) || ((localDERObject instanceof DERBMPString)))
      return getInstance(localDERObject);
    return new DERBMPString(ASN1OctetString.getInstance(localDERObject).getOctets());
  }

  public static DERBMPString getInstance(Object paramObject)
  {
    if ((paramObject == null) || ((paramObject instanceof DERBMPString)))
      return (DERBMPString)paramObject;
    throw new IllegalArgumentException("illegal object in getInstance: " + paramObject.getClass().getName());
  }

  protected boolean asn1Equals(DERObject paramDERObject)
  {
    if (!(paramDERObject instanceof DERBMPString))
      return false;
    DERBMPString localDERBMPString = (DERBMPString)paramDERObject;
    return getString().equals(localDERBMPString.getString());
  }

  void encode(DEROutputStream paramDEROutputStream)
    throws IOException
  {
    char[] arrayOfChar = this.string.toCharArray();
    byte[] arrayOfByte = new byte[2 * arrayOfChar.length];
    for (int i = 0; i != arrayOfChar.length; i++)
    {
      arrayOfByte[(i * 2)] = ((byte)(arrayOfChar[i] >> '\b'));
      arrayOfByte[(1 + i * 2)] = ((byte)arrayOfChar[i]);
    }
    paramDEROutputStream.writeEncoded(30, arrayOfByte);
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
 * Qualified Name:     com.braintree.org.bouncycastle.asn1.DERBMPString
 * JD-Core Version:    0.6.2
 */