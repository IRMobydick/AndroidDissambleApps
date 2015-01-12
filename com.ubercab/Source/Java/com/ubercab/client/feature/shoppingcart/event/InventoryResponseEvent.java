package com.ubercab.client.feature.shoppingcart.event;

import com.ubercab.client.feature.shoppingcart.model.Inventory;

public class InventoryResponseEvent
{
  private final Exception mException;
  private final Inventory mInventory;
  private final String mVehicleViewId;

  public InventoryResponseEvent(String paramString, Inventory paramInventory)
  {
    this.mInventory = paramInventory;
    this.mVehicleViewId = paramString;
    this.mException = null;
  }

  public InventoryResponseEvent(String paramString, Exception paramException)
  {
    this.mException = paramException;
    this.mVehicleViewId = paramString;
    this.mInventory = null;
  }

  public Exception getException()
  {
    return this.mException;
  }

  public Inventory getInventory()
  {
    return this.mInventory;
  }

  public String getVehicleViewId()
  {
    return this.mVehicleViewId;
  }

  public boolean isSuccess()
  {
    return this.mInventory != null;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.shoppingcart.event.InventoryResponseEvent
 * JD-Core Version:    0.6.2
 */