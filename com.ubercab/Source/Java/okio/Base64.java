package okio;

import java.io.UnsupportedEncodingException;

final class Base64
{
  private static final byte[] MAP = { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47 };

  public static byte[] decode(String paramString)
  {
    int i = paramString.length();
    byte[] arrayOfByte1;
    int j;
    int k;
    int m;
    int n;
    label78: int i6;
    int i8;
    label113: int i7;
    if (i > 0)
    {
      int i11 = paramString.charAt(i - 1);
      if ((i11 == 61) || (i11 == 10) || (i11 == 13) || (i11 == 32) || (i11 == 9));
    }
    else
    {
      arrayOfByte1 = new byte[(int)(6L * i / 8L)];
      j = 0;
      k = 0;
      m = 0;
      n = 0;
      if (m >= i)
        break label311;
      i6 = paramString.charAt(m);
      if ((i6 < 65) || (i6 > 90))
        break label194;
      i8 = i6 - 65;
      k = k << 6 | (byte)i8;
      j++;
      if (j % 4 != 0)
        break label434;
      int i9 = n + 1;
      arrayOfByte1[n] = ((byte)(k >> 16));
      int i10 = i9 + 1;
      arrayOfByte1[i9] = ((byte)(k >> 8));
      i7 = i10 + 1;
      arrayOfByte1[i10] = ((byte)k);
    }
    while (true)
    {
      m++;
      n = i7;
      break label78;
      i--;
      break;
      label194: if ((i6 >= 97) && (i6 <= 122))
      {
        i8 = i6 - 71;
        break label113;
      }
      if ((i6 >= 48) && (i6 <= 57))
      {
        i8 = i6 + 4;
        break label113;
      }
      if (i6 == 43)
      {
        i8 = 62;
        break label113;
      }
      if (i6 == 47)
      {
        i8 = 63;
        break label113;
      }
      if ((i6 != 10) && (i6 != 13) && (i6 != 32))
      {
        if (i6 == 9)
        {
          i7 = n;
        }
        else
        {
          arrayOfByte1 = null;
          while (true)
          {
            return arrayOfByte1;
            label311: int i1 = j % 4;
            if (i1 == 1)
              return null;
            int i2;
            if (i1 == 2)
            {
              int i5 = k << 12;
              i2 = n + 1;
              arrayOfByte1[n] = ((byte)(i5 >> 16));
            }
            while (i2 != arrayOfByte1.length)
            {
              byte[] arrayOfByte2 = new byte[i2];
              System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, i2);
              return arrayOfByte2;
              if (i1 == 3)
              {
                int i3 = k << 6;
                int i4 = n + 1;
                arrayOfByte1[n] = ((byte)(i3 >> 16));
                n = i4 + 1;
                arrayOfByte1[i4] = ((byte)(i3 >> 8));
              }
              i2 = n;
            }
          }
        }
      }
      else
        label434: i7 = n;
    }
  }

  public static String encode(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = new byte[4 * (2 + paramArrayOfByte.length) / 3];
    int i = paramArrayOfByte.length - paramArrayOfByte.length % 3;
    int j = 0;
    int k = 0;
    while (j < i)
    {
      int i7 = k + 1;
      arrayOfByte[k] = MAP[((0xFF & paramArrayOfByte[j]) >> 2)];
      int i8 = i7 + 1;
      arrayOfByte[i7] = MAP[((0x3 & paramArrayOfByte[j]) << 4 | (0xFF & paramArrayOfByte[(j + 1)]) >> 4)];
      int i9 = i8 + 1;
      arrayOfByte[i8] = MAP[((0xF & paramArrayOfByte[(j + 1)]) << 2 | (0xFF & paramArrayOfByte[(j + 2)]) >> 6)];
      k = i9 + 1;
      arrayOfByte[i9] = MAP[(0x3F & paramArrayOfByte[(j + 2)])];
      j += 3;
    }
    switch (paramArrayOfByte.length % 3)
    {
    default:
    case 1:
    case 2:
    }
    while (true)
    {
      int i2 = k;
      try
      {
        while (true)
        {
          String str = new String(arrayOfByte, 0, i2, "US-ASCII");
          return str;
          int i3 = k + 1;
          arrayOfByte[k] = MAP[((0xFF & paramArrayOfByte[i]) >> 2)];
          int i4 = i3 + 1;
          arrayOfByte[i3] = MAP[((0x3 & paramArrayOfByte[i]) << 4)];
          int i5 = i4 + 1;
          arrayOfByte[i4] = 61;
          int i6 = i5 + 1;
          arrayOfByte[i5] = 61;
          i2 = i6;
        }
        int m = k + 1;
        arrayOfByte[k] = MAP[((0xFF & paramArrayOfByte[i]) >> 2)];
        int n = m + 1;
        arrayOfByte[m] = MAP[((0x3 & paramArrayOfByte[i]) << 4 | (0xFF & paramArrayOfByte[(i + 1)]) >> 4)];
        int i1 = n + 1;
        arrayOfByte[n] = MAP[((0xF & paramArrayOfByte[(i + 1)]) << 2)];
        k = i1 + 1;
        arrayOfByte[i1] = 61;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        throw new AssertionError(localUnsupportedEncodingException);
      }
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     okio.Base64
 * JD-Core Version:    0.6.2
 */