package com.ubercab.common.collect;

import com.ubercab.common.base.Function;
import com.ubercab.common.base.Optional;
import com.ubercab.common.base.Preconditions;
import com.ubercab.common.base.Predicate;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class Iterators
{
  public static <T> boolean all(Iterator<T> paramIterator, Predicate<? super T> paramPredicate)
  {
    Preconditions.checkNotNull(paramPredicate);
    while (paramIterator.hasNext())
      if (!paramPredicate.apply(paramIterator.next()))
        return false;
    return true;
  }

  public static <T> boolean any(Iterator<T> paramIterator, Predicate<? super T> paramPredicate)
  {
    return indexOf(paramIterator, paramPredicate) != -1;
  }

  public static <T> UnmodifiableIterator<T> filter(Iterator<T> paramIterator, final Predicate<? super T> paramPredicate)
  {
    Preconditions.checkNotNull(paramIterator);
    Preconditions.checkNotNull(paramPredicate);
    return new AbstractIterator()
    {
      protected T computeNext()
      {
        while (this.val$unfiltered.hasNext())
        {
          Object localObject = this.val$unfiltered.next();
          if (paramPredicate.apply(localObject))
            return localObject;
        }
        return endOfData();
      }
    };
  }

  public static <T> T getLast(Iterator<T> paramIterator)
  {
    Object localObject;
    do
      localObject = paramIterator.next();
    while (paramIterator.hasNext());
    return localObject;
  }

  public static <T> T getLast(Iterator<? extends T> paramIterator, T paramT)
  {
    if (paramIterator.hasNext())
      paramT = getLast(paramIterator);
    return paramT;
  }

  static <T> T getNext(Iterator<? extends T> paramIterator, T paramT)
  {
    if (paramIterator.hasNext())
      paramT = paramIterator.next();
    return paramT;
  }

  static <T> int indexOf(Iterator<T> paramIterator, Predicate<? super T> paramPredicate)
  {
    Preconditions.checkNotNull(paramPredicate);
    for (int i = 0; paramIterator.hasNext(); i++)
      if (paramPredicate.apply(paramIterator.next()))
        return i;
    return -1;
  }

  public static <T> Iterator<T> limit(final Iterator<T> paramIterator, int paramInt)
  {
    Preconditions.checkNotNull(paramIterator);
    if (paramInt >= 0);
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool);
      return new Iterator()
      {
        private int count;

        public boolean hasNext()
        {
          return (this.count < this.val$limitSize) && (paramIterator.hasNext());
        }

        public T next()
        {
          if (!hasNext())
            throw new NoSuchElementException();
          this.count = (1 + this.count);
          return paramIterator.next();
        }

        public void remove()
        {
          paramIterator.remove();
        }
      };
    }
  }

  public static int size(Iterator<?> paramIterator)
  {
    for (int i = 0; paramIterator.hasNext(); i++)
      paramIterator.next();
    return i;
  }

  public static <F, T> Iterator<T> transform(Iterator<F> paramIterator, final Function<? super F, ? extends T> paramFunction)
  {
    Preconditions.checkNotNull(paramFunction);
    return new TransformedIterator(paramIterator)
    {
      T transform(F paramAnonymousF)
      {
        return paramFunction.apply(paramAnonymousF);
      }
    };
  }

  public static <T> Optional<T> tryFind(Iterator<T> paramIterator, Predicate<? super T> paramPredicate)
  {
    UnmodifiableIterator localUnmodifiableIterator = filter(paramIterator, paramPredicate);
    if (localUnmodifiableIterator.hasNext())
      return Optional.of(localUnmodifiableIterator.next());
    return Optional.absent();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.common.collect.Iterators
 * JD-Core Version:    0.6.2
 */