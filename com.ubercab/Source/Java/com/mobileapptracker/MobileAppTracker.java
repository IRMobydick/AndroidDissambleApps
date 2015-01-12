package com.mobileapptracker;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONArray;
import org.json.JSONObject;

public class MobileAppTracker
{
  public static final int GENDER_FEMALE = 1;
  public static final int GENDER_MALE;
  private static volatile MobileAppTracker g = null;
  private final String a = "heF9BATUfWuISyO8";
  private c b;
  private Encryption c;
  private boolean d;
  private boolean e;
  protected MATEventQueue eventQueue;
  private ExecutorService f;
  protected boolean initialized;
  protected boolean isRegistered;
  protected Context mContext;
  protected MATTestRequest matRequest;
  protected MATResponse matResponse;
  protected BroadcastReceiver networkStateReceiver;
  protected Parameters params;
  protected ExecutorService pubQueue;

  private void a(Object paramObject, JSONArray paramJSONArray, double paramDouble, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean)
  {
    while (true)
    {
      try
      {
        boolean bool = this.initialized;
        if (!bool)
          return;
        dumpQueue();
        this.params.setAction("conversion");
        Date localDate = new Date();
        if (!(paramObject instanceof String))
          break label297;
        if (paramObject.equals("close"))
          continue;
        if ((!paramObject.equals("open")) && (!paramObject.equals("install")) && (!paramObject.equals("update")) && (!paramObject.equals("session")))
          break label283;
        if (paramBoolean)
        {
          this.params.setAction("install");
          localDate = new Date(5000L + localDate.getTime());
          this.params.setRevenue(Double.toString(paramDouble));
          if (paramDouble > 0.0D)
            this.params.setIsPayingUser(Integer.toString(1));
          this.params.setCurrencyCode(paramString1);
          this.params.setRefId(paramString2);
          String str1 = b.a(this.d, this.e, paramBoolean);
          String str2 = b.a();
          JSONObject localJSONObject = b.a(paramJSONArray, paramString3, paramString4);
          if (this.matRequest != null)
            this.matRequest.constructedRequest(str1, str2, localJSONObject);
          addEventToQueue(str1, str2, localJSONObject, localDate);
          dumpQueue();
          if (this.matResponse != null)
            this.matResponse.enqueuedActionWithRefId(paramString2);
          this.params.resetAfterRequest();
          continue;
        }
      }
      finally
      {
      }
      this.params.setAction("session");
      continue;
      label283: this.params.setEventName((String)paramObject);
      continue;
      label297: if ((paramObject instanceof Integer))
        this.params.setEventId(Integer.toString(((Integer)paramObject).intValue()));
      else
        Log.d("MobileAppTracker", "Received invalid event name or id value, not measuring event");
    }
  }

  private void c()
  {
    Date localDate = null;
    while (true)
    {
      if (this.params == null)
      {
        if (localDate == null)
          localDate = new Date(1000L + new Date().getTime());
        if (localDate.before(new Date()))
          Log.w("MobileAppTracker", "after waiting 1 s, params is still null -- will probably lead to NullPointerException");
      }
      else
      {
        return;
      }
      try
      {
        Thread.sleep(50L);
      }
      catch (InterruptedException localInterruptedException)
      {
      }
    }
  }

