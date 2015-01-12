package com.adjust.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.preference.PreferenceManager;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ActivityHandler extends HandlerThread
{
  private static final String ADJUST_PREFIX = "adjust_";
  private static long SESSION_INTERVAL = 0L;
  private static long SUBSESSION_INTERVAL = 0L;
  private static long TIMER_INTERVAL = 0L;
  private static final String TIME_TRAVEL = "Time travel!";
  private static ScheduledExecutorService timer;
  private ActivityState activityState;
  private String androidId;
  private String appToken;
  private String clientSdk;
  private Context context;
  private String defaultTracker;
  private boolean dropOfflineActivities;
  private boolean enabled;
  private String environment;
  private boolean eventBuffering;
  private String fbAttributionId;
  private Logger logger;
  private String macSha1;
  private String macShortMd5;
  private OnFinishedListener onFinishedListener;
  private IPackageHandler packageHandler;
  private SessionHandler sessionHandler;
  private String userAgent;

  public ActivityHandler(Activity paramActivity)
  {
    super("Adjust", 1);
    initActivityHandler(paramActivity);
    Message localMessage = Message.obtain();
    localMessage.arg1 = 72630;
    this.sessionHandler.sendMessage(localMessage);
  }

  public ActivityHandler(Activity paramActivity, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    super("Adjust", 1);
    initActivityHandler(paramActivity);
    this.appToken = paramString1;
    this.environment = paramString2;
    this.eventBuffering = paramBoolean;
    this.logger.setLogLevelString(paramString3);
    Message localMessage = Message.obtain();
    localMessage.arg1 = 72633;
    this.sessionHandler.sendMessage(localMessage);
  }

  private boolean canInit()
  {
    return (checkAppTokenNotNull(this.appToken)) && (checkAppTokenLength(this.appToken)) && (checkContext(this.context)) && (checkPermissions(this.context));
  }

  private boolean canTrackEvent(PackageBuilder paramPackageBuilder)
  {
    return (checkAppTokenNotNull(this.appToken)) && (checkActivityState(this.activityState)) && (paramPackageBuilder.isValidForEvent());
  }

  private boolean canTrackRevenue(PackageBuilder paramPackageBuilder)
  {
    return (checkAppTokenNotNull(this.appToken)) && (checkActivityState(this.activityState)) && (paramPackageBuilder.isValidForRevenue());
  }

  private boolean checkActivityState(ActivityState paramActivityState)
  {
    if (paramActivityState == null)
    {
      this.logger.error("Missing activity state.");
      return false;
    }
    return true;
  }

  private boolean checkAppTokenLength(String paramString)
  {
    if (12 != paramString.length())
    {
      this.logger.error(String.format("Malformed App Token '%s'", new Object[] { paramString }));
      return false;
    }
    return true;
  }

  private boolean checkAppTokenNotNull(String paramString)
  {
    if (paramString == null)
    {
      this.logger.error("Missing App Token.");
      return false;
    }
    return true;
  }

  private boolean checkContext(Context paramContext)
  {
    if (paramContext == null)
    {
      this.logger.error("Missing context");
      return false;
    }
    return true;
  }

  private static boolean checkPermission(Context paramContext, String paramString)
  {
    return paramContext.checkCallingOrSelfPermission(paramString) == 0;
  }

  private boolean checkPermissions(Context paramContext)
  {
    boolean bool = true;
    if (!checkPermission(paramContext, "android.permission.INTERNET"))
    {
      this.logger.error("Missing permission: INTERNET");
      bool = false;
    }
    if (!checkPermission(paramContext, "android.permission.ACCESS_WIFI_STATE"))
      this.logger.warn("Missing permission: ACCESS_WIFI_STATE");
    return bool;
  }

  public static Boolean deleteActivityState(Context paramContext)
  {
    return Boolean.valueOf(paramContext.deleteFile("AdjustIoActivityState"));
  }

  private void endInternal()
  {
    if (!checkAppTokenNotNull(this.appToken))
      return;
    this.packageHandler.pauseSending();
    stopTimer();
    updateActivityState(System.currentTimeMillis());
    writeActivityState();
  }

  private Bundle getApplicationBundle()
  {
    try
    {
      String str = this.context.getPackageName();
      Bundle localBundle = this.context.getPackageManager().getApplicationInfo(str, 128).metaData;
      return localBundle;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      this.logger.error("ApplicationInfo not found");
      return null;
    }
    catch (Exception localException)
    {
      while (true)
        this.logger.error(String.format("Failed to get ApplicationBundle (%s)", new Object[] { localException }));
    }
  }

  private void initActivityHandler(Activity paramActivity)
  {
    setDaemon(true);
    start();
    TIMER_INTERVAL = AdjustFactory.getTimerInterval();
    SESSION_INTERVAL = AdjustFactory.getSessionInterval();
    SUBSESSION_INTERVAL = AdjustFactory.getSubsessionInterval();
    this.sessionHandler = new SessionHandler(getLooper(), this);
    this.context = paramActivity.getApplicationContext();
    this.clientSdk = "android3.3.4";
    this.enabled = true;
    this.logger = AdjustFactory.getLogger();
  }

  private void initInternal(boolean paramBoolean)
  {
    if (paramBoolean)
      processApplicationBundle();
    while (!canInit())
    {
      return;
      setEnvironment(this.environment);
      setEventBuffering(this.eventBuffering);
    }
    String str1 = Util.getMacAddress(this.context);
    String str2 = str1.replaceAll(":", "");
    this.macSha1 = Util.sha1(str1);
    this.macShortMd5 = Util.md5(str2);
    this.androidId = Util.getAndroidId(this.context);
    this.fbAttributionId = Util.getAttributionId(this.context);
    this.userAgent = Util.getUserAgent(this.context);
    if (Util.getGpsAdid(this.context) == null)
      this.logger.info("Unable to get Google Play Services Advertising ID at start time");
    this.packageHandler = AdjustFactory.getPackageHandler(this, this.context, this.dropOfflineActivities);
    readActivityState();
  }

  private void injectGeneralAttributes(PackageBuilder paramPackageBuilder)
  {
    paramPackageBuilder.setAppToken(this.appToken);
    paramPackageBuilder.setMacShortMd5(this.macShortMd5);
    paramPackageBuilder.setMacSha1(this.macSha1);
    paramPackageBuilder.setAndroidId(this.androidId);
    paramPackageBuilder.setFbAttributionId(this.fbAttributionId);
    paramPackageBuilder.setUserAgent(this.userAgent);
    paramPackageBuilder.setClientSdk(this.clientSdk);
    paramPackageBuilder.setEnvironment(this.environment);
    paramPackageBuilder.setDefaultTracker(this.defaultTracker);
  }

  private void injectReferrer(PackageBuilder paramPackageBuilder)
  {
    try
    {
      paramPackageBuilder.setReferrer(PreferenceManager.getDefaultSharedPreferences(this.context).getString("AdjustInstallReferrer", null));
      return;
    }
    catch (Exception localException)
    {
      this.logger.error(String.format("Failed to inject referrer (%s)", new Object[] { localException }));
    }
  }

  private void processApplicationBundle()
  {
    Bundle localBundle = getApplicationBundle();
    if (localBundle == null)
      return;
    this.appToken = localBundle.getString("AdjustAppToken");
    setEnvironment(localBundle.getString("AdjustEnvironment"));
    setDefaultTracker(localBundle.getString("AdjustDefaultTracker"));
    setEventBuffering(localBundle.getBoolean("AdjustEventBuffering"));
    this.logger.setLogLevelString(localBundle.getString("AdjustLogLevel"));
    setDropOfflineActivities(localBundle.getBoolean("AdjustDropOfflineActivities"));
  }

  // ERROR //
  private void readActivityState()
  {
    // Byte code:
    //   0: new 472	java/io/ObjectInputStream
    //   3: dup
    //   4: new 474	java/io/BufferedInputStream
    //   7: dup
    //   8: aload_0
    //   9: getfield 140	com/adjust/sdk/ActivityHandler:context	Landroid/content/Context;
    //   12: ldc 212
    //   14: invokevirtual 478	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   17: invokespecial 481	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   20: invokespecial 482	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   23: astore_1
    //   24: aload_0
    //   25: aload_1
    //   26: invokevirtual 486	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   29: checkcast 488	com/adjust/sdk/ActivityState
    //   32: putfield 151	com/adjust/sdk/ActivityHandler:activityState	Lcom/adjust/sdk/ActivityState;
    //   35: aload_0
    //   36: getfield 82	com/adjust/sdk/ActivityHandler:logger	Lcom/adjust/sdk/Logger;
    //   39: astore 9
    //   41: iconst_2
    //   42: anewarray 179	java/lang/Object
    //   45: astore 10
    //   47: aload 10
    //   49: iconst_0
    //   50: aload_0
    //   51: getfield 151	com/adjust/sdk/ActivityHandler:activityState	Lcom/adjust/sdk/ActivityState;
    //   54: aastore
    //   55: aload 10
    //   57: iconst_1
    //   58: aload_0
    //   59: getfield 151	com/adjust/sdk/ActivityHandler:activityState	Lcom/adjust/sdk/ActivityState;
    //   62: getfield 491	com/adjust/sdk/ActivityState:uuid	Ljava/lang/String;
    //   65: aastore
    //   66: aload 9
    //   68: ldc_w 493
    //   71: aload 10
    //   73: invokestatic 183	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   76: invokeinterface 496 2 0
    //   81: aload_1
    //   82: invokevirtual 499	java/io/ObjectInputStream:close	()V
    //   85: return
    //   86: astore 8
    //   88: aload_0
    //   89: getfield 82	com/adjust/sdk/ActivityHandler:logger	Lcom/adjust/sdk/Logger;
    //   92: ldc_w 501
    //   95: invokeinterface 169 2 0
    //   100: aload_1
    //   101: invokevirtual 499	java/io/ObjectInputStream:close	()V
    //   104: aload_0
    //   105: aconst_null
    //   106: putfield 151	com/adjust/sdk/ActivityHandler:activityState	Lcom/adjust/sdk/ActivityState;
    //   109: return
    //   110: astore 7
    //   112: aload_1
    //   113: invokevirtual 499	java/io/ObjectInputStream:close	()V
    //   116: goto -12 -> 104
    //   119: astore 4
    //   121: aload_0
    //   122: getfield 82	com/adjust/sdk/ActivityHandler:logger	Lcom/adjust/sdk/Logger;
    //   125: ldc_w 503
    //   128: invokeinterface 506 2 0
    //   133: goto -29 -> 104
    //   136: astore 6
    //   138: aload_0
    //   139: getfield 82	com/adjust/sdk/ActivityHandler:logger	Lcom/adjust/sdk/Logger;
    //   142: ldc_w 508
    //   145: invokeinterface 169 2 0
    //   150: aload_1
    //   151: invokevirtual 499	java/io/ObjectInputStream:close	()V
    //   154: goto -50 -> 104
    //   157: astore_3
    //   158: aload_0
    //   159: getfield 82	com/adjust/sdk/ActivityHandler:logger	Lcom/adjust/sdk/Logger;
    //   162: ldc_w 510
    //   165: iconst_1
    //   166: anewarray 179	java/lang/Object
    //   169: dup
    //   170: iconst_0
    //   171: aload_3
    //   172: aastore
    //   173: invokestatic 183	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   176: invokeinterface 169 2 0
    //   181: goto -77 -> 104
    //   184: astore 5
    //   186: aload_0
    //   187: getfield 82	com/adjust/sdk/ActivityHandler:logger	Lcom/adjust/sdk/Logger;
    //   190: ldc_w 512
    //   193: invokeinterface 169 2 0
    //   198: aload_1
    //   199: invokevirtual 499	java/io/ObjectInputStream:close	()V
    //   202: goto -98 -> 104
    //   205: astore_2
    //   206: aload_1
    //   207: invokevirtual 499	java/io/ObjectInputStream:close	()V
    //   210: aload_2
    //   211: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   24	81	86	java/lang/ClassNotFoundException
    //   24	81	110	java/io/OptionalDataException
    //   0	24	119	java/io/FileNotFoundException
    //   81	85	119	java/io/FileNotFoundException
    //   100	104	119	java/io/FileNotFoundException
    //   112	116	119	java/io/FileNotFoundException
    //   150	154	119	java/io/FileNotFoundException
    //   198	202	119	java/io/FileNotFoundException
    //   206	212	119	java/io/FileNotFoundException
    //   24	81	136	java/io/IOException
    //   0	24	157	java/lang/Exception
    //   81	85	157	java/lang/Exception
    //   100	104	157	java/lang/Exception
    //   112	116	157	java/lang/Exception
    //   150	154	157	java/lang/Exception
    //   198	202	157	java/lang/Exception
    //   206	212	157	java/lang/Exception
    //   24	81	184	java/lang/ClassCastException
    //   24	81	205	finally
    //   88	100	205	finally
    //   138	150	205	finally
    //   186	198	205	finally
  }

  private void readOpenUrlInternal(Uri paramUri)
  {
    if (paramUri == null);
    HashMap localHashMap;
    do
    {
      String str1;
      do
      {
        return;
        str1 = paramUri.getQuery();
      }
      while (str1 == null);
      localHashMap = new HashMap();
      String[] arrayOfString1 = str1.split("&");
      int i = arrayOfString1.length;
      int j = 0;
      if (j < i)
      {
        String[] arrayOfString2 = arrayOfString1[j].split("=");
        if (arrayOfString2.length != 2);
        while (true)
        {
          j++;
          break;
          String str2 = arrayOfString2[0];
          if (str2.startsWith("adjust_"))
          {
            String str3 = arrayOfString2[1];
            if (str3.length() != 0)
            {
              String str4 = str2.substring("adjust_".length());
              if (str4.length() != 0)
                localHashMap.put(str4, str3);
            }
          }
        }
      }
    }
    while (localHashMap.size() == 0);
    PackageBuilder localPackageBuilder = new PackageBuilder(this.context);
    localPackageBuilder.setDeepLinkParameters(localHashMap);
    injectGeneralAttributes(localPackageBuilder);
    ActivityPackage localActivityPackage = localPackageBuilder.buildReattributionPackage();
    this.packageHandler.addPackage(localActivityPackage);
    this.packageHandler.sendFirstPackage();
    Logger localLogger = this.logger;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = localHashMap.toString();
    localLogger.debug(String.format("Reattribution %s", arrayOfObject));
  }

  private void setDefaultTracker(String paramString)
  {
    this.defaultTracker = paramString;
    if (this.defaultTracker != null)
    {
      Logger localLogger = this.logger;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = this.defaultTracker;
      localLogger.info(String.format("Default tracker: '%s'", arrayOfObject));
    }
  }

  private void setDropOfflineActivities(boolean paramBoolean)
  {
    this.dropOfflineActivities = paramBoolean;
    if (this.dropOfflineActivities)
      this.logger.info("Offline activities will get dropped");
  }

  private void setEnvironment(String paramString)
  {
    this.environment = paramString;
    if (this.environment == null)
    {
      this.logger.Assert("Missing environment");
      this.logger.setLogLevel(Logger.LogLevel.ASSERT);
      this.environment = "unknown";
      return;
    }
    if ("sandbox".equalsIgnoreCase(this.environment))
    {
      this.logger.Assert("SANDBOX: Adjust is running in Sandbox mode. Use this setting for testing. Don't forget to set the environment to `production` before publishing!");
      return;
    }
    if ("production".equalsIgnoreCase(this.environment))
    {
      this.logger.Assert("PRODUCTION: Adjust is running in Production mode. Use this setting only for the build that you want to publish. Set the environment to `sandbox` if you want to test your app!");
      this.logger.setLogLevel(Logger.LogLevel.ASSERT);
      return;
    }
    Logger localLogger = this.logger;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = this.environment;
    localLogger.Assert(String.format("Malformed environment '%s'", arrayOfObject));
    this.logger.setLogLevel(Logger.LogLevel.ASSERT);
    this.environment = "malformed";
  }

  private void setEventBuffering(boolean paramBoolean)
  {
    this.eventBuffering = paramBoolean;
    if (this.eventBuffering)
      this.logger.info("Event buffering is enabled");
  }

  private void startInternal()
  {
    if (!checkAppTokenNotNull(this.appToken));
    while ((this.activityState != null) && (!this.activityState.enabled.booleanValue()))
      return;
    this.packageHandler.resumeSending();
    startTimer();
    long l1 = System.currentTimeMillis();
    if (this.activityState == null)
    {
      this.activityState = new ActivityState();
      this.activityState.sessionCount = 1;
      this.activityState.createdAt = l1;
      transferSessionPackage();
      this.activityState.resetSessionAttributes(l1);
      this.activityState.enabled = Boolean.valueOf(this.enabled);
      writeActivityState();
      this.logger.info("First session");
      return;
    }
    long l2 = l1 - this.activityState.lastActivity;
    if (l2 < 0L)
    {
      this.logger.error("Time travel!");
      this.activityState.lastActivity = l1;
      writeActivityState();
      return;
    }
    if (l2 > SESSION_INTERVAL)
    {
      ActivityState localActivityState3 = this.activityState;
      localActivityState3.sessionCount = (1 + localActivityState3.sessionCount);
      this.activityState.createdAt = l1;
      this.activityState.lastInterval = l2;
      transferSessionPackage();
      this.activityState.resetSessionAttributes(l1);
      writeActivityState();
      Logger localLogger2 = this.logger;
      Locale localLocale2 = Locale.US;
      Object[] arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = Integer.valueOf(this.activityState.sessionCount);
      localLogger2.debug(String.format(localLocale2, "Session %d", arrayOfObject2));
      return;
    }
    if (l2 > SUBSESSION_INTERVAL)
    {
      ActivityState localActivityState2 = this.activityState;
      localActivityState2.subsessionCount = (1 + localActivityState2.subsessionCount);
      Logger localLogger1 = this.logger;
      Locale localLocale1 = Locale.US;
      Object[] arrayOfObject1 = new Object[2];
      arrayOfObject1[0] = Integer.valueOf(this.activityState.subsessionCount);
      arrayOfObject1[1] = Integer.valueOf(this.activityState.sessionCount);
      localLogger1.info(String.format(localLocale1, "Started subsession %d of session %d", arrayOfObject1));
    }
    ActivityState localActivityState1 = this.activityState;
    localActivityState1.sessionLength = (l2 + localActivityState1.sessionLength);
    this.activityState.lastActivity = l1;
    writeActivityState();
  }

  private void startTimer()
  {
    if (timer != null)
      stopTimer();
    timer = Executors.newSingleThreadScheduledExecutor();
    timer.scheduleWithFixedDelay(new Runnable()
    {
      public void run()
      {
        ActivityHandler.this.timerFired();
      }
    }
    , 1000L, TIMER_INTERVAL, TimeUnit.MILLISECONDS);
  }

  private void stopTimer()
  {
    try
    {
      timer.shutdown();
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      this.logger.error("No timer found");
    }
  }

  private void timerFired()
  {
    if ((this.activityState != null) && (!this.activityState.enabled.booleanValue()))
      return;
    this.packageHandler.sendFirstPackage();
    updateActivityState(System.currentTimeMillis());
    writeActivityState();
  }

  private void trackEventInternal(PackageBuilder paramPackageBuilder)
  {
    if (!canTrackEvent(paramPackageBuilder));
    while (!this.activityState.enabled.booleanValue())
      return;
    long l = System.currentTimeMillis();
    this.activityState.createdAt = l;
    ActivityState localActivityState = this.activityState;
    localActivityState.eventCount = (1 + localActivityState.eventCount);
    updateActivityState(l);
    injectGeneralAttributes(paramPackageBuilder);
    this.activityState.injectEventAttributes(paramPackageBuilder);
    ActivityPackage localActivityPackage = paramPackageBuilder.buildEventPackage();
    this.packageHandler.addPackage(localActivityPackage);
    if (this.eventBuffering)
    {
      Logger localLogger2 = this.logger;
      Object[] arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = localActivityPackage.getSuffix();
      localLogger2.info(String.format("Buffered event %s", arrayOfObject2));
    }
    while (true)
    {
      writeActivityState();
      Logger localLogger1 = this.logger;
      Locale localLocale = Locale.US;
      Object[] arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = Integer.valueOf(this.activityState.eventCount);
      localLogger1.debug(String.format(localLocale, "Event %d", arrayOfObject1));
      return;
      this.packageHandler.sendFirstPackage();
    }
  }

  private void trackRevenueInternal(PackageBuilder paramPackageBuilder)
  {
    if (!canTrackRevenue(paramPackageBuilder));
    while (!this.activityState.enabled.booleanValue())
      return;
    long l = System.currentTimeMillis();
    this.activityState.createdAt = l;
    ActivityState localActivityState = this.activityState;
    localActivityState.eventCount = (1 + localActivityState.eventCount);
    updateActivityState(l);
    injectGeneralAttributes(paramPackageBuilder);
    this.activityState.injectEventAttributes(paramPackageBuilder);
    ActivityPackage localActivityPackage = paramPackageBuilder.buildRevenuePackage();
    this.packageHandler.addPackage(localActivityPackage);
    if (this.eventBuffering)
    {
      Logger localLogger2 = this.logger;
      Object[] arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = localActivityPackage.getSuffix();
      localLogger2.info(String.format("Buffered revenue %s", arrayOfObject2));
    }
    while (true)
    {
      writeActivityState();
      Logger localLogger1 = this.logger;
      Locale localLocale = Locale.US;
      Object[] arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = Integer.valueOf(this.activityState.eventCount);
      localLogger1.debug(String.format(localLocale, "Event %d (revenue)", arrayOfObject1));
      return;
      this.packageHandler.sendFirstPackage();
    }
  }

  private void transferSessionPackage()
  {
    PackageBuilder localPackageBuilder = new PackageBuilder(this.context);
    injectGeneralAttributes(localPackageBuilder);
    injectReferrer(localPackageBuilder);
    this.activityState.injectSessionAttributes(localPackageBuilder);
    ActivityPackage localActivityPackage = localPackageBuilder.buildSessionPackage();
    this.packageHandler.addPackage(localActivityPackage);
    this.packageHandler.sendFirstPackage();
  }

  private void updateActivityState(long paramLong)
  {
    if (!checkActivityState(this.activityState));
    long l;
    do
    {
      return;
      l = paramLong - this.activityState.lastActivity;
      if (l < 0L)
      {
        this.logger.error("Time travel!");
        this.activityState.lastActivity = paramLong;
        return;
      }
    }
    while (l > SESSION_INTERVAL);
    ActivityState localActivityState1 = this.activityState;
    localActivityState1.sessionLength = (l + localActivityState1.sessionLength);
    ActivityState localActivityState2 = this.activityState;
    localActivityState2.timeSpent = (l + localActivityState2.timeSpent);
    this.activityState.lastActivity = paramLong;
  }

  // ERROR //
  private void writeActivityState()
  {
    // Byte code:
    //   0: new 742	java/io/ObjectOutputStream
    //   3: dup
    //   4: new 744	java/io/BufferedOutputStream
    //   7: dup
    //   8: aload_0
    //   9: getfield 140	com/adjust/sdk/ActivityHandler:context	Landroid/content/Context;
    //   12: ldc 212
    //   14: iconst_0
    //   15: invokevirtual 748	android/content/Context:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   18: invokespecial 751	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   21: invokespecial 752	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   24: astore_1
    //   25: aload_1
    //   26: aload_0
    //   27: getfield 151	com/adjust/sdk/ActivityHandler:activityState	Lcom/adjust/sdk/ActivityState;
    //   30: invokevirtual 756	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   33: aload_0
    //   34: getfield 82	com/adjust/sdk/ActivityHandler:logger	Lcom/adjust/sdk/Logger;
    //   37: astore 5
    //   39: iconst_1
    //   40: anewarray 179	java/lang/Object
    //   43: astore 6
    //   45: aload 6
    //   47: iconst_0
    //   48: aload_0
    //   49: getfield 151	com/adjust/sdk/ActivityHandler:activityState	Lcom/adjust/sdk/ActivityState;
    //   52: aastore
    //   53: aload 5
    //   55: ldc_w 758
    //   58: aload 6
    //   60: invokestatic 183	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   63: invokeinterface 496 2 0
    //   68: aload_1
    //   69: invokevirtual 759	java/io/ObjectOutputStream:close	()V
    //   72: return
    //   73: astore 4
    //   75: aload_0
    //   76: getfield 82	com/adjust/sdk/ActivityHandler:logger	Lcom/adjust/sdk/Logger;
    //   79: ldc_w 761
    //   82: invokeinterface 169 2 0
    //   87: aload_1
    //   88: invokevirtual 759	java/io/ObjectOutputStream:close	()V
    //   91: return
    //   92: astore_3
    //   93: aload_0
    //   94: getfield 82	com/adjust/sdk/ActivityHandler:logger	Lcom/adjust/sdk/Logger;
    //   97: ldc_w 763
    //   100: iconst_1
    //   101: anewarray 179	java/lang/Object
    //   104: dup
    //   105: iconst_0
    //   106: aload_3
    //   107: aastore
    //   108: invokestatic 183	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   111: invokeinterface 169 2 0
    //   116: return
    //   117: astore_2
    //   118: aload_1
    //   119: invokevirtual 759	java/io/ObjectOutputStream:close	()V
    //   122: aload_2
    //   123: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   25	68	73	java/io/NotSerializableException
    //   0	25	92	java/lang/Exception
    //   68	72	92	java/lang/Exception
    //   87	91	92	java/lang/Exception
    //   118	124	92	java/lang/Exception
    //   25	68	117	finally
    //   75	87	117	finally
  }

  public void finishedTrackingActivity(final ResponseData paramResponseData)
  {
    if (this.onFinishedListener == null)
      return;
    new Handler(this.context.getMainLooper()).post(new Runnable()
    {
      public void run()
      {
        try
        {
          ActivityHandler.this.onFinishedListener.onFinishedTracking(paramResponseData);
          return;
        }
        catch (NullPointerException localNullPointerException)
        {
        }
      }
    });
  }

  public Boolean isEnabled()
  {
    if (checkActivityState(this.activityState))
      return this.activityState.enabled;
    return Boolean.valueOf(this.enabled);
  }

  public void readOpenUrl(Uri paramUri)
  {
    Message localMessage = Message.obtain();
    localMessage.arg1 = 72680;
    localMessage.obj = paramUri;
    this.sessionHandler.sendMessage(localMessage);
  }

  public void setEnabled(Boolean paramBoolean)
  {
    this.enabled = paramBoolean.booleanValue();
    if (checkActivityState(this.activityState))
      this.activityState.enabled = paramBoolean;
    if (paramBoolean.booleanValue())
    {
      trackSubsessionStart();
      return;
    }
    trackSubsessionEnd();
  }

  public void setOnFinishedListener(OnFinishedListener paramOnFinishedListener)
  {
    this.onFinishedListener = paramOnFinishedListener;
  }

  public void setSdkPrefix(String paramString)
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = paramString;
    arrayOfObject[1] = this.clientSdk;
    this.clientSdk = String.format("%s@%s", arrayOfObject);
  }

  public void trackEvent(String paramString, Map<String, String> paramMap)
  {
    PackageBuilder localPackageBuilder = new PackageBuilder(this.context);
    localPackageBuilder.setEventToken(paramString);
    localPackageBuilder.setCallbackParameters(paramMap);
    Message localMessage = Message.obtain();
    localMessage.arg1 = 72660;
    localMessage.obj = localPackageBuilder;
    this.sessionHandler.sendMessage(localMessage);
  }

  public void trackRevenue(double paramDouble, String paramString, Map<String, String> paramMap)
  {
    PackageBuilder localPackageBuilder = new PackageBuilder(this.context);
    localPackageBuilder.setAmountInCents(paramDouble);
    localPackageBuilder.setEventToken(paramString);
    localPackageBuilder.setCallbackParameters(paramMap);
    Message localMessage = Message.obtain();
    localMessage.arg1 = 72670;
    localMessage.obj = localPackageBuilder;
    this.sessionHandler.sendMessage(localMessage);
  }

  public void trackSubsessionEnd()
  {
    Message localMessage = Message.obtain();
    localMessage.arg1 = 72650;
    this.sessionHandler.sendMessage(localMessage);
  }

  public void trackSubsessionStart()
  {
    Message localMessage = Message.obtain();
    localMessage.arg1 = 72640;
    this.sessionHandler.sendMessage(localMessage);
  }

  private static final class SessionHandler extends Handler
  {
    private static final int DEEP_LINK = 72680;
    private static final int END = 72650;
    private static final int EVENT = 72660;
    private static final int INIT_BUNDLE = 72630;
    private static final int INIT_PRESET = 72633;
    private static final int REVENUE = 72670;
    private static final int START = 72640;
    private final WeakReference<ActivityHandler> sessionHandlerReference;

    protected SessionHandler(Looper paramLooper, ActivityHandler paramActivityHandler)
    {
      super();
      this.sessionHandlerReference = new WeakReference(paramActivityHandler);
    }

    public void handleMessage(Message paramMessage)
    {
      super.handleMessage(paramMessage);
      ActivityHandler localActivityHandler = (ActivityHandler)this.sessionHandlerReference.get();
      if (localActivityHandler == null)
        return;
      switch (paramMessage.arg1)
      {
      default:
        return;
      case 72630:
        localActivityHandler.initInternal(true);
        return;
      case 72633:
        localActivityHandler.initInternal(false);
        return;
      case 72640:
        localActivityHandler.startInternal();
        return;
      case 72650:
        localActivityHandler.endInternal();
        return;
      case 72660:
        localActivityHandler.trackEventInternal((PackageBuilder)paramMessage.obj);
        return;
      case 72670:
        localActivityHandler.trackRevenueInternal((PackageBuilder)paramMessage.obj);
        return;
      case 72680:
      }
      localActivityHandler.readOpenUrlInternal((Uri)paramMessage.obj);
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.adjust.sdk.ActivityHandler
 * JD-Core Version:    0.6.2
 */