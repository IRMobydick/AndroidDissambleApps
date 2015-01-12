package com.ubercab.client.core.model;

public class TripLegAction
{
  public static final String TYPE_DROPOFF = "Dropoff";
  public static final String TYPE_PICKUP = "Pickup";
  String entityRef;
  String type;

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    TripLegAction localTripLegAction;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localTripLegAction = (TripLegAction)paramObject;
      if (this.entityRef != null)
      {
        if (this.entityRef.equals(localTripLegAction.entityRef));
      }
      else
        while (localTripLegAction.entityRef != null)
          return false;
      if (this.type == null)
        break;
    }
    while (this.type.equals(localTripLegAction.type));
    while (true)
    {
      return false;
      if (localTripLegAction.type == null)
        break;
    }
  }

  public String getEntityRef()
  {
    return this.entityRef;
  }

  public String getType()
  {
    return this.type;
  }

  public int hashCode()
  {
    if (this.type != null);
    for (int i = this.type.hashCode(); ; i = 0)
    {
      int j = i * 31;
      String str = this.entityRef;
      int k = 0;
      if (str != null)
        k = this.entityRef.hashCode();
      return j + k;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.model.TripLegAction
 * JD-Core Version:    0.6.2
 */