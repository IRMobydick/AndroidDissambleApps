package com.ubercab.client.core.model;

public class VehicleViewTagline
{
  String detail;
  String title;

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    VehicleViewTagline localVehicleViewTagline;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localVehicleViewTagline = (VehicleViewTagline)paramObject;
      if (this.detail != null)
      {
        if (this.detail.equals(localVehicleViewTagline.detail));
      }
      else
        while (localVehicleViewTagline.detail != null)
          return false;
      if (this.title == null)
        break;
    }
    while (this.title.equals(localVehicleViewTagline.title));
    while (true)
    {
      return false;
      if (localVehicleViewTagline.title == null)
        break;
    }
  }

  public String getDetail()
  {
    return this.detail;
  }

  public String getTitle()
  {
    return this.title;
  }

  public int hashCode()
  {
    if (this.title != null);
    for (int i = this.title.hashCode(); ; i = 0)
    {
      int j = i * 31;
      String str = this.detail;
      int k = 0;
      if (str != null)
        k = this.detail.hashCode();
      return j + k;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.model.VehicleViewTagline
 * JD-Core Version:    0.6.2
 */