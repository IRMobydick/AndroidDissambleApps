package com.ubercab.client.core.model;

public class FareEstimateVehicleViewData
{
  private static final float DEFAULT_SURGE_MULTIPLIER = 1.0F;
  private String fareString;
  private String maxFare;
  private String minFare;
  private Float surgeMultiplier;

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    FareEstimateVehicleViewData localFareEstimateVehicleViewData;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localFareEstimateVehicleViewData = (FareEstimateVehicleViewData)paramObject;
      if (this.fareString != null)
      {
        if (this.fareString.equals(localFareEstimateVehicleViewData.fareString));
      }
      else
        while (localFareEstimateVehicleViewData.fareString != null)
          return false;
      if (this.maxFare != null)
      {
        if (this.maxFare.equals(localFareEstimateVehicleViewData.maxFare));
      }
      else
        while (localFareEstimateVehicleViewData.maxFare != null)
          return false;
      if (this.minFare != null)
      {
        if (this.minFare.equals(localFareEstimateVehicleViewData.minFare));
      }
      else
        while (localFareEstimateVehicleViewData.minFare != null)
          return false;
      if (this.surgeMultiplier == null)
        break;
    }
    while (this.surgeMultiplier.equals(localFareEstimateVehicleViewData.surgeMultiplier));
    while (true)
    {
      return false;
      if (localFareEstimateVehicleViewData.surgeMultiplier == null)
        break;
    }
  }

  public String getFareString()
  {
    return this.fareString;
  }

  public String getMaxFare()
  {
    return this.maxFare;
  }

  public String getMinFare()
  {
    return this.minFare;
  }

  public float getSurgeMultiplier()
  {
    if (this.surgeMultiplier == null)
      return 1.0F;
    return this.surgeMultiplier.floatValue();
  }

  public int hashCode()
  {
    int i;
    int k;
    label35: int m;
    if (this.fareString != null)
    {
      i = this.fareString.hashCode();
      int j = i * 31;
      if (this.maxFare == null)
        break label103;
      k = this.maxFare.hashCode();
      m = 31 * (j + k);
      if (this.minFare == null)
        break label108;
    }
    label103: label108: for (int n = this.minFare.hashCode(); ; n = 0)
    {
      int i1 = 31 * (m + n);
      Float localFloat = this.surgeMultiplier;
      int i2 = 0;
      if (localFloat != null)
        i2 = this.surgeMultiplier.hashCode();
      return i1 + i2;
      i = 0;
      break;
      k = 0;
      break label35;
    }
  }

  void setFareString(String paramString)
  {
    this.fareString = paramString;
  }

  void setMaxFare(String paramString)
  {
    this.maxFare = paramString;
  }

  void setMinFare(String paramString)
  {
    this.minFare = paramString;
  }

  void setSurgeMultiplier(float paramFloat)
  {
    this.surgeMultiplier = Float.valueOf(paramFloat);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.model.FareEstimateVehicleViewData
 * JD-Core Version:    0.6.2
 */