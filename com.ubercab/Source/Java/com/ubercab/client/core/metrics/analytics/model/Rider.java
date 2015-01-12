package com.ubercab.client.core.metrics.analytics.model;

import android.content.Context;

final class Rider
{
  Product current_product;
  Device device;
  String driver_id;
  String driver_status;
  String rider_id;
  String rider_status;
  String trip_id;
  String version;

  Rider(Context paramContext)
  {
    this.device = new Device(paramContext);
    this.version = "3.23.2";
  }

  Product getCurrentProduct()
  {
    return this.current_product;
  }

  String getRiderId()
  {
    return this.rider_id;
  }

  void setCurrentProduct(Product paramProduct)
  {
    this.current_product = paramProduct;
  }

  void setCurrentProductId(String paramString)
  {
    if (paramString == null)
      this.current_product = null;
    while ((this.current_product != null) && (paramString.equals(this.current_product.getId())))
      return;
    this.current_product = new Product();
    this.current_product.setId(paramString);
  }

  void setDevice(Device paramDevice)
  {
    this.device = paramDevice;
  }

  void setDriverId(String paramString)
  {
    this.driver_id = paramString;
  }

  void setDriverStatus(String paramString)
  {
    this.driver_status = paramString;
  }

  void setRiderId(String paramString)
  {
    this.rider_id = paramString;
  }

  void setRiderStatus(String paramString)
  {
    this.rider_status = paramString;
  }

  void setTripId(String paramString)
  {
    this.trip_id = paramString;
  }

  void setVersion(String paramString)
  {
    this.version = paramString;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.metrics.analytics.model.Rider
 * JD-Core Version:    0.6.2
 */