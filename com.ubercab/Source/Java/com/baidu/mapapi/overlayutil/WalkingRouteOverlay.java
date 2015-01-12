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
import com.baidu.mapapi.search.route.WalkingRouteLine;
import com.baidu.mapapi.search.route.WalkingRouteLine.WalkingStep;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WalkingRouteOverlay extends OverlayManager
{
  private WalkingRouteLine c = null;

  public WalkingRouteOverlay(BaiduMap paramBaiduMap)
  {
    super(paramBaiduMap);
  }

  public final List<OverlayOptions> getOverlayOptions()
  {
    if (this.c == null)
      return null;
    ArrayList localArrayList1 = new ArrayList();
    if ((this.c.getAllStep() != null) && (this.c.getAllStep().size() > 0))
    {
      Iterator localIterator2 = this.c.getAllStep().iterator();
      while (localIterator2.hasNext())
      {
        WalkingRouteLine.WalkingStep localWalkingStep2 = (WalkingRouteLine.WalkingStep)localIterator2.next();
        Bundle localBundle = new Bundle();
        localBundle.putInt("index", this.c.getAllStep().indexOf(localWalkingStep2));
        if (localWalkingStep2.getEntrace() != null)
          localArrayList1.add(new MarkerOptions().position(localWalkingStep2.getEntrace().getLocation()).rotate(360 - localWalkingStep2.getDirection()).zIndex(10).extraInfo(localBundle).icon(BitmapDescriptorFactory.fromAsset("Icon_line_node.png")));
        if ((this.c.getAllStep().indexOf(localWalkingStep2) == -1 + this.c.getAllStep().size()) && (localWalkingStep2.getExit() != null))
          localArrayList1.add(new MarkerOptions().position(localWalkingStep2.getExit().getLocation()).anchor(0.5F, 0.5F).zIndex(10).icon(BitmapDescriptorFactory.fromAsset("Icon_line_node.png")));
      }
    }
    BitmapDescriptor localBitmapDescriptor2;
    MarkerOptions localMarkerOptions1;
    if (this.c.getStarting() != null)
    {
      MarkerOptions localMarkerOptions2 = new MarkerOptions().position(this.c.getStarting().getLocation());
      if (getStartMarker() != null)
      {
        localBitmapDescriptor2 = getStartMarker();
        localArrayList1.add(localMarkerOptions2.icon(localBitmapDescriptor2).zIndex(10));
      }
    }
    else if (this.c.getTerminal() != null)
    {
      localMarkerOptions1 = new MarkerOptions().position(this.c.getTerminal().getLocation());
      if (getTerminalMarker() == null)
        break label486;
    }
    ArrayList localArrayList2;
    label486: for (BitmapDescriptor localBitmapDescriptor1 = getTerminalMarker(); ; localBitmapDescriptor1 = BitmapDescriptorFactory.fromAsset("Icon_end.png"))
    {
      localArrayList1.add(localMarkerOptions1.icon(localBitmapDescriptor1).zIndex(10));
      if ((this.c.getAllStep() == null) || (this.c.getAllStep().size() <= 0))
        break label538;
      localArrayList2 = new ArrayList();
      Iterator localIterator1 = this.c.getAllStep().iterator();
      while (localIterator1.hasNext())
      {
        WalkingRouteLine.WalkingStep localWalkingStep1 = (WalkingRouteLine.WalkingStep)localIterator1.next();
        if (localWalkingStep1.getWayPoints() != null)
          localArrayList2.addAll(localWalkingStep1.getWayPoints());
      }
      localBitmapDescriptor2 = BitmapDescriptorFactory.fromAsset("Icon_start.png");
      break;
    }
    localArrayList1.add(new PolylineOptions().points(localArrayList2).width(10).color(Color.argb(178, 0, 78, 255)).zIndex(0));
    label538: return localArrayList1;
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
      Toast.makeText(a.a().d(), ((WalkingRouteLine.WalkingStep)this.c.getAllStep().get(paramInt)).getInstructions(), 1).show();
    return false;
  }

  public void setData(WalkingRouteLine paramWalkingRouteLine)
  {
    this.c = paramWalkingRouteLine;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.mapapi.overlayutil.WalkingRouteOverlay
 * JD-Core Version:    0.6.2
 */