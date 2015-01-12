package com.ubercab.common.collect;

import com.ubercab.common.base.Preconditions;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

public final class EvictingQueue<E>
  implements Queue<E>
{
  final int mMaxSize;
  final Queue<E> mQueue;

  private EvictingQueue(int paramInt)
  {
    if (paramInt >= 0);
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool);
      this.mQueue = new ArrayDeque(paramInt);
      this.mMaxSize = paramInt;
      return;
    }
  }

  public static <E> EvictingQueue<E> create(int paramInt)
  {
    return new EvictingQueue(paramInt);
  }

  public boolean add(E paramE)
  {
    Preconditions.checkNotNull(paramE);
    if (this.mMaxSize == 0)
      return true;
    if (size() == this.mMaxSize)
      this.mQueue.remove();
    this.mQueue.add(paramE);
    return true;
  }

  public boolean addAll(Collection<? extends E> paramCollection)
  {
    Iterator localIterator = paramCollection.iterator();
    boolean bool = false;
    while (localIterator.hasNext())
      bool |= add(localIterator.next());
    return bool;
  }

  public void clear()
  {
    this.mQueue.clear();
  }

  public boolean contains(Object paramObject)
  {
    return this.mQueue.contains(paramObject);
  }

  public boolean containsAll(Collection<?> paramCollection)
  {
    return this.mQueue.containsAll(paramCollection);
  }

  public E element()
  {
    return this.mQueue.element();
  }

  public boolean isEmpty()
  {
    return this.mQueue.isEmpty();
  }

  public Iterator<E> iterator()
  {
    return this.mQueue.iterator();
  }

  public boolean offer(E paramE)
  {
    return add(paramE);
  }

  public E peek()
  {
    return this.mQueue.peek();
  }

  public E poll()
  {
    return this.mQueue.poll();
  }

  public int remainingCapacity()
  {
    return this.mMaxSize - size();
  }

  public E remove()
  {
    return this.mQueue.remove();
  }

  public boolean remove(Object paramObject)
  {
    return this.mQueue.remove(paramObject);
  }

  public boolean removeAll(Collection<?> paramCollection)
  {
    return this.mQueue.removeAll(paramCollection);
  }

  public boolean retainAll(Collection<?> paramCollection)
  {
    return this.mQueue.retainAll(paramCollection);
  }

  public int size()
  {
    return this.mQueue.size();
  }

  public Object[] toArray()
  {
    return this.mQueue.toArray();
  }

  public <E> E[] toArray(E[] paramArrayOfE)
  {
    return (Object[])this.mQueue.toArray();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.common.collect.EvictingQueue
 * JD-Core Version:    0.6.2
 */