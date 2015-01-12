package com.ubercab.client.feature.verification;

import android.view.View;
import android.view.View.OnClickListener;
import butterknife.ButterKnife.Finder;
import com.ubercab.ui.UberButton;
import com.ubercab.ui.UberTextView;

public class MobileVerificationSmsFragment$$ViewInjector
{
  public static void inject(ButterKnife.Finder paramFinder, MobileVerificationSmsFragment paramMobileVerificationSmsFragment, Object paramObject)
  {
    View localView1 = paramFinder.findRequiredView(paramObject, 2131427916, "field 'mButtonChangeNumber' and method 'onClickButtonChangeNumber'");
    paramMobileVerificationSmsFragment.mButtonChangeNumber = ((UberButton)localView1);
    localView1.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        this.val$target.onClickButtonChangeNumber();
      }
    });
    View localView2 = paramFinder.findRequiredView(paramObject, 2131427915, "field 'mButtonResendSms' and method 'onClickButtonResendSms'");
    paramMobileVerificationSmsFragment.mButtonResendSms = ((UberButton)localView2);
    localView2.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        this.val$target.onClickButtonResendSms();
      }
    });
    paramMobileVerificationSmsFragment.mTextViewActionRequired = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427928, "field 'mTextViewActionRequired'"));
    paramMobileVerificationSmsFragment.mTextViewPhoneNumber = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427914, "field 'mTextViewPhoneNumber'"));
    paramMobileVerificationSmsFragment.mTextViewReplyMessage = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427913, "field 'mTextViewReplyMessage'"));
    paramMobileVerificationSmsFragment.mTextViewReplyTitle = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427911, "field 'mTextViewReplyTitle'"));
  }

  public static void reset(MobileVerificationSmsFragment paramMobileVerificationSmsFragment)
  {
    paramMobileVerificationSmsFragment.mButtonChangeNumber = null;
    paramMobileVerificationSmsFragment.mButtonResendSms = null;
    paramMobileVerificationSmsFragment.mTextViewActionRequired = null;
    paramMobileVerificationSmsFragment.mTextViewPhoneNumber = null;
    paramMobileVerificationSmsFragment.mTextViewReplyMessage = null;
    paramMobileVerificationSmsFragment.mTextViewReplyTitle = null;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.verification.MobileVerificationSmsFragment..ViewInjector
 * JD-Core Version:    0.6.2
 */