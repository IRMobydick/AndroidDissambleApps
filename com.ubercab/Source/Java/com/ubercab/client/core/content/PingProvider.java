package com.ubercab.client.core.content;

import com.squareup.otto.Bus;
import com.squareup.otto.Produce;
import com.ubercab.client.core.content.event.PingEvent;
import com.ubercab.client.core.model.Ping;
import com.ubercab.client.core.model.event.ApiResponseEvent;
import com.ubercab.client.core.model.event.AppConfigEvent;
import com.ubercab.client.core.model.event.CityEvent;
import com.ubercab.client.core.model.event.ClientEvent;
import com.ubercab.client.core.model.event.ErrorObjectEvent;
import com.ubercab.client.core.model.event.FareSplitEvent;
import com.ubercab.client.core.model.event.ForceUpgradeUrlEvent;
import com.ubercab.client.core.model.event.IsForceUpgradeEvent;
import com.ubercab.client.core.model.event.MapFittingMobileAppDelayWindowMsEvent;
import com.ubercab.client.core.model.event.NearbyEvent;
import com.ubercab.client.core.model.event.NearbyVehiclesEvent;
import com.ubercab.client.core.model.event.NoPingEvent;
import com.ubercab.client.core.model.event.PlacesEvent;
import com.ubercab.client.core.model.event.RecentEvent;
import com.ubercab.client.core.model.event.SessionEvent;
import com.ubercab.client.core.model.event.TripEvent;
import com.ubercab.common.base.Objects;
import com.ubercab.common.base.Preconditions;
import com.ubercab.library.util.TimeUtils;

public class PingProvider
{
  public static final int MAX_LIFETIME_SECONDS = 300;
  private final Bus mBus;
  private Ping mPing = new Ping();
  private long mPingEpochTime;

  public PingProvider(Bus paramBus)
  {
    Preconditions.checkNotNull(paramBus);
    this.mBus = paramBus;
  }

