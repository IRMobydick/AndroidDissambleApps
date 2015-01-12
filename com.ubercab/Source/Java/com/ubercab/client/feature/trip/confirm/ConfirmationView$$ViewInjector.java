package com.ubercab.client.feature.trip.confirm;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TabHost;
import butterknife.ButterKnife.Finder;
import com.ubercab.client.core.ui.PaymentTextView;
import com.ubercab.ui.UberButton;
import com.ubercab.ui.UberTextView;

public class ConfirmationView$$ViewInjector
{
  public static void inject(ButterKnife.Finder paramFinder, ConfirmationView paramConfirmationView, Object paramObject)
  {
    paramConfirmationView.mTextEta = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427869, "field 'mTextEta'"));
    View localView1 = paramFinder.findRequiredView(paramObject, 2131427868, "field 'mButtonRequest' and method 'onClickRequestButton'");
    paramConfirmationView.mButtonRequest = ((UberButton)localView1);
    localView1.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        this.val$target.onClickRequestButton();
      }
    });
    paramConfirmationView.mTextViewPromo = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427867, "field 'mTextViewPromo'"));
    paramConfirmationView.mViewGroupButtons = ((ViewGroup)paramFinder.findRequiredView(paramObject, 2131427863, "field 'mViewGroupButtons'"));
    View localView2 = paramFinder.findRequiredView(paramObject, 2131427858, "field 'mViewGroupPayment' and method 'onClickPaymentButton'");
    paramConfirmationView.mViewGroupPayment = ((ViewGroup)localView2);
    localView2.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        this.val$target.onClickPaymentButton();
      }
    });
    paramConfirmationView.mTextViewPayment = ((PaymentTextView)paramFinder.findRequiredView(paramObject, 2131427859, "field 'mTextViewPayment'"));
    paramConfirmationView.mTextViewPointBalance = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427861, "field 'mTextViewPointBalance'"));
    paramConfirmationView.mTextViewFareQuote = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427865, "field 'mTextViewFareQuote'"));
    paramConfirmationView.mTextViewPaymentCredits = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427862, "field 'mTextViewPaymentCredits'"));
    paramConfirmationView.mTextViewPaymentNotIncluded = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427856, "field 'mTextViewPaymentNotIncluded'"));
    paramConfirmationView.mTextViewRewardsDoNotApply = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427857, "field 'mTextViewRewardsDoNotApply'"));
    paramConfirmationView.mViewGroupPaymentDisclosure = ((ViewGroup)paramFinder.findRequiredView(paramObject, 2131427855, "field 'mViewGroupPaymentDisclosure'"));
    paramConfirmationView.mViewGroupPointBalance = ((ViewGroup)paramFinder.findRequiredView(paramObject, 2131427860, "field 'mViewGroupPointBalance'"));
    paramConfirmationView.mTabHost = ((TabHost)paramFinder.findRequiredView(paramObject, 16908306, "field 'mTabHost'"));
    paramFinder.findRequiredView(paramObject, 2131427864, "method 'onClickButtonFareQuote'").setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        this.val$target.onClickButtonFareQuote();
      }
    });
    paramFinder.findRequiredView(paramObject, 2131427866, "method 'onClickPromoButton'").setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        this.val$target.onClickPromoButton();
      }
    });
  }

  public static void reset(ConfirmationView paramConfirmationView)
  {
    paramConfirmationView.mTextEta = null;
    paramConfirmationView.mButtonRequest = null;
    paramConfirmationView.mTextViewPromo = null;
    paramConfirmationView.mViewGroupButtons = null;
    paramConfirmationView.mViewGroupPayment = null;
    paramConfirmationView.mTextViewPayment = null;
    paramConfirmationView.mTextViewPointBalance = null;
    paramConfirmationView.mTextViewFareQuote = null;
    paramConfirmationView.mTextViewPaymentCredits = null;
    paramConfirmationView.mTextViewPaymentNotIncluded = null;
    paramConfirmationView.mTextViewRewardsDoNotApply = null;
    paramConfirmationView.mViewGroupPaymentDisclosure = null;
    paramConfirmationView.mViewGroupPointBalance = null;
    paramConfirmationView.mTabHost = null;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.trip.confirm.ConfirmationView..ViewInjector
 * JD-Core Version:    0.6.2
 */