package com.ubercab.client.core.ui;

import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import java.util.HashMap;
import java.util.Map;

public class ColorStateDrawable extends LayerDrawable
{
  private Map<Integer, Integer> mMapColorStates = new HashMap();

  public ColorStateDrawable(Drawable paramDrawable)
  {
    this(new Drawable[] { paramDrawable });
  }

  public ColorStateDrawable(Drawable[] paramArrayOfDrawable)
  {
    super(paramArrayOfDrawable);
  }

  public boolean isStateful()
  {
    return true;
  }

  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    int i = paramArrayOfInt.length;
    for (int j = 0; j < i; j++)
    {
      int k = paramArrayOfInt[j];
      if (this.mMapColorStates.containsKey(Integer.valueOf(k)))
        super.setColorFilter(((Integer)this.mMapColorStates.get(Integer.valueOf(k))).intValue(), PorterDuff.Mode.SRC_ATOP);
    }
    return super.onStateChange(paramArrayOfInt);
  }

  public void setColorState(int paramInt1, int paramInt2)
  {
    this.mMapColorStates.put(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.ui.ColorStateDrawable
 * JD-Core Version:    0.6.2
 */