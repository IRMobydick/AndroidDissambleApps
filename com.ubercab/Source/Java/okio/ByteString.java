package okio;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public final class ByteString
  implements Serializable
{
  public static final ByteString EMPTY = of(new byte[0]);
  private static final char[] HEX_DIGITS = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  private static final long serialVersionUID = 1L;
  final byte[] data;
  private transient int hashCode;
  private transient String utf8;

  ByteString(byte[] paramArrayOfByte)
  {
    this.data = paramArrayOfByte;
  }

  public static ByteString decodeBase64(String paramString)
  {
    if (paramString == null)
      throw new IllegalArgumentException("base64 == null");
    byte[] arrayOfByte = Base64.decode(paramString);
    if (arrayOfByte != null)
      return new ByteString(arrayOfByte);
    return null;
  }

  public static ByteString decodeHex(String paramString)
  {
    if (paramString == null)
      throw new IllegalArgumentException("hex == null");
    if (paramString.length() % 2 != 0)
      throw new IllegalArgumentException("Unexpected hex string: " + paramString);
    byte[] arrayOfByte = new byte[paramString.length() / 2];
    for (int i = 0; i < arrayOfByte.length; i++)
      arrayOfByte[i] = ((byte)((decodeHexDigit(paramString.charAt(i * 2)) << 4) + decodeHexDigit(paramString.charAt(1 + i * 2))));
    return of(arrayOfByte);
  }

  private static int decodeHexDigit(char paramChar)
  {
    if ((paramChar >= '0') && (paramChar <= '9'))
      return paramChar - '0';
    if ((paramChar >= 'a') && (paramChar <= 'f'))
      return 10 + (paramChar - 'a');
    if ((paramChar >= 'A') && (paramChar <= 'F'))
      return 10 + (paramChar - 'A');
    throw new IllegalArgumentException("Unexpected hex digit: " + paramChar);
  }

  public static ByteString encodeUtf8(String paramString)
  {
    if (paramString == null)
      throw new IllegalArgumentException("s == null");
    ByteString localByteString = new ByteString(paramString.getBytes(Util.UTF_8));
    localByteString.utf8 = paramString;
    return localByteString;
  }

  public static ByteString of(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
      throw new IllegalArgumentException("data == null");
    return new ByteString((byte[])paramArrayOfByte.clone());
  }

  public static ByteString of(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramArrayOfByte == null)
      throw new IllegalArgumentException("data == null");
    Util.checkOffsetAndCount(paramArrayOfByte.length, paramInt1, paramInt2);
    byte[] arrayOfByte = new byte[paramInt2];
    System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, 0, paramInt2);
    return new ByteString(arrayOfByte);
  }

  public static ByteString read(InputStream paramInputStream, int paramInt)
    throws IOException
  {
    if (paramInputStream == null)
      throw new IllegalArgumentException("in == null");
    if (paramInt < 0)
      throw new IllegalArgumentException("byteCount < 0: " + paramInt);
    byte[] arrayOfByte = new byte[paramInt];
    int i = 0;
    while (i < paramInt)
    {
      int j = paramInputStream.read(arrayOfByte, i, paramInt - i);
      if (j == -1)
        throw new EOFException();
      i += j;
    }
    return new ByteString(arrayOfByte);
  }

  private void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException
  {
    ByteString localByteString = read(paramObjectInputStream, paramObjectInputStream.readInt());
    try
    {
      Field localField = ByteString.class.getDeclaredField("data");
      localField.setAccessible(true);
      localField.set(this, localByteString.data);
      return;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      throw new AssertionError();
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
    }
    throw new AssertionError();
  }

  private void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    paramObjectOutputStream.writeInt(this.data.length);
    paramObjectOutputStream.write(this.data);
  }

  public String base64()
  {
    return Base64.encode(this.data);
  }

  public boolean equals(Object paramObject)
  {
    return (paramObject == this) || (((paramObject instanceof ByteString)) && (Arrays.equals(((ByteString)paramObject).data, this.data)));
  }

  public byte getByte(int paramInt)
  {
    return this.data[paramInt];
  }

  public int hashCode()
  {
    int i = this.hashCode;
    if (i != 0)
      return i;
    int j = Arrays.hashCode(this.data);
    this.hashCode = j;
    return j;
  }

  public String hex()
  {
    char[] arrayOfChar = new char[2 * this.data.length];
    byte[] arrayOfByte = this.data;
    int i = arrayOfByte.length;
    int j = 0;
    int k = 0;
    while (j < i)
    {
      int m = arrayOfByte[j];
      int n = k + 1;
      arrayOfChar[k] = HEX_DIGITS[(0xF & m >> 4)];
      k = n + 1;
      arrayOfChar[n] = HEX_DIGITS[(m & 0xF)];
      j++;
    }
    return new String(arrayOfChar);
  }

  public int size()
  {
    return this.data.length;
  }

  public ByteString toAsciiLowercase()
  {
    int i = 0;
    while (i < this.data.length)
    {
      int j = this.data[i];
      if ((j < 65) || (j > 90))
      {
        i++;
      }
      else
      {
        byte[] arrayOfByte = (byte[])this.data.clone();
        int k = i + 1;
        arrayOfByte[i] = ((byte)(j + 32));
        int m = k;
        if (m < arrayOfByte.length)
        {
          int n = arrayOfByte[m];
          if ((n < 65) || (n > 90));
          while (true)
          {
            m++;
            break;
            arrayOfByte[m] = ((byte)(n + 32));
          }
        }
        this = new ByteString(arrayOfByte);
      }
    }
    return this;
  }

  public ByteString toAsciiUppercase()
  {
    int i = 0;
    while (i < this.data.length)
    {
      int j = this.data[i];
      if ((j < 97) || (j > 122))
      {
        i++;
      }
      else
      {
        byte[] arrayOfByte = (byte[])this.data.clone();
        int k = i + 1;
        arrayOfByte[i] = ((byte)(j - 32));
        int m = k;
        if (m < arrayOfByte.length)
        {
          int n = arrayOfByte[m];
          if ((n < 97) || (n > 122));
          while (true)
          {
            m++;
            break;
            arrayOfByte[m] = ((byte)(n - 32));
          }
        }
        this = new ByteString(arrayOfByte);
      }
    }
    return this;
  }

  public byte[] toByteArray()
  {
    return (byte[])this.data.clone();
  }

  public String toString()
  {
    if (this.data.length == 0)
      return "ByteString[size=0]";
    if (this.data.length <= 16)
    {
      Object[] arrayOfObject2 = new Object[2];
      arrayOfObject2[0] = Integer.valueOf(this.data.length);
      arrayOfObject2[1] = hex();
      return String.format("ByteString[size=%s data=%s]", arrayOfObject2);
    }
    try
    {
      Object[] arrayOfObject1 = new Object[2];
      arrayOfObject1[0] = Integer.valueOf(this.data.length);
      arrayOfObject1[1] = of(MessageDigest.getInstance("MD5").digest(this.data)).hex();
      String str = String.format("ByteString[size=%s md5=%s]", arrayOfObject1);
      return str;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
    }
    throw new AssertionError();
  }

  public String utf8()
  {
    String str1 = this.utf8;
    if (str1 != null)
      return str1;
    String str2 = new String(this.data, Util.UTF_8);
    this.utf8 = str2;
    return str2;
  }

  public void write(OutputStream paramOutputStream)
    throws IOException
  {
    if (paramOutputStream == null)
      throw new IllegalArgumentException("out == null");
    paramOutputStream.write(this.data);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     okio.ByteString
 * JD-Core Version:    0.6.2
 */