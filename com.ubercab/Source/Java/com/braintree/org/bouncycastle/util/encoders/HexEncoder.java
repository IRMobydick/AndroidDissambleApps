package com.braintree.org.bouncycastle.util.encoders;

import java.io.IOException;
import java.io.OutputStream;

public class HexEncoder
  implements Encoder
{
  protected final byte[] decodingTable = new byte[''];
  protected final byte[] encodingTable = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };

  public HexEncoder()
  {
    initialiseDecodingTable();
  }

  private boolean ignore(char paramChar)
  {
    return (paramChar == '\n') || (paramChar == '\r') || (paramChar == '\t') || (paramChar == ' ');
  }

  public int decode(String paramString, OutputStream paramOutputStream)
    throws IOException
  {
    int i = 0;
    int j = paramString.length();
    int k;
    if ((j <= 0) || (!ignore(paramString.charAt(j - 1))))
      k = 0;
    while (true)
    {
      if (k >= j)
        break label163;
      int m = k;
      while (true)
        if ((m < j) && (ignore(paramString.charAt(m))))
        {
          m++;
          continue;
          j--;
          break;
        }
      byte[] arrayOfByte1 = this.decodingTable;
      int n = m + 1;
      int i1 = arrayOfByte1[paramString.charAt(m)];
      for (int i2 = n; (i2 < j) && (ignore(paramString.charAt(i2))); i2++);
      byte[] arrayOfByte2 = this.decodingTable;
      k = i2 + 1;
      paramOutputStream.write(arrayOfByte2[paramString.charAt(i2)] | i1 << 4);
      i++;
    }
    label163: return i;
  }

  public int decode(byte[] paramArrayOfByte, int paramInt1, int paramInt2, OutputStream paramOutputStream)
    throws IOException
  {
    int i = 0;
    int j = paramInt1 + paramInt2;
    int k;
    if ((j <= paramInt1) || (!ignore((char)paramArrayOfByte[(j - 1)])))
      k = paramInt1;
    while (true)
    {
      if (k >= j)
        break label158;
      int m = k;
      while (true)
        if ((m < j) && (ignore((char)paramArrayOfByte[m])))
        {
          m++;
          continue;
          j--;
          break;
        }
      byte[] arrayOfByte1 = this.decodingTable;
      int n = m + 1;
      int i1 = arrayOfByte1[paramArrayOfByte[m]];
      for (int i2 = n; (i2 < j) && (ignore((char)paramArrayOfByte[i2])); i2++);
      byte[] arrayOfByte2 = this.decodingTable;
      k = i2 + 1;
      paramOutputStream.write(arrayOfByte2[paramArrayOfByte[i2]] | i1 << 4);
      i++;
    }
    label158: return i;
  }

  public int encode(byte[] paramArrayOfByte, int paramInt1, int paramInt2, OutputStream paramOutputStream)
    throws IOException
  {
    for (int i = paramInt1; i < paramInt1 + paramInt2; i++)
    {
      int j = 0xFF & paramArrayOfByte[i];
      paramOutputStream.write(this.encodingTable[(j >>> 4)]);
      paramOutputStream.write(this.encodingTable[(j & 0xF)]);
    }
    return paramInt2 * 2;
  }

  protected void initialiseDecodingTable()
  {
    for (int i = 0; i < this.encodingTable.length; i++)
      this.decodingTable[this.encodingTable[i]] = ((byte)i);
    this.decodingTable[65] = this.decodingTable[97];
    this.decodingTable[66] = this.decodingTable[98];
    this.decodingTable[67] = this.decodingTable[99];
    this.decodingTable[68] = this.decodingTable[100];
    this.decodingTable[69] = this.decodingTable[101];
    this.decodingTable[70] = this.decodingTable[102];
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.braintree.org.bouncycastle.util.encoders.HexEncoder
 * JD-Core Version:    0.6.2
 */