package com.ubercab.client.feature.notification.data;

import android.os.Bundle;
import com.ubercab.client.core.util.NumberUtils;

public final class SurgeNotificationData extends NotificationData
{
  private static final String KEY_FALLBACK_TEXT = "fallback_text";
  private static final String KEY_FARE_ID = "fare_id";
  private static final String KEY_NEW_MULTIPLIER = "new_multiplier";
  private static final String KEY_OLD_MULTIPLIER = "old_multiplier";
  private static final String KEY_VEHICLE_VIEW_NAME = "vehicle_view_name";
  public static final String TYPE = "surge";
  private String mFallbackText;
  private String mFareId;
  private float mNewMultiplier;
  private float mOldMultiplier;
  private String mVehicleViewName;

  public SurgeNotificationData(NotificationData.Source paramSource)
  {
    super("surge", paramSource);
  }

  public static SurgeNotificationData createFakeData()
  {
    SurgeNotificationData localSurgeNotificationData = new SurgeNotificationData(NotificationData.Source.FAKE);
    localSurgeNotificationData.mFareId = "1";
    localSurgeNotificationData.mVehicleViewName = "uberX";
    localSurgeNotificationData.mOldMultiplier = 2.75F;
    localSurgeNotificationData.mNewMultiplier = 1.0F;
    localSurgeNotificationData.mFallbackText = "Rates have dropped at your most recent pickup location. Request a ride as soon as possible to avoid surge pricing.";
    return localSurgeNotificationData;
  }

  public static SurgeNotificationData fromGcmBundle(Bundle paramBundle)
  {
    SurgeNotificationData localSurgeNotificationData = new SurgeNotificationData(NotificationData.Source.PUSH);
    localSurgeNotificationData.mFareId = paramBundle.getString("fare_id");
    localSurgeNotificationData.mVehicleViewName = paramBundle.getString("vehicle_view_name");
    localSurgeNotificationData.mOldMultiplier = NumberUtils.tryParseFloat(paramBundle.getString("old_multiplier"), 0.0F);
    localSurgeNotificationData.mNewMultiplier = NumberUtils.tryParseFloat(paramBundle.getString("new_multiplier"), 0.0F);
    localSurgeNotificationData.mFallbackText = paramBundle.getString("fallback_text");
    return localSurgeNotificationData;
  }

  public String getFallbackText()
  {
    return this.mFallbackText;
  }

  public String getFareId()
  {
    return this.mFareId;
  }

  public float getNewMultiplier()
  {
    return this.mNewMultiplier;
  }

  public float getOldMultiplier()
  {
    return this.mOldMultiplier;
  }

  public String getTag()
  {
    return this.mFareId;
  }

  public String getVehicleViewName()
  {
    return this.mVehicleViewName;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.notification.data.SurgeNotificationData
 * JD-Core Version:    0.6.2
 */