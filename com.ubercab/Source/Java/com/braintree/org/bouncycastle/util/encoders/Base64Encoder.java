package com.braintree.org.bouncycastle.util.encoders;

import java.io.IOException;
import java.io.OutputStream;

public class Base64Encoder
  implements Encoder
{
  protected final byte[] decodingTable = new byte[''];
  protected final byte[] encodingTable = { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47 };
  protected byte padding = 61;

  public Base64Encoder()
  {
    initialiseDecodingTable();
  }

  private int decodeLastBlock(OutputStream paramOutputStream, char paramChar1, char paramChar2, char paramChar3, char paramChar4)
    throws IOException
  {
    if (paramChar3 == this.padding)
    {
      int i3 = this.decodingTable[paramChar1];
      int i4 = this.decodingTable[paramChar2];
      paramOutputStream.write(i3 << 2 | i4 >> 4);
      return 1;
    }
    if (paramChar4 == this.padding)
    {
      int n = this.decodingTable[paramChar1];
      int i1 = this.decodingTable[paramChar2];
      int i2 = this.decodingTable[paramChar3];
      paramOutputStream.write(n << 2 | i1 >> 4);
      paramOutputStream.write(i1 << 4 | i2 >> 2);
      return 2;
    }
    int i = this.decodingTable[paramChar1];
    int j = this.decodingTable[paramChar2];
    int k = this.decodingTable[paramChar3];
    int m = this.decodingTable[paramChar4];
    paramOutputStream.write(i << 2 | j >> 4);
    paramOutputStream.write(j << 4 | k >> 2);
    paramOutputStream.write(m | k << 6);
    return 3;
  }

  private boolean ignore(char paramChar)
  {
    return (paramChar == '\n') || (paramChar == '\r') || (paramChar == '\t') || (paramChar == ' ');
  }

  private int nextI(String paramString, int paramInt1, int paramInt2)
  {
    while ((paramInt1 < paramInt2) && (ignore(paramString.charAt(paramInt1))))
      paramInt1++;
    return paramInt1;
  }

  private int nextI(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    while ((paramInt1 < paramInt2) && (ignore((char)paramArrayOfByte[paramInt1])))
      paramInt1++;
    return paramInt1;
  }

  public int decode(String paramString, OutputStream paramOutputStream)
    throws IOException
  {
    int i = 0;
    for (int j = paramString.length(); ; j--)
      if ((j <= 0) || (!ignore(paramString.charAt(j - 1))))
      {
        int k = j - 4;
        int i9;
        for (int m = nextI(paramString, 0, k); m < k; m = nextI(paramString, i9, k))
        {
          byte[] arrayOfByte1 = this.decodingTable;
          int n = m + 1;
          int i1 = arrayOfByte1[paramString.charAt(m)];
          int i2 = nextI(paramString, n, k);
          byte[] arrayOfByte2 = this.decodingTable;
          int i3 = i2 + 1;
          int i4 = arrayOfByte2[paramString.charAt(i2)];
          int i5 = nextI(paramString, i3, k);
          byte[] arrayOfByte3 = this.decodingTable;
          int i6 = i5 + 1;
          int i7 = arrayOfByte3[paramString.charAt(i5)];
          int i8 = nextI(paramString, i6, k);
          byte[] arrayOfByte4 = this.decodingTable;
          i9 = i8 + 1;
          int i10 = arrayOfByte4[paramString.charAt(i8)];
          paramOutputStream.write(i1 << 2 | i4 >> 4);
          paramOutputStream.write(i4 << 4 | i7 >> 2);
          paramOutputStream.write(i10 | i7 << 6);
          i += 3;
        }
      }
    return i + decodeLastBlock(paramOutputStream, paramString.charAt(j - 4), paramString.charAt(j - 3), paramString.charAt(j - 2), paramString.charAt(j - 1));
  }

  public int decode(byte[] paramArrayOfByte, int paramInt1, int paramInt2, OutputStream paramOutputStream)
    throws IOException
  {
    int i = 0;
    for (int j = paramInt1 + paramInt2; ; j--)
      if ((j <= paramInt1) || (!ignore((char)paramArrayOfByte[(j - 1)])))
      {
        int k = j - 4;
        int i9;
        for (int m = nextI(paramArrayOfByte, paramInt1, k); m < k; m = nextI(paramArrayOfByte, i9, k))
        {
          byte[] arrayOfByte1 = this.decodingTable;
          int n = m + 1;
          int i1 = arrayOfByte1[paramArrayOfByte[m]];
          int i2 = nextI(paramArrayOfByte, n, k);
          byte[] arrayOfByte2 = this.decodingTable;
          int i3 = i2 + 1;
          int i4 = arrayOfByte2[paramArrayOfByte[i2]];
          int i5 = nextI(paramArrayOfByte, i3, k);
          byte[] arrayOfByte3 = this.decodingTable;
          int i6 = i5 + 1;
          int i7 = arrayOfByte3[paramArrayOfByte[i5]];
          int i8 = nextI(paramArrayOfByte, i6, k);
          byte[] arrayOfByte4 = this.decodingTable;
          i9 = i8 + 1;
          int i10 = arrayOfByte4[paramArrayOfByte[i8]];
          paramOutputStream.write(i1 << 2 | i4 >> 4);
          paramOutputStream.write(i4 << 4 | i7 >> 2);
          paramOutputStream.write(i10 | i7 << 6);
          i += 3;
        }
      }
    return i + decodeLastBlock(paramOutputStream, (char)paramArrayOfByte[(j - 4)], (char)paramArrayOfByte[(j - 3)], (char)paramArrayOfByte[(j - 2)], (char)paramArrayOfByte[(j - 1)]);
  }

  public int encode(byte[] paramArrayOfByte, int paramInt1, int paramInt2, OutputStream paramOutputStream)
    throws IOException
  {
    int i = paramInt2 % 3;
    int j = paramInt2 - i;
    for (int k = paramInt1; k < paramInt1 + j; k += 3)
    {
      int i9 = 0xFF & paramArrayOfByte[k];
      int i10 = 0xFF & paramArrayOfByte[(k + 1)];
      int i11 = 0xFF & paramArrayOfByte[(k + 2)];
      paramOutputStream.write(this.encodingTable[(0x3F & i9 >>> 2)]);
      paramOutputStream.write(this.encodingTable[(0x3F & (i9 << 4 | i10 >>> 4))]);
      paramOutputStream.write(this.encodingTable[(0x3F & (i10 << 2 | i11 >>> 6))]);
      paramOutputStream.write(this.encodingTable[(i11 & 0x3F)]);
    }
    int i4;
    switch (i)
    {
    case 0:
    default:
      i4 = 4 * (j / 3);
      if (i != 0)
        break;
    case 1:
    case 2:
    }
    for (int i5 = 0; ; i5 = 4)
    {
      return i5 + i4;
      int i6 = 0xFF & paramArrayOfByte[(paramInt1 + j)];
      int i7 = 0x3F & i6 >>> 2;
      int i8 = 0x3F & i6 << 4;
      paramOutputStream.write(this.encodingTable[i7]);
      paramOutputStream.write(this.encodingTable[i8]);
      paramOutputStream.write(this.padding);
      paramOutputStream.write(this.padding);
      break;
      int m = 0xFF & paramArrayOfByte[(paramInt1 + j)];
      int n = 0xFF & paramArrayOfByte[(1 + (paramInt1 + j))];
      int i1 = 0x3F & m >>> 2;
      int i2 = 0x3F & (m << 4 | n >>> 4);
      int i3 = 0x3F & n << 2;
      paramOutputStream.write(this.encodingTable[i1]);
      paramOutputStream.write(this.encodingTable[i2]);
      paramOutputStream.write(this.encodingTable[i3]);
      paramOutputStream.write(this.padding);
      break;
    }
  }

  protected void initialiseDecodingTable()
  {
    for (int i = 0; i < this.encodingTable.length; i++)
      this.decodingTable[this.encodingTable[i]] = ((byte)i);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.braintree.org.bouncycastle.util.encoders.Base64Encoder
 * JD-Core Version:    0.6.2
 */