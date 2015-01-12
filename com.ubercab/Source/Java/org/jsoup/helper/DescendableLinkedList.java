package org.jsoup.helper;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class DescendableLinkedList<E> extends LinkedList<E>
{
  public Iterator<E> descendingIterator()
  {
    return new DescendingIterator(size(), null);
  }

  public E peekLast()
  {
    if (size() == 0)
      return null;
    return getLast();
  }

  public E pollLast()
  {
    if (size() == 0)
      return null;
    return removeLast();
  }

  public void push(E paramE)
  {
    addFirst(paramE);
  }

  private class DescendingIterator<E>
    implements Iterator<E>
  {
    private final ListIterator<E> iter;

    private DescendingIterator(int arg2)
    {
      int i;
      this.iter = DescendableLinkedList.this.listIterator(i);
    }

    public boolean hasNext()
    {
      return this.iter.hasPrevious();
    }

    public E next()
    {
      return this.iter.previous();
    }

    public void remove()
    {
      this.iter.remove();
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     org.jsoup.helper.DescendableLinkedList
 * JD-Core Version:    0.6.2
 */