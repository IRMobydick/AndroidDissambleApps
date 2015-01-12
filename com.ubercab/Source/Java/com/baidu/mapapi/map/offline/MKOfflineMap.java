package com.baidu.mapapi.map.offline;

import com.baidu.mapapi.utils.c;
import com.baidu.platform.comapi.map.m;
import com.baidu.platform.comapi.map.n;
import com.baidu.platform.comapi.map.p;
import com.baidu.platform.comapi.map.q;
import java.util.ArrayList;
import java.util.Iterator;

public class MKOfflineMap
{
  public static final int TYPE_DOWNLOAD_UPDATE = 0;
  public static final int TYPE_NEW_OFFLINE = 6;
  public static final int TYPE_VER_UPDATE = 4;
  private static final String a = MKOfflineMap.class.getSimpleName();
  private n b;
  private MKOfflineMapListener c;

  public void destroy()
  {
    this.b.d(0);
    this.b.b(null);
    this.b.b();
    com.baidu.mapapi.a.a().c();
  }

  public ArrayList<MKOLUpdateElement> getAllUpdateInfo()
  {
    ArrayList localArrayList1 = this.b.e();
    if (localArrayList1 == null)
      return null;
    ArrayList localArrayList2 = new ArrayList();
    Iterator localIterator = localArrayList1.iterator();
    while (localIterator.hasNext())
      localArrayList2.add(c.a(((q)localIterator.next()).a()));
    return localArrayList2;
  }

  public ArrayList<MKOLSearchRecord> getHotCityList()
  {
    ArrayList localArrayList1 = this.b.c();
    if (localArrayList1 == null)
      return null;
    ArrayList localArrayList2 = new ArrayList();
    Iterator localIterator = localArrayList1.iterator();
    while (localIterator.hasNext())
      localArrayList2.add(c.a((m)localIterator.next()));
    return localArrayList2;
  }

  public ArrayList<MKOLSearchRecord> getOfflineCityList()
  {
    ArrayList localArrayList1 = this.b.d();
    if (localArrayList1 == null)
      return null;
    ArrayList localArrayList2 = new ArrayList();
    Iterator localIterator = localArrayList1.iterator();
    while (localIterator.hasNext())
      localArrayList2.add(c.a((m)localIterator.next()));
    return localArrayList2;
  }

  public MKOLUpdateElement getUpdateInfo(int paramInt)
  {
    q localq = this.b.f(paramInt);
    if (localq == null)
      return null;
    return c.a(localq.a());
  }

  public int importOfflineData()
  {
    return importOfflineData(false);
  }

  public int importOfflineData(boolean paramBoolean)
  {
    ArrayList localArrayList1 = this.b.e();
    int i;
    if (localArrayList1 != null)
      i = localArrayList1.size();
    for (int j = i; ; j = 0)
    {
      this.b.a(paramBoolean);
      ArrayList localArrayList2 = this.b.e();
      if (localArrayList2 != null)
        i = localArrayList2.size();
      return i - j;
      i = 0;
    }
  }

  public boolean init(MKOfflineMapListener paramMKOfflineMapListener)
  {
    com.baidu.mapapi.a.a().b();
    this.b = n.a();
    if (this.b == null)
      return false;
    this.b.a(new a(this));
    this.c = paramMKOfflineMapListener;
    return true;
  }

  public boolean pause(int paramInt)
  {
    return this.b.c(paramInt);
  }

  public boolean remove(int paramInt)
  {
    return this.b.e(paramInt);
  }

  public ArrayList<MKOLSearchRecord> searchCity(String paramString)
  {
    ArrayList localArrayList1 = this.b.a(paramString);
    if (localArrayList1 == null)
      return null;
    ArrayList localArrayList2 = new ArrayList();
    Iterator localIterator = localArrayList1.iterator();
    while (localIterator.hasNext())
      localArrayList2.add(c.a((m)localIterator.next()));
    return localArrayList2;
  }

  public boolean start(int paramInt)
  {
    if (this.b == null)
      return false;
    if (this.b.e() != null)
    {
      Iterator localIterator = this.b.e().iterator();
      while (localIterator.hasNext())
      {
        q localq = (q)localIterator.next();
        if (localq.a.a == paramInt)
        {
          if ((localq.a.j) || (localq.a.l == 2) || (localq.a.l == 3))
            return this.b.b(paramInt);
          return false;
        }
      }
    }
    return this.b.a(paramInt);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.mapapi.map.offline.MKOfflineMap
 * JD-Core Version:    0.6.2
 */