package com.ubercab.client.feature.payment;

import butterknife.ButterKnife.Finder;
import com.ubercab.ui.UberTextView;

public class VerifyAlipayActivity$$ViewInjector
{
  public static void inject(ButterKnife.Finder paramFinder, VerifyAlipayActivity paramVerifyAlipayActivity, Object paramObject)
  {
    paramVerifyAlipayActivity.mTextCompleteFollowingSteps = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427922, "field 'mTextCompleteFollowingSteps'"));
    paramVerifyAlipayActivity.mTextHeader = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427921, "field 'mTextHeader'"));
    paramVerifyAlipayActivity.mTextRetry = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427926, "field 'mTextRetry'"));
    paramVerifyAlipayActivity.mTextStepOne = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427923, "field 'mTextStepOne'"));
    paramVerifyAlipayActivity.mTextStepTwo = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427924, "field 'mTextStepTwo'"));
    paramVerifyAlipayActivity.mTextStepThree = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427925, "field 'mTextStepThree'"));
  }

  public static void reset(VerifyAlipayActivity paramVerifyAlipayActivity)
  {
    paramVerifyAlipayActivity.mTextCompleteFollowingSteps = null;
    paramVerifyAlipayActivity.mTextHeader = null;
    paramVerifyAlipayActivity.mTextRetry = null;
    paramVerifyAlipayActivity.mTextStepOne = null;
    paramVerifyAlipayActivity.mTextStepTwo = null;
    paramVerifyAlipayActivity.mTextStepThree = null;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.payment.VerifyAlipayActivity..ViewInjector
 * JD-Core Version:    0.6.2
 */