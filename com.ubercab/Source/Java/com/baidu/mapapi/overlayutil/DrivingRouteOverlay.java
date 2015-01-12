package com.baidu.mapapi.overlayutil;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;
import com.baidu.mapapi.a;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.map.PolylineOptions;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.RouteNode;
import com.baidu.mapapi.search.route.DrivingRouteLine;
import com.baidu.mapapi.search.route.DrivingRouteLine.DrivingStep;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DrivingRouteOverlay extends OverlayManager
{
  private DrivingRouteLine c = null;

  public DrivingRouteOverlay(BaiduMap paramBaiduMap)
  {
    super(paramBaiduMap);
  }

  public final List<OverlayOptions> getOverlayOptions()
  {
    Object localObject1 = null;
    if (this.c == null)
      return null;
    ArrayList localArrayList1 = new ArrayList();
    if ((this.c.getAllStep() != null) && (this.c.getAllStep().size() > 0))
    {
      new ArrayList();
      Iterator localIterator = this.c.getAllStep().iterator();
      while (localIterator.hasNext())
      {
        DrivingRouteLine.DrivingStep localDrivingStep2 = (DrivingRouteLine.DrivingStep)localIterator.next();
        Bundle localBundle = new Bundle();
        localBundle.putInt("index", this.c.getAllStep().indexOf(localDrivingStep2));
        if (localDrivingStep2.getEntrace() != null)
          localArrayList1.add(new MarkerOptions().position(localDrivingStep2.getEntrace().getLocation()).anchor(0.5F, 0.5F).zIndex(10).rotate(360 - localDrivingStep2.getDirection()).extraInfo(localBundle).icon(BitmapDescriptorFactory.fromAsset("Icon_line_node.png")));
        if ((this.c.getAllStep().indexOf(localDrivingStep2) == -1 + this.c.getAllStep().size()) && (localDrivingStep2.getExit() != null))
          localArrayList1.add(new MarkerOptions().position(localDrivingStep2.getExit().getLocation()).anchor(0.5F, 0.5F).zIndex(10).icon(BitmapDescriptorFactory.fromAsset("Icon_line_node.png")));
      }
    }
    BitmapDescriptor localBitmapDescriptor2;
    BitmapDescriptor localBitmapDescriptor1;
    label385: int j;
    label448: List localList2;
    if (this.c.getStarting() != null)
    {
      MarkerOptions localMarkerOptions2 = new MarkerOptions().position(this.c.getStarting().getLocation());
      if (getStartMarker() != null)
      {
        localBitmapDescriptor2 = getStartMarker();
        localArrayList1.add(localMarkerOptions2.icon(localBitmapDescriptor2).zIndex(10));
      }
    }
    else
    {
      if (this.c.getTerminal() != null)
      {
        MarkerOptions localMarkerOptions1 = new MarkerOptions().position(this.c.getTerminal().getLocation());
        if (getTerminalMarker() == null)
          break label611;
        localBitmapDescriptor1 = getTerminalMarker();
        localArrayList1.add(localMarkerOptions1.icon(localBitmapDescriptor1).zIndex(10));
      }
      if ((this.c.getAllStep() == null) || (this.c.getAllStep().size() <= 0))
        break label621;
      List localList1 = this.c.getAllStep();
      int i = localList1.size();
      j = 0;
      if (j >= i)
        break label621;
      DrivingRouteLine.DrivingStep localDrivingStep1 = (DrivingRouteLine.DrivingStep)localList1.get(j);
      if ((localDrivingStep1.getWayPoints() == null) || (localDrivingStep1.getWayPoints().size() <= 0))
        break label623;
      ArrayList localArrayList2 = new ArrayList();
      if (localObject1 != null)
        localArrayList2.add(localObject1);
      localList2 = localDrivingStep1.getWayPoints();
      localArrayList2.addAll(localList2);
      localArrayList1.add(new PolylineOptions().points(localArrayList2).width(10).color(Color.argb(178, 0, 78, 255)).zIndex(0));
    }
    label611: label621: label623: for (Object localObject2 = (LatLng)localList2.get(-1 + localList2.size()); ; localObject2 = localObject1)
    {
      j++;
      localObject1 = localObject2;
      break label448;
      localBitmapDescriptor2 = BitmapDescriptorFactory.fromAsset("Icon_start.png");
      break;
      localBitmapDescriptor1 = BitmapDescriptorFactory.fromAsset("Icon_end.png");
      break label385;
      return localArrayList1;
    }
  }

  public BitmapDescriptor getStartMarker()
  {
    return null;
  }

  public BitmapDescriptor getTerminalMarker()
  {
    return null;
  }

  public final boolean onMarkerClick(Marker paramMarker)
  {
    if (paramMarker.getExtraInfo() != null)
      onRouteNodeClick(paramMarker.getExtraInfo().getInt("index"));
    return true;
  }

  public boolean onRouteNodeClick(int paramInt)
  {
    if ((this.c.getAllStep() != null) && (this.c.getAllStep().get(paramInt) != null))
      Toast.makeText(a.a().d(), ((DrivingRouteLine.DrivingStep)this.c.getAllStep().get(paramInt)).getInstructions(), 1).show();
    return false;
  }

  public void setData(DrivingRouteLine paramDrivingRouteLine)
  {
    this.c = paramDrivingRouteLine;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.mapapi.overlayutil.DrivingRouteOverlay
 * JD-Core Version:    0.6.2
 */