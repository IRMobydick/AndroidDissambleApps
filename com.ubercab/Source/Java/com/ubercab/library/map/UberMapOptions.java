package com.ubercab.library.map;

import com.ubercab.library.map.internal.IUberMapOptions;
import com.ubercab.library.map.internal.model.IUberCameraPosition;
import com.ubercab.library.vendor.baidu.map.BaiduMapOptionsAdapter;
import com.ubercab.library.vendor.google.map.GoogleMapOptionsAdapter;

public class UberMapOptions
{
  private final IUberMapOptions mMapOptions;

  public UberMapOptions()
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
    this.mMapOptions = new BaiduMapOptionsAdapter();
    return;
    this.mMapOptions = new GoogleMapOptionsAdapter();
  }

  public UberMapOptions camera(IUberCameraPosition paramIUberCameraPosition)
  {
    this.mMapOptions.camera(paramIUberCameraPosition);
    return this;
  }

  public UberMapOptions compassEnabled(boolean paramBoolean)
  {
    this.mMapOptions.compassEnabled(paramBoolean);
    return this;
  }

  IUberMapOptions getMapOptions()
  {
    return this.mMapOptions;
  }

  public UberMapOptions rotateGesturesEnabled(boolean paramBoolean)
  {
    this.mMapOptions.rotateGesturesEnabled(paramBoolean);
    return this;
  }

  public UberMapOptions scrollGesturesEnabled(boolean paramBoolean)
  {
    this.mMapOptions.scrollGesturesEnabled(paramBoolean);
    return this;
  }

  public UberMapOptions tiltGesturesEnabled(boolean paramBoolean)
  {
    this.mMapOptions.tiltGesturesEnabled(paramBoolean);
    return this;
  }

  public UberMapOptions zoomControlsEnabled(boolean paramBoolean)
  {
    this.mMapOptions.zoomControlsEnabled(paramBoolean);
    return this;
  }

  public UberMapOptions zoomGesturesEnabled(boolean paramBoolean)
  {
    this.mMapOptions.zoomGesturesEnabled(paramBoolean);
    return this;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.map.UberMapOptions
 * JD-Core Version:    0.6.2
 */