package com.baidu.mapapi.map;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.a;
import com.baidu.platform.comapi.a.b;
import com.baidu.platform.comapi.map.d;
import vi.com.gdi.bgl.android.java.EnvDrawText;

public final class Text extends Overlay
{
  private static final String p = Text.class.getSimpleName();
  String a;
  LatLng b;
  int c;
  int d;
  int e;
  Typeface f;
  int g;
  int h;
  float i;
  int o;

  Text()
  {
    this.k = d.e;
  }

  Bundle a()
  {
    if (this.f != null)
      EnvDrawText.removeFontCache(this.f.hashCode());
    return super.a();
  }

  Bundle a(Bundle paramBundle)
  {
    float f1 = 0.5F;
    super.a(paramBundle);
    if (this.b == null)
      throw new IllegalStateException("when you add a text overlay, you must provide text and the position info.");
    paramBundle.putString("text", this.a);
    b localb = a.a(this.b);
    paramBundle.putInt("location_x", localb.b());
    paramBundle.putInt("location_y", localb.a());
    int j = this.d >>> 24;
    int k = 0xFF & this.d >> 16;
    int m = 0xFF & this.d >> 8;
    paramBundle.putInt("font_color", Color.argb(j, 0xFF & this.d, m, k));
    int n = this.c >>> 24;
    int i1 = 0xFF & this.c >> 16;
    int i2 = 0xFF & this.c >> 8;
    paramBundle.putInt("bg_color", Color.argb(n, 0xFF & this.c, i2, i1));
    paramBundle.putInt("font_size", this.e);
    if (this.f != null)
    {
      EnvDrawText.registFontCache(this.f.hashCode(), this.f);
      paramBundle.putInt("type_face", this.f.hashCode());
    }
    float f2;
    switch (this.g)
    {
    case 3:
    default:
      f2 = f1;
      paramBundle.putFloat("align_x", f2);
      switch (this.h)
      {
      case 32:
      default:
      case 8:
      case 16:
      }
      break;
    case 4:
    case 1:
    case 2:
    }
    while (true)
    {
      paramBundle.putFloat("align_y", f1);
      paramBundle.putFloat("rotate", this.i);
      paramBundle.putInt("update", this.o);
      return paramBundle;
      f2 = f1;
      break;
      f2 = 0.0F;
      break;
      f2 = 1.0F;
      break;
      f1 = 0.0F;
      continue;
      f1 = 1.0F;
    }
  }

  public float getAlignX()
  {
    return this.g;
  }

  public float getAlignY()
  {
    return this.h;
  }

  public int getBgColor()
  {
    return this.c;
  }

  public int getFontColor()
  {
    return this.d;
  }

  public int getFontSize()
  {
    return this.e;
  }

  public LatLng getPosition()
  {
    return this.b;
  }

  public float getRotate()
  {
    return this.i;
  }

  public String getText()
  {
    return this.a;
  }

  public Typeface getTypeface()
  {
    return this.f;
  }

  public void setAlign(int paramInt1, int paramInt2)
  {
    this.g = paramInt1;
    this.h = paramInt2;
    this.o = 1;
    this.listener.b(this);
  }

  public void setBgColor(int paramInt)
  {
    this.c = paramInt;
    this.o = 1;
    this.listener.b(this);
  }

  public void setFontColor(int paramInt)
  {
    this.d = paramInt;
    this.o = 1;
    this.listener.b(this);
  }

  public void setFontSize(int paramInt)
  {
    this.e = paramInt;
    this.o = 1;
    this.listener.b(this);
  }

  public void setPosition(LatLng paramLatLng)
  {
    if (paramLatLng == null)
      throw new IllegalArgumentException("position can not be null");
    this.b = paramLatLng;
    this.o = 1;
    this.listener.b(this);
  }

  public void setRotate(float paramFloat)
  {
    this.i = paramFloat;
    this.o = 1;
    this.listener.b(this);
  }

  public void setText(String paramString)
  {
    if ((paramString == null) || (paramString.equals("")))
      throw new IllegalArgumentException("text can not be null or empty");
    this.a = paramString;
    this.o = 1;
    this.listener.b(this);
  }

  public void setTypeface(Typeface paramTypeface)
  {
    this.f = paramTypeface;
    this.o = 1;
    this.listener.b(this);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.mapapi.map.Text
 * JD-Core Version:    0.6.2
 */