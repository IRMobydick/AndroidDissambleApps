package com.baidu.mapapi.search.poi;

import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.core.SearchResult.ERRORNO;
import org.json.JSONException;
import org.json.JSONObject;

public class PoiDetailResult extends SearchResult
{
  int a;
  String b;
  String c;
  LatLng d;
  String e;
  String f;
  String g;
  String h;
  String i;
  String j;
  double k;
  double l;
  double m;
  double n;
  double o;
  double p;
  double q;
  double r;
  int s;
  int t;
  int u;
  int v;
  int w;
  String x;

  PoiDetailResult()
  {
  }

  public PoiDetailResult(SearchResult.ERRORNO paramERRORNO)
  {
    super(paramERRORNO);
  }

  boolean a(String paramString)
  {
    try
    {
      JSONObject localJSONObject1 = new JSONObject(paramString);
      this.a = localJSONObject1.optInt("status");
      int i1 = this.a;
      boolean bool = false;
      if (i1 == 0)
      {
        this.b = localJSONObject1.optString("message");
        JSONObject localJSONObject2 = localJSONObject1.optJSONObject("result");
        bool = false;
        if (localJSONObject2 != null)
        {
          this.c = localJSONObject2.optString("name");
          JSONObject localJSONObject3 = localJSONObject2.optJSONObject("location");
          this.d = new LatLng(localJSONObject3.optDouble("lat"), localJSONObject3.optDouble("lng"));
          this.e = localJSONObject2.optString("address");
          this.f = localJSONObject2.optString("telephone");
          this.g = localJSONObject2.optString("uid");
          JSONObject localJSONObject4 = localJSONObject2.optJSONObject("detail_info");
          this.h = localJSONObject4.optString("tag");
          this.i = localJSONObject4.optString("detail_url");
          this.j = localJSONObject4.optString("type");
          this.k = localJSONObject4.optDouble("price", 0.0D);
          this.l = localJSONObject4.optDouble("overall_rating", 0.0D);
          this.m = localJSONObject4.optDouble("taste_rating", 0.0D);
          this.n = localJSONObject4.optDouble("service_rating", 0.0D);
          this.o = localJSONObject4.optDouble("environment_rating", 0.0D);
          this.p = localJSONObject4.optDouble("facility_rating", 0.0D);
          this.q = localJSONObject4.optDouble("hygiene_rating", 0.0D);
          this.r = localJSONObject4.optDouble("technology_rating", 0.0D);
          this.s = localJSONObject4.optInt("image_num");
          this.t = localJSONObject4.optInt("groupon_num");
          this.u = localJSONObject4.optInt("comment_num");
          this.v = localJSONObject4.optInt("favorite_num");
          this.w = localJSONObject4.optInt("checkin_num");
          this.x = localJSONObject4.optString("shop_hours");
          bool = true;
        }
      }
      return bool;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return false;
  }

  public String getAddress()
  {
    return this.e;
  }

  public int getCheckinNum()
  {
    return this.w;
  }

  public int getCommentNum()
  {
    return this.u;
  }

  public String getDetailUrl()
  {
    return this.i;
  }

  public double getEnvironmentRating()
  {
    return this.o;
  }

  public double getFacilityRating()
  {
    return this.p;
  }

  public int getFavoriteNum()
  {
    return this.v;
  }

  public int getGrouponNum()
  {
    return this.t;
  }

  public double getHygieneRating()
  {
    return this.q;
  }

  public int getImageNum()
  {
    return this.s;
  }

  public LatLng getLocation()
  {
    return this.d;
  }

  public String getName()
  {
    return this.c;
  }

  public double getOverallRating()
  {
    return this.l;
  }

  public double getPrice()
  {
    return this.k;
  }

  public double getServiceRating()
  {
    return this.n;
  }

  public String getShopHours()
  {
    return this.x;
  }

  public String getTag()
  {
    return this.h;
  }

  public double getTasteRating()
  {
    return this.m;
  }

  public double getTechnologyRating()
  {
    return this.r;
  }

  public String getTelephone()
  {
    return this.f;
  }

  public String getType()
  {
    return this.j;
  }

  public String getUid()
  {
    return this.g;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.mapapi.search.poi.PoiDetailResult
 * JD-Core Version:    0.6.2
 */