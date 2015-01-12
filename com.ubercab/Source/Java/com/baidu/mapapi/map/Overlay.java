package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.a;
import com.baidu.platform.comapi.a.b;
import com.baidu.platform.comapi.map.d;
import java.util.List;

public abstract class Overlay
{
  String j = System.currentTimeMillis() + "_" + hashCode();
  d k;
  int l;
  protected a listener;
  boolean m;
  Bundle n;

  static void a(int paramInt, Bundle paramBundle)
  {
    Bundle localBundle = new Bundle();
    int i = paramInt >>> 24;
    int i1 = 0xFF & paramInt >> 16;
    int i2 = 0xFF & paramInt >> 8;
    int i3 = paramInt & 0xFF;
    localBundle.putFloat("red", i1 / 255.0F);
    localBundle.putFloat("green", i2 / 255.0F);
    localBundle.putFloat("blue", i3 / 255.0F);
    localBundle.putFloat("alpha", i / 255.0F);
    paramBundle.putBundle("color", localBundle);
  }

  static void a(List<LatLng> paramList, Bundle paramBundle)
  {
    int i = paramList.size();
    int[] arrayOfInt1 = new int[i];
    int[] arrayOfInt2 = new int[i];
    for (int i1 = 0; i1 < i; i1++)
    {
      b localb = a.a((LatLng)paramList.get(i1));
      arrayOfInt1[i1] = localb.b();
      arrayOfInt2[i1] = localb.a();
    }
    paramBundle.putIntArray("x_array", arrayOfInt1);
    paramBundle.putIntArray("y_array", arrayOfInt2);
  }

  Bundle a()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("id", this.j);
    localBundle.putInt("type", this.k.ordinal());
    return localBundle;
  }

  Bundle a(Bundle paramBundle)
  {
    paramBundle.putString("id", this.j);
    paramBundle.putInt("type", this.k.ordinal());
    if (this.m);
    for (int i = 1; ; i = 0)
    {
      paramBundle.putInt("visibility", i);
      paramBundle.putInt("z_index", this.l);
      return paramBundle;
    }
  }

  public Bundle getExtraInfo()
  {
    return this.n;
  }

  public int getZIndex()
  {
    return this.l;
  }

  public boolean isVisible()
  {
    return this.m;
  }

  public void remove()
  {
    this.listener.a(this);
  }

  public void setExtraInfo(Bundle paramBundle)
  {
    this.n = paramBundle;
  }

  public void setVisible(boolean paramBoolean)
  {
    this.m = paramBoolean;
    this.listener.b(this);
  }

  public void setZIndex(int paramInt)
  {
    this.l = paramInt;
    this.listener.b(this);
  }

  static abstract interface a
  {
    public abstract void a(Overlay paramOverlay);

    public abstract void b(Overlay paramOverlay);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.mapapi.map.Overlay
 * JD-Core Version:    0.6.2
 */