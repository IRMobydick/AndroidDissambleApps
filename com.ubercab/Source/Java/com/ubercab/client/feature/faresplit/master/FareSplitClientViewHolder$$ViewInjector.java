package com.ubercab.client.feature.faresplit.master;

import android.widget.ImageButton;
import android.widget.ImageView;
import butterknife.ButterKnife.Finder;
import com.ubercab.ui.UberTextView;

public class FareSplitClientViewHolder$$ViewInjector
{
  public static void inject(ButterKnife.Finder paramFinder, FareSplitClientViewHolder paramFareSplitClientViewHolder, Object paramObject)
  {
    paramFareSplitClientViewHolder.mImageView = ((ImageView)paramFinder.findRequiredView(paramObject, 2131427457, "field 'mImageView'"));
    paramFareSplitClientViewHolder.mButtonRemove = ((ImageButton)paramFinder.findRequiredView(paramObject, 2131427471, "field 'mButtonRemove'"));
    paramFareSplitClientViewHolder.mTextViewName = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427469, "field 'mTextViewName'"));
    paramFareSplitClientViewHolder.mTextViewStatus = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427470, "field 'mTextViewStatus'"));
  }

  public static void reset(FareSplitClientViewHolder paramFareSplitClientViewHolder)
  {
    paramFareSplitClientViewHolder.mImageView = null;
    paramFareSplitClientViewHolder.mButtonRemove = null;
    paramFareSplitClientViewHolder.mTextViewName = null;
    paramFareSplitClientViewHolder.mTextViewStatus = null;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.faresplit.master.FareSplitClientViewHolder..ViewInjector
 * JD-Core Version:    0.6.2
 */