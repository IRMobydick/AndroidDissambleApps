package com.ubercab.client.feature.signup;

import android.view.View;
import android.view.View.OnClickListener;
import butterknife.ButterKnife.Finder;
import com.ubercab.ui.UberButton;
import com.ubercab.ui.UberTextView;

public class SignupPaymentLastStepFragment$$ViewInjector
{
  public static void inject(ButterKnife.Finder paramFinder, SignupPaymentLastStepFragment paramSignupPaymentLastStepFragment, Object paramObject)
  {
    View localView1 = paramFinder.findRequiredView(paramObject, 2131427659, "field 'mButtonAddFunds' and method 'onClickAddFunds'");
    paramSignupPaymentLastStepFragment.mButtonAddFunds = ((UberButton)localView1);
    localView1.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        this.val$target.onClickAddFunds();
      }
    });
    View localView2 = paramFinder.findRequiredView(paramObject, 2131427745, "field 'mButtonPromoCode' and method 'onClickPromoCode'");
    paramSignupPaymentLastStepFragment.mButtonPromoCode = ((UberButton)localView2);
    localView2.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        this.val$target.onClickPromoCode();
      }
    });
    paramSignupPaymentLastStepFragment.mTextViewDescription = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427744, "field 'mTextViewDescription'"));
    paramSignupPaymentLastStepFragment.mTextViewTitle = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427928, "field 'mTextViewTitle'"));
  }

  public static void reset(SignupPaymentLastStepFragment paramSignupPaymentLastStepFragment)
  {
    paramSignupPaymentLastStepFragment.mButtonAddFunds = null;
    paramSignupPaymentLastStepFragment.mButtonPromoCode = null;
    paramSignupPaymentLastStepFragment.mTextViewDescription = null;
    paramSignupPaymentLastStepFragment.mTextViewTitle = null;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.signup.SignupPaymentLastStepFragment..ViewInjector
 * JD-Core Version:    0.6.2
 */