package com.braintree.org.bouncycastle.asn1;

import java.io.IOException;
import java.io.InputStream;

public class DEROctetStringParser
  implements ASN1OctetStringParser
{
  private DefiniteLengthInputStream stream;

  DEROctetStringParser(DefiniteLengthInputStream paramDefiniteLengthInputStream)
  {
    this.stream = paramDefiniteLengthInputStream;
  }

  public DERObject getDERObject()
  {
    try
    {
      DERObject localDERObject = getLoadedObject();
      return localDERObject;
    }
    catch (IOException localIOException)
    {
      throw new ASN1ParsingException("IOException converting stream to byte array: " + localIOException.getMessage(), localIOException);
    }
  }

  public DERObject getLoadedObject()
    throws IOException
  {
    return new DEROctetString(this.stream.toByteArray());
  }

  public InputStream getOctetStream()
  {
    return this.stream;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.braintree.org.bouncycastle.asn1.DEROctetStringParser
 * JD-Core Version:    0.6.2
 */