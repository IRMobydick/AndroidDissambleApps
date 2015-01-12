package com.ubercab.client.feature.payment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;
import com.ubercab.ui.UberButton;
import com.ubercab.ui.UberEditText;
import com.ubercab.ui.UberTextView;

public class PaymentOtpFragment$$ViewInjector
{
  public static void inject(ButterKnife.Finder paramFinder, PaymentOtpFragment paramPaymentOtpFragment, Object paramObject)
  {
    View localView1 = paramFinder.findRequiredView(paramObject, 2131427612, "field 'mButtonVerify' and method 'onClickVerify'");
    paramPaymentOtpFragment.mButtonVerify = ((UberButton)localView1);
    localView1.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        this.val$target.onClickVerify();
      }
    });
    paramPaymentOtpFragment.mTextViewInstructionsSubtext = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427610, "field 'mTextViewInstructionsSubtext'"));
    View localView2 = paramFinder.findRequiredView(paramObject, 2131427611, "field 'mEditTextOtp' and method 'onTextChangedOtp'");
    paramPaymentOtpFragment.mEditTextOtp = ((UberEditText)localView2);
    ((TextView)localView2).addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
      }

      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
      }

      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        this.val$target.onTextChangedOtp();
      }
    });
  }

  public static void reset(PaymentOtpFragment paramPaymentOtpFragment)
  {
    paramPaymentOtpFragment.mButtonVerify = null;
    paramPaymentOtpFragment.mTextViewInstructionsSubtext = null;
    paramPaymentOtpFragment.mEditTextOtp = null;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.payment.PaymentOtpFragment..ViewInjector
 * JD-Core Version:    0.6.2
 */