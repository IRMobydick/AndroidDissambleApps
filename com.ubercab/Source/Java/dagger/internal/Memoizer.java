package dagger.internal;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

abstract class Memoizer<K, V>
{
  private final Map<K, V> map = new LinkedHashMap();
  private final Lock readLock;
  private final Lock writeLock;

  public Memoizer()
  {
    ReentrantReadWriteLock localReentrantReadWriteLock = new ReentrantReadWriteLock();
    this.readLock = localReentrantReadWriteLock.readLock();
    this.writeLock = localReentrantReadWriteLock.writeLock();
  }

  protected abstract V create(K paramK);

  public final V get(K paramK)
  {
    if (paramK == null)
      throw new NullPointerException("key == null");
    this.readLock.lock();
    Object localObject3;
    try
    {
      Object localObject2 = this.map.get(paramK);
      if (localObject2 != null)
      {
        this.readLock.unlock();
        return localObject2;
      }
      this.readLock.unlock();
      localObject3 = create(paramK);
      if (localObject3 == null)
        throw new NullPointerException("create returned null");
    }
    finally
    {
      this.readLock.unlock();
    }
    this.writeLock.lock();
    try
    {
      this.map.put(paramK, localObject3);
      return localObject3;
    }
    finally
    {
      this.writeLock.unlock();
    }
  }

  public final String toString()
  {
    this.readLock.lock();
    try
    {
      String str = this.map.toString();
      return str;
    }
    finally
    {
      this.readLock.unlock();
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     dagger.internal.Memoizer
 * JD-Core Version:    0.6.2
 */