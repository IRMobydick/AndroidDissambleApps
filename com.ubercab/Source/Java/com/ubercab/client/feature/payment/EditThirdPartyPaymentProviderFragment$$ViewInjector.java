package com.ubercab.client.feature.payment;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import butterknife.ButterKnife.Finder;
import com.ubercab.ui.UberButton;
import com.ubercab.ui.UberTextView;

public class EditThirdPartyPaymentProviderFragment$$ViewInjector
{
  public static void inject(ButterKnife.Finder paramFinder, EditThirdPartyPaymentProviderFragment paramEditThirdPartyPaymentProviderFragment, Object paramObject)
  {
    View localView = paramFinder.findRequiredView(paramObject, 2131427605, "field 'mButtonDelete' and method 'onClickButtonDelete'");
    paramEditThirdPartyPaymentProviderFragment.mButtonDelete = ((UberButton)localView);
    localView.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        this.val$target.onClickButtonDelete();
      }
    });
    paramEditThirdPartyPaymentProviderFragment.mImageViewPaymentProvider = ((ImageView)paramFinder.findRequiredView(paramObject, 2131427647, "field 'mImageViewPaymentProvider'"));
    paramEditThirdPartyPaymentProviderFragment.mTextViewEmail = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427648, "field 'mTextViewEmail'"));
  }

  public static void reset(EditThirdPartyPaymentProviderFragment paramEditThirdPartyPaymentProviderFragment)
  {
    paramEditThirdPartyPaymentProviderFragment.mButtonDelete = null;
    paramEditThirdPartyPaymentProviderFragment.mImageViewPaymentProvider = null;
    paramEditThirdPartyPaymentProviderFragment.mTextViewEmail = null;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.payment.EditThirdPartyPaymentProviderFragment..ViewInjector
 * JD-Core Version:    0.6.2
 */