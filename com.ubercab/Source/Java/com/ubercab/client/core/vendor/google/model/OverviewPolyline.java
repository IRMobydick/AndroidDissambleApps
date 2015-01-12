package com.ubercab.client.core.vendor.google.model;

import com.google.gson.annotations.SerializedName;

public final class OverviewPolyline
{

  @SerializedName("points")
  private String mPoints;

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    OverviewPolyline localOverviewPolyline;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localOverviewPolyline = (OverviewPolyline)paramObject;
      if (this.mPoints == null)
        break;
    }
    while (this.mPoints.equals(localOverviewPolyline.mPoints));
    while (true)
    {
      return false;
      if (localOverviewPolyline.mPoints == null)
        break;
    }
  }

  public String getPoints()
  {
    return this.mPoints;
  }

  public int hashCode()
  {
    if (this.mPoints != null)
      return this.mPoints.hashCode();
    return 0;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.vendor.google.model.OverviewPolyline
 * JD-Core Version:    0.6.2
 */