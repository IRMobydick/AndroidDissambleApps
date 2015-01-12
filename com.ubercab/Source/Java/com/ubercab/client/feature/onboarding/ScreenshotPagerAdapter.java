package com.ubercab.client.feature.onboarding;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.ViewGroup;
import android.widget.ImageView;

class ScreenshotPagerAdapter extends CircularPagerAdapter
{
  private Context mContext;
  private TypedArray mScreenshots;

  ScreenshotPagerAdapter(Context paramContext)
  {
    this.mContext = paramContext;
    this.mScreenshots = paramContext.getResources().obtainTypedArray(2131165202);
  }

  private Bitmap loadScreenshot(int paramInt)
  {
    BitmapDrawable localBitmapDrawable = (BitmapDrawable)this.mScreenshots.getDrawable(paramInt);
    if (localBitmapDrawable != null)
      return localBitmapDrawable.getBitmap();
    return null;
  }

  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    Bitmap localBitmap = loadScreenshot(paramInt % this.mScreenshots.length());
    if (localBitmap == null)
      return null;
    ImageView localImageView = new ImageView(this.mContext);
    localImageView.setImageBitmap(localBitmap);
    paramViewGroup.addView(localImageView);
    return localImageView;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.onboarding.ScreenshotPagerAdapter
 * JD-Core Version:    0.6.2
 */