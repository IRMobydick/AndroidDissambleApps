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
import com.baidu.mapapi.search.core.RouteNode;
import com.baidu.mapapi.search.route.TransitRouteLine;
import com.baidu.mapapi.search.route.TransitRouteLine.TransitStep;
import com.baidu.mapapi.search.route.TransitRouteLine.TransitStep.TransitRouteStepType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TransitRouteOverlay extends OverlayManager
{
  private TransitRouteLine c = null;

  public TransitRouteOverlay(BaiduMap paramBaiduMap)
  {
    super(paramBaiduMap);
  }

  private BitmapDescriptor a(TransitRouteLine.TransitStep paramTransitStep)
  {
    switch (1.a[paramTransitStep.getStepType().ordinal()])
    {
    default:
      return null;
    case 1:
      return BitmapDescriptorFactory.fromAsset("Icon_bus_station.png");
    case 2:
      return BitmapDescriptorFactory.fromAsset("Icon_subway_station.png");
    case 3:
    }
    return BitmapDescriptorFactory.fromAsset("Icon_walk_route.png");
  }

  public final List<OverlayOptions> getOverlayOptions()
  {
    if (this.c == null)
      return null;
    ArrayList localArrayList = new ArrayList();
    if ((this.c.getAllStep() != null) && (this.c.getAllStep().size() > 0))
    {
      new ArrayList();
      Iterator localIterator2 = this.c.getAllStep().iterator();
      while (localIterator2.hasNext())
      {
        TransitRouteLine.TransitStep localTransitStep2 = (TransitRouteLine.TransitStep)localIterator2.next();
        Bundle localBundle = new Bundle();
        localBundle.putInt("index", this.c.getAllStep().indexOf(localTransitStep2));
        if (localTransitStep2.getEntrace() != null)
          localArrayList.add(new MarkerOptions().position(localTransitStep2.getEntrace().getLocation()).anchor(0.5F, 0.5F).zIndex(10).extraInfo(localBundle).icon(a(localTransitStep2)));
        if ((this.c.getAllStep().indexOf(localTransitStep2) == -1 + this.c.getAllStep().size()) && (localTransitStep2.getExit() != null))
          localArrayList.add(new MarkerOptions().position(localTransitStep2.getExit().getLocation()).anchor(0.5F, 0.5F).zIndex(10).icon(a(localTransitStep2)));
      }
    }
    BitmapDescriptor localBitmapDescriptor2;
    BitmapDescriptor localBitmapDescriptor1;
    label372: TransitRouteLine.TransitStep localTransitStep1;
    if (this.c.getStarting() != null)
    {
      MarkerOptions localMarkerOptions2 = new MarkerOptions().position(this.c.getStarting().getLocation());
      if (getStartMarker() != null)
      {
        localBitmapDescriptor2 = getStartMarker();
        localArrayList.add(localMarkerOptions2.icon(localBitmapDescriptor2).zIndex(10));
      }
    }
    else
    {
      if (this.c.getTerminal() != null)
      {
        MarkerOptions localMarkerOptions1 = new MarkerOptions().position(this.c.getTerminal().getLocation());
        if (getTerminalMarker() == null)
          break label539;
        localBitmapDescriptor1 = getTerminalMarker();
        localArrayList.add(localMarkerOptions1.icon(localBitmapDescriptor1).zIndex(10));
      }
      if ((this.c.getAllStep() == null) || (this.c.getAllStep().size() <= 0))
        break label566;
      new ArrayList();
      Iterator localIterator1 = this.c.getAllStep().iterator();
      label437: 
      do
      {
        if (!localIterator1.hasNext())
          break;
        localTransitStep1 = (TransitRouteLine.TransitStep)localIterator1.next();
      }
      while (localTransitStep1.getWayPoints() == null);
      if (localTransitStep1.getStepType() == TransitRouteLine.TransitStep.TransitRouteStepType.WAKLING)
        break label549;
    }
    label539: label549: for (int i = Color.argb(178, 0, 78, 255); ; i = Color.argb(178, 88, 208, 0))
    {
      localArrayList.add(new PolylineOptions().points(localTransitStep1.getWayPoints()).width(10).color(i).zIndex(0));
      break label437;
      localBitmapDescriptor2 = BitmapDescriptorFactory.fromAsset("Icon_start.png");
      break;
      localBitmapDescriptor1 = BitmapDescriptorFactory.fromAsset("Icon_end.png");
      break label372;
    }
    label566: return localArrayList;
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
    Toast.makeText(a.a().d(), ((TransitRouteLine.TransitStep)this.c.getAllStep().get(paramInt)).getInstructions(), 1).show();
    return false;
  }

  public void setData(TransitRouteLine paramTransitRouteLine)
  {
    this.c = paramTransitRouteLine;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.mapapi.overlayutil.TransitRouteOverlay
 * JD-Core Version:    0.6.2
 */