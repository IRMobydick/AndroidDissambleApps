package com.ubercab.client.feature.payment;

import android.view.View;
import android.view.View.OnClickListener;
import butterknife.ButterKnife.Finder;
import com.ubercab.ui.UberButton;
import com.ubercab.ui.UberTextView;

public class PaymentWalletConfirmationFragment$$ViewInjector
{
  public static void inject(ButterKnife.Finder paramFinder, PaymentWalletConfirmationFragment paramPaymentWalletConfirmationFragment, Object paramObject)
  {
    View localView1 = paramFinder.findRequiredView(paramObject, 2131427547, "field 'mButtonCancel' and method 'onClickCancel'");
    paramPaymentWalletConfirmationFragment.mButtonCancel = ((UberButton)localView1);
    localView1.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        this.val$target.onClickCancel();
      }
    });
    View localView2 = paramFinder.findRequiredView(paramObject, 2131427652, "field 'mButtonOk' and method 'onClickOk'");
    paramPaymentWalletConfirmationFragment.mButtonOk = ((UberButton)localView2);
    localView2.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        this.val$target.onClickOk();
      }
    });
    paramPaymentWalletConfirmationFragment.mTextViewConfirm = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427649, "field 'mTextViewConfirm'"));
    paramPaymentWalletConfirmationFragment.mTextViewDetails = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427651, "field 'mTextViewDetails'"));
    paramPaymentWalletConfirmationFragment.mTextViewNumber = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427650, "field 'mTextViewNumber'"));
  }

  public static void reset(PaymentWalletConfirmationFragment paramPaymentWalletConfirmationFragment)
  {
    paramPaymentWalletConfirmationFragment.mButtonCancel = null;
    paramPaymentWalletConfirmationFragment.mButtonOk = null;
    paramPaymentWalletConfirmationFragment.mTextViewConfirm = null;
    paramPaymentWalletConfirmationFragment.mTextViewDetails = null;
    paramPaymentWalletConfirmationFragment.mTextViewNumber = null;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.payment.PaymentWalletConfirmationFragment..ViewInjector
 * JD-Core Version:    0.6.2
 */