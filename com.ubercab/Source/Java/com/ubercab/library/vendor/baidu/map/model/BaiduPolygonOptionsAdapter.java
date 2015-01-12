package com.ubercab.library.vendor.baidu.map.model;

import com.baidu.mapapi.map.PolygonOptions;
import com.baidu.mapapi.map.Stroke;
import com.ubercab.library.location.model.UberLatLng;
import com.ubercab.library.map.internal.model.IUberPolygonOptions;
import com.ubercab.library.vendor.baidu.BaiduUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BaiduPolygonOptionsAdapter
  implements IUberPolygonOptions
{
  private PolygonOptions mPolygonOptions = new PolygonOptions();

  public IUberPolygonOptions fillColor(int paramInt)
  {
    this.mPolygonOptions = this.mPolygonOptions.fillColor(paramInt);
    return this;
  }

  public PolygonOptions getPolygonOptions()
  {
    return this.mPolygonOptions;
  }

  public IUberPolygonOptions points(Iterable<UberLatLng> paramIterable)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramIterable.iterator();
    while (localIterator.hasNext())
      localArrayList.add(BaiduUtils.convertLatLng((UberLatLng)localIterator.next()));
    this.mPolygonOptions = new PolygonOptions().points(localArrayList).fillColor(this.mPolygonOptions.getFillColor()).stroke(this.mPolygonOptions.getStroke());
    return this;
  }

  public IUberPolygonOptions stroke(float paramFloat, int paramInt)
  {
    this.mPolygonOptions = this.mPolygonOptions.stroke(new Stroke((int)paramFloat, paramInt));
    return this;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.vendor.baidu.map.model.BaiduPolygonOptionsAdapter
 * JD-Core Version:    0.6.2
 */