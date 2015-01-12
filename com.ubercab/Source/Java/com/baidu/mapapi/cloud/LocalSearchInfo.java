package com.baidu.mapapi.cloud;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class LocalSearchInfo extends BaseCloudSearchInfo
{
  public String region;

  public LocalSearchInfo()
  {
    this.a = "http://api.map.baidu.com/geosearch/v2/local";
  }

  String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    String str1 = super.a();
    String str2 = null;
    if (str1 != null)
    {
      localStringBuilder.append(super.a());
      String str3 = this.region;
      str2 = null;
      if (str3 != null)
      {
        boolean bool = this.region.equals("");
        str2 = null;
        if (!bool)
        {
          int i = this.region.length();
          str2 = null;
          if (i <= 25)
          {
            localStringBuilder.append("&");
            localStringBuilder.append("region");
            localStringBuilder.append("=");
          }
        }
      }
    }
    try
    {
      localStringBuilder.append(URLEncoder.encode(this.region, "UTF-8"));
      str2 = localStringBuilder.toString();
      return str2;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      while (true)
        localUnsupportedEncodingException.printStackTrace();
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.mapapi.cloud.LocalSearchInfo
 * JD-Core Version:    0.6.2
 */