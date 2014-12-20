package android.support.v4.util;

import java.util.Map;

public class SimpleArrayMap<K, V>
{
  private static final int BASE_SIZE = 4;
  private static final int CACHE_SIZE = 10;
  private static final boolean DEBUG = false;
  private static final String TAG = "ArrayMap";
  static Object[] mBaseCache;
  static int mBaseCacheSize;
  static Object[] mTwiceBaseCache;
  static int mTwiceBaseCacheSize;
  Object[] mArray;
  int[] mHashes;
  int mSize;

  public SimpleArrayMap()
  {
    this.mHashes = ContainerHelpers.EMPTY_INTS;
    this.mArray = ContainerHelpers.EMPTY_OBJECTS;
    this.mSize = 0;
  }

  public SimpleArrayMap(int paramInt)
  {
    if (paramInt == 0)
    {
      this.mHashes = ContainerHelpers.EMPTY_INTS;
      this.mArray = ContainerHelpers.EMPTY_OBJECTS;
    }
    while (true)
    {
      this.mSize = 0;
      return;
      allocArrays(paramInt);
    }
  }

  public SimpleArrayMap(SimpleArrayMap paramSimpleArrayMap)
  {
    this();
    if (paramSimpleArrayMap != null)
      putAll(paramSimpleArrayMap);
  }

  // ERROR //
  private void allocArrays(int paramInt)
  {
    // Byte code:
    //   0: iload_1
    //   1: bipush 8
    //   3: if_icmpne +106 -> 109
    //   6: ldc 55
    //   8: monitorenter
    //   9: getstatic 57	android/support/v4/util/SimpleArrayMap:mTwiceBaseCache	[Ljava/lang/Object;
    //   12: ifnull +66 -> 78
    //   15: getstatic 57	android/support/v4/util/SimpleArrayMap:mTwiceBaseCache	[Ljava/lang/Object;
    //   18: astore 5
    //   20: aload_0
    //   21: aload 5
    //   23: putfield 42	android/support/v4/util/SimpleArrayMap:mArray	[Ljava/lang/Object;
    //   26: aload 5
    //   28: iconst_0
    //   29: aaload
    //   30: checkcast 58	[Ljava/lang/Object;
    //   33: checkcast 58	[Ljava/lang/Object;
    //   36: putstatic 57	android/support/v4/util/SimpleArrayMap:mTwiceBaseCache	[Ljava/lang/Object;
    //   39: aload_0
    //   40: aload 5
    //   42: iconst_1
    //   43: aaload
    //   44: checkcast 59	[I
    //   47: checkcast 59	[I
    //   50: putfield 37	android/support/v4/util/SimpleArrayMap:mHashes	[I
    //   53: aload 5
    //   55: iconst_1
    //   56: aconst_null
    //   57: aastore
    //   58: aload 5
    //   60: iconst_0
    //   61: aconst_null
    //   62: aastore
    //   63: bipush 255
    //   65: getstatic 61	android/support/v4/util/SimpleArrayMap:mTwiceBaseCacheSize	I
    //   68: iadd
    //   69: putstatic 61	android/support/v4/util/SimpleArrayMap:mTwiceBaseCacheSize	I
    //   72: ldc 55
    //   74: monitorexit
    //   75: goto +117 -> 192
    //   78: ldc 55
    //   80: monitorexit
    //   81: aload_0
    //   82: iload_1
    //   83: newarray int
    //   85: putfield 37	android/support/v4/util/SimpleArrayMap:mHashes	[I
    //   88: aload_0
    //   89: iload_1
    //   90: iconst_1
    //   91: ishl
    //   92: anewarray 5	java/lang/Object
    //   95: putfield 42	android/support/v4/util/SimpleArrayMap:mArray	[Ljava/lang/Object;
    //   98: goto +94 -> 192
    //   101: astore 4
    //   103: ldc 55
    //   105: monitorexit
    //   106: aload 4
    //   108: athrow
    //   109: iload_1
    //   110: iconst_4
    //   111: if_icmpne -30 -> 81
    //   114: ldc 55
    //   116: monitorenter
    //   117: getstatic 63	android/support/v4/util/SimpleArrayMap:mBaseCache	[Ljava/lang/Object;
    //   120: ifnull +66 -> 186
    //   123: getstatic 63	android/support/v4/util/SimpleArrayMap:mBaseCache	[Ljava/lang/Object;
    //   126: astore_3
    //   127: aload_0
    //   128: aload_3
    //   129: putfield 42	android/support/v4/util/SimpleArrayMap:mArray	[Ljava/lang/Object;
    //   132: aload_3
    //   133: iconst_0
    //   134: aaload
    //   135: checkcast 58	[Ljava/lang/Object;
    //   138: checkcast 58	[Ljava/lang/Object;
    //   141: putstatic 63	android/support/v4/util/SimpleArrayMap:mBaseCache	[Ljava/lang/Object;
    //   144: aload_0
    //   145: aload_3
    //   146: iconst_1
    //   147: aaload
    //   148: checkcast 59	[I
    //   151: checkcast 59	[I
    //   154: putfield 37	android/support/v4/util/SimpleArrayMap:mHashes	[I
    //   157: aload_3
    //   158: iconst_1
    //   159: aconst_null
    //   160: aastore
    //   161: aload_3
    //   162: iconst_0
    //   163: aconst_null
    //   164: aastore
    //   165: bipush 255
    //   167: getstatic 65	android/support/v4/util/SimpleArrayMap:mBaseCacheSize	I
    //   170: iadd
    //   171: putstatic 65	android/support/v4/util/SimpleArrayMap:mBaseCacheSize	I
    //   174: ldc 55
    //   176: monitorexit
    //   177: goto +15 -> 192
    //   180: astore_2
    //   181: ldc 55
    //   183: monitorexit
    //   184: aload_2
    //   185: athrow
    //   186: ldc 55
    //   188: monitorexit
    //   189: goto -108 -> 81
    //   192: return
    //
    // Exception table:
    //   from	to	target	type
    //   9	81	101	finally
    //   103	106	101	finally
    //   117	184	180	finally
    //   186	189	180	finally
  }

