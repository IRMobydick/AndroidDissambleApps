package com.ubercab.library.vendor.baidu.map.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatus.Builder;
import com.ubercab.library.location.model.UberLatLng;
import com.ubercab.library.map.internal.model.IUberCameraPosition;
import com.ubercab.library.map.internal.model.IUberCameraPosition.Builder;
import com.ubercab.library.vendor.baidu.BaiduUtils;

public class BaiduCameraPositionAdapter
  implements IUberCameraPosition
{
  private final MapStatus mMapStatus;

  public BaiduCameraPositionAdapter(MapStatus paramMapStatus)
  {
    this.mMapStatus = paramMapStatus;
  }

  public BaiduCameraPositionAdapter(String paramString, Bundle paramBundle)
  {
    this.mMapStatus = ((BaiduCameraPositionParcel)paramBundle.getParcelable(paramString)).getMapStatus();
  }

  public float getBearing()
  {
    return this.mMapStatus.rotate;
  }

  public MapStatus getMapStatus()
  {
    return this.mMapStatus;
  }

  public UberLatLng getTarget()
  {
    return BaiduUtils.convertLatLng(this.mMapStatus.target);
  }

  public float getTilt()
  {
    return this.mMapStatus.overlook;
  }

  public float getZoom()
  {
    return this.mMapStatus.zoom;
  }

  public void writeToBundle(String paramString, Bundle paramBundle)
  {
    paramBundle.putParcelable(paramString, new BaiduCameraPositionParcel(this.mMapStatus));
  }

  private static class BaiduCameraPositionParcel
    implements Parcelable
  {
    public static final Parcelable.Creator<BaiduCameraPositionParcel> CREATOR = new Parcelable.Creator()
    {
      public BaiduCameraPositionAdapter.BaiduCameraPositionParcel createFromParcel(Parcel paramAnonymousParcel)
      {
        return new BaiduCameraPositionAdapter.BaiduCameraPositionParcel(paramAnonymousParcel);
      }

      public BaiduCameraPositionAdapter.BaiduCameraPositionParcel[] newArray(int paramAnonymousInt)
      {
        return new BaiduCameraPositionAdapter.BaiduCameraPositionParcel[paramAnonymousInt];
      }
    };
    private final MapStatus mMapStatus;

    protected BaiduCameraPositionParcel(Parcel paramParcel)
    {
      this.mMapStatus = new MapStatus.Builder().overlook(paramParcel.readFloat()).rotate(paramParcel.readFloat()).target(BaiduUtils.convertLatLng(new UberLatLng(paramParcel))).zoom(paramParcel.readFloat()).build();
    }

    public BaiduCameraPositionParcel(MapStatus paramMapStatus)
    {
      this.mMapStatus = paramMapStatus;
    }

    public int describeContents()
    {
      return 0;
    }

    public MapStatus getMapStatus()
    {
      return this.mMapStatus;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeFloat(this.mMapStatus.overlook);
      paramParcel.writeFloat(this.mMapStatus.rotate);
      BaiduUtils.convertLatLng(this.mMapStatus.target).writeToParcel(paramParcel, paramInt);
      paramParcel.writeFloat(this.mMapStatus.zoom);
    }
  }

  public static class Builder
    implements IUberCameraPosition.Builder
  {
    private MapStatus.Builder mBuilder = new MapStatus.Builder();

    public IUberCameraPosition.Builder bearing(float paramFloat)
    {
      this.mBuilder = this.mBuilder.overlook(paramFloat);
      return this;
    }

    public IUberCameraPosition build()
    {
      return new BaiduCameraPositionAdapter(this.mBuilder.build());
    }

    public IUberCameraPosition.Builder target(UberLatLng paramUberLatLng)
    {
      this.mBuilder = this.mBuilder.target(BaiduUtils.convertLatLng(paramUberLatLng));
      return this;
    }

    public IUberCameraPosition.Builder tilt(float paramFloat)
    {
      this.mBuilder = this.mBuilder.rotate(paramFloat);
      return this;
    }

    public IUberCameraPosition.Builder zoom(float paramFloat)
    {
      this.mBuilder = this.mBuilder.zoom(paramFloat);
      return this;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.vendor.baidu.map.model.BaiduCameraPositionAdapter
 * JD-Core Version:    0.6.2
 */