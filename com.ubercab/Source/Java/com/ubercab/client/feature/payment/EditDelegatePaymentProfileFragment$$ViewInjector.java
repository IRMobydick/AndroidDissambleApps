package com.ubercab.client.feature.payment;

import butterknife.ButterKnife.Finder;
import com.ubercab.ui.UberTextView;

public class EditDelegatePaymentProfileFragment$$ViewInjector
{
  public static void inject(ButterKnife.Finder paramFinder, EditDelegatePaymentProfileFragment paramEditDelegatePaymentProfileFragment, Object paramObject)
  {
    paramEditDelegatePaymentProfileFragment.mTextViewNoEditMessage = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427561, "field 'mTextViewNoEditMessage'"));
    paramEditDelegatePaymentProfileFragment.mTextViewPaymentProfileName = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427560, "field 'mTextViewPaymentProfileName'"));
  }

  public static void reset(EditDelegatePaymentProfileFragment paramEditDelegatePaymentProfileFragment)
  {
    paramEditDelegatePaymentProfileFragment.mTextViewNoEditMessage = null;
    paramEditDelegatePaymentProfileFragment.mTextViewPaymentProfileName = null;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.payment.EditDelegatePaymentProfileFragment..ViewInjector
 * JD-Core Version:    0.6.2
 */