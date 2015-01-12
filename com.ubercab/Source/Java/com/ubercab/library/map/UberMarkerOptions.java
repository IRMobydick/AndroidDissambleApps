package com.ubercab.library.map;

import com.ubercab.library.location.model.UberLatLng;
import com.ubercab.library.map.internal.model.IUberMarkerOptions;
import com.ubercab.library.vendor.baidu.map.model.BaiduMarkerOptionsAdapter;
import com.ubercab.library.vendor.google.map.model.GoogleMarkerOptionsAdapter;

public class UberMarkerOptions
{
  private final IUberMarkerOptions mMarkerOptions;

  public UberMarkerOptions()
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
    this.mMarkerOptions = new BaiduMarkerOptionsAdapter();
    return;
    this.mMarkerOptions = new GoogleMarkerOptionsAdapter();
  }

  public UberMarkerOptions alpha(float paramFloat)
  {
    this.mMarkerOptions.alpha(paramFloat);
    return this;
  }

  public UberMarkerOptions anchor(float paramFloat1, float paramFloat2)
  {
    this.mMarkerOptions.anchor(paramFloat1, paramFloat2);
    return this;
  }

  IUberMarkerOptions getMarkerOptions()
  {
    return this.mMarkerOptions;
  }

  public UberMarkerOptions icon(UberBitmapDescriptor paramUberBitmapDescriptor)
  {
    this.mMarkerOptions.icon(paramUberBitmapDescriptor.getBitmapDescriptor());
    return this;
  }

  public UberMarkerOptions position(UberLatLng paramUberLatLng)
  {
    this.mMarkerOptions.position(paramUberLatLng);
    return this;
  }

  public UberMarkerOptions rotation(float paramFloat)
  {
    this.mMarkerOptions.rotation(paramFloat);
    return this;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.map.UberMarkerOptions
 * JD-Core Version:    0.6.2
 */