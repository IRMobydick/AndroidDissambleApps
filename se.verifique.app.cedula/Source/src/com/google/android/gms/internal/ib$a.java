package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class ib$a
  implements SafeParcelable
{
  public static final ll a = new ll();
  final int b;
  final String c;
  final ArrayList d;

  ib$a(int paramInt, String paramString, ArrayList paramArrayList)
  {
    this.b = paramInt;
    this.c = paramString;
    this.d = paramArrayList;
  }

  ib$a(String paramString, HashMap paramHashMap)
  {
    this.b = 1;
    this.c = paramString;
    this.d = a(paramHashMap);
  }

  private static ArrayList a(HashMap paramHashMap)
  {
    if (paramHashMap == null);
    ArrayList localArrayList;
    for (Object localObject = null; ; localObject = localArrayList)
    {
      return localObject;
      localArrayList = new ArrayList();
      Iterator localIterator = paramHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localArrayList.add(new ib.b(str, (hy.a)paramHashMap.get(str)));
      }
    }
  }

  HashMap a()
  {
    HashMap localHashMap = new HashMap();
    int i = this.d.size();
    for (int j = 0; j < i; j++)
    {
      ib.b localb = (ib.b)this.d.get(j);
      localHashMap.put(localb.c, localb.d);
    }
    return localHashMap;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ll.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ib.a
 * JD-Core Version:    0.6.0
 */