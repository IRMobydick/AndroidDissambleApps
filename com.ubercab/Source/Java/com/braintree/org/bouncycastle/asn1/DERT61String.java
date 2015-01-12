package com.braintree.org.bouncycastle.asn1;

import java.io.IOException;

public class DERT61String extends ASN1Object
  implements DERString
{
  String string;

  public DERT61String(String paramString)
  {
    this.string = paramString;
  }

  public DERT61String(byte[] paramArrayOfByte)
  {
    char[] arrayOfChar = new char[paramArrayOfByte.length];
    for (int i = 0; i != arrayOfChar.length; i++)
      arrayOfChar[i] = ((char)(0xFF & paramArrayOfByte[i]));
    this.string = new String(arrayOfChar);
  }

  public static DERT61String getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    DERObject localDERObject = paramASN1TaggedObject.getObject();
    if (paramBoolean)
      return getInstance(localDERObject);
    return new DERT61String(ASN1OctetString.getInstance(localDERObject).getOctets());
  }

  public static DERT61String getInstance(Object paramObject)
  {
    if ((paramObject == null) || ((paramObject instanceof DERT61String)))
      return (DERT61String)paramObject;
    throw new IllegalArgumentException("illegal object in getInstance: " + paramObject.getClass().getName());
  }

  boolean asn1Equals(DERObject paramDERObject)
  {
    if (!(paramDERObject instanceof DERT61String))
      return false;
    return getString().equals(((DERT61String)paramDERObject).getString());
  }

  void encode(DEROutputStream paramDEROutputStream)
    throws IOException
  {
    paramDEROutputStream.writeEncoded(20, getOctets());
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
 * Qualified Name:     com.braintree.org.bouncycastle.asn1.DERT61String
 * JD-Core Version:    0.6.2
 */