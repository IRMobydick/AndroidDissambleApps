package com.ubercab.common.collect;

import java.util.NoSuchElementException;

abstract class AbstractIterator<T> extends UnmodifiableIterator<T>
{
  private static final int DONE = 2;
  private static final int FAILED = 3;
  private static final int NOT_READY = 1;
  private static final int READY;
  private T next;
  private int state = 1;

  private boolean tryToComputeNext()
  {
    this.state = 3;
    this.next = computeNext();
    int i = this.state;
    boolean bool = false;
    if (i != 2)
    {
      this.state = 0;
      bool = true;
    }
    return bool;
  }

  protected abstract T computeNext();

  protected final T endOfData()
  {
    this.state = 2;
    return null;
  }

  public final boolean hasNext()
  {
    if (this.state == 3)
      throw new IllegalStateException("failed state");
    switch (this.state)
    {
    case 1:
    default:
      return tryToComputeNext();
    case 2:
      return false;
    case 0:
    }
    return true;
  }

  public final T next()
  {
    if (!hasNext())
      throw new NoSuchElementException();
    this.state = 1;
    Object localObject = this.next;
    this.next = null;
    return localObject;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.common.collect.AbstractIterator
 * JD-Core Version:    0.6.2
 */