package com.baidu.mapapi.cloud;

public class DetailSearchInfo extends BaseSearchInfo
{
  public int uid;

  public DetailSearchInfo()
  {
    this.a = "http://api.map.baidu.com/geosearch/v2/detail/";
  }

  String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a);
    localStringBuilder.append(this.uid).append('?');
    String str1 = this.ak;
    String str2 = null;
    if (str1 != null)
    {
      boolean bool = this.ak.equals("");
      str2 = null;
      if (!bool)
      {
        int i = this.ak.length();
        str2 = null;
        if (i <= 50)
        {
          localStringBuilder.append("ak");
          localStringBuilder.append("=");
          localStringBuilder.append(this.ak);
          int j = this.geoTableId;
          str2 = null;
          if (j != 0)
          {
            localStringBuilder.append("&");
            localStringBuilder.append("geotable_id");
            localStringBuilder.append("=");
            localStringBuilder.append(this.geoTableId);
            if ((this.sn != null) && (!this.sn.equals("")) && (this.sn.length() <= 50))
            {
              localStringBuilder.append("&");
              localStringBuilder.append("sn");
              localStringBuilder.append("=");
              localStringBuilder.append(this.sn);
            }
            str2 = localStringBuilder.toString();
          }
        }
      }
    }
    return str2;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.mapapi.cloud.DetailSearchInfo
 * JD-Core Version:    0.6.2
 */