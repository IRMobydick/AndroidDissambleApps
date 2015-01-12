package com.inauth.pid.utilities;

import android.app.Application;
import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import com.inauth.utilities.ndk.InAuthNDK;
import java.io.UnsupportedEncodingException;
import java.util.Locale;

public class PIDHelper
{
  private static PIDHelper instance;
  private String Device_ID;

  public static PIDHelper getInstance()
  {
    if (instance == null)
      instance = new PIDHelper();
    return instance;
  }

  private void getWiFiMac(Context paramContext)
  {
    try
    {
      WifiManager localWifiManager = (WifiManager)paramContext.getSystemService("wifi");
      if (localWifiManager.isWifiEnabled())
      {
        this.Device_ID = localWifiManager.getConnectionInfo().getMacAddress();
        return;
      }
      localWifiManager.setWifiEnabled(true);
      this.Device_ID = localWifiManager.getConnectionInfo().getMacAddress();
      localWifiManager.setWifiEnabled(false);
      return;
    }
    catch (Exception localException)
    {
      this.Device_ID = "9a41f875e3b4";
    }
  }

  public String generatePID(Application paramApplication)
  {
    Context localContext = paramApplication.getApplicationContext();
    TelephonyManager localTelephonyManager = (TelephonyManager)localContext.getSystemService("phone");
    String str1;
    if (localTelephonyManager.getDeviceId() != null)
      str1 = localTelephonyManager.getDeviceId();
    while (true)
    {
      if (localTelephonyManager.getDeviceId() != null)
        str1 = localTelephonyManager.getDeviceId();
      getWiFiMac(localContext);
      String str2;
      byte[] arrayOfByte;
      if (this.Device_ID == null)
      {
        str2 = "9a41f875e3b4";
        arrayOfByte = InAuthNDK.getInstance().inauthid(str1, str2);
      }
      try
      {
        String str3 = new String(arrayOfByte, "UTF-8");
        return str3;
        str1 = Settings.Secure.getString(localContext.getContentResolver(), "android_id");
        continue;
        str2 = this.Device_ID.toLowerCase(Locale.ENGLISH);
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
      }
    }
    return null;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.inauth.pid.utilities.PIDHelper
 * JD-Core Version:    0.6.2
 */