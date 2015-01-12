package com.ubercab.client.core.util;

import android.text.TextUtils;
import com.ubercab.client.core.model.AppConfig;
import com.ubercab.client.core.model.City;
import com.ubercab.client.core.model.Client;
import com.ubercab.client.core.model.Experiment;
import com.ubercab.client.core.model.FareSplit;
import com.ubercab.client.core.model.FareSplitClient;
import com.ubercab.client.core.model.Ping;
import com.ubercab.client.core.model.Surge;
import com.ubercab.client.core.model.Trip;
import com.ubercab.client.core.model.TripPendingRating;
import com.ubercab.client.core.model.VehicleView;
import java.util.List;
import java.util.Map;

public final class PingUtils
{
  public static boolean hasAppConfig(Ping paramPing)
  {
    return (paramPing != null) && (paramPing.getAppConfig() != null);
  }

  public static boolean hasCity(Ping paramPing)
  {
    return (paramPing != null) && (paramPing.getCity() != null) && (!TextUtils.isEmpty(paramPing.getCity().getCityName()));
  }

  public static boolean hasClient(Ping paramPing)
  {
    return (paramPing != null) && (paramPing.getClient() != null) && (!TextUtils.isEmpty(paramPing.getClient().getUuid()));
  }

  public static boolean hasClientPaymentProfiles(Ping paramPing)
  {
    return (hasClient(paramPing)) && (paramPing.getClient().getPaymentProfiles() != null);
  }

  public static boolean hasErrorCode(Ping paramPing, int paramInt)
  {
    return (paramPing != null) && (paramPing.getErrorCode() != null) && (paramPing.getErrorCode().intValue() == paramInt);
  }

  public static boolean hasExperiment(Ping paramPing, String paramString)
  {
    return (hasClient(paramPing)) && (paramPing.getClient().getActiveExperiments() != null) && (paramPing.getClient().getActiveExperiments().containsKey(paramString));
  }

  public static boolean hasExperimentSerial(Ping paramPing, String paramString, int paramInt)
  {
    return (hasExperiment(paramPing, paramString)) && (((Experiment)paramPing.getClient().getActiveExperiments().get(paramString)).getGroupSerial() == paramInt);
  }

  public static boolean hasFailoverStrategy(Ping paramPing)
  {
    return (hasAppConfig(paramPing)) && (paramPing.getAppConfig().getFailoverStrategy() != null);
  }

  public static boolean hasFare(Ping paramPing, String paramString)
  {
    return (hasVehicleView(paramPing, paramString)) && (paramPing.getCity().findVehicleView(paramString).getFare() != null);
  }

  public static boolean hasFareSplit(Ping paramPing)
  {
    return (isClientOnTrip(paramPing)) && (paramPing.getFareSplit() != null) && (paramPing.getFareSplit().getClients() != null) && (!paramPing.getFareSplit().getClients().isEmpty());
  }

  public static boolean hasInactivePaymentProfiles(Ping paramPing)
  {
    return (hasClient(paramPing)) && (paramPing.getClient().getInactivePaymentProfiles() != null);
  }

  public static boolean hasLastEstimatedTrip(Ping paramPing)
  {
    return (hasClient(paramPing)) && (paramPing.getClient().getLastEstimatedTrip() != null);
  }

  public static boolean hasLastSelectedPaymentProfileId(Ping paramPing)
  {
    return (hasClient(paramPing)) && (paramPing.getClient().getLastSelectedPaymentProfileId() != null);
  }

  public static boolean hasLegacyMobileMessage(Ping paramPing)
  {
    return (hasCity(paramPing)) && (paramPing.getCity().getEvent() != null);
  }

  public static boolean hasMobileMessages(Ping paramPing)
  {
    return (hasCity(paramPing)) && (paramPing.getCity().getMessages() != null) && (!paramPing.getCity().getMessages().isEmpty());
  }

  public static boolean hasMultiLegTrip(Ping paramPing)
  {
    return (hasTrip(paramPing)) && (paramPing.getTrip().getLegs() != null) && (paramPing.getTrip().getLegs().size() > 1);
  }

  public static boolean hasNearbyVehicle(Ping paramPing, String paramString)
  {
    return (hasNearbyVehicles(paramPing)) && (paramPing.getNearbyVehicles().get(paramString) != null);
  }

