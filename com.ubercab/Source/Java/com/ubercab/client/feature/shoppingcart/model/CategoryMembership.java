package com.ubercab.client.feature.shoppingcart.model;

public class CategoryMembership
{
  Integer priority;
  String uuid;

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    CategoryMembership localCategoryMembership;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localCategoryMembership = (CategoryMembership)paramObject;
      if (this.priority != null)
      {
        if (this.priority.equals(localCategoryMembership.priority));
      }
      else
        while (localCategoryMembership.priority != null)
          return false;
      if (this.uuid == null)
        break;
    }
    while (this.uuid.equals(localCategoryMembership.uuid));
    while (true)
    {
      return false;
      if (localCategoryMembership.uuid == null)
        break;
    }
  }

  public int getPriority()
  {
    if (this.priority == null)
      return 0;
    return this.priority.intValue();
  }

  public String getUuid()
  {
    return this.uuid;
  }

  public int hashCode()
  {
    if (this.priority != null);
    for (int i = this.priority.hashCode(); ; i = 0)
    {
      int j = i * 31;
      String str = this.uuid;
      int k = 0;
      if (str != null)
        k = this.uuid.hashCode();
      return j + k;
    }
  }

  public void setPriority(Integer paramInteger)
  {
    this.priority = paramInteger;
  }

  public void setUuid(String paramString)
  {
    this.uuid = paramString;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.shoppingcart.model.CategoryMembership
 * JD-Core Version:    0.6.2
 */