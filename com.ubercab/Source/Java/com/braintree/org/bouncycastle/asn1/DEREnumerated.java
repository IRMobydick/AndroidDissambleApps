package com.braintree.org.bouncycastle.asn1;

import com.braintree.org.bouncycastle.util.Arrays;
import java.io.IOException;
import java.math.BigInteger;

public class DEREnumerated extends ASN1Object
{
  byte[] bytes;

  public DEREnumerated(int paramInt)
  {
    this.bytes = BigInteger.valueOf(paramInt).toByteArray();
  }

  public DEREnumerated(BigInteger paramBigInteger)
  {
    this.bytes = paramBigInteger.toByteArray();
  }

  public DEREnumerated(byte[] paramArrayOfByte)
  {
    this.bytes = paramArrayOfByte;
  }

  public static DEREnumerated getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    DERObject localDERObject = paramASN1TaggedObject.getObject();
    if ((paramBoolean) || ((localDERObject instanceof DEREnumerated)))
      return getInstance(localDERObject);
    return new DEREnumerated(((ASN1OctetString)localDERObject).getOctets());
  }

  public static DEREnumerated getInstance(Object paramObject)
  {
    if ((paramObject == null) || ((paramObject instanceof DEREnumerated)))
      return (DEREnumerated)paramObject;
    throw new IllegalArgumentException("illegal object in getInstance: " + paramObject.getClass().getName());
  }

  boolean asn1Equals(DERObject paramDERObject)
  {
    if (!(paramDERObject instanceof DEREnumerated))
      return false;
    DEREnumerated localDEREnumerated = (DEREnumerated)paramDERObject;
    return Arrays.areEqual(this.bytes, localDEREnumerated.bytes);
  }

  void encode(DEROutputStream paramDEROutputStream)
    throws IOException
  {
    paramDEROutputStream.writeEncoded(10, this.bytes);
  }

  public BigInteger getValue()
  {
    return new BigInteger(this.bytes);
  }

  public int hashCode()
  {
    return Arrays.hashCode(this.bytes);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.braintree.org.bouncycastle.asn1.DEREnumerated
 * JD-Core Version:    0.6.2
 */