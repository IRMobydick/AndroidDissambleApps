package com.ubercab.common.collect;

import java.util.ListIterator;

public final class UnmodifiableListIterator<E> extends UnmodifiableIterator<E>
  implements ListIterator<E>
{
  private final ListIterator<E> mListIterator;

  protected UnmodifiableListIterator(ListIterator<E> paramListIterator)
  {
    this.mListIterator = paramListIterator;
  }

  public void add(E paramE)
  {
    throw new UnsupportedOperationException();
  }

  public boolean hasNext()
  {
    return this.mListIterator.hasNext();
  }

  public boolean hasPrevious()
  {
    return this.mListIterator.hasPrevious();
  }

  public E next()
  {
    return this.mListIterator.next();
  }

  public int nextIndex()
  {
    return this.mListIterator.nextIndex();
  }

  public E previous()
  {
    return this.mListIterator.previous();
  }

  public int previousIndex()
  {
    return this.mListIterator.previousIndex();
  }

  public void set(E paramE)
  {
    throw new UnsupportedOperationException();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.common.collect.UnmodifiableListIterator
 * JD-Core Version:    0.6.2
 */