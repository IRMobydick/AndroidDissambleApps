package com.google.gson.internal;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;

public final class LinkedTreeMap<K, V> extends AbstractMap<K, V>
  implements Serializable
{
  private static final Comparator<Comparable> NATURAL_ORDER;
  Comparator<? super K> comparator;
  private LinkedTreeMap<K, V>.EntrySet entrySet;
  final Node<K, V> header = new Node();
  private LinkedTreeMap<K, V>.KeySet keySet;
  int modCount = 0;
  Node<K, V> root;
  int size = 0;

  static
  {
    if (!LinkedTreeMap.class.desiredAssertionStatus());
    for (boolean bool = true; ; bool = false)
    {
      $assertionsDisabled = bool;
      NATURAL_ORDER = new Comparator()
      {
        public int compare(Comparable paramAnonymousComparable1, Comparable paramAnonymousComparable2)
        {
          return paramAnonymousComparable1.compareTo(paramAnonymousComparable2);
        }
      };
      return;
    }
  }

  public LinkedTreeMap()
  {
    this(NATURAL_ORDER);
  }

  public LinkedTreeMap(Comparator<? super K> paramComparator)
  {
    if (paramComparator != null);
    while (true)
    {
      this.comparator = paramComparator;
      return;
      paramComparator = NATURAL_ORDER;
    }
  }

  private boolean equal(Object paramObject1, Object paramObject2)
  {
    return (paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2)));
  }

  private void rebalance(Node<K, V> paramNode, boolean paramBoolean)
  {
    Object localObject = paramNode;
    Node localNode1;
    Node localNode2;
    int i;
    int j;
    label42: int k;
    int i2;
    label82: int i3;
    label94: int i4;
    if (localObject != null)
    {
      localNode1 = ((Node)localObject).left;
      localNode2 = ((Node)localObject).right;
      if (localNode1 == null)
        break label126;
      i = localNode1.height;
      if (localNode2 == null)
        break label132;
      j = localNode2.height;
      k = i - j;
      if (k != -2)
        break label184;
      Node localNode5 = localNode2.left;
      Node localNode6 = localNode2.right;
      if (localNode6 == null)
        break label138;
      i2 = localNode6.height;
      if (localNode5 == null)
        break label144;
      i3 = localNode5.height;
      i4 = i3 - i2;
      if ((i4 != -1) && ((i4 != 0) || (paramBoolean)))
        break label150;
      rotateLeft((Node)localObject);
    }
    while (true)
    {
      if (!paramBoolean)
        break label259;
      label125: return;
      label126: i = 0;
      break;
      label132: j = 0;
      break label42;
      label138: i2 = 0;
      break label82;
      label144: i3 = 0;
      break label94;
      label150: assert (i4 == 1);
      rotateRight(localNode2);
      rotateLeft((Node)localObject);
    }
    label184: int m;
    label216: int n;
    label228: int i1;
    if (k == 2)
    {
      Node localNode3 = localNode1.left;
      Node localNode4 = localNode1.right;
      if (localNode4 != null)
      {
        m = localNode4.height;
        if (localNode3 == null)
          break label273;
        n = localNode3.height;
        i1 = n - m;
        if ((i1 != 1) && ((i1 != 0) || (paramBoolean)))
          break label279;
        rotateRight((Node)localObject);
        label255: if (paramBoolean)
          break label311;
      }
    }
    label259: label273: label279: label311: label331: 
    do
    {
      do
      {
        localObject = ((Node)localObject).parent;
        break;
        m = 0;
        break label216;
        n = 0;
        break label228;
        assert (i1 == -1);
        rotateLeft(localNode1);
        rotateRight((Node)localObject);
        break label255;
        break label125;
        if (k != 0)
          break label331;
        ((Node)localObject).height = (i + 1);
      }
      while (!paramBoolean);
      return;
      assert ((k == -1) || (k == 1));
      ((Node)localObject).height = (1 + Math.max(i, j));
    }
    while (paramBoolean);
  }

  private void replaceInParent(Node<K, V> paramNode1, Node<K, V> paramNode2)
  {
    Node localNode = paramNode1.parent;
    paramNode1.parent = null;
    if (paramNode2 != null)
      paramNode2.parent = localNode;
    if (localNode != null)
    {
      if (localNode.left == paramNode1)
      {
        localNode.left = paramNode2;
        return;
      }
      assert (localNode.right == paramNode1);
      localNode.right = paramNode2;
      return;
    }
    this.root = paramNode2;
  }

  private void rotateLeft(Node<K, V> paramNode)
  {
    Node localNode1 = paramNode.left;
    Node localNode2 = paramNode.right;
    Node localNode3 = localNode2.left;
    Node localNode4 = localNode2.right;
    paramNode.right = localNode3;
    if (localNode3 != null)
      localNode3.parent = paramNode;
    replaceInParent(paramNode, localNode2);
    localNode2.left = paramNode;
    paramNode.parent = localNode2;
    int i;
    if (localNode1 != null)
    {
      i = localNode1.height;
      if (localNode3 == null)
        break label131;
    }
    label131: for (int j = localNode3.height; ; j = 0)
    {
      paramNode.height = (1 + Math.max(i, j));
      int k = paramNode.height;
      int m = 0;
      if (localNode4 != null)
        m = localNode4.height;
      localNode2.height = (1 + Math.max(k, m));
      return;
      i = 0;
      break;
    }
  }

  private void rotateRight(Node<K, V> paramNode)
  {
    Node localNode1 = paramNode.left;
    Node localNode2 = paramNode.right;
    Node localNode3 = localNode1.left;
    Node localNode4 = localNode1.right;
    paramNode.left = localNode4;
    if (localNode4 != null)
      localNode4.parent = paramNode;
    replaceInParent(paramNode, localNode1);
    localNode1.right = paramNode;
    paramNode.parent = localNode1;
    int i;
    if (localNode2 != null)
    {
      i = localNode2.height;
      if (localNode4 == null)
        break label131;
    }
    label131: for (int j = localNode4.height; ; j = 0)
    {
      paramNode.height = (1 + Math.max(i, j));
      int k = paramNode.height;
      int m = 0;
      if (localNode3 != null)
        m = localNode3.height;
      localNode1.height = (1 + Math.max(k, m));
      return;
      i = 0;
      break;
    }
  }

  private Object writeReplace()
    throws ObjectStreamException
  {
    return new LinkedHashMap(this);
  }

  public void clear()
  {
    this.root = null;
    this.size = 0;
    this.modCount = (1 + this.modCount);
    Node localNode = this.header;
    localNode.prev = localNode;
    localNode.next = localNode;
  }

  public boolean containsKey(Object paramObject)
  {
    return findByObject(paramObject) != null;
  }

  public Set<Map.Entry<K, V>> entrySet()
  {
    EntrySet localEntrySet1 = this.entrySet;
    if (localEntrySet1 != null)
      return localEntrySet1;
    EntrySet localEntrySet2 = new EntrySet();
    this.entrySet = localEntrySet2;
    return localEntrySet2;
  }

  Node<K, V> find(K paramK, boolean paramBoolean)
  {
    Comparator localComparator = this.comparator;
    Object localObject1 = this.root;
    int i = 0;
    Comparable localComparable;
    if (localObject1 != null)
      if (localComparator == NATURAL_ORDER)
        localComparable = (Comparable)paramK;
    label86: Node localNode1;
    while (true)
    {
      if (localComparable != null);
      Object localObject2;
      for (i = localComparable.compareTo(((Node)localObject1).key); ; i = localComparator.compare(paramK, ((Node)localObject1).key))
      {
        if (i != 0)
          break label86;
        localObject2 = localObject1;
        return localObject2;
        localComparable = null;
        break;
      }
      if (i < 0);
      for (Node localNode3 = ((Node)localObject1).left; ; localNode3 = ((Node)localObject1).right)
      {
        if (localNode3 != null)
          break label178;
        localObject2 = null;
        if (!paramBoolean)
          break;
        localNode1 = this.header;
        if (localObject1 != null)
          break label233;
        if ((localComparator != NATURAL_ORDER) || ((paramK instanceof Comparable)))
          break label185;
        throw new ClassCastException(paramK.getClass().getName() + " is not Comparable");
      }
      label178: localObject1 = localNode3;
    }
    label185: Node localNode2 = new Node((Node)localObject1, paramK, localNode1, localNode1.prev);
    this.root = localNode2;
    this.size = (1 + this.size);
    this.modCount = (1 + this.modCount);
    return localNode2;
    label233: localNode2 = new Node((Node)localObject1, paramK, localNode1, localNode1.prev);
    if (i < 0)
      ((Node)localObject1).left = localNode2;
    while (true)
    {
      rebalance((Node)localObject1, true);
      break;
      ((Node)localObject1).right = localNode2;
    }
  }

  Node<K, V> findByEntry(Map.Entry<?, ?> paramEntry)
  {
    Node localNode = findByObject(paramEntry.getKey());
    if ((localNode != null) && (equal(localNode.value, paramEntry.getValue())));
    for (int i = 1; i != 0; i = 0)
      return localNode;
    return null;
  }

  Node<K, V> findByObject(Object paramObject)
  {
    Object localObject = null;
    if (paramObject != null);
    try
    {
      Node localNode = find(paramObject, false);
      localObject = localNode;
      return localObject;
    }
    catch (ClassCastException localClassCastException)
    {
    }
    return null;
  }

  public V get(Object paramObject)
  {
    Node localNode = findByObject(paramObject);
    if (localNode != null)
      return localNode.value;
    return null;
  }

  public Set<K> keySet()
  {
    KeySet localKeySet1 = this.keySet;
    if (localKeySet1 != null)
      return localKeySet1;
    KeySet localKeySet2 = new KeySet();
    this.keySet = localKeySet2;
    return localKeySet2;
  }

  public V put(K paramK, V paramV)
  {
    if (paramK == null)
      throw new NullPointerException("key == null");
    Node localNode = find(paramK, true);
    Object localObject = localNode.value;
    localNode.value = paramV;
    return localObject;
  }

  public V remove(Object paramObject)
  {
    Node localNode = removeInternalByKey(paramObject);
    if (localNode != null)
      return localNode.value;
    return null;
  }

  void removeInternal(Node<K, V> paramNode, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramNode.prev.next = paramNode.next;
      paramNode.next.prev = paramNode.prev;
    }
    Node localNode1 = paramNode.left;
    Node localNode2 = paramNode.right;
    Node localNode3 = paramNode.parent;
    if ((localNode1 != null) && (localNode2 != null))
    {
      if (localNode1.height > localNode2.height);
      for (Node localNode4 = localNode1.last(); ; localNode4 = localNode2.first())
      {
        removeInternal(localNode4, false);
        Node localNode5 = paramNode.left;
        int i = 0;
        if (localNode5 != null)
        {
          i = localNode5.height;
          localNode4.left = localNode5;
          localNode5.parent = localNode4;
          paramNode.left = null;
        }
        Node localNode6 = paramNode.right;
        int j = 0;
        if (localNode6 != null)
        {
          j = localNode6.height;
          localNode4.right = localNode6;
          localNode6.parent = localNode4;
          paramNode.right = null;
        }
        localNode4.height = (1 + Math.max(i, j));
        replaceInParent(paramNode, localNode4);
        return;
      }
    }
    if (localNode1 != null)
    {
      replaceInParent(paramNode, localNode1);
      paramNode.left = null;
    }
    while (true)
    {
      rebalance(localNode3, false);
      this.size = (-1 + this.size);
      this.modCount = (1 + this.modCount);
      return;
      if (localNode2 != null)
      {
        replaceInParent(paramNode, localNode2);
        paramNode.right = null;
      }
      else
      {
        replaceInParent(paramNode, null);
      }
    }
  }

  Node<K, V> removeInternalByKey(Object paramObject)
  {
    Node localNode = findByObject(paramObject);
    if (localNode != null)
      removeInternal(localNode, true);
    return localNode;
  }

  public int size()
  {
    return this.size;
  }

  class EntrySet extends AbstractSet<Map.Entry<K, V>>
  {
    EntrySet()
    {
    }

    public void clear()
    {
      LinkedTreeMap.this.clear();
    }

    public boolean contains(Object paramObject)
    {
      return ((paramObject instanceof Map.Entry)) && (LinkedTreeMap.this.findByEntry((Map.Entry)paramObject) != null);
    }

    public Iterator<Map.Entry<K, V>> iterator()
    {
      // Byte code:
      //   0: new 31	com/google/gson/internal/LinkedTreeMap$EntrySet$1
      //   3: dup
      //   4: aload_0
      //   5: invokespecial 34	com/google/gson/internal/LinkedTreeMap$EntrySet$1:<init>	(Lcom/google/gson/internal/LinkedTreeMap$EntrySet;)V
      //   8: areturn
    }

    public boolean remove(Object paramObject)
    {
      if (!(paramObject instanceof Map.Entry));
      LinkedTreeMap.Node localNode;
      do
      {
        return false;
        localNode = LinkedTreeMap.this.findByEntry((Map.Entry)paramObject);
      }
      while (localNode == null);
      LinkedTreeMap.this.removeInternal(localNode, true);
      return true;
    }

    public int size()
    {
      return LinkedTreeMap.this.size;
    }
  }

  class KeySet extends AbstractSet<K>
  {
    KeySet()
    {
    }

    public void clear()
    {
      LinkedTreeMap.this.clear();
    }

    public boolean contains(Object paramObject)
    {
      return LinkedTreeMap.this.containsKey(paramObject);
    }

    public Iterator<K> iterator()
    {
      // Byte code:
      //   0: new 28	com/google/gson/internal/LinkedTreeMap$KeySet$1
      //   3: dup
      //   4: aload_0
      //   5: invokespecial 31	com/google/gson/internal/LinkedTreeMap$KeySet$1:<init>	(Lcom/google/gson/internal/LinkedTreeMap$KeySet;)V
      //   8: areturn
    }

    public boolean remove(Object paramObject)
    {
      return LinkedTreeMap.this.removeInternalByKey(paramObject) != null;
    }

    public int size()
    {
      return LinkedTreeMap.this.size;
    }
  }

  private abstract class LinkedTreeMapIterator<T>
    implements Iterator<T>
  {
    int expectedModCount = LinkedTreeMap.this.modCount;
    LinkedTreeMap.Node<K, V> lastReturned = null;
    LinkedTreeMap.Node<K, V> next = LinkedTreeMap.this.header.next;

    private LinkedTreeMapIterator()
    {
    }

    public final boolean hasNext()
    {
      return this.next != LinkedTreeMap.this.header;
    }

    final LinkedTreeMap.Node<K, V> nextNode()
    {
      LinkedTreeMap.Node localNode = this.next;
      if (localNode == LinkedTreeMap.this.header)
        throw new NoSuchElementException();
      if (LinkedTreeMap.this.modCount != this.expectedModCount)
        throw new ConcurrentModificationException();
      this.next = localNode.next;
      this.lastReturned = localNode;
      return localNode;
    }

    public final void remove()
    {
      if (this.lastReturned == null)
        throw new IllegalStateException();
      LinkedTreeMap.this.removeInternal(this.lastReturned, true);
      this.lastReturned = null;
      this.expectedModCount = LinkedTreeMap.this.modCount;
    }
  }

  static final class Node<K, V>
    implements Map.Entry<K, V>
  {
    int height;
    final K key;
    Node<K, V> left;
    Node<K, V> next;
    Node<K, V> parent;
    Node<K, V> prev;
    Node<K, V> right;
    V value;

    Node()
    {
      this.key = null;
      this.prev = this;
      this.next = this;
    }

    Node(Node<K, V> paramNode1, K paramK, Node<K, V> paramNode2, Node<K, V> paramNode3)
    {
      this.parent = paramNode1;
      this.key = paramK;
      this.height = 1;
      this.next = paramNode2;
      this.prev = paramNode3;
      paramNode3.next = this;
      paramNode2.prev = this;
    }

    public boolean equals(Object paramObject)
    {
      boolean bool1 = paramObject instanceof Map.Entry;
      boolean bool2 = false;
      Map.Entry localEntry;
      if (bool1)
      {
        localEntry = (Map.Entry)paramObject;
        if (this.key != null)
          break label67;
        Object localObject2 = localEntry.getKey();
        bool2 = false;
        if (localObject2 == null)
        {
          if (this.value != null)
            break label93;
          Object localObject1 = localEntry.getValue();
          bool2 = false;
          if (localObject1 != null);
        }
      }
      while (true)
      {
        bool2 = true;
        label67: label93: boolean bool4;
        do
        {
          boolean bool3;
          do
          {
            return bool2;
            bool3 = this.key.equals(localEntry.getKey());
            bool2 = false;
          }
          while (!bool3);
          break;
          bool4 = this.value.equals(localEntry.getValue());
          bool2 = false;
        }
        while (!bool4);
      }
    }

    public Node<K, V> first()
    {
      Object localObject = this;
      for (Node localNode = ((Node)localObject).left; localNode != null; localNode = ((Node)localObject).left)
        localObject = localNode;
      return localObject;
    }

    public K getKey()
    {
      return this.key;
    }

    public V getValue()
    {
      return this.value;
    }

    public int hashCode()
    {
      int i;
      int j;
      if (this.key == null)
      {
        i = 0;
        Object localObject = this.value;
        j = 0;
        if (localObject != null)
          break label35;
      }
      while (true)
      {
        return i ^ j;
        i = this.key.hashCode();
        break;
        label35: j = this.value.hashCode();
      }
    }

    public Node<K, V> last()
    {
      Object localObject = this;
      for (Node localNode = ((Node)localObject).right; localNode != null; localNode = ((Node)localObject).right)
        localObject = localNode;
      return localObject;
    }

    public V setValue(V paramV)
    {
      Object localObject = this.value;
      this.value = paramV;
      return localObject;
    }

    public String toString()
    {
      return this.key + "=" + this.value;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.gson.internal.LinkedTreeMap
 * JD-Core Version:    0.6.2
 */