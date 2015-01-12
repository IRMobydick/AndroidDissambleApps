package com.ubercab.client.core.model;

public class TripVehiclePictureImage
{
  Integer height;
  String url;
  Integer width;

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    TripVehiclePictureImage localTripVehiclePictureImage;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localTripVehiclePictureImage = (TripVehiclePictureImage)paramObject;
      if (this.height != null)
      {
        if (this.height.equals(localTripVehiclePictureImage.height));
      }
      else
        while (localTripVehiclePictureImage.height != null)
          return false;
      if (this.url != null)
      {
        if (this.url.equals(localTripVehiclePictureImage.url));
      }
      else
        while (localTripVehiclePictureImage.url != null)
          return false;
      if (this.width == null)
        break;
    }
    while (this.width.equals(localTripVehiclePictureImage.width));
    while (true)
    {
      return false;
      if (localTripVehiclePictureImage.width == null)
        break;
    }
  }

  public Integer getHeight()
  {
    return this.height;
  }

  public String getUrl()
  {
    return this.url;
  }

  public Integer getWidth()
  {
    return this.width;
  }

  public int hashCode()
  {
    int i;
    int j;
    if (this.width != null)
    {
      i = this.width.hashCode();
      j = i * 31;
      if (this.height == null)
        break label77;
    }
    label77: for (int k = this.height.hashCode(); ; k = 0)
    {
      int m = 31 * (j + k);
      String str = this.url;
      int n = 0;
      if (str != null)
        n = this.url.hashCode();
      return m + n;
      i = 0;
      break;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.model.TripVehiclePictureImage
 * JD-Core Version:    0.6.2
 */