  private static void freeArrays(int[] paramArrayOfInt, Object[] paramArrayOfObject, int paramInt)
  {
    if (paramArrayOfInt.length == 8)
    {
      monitorenter;
      try
      {
        if (mTwiceBaseCacheSize < 10)
        {
          paramArrayOfObject[0] = mTwiceBaseCache;
          paramArrayOfObject[1] = paramArrayOfInt;
          for (int j = -1 + (paramInt << 1); j >= 2; j--)
            paramArrayOfObject[j] = null;
          mTwiceBaseCache = paramArrayOfObject;
          mTwiceBaseCacheSize = 1 + mTwiceBaseCacheSize;
        }
        monitorexit;
        return;
      }
      finally
      {
        localObject2 = finally;
        monitorexit;
        throw localObject2;
      }
    }
    else if (paramArrayOfInt.length == 4)
    {
      monitorenter;
      try
      {
        if (mBaseCacheSize < 10)
        {
          paramArrayOfObject[0] = mBaseCache;
          paramArrayOfObject[1] = paramArrayOfInt;
          for (int i = -1 + (paramInt << 1); i >= 2; i--)
            paramArrayOfObject[i] = null;
          mBaseCache = paramArrayOfObject;
          mBaseCacheSize = 1 + mBaseCacheSize;
        }
        monitorexit;
      }
      finally
      {
        localObject1 = finally;
        monitorexit;
        throw localObject1;
      }
    }
  }

  public void clear()
  {
    if (this.mSize != 0)
    {
      freeArrays(this.mHashes, this.mArray, this.mSize);
      this.mHashes = ContainerHelpers.EMPTY_INTS;
      this.mArray = ContainerHelpers.EMPTY_OBJECTS;
      this.mSize = 0;
    }
  }

