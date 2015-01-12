package com.braintree.org.bouncycastle.util.encoders;

import java.io.IOException;
import java.io.OutputStream;

public abstract interface Encoder
{
  public abstract int decode(String paramString, OutputStream paramOutputStream)
    throws IOException;

  public abstract int decode(byte[] paramArrayOfByte, int paramInt1, int paramInt2, OutputStream paramOutputStream)
    throws IOException;

  public abstract int encode(byte[] paramArrayOfByte, int paramInt1, int paramInt2, OutputStream paramOutputStream)
    throws IOException;
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.braintree.org.bouncycastle.util.encoders.Encoder
 * JD-Core Version:    0.6.2
 */