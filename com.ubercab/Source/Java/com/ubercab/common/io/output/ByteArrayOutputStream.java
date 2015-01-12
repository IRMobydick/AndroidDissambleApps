package com.ubercab.common.io.output;

import com.ubercab.common.io.input.ClosedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.SequenceInputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ByteArrayOutputStream extends OutputStream
{
  private static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
  private final List<byte[]> buffers = new ArrayList();
  private int count;
  private byte[] currentBuffer;
  private int currentBufferIndex;
  private int filledBufferSum;

  public ByteArrayOutputStream()
  {
    this(1024);
  }

  public ByteArrayOutputStream(int paramInt)
  {
    if (paramInt < 0)
      throw new IllegalArgumentException("Negative initial size: " + paramInt);
    try
    {
      needNewBuffer(paramInt);
      return;
    }
    finally
    {
    }
  }

  private void needNewBuffer(int paramInt)
  {
    if (this.currentBufferIndex < -1 + this.buffers.size())
    {
      this.filledBufferSum += this.currentBuffer.length;
      this.currentBufferIndex = (1 + this.currentBufferIndex);
      this.currentBuffer = ((byte[])this.buffers.get(this.currentBufferIndex));
      return;
    }
    int i;
    if (this.currentBuffer == null)
      i = paramInt;
    for (this.filledBufferSum = 0; ; this.filledBufferSum += this.currentBuffer.length)
    {
      this.currentBufferIndex = (1 + this.currentBufferIndex);
      this.currentBuffer = new byte[i];
      this.buffers.add(this.currentBuffer);
      return;
      i = Math.max(this.currentBuffer.length << 1, paramInt - this.filledBufferSum);
    }
  }

  private InputStream toBufferedInputStream()
  {
    int i = this.count;
    if (i == 0)
      return new ClosedInputStream();
    ArrayList localArrayList = new ArrayList(this.buffers.size());
    Iterator localIterator = this.buffers.iterator();
    do
    {
      if (!localIterator.hasNext())
        break;
      byte[] arrayOfByte = (byte[])localIterator.next();
      int j = Math.min(arrayOfByte.length, i);
      localArrayList.add(new ByteArrayInputStream(arrayOfByte, 0, j));
      i -= j;
    }
    while (i != 0);
    return new SequenceInputStream(Collections.enumeration(localArrayList));
  }

  public static InputStream toBufferedInputStream(InputStream paramInputStream)
    throws IOException
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    localByteArrayOutputStream.write(paramInputStream);
    return localByteArrayOutputStream.toBufferedInputStream();
  }

  public void close()
    throws IOException
  {
  }

  public void reset()
  {
    try
    {
      this.count = 0;
      this.filledBufferSum = 0;
      this.currentBufferIndex = 0;
      this.currentBuffer = ((byte[])this.buffers.get(this.currentBufferIndex));
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public int size()
  {
    try
    {
      int i = this.count;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public byte[] toByteArray()
  {
    try
    {
      int i = this.count;
      byte[] arrayOfByte1;
      if (i == 0)
        arrayOfByte1 = EMPTY_BYTE_ARRAY;
      while (true)
      {
        return arrayOfByte1;
        arrayOfByte1 = new byte[i];
        int j = 0;
        Iterator localIterator = this.buffers.iterator();
        if (localIterator.hasNext())
        {
          byte[] arrayOfByte2 = (byte[])localIterator.next();
          int k = Math.min(arrayOfByte2.length, i);
          System.arraycopy(arrayOfByte2, 0, arrayOfByte1, j, k);
          j += k;
          i -= k;
          if (i != 0)
            break;
        }
      }
    }
    finally
    {
    }
  }

  public String toString()
  {
    return new String(toByteArray());
  }

  public String toString(String paramString)
    throws UnsupportedEncodingException
  {
    return new String(toByteArray(), paramString);
  }

  public int write(InputStream paramInputStream)
    throws IOException
  {
    int i = 0;
    try
    {
      int j = this.count - this.filledBufferSum;
      int m;
      for (int k = paramInputStream.read(this.currentBuffer, j, this.currentBuffer.length - j); k != -1; k = m)
      {
        i += k;
        j += k;
        this.count = (k + this.count);
        if (j == this.currentBuffer.length)
        {
          needNewBuffer(this.currentBuffer.length);
          j = 0;
        }
        m = paramInputStream.read(this.currentBuffer, j, this.currentBuffer.length - j);
      }
      return i;
    }
    finally
    {
    }
  }

  public void write(int paramInt)
  {
    try
    {
      int i = this.count - this.filledBufferSum;
      if (i == this.currentBuffer.length)
      {
        needNewBuffer(1 + this.count);
        i = 0;
      }
      this.currentBuffer[i] = ((byte)paramInt);
      this.count = (1 + this.count);
      return;
    }
    finally
    {
    }
  }

  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if ((paramInt1 < 0) || (paramInt1 > paramArrayOfByte.length) || (paramInt2 < 0) || (paramInt1 + paramInt2 > paramArrayOfByte.length) || (paramInt1 + paramInt2 < 0))
      throw new IndexOutOfBoundsException();
    if (paramInt2 == 0)
      return;
    try
    {
      int i = paramInt2 + this.count;
      int j = paramInt2;
      int k = this.count - this.filledBufferSum;
      while (j > 0)
      {
        int m = Math.min(j, this.currentBuffer.length - k);
        System.arraycopy(paramArrayOfByte, paramInt1 + paramInt2 - j, this.currentBuffer, k, m);
        j -= m;
        if (j > 0)
        {
          needNewBuffer(i);
          k = 0;
        }
      }
      this.count = i;
      return;
    }
    finally
    {
    }
  }

  public void writeTo(OutputStream paramOutputStream)
    throws IOException
  {
    try
    {
      int i = this.count;
      Iterator localIterator = this.buffers.iterator();
      do
      {
        if (!localIterator.hasNext())
          break;
        byte[] arrayOfByte = (byte[])localIterator.next();
        int j = Math.min(arrayOfByte.length, i);
        paramOutputStream.write(arrayOfByte, 0, j);
        i -= j;
      }
      while (i != 0);
      return;
    }
    finally
    {
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.common.io.output.ByteArrayOutputStream
 * JD-Core Version:    0.6.2
 */