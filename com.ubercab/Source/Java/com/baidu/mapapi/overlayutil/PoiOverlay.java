package com.baidu.mapapi.overlayutil;

import android.os.Bundle;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.search.core.PoiInfo;
import com.baidu.mapapi.search.poi.PoiResult;
import java.util.ArrayList;
import java.util.List;

public class PoiOverlay extends OverlayManager
{
  private PoiResult c = null;

  public PoiOverlay(BaiduMap paramBaiduMap)
  {
    super(paramBaiduMap);
  }

  public final List<OverlayOptions> getOverlayOptions()
  {
    if ((this.c == null) || (this.c.getAllPoi() == null))
      return null;
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    int j = 0;
    if ((i < this.c.getAllPoi().size()) && (j < 10))
    {
      if (((PoiInfo)this.c.getAllPoi().get(i)).location == null);
      while (true)
      {
        i++;
        break;
        j++;
        Bundle localBundle = new Bundle();
        localBundle.putInt("index", i);
        localArrayList.add(new MarkerOptions().icon(BitmapDescriptorFactory.fromAsset("Icon_mark" + j + ".png")).extraInfo(localBundle).position(((PoiInfo)this.c.getAllPoi().get(i)).location));
      }
    }
    return localArrayList;
  }

  public PoiResult getPoiResult()
  {
    return this.c;
  }

  public final boolean onMarkerClick(Marker paramMarker)
  {
    if (paramMarker.getExtraInfo() != null)
      return onPoiClick(paramMarker.getExtraInfo().getInt("index"));
    return false;
  }

  public boolean onPoiClick(int paramInt)
  {
    return false;
  }

  public void setData(PoiResult paramPoiResult)
  {
    this.c = paramPoiResult;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.mapapi.overlayutil.PoiOverlay
 * JD-Core Version:    0.6.2
 */