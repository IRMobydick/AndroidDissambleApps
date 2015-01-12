package dagger.internal;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;

public class ArrayQueue<E> extends AbstractCollection<E>
  implements Queue<E>, Cloneable, Serializable
{
  private static final int MIN_INITIAL_CAPACITY = 8;
  private static final long serialVersionUID = 2340985798034038923L;
  private transient Object[] elements;
  private transient int head;
  private transient int tail;

  public ArrayQueue()
  {
    this.elements = new Object[16];
  }

  public ArrayQueue(int paramInt)
  {
    allocateElements(paramInt);
  }

  public ArrayQueue(Collection<? extends E> paramCollection)
  {
    allocateElements(paramCollection.size());
    addAll(paramCollection);
  }

  private void allocateElements(int paramInt)
  {
    int i = 8;
    if (paramInt >= i)
    {
      int j = paramInt | paramInt >>> 1;
      int k = j | j >>> 2;
      int m = k | k >>> 4;
      int n = m | m >>> 8;
      i = 1 + (n | n >>> 16);
      if (i < 0)
        i >>>= 1;
    }
    this.elements = new Object[i];
  }

  private boolean delete(int paramInt)
  {
    Object[] arrayOfObject = this.elements;
    int i = -1 + arrayOfObject.length;
    int j = this.head;
    int k = this.tail;
    int m = i & paramInt - j;
    int n = i & k - paramInt;
    if (m >= (i & k - j))
      throw new ConcurrentModificationException();
    if (m < n)
    {
      if (j <= paramInt)
        System.arraycopy(arrayOfObject, j, arrayOfObject, j + 1, m);
      while (true)
      {
        arrayOfObject[j] = null;
        this.head = (i & j + 1);
        return false;
        System.arraycopy(arrayOfObject, 0, arrayOfObject, 1, paramInt);
        arrayOfObject[0] = arrayOfObject[i];
        System.arraycopy(arrayOfObject, j, arrayOfObject, j + 1, i - j);
      }
    }
    if (paramInt < k)
      System.arraycopy(arrayOfObject, paramInt + 1, arrayOfObject, paramInt, n);
    for (this.tail = (k - 1); ; this.tail = (i & k - 1))
    {
      return true;
      System.arraycopy(arrayOfObject, paramInt + 1, arrayOfObject, paramInt, i - paramInt);
      arrayOfObject[i] = arrayOfObject[0];
      System.arraycopy(arrayOfObject, 1, arrayOfObject, 0, k);
    }
  }

  private void doubleCapacity()
  {
    int i = this.head;
    int j = this.elements.length;
    int k = j - i;
    int m = j << 1;
    if (m < 0)
      throw new IllegalStateException("Sorry, queue too big");
    Object[] arrayOfObject = new Object[m];
    System.arraycopy(this.elements, i, arrayOfObject, 0, k);
    System.arraycopy(this.elements, 0, arrayOfObject, k, i);
    this.elements = arrayOfObject;
    this.head = 0;
    this.tail = j;
  }

  private void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    paramObjectInputStream.defaultReadObject();
    int i = paramObjectInputStream.readInt();
    allocateElements(i);
    this.head = 0;
    this.tail = i;
    for (int j = 0; j < i; j++)
      this.elements[j] = paramObjectInputStream.readObject();
  }

  private void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    paramObjectOutputStream.defaultWriteObject();
    paramObjectOutputStream.writeInt(size());
    int i = -1 + this.elements.length;
    for (int j = this.head; j != this.tail; j = i & j + 1)
      paramObjectOutputStream.writeObject(this.elements[j]);
  }

  public boolean add(E paramE)
  {
    if (paramE == null)
      throw new NullPointerException("e == null");
    this.elements[this.tail] = paramE;
    int i = 1 + this.tail & -1 + this.elements.length;
    this.tail = i;
    if (i == this.head)
      doubleCapacity();
    return true;
  }

  public void clear()
  {
    int i = this.head;
    int j = this.tail;
    if (i != j)
    {
      this.tail = 0;
      this.head = 0;
      int k = i;
      int m = -1 + this.elements.length;
      do
      {
        this.elements[k] = null;
        k = m & k + 1;
      }
      while (k != j);
    }
  }

  public ArrayQueue<E> clone()
  {
    try
    {
      ArrayQueue localArrayQueue = (ArrayQueue)super.clone();
      Object[] arrayOfObject = (Object[])Array.newInstance(this.elements.getClass().getComponentType(), this.elements.length);
      System.arraycopy(this.elements, 0, arrayOfObject, 0, this.elements.length);
      localArrayQueue.elements = arrayOfObject;
      return localArrayQueue;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
    }
    throw new AssertionError();
  }

  public boolean contains(Object paramObject)
  {
    if (paramObject == null)
      return false;
    int i = -1 + this.elements.length;
    for (int j = this.head; ; j = i & j + 1)
    {
      Object localObject = this.elements[j];
      if (localObject == null)
        break;
      if (paramObject.equals(localObject))
        return true;
    }
  }

  public E element()
  {
    Object localObject = this.elements[this.head];
    if (localObject == null)
      throw new NoSuchElementException();
    return localObject;
  }

  public boolean isEmpty()
  {
    return this.head == this.tail;
  }

  public Iterator<E> iterator()
  {
    return new QueueIterator(null);
  }

  public boolean offer(E paramE)
  {
    return add(paramE);
  }

  public E peek()
  {
    return this.elements[this.head];
  }

  public E poll()
  {
    int i = this.head;
    Object localObject = this.elements[i];
    if (localObject == null)
      return null;
    this.elements[i] = null;
    this.head = (i + 1 & -1 + this.elements.length);
    return localObject;
  }

  public E remove()
  {
    Object localObject = poll();
    if (localObject == null)
      throw new NoSuchElementException();
    return localObject;
  }

  public boolean remove(Object paramObject)
  {
    if (paramObject == null)
      return false;
    int i = -1 + this.elements.length;
    for (int j = this.head; ; j = i & j + 1)
    {
      Object localObject = this.elements[j];
      if (localObject == null)
        break;
      if (paramObject.equals(localObject))
      {
        delete(j);
        return true;
      }
    }
  }

  public int size()
  {
    return this.tail - this.head & -1 + this.elements.length;
  }

  public Object[] toArray()
  {
    return toArray(new Object[size()]);
  }

  public <T> T[] toArray(T[] paramArrayOfT)
  {
    int i = size();
    if (paramArrayOfT.length < i)
      paramArrayOfT = (Object[])Array.newInstance(paramArrayOfT.getClass().getComponentType(), i);
    if (this.head < this.tail)
      System.arraycopy(this.elements, this.head, paramArrayOfT, 0, size());
    while (true)
    {
      if (paramArrayOfT.length > i)
        paramArrayOfT[i] = null;
      return paramArrayOfT;
      if (this.head > this.tail)
      {
        int j = this.elements.length - this.head;
        System.arraycopy(this.elements, this.head, paramArrayOfT, 0, j);
        System.arraycopy(this.elements, 0, paramArrayOfT, j, this.tail);
      }
    }
  }

  private class QueueIterator
    implements Iterator<E>
  {
    private int cursor = ArrayQueue.this.head;
    private int fence = ArrayQueue.this.tail;
    private int lastRet = -1;

    private QueueIterator()
    {
    }

    public boolean hasNext()
    {
      return this.cursor != this.fence;
    }

    public E next()
    {
      if (this.cursor == this.fence)
        throw new NoSuchElementException();
      Object localObject = ArrayQueue.this.elements[this.cursor];
      if ((ArrayQueue.this.tail != this.fence) || (localObject == null))
        throw new ConcurrentModificationException();
      this.lastRet = this.cursor;
      this.cursor = (1 + this.cursor & -1 + ArrayQueue.this.elements.length);
      return localObject;
    }

    public void remove()
    {
      if (this.lastRet < 0)
        throw new IllegalStateException();
      if (ArrayQueue.this.delete(this.lastRet))
      {
        this.cursor = (-1 + this.cursor & -1 + ArrayQueue.this.elements.length);
        this.fence = ArrayQueue.this.tail;
      }
      this.lastRet = -1;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     dagger.internal.ArrayQueue
 * JD-Core Version:    0.6.2
 */