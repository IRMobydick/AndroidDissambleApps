package com.ubercab.common.collect;

import java.util.Iterator;

public abstract class UnmodifiableIterator<E>
  implements Iterator<E>
{
  public final void remove()
  {
    throw new UnsupportedOperationException();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.common.collect.UnmodifiableIterator
 * JD-Core Version:    0.6.2
 */