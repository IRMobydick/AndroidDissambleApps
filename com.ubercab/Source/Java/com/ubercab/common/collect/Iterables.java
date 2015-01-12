package com.ubercab.common.collect;

import com.ubercab.common.base.Function;
import com.ubercab.common.base.Optional;
import com.ubercab.common.base.Preconditions;
import com.ubercab.common.base.Predicate;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public final class Iterables
{
  public static <T> boolean all(Iterable<T> paramIterable, Predicate<? super T> paramPredicate)
  {
    return Iterators.all(paramIterable.iterator(), paramPredicate);
  }

  public static <T> boolean any(Iterable<T> paramIterable, Predicate<? super T> paramPredicate)
  {
    return Iterators.any(paramIterable.iterator(), paramPredicate);
  }

  public static <T> Iterable<T> filter(Iterable<T> paramIterable, final Predicate<? super T> paramPredicate)
  {
    Preconditions.checkNotNull(paramIterable);
    Preconditions.checkNotNull(paramPredicate);
    return new Iterable()
    {
      public Iterator<T> iterator()
      {
        return Iterators.filter(this.val$unfiltered.iterator(), paramPredicate);
      }
    };
  }

  public static <T> T getFirst(Iterable<? extends T> paramIterable, T paramT)
  {
    return Iterators.getNext(paramIterable.iterator(), paramT);
  }

  public static <T> T getLast(Iterable<T> paramIterable)
  {
    if ((paramIterable instanceof List))
    {
      List localList = (List)paramIterable;
      if (localList.isEmpty())
        throw new NoSuchElementException();
      return getLastInNonemptyList(localList);
    }
    return Iterators.getLast(paramIterable.iterator());
  }

  public static <T> T getLast(Iterable<? extends T> paramIterable, T paramT)
  {
    if ((paramIterable instanceof Collection))
    {
      if (((Collection)paramIterable).isEmpty())
        return paramT;
      if ((paramIterable instanceof List))
        return getLastInNonemptyList((List)paramIterable);
    }
    return Iterators.getLast(paramIterable.iterator(), paramT);
  }

  private static <T> T getLastInNonemptyList(List<T> paramList)
  {
    return paramList.get(-1 + paramList.size());
  }

  public static <T> int indexOf(Iterable<T> paramIterable, Predicate<? super T> paramPredicate)
  {
    return Iterators.indexOf(paramIterable.iterator(), paramPredicate);
  }

  public static <T> Iterable<T> limit(Iterable<T> paramIterable, final int paramInt)
  {
    Preconditions.checkNotNull(paramIterable);
    if (paramInt >= 0);
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool);
      return new Iterable()
      {
        public Iterator<T> iterator()
        {
          return Iterators.limit(this.val$iterable.iterator(), paramInt);
        }
      };
    }
  }

  public static int size(Iterable<?> paramIterable)
  {
    if ((paramIterable instanceof Collection))
      return ((Collection)paramIterable).size();
    return Iterators.size(paramIterable.iterator());
  }

  public static <F, T> Iterable<T> transform(Iterable<F> paramIterable, final Function<? super F, ? extends T> paramFunction)
  {
    Preconditions.checkNotNull(paramIterable);
    Preconditions.checkNotNull(paramFunction);
    return new Iterable()
    {
      public Iterator<T> iterator()
      {
        return Iterators.transform(this.val$fromIterable.iterator(), paramFunction);
      }
    };
  }

  public static <T> Optional<T> tryFind(Iterable<T> paramIterable, Predicate<? super T> paramPredicate)
  {
    return Iterators.tryFind(paramIterable.iterator(), paramPredicate);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.common.collect.Iterables
 * JD-Core Version:    0.6.2
 */