  public static boolean hasNearbyVehicles(Ping paramPing)
  {
    return (paramPing != null) && (paramPing.getNearbyVehicles() != null) && (paramPing.getNearbyVehicles().size() > 0);
  }

  public static boolean hasNonEmptyVehicleViews(Ping paramPing)
  {
    return (hasVehicleViews(paramPing)) && (!paramPing.getCity().getVehicleViews().isEmpty());
  }

  public static boolean hasPingUpdateInterval(Ping paramPing)
  {
    return (hasAppConfig(paramPing)) && (paramPing.getAppConfig().getPingUpdateIntervalMs() != null);
  }

  public static boolean hasRiderAppConfig(Ping paramPing)
  {
    return (paramPing != null) && (paramPing.getAppConfig() != null) && (paramPing.getAppConfig().getRiderConfig() != null);
  }

  public static boolean hasSession(Ping paramPing)
  {
    return (paramPing != null) && (paramPing.getSession() != null);
  }

  public static boolean hasTrip(Ping paramPing)
  {
    return (paramPing != null) && (paramPing.getTrip() != null);
  }

  public static boolean hasTripBalances(Ping paramPing)
  {
    return (hasClient(paramPing)) && (paramPing.getClient().getTripBalances() != null) && (paramPing.getClient().getTripBalances().size() > 0);
  }

  public static boolean hasTripDestination(Ping paramPing)
  {
    return (hasTrip(paramPing)) && (paramPing.getTrip().getDestination() != null);
  }

  public static boolean hasTripDriver(Ping paramPing)
  {
    return (hasTrip(paramPing)) && (paramPing.getTrip().getDriver() != null);
  }

  public static boolean hasTripEntities(Ping paramPing)
  {
    return (hasTrip(paramPing)) && (paramPing.getTrip().getEntities() != null) && (!paramPing.getTrip().getEntities().isEmpty());
  }

  public static boolean hasTripExtraStates(Ping paramPing)
  {
    return (hasTrip(paramPing)) && (paramPing.getTrip().getExtraStates() != null) && (!paramPing.getTrip().getExtraStates().isEmpty());
  }

  public static boolean hasTripPendingRating(Ping paramPing)
  {
    if ((!hasClient(paramPing)) || (paramPing.getClient().getTripPendingRating() == null));
    while (TextUtils.isEmpty(paramPing.getClient().getTripPendingRating().getId()))
      return false;
    return true;
  }

  public static boolean hasTripPickup(Ping paramPing)
  {
    return (hasTrip(paramPing)) && (paramPing.getTrip().getPickupLocation() != null);
  }

  public static boolean hasVehicleView(Ping paramPing, String paramString)
  {
    return (hasVehicleViews(paramPing)) && (paramPing.getCity().findVehicleView(paramString) != null);
  }

  public static boolean hasVehicleViews(City paramCity)
  {
    return (paramCity != null) && (paramCity.getVehicleViews() != null) && (!paramCity.getVehicleViews().isEmpty());
  }

  public static boolean hasVehicleViews(Ping paramPing)
  {
    return (hasCity(paramPing)) && (paramPing.getCity().getVehicleViews() != null);
  }

  public static boolean isClientOnTrip(Ping paramPing)
  {
    return (hasClient(paramPing)) && (!paramPing.getClient().getStatus().equals("Looking"));
  }

  public static boolean isClientStatusLooking(Ping paramPing)
  {
    return (hasClient(paramPing)) && (paramPing.getClient().getStatus().equals("Looking"));
  }

  public static boolean isSurging(Ping paramPing, String paramString)
  {
    if (!hasVehicleView(paramPing, paramString));
    Surge localSurge;
    do
    {
      return false;
      localSurge = paramPing.getCity().findVehicleView(paramString).getSurge();
    }
    while ((localSurge == null) || (localSurge.getMultiplier() <= 1.0F));
    return true;
  }

  public static boolean isTripMaster(Ping paramPing)
  {
    return (!hasFareSplit(paramPing)) || (paramPing.getFareSplit().getClientSelf().isInitiator());
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.util.PingUtils
 * JD-Core Version:    0.6.2
 */