  public boolean containsKey(Object paramObject)
  {
    int i = 1;
    if (paramObject == null)
      if (indexOfNull() < 0);
    while (true)
    {
      return i;
      i = 0;
      continue;
      if (indexOf(paramObject, paramObject.hashCode()) >= 0)
        continue;
      i = 0;
    }
  }

  public boolean containsValue(Object paramObject)
  {
    if (indexOfValue(paramObject) >= 0);
    for (int i = 1; ; i = 0)
      return i;
  }

  public void ensureCapacity(int paramInt)
  {
    if (this.mHashes.length < paramInt)
    {
      int[] arrayOfInt = this.mHashes;
      Object[] arrayOfObject = this.mArray;
      allocArrays(paramInt);
      if (this.mSize > 0)
      {
        System.arraycopy(arrayOfInt, 0, this.mHashes, 0, this.mSize);
        System.arraycopy(arrayOfObject, 0, this.mArray, 0, this.mSize << 1);
      }
      freeArrays(arrayOfInt, arrayOfObject, this.mSize);
    }
  }

  public boolean equals(Object paramObject)
  {
    int i = 1;
    if (this == paramObject);
    while (true)
    {
      return i;
      if ((paramObject instanceof Map))
      {
        Map localMap = (Map)paramObject;
        if (size() != localMap.size())
        {
          i = 0;
          continue;
        }
        int j = 0;
        try
        {
          while (j < this.mSize)
          {
            Object localObject1 = keyAt(j);
            Object localObject2 = valueAt(j);
            Object localObject3 = localMap.get(localObject1);
            if (localObject2 == null)
            {
              if (localObject3 != null)
                break label145;
              if (!localMap.containsKey(localObject1))
                break label145;
            }
            else
            {
              boolean bool = localObject2.equals(localObject3);
              if (!bool)
              {
                i = 0;
                break;
              }
            }
            j++;
          }
        }
        catch (NullPointerException localNullPointerException)
        {
          i = 0;
        }
        catch (ClassCastException localClassCastException)
        {
          i = 0;
        }
        continue;
      }
      i = 0;
      continue;
      label145: i = 0;
    }
  }

  public V get(Object paramObject)
  {
    int i;
    if (paramObject == null)
    {
      i = indexOfNull();
      if (i < 0)
        break label39;
    }
    label39: for (Object localObject = this.mArray[(1 + (i << 1))]; ; localObject = null)
    {
      return localObject;
      i = indexOf(paramObject, paramObject.hashCode());
      break;
    }
  }

  public int hashCode()
  {
    int[] arrayOfInt = this.mHashes;
    Object[] arrayOfObject = this.mArray;
    int i = 0;
    int j = 0;
    int k = 1;
    int m = this.mSize;
    if (j < m)
    {
      Object localObject = arrayOfObject[k];
      int n = arrayOfInt[j];
      if (localObject == null);
      for (int i1 = 0; ; i1 = localObject.hashCode())
      {
        i += (i1 ^ n);
        j++;
        k += 2;
        break;
      }
    }
    return i;
  }

  int indexOf(Object paramObject, int paramInt)
  {
    int i = this.mSize;
    int j;
    if (i == 0)
      j = -1;
    while (true)
    {
      return j;
      j = ContainerHelpers.binarySearch(this.mHashes, i, paramInt);
      if ((j < 0) || (paramObject.equals(this.mArray[(j << 1)])))
        continue;
      for (int k = j + 1; ; k++)
      {
        if ((k >= i) || (this.mHashes[k] != paramInt))
          break label100;
        if (!paramObject.equals(this.mArray[(k << 1)]))
          continue;
        j = k;
        break;
      }
      label100: for (int m = j - 1; ; m--)
      {
        if ((m < 0) || (this.mHashes[m] != paramInt))
          break label151;
        if (!paramObject.equals(this.mArray[(m << 1)]))
          continue;
        j = m;
        break;
      }
      label151: j = k ^ 0xFFFFFFFF;
    }
  }

