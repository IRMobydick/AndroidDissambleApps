package com.ubercab.client.core.analytics.event;

import com.ubercab.client.core.location.RiderLocation;
import com.ubercab.client.core.model.City;
import com.ubercab.client.core.model.CnLocation;
import com.ubercab.client.core.model.NearbyVehicle;
import com.ubercab.client.core.model.Ping;
import com.ubercab.client.core.model.Surge;
import com.ubercab.client.core.model.VehicleView;
import com.ubercab.client.core.util.PingUtils;
import com.ubercab.library.util.TimeUtils;
import java.util.Map;
import java.util.UUID;

@Deprecated
public final class RequestVehicleEvent extends AnalyticsEvent
{
  private static final String EVENT_REQUEST_VEHICLE_REQUEST = "RequestVehicleRequest";
  private static final String EVENT_REQUEST_VEHICLE_RESPONSE = "RequestVehicleResponse";
  private static final String PARAM_DESTINATION_NOT_SET = "destinationNotSet";
  private static final String PARAM_DESTINATION_SET = "destinationSet";
  private static final String PARAM_LOCATION_DEVICE = "device";
  private static final String PARAM_LOCATION_MANUAL = "manual";
  private static final String PARAM_LOCATION_SEARCH = "search";
  private static final String PARAM_LOCATION_SNAPPED = "snapped";
  private long mEpoch;
  private RiderLocation mLocation;
  private String mLocationExtra;
  private boolean mLocationWasSnapped;
  private String mUuid;

  public RequestVehicleEvent(AnalyticsEvent.Listener paramListener)
  {
    super(paramListener);
  }

  public void requestVehicleRequest(Ping paramPing, String paramString, CnLocation paramCnLocation1, CnLocation paramCnLocation2, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.mUuid = UUID.randomUUID().toString();
    this.mEpoch = TimeUtils.getEpochTimeMs();
    boolean bool = PingUtils.hasNearbyVehicle(paramPing, paramString);
    int i = 0;
    if (bool)
      i = ((NearbyVehicle)paramPing.getNearbyVehicles().get(paramString)).getMinEta();
    float f = 1.0F;
    if (PingUtils.hasVehicleView(paramPing, paramString))
    {
      VehicleView localVehicleView = paramPing.getCity().findVehicleView(paramString);
      if (localVehicleView.getSurge() != null)
        f = localVehicleView.getSurge().getMultiplier();
    }
    if (paramCnLocation2 != null);
    for (String str = "destinationSet"; ; str = "destinationNotSet")
    {
      sendEvent(new EventBuilder().setEventName("RequestVehicleRequest").putParameter("destinationLocation", paramCnLocation2).putParameter("duration", Integer.valueOf(i)).putParameter("expenseTrip", Boolean.valueOf(paramBoolean1)).putParameter("method", str).putParameter("multiplier", Float.valueOf(f)).putParameter("page", this.mLocationExtra).putParameter("pickupLocation", paramCnLocation1).putParameter("reason", paramCnLocation1.getType()).putParameter("requestGuid", this.mUuid).putParameter("useCredits", Boolean.valueOf(paramBoolean2)).putParameter("vehicleViewId", paramString).build());
      return;
    }
  }

  public void requestVehicleResponse(int paramInt)
  {
    float f = AnalyticsUtils.calculateLatencyInSeconds(this.mEpoch);
    sendEvent(new EventBuilder().setEventName("RequestVehicleResponse").putParameter("latency", Float.valueOf(f)).putParameter("requestGuid", this.mUuid).putParameter("statusCode", Integer.valueOf(paramInt)).build());
  }

  public void setLocationWasSnapped(boolean paramBoolean)
  {
    this.mLocationWasSnapped = paramBoolean;
  }

  public void updateLocation(RiderLocation paramRiderLocation)
  {
    String str = paramRiderLocation.getType();
    if (this.mLocationWasSnapped)
    {
      this.mLocationExtra = "snapped";
      this.mLocationWasSnapped = false;
    }
    while (true)
    {
      this.mLocation = paramRiderLocation;
      return;
      if ((this.mLocation != null) && ("geocodmanual".equals(str)))
      {
        if (this.mLocation.getType().equals("device"))
          this.mLocationExtra = "device";
        else if (this.mLocation.getType().equals("manual"))
          this.mLocationExtra = "manual";
      }
      else if (("backfill".equals(str)) || ("cache".equals(str)))
        this.mLocationExtra = "search";
      else
        this.mLocationExtra = "";
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.analytics.event.RequestVehicleEvent
 * JD-Core Version:    0.6.2
 */