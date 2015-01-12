package com.inauth.utilities;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Build.VERSION;
import android.os.Debug;
import android.provider.Settings.Global;
import android.provider.Settings.Secure;
import com.inauth.mme.InAuthManager;
import com.inauth.mme.beans.LogConfigFlagsBean;
import com.inauth.utilities.encryption.BouncyEncoding;
import com.inauth.utilities.enums.NetworkState;
import com.inauth.utilities.ndk.InAuthNDK;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.channels.FileChannel;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;

public class InAuthUtilities
{
  public static String GetIsoDateTime()
  {
    return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss Z").format(new Date());
  }

  public static byte[] Serverpack(String paramString)
  {
    byte[] arrayOfByte1 = zipit(paramString.getBytes());
    try
    {
      byte[] arrayOfByte2 = InAuthNDK.getInstance().NDKPacking(arrayOfByte1);
      return arrayOfByte2;
    }
    catch (Exception localException)
    {
      return null;
    }
    catch (IOException localIOException)
    {
    }
    return null;
  }

  public static String checkActiveNetworkDataConnection(Application paramApplication)
  {
    if (paramApplication.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", paramApplication.getPackageName()) != 0)
      return "PERMISSIONS_MISSING";
    NetworkInfo localNetworkInfo = ((ConnectivityManager)paramApplication.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
    Object localObject = null;
    int i = 0;
    if (0 == 0);
    try
    {
      int j = localNetworkInfo.getType();
      localObject = null;
      i = 0;
      if (j == 1)
      {
        NetworkInfo.State localState1 = localNetworkInfo.getState();
        NetworkInfo.State localState2 = NetworkInfo.State.CONNECTED;
        localObject = null;
        i = 0;
        if (localState1 == localState2)
        {
          String str4 = NetworkState.WIFI.getValue();
          localObject = str4;
          i = 1;
        }
      }
      if (i == 0);
      try
      {
        if ((localNetworkInfo.getType() == 0) && (localNetworkInfo.getState() == NetworkInfo.State.CONNECTED))
        {
          String str3 = NetworkState.MOBILE.getValue();
          localObject = str3;
          i = 1;
        }
        label128: if (i == 0);
        try
        {
          if ((localNetworkInfo.getType() == 7) && (localNetworkInfo.getState() == NetworkInfo.State.CONNECTED))
          {
            String str2 = NetworkState.BLUETOOTH.getValue();
            localObject = str2;
            i = 1;
          }
          label164: if (i == 0);
          try
          {
            if ((localNetworkInfo.getType() == 9) && (localNetworkInfo.getState() == NetworkInfo.State.CONNECTED))
            {
              String str1 = NetworkState.ETHERNET.getValue();
              localObject = str1;
            }
            label198: if (localObject == null)
              localObject = NetworkState.NONE.getValue();
            return localObject;
          }
          catch (Exception localException1)
          {
            break label198;
          }
        }
        catch (Exception localException2)
        {
          break label164;
        }
      }
      catch (Exception localException3)
      {
        break label128;
      }
    }
    catch (Exception localException4)
    {
      while (true)
      {
        localObject = null;
        i = 0;
      }
    }
  }

  public static boolean checkLogPermissions(String paramString)
  {
    PackageManager localPackageManager = InAuthManager.getInstance().getApp().getPackageManager();
    boolean bool1;
    if ("registration_logs".equals(paramString))
    {
      int i5 = localPackageManager.checkPermission("android.permission.READ_PHONE_STATE", InAuthManager.getInstance().getApp().getPackageName());
      bool1 = false;
      if (i5 == 0)
      {
        int i6 = localPackageManager.checkPermission("android.permission.ACCESS_WIFI_STATE", InAuthManager.getInstance().getApp().getPackageName());
        bool1 = false;
        if (i6 == 0)
        {
          int i7 = localPackageManager.checkPermission("android.permission.INTERNET", InAuthManager.getInstance().getApp().getPackageName());
          bool1 = false;
          if (i7 == 0)
          {
            int i8 = localPackageManager.checkPermission("android.permission.ACCESS_NETWORK_STATE", InAuthManager.getInstance().getApp().getPackageName());
            bool1 = false;
            if (i8 == 0)
              bool1 = true;
          }
        }
      }
    }
    int k;
    do
    {
      boolean bool2;
      do
      {
        int m;
        do
        {
          int i1;
          do
          {
            int n;
            do
            {
              int j;
              do
              {
                int i3;
                do
                {
                  int i2;
                  do
                  {
                    int i;
                    do
                    {
                      int i4;
                      do
                      {
                        return bool1;
                        if (!"android_accounts_logs".equals(paramString))
                          break;
                        i4 = localPackageManager.checkPermission("android.permission.GET_ACCOUNTS", InAuthManager.getInstance().getApp().getPackageName());
                        bool1 = false;
                      }
                      while (i4 != 0);
                      return true;
                      if ((!"app_data_usage_logs".equals(paramString)) && (!"app_activity_history_logs".equals(paramString)))
                        break;
                      i = localPackageManager.checkPermission("android.permission.GET_PACKAGE_SIZE", InAuthManager.getInstance().getApp().getPackageName());
                      bool1 = false;
                    }
                    while (i != 0);
                    return true;
                    if (!"gps_location_logs".equals(paramString))
                      break;
                    i2 = localPackageManager.checkPermission("android.permission.ACCESS_FINE_LOCATION", InAuthManager.getInstance().getApp().getPackageName());
                    bool1 = false;
                  }
                  while (i2 != 0);
                  i3 = localPackageManager.checkPermission("android.permission.ACCESS_COARSE_LOCATION", InAuthManager.getInstance().getApp().getPackageName());
                  bool1 = false;
                }
                while (i3 != 0);
                return true;
                if ((!"mms_logs".equals(paramString)) && (!"sms_logs".equals(paramString)))
                  break;
                j = localPackageManager.checkPermission("android.permission.READ_SMS", InAuthManager.getInstance().getApp().getPackageName());
                bool1 = false;
              }
              while (j != 0);
              return true;
              if (!"phone_calls_logs".equals(paramString))
                break;
              n = localPackageManager.checkPermission("android.permission.READ_CONTACTS", InAuthManager.getInstance().getApp().getPackageName());
              bool1 = false;
            }
            while (n != 0);
            if (Build.VERSION.SDK_INT <= 15)
              break;
            i1 = localPackageManager.checkPermission("android.permission.READ_CALL_LOG", InAuthManager.getInstance().getApp().getPackageName());
            bool1 = false;
          }
          while (i1 != 0);
          return true;
          return true;
          if (!"telephony_info_logs".equals(paramString))
            break;
          m = localPackageManager.checkPermission("android.permission.ACCESS_COARSE_LOCATION", InAuthManager.getInstance().getApp().getPackageName());
          bool1 = false;
        }
        while (m != 0);
        return true;
        bool2 = "wifi_neighbor_logs".equals(paramString);
        bool1 = false;
      }
      while (!bool2);
      k = localPackageManager.checkPermission("android.permission.CHANGE_WIFI_STATE", InAuthManager.getInstance().getApp().getPackageName());
      bool1 = false;
    }
    while (k != 0);
    return true;
  }

  private static String convertHashToString(byte[] paramArrayOfByte)
  {
    String str = "";
    for (int i = 0; i < paramArrayOfByte.length; i++)
      str = str + Integer.toString(256 + (0xFF & paramArrayOfByte[i]), 16).substring(1);
    return str;
  }

  private static void copy(InputStream paramInputStream, OutputStream paramOutputStream)
    throws IOException
  {
    if (((paramOutputStream instanceof FileOutputStream)) && ((paramInputStream instanceof FileInputStream)))
      try
      {
        FileChannel localFileChannel1 = ((FileOutputStream)paramOutputStream).getChannel();
        FileChannel localFileChannel2 = ((FileInputStream)paramInputStream).getChannel();
        localFileChannel2.transferTo(0L, 2147483647L, localFileChannel1);
        localFileChannel2.close();
        localFileChannel1.close();
        return;
      }
      catch (Exception localException)
      {
      }
    byte[] arrayOfByte = new byte[8192];
    while (true)
    {
      int i = paramInputStream.read(arrayOfByte);
      if (i < 0);
      try
      {
        paramInputStream.close();
        try
        {
          label77: paramOutputStream.close();
          return;
        }
        catch (IOException localIOException2)
        {
          return;
        }
        paramOutputStream.write(arrayOfByte, 0, i);
      }
      catch (IOException localIOException1)
      {
        break label77;
      }
    }
  }

  public static boolean doesFileExist(String paramString)
  {
    boolean bool1 = false;
    if (paramString != null)
    {
      File localFile = new File(paramString);
      boolean bool2 = localFile.exists();
      bool1 = false;
      if (bool2)
      {
        boolean bool3 = localFile.canRead();
        bool1 = false;
        if (bool3)
          bool1 = true;
      }
    }
    return bool1;
  }

  // ERROR //
  public static String fileToMD5(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: new 219	java/io/FileInputStream
    //   5: dup
    //   6: aload_0
    //   7: invokespecial 263	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   10: astore_2
    //   11: sipush 1024
    //   14: newarray byte
    //   16: astore 8
    //   18: ldc_w 265
    //   21: invokestatic 270	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   24: astore 9
    //   26: iconst_0
    //   27: istore 10
    //   29: iload 10
    //   31: iconst_m1
    //   32: if_icmpeq +46 -> 78
    //   35: aload_2
    //   36: aload 8
    //   38: invokevirtual 241	java/io/InputStream:read	([B)I
    //   41: istore 10
    //   43: iload 10
    //   45: ifle -16 -> 29
    //   48: aload 9
    //   50: aload 8
    //   52: iconst_0
    //   53: iload 10
    //   55: invokevirtual 273	java/security/MessageDigest:update	([BII)V
    //   58: goto -29 -> 29
    //   61: astore 5
    //   63: aload_2
    //   64: astore 6
    //   66: aload 6
    //   68: ifnull +8 -> 76
    //   71: aload 6
    //   73: invokevirtual 242	java/io/InputStream:close	()V
    //   76: aconst_null
    //   77: areturn
    //   78: aload 9
    //   80: invokevirtual 276	java/security/MessageDigest:digest	()[B
    //   83: invokestatic 278	com/inauth/utilities/InAuthUtilities:convertHashToString	([B)Ljava/lang/String;
    //   86: astore 11
    //   88: aload_2
    //   89: ifnull +7 -> 96
    //   92: aload_2
    //   93: invokevirtual 242	java/io/InputStream:close	()V
    //   96: aload 11
    //   98: areturn
    //   99: astore_3
    //   100: aload_1
    //   101: ifnull +7 -> 108
    //   104: aload_1
    //   105: invokevirtual 242	java/io/InputStream:close	()V
    //   108: aload_3
    //   109: athrow
    //   110: astore 12
    //   112: goto -16 -> 96
    //   115: astore 7
    //   117: aconst_null
    //   118: areturn
    //   119: astore 4
    //   121: goto -13 -> 108
    //   124: astore_3
    //   125: aload_2
    //   126: astore_1
    //   127: goto -27 -> 100
    //   130: astore 13
    //   132: aconst_null
    //   133: astore 6
    //   135: goto -69 -> 66
    //
    // Exception table:
    //   from	to	target	type
    //   11	26	61	java/lang/Exception
    //   35	43	61	java/lang/Exception
    //   48	58	61	java/lang/Exception
    //   78	88	61	java/lang/Exception
    //   2	11	99	finally
    //   92	96	110	java/lang/Exception
    //   71	76	115	java/lang/Exception
    //   104	108	119	java/lang/Exception
    //   11	26	124	finally
    //   35	43	124	finally
    //   48	58	124	finally
    //   78	88	124	finally
    //   2	11	130	java/lang/Exception
  }

  public static String find_net_type(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return "Unknown";
    case 7:
      return "1xRTT";
    case 4:
      return "CDMA";
    case 2:
      return "EDGE";
    case 14:
      return "eHRDP";
    case 5:
      return "EVDO rev. 0";
    case 6:
      return "EVDO rev. A";
    case 12:
      return "EVDO rev. B";
    case 1:
      return "GPRS";
    case 8:
      return "HSDPA";
    case 10:
      return "HSPA";
    case 15:
      return "HSPA+";
    case 9:
      return "HSUPA";
    case 11:
      return "iDen";
    case 13:
      return "LTE";
    case 3:
      return "UMTS";
    case 0:
    }
    return "Unknown";
  }

  public static String find_phone_type(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return "Unknown";
    case 1:
      return "GSM";
    case 2:
      return "CDMA";
    case 3:
      return "SIP";
    case 0:
    }
    return "Unknown";
  }

