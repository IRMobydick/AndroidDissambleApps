package com.braintree.org.bouncycastle.asn1;

import java.io.InputStream;

abstract class LimitedInputStream extends InputStream
{
  protected final InputStream _in;
  private int _limit;

  LimitedInputStream(InputStream paramInputStream, int paramInt)
  {
    this._in = paramInputStream;
    this._limit = paramInt;
  }

  int getRemaining()
  {
    return this._limit;
  }

  protected void setParentEofDetect(boolean paramBoolean)
  {
    if ((this._in instanceof IndefiniteLengthInputStream))
      ((IndefiniteLengthInputStream)this._in).setEofOn00(paramBoolean);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.braintree.org.bouncycastle.asn1.LimitedInputStream
 * JD-Core Version:    0.6.2
 */