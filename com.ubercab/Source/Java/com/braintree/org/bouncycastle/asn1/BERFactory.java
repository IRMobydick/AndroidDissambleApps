package com.braintree.org.bouncycastle.asn1;

class BERFactory
{
  static final BERSequence EMPTY_SEQUENCE = new BERSequence();
  static final BERSet EMPTY_SET = new BERSet();

  static BERSequence createSequence(ASN1EncodableVector paramASN1EncodableVector)
  {
    if (paramASN1EncodableVector.size() < 1)
      return EMPTY_SEQUENCE;
    return new BERSequence(paramASN1EncodableVector);
  }

  static BERSet createSet(ASN1EncodableVector paramASN1EncodableVector)
  {
    if (paramASN1EncodableVector.size() < 1)
      return EMPTY_SET;
    return new BERSet(paramASN1EncodableVector);
  }

  static BERSet createSet(ASN1EncodableVector paramASN1EncodableVector, boolean paramBoolean)
  {
    if (paramASN1EncodableVector.size() < 1)
      return EMPTY_SET;
    return new BERSet(paramASN1EncodableVector, paramBoolean);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.braintree.org.bouncycastle.asn1.BERFactory
 * JD-Core Version:    0.6.2
 */