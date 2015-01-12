package com.ubercab.client.feature.notification.data;

import android.os.Bundle;

public class FareSplitAcceptedNotificationData extends NotificationData
{
  private static final String KEY_MINION_NAME = "minion_name";
  private static final String KEY_MINION_PHOTO_URL = "minion_photo_url";
  private static final String KEY_TRIP_ID = "trip_id";
  public static final String TYPE = "fare_split_accepted";
  private String mMinionName;
  private String mMinionPhotoUrl;
  private String mTripId;

  protected FareSplitAcceptedNotificationData(NotificationData.Source paramSource)
  {
    super("fare_split_accepted", paramSource);
  }

  public static FareSplitAcceptedNotificationData createFakeData()
  {
    FareSplitAcceptedNotificationData localFareSplitAcceptedNotificationData = new FareSplitAcceptedNotificationData(NotificationData.Source.FAKE);
    localFareSplitAcceptedNotificationData.mTripId = "fake";
    localFareSplitAcceptedNotificationData.mMinionName = "Heisenberg";
    localFareSplitAcceptedNotificationData.mMinionPhotoUrl = "http://uber-mobile.s3.amazonaws.com/android-notification-testing/heisenberg.jpg";
    return localFareSplitAcceptedNotificationData;
  }

  public static FareSplitAcceptedNotificationData fromGcmBundle(Bundle paramBundle)
  {
    FareSplitAcceptedNotificationData localFareSplitAcceptedNotificationData = new FareSplitAcceptedNotificationData(NotificationData.Source.PUSH);
    localFareSplitAcceptedNotificationData.mTripId = paramBundle.getString("trip_id");
    localFareSplitAcceptedNotificationData.mMinionName = paramBundle.getString("minion_name");
    localFareSplitAcceptedNotificationData.mMinionPhotoUrl = paramBundle.getString("minion_photo_url");
    return localFareSplitAcceptedNotificationData;
  }

  public String getMinionName()
  {
    return this.mMinionName;
  }

  public String getMinionPhotoUrl()
  {
    return this.mMinionPhotoUrl;
  }

  public String getTag()
  {
    return this.mTripId;
  }

  public String getTripId()
  {
    return this.mTripId;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.notification.data.FareSplitAcceptedNotificationData
 * JD-Core Version:    0.6.2
 */