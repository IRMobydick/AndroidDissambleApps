package com.ubercab.client.feature.music;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

public class HeaderImageView extends ImageView
{
  public HeaderImageView(Context paramContext)
  {
    super(paramContext);
  }

  public HeaderImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public HeaderImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    setMeasuredDimension(getMeasuredWidth(), (int)(0.66F * getMeasuredWidth()));
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.music.HeaderImageView
 * JD-Core Version:    0.6.2
 */