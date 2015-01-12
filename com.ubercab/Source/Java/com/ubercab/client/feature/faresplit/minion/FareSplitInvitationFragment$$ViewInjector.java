package com.ubercab.client.feature.faresplit.minion;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ProgressBar;
import butterknife.ButterKnife.Finder;
import com.ubercab.ui.UberButton;
import com.ubercab.ui.UberTextView;

public class FareSplitInvitationFragment$$ViewInjector
{
  public static void inject(ButterKnife.Finder paramFinder, FareSplitInvitationFragment paramFareSplitInvitationFragment, Object paramObject)
  {
    paramFareSplitInvitationFragment.mViewContent = paramFinder.findRequiredView(paramObject, 2131427452, "field 'mViewContent'");
    paramFareSplitInvitationFragment.mTextViewFee = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427460, "field 'mTextViewFee'"));
    View localView1 = paramFinder.findRequiredView(paramObject, 2131427462, "field 'mButtonAccept' and method 'onButtonAcceptClicked'");
    paramFareSplitInvitationFragment.mButtonAccept = ((UberButton)localView1);
    localView1.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        this.val$target.onButtonAcceptClicked();
      }
    });
    View localView2 = paramFinder.findRequiredView(paramObject, 2131427461, "field 'mButtonDecline' and method 'onButtonDeclineClicked'");
    paramFareSplitInvitationFragment.mButtonDecline = ((UberButton)localView2);
    localView2.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        this.val$target.onButtonDeclineClicked();
      }
    });
    paramFareSplitInvitationFragment.mTextViewTitle = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427458, "field 'mTextViewTitle'"));
    paramFareSplitInvitationFragment.mImageViewPicture = ((ImageView)paramFinder.findRequiredView(paramObject, 2131427457, "field 'mImageViewPicture'"));
    paramFareSplitInvitationFragment.mTextViewSubtitle = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427459, "field 'mTextViewSubtitle'"));
    paramFareSplitInvitationFragment.mProgressBarLoading = ((ProgressBar)paramFinder.findRequiredView(paramObject, 2131427463, "field 'mProgressBarLoading'"));
  }

  public static void reset(FareSplitInvitationFragment paramFareSplitInvitationFragment)
  {
    paramFareSplitInvitationFragment.mViewContent = null;
    paramFareSplitInvitationFragment.mTextViewFee = null;
    paramFareSplitInvitationFragment.mButtonAccept = null;
    paramFareSplitInvitationFragment.mButtonDecline = null;
    paramFareSplitInvitationFragment.mTextViewTitle = null;
    paramFareSplitInvitationFragment.mImageViewPicture = null;
    paramFareSplitInvitationFragment.mTextViewSubtitle = null;
    paramFareSplitInvitationFragment.mProgressBarLoading = null;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.faresplit.minion.FareSplitInvitationFragment..ViewInjector
 * JD-Core Version:    0.6.2
 */