package com.ubercab.client.feature.faresplit.master;

import android.widget.CheckBox;
import android.widget.ImageView;
import butterknife.ButterKnife.Finder;
import com.ubercab.ui.UberTextView;

public class FareSplitContactViewHolder$$ViewInjector
{
  public static void inject(ButterKnife.Finder paramFinder, FareSplitContactViewHolder paramFareSplitContactViewHolder, Object paramObject)
  {
    paramFareSplitContactViewHolder.mTextViewName = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427469, "field 'mTextViewName'"));
    paramFareSplitContactViewHolder.mTextViewNumber = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427470, "field 'mTextViewNumber'"));
    paramFareSplitContactViewHolder.mImageViewPicture = ((ImageView)paramFinder.findRequiredView(paramObject, 2131427457, "field 'mImageViewPicture'"));
    paramFareSplitContactViewHolder.mCheckBoxIsInvited = ((CheckBox)paramFinder.findRequiredView(paramObject, 2131427472, "field 'mCheckBoxIsInvited'"));
  }

  public static void reset(FareSplitContactViewHolder paramFareSplitContactViewHolder)
  {
    paramFareSplitContactViewHolder.mTextViewName = null;
    paramFareSplitContactViewHolder.mTextViewNumber = null;
    paramFareSplitContactViewHolder.mImageViewPicture = null;
    paramFareSplitContactViewHolder.mCheckBoxIsInvited = null;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.faresplit.master.FareSplitContactViewHolder..ViewInjector
 * JD-Core Version:    0.6.2
 */