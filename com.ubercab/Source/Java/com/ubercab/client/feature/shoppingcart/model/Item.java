package com.ubercab.client.feature.shoppingcart.model;

import java.util.List;

public class Item
{
  String description;
  String imageUrlOriginal;
  Integer itemId;
  List<CategoryMembership> memberships;
  Double price;
  Double taxRate;
  String title;

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    Item localItem;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localItem = (Item)paramObject;
      if (this.description != null)
      {
        if (this.description.equals(localItem.description));
      }
      else
        while (localItem.description != null)
          return false;
      if (this.imageUrlOriginal != null)
      {
        if (this.imageUrlOriginal.equals(localItem.imageUrlOriginal));
      }
      else
        while (localItem.imageUrlOriginal != null)
          return false;
      if (this.itemId != null)
      {
        if (this.itemId.equals(localItem.itemId));
      }
      else
        while (localItem.itemId != null)
          return false;
      if (this.memberships != null)
      {
        if (this.memberships.equals(localItem.memberships));
      }
      else
        while (localItem.memberships != null)
          return false;
      if (this.price != null)
      {
        if (this.price.equals(localItem.price));
      }
      else
        while (localItem.price != null)
          return false;
      if (this.taxRate != null)
      {
        if (this.taxRate.equals(localItem.taxRate));
      }
      else
        while (localItem.taxRate != null)
          return false;
      if (this.title == null)
        break;
    }
    while (this.title.equals(localItem.title));
    while (true)
    {
      return false;
      if (localItem.title == null)
        break;
    }
  }

  public String getDescription()
  {
    return this.description;
  }

  public String getImageUrlOriginal()
  {
    return this.imageUrlOriginal;
  }

  public int getItemId()
  {
    if (this.itemId == null)
      return 0;
    return this.itemId.intValue();
  }

  public List<CategoryMembership> getMemberships()
  {
    return this.memberships;
  }

  public Double getPrice()
  {
    return this.price;
  }

  public Double getTaxRate()
  {
    return this.taxRate;
  }

  public String getTitle()
  {
    return this.title;
  }

  public int hashCode()
  {
    int i;
    int k;
    label35: int n;
    label59: int i2;
    label87: int i4;
    label113: int i5;
    if (this.description != null)
    {
      i = this.description.hashCode();
      int j = i * 31;
      if (this.imageUrlOriginal == null)
        break label183;
      k = this.imageUrlOriginal.hashCode();
      int m = 31 * (j + k);
      if (this.itemId == null)
        break label188;
      n = this.itemId.hashCode();
      int i1 = 31 * (m + n);
      if (this.memberships == null)
        break label194;
      i2 = this.memberships.hashCode();
      int i3 = 31 * (i1 + i2);
      if (this.price == null)
        break label200;
      i4 = this.price.hashCode();
      i5 = 31 * (i3 + i4);
      if (this.taxRate == null)
        break label206;
    }
    label183: label188: label194: label200: label206: for (int i6 = this.taxRate.hashCode(); ; i6 = 0)
    {
      int i7 = 31 * (i5 + i6);
      String str = this.title;
      int i8 = 0;
      if (str != null)
        i8 = this.title.hashCode();
      return i7 + i8;
      i = 0;
      break;
      k = 0;
      break label35;
      n = 0;
      break label59;
      i2 = 0;
      break label87;
      i4 = 0;
      break label113;
    }
  }

  public void setDescription(String paramString)
  {
    this.description = paramString;
  }

  public void setImageUrlOriginal(String paramString)
  {
    this.imageUrlOriginal = paramString;
  }

  public void setItemId(Integer paramInteger)
  {
    this.itemId = paramInteger;
  }

  public void setMemberships(List<CategoryMembership> paramList)
  {
    this.memberships = paramList;
  }

  public void setPrice(Double paramDouble)
  {
    this.price = paramDouble;
  }

  public void setTaxRate(Double paramDouble)
  {
    this.taxRate = paramDouble;
  }

  public void setTitle(String paramString)
  {
    this.title = paramString;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.shoppingcart.model.Item
 * JD-Core Version:    0.6.2
 */