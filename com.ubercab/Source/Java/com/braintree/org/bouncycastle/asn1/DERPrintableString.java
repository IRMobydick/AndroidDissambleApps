package com.braintree.org.bouncycastle.asn1;

import java.io.IOException;

public class DERPrintableString extends ASN1Object
  implements DERString
{
  String string;

  public DERPrintableString(String paramString)
  {
    this(paramString, false);
  }

  public DERPrintableString(String paramString, boolean paramBoolean)
  {
    if ((paramBoolean) && (!isPrintableString(paramString)))
      throw new IllegalArgumentException("string contains illegal characters");
    this.string = paramString;
  }

  public DERPrintableString(byte[] paramArrayOfByte)
  {
    char[] arrayOfChar = new char[paramArrayOfByte.length];
    for (int i = 0; i != arrayOfChar.length; i++)
      arrayOfChar[i] = ((char)(0xFF & paramArrayOfByte[i]));
    this.string = new String(arrayOfChar);
  }

  public static DERPrintableString getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    DERObject localDERObject = paramASN1TaggedObject.getObject();
    if ((paramBoolean) || ((localDERObject instanceof DERPrintableString)))
      return getInstance(localDERObject);
    return new DERPrintableString(ASN1OctetString.getInstance(localDERObject).getOctets());
  }

  public static DERPrintableString getInstance(Object paramObject)
  {
    if ((paramObject == null) || ((paramObject instanceof DERPrintableString)))
      return (DERPrintableString)paramObject;
    throw new IllegalArgumentException("illegal object in getInstance: " + paramObject.getClass().getName());
  }

  public static boolean isPrintableString(String paramString)
  {
    int i = -1 + paramString.length();
    if (i >= 0)
    {
      int j = paramString.charAt(i);
      if (j > 127)
        return false;
      if ((97 <= j) && (j <= 122));
      while (((65 <= j) && (j <= 90)) || ((48 <= j) && (j <= 57)))
      {
        i--;
        break;
      }
      switch (j)
      {
      case 32:
      case 39:
      case 40:
      case 41:
      case 43:
      case 44:
      case 45:
      case 46:
      case 47:
      case 58:
      case 61:
      case 63:
      }
      return false;
    }
    return true;
  }

  boolean asn1Equals(DERObject paramDERObject)
  {
    if (!(paramDERObject instanceof DERPrintableString))
      return false;
    DERPrintableString localDERPrintableString = (DERPrintableString)paramDERObject;
    return getString().equals(localDERPrintableString.getString());
  }

  void encode(DEROutputStream paramDEROutputStream)
    throws IOException
  {
    paramDEROutputStream.writeEncoded(19, getOctets());
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
 * Qualified Name:     com.braintree.org.bouncycastle.asn1.DERPrintableString
 * JD-Core Version:    0.6.2
 */