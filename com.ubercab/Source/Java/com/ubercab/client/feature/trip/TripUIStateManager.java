package com.ubercab.client.feature.trip;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.squareup.otto.Bus;
import com.squareup.otto.Produce;
import com.squareup.otto.Subscribe;
import com.ubercab.client.core.analytics.AnalyticsManager;
import com.ubercab.client.core.analytics.event.NearestCabEvent;
import com.ubercab.client.core.analytics.event.PageEvent;
import com.ubercab.client.core.content.PingProvider;
import com.ubercab.client.core.content.SessionPreferences;
import com.ubercab.client.core.content.event.PingEvent;
import com.ubercab.client.core.location.RiderLocation;
import com.ubercab.client.core.metrics.analytics.RiderEvents.Impression;
import com.ubercab.client.core.model.AppConfig;
import com.ubercab.client.core.model.City;
import com.ubercab.client.core.model.Client;
import com.ubercab.client.core.model.CnLocation;
import com.ubercab.client.core.model.LocationSearchResult;
import com.ubercab.client.core.model.Ping;
import com.ubercab.client.core.model.RiderAppConfig;
import com.ubercab.client.core.model.Trip;
import com.ubercab.client.core.model.TripDriver;
import com.ubercab.client.core.model.VehicleView;
import com.ubercab.client.core.model.event.NoPingEvent;
import com.ubercab.client.core.network.LocationClient;
import com.ubercab.client.core.network.events.LocationDetailResponseEvent;
import com.ubercab.client.core.network.events.SetDestinationResponseEvent;
import com.ubercab.client.core.util.PingUtils;
import com.ubercab.client.feature.trip.event.DestinationChangedEvent;
import com.ubercab.client.feature.trip.event.TripUIStateChangedEvent;
import com.ubercab.client.feature.trip.event.VehicleViewSelectedEvent;
import com.ubercab.common.base.Objects;
import com.ubercab.library.metrics.analytics.AnalyticsClient;
import com.ubercab.library.metrics.analytics.AnalyticsEvent.Builder;
import java.util.Locale;

public class TripUIStateManager
{
  private static final String BUNDLE_IS_CONFIRMING = "com.ubercab.IS_CONFIRMING";
  private static final String BUNDLE_LOCATION_DESTINATION_PRE_TRIP = "com.ubercab.LOCATION_DESTINATION_PRE_TRIP";
  private static final String BUNDLE_PICKUP_REQUEST_PENDING = "com.ubercab.PICKUP_REQUEST_PENDING";
  private static final String BUNDLE_RATE_CARD_ESTIMATE_REQUESTED = "com.ubercab.RATE_CARD_ESTIMATE_REQUESTED";
  public static final int STATE_ACCEPTED = 3;
  public static final int STATE_ARRIVING_NOW = 4;
  public static final int STATE_CONFIRMING = 1;
  public static final int STATE_DISPATCHING = 2;
  public static final int STATE_LOOKING = 0;
  public static final int STATE_ON_TRIP = 5;
  public static final int STATE_UNDEF = -1;
  private final AnalyticsClient mAnalyticsClient;
  private final AnalyticsManager mAnalyticsManager;
  private final Bus mBus;
  private final Context mContext;
  private boolean mIsConfirming;
  private boolean mIsRateCardFareEstimateRequested;
  private boolean mIsShowingFareDetails;
  private final LocationClient mLocationClient;
  private RiderLocation mPendingTripDestination;
  private boolean mPickupRequestPending;
  private final PingProvider mPingProvider;
  private RiderLocation mPreTripDestination;
  private final SessionPreferences mSessionPreferences;
  private int mState = -1;
  private RiderLocation mTripDestination;

