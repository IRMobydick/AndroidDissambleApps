package com.ubercab.client.feature.verification;

import android.view.View;
import android.view.View.OnClickListener;
import butterknife.ButterKnife.Finder;
import com.ubercab.client.core.ui.FlagButton;
import com.ubercab.ui.UberButton;
import com.ubercab.ui.UberEditText;
import com.ubercab.ui.UberTextView;

public class MobileVerificationChangeNumberFragment$$ViewInjector
{
  public static void inject(ButterKnife.Finder paramFinder, MobileVerificationChangeNumberFragment paramMobileVerificationChangeNumberFragment, Object paramObject)
  {
    View localView1 = paramFinder.findRequiredView(paramObject, 2131427910, "field 'mButtonContinue' and method 'onClickButtonContinue'");
    paramMobileVerificationChangeNumberFragment.mButtonContinue = ((UberButton)localView1);
    localView1.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        this.val$target.onClickButtonContinue();
      }
    });
    View localView2 = paramFinder.findRequiredView(paramObject, 2131427725, "field 'mFlagButtonCountry' and method 'onClickButtonFlag'");
    paramMobileVerificationChangeNumberFragment.mFlagButtonCountry = ((FlagButton)localView2);
    localView2.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        this.val$target.onClickButtonFlag();
      }
    });
    paramMobileVerificationChangeNumberFragment.mEditTextPhone = ((UberEditText)paramFinder.findRequiredView(paramObject, 2131427726, "field 'mEditTextPhone'"));
    paramMobileVerificationChangeNumberFragment.mTextViewNotice = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427909, "field 'mTextViewNotice'"));
  }

  public static void reset(MobileVerificationChangeNumberFragment paramMobileVerificationChangeNumberFragment)
  {
    paramMobileVerificationChangeNumberFragment.mButtonContinue = null;
    paramMobileVerificationChangeNumberFragment.mFlagButtonCountry = null;
    paramMobileVerificationChangeNumberFragment.mEditTextPhone = null;
    paramMobileVerificationChangeNumberFragment.mTextViewNotice = null;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.verification.MobileVerificationChangeNumberFragment..ViewInjector
 * JD-Core Version:    0.6.2
 */