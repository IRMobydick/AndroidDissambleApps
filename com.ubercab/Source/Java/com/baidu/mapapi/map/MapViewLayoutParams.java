package com.baidu.mapapi.map;

import android.graphics.Point;
import android.view.ViewGroup.LayoutParams;
import com.baidu.mapapi.model.LatLng;

public final class MapViewLayoutParams extends ViewGroup.LayoutParams
{
  public static final int ALIGN_BOTTOM = 16;
  public static final int ALIGN_CENTER_HORIZONTAL = 4;
  public static final int ALIGN_CENTER_VERTICAL = 32;
  public static final int ALIGN_LEFT = 1;
  public static final int ALIGN_RIGHT = 2;
  public static final int ALIGN_TOP = 8;
  LatLng a;
  Point b;
  ELayoutMode c;
  float d;
  float e;

  MapViewLayoutParams(int paramInt1, int paramInt2, LatLng paramLatLng, Point paramPoint, ELayoutMode paramELayoutMode, int paramInt3, int paramInt4)
  {
    super(paramInt1, paramInt2);
    this.a = paramLatLng;
    this.b = paramPoint;
    this.c = paramELayoutMode;
    switch (paramInt3)
    {
    case 3:
    default:
      this.d = 0.5F;
    case 1:
    case 4:
    case 2:
    }
    while (true)
      switch (paramInt4)
      {
      default:
        this.e = 1.0F;
        return;
        this.d = 0.0F;
        continue;
        this.d = 0.5F;
        continue;
        this.d = 1.0F;
      case 8:
      case 32:
      case 16:
      }
    this.e = 0.0F;
    return;
    this.e = 0.5F;
    return;
    this.e = 1.0F;
  }

  public static final class Builder
  {
    private int a;
    private int b;
    private LatLng c;
    private Point d;
    private MapViewLayoutParams.ELayoutMode e = MapViewLayoutParams.ELayoutMode.absoluteMode;
    private int f = 4;
    private int g = 16;

    public Builder align(int paramInt1, int paramInt2)
    {
      if ((paramInt1 == 1) || (paramInt1 == 2) || (paramInt1 == 4))
        this.f = paramInt1;
      if ((paramInt2 == 8) || (paramInt2 == 16) || (paramInt2 == 32))
        this.g = paramInt2;
      return this;
    }

    public MapViewLayoutParams build()
    {
      int i = 1;
      if (this.e == MapViewLayoutParams.ELayoutMode.mapMode)
        if (this.c != null)
          break label50;
      while (i != 0)
      {
        throw new IllegalStateException("if it is map mode, you must supply position info; else if it is absolute mode, you must supply the point info");
        if ((this.e != MapViewLayoutParams.ELayoutMode.absoluteMode) || (this.d != null))
          label50: i = 0;
      }
      return new MapViewLayoutParams(this.a, this.b, this.c, this.d, this.e, this.f, this.g);
    }

    public Builder height(int paramInt)
    {
      this.b = paramInt;
      return this;
    }

    public Builder layoutMode(MapViewLayoutParams.ELayoutMode paramELayoutMode)
    {
      this.e = paramELayoutMode;
      return this;
    }

    public Builder point(Point paramPoint)
    {
      this.d = paramPoint;
      return this;
    }

    public Builder position(LatLng paramLatLng)
    {
      this.c = paramLatLng;
      return this;
    }

    public Builder width(int paramInt)
    {
      this.a = paramInt;
      return this;
    }
  }

  public static enum ELayoutMode
  {
    static
    {
      absoluteMode = new ELayoutMode("absoluteMode", 1);
      ELayoutMode[] arrayOfELayoutMode = new ELayoutMode[2];
      arrayOfELayoutMode[0] = mapMode;
      arrayOfELayoutMode[1] = absoluteMode;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.mapapi.map.MapViewLayoutParams
 * JD-Core Version:    0.6.2
 */