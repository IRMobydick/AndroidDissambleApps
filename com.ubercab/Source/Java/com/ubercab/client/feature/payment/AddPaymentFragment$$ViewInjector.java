package com.ubercab.client.feature.payment;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import butterknife.ButterKnife.Finder;
import com.ubercab.client.core.ui.CountryButton;
import com.ubercab.client.core.ui.MonthEditText;
import com.ubercab.client.core.ui.YearEditText;
import com.ubercab.library.ui.ZipEditText;
import com.ubercab.payment.ui.CreditCardEditText;
import com.ubercab.payment.ui.SecurityCodeEditText;
import com.ubercab.ui.UberButton;
import com.ubercab.ui.UberTextView;

public class AddPaymentFragment$$ViewInjector
{
  public static void inject(ButterKnife.Finder paramFinder, AddPaymentFragment paramAddPaymentFragment, Object paramObject)
  {
    View localView1 = paramFinder.findRequiredView(paramObject, 2131427571, "field 'mButtonScanCard' and method 'onClickScanCard'");
    paramAddPaymentFragment.mButtonScanCard = ((UberButton)localView1);
    localView1.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        this.val$target.onClickScanCard();
      }
    });
    View localView2 = paramFinder.findRequiredView(paramObject, 2131427574, "field 'mEditTextZip' and method 'onEditorAction'");
    paramAddPaymentFragment.mEditTextZip = ((ZipEditText)localView2);
    ((TextView)localView2).setOnEditorActionListener(new TextView.OnEditorActionListener()
    {
      public boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        return this.val$target.onEditorAction();
      }
    });
    View localView3 = paramFinder.findRequiredView(paramObject, 2131427575, "field 'mButtonCountry' and method 'onClickCountry'");
    paramAddPaymentFragment.mButtonCountry = ((CountryButton)localView3);
    localView3.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        this.val$target.onClickCountry();
      }
    });
    View localView4 = paramFinder.findRequiredView(paramObject, 2131427576, "field 'mButtonAddPayment' and method 'onClickButtonAddPayment'");
    paramAddPaymentFragment.mButtonAddPayment = ((UberButton)localView4);
    localView4.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        this.val$target.onClickButtonAddPayment((UberButton)paramAnonymousView);
      }
    });
    View localView5 = paramFinder.findRequiredView(paramObject, 2131427579, "field 'mImageButtonAlipay' and method 'onClickImageButtonAlipay'");
    paramAddPaymentFragment.mImageButtonAlipay = ((ImageButton)localView5);
    localView5.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        this.val$target.onClickImageButtonAlipay();
      }
    });
    View localView6 = paramFinder.findRequiredView(paramObject, 2131427578, "field 'mImageButtonPayPal' and method 'onClickImageButtonPayPal'");
    paramAddPaymentFragment.mImageButtonPayPal = ((ImageButton)localView6);
    localView6.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        this.val$target.onClickImageButtonPayPal();
      }
    });
    paramAddPaymentFragment.mViewGroupHeaderOr = ((ViewGroup)paramFinder.findRequiredView(paramObject, 2131427577, "field 'mViewGroupHeaderOr'"));
    paramAddPaymentFragment.mTextViewHeaderOr = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427928, "field 'mTextViewHeaderOr'"));
    paramAddPaymentFragment.mEditTextExpirationYear = ((YearEditText)paramFinder.findRequiredView(paramObject, 2131427572, "field 'mEditTextExpirationYear'"));
    paramAddPaymentFragment.mEditTextExpirationMonth = ((MonthEditText)paramFinder.findRequiredView(paramObject, 2131427570, "field 'mEditTextExpirationMonth'"));
    paramAddPaymentFragment.mEditTextCreditCardCode = ((SecurityCodeEditText)paramFinder.findRequiredView(paramObject, 2131427573, "field 'mEditTextCreditCardCode'"));
    paramAddPaymentFragment.mEditTextCreditCardNumber = ((CreditCardEditText)paramFinder.findRequiredView(paramObject, 2131427569, "field 'mEditTextCreditCardNumber'"));
  }

  public static void reset(AddPaymentFragment paramAddPaymentFragment)
  {
    paramAddPaymentFragment.mButtonScanCard = null;
    paramAddPaymentFragment.mEditTextZip = null;
    paramAddPaymentFragment.mButtonCountry = null;
    paramAddPaymentFragment.mButtonAddPayment = null;
    paramAddPaymentFragment.mImageButtonAlipay = null;
    paramAddPaymentFragment.mImageButtonPayPal = null;
    paramAddPaymentFragment.mViewGroupHeaderOr = null;
    paramAddPaymentFragment.mTextViewHeaderOr = null;
    paramAddPaymentFragment.mEditTextExpirationYear = null;
    paramAddPaymentFragment.mEditTextExpirationMonth = null;
    paramAddPaymentFragment.mEditTextCreditCardCode = null;
    paramAddPaymentFragment.mEditTextCreditCardNumber = null;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.payment.AddPaymentFragment..ViewInjector
 * JD-Core Version:    0.6.2
 */