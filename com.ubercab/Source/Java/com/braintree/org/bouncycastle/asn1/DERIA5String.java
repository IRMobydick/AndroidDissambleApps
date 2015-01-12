package com.braintree.org.bouncycastle.asn1;

import java.io.IOException;

public class DERIA5String extends ASN1Object
  implements DERString
{
  String string;

  public DERIA5String(String paramString)
  {
    this(paramString, false);
  }

  public DERIA5String(String paramString, boolean paramBoolean)
  {
    if (paramString == null)
      throw new NullPointerException("string cannot be null");
    if ((paramBoolean) && (!isIA5String(paramString)))
      throw new IllegalArgumentException("string contains illegal characters");
    this.string = paramString;
  }

  public DERIA5String(byte[] paramArrayOfByte)
  {
    char[] arrayOfChar = new char[paramArrayOfByte.length];
    for (int i = 0; i != arrayOfChar.length; i++)
      arrayOfChar[i] = ((char)(0xFF & paramArrayOfByte[i]));
    this.string = new String(arrayOfChar);
  }

  public static DERIA5String getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    DERObject localDERObject = paramASN1TaggedObject.getObject();
    if ((paramBoolean) || ((localDERObject instanceof DERIA5String)))
      return getInstance(localDERObject);
    return new DERIA5String(((ASN1OctetString)localDERObject).getOctets());
  }

  public static DERIA5String getInstance(Object paramObject)
  {
    if ((paramObject == null) || ((paramObject instanceof DERIA5String)))
      return (DERIA5String)paramObject;
    throw new IllegalArgumentException("illegal object in getInstance: " + paramObject.getClass().getName());
  }

  public static boolean isIA5String(String paramString)
  {
    for (int i = -1 + paramString.length(); i >= 0; i--)
      if (paramString.charAt(i) > '')
        return false;
    return true;
  }

  boolean asn1Equals(DERObject paramDERObject)
  {
    if (!(paramDERObject instanceof DERIA5String))
      return false;
    DERIA5String localDERIA5String = (DERIA5String)paramDERObject;
    return getString().equals(localDERIA5String.getString());
  }

  void encode(DEROutputStream paramDEROutputStream)
    throws IOException
  {
    paramDEROutputStream.writeEncoded(22, getOctets());
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
 * Qualified Name:     com.braintree.org.bouncycastle.asn1.DERIA5String
 * JD-Core Version:    0.6.2
 */