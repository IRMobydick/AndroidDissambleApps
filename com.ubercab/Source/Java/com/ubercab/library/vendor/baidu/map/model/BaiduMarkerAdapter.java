package com.ubercab.library.vendor.baidu.map.model;

import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.Marker;
import com.ubercab.library.location.model.UberLatLng;
import com.ubercab.library.map.internal.model.IUberBitmapDescriptor;
import com.ubercab.library.map.internal.model.IUberMarker;
import com.ubercab.library.vendor.baidu.BaiduUtils;
import java.util.UUID;

public class BaiduMarkerAdapter
  implements IUberMarker
{
  private static final int BAIDU_ROTATION_OFFSET = 360;
  private float mAlpha = 1.0F;
  private final String mId;
  private final Marker mMarker;
  private UberLatLng mWGS84Position;

  public BaiduMarkerAdapter(Marker paramMarker)
  {
    this.mMarker = paramMarker;
    this.mId = UUID.randomUUID().toString();
  }

  public float getAlpha()
  {
    return this.mAlpha;
  }

  public String getId()
  {
    return this.mId;
  }

  public Marker getMarker()
  {
    return this.mMarker;
  }

  public UberLatLng getPosition()
  {
    if (this.mWGS84Position != null)
      return this.mWGS84Position;
    return BaiduUtils.convertLatLng(this.mMarker.getPosition());
  }

  public float getRotation()
  {
    return 360.0F + this.mMarker.getRotate();
  }

  public void remove()
  {
    this.mMarker.getIcon().recycle();
    this.mMarker.remove();
  }

  public void setAlpha(float paramFloat)
  {
    this.mAlpha = paramFloat;
    if (paramFloat < 1.0F);
    try
    {
      this.mMarker.setVisible(false);
      return;
      this.mMarker.setVisible(true);
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
    }
  }

  public void setIcon(IUberBitmapDescriptor paramIUberBitmapDescriptor)
  {
    this.mMarker.setIcon(((BaiduBitmapDescriptorAdapter)paramIUberBitmapDescriptor).getBitmapDescriptor());
  }

  public void setPosition(UberLatLng paramUberLatLng)
  {
    this.mWGS84Position = paramUberLatLng;
    this.mMarker.setPosition(BaiduUtils.convertLatLng(paramUberLatLng));
  }

  public void setRotation(float paramFloat)
  {
    this.mMarker.setRotate(360.0F - paramFloat);
  }

  public void setVisible(boolean paramBoolean)
  {
    this.mMarker.setVisible(paramBoolean);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.vendor.baidu.map.model.BaiduMarkerAdapter
 * JD-Core Version:    0.6.2
 */