  public static String find_sim_state(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return "Unknown";
    case 0:
      return "Unknown";
    case 1:
      return "Absent";
    case 2:
      return "Pin Required";
    case 3:
      return "Puk Required";
    case 4:
      return "Network Locked";
    case 5:
    }
    return "Ready";
  }

  public static boolean hasActiveInternetConnection(String paramString)
  {
    boolean bool1 = isConnected();
    boolean bool2 = false;
    if (bool1)
    {
      bool2 = false;
      if (paramString != null)
      {
        try
        {
          boolean bool3 = paramString.isEmpty();
          bool2 = false;
          if (bool3)
            break label178;
          if (paramString.endsWith("/"));
          String str;
          for (Object localObject = paramString + "users/sign_in"; ; localObject = str)
          {
            HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL((String)localObject).openConnection();
            localHttpURLConnection.setRequestMethod("HEAD");
            localHttpURLConnection.setRequestProperty("Connection", "close");
            localHttpURLConnection.setConnectTimeout(1500);
            localHttpURLConnection.connect();
            if (localHttpURLConnection.getResponseCode() == 200)
              break;
            int i = localHttpURLConnection.getResponseCode();
            bool2 = false;
            if (i != 302)
              break label178;
            break;
            str = paramString + "/users/sign_in";
          }
        }
        catch (IOException localIOException)
        {
          return false;
        }
        bool2 = true;
      }
    }
    label178: return bool2;
  }

  public static boolean isConnected()
  {
    int i = InAuthManager.getInstance().getApp().getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", InAuthManager.getInstance().getApp().getPackageName());
    boolean bool = false;
    if (i == 0)
    {
      ConnectivityManager localConnectivityManager = (ConnectivityManager)InAuthManager.getInstance().getApp().getApplicationContext().getSystemService("connectivity");
      bool = false;
      if (localConnectivityManager != null)
        for (NetworkInfo localNetworkInfo : localConnectivityManager.getAllNetworkInfo())
          if (((localNetworkInfo.getTypeName().equalsIgnoreCase("WIFI")) || (localNetworkInfo.getTypeName().equalsIgnoreCase("MOBILE"))) && (localNetworkInfo.isConnected()) && (localNetworkInfo.isAvailable()))
            bool = true;
    }
    return bool;
  }

  public static boolean isDebuggerConnected()
  {
    return Debug.isDebuggerConnected();
  }

  public static boolean isFullMMEAccount(String paramString)
  {
    boolean bool1 = "full".equals(paramString);
    boolean bool2 = false;
    if (bool1)
      bool2 = true;
    return bool2;
  }

  public static boolean isLogFlagEnabled(String paramString1, String paramString2)
  {
    LogConfigFlagsBean localLogConfigFlagsBean = new LogConfigFlagsBean(paramString1);
    boolean bool2;
    if (("android_accounts_logs".equals(paramString2)) && (localLogConfigFlagsBean.isAccountsLogEnabled()))
      bool2 = true;
    boolean bool3;
    do
    {
      boolean bool1;
      do
      {
        return bool2;
        if (("app_activity_history_logs".equals(paramString2)) && (localLogConfigFlagsBean.isAppActivityLogEnabled()))
          return true;
        if (("app_data_usage_logs".equals(paramString2)) && (localLogConfigFlagsBean.isAppDataLogEnabled()))
          return true;
        if (("app_installs_logs".equals(paramString2)) && (localLogConfigFlagsBean.isAppInstallLogEnabled()))
          return true;
        if (("battery_info_logs".equals(paramString2)) && (localLogConfigFlagsBean.isBatteryInfoLogEnabled()))
          return true;
        if (("device_info_logs".equals(paramString2)) && (localLogConfigFlagsBean.isDeviceInfoLogEnabled()))
          return true;
        if (("gps_location_logs".equals(paramString2)) && (localLogConfigFlagsBean.isGPSLogEnabled()))
          return true;
        if (("malware_info_logs".equals(paramString2)) && (localLogConfigFlagsBean.isMalwareInfoLogEnabled()))
          return true;
        if (("mms_logs".equals(paramString2)) && (localLogConfigFlagsBean.isMMSLogEnabled()))
          return true;
        if (("net_data_usage_logs".equals(paramString2)) && (localLogConfigFlagsBean.isNetDataUsageLogEnabled()))
          return true;
        if (("phone_calls_logs".equals(paramString2)) && (localLogConfigFlagsBean.isPhoneCallLogEnabled()))
          return true;
        if (("root_check_logs".equals(paramString2)) && (localLogConfigFlagsBean.isRootInfoLogEnabled()))
          return true;
        if (("sms_logs".equals(paramString2)) && (localLogConfigFlagsBean.isSMSLogEnabled()))
          return true;
        if (("telephony_info_logs".equals(paramString2)) && (localLogConfigFlagsBean.isTelephonyInfoLogEnabled()))
          return true;
        if (("wifi_connection_logs".equals(paramString2)) && (localLogConfigFlagsBean.isWifiConnectedLogEnabled()))
          return true;
        bool1 = "wifi_neighbor_logs".equals(paramString2);
        bool2 = false;
      }
      while (!bool1);
      bool3 = localLogConfigFlagsBean.isWifiNeighborLogEnabled();
      bool2 = false;
    }
    while (!bool3);
    return true;
  }

  public static boolean isUSBDebuggerConnected(Application paramApplication)
  {
    if (Build.VERSION.SDK_INT < 17)
      return Settings.Secure.getInt(paramApplication.getApplicationContext().getContentResolver(), "adb_enabled", 0) == 1;
    return Settings.Global.getInt(paramApplication.getApplicationContext().getContentResolver(), "adb_enabled", 0) == 1;
  }

  public static String serverUnpack(byte[] paramArrayOfByte)
  {
    BouncyEncoding localBouncyEncoding = new BouncyEncoding();
    localBouncyEncoding.setCipherData(paramArrayOfByte);
    try
    {
      String str = new String(unzip(localBouncyEncoding.decrypt()), "UTF-8");
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      return null;
    }
    catch (InvalidAlgorithmParameterException localInvalidAlgorithmParameterException)
    {
      return null;
    }
    catch (BadPaddingException localBadPaddingException)
    {
      return null;
    }
    catch (IllegalBlockSizeException localIllegalBlockSizeException)
    {
      return null;
    }
    catch (ShortBufferException localShortBufferException)
    {
      return null;
    }
    catch (NoSuchPaddingException localNoSuchPaddingException)
    {
      return null;
    }
    catch (NoSuchProviderException localNoSuchProviderException)
    {
      return null;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      return null;
    }
    catch (InvalidKeyException localInvalidKeyException)
    {
    }
    return null;
  }

  public static byte[] streamToByteArray(InputStream paramInputStream)
    throws IOException
  {
    byte[] arrayOfByte = new byte[4096];
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    while (true)
    {
      int i = paramInputStream.read(arrayOfByte);
      if (i == -1)
        break;
      localByteArrayOutputStream.write(arrayOfByte, 0, i);
    }
    return localByteArrayOutputStream.toByteArray();
  }

  private static byte[] unzip(byte[] paramArrayOfByte)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    try
    {
      copy(new GZIPInputStream(new ByteArrayInputStream(paramArrayOfByte)), localByteArrayOutputStream);
      return localByteArrayOutputStream.toByteArray();
    }
    catch (IOException localIOException)
    {
      throw new RuntimeException(localIOException);
    }
  }

  private static byte[] zipit(byte[] paramArrayOfByte)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    try
    {
      GZIPOutputStream localGZIPOutputStream = new GZIPOutputStream(localByteArrayOutputStream);
      localGZIPOutputStream.write(paramArrayOfByte);
      localGZIPOutputStream.close();
      return localByteArrayOutputStream.toByteArray();
    }
    catch (IOException localIOException)
    {
      throw new RuntimeException(localIOException);
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.inauth.utilities.InAuthUtilities
 * JD-Core Version:    0.6.2
 */