  public void clear()
  {
    try
    {
      this.mPing = null;
      this.mPingEpochTime = 0L;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public Ping get()
  {
    try
    {
      Ping localPing = this.mPing;
      return localPing;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public long getEpochTime()
  {
    try
    {
      long l = this.mPingEpochTime;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public boolean isExpired()
  {
    try
    {
      if (this.mPing != null)
      {
        long l1 = TimeUtils.getEpochTime();
        long l2 = this.mPingEpochTime;
        if (l1 - l2 < 300L);
      }
      else
      {
        bool = true;
        return bool;
      }
      boolean bool = false;
    }
    finally
    {
    }
  }

  @Produce
  public ApiResponseEvent produceApiResponseEvent()
  {
    if (isExpired())
      return null;
    return new ApiResponseEvent(this.mPing.getApiResponse());
  }

  @Produce
  public AppConfigEvent produceAppConfigEvent()
  {
    if (isExpired())
      return null;
    return new AppConfigEvent(this.mPing.getAppConfig());
  }

  @Produce
  public CityEvent produceCityEvent()
  {
    if (isExpired())
      return null;
    return new CityEvent(this.mPing.getCity());
  }

  @Produce
  public ClientEvent produceClientEvent()
  {
    if (isExpired())
      return null;
    return new ClientEvent(this.mPing.getClient());
  }

  @Produce
  public ErrorObjectEvent produceErrorObjEvent()
  {
    if (isExpired())
      return null;
    return new ErrorObjectEvent(this.mPing.getErrorObj());
  }

  @Produce
  public FareSplitEvent produceFareSplitEvent()
  {
    if (isExpired())
      return null;
    return new FareSplitEvent(this.mPing.getFareSplit());
  }

  @Produce
  public ForceUpgradeUrlEvent produceForceUpgradeUrlEvent()
  {
    if (isExpired())
      return null;
    return new ForceUpgradeUrlEvent(this.mPing.getForceUpgradeUrl());
  }

  @Produce
  public IsForceUpgradeEvent produceIsForceUpgradeEvent()
  {
    if (isExpired())
      return null;
    return new IsForceUpgradeEvent(this.mPing.isForceUpgrade());
  }

  @Produce
  public MapFittingMobileAppDelayWindowMsEvent produceMapFittingMobileAppDelayWindowMsEvent()
  {
    if (isExpired())
      return null;
    return new MapFittingMobileAppDelayWindowMsEvent(this.mPing.getMapFittingMobileAppDelayWindowMs());
  }

  @Produce
  public NearbyEvent produceNearbyEvent()
  {
    if (isExpired())
      return null;
    return new NearbyEvent(this.mPing.getNearby());
  }

  @Produce
  public NearbyVehiclesEvent produceNearbyVehiclesEvent()
  {
    if (isExpired())
      return null;
    return new NearbyVehiclesEvent(this.mPing.getNearbyVehicles());
  }

  @Produce
  public NoPingEvent produceNoPingEvent()
  {
    if (isExpired())
      return new NoPingEvent();
    return null;
  }

  @Produce
  public PingEvent producePingEvent()
  {
    if (isExpired())
      return null;
    return new PingEvent(this.mPing, this.mPingEpochTime);
  }

  @Produce
  public PlacesEvent producePlacesEvent()
  {
    if (isExpired())
      return null;
    return new PlacesEvent(this.mPing.getPlaces());
  }

  @Produce
  public RecentEvent produceRecentEvent()
  {
    if (isExpired())
      return null;
    return new RecentEvent(this.mPing.getRecent());
  }

  @Produce
  public SessionEvent produceSessionEvent()
  {
    if (isExpired())
      return null;
    return new SessionEvent(this.mPing.getSession());
  }

  @Produce
  public TripEvent produceTripEvent()
  {
    if (isExpired())
      return null;
    return new TripEvent(this.mPing.getTrip());
  }

  public void register()
  {
    this.mBus.register(this);
  }

  public void unregister()
  {
    this.mBus.unregister(this);
  }

  public void update(Ping paramPing)
  {
    try
    {
      Ping localPing = this.mPing;
      long l = this.mPingEpochTime;
      this.mPing = paramPing;
      this.mPingEpochTime = TimeUtils.getEpochTime();
      if (paramPing == null)
        this.mBus.post(new NoPingEvent());
      while (true)
      {
        return;
        if ((this.mPingEpochTime != l) || (!Objects.equal(this.mPing, localPing)))
        {
          this.mBus.post(new PingEvent(paramPing, this.mPingEpochTime));
          if (localPing == null)
            localPing = new Ping();
          if (!Objects.equal(this.mPing.getApiResponse(), localPing.getApiResponse()))
            this.mBus.post(new ApiResponseEvent(this.mPing.getApiResponse()));
          if (!Objects.equal(this.mPing.getAppConfig(), localPing.getAppConfig()))
            this.mBus.post(new AppConfigEvent(this.mPing.getAppConfig()));
          if (!Objects.equal(this.mPing.getCity(), localPing.getCity()))
            this.mBus.post(new CityEvent(this.mPing.getCity()));
          if (!Objects.equal(this.mPing.getClient(), localPing.getClient()))
            this.mBus.post(new ClientEvent(this.mPing.getClient()));
          if (!Objects.equal(this.mPing.getErrorObj(), localPing.getErrorObj()))
            this.mBus.post(new ErrorObjectEvent(this.mPing.getErrorObj()));
          if (!Objects.equal(this.mPing.getFareSplit(), localPing.getFareSplit()))
            this.mBus.post(new FareSplitEvent(this.mPing.getFareSplit()));
          if (!Objects.equal(this.mPing.getForceUpgradeUrl(), localPing.getForceUpgradeUrl()))
            this.mBus.post(new ForceUpgradeUrlEvent(this.mPing.getForceUpgradeUrl()));
          if (!Objects.equal(Boolean.valueOf(this.mPing.isForceUpgrade()), Boolean.valueOf(localPing.isForceUpgrade())))
            this.mBus.post(new IsForceUpgradeEvent(this.mPing.isForceUpgrade()));
          if (!Objects.equal(Long.valueOf(this.mPing.getMapFittingMobileAppDelayWindowMs()), Long.valueOf(localPing.getMapFittingMobileAppDelayWindowMs())))
            this.mBus.post(new MapFittingMobileAppDelayWindowMsEvent(this.mPing.getMapFittingMobileAppDelayWindowMs()));
          if (!Objects.equal(this.mPing.getNearby(), localPing.getNearby()))
            this.mBus.post(new NearbyEvent(this.mPing.getNearby()));
          if (!Objects.equal(this.mPing.getNearbyVehicles(), localPing.getNearbyVehicles()))
            this.mBus.post(new NearbyVehiclesEvent(this.mPing.getNearbyVehicles()));
          if (!Objects.equal(this.mPing.getPlaces(), localPing.getPlaces()))
            this.mBus.post(new PlacesEvent(this.mPing.getPlaces()));
          if (!Objects.equal(this.mPing.getRecent(), localPing.getRecent()))
            this.mBus.post(new RecentEvent(this.mPing.getRecent()));
          if (!Objects.equal(this.mPing.getSession(), localPing.getSession()))
            this.mBus.post(new SessionEvent(this.mPing.getSession()));
          if (!Objects.equal(this.mPing.getTrip(), localPing.getTrip()))
            this.mBus.post(new TripEvent(this.mPing.getTrip()));
        }
      }
    }
    finally
    {
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.content.PingProvider
 * JD-Core Version:    0.6.2
 */