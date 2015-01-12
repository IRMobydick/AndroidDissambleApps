package com.ubercab.client.feature.payment;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import butterknife.ButterKnife.Finder;
import com.ubercab.ui.UberTextView;

public class PaymentProfileAdapter$RewardsToggleViewHolder$$ViewInjector
{
  public static void inject(ButterKnife.Finder paramFinder, PaymentProfileAdapter.RewardsToggleViewHolder paramRewardsToggleViewHolder, Object paramObject)
  {
    paramRewardsToggleViewHolder.mCheckedTextViewEarn = ((CheckedTextView)paramFinder.findRequiredView(paramObject, 2131427635, "field 'mCheckedTextViewEarn'"));
    paramRewardsToggleViewHolder.mCheckedTextViewEarning = ((CheckedTextView)paramFinder.findRequiredView(paramObject, 2131427632, "field 'mCheckedTextViewEarning'"));
    paramRewardsToggleViewHolder.mCheckedTextViewUse = ((CheckedTextView)paramFinder.findRequiredView(paramObject, 2131427640, "field 'mCheckedTextViewUse'"));
    paramRewardsToggleViewHolder.mImageViewCreditCard = ((ImageView)paramFinder.findRequiredView(paramObject, 2131427631, "field 'mImageViewCreditCard'"));
    paramRewardsToggleViewHolder.mImageViewRewardsEarn = ((ImageView)paramFinder.findRequiredView(paramObject, 2131427636, "field 'mImageViewRewardsEarn'"));
    paramRewardsToggleViewHolder.mImageViewRewardsStatus = ((ImageView)paramFinder.findRequiredView(paramObject, 2131427627, "field 'mImageViewRewardsStatus'"));
    paramRewardsToggleViewHolder.mTextViewPaymentName = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427633, "field 'mTextViewPaymentName'"));
    paramRewardsToggleViewHolder.mTextViewPointBalance = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427641, "field 'mTextViewPointBalance'"));
    paramRewardsToggleViewHolder.mTextViewRewardsEarn = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427637, "field 'mTextViewRewardsEarn'"));
    View localView1 = paramFinder.findRequiredView(paramObject, 2131427634, "field 'mViewGroupRewardsEarn' and method 'onClickEarn'");
    paramRewardsToggleViewHolder.mViewGroupRewardsEarn = ((ViewGroup)localView1);
    localView1.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        this.val$target.onClickEarn();
      }
    });
    View localView2 = paramFinder.findRequiredView(paramObject, 2131427629, "field 'mViewGroupListItem' and method 'onClickPayment'");
    paramRewardsToggleViewHolder.mViewGroupListItem = ((ViewGroup)localView2);
    localView2.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        this.val$target.onClickPayment();
      }
    });
    View localView3 = paramFinder.findRequiredView(paramObject, 2131427639, "field 'mViewGroupRewardsUse' and method 'onClickUse'");
    paramRewardsToggleViewHolder.mViewGroupRewardsUse = ((ViewGroup)localView3);
    localView3.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        this.val$target.onClickUse();
      }
    });
    paramRewardsToggleViewHolder.mViewSeparator = paramFinder.findRequiredView(paramObject, 2131427638, "field 'mViewSeparator'");
  }

  public static void reset(PaymentProfileAdapter.RewardsToggleViewHolder paramRewardsToggleViewHolder)
  {
    paramRewardsToggleViewHolder.mCheckedTextViewEarn = null;
    paramRewardsToggleViewHolder.mCheckedTextViewEarning = null;
    paramRewardsToggleViewHolder.mCheckedTextViewUse = null;
    paramRewardsToggleViewHolder.mImageViewCreditCard = null;
    paramRewardsToggleViewHolder.mImageViewRewardsEarn = null;
    paramRewardsToggleViewHolder.mImageViewRewardsStatus = null;
    paramRewardsToggleViewHolder.mTextViewPaymentName = null;
    paramRewardsToggleViewHolder.mTextViewPointBalance = null;
    paramRewardsToggleViewHolder.mTextViewRewardsEarn = null;
    paramRewardsToggleViewHolder.mViewGroupRewardsEarn = null;
    paramRewardsToggleViewHolder.mViewGroupListItem = null;
    paramRewardsToggleViewHolder.mViewGroupRewardsUse = null;
    paramRewardsToggleViewHolder.mViewSeparator = null;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.payment.PaymentProfileAdapter.RewardsToggleViewHolder..ViewInjector
 * JD-Core Version:    0.6.2
 */