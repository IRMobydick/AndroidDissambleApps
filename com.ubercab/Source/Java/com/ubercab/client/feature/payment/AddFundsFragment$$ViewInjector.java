package com.ubercab.client.feature.payment;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import butterknife.ButterKnife.Finder;
import com.ubercab.ui.UberButton;
import com.ubercab.ui.UberEditText;
import com.ubercab.ui.UberTextView;

public class AddFundsFragment$$ViewInjector
{
  public static void inject(ButterKnife.Finder paramFinder, AddFundsFragment paramAddFundsFragment, Object paramObject)
  {
    View localView1 = paramFinder.findRequiredView(paramObject, 2131427586, "field 'mButtonDenomination1' and method 'onClickFirstValue'");
    paramAddFundsFragment.mButtonDenomination1 = ((UberButton)localView1);
    localView1.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        this.val$target.onClickFirstValue();
      }
    });
    View localView2 = paramFinder.findRequiredView(paramObject, 2131427587, "field 'mButtonDenomination2' and method 'onClickSecondValue'");
    paramAddFundsFragment.mButtonDenomination2 = ((UberButton)localView2);
    localView2.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        this.val$target.onClickSecondValue();
      }
    });
    View localView3 = paramFinder.findRequiredView(paramObject, 2131427588, "field 'mButtonDenomination3' and method 'onClickThirdValue'");
    paramAddFundsFragment.mButtonDenomination3 = ((UberButton)localView3);
    localView3.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        this.val$target.onClickThirdValue();
      }
    });
    View localView4 = paramFinder.findRequiredView(paramObject, 2131427589, "field 'mButtonSubmit' and method 'onClickButtonSubmit'");
    paramAddFundsFragment.mButtonSubmit = ((UberButton)localView4);
    localView4.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        this.val$target.onClickButtonSubmit();
      }
    });
    paramAddFundsFragment.mEditTextAddFunds = ((UberEditText)paramFinder.findRequiredView(paramObject, 2131427582, "field 'mEditTextAddFunds'"));
    paramAddFundsFragment.mProgressBarCurrentBalanceRequest = ((ProgressBar)paramFinder.findRequiredView(paramObject, 2131427584, "field 'mProgressBarCurrentBalanceRequest'"));
    paramAddFundsFragment.mTextViewCurrencyCodeAddFunds = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427581, "field 'mTextViewCurrencyCodeAddFunds'"));
    paramAddFundsFragment.mTextViewBalanceValue = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427583, "field 'mTextViewBalanceValue'"));
    paramAddFundsFragment.mTextViewMinimumBalanceValue = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427590, "field 'mTextViewMinimumBalanceValue'"));
    paramAddFundsFragment.mTextViewTitleAddFunds = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427580, "field 'mTextViewTitleAddFunds'"));
    paramAddFundsFragment.mViewGroupDenominations = ((ViewGroup)paramFinder.findRequiredView(paramObject, 2131427585, "field 'mViewGroupDenominations'"));
  }

  public static void reset(AddFundsFragment paramAddFundsFragment)
  {
    paramAddFundsFragment.mButtonDenomination1 = null;
    paramAddFundsFragment.mButtonDenomination2 = null;
    paramAddFundsFragment.mButtonDenomination3 = null;
    paramAddFundsFragment.mButtonSubmit = null;
    paramAddFundsFragment.mEditTextAddFunds = null;
    paramAddFundsFragment.mProgressBarCurrentBalanceRequest = null;
    paramAddFundsFragment.mTextViewCurrencyCodeAddFunds = null;
    paramAddFundsFragment.mTextViewBalanceValue = null;
    paramAddFundsFragment.mTextViewMinimumBalanceValue = null;
    paramAddFundsFragment.mTextViewTitleAddFunds = null;
    paramAddFundsFragment.mViewGroupDenominations = null;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.payment.AddFundsFragment..ViewInjector
 * JD-Core Version:    0.6.2
 */