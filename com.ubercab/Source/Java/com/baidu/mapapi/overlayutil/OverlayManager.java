package com.baidu.mapapi.overlayutil;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BaiduMap.OnMarkerClickListener;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.Overlay;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.model.LatLngBounds.Builder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class OverlayManager
  implements BaiduMap.OnMarkerClickListener
{
  BaiduMap a = null;
  List<Overlay> b = null;
  private List<OverlayOptions> c = null;

  public OverlayManager(BaiduMap paramBaiduMap)
  {
    this.a = paramBaiduMap;
    if (this.c == null)
      this.c = new ArrayList();
    if (this.b == null)
      this.b = new ArrayList();
  }

  public final void addToMap()
  {
    if (this.a == null);
    while (true)
    {
      return;
      removeFromMap();
      if (getOverlayOptions() != null)
        this.c.addAll(getOverlayOptions());
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext())
      {
        OverlayOptions localOverlayOptions = (OverlayOptions)localIterator.next();
        this.b.add(this.a.addOverlay(localOverlayOptions));
      }
    }
  }

  public abstract List<OverlayOptions> getOverlayOptions();

  public final void removeFromMap()
  {
    if (this.a == null)
      return;
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
      ((Overlay)localIterator.next()).remove();
    this.c.clear();
    this.b.clear();
  }

  public void zoomToSpan()
  {
    if (this.a == null);
    while (this.b.size() <= 0)
      return;
    LatLngBounds.Builder localBuilder = new LatLngBounds.Builder();
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      Overlay localOverlay = (Overlay)localIterator.next();
      if ((localOverlay instanceof Marker))
        localBuilder.include(((Marker)localOverlay).getPosition());
    }
    this.a.setMapStatus(MapStatusUpdateFactory.newLatLngBounds(localBuilder.build()));
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.mapapi.overlayutil.OverlayManager
 * JD-Core Version:    0.6.2
 */