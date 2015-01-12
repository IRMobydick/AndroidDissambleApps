package com.inauth.mme.logs;

import android.app.Application;
import android.net.DhcpInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import android.provider.Settings.Global;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import com.google.gson.Gson;
import com.inauth.mme.InAuthManager;
import com.inauth.mme.beans.DeviceInfoBean;
import com.inauth.mme.header.LogHeader;
import com.inauth.mme.response.LogResponse;
import com.inauth.utilities.InAuthUtilities;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;

public class DeviceInfoLog
{
  private static InetAddress getBroadcastAddress(Application paramApplication)
    throws IOException
  {
    byte[] arrayOfByte = new byte[4];
    try
    {
      DhcpInfo localDhcpInfo = ((WifiManager)paramApplication.getSystemService("wifi")).getDhcpInfo();
      int i = localDhcpInfo.ipAddress & localDhcpInfo.netmask | 0xFFFFFFFF ^ localDhcpInfo.netmask;
      for (int j = 0; j < 4; j++)
        arrayOfByte[j] = ((byte)(0xFF & i >> j * 8));
    }
    catch (Exception localException)
    {
    }
    return InetAddress.getByAddress(arrayOfByte);
  }

  private long getTotalMemory()
  {
    StatFs localStatFs = new StatFs(Environment.getRootDirectory().getAbsolutePath());
    if (Build.VERSION.SDK_INT < 18)
      return localStatFs.getBlockCount() * localStatFs.getBlockSize() / 1048576;
    return localStatFs.getBlockCountLong() * localStatFs.getBlockSizeLong() / 1048576L;
  }

  public LogResponse deserialize(String paramString)
  {
    return (LogResponse)new Gson().fromJson(paramString, LogResponse.class);
  }

  public String serialize(Application paramApplication, String paramString1, String paramString2, String paramString3)
  {
    TelephonyManager localTelephonyManager = (TelephonyManager)paramApplication.getSystemService("phone");
    InetAddress localInetAddress = null;
    try
    {
      localInetAddress = getBroadcastAddress(paramApplication);
      if (Build.VERSION.SDK_INT < 17)
      {
        int j = Settings.Secure.getInt(null, "install_non_market_apps", 0);
        if (j == 1);
        for (bool = true; ; bool = false)
        {
          String str = "";
          if (localInetAddress != null)
            str = localInetAddress.toString().substring(1);
          LogHeader localLogHeader = new LogHeader();
          localLogHeader.setAccountGUID(paramString2);
          localLogHeader.setDeviceGUID(paramString1);
          localLogHeader.setDynamicID(InAuthManager.getInstance().getInAuthDynamicID());
          localLogHeader.setTransaction_id(paramString3);
          localLogHeader.setSDKVersion(InAuthManager.getInstance().getSDKVersion());
          localLogHeader.setType("device_info_logs");
          DeviceInfoBean localDeviceInfoBean = new DeviceInfoBean();
          localDeviceInfoBean.setBuild_version(Build.VERSION.RELEASE);
          localDeviceInfoBean.setSdk_code(Build.VERSION.SDK);
          localDeviceInfoBean.setBoard(Build.BOARD);
          localDeviceInfoBean.setBrand(Build.BRAND);
          localDeviceInfoBean.setDevice(Build.DEVICE);
          localDeviceInfoBean.setDisplay(Build.DISPLAY);
          localDeviceInfoBean.setFingerprint(Build.FINGERPRINT);
          localDeviceInfoBean.setDevice_type(Build.ID);
          localDeviceInfoBean.setModel(Build.MODEL);
          localDeviceInfoBean.setManufacturer(Build.MANUFACTURER);
          localDeviceInfoBean.setProduct(Build.PRODUCT);
          localDeviceInfoBean.setDevice_type(Build.TYPE);
          localDeviceInfoBean.setCell_number(localTelephonyManager.getLine1Number());
          localDeviceInfoBean.setIp(str);
          localDeviceInfoBean.setOs_platform("Android");
          localDeviceInfoBean.setTotal_disk_space(Long.toString(getTotalMemory()));
          localDeviceInfoBean.setUnknown_sources_enabled(Boolean.toString(bool));
          localDeviceInfoBean.setChecked_at(InAuthUtilities.GetIsoDateTime());
          localLogHeader.addLogs(localDeviceInfoBean);
          return new Gson().toJson(localLogHeader);
        }
      }
      int i = Settings.Global.getInt(null, "install_non_market_apps", 0);
      if (i == 1);
      for (bool = true; ; bool = false)
        break;
    }
    catch (Exception localException)
    {
      while (true)
        boolean bool = false;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.inauth.mme.logs.DeviceInfoLog
 * JD-Core Version:    0.6.2
 */