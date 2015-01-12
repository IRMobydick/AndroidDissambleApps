package com.ubercab.client.feature.payment;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ProgressBar;
import butterknife.ButterKnife.Finder;
import com.ubercab.ui.UberButton;
import com.ubercab.ui.UberTextView;

public class EditWalletPaymentFragment$$ViewInjector
{
  public static void inject(ButterKnife.Finder paramFinder, EditWalletPaymentFragment paramEditWalletPaymentFragment, Object paramObject)
  {
    View localView1 = paramFinder.findRequiredView(paramObject, 2131427659, "field 'mButtonAddFunds' and method 'onClickButtonAddFunds'");
    paramEditWalletPaymentFragment.mButtonAddFunds = ((UberButton)localView1);
    localView1.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        this.val$target.onClickButtonAddFunds();
      }
    });
    View localView2 = paramFinder.findRequiredView(paramObject, 2131427605, "field 'mButtonDelete' and method 'onClickButtonDelete'");
    paramEditWalletPaymentFragment.mButtonDelete = ((UberButton)localView2);
    localView2.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        this.val$target.onClickButtonDelete();
      }
    });
    paramEditWalletPaymentFragment.mImageViewWalletPaymentProvider = ((ImageView)paramFinder.findRequiredView(paramObject, 2131427658, "field 'mImageViewWalletPaymentProvider'"));
    paramEditWalletPaymentFragment.mProgressBarCurrentBalanceRequest = ((ProgressBar)paramFinder.findRequiredView(paramObject, 2131427584, "field 'mProgressBarCurrentBalanceRequest'"));
    paramEditWalletPaymentFragment.mTextViewBalanceValue = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427583, "field 'mTextViewBalanceValue'"));
    paramEditWalletPaymentFragment.mTextViewNumber = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427650, "field 'mTextViewNumber'"));
    paramEditWalletPaymentFragment.mTextViewHeader = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427928, "field 'mTextViewHeader'"));
  }

  public static void reset(EditWalletPaymentFragment paramEditWalletPaymentFragment)
  {
    paramEditWalletPaymentFragment.mButtonAddFunds = null;
    paramEditWalletPaymentFragment.mButtonDelete = null;
    paramEditWalletPaymentFragment.mImageViewWalletPaymentProvider = null;
    paramEditWalletPaymentFragment.mProgressBarCurrentBalanceRequest = null;
    paramEditWalletPaymentFragment.mTextViewBalanceValue = null;
    paramEditWalletPaymentFragment.mTextViewNumber = null;
    paramEditWalletPaymentFragment.mTextViewHeader = null;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.payment.EditWalletPaymentFragment..ViewInjector
 * JD-Core Version:    0.6.2
 */