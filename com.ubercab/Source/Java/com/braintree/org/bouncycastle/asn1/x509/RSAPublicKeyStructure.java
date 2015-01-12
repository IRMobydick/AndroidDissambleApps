package com.braintree.org.bouncycastle.asn1.x509;

import com.braintree.org.bouncycastle.asn1.ASN1Encodable;
import com.braintree.org.bouncycastle.asn1.ASN1EncodableVector;
import com.braintree.org.bouncycastle.asn1.ASN1Sequence;
import com.braintree.org.bouncycastle.asn1.ASN1TaggedObject;
import com.braintree.org.bouncycastle.asn1.DERInteger;
import com.braintree.org.bouncycastle.asn1.DERObject;
import com.braintree.org.bouncycastle.asn1.DERSequence;
import java.math.BigInteger;
import java.util.Enumeration;

public class RSAPublicKeyStructure extends ASN1Encodable
{
  private BigInteger modulus;
  private BigInteger publicExponent;

  public RSAPublicKeyStructure(ASN1Sequence paramASN1Sequence)
  {
    if (paramASN1Sequence.size() != 2)
      throw new IllegalArgumentException("Bad sequence size: " + paramASN1Sequence.size());
    Enumeration localEnumeration = paramASN1Sequence.getObjects();
    this.modulus = DERInteger.getInstance(localEnumeration.nextElement()).getPositiveValue();
    this.publicExponent = DERInteger.getInstance(localEnumeration.nextElement()).getPositiveValue();
  }

  public RSAPublicKeyStructure(BigInteger paramBigInteger1, BigInteger paramBigInteger2)
  {
    this.modulus = paramBigInteger1;
    this.publicExponent = paramBigInteger2;
  }

  public static RSAPublicKeyStructure getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    return getInstance(ASN1Sequence.getInstance(paramASN1TaggedObject, paramBoolean));
  }

  public static RSAPublicKeyStructure getInstance(Object paramObject)
  {
    if ((paramObject == null) || ((paramObject instanceof RSAPublicKeyStructure)))
      return (RSAPublicKeyStructure)paramObject;
    if ((paramObject instanceof ASN1Sequence))
      return new RSAPublicKeyStructure((ASN1Sequence)paramObject);
    throw new IllegalArgumentException("Invalid RSAPublicKeyStructure: " + paramObject.getClass().getName());
  }

  public BigInteger getModulus()
  {
    return this.modulus;
  }

  public BigInteger getPublicExponent()
  {
    return this.publicExponent;
  }

  public DERObject toASN1Object()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(new DERInteger(getModulus()));
    localASN1EncodableVector.add(new DERInteger(getPublicExponent()));
    return new DERSequence(localASN1EncodableVector);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.braintree.org.bouncycastle.asn1.x509.RSAPublicKeyStructure
 * JD-Core Version:    0.6.2
 */