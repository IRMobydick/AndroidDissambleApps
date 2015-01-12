package com.ubercab.common.collect;

import com.ubercab.common.base.Preconditions;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class ImmutableList<E>
  implements List<E>
{
  private final List<E> mList;

  private ImmutableList(List<E> paramList)
  {
    this.mList = paramList;
  }

  private static <T> List<T> copyIterator(Iterator<T> paramIterator)
  {
    ArrayList localArrayList = new ArrayList();
    while (paramIterator.hasNext())
      localArrayList.add(paramIterator.next());
    return localArrayList;
  }

  public static <E> ImmutableList<E> copyOf(Collection<? extends E> paramCollection)
  {
    return new Builder().add((Object[])paramCollection.toArray()).build();
  }

  public static <E> ImmutableList<E> of()
  {
    return new Builder().build();
  }

  public static <E> ImmutableList<E> of(E paramE)
  {
    return new Builder().add(paramE).build();
  }

  public static <E> ImmutableList<E> of(E paramE1, E paramE2)
  {
    return new Builder().add(new Object[] { paramE1, paramE2 }).build();
  }

  public static <E> ImmutableList<E> of(E paramE1, E paramE2, E paramE3)
  {
    return new Builder().add(new Object[] { paramE1, paramE2, paramE3 }).build();
  }

  public static <E> ImmutableList<E> of(E paramE1, E paramE2, E paramE3, E paramE4)
  {
    return new Builder().add(new Object[] { paramE1, paramE2, paramE3, paramE4 }).build();
  }

  public static <E> ImmutableList<E> of(E paramE1, E paramE2, E paramE3, E paramE4, E paramE5)
  {
    return new Builder().add(new Object[] { paramE1, paramE2, paramE3, paramE4, paramE5 }).build();
  }

  public void add(int paramInt, E paramE)
  {
    throw new UnsupportedOperationException();
  }

  public boolean add(E paramE)
  {
    throw new UnsupportedOperationException();
  }

  public boolean addAll(int paramInt, Collection<? extends E> paramCollection)
  {
    throw new UnsupportedOperationException();
  }

  public boolean addAll(Collection<? extends E> paramCollection)
  {
    throw new UnsupportedOperationException();
  }

  public void clear()
  {
    throw new UnsupportedOperationException();
  }

  public boolean contains(Object paramObject)
  {
    return this.mList.contains(paramObject);
  }

  public boolean containsAll(Collection<?> paramCollection)
  {
    return this.mList.containsAll(paramCollection);
  }

  public E get(int paramInt)
  {
    return this.mList.get(paramInt);
  }

  public int indexOf(Object paramObject)
  {
    return this.mList.indexOf(paramObject);
  }

  public boolean isEmpty()
  {
    return this.mList.isEmpty();
  }

  public UnmodifiableIterator<E> iterator()
  {
    return listIterator();
  }

  public int lastIndexOf(Object paramObject)
  {
    return this.mList.lastIndexOf(paramObject);
  }

  public UnmodifiableListIterator<E> listIterator()
  {
    return listIterator(0);
  }

  public UnmodifiableListIterator<E> listIterator(int paramInt)
  {
    return new UnmodifiableListIterator(this.mList.listIterator(paramInt));
  }

  public E remove(int paramInt)
  {
    throw new UnsupportedOperationException();
  }

  public boolean remove(Object paramObject)
  {
    throw new UnsupportedOperationException();
  }

  public boolean removeAll(Collection<?> paramCollection)
  {
    throw new UnsupportedOperationException();
  }

  public boolean retainAll(Collection<?> paramCollection)
  {
    throw new UnsupportedOperationException();
  }

  public E set(int paramInt, E paramE)
  {
    throw new UnsupportedOperationException();
  }

  public int size()
  {
    return this.mList.size();
  }

  public List<E> subList(int paramInt1, int paramInt2)
  {
    return new ArrayList(this.mList.subList(paramInt1, paramInt2));
  }

  public Object[] toArray()
  {
    return (Object[])this.mList.toArray().clone();
  }

  public <T> T[] toArray(T[] paramArrayOfT)
  {
    return (Object[])toArray();
  }

  public static class Builder<E>
  {
    private final List<E> mList = new ArrayList();

    public Builder<E> add(E paramE)
    {
      Preconditions.checkNotNull(paramE);
      this.mList.add(paramE);
      return this;
    }

    public Builder<E> add(E[] paramArrayOfE)
    {
      int i = paramArrayOfE.length;
      for (int j = 0; j < i; j++)
        add(paramArrayOfE[j]);
      return this;
    }

    public Builder<E> addAll(Iterable<? extends E> paramIterable)
    {
      addAll(paramIterable.iterator());
      return this;
    }

    public Builder<E> addAll(Iterator<? extends E> paramIterator)
    {
      while (paramIterator.hasNext())
        add(paramIterator.next());
      return this;
    }

    public ImmutableList<E> build()
    {
      return new ImmutableList(this.mList, null);
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.common.collect.ImmutableList
 * JD-Core Version:    0.6.2
 */