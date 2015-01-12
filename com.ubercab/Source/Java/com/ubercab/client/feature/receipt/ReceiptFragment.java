package com.ubercab.client.feature.receipt;

import android.app.ActionBar;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.Spinner;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import com.ubercab.client.core.analytics.AnalyticsManager;
import com.ubercab.client.core.analytics.event.RateDriverEvent;
import com.ubercab.client.core.app.RiderFragment;
import com.ubercab.client.core.content.PingProvider;
import com.ubercab.client.core.content.SessionPreferences;
import com.ubercab.client.core.content.event.PingEvent;
import com.ubercab.client.core.model.Client;
import com.ubercab.client.core.model.ExtraPaymentData;
import com.ubercab.client.core.model.FeedbackType;
import com.ubercab.client.core.model.PaymentProfile;
import com.ubercab.client.core.model.Ping;
import com.ubercab.client.core.model.RewardInfo;
import com.ubercab.client.core.model.TripPendingRating;
import com.ubercab.client.core.model.TripPendingRatingDriver;
import com.ubercab.client.core.model.VehicleView;
import com.ubercab.client.core.network.RiderClient;
import com.ubercab.client.core.network.events.RatingDriverResponseEvent;
import com.ubercab.client.core.util.PingUtils;
import com.ubercab.client.feature.receipt.event.ReceiptRateEvent;
import com.ubercab.library.app.annotation.ForActivity;
import com.ubercab.ui.UberButton;
import com.ubercab.ui.UberEditText;
import com.ubercab.ui.UberTextView;
import java.text.SimpleDateFormat;
import java.util.Locale;
import javax.inject.Inject;

