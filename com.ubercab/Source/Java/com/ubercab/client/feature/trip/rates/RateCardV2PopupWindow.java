package com.ubercab.client.feature.trip.rates;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.InjectView;
import butterknife.OnClick;
import com.squareup.otto.Subscribe;
import com.ubercab.client.core.content.event.PingEvent;
import com.ubercab.client.core.location.RiderLocation;
import com.ubercab.client.core.metrics.analytics.RiderEvents.Tap;
import com.ubercab.client.core.model.Fare;
import com.ubercab.client.feature.trip.event.FooterSizeChangedEvent;
import com.ubercab.client.feature.trip.event.MultiFareEstimateEvent;
import com.ubercab.client.feature.trip.event.VehicleViewSelectedEvent;
import com.ubercab.library.metrics.analytics.AnalyticsClient;

public class RateCardV2PopupWindow extends BaseRateCardPopupWindow
{

  @InjectView(2131427828)
  RateCardAddressView mAddressViewDestination;

  @InjectView(2131427836)
  RateCardAddressView mAddressViewFareDestination;

  @InjectView(2131427832)
  ProgressBar mProgressBarFareLoading;

  @InjectView(2131427835)
  TextView mTextViewDividerFor;

  @InjectView(2131427837)
  TextView mTextViewDividerTo;

  @InjectView(2131427830)
  TextView mTextViewFareEstimate;

  @InjectView(2131427831)
  TextView mTextViewFareEstimateError;

  @InjectView(2131427823)
  TextView mTextViewMinFare;

  @InjectView(2131427826)
  ViewGroup mViewGroupAddressContents;

  @InjectView(2131427833)
  ViewGroup mViewGroupDefaultDetails;

  @InjectView(2131427829)
  ViewGroup mViewGroupFareEstimateDetails;

  public RateCardV2PopupWindow(Activity paramActivity, String paramString, RiderLocation paramRiderLocation1, RiderLocation paramRiderLocation2, int paramInt)
  {
    super(paramActivity, paramString, paramRiderLocation1, paramRiderLocation2, paramInt);
  }

  void displayFareEstimateView(String paramString)
  {
    this.mTextViewDividerTo.setVisibility(0);
    this.mTextViewDividerFor.setVisibility(8);
    this.mViewGroupDefaultDetails.setVisibility(8);
    this.mViewGroupFareEstimateDetails.setVisibility(0);
    super.displayFareEstimateView(paramString);
  }

  View getView(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2130903204, null, false);
  }

  protected void hideAddressView()
  {
    this.mViewGroupAddressContents.setVisibility(8);
  }

  void hideFareEstimateView()
  {
    this.mTextViewDividerTo.setVisibility(8);
    this.mTextViewDividerFor.setVisibility(0);
    this.mViewGroupDefaultDetails.setVisibility(0);
    this.mViewGroupFareEstimateDetails.setVisibility(8);
  }

  void initView()
  {
    super.initView();
    this.mAddressViewFareDestination.setBackgroundResource(2130837731);
    String str = this.mResources.getString(2131558805);
    this.mAddressViewFareDestination.setDefaultHintText(str);
    this.mAddressViewDestination.setDefaultHintText(str);
  }

  @OnClick({2131427828})
  public void onDestinationClick()
  {
    this.mAnalyticsClient.sendTapEvent(RiderEvents.Tap.SEARCH_DROPOFF_OPEN_PRODUCTDETAIL);
    triggerDestinationSelection();
  }

  @OnClick({2131427834})
  public void onFareEstimateClick()
  {
    this.mAnalyticsClient.sendTapEvent(RiderEvents.Tap.SEARCH_DROPOFF_OPEN_PRODUCTDETAIL_BUTTON);
    triggerDestinationSelection();
  }

  @OnClick({2131427836})
  public void onFareEstimateDestinationClick()
  {
    this.mAnalyticsClient.sendTapEvent(RiderEvents.Tap.SEARCH_DROPOFF_OPEN_PRODUCTDETAIL);
    triggerDestinationSelection();
  }

  @Subscribe
  public void onFooterSizeChangedEvent(FooterSizeChangedEvent paramFooterSizeChangedEvent)
  {
    super.onFooterSizeChangedEvent(paramFooterSizeChangedEvent);
  }

  @Subscribe
  public void onMultiFareEstimateEvent(MultiFareEstimateEvent paramMultiFareEstimateEvent)
  {
    super.onMultiFareEstimateEvent(paramMultiFareEstimateEvent);
  }

  @Subscribe
  public void onPingEvent(PingEvent paramPingEvent)
  {
    super.onPingEvent(paramPingEvent);
  }

  @Subscribe
  public void onVehicleViewEvent(VehicleViewSelectedEvent paramVehicleViewSelectedEvent)
  {
    super.onVehicleViewEvent(paramVehicleViewSelectedEvent);
  }

  protected void showAddressView()
  {
    this.mViewGroupAddressContents.setVisibility(0);
  }

  void showFareEstimateFailureState()
  {
    this.mProgressBarFareLoading.setVisibility(4);
    this.mTextViewFareEstimate.setVisibility(4);
    this.mTextViewFareEstimateError.setVisibility(0);
  }

  void showFareEstimatePendingState()
  {
    this.mProgressBarFareLoading.setVisibility(0);
    this.mTextViewFareEstimate.setVisibility(4);
    this.mTextViewFareEstimateError.setVisibility(4);
  }

  void showFareEstimateSuccessState(String paramString)
  {
    this.mTextViewFareEstimate.setText(paramString);
    this.mTextViewFareEstimateError.setVisibility(4);
    this.mTextViewFareEstimate.setVisibility(0);
    this.mProgressBarFareLoading.setVisibility(4);
  }

  void updateFareInfo(Fare paramFare, float paramFloat, String paramString1, String paramString2)
  {
    this.mTextViewMinFare.setText(paramFare.getMinimum());
    this.mAddressViewDestination.setLocation(this.mDestination);
    this.mAddressViewFareDestination.setLocation(this.mDestination);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.trip.rates.RateCardV2PopupWindow
 * JD-Core Version:    0.6.2
 */