  int indexOfNull()
  {
    int i = this.mSize;
    int j;
    if (i == 0)
      j = -1;
    while (true)
    {
      return j;
      j = ContainerHelpers.binarySearch(this.mHashes, i, 0);
      if ((j < 0) || (this.mArray[(j << 1)] == null))
        continue;
      for (int k = j + 1; ; k++)
      {
        if ((k >= i) || (this.mHashes[k] != 0))
          break label79;
        if (this.mArray[(k << 1)] != null)
          continue;
        j = k;
        break;
      }
      label79: for (int m = j - 1; ; m--)
      {
        if ((m < 0) || (this.mHashes[m] != 0))
          break label123;
        if (this.mArray[(m << 1)] != null)
          continue;
        j = m;
        break;
      }
      label123: j = k ^ 0xFFFFFFFF;
    }
  }

  int indexOfValue(Object paramObject)
  {
    int i = 2 * this.mSize;
    Object[] arrayOfObject = this.mArray;
    int m;
    int k;
    if (paramObject == null)
    {
      m = 1;
      if (m >= i)
        break label82;
      if (arrayOfObject[m] == null)
        k = m >> 1;
    }
    while (true)
    {
      return k;
      m += 2;
      break;
      for (int j = 1; ; j += 2)
      {
        if (j >= i)
          break label82;
        if (!paramObject.equals(arrayOfObject[j]))
          continue;
        k = j >> 1;
        break;
      }
      label82: k = -1;
    }
  }

  public boolean isEmpty()
  {
    if (this.mSize <= 0);
    for (int i = 1; ; i = 0)
      return i;
  }

  public K keyAt(int paramInt)
  {
    return this.mArray[(paramInt << 1)];
  }

  public V put(K paramK, V paramV)
  {
    int i = 8;
    int j;
    if (paramK == null)
      j = 0;
    Object localObject;
    for (int k = indexOfNull(); k >= 0; k = indexOf(paramK, j))
    {
      int n = 1 + (k << 1);
      localObject = this.mArray[n];
      this.mArray[n] = paramV;
      return localObject;
      j = paramK.hashCode();
    }
    int m = k ^ 0xFFFFFFFF;
    if (this.mSize >= this.mHashes.length)
    {
      if (this.mSize < i)
        break label280;
      i = this.mSize + (this.mSize >> 1);
    }
    while (true)
    {
      int[] arrayOfInt = this.mHashes;
      Object[] arrayOfObject = this.mArray;
      allocArrays(i);
      if (this.mHashes.length > 0)
      {
        System.arraycopy(arrayOfInt, 0, this.mHashes, 0, arrayOfInt.length);
        System.arraycopy(arrayOfObject, 0, this.mArray, 0, arrayOfObject.length);
      }
      freeArrays(arrayOfInt, arrayOfObject, this.mSize);
      if (m < this.mSize)
      {
        System.arraycopy(this.mHashes, m, this.mHashes, m + 1, this.mSize - m);
        System.arraycopy(this.mArray, m << 1, this.mArray, m + 1 << 1, this.mSize - m << 1);
      }
      this.mHashes[m] = j;
      this.mArray[(m << 1)] = paramK;
      this.mArray[(1 + (m << 1))] = paramV;
      this.mSize = (1 + this.mSize);
      localObject = null;
      break;
      label280: if (this.mSize >= 4)
        continue;
      i = 4;
    }
  }

  public void putAll(SimpleArrayMap<? extends K, ? extends V> paramSimpleArrayMap)
  {
    int i = paramSimpleArrayMap.mSize;
    ensureCapacity(i + this.mSize);
    if (this.mSize == 0)
      if (i > 0)
      {
        System.arraycopy(paramSimpleArrayMap.mHashes, 0, this.mHashes, 0, i);
        System.arraycopy(paramSimpleArrayMap.mArray, 0, this.mArray, 0, i << 1);
        this.mSize = i;
      }
    while (true)
    {
      return;
      for (int j = 0; j < i; j++)
        put(paramSimpleArrayMap.keyAt(j), paramSimpleArrayMap.valueAt(j));
    }
  }

