package com.ubercab.client.feature.payment;

import android.view.ViewGroup;
import android.widget.ImageView;
import butterknife.ButterKnife.Finder;
import com.ubercab.ui.UberTextView;

public class PaymentProfileAdapter$EnrollmentStatusViewHolder$$ViewInjector
{
  public static void inject(ButterKnife.Finder paramFinder, PaymentProfileAdapter.EnrollmentStatusViewHolder paramEnrollmentStatusViewHolder, Object paramObject)
  {
    paramEnrollmentStatusViewHolder.mViewGroupRewards = ((ViewGroup)paramFinder.findRequiredView(paramObject, 2131427626, "field 'mViewGroupRewards'"));
    paramEnrollmentStatusViewHolder.mViewDivider = paramFinder.findRequiredView(paramObject, 2131427625, "field 'mViewDivider'");
    paramEnrollmentStatusViewHolder.mTextViewPaymentName = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427624, "field 'mTextViewPaymentName'"));
    paramEnrollmentStatusViewHolder.mImageViewRewardsStatus = ((ImageView)paramFinder.findRequiredView(paramObject, 2131427627, "field 'mImageViewRewardsStatus'"));
    paramEnrollmentStatusViewHolder.mTextViewRewardsStatus = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427600, "field 'mTextViewRewardsStatus'"));
    paramEnrollmentStatusViewHolder.mTextViewLearnMore = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427628, "field 'mTextViewLearnMore'"));
  }

  public static void reset(PaymentProfileAdapter.EnrollmentStatusViewHolder paramEnrollmentStatusViewHolder)
  {
    paramEnrollmentStatusViewHolder.mViewGroupRewards = null;
    paramEnrollmentStatusViewHolder.mViewDivider = null;
    paramEnrollmentStatusViewHolder.mTextViewPaymentName = null;
    paramEnrollmentStatusViewHolder.mImageViewRewardsStatus = null;
    paramEnrollmentStatusViewHolder.mTextViewRewardsStatus = null;
    paramEnrollmentStatusViewHolder.mTextViewLearnMore = null;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.payment.PaymentProfileAdapter.EnrollmentStatusViewHolder..ViewInjector
 * JD-Core Version:    0.6.2
 */