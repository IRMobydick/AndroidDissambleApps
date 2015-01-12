package com.ubercab.common.collect;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class ImmutableMap<K, V>
  implements Map<K, V>
{
  private final Map<K, V> mMap;

  private ImmutableMap(Map paramMap)
  {
    this.mMap = paramMap;
  }

  public static <K, V> ImmutableMap<K, V> of()
  {
    return new ImmutableMap(new LinkedHashMap());
  }

  public static <K, V> ImmutableMap<K, V> of(K paramK, V paramV)
  {
    return new Builder().put(paramK, paramV).build();
  }

  public static <K, V> ImmutableMap<K, V> of(K paramK1, V paramV1, K paramK2, V paramV2)
  {
    return new Builder().put(paramK1, paramV1).put(paramK2, paramV2).build();
  }

  public static <K, V> ImmutableMap<K, V> of(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3)
  {
    return new Builder().put(paramK1, paramV1).put(paramK2, paramV2).put(paramK3, paramV3).build();
  }

  public static <K, V> ImmutableMap<K, V> of(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3, K paramK4, V paramV4)
  {
    return new Builder().put(paramK1, paramV1).put(paramK2, paramV2).put(paramK3, paramV3).put(paramK4, paramV4).build();
  }

  public static <K, V> ImmutableMap<K, V> of(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3, K paramK4, V paramV4, K paramK5, V paramV5)
  {
    return new Builder().put(paramK1, paramV1).put(paramK2, paramV2).put(paramK3, paramV3).put(paramK4, paramV4).put(paramK5, paramV5).build();
  }

  public void clear()
  {
    throw new UnsupportedOperationException();
  }

  public boolean containsKey(Object paramObject)
  {
    return this.mMap.containsKey(paramObject);
  }

  public boolean containsValue(Object paramObject)
  {
    return this.mMap.containsValue(paramObject);
  }

  public Set<Map.Entry<K, V>> entrySet()
  {
    return new LinkedHashSet(this.mMap.entrySet());
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    ImmutableMap localImmutableMap;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localImmutableMap = (ImmutableMap)paramObject;
      if (this.mMap == null)
        break;
    }
    while (this.mMap.equals(localImmutableMap.mMap));
    while (true)
    {
      return false;
      if (localImmutableMap.mMap == null)
        break;
    }
  }

  public V get(Object paramObject)
  {
    return this.mMap.get(paramObject);
  }

  public int hashCode()
  {
    if (this.mMap != null)
      return this.mMap.hashCode();
    return 0;
  }

  public boolean isEmpty()
  {
    return this.mMap.isEmpty();
  }

  public Set<K> keySet()
  {
    return new LinkedHashSet(this.mMap.keySet());
  }

  public V put(K paramK, V paramV)
  {
    throw new UnsupportedOperationException();
  }

  public void putAll(Map<? extends K, ? extends V> paramMap)
  {
    throw new UnsupportedOperationException();
  }

  public V remove(Object paramObject)
  {
    throw new UnsupportedOperationException();
  }

  public int size()
  {
    return this.mMap.size();
  }

  public Collection<V> values()
  {
    return new LinkedList(this.mMap.values());
  }

  public static class Builder<K, V>
  {
    private final Map<K, V> mMap = new LinkedHashMap();

    public ImmutableMap<K, V> build()
    {
      return new ImmutableMap(this.mMap, null);
    }

    public Builder<K, V> put(K paramK, V paramV)
    {
      if (this.mMap.containsKey(paramK))
        throw new IllegalArgumentException("duplicate key");
      this.mMap.put(paramK, paramV);
      return this;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.common.collect.ImmutableMap
 * JD-Core Version:    0.6.2
 */