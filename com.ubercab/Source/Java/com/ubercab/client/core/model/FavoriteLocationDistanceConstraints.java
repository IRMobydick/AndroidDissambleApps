package com.ubercab.client.core.model;

public final class FavoriteLocationDistanceConstraints
{
  Integer maximumDropoffDistanceInMeters;
  Integer maximumPickupDistanceInMeters;
  Integer minimumDropoffDistanceInMeters;

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    FavoriteLocationDistanceConstraints localFavoriteLocationDistanceConstraints;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localFavoriteLocationDistanceConstraints = (FavoriteLocationDistanceConstraints)paramObject;
      if (this.maximumDropoffDistanceInMeters != null)
      {
        if (this.maximumDropoffDistanceInMeters.equals(localFavoriteLocationDistanceConstraints.maximumDropoffDistanceInMeters));
      }
      else
        while (localFavoriteLocationDistanceConstraints.maximumDropoffDistanceInMeters != null)
          return false;
      if (this.maximumPickupDistanceInMeters != null)
      {
        if (this.maximumPickupDistanceInMeters.equals(localFavoriteLocationDistanceConstraints.maximumPickupDistanceInMeters));
      }
      else
        while (localFavoriteLocationDistanceConstraints.maximumPickupDistanceInMeters != null)
          return false;
      if (this.minimumDropoffDistanceInMeters == null)
        break;
    }
    while (this.minimumDropoffDistanceInMeters.equals(localFavoriteLocationDistanceConstraints.minimumDropoffDistanceInMeters));
    while (true)
    {
      return false;
      if (localFavoriteLocationDistanceConstraints.minimumDropoffDistanceInMeters == null)
        break;
    }
  }

  public Integer getMaximumDropoffDistanceInMeters()
  {
    return this.maximumDropoffDistanceInMeters;
  }

  public Integer getMaximumPickupDistanceInMeters()
  {
    return this.maximumPickupDistanceInMeters;
  }

  public Integer getMinimumDropoffDistanceInMeters()
  {
    return this.minimumDropoffDistanceInMeters;
  }

  public int hashCode()
  {
    int i;
    int j;
    if (this.maximumPickupDistanceInMeters != null)
    {
      i = this.maximumPickupDistanceInMeters.hashCode();
      j = i * 31;
      if (this.minimumDropoffDistanceInMeters == null)
        break label77;
    }
    label77: for (int k = this.minimumDropoffDistanceInMeters.hashCode(); ; k = 0)
    {
      int m = 31 * (j + k);
      Integer localInteger = this.maximumDropoffDistanceInMeters;
      int n = 0;
      if (localInteger != null)
        n = this.maximumDropoffDistanceInMeters.hashCode();
      return m + n;
      i = 0;
      break;
    }
  }

  public void setMaximumDropoffDistanceInMeters(int paramInt)
  {
    this.maximumDropoffDistanceInMeters = Integer.valueOf(paramInt);
  }

  public void setMaximumPickupDistanceInMeters(int paramInt)
  {
    this.maximumPickupDistanceInMeters = Integer.valueOf(paramInt);
  }

  public void setMinimumDropoffDistanceInMeters(int paramInt)
  {
    this.minimumDropoffDistanceInMeters = Integer.valueOf(paramInt);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.model.FavoriteLocationDistanceConstraints
 * JD-Core Version:    0.6.2
 */