package com.ubercab.geo;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.TimeUnit;

public class LocationFetcher extends GeoFetcher
{
  private static final long LOCATION_UPDATE_TIMEOUT_MS = TimeUnit.MILLISECONDS.convert(5L, TimeUnit.SECONDS);
  private static final long MAX_CACHED_LOCATION_AGE_MS = TimeUnit.MILLISECONDS.convert(1L, TimeUnit.DAYS);
  private Location mInitialLocation;
  private LocationListener mLocationListener = new LocationListener()
  {
    public void onLocationChanged(Location paramAnonymousLocation)
    {
      LocationFetcher.this.sendLocation(paramAnonymousLocation);
    }

    public void onProviderDisabled(String paramAnonymousString)
    {
    }

    public void onProviderEnabled(String paramAnonymousString)
    {
    }

    public void onStatusChanged(String paramAnonymousString, int paramAnonymousInt, Bundle paramAnonymousBundle)
    {
    }
  };
  private LocationManager mLocationManager;

  public LocationFetcher(Context paramContext)
  {
    this.mLocationManager = ((LocationManager)paramContext.getSystemService("location"));
  }

  public void connect()
  {
    long l = System.currentTimeMillis();
    Location localLocation = getRecentLastKnownLocation("gps", l);
    if (localLocation == null)
      localLocation = getRecentLastKnownLocation("network", l);
    if (localLocation == null)
      localLocation = getRecentLastKnownLocation("passive", l);
    if (localLocation == null)
    {
      Criteria localCriteria = new Criteria();
      localCriteria.setAccuracy(1);
      try
      {
        this.mLocationManager.requestSingleUpdate(localCriteria, this.mLocationListener, null);
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable()
        {
          public void run()
          {
            LocationFetcher.this.mLocationManager.removeUpdates(LocationFetcher.this.mLocationListener);
            if ((LocationFetcher.this.mInitialLocation == null) && (LocationFetcher.this.mListener != null))
              LocationFetcher.this.mListener.onGeoNoLocationReceived();
          }
        }
        , LOCATION_UPDATE_TIMEOUT_MS);
        return;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        this.mListener.onGeoNoLocationReceived();
        return;
      }
    }
    sendLocation(localLocation);
  }

  public void disconnect()
  {
  }

  Location getRecentLastKnownLocation(String paramString, long paramLong)
  {
    Location localLocation = this.mLocationManager.getLastKnownLocation(paramString);
    if ((localLocation != null) && (paramLong - localLocation.getTime() < MAX_CACHED_LOCATION_AGE_MS))
      return localLocation;
    return null;
  }

  void sendLocation(Location paramLocation)
  {
    if (this.mListener != null)
    {
      this.mInitialLocation = paramLocation;
      this.mListener.onGeoLocationReceived(paramLocation.getLatitude(), paramLocation.getLongitude());
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.geo.LocationFetcher
 * JD-Core Version:    0.6.2
 */