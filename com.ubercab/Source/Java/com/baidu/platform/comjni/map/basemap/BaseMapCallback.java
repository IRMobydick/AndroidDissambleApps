package com.baidu.platform.comjni.map.basemap;

import android.os.Bundle;
import android.util.SparseArray;

public class BaseMapCallback
{
  private static SparseArray<b> a = new SparseArray();

  public static int ReqLayerData(Bundle paramBundle1, int paramInt1, int paramInt2, Bundle paramBundle2)
  {
    int i = a.size();
    for (int j = 0; j < i; j++)
    {
      b localb = (b)a.valueAt(j);
      if ((localb != null) && (localb.a(paramInt1)))
        return localb.a(paramBundle1, paramInt1, paramInt2, paramBundle2);
    }
    return 0;
  }

  public static void addLayerDataInterface(int paramInt, b paramb)
  {
    a.put(paramInt, paramb);
  }

  public static void removeLayerDataInterface(int paramInt)
  {
    a.remove(paramInt);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.platform.comjni.map.basemap.BaseMapCallback
 * JD-Core Version:    0.6.2
 */