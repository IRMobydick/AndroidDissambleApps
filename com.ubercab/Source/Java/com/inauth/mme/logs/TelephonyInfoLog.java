package com.inauth.mme.logs;

import android.app.Application;
import android.content.Context;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import com.google.gson.Gson;
import com.inauth.mme.InAuthManager;
import com.inauth.mme.beans.TelephonyInfoBean;
import com.inauth.mme.header.LogHeader;
import com.inauth.mme.response.LogResponse;
import com.inauth.utilities.InAuthUtilities;
import java.lang.reflect.Method;

public class TelephonyInfoLog
{
  public LogResponse deserialize(String paramString)
  {
    return (LogResponse)new Gson().fromJson(paramString, LogResponse.class);
  }

  public String serialize(Application paramApplication, String paramString1, String paramString2, String paramString3)
  {
    TelephonyManager localTelephonyManager = (TelephonyManager)paramApplication.getApplicationContext().getSystemService("phone");
    LogHeader localLogHeader = new LogHeader();
    localLogHeader.setAccountGUID(paramString2);
    localLogHeader.setDeviceGUID(paramString1);
    localLogHeader.setDynamicID(InAuthManager.getInstance().getInAuthDynamicID());
    localLogHeader.setTransaction_id(paramString3);
    localLogHeader.setSDKVersion(InAuthManager.getInstance().getSDKVersion());
    localLogHeader.setType("telephony_info_logs");
    TelephonyInfoBean localTelephonyInfoBean = new TelephonyInfoBean();
    if (localTelephonyManager.getDeviceId() != null)
    {
      if (localTelephonyManager.getPhoneType() != 1)
        break label301;
      localTelephonyInfoBean.setImei(localTelephonyManager.getDeviceId());
      GsmCellLocation localGsmCellLocation = (GsmCellLocation)localTelephonyManager.getCellLocation();
      if (localGsmCellLocation != null)
      {
        localTelephonyInfoBean.setCell_tower_id(Integer.toString(localGsmCellLocation.getCid()));
        localTelephonyInfoBean.setLocal_area_code(Integer.toString(localGsmCellLocation.getLac()));
      }
      if (localTelephonyManager.getSimState() == 5)
      {
        if (localTelephonyManager.getSimSerialNumber() != null)
          localTelephonyInfoBean.setSim_serial_number(localTelephonyManager.getSimSerialNumber());
        localTelephonyInfoBean.setMobile_country_code(localTelephonyManager.getSimOperator().substring(0, 3));
        localTelephonyInfoBean.setIso_country_code(localTelephonyManager.getSimCountryIso());
        localTelephonyInfoBean.setMobile_network_code(localTelephonyManager.getSimOperator().substring(3));
      }
    }
    while (true)
    {
      localTelephonyInfoBean.setSubscriber_id(localTelephonyManager.getSubscriberId());
      localTelephonyInfoBean.setNetwork_type(InAuthUtilities.find_net_type(localTelephonyManager.getNetworkType()));
      localTelephonyInfoBean.setPhone_type(InAuthUtilities.find_phone_type(localTelephonyManager.getPhoneType()));
      localTelephonyInfoBean.setSim_state(InAuthUtilities.find_sim_state(localTelephonyManager.getSimState()));
      localTelephonyInfoBean.setNetwork_name(localTelephonyManager.getNetworkOperatorName());
      localTelephonyInfoBean.setChecked_at(InAuthUtilities.GetIsoDateTime());
      localLogHeader.addLogs(localTelephonyInfoBean);
      return new Gson().toJson(localLogHeader);
      label301: if (localTelephonyManager.getPhoneType() == 2)
      {
        localTelephonyInfoBean.setMeid(localTelephonyManager.getDeviceId());
        CdmaCellLocation localCdmaCellLocation = (CdmaCellLocation)localTelephonyManager.getCellLocation();
        if (localCdmaCellLocation != null)
        {
          if (2147483647 != localCdmaCellLocation.getBaseStationLatitude())
            localTelephonyInfoBean.setCell_tower_latitude("" + localCdmaCellLocation.getBaseStationLatitude());
          if (2147483647 != localCdmaCellLocation.getBaseStationLongitude())
            localTelephonyInfoBean.setCell_tower_longitude("" + localCdmaCellLocation.getBaseStationLongitude());
          localTelephonyInfoBean.setCell_tower_id(Integer.toString(localCdmaCellLocation.getBaseStationId()));
          localTelephonyInfoBean.setLocal_area_code(Integer.toString(localCdmaCellLocation.getSystemId()));
        }
        if (localTelephonyManager.getSimSerialNumber() != null)
          localTelephonyInfoBean.setSim_serial_number(localTelephonyManager.getSimSerialNumber());
        try
        {
          Class localClass = Class.forName("android.os.SystemProperties");
          Method localMethod = localClass.getMethod("get", new Class[] { String.class });
          String str1 = (String)localMethod.invoke(localClass, new Object[] { "ro.cdma.home.operator.numeric" });
          String str2 = (String)localMethod.invoke(localClass, new Object[] { "gsm.operator.iso-country" });
          String str3 = str1.substring(0, 3);
          String str4 = str1.substring(3);
          localTelephonyInfoBean.setMobile_country_code(str3);
          localTelephonyInfoBean.setIso_country_code(str2);
          localTelephonyInfoBean.setMobile_network_code(str4);
        }
        catch (Exception localException)
        {
        }
      }
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.inauth.mme.logs.TelephonyInfoLog
 * JD-Core Version:    0.6.2
 */