package okio;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Buffer
  implements BufferedSource, BufferedSink, Cloneable
{
  Segment head;
  long size;

  private void readFrom(InputStream paramInputStream, long paramLong, boolean paramBoolean)
    throws IOException
  {
    if (paramInputStream == null)
      throw new IllegalArgumentException("in == null");
    int j;
    do
    {
      localSegment.limit = (j + localSegment.limit);
      this.size += j;
      paramLong -= j;
      if ((paramLong <= 0L) && (!paramBoolean))
        break;
      Segment localSegment = writableSegment(1);
      int i = (int)Math.min(paramLong, 2048 - localSegment.limit);
      j = paramInputStream.read(localSegment.data, localSegment.limit, i);
    }
    while (j != -1);
    if (paramBoolean)
      return;
    throw new EOFException();
  }

  public Buffer buffer()
  {
    return this;
  }

  public void clear()
  {
    skip(this.size);
  }

  public Buffer clone()
  {
    Buffer localBuffer = new Buffer();
    if (this.size == 0L);
    while (true)
    {
      return localBuffer;
      localBuffer.write(this.head.data, this.head.pos, this.head.limit - this.head.pos);
      for (Segment localSegment = this.head.next; localSegment != this.head; localSegment = localSegment.next)
        localBuffer.write(localSegment.data, localSegment.pos, localSegment.limit - localSegment.pos);
    }
  }

  public void close()
  {
  }

  public long completeSegmentByteCount()
  {
    long l = this.size;
    if (l == 0L)
      return 0L;
    Segment localSegment = this.head.prev;
    if (localSegment.limit < 2048)
      l -= localSegment.limit - localSegment.pos;
    return l;
  }

  public Buffer copyTo(OutputStream paramOutputStream)
    throws IOException
  {
    return copyTo(paramOutputStream, 0L, this.size);
  }

  public Buffer copyTo(OutputStream paramOutputStream, long paramLong1, long paramLong2)
    throws IOException
  {
    if (paramOutputStream == null)
      throw new IllegalArgumentException("out == null");
    Util.checkOffsetAndCount(this.size, paramLong1, paramLong2);
    if (paramLong2 == 0L);
    while (true)
    {
      return this;
      for (Segment localSegment = this.head; paramLong1 >= localSegment.limit - localSegment.pos; localSegment = localSegment.next)
        paramLong1 -= localSegment.limit - localSegment.pos;
      while (paramLong2 > 0L)
      {
        int i = (int)(paramLong1 + localSegment.pos);
        int j = (int)Math.min(localSegment.limit - i, paramLong2);
        paramOutputStream.write(localSegment.data, i, j);
        paramLong2 -= j;
        paramLong1 = 0L;
        localSegment = localSegment.next;
      }
    }
  }

  public Buffer emitCompleteSegments()
  {
    return this;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject)
      return true;
    if (!(paramObject instanceof Buffer))
      return false;
    Buffer localBuffer = (Buffer)paramObject;
    if (this.size != localBuffer.size)
      return false;
    if (this.size == 0L)
      return true;
    Segment localSegment1 = this.head;
    Segment localSegment2 = localBuffer.head;
    int i = localSegment1.pos;
    int j = localSegment2.pos;
    long l1 = 0L;
    long l2;
    int m;
    int n;
    if (l1 < this.size)
    {
      l2 = Math.min(localSegment1.limit - i, localSegment2.limit - j);
      int k = 0;
      m = j;
      int i1;
      for (n = i; k < l2; n = i1)
      {
        byte[] arrayOfByte1 = localSegment1.data;
        i1 = n + 1;
        int i2 = arrayOfByte1[n];
        byte[] arrayOfByte2 = localSegment2.data;
        int i3 = m + 1;
        if (i2 != arrayOfByte2[m])
          return false;
        k++;
        m = i3;
      }
      if (n != localSegment1.limit)
        break label245;
      localSegment1 = localSegment1.next;
    }
    label245: for (i = localSegment1.pos; ; i = n)
    {
      if (m == localSegment2.limit)
        localSegment2 = localSegment2.next;
      for (j = localSegment2.pos; ; j = m)
      {
        l1 += l2;
        break;
        return true;
      }
    }
  }

  public boolean exhausted()
  {
    return this.size == 0L;
  }

  public void flush()
  {
  }

  public byte getByte(long paramLong)
  {
    Util.checkOffsetAndCount(this.size, paramLong, 1L);
    for (Segment localSegment = this.head; ; localSegment = localSegment.next)
    {
      int i = localSegment.limit - localSegment.pos;
      if (paramLong < i)
        return localSegment.data[(localSegment.pos + (int)paramLong)];
      paramLong -= i;
    }
  }

  public int hashCode()
  {
    Segment localSegment = this.head;
    if (localSegment == null)
      return 0;
    int i = 1;
    do
    {
      int j = localSegment.pos;
      int k = localSegment.limit;
      while (j < k)
      {
        i = i * 31 + localSegment.data[j];
        j++;
      }
      localSegment = localSegment.next;
    }
    while (localSegment != this.head);
    return i;
  }

  public long indexOf(byte paramByte)
  {
    return indexOf(paramByte, 0L);
  }

  public long indexOf(byte paramByte, long paramLong)
  {
    if (paramLong < 0L)
      throw new IllegalArgumentException("fromIndex < 0");
    Segment localSegment = this.head;
    if (localSegment == null)
      return -1L;
    long l1 = 0L;
    int i = localSegment.limit - localSegment.pos;
    if (paramLong >= i);
    for (paramLong -= i; ; paramLong = 0L)
    {
      l1 += i;
      localSegment = localSegment.next;
      if (localSegment != this.head)
        break;
      return -1L;
      byte[] arrayOfByte = localSegment.data;
      long l2 = paramLong + localSegment.pos;
      long l3 = localSegment.limit;
      while (l2 < l3)
      {
        if (arrayOfByte[((int)l2)] == paramByte)
          return l1 + l2 - localSegment.pos;
        l2 += 1L;
      }
    }
  }

  public InputStream inputStream()
  {
    return new InputStream()
    {
      public int available()
      {
        return (int)Math.min(Buffer.this.size, 2147483647L);
      }

      public void close()
      {
      }

      public int read()
      {
        if (Buffer.this.size > 0L)
          return 0xFF & Buffer.this.readByte();
        return -1;
      }

      public int read(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        return Buffer.this.read(paramAnonymousArrayOfByte, paramAnonymousInt1, paramAnonymousInt2);
      }

      public String toString()
      {
        return Buffer.this + ".inputStream()";
      }
    };
  }

  public OutputStream outputStream()
  {
    return new OutputStream()
    {
      public void close()
      {
      }

      public void flush()
      {
      }

      public String toString()
      {
        return this + ".outputStream()";
      }

      public void write(int paramAnonymousInt)
      {
        Buffer.this.writeByte((byte)paramAnonymousInt);
      }

      public void write(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        Buffer.this.write(paramAnonymousArrayOfByte, paramAnonymousInt1, paramAnonymousInt2);
      }
    };
  }

  int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    Segment localSegment = this.head;
    int i;
    if (localSegment == null)
      i = -1;
    do
    {
      return i;
      i = Math.min(paramInt2, localSegment.limit - localSegment.pos);
      System.arraycopy(localSegment.data, localSegment.pos, paramArrayOfByte, paramInt1, i);
      localSegment.pos = (i + localSegment.pos);
      this.size -= i;
    }
    while (localSegment.pos != localSegment.limit);
    this.head = localSegment.pop();
    SegmentPool.INSTANCE.recycle(localSegment);
    return i;
  }

  public long read(Buffer paramBuffer, long paramLong)
  {
    if (paramBuffer == null)
      throw new IllegalArgumentException("sink == null");
    if (paramLong < 0L)
      throw new IllegalArgumentException("byteCount < 0: " + paramLong);
    if (this.size == 0L)
      return -1L;
    if (paramLong > this.size)
      paramLong = this.size;
    paramBuffer.write(this, paramLong);
    return paramLong;
  }

  public long readAll(Sink paramSink)
    throws IOException
  {
    long l = size();
    paramSink.write(this, l);
    return l;
  }

  public byte readByte()
  {
    if (this.size == 0L)
      throw new IllegalStateException("size == 0");
    Segment localSegment = this.head;
    int i = localSegment.pos;
    int j = localSegment.limit;
    byte[] arrayOfByte = localSegment.data;
    int k = i + 1;
    byte b = arrayOfByte[i];
    this.size -= 1L;
    if (k == j)
    {
      this.head = localSegment.pop();
      SegmentPool.INSTANCE.recycle(localSegment);
      return b;
    }
    localSegment.pos = k;
    return b;
  }

  public byte[] readByteArray()
  {
    return readByteArray(this.size);
  }

  public byte[] readByteArray(long paramLong)
  {
    Util.checkOffsetAndCount(this.size, 0L, paramLong);
    if (paramLong > 2147483647L)
      throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + paramLong);
    int i = 0;
    byte[] arrayOfByte = new byte[(int)paramLong];
    while (i < paramLong)
    {
      int j = (int)Math.min(paramLong - i, this.head.limit - this.head.pos);
      System.arraycopy(this.head.data, this.head.pos, arrayOfByte, i, j);
      i += j;
      Segment localSegment1 = this.head;
      localSegment1.pos = (j + localSegment1.pos);
      if (this.head.pos == this.head.limit)
      {
        Segment localSegment2 = this.head;
        this.head = localSegment2.pop();
        SegmentPool.INSTANCE.recycle(localSegment2);
      }
    }
    this.size -= paramLong;
    return arrayOfByte;
  }

  public ByteString readByteString()
    throws IOException
  {
    return new ByteString(readByteArray());
  }

  public ByteString readByteString(long paramLong)
  {
    return new ByteString(readByteArray(paramLong));
  }

  public Buffer readFrom(InputStream paramInputStream)
    throws IOException
  {
    readFrom(paramInputStream, 9223372036854775807L, true);
    return this;
  }

  public Buffer readFrom(InputStream paramInputStream, long paramLong)
    throws IOException
  {
    if (paramLong < 0L)
      throw new IllegalArgumentException("byteCount < 0: " + paramLong);
    readFrom(paramInputStream, paramLong, false);
    return this;
  }

  public void readFully(Buffer paramBuffer, long paramLong)
    throws IOException
  {
    paramBuffer.write(this, paramLong);
  }

  public int readInt()
  {
    if (this.size < 4L)
      throw new IllegalStateException("size < 4: " + this.size);
    Segment localSegment = this.head;
    int i = localSegment.pos;
    int j = localSegment.limit;
    if (j - i < 4)
      return (0xFF & readByte()) << 24 | (0xFF & readByte()) << 16 | (0xFF & readByte()) << 8 | 0xFF & readByte();
    byte[] arrayOfByte = localSegment.data;
    int k = i + 1;
    int m = (0xFF & arrayOfByte[i]) << 24;
    int n = k + 1;
    int i1 = m | (0xFF & arrayOfByte[k]) << 16;
    int i2 = n + 1;
    int i3 = i1 | (0xFF & arrayOfByte[n]) << 8;
    int i4 = i2 + 1;
    int i5 = i3 | 0xFF & arrayOfByte[i2];
    this.size -= 4L;
    if (i4 == j)
    {
      this.head = localSegment.pop();
      SegmentPool.INSTANCE.recycle(localSegment);
      return i5;
    }
    localSegment.pos = i4;
    return i5;
  }

  public int readIntLe()
  {
    return Util.reverseBytesInt(readInt());
  }

  public long readLong()
  {
    if (this.size < 8L)
      throw new IllegalStateException("size < 8: " + this.size);
    Segment localSegment = this.head;
    int i = localSegment.pos;
    int j = localSegment.limit;
    if (j - i < 8)
      return (0xFFFFFFFF & readInt()) << 32 | 0xFFFFFFFF & readInt();
    byte[] arrayOfByte = localSegment.data;
    int k = i + 1;
    long l1 = (0xFF & arrayOfByte[i]) << 56;
    int m = k + 1;
    long l2 = l1 | (0xFF & arrayOfByte[k]) << 48;
    int n = m + 1;
    long l3 = l2 | (0xFF & arrayOfByte[m]) << 40;
    int i1 = n + 1;
    long l4 = l3 | (0xFF & arrayOfByte[n]) << 32;
    int i2 = i1 + 1;
    long l5 = l4 | (0xFF & arrayOfByte[i1]) << 24;
    int i3 = i2 + 1;
    long l6 = l5 | (0xFF & arrayOfByte[i2]) << 16;
    int i4 = i3 + 1;
    long l7 = l6 | (0xFF & arrayOfByte[i3]) << 8;
    int i5 = i4 + 1;
    long l8 = l7 | 0xFF & arrayOfByte[i4];
    this.size -= 8L;
    if (i5 == j)
    {
      this.head = localSegment.pop();
      SegmentPool.INSTANCE.recycle(localSegment);
      return l8;
    }
    localSegment.pos = i5;
    return l8;
  }

  public long readLongLe()
  {
    return Util.reverseBytesLong(readLong());
  }

  public short readShort()
  {
    if (this.size < 2L)
      throw new IllegalStateException("size < 2: " + this.size);
    Segment localSegment = this.head;
    int i = localSegment.pos;
    int j = localSegment.limit;
    if (j - i < 2)
      return (short)((0xFF & readByte()) << 8 | 0xFF & readByte());
    byte[] arrayOfByte = localSegment.data;
    int k = i + 1;
    int m = (0xFF & arrayOfByte[i]) << 8;
    int n = k + 1;
    int i1 = m | 0xFF & arrayOfByte[k];
    this.size -= 2L;
    if (n == j)
    {
      this.head = localSegment.pop();
      SegmentPool.INSTANCE.recycle(localSegment);
    }
    while (true)
    {
      return (short)i1;
      localSegment.pos = n;
    }
  }

  public short readShortLe()
  {
    return Util.reverseBytesShort(readShort());
  }

  public String readString(long paramLong, Charset paramCharset)
  {
    Util.checkOffsetAndCount(this.size, 0L, paramLong);
    if (paramCharset == null)
      throw new IllegalArgumentException("charset == null");
    if (paramLong > 2147483647L)
      throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + paramLong);
    String str;
    if (paramLong == 0L)
      str = "";
    Segment localSegment;
    do
    {
      return str;
      localSegment = this.head;
      if (paramLong + localSegment.pos > localSegment.limit)
        return new String(readByteArray(paramLong), paramCharset);
      str = new String(localSegment.data, localSegment.pos, (int)paramLong, paramCharset);
      localSegment.pos = ((int)(paramLong + localSegment.pos));
      this.size -= paramLong;
    }
    while (localSegment.pos != localSegment.limit);
    this.head = localSegment.pop();
    SegmentPool.INSTANCE.recycle(localSegment);
    return str;
  }

  public String readString(Charset paramCharset)
    throws IOException
  {
    return readString(this.size, paramCharset);
  }

  public String readUtf8()
    throws IOException
  {
    return readString(this.size, Util.UTF_8);
  }

  public String readUtf8(long paramLong)
  {
    return readString(paramLong, Util.UTF_8);
  }

  public String readUtf8Line()
    throws IOException
  {
    long l = indexOf((byte)10);
    if (l == -1L)
    {
      if (this.size != 0L)
        return readUtf8(this.size);
      return null;
    }
    return readUtf8Line(l);
  }

  String readUtf8Line(long paramLong)
  {
    if ((paramLong > 0L) && (getByte(paramLong - 1L) == 13))
    {
      String str2 = readUtf8(paramLong - 1L);
      skip(2L);
      return str2;
    }
    String str1 = readUtf8(paramLong);
    skip(1L);
    return str1;
  }

  public String readUtf8LineStrict()
    throws IOException
  {
    long l = indexOf((byte)10);
    if (l == -1L)
      throw new EOFException();
    return readUtf8Line(l);
  }

  public void require(long paramLong)
    throws EOFException
  {
    if (this.size < paramLong)
      throw new EOFException();
  }

  List<Integer> segmentSizes()
  {
    Object localObject;
    if (this.head == null)
      localObject = Collections.emptyList();
    while (true)
    {
      return localObject;
      localObject = new ArrayList();
      ((List)localObject).add(Integer.valueOf(this.head.limit - this.head.pos));
      for (Segment localSegment = this.head.next; localSegment != this.head; localSegment = localSegment.next)
        ((List)localObject).add(Integer.valueOf(localSegment.limit - localSegment.pos));
    }
  }

  public long size()
  {
    return this.size;
  }

  public void skip(long paramLong)
  {
    Util.checkOffsetAndCount(this.size, 0L, paramLong);
    this.size -= paramLong;
    while (paramLong > 0L)
    {
      int i = (int)Math.min(paramLong, this.head.limit - this.head.pos);
      paramLong -= i;
      Segment localSegment1 = this.head;
      localSegment1.pos = (i + localSegment1.pos);
      if (this.head.pos == this.head.limit)
      {
        Segment localSegment2 = this.head;
        this.head = localSegment2.pop();
        SegmentPool.INSTANCE.recycle(localSegment2);
      }
    }
  }

  public Timeout timeout()
  {
    return Timeout.NONE;
  }

  public String toString()
  {
    if (this.size == 0L)
      return "Buffer[size=0]";
    if (this.size <= 16L)
    {
      ByteString localByteString = clone().readByteString(this.size);
      Object[] arrayOfObject2 = new Object[2];
      arrayOfObject2[0] = Long.valueOf(this.size);
      arrayOfObject2[1] = localByteString.hex();
      return String.format("Buffer[size=%s data=%s]", arrayOfObject2);
    }
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(this.head.data, this.head.pos, this.head.limit - this.head.pos);
      for (Segment localSegment = this.head.next; localSegment != this.head; localSegment = localSegment.next)
        localMessageDigest.update(localSegment.data, localSegment.pos, localSegment.limit - localSegment.pos);
      Object[] arrayOfObject1 = new Object[2];
      arrayOfObject1[0] = Long.valueOf(this.size);
      arrayOfObject1[1] = ByteString.of(localMessageDigest.digest()).hex();
      String str = String.format("Buffer[size=%s md5=%s]", arrayOfObject1);
      return str;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
    }
    throw new AssertionError();
  }

  Segment writableSegment(int paramInt)
  {
    if ((paramInt < 1) || (paramInt > 2048))
      throw new IllegalArgumentException();
    Segment localSegment1;
    if (this.head == null)
    {
      this.head = SegmentPool.INSTANCE.take();
      Segment localSegment2 = this.head;
      Segment localSegment3 = this.head;
      localSegment1 = this.head;
      localSegment3.prev = localSegment1;
      localSegment2.next = localSegment1;
    }
    do
    {
      return localSegment1;
      localSegment1 = this.head.prev;
    }
    while (paramInt + localSegment1.limit <= 2048);
    return localSegment1.push(SegmentPool.INSTANCE.take());
  }

  public Buffer write(ByteString paramByteString)
  {
    if (paramByteString == null)
      throw new IllegalArgumentException("byteString == null");
    return write(paramByteString.data, 0, paramByteString.data.length);
  }

  public Buffer write(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
      throw new IllegalArgumentException("source == null");
    return write(paramArrayOfByte, 0, paramArrayOfByte.length);
  }

  public Buffer write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramArrayOfByte == null)
      throw new IllegalArgumentException("source == null");
    Util.checkOffsetAndCount(paramArrayOfByte.length, paramInt1, paramInt2);
    int i = paramInt1 + paramInt2;
    while (paramInt1 < i)
    {
      Segment localSegment = writableSegment(1);
      int j = Math.min(i - paramInt1, 2048 - localSegment.limit);
      System.arraycopy(paramArrayOfByte, paramInt1, localSegment.data, localSegment.limit, j);
      paramInt1 += j;
      localSegment.limit = (j + localSegment.limit);
    }
    this.size += paramInt2;
    return this;
  }

  public void write(Buffer paramBuffer, long paramLong)
  {
    if (paramBuffer == null)
      throw new IllegalArgumentException("source == null");
    if (paramBuffer == this)
      throw new IllegalArgumentException("source == this");
    Util.checkOffsetAndCount(paramBuffer.size, 0L, paramLong);
    Segment localSegment5;
    label83: Segment localSegment1;
    long l;
    if (paramLong > 0L)
      if (paramLong < paramBuffer.head.limit - paramBuffer.head.pos)
      {
        if (this.head != null)
        {
          localSegment5 = this.head.prev;
          if ((localSegment5 != null) && (paramLong + (localSegment5.limit - localSegment5.pos) <= 2048L))
            break label232;
          paramBuffer.head = paramBuffer.head.split((int)paramLong);
        }
      }
      else
      {
        localSegment1 = paramBuffer.head;
        l = localSegment1.limit - localSegment1.pos;
        paramBuffer.head = localSegment1.pop();
        if (this.head != null)
          break label264;
        this.head = localSegment1;
        Segment localSegment2 = this.head;
        Segment localSegment3 = this.head;
        Segment localSegment4 = this.head;
        localSegment3.prev = localSegment4;
        localSegment2.next = localSegment4;
      }
    while (true)
    {
      paramBuffer.size -= l;
      this.size = (l + this.size);
      paramLong -= l;
      break;
      localSegment5 = null;
      break label83;
      label232: paramBuffer.head.writeTo(localSegment5, (int)paramLong);
      paramBuffer.size -= paramLong;
      this.size = (paramLong + this.size);
      return;
      label264: this.head.prev.push(localSegment1).compact();
    }
  }

  public long writeAll(Source paramSource)
    throws IOException
  {
    if (paramSource == null)
      throw new IllegalArgumentException("source == null");
    long l2;
    for (long l1 = 0L; ; l1 += l2)
    {
      l2 = paramSource.read(this, 2048L);
      if (l2 == -1L)
        break;
    }
    return l1;
  }

  public Buffer writeByte(int paramInt)
  {
    Segment localSegment = writableSegment(1);
    byte[] arrayOfByte = localSegment.data;
    int i = localSegment.limit;
    localSegment.limit = (i + 1);
    arrayOfByte[i] = ((byte)paramInt);
    this.size = (1L + this.size);
    return this;
  }

  public Buffer writeInt(int paramInt)
  {
    Segment localSegment = writableSegment(4);
    byte[] arrayOfByte = localSegment.data;
    int i = localSegment.limit;
    int j = i + 1;
    arrayOfByte[i] = ((byte)(0xFF & paramInt >>> 24));
    int k = j + 1;
    arrayOfByte[j] = ((byte)(0xFF & paramInt >>> 16));
    int m = k + 1;
    arrayOfByte[k] = ((byte)(0xFF & paramInt >>> 8));
    int n = m + 1;
    arrayOfByte[m] = ((byte)(paramInt & 0xFF));
    localSegment.limit = n;
    this.size = (4L + this.size);
    return this;
  }

  public Buffer writeIntLe(int paramInt)
  {
    return writeInt(Util.reverseBytesInt(paramInt));
  }

  public Buffer writeLong(long paramLong)
  {
    Segment localSegment = writableSegment(8);
    byte[] arrayOfByte = localSegment.data;
    int i = localSegment.limit;
    int j = i + 1;
    arrayOfByte[i] = ((byte)(int)(0xFF & paramLong >>> 56));
    int k = j + 1;
    arrayOfByte[j] = ((byte)(int)(0xFF & paramLong >>> 48));
    int m = k + 1;
    arrayOfByte[k] = ((byte)(int)(0xFF & paramLong >>> 40));
    int n = m + 1;
    arrayOfByte[m] = ((byte)(int)(0xFF & paramLong >>> 32));
    int i1 = n + 1;
    arrayOfByte[n] = ((byte)(int)(0xFF & paramLong >>> 24));
    int i2 = i1 + 1;
    arrayOfByte[i1] = ((byte)(int)(0xFF & paramLong >>> 16));
    int i3 = i2 + 1;
    arrayOfByte[i2] = ((byte)(int)(0xFF & paramLong >>> 8));
    int i4 = i3 + 1;
    arrayOfByte[i3] = ((byte)(int)(paramLong & 0xFF));
    localSegment.limit = i4;
    this.size = (8L + this.size);
    return this;
  }

  public Buffer writeLongLe(long paramLong)
  {
    return writeLong(Util.reverseBytesLong(paramLong));
  }

  public Buffer writeShort(int paramInt)
  {
    Segment localSegment = writableSegment(2);
    byte[] arrayOfByte = localSegment.data;
    int i = localSegment.limit;
    int j = i + 1;
    arrayOfByte[i] = ((byte)(0xFF & paramInt >>> 8));
    int k = j + 1;
    arrayOfByte[j] = ((byte)(paramInt & 0xFF));
    localSegment.limit = k;
    this.size = (2L + this.size);
    return this;
  }

  public Buffer writeShortLe(int paramInt)
  {
    return writeShort(Util.reverseBytesShort((short)paramInt));
  }

  public Buffer writeString(String paramString, Charset paramCharset)
  {
    if (paramString == null)
      throw new IllegalArgumentException("string == null");
    if (paramCharset == null)
      throw new IllegalArgumentException("charset == null");
    byte[] arrayOfByte = paramString.getBytes(paramCharset);
    return write(arrayOfByte, 0, arrayOfByte.length);
  }

  public Buffer writeTo(OutputStream paramOutputStream)
    throws IOException
  {
    return writeTo(paramOutputStream, this.size);
  }

  public Buffer writeTo(OutputStream paramOutputStream, long paramLong)
    throws IOException
  {
    if (paramOutputStream == null)
      throw new IllegalArgumentException("out == null");
    Util.checkOffsetAndCount(this.size, 0L, paramLong);
    Segment localSegment1 = this.head;
    while (paramLong > 0L)
    {
      int i = (int)Math.min(paramLong, localSegment1.limit - localSegment1.pos);
      paramOutputStream.write(localSegment1.data, localSegment1.pos, i);
      localSegment1.pos = (i + localSegment1.pos);
      this.size -= i;
      paramLong -= i;
      if (localSegment1.pos == localSegment1.limit)
      {
        Segment localSegment2 = localSegment1;
        localSegment1 = localSegment2.pop();
        this.head = localSegment1;
        SegmentPool.INSTANCE.recycle(localSegment2);
      }
    }
    return this;
  }

  public Buffer writeUtf8(String paramString)
  {
    if (paramString == null)
      throw new IllegalArgumentException("string == null");
    return writeString(paramString, Util.UTF_8);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     okio.Buffer
 * JD-Core Version:    0.6.2
 */