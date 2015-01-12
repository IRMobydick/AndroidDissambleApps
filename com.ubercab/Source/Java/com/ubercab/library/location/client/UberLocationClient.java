package com.ubercab.library.location.client;

import android.content.Context;
import com.ubercab.library.location.model.UberLocation;
import com.ubercab.library.location.model.UberLocationRequest;
import com.ubercab.library.vendor.baidu.BaiduUtils;
import com.ubercab.library.vendor.baidu.location.BaiduLocationClientAdapter;
import com.ubercab.library.vendor.google.location.GoogleLocationClientAdapter;
import java.util.List;

public class UberLocationClient extends IUberLocationClient
{
  private Context mContext;
  private IUberLocationClient mLocationClient;
  private LocationClientVendor mLocationClientVendor;

  public UberLocationClient(Context paramContext, LocationClientVendor paramLocationClientVendor)
  {
    this.mContext = paramContext;
    this.mLocationClientVendor = paramLocationClientVendor;
    determineLocationClient();
  }

  private void determineLocationClient()
  {
    String str = this.mLocationClientVendor.getName();
    int i = -1;
    switch (str.hashCode())
    {
    default:
    case 93498907:
    case -1240244679:
    }
    while (true)
      switch (i)
      {
      default:
        throw new RuntimeException("Unknown location client vendor: " + this.mLocationClientVendor.getName());
        if (str.equals("baidu"))
        {
          i = 0;
          continue;
          if (str.equals("google"))
            i = 1;
        }
        break;
      case 0:
      case 1:
      }
    BaiduUtils.setBaiduServiceEnabled(this.mContext, true);
    this.mLocationClient = new BaiduLocationClientAdapter(this.mContext);
    return;
    BaiduUtils.setBaiduServiceEnabled(this.mContext, false);
    this.mLocationClient = new GoogleLocationClientAdapter(this.mContext);
  }

  public void connect()
  {
    this.mLocationClient.connect();
  }

  public void disconnect()
  {
    this.mLocationClient.disconnect();
  }

  public UberLocation getLastKnownLocation()
  {
    if (this.mLocationClient.isConnected())
      return this.mLocationClient.getLastKnownLocation();
    return null;
  }

  public String getLocationClientName()
  {
    return this.mLocationClient.getLocationClientName();
  }

  public UberLocationRequest getLocationRequest()
  {
    try
    {
      UberLocationRequest localUberLocationRequest = this.mLocationClient.getLocationRequest();
      return localUberLocationRequest;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public List<UberLocationListener> getUberLocationListeners()
  {
    return this.mLocationClient.getUberLocationListeners();
  }

  public boolean isConnected()
  {
    return this.mLocationClient.isConnected();
  }

  public void registerLocationListener(UberLocationListener paramUberLocationListener)
  {
    this.mLocationClient.registerLocationListener(paramUberLocationListener);
  }

  public void setLocationRequest(UberLocationRequest paramUberLocationRequest)
  {
    try
    {
      this.mLocationClient.setLocationRequest(paramUberLocationRequest);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void unregisterLocationListener(UberLocationListener paramUberLocationListener)
  {
    this.mLocationClient.unregisterLocationListener(paramUberLocationListener);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.location.client.UberLocationClient
 * JD-Core Version:    0.6.2
 */