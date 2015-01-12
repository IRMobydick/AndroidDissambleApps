package com.inauth.mme.logs;

import android.app.Application;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import com.google.gson.Gson;
import com.inauth.mme.InAuthManager;
import com.inauth.mme.beans.GPSLocationBean;
import com.inauth.mme.header.LogHeader;
import com.inauth.mme.response.LogResponse;
import com.inauth.utilities.InAuthUtilities;

public class GPSLocationLog
{
  private Location getGPSLocation(Application paramApplication)
  {
    LocationManager localLocationManager = (LocationManager)paramApplication.getSystemService("location");
    LocationListener local1 = new LocationListener()
    {
      public void onLocationChanged(Location paramAnonymousLocation)
      {
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
    try
    {
      localLocationManager.requestLocationUpdates("network", 0L, 0.0F, local1);
      try
      {
        label28: localLocationManager.requestLocationUpdates("gps", 0L, 0.0F, local1);
        try
        {
          label37: Location localLocation5 = localLocationManager.getLastKnownLocation("gps");
          localLocation1 = localLocation5;
        }
        catch (IllegalArgumentException localIllegalArgumentException3)
        {
          try
          {
            while (true)
            {
              Location localLocation4 = localLocationManager.getLastKnownLocation("network");
              localLocation2 = localLocation4;
              if (localLocation2 == null)
                break;
              localLocation3 = localLocation2;
              localLocationManager.removeUpdates(local1);
              return localLocation3;
              localIllegalArgumentException3 = localIllegalArgumentException3;
              localLocation1 = null;
            }
          }
          catch (IllegalArgumentException localIllegalArgumentException4)
          {
            while (true)
            {
              Location localLocation1;
              Location localLocation2 = null;
              continue;
              Location localLocation3 = null;
              if (localLocation1 != null)
                localLocation3 = localLocation1;
            }
          }
        }
      }
      catch (IllegalArgumentException localIllegalArgumentException2)
      {
        break label37;
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException1)
    {
      break label28;
    }
  }

  public LogResponse deserialize(String paramString)
  {
    return (LogResponse)new Gson().fromJson(paramString, LogResponse.class);
  }

  public String serialize(Application paramApplication, String paramString1, String paramString2, String paramString3)
  {
    LogHeader localLogHeader = new LogHeader();
    localLogHeader.setAccountGUID(paramString2);
    localLogHeader.setDeviceGUID(paramString1);
    localLogHeader.setDynamicID(InAuthManager.getInstance().getInAuthDynamicID());
    localLogHeader.setTransaction_id(paramString3);
    localLogHeader.setSDKVersion(InAuthManager.getInstance().getSDKVersion());
    localLogHeader.setType("gps_location_logs");
    Location localLocation = getGPSLocation(paramApplication);
    if (localLocation != null)
    {
      GPSLocationBean localGPSLocationBean = new GPSLocationBean();
      localGPSLocationBean.setLatitude(Double.toString(localLocation.getLatitude()));
      localGPSLocationBean.setLongitude(Double.toString(localLocation.getLongitude()));
      localGPSLocationBean.setAltitude(Double.toString(localLocation.getAltitude()));
      localGPSLocationBean.setAccuracy(Double.toString(localLocation.getAccuracy()));
      localGPSLocationBean.setProvider(localLocation.getProvider());
      localGPSLocationBean.setSpeed(Float.toString(localLocation.getSpeed()));
      localGPSLocationBean.setChecked_at(InAuthUtilities.GetIsoDateTime());
      localLogHeader.addLogs(localGPSLocationBean);
    }
    return new Gson().toJson(localLogHeader);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.inauth.mme.logs.GPSLocationLog
 * JD-Core Version:    0.6.2
 */