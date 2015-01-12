package com.google.android.gms.common.data;

import java.util.NoSuchElementException;

public class h<T> extends c<T>
{
  private T Kr;

  public h(DataBuffer<T> paramDataBuffer)
  {
    super(paramDataBuffer);
  }

  public T next()
  {
    if (!hasNext())
      throw new NoSuchElementException("Cannot advance the iterator beyond " + this.JW);
    this.JW = (1 + this.JW);
    if (this.JW == 0)
    {
      this.Kr = this.JV.get(0);
      if (!(this.Kr instanceof d))
        throw new IllegalStateException("DataBuffer reference of type " + this.Kr.getClass() + " is not movable");
    }
    else
    {
      ((d)this.Kr).ap(this.JW);
    }
    return this.Kr;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.data.h
 * JD-Core Version:    0.6.2
 */