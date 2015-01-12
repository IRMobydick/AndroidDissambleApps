package com.braintree.org.bouncycastle.asn1;

import java.io.IOException;
import java.util.Enumeration;

public class LazyDERSequence extends DERSequence
{
  private byte[] encoded;
  private boolean parsed = false;
  private int size = -1;

  LazyDERSequence(byte[] paramArrayOfByte)
    throws IOException
  {
    this.encoded = paramArrayOfByte;
  }

  private void parse()
  {
    LazyDERConstructionEnumeration localLazyDERConstructionEnumeration = new LazyDERConstructionEnumeration(this.encoded);
    while (localLazyDERConstructionEnumeration.hasMoreElements())
      addObject((DEREncodable)localLazyDERConstructionEnumeration.nextElement());
    this.parsed = true;
  }

  void encode(DEROutputStream paramDEROutputStream)
    throws IOException
  {
    paramDEROutputStream.writeEncoded(48, this.encoded);
  }

  public DEREncodable getObjectAt(int paramInt)
  {
    try
    {
      if (!this.parsed)
        parse();
      DEREncodable localDEREncodable = super.getObjectAt(paramInt);
      return localDEREncodable;
    }
    finally
    {
    }
  }

  public Enumeration getObjects()
  {
    try
    {
      Enumeration localEnumeration;
      if (this.parsed)
        localEnumeration = super.getObjects();
      for (Object localObject2 = localEnumeration; ; localObject2 = new LazyDERConstructionEnumeration(this.encoded))
        return localObject2;
    }
    finally
    {
    }
  }

  public int size()
  {
    if (this.size < 0)
    {
      LazyDERConstructionEnumeration localLazyDERConstructionEnumeration = new LazyDERConstructionEnumeration(this.encoded);
      for (this.size = 0; localLazyDERConstructionEnumeration.hasMoreElements(); this.size = (1 + this.size))
        localLazyDERConstructionEnumeration.nextElement();
    }
    return this.size;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.braintree.org.bouncycastle.asn1.LazyDERSequence
 * JD-Core Version:    0.6.2
 */