package com.ubercab.common.collect;

import com.ubercab.common.base.Preconditions;
import java.util.Iterator;

abstract class TransformedIterator<F, T>
  implements Iterator<T>
{
  final Iterator<? extends F> backingIterator;

  TransformedIterator(Iterator<? extends F> paramIterator)
  {
    this.backingIterator = ((Iterator)Preconditions.checkNotNull(paramIterator));
  }

  public final boolean hasNext()
  {
    return this.backingIterator.hasNext();
  }

  public final T next()
  {
    return transform(this.backingIterator.next());
  }

  public final void remove()
  {
    this.backingIterator.remove();
  }

  abstract T transform(F paramF);
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.common.collect.TransformedIterator
 * JD-Core Version:    0.6.2
 */