  public static MobileAppTracker getInstance()
  {
    try
    {
      MobileAppTracker localMobileAppTracker = g;
      return localMobileAppTracker;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public static void init(Context paramContext, String paramString1, String paramString2)
  {
    MobileAppTracker localMobileAppTracker = new MobileAppTracker();
    g = localMobileAppTracker;
    localMobileAppTracker.mContext = paramContext.getApplicationContext();
    g.pubQueue = Executors.newSingleThreadExecutor();
    g.pubQueue.execute(new d(paramString1, paramString2));
  }

  public static boolean isOnline(Context paramContext)
  {
    NetworkInfo localNetworkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    return (localNetworkInfo != null) && (localNetworkInfo.isConnected());
  }

  final void a()
  {
    a("install", null, 0.0D, null, null, null, null, true);
  }

  protected void addEventToQueue(String paramString1, String paramString2, JSONObject paramJSONObject, Date paramDate)
  {
    ExecutorService localExecutorService = this.f;
    MATEventQueue localMATEventQueue = this.eventQueue;
    localMATEventQueue.getClass();
    localExecutorService.execute(new MATEventQueue.Add(localMATEventQueue, paramString1, paramString2, paramJSONObject, paramDate));
  }

  protected void dumpQueue()
  {
    if (!isOnline(this.mContext))
      return;
    ExecutorService localExecutorService = this.f;
    MATEventQueue localMATEventQueue = this.eventQueue;
    localMATEventQueue.getClass();
    localExecutorService.execute(new MATEventQueue.Dump(localMATEventQueue));
  }

  public String getAction()
  {
    c();
    return this.params.getAction();
  }

  public String getAdvertiserId()
  {
    c();
    return this.params.getAdvertiserId();
  }

  public int getAge()
  {
    c();
    return Integer.parseInt(this.params.getAge());
  }

  public double getAltitude()
  {
    c();
    return Double.parseDouble(this.params.getAltitude());
  }

  public boolean getAppAdTrackingEnabled()
  {
    c();
    return Integer.parseInt(this.params.getAppAdTrackingEnabled()) == 1;
  }

  public String getAppName()
  {
    c();
    return this.params.getAppName();
  }

  public int getAppVersion()
  {
    c();
    return Integer.parseInt(this.params.getAppVersion());
  }

  public String getConnectionType()
  {
    c();
    return this.params.getConnectionType();
  }

  public String getCountryCode()
  {
    c();
    return this.params.getCountryCode();
  }

  public String getCurrencyCode()
  {
    c();
    return this.params.getCurrencyCode();
  }

  public String getDeviceBrand()
  {
    c();
    return this.params.getDeviceBrand();
  }

  public String getDeviceCarrier()
  {
    c();
    return this.params.getDeviceCarrier();
  }

  public String getDeviceModel()
  {
    c();
    return this.params.getDeviceModel();
  }

  public String getEventAttribute1()
  {
    c();
    return this.params.getEventAttribute1();
  }

  public String getEventAttribute2()
  {
    c();
    return this.params.getEventAttribute2();
  }

  public String getEventAttribute3()
  {
    c();
    return this.params.getEventAttribute3();
  }

  public String getEventAttribute4()
  {
    c();
    return this.params.getEventAttribute4();
  }

  public String getEventAttribute5()
  {
    c();
    return this.params.getEventAttribute5();
  }

  public String getEventId()
  {
    c();
    return this.params.getEventId();
  }

  public String getEventName()
  {
    c();
    return this.params.getEventName();
  }

  public boolean getExistingUser()
  {
    c();
    return Integer.parseInt(this.params.getExistingUser()) == 1;
  }

  public String getFacebookUserId()
  {
    c();
    return this.params.getFacebookUserId();
  }

  public int getGender()
  {
    c();
    return Integer.parseInt(this.params.getGender());
  }

  public boolean getGoogleAdTrackingLimited()
  {
    c();
    return Integer.parseInt(this.params.getGoogleAdTrackingLimited()) != 0;
  }

  public String getGoogleAdvertisingId()
  {
    c();
    return this.params.getGoogleAdvertisingId();
  }

  public String getGoogleUserId()
  {
    c();
    return this.params.getGoogleUserId();
  }

  public long getInstallDate()
  {
    c();
    return Long.parseLong(this.params.getInstallDate());
  }

  public String getInstallLogId()
  {
    c();
    return this.params.getInstallLogId();
  }

  public String getInstallReferrer()
  {
    c();
    return this.params.getInstallReferrer();
  }

  public boolean getIsPayingUser()
  {
    c();
    return this.params.getIsPayingUser().equals("1");
  }

  public String getLanguage()
  {
    c();
    return this.params.getLanguage();
  }

  public String getLastOpenLogId()
  {
    c();
    return this.params.getLastOpenLogId();
  }

  public double getLatitude()
  {
    c();
    return Double.parseDouble(this.params.getLatitude());
  }

  public double getLongitude()
  {
    c();
    return Double.parseDouble(this.params.getLongitude());
  }

  public String getMCC()
  {
    c();
    return this.params.getMCC();
  }

  public String getMNC()
  {
    c();
    return this.params.getMNC();
  }

  public String getMatId()
  {
    c();
    return this.params.getMatId();
  }

  public String getOpenLogId()
  {
    c();
    return this.params.getOpenLogId();
  }

  public String getOsVersion()
  {
    c();
    return this.params.getOsVersion();
  }

  public String getPackageName()
  {
    c();
    return this.params.getPackageName();
  }

  public String getPluginName()
  {
    c();
    return this.params.getPluginName();
  }

  public String getRefId()
  {
    c();
    return this.params.getRefId();
  }

  public String getReferralSource()
  {
    c();
    return this.params.getReferralSource();
  }

  public String getReferralUrl()
  {
    c();
    return this.params.getReferralUrl();
  }

  public Double getRevenue()
  {
    c();
    return Double.valueOf(Double.parseDouble(this.params.getRevenue()));
  }

  public String getSDKVersion()
  {
    c();
    return this.params.getSdkVersion();
  }

  public String getScreenDensity()
  {
    c();
    return this.params.getScreenDensity();
  }

  public String getScreenHeight()
  {
    c();
    return this.params.getScreenHeight();
  }

  public String getScreenWidth()
  {
    c();
    return this.params.getScreenWidth();
  }

  public String getSiteId()
  {
    c();
    return this.params.getSiteId();
  }

  public String getTRUSTeId()
  {
    c();
    return this.params.getTRUSTeId();
  }

  public String getTwitterUserId()
  {
    c();
    return this.params.getTwitterUserId();
  }

  public String getUpdateLogId()
  {
    c();
    return this.params.getUpdateLogId();
  }

  public String getUserAgent()
  {
    c();
    return this.params.getUserAgent();
  }

  public String getUserEmail()
  {
    c();
    return this.params.getUserEmail();
  }

  public String getUserId()
  {
    c();
    return this.params.getUserId();
  }

  public String getUserName()
  {
    c();
    return this.params.getUserName();
  }

  protected void initAll(String paramString1, String paramString2)
  {
    Parameters.init(this.mContext, paramString1, paramString2);
    this.params = Parameters.getInstance();
    this.f = Executors.newSingleThreadExecutor();
    this.b = new c();
    this.c = new Encryption(paramString2.trim(), "heF9BATUfWuISyO8");
    this.initialized = false;
    this.isRegistered = false;
    this.d = false;
    this.e = false;
    this.eventQueue = new MATEventQueue(this.mContext, g);
    dumpQueue();
    this.networkStateReceiver = new o(this);
    if (this.isRegistered);
    try
    {
      this.mContext.unregisterReceiver(this.networkStateReceiver);
      label123: this.isRegistered = false;
      IntentFilter localIntentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
      this.mContext.registerReceiver(this.networkStateReceiver, localIntentFilter);
      this.isRegistered = true;
      this.initialized = true;
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      break label123;
    }
  }

  // ERROR //
  protected boolean makeRequest(String paramString1, String paramString2, JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 119	com/mobileapptracker/MobileAppTracker:d	Z
    //   4: ifeq +12 -> 16
    //   7: ldc 166
    //   9: ldc_w 518
    //   12: invokestatic 173	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   15: pop
    //   16: aload_2
    //   17: aload_0
    //   18: getfield 484	com/mobileapptracker/MobileAppTracker:c	Lcom/mobileapptracker/Encryption;
    //   21: invokestatic 521	com/mobileapptracker/b:a	(Ljava/lang/String;Lcom/mobileapptracker/Encryption;)Ljava/lang/String;
    //   24: astore 4
    //   26: new 523	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 524	java/lang/StringBuilder:<init>	()V
    //   33: aload_1
    //   34: invokevirtual 528	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: ldc_w 530
    //   40: invokevirtual 528	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: aload 4
    //   45: invokevirtual 528	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: invokevirtual 532	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: astore 5
    //   53: aload_0
    //   54: getfield 476	com/mobileapptracker/MobileAppTracker:b	Lcom/mobileapptracker/c;
    //   57: aload 5
    //   59: aload_3
    //   60: aload_0
    //   61: getfield 119	com/mobileapptracker/MobileAppTracker:d	Z
    //   64: invokevirtual 535	com/mobileapptracker/c:a	(Ljava/lang/String;Lorg/json/JSONObject;Z)Lorg/json/JSONObject;
    //   67: astore 6
    //   69: aload 6
    //   71: ifnonnull +23 -> 94
    //   74: aload_0
    //   75: getfield 146	com/mobileapptracker/MobileAppTracker:matResponse	Lcom/mobileapptracker/MATResponse;
    //   78: ifnull +14 -> 92
    //   81: aload_0
    //   82: getfield 146	com/mobileapptracker/MobileAppTracker:matResponse	Lcom/mobileapptracker/MATResponse;
    //   85: aload 6
    //   87: invokeinterface 539 2 0
    //   92: iconst_1
    //   93: ireturn
    //   94: aload 6
    //   96: ldc_w 541
    //   99: invokevirtual 547	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   102: ifne +21 -> 123
    //   105: aload_0
    //   106: getfield 119	com/mobileapptracker/MobileAppTracker:d	Z
    //   109: ifeq +12 -> 121
    //   112: ldc 166
    //   114: ldc_w 549
    //   117: invokestatic 173	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   120: pop
    //   121: iconst_0
    //   122: ireturn
    //   123: aload_0
    //   124: getfield 146	com/mobileapptracker/MobileAppTracker:matResponse	Lcom/mobileapptracker/MATResponse;
    //   127: ifnull +46 -> 173
    //   130: aload 6
    //   132: ldc_w 541
    //   135: invokevirtual 553	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   138: ldc_w 555
    //   141: invokevirtual 376	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   144: istore 21
    //   146: iconst_0
    //   147: istore 22
    //   149: iload 21
    //   151: ifeq +6 -> 157
    //   154: iconst_1
    //   155: istore 22
    //   157: iload 22
    //   159: ifeq +255 -> 414
    //   162: aload_0
    //   163: getfield 146	com/mobileapptracker/MobileAppTracker:matResponse	Lcom/mobileapptracker/MATResponse;
    //   166: aload 6
    //   168: invokeinterface 558 2 0
    //   173: aload 6
    //   175: ldc_w 560
    //   178: invokevirtual 553	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   181: ldc 79
    //   183: invokevirtual 376	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   186: ifeq +38 -> 224
    //   189: aload 6
    //   191: ldc_w 562
    //   194: invokevirtual 553	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   197: astore 19
    //   199: aload_0
    //   200: invokevirtual 563	com/mobileapptracker/MobileAppTracker:getOpenLogId	()Ljava/lang/String;
    //   203: ifnonnull +12 -> 215
    //   206: aload_0
    //   207: getfield 58	com/mobileapptracker/MobileAppTracker:params	Lcom/mobileapptracker/Parameters;
    //   210: aload 19
    //   212: invokevirtual 566	com/mobileapptracker/Parameters:setOpenLogId	(Ljava/lang/String;)V
    //   215: aload_0
    //   216: getfield 58	com/mobileapptracker/MobileAppTracker:params	Lcom/mobileapptracker/Parameters;
    //   219: aload 19
    //   221: invokevirtual 569	com/mobileapptracker/Parameters:setLastOpenLogId	(Ljava/lang/String;)V
    //   224: aload_0
    //   225: getfield 119	com/mobileapptracker/MobileAppTracker:d	Z
    //   228: ifeq -136 -> 92
    //   231: ldc 166
    //   233: new 523	java/lang/StringBuilder
    //   236: dup
    //   237: ldc_w 571
    //   240: invokespecial 572	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   243: aload 6
    //   245: invokevirtual 573	org/json/JSONObject:toString	()Ljava/lang/String;
    //   248: invokevirtual 528	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: invokevirtual 532	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   254: invokestatic 173	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   257: pop
    //   258: aload 6
    //   260: invokevirtual 576	org/json/JSONObject:length	()I
    //   263: ifle -171 -> 92
    //   266: aload 6
    //   268: ldc_w 578
    //   271: invokevirtual 547	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   274: ifeq +165 -> 439
    //   277: aload 6
    //   279: ldc_w 578
    //   282: invokevirtual 553	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   285: ldc_w 580
    //   288: invokevirtual 376	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   291: ifne +148 -> 439
    //   294: aload 6
    //   296: ldc_w 578
    //   299: invokevirtual 584	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   302: astore 14
    //   304: aload 14
    //   306: ldc 60
    //   308: invokevirtual 547	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   311: ifeq -219 -> 92
    //   314: aload 14
    //   316: ldc 60
    //   318: invokevirtual 584	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   321: astore 15
    //   323: aload 15
    //   325: ldc_w 586
    //   328: invokevirtual 547	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   331: ifeq -239 -> 92
    //   334: aload 15
    //   336: ldc_w 586
    //   339: invokevirtual 553	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   342: ldc_w 588
    //   345: invokevirtual 376	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   348: ifeq +80 -> 428
    //   351: aload 15
    //   353: ldc_w 590
    //   356: invokevirtual 553	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   359: astore 17
    //   361: ldc 166
    //   363: new 523	java/lang/StringBuilder
    //   366: dup
    //   367: ldc_w 592
    //   370: invokespecial 572	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   373: aload 17
    //   375: invokevirtual 528	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   378: invokevirtual 532	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   381: invokestatic 173	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   384: pop
    //   385: iconst_1
    //   386: ireturn
    //   387: astore 9
    //   389: ldc 166
    //   391: ldc_w 594
    //   394: invokestatic 173	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   397: pop
    //   398: aload 9
    //   400: invokevirtual 597	org/json/JSONException:printStackTrace	()V
    //   403: iconst_1
    //   404: ireturn
    //   405: astore 20
    //   407: aload 20
    //   409: invokevirtual 597	org/json/JSONException:printStackTrace	()V
    //   412: iconst_0
    //   413: ireturn
    //   414: aload_0
    //   415: getfield 146	com/mobileapptracker/MobileAppTracker:matResponse	Lcom/mobileapptracker/MATResponse;
    //   418: aload 6
    //   420: invokeinterface 539 2 0
    //   425: goto -252 -> 173
    //   428: ldc 166
    //   430: ldc_w 599
    //   433: invokestatic 173	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   436: pop
    //   437: iconst_1
    //   438: ireturn
    //   439: aload 6
    //   441: ldc_w 601
    //   444: invokevirtual 547	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   447: ifeq -355 -> 92
    //   450: aload 6
    //   452: ldc_w 601
    //   455: invokevirtual 584	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   458: astore 11
    //   460: aload 11
    //   462: ldc_w 603
    //   465: invokevirtual 547	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   468: ifeq -376 -> 92
    //   471: aload 11
    //   473: ldc_w 603
    //   476: invokevirtual 553	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   479: astore 12
    //   481: ldc 166
    //   483: new 523	java/lang/StringBuilder
    //   486: dup
    //   487: ldc_w 605
    //   490: invokespecial 572	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   493: aload 12
    //   495: invokevirtual 528	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   498: ldc_w 607
    //   501: invokevirtual 528	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   504: invokevirtual 532	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   507: invokestatic 173	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   510: pop
    //   511: iconst_1
    //   512: ireturn
    //   513: astore 7
    //   515: goto -291 -> 224
    //
    // Exception table:
    //   from	to	target	type
    //   266	385	387	org/json/JSONException
    //   428	437	387	org/json/JSONException
    //   439	511	387	org/json/JSONException
    //   130	146	405	org/json/JSONException
    //   173	215	513	org/json/JSONException
    //   215	224	513	org/json/JSONException
  }

  public void measureAction(int paramInt)
  {
    measureAction(paramInt, null, 0.0D, getCurrencyCode(), null, null, null);
  }

  public void measureAction(int paramInt, double paramDouble, String paramString)
  {
    measureAction(paramInt, null, paramDouble, paramString, null, null, null);
  }

  public void measureAction(int paramInt, double paramDouble, String paramString1, String paramString2)
  {
    measureAction(paramInt, null, paramDouble, paramString1, paramString2, null, null);
  }

  public void measureAction(int paramInt, List paramList, double paramDouble, String paramString1, String paramString2)
  {
    measureAction(paramInt, paramList, paramDouble, paramString1, paramString2, null, null);
  }

  public void measureAction(int paramInt, List paramList, double paramDouble, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    JSONArray localJSONArray = new JSONArray();
    if (paramList != null)
      for (int i = 0; i < paramList.size(); i++)
        localJSONArray.put(((MATEventItem)paramList.get(i)).toJSON());
    this.pubQueue.execute(new av(this, paramInt, localJSONArray, paramDouble, paramString1, paramString2, paramString3, paramString4));
  }

  public void measureAction(String paramString)
  {
    measureAction(paramString, null, 0.0D, getCurrencyCode(), null, null, null);
  }

  public void measureAction(String paramString1, double paramDouble, String paramString2)
  {
    measureAction(paramString1, null, paramDouble, paramString2, null, null, null);
  }

  public void measureAction(String paramString1, double paramDouble, String paramString2, String paramString3)
  {
    measureAction(paramString1, null, paramDouble, paramString2, paramString3, null, null);
  }

  public void measureAction(String paramString1, List paramList, double paramDouble, String paramString2, String paramString3)
  {
    measureAction(paramString1, paramList, paramDouble, paramString2, paramString3, null, null);
  }

  public void measureAction(String paramString1, List paramList, double paramDouble, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    JSONArray localJSONArray = new JSONArray();
    if (paramList != null)
      for (int i = 0; i < paramList.size(); i++)
        localJSONArray.put(((MATEventItem)paramList.get(i)).toJSON());
    this.pubQueue.execute(new ak(this, paramString1, localJSONArray, paramDouble, paramString2, paramString3, paramString4, paramString5));
  }

  public void measureSession()
  {
    this.pubQueue.execute(new z(this));
  }

  public void setAdvertiserSubAd(String paramString)
  {
    this.pubQueue.execute(new bg(this, paramString));
  }

  public void setAdvertiserSubAdgroup(String paramString)
  {
    this.pubQueue.execute(new bo(this, paramString));
  }

  public void setAdvertiserSubCampaign(String paramString)
  {
    this.pubQueue.execute(new bp(this, paramString));
  }

  public void setAdvertiserSubKeyword(String paramString)
  {
    this.pubQueue.execute(new bq(this, paramString));
  }

  public void setAdvertiserSubPublisher(String paramString)
  {
    this.pubQueue.execute(new e(this, paramString));
  }

  public void setAdvertiserSubSite(String paramString)
  {
    this.pubQueue.execute(new f(this, paramString));
  }

  public void setAge(int paramInt)
  {
    this.pubQueue.execute(new g(this, paramInt));
  }

  public void setAllowDuplicates(boolean paramBoolean)
  {
    this.pubQueue.execute(new bm(this, paramBoolean));
  }

  public void setAltitude(double paramDouble)
  {
    this.pubQueue.execute(new h(this, paramDouble));
  }

  public void setAndroidId(String paramString)
  {
    this.pubQueue.execute(new i(this, paramString));
  }

  public void setAppAdTrackingEnabled(boolean paramBoolean)
  {
    this.pubQueue.execute(new j(this, paramBoolean));
  }

  public void setCurrencyCode(String paramString)
  {
    this.pubQueue.execute(new k(this, paramString));
  }

  public void setDebugMode(boolean paramBoolean)
  {
    this.pubQueue.execute(new bn(this, paramBoolean));
  }

  public void setDeviceId(String paramString)
  {
    this.pubQueue.execute(new l(this, paramString));
  }

  public void setEventAttribute1(String paramString)
  {
    this.pubQueue.execute(new v(this, paramString));
  }

  public void setEventAttribute2(String paramString)
  {
    this.pubQueue.execute(new w(this, paramString));
  }

  public void setEventAttribute3(String paramString)
  {
    this.pubQueue.execute(new x(this, paramString));
  }

  public void setEventAttribute4(String paramString)
  {
    this.pubQueue.execute(new y(this, paramString));
  }

  public void setEventAttribute5(String paramString)
  {
    this.pubQueue.execute(new aa(this, paramString));
  }

  public void setEventContentId(String paramString)
  {
    this.pubQueue.execute(new n(this, paramString));
  }

  public void setEventContentType(String paramString)
  {
    this.pubQueue.execute(new m(this, paramString));
  }

  public void setEventDate1(Date paramDate)
  {
    this.pubQueue.execute(new t(this, paramDate));
  }

  public void setEventDate2(Date paramDate)
  {
    this.pubQueue.execute(new u(this, paramDate));
  }

  public void setEventLevel(int paramInt)
  {
    this.pubQueue.execute(new p(this, paramInt));
  }

  public void setEventQuantity(int paramInt)
  {
    this.pubQueue.execute(new q(this, paramInt));
  }

  public void setEventRating(float paramFloat)
  {
    this.pubQueue.execute(new s(this, paramFloat));
  }

  public void setEventSearchString(String paramString)
  {
    this.pubQueue.execute(new r(this, paramString));
  }

  public void setExistingUser(boolean paramBoolean)
  {
    this.pubQueue.execute(new ab(this, paramBoolean));
  }

  public void setFacebookUserId(String paramString)
  {
    this.pubQueue.execute(new ac(this, paramString));
  }

  public void setGender(int paramInt)
  {
    this.pubQueue.execute(new ad(this, paramInt));
  }

  public void setGoogleAdvertisingId(String paramString, boolean paramBoolean)
  {
    if (paramBoolean);
    for (int i = 1; ; i = 0)
    {
      this.pubQueue.execute(new ae(this, paramString, i));
      return;
    }
  }

  public void setGoogleUserId(String paramString)
  {
    this.pubQueue.execute(new af(this, paramString));
  }

  public void setInstallReferrer(String paramString)
  {
    this.pubQueue.execute(new ag(this, paramString));
  }

  public void setIsPayingUser(boolean paramBoolean)
  {
    this.pubQueue.execute(new ah(this, paramBoolean));
  }

  public void setLatitude(double paramDouble)
  {
    this.pubQueue.execute(new ai(this, paramDouble));
  }

  public void setLocation(Location paramLocation)
  {
    this.pubQueue.execute(new aj(this, paramLocation));
  }

  public void setLongitude(double paramDouble)
  {
    this.pubQueue.execute(new al(this, paramDouble));
  }

  public void setMATResponse(MATResponse paramMATResponse)
  {
    this.matResponse = paramMATResponse;
  }

  public void setMacAddress(String paramString)
  {
    this.pubQueue.execute(new am(this, paramString));
  }

  public void setOfferId(String paramString)
  {
    this.pubQueue.execute(new an(this, paramString));
  }

  public void setPackageName(String paramString)
  {
    this.pubQueue.execute(new ao(this, paramString));
  }

  public void setPluginName(String paramString)
  {
    if (Arrays.asList(a.a).contains(paramString))
      this.pubQueue.execute(new bl(this, paramString));
    while (!this.d)
      return;
    throw new IllegalArgumentException("Plugin name not acceptable");
  }

  public void setPublisherId(String paramString)
  {
    this.e = true;
    this.pubQueue.execute(new ap(this, paramString));
  }

  public void setPublisherReferenceId(String paramString)
  {
    this.pubQueue.execute(new aq(this, paramString));
  }

  public void setPublisherSub1(String paramString)
  {
    this.pubQueue.execute(new ay(this, paramString));
  }

  public void setPublisherSub2(String paramString)
  {
    this.pubQueue.execute(new az(this, paramString));
  }

  public void setPublisherSub3(String paramString)
  {
    this.pubQueue.execute(new ba(this, paramString));
  }

  public void setPublisherSub4(String paramString)
  {
    this.pubQueue.execute(new bb(this, paramString));
  }

  public void setPublisherSub5(String paramString)
  {
    this.pubQueue.execute(new bc(this, paramString));
  }

  public void setPublisherSubAd(String paramString)
  {
    this.pubQueue.execute(new ar(this, paramString));
  }

  public void setPublisherSubAdgroup(String paramString)
  {
    this.pubQueue.execute(new as(this, paramString));
  }

  public void setPublisherSubCampaign(String paramString)
  {
    this.pubQueue.execute(new at(this, paramString));
  }

  public void setPublisherSubKeyword(String paramString)
  {
    this.pubQueue.execute(new au(this, paramString));
  }

  public void setPublisherSubPublisher(String paramString)
  {
    this.pubQueue.execute(new aw(this, paramString));
  }

  public void setPublisherSubSite(String paramString)
  {
    this.pubQueue.execute(new ax(this, paramString));
  }

  public void setReferralSources(Activity paramActivity)
  {
    this.pubQueue.execute(new bd(this, paramActivity));
  }

  public void setSiteId(String paramString)
  {
    this.pubQueue.execute(new be(this, paramString));
  }

  public void setTRUSTeId(String paramString)
  {
    this.pubQueue.execute(new bf(this, paramString));
  }

  public void setTwitterUserId(String paramString)
  {
    this.pubQueue.execute(new bh(this, paramString));
  }

  public void setUserEmail(String paramString)
  {
    this.pubQueue.execute(new bi(this, paramString));
  }

  public void setUserId(String paramString)
  {
    this.pubQueue.execute(new bj(this, paramString));
  }

  public void setUserName(String paramString)
  {
    this.pubQueue.execute(new bk(this, paramString));
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.mobileapptracker.MobileAppTracker
 * JD-Core Version:    0.6.2
 */