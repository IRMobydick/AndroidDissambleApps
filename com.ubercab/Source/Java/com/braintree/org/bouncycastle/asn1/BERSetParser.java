package com.braintree.org.bouncycastle.asn1;

import java.io.IOException;

public class BERSetParser
  implements ASN1SetParser
{
  private ASN1StreamParser _parser;

  BERSetParser(ASN1StreamParser paramASN1StreamParser)
  {
    this._parser = paramASN1StreamParser;
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
      throw new ASN1ParsingException(localIOException.getMessage(), localIOException);
    }
  }

  public DERObject getLoadedObject()
    throws IOException
  {
    return new BERSet(this._parser.readVector(), false);
  }

  public DEREncodable readObject()
    throws IOException
  {
    return this._parser.readObject();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.braintree.org.bouncycastle.asn1.BERSetParser
 * JD-Core Version:    0.6.2
 */