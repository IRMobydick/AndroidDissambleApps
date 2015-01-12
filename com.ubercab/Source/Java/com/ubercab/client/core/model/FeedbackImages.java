package com.ubercab.client.core.model;

public final class FeedbackImages
{
  private Integer height;
  private String url;
  private Integer width;

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    FeedbackImages localFeedbackImages;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localFeedbackImages = (FeedbackImages)paramObject;
      if (this.height != null)
      {
        if (this.height.equals(localFeedbackImages.height));
      }
      else
        while (localFeedbackImages.height != null)
          return false;
      if (this.url != null)
      {
        if (this.url.equals(localFeedbackImages.url));
      }
      else
        while (localFeedbackImages.url != null)
          return false;
      if (this.width == null)
        break;
    }
    while (this.width.equals(localFeedbackImages.width));
    while (true)
    {
      return false;
      if (localFeedbackImages.width == null)
        break;
    }
  }

  public Integer getHeight()
  {
    if (this.height == null);
    for (int i = 0; ; i = this.height.intValue())
      return Integer.valueOf(i);
  }

  public String getUrl()
  {
    return this.url;
  }

  public Integer getWidth()
  {
    if (this.width == null);
    for (int i = 0; ; i = this.width.intValue())
      return Integer.valueOf(i);
  }

  public int hashCode()
  {
    int i;
    int j;
    if (this.height != null)
    {
      i = this.height.hashCode();
      j = i * 31;
      if (this.width == null)
        break label77;
    }
    label77: for (int k = this.width.hashCode(); ; k = 0)
    {
      int m = 31 * (j + k);
      String str = this.url;
      int n = 0;
      if (str != null)
        n = this.url.hashCode();
      return m + n;
      i = 0;
      break;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.model.FeedbackImages
 * JD-Core Version:    0.6.2
 */