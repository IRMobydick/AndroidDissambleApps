package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.platform.comapi.map.e;
import java.util.List;

class a
  implements Overlay.a
{
  a(BaiduMap paramBaiduMap)
  {
  }

  public void a(Overlay paramOverlay)
  {
    if (BaiduMap.a(this.a).contains(paramOverlay))
    {
      Bundle localBundle = paramOverlay.a();
      BaiduMap.b(this.a).c(localBundle);
      BaiduMap.a(this.a).remove(paramOverlay);
    }
  }

  public void b(Overlay paramOverlay)
  {
    if (BaiduMap.a(this.a).contains(paramOverlay))
    {
      Bundle localBundle = new Bundle();
      paramOverlay.a(localBundle);
      BaiduMap.b(this.a).b(localBundle);
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.mapapi.map.a
 * JD-Core Version:    0.6.2
 */