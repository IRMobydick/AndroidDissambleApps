package com.ubercab.client.core.model;

public final class FareEstimateRange
{
  private Float maxFare;
  private Float minFare;

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    FareEstimateRange localFareEstimateRange;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localFareEstimateRange = (FareEstimateRange)paramObject;
      if (this.maxFare != null)
      {
        if (this.maxFare.equals(localFareEstimateRange.maxFare));
      }
      else
        while (localFareEstimateRange.maxFare != null)
          return false;
      if (this.minFare == null)
        break;
    }
    while (this.minFare.equals(localFareEstimateRange.minFare));
    while (true)
    {
      return false;
      if (localFareEstimateRange.minFare == null)
        break;
    }
  }

  public Float getMaxFare()
  {
    return this.maxFare;
  }

  public Float getMinFare()
  {
    return this.minFare;
  }

  public int hashCode()
  {
    if (this.minFare != null);
    for (int i = this.minFare.hashCode(); ; i = 0)
    {
      int j = i * 31;
      Float localFloat = this.maxFare;
      int k = 0;
      if (localFloat != null)
        k = this.maxFare.hashCode();
      return j + k;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.model.FareEstimateRange
 * JD-Core Version:    0.6.2
 */