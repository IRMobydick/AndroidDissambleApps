package com.ubercab.client.feature.trip.map;

import android.content.Context;
import android.content.res.Resources;

public class MapPolylineStyle
{
  private final int mColorRoute;
  private final int mColorRouteSecondary;
  private final float mPolylineWidth;

  public MapPolylineStyle(Context paramContext)
  {
    Resources localResources = paramContext.getResources();
    this.mPolylineWidth = localResources.getDimensionPixelSize(2131361895);
    this.mColorRoute = localResources.getColor(2131296333);
    this.mColorRouteSecondary = localResources.getColor(2131296334);
  }

  public int getPolylineColor()
  {
    return this.mColorRoute;
  }

  public int getPolylineSecondaryColor()
  {
    return this.mColorRouteSecondary;
  }

  public float getPolylineWidth()
  {
    return this.mPolylineWidth;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.trip.map.MapPolylineStyle
 * JD-Core Version:    0.6.2
 */