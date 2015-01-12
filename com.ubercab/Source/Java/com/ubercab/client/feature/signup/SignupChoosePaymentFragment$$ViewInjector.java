package com.ubercab.client.feature.signup;

import android.view.View;
import android.view.View.OnClickListener;
import butterknife.ButterKnife.Finder;
import com.ubercab.ui.UberTextView;

public class SignupChoosePaymentFragment$$ViewInjector
{
  public static void inject(ButterKnife.Finder paramFinder, SignupChoosePaymentFragment paramSignupChoosePaymentFragment, Object paramObject)
  {
    paramSignupChoosePaymentFragment.mTextViewOr = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427928, "field 'mTextViewOr'"));
    paramFinder.findRequiredView(paramObject, 2131427591, "method 'onClickCreditCard'").setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        this.val$target.onClickCreditCard();
      }
    });
    paramFinder.findRequiredView(paramObject, 2131427597, "method 'onClickLegal'").setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        this.val$target.onClickLegal();
      }
    });
    paramFinder.findRequiredView(paramObject, 2131427593, "method 'onClickPrepaid'").setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        this.val$target.onClickPrepaid();
      }
    });
  }

  public static void reset(SignupChoosePaymentFragment paramSignupChoosePaymentFragment)
  {
    paramSignupChoosePaymentFragment.mTextViewOr = null;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.signup.SignupChoosePaymentFragment..ViewInjector
 * JD-Core Version:    0.6.2
 */