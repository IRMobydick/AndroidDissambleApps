package com.ubercab.client.core.model;

import java.util.List;

public final class FeedbackType
{
  private String description;
  private Integer id;
  private List<FeedbackImages> images;
  private String type;

  public FeedbackType()
  {
  }

  public FeedbackType(String paramString)
  {
    this.description = paramString;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    FeedbackType localFeedbackType;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localFeedbackType = (FeedbackType)paramObject;
      if (this.description != null)
      {
        if (this.description.equals(localFeedbackType.description));
      }
      else
        while (localFeedbackType.description != null)
          return false;
      if (this.id != null)
      {
        if (this.id.equals(localFeedbackType.id));
      }
      else
        while (localFeedbackType.id != null)
          return false;
      if (this.images != null)
      {
        if (this.images.equals(localFeedbackType.images));
      }
      else
        while (localFeedbackType.images != null)
          return false;
      if (this.type == null)
        break;
    }
    while (this.type.equals(localFeedbackType.type));
    while (true)
    {
      return false;
      if (localFeedbackType.type == null)
        break;
    }
  }

  public String getDescription()
  {
    return this.description;
  }

  public int getId()
  {
    if (this.id == null)
      return 0;
    return this.id.intValue();
  }

  public List<FeedbackImages> getImages()
  {
    return this.images;
  }

  public String getType()
  {
    return this.type;
  }

  public int hashCode()
  {
    int i;
    int k;
    label35: int m;
    if (this.id != null)
    {
      i = this.id.hashCode();
      int j = i * 31;
      if (this.type == null)
        break label105;
      k = this.type.hashCode();
      m = 31 * (j + k);
      if (this.description == null)
        break label110;
    }
    label105: label110: for (int n = this.description.hashCode(); ; n = 0)
    {
      int i1 = 31 * (m + n);
      List localList = this.images;
      int i2 = 0;
      if (localList != null)
        i2 = this.images.hashCode();
      return i1 + i2;
      i = 0;
      break;
      k = 0;
      break label35;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.model.FeedbackType
 * JD-Core Version:    0.6.2
 */