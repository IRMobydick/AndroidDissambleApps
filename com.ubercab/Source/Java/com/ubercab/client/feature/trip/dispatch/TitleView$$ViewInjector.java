package com.ubercab.client.feature.trip.dispatch;

import butterknife.ButterKnife.Finder;
import com.ubercab.ui.UberTextView;
import fr.castorflex.android.smoothprogressbar.SmoothProgressBar;

public class TitleView$$ViewInjector
{
  public static void inject(ButterKnife.Finder paramFinder, TitleView paramTitleView, Object paramObject)
  {
    paramTitleView.mTextViewStatus = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427847, "field 'mTextViewStatus'"));
    paramTitleView.mProgressBarRequesting = ((SmoothProgressBar)paramFinder.findRequiredView(paramObject, 2131427848, "field 'mProgressBarRequesting'"));
  }

  public static void reset(TitleView paramTitleView)
  {
    paramTitleView.mTextViewStatus = null;
    paramTitleView.mProgressBarRequesting = null;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.trip.dispatch.TitleView..ViewInjector
 * JD-Core Version:    0.6.2
 */