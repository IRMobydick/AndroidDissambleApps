package com.ubercab.library.vendor.baidu.map.model;

import com.baidu.mapapi.map.Polyline;
import com.baidu.mapapi.model.LatLng;
import com.ubercab.library.location.model.UberLatLng;
import com.ubercab.library.map.internal.model.IUberPolyline;
import com.ubercab.library.vendor.baidu.BaiduUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BaiduPolylineAdapter
  implements IUberPolyline
{
  private final Polyline mPolyline;

  public BaiduPolylineAdapter(Polyline paramPolyline)
  {
    this.mPolyline = paramPolyline;
  }

  public List<UberLatLng> getPoints()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.mPolyline.getPoints().iterator();
    while (localIterator.hasNext())
      localArrayList.add(BaiduUtils.convertLatLng((LatLng)localIterator.next()));
    return localArrayList;
  }

  public Polyline getPolyline()
  {
    return this.mPolyline;
  }

  public void remove()
  {
    this.mPolyline.remove();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.vendor.baidu.map.model.BaiduPolylineAdapter
 * JD-Core Version:    0.6.2
 */