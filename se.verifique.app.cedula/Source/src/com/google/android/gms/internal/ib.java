package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class ib
  implements SafeParcelable
{
  public static final lk a = new lk();
  private final int b;
  private final HashMap c;
  private final ArrayList d;
  private final String e;

  ib(int paramInt, ArrayList paramArrayList, String paramString)
  {
    this.b = paramInt;
    this.d = null;
    this.c = a(paramArrayList);
    this.e = ((String)kx.a(paramString));
    a();
  }

  private static HashMap a(ArrayList paramArrayList)
  {
    HashMap localHashMap = new HashMap();
    int i = paramArrayList.size();
    for (int j = 0; j < i; j++)
    {
      ib.a locala = (ib.a)paramArrayList.get(j);
      localHashMap.put(locala.c, locala.a());
    }
    return localHashMap;
  }

  public HashMap a(String paramString)
  {
    return (HashMap)this.c.get(paramString);
  }

  public void a()
  {
    Iterator localIterator1 = this.c.keySet().iterator();
    while (localIterator1.hasNext())
    {
      String str = (String)localIterator1.next();
      HashMap localHashMap = (HashMap)this.c.get(str);
      Iterator localIterator2 = localHashMap.keySet().iterator();
      while (localIterator2.hasNext())
        ((hy.a)localHashMap.get((String)localIterator2.next())).a(this);
    }
  }

  int b()
  {
    return this.b;
  }

  ArrayList c()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.c.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localArrayList.add(new ib.a(str, (HashMap)this.c.get(str)));
    }
    return localArrayList;
  }

  public String d()
  {
    return this.e;
  }

  public int describeContents()
  {
    return 0;
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator1 = this.c.keySet().iterator();
    while (localIterator1.hasNext())
    {
      String str1 = (String)localIterator1.next();
      localStringBuilder.append(str1).append(":\n");
      HashMap localHashMap = (HashMap)this.c.get(str1);
      Iterator localIterator2 = localHashMap.keySet().iterator();
      while (localIterator2.hasNext())
      {
        String str2 = (String)localIterator2.next();
        localStringBuilder.append("  ").append(str2).append(": ");
        localStringBuilder.append(localHashMap.get(str2));
      }
    }
    return localStringBuilder.toString();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    lk.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ib
 * JD-Core Version:    0.6.0
 */