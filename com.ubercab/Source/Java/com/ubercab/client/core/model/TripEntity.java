package com.ubercab.client.core.model;

public class TripEntity
{
  public static final String TYPE_USER = "user";
  String pictureUrl;
  String title;
  String type;
  String uuid;

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    TripEntity localTripEntity;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localTripEntity = (TripEntity)paramObject;
      if (this.uuid != null)
      {
        if (this.uuid.equals(localTripEntity.uuid));
      }
      else
        while (localTripEntity.uuid != null)
          return false;
      if (this.pictureUrl != null)
      {
        if (this.pictureUrl.equals(localTripEntity.pictureUrl));
      }
      else
        while (localTripEntity.pictureUrl != null)
          return false;
      if (this.title != null)
      {
        if (this.title.equals(localTripEntity.title));
      }
      else
        while (localTripEntity.title != null)
          return false;
      if (this.type == null)
        break;
    }
    while (this.type.equals(localTripEntity.type));
    while (true)
    {
      return false;
      if (localTripEntity.type == null)
        break;
    }
  }

  public String getPictureUrl()
  {
    return this.pictureUrl;
  }

  public String getTitle()
  {
    return this.title;
  }

  public String getType()
  {
    return this.type;
  }

  public String getUuid()
  {
    return this.uuid;
  }

  public int hashCode()
  {
    int i;
    int k;
    label35: int m;
    if (this.uuid != null)
    {
      i = this.uuid.hashCode();
      int j = i * 31;
      if (this.pictureUrl == null)
        break label103;
      k = this.pictureUrl.hashCode();
      m = 31 * (j + k);
      if (this.title == null)
        break label108;
    }
    label103: label108: for (int n = this.title.hashCode(); ; n = 0)
    {
      int i1 = 31 * (m + n);
      String str = this.type;
      int i2 = 0;
      if (str != null)
        i2 = this.type.hashCode();
      return i1 + i2;
      i = 0;
      break;
      k = 0;
      break label35;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.model.TripEntity
 * JD-Core Version:    0.6.2
 */