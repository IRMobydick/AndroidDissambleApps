package com.ubercab.client.feature.payment;

import android.view.View;
import android.view.View.OnClickListener;
import butterknife.ButterKnife.Finder;
import com.ubercab.ui.UberButton;
import com.ubercab.ui.UberTextView;

public class RewardInfoFragment$$ViewInjector
{
  public static void inject(ButterKnife.Finder paramFinder, RewardInfoFragment paramRewardInfoFragment, Object paramObject)
  {
    paramRewardInfoFragment.mTextViewActionRequired = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427928, "field 'mTextViewActionRequired'"));
    paramRewardInfoFragment.mTextViewRewardInfo = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427613, "field 'mTextViewRewardInfo'"));
    paramRewardInfoFragment.mTextViewRewardRestrictions = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427607, "field 'mTextViewRewardRestrictions'"));
    paramRewardInfoFragment.mTextViewRewardLink = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427608, "field 'mTextViewRewardLink'"));
    View localView1 = paramFinder.findRequiredView(paramObject, 2131427604, "field 'mButtonEnrollMe' and method 'onClickEnrollMe'");
    paramRewardInfoFragment.mButtonEnrollMe = ((UberButton)localView1);
    localView1.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        this.val$target.onClickEnrollMe();
      }
    });
    View localView2 = paramFinder.findRequiredView(paramObject, 2131427615, "field 'mTextViewNotRightNow' and method 'onClickNotRightNow'");
    paramRewardInfoFragment.mTextViewNotRightNow = ((UberTextView)localView2);
    localView2.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        this.val$target.onClickNotRightNow();
      }
    });
    paramFinder.findRequiredView(paramObject, 2131427614, "method 'onClickTerms'").setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        this.val$target.onClickTerms();
      }
    });
  }

  public static void reset(RewardInfoFragment paramRewardInfoFragment)
  {
    paramRewardInfoFragment.mTextViewActionRequired = null;
    paramRewardInfoFragment.mTextViewRewardInfo = null;
    paramRewardInfoFragment.mTextViewRewardRestrictions = null;
    paramRewardInfoFragment.mTextViewRewardLink = null;
    paramRewardInfoFragment.mButtonEnrollMe = null;
    paramRewardInfoFragment.mTextViewNotRightNow = null;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.payment.RewardInfoFragment..ViewInjector
 * JD-Core Version:    0.6.2
 */