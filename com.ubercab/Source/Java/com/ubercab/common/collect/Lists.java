package com.ubercab.common.collect;

import java.util.ArrayList;
import java.util.Iterator;

public final class Lists
{
  public static <T> ArrayList<T> newArrayList(Iterable<T> paramIterable)
  {
    return newArrayList(paramIterable.iterator());
  }

  public static <T> ArrayList<T> newArrayList(Iterator<T> paramIterator)
  {
    ArrayList localArrayList = new ArrayList();
    while (paramIterator.hasNext())
      localArrayList.add(paramIterator.next());
    return localArrayList;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.common.collect.Lists
 * JD-Core Version:    0.6.2
 */