package com.baidu.mapapi.cloud;

public class BoundSearchInfo extends BaseCloudSearchInfo
{
  public String bound;

  public BoundSearchInfo()
  {
    this.a = "http://api.map.baidu.com/geosearch/v2/bound";
  }

  String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    String str1 = super.a();
    String str2 = null;
    if (str1 != null)
    {
      localStringBuilder.append(super.a());
      String str3 = this.bound;
      str2 = null;
      if (str3 != null)
      {
        boolean bool = this.bound.equals("");
        str2 = null;
        if (!bool)
        {
          localStringBuilder.append("&");
          localStringBuilder.append("bounds");
          localStringBuilder.append("=");
          localStringBuilder.append(this.bound);
          str2 = localStringBuilder.toString();
        }
      }
    }
    return str2;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.mapapi.cloud.BoundSearchInfo
 * JD-Core Version:    0.6.2
 */