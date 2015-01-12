package com.braintree.org.bouncycastle.asn1;

import java.io.IOException;

public class DERNumericString extends ASN1Object
  implements DERString
{
  String string;

  public DERNumericString(String paramString)
  {
    this(paramString, false);
  }

  public DERNumericString(String paramString, boolean paramBoolean)
  {
    if ((paramBoolean) && (!isNumericString(paramString)))
      throw new IllegalArgumentException("string contains illegal characters");
    this.string = paramString;
  }

  public DERNumericString(byte[] paramArrayOfByte)
  {
    char[] arrayOfChar = new char[paramArrayOfByte.length];
    for (int i = 0; i != arrayOfChar.length; i++)
      arrayOfChar[i] = ((char)(0xFF & paramArrayOfByte[i]));
    this.string = new String(arrayOfChar);
  }

  public static DERNumericString getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    DERObject localDERObject = paramASN1TaggedObject.getObject();
    if ((paramBoolean) || ((localDERObject instanceof DERNumericString)))
      return getInstance(localDERObject);
    return new DERNumericString(ASN1OctetString.getInstance(localDERObject).getOctets());
  }

  public static DERNumericString getInstance(Object paramObject)
  {
    if ((paramObject == null) || ((paramObject instanceof DERNumericString)))
      return (DERNumericString)paramObject;
    throw new IllegalArgumentException("illegal object in getInstance: " + paramObject.getClass().getName());
  }

  public static boolean isNumericString(String paramString)
  {
    for (int i = -1 + paramString.length(); i >= 0; i--)
    {
      int j = paramString.charAt(i);
      if (j > 127);
      while (((48 > j) || (j > 57)) && (j != 32))
        return false;
    }
    return true;
  }

  boolean asn1Equals(DERObject paramDERObject)
  {
    if (!(paramDERObject instanceof DERNumericString))
      return false;
    DERNumericString localDERNumericString = (DERNumericString)paramDERObject;
    return getString().equals(localDERNumericString.getString());
  }

  void encode(DEROutputStream paramDEROutputStream)
    throws IOException
  {
    paramDEROutputStream.writeEncoded(18, getOctets());
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
 * Qualified Name:     com.braintree.org.bouncycastle.asn1.DERNumericString
 * JD-Core Version:    0.6.2
 */