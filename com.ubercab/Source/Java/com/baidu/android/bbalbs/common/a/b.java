package com.baidu.android.bbalbs.common.a;

import java.io.UnsupportedEncodingException;

public final class b
{
  private static final byte[] a = { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47 };

  public static String a(byte[] paramArrayOfByte, String paramString)
    throws UnsupportedEncodingException
  {
    int i = 4 * paramArrayOfByte.length / 3;
    byte[] arrayOfByte = new byte[i + (3 + i / 76)];
    int j = 0;
    int k = paramArrayOfByte.length - paramArrayOfByte.length % 3;
    int m = 0;
    int n = 0;
    if (m >= k);
    label68: int i9;
    label72: int i4;
    int i5;
    switch (paramArrayOfByte.length % 3)
    {
    default:
      i9 = n;
      return new String(arrayOfByte, 0, i9, paramString);
      int i1 = n + 1;
      arrayOfByte[n] = a[((0xFF & paramArrayOfByte[m]) >> 2)];
      int i2 = i1 + 1;
      arrayOfByte[i1] = a[((0x3 & paramArrayOfByte[m]) << 4 | (0xFF & paramArrayOfByte[(m + 1)]) >> 4)];
      int i3 = i2 + 1;
      arrayOfByte[i2] = a[((0xF & paramArrayOfByte[(m + 1)]) << 2 | (0xFF & paramArrayOfByte[(m + 2)]) >> 6)];
      i4 = i3 + 1;
      arrayOfByte[i3] = a[(0x3F & paramArrayOfByte[(m + 2)])];
      if (((i4 - j) % 76 == 0) && (i4 != 0))
      {
        i5 = i4 + 1;
        arrayOfByte[i4] = 10;
        j++;
      }
      break;
    case 1:
    case 2:
    }
    while (true)
    {
      m += 3;
      n = i5;
      break;
      int i10 = n + 1;
      arrayOfByte[n] = a[((0xFF & paramArrayOfByte[k]) >> 2)];
      int i11 = i10 + 1;
      arrayOfByte[i10] = a[((0x3 & paramArrayOfByte[k]) << 4)];
      int i12 = i11 + 1;
      arrayOfByte[i11] = 61;
      int i13 = i12 + 1;
      arrayOfByte[i12] = 61;
      i9 = i13;
      break label72;
      int i6 = n + 1;
      arrayOfByte[n] = a[((0xFF & paramArrayOfByte[k]) >> 2)];
      int i7 = i6 + 1;
      arrayOfByte[i6] = a[((0x3 & paramArrayOfByte[k]) << 4 | (0xFF & paramArrayOfByte[(k + 1)]) >> 4)];
      int i8 = i7 + 1;
      arrayOfByte[i7] = a[((0xF & paramArrayOfByte[(k + 1)]) << 2)];
      n = i8 + 1;
      arrayOfByte[i8] = 61;
      break label68;
      i5 = i4;
    }
  }

  public static byte[] a(byte[] paramArrayOfByte)
  {
    return a(paramArrayOfByte, paramArrayOfByte.length);
  }

  public static byte[] a(byte[] paramArrayOfByte, int paramInt)
  {
    int i = 3 * (paramInt / 4);
    if (i == 0)
      return new byte[0];
    byte[] arrayOfByte1 = new byte[i];
    int j = 0;
    int k = paramArrayOfByte[(paramInt - 1)];
    if ((k == 10) || (k == 13) || (k == 32) || (k == 9));
    while (true)
    {
      paramInt--;
      break;
      if (k != 61)
        break label75;
      j++;
    }
    label75: int m = 0;
    int n = 0;
    int i1 = 0;
    int i2 = 0;
    if (i1 >= paramInt)
    {
      int i8;
      if (j > 0)
      {
        int i9 = n << j * 6;
        i8 = i2 + 1;
        arrayOfByte1[i2] = ((byte)((0xFF0000 & i9) >> 16));
        if (j == 1)
        {
          i2 = i8 + 1;
          arrayOfByte1[i8] = ((byte)((0xFF00 & i9) >> 8));
        }
      }
      else
      {
        i8 = i2;
      }
      byte[] arrayOfByte2 = new byte[i8];
      System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, i8);
      return arrayOfByte2;
    }
    int i3 = paramArrayOfByte[i1];
    int i4;
    if ((i3 != 10) && (i3 != 13) && (i3 != 32))
      if (i3 == 9)
        i4 = i2;
    while (true)
    {
      i1++;
      i2 = i4;
      break;
      int i5;
      if ((i3 >= 65) && (i3 <= 90))
      {
        i5 = i3 - 65;
        label244: n = n << 6 | (byte)i5;
        if (m % 4 != 3)
          break label401;
        int i6 = i2 + 1;
        arrayOfByte1[i2] = ((byte)((0xFF0000 & n) >> 16));
        int i7 = i6 + 1;
        arrayOfByte1[i6] = ((byte)((0xFF00 & n) >> 8));
        i4 = i7 + 1;
        arrayOfByte1[i7] = ((byte)(n & 0xFF));
      }
      while (true)
      {
        m++;
        break;
        if ((i3 >= 97) && (i3 <= 122))
        {
          i5 = i3 - 71;
          break label244;
        }
        if ((i3 >= 48) && (i3 <= 57))
        {
          i5 = i3 + 4;
          break label244;
        }
        if (i3 == 43)
        {
          i5 = 62;
          break label244;
        }
        if (i3 == 47)
        {
          i5 = 63;
          break label244;
        }
        return null;
        label401: i4 = i2;
      }
      i4 = i2;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.android.bbalbs.common.a.b
 * JD-Core Version:    0.6.2
 */