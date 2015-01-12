package com.ubercab.client.feature.onboarding;

import android.support.v4.view.ViewPager.PageTransformer;
import android.view.View;

class DimmingTransformer
  implements ViewPager.PageTransformer
{
  private static final float MIN_ALPHA = 0.5F;
  private static final float MIN_SCALE = 0.85F;

  public void transformPage(View paramView, float paramFloat)
  {
    int i = paramView.getWidth();
    int j = paramView.getHeight();
    if (paramFloat < -1.0F)
    {
      paramView.setScaleX(0.85F);
      paramView.setScaleY(0.85F);
      paramView.setAlpha(0.0F);
      return;
    }
    if (paramFloat <= 1.0F)
    {
      paramView.setScaleX(0.85F);
      float f1 = Math.max(0.85F, 1.0F - Math.abs(paramFloat));
      float f2 = j * (1.0F - f1) / 2.0F;
      float f3 = i * (1.0F - f1) / 2.0F;
      if (paramFloat < 0.0F)
        paramView.setTranslationX(f3 - f2 / 2.0F);
      while (true)
      {
        paramView.setScaleX(f1);
        paramView.setScaleY(f1);
        paramView.setAlpha(0.5F + 0.5F * ((f1 - 0.85F) / 0.15F));
        return;
        paramView.setTranslationX(-f3 + f2 / 2.0F);
      }
    }
    paramView.setScaleX(0.85F);
    paramView.setScaleY(0.85F);
    paramView.setAlpha(0.0F);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.onboarding.DimmingTransformer
 * JD-Core Version:    0.6.2
 */