package com.braintree.org.bouncycastle.asn1;

import java.util.Vector;

public class DEREncodableVector
{
  Vector v = new Vector();

  public void add(DEREncodable paramDEREncodable)
  {
    this.v.addElement(paramDEREncodable);
  }

  public DEREncodable get(int paramInt)
  {
    return (DEREncodable)this.v.elementAt(paramInt);
  }

  public int size()
  {
    return this.v.size();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.braintree.org.bouncycastle.asn1.DEREncodableVector
 * JD-Core Version:    0.6.2
 */