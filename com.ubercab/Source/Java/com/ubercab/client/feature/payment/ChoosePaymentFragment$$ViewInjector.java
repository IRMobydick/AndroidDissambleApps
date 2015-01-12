package com.ubercab.client.feature.payment;

import android.view.View;
import android.view.View.OnClickListener;
import butterknife.ButterKnife.Finder;
import com.ubercab.ui.UberButton;
import com.ubercab.ui.UberTextView;

public class ChoosePaymentFragment$$ViewInjector
{
  public static void inject(ButterKnife.Finder paramFinder, ChoosePaymentFragment paramChoosePaymentFragment, Object paramObject)
  {
    View localView = paramFinder.findRequiredView(paramObject, 2131427593, "field 'mButtonPrepaid' and method 'onClickPrepaid'");
    paramChoosePaymentFragment.mButtonPrepaid = ((UberButton)localView);
    localView.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        this.val$target.onClickPrepaid();
      }
    });
    paramChoosePaymentFragment.mTextViewOr = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427928, "field 'mTextViewOr'"));
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
  }

  public static void reset(ChoosePaymentFragment paramChoosePaymentFragment)
  {
    paramChoosePaymentFragment.mButtonPrepaid = null;
    paramChoosePaymentFragment.mTextViewOr = null;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.payment.ChoosePaymentFragment..ViewInjector
 * JD-Core Version:    0.6.2
 */