package com.ubercab.library.map;

import com.ubercab.library.location.model.UberLatLng;
import com.ubercab.library.map.internal.model.IUberPolylineOptions;
import com.ubercab.library.vendor.baidu.map.model.BaiduPolylineOptionsAdapter;
import com.ubercab.library.vendor.google.map.model.GooglePolylineOptionsAdapter;

public class UberPolylineOptions
{
  private final IUberPolylineOptions mPolylineOptions;

  public UberPolylineOptions()
  {
    String str = UberMapInitializer.getMapVendor().getName();
    int i = -1;
    switch (str.hashCode())
    {
    default:
    case 93498907:
    case -1240244679:
    }
    while (true)
      switch (i)
      {
      default:
        throw new RuntimeException("Unknown map vendor: " + str);
        if (str.equals("baidu"))
        {
          i = 0;
          continue;
          if (str.equals("google"))
            i = 1;
        }
        break;
      case 0:
      case 1:
      }
    this.mPolylineOptions = new BaiduPolylineOptionsAdapter();
    return;
    this.mPolylineOptions = new GooglePolylineOptionsAdapter();
  }

  public UberPolylineOptions color(int paramInt)
  {
    this.mPolylineOptions.color(paramInt);
    return this;
  }

  IUberPolylineOptions getPolylineOptions()
  {
    return this.mPolylineOptions;
  }

  public UberPolylineOptions points(Iterable<UberLatLng> paramIterable)
  {
    this.mPolylineOptions.points(paramIterable);
    return this;
  }

  public UberPolylineOptions width(float paramFloat)
  {
    this.mPolylineOptions.width(paramFloat);
    return this;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.map.UberPolylineOptions
 * JD-Core Version:    0.6.2
 */