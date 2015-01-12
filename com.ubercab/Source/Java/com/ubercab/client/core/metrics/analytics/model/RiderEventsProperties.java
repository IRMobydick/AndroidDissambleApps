package com.ubercab.client.core.metrics.analytics.model;

import android.content.Context;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;
import com.ubercab.client.core.content.PingProvider;
import com.ubercab.client.core.content.SessionPreferences;
import com.ubercab.client.core.content.event.PingEvent;
import com.ubercab.client.core.model.City;
import com.ubercab.client.core.model.Client;
import com.ubercab.client.core.model.NearbyVehicle;
import com.ubercab.client.core.model.Ping;
import com.ubercab.client.core.model.Surge;
import com.ubercab.client.core.model.Trip;
import com.ubercab.client.core.model.TripDriver;
import com.ubercab.client.core.model.VehicleView;
import com.ubercab.client.core.util.PingUtils;
import com.ubercab.client.feature.trip.event.VehicleViewSelectedEvent;
import com.ubercab.common.base.Objects;
import com.ubercab.library.metrics.analytics.AnalyticsProperties;
import java.util.Map;

public final class RiderEventsProperties
  implements AnalyticsProperties
{
  private final Gson mGson;
  private final PingProvider mPingProvider;
  private final Rider mRider;
  private final SessionPreferences mSessionPreferences;

  public RiderEventsProperties(Context paramContext, SessionPreferences paramSessionPreferences, Gson paramGson, PingProvider paramPingProvider)
  {
    this.mGson = paramGson;
    this.mSessionPreferences = paramSessionPreferences;
    this.mRider = new Rider(paramContext);
    this.mPingProvider = paramPingProvider;
  }

  protected void extractCurrentProductProperties(Ping paramPing)
  {
    Product localProduct = this.mRider.getCurrentProduct();
    if (localProduct == null)
      return;
    String str = localProduct.getId();
    if (str == null)
    {
      this.mRider.setCurrentProduct(null);
      return;
    }
    if (!PingUtils.hasVehicleView(paramPing, str))
    {
      localProduct.setEta(null);
      localProduct.setSurge(null);
      return;
    }
    localProduct.setSurge(Double.valueOf(paramPing.getCity().findVehicleView(str).getSurge().getMultiplier()));
    if (!PingUtils.hasNearbyVehicle(paramPing, str))
    {
      localProduct.setEta(null);
      return;
    }
    localProduct.setEta(Double.valueOf(((NearbyVehicle)paramPing.getNearbyVehicles().get(str)).getMinEta()));
  }

  public String generateJsonPayload()
  {
    return this.mGson.toJson(this.mRider);
  }

  protected Rider getRider()
  {
    return this.mRider;
  }

  @Subscribe
  public void onPingEvent(PingEvent paramPingEvent)
  {
    Ping localPing = paramPingEvent.getPing();
    String str3;
    int j;
    label87: label120: String str2;
    label196: int i;
    if (PingUtils.hasClient(localPing))
    {
      Client localClient = localPing.getClient();
      this.mRider.setRiderId(localClient.getUuid());
      str3 = localClient.getStatus();
      switch (str3.hashCode())
      {
      default:
        j = -1;
        switch (j)
        {
        default:
          if (PingUtils.hasTripDriver(localPing))
          {
            this.mRider.setDriverId(localPing.getTrip().getDriver().getUuid());
            str2 = localPing.getTrip().getDriver().getStatus();
            switch (str2.hashCode())
            {
            default:
              i = -1;
              label199: switch (i)
              {
              default:
              case 0:
              case 1:
              case 2:
              }
              break;
            case -2081881145:
            case 930446413:
            case -1484957102:
            }
          }
          break;
        case 0:
        case 1:
        case 2:
        case 3:
        }
        break;
      case -1561136888:
      case 2014441667:
      case -1929061692:
      case -1978426120:
      }
    }
    while (true)
    {
      if (TextUtils.isEmpty(this.mRider.getRiderId()))
        this.mRider.setRiderId(this.mSessionPreferences.getUserUuid());
      extractCurrentProductProperties(localPing);
      Rider localRider = this.mRider;
      boolean bool = PingUtils.hasTrip(localPing);
      String str1 = null;
      if (bool)
        str1 = localPing.getTrip().getId();
      localRider.setTripId(str1);
      return;
      if (!str3.equals("Dispatching"))
        break;
      j = 0;
      break label87;
      if (!str3.equals("Looking"))
        break;
      j = 1;
      break label87;
      if (!str3.equals("OnTrip"))
        break;
      j = 2;
      break label87;
      if (!str3.equals("WaitingForPickup"))
        break;
      j = 3;
      break label87;
      this.mRider.setRiderStatus("dispatching");
      break label120;
      this.mRider.setRiderStatus("looking");
      break label120;
      this.mRider.setRiderStatus("on_trip");
      break label120;
      this.mRider.setRiderStatus("waiting_for_pickup");
      break label120;
      this.mRider.setRiderId(null);
      this.mRider.setRiderStatus(null);
      break label120;
      if (!str2.equals("Accepted"))
        break label196;
      i = 0;
      break label199;
      if (!str2.equals("Arrived"))
        break label196;
      i = 1;
      break label199;
      if (!str2.equals("DrivingClient"))
        break label196;
      i = 2;
      break label199;
      this.mRider.setDriverStatus("accepted");
      continue;
      this.mRider.setDriverStatus("arrived");
      continue;
      this.mRider.setDriverStatus("on_trip");
      continue;
      this.mRider.setDriverId(null);
      this.mRider.setDriverStatus(null);
    }
  }

  @Subscribe
  public void onVehicleSelected(VehicleViewSelectedEvent paramVehicleViewSelectedEvent)
  {
    String str = paramVehicleViewSelectedEvent.getVehicleViewId();
    if (this.mRider.getCurrentProduct() == null);
    for (Object localObject = null; Objects.equal(str, localObject); localObject = this.mRider.getCurrentProduct().getId())
      return;
    this.mRider.setCurrentProductId(str);
    extractCurrentProductProperties(this.mPingProvider.get());
  }

  public void register(Bus paramBus)
  {
    paramBus.register(this);
  }

  public void unregister(Bus paramBus)
  {
    paramBus.unregister(this);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.metrics.analytics.model.RiderEventsProperties
 * JD-Core Version:    0.6.2
 */