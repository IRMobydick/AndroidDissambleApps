package com.ubercab.client.feature.shoppingcart;

import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;
import com.ubercab.client.core.app.RiderPreferences;
import com.ubercab.client.core.model.City;
import com.ubercab.client.core.model.VehicleView;
import com.ubercab.client.core.model.event.CityEvent;
import com.ubercab.client.core.util.PingUtils;
import com.ubercab.client.feature.shoppingcart.event.InventoryResponseEvent;
import com.ubercab.client.feature.shoppingcart.model.Inventory;
import com.ubercab.client.feature.shoppingcart.network.InventoryClient;
import com.ubercab.common.base.Preconditions;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ShoppingCartManager
{
  private final Bus mBus;
  Map<String, Inventory> mCachedInventory;
  private final InventoryClient mInventoryClient;
  private final RiderPreferences mRiderPreferences;
  List<String> mVehicleOrder;

  public ShoppingCartManager(Bus paramBus, InventoryClient paramInventoryClient, RiderPreferences paramRiderPreferences)
  {
    Preconditions.checkNotNull(paramBus);
    this.mBus = paramBus;
    this.mCachedInventory = new HashMap();
    this.mInventoryClient = paramInventoryClient;
    this.mRiderPreferences = paramRiderPreferences;
  }

  public Inventory getInventory(String paramString)
  {
    return (Inventory)this.mCachedInventory.get(paramString);
  }

  boolean hasVehicleOrderChanged(City paramCity)
  {
    return (this.mVehicleOrder == null) || (!this.mVehicleOrder.equals(paramCity.getVehicleViewsOrder()));
  }

  @Subscribe
  public void onCityEvent(CityEvent paramCityEvent)
  {
    City localCity = paramCityEvent.getCity();
    if ((!this.mRiderPreferences.isEssentialsCartFeatureFlagEnabled()) || (!PingUtils.hasVehicleViews(localCity)) || (!hasVehicleOrderChanged(localCity)))
      return;
    this.mVehicleOrder = paramCityEvent.getCity().getVehicleViewsOrder();
    HashSet localHashSet = new HashSet();
    Iterator localIterator = paramCityEvent.getCity().getVehicleViews().values().iterator();
    while (localIterator.hasNext())
    {
      VehicleView localVehicleView = (VehicleView)localIterator.next();
      if (localVehicleView.hasInventoryUrl())
      {
        String str = localVehicleView.getId();
        localHashSet.add(str);
        if (!this.mCachedInventory.containsKey(str))
          this.mInventoryClient.getInventory(str, localVehicleView.getInventoryUrl());
      }
    }
    removeInventoryForOldVehicleViews(localHashSet);
  }

  @Subscribe
  public void onInventoryResponseEvent(InventoryResponseEvent paramInventoryResponseEvent)
  {
    if (paramInventoryResponseEvent.isSuccess())
    {
      this.mCachedInventory.put(paramInventoryResponseEvent.getVehicleViewId(), paramInventoryResponseEvent.getInventory());
      return;
    }
    this.mVehicleOrder = null;
  }

  void removeInventoryForOldVehicleViews(Set<String> paramSet)
  {
    HashSet localHashSet = new HashSet();
    localHashSet.addAll(this.mCachedInventory.keySet());
    if ((paramSet == null) || (localHashSet.isEmpty()));
    while (true)
    {
      return;
      if (paramSet.isEmpty())
        this.mCachedInventory.clear();
      Iterator localIterator = localHashSet.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (!paramSet.contains(str))
          this.mCachedInventory.remove(str);
      }
    }
  }

  public void start()
  {
    this.mBus.register(this);
  }

  public void stop()
  {
    this.mBus.unregister(this);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.shoppingcart.ShoppingCartManager
 * JD-Core Version:    0.6.2
 */