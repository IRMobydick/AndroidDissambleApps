package com.baidu.mapapi.map;

import android.os.Bundle;

public final class Stroke
{
  public final int color;
  public final int strokeWidth;

  public Stroke(int paramInt1, int paramInt2)
  {
    if (paramInt1 <= 0)
      paramInt1 = 5;
    this.strokeWidth = paramInt1;
    this.color = paramInt2;
  }

  Bundle a(Bundle paramBundle)
  {
    paramBundle.putInt("width", this.strokeWidth);
    Overlay.a(this.color, paramBundle);
    return paramBundle;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.mapapi.map.Stroke
 * JD-Core Version:    0.6.2
 */