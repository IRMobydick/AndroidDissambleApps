package com.ubercab.library.vendor.baidu.map.model;

import com.baidu.mapapi.map.Polygon;
import com.baidu.mapapi.model.LatLng;
import com.ubercab.library.location.model.UberLatLng;
import com.ubercab.library.map.internal.model.IUberPolygon;
import com.ubercab.library.vendor.baidu.BaiduUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BaiduPolygonAdapter
  implements IUberPolygon
{
  private UberLatLng mCenter;
  private List<UberLatLng> mPoints;
  private final Polygon mPolygon;

  public BaiduPolygonAdapter(Polygon paramPolygon)
  {
    this.mPolygon = paramPolygon;
  }

  private void computePoints()
  {
    if (this.mPoints == null)
    {
      double d1 = 0.0D;
      double d2 = 0.0D;
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.mPolygon.getPoints().iterator();
      while (localIterator.hasNext())
      {
        UberLatLng localUberLatLng = BaiduUtils.convertLatLng((LatLng)localIterator.next());
        d1 += localUberLatLng.getLatitude();
        d2 += localUberLatLng.getLongitude();
        localArrayList.add(localUberLatLng);
      }
      this.mCenter = new UberLatLng(d1 / localArrayList.size(), d2 / localArrayList.size());
      this.mPoints = localArrayList;
    }
  }

  public UberLatLng getCenter()
  {
    computePoints();
    return this.mCenter;
  }

  public List<UberLatLng> getPoints()
  {
    computePoints();
    return this.mPoints;
  }

  public Polygon getPolygon()
  {
    return this.mPolygon;
  }

  public void remove()
  {
    this.mPolygon.remove();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.vendor.baidu.map.model.BaiduPolygonAdapter
 * JD-Core Version:    0.6.2
 */