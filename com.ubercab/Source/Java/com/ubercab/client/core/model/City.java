package com.ubercab.client.core.model;

import java.util.List;
import java.util.Map;

public class City
{
  String cityName;
  String currencyCode;
  String defaultVehicleViewId;
  LegacyMobileMessage event;
  List<MobileMessage> messages;
  Map<String, VehicleView> vehicleViews;
  List<String> vehicleViewsOrder;

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    City localCity;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localCity = (City)paramObject;
      if (this.cityName != null)
      {
        if (this.cityName.equals(localCity.cityName));
      }
      else
        while (localCity.cityName != null)
          return false;
      if (this.currencyCode != null)
      {
        if (this.currencyCode.equals(localCity.currencyCode));
      }
      else
        while (localCity.currencyCode != null)
          return false;
      if (this.defaultVehicleViewId != null)
      {
        if (this.defaultVehicleViewId.equals(localCity.defaultVehicleViewId));
      }
      else
        while (localCity.defaultVehicleViewId != null)
          return false;
      if (this.event != null)
      {
        if (this.event.equals(localCity.event));
      }
      else
        while (localCity.event != null)
          return false;
      if (this.messages != null)
      {
        if (this.messages.equals(localCity.messages));
      }
      else
        while (localCity.messages != null)
          return false;
      if (this.vehicleViews != null)
      {
        if (this.vehicleViews.equals(localCity.vehicleViews));
      }
      else
        while (localCity.vehicleViews != null)
          return false;
      if (this.vehicleViewsOrder == null)
        break;
    }
    while (this.vehicleViewsOrder.equals(localCity.vehicleViewsOrder));
    while (true)
    {
      return false;
      if (localCity.vehicleViewsOrder == null)
        break;
    }
  }

  public VehicleView findVehicleView(String paramString)
  {
    if ((this.vehicleViews == null) || (!this.vehicleViews.containsKey(paramString)))
      return null;
    return (VehicleView)this.vehicleViews.get(paramString);
  }

  public String getCityName()
  {
    return this.cityName;
  }

  public String getCurrencyCode()
  {
    return this.currencyCode;
  }

  public String getDefaultVehicleViewId()
  {
    return this.defaultVehicleViewId;
  }

  public LegacyMobileMessage getEvent()
  {
    return this.event;
  }

  public List<MobileMessage> getMessages()
  {
    return this.messages;
  }

  public Map<String, VehicleView> getVehicleViews()
  {
    return this.vehicleViews;
  }

  public List<String> getVehicleViewsOrder()
  {
    return this.vehicleViewsOrder;
  }

  public int hashCode()
  {
    int i;
    int k;
    label35: int n;
    label59: int i2;
    label85: int i4;
    label113: int i5;
    if (this.cityName != null)
    {
      i = this.cityName.hashCode();
      int j = i * 31;
      if (this.currencyCode == null)
        break label187;
      k = this.currencyCode.hashCode();
      int m = 31 * (j + k);
      if (this.defaultVehicleViewId == null)
        break label192;
      n = this.defaultVehicleViewId.hashCode();
      int i1 = 31 * (m + n);
      if (this.event == null)
        break label198;
      i2 = this.event.hashCode();
      int i3 = 31 * (i1 + i2);
      if (this.messages == null)
        break label204;
      i4 = this.messages.hashCode();
      i5 = 31 * (i3 + i4);
      if (this.vehicleViews == null)
        break label210;
    }
    label187: label192: label198: label204: label210: for (int i6 = this.vehicleViews.hashCode(); ; i6 = 0)
    {
      int i7 = 31 * (i5 + i6);
      List localList = this.vehicleViewsOrder;
      int i8 = 0;
      if (localList != null)
        i8 = this.vehicleViewsOrder.hashCode();
      return i7 + i8;
      i = 0;
      break;
      k = 0;
      break label35;
      n = 0;
      break label59;
      i2 = 0;
      break label85;
      i4 = 0;
      break label113;
    }
  }

  void setCityName(String paramString)
  {
    this.cityName = paramString;
  }

  public void setEvent(LegacyMobileMessage paramLegacyMobileMessage)
  {
    this.event = paramLegacyMobileMessage;
  }

  public void setMessages(List<MobileMessage> paramList)
  {
    this.messages = paramList;
  }

  void setVehicleViews(Map<String, VehicleView> paramMap)
  {
    this.vehicleViews = paramMap;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.model.City
 * JD-Core Version:    0.6.2
 */