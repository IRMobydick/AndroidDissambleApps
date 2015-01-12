package com.google.android.gms.common.data;

import android.os.Bundle;
import com.google.android.gms.common.api.Releasable;
import java.util.Iterator;

public abstract class DataBuffer<T>
  implements Releasable, Iterable<T>
{
  protected final DataHolder II;

  protected DataBuffer(DataHolder paramDataHolder)
  {
    this.II = paramDataHolder;
    if (this.II != null)
      this.II.e(this);
  }

  @Deprecated
  public final void close()
  {
    release();
  }

  public int describeContents()
  {
    return 0;
  }

  public abstract T get(int paramInt);

  public int getCount()
  {
    if (this.II == null)
      return 0;
    return this.II.getCount();
  }

  public Bundle gy()
  {
    return this.II.gy();
  }

  @Deprecated
  public boolean isClosed()
  {
    if (this.II == null)
      return true;
    return this.II.isClosed();
  }

  public Iterator<T> iterator()
  {
    return new c(this);
  }

  public void release()
  {
    if (this.II != null)
      this.II.close();
  }

  public Iterator<T> singleRefIterator()
  {
    return new h(this);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.data.DataBuffer
 * JD-Core Version:    0.6.2
 */