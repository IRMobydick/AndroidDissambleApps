package com.braintree.org.bouncycastle.asn1;

public class OIDTokenizer
{
  private int index;
  private String oid;

  public OIDTokenizer(String paramString)
  {
    this.oid = paramString;
    this.index = 0;
  }

  public boolean hasMoreTokens()
  {
    return this.index != -1;
  }

  public String nextToken()
  {
    if (this.index == -1)
      return null;
    int i = this.oid.indexOf('.', this.index);
    if (i == -1)
    {
      String str2 = this.oid.substring(this.index);
      this.index = -1;
      return str2;
    }
    String str1 = this.oid.substring(this.index, i);
    this.index = (i + 1);
    return str1;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.braintree.org.bouncycastle.asn1.OIDTokenizer
 * JD-Core Version:    0.6.2
 */