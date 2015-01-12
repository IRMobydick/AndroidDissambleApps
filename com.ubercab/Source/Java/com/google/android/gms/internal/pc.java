package com.google.android.gms.internal;

import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.DataMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class pc
{
  private static int a(String paramString, pd.a.a[] paramArrayOfa)
  {
    int i = paramArrayOfa.length;
    int j = 0;
    int k = 14;
    if (j < i)
    {
      pd.a.a locala = paramArrayOfa[j];
      if (k == 14)
        if ((locala.type == 9) || (locala.type == 2) || (locala.type == 6))
          k = locala.type;
      while (locala.type == k)
      {
        do
        {
          j++;
          break;
        }
        while (locala.type == 14);
        throw new IllegalArgumentException("Unexpected TypedValue type: " + locala.type + " for key " + paramString);
      }
      throw new IllegalArgumentException("The ArrayList elements should all be the same type, but ArrayList with key " + paramString + " contains items of type " + k + " and " + locala.type);
    }
    return k;
  }

  static int a(List<Asset> paramList, Asset paramAsset)
  {
    paramList.add(paramAsset);
    return -1 + paramList.size();
  }

  public static a a(DataMap paramDataMap)
  {
    pd localpd = new pd();
    ArrayList localArrayList = new ArrayList();
    localpd.awd = a(paramDataMap, localArrayList);
    return new a(localpd, localArrayList);
  }

  private static pd.a.a a(List<Asset> paramList, Object paramObject)
  {
    pd.a.a locala1 = new pd.a.a();
    if (paramObject == null)
    {
      locala1.type = 14;
      return locala1;
    }
    locala1.awh = new pd.a.a.a();
    if ((paramObject instanceof String))
    {
      locala1.type = 2;
      locala1.awh.awj = ((String)paramObject);
    }
    while (true)
    {
      return locala1;
      if ((paramObject instanceof Integer))
      {
        locala1.type = 6;
        locala1.awh.awn = ((Integer)paramObject).intValue();
      }
      else if ((paramObject instanceof Long))
      {
        locala1.type = 5;
        locala1.awh.awm = ((Long)paramObject).longValue();
      }
      else if ((paramObject instanceof Double))
      {
        locala1.type = 3;
        locala1.awh.awk = ((Double)paramObject).doubleValue();
      }
      else if ((paramObject instanceof Float))
      {
        locala1.type = 4;
        locala1.awh.awl = ((Float)paramObject).floatValue();
      }
      else if ((paramObject instanceof Boolean))
      {
        locala1.type = 8;
        locala1.awh.awp = ((Boolean)paramObject).booleanValue();
      }
      else if ((paramObject instanceof Byte))
      {
        locala1.type = 7;
        locala1.awh.awo = ((Byte)paramObject).byteValue();
      }
      else if ((paramObject instanceof byte[]))
      {
        locala1.type = 1;
        locala1.awh.awi = ((byte[])paramObject);
      }
      else if ((paramObject instanceof String[]))
      {
        locala1.type = 11;
        locala1.awh.aws = ((String[])paramObject);
      }
      else if ((paramObject instanceof long[]))
      {
        locala1.type = 12;
        locala1.awh.awt = ((long[])paramObject);
      }
      else if ((paramObject instanceof float[]))
      {
        locala1.type = 15;
        locala1.awh.awu = ((float[])paramObject);
      }
      else if ((paramObject instanceof Asset))
      {
        locala1.type = 13;
        locala1.awh.awv = a(paramList, (Asset)paramObject);
      }
      else
      {
        if (!(paramObject instanceof DataMap))
          break;
        locala1.type = 9;
        DataMap localDataMap = (DataMap)paramObject;
        Set localSet = localDataMap.keySet();
        pd.a[] arrayOfa1 = new pd.a[localSet.size()];
        Iterator localIterator = localSet.iterator();
        for (int n = 0; localIterator.hasNext(); n++)
        {
          String str = (String)localIterator.next();
          arrayOfa1[n] = new pd.a();
          arrayOfa1[n].name = str;
          arrayOfa1[n].awf = a(paramList, localDataMap.get(str));
        }
        locala1.awh.awq = arrayOfa1;
      }
    }
    pd.a.a[] arrayOfa;
    Object localObject1;
    int j;
    int k;
    label558: Object localObject2;
    pd.a.a locala2;
    if ((paramObject instanceof ArrayList))
    {
      locala1.type = 10;
      ArrayList localArrayList = (ArrayList)paramObject;
      arrayOfa = new pd.a.a[localArrayList.size()];
      localObject1 = null;
      int i = localArrayList.size();
      j = 0;
      k = 14;
      if (j < i)
      {
        localObject2 = localArrayList.get(j);
        locala2 = a(paramList, localObject2);
        if ((locala2.type != 14) && (locala2.type != 2) && (locala2.type != 6) && (locala2.type != 9))
          throw new IllegalArgumentException("The only ArrayList element types supported by DataBundleUtil are String, Integer, Bundle, and null, but this ArrayList contains a " + localObject2.getClass());
        if ((k != 14) || (locala2.type == 14));
      }
    }
    for (int m = locala2.type; ; m = k)
    {
      arrayOfa[j] = locala2;
      j++;
      k = m;
      localObject1 = localObject2;
      break label558;
      if (locala2.type != k)
      {
        throw new IllegalArgumentException("ArrayList elements must all be of the sameclass, but this one contains a " + localObject1.getClass() + " and a " + localObject2.getClass());
        locala1.awh.awr = arrayOfa;
        break;
        throw new RuntimeException("newFieldValueFromValue: unexpected value " + paramObject.getClass().getSimpleName());
      }
      localObject2 = localObject1;
    }
  }

  public static DataMap a(a parama)
  {
    DataMap localDataMap = new DataMap();
    for (pd.a locala : parama.awb.awd)
      a(parama.awc, localDataMap, locala.name, locala.awf);
    return localDataMap;
  }

  private static ArrayList a(List<Asset> paramList, pd.a.a.a parama, int paramInt)
  {
    ArrayList localArrayList = new ArrayList(parama.awr.length);
    pd.a.a[] arrayOfa = parama.awr;
    int i = arrayOfa.length;
    int j = 0;
    if (j < i)
    {
      pd.a.a locala = arrayOfa[j];
      if (locala.type == 14)
        localArrayList.add(null);
      while (true)
      {
        j++;
        break;
        if (paramInt == 9)
        {
          DataMap localDataMap = new DataMap();
          for (pd.a locala1 : locala.awh.awq)
            a(paramList, localDataMap, locala1.name, locala1.awf);
          localArrayList.add(localDataMap);
        }
        else if (paramInt == 2)
        {
          localArrayList.add(locala.awh.awj);
        }
        else
        {
          if (paramInt != 6)
            break label188;
          localArrayList.add(Integer.valueOf(locala.awh.awn));
        }
      }
      label188: throw new IllegalArgumentException("Unexpected typeOfArrayList: " + paramInt);
    }
    return localArrayList;
  }

  private static void a(List<Asset> paramList, DataMap paramDataMap, String paramString, pd.a.a parama)
  {
    int i = parama.type;
    if (i == 14)
    {
      paramDataMap.putString(paramString, null);
      return;
    }
    pd.a.a.a locala = parama.awh;
    if (i == 1)
    {
      paramDataMap.putByteArray(paramString, locala.awi);
      return;
    }
    if (i == 11)
    {
      paramDataMap.putStringArray(paramString, locala.aws);
      return;
    }
    if (i == 12)
    {
      paramDataMap.putLongArray(paramString, locala.awt);
      return;
    }
    if (i == 15)
    {
      paramDataMap.putFloatArray(paramString, locala.awu);
      return;
    }
    if (i == 2)
    {
      paramDataMap.putString(paramString, locala.awj);
      return;
    }
    if (i == 3)
    {
      paramDataMap.putDouble(paramString, locala.awk);
      return;
    }
    if (i == 4)
    {
      paramDataMap.putFloat(paramString, locala.awl);
      return;
    }
    if (i == 5)
    {
      paramDataMap.putLong(paramString, locala.awm);
      return;
    }
    if (i == 6)
    {
      paramDataMap.putInt(paramString, locala.awn);
      return;
    }
    if (i == 7)
    {
      paramDataMap.putByte(paramString, (byte)locala.awo);
      return;
    }
    if (i == 8)
    {
      paramDataMap.putBoolean(paramString, locala.awp);
      return;
    }
    if (i == 13)
    {
      if (paramList == null)
        throw new RuntimeException("populateBundle: unexpected type for: " + paramString);
      paramDataMap.putAsset(paramString, (Asset)paramList.get((int)locala.awv));
      return;
    }
    if (i == 9)
    {
      DataMap localDataMap = new DataMap();
      for (pd.a locala1 : locala.awq)
        a(paramList, localDataMap, locala1.name, locala1.awf);
      paramDataMap.putDataMap(paramString, localDataMap);
      return;
    }
    if (i == 10)
    {
      int m = a(paramString, locala.awr);
      ArrayList localArrayList = a(paramList, locala, m);
      if (m == 14)
      {
        paramDataMap.putStringArrayList(paramString, localArrayList);
        return;
      }
      if (m == 9)
      {
        paramDataMap.putDataMapArrayList(paramString, localArrayList);
        return;
      }
      if (m == 2)
      {
        paramDataMap.putStringArrayList(paramString, localArrayList);
        return;
      }
      if (m == 6)
      {
        paramDataMap.putIntegerArrayList(paramString, localArrayList);
        return;
      }
      throw new IllegalStateException("Unexpected typeOfArrayList: " + m);
    }
    throw new RuntimeException("populateBundle: unexpected type " + i);
  }

  private static pd.a[] a(DataMap paramDataMap, List<Asset> paramList)
  {
    Set localSet = paramDataMap.keySet();
    pd.a[] arrayOfa = new pd.a[localSet.size()];
    Iterator localIterator = localSet.iterator();
    for (int i = 0; localIterator.hasNext(); i++)
    {
      String str = (String)localIterator.next();
      Object localObject = paramDataMap.get(str);
      arrayOfa[i] = new pd.a();
      arrayOfa[i].name = str;
      arrayOfa[i].awf = a(paramList, localObject);
    }
    return arrayOfa;
  }

  public static class a
  {
    public final pd awb;
    public final List<Asset> awc;

    public a(pd parampd, List<Asset> paramList)
    {
      this.awb = parampd;
      this.awc = paramList;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.pc
 * JD-Core Version:    0.6.2
 */