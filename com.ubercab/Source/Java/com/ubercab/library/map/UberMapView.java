package com.ubercab.library.map;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.ubercab.library.R.styleable;
import com.ubercab.library.map.internal.IUberMapOptions;
import com.ubercab.library.map.internal.IUberMapView;
import com.ubercab.library.vendor.baidu.BaiduUtils;
import com.ubercab.library.vendor.baidu.map.BaiduMapOptionsAdapter;
import com.ubercab.library.vendor.baidu.map.BaiduMapViewAdapter;
import com.ubercab.library.vendor.google.map.GoogleMapOptionsAdapter;
import com.ubercab.library.vendor.google.map.GoogleMapViewAdapter;

public final class UberMapView extends FrameLayout
{
  private static final String EXTRA_MAP_VENDOR = "map_vendor";
  private final String mMapVendor;
  private IUberMapView mMapView;
  private UberMap mUberMap;

  public UberMapView(Context paramContext)
  {
    this(paramContext, null);
  }

  public UberMapView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public UberMapView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    IUberMapOptions localIUberMapOptions = getMapOptions(paramContext, paramAttributeSet).getMapOptions();
    this.mMapVendor = UberMapInitializer.getMapVendor().getName();
    String str = this.mMapVendor;
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
        throw new RuntimeException("Unknown map vendor: " + this.mMapVendor);
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
    BaiduUtils.setBaiduServiceEnabled(paramContext, true);
    this.mMapView = new BaiduMapViewAdapter(paramContext, (BaiduMapOptionsAdapter)localIUberMapOptions);
    for (Object localObject = ((BaiduMapViewAdapter)this.mMapView).getMapView(); ; localObject = ((GoogleMapViewAdapter)this.mMapView).getMapView())
    {
      addView((View)localObject);
      return;
      BaiduUtils.setBaiduServiceEnabled(paramContext, false);
      this.mMapView = new GoogleMapViewAdapter(paramContext, (GoogleMapOptionsAdapter)localIUberMapOptions);
    }
  }

  private UberMapOptions getMapOptions(Context paramContext, AttributeSet paramAttributeSet)
  {
    UberMapOptions localUberMapOptions = new UberMapOptions();
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.UberMapView);
    int i = localTypedArray.getIndexCount();
    for (int j = 0; j < i; j++)
    {
      int k = localTypedArray.getIndex(j);
      if (k == R.styleable.UberMapView_zoomControls)
        localUberMapOptions.zoomControlsEnabled(localTypedArray.getBoolean(k, false));
    }
    localTypedArray.recycle();
    return localUberMapOptions;
  }

  public UberMap getMap()
  {
    if (this.mMapView.getMap() == null)
      return null;
    if (this.mUberMap == null)
      this.mUberMap = new UberMap(this.mMapView.getMap());
    return this.mUberMap;
  }

  public void onCreate(Bundle paramBundle)
  {
    if ((paramBundle == null) || (!this.mMapVendor.equals(paramBundle.get("map_vendor"))))
    {
      this.mMapView.onCreate(null);
      return;
    }
    this.mMapView.onCreate(paramBundle);
  }

  public void onDestroy()
  {
    this.mMapView.onDestroy();
  }

  public void onLowMemory()
  {
    this.mMapView.onLowMemory();
  }

  public void onPause()
  {
    this.mMapView.onPause();
  }

  public void onResume()
  {
    this.mMapView.onResume();
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    paramBundle.putString("map_vendor", this.mMapVendor);
    this.mMapView.onSaveInstanceState(paramBundle);
  }

  public void setMapPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    UberMap localUberMap = getMap();
    if (localUberMap.supportsPadding())
    {
      localUberMap.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
    setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.map.UberMapView
 * JD-Core Version:    0.6.2
 */