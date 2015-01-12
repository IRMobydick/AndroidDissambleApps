package com.adjust.sdk;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

public class PackageBuilder
{
  private double amountInCents;
  private String androidId;
  private String appToken;
  private Map<String, String> callbackParameters;
  private String clientSdk;
  private Context context;
  private long createdAt;
  private Map<String, String> deepLinkParameters;
  private String defaultTracker;
  private String environment;
  private int eventCount;
  private String eventToken;
  private String fbAttributionId;
  private long lastInterval;
  private String macSha1;
  private String macShortMd5;
  private String referrer;
  private int sessionCount;
  private long sessionLength;
  private int subsessionCount;
  private long timeSpent;
  private String userAgent;
  private String uuid;

  public PackageBuilder(Context paramContext)
  {
    this.context = paramContext;
  }

  private void addDate(Map<String, String> paramMap, String paramString, long paramLong)
  {
    if (paramLong < 0L)
      return;
    addString(paramMap, paramString, Util.dateFormat(paramLong));
  }

  private void addDuration(Map<String, String> paramMap, String paramString, long paramLong)
  {
    if (paramLong < 0L)
      return;
    addInt(paramMap, paramString, (500L + paramLong) / 1000L);
  }

  private void addInt(Map<String, String> paramMap, String paramString, long paramLong)
  {
    if (paramLong < 0L)
      return;
    addString(paramMap, paramString, Long.toString(paramLong));
  }

  private void addMapBase64(Map<String, String> paramMap1, String paramString, Map<String, String> paramMap2)
  {
    if (paramMap2 == null)
      return;
    addString(paramMap1, paramString, Base64.encodeToString(new JSONObject(paramMap2).toString().getBytes(), 2));
  }

  private void addMapJson(Map<String, String> paramMap1, String paramString, Map<String, String> paramMap2)
  {
    if (paramMap2 == null)
      return;
    addString(paramMap1, paramString, new JSONObject(paramMap2).toString());
  }