public class ReceiptFragment extends RiderFragment
  implements RatingBar.OnRatingBarChangeListener
{
  private static final SimpleDateFormat FORMAT = new SimpleDateFormat("MMMM dd', 'hh:mm aa", Locale.getDefault());
  private static final int LOWEST_GOOD_RATING = 4;

  @Inject
  ActionBar mActionBar;

  @Inject
  AnalyticsManager mAnalyticsManager;

  @Inject
  Bus mBus;

  @InjectView(2131427687)
  UberButton mButtonSubmit;

  @ForActivity
  @Inject
  Context mContext;

  @InjectView(2131427686)
  UberEditText mEditTextComment;
  private TripPendingRating mFakeTripPendingRating;

  @InjectView(2131427681)
  ImageView mImageViewDriverPhoto;

  @InjectView(2131427683)
  ImageView mImageViewVehicle;

  @Inject
  Picasso mPicasso;

  @Inject
  PingProvider mPingProvider;

  @InjectView(2131427684)
  RatingBar mRatingBar;

  @Inject
  RiderClient mRiderClient;

  @Inject
  SessionPreferences mSessionPreferences;

  @InjectView(2131427685)
  Spinner mSpinnerFeedback;

  @InjectView(2131427682)
  UberTextView mTextViewDriverName;

  @InjectView(2131427677)
  UberTextView mTextViewFare;

  @InjectView(2131427928)
  UberTextView mTextViewHeaderRate;

  @InjectView(2131427680)
  UberTextView mTextViewRewardsDetails;

  @InjectView(2131427679)
  UberTextView mTextViewRewardsHeading;

  @InjectView(2131427678)
  ViewGroup mViewGroupRewards;

  public static ReceiptFragment newInstance()
  {
    return new ReceiptFragment();
  }

  public static ReceiptFragment newInstance(TripPendingRating paramTripPendingRating)
  {
    ReceiptFragment localReceiptFragment = new ReceiptFragment();
    localReceiptFragment.mFakeTripPendingRating = paramTripPendingRating;
    return localReceiptFragment;
  }

  private void updateUI(Client paramClient)
  {
    int i = 1;
    TripPendingRating localTripPendingRating = paramClient.getTripPendingRating();
    updateUI(localTripPendingRating);
    boolean bool1 = PingUtils.hasExperimentSerial(this.mPingProvider.get(), "amex_rewards", i);
    boolean bool2 = paramClient.isLastSelectedPaymentProfileGoogleWallet();
    PaymentProfile localPaymentProfile = paramClient.findLastSelectedPaymentProfile();
    if ((!bool2) && (localPaymentProfile != null) && (bool1))
    {
      RewardInfo localRewardInfo = localPaymentProfile.getRewardInfo();
      if ((localRewardInfo != null) && (localRewardInfo.isEligible()) && (localRewardInfo.isEnrolled()))
      {
        ExtraPaymentData localExtraPaymentData = localTripPendingRating.getExtraPaymentData();
        if ((localExtraPaymentData != null) && (localExtraPaymentData.useRewards()))
          break label138;
        if ((!localRewardInfo.isEarnOnly()) && (i == 0))
          break label143;
        this.mTextViewRewardsHeading.setText(getString(2131558822).toUpperCase());
      }
    }
    while (true)
    {
      this.mViewGroupRewards.setVisibility(0);
      return;
      label138: i = 0;
      break;
      label143: this.mTextViewRewardsHeading.setText(getString(2131559006).toUpperCase());
      this.mTextViewRewardsDetails.setText(getString(2131559021));
      this.mTextViewRewardsDetails.setVisibility(0);
    }
  }

  private void updateUI(TripPendingRating paramTripPendingRating)
  {
    Long localLong = paramTripPendingRating.getDropOffEpoch();
    if (localLong != null)
      this.mActionBar.setSubtitle(FORMAT.format(localLong));
    TripPendingRatingDriver localTripPendingRatingDriver = paramTripPendingRating.getDriver();
    if (localTripPendingRatingDriver != null)
    {
      this.mTextViewDriverName.setText(localTripPendingRatingDriver.getName());
      this.mPicasso.load(localTripPendingRatingDriver.getPictureUrl()).into(this.mImageViewDriverPhoto);
      VehicleView localVehicleView = paramTripPendingRating.getVehicleView();
      if (localVehicleView == null)
        break label198;
      Uri localUri = localVehicleView.getMonoImageResourceUri(getActivity());
      if (localUri == null)
        localUri = localVehicleView.getMonoImagePublicUri();
      this.mPicasso.load(localUri).into(this.mImageViewVehicle);
      this.mImageViewVehicle.setContentDescription(localVehicleView.getDescription());
    }
    while (true)
    {
      this.mTextViewFare.setText(paramTripPendingRating.getFareBilledToCardString());
      int i = this.mSpinnerFeedback.getSelectedItemPosition();
      FeedbackAdapter localFeedbackAdapter = new FeedbackAdapter(getActivity(), paramTripPendingRating.getFeedbackTypes());
      this.mSpinnerFeedback.setAdapter(localFeedbackAdapter);
      this.mSpinnerFeedback.setSelection(i);
      return;
      this.mTextViewDriverName.setText(null);
      this.mImageViewDriverPhoto.setImageDrawable(null);
      break;
      label198: this.mImageViewVehicle.setImageDrawable(null);
      this.mImageViewVehicle.setContentDescription(null);
    }
  }

  @OnClick({2131427687})
  public void onClickSubmit()
  {
    if (!PingUtils.hasTripPendingRating(this.mPingProvider.get()))
      return;
    showLoadingDialogSticky(getString(2131559088), null);
    int i = this.mRatingBar.getProgress();
    String str1 = this.mPingProvider.get().getClient().getTripPendingRating().getId();
    String str2 = this.mEditTextComment.getText().toString();
    if (i < 4);
    for (int j = ((FeedbackType)this.mSpinnerFeedback.getSelectedItem()).getId(); ; j = 0)
    {
      this.mRiderClient.rateDriver(str1, i, j, str2);
      this.mSessionPreferences.setLastRatedTripId(str1);
      this.mAnalyticsManager.rateDriverEvent().submit(i, str1);
      this.mBus.post(new ReceiptRateEvent(str1));
      return;
    }
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(2130903162, paramViewGroup, false);
    ButterKnife.inject(this, localView);
    return localView;
  }

  public void onDestroyView()
  {
    super.onDestroyView();
    ButterKnife.reset(this);
  }

  @Subscribe
  public void onPingEvent(PingEvent paramPingEvent)
  {
    Ping localPing = paramPingEvent.getPing();
    if (this.mFakeTripPendingRating != null)
      updateUI(this.mFakeTripPendingRating);
    while (!PingUtils.hasTripPendingRating(localPing))
      return;
    updateUI(localPing.getClient());
  }

  public void onRatingChanged(RatingBar paramRatingBar, float paramFloat, boolean paramBoolean)
  {
    UberButton localUberButton = this.mButtonSubmit;
    if (paramFloat > 0.0F);
    for (boolean bool = true; ; bool = false)
    {
      localUberButton.setEnabled(bool);
      if ((paramFloat <= 0.0F) || (paramFloat >= 4.0F))
        break;
      this.mSpinnerFeedback.setVisibility(0);
      this.mEditTextComment.setHint(getString(2131558978));
      this.mEditTextComment.requestFocus();
      return;
    }
    this.mSpinnerFeedback.setVisibility(8);
    this.mEditTextComment.setHint(getString(2131558905));
  }

  @Subscribe
  public void onRatingDriverResponseEvent(RatingDriverResponseEvent paramRatingDriverResponseEvent)
  {
    hideLoadingDialog();
  }

  public void onResume()
  {
    super.onResume();
    this.mActionBar.setTitle(getString(2131559352));
  }

  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.mRatingBar.setOnRatingBarChangeListener(this);
    this.mButtonSubmit.setText(getString(2131559087));
    this.mTextViewHeaderRate.setText(getString(2131559019));
    this.mEditTextComment.setHint(getString(2131558905));
    Ping localPing = this.mPingProvider.get();
    if (PingUtils.hasTripPendingRating(localPing))
      this.mAnalyticsManager.rateDriverEvent().view(localPing.getClient().getTripPendingRating().getId());
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.receipt.ReceiptFragment
 * JD-Core Version:    0.6.2
 */