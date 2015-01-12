package com.ubercab.client.core.model;

public final class LocationTagDeleteResponse
{
  private String status;

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    LocationTagDeleteResponse localLocationTagDeleteResponse;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localLocationTagDeleteResponse = (LocationTagDeleteResponse)paramObject;
      if (this.status == null)
        break;
    }
    while (this.status.equals(localLocationTagDeleteResponse.status));
    while (true)
    {
      return false;
      if (localLocationTagDeleteResponse.status == null)
        break;
    }
  }

  public int hashCode()
  {
    if (this.status != null)
      return this.status.hashCode();
    return 0;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.model.LocationTagDeleteResponse
 * JD-Core Version:    0.6.2
 */