  private void addString(Map<String, String> paramMap, String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2))
      return;
    paramMap.put(paramString1, paramString2);
  }

  private String getAmountString()
  {
    long l = Math.round(10.0D * this.amountInCents);
    this.amountInCents = (l / 10.0D);
    return Long.toString(l);
  }

  private ActivityPackage getDefaultActivityPackage()
  {
    ActivityPackage localActivityPackage = new ActivityPackage();
    localActivityPackage.setUserAgent(this.userAgent);
    localActivityPackage.setClientSdk(this.clientSdk);
    return localActivityPackage;
  }

  private Map<String, String> getDefaultParameters()
  {
    HashMap localHashMap = new HashMap();
    addDate(localHashMap, "created_at", this.createdAt);
    addString(localHashMap, "app_token", this.appToken);
    addString(localHashMap, "mac_sha1", this.macSha1);
    addString(localHashMap, "mac_md5", this.macShortMd5);
    addString(localHashMap, "android_id", this.androidId);
    addString(localHashMap, "android_uuid", this.uuid);
    addString(localHashMap, "fb_id", this.fbAttributionId);
    addString(localHashMap, "environment", this.environment);
    addString(localHashMap, "gps_adid", Util.getGpsAdid(this.context));
    addInt(localHashMap, "session_count", this.sessionCount);
    addInt(localHashMap, "subsession_count", this.subsessionCount);
    addDuration(localHashMap, "session_length", this.sessionLength);
    addDuration(localHashMap, "time_spent", this.timeSpent);
    return localHashMap;
  }

  private String getEventSuffix()
  {
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = this.eventToken;
    return String.format(" '%s'", arrayOfObject);
  }

  private String getRevenueSuffix()
  {
    if (this.eventToken != null)
    {
      Locale localLocale2 = Locale.US;
      Object[] arrayOfObject2 = new Object[2];
      arrayOfObject2[0] = Double.valueOf(this.amountInCents);
      arrayOfObject2[1] = this.eventToken;
      return String.format(localLocale2, " (%.1f cent, '%s')", arrayOfObject2);
    }
    Locale localLocale1 = Locale.US;
    Object[] arrayOfObject1 = new Object[1];
    arrayOfObject1[0] = Double.valueOf(this.amountInCents);
    return String.format(localLocale1, " (%.1f cent)", arrayOfObject1);
  }

  private void injectEventParameters(Map<String, String> paramMap)
  {
    addInt(paramMap, "event_count", this.eventCount);
    addString(paramMap, "event_token", this.eventToken);
    addMapBase64(paramMap, "params", this.callbackParameters);
  }

  private boolean isEventTokenValid()
  {
    if (6 != this.eventToken.length())
    {
      Logger localLogger = AdjustFactory.getLogger();
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = this.eventToken;
      localLogger.error(String.format("Malformed Event Token '%s'", arrayOfObject));
      return false;
    }
    return true;
  }

  public ActivityPackage buildEventPackage()
  {
    Map localMap = getDefaultParameters();
    injectEventParameters(localMap);
    ActivityPackage localActivityPackage = getDefaultActivityPackage();
    localActivityPackage.setPath("/event");
    localActivityPackage.setActivityKind(ActivityKind.EVENT);
    localActivityPackage.setSuffix(getEventSuffix());
    localActivityPackage.setParameters(localMap);
    return localActivityPackage;
  }

  public ActivityPackage buildReattributionPackage()
  {
    Map localMap = getDefaultParameters();
    addMapJson(localMap, "deeplink_parameters", this.deepLinkParameters);
    ActivityPackage localActivityPackage = getDefaultActivityPackage();
    localActivityPackage.setPath("/reattribute");
    localActivityPackage.setActivityKind(ActivityKind.REATTRIBUTION);
    localActivityPackage.setSuffix("");
    localActivityPackage.setParameters(localMap);
    return localActivityPackage;
  }

  public ActivityPackage buildRevenuePackage()
  {
    Map localMap = getDefaultParameters();
    injectEventParameters(localMap);
    addString(localMap, "amount", getAmountString());
    ActivityPackage localActivityPackage = getDefaultActivityPackage();
    localActivityPackage.setPath("/revenue");
    localActivityPackage.setActivityKind(ActivityKind.REVENUE);
    localActivityPackage.setSuffix(getRevenueSuffix());
    localActivityPackage.setParameters(localMap);
    return localActivityPackage;
  }

  public ActivityPackage buildSessionPackage()
  {
    Map localMap = getDefaultParameters();
    addDuration(localMap, "last_interval", this.lastInterval);
    addString(localMap, "default_tracker", this.defaultTracker);
    addString(localMap, "referrer", this.referrer);
    ActivityPackage localActivityPackage = getDefaultActivityPackage();
    localActivityPackage.setPath("/startup");
    localActivityPackage.setActivityKind(ActivityKind.SESSION);
    localActivityPackage.setSuffix("");
    localActivityPackage.setParameters(localMap);
    return localActivityPackage;
  }

  public double getAmountInCents()
  {
    return this.amountInCents;
  }

  public String getEventToken()
  {
    return this.eventToken;
  }

  public boolean isValidForEvent()
  {
    if (this.eventToken == null)
    {
      AdjustFactory.getLogger().error("Missing Event Token");
      return false;
    }
    return isEventTokenValid();
  }

  public boolean isValidForRevenue()
  {
    if (this.amountInCents < 0.0D)
    {
      Logger localLogger = AdjustFactory.getLogger();
      Locale localLocale = Locale.US;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Double.valueOf(this.amountInCents);
      localLogger.error(String.format(localLocale, "Invalid amount %f", arrayOfObject));
      return false;
    }
    if (this.eventToken == null)
      return true;
    return isEventTokenValid();
  }

  public void setAmountInCents(double paramDouble)
  {
    this.amountInCents = paramDouble;
  }

  public void setAndroidId(String paramString)
  {
    this.androidId = paramString;
  }

  public void setAppToken(String paramString)
  {
    this.appToken = paramString;
  }

  public void setCallbackParameters(Map<String, String> paramMap)
  {
    this.callbackParameters = paramMap;
  }

  public void setClientSdk(String paramString)
  {
    this.clientSdk = paramString;
  }

  public void setCreatedAt(long paramLong)
  {
    this.createdAt = paramLong;
  }

  public void setDeepLinkParameters(Map<String, String> paramMap)
  {
    this.deepLinkParameters = paramMap;
  }

  public void setDefaultTracker(String paramString)
  {
    this.defaultTracker = paramString;
  }

  public void setEnvironment(String paramString)
  {
    this.environment = paramString;
  }

  public void setEventCount(int paramInt)
  {
    this.eventCount = paramInt;
  }

  public void setEventToken(String paramString)
  {
    this.eventToken = paramString;
  }

  public void setFbAttributionId(String paramString)
  {
    this.fbAttributionId = paramString;
  }

  public void setLastInterval(long paramLong)
  {
    this.lastInterval = paramLong;
  }

  public void setMacSha1(String paramString)
  {
    this.macSha1 = paramString;
  }

  public void setMacShortMd5(String paramString)
  {
    this.macShortMd5 = paramString;
  }

  public void setReferrer(String paramString)
  {
    this.referrer = paramString;
  }

  public void setSessionCount(int paramInt)
  {
    this.sessionCount = paramInt;
  }

  public void setSessionLength(long paramLong)
  {
    this.sessionLength = paramLong;
  }

  public void setSubsessionCount(int paramInt)
  {
    this.subsessionCount = paramInt;
  }

  public void setTimeSpent(long paramLong)
  {
    this.timeSpent = paramLong;
  }

  public void setUserAgent(String paramString)
  {
    this.userAgent = paramString;
  }

  public void setUuid(String paramString)
  {
    this.uuid = paramString;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.adjust.sdk.PackageBuilder
 * JD-Core Version:    0.6.2
 */