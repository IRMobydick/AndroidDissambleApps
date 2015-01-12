package com.baidu.mapapi.map;

import android.os.Bundle;
import java.util.concurrent.locks.Lock;

class c
  implements com.baidu.platform.comapi.map.j
{
  c(BaiduMap paramBaiduMap)
  {
  }

  public Bundle a(int paramInt1, int paramInt2, int paramInt3)
  {
    BaiduMap.p(this.a).lock();
    try
    {
      if (BaiduMap.q(this.a) != null)
      {
        j localj = BaiduMap.q(this.a).a(paramInt1, paramInt2, paramInt3);
        if (localj != null)
        {
          Bundle localBundle = localj.a();
          return localBundle;
        }
      }
      return null;
    }
    finally
    {
      BaiduMap.p(this.a).unlock();
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.mapapi.map.c
 * JD-Core Version:    0.6.2
 */