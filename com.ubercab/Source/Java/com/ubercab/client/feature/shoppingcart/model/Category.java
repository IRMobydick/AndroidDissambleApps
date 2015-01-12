package com.ubercab.client.feature.shoppingcart.model;

import java.util.List;

public class Category
{
  String description;
  String displayTitle;
  String imageUrlOriginal;
  List<CategoryMembership> memberships;
  String title;
  String uuid;

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    Category localCategory;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localCategory = (Category)paramObject;
      if (this.description != null)
      {
        if (this.description.equals(localCategory.description));
      }
      else
        while (localCategory.description != null)
          return false;
      if (this.displayTitle != null)
      {
        if (this.displayTitle.equals(localCategory.displayTitle));
      }
      else
        while (localCategory.displayTitle != null)
          return false;
      if (this.imageUrlOriginal != null)
      {
        if (this.imageUrlOriginal.equals(localCategory.imageUrlOriginal));
      }
      else
        while (localCategory.imageUrlOriginal != null)
          return false;
      if (this.memberships != null)
      {
        if (this.memberships.equals(localCategory.memberships));
      }
      else
        while (localCategory.memberships != null)
          return false;
      if (this.title != null)
      {
        if (this.title.equals(localCategory.title));
      }
      else
        while (localCategory.title != null)
          return false;
      if (this.uuid == null)
        break;
    }
    while (this.uuid.equals(localCategory.uuid));
    while (true)
    {
      return false;
      if (localCategory.uuid == null)
        break;
    }
  }

  public String getDescription()
  {
    return this.description;
  }

  public String getDisplayTitle()
  {
    return this.displayTitle;
  }

  public String getImageUrlOriginal()
  {
    return this.imageUrlOriginal;
  }

  public List<CategoryMembership> getMemberships()
  {
    return this.memberships;
  }

  public String getTitle()
  {
    return this.title;
  }

  public String getUuid()
  {
    return this.uuid;
  }

  public int hashCode()
  {
    int i;
    int k;
    label35: int n;
    label59: int i2;
    label87: int i3;
    if (this.description != null)
    {
      i = this.description.hashCode();
      int j = i * 31;
      if (this.displayTitle == null)
        break label157;
      k = this.displayTitle.hashCode();
      int m = 31 * (j + k);
      if (this.imageUrlOriginal == null)
        break label162;
      n = this.imageUrlOriginal.hashCode();
      int i1 = 31 * (m + n);
      if (this.memberships == null)
        break label168;
      i2 = this.memberships.hashCode();
      i3 = 31 * (i1 + i2);
      if (this.title == null)
        break label174;
    }
    label157: label162: label168: label174: for (int i4 = this.title.hashCode(); ; i4 = 0)
    {
      int i5 = 31 * (i3 + i4);
      String str = this.uuid;
      int i6 = 0;
      if (str != null)
        i6 = this.uuid.hashCode();
      return i5 + i6;
      i = 0;
      break;
      k = 0;
      break label35;
      n = 0;
      break label59;
      i2 = 0;
      break label87;
    }
  }

  public void setDescription(String paramString)
  {
    this.description = paramString;
  }

  public void setDisplayTitle(String paramString)
  {
    this.displayTitle = paramString;
  }

  public void setImageUrlOriginal(String paramString)
  {
    this.imageUrlOriginal = paramString;
  }

  public void setMemberships(List<CategoryMembership> paramList)
  {
    this.memberships = paramList;
  }

  public void setTitle(String paramString)
  {
    this.title = paramString;
  }

  public void setUuid(String paramString)
  {
    this.uuid = paramString;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.shoppingcart.model.Category
 * JD-Core Version:    0.6.2
 */