  public V remove(Object paramObject)
  {
    int i;
    if (paramObject == null)
    {
      i = indexOfNull();
      if (i < 0)
        break label34;
    }
    label34: for (Object localObject = removeAt(i); ; localObject = null)
    {
      return localObject;
      i = indexOf(paramObject, paramObject.hashCode());
      break;
    }
  }

  public V removeAt(int paramInt)
  {
    int i = 8;
    Object localObject = this.mArray[(1 + (paramInt << 1))];
    if (this.mSize <= 1)
    {
      freeArrays(this.mHashes, this.mArray, this.mSize);
      this.mHashes = ContainerHelpers.EMPTY_INTS;
      this.mArray = ContainerHelpers.EMPTY_OBJECTS;
      this.mSize = 0;
    }
    while (true)
    {
      return localObject;
      if ((this.mHashes.length > i) && (this.mSize < this.mHashes.length / 3))
      {
        if (this.mSize > i)
          i = this.mSize + (this.mSize >> 1);
        int[] arrayOfInt = this.mHashes;
        Object[] arrayOfObject = this.mArray;
        allocArrays(i);
        this.mSize = (-1 + this.mSize);
        if (paramInt > 0)
        {
          System.arraycopy(arrayOfInt, 0, this.mHashes, 0, paramInt);
          System.arraycopy(arrayOfObject, 0, this.mArray, 0, paramInt << 1);
        }
        if (paramInt >= this.mSize)
          continue;
        System.arraycopy(arrayOfInt, paramInt + 1, this.mHashes, paramInt, this.mSize - paramInt);
        System.arraycopy(arrayOfObject, paramInt + 1 << 1, this.mArray, paramInt << 1, this.mSize - paramInt << 1);
        continue;
      }
      this.mSize = (-1 + this.mSize);
      if (paramInt < this.mSize)
      {
        System.arraycopy(this.mHashes, paramInt + 1, this.mHashes, paramInt, this.mSize - paramInt);
        System.arraycopy(this.mArray, paramInt + 1 << 1, this.mArray, paramInt << 1, this.mSize - paramInt << 1);
      }
      this.mArray[(this.mSize << 1)] = null;
      this.mArray[(1 + (this.mSize << 1))] = null;
    }
  }

  public V setValueAt(int paramInt, V paramV)
  {
    int i = 1 + (paramInt << 1);
    Object localObject = this.mArray[i];
    this.mArray[i] = paramV;
    return localObject;
  }

  public int size()
  {
    return this.mSize;
  }

  public String toString()
  {
    if (isEmpty());
    StringBuilder localStringBuilder;
    for (String str = "{}"; ; str = localStringBuilder.toString())
    {
      return str;
      localStringBuilder = new StringBuilder(28 * this.mSize);
      localStringBuilder.append('{');
      int i = 0;
      if (i < this.mSize)
      {
        if (i > 0)
          localStringBuilder.append(", ");
        Object localObject1 = keyAt(i);
        if (localObject1 != this)
        {
          localStringBuilder.append(localObject1);
          label77: localStringBuilder.append('=');
          Object localObject2 = valueAt(i);
          if (localObject2 == this)
            break label120;
          localStringBuilder.append(localObject2);
        }
        while (true)
        {
          i++;
          break;
          localStringBuilder.append("(this Map)");
          break label77;
          label120: localStringBuilder.append("(this Map)");
        }
      }
      localStringBuilder.append('}');
    }
  }

  public V valueAt(int paramInt)
  {
    return this.mArray[(1 + (paramInt << 1))];
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.util.SimpleArrayMap
 * JD-Core Version:    0.6.0
 */