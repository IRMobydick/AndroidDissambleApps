package com.ubercab.client.feature.trip.driver;

import android.widget.ImageView;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewFlipper;
import butterknife.ButterKnife.Finder;
import com.ubercab.client.feature.trip.driver.animation.DiscountProgressAnimView;

public class DiscountBar$$ViewInjector
{
  public static void inject(ButterKnife.Finder paramFinder, DiscountBar paramDiscountBar, Object paramObject)
  {
    paramDiscountBar.mViewFlipper = ((ViewFlipper)paramFinder.findRequiredView(paramObject, 2131427876, "field 'mViewFlipper'"));
    paramDiscountBar.mUberPoolMatchAnimationView = ((DiscountProgressAnimView)paramFinder.findRequiredView(paramObject, 2131427877, "field 'mUberPoolMatchAnimationView'"));
    paramDiscountBar.mPeopleIcon = ((ImageView)paramFinder.findRequiredView(paramObject, 2131427878, "field 'mPeopleIcon'"));
    paramDiscountBar.mTextSwitcher = ((TextSwitcher)paramFinder.findRequiredView(paramObject, 2131427879, "field 'mTextSwitcher'"));
    paramDiscountBar.mDiscountTextView = ((TextView)paramFinder.findRequiredView(paramObject, 2131427882, "field 'mDiscountTextView'"));
  }

  public static void reset(DiscountBar paramDiscountBar)
  {
    paramDiscountBar.mViewFlipper = null;
    paramDiscountBar.mUberPoolMatchAnimationView = null;
    paramDiscountBar.mPeopleIcon = null;
    paramDiscountBar.mTextSwitcher = null;
    paramDiscountBar.mDiscountTextView = null;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.trip.driver.DiscountBar..ViewInjector
 * JD-Core Version:    0.6.2
 */