package com.ubercab.client.feature.faresplit.master;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.ProgressBar;
import butterknife.ButterKnife.Finder;
import com.ubercab.ui.UberButton;
import com.ubercab.ui.UberTextView;

public class FareSplitSummaryFragment$$ViewInjector
{
  public static void inject(ButterKnife.Finder paramFinder, FareSplitSummaryFragment paramFareSplitSummaryFragment, Object paramObject)
  {
    View localView1 = paramFinder.findRequiredView(paramObject, 2131427468, "field 'mButtonOk' and method 'onClickButtonOk'");
    paramFareSplitSummaryFragment.mButtonOk = ((UberButton)localView1);
    localView1.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        this.val$target.onClickButtonOk();
      }
    });
    View localView2 = paramFinder.findRequiredView(paramObject, 2131427465, "field 'mButtonInvite' and method 'onClickButtonInvite'");
    paramFareSplitSummaryFragment.mButtonInvite = ((ImageButton)localView2);
    localView2.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        this.val$target.onClickButtonInvite();
      }
    });
    paramFareSplitSummaryFragment.mTextViewTitle = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427458, "field 'mTextViewTitle'"));
    paramFareSplitSummaryFragment.mListViewSummary = ((ListView)paramFinder.findRequiredView(paramObject, 2131427467, "field 'mListViewSummary'"));
    paramFareSplitSummaryFragment.mViewGroupContent = ((ViewGroup)paramFinder.findRequiredView(paramObject, 2131427464, "field 'mViewGroupContent'"));
    paramFareSplitSummaryFragment.mProgressBarLoading = ((ProgressBar)paramFinder.findRequiredView(paramObject, 2131427463, "field 'mProgressBarLoading'"));
  }

  public static void reset(FareSplitSummaryFragment paramFareSplitSummaryFragment)
  {
    paramFareSplitSummaryFragment.mButtonOk = null;
    paramFareSplitSummaryFragment.mButtonInvite = null;
    paramFareSplitSummaryFragment.mTextViewTitle = null;
    paramFareSplitSummaryFragment.mListViewSummary = null;
    paramFareSplitSummaryFragment.mViewGroupContent = null;
    paramFareSplitSummaryFragment.mProgressBarLoading = null;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.faresplit.master.FareSplitSummaryFragment..ViewInjector
 * JD-Core Version:    0.6.2
 */