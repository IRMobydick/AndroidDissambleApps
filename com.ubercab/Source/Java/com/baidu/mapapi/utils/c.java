package com.baidu.mapapi.utils;

import com.baidu.mapapi.map.offline.MKOLSearchRecord;
import com.baidu.mapapi.map.offline.MKOLUpdateElement;
import com.baidu.mapapi.model.a;
import com.baidu.platform.comapi.a.b;
import com.baidu.platform.comapi.a.d;
import com.baidu.platform.comapi.map.m;
import com.baidu.platform.comapi.map.p;
import java.util.ArrayList;
import java.util.Iterator;

public class c
{
  public static MKOLSearchRecord a(m paramm)
  {
    if (paramm == null)
      return null;
    MKOLSearchRecord localMKOLSearchRecord = new MKOLSearchRecord();
    localMKOLSearchRecord.cityID = paramm.a;
    localMKOLSearchRecord.cityName = paramm.b;
    localMKOLSearchRecord.cityType = paramm.d;
    if (paramm.a() != null)
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = paramm.a().iterator();
      int j;
      for (i = 0; localIterator.hasNext(); i = j)
      {
        m localm = (m)localIterator.next();
        localArrayList.add(a(localm));
        j = i + localm.c;
        localMKOLSearchRecord.childCities = localArrayList;
      }
    }
    int i = 0;
    if (localMKOLSearchRecord.cityType == 1);
    for (localMKOLSearchRecord.size = i; ; localMKOLSearchRecord.size = paramm.c)
      return localMKOLSearchRecord;
  }

  public static MKOLUpdateElement a(p paramp)
  {
    if (paramp == null)
      return null;
    MKOLUpdateElement localMKOLUpdateElement = new MKOLUpdateElement();
    localMKOLUpdateElement.cityID = paramp.a;
    localMKOLUpdateElement.cityName = paramp.b;
    if (paramp.g != null)
      localMKOLUpdateElement.geoPt = a.a(new b(paramp.g.b(), paramp.g.a()));
    localMKOLUpdateElement.level = paramp.e;
    localMKOLUpdateElement.ratio = paramp.i;
    localMKOLUpdateElement.serversize = paramp.h;
    if (paramp.i == 100);
    for (localMKOLUpdateElement.size = paramp.h; ; localMKOLUpdateElement.size = (paramp.h * paramp.i / 100))
    {
      localMKOLUpdateElement.status = paramp.l;
      localMKOLUpdateElement.update = paramp.j;
      return localMKOLUpdateElement;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.mapapi.utils.c
 * JD-Core Version:    0.6.2
 */