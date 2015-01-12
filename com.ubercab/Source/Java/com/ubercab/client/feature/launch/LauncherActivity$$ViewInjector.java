package com.ubercab.client.feature.launch;

import butterknife.ButterKnife.Finder;
import com.ubercab.ui.UberTextView;

public class LauncherActivity$$ViewInjector
{
  public static void inject(ButterKnife.Finder paramFinder, LauncherActivity paramLauncherActivity, Object paramObject)
  {
    paramLauncherActivity.mTextViewSlogan = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427485, "field 'mTextViewSlogan'"));
  }

  public static void reset(LauncherActivity paramLauncherActivity)
  {
    paramLauncherActivity.mTextViewSlogan = null;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.launch.LauncherActivity..ViewInjector
 * JD-Core Version:    0.6.2
 */