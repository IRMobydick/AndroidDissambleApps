package com.ubercab.library.vendor.google.map.model;

import com.google.android.gms.maps.model.PolylineOptions;
import com.ubercab.library.location.model.UberLatLng;
import com.ubercab.library.map.internal.model.IUberPolylineOptions;
import com.ubercab.library.vendor.google.GoogleUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GooglePolylineOptionsAdapter
  implements IUberPolylineOptions
{
  private PolylineOptions mPolylineOptions = new PolylineOptions();

  public IUberPolylineOptions color(int paramInt)
  {
    this.mPolylineOptions = this.mPolylineOptions.color(paramInt);
    return this;
  }

  public PolylineOptions getPolylineOptions()
  {
    return this.mPolylineOptions;
  }

  public IUberPolylineOptions points(Iterable<UberLatLng> paramIterable)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramIterable.iterator();
    while (localIterator.hasNext())
      localArrayList.add(GoogleUtils.convertLatLng((UberLatLng)localIterator.next()));
    this.mPolylineOptions = new PolylineOptions().addAll(localArrayList).color(this.mPolylineOptions.getColor()).width(this.mPolylineOptions.getWidth());
    return this;
  }

  public IUberPolylineOptions width(float paramFloat)
  {
    this.mPolylineOptions = this.mPolylineOptions.width(paramFloat);
    return this;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.vendor.google.map.model.GooglePolylineOptionsAdapter
 * JD-Core Version:    0.6.2
 */