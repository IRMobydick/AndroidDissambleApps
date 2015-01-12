package com.baidu.mapapi.overlayutil;

import android.graphics.Color;
import android.widget.Toast;
import com.baidu.mapapi.a;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.map.PolylineOptions;
import com.baidu.mapapi.search.busline.BusLineResult;
import com.baidu.mapapi.search.busline.BusLineResult.BusStation;
import com.baidu.mapapi.search.busline.BusLineResult.BusStep;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BusLineOverlay extends OverlayManager
{
  private BusLineResult c = null;

  public BusLineOverlay(BaiduMap paramBaiduMap)
  {
    super(paramBaiduMap);
  }

  public final List<OverlayOptions> getOverlayOptions()
  {
    if ((this.c == null) || (this.c.getStations() == null))
      return null;
    ArrayList localArrayList1 = new ArrayList();
    Iterator localIterator1 = this.c.getStations().iterator();
    while (localIterator1.hasNext())
    {
      BusLineResult.BusStation localBusStation = (BusLineResult.BusStation)localIterator1.next();
      localArrayList1.add(new MarkerOptions().position(localBusStation.getLocation()).zIndex(10).anchor(0.5F, 0.5F).icon(BitmapDescriptorFactory.fromAsset("Icon_bus_station.png")));
    }
    ArrayList localArrayList2 = new ArrayList();
    Iterator localIterator2 = this.c.getSteps().iterator();
    while (localIterator2.hasNext())
    {
      BusLineResult.BusStep localBusStep = (BusLineResult.BusStep)localIterator2.next();
      if (localBusStep.getWayPoints() != null)
        localArrayList2.addAll(localBusStep.getWayPoints());
    }
    if (localArrayList2.size() > 0)
      localArrayList1.add(new PolylineOptions().width(10).color(Color.argb(178, 0, 78, 255)).zIndex(0).points(localArrayList2));
    return localArrayList1;
  }

  public boolean onBusStationClick(int paramInt)
  {
    if ((this.c.getStations() != null) && (this.c.getStations().get(paramInt) != null))
      Toast.makeText(a.a().d(), ((BusLineResult.BusStation)this.c.getStations().get(paramInt)).getTitle(), 1).show();
    return false;
  }

  public final boolean onMarkerClick(Marker paramMarker)
  {
    return onBusStationClick(this.b.indexOf(paramMarker));
  }

  public void setData(BusLineResult paramBusLineResult)
  {
    this.c = paramBusLineResult;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.mapapi.overlayutil.BusLineOverlay
 * JD-Core Version:    0.6.2
 */