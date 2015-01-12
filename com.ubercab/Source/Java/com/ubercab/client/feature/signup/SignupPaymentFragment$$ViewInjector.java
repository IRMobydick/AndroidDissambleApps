package com.ubercab.client.feature.signup;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import butterknife.ButterKnife.Finder;
import com.ubercab.client.core.ui.CountryButton;
import com.ubercab.client.core.ui.MonthEditText;
import com.ubercab.client.core.ui.YearEditText;
import com.ubercab.library.ui.ZipEditText;
import com.ubercab.payment.ui.CreditCardEditText;
import com.ubercab.payment.ui.SecurityCodeEditText;
import com.ubercab.ui.UberButton;
import com.ubercab.ui.UberTextView;

public class SignupPaymentFragment$$ViewInjector
{
  public static void inject(ButterKnife.Finder paramFinder, SignupPaymentFragment paramSignupPaymentFragment, Object paramObject)
  {
    paramSignupPaymentFragment.mViewGroupHeaderOr = ((ViewGroup)paramFinder.findRequiredView(paramObject, 2131427577, "field 'mViewGroupHeaderOr'"));
    paramSignupPaymentFragment.mTextViewOr = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427928, "field 'mTextViewOr'"));
    paramSignupPaymentFragment.mLegalDescription = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427743, "field 'mLegalDescription'"));
    paramSignupPaymentFragment.mViewGroupPromo = ((ViewGroup)paramFinder.findRequiredView(paramObject, 2131427728, "field 'mViewGroupPromo'"));
    paramSignupPaymentFragment.mImageViewPromoPicture = ((ImageView)paramFinder.findRequiredView(paramObject, 2131427729, "field 'mImageViewPromoPicture'"));
    paramSignupPaymentFragment.mTextViewPromo1 = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427730, "field 'mTextViewPromo1'"));
    paramSignupPaymentFragment.mTextViewPromo2 = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427731, "field 'mTextViewPromo2'"));
    View localView1 = paramFinder.findRequiredView(paramObject, 2131427742, "field 'mButtonAlipay' and method 'onClickAlipay'");
    paramSignupPaymentFragment.mButtonAlipay = ((ImageButton)localView1);
    localView1.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        this.val$target.onClickAlipay();
      }
    });
    View localView2 = paramFinder.findRequiredView(paramObject, 2131427740, "field 'mButtonPaypal' and method 'onClickPayPal'");
    paramSignupPaymentFragment.mButtonPaypal = ((ImageButton)localView2);
    localView2.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        this.val$target.onClickPayPal();
      }
    });
    View localView3 = paramFinder.findRequiredView(paramObject, 2131427741, "field 'mButtonGoogleWallet' and method 'onClickGoogleWallet'");
    paramSignupPaymentFragment.mButtonGoogleWallet = ((ImageButton)localView3);
    localView3.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        this.val$target.onClickGoogleWallet();
      }
    });
    paramSignupPaymentFragment.mEditTextCardNumber = ((CreditCardEditText)paramFinder.findRequiredView(paramObject, 2131427732, "field 'mEditTextCardNumber'"));
    paramSignupPaymentFragment.mEditTextCardCode = ((SecurityCodeEditText)paramFinder.findRequiredView(paramObject, 2131427736, "field 'mEditTextCardCode'"));
    paramSignupPaymentFragment.mEditTextMonth = ((MonthEditText)paramFinder.findRequiredView(paramObject, 2131427733, "field 'mEditTextMonth'"));
    paramSignupPaymentFragment.mEditTextYear = ((YearEditText)paramFinder.findRequiredView(paramObject, 2131427735, "field 'mEditTextYear'"));
    View localView4 = paramFinder.findRequiredView(paramObject, 2131427738, "field 'mCountryButton' and method 'onClickFlag'");
    paramSignupPaymentFragment.mCountryButton = ((CountryButton)localView4);
    localView4.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        this.val$target.onClickFlag();
      }
    });
    paramSignupPaymentFragment.mEditTextZip = ((ZipEditText)paramFinder.findRequiredView(paramObject, 2131427737, "field 'mEditTextZip'"));
    View localView5 = paramFinder.findRequiredView(paramObject, 2131427597, "field 'mButtonLegal' and method 'onClickLegal'");
    paramSignupPaymentFragment.mButtonLegal = ((UberButton)localView5);
    localView5.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        this.val$target.onClickLegal();
      }
    });
    View localView6 = paramFinder.findRequiredView(paramObject, 2131427739, "field 'mButtonDone' and method 'onClickDone'");
    paramSignupPaymentFragment.mButtonDone = ((UberButton)localView6);
    localView6.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        this.val$target.onClickDone();
      }
    });
    View localView7 = paramFinder.findRequiredView(paramObject, 2131427734, "field 'mButtonScanCard' and method 'onClickScanCard'");
    paramSignupPaymentFragment.mButtonScanCard = ((UberButton)localView7);
    localView7.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        this.val$target.onClickScanCard();
      }
    });
  }

  public static void reset(SignupPaymentFragment paramSignupPaymentFragment)
  {
    paramSignupPaymentFragment.mViewGroupHeaderOr = null;
    paramSignupPaymentFragment.mTextViewOr = null;
    paramSignupPaymentFragment.mLegalDescription = null;
    paramSignupPaymentFragment.mViewGroupPromo = null;
    paramSignupPaymentFragment.mImageViewPromoPicture = null;
    paramSignupPaymentFragment.mTextViewPromo1 = null;
    paramSignupPaymentFragment.mTextViewPromo2 = null;
    paramSignupPaymentFragment.mButtonAlipay = null;
    paramSignupPaymentFragment.mButtonPaypal = null;
    paramSignupPaymentFragment.mButtonGoogleWallet = null;
    paramSignupPaymentFragment.mEditTextCardNumber = null;
    paramSignupPaymentFragment.mEditTextCardCode = null;
    paramSignupPaymentFragment.mEditTextMonth = null;
    paramSignupPaymentFragment.mEditTextYear = null;
    paramSignupPaymentFragment.mCountryButton = null;
    paramSignupPaymentFragment.mEditTextZip = null;
    paramSignupPaymentFragment.mButtonLegal = null;
    paramSignupPaymentFragment.mButtonDone = null;
    paramSignupPaymentFragment.mButtonScanCard = null;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.signup.SignupPaymentFragment..ViewInjector
 * JD-Core Version:    0.6.2
 */