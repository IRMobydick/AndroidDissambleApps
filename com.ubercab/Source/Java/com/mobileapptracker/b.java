package com.mobileapptracker;

import android.util.Log;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class b
{
  private static Parameters a;

  public static String a()
  {
    try
    {
      a = Parameters.getInstance();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("connection_type=" + a.getConnectionType());
      a(localStringBuilder, "age", a.getAge());
      a(localStringBuilder, "altitude", a.getAltitude());
      a(localStringBuilder, "android_id", a.getAndroidId());
      a(localStringBuilder, "app_ad_tracking", a.getAppAdTrackingEnabled());
      a(localStringBuilder, "app_name", a.getAppName());
      a(localStringBuilder, "app_version", a.getAppVersion());
      a(localStringBuilder, "country_code", a.getCountryCode());
      a(localStringBuilder, "currency_code", a.getCurrencyCode());
      a(localStringBuilder, "device_brand", a.getDeviceBrand());
      a(localStringBuilder, "device_carrier", a.getDeviceCarrier());
      a(localStringBuilder, "device_cpu_type", a.getDeviceCpuType());
      a(localStringBuilder, "device_cpu_subtype", a.getDeviceCpuSubtype());
      a(localStringBuilder, "device_model", a.getDeviceModel());
      a(localStringBuilder, "device_id", a.getDeviceId());
      a(localStringBuilder, "attribute_sub1", a.getEventAttribute1());
      a(localStringBuilder, "attribute_sub2", a.getEventAttribute2());
      a(localStringBuilder, "attribute_sub3", a.getEventAttribute3());
      a(localStringBuilder, "attribute_sub4", a.getEventAttribute4());
      a(localStringBuilder, "attribute_sub5", a.getEventAttribute5());
      a(localStringBuilder, "content_id", a.getEventContentId());
      a(localStringBuilder, "content_type", a.getEventContentType());
      a(localStringBuilder, "date1", a.getEventDate1());
      a(localStringBuilder, "date2", a.getEventDate2());
      a(localStringBuilder, "level", a.getEventLevel());
      a(localStringBuilder, "quantity", a.getEventQuantity());
      a(localStringBuilder, "rating", a.getEventRating());
      a(localStringBuilder, "search_string", a.getEventSearchString());
      a(localStringBuilder, "existing_user", a.getExistingUser());
      a(localStringBuilder, "facebook_user_id", a.getFacebookUserId());
      a(localStringBuilder, "gender", a.getGender());
      a(localStringBuilder, "google_aid", a.getGoogleAdvertisingId());
      a(localStringBuilder, "google_ad_tracking_disabled", a.getGoogleAdTrackingLimited());
      a(localStringBuilder, "google_user_id", a.getGoogleUserId());
      a(localStringBuilder, "insdate", a.getInstallDate());
      a(localStringBuilder, "installer", a.getInstaller());
      a(localStringBuilder, "install_log_id", a.getInstallLogId());
      a(localStringBuilder, "install_referrer", a.getInstallReferrer());
      a(localStringBuilder, "is_paying_user", a.getIsPayingUser());
      a(localStringBuilder, "language", a.getLanguage());
      a(localStringBuilder, "last_open_log_id", a.getLastOpenLogId());
      a(localStringBuilder, "latitude", a.getLatitude());
      a(localStringBuilder, "longitude", a.getLongitude());
      a(localStringBuilder, "mac_address", a.getMacAddress());
      a(localStringBuilder, "mat_id", a.getMatId());
      a(localStringBuilder, "mobile_country_code", a.getMCC());
      a(localStringBuilder, "mobile_network_code", a.getMNC());
      a(localStringBuilder, "open_log_id", a.getOpenLogId());
      a(localStringBuilder, "os_version", a.getOsVersion());
      a(localStringBuilder, "sdk_plugin", a.getPluginName());
      a(localStringBuilder, "android_purchase_status", a.getPurchaseStatus());
      a(localStringBuilder, "advertiser_ref_id", a.getRefId());
      a(localStringBuilder, "revenue", a.getRevenue());
      a(localStringBuilder, "screen_density", a.getScreenDensity());
      a(localStringBuilder, "screen_layout_size", a.getScreenWidth() + "x" + a.getScreenHeight());
      a(localStringBuilder, "sdk_version", a.getSdkVersion());
      a(localStringBuilder, "truste_tpid", a.getTRUSTeId());
      a(localStringBuilder, "twitter_user_id", a.getTwitterUserId());
      a(localStringBuilder, "update_log_id", a.getUpdateLogId());
      a(localStringBuilder, "conversion_user_agent", a.getUserAgent());
      a(localStringBuilder, "user_email", a.getUserEmail());
      a(localStringBuilder, "user_id", a.getUserId());
      a(localStringBuilder, "user_name", a.getUserName());
      String str = localStringBuilder.toString();
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public static String a(String paramString, Encryption paramEncryption)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder(paramString);
      Parameters localParameters = Parameters.getInstance();
      a = localParameters;
      if (localParameters != null)
      {
        String str1 = a.getGoogleAdvertisingId();
        if ((str1 != null) && (!paramString.contains("&google_aid=")))
        {
          a(localStringBuilder, "google_aid", str1);
          a(localStringBuilder, "google_ad_tracking_disabled", a.getGoogleAdTrackingLimited());
        }
        String str2 = a.getInstallReferrer();
        if ((str2 != null) && (!paramString.contains("&install_referrer=")))
          a(localStringBuilder, "install_referrer", str2);
      }
      if (!paramString.contains("&system_date="))
        a(localStringBuilder, "system_date", Long.toString(new Date().getTime() / 1000L));
      String str3 = localStringBuilder.toString();
      Object localObject2 = str3;
      try
      {
        String str4 = Encryption.bytesToHex(paramEncryption.encrypt((String)localObject2));
        localObject2 = str4;
        return localObject2;
      }
      catch (Exception localException)
      {
        while (true)
          localException.printStackTrace();
      }
    }
    finally
    {
    }
  }

  public static String a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    a = Parameters.getInstance();
    StringBuilder localStringBuilder = new StringBuilder("https://").append(a.getAdvertiserId()).append(".");
    if (paramBoolean1)
      localStringBuilder.append("debug.engine.mobileapptracking.com");
    while (true)
    {
      localStringBuilder.append("/serve?ver=").append(a.getSdkVersion());
      localStringBuilder.append("&transaction_id=").append(UUID.randomUUID().toString());
      a(localStringBuilder, "sdk", "android");
      a(localStringBuilder, "action", a.getAction());
      a(localStringBuilder, "advertiser_id", a.getAdvertiserId());
      a(localStringBuilder, "site_event_id", a.getEventId());
      a(localStringBuilder, "site_event_name", a.getEventName());
      a(localStringBuilder, "package_name", a.getPackageName());
      a(localStringBuilder, "referral_source", a.getReferralSource());
      a(localStringBuilder, "referral_url", a.getReferralUrl());
      a(localStringBuilder, "site_id", a.getSiteId());
      a(localStringBuilder, "tracking_id", a.getTrackingId());
      if (paramBoolean2)
        localStringBuilder.append("&attr_set=1");
      a(localStringBuilder, "publisher_id", a.getPublisherId());
      a(localStringBuilder, "offer_id", a.getOfferId());
      a(localStringBuilder, "publisher_ref_id", a.getPublisherReferenceId());
      a(localStringBuilder, "publisher_sub_publisher", a.getPublisherSubPublisher());
      a(localStringBuilder, "publisher_sub_site", a.getPublisherSubSite());
      a(localStringBuilder, "publisher_sub_campaign", a.getPublisherSubCampaign());
      a(localStringBuilder, "publisher_sub_adgroup", a.getPublisherSubAdgroup());
      a(localStringBuilder, "publisher_sub_ad", a.getPublisherSubAd());
      a(localStringBuilder, "publisher_sub_keyword", a.getPublisherSubKeyword());
      a(localStringBuilder, "advertiser_sub_publisher", a.getAdvertiserSubPublisher());
      a(localStringBuilder, "advertiser_sub_site", a.getAdvertiserSubSite());
      a(localStringBuilder, "advertiser_sub_campaign", a.getAdvertiserSubCampaign());
      a(localStringBuilder, "advertiser_sub_adgroup", a.getAdvertiserSubAdgroup());
      a(localStringBuilder, "advertiser_sub_ad", a.getAdvertiserSubAd());
      a(localStringBuilder, "advertiser_sub_keyword", a.getAdvertiserSubKeyword());
      a(localStringBuilder, "publisher_sub1", a.getPublisherSub1());
      a(localStringBuilder, "publisher_sub2", a.getPublisherSub2());
      a(localStringBuilder, "publisher_sub3", a.getPublisherSub3());
      a(localStringBuilder, "publisher_sub4", a.getPublisherSub4());
      a(localStringBuilder, "publisher_sub5", a.getPublisherSub5());
      String str = a.getAllowDuplicates();
      if ((str != null) && (Integer.parseInt(str) == 1))
        localStringBuilder.append("&skip_dup=1");
      if (paramBoolean1)
        localStringBuilder.append("&debug=1");
      if (paramBoolean3)
        localStringBuilder.append("&post_conversion=1");
      return localStringBuilder.toString();
      localStringBuilder.append("engine.mobileapptracking.com");
    }
  }

  public static JSONObject a(JSONArray paramJSONArray, String paramString1, String paramString2)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      if (paramJSONArray != null);
      try
      {
        localJSONObject.put("data", paramJSONArray);
        if (paramString1 != null)
          localJSONObject.put("store_iap_data", paramString1);
        if (paramString2 != null)
          localJSONObject.put("store_iap_signature", paramString2);
        return localJSONObject;
      }
      catch (JSONException localJSONException)
      {
        while (true)
        {
          Log.d("MobileAppTracker", "Could not build JSON for event items or verification values");
          localJSONException.printStackTrace();
        }
      }
    }
    finally
    {
    }
  }

  private static void a(StringBuilder paramStringBuilder, String paramString1, String paramString2)
  {
    if (paramString2 != null);
    try
    {
      boolean bool = paramString2.equals("");
      if (!bool);
      try
      {
        paramStringBuilder.append("&" + paramString1 + "=" + URLEncoder.encode(paramString2, "UTF-8"));
        return;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        while (true)
        {
          Log.w("MobileAppTracker", "failed encoding value " + paramString2 + " for key " + paramString1);
          localUnsupportedEncodingException.printStackTrace();
        }
      }
    }
    finally
    {
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.mobileapptracker.b
 * JD-Core Version:    0.6.2
 */