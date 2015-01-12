package com.ubercab.client.feature.receipt;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Spinner;
import butterknife.ButterKnife.Finder;
import com.ubercab.ui.UberButton;
import com.ubercab.ui.UberEditText;
import com.ubercab.ui.UberTextView;

public class ReceiptFragment$$ViewInjector
{
  public static void inject(ButterKnife.Finder paramFinder, ReceiptFragment paramReceiptFragment, Object paramObject)
  {
    paramReceiptFragment.mRatingBar = ((RatingBar)paramFinder.findRequiredView(paramObject, 2131427684, "field 'mRatingBar'"));
    View localView = paramFinder.findRequiredView(paramObject, 2131427687, "field 'mButtonSubmit' and method 'onClickSubmit'");
    paramReceiptFragment.mButtonSubmit = ((UberButton)localView);
    localView.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        this.val$target.onClickSubmit();
      }
    });
    paramReceiptFragment.mTextViewFare = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427677, "field 'mTextViewFare'"));
    paramReceiptFragment.mViewGroupRewards = ((ViewGroup)paramFinder.findRequiredView(paramObject, 2131427678, "field 'mViewGroupRewards'"));
    paramReceiptFragment.mTextViewRewardsHeading = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427679, "field 'mTextViewRewardsHeading'"));
    paramReceiptFragment.mTextViewRewardsDetails = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427680, "field 'mTextViewRewardsDetails'"));
    paramReceiptFragment.mSpinnerFeedback = ((Spinner)paramFinder.findRequiredView(paramObject, 2131427685, "field 'mSpinnerFeedback'"));
    paramReceiptFragment.mImageViewVehicle = ((ImageView)paramFinder.findRequiredView(paramObject, 2131427683, "field 'mImageViewVehicle'"));
    paramReceiptFragment.mEditTextComment = ((UberEditText)paramFinder.findRequiredView(paramObject, 2131427686, "field 'mEditTextComment'"));
    paramReceiptFragment.mTextViewDriverName = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427682, "field 'mTextViewDriverName'"));
    paramReceiptFragment.mImageViewDriverPhoto = ((ImageView)paramFinder.findRequiredView(paramObject, 2131427681, "field 'mImageViewDriverPhoto'"));
    paramReceiptFragment.mTextViewHeaderRate = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427928, "field 'mTextViewHeaderRate'"));
  }

  public static void reset(ReceiptFragment paramReceiptFragment)
  {
    paramReceiptFragment.mRatingBar = null;
    paramReceiptFragment.mButtonSubmit = null;
    paramReceiptFragment.mTextViewFare = null;
    paramReceiptFragment.mViewGroupRewards = null;
    paramReceiptFragment.mTextViewRewardsHeading = null;
    paramReceiptFragment.mTextViewRewardsDetails = null;
    paramReceiptFragment.mSpinnerFeedback = null;
    paramReceiptFragment.mImageViewVehicle = null;
    paramReceiptFragment.mEditTextComment = null;
    paramReceiptFragment.mTextViewDriverName = null;
    paramReceiptFragment.mImageViewDriverPhoto = null;
    paramReceiptFragment.mTextViewHeaderRate = null;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.receipt.ReceiptFragment..ViewInjector
 * JD-Core Version:    0.6.2
 */