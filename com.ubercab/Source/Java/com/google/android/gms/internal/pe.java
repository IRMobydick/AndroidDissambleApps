package com.google.android.gms.internal;

public class pe
{
  private final byte[] aww = new byte[256];
  private int awx;
  private int awy;

  public pe(byte[] paramArrayOfByte)
  {
    for (int i = 0; i < 256; i++)
      this.aww[i] = ((byte)i);
    int j = 0;
    for (int k = 0; k < 256; k++)
    {
      j = 0xFF & j + this.aww[k] + paramArrayOfByte[(k % paramArrayOfByte.length)];
      int m = this.aww[k];
      this.aww[k] = this.aww[j];
      this.aww[j] = m;
    }
    this.awx = 0;
    this.awy = 0;
  }

  public void o(byte[] paramArrayOfByte)
  {
    int i = this.awx;
    int j = this.awy;
    for (int k = 0; k < paramArrayOfByte.length; k++)
    {
      i = 0xFF & i + 1;
      j = 0xFF & j + this.aww[i];
      int m = this.aww[i];
      this.aww[i] = this.aww[j];
      this.aww[j] = m;
      paramArrayOfByte[k] = ((byte)(paramArrayOfByte[k] ^ this.aww[(0xFF & this.aww[i] + this.aww[j])]));
    }
    this.awx = i;
    this.awy = j;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.pe
 * JD-Core Version:    0.6.2
 */