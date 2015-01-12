package com.ubercab.library.map;

import android.os.Bundle;
import com.ubercab.library.location.model.UberLatLng;
import com.ubercab.library.map.internal.model.IUberCameraPosition;
import com.ubercab.library.map.internal.model.IUberCameraPosition.Builder;
import com.ubercab.library.vendor.baidu.map.model.BaiduCameraPositionAdapter;
import com.ubercab.library.vendor.baidu.map.model.BaiduCameraPositionAdapter.Builder;
import com.ubercab.library.vendor.google.map.model.GoogleCameraPositionAdapter;
import com.ubercab.library.vendor.google.map.model.GoogleCameraPositionAdapter.Builder;

public class UberCameraPosition
  implements IUberCameraPosition
{
  private final IUberCameraPosition mCameraPosition;

  UberCameraPosition(float paramFloat1, UberLatLng paramUberLatLng, float paramFloat2, float paramFloat3)
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
    for (Object localObject = new BaiduCameraPositionAdapter.Builder(); ; localObject = new GoogleCameraPositionAdapter.Builder())
    {
      this.mCameraPosition = ((IUberCameraPosition.Builder)localObject).bearing(paramFloat1).target(paramUberLatLng).tilt(paramFloat2).zoom(paramFloat3).build();
      return;
    }
  }

  public UberCameraPosition(String paramString, Bundle paramBundle)
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
    this.mCameraPosition = new BaiduCameraPositionAdapter(paramString, paramBundle);
    return;
    this.mCameraPosition = new GoogleCameraPositionAdapter(paramString, paramBundle);
  }

  public float getBearing()
  {
    return this.mCameraPosition.getBearing();
  }

  IUberCameraPosition getCameraPosition()
  {
    return this.mCameraPosition;
  }

  public UberLatLng getTarget()
  {
    return this.mCameraPosition.getTarget();
  }

  public float getTilt()
  {
    return this.mCameraPosition.getTilt();
  }

  public float getZoom()
  {
    return this.mCameraPosition.getZoom();
  }

  public void writeToBundle(String paramString, Bundle paramBundle)
  {
    this.mCameraPosition.writeToBundle(paramString, paramBundle);
  }

  public static class Builder
  {
    private float mBearing;
    private UberLatLng mTarget;
    private float mTilt;
    private float mZoom;

    public Builder bearing(float paramFloat)
    {
      this.mBearing = paramFloat;
      return this;
    }

    public UberCameraPosition build()
    {
      return new UberCameraPosition(this.mBearing, this.mTarget, this.mTilt, this.mZoom);
    }

    public Builder target(UberLatLng paramUberLatLng)
    {
      this.mTarget = paramUberLatLng;
      return this;
    }

    public Builder tilt(float paramFloat)
    {
      this.mTilt = paramFloat;
      return this;
    }

    public Builder zoom(float paramFloat)
    {
      this.mZoom = paramFloat;
      return this;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.map.UberCameraPosition
 * JD-Core Version:    0.6.2
 */