  public TripUIStateManager(AnalyticsClient paramAnalyticsClient, AnalyticsManager paramAnalyticsManager, Bus paramBus, Context paramContext, LocationClient paramLocationClient, PingProvider paramPingProvider, SessionPreferences paramSessionPreferences)
  {
    this.mAnalyticsClient = paramAnalyticsClient;
    this.mAnalyticsManager = paramAnalyticsManager;
    this.mBus = paramBus;
    this.mContext = paramContext;
    this.mLocationClient = paramLocationClient;
    this.mPingProvider = paramPingProvider;
    this.mSessionPreferences = paramSessionPreferences;
  }

  private int getStateForPing(Ping paramPing)
  {
    if (!PingUtils.hasClient(paramPing))
      return -1;
    String str = paramPing.getClient().getStatus();
    if (this.mPickupRequestPending)
      str = "Dispatching";
    label72: int i;
    switch (str.hashCode())
    {
    default:
      i = -1;
    case 2014441667:
    case -1561136888:
    case -1978426120:
    case -1929061692:
    }
    while (true)
      switch (i)
      {
      default:
        return -1;
      case 0:
        if (!this.mIsConfirming)
          break label171;
        return 1;
        if (!str.equals("Looking"))
          break label72;
        i = 0;
        continue;
        if (!str.equals("Dispatching"))
          break label72;
        i = 1;
        continue;
        if (!str.equals("WaitingForPickup"))
          break label72;
        i = 2;
        continue;
        if (!str.equals("OnTrip"))
          break label72;
        i = 3;
      case 1:
      case 2:
      case 3:
      }
    label171: return 0;
    return 2;
    if (paramPing.getTrip().getDriver().getStatus().equals("Arrived"))
      return 4;
    return 3;
    return 5;
  }

  public static boolean isLooking(int paramInt)
  {
    return paramInt == 0;
  }

  public static boolean isOnTrip(int paramInt)
  {
    return (paramInt == 2) || (paramInt == 3) || (paramInt == 4) || (paramInt == 5);
  }

  private void updateState()
  {
    int i = this.mState;
    this.mState = getStateForPing(this.mPingProvider.get());
    if (i != this.mState)
      this.mBus.post(produceTripUIStateChangedEvent());
  }

  void clearDestination()
  {
    this.mTripDestination = null;
    this.mPreTripDestination = null;
    this.mPendingTripDestination = null;
    this.mBus.post(produceDestinationChangedEvent());
  }

  public RiderLocation getDestination()
  {
    if (!PingUtils.hasTrip(this.mPingProvider.get()))
      return this.mPreTripDestination;
    if (this.mPendingTripDestination != null)
      return this.mPendingTripDestination;
    return this.mTripDestination;
  }

  public String getSelectedVehicleViewId()
  {
    return this.mSessionPreferences.getSelectedVehicleViewId();
  }

  public int getState()
  {
    return this.mState;
  }

  public boolean hasDestination()
  {
    return getDestination() != null;
  }

  public boolean isDestinationHighlightEnabledOnDispatch()
  {
    return PingUtils.hasExperimentSerial(this.mPingProvider.get(), "destination_not_set_highlight", 1);
  }

  public boolean isRateCardFareEstimateRequested()
  {
    return this.mIsRateCardFareEstimateRequested;
  }

  public boolean isShowingFareDetails()
  {
    return this.mIsShowingFareDetails;
  }

  @Subscribe
  public void onLocationDetailResponseEvent(LocationDetailResponseEvent paramLocationDetailResponseEvent)
  {
    if ((this.mTripDestination == null) || (!Objects.equal(paramLocationDetailResponseEvent.getRequestReference(), this.mTripDestination.getReference())))
      return;
    if (!paramLocationDetailResponseEvent.isSuccess())
    {
      this.mTripDestination.setTitle(this.mContext.getString(2131558803));
      return;
    }
    this.mTripDestination.update((LocationSearchResult)paramLocationDetailResponseEvent.getModel());
    this.mBus.post(produceDestinationChangedEvent());
  }

  @Subscribe
  public void onNoPingEvent(NoPingEvent paramNoPingEvent)
  {
    updateState();
  }

