package com.baidu.mapapi.cloud;

public class NearbySearchInfo extends BaseCloudSearchInfo
{
  public String location;
  public int radius = 1000;

  public NearbySearchInfo()
  {
    this.a = "http://api.map.baidu.com/geosearch/v2/nearby";
  }

  String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    String str1 = super.a();
    String str2 = null;
    if (str1 != null)
    {
      localStringBuilder.append(super.a());
      String str3 = this.location;
      str2 = null;
      if (str3 != null)
      {
        boolean bool = this.location.equals("");
        str2 = null;
        if (!bool)
        {
          localStringBuilder.append("&");
          localStringBuilder.append("location");
          localStringBuilder.append("=");
          localStringBuilder.append(this.location);
          if (this.radius >= 0)
          {
            localStringBuilder.append("&");
            localStringBuilder.append("radius");
            localStringBuilder.append("=");
            localStringBuilder.append(this.radius);
          }
          str2 = localStringBuilder.toString();
        }
      }
    }
    return str2;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.mapapi.cloud.NearbySearchInfo
 * JD-Core Version:    0.6.2
 */