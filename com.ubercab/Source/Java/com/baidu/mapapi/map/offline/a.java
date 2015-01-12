package com.baidu.mapapi.map.offline;

import com.baidu.platform.comapi.map.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class a
  implements r
{
  a(MKOfflineMap paramMKOfflineMap)
  {
  }

  public void a(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    case 5:
    case 7:
    default:
    case 6:
    case 4:
      ArrayList localArrayList;
      do
      {
        return;
        MKOfflineMap.a(this.a).onGetOfflineMapState(6, paramInt2);
        return;
        localArrayList = this.a.getAllUpdateInfo();
      }
      while (localArrayList == null);
      Iterator localIterator = localArrayList.iterator();
      while (localIterator.hasNext())
      {
        MKOLUpdateElement localMKOLUpdateElement = (MKOLUpdateElement)localIterator.next();
        if (localMKOLUpdateElement.update)
          MKOfflineMap.a(this.a).onGetOfflineMapState(4, localMKOLUpdateElement.cityID);
      }
    case 8:
    }
    int i = 0xFFFF & paramInt2 >> 16;
    MKOfflineMap.a(this.a).onGetOfflineMapState(0, i);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.mapapi.map.offline.a
 * JD-Core Version:    0.6.2
 */