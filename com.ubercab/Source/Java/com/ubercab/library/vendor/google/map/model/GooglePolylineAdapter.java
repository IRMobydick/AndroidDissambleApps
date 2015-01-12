package com.ubercab.library.vendor.google.map.model;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Polyline;
import com.ubercab.library.location.model.UberLatLng;
import com.ubercab.library.map.internal.model.IUberPolyline;
import com.ubercab.library.vendor.google.GoogleUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GooglePolylineAdapter
  implements IUberPolyline
{
  private final Polyline mPolyline;

  public GooglePolylineAdapter(Polyline paramPolyline)
  {
    this.mPolyline = paramPolyline;
  }

  public List<UberLatLng> getPoints()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.mPolyline.getPoints().iterator();
    while (localIterator.hasNext())
      localArrayList.add(GoogleUtils.convertLatLng((LatLng)localIterator.next()));
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
 * Qualified Name:     com.ubercab.library.vendor.google.map.model.GooglePolylineAdapter
 * JD-Core Version:    0.6.2
 */