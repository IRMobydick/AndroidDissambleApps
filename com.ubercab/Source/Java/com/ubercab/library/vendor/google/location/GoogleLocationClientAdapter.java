package com.ubercab.library.vendor.google.location;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;
import com.google.android.gms.location.LocationClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.ubercab.library.location.client.IUberLocationClient;
import com.ubercab.library.location.client.UberLocationClientError;
import com.ubercab.library.location.client.UberLocationListener;
import com.ubercab.library.location.model.UberLatLng;
import com.ubercab.library.location.model.UberLocation;
import com.ubercab.library.location.model.UberLocation.Builder;
import com.ubercab.library.location.model.UberLocationRequest;
import java.util.Iterator;
import java.util.List;

public class GoogleLocationClientAdapter extends IUberLocationClient
  implements LocationListener, GooglePlayServicesClient.ConnectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener
{
  private final LocationClient mLocationClient;

  public GoogleLocationClientAdapter(Context paramContext)
  {
    this.mLocationClient = new LocationClient(paramContext, this, this);
  }

  GoogleLocationClientAdapter(LocationClient paramLocationClient)
  {
    this.mLocationClient = paramLocationClient;
  }

  private static LocationRequest convert(UberLocationRequest paramUberLocationRequest)
  {
    if (paramUberLocationRequest == null)
      return null;
    return LocationRequest.create().setFastestInterval(paramUberLocationRequest.getFastestInterval()).setInterval(paramUberLocationRequest.getInterval()).setPriority(convertPriority(paramUberLocationRequest.getPriority()));
  }

  private static UberLocationClientError convert(ConnectionResult paramConnectionResult)
  {
    if (paramConnectionResult == null)
      return null;
    return new UberLocationClientError(paramConnectionResult.getErrorCode(), 0);
  }

  private static UberLocation convert(Location paramLocation)
  {
    if (paramLocation == null)
      return null;
    return new UberLocation.Builder(new UberLatLng(paramLocation.getLatitude(), paramLocation.getLongitude())).accuracy(paramLocation.getAccuracy()).altitude(paramLocation.getAltitude()).bearing(paramLocation.getBearing()).speed(paramLocation.getSpeed()).time(paramLocation.getTime()).build();
  }

  static int convertPriority(int paramInt)
  {
    switch (paramInt)
    {
    case 0:
    default:
      return 102;
    case 1:
      return 100;
    case 2:
      return 104;
    case 3:
    }
    return 105;
  }

  public void connect()
  {
    this.mLocationClient.connect();
  }

  public void disconnect()
  {
    this.mLocationClient.removeLocationUpdates(this);
    this.mLocationClient.disconnect();
  }

  public UberLocation getLastKnownLocation()
  {
    try
    {
      UberLocation localUberLocation = convert(this.mLocationClient.getLastLocation());
      return localUberLocation;
    }
    catch (IllegalStateException localIllegalStateException)
    {
    }
    return null;
  }

  public String getLocationClientName()
  {
    return "Google";
  }

  public boolean isConnected()
  {
    return this.mLocationClient.isConnected();
  }

  public void onConnected(Bundle paramBundle)
  {
    this.mLocationClient.requestLocationUpdates(convert(getLocationRequest()), this);
  }

  public void onConnectionFailed(ConnectionResult paramConnectionResult)
  {
    UberLocationClientError localUberLocationClientError = convert(paramConnectionResult);
    Iterator localIterator = getUberLocationListeners().iterator();
    while (localIterator.hasNext())
      ((UberLocationListener)localIterator.next()).onLocationFailed(localUberLocationClientError);
  }

  public void onDisconnected()
  {
  }

  public void onLocationChanged(Location paramLocation)
  {
    UberLocation localUberLocation = convert(paramLocation);
    Iterator localIterator = getUberLocationListeners().iterator();
    while (localIterator.hasNext())
      ((UberLocationListener)localIterator.next()).onLocationChanged(localUberLocation);
  }

  public void setLocationRequest(UberLocationRequest paramUberLocationRequest)
  {
    try
    {
      super.setLocationRequest(paramUberLocationRequest);
      if (isConnected())
      {
        this.mLocationClient.removeLocationUpdates(this);
        this.mLocationClient.requestLocationUpdates(convert(getLocationRequest()), this);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.vendor.google.location.GoogleLocationClientAdapter
 * JD-Core Version:    0.6.2
 */