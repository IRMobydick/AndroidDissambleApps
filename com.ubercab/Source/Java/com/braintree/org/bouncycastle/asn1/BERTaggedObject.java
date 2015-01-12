package com.braintree.org.bouncycastle.asn1;

import java.io.IOException;
import java.util.Enumeration;

public class BERTaggedObject extends DERTaggedObject
{
  public BERTaggedObject(int paramInt)
  {
    super(false, paramInt, new BERSequence());
  }

  public BERTaggedObject(int paramInt, DEREncodable paramDEREncodable)
  {
    super(paramInt, paramDEREncodable);
  }

  public BERTaggedObject(boolean paramBoolean, int paramInt, DEREncodable paramDEREncodable)
  {
    super(paramBoolean, paramInt, paramDEREncodable);
  }

  void encode(DEROutputStream paramDEROutputStream)
    throws IOException
  {
    if (((paramDEROutputStream instanceof ASN1OutputStream)) || ((paramDEROutputStream instanceof BEROutputStream)))
    {
      paramDEROutputStream.writeTag(160, this.tagNo);
      paramDEROutputStream.write(128);
      if (!this.empty)
      {
        if (!this.explicit)
        {
          Enumeration localEnumeration;
          if ((this.obj instanceof ASN1OctetString))
            if ((this.obj instanceof BERConstructedOctetString))
              localEnumeration = ((BERConstructedOctetString)this.obj).getObjects();
          while (true)
          {
            if (!localEnumeration.hasMoreElements())
              break label215;
            paramDEROutputStream.writeObject(localEnumeration.nextElement());
            continue;
            localEnumeration = new BERConstructedOctetString(((ASN1OctetString)this.obj).getOctets()).getObjects();
            continue;
            if ((this.obj instanceof ASN1Sequence))
            {
              localEnumeration = ((ASN1Sequence)this.obj).getObjects();
            }
            else
            {
              if (!(this.obj instanceof ASN1Set))
                break;
              localEnumeration = ((ASN1Set)this.obj).getObjects();
            }
          }
          throw new RuntimeException("not implemented: " + this.obj.getClass().getName());
        }
        paramDEROutputStream.writeObject(this.obj);
      }
      label215: paramDEROutputStream.write(0);
      paramDEROutputStream.write(0);
      return;
    }
    super.encode(paramDEROutputStream);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.braintree.org.bouncycastle.asn1.BERTaggedObject
 * JD-Core Version:    0.6.2
 */