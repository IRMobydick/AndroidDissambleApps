package com.ubercab.client.feature.estimate;

import android.view.View;
import android.view.View.OnClickListener;
import butterknife.ButterKnife.Finder;
import com.ubercab.ui.UberButton;
import com.ubercab.ui.UberTextView;

public class RewardPointsFareEstimateFragment$$ViewInjector
{
  public static void inject(ButterKnife.Finder paramFinder, RewardPointsFareEstimateFragment paramRewardPointsFareEstimateFragment, Object paramObject)
  {
    View localView = paramFinder.findRequiredView(paramObject, 2131427448, "field 'mButtonOk' and method 'onClickButtonOk'");
    paramRewardPointsFareEstimateFragment.mButtonOk = ((UberButton)localView);
    localView.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        this.val$target.onClickButtonOk();
      }
    });
    paramRewardPointsFareEstimateFragment.mTextViewExplanation = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427446, "field 'mTextViewExplanation'"));
    paramRewardPointsFareEstimateFragment.mTextViewFare = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427444, "field 'mTextViewFare'"));
    paramRewardPointsFareEstimateFragment.mTextViewMembershipRewards = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427445, "field 'mTextViewMembershipRewards'"));
    paramRewardPointsFareEstimateFragment.mTextViewMessage = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427447, "field 'mTextViewMessage'"));
    paramRewardPointsFareEstimateFragment.mTextViewTitle = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427443, "field 'mTextViewTitle'"));
  }

  public static void reset(RewardPointsFareEstimateFragment paramRewardPointsFareEstimateFragment)
  {
    paramRewardPointsFareEstimateFragment.mButtonOk = null;
    paramRewardPointsFareEstimateFragment.mTextViewExplanation = null;
    paramRewardPointsFareEstimateFragment.mTextViewFare = null;
    paramRewardPointsFareEstimateFragment.mTextViewMembershipRewards = null;
    paramRewardPointsFareEstimateFragment.mTextViewMessage = null;
    paramRewardPointsFareEstimateFragment.mTextViewTitle = null;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.estimate.RewardPointsFareEstimateFragment..ViewInjector
 * JD-Core Version:    0.6.2
 */