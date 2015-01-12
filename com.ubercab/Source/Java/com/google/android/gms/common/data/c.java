package com.google.android.gms.common.data;

import com.google.android.gms.common.internal.o;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class c<T>
  implements Iterator<T>
{
  protected final DataBuffer<T> JV;
  protected int JW;

  public c(DataBuffer<T> paramDataBuffer)
  {
    this.JV = ((DataBuffer)o.i(paramDataBuffer));
    this.JW = -1;
  }

  public boolean hasNext()
  {
    return this.JW < -1 + this.JV.getCount();
  }

  public T next()
  {
    if (!hasNext())
      throw new NoSuchElementException("Cannot advance the iterator beyond " + this.JW);
    DataBuffer localDataBuffer = this.JV;
    int i = 1 + this.JW;
    this.JW = i;
    return localDataBuffer.get(i);
  }

  public void remove()
  {
    throw new UnsupportedOperationException("Cannot remove elements from a DataBufferIterator");
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.data.c
 * JD-Core Version:    0.6.2
 */