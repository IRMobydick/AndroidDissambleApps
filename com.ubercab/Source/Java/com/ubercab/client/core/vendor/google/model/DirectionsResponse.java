package com.ubercab.client.core.vendor.google.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public final class DirectionsResponse
{
  private static final String STATUS_OK = "OK";

  @SerializedName("routes")
  private List<Route> mRoutes;

  @SerializedName("status")
  private String mStatus;

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    DirectionsResponse localDirectionsResponse;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localDirectionsResponse = (DirectionsResponse)paramObject;
      if (this.mRoutes != null)
      {
        if (this.mRoutes.equals(localDirectionsResponse.mRoutes));
      }
      else
        while (localDirectionsResponse.mRoutes != null)
          return false;
      if (this.mStatus == null)
        break;
    }
    while (this.mStatus.equals(localDirectionsResponse.mStatus));
    while (true)
    {
      return false;
      if (localDirectionsResponse.mStatus == null)
        break;
    }
  }

  public List<Route> getRoutes()
  {
    return this.mRoutes;
  }

  public int hashCode()
  {
    if (this.mRoutes != null);
    for (int i = this.mRoutes.hashCode(); ; i = 0)
    {
      int j = i * 31;
      String str = this.mStatus;
      int k = 0;
      if (str != null)
        k = this.mStatus.hashCode();
      return j + k;
    }
  }

  public boolean isSuccess()
  {
    return this.mStatus.equals("OK");
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.vendor.google.model.DirectionsResponse
 * JD-Core Version:    0.6.2
 */