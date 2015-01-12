package com.ubercab.client.feature.faresplit.master;

import android.widget.ListView;
import butterknife.ButterKnife.Finder;
import com.ubercab.client.core.ui.ChipEditText;
import com.ubercab.ui.UberTextView;

public class FareSplitInviteFragment$$ViewInjector
{
  public static void inject(ButterKnife.Finder paramFinder, FareSplitInviteFragment paramFareSplitInviteFragment, Object paramObject)
  {
    paramFareSplitInviteFragment.mListView = ((ListView)paramFinder.findRequiredView(paramObject, 2131427455, "field 'mListView'"));
    paramFareSplitInviteFragment.mEditTextInvitees = ((ChipEditText)paramFinder.findRequiredView(paramObject, 2131427454, "field 'mEditTextInvitees'"));
    paramFareSplitInviteFragment.mTextViewFeeNotice = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427456, "field 'mTextViewFeeNotice'"));
    paramFareSplitInviteFragment.mTextViewLimitReached = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427453, "field 'mTextViewLimitReached'"));
  }

  public static void reset(FareSplitInviteFragment paramFareSplitInviteFragment)
  {
    paramFareSplitInviteFragment.mListView = null;
    paramFareSplitInviteFragment.mEditTextInvitees = null;
    paramFareSplitInviteFragment.mTextViewFeeNotice = null;
    paramFareSplitInviteFragment.mTextViewLimitReached = null;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.faresplit.master.FareSplitInviteFragment..ViewInjector
 * JD-Core Version:    0.6.2
 */