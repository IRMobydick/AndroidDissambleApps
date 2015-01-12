package com.inauth.mme;

import android.app.Application;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Looper;
import android.preference.PreferenceManager;
import com.inauth.mme.logs.AndroidAccountsLog;
import com.inauth.mme.logs.AppActivityHistoryLog;
import com.inauth.mme.logs.AppDataUsageLog;
import com.inauth.mme.logs.AppInstallLog;
import com.inauth.mme.logs.BatteryInfoLog;
import com.inauth.mme.logs.ConfigurationLog;
import com.inauth.mme.logs.CustomInfoLog;
import com.inauth.mme.logs.DeviceInfoLog;
import com.inauth.mme.logs.GPSLocationLog;
import com.inauth.mme.logs.MMSLog;
import com.inauth.mme.logs.MalwareInfoLog;
import com.inauth.mme.logs.NetDataUsageLog;
import com.inauth.mme.logs.PhoneCallLog;
import com.inauth.mme.logs.RegistrationLog;
import com.inauth.mme.logs.RootCheckLog;
import com.inauth.mme.logs.SMSLog;
import com.inauth.mme.logs.TelephonyInfoLog;
import com.inauth.mme.logs.WifiConnectionLog;
import com.inauth.mme.logs.WifiNeighborLog;
import com.inauth.mme.response.LogConfigResponse;
import com.inauth.mme.response.RegistrationResponse;
import com.inauth.mw.InAuthMalware;
import com.inauth.mw.utilities.MalwareLog;
import com.inauth.pid.InAuthPID;
import com.inauth.root.InAuthRoot;
import com.inauth.root.utilities.RootLog;
import com.inauth.utilities.InAuthDynamicID;
import com.inauth.utilities.InAuthUtilities;
import com.inauth.utilities.network.UploadFile;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class InAuthManager
{
  private static InAuthManager instance;
  private Application app;
  private InitCompletionListener listener;
  private SharedPreferences mPrefs;

  private String getAccountGUID()
  {
    return getInstance().getmPrefs().getString("ACCOUNT_GUID", null);
  }

  private String getAccountType()
  {
    return getInstance().getmPrefs().getString("ACCOUNT_TYPE", null);
  }

  private InitCompletionListener getCompleteListener()
  {
    return this.listener;
  }

  public static InAuthManager getInstance()
  {
    if (instance == null)
      instance = new InAuthManager();
    return instance;
  }

  private String getLogConfiguration()
  {
    return getInstance().getmPrefs().getString("LOG_CONFIGURATION", null);
  }

  private String getServerURL()
  {
    return getInstance().getmPrefs().getString("SERVER_URL", null);
  }

  private SharedPreferences getmPrefs()
  {
    return this.mPrefs;
  }

  private boolean isAccountTypeSet()
  {
    String str = getInstance().getAccountType();
    boolean bool = false;
    if (str != null)
      bool = true;
    return bool;
  }

  private boolean isLogConfigured()
  {
    String str = getInstance().getLogConfiguration();
    boolean bool = false;
    if (str != null)
      bool = true;
    return bool;
  }

  private boolean isRegistered()
  {
    String str = getInstance().getDeviceGUID();
    boolean bool = false;
    if (str != null)
      bool = true;
    return bool;
  }

  private String register(String paramString1, String paramString2, String paramString3)
  {
    String str1 = "REGISTRATION_FAILURE";
    RegistrationLog localRegistrationLog = new RegistrationLog();
    String str2 = localRegistrationLog.serialize(getInstance().getApp(), paramString2, getInstance().getInAuthDynamicID(), getInstance().getSDKVersion(), getInstance().getInAuthPID(), paramString3);
    if (str2 != null)
    {
      String str3 = localRegistrationLog.send(paramString1, str2);
      if (str3 != null)
      {
        RegistrationResponse localRegistrationResponse = localRegistrationLog.deserialize(str3);
        if ((localRegistrationResponse != null) && ("success".equals(localRegistrationResponse.getStatus())))
        {
          SharedPreferences.Editor localEditor = getInstance().getmPrefs().edit();
          localEditor.putString("SERVER_URL", paramString1);
          localEditor.putString("ACCOUNT_GUID", paramString2);
          localEditor.putString("DEVICE_GUID", localRegistrationResponse.getDeviceGuid());
          localEditor.putString("LOG_CONFIGURATION", localRegistrationResponse.getConfig());
          localEditor.putString("ACCOUNT_TYPE", localRegistrationResponse.getAccountType());
          localEditor.commit();
          str1 = "SUCCESS";
        }
      }
    }
    return str1;
  }

  private String sendDeviceInfoLog(String paramString, boolean paramBoolean)
  {
    String str1 = "INTERNAL_ERROR";
    if ((!InAuthUtilities.isFullMMEAccount(getAccountType())) && (!paramBoolean))
      str1 = "INVALID_ACCESS";
    String str2;
    do
    {
      return str1;
      if (!InAuthUtilities.isLogFlagEnabled(getInstance().getLogConfiguration(), "device_info_logs"))
        return "LOG_CONFIGURATION_OFF";
      if (!InAuthUtilities.isConnected())
        break;
      str2 = new DeviceInfoLog().serialize(getInstance().getApp(), getInstance().getDeviceGUID(), getInstance().getAccountGUID(), paramString);
    }
    while (str2 == null);
    UploadFile.getInstance().sendLog(str2, getInstance().getServerURL() + "/v1/devices/logs");
    return "SUCCESS";
    return "NO_NETWORK_CONNECTION";
  }

  private String sendGPSLog(String paramString, boolean paramBoolean)
  {
    String str1 = "INTERNAL_ERROR";
    if ((!InAuthUtilities.isFullMMEAccount(getAccountType())) && (!paramBoolean))
      str1 = "INVALID_ACCESS";
    String str2;
    do
    {
      return str1;
      if (!InAuthUtilities.checkLogPermissions("gps_location_logs"))
        return "PERMISSIONS_MISSING";
      if (!InAuthUtilities.isLogFlagEnabled(getInstance().getLogConfiguration(), "gps_location_logs"))
        return "LOG_CONFIGURATION_OFF";
      if (!InAuthUtilities.isConnected())
        break;
      str2 = new GPSLocationLog().serialize(getInstance().getApp(), getInstance().getDeviceGUID(), getInstance().getAccountGUID(), paramString);
    }
    while (str2 == null);
    UploadFile.getInstance().sendLog(str2, getInstance().getServerURL() + "/v1/devices/logs");
    return "SUCCESS";
    return "NO_NETWORK_CONNECTION";
  }

  private String sendTelephonyInfoLog(String paramString, boolean paramBoolean)
  {
    String str1 = "INTERNAL_ERROR";
    if ((!InAuthUtilities.isFullMMEAccount(getAccountType())) && (!paramBoolean))
      str1 = "INVALID_ACCESS";
    String str2;
    do
    {
      return str1;
      if (!InAuthUtilities.checkLogPermissions("telephony_info_logs"))
        return "PERMISSIONS_MISSING";
      if (!InAuthUtilities.isLogFlagEnabled(getInstance().getLogConfiguration(), "telephony_info_logs"))
        return "LOG_CONFIGURATION_OFF";
      if (!InAuthUtilities.isConnected())
        break;
      str2 = new TelephonyInfoLog().serialize(getInstance().getApp(), getInstance().getDeviceGUID(), getInstance().getAccountGUID(), paramString);
    }
    while (str2 == null);
    UploadFile.getInstance().sendLog(str2, getInstance().getServerURL() + "/v1/devices/logs");
    return "SUCCESS";
    return "NO_NETWORK_CONNECTION";
  }

  private void setCompleteListener(InitCompletionListener paramInitCompletionListener)
  {
    this.listener = paramInitCompletionListener;
  }

  private void setmPrefs(SharedPreferences paramSharedPreferences)
  {
    this.mPrefs = paramSharedPreferences;
  }

  private String updateLogConfig(String paramString1, String paramString2)
  {
    String str1 = "LOG_CONFIG_FAILURE";
    ConfigurationLog localConfigurationLog = new ConfigurationLog();
    String str2 = localConfigurationLog.serialize(paramString2, getInstance().getDeviceGUID(), getInstance().getInAuthDynamicID(), getInstance().getSDKVersion());
    if (str2 != null)
    {
      String str3 = localConfigurationLog.send(paramString1, str2);
      if (str3 != null)
      {
        LogConfigResponse localLogConfigResponse = localConfigurationLog.deserialize(str3);
        if (localLogConfigResponse != null)
        {
          SharedPreferences.Editor localEditor = getInstance().getmPrefs().edit();
          localEditor.putString("LOG_CONFIGURATION", localLogConfigResponse.getConfig());
          localEditor.putString("ACCOUNT_TYPE", localLogConfigResponse.getAccountType());
          localEditor.commit();
          str1 = "SUCCESS";
        }
      }
    }
    return str1;
  }

  public String checkActiveNetworkDataConnection()
  {
    return InAuthUtilities.checkActiveNetworkDataConnection(getInstance().getApp());
  }

  public Application getApp()
  {
    return this.app;
  }

  public String getDeviceGUID()
  {
    return getInstance().getmPrefs().getString("DEVICE_GUID", null);
  }

  public String getInAuthDynamicID()
  {
    return new InAuthDynamicID().getDynamicID();
  }

  public String getInAuthPID()
  {
    InAuthPID.getInstance().init(getInstance().getApp());
    return InAuthPID.getInstance().getInAuthPID();
  }

  public MalwareLog getMalwareDetectionLog(String paramString)
  {
    return getMalwareDetectionLog(paramString, "");
  }

  public MalwareLog getMalwareDetectionLog(String paramString1, String paramString2)
  {
    MalwareInfoLog localMalwareInfoLog = new MalwareInfoLog();
    MalwareLog localMalwareLog = localMalwareInfoLog.getMalwareLog(paramString1);
    if ((InAuthUtilities.isConnected()) && (InAuthUtilities.isLogFlagEnabled(getInstance().getLogConfiguration(), "malware_info_logs")))
    {
      String str = localMalwareInfoLog.serialize(localMalwareLog, paramString1, getInstance().getDeviceGUID(), getInstance().getAccountGUID(), paramString2);
      if (str != null)
        UploadFile.getInstance().sendLog(str, getInstance().getServerURL() + "/v1/devices/logs");
    }
    return localMalwareLog;
  }

  public String getMalwareSDKVersion()
  {
    return new MalwareInfoLog().getMalwareSDKVersion();
  }

  public String getMalwareSigfileVersion(String paramString)
  {
    return new MalwareInfoLog().getMalwareSigfileVersion(paramString);
  }

  public RootLog getRootDetectionLog(String paramString, boolean paramBoolean)
  {
    return getRootDetectionLog(paramString, paramBoolean, "");
  }

  public RootLog getRootDetectionLog(String paramString1, boolean paramBoolean, String paramString2)
  {
    RootCheckLog localRootCheckLog = new RootCheckLog();
    RootLog localRootLog = localRootCheckLog.getRootLog(paramString1, paramBoolean);
    if ((InAuthUtilities.isConnected()) && (InAuthUtilities.isLogFlagEnabled(getInstance().getLogConfiguration(), "root_check_logs")))
    {
      String str = localRootCheckLog.serialize(localRootLog, paramString1, getInstance().getDeviceGUID(), getInstance().getAccountGUID(), paramString2);
      if (str != null)
        UploadFile.getInstance().sendLog(str, getInstance().getServerURL() + "/v1/devices/logs");
    }
    return localRootLog;
  }

  public String getRootSDKVersion()
  {
    return new RootCheckLog().getRootSDKVersion();
  }

  public String getRootSigfileVersion(String paramString)
  {
    return new RootCheckLog().getRootSigfileVersion(paramString);
  }

  public String getSDKVersion()
  {
    return "Android-MME-5.2.3";
  }

  // ERROR //
  public boolean hasHeartbleedVulnerability()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: new 334	java/io/File
    //   5: dup
    //   6: ldc_w 336
    //   9: invokespecial 339	java/io/File:<init>	(Ljava/lang/String;)V
    //   12: astore_2
    //   13: aload_2
    //   14: invokevirtual 342	java/io/File:exists	()Z
    //   17: istore_3
    //   18: iconst_0
    //   19: istore 4
    //   21: iconst_0
    //   22: istore 5
    //   24: iconst_0
    //   25: istore 6
    //   27: iload_3
    //   28: ifeq +169 -> 197
    //   31: aconst_null
    //   32: astore 9
    //   34: new 344	java/io/FileInputStream
    //   37: dup
    //   38: aload_2
    //   39: invokespecial 347	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   42: astore 10
    //   44: sipush 1024
    //   47: newarray byte
    //   49: astore 17
    //   51: iconst_m1
    //   52: aload 10
    //   54: aload 17
    //   56: invokevirtual 351	java/io/FileInputStream:read	([B)I
    //   59: if_icmpeq +122 -> 181
    //   62: iload_1
    //   63: ifne +118 -> 181
    //   66: aload 10
    //   68: aload 17
    //   70: invokevirtual 351	java/io/FileInputStream:read	([B)I
    //   73: istore 18
    //   75: iload 18
    //   77: ifle -26 -> 51
    //   80: new 138	java/lang/String
    //   83: dup
    //   84: aload 17
    //   86: iconst_0
    //   87: iload 18
    //   89: invokespecial 354	java/lang/String:<init>	([BII)V
    //   92: astore 19
    //   94: aload 19
    //   96: ldc_w 356
    //   99: invokevirtual 360	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   102: ifeq +58 -> 160
    //   105: aload 19
    //   107: aload 19
    //   109: ldc_w 356
    //   112: invokevirtual 364	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   115: bipush 14
    //   117: aload 19
    //   119: ldc_w 356
    //   122: invokevirtual 364	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   125: iadd
    //   126: invokevirtual 368	java/lang/String:substring	(II)Ljava/lang/String;
    //   129: astore 21
    //   131: aload 21
    //   133: ldc_w 370
    //   136: invokevirtual 360	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   139: ifeq +5 -> 144
    //   142: iconst_1
    //   143: istore_1
    //   144: aload 21
    //   146: ldc_w 372
    //   149: invokevirtual 360	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   152: ifeq -101 -> 51
    //   155: iconst_0
    //   156: istore_1
    //   157: goto -106 -> 51
    //   160: aload 19
    //   162: ldc_w 374
    //   165: invokevirtual 360	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   168: istore 20
    //   170: iload 20
    //   172: ifeq -121 -> 51
    //   175: iinc 6 1
    //   178: goto -127 -> 51
    //   181: iconst_0
    //   182: istore 4
    //   184: iconst_0
    //   185: istore 5
    //   187: aload 10
    //   189: ifnull +8 -> 197
    //   192: aload 10
    //   194: invokevirtual 377	java/io/FileInputStream:close	()V
    //   197: iload 6
    //   199: istore 7
    //   201: iconst_0
    //   202: istore 8
    //   204: iload 7
    //   206: iconst_2
    //   207: if_icmple +6 -> 213
    //   210: iconst_1
    //   211: istore 8
    //   213: iload 4
    //   215: ifne +8 -> 223
    //   218: iload 5
    //   220: ifeq +33 -> 253
    //   223: iload 4
    //   225: ifeq +8 -> 233
    //   228: iload 5
    //   230: ifne +3 -> 233
    //   233: iload 5
    //   235: ifeq +8 -> 243
    //   238: iload 4
    //   240: ifne +3 -> 243
    //   243: iload 4
    //   245: ifeq +8 -> 253
    //   248: iload 5
    //   250: ifeq +3 -> 253
    //   253: iload 8
    //   255: ireturn
    //   256: astore 22
    //   258: iconst_1
    //   259: istore 5
    //   261: iconst_0
    //   262: istore 4
    //   264: goto -67 -> 197
    //   267: astore 24
    //   269: iconst_1
    //   270: istore 4
    //   272: iconst_0
    //   273: istore 5
    //   275: aload 9
    //   277: ifnull -80 -> 197
    //   280: aload 9
    //   282: invokevirtual 377	java/io/FileInputStream:close	()V
    //   285: iconst_0
    //   286: istore 5
    //   288: goto -91 -> 197
    //   291: astore 12
    //   293: iconst_1
    //   294: istore 5
    //   296: goto -99 -> 197
    //   299: astore 23
    //   301: iconst_1
    //   302: istore 5
    //   304: iconst_0
    //   305: istore 4
    //   307: aload 9
    //   309: ifnull -112 -> 197
    //   312: aload 9
    //   314: invokevirtual 377	java/io/FileInputStream:close	()V
    //   317: iconst_0
    //   318: istore 4
    //   320: goto -123 -> 197
    //   323: astore 14
    //   325: iconst_1
    //   326: istore 5
    //   328: iconst_0
    //   329: istore 4
    //   331: goto -134 -> 197
    //   334: astore 15
    //   336: aload 9
    //   338: ifnull +8 -> 346
    //   341: aload 9
    //   343: invokevirtual 377	java/io/FileInputStream:close	()V
    //   346: aload 15
    //   348: athrow
    //   349: astore 16
    //   351: goto -5 -> 346
    //   354: astore 15
    //   356: aload 10
    //   358: astore 9
    //   360: goto -24 -> 336
    //   363: astore 13
    //   365: aload 10
    //   367: astore 9
    //   369: goto -68 -> 301
    //   372: astore 11
    //   374: aload 10
    //   376: astore 9
    //   378: goto -109 -> 269
    //
    // Exception table:
    //   from	to	target	type
    //   192	197	256	java/io/IOException
    //   34	44	267	java/io/FileNotFoundException
    //   280	285	291	java/io/IOException
    //   34	44	299	java/io/IOException
    //   312	317	323	java/io/IOException
    //   34	44	334	finally
    //   341	346	349	java/io/IOException
    //   44	51	354	finally
    //   51	62	354	finally
    //   66	75	354	finally
    //   80	142	354	finally
    //   144	155	354	finally
    //   160	170	354	finally
    //   44	51	363	java/io/IOException
    //   51	62	363	java/io/IOException
    //   66	75	363	java/io/IOException
    //   80	142	363	java/io/IOException
    //   144	155	363	java/io/IOException
    //   160	170	363	java/io/IOException
    //   44	51	372	java/io/FileNotFoundException
    //   51	62	372	java/io/FileNotFoundException
    //   66	75	372	java/io/FileNotFoundException
    //   80	142	372	java/io/FileNotFoundException
    //   144	155	372	java/io/FileNotFoundException
    //   160	170	372	java/io/FileNotFoundException
  }

  public void init(Application paramApplication, String paramString1, String paramString2)
  {
    getInstance().init(paramApplication, paramString1, paramString2, "");
  }

  public void init(Application paramApplication, String paramString1, String paramString2, InitCompletionListener paramInitCompletionListener)
  {
    getInstance().setCompleteListener(paramInitCompletionListener);
    getInstance().init(paramApplication, paramString1, paramString2, "");
  }

  public void init(Application paramApplication, String paramString1, String paramString2, final String paramString3)
  {
    getInstance().setApp(paramApplication);
    setmPrefs(PreferenceManager.getDefaultSharedPreferences(paramApplication));
    if (paramString1 == null)
      paramString1 = "";
    if (paramString2 == null)
      paramString2 = "";
    final String str1 = paramString1;
    final String str2 = paramString2;
    if (("".equals(str1)) && ("".equals(str2)))
    {
      if (getInstance().getCompleteListener() != null)
        getInstance().getCompleteListener().onInitComplete("INITIALIZED_OFFLINE");
      return;
    }
    Executors.newSingleThreadExecutor().execute(new Runnable()
    {
      public void run()
      {
        try
        {
          if (!InAuthUtilities.hasActiveInternetConnection(str1))
          {
            if (InAuthManager.getInstance().getCompleteListener() != null)
              InAuthManager.getInstance().getCompleteListener().onInitComplete("NO_NETWORK_CONNECTION");
          }
          else if (!InAuthUtilities.checkLogPermissions("registration_logs"))
          {
            if (InAuthManager.getInstance().getCompleteListener() == null)
              return;
            InAuthManager.getInstance().getCompleteListener().onInitComplete("PERMISSIONS_MISSING");
          }
        }
        catch (Exception localException)
        {
          if (InAuthManager.getInstance().getCompleteListener() != null)
          {
            InAuthManager.getInstance().getCompleteListener().onInitComplete("INTERNAL_ERROR");
            return;
            String str1 = "REGISTRATION_FAILURE";
            String str2 = "LOG_CONFIG_FAILURE";
            if (!InAuthManager.getInstance().isRegistered())
              str1 = InAuthManager.getInstance().register(str1, str2, paramString3);
            while ((InAuthManager.getInstance().getCompleteListener() != null) && (InAuthManager.this.listener != null))
              if ("SUCCESS".equals(str1))
              {
                if (InAuthManager.getInstance().isRegistered())
                {
                  InAuthManager.getInstance().getCompleteListener().onInitComplete("SUCCESS");
                  return;
                  str2 = InAuthManager.getInstance().updateLogConfig(str1, str2);
                }
              }
              else if ("SUCCESS".equals(str2))
              {
                if (InAuthManager.getInstance().isLogConfigured())
                  InAuthManager.getInstance().getCompleteListener().onInitComplete("SUCCESS");
              }
              else
              {
                if ((InAuthManager.getInstance().isRegistered()) && ("LOG_CONFIG_FAILURE".equals(str2)))
                {
                  InAuthManager.getInstance().getCompleteListener().onInitComplete("LOG_CONFIG_FAILURE");
                  return;
                }
                InAuthManager.getInstance().getCompleteListener().onInitComplete("REGISTRATION_FAILURE");
              }
          }
        }
      }
    });
  }

  public void init(Application paramApplication, String paramString1, String paramString2, String paramString3, InitCompletionListener paramInitCompletionListener)
  {
    getInstance().setCompleteListener(paramInitCompletionListener);
    getInstance().init(paramApplication, paramString1, paramString2, paramString3);
  }

  public void initOffline(Application paramApplication, InitCompletionListener paramInitCompletionListener)
  {
    getInstance().init(paramApplication, "", "", paramInitCompletionListener);
  }

  public boolean isDebuggerConnected()
  {
    return InAuthUtilities.isDebuggerConnected();
  }

  public boolean isInitialized()
  {
    return (getInstance().getApp() != null) && (getInstance().getmPrefs() != null) && (isRegistered()) && (isLogConfigured()) && (isAccountTypeSet());
  }

  public boolean isInitializedOffline()
  {
    if (getInstance().isInitialized());
    while ((getInstance().getApp() == null) || (getInstance().getmPrefs() == null))
      return false;
    return true;
  }

  public boolean isUSBDebuggerConnected()
  {
    return InAuthUtilities.isUSBDebuggerConnected(getInstance().getApp());
  }

  public String sendAccountsLog()
  {
    return sendAccountsLog("");
  }

  public String sendAccountsLog(String paramString)
  {
    String str1 = "INTERNAL_ERROR";
    if (!InAuthUtilities.isFullMMEAccount(getAccountType()))
      str1 = "INVALID_ACCESS";
    String str2;
    do
    {
      return str1;
      if (!InAuthUtilities.checkLogPermissions("android_accounts_logs"))
        return "PERMISSIONS_MISSING";
      if (!InAuthUtilities.isLogFlagEnabled(getInstance().getLogConfiguration(), "android_accounts_logs"))
        return "LOG_CONFIGURATION_OFF";
      if (!InAuthUtilities.isConnected())
        break;
      str2 = new AndroidAccountsLog().serialize(getInstance().getApp(), getInstance().getDeviceGUID(), getInstance().getAccountGUID(), paramString);
    }
    while (str2 == null);
    UploadFile.getInstance().sendLog(str2, getInstance().getServerURL() + "/v1/devices/logs");
    return "SUCCESS";
    return "NO_NETWORK_CONNECTION";
  }

  public void sendAllLogs()
  {
    sendAllLogs("");
  }

  public void sendAllLogs(final String paramString)
  {
    final String str1 = getInstance().getServerURL();
    final String str2 = getInstance().getAccountGUID();
    if ((InAuthUtilities.isConnected()) && (getInstance().isInitialized()))
      Executors.newSingleThreadExecutor().execute(new Runnable()
      {
        public void run()
        {
          Looper.prepare();
          InAuthManager.getInstance().updateLogConfig(str1, str2);
          InAuthManager.getInstance().sendAccountsLog(paramString);
          InAuthManager.getInstance().sendAppActivityLog(paramString);
          InAuthManager.getInstance().sendAppDataUsageLog(paramString);
          InAuthManager.getInstance().sendAppInstallLog(paramString);
          InAuthManager.getInstance().sendBatteryLog(paramString);
          InAuthManager.getInstance().sendDeviceInfoLog(paramString, true);
          InAuthManager.getInstance().sendGPSLog(paramString, true);
          InAuthManager.getInstance().sendMMSLog(paramString);
          InAuthManager.getInstance().sendNetDataLog(paramString);
          InAuthManager.getInstance().sendPhoneCallLog(paramString);
          InAuthManager.getInstance().sendSMSLog(paramString);
          InAuthManager.getInstance().sendTelephonyInfoLog(paramString, true);
          InAuthManager.getInstance().sendWifiConnectionLog(paramString);
          InAuthManager.getInstance().sendWifiNeighborsLog(paramString);
        }
      });
  }

  public String sendAppActivityLog()
  {
    return sendAppActivityLog("");
  }

  public String sendAppActivityLog(String paramString)
  {
    String str1 = "INTERNAL_ERROR";
    if (!InAuthUtilities.isFullMMEAccount(getAccountType()))
      str1 = "INVALID_ACCESS";
    String str2;
    do
    {
      return str1;
      if (!InAuthUtilities.checkLogPermissions("app_activity_history_logs"))
        return "PERMISSIONS_MISSING";
      if (!InAuthUtilities.isLogFlagEnabled(getInstance().getLogConfiguration(), "app_activity_history_logs"))
        return "LOG_CONFIGURATION_OFF";
      if (!InAuthUtilities.isConnected())
        break;
      str2 = new AppActivityHistoryLog().serialize(getInstance().getApp(), getInstance().getDeviceGUID(), getInstance().getAccountGUID(), paramString);
    }
    while (str2 == null);
    UploadFile.getInstance().sendLog(str2, getInstance().getServerURL() + "/v1/devices/logs");
    return "SUCCESS";
    return "NO_NETWORK_CONNECTION";
  }

  public String sendAppDataUsageLog()
  {
    return sendAppDataUsageLog("");
  }

  public String sendAppDataUsageLog(String paramString)
  {
    String str1 = "INTERNAL_ERROR";
    if (!InAuthUtilities.isFullMMEAccount(getAccountType()))
      str1 = "INVALID_ACCESS";
    String str2;
    do
    {
      return str1;
      if (!InAuthUtilities.checkLogPermissions("app_data_usage_logs"))
        return "PERMISSIONS_MISSING";
      if (!InAuthUtilities.isLogFlagEnabled(getInstance().getLogConfiguration(), "app_data_usage_logs"))
        return "LOG_CONFIGURATION_OFF";
      if (!InAuthUtilities.isConnected())
        break;
      str2 = new AppDataUsageLog().serialize(getInstance().getApp(), getInstance().getDeviceGUID(), getInstance().getAccountGUID(), paramString);
    }
    while (str2 == null);
    UploadFile.getInstance().sendLog(str2, getInstance().getServerURL() + "/v1/devices/logs");
    return "SUCCESS";
    return "NO_NETWORK_CONNECTION";
  }

  public String sendAppInstallLog()
  {
    return sendAppInstallLog("");
  }

  public String sendAppInstallLog(String paramString)
  {
    String str1 = "INTERNAL_ERROR";
    if (!InAuthUtilities.isFullMMEAccount(getAccountType()))
      str1 = "INVALID_ACCESS";
    String str2;
    do
    {
      return str1;
      if (!InAuthUtilities.isLogFlagEnabled(getInstance().getLogConfiguration(), "app_installs_logs"))
        return "LOG_CONFIGURATION_OFF";
      if (!InAuthUtilities.isConnected())
        break;
      str2 = new AppInstallLog().serialize(getInstance().getApp(), getInstance().getDeviceGUID(), getInstance().getAccountGUID(), paramString);
    }
    while (str2 == null);
    UploadFile.getInstance().sendLog(str2, getInstance().getServerURL() + "/v1/devices/logs");
    return "SUCCESS";
    return "NO_NETWORK_CONNECTION";
  }

  public String sendBatteryLog()
  {
    return sendBatteryLog("");
  }

  public String sendBatteryLog(String paramString)
  {
    String str1 = "INTERNAL_ERROR";
    if (!InAuthUtilities.isFullMMEAccount(getAccountType()))
      str1 = "INVALID_ACCESS";
    String str2;
    do
    {
      return str1;
      if (!InAuthUtilities.isLogFlagEnabled(getInstance().getLogConfiguration(), "battery_info_logs"))
        return "LOG_CONFIGURATION_OFF";
      if (!InAuthUtilities.isConnected())
        break;
      str2 = new BatteryInfoLog().serialize(getInstance().getApp(), getInstance().getDeviceGUID(), getInstance().getAccountGUID(), paramString);
    }
    while (str2 == null);
    UploadFile.getInstance().sendLog(str2, getInstance().getServerURL() + "/v1/devices/logs");
    return "SUCCESS";
    return "NO_NETWORK_CONNECTION";
  }

  public String sendCustomLog(Map<String, String> paramMap)
  {
    String str1 = "INTERNAL_ERROR";
    if (!InAuthUtilities.isFullMMEAccount(getAccountType()))
      str1 = "INVALID_ACCESS";
    String str2;
    do
    {
      return str1;
      if (!InAuthUtilities.isConnected())
        break;
      str2 = new CustomInfoLog().serialize(paramMap, getInstance().getDeviceGUID(), getInstance().getAccountGUID());
    }
    while (str2 == null);
    UploadFile.getInstance().sendLog(str2, getInstance().getServerURL() + "/v1/devices/events");
    return "SUCCESS";
    return "NO_NETWORK_CONNECTION";
  }

  public String sendDeviceInfoLog()
  {
    return sendDeviceInfoLog("", false);
  }

  public String sendDeviceInfoLog(String paramString)
  {
    return sendDeviceInfoLog(paramString, false);
  }

  public String sendGPSLog()
  {
    return sendGPSLog("", false);
  }

  public String sendGPSLog(String paramString)
  {
    return sendGPSLog(paramString, false);
  }

  public String sendMMSLog()
  {
    return sendMMSLog("");
  }

  public String sendMMSLog(String paramString)
  {
    String str1 = "INTERNAL_ERROR";
    if (!InAuthUtilities.isFullMMEAccount(getAccountType()))
      str1 = "INVALID_ACCESS";
    String str3;
    do
    {
      return str1;
      if (!InAuthUtilities.checkLogPermissions("mms_logs"))
        return "PERMISSIONS_MISSING";
      if (!InAuthUtilities.isLogFlagEnabled(getInstance().getLogConfiguration(), "mms_logs"))
        return "LOG_CONFIGURATION_OFF";
      if (!InAuthUtilities.isConnected())
        break;
      MMSLog localMMSLog = new MMSLog();
      String str2 = localMMSLog.serializeIncoming(getInstance().getApp(), getInstance().getDeviceGUID(), getInstance().getAccountGUID(), paramString);
      str3 = localMMSLog.serializeOutgoing(getInstance().getApp(), getInstance().getDeviceGUID(), getInstance().getAccountGUID(), paramString);
      if (str2 != null)
      {
        UploadFile.getInstance().sendLog(str2, getInstance().getServerURL() + "/v1/devices/logs");
        str1 = "SUCCESS";
      }
    }
    while (str3 == null);
    UploadFile.getInstance().sendLog(str3, getInstance().getServerURL() + "/v1/devices/logs");
    return "SUCCESS";
    return "NO_NETWORK_CONNECTION";
  }

  public String sendNetDataLog()
  {
    return sendNetDataLog("");
  }

  public String sendNetDataLog(String paramString)
  {
    String str1 = "INTERNAL_ERROR";
    if (!InAuthUtilities.isFullMMEAccount(getAccountType()))
      str1 = "INVALID_ACCESS";
    String str2;
    do
    {
      return str1;
      if (!InAuthUtilities.isLogFlagEnabled(getInstance().getLogConfiguration(), "net_data_usage_logs"))
        return "LOG_CONFIGURATION_OFF";
      if (!InAuthUtilities.isConnected())
        break;
      str2 = new NetDataUsageLog().serialize(getInstance().getApp(), getInstance().getDeviceGUID(), getInstance().getAccountGUID(), paramString);
    }
    while (str2 == null);
    UploadFile.getInstance().sendLog(str2, getInstance().getServerURL() + "/v1/devices/logs");
    return "SUCCESS";
    return "NO_NETWORK_CONNECTION";
  }

  public String sendPhoneCallLog()
  {
    return sendPhoneCallLog("");
  }

  public String sendPhoneCallLog(String paramString)
  {
    String str1 = "INTERNAL_ERROR";
    if (!InAuthUtilities.isFullMMEAccount(getAccountType()))
      str1 = "INVALID_ACCESS";
    String str2;
    do
    {
      return str1;
      if (!InAuthUtilities.checkLogPermissions("phone_calls_logs"))
        return "PERMISSIONS_MISSING";
      if (!InAuthUtilities.isLogFlagEnabled(getInstance().getLogConfiguration(), "phone_calls_logs"))
        return "LOG_CONFIGURATION_OFF";
      if (!InAuthUtilities.isConnected())
        break;
      str2 = new PhoneCallLog().serialize(getInstance().getApp(), getInstance().getDeviceGUID(), getInstance().getAccountGUID(), paramString);
    }
    while (str2 == null);
    UploadFile.getInstance().sendLog(str2, getInstance().getServerURL() + "/v1/devices/logs");
    return "SUCCESS";
    return "NO_NETWORK_CONNECTION";
  }

  public String sendSMSLog()
  {
    return sendSMSLog("");
  }

  public String sendSMSLog(String paramString)
  {
    String str1 = "INTERNAL_ERROR";
    if (!InAuthUtilities.isFullMMEAccount(getAccountType()))
      str1 = "INVALID_ACCESS";
    String str2;
    do
    {
      return str1;
      if (!InAuthUtilities.checkLogPermissions("sms_logs"))
        return "PERMISSIONS_MISSING";
      if (!InAuthUtilities.isLogFlagEnabled(getInstance().getLogConfiguration(), "sms_logs"))
        return "LOG_CONFIGURATION_OFF";
      if (!InAuthUtilities.isConnected())
        break;
      str2 = new SMSLog().serialize(getInstance().getApp(), getInstance().getDeviceGUID(), getInstance().getAccountGUID(), paramString);
    }
    while (str2 == null);
    UploadFile.getInstance().sendLog(str2, getInstance().getServerURL() + "/v1/devices/logs");
    return "SUCCESS";
    return "NO_NETWORK_CONNECTION";
  }

  public String sendTelephonyInfoLog()
  {
    return sendTelephonyInfoLog("", false);
  }

  public String sendTelephonyInfoLog(String paramString)
  {
    return sendTelephonyInfoLog(paramString, false);
  }

  public String sendWifiConnectionLog()
  {
    return sendWifiConnectionLog("");
  }

  public String sendWifiConnectionLog(String paramString)
  {
    String str1 = "INTERNAL_ERROR";
    if (!InAuthUtilities.isFullMMEAccount(getAccountType()))
      str1 = "INVALID_ACCESS";
    String str2;
    do
    {
      return str1;
      if (!InAuthUtilities.isLogFlagEnabled(getInstance().getLogConfiguration(), "wifi_connection_logs"))
        return "LOG_CONFIGURATION_OFF";
      if (!InAuthUtilities.isConnected())
        break;
      str2 = new WifiConnectionLog().serialize(getInstance().getApp(), getInstance().getDeviceGUID(), getInstance().getAccountGUID(), paramString);
    }
    while (str2 == null);
    UploadFile.getInstance().sendLog(str2, getInstance().getServerURL() + "/v1/devices/logs");
    return "SUCCESS";
    return "NO_NETWORK_CONNECTION";
  }

  public String sendWifiNeighborsLog()
  {
    return sendWifiNeighborsLog("");
  }

  public String sendWifiNeighborsLog(String paramString)
  {
    String str1 = "INTERNAL_ERROR";
    if (!InAuthUtilities.isFullMMEAccount(getAccountType()))
      str1 = "INVALID_ACCESS";
    String str2;
    do
    {
      return str1;
      if (!InAuthUtilities.checkLogPermissions("wifi_neighbor_logs"))
        return "PERMISSIONS_MISSING";
      if (!InAuthUtilities.isLogFlagEnabled(getInstance().getLogConfiguration(), "wifi_neighbor_logs"))
        return "LOG_CONFIGURATION_OFF";
      if (!InAuthUtilities.isConnected())
        break;
      str2 = new WifiNeighborLog().serialize(getInstance().getApp(), getInstance().getDeviceGUID(), getInstance().getAccountGUID(), paramString);
    }
    while (str2 == null);
    UploadFile.getInstance().sendLog(str2, getInstance().getServerURL() + "/v1/devices/logs");
    return "SUCCESS";
    return "NO_NETWORK_CONNECTION";
  }

  protected void setApp(Application paramApplication)
  {
    this.app = paramApplication;
  }

  public String updateMalwareSigfile(String paramString)
  {
    return InAuthMalware.getInstance().updateSignatureFile(paramString, getInstance().getAccountGUID(), getInstance().getServerURL());
  }

  public String updateRootSigfile(String paramString)
  {
    return InAuthRoot.getInstance().updateSignatureFile(paramString, getInstance().getAccountGUID(), getInstance().getServerURL());
  }

  public static abstract interface InitCompletionListener
  {
    public abstract void onInitComplete(String paramString);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.inauth.mme.InAuthManager
 * JD-Core Version:    0.6.2
 */