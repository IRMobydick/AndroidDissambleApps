package com.baidu.mapapi.cloud;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public abstract class BaseCloudSearchInfo extends BaseSearchInfo
{
  public String filter;
  public int pageIndex;
  public int pageSize = 10;
  public String q;
  public String sortby;
  public String tags;

  String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (super.a() != null)
    {
      localStringBuilder.append(super.a());
      if ((this.q != null) && (!this.q.equals("")) && (this.q.length() <= 45))
      {
        localStringBuilder.append("&");
        localStringBuilder.append("q");
        localStringBuilder.append("=");
      }
    }
    try
    {
      localStringBuilder.append(URLEncoder.encode(this.q, "UTF-8"));
      if ((this.tags != null) && (!this.tags.equals("")) && (this.tags.length() <= 45))
      {
        localStringBuilder.append("&");
        localStringBuilder.append("tags");
        localStringBuilder.append("=");
      }
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException2)
    {
      try
      {
        localStringBuilder.append(URLEncoder.encode(this.tags, "UTF-8"));
        if ((this.sortby != null) && (!this.sortby.equals("")))
        {
          localStringBuilder.append("&");
          localStringBuilder.append("sortby");
          localStringBuilder.append("=");
          localStringBuilder.append(this.sortby);
        }
        if ((this.filter != null) && (!this.filter.equals("")))
        {
          localStringBuilder.append("&");
          localStringBuilder.append("filter");
          localStringBuilder.append("=");
          localStringBuilder.append(this.filter);
        }
        if (this.pageIndex >= 0)
        {
          localStringBuilder.append("&");
          localStringBuilder.append("page_index");
          localStringBuilder.append("=");
          localStringBuilder.append(this.pageIndex);
        }
        if ((this.pageSize >= 0) && (this.pageSize <= 50))
        {
          localStringBuilder.append("&");
          localStringBuilder.append("page_size");
          localStringBuilder.append("=");
          localStringBuilder.append(this.pageSize);
        }
        return localStringBuilder.toString();
        return null;
        localUnsupportedEncodingException2 = localUnsupportedEncodingException2;
        localUnsupportedEncodingException2.printStackTrace();
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException1)
      {
        while (true)
          localUnsupportedEncodingException1.printStackTrace();
      }
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.mapapi.cloud.BaseCloudSearchInfo
 * JD-Core Version:    0.6.2
 */