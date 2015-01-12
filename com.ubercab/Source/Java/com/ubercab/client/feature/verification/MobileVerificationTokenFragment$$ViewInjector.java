package com.ubercab.client.feature.verification;

import android.view.View;
import android.view.View.OnClickListener;
import butterknife.ButterKnife.Finder;
import com.ubercab.ui.UberButton;
import com.ubercab.ui.UberEditText;
import com.ubercab.ui.UberTextView;

public class MobileVerificationTokenFragment$$ViewInjector
{
  public static void inject(ButterKnife.Finder paramFinder, MobileVerificationTokenFragment paramMobileVerificationTokenFragment, Object paramObject)
  {
    View localView1 = paramFinder.findRequiredView(paramObject, 2131427916, "field 'mButtonChangeNumber' and method 'onClickButtonChangeNumber'");
    paramMobileVerificationTokenFragment.mButtonChangeNumber = ((UberButton)localView1);
    localView1.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        this.val$target.onClickButtonChangeNumber();
      }
    });
    View localView2 = paramFinder.findRequiredView(paramObject, 2131427920, "field 'mButtonResendToken' and method 'onClickButtonResendToken'");
    paramMobileVerificationTokenFragment.mButtonResendToken = ((UberButton)localView2);
    localView2.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        this.val$target.onClickButtonResendToken();
      }
    });
    paramMobileVerificationTokenFragment.mEditTextToken = ((UberEditText)paramFinder.findRequiredView(paramObject, 2131427919, "field 'mEditTextToken'"));
    paramMobileVerificationTokenFragment.mTextViewTokenMessage = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427918, "field 'mTextViewTokenMessage'"));
    paramMobileVerificationTokenFragment.mTextViewTokenTitle = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427917, "field 'mTextViewTokenTitle'"));
  }

  public static void reset(MobileVerificationTokenFragment paramMobileVerificationTokenFragment)
  {
    paramMobileVerificationTokenFragment.mButtonChangeNumber = null;
    paramMobileVerificationTokenFragment.mButtonResendToken = null;
    paramMobileVerificationTokenFragment.mEditTextToken = null;
    paramMobileVerificationTokenFragment.mTextViewTokenMessage = null;
    paramMobileVerificationTokenFragment.mTextViewTokenTitle = null;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.verification.MobileVerificationTokenFragment..ViewInjector
 * JD-Core Version:    0.6.2
 */