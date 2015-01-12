package com.ubercab.library.vendor.baidu.location;

import android.content.Context;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.location.LocationClientOption.LocationMode;
import com.ubercab.library.location.client.IUberLocationClient;
import com.ubercab.library.location.client.UberLocationListener;
import com.ubercab.library.location.model.UberLatLng;
import com.ubercab.library.location.model.UberLocation;
import com.ubercab.library.location.model.UberLocation.Builder;
import com.ubercab.library.location.model.UberLocationRequest;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import timber.log.Timber;

public class BaiduLocationClientAdapter extends IUberLocationClient
  implements BDLocationListener
{
  private static final DateFormat BAIDU_DATE_FORMATTER = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z");
  private static final String CHINA_STANDARD_TIMEZONE_OFFSET = "+0800";
  private static final String COORDINATE_TYPE_GCJ02 = "gcj02";
  private final BaiduLocationClientWrapper mBaiduLocationClientWrapper;

  public BaiduLocationClientAdapter(Context paramContext)
  {
    this.mBaiduLocationClientWrapper = new BaiduLocationClientWrapper(new LocationClient(paramContext));
    this.mBaiduLocationClientWrapper.setLocOption(convert(getLocationRequest()));
    this.mBaiduLocationClientWrapper.registerLocationListener(this);
  }

  BaiduLocationClientAdapter(BaiduLocationClientWrapper paramBaiduLocationClientWrapper)
  {
    this.mBaiduLocationClientWrapper = paramBaiduLocationClientWrapper;
  }

  private static LocationClientOption convert(UberLocationRequest paramUberLocationRequest)
  {
    if (paramUberLocationRequest == null)
      return null;
    LocationClientOption localLocationClientOption = new LocationClientOption();
    localLocationClientOption.setCoorType("gcj02");
    localLocationClientOption.setLocationMode(convertPriority(paramUberLocationRequest.getPriority()));
    localLocationClientOption.setScanSpan(new Long(paramUberLocationRequest.getInterval()).intValue());
    return localLocationClientOption;
  }

  private static UberLocation convert(BDLocation paramBDLocation)
  {
    if (paramBDLocation == null)
      return null;
    return new UberLocation.Builder(new UberLatLng(paramBDLocation.getLatitude(), paramBDLocation.getLongitude(), 1).convertToWGS84()).accuracy(paramBDLocation.getRadius()).altitude(paramBDLocation.getAltitude()).bearing(paramBDLocation.getDirection()).speed(paramBDLocation.getSpeed()).time(convertTimeToMs(paramBDLocation.getTime())).build();
  }

  private static LocationClientOption.LocationMode convertPriority(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return LocationClientOption.LocationMode.Battery_Saving;
    case 0:
      return LocationClientOption.LocationMode.Battery_Saving;
    case 1:
      return LocationClientOption.LocationMode.Hight_Accuracy;
    case 2:
    case 3:
    }
    return LocationClientOption.LocationMode.Device_Sensors;
  }

  private static long convertTimeToMs(String paramString)
  {
    long l1 = System.currentTimeMillis();
    String str;
    if (paramString != null)
      str = paramString + " " + "+0800";
    try
    {
      long l2 = BAIDU_DATE_FORMATTER.parse(str).getTime();
      l1 = l2;
      return l1;
    }
    catch (ParseException localParseException)
    {
      Timber.e("Error parsing time string", new Object[] { localParseException });
    }
    return l1;
  }

  public void connect()
  {
    this.mBaiduLocationClientWrapper.start();
  }

  public void disconnect()
  {
    this.mBaiduLocationClientWrapper.unRegisterLocationListener(this);
    this.mBaiduLocationClientWrapper.stop();
  }

  public UberLocation getLastKnownLocation()
  {
    return convert(this.mBaiduLocationClientWrapper.getLastKnownLocation());
  }

  public String getLocationClientName()
  {
    return "Baidu";
  }

  public boolean isConnected()
  {
    return this.mBaiduLocationClientWrapper.isStarted();
  }

  public void onReceiveLocation(BDLocation paramBDLocation)
  {
    UberLocation localUberLocation = convert(paramBDLocation);
    Iterator localIterator = getUberLocationListeners().iterator();
    while (localIterator.hasNext())
      ((UberLocationListener)localIterator.next()).onLocationChanged(localUberLocation);
  }

  public void setLocationRequest(UberLocationRequest paramUberLocationRequest)
  {
    try
    {
      super.setLocationRequest(paramUberLocationRequest);
      this.mBaiduLocationClientWrapper.unRegisterLocationListener(this);
      this.mBaiduLocationClientWrapper.setLocOption(convert(getLocationRequest()));
      this.mBaiduLocationClientWrapper.registerLocationListener(this);
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
 * Qualified Name:     com.ubercab.library.vendor.baidu.location.BaiduLocationClientAdapter
 * JD-Core Version:    0.6.2
 */