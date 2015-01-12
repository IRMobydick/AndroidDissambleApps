package com.baidu.mapapi.map;

import android.graphics.Bitmap;
import android.util.SparseArray;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.platform.comapi.a.b;
import com.baidu.platform.comapi.map.e;
import com.baidu.platform.comapi.map.g;
import com.baidu.platform.comapi.map.w;

class f
  implements g
{
  f(MapView paramMapView)
  {
  }

  public void a()
  {
    float f = MapView.a(this.a).m().a;
    int i;
    Object[] arrayOfObject2;
    if (MapView.b(this.a) != f)
    {
      i = ((Integer)MapView.a().get((int)f)).intValue();
      int j = (int)(i / MapView.a(this.a).m().m);
      MapView.c(this.a).setPadding(j / 2, 0, j / 2, 0);
      if (i < 1000)
        break label159;
      arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = Integer.valueOf(i / 1000);
    }
    label159: Object[] arrayOfObject1;
    for (String str = String.format(" %d公里 ", arrayOfObject2); ; str = String.format(" %d米 ", arrayOfObject1))
    {
      MapView.d(this.a).setText(str);
      MapView.e(this.a).setText(str);
      MapView.a(this.a, f);
      MapView.f(this.a);
      this.a.requestLayout();
      return;
      arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = Integer.valueOf(i);
    }
  }

  public void a(Bitmap paramBitmap)
  {
  }

  public void a(b paramb)
  {
  }

  public void a(w paramw)
  {
  }

  public void a(String paramString)
  {
  }

  public void b()
  {
  }

  public void b(b paramb)
  {
  }

  public void b(w paramw)
  {
  }

  public boolean b(String paramString)
  {
    return false;
  }

  public void c()
  {
  }

  public void c(b paramb)
  {
  }

  public void c(w paramw)
  {
  }

  public void d(b paramb)
  {
  }

  public void e(b paramb)
  {
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.mapapi.map.f
 * JD-Core Version:    0.6.2
 */