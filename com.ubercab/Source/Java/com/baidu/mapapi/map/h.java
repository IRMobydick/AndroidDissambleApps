package com.baidu.mapapi.map;

import android.view.View;
import android.view.View.OnClickListener;
import com.baidu.platform.comapi.map.e;
import com.baidu.platform.comapi.map.w;

class h
  implements View.OnClickListener
{
  h(MapView paramMapView)
  {
  }

  public void onClick(View paramView)
  {
    w localw = MapView.a(this.a).m();
    localw.a = (1.0F + localw.a);
    MapView.a(this.a).a(localw, 300);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.mapapi.map.h
 * JD-Core Version:    0.6.2
 */