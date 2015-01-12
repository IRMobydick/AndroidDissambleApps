package com.ubercab.library.map;

import com.ubercab.library.location.model.UberLatLng;
import com.ubercab.library.location.model.UberLatLngBounds;
import com.ubercab.library.map.internal.model.IUberCameraUpdateFactory;
import com.ubercab.library.vendor.baidu.map.model.BaiduCameraUpdateFactoryAdapter;
import com.ubercab.library.vendor.google.map.model.GoogleCameraUpdateFactoryAdapter;

public class UberCameraUpdateFactory
{
  private final IUberCameraUpdateFactory mCameraUpdateFactory;

  public UberCameraUpdateFactory()
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
    this.mCameraUpdateFactory = new BaiduCameraUpdateFactoryAdapter();
    return;
    this.mCameraUpdateFactory = new GoogleCameraUpdateFactoryAdapter();
  }

  IUberCameraUpdateFactory getCameraUpdateFactory()
  {
    return this.mCameraUpdateFactory;
  }

  public UberCameraUpdate newLatLng(UberLatLng paramUberLatLng)
  {
    return new UberCameraUpdate(this.mCameraUpdateFactory.newLatLng(paramUberLatLng));
  }

  public UberCameraUpdate newLatLngBounds(UberLatLngBounds paramUberLatLngBounds, int paramInt)
  {
    return new UberCameraUpdate(this.mCameraUpdateFactory.newLatLngBounds(paramUberLatLngBounds, paramInt));
  }

  public UberCameraUpdate newLatLngZoom(UberLatLng paramUberLatLng, float paramFloat)
  {
    return new UberCameraUpdate(this.mCameraUpdateFactory.newLatLngZoom(paramUberLatLng, paramFloat));
  }

  public UberCameraUpdate zoomIn()
  {
    return new UberCameraUpdate(this.mCameraUpdateFactory.zoomIn());
  }

  public UberCameraUpdate zoomOut()
  {
    return new UberCameraUpdate(this.mCameraUpdateFactory.zoomOut());
  }

  public UberCameraUpdate zoomTo(float paramFloat)
  {
    return new UberCameraUpdate(this.mCameraUpdateFactory.zoomTo(paramFloat));
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.map.UberCameraUpdateFactory
 * JD-Core Version:    0.6.2
 */