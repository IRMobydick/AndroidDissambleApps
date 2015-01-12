package com.ubercab.library.map;

import com.ubercab.library.location.model.UberLatLng;
import com.ubercab.library.map.internal.model.IUberPolygonOptions;
import com.ubercab.library.vendor.baidu.map.model.BaiduPolygonOptionsAdapter;
import com.ubercab.library.vendor.google.map.model.GooglePolygonOptionsAdapter;

public class UberPolygonOptions
{
  private final IUberPolygonOptions mPolygonOptions;

  public UberPolygonOptions()
  {
    String str = UberMapInitializer.getMapVendor().getName();
    int i = -1;
    switch (str.hashCode())
    {
    default:
    case 93498907:
    }
    while (true)
      switch (i)
      {
      default:
        this.mPolygonOptions = new GooglePolygonOptionsAdapter();
        return;
        if (str.equals("baidu"))
          i = 0;
        break;
      case 0:
      }
    this.mPolygonOptions = new BaiduPolygonOptionsAdapter();
  }

  public UberPolygonOptions fillColor(int paramInt)
  {
    this.mPolygonOptions.fillColor(paramInt);
    return this;
  }

  IUberPolygonOptions getPolygonOptions()
  {
    return this.mPolygonOptions;
  }

  public UberPolygonOptions points(Iterable<UberLatLng> paramIterable)
  {
    this.mPolygonOptions.points(paramIterable);
    return this;
  }

  public UberPolygonOptions stroke(float paramFloat, int paramInt)
  {
    this.mPolygonOptions.stroke(paramFloat, paramInt);
    return this;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.map.UberPolygonOptions
 * JD-Core Version:    0.6.2
 */