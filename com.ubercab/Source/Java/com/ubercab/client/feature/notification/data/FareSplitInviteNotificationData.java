package com.ubercab.client.feature.notification.data;

import android.os.Bundle;

public final class FareSplitInviteNotificationData extends NotificationData
{
  private static final String KEY_MASTER_NAME = "master_name";
  private static final String KEY_MASTER_PHOTO_URL = "master_photo_url";
  private static final String KEY_TRIP_ID = "trip_id";
  public static final String TYPE = "fare_split_invite";
  private String mMasterName;
  private String mMasterPhotoUrl;
  private String mTripId;

  private FareSplitInviteNotificationData(NotificationData.Source paramSource)
  {
    super("fare_split_invite", paramSource);
  }

  public static NotificationData createFakeData()
  {
    FareSplitInviteNotificationData localFareSplitInviteNotificationData = new FareSplitInviteNotificationData(NotificationData.Source.FAKE);
    localFareSplitInviteNotificationData.mTripId = "fake";
    localFareSplitInviteNotificationData.mMasterName = "Heisenberg";
    localFareSplitInviteNotificationData.mMasterPhotoUrl = "http://uber-mobile.s3.amazonaws.com/android-notification-testing/heisenberg.jpg";
    return localFareSplitInviteNotificationData;
  }

  public static FareSplitInviteNotificationData fromGcmBundle(Bundle paramBundle)
  {
    FareSplitInviteNotificationData localFareSplitInviteNotificationData = new FareSplitInviteNotificationData(NotificationData.Source.PUSH);
    localFareSplitInviteNotificationData.mTripId = paramBundle.getString("trip_id");
    localFareSplitInviteNotificationData.mMasterName = paramBundle.getString("master_name");
    localFareSplitInviteNotificationData.mMasterPhotoUrl = paramBundle.getString("master_photo_url");
    return localFareSplitInviteNotificationData;
  }

  public String getMasterName()
  {
    return this.mMasterName;
  }

  public String getMasterPhotoUrl()
  {
    return this.mMasterPhotoUrl;
  }

  public String getTag()
  {
    if (getSource() == NotificationData.Source.FAKE)
      return "fake";
    return null;
  }

  public String getTripId()
  {
    return this.mTripId;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.notification.data.FareSplitInviteNotificationData
 * JD-Core Version:    0.6.2
 */