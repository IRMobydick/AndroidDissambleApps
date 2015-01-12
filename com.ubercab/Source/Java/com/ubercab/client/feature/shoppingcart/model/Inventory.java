package com.ubercab.client.feature.shoppingcart.model;

import java.util.List;

public class Inventory
{
  List<Category> categories;
  Integer itemCount;
  List<Item> items;

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    Inventory localInventory;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localInventory = (Inventory)paramObject;
      if (this.categories != null)
      {
        if (this.categories.equals(localInventory.categories));
      }
      else
        while (localInventory.categories != null)
          return false;
      if (this.itemCount != null)
      {
        if (this.itemCount.equals(localInventory.itemCount));
      }
      else
        while (localInventory.itemCount != null)
          return false;
      if (this.items == null)
        break;
    }
    while (this.items.equals(localInventory.items));
    while (true)
    {
      return false;
      if (localInventory.items == null)
        break;
    }
  }

  public List<Category> getCategories()
  {
    return this.categories;
  }

  public int getItemCount()
  {
    if (this.itemCount == null)
      return 0;
    return this.itemCount.intValue();
  }

  public List<Item> getItems()
  {
    return this.items;
  }

  public int hashCode()
  {
    int i;
    int j;
    if (this.items != null)
    {
      i = this.items.hashCode();
      j = i * 31;
      if (this.categories == null)
        break label81;
    }
    label81: for (int k = this.categories.hashCode(); ; k = 0)
    {
      int m = 31 * (j + k);
      Integer localInteger = this.itemCount;
      int n = 0;
      if (localInteger != null)
        n = this.itemCount.hashCode();
      return m + n;
      i = 0;
      break;
    }
  }

  public void setCategories(List<Category> paramList)
  {
    this.categories = paramList;
  }

  public void setItemCount(Integer paramInteger)
  {
    this.itemCount = paramInteger;
  }

  public void setItems(List<Item> paramList)
  {
    this.items = paramList;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.shoppingcart.model.Inventory
 * JD-Core Version:    0.6.2
 */