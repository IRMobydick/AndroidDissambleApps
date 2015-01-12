package com.ubercab.client.core.vendor.google.model;

import com.google.gson.annotations.SerializedName;

public final class Route
{

  @SerializedName("overview_polyline")
  private OverviewPolyline mOverviewPolyline;

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    Route localRoute;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localRoute = (Route)paramObject;
      if (this.mOverviewPolyline == null)
        break;
    }
    while (this.mOverviewPolyline.equals(localRoute.mOverviewPolyline));
    while (true)
    {
      return false;
      if (localRoute.mOverviewPolyline == null)
        break;
    }
  }

  public OverviewPolyline getOverviewPolyline()
  {
    return this.mOverviewPolyline;
  }

  public int hashCode()
  {
    if (this.mOverviewPolyline != null)
      return this.mOverviewPolyline.hashCode();
    return 0;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.vendor.google.model.Route
 * JD-Core Version:    0.6.2
 */