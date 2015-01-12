package com.braintree.org.bouncycastle.asn1;

import com.braintree.org.bouncycastle.util.Arrays;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class DERBitString extends ASN1Object
  implements DERString
{
  private static final char[] table = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  protected byte[] data;
  protected int padBits;

  protected DERBitString(byte paramByte, int paramInt)
  {
    this.data = new byte[1];
    this.data[0] = paramByte;
    this.padBits = paramInt;
  }

  public DERBitString(DEREncodable paramDEREncodable)
  {
    try
    {
      this.data = paramDEREncodable.getDERObject().getEncoded("DER");
      this.padBits = 0;
      return;
    }
    catch (IOException localIOException)
    {
      throw new IllegalArgumentException("Error processing object : " + localIOException.toString());
    }
  }

  public DERBitString(byte[] paramArrayOfByte)
  {
    this(paramArrayOfByte, 0);
  }

  public DERBitString(byte[] paramArrayOfByte, int paramInt)
  {
    this.data = paramArrayOfByte;
    this.padBits = paramInt;
  }

  static DERBitString fromOctetString(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length < 1)
      throw new IllegalArgumentException("truncated BIT STRING detected");
    int i = paramArrayOfByte[0];
    byte[] arrayOfByte = new byte[-1 + paramArrayOfByte.length];
    if (arrayOfByte.length != 0)
      System.arraycopy(paramArrayOfByte, 1, arrayOfByte, 0, -1 + paramArrayOfByte.length);
    return new DERBitString(arrayOfByte, i);
  }

  protected static byte[] getBytes(int paramInt)
  {
    int i = 4;
    byte[] arrayOfByte;
    for (int j = 3; ; j--)
    {
      if ((j < 1) || ((paramInt & 255 << j * 8) != 0))
      {
        arrayOfByte = new byte[i];
        for (int k = 0; k < i; k++)
          arrayOfByte[k] = ((byte)(0xFF & paramInt >> k * 8));
      }
      i--;
    }
    return arrayOfByte;
  }

  public static DERBitString getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    DERObject localDERObject = paramASN1TaggedObject.getObject();
    if ((paramBoolean) || ((localDERObject instanceof DERBitString)))
      return getInstance(localDERObject);
    return fromOctetString(((ASN1OctetString)localDERObject).getOctets());
  }

  public static DERBitString getInstance(Object paramObject)
  {
    if ((paramObject == null) || ((paramObject instanceof DERBitString)))
      return (DERBitString)paramObject;
    throw new IllegalArgumentException("illegal object in getInstance: " + paramObject.getClass().getName());
  }

  protected static int getPadBits(int paramInt)
  {
    int j;
    for (int i = 3; ; i--)
    {
      j = 0;
      if (i >= 0)
      {
        if (i == 0)
          break label39;
        if (paramInt >> i * 8 == 0)
          continue;
      }
      for (j = 0xFF & paramInt >> i * 8; ; j = paramInt & 0xFF)
      {
        if (j != 0)
          break label58;
        return 7;
        label39: if (paramInt == 0)
          break;
      }
    }
    label58: for (int k = 1; ; k++)
    {
      j <<= 1;
      if ((j & 0xFF) == 0)
        break;
    }
    return 8 - k;
  }

  protected boolean asn1Equals(DERObject paramDERObject)
  {
    if (!(paramDERObject instanceof DERBitString));
    DERBitString localDERBitString;
    do
    {
      return false;
      localDERBitString = (DERBitString)paramDERObject;
    }
    while ((this.padBits != localDERBitString.padBits) || (!Arrays.areEqual(this.data, localDERBitString.data)));
    return true;
  }

  void encode(DEROutputStream paramDEROutputStream)
    throws IOException
  {
    byte[] arrayOfByte = new byte[1 + getBytes().length];
    arrayOfByte[0] = ((byte)getPadBits());
    System.arraycopy(getBytes(), 0, arrayOfByte, 1, -1 + arrayOfByte.length);
    paramDEROutputStream.writeEncoded(3, arrayOfByte);
  }

  public byte[] getBytes()
  {
    return this.data;
  }

  public int getPadBits()
  {
    return this.padBits;
  }

  public String getString()
  {
    StringBuffer localStringBuffer = new StringBuffer("#");
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    ASN1OutputStream localASN1OutputStream = new ASN1OutputStream(localByteArrayOutputStream);
    try
    {
      localASN1OutputStream.writeObject(this);
      byte[] arrayOfByte = localByteArrayOutputStream.toByteArray();
      for (int i = 0; i != arrayOfByte.length; i++)
      {
        localStringBuffer.append(table[(0xF & arrayOfByte[i] >>> 4)]);
        localStringBuffer.append(table[(0xF & arrayOfByte[i])]);
      }
    }
    catch (IOException localIOException)
    {
      throw new RuntimeException("internal error encoding BitString");
    }
    return localStringBuffer.toString();
  }

  public int hashCode()
  {
    return this.padBits ^ Arrays.hashCode(this.data);
  }

  public int intValue()
  {
    int i = 0;
    for (int j = 0; (j != this.data.length) && (j != 4); j++)
      i |= (0xFF & this.data[j]) << j * 8;
    return i;
  }

  public String toString()
  {
    return getString();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.braintree.org.bouncycastle.asn1.DERBitString
 * JD-Core Version:    0.6.2
 */