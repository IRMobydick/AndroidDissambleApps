package com.baidu.platform.comapi.map;

import android.os.Bundle;
import com.baidu.platform.comapi.a.d;

public class w
{
  public float a = 12.0F;
  public int b = 0;
  public int c = 0;
  public int d = 12958162;
  public int e = 4825907;
  public int f = -1;
  public int g = -1;
  public long h = 0L;
  public long i = 0L;
  public b j = new b();
  public a k = new a();
  public boolean l = false;
  public double m;
  public int n;
  public String o;
  public float p;
  public boolean q;
  public int r;

  public Bundle a(e parame)
  {
    int i1 = 1;
    if (this.a < parame.b)
      this.a = parame.b;
    if (this.a > parame.a)
      this.a = parame.a;
    while (this.b < 0)
      this.b = (360 + this.b);
    this.b %= 360;
    if (this.c > 0)
      this.c = 0;
    if (this.c < -45)
      this.c = -45;
    Bundle localBundle = new Bundle();
    localBundle.putDouble("level", this.a);
    localBundle.putDouble("rotation", this.b);
    localBundle.putDouble("overlooking", this.c);
    localBundle.putDouble("centerptx", this.d);
    localBundle.putDouble("centerpty", this.e);
    localBundle.putInt("left", this.j.a);
    localBundle.putInt("right", this.j.b);
    localBundle.putInt("top", this.j.c);
    localBundle.putInt("bottom", this.j.d);
    if ((this.f >= 0) && (this.g >= 0) && (this.f <= this.j.b) && (this.g <= this.j.d) && (this.j.b > 0) && (this.j.d > 0))
    {
      int i3 = (this.j.b - this.j.a) / 2;
      int i4 = (this.j.d - this.j.c) / 2;
      int i5 = this.f - i3;
      int i6 = this.g - i4;
      this.h = i5;
      this.i = (-i6);
      localBundle.putLong("xoffset", this.h);
      localBundle.putLong("yoffset", this.i);
    }
    localBundle.putInt("lbx", this.k.e.a);
    localBundle.putInt("lby", this.k.e.b);
    localBundle.putInt("ltx", this.k.f.a);
    localBundle.putInt("lty", this.k.f.b);
    localBundle.putInt("rtx", this.k.g.a);
    localBundle.putInt("rty", this.k.g.b);
    localBundle.putInt("rbx", this.k.h.a);
    localBundle.putInt("rby", this.k.h.b);
    int i2;
    if (this.l)
    {
      i2 = i1;
      localBundle.putInt("bfpp", i2);
      localBundle.putInt("animation", i1);
      localBundle.putInt("animatime", this.n);
      localBundle.putString("panoid", this.o);
      localBundle.putInt("autolink", 0);
      localBundle.putFloat("siangle", this.p);
      if (!this.q)
        break label593;
    }
    while (true)
    {
      localBundle.putInt("isbirdeye", i1);
      localBundle.putInt("ssext", this.r);
      return localBundle;
      i2 = 0;
      break;
      label593: i1 = 0;
    }
  }

  public void a(Bundle paramBundle)
  {
    int i1 = 1;
    this.a = ((float)paramBundle.getDouble("level"));
    this.b = ((int)paramBundle.getDouble("rotation"));
    this.c = ((int)paramBundle.getDouble("overlooking"));
    this.d = ((int)paramBundle.getDouble("centerptx"));
    this.e = ((int)paramBundle.getDouble("centerpty"));
    this.j.a = paramBundle.getInt("left");
    this.j.b = paramBundle.getInt("right");
    this.j.c = paramBundle.getInt("top");
    this.j.d = paramBundle.getInt("bottom");
    this.h = paramBundle.getLong("xoffset");
    this.i = paramBundle.getLong("yoffset");
    if ((this.j.b != 0) && (this.j.d != 0))
    {
      int i3 = (this.j.b - this.j.a) / 2;
      int i4 = (this.j.d - this.j.c) / 2;
      int i5 = (int)this.h;
      int i6 = (int)-this.i;
      this.f = (i3 + i5);
      this.g = (i6 + i4);
    }
    this.k.a = paramBundle.getLong("gleft");
    this.k.b = paramBundle.getLong("gright");
    this.k.c = paramBundle.getLong("gtop");
    this.k.d = paramBundle.getLong("gbottom");
    if (this.k.a <= -20037508L)
      this.k.a = -20037508L;
    if (this.k.b >= 20037508L)
      this.k.b = 20037508L;
    if (this.k.c >= 20037508L)
      this.k.c = 20037508L;
    if (this.k.d <= -20037508L)
      this.k.d = -20037508L;
    this.k.e.a = paramBundle.getInt("lbx");
    this.k.e.b = paramBundle.getInt("lby");
    this.k.f.a = paramBundle.getInt("ltx");
    this.k.f.b = paramBundle.getInt("lty");
    this.k.g.a = paramBundle.getInt("rtx");
    this.k.g.b = paramBundle.getInt("rty");
    this.k.h.a = paramBundle.getInt("rbx");
    this.k.h.b = paramBundle.getInt("rby");
    int i2;
    if (paramBundle.getInt("bfpp") == i1)
    {
      i2 = i1;
      this.l = i2;
      this.m = paramBundle.getDouble("zoomunit");
      this.o = paramBundle.getString("panoid");
      this.p = paramBundle.getFloat("siangle");
      if (paramBundle.getInt("isbirdeye") == 0)
        break label573;
    }
    while (true)
    {
      this.q = i1;
      this.r = paramBundle.getInt("ssext");
      return;
      i2 = 0;
      break;
      label573: i1 = 0;
    }
  }

  public class a
  {
    public long a = 0L;
    public long b = 0L;
    public long c = 0L;
    public long d = 0L;
    public d e = new d(0, 0);
    public d f = new d(0, 0);
    public d g = new d(0, 0);
    public d h = new d(0, 0);

    public a()
    {
    }
  }

  public class b
  {
    public int a = 0;
    public int b = 0;
    public int c = 0;
    public int d = 0;

    public b()
    {
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.platform.comapi.map.w
 * JD-Core Version:    0.6.2
 */