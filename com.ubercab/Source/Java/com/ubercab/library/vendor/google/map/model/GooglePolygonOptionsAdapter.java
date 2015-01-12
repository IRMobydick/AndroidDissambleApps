package com.ubercab.library.vendor.google.map.model;

import com.google.android.gms.maps.model.PolygonOptions;
import com.ubercab.library.location.model.UberLatLng;
import com.ubercab.library.map.internal.model.IUberPolygonOptions;
import com.ubercab.library.vendor.google.GoogleUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GooglePolygonOptionsAdapter
  implements IUberPolygonOptions
{
  private PolygonOptions mPolygonOptions = new PolygonOptions();

  public IUberPolygonOptions fillColor(int paramInt)
  {
    this.mPolygonOptions = this.mPolygonOptions.fillColor(paramInt);
    return this;
  }

  public PolygonOptions getPolygonOptions()
  {
    return this.mPolygonOptions;
  }

  public IUberPolygonOptions points(Iterable<UberLatLng> paramIterable)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramIterable.iterator();
    while (localIterator.hasNext())
      localArrayList.add(GoogleUtils.convertLatLng((UberLatLng)localIterator.next()));
    this.mPolygonOptions = new PolygonOptions().addAll(localArrayList).fillColor(this.mPolygonOptions.getFillColor()).strokeColor(this.mPolygonOptions.getStrokeColor()).strokeWidth(this.mPolygonOptions.getStrokeWidth());
    return this;
  }

  public IUberPolygonOptions stroke(float paramFloat, int paramInt)
  {
    this.mPolygonOptions = this.mPolygonOptions.strokeWidth(paramFloat).strokeColor(paramInt);
    return this;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.vendor.google.map.model.GooglePolygonOptionsAdapter
 * JD-Core Version:    0.6.2
 */