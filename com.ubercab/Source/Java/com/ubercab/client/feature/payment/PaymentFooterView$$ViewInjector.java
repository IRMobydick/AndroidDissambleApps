package com.ubercab.client.feature.payment;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import butterknife.ButterKnife.Finder;

public class PaymentFooterView$$ViewInjector
{
  public static void inject(ButterKnife.Finder paramFinder, PaymentFooterView paramPaymentFooterView, Object paramObject)
  {
    View localView1 = paramFinder.findRequiredView(paramObject, 2131427566, "field 'mExpenseInfoButton' and method 'onClickExpenseInfo'");
    paramPaymentFooterView.mExpenseInfoButton = ((Button)localView1);
    localView1.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        this.val$target.onClickExpenseInfo();
      }
    });
    View localView2 = paramFinder.findRequiredView(paramObject, 2131427567, "field 'mPromoButton' and method 'onClickPromoApply'");
    paramPaymentFooterView.mPromoButton = ((Button)localView2);
    localView2.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        this.val$target.onClickPromoApply();
      }
    });
  }

  public static void reset(PaymentFooterView paramPaymentFooterView)
  {
    paramPaymentFooterView.mExpenseInfoButton = null;
    paramPaymentFooterView.mPromoButton = null;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.payment.PaymentFooterView..ViewInjector
 * JD-Core Version:    0.6.2
 */