  @Subscribe
  public void onPingEvent(PingEvent paramPingEvent)
  {
    Ping localPing = paramPingEvent.getPing();
    this.mPickupRequestPending = false;
    if (!PingUtils.isClientStatusLooking(localPing))
      this.mIsConfirming = false;
    if (!PingUtils.hasVehicleView(localPing, this.mSessionPreferences.getSelectedVehicleViewId()))
    {
      this.mSessionPreferences.setSelectedVehicleViewId(localPing.getCity().getDefaultVehicleViewId());
      this.mBus.post(produceVehicleViewSelectedEvent());
      if (this.mIsConfirming)
        this.mIsConfirming = false;
    }
    this.mAnalyticsManager.nearestCabEvent().trackVehicleViewId(this.mSessionPreferences.getSelectedVehicleViewId());
    if (!PingUtils.hasTrip(localPing))
    {
      this.mTripDestination = null;
      updateState();
      return;
    }
    RiderLocation localRiderLocation1 = getDestination();
    this.mPreTripDestination = null;
    RiderLocation localRiderLocation2;
    int i;
    label183: int j;
    if (PingUtils.hasTripDestination(localPing))
    {
      CnLocation localCnLocation = localPing.getTrip().getDestination();
      localRiderLocation2 = RiderLocation.create(localCnLocation);
      if (!localRiderLocation2.equals(this.mTripDestination))
      {
        if ((TextUtils.isEmpty(localCnLocation.getLanguage())) || (Locale.getDefault().getLanguage().equalsIgnoreCase(localCnLocation.getLanguage())))
          break label326;
        i = 1;
        if ((TextUtils.isEmpty(localCnLocation.getReference())) || (TextUtils.isEmpty(localCnLocation.getReferenceType())))
          break label332;
        j = 1;
        label208: if ((i == 0) || (j == 0))
          break label338;
        if ((this.mTripDestination == null) || (!Objects.equal(this.mTripDestination.getReference(), localCnLocation.getReference())))
        {
          RiderLocation localRiderLocation3 = RiderLocation.create(localCnLocation.getUberLatLng());
          localRiderLocation3.setReference(localCnLocation.getReference(), localCnLocation.getReferenceType());
          localRiderLocation3.setTitle(null);
          this.mTripDestination = localRiderLocation3;
          this.mLocationClient.details(localCnLocation.getReference(), localCnLocation.getReferenceType());
        }
      }
    }
    while (true)
    {
      updateState();
      if (Objects.equal(localRiderLocation1, getDestination()))
        break;
      this.mBus.post(produceDestinationChangedEvent());
      return;
      label326: i = 0;
      break label183;
      label332: j = 0;
      break label208;
      label338: this.mTripDestination = localRiderLocation2;
      continue;
      this.mTripDestination = null;
    }
  }

  @Subscribe
  public void onSetDestinationResponseEvent(SetDestinationResponseEvent paramSetDestinationResponseEvent)
  {
    this.mPendingTripDestination = null;
    this.mBus.post(produceDestinationChangedEvent());
  }

  @Produce
  public DestinationChangedEvent produceDestinationChangedEvent()
  {
    return new DestinationChangedEvent(getDestination());
  }

  @Produce
  public TripUIStateChangedEvent produceTripUIStateChangedEvent()
  {
    return new TripUIStateChangedEvent(this.mState);
  }

  @Produce
  public VehicleViewSelectedEvent produceVehicleViewSelectedEvent()
  {
    String str = this.mSessionPreferences.getSelectedVehicleViewId();
    if (str != null)
      return new VehicleViewSelectedEvent(str);
    return null;
  }

