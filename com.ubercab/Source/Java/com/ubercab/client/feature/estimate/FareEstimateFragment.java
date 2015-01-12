package com.ubercab.client.feature.estimate;

import android.app.ActionBar;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;
import com.ubercab.client.core.app.RiderFragment;
import com.ubercab.client.core.content.SessionPreferences;
import com.ubercab.client.core.location.RiderLocation;
import com.ubercab.client.core.model.City;
import com.ubercab.client.core.model.Client;
import com.ubercab.client.core.model.CnLocation;
import com.ubercab.client.core.model.FareEstimateRange;
import com.ubercab.client.core.model.Itinerary;
import com.ubercab.client.core.model.Ping;
import com.ubercab.client.core.model.VehicleView;
import com.ubercab.client.core.network.RiderClient;
import com.ubercab.client.core.network.events.SetDestinationResponseEvent;
import com.ubercab.client.core.util.PingUtils;
import com.ubercab.client.feature.estimate.event.DestinationSelectEvent;
import com.ubercab.client.feature.estimate.event.PickupSelectEvent;
import com.ubercab.client.feature.trip.LegacyFareEstimateManager;
import com.ubercab.ui.UberTextView;
import javax.inject.Inject;

public class FareEstimateFragment extends RiderFragment
  implements FareEstimateMultiAddressView.Listener
{
  private static final String ARG_CURRENCY_TO_REWARDS_RATIO = "currency_to_rewards_ratio";
  private static final String ARG_FARE_ID = "fare_id";
  private static final String ARG_LOCATION_DESTINATION = "destination_location";
  private static final String ARG_LOCATION_PICKUP = "pickup_location";

  @Inject
  ActionBar mActionBar;

  @Inject
  Bus mBus;
  private float mCurrencyToRewardsRatio;
  private RiderLocation mDestinationLocation;
  private long mFareId;

  @InjectView(2131427435)
  FareEstimateMultiAddressView mMultiAddressView;
  private RiderLocation mPickupLocation;

  @Inject
  RiderClient mRiderClient;

  @Inject
  SessionPreferences mSessionPreferences;

  @InjectView(2131427439)
  UberTextView mTextViewFare;

  @InjectView(2131427440)
  UberTextView mTextViewFarePoints;

  @InjectView(2131427441)
  UberTextView mTextViewFarePointsExplanation;

  @InjectView(2131427442)
  UberTextView mTextViewMessage;

  @InjectView(2131427928)
  UberTextView mTextViewSectionHeaderSurge;

  @InjectView(2131427437)
  UberTextView mTextViewVehicle;

  @InjectView(2131427436)
  LinearLayout mViewGroupResults;

  @InjectView(2131427438)
  LinearLayout mViewGroupSurge;

  public static FareEstimateFragment newInstance(RiderLocation paramRiderLocation1, RiderLocation paramRiderLocation2, long paramLong, Float paramFloat)
  {
    Bundle localBundle = new Bundle();
    localBundle.putLong("fare_id", paramLong);
    localBundle.putParcelable("pickup_location", paramRiderLocation1);
    localBundle.putParcelable("destination_location", paramRiderLocation2);
    localBundle.putFloat("currency_to_rewards_ratio", paramFloat.floatValue());
    FareEstimateFragment localFareEstimateFragment = new FareEstimateFragment();
    localFareEstimateFragment.setArguments(localBundle);
    return localFareEstimateFragment;
  }

  private void sendSetDestinationRequest()
  {
    showLoadingDialogSticky(getString(2131558846), null);
    int i = Integer.valueOf(this.mSessionPreferences.getSelectedVehicleViewId()).intValue();
    CnLocation localCnLocation1 = this.mPickupLocation.getCnLocation();
    CnLocation localCnLocation2 = this.mDestinationLocation.getCnLocation();
    this.mRiderClient.setDestination(i, this.mFareId, localCnLocation1, localCnLocation2);
  }

  private void showError()
  {
    this.mTextViewFare.setVisibility(8);
    this.mTextViewVehicle.setVisibility(8);
    this.mViewGroupSurge.setVisibility(8);
    this.mTextViewMessage.setVisibility(0);
    this.mViewGroupResults.setVisibility(0);
    this.mTextViewMessage.setText(getString(2131558853));
  }

  public void onClickDestinationAddress()
  {
    this.mBus.post(new DestinationSelectEvent());
  }

  public void onClickPickupAddress()
  {
    this.mBus.post(new PickupSelectEvent());
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (paramBundle == null)
    {
      Bundle localBundle = getArguments();
      this.mCurrencyToRewardsRatio = localBundle.getFloat("currency_to_rewards_ratio", 0.0F);
      this.mFareId = localBundle.getLong("fare_id", 0L);
      this.mPickupLocation = ((RiderLocation)localBundle.getParcelable("pickup_location"));
      this.mDestinationLocation = ((RiderLocation)localBundle.getParcelable("destination_location"));
      return;
    }
    this.mCurrencyToRewardsRatio = paramBundle.getFloat("currency_to_rewards_ratio", 0.0F);
    this.mFareId = paramBundle.getLong("fare_id");
    this.mPickupLocation = ((RiderLocation)paramBundle.getParcelable("pickup_location"));
    this.mDestinationLocation = ((RiderLocation)paramBundle.getParcelable("destination_location"));
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(2130903078, paramViewGroup, false);
    ButterKnife.inject(this, localView);
    return localView;
  }

  public void onDestroy()
  {
    super.onDestroy();
    this.mMultiAddressView.removeListener(this);
    ButterKnife.reset(this);
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putFloat("currency_to_rewards_ratio", this.mCurrencyToRewardsRatio);
    paramBundle.putLong("fare_id", this.mFareId);
    paramBundle.putParcelable("pickup_location", this.mPickupLocation);
    paramBundle.putParcelable("destination_location", this.mDestinationLocation);
  }

  @Subscribe
  public void onSetDestinationResponseEvent(SetDestinationResponseEvent paramSetDestinationResponseEvent)
  {
    hideLoadingDialog();
    Ping localPing = (Ping)paramSetDestinationResponseEvent.getModel();
    if ((!paramSetDestinationResponseEvent.isSuccess()) || (!PingUtils.hasLastEstimatedTrip(localPing)) || (!PingUtils.hasCity(localPing)))
      showError();
    String str1;
    do
    {
      return;
      Itinerary localItinerary = localPing.getClient().getLastEstimatedTrip();
      if (TextUtils.isEmpty(localItinerary.getFareEstimateString()))
      {
        showError();
        return;
      }
      this.mTextViewFare.setVisibility(0);
      this.mTextViewFare.setText(localItinerary.getFareEstimateString());
      FareEstimateRange localFareEstimateRange = localItinerary.getFareEstimateRange();
      if ((localFareEstimateRange != null) && (this.mCurrencyToRewardsRatio != 0.0F))
      {
        String str2 = LegacyFareEstimateManager.getFareEstimatePointsRange(localFareEstimateRange, Float.valueOf(this.mCurrencyToRewardsRatio));
        this.mTextViewFarePoints.setText(getString(2131558856, new Object[] { str2 }));
        this.mTextViewFarePoints.setVisibility(0);
        this.mTextViewFarePointsExplanation.setText(getString(2131558857));
        this.mTextViewFarePointsExplanation.setVisibility(0);
      }
      this.mViewGroupResults.setVisibility(0);
      this.mTextViewMessage.setVisibility(0);
      this.mTextViewMessage.setText(getString(2131558854));
      str1 = this.mSessionPreferences.getSelectedVehicleViewId();
    }
    while (!PingUtils.hasVehicleView(localPing, str1));
    VehicleView localVehicleView = localPing.getCity().findVehicleView(str1);
    this.mTextViewVehicle.setText(localVehicleView.getDescription());
    this.mTextViewVehicle.setVisibility(0);
    if (PingUtils.isSurging(localPing, str1))
    {
      this.mViewGroupSurge.setVisibility(0);
      this.mTextViewSectionHeaderSurge.setText(getString(2131559096));
      this.mTextViewSectionHeaderSurge.setCompoundDrawablesWithIntrinsicBounds(2130837790, 0, 0, 0);
      return;
    }
    this.mViewGroupSurge.setVisibility(8);
  }

  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.mActionBar.setTitle(getString(2131558852));
    this.mMultiAddressView.setPickupLabel(getString(2131559002));
    this.mMultiAddressView.setPickupHintText(getString(2131558883));
    this.mMultiAddressView.setDestinationLabel(getString(2131559051));
    this.mMultiAddressView.addListener(this);
    this.mMultiAddressView.update(this.mPickupLocation, this.mDestinationLocation);
    sendSetDestinationRequest();
  }

  void update(RiderLocation paramRiderLocation1, RiderLocation paramRiderLocation2)
  {
    if ((this.mPickupLocation.equals(paramRiderLocation1)) && (this.mDestinationLocation.equals(paramRiderLocation2)))
      return;
    this.mMultiAddressView.update(paramRiderLocation1, paramRiderLocation2);
    this.mPickupLocation = paramRiderLocation1;
    this.mDestinationLocation = paramRiderLocation2;
    sendSetDestinationRequest();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.estimate.FareEstimateFragment
 * JD-Core Version:    0.6.2
 */