package com.ubercab.client.core.analytics.event;

import com.ubercab.client.core.model.City;
import com.ubercab.client.core.model.LocationSearchResult;
import com.ubercab.client.core.model.Ping;
import com.ubercab.client.core.model.Surge;
import com.ubercab.client.core.model.VehicleView;
import com.ubercab.client.feature.trip.TripAnalyticsUtils;
import java.util.List;

@Deprecated
public final class TripEvent extends AnalyticsEvent
{
  private static final String CONTEXT_DROPOFF = "dropoff";
  private static final String CONTEXT_PICKUP = "pickup";
  private static final String EVENT_CONFIRM_PICKUP_CANCEL = "ConfirmPickupCancel";
  private static final String EVENT_DESTINATION_OVERLAY_VIEW = "DestinationOverlayView";
  private static final String EVENT_FARE_ESTIMATE_OPEN = "FareEstimateOpen";
  private static final String EVENT_LOCATION_OPEN = "LocationOpen";
  private static final String EVENT_LOCATION_REMOVE = "LocationRemove";
  private static final String EVENT_LOCATION_SELECT = "LocationSelect";
  private static final String EVENT_RATE_CARD_VIEW = "RateCardView";
  private static final String EVENT_SET_PICKUP = "SetPickup";
  private static final String REASON_RATE_CARD_OFF = "OFF";
  private static final String REASON_RATE_CARD_ON = "ON";
  private String mAppContext;
  private int mTripUIState;

  public TripEvent(AnalyticsEvent.Listener paramListener)
  {
    super(paramListener);
  }

  private void sendLocationSelectEvent(String paramString, LocationSearchResult paramLocationSearchResult, List<LocationSearchResult> paramList)
  {
    String str1 = paramLocationSearchResult.getServiceType();
    int i = TripAnalyticsUtils.indexInLocationResultList(paramList, paramLocationSearchResult);
    int j = TripAnalyticsUtils.indexInLocationResultSublist(paramList, paramLocationSearchResult);
    String str2 = AnalyticsUtils.convertTripUIStateToParameter(this.mTripUIState);
    sendEvent(new EventBuilder().setEventName("LocationSelect").putParameter("addressLatitude", paramLocationSearchResult.getLatitude()).putParameter("addressLongitude", paramLocationSearchResult.getLongitude()).putParameter("addressSubtitle", paramLocationSearchResult.getSubtitle()).putParameter("addressTitle", paramLocationSearchResult.getTitle()).putParameter("method", str1).putParameter("module", Integer.valueOf(j)).putParameter("page", paramString).putParameter("reason", this.mAppContext).putParameter("sourceApplication", str2).putParameter("statusCode", Integer.valueOf(i)).build());
  }

  public void confirmPickupCancel(Ping paramPing, String paramString, long paramLong)
  {
    VehicleView localVehicleView = paramPing.getCity().findVehicleView(paramString);
    if (localVehicleView != null);
    for (float f = localVehicleView.getSurge().getMultiplier(); ; f = 0.0F)
    {
      sendEvent(new EventBuilder().setEventName("ConfirmPickupCancel").putParameter("fareId", Long.valueOf(paramLong)).putParameter("multiplier", Float.valueOf(f)).putParameter("vehicleViewId", paramString).build());
      return;
    }
  }

  public void destinationOverlayView()
  {
    sendEvent(new EventBuilder().setEventName("DestinationOverlayView").build());
  }

  public void fareEstimateOpen()
  {
    sendEvent(new EventBuilder().setEventName("FareEstimateOpen").build());
  }

  public void locationOpenDropoff()
  {
    String str = AnalyticsUtils.convertTripUIStateToParameter(this.mTripUIState);
    sendEvent(new EventBuilder().setEventName("LocationOpen").putParameter("page", "dropoff").putParameter("reason", this.mAppContext).putParameter("sourceApplication", str).build());
  }

  public void locationOpenPickup()
  {
    String str = AnalyticsUtils.convertTripUIStateToParameter(this.mTripUIState);
    sendEvent(new EventBuilder().setEventName("LocationOpen").putParameter("page", "pickup").putParameter("reason", this.mAppContext).putParameter("sourceApplication", str).build());
  }

  public void locationRemoveDropoff()
  {
    String str = AnalyticsUtils.convertTripUIStateToParameter(this.mTripUIState);
    sendEvent(new EventBuilder().setEventName("LocationRemove").putParameter("page", "dropoff").putParameter("reason", this.mAppContext).putParameter("sourceApplication", str).build());
  }

  public void locationSelectDropoff(LocationSearchResult paramLocationSearchResult, List<LocationSearchResult> paramList)
  {
    sendLocationSelectEvent("dropoff", paramLocationSearchResult, paramList);
  }

  public void locationSelectPickup(LocationSearchResult paramLocationSearchResult, List<LocationSearchResult> paramList)
  {
    sendLocationSelectEvent("pickup", paramLocationSearchResult, paramList);
  }

  public void rateCardViewOff(String paramString)
  {
    sendEvent(new EventBuilder().setEventName("RateCardView").putParameter("reason", "OFF").putParameter("vehicleViewId", paramString).build());
  }

  public void rateCardViewOn(String paramString)
  {
    sendEvent(new EventBuilder().setEventName("RateCardView").putParameter("reason", "ON").putParameter("vehicleViewId", paramString).build());
  }

  public void setAppContext(String paramString)
  {
    this.mAppContext = paramString;
  }

  public void setPickup(String paramString, long paramLong, float paramFloat)
  {
    sendEvent(new EventBuilder().setEventName("SetPickup").putParameter("fareId", Long.valueOf(paramLong)).putParameter("multiplier", Float.valueOf(paramFloat)).putParameter("vehicleViewId", paramString).build());
  }

  public void setTripUIState(int paramInt)
  {
    this.mTripUIState = paramInt;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.analytics.event.TripEvent
 * JD-Core Version:    0.6.2
 */