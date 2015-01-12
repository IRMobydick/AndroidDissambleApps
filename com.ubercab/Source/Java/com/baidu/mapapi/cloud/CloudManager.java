package com.baidu.mapapi.cloud;

import android.os.Bundle;
import android.os.Handler;

public class CloudManager
{
  private static final String a = CloudManager.class.getSimpleName();
  private static CloudManager c;
  private Bundle b = null;
  private com.baidu.platform.comjni.map.cloud.a d;
  private Handler e;
  private CloudListener f;

  private String a(int paramInt)
  {
    String str = this.d.a(paramInt);
    if ((str != null) && (str.trim().length() <= 0))
      str = null;
    return str;
  }

  private boolean a(BaseCloudSearchInfo paramBaseCloudSearchInfo)
  {
    if (paramBaseCloudSearchInfo == null);
    String str;
    do
    {
      return false;
      str = paramBaseCloudSearchInfo.a();
    }
    while ((str == null) || (str.equals("")));
    this.b.putString("url", str);
    this.d.a(this.b);
    return true;
  }

  public static CloudManager getInstance()
  {
    if (c == null)
      c = new CloudManager();
    return c;
  }

  public boolean boundSearch(BoundSearchInfo paramBoundSearchInfo)
  {
    return a(paramBoundSearchInfo);
  }

  public void destroy()
  {
    if (this.d != null)
    {
      com.baidu.platform.comjni.engine.a.b(131072, this.e);
      this.d.b();
      this.d = null;
      com.baidu.mapapi.a.a().c();
    }
  }

  public boolean detailSearch(DetailSearchInfo paramDetailSearchInfo)
  {
    if (paramDetailSearchInfo == null);
    String str;
    do
    {
      return false;
      str = paramDetailSearchInfo.a();
    }
    while ((str == null) || (str.equals("")));
    this.b.putString("url", str);
    this.d.b(this.b);
    return true;
  }

  public void init(CloudListener paramCloudListener)
  {
    this.f = paramCloudListener;
    if (this.d == null)
    {
      com.baidu.mapapi.a.a().b();
      this.d = new com.baidu.platform.comjni.map.cloud.a();
      if (this.d.a() == 0)
        this.d = null;
    }
    else
    {
      return;
    }
    this.b = new Bundle();
    this.e = new a(this);
    com.baidu.platform.comjni.engine.a.a(131072, this.e);
  }

  public boolean localSearch(LocalSearchInfo paramLocalSearchInfo)
  {
    return a(paramLocalSearchInfo);
  }

  public boolean nearbySearch(NearbySearchInfo paramNearbySearchInfo)
  {
    return a(paramNearbySearchInfo);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.mapapi.cloud.CloudManager
 * JD-Core Version:    0.6.2
 */