  public void restoreInstanceState(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      this.mIsConfirming = paramBundle.getBoolean("com.ubercab.IS_CONFIRMING", false);
      this.mIsRateCardFareEstimateRequested = paramBundle.getBoolean("com.ubercab.RATE_CARD_ESTIMATE_REQUESTED", false);
      this.mPickupRequestPending = paramBundle.getBoolean("com.ubercab.PICKUP_REQUEST_PENDING", false);
      this.mPreTripDestination = ((RiderLocation)paramBundle.getParcelable("com.ubercab.LOCATION_DESTINATION_PRE_TRIP"));
    }
  }

  public void saveInstanceState(Bundle paramBundle)
  {
    paramBundle.putBoolean("com.ubercab.IS_CONFIRMING", this.mIsConfirming);
    paramBundle.putBoolean("com.ubercab.PICKUP_REQUEST_PENDING", this.mPickupRequestPending);
    paramBundle.putBoolean("com.ubercab.RATE_CARD_ESTIMATE_REQUESTED", this.mIsRateCardFareEstimateRequested);
    paramBundle.putParcelable("com.ubercab.LOCATION_DESTINATION_PRE_TRIP", this.mPreTripDestination);
  }

  public void setIsConfirming(boolean paramBoolean)
  {
    VehicleView localVehicleView = this.mPingProvider.get().getCity().findVehicleView(getSelectedVehicleViewId());
    if ((paramBoolean) && (localVehicleView == null))
      return;
    if ((!this.mIsConfirming) && (paramBoolean))
      this.mAnalyticsManager.pageEvent().confirmPageView();
    this.mIsConfirming = paramBoolean;
    updateState();
  }

  void setPendingTripDestination(RiderLocation paramRiderLocation)
  {
    this.mPendingTripDestination = paramRiderLocation;
    this.mBus.post(produceDestinationChangedEvent());
  }

  public void setPickupRequestPending(boolean paramBoolean)
  {
    this.mPickupRequestPending = paramBoolean;
    updateState();
  }

  void setPreTripDestination(RiderLocation paramRiderLocation)
  {
    this.mPreTripDestination = paramRiderLocation;
    this.mBus.post(produceDestinationChangedEvent());
  }

  public void setRateCardFareEstimateRequested(boolean paramBoolean)
  {
    this.mIsRateCardFareEstimateRequested = paramBoolean;
  }

  public void setSelectedVehicleViewId(String paramString)
  {
    this.mAnalyticsManager.nearestCabEvent().trackVehicleViewId(paramString);
    if (this.mAnalyticsManager.isProductDetailShowing());
    for (String str = "product_detail_shown"; ; str = "product_detail_hidden")
    {
      this.mAnalyticsClient.addEvent(new AnalyticsEvent.Builder("impression").setName(RiderEvents.Impression.PRODUCT_LOAD_ON_MAP).setValue(str).build());
      this.mSessionPreferences.setSelectedVehicleViewId(paramString);
      this.mBus.post(produceVehicleViewSelectedEvent());
      this.mBus.post(produceTripUIStateChangedEvent());
      return;
    }
  }

  public void setShowingFareDetails(boolean paramBoolean)
  {
    this.mIsShowingFareDetails = paramBoolean;
  }

  public boolean showNewConfirmation()
  {
    if (this.mState != 1);
    boolean bool2;
    int i;
    do
    {
      return false;
      Ping localPing = this.mPingProvider.get();
      boolean bool1 = PingUtils.hasRiderAppConfig(localPing);
      bool2 = false;
      if (bool1)
        bool2 = localPing.getAppConfig().getRiderConfig().isNewConfirmationEnabledInFareEstimateFlow();
      boolean bool3 = PingUtils.hasVehicleView(localPing, getSelectedVehicleViewId());
      i = 0;
      if (bool3)
      {
        boolean bool4 = "FareEstimateTagline".equals(localPing.getCity().findVehicleView(getSelectedVehicleViewId()).getConfirmationType());
        i = 0;
        if (bool4)
          i = 1;
      }
    }
    while ((i == 0) && ((!isRateCardFareEstimateRequested()) || (!bool2)));
    return true;
  }

  public void start()
  {
    this.mBus.register(this);
  }

  public void stop()
  {
    this.mBus.unregister(this);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.trip.TripUIStateManager
 * JD-Core Version:    0.6.2
 */