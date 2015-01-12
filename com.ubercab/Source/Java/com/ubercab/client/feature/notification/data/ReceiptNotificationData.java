package com.ubercab.client.feature.notification.data;

import android.os.Bundle;

public final class ReceiptNotificationData extends NotificationData
{
  private static final String KEY_AMOUNT_CHARGED = "amount_charged";
  private static final String KEY_CREDITS_USED = "credits_used";
  private static final String KEY_DRIVER_NAME = "driver_name";
  private static final String KEY_DRIVER_PHOTO_URL = "driver_photo_url";
  private static final String KEY_MAP_IMAGE_URL = "map_image_url";
  private static final String KEY_TRIP_ID = "trip_id";
  private static final String KEY_VEHICLE_EXTERIOR_COLOR = "vehicle_exterior_color";
  private static final String KEY_VEHICLE_LICENSE = "vehicle_license";
  private static final String KEY_VEHICLE_MODEL = "vehicle_model";
  private static final String KEY_VEHICLE_PHOTO_URL = "vehicle_photo_url";
  private static final String KEY_VEHICLE_VIEW_NAME = "vehicle_view_name";
  public static final String TYPE = "receipt";
  private String mAmountCharged;
  private String mCreditsUsed;
  private String mDriverName;
  private String mDriverPhotoUrl;
  private String mMapImageUrl;
  private String mTripId;
  private String mVehicleExteriorColor;
  private String mVehicleLicense;
  private String mVehicleModel;
  private String mVehiclePhotoUrl;
  private String mVehicleViewName;

  private ReceiptNotificationData(NotificationData.Source paramSource)
  {
    super("receipt", paramSource);
  }

  public static ReceiptNotificationData createFakeData()
  {
    ReceiptNotificationData localReceiptNotificationData = new ReceiptNotificationData(NotificationData.Source.FAKE);
    localReceiptNotificationData.mAmountCharged = "$5.99";
    localReceiptNotificationData.mCreditsUsed = "50";
    localReceiptNotificationData.mDriverName = "Heisenberg";
    localReceiptNotificationData.mDriverPhotoUrl = "http://uber-mobile.s3.amazonaws.com/android-notification-testing/heisenberg.jpg";
    localReceiptNotificationData.mMapImageUrl = "http://uber-mobile.s3.amazonaws.com/android-notification-testing/heisenberg.jpg";
    localReceiptNotificationData.mTimestamp = Long.valueOf(1412146799L);
    localReceiptNotificationData.mTripId = "fake";
    localReceiptNotificationData.mVehicleExteriorColor = "Black";
    localReceiptNotificationData.mVehicleLicense = "COOK";
    localReceiptNotificationData.mVehicleModel = "Bounder";
    localReceiptNotificationData.mVehiclePhotoUrl = "http://uber-mobile.s3.amazonaws.com/android-notification-testing/bounder.jpg";
    localReceiptNotificationData.mVehicleViewName = "Uber Black";
    return localReceiptNotificationData;
  }

  static ReceiptNotificationData fromGcmBundle(Bundle paramBundle)
  {
    ReceiptNotificationData localReceiptNotificationData = new ReceiptNotificationData(NotificationData.Source.PUSH);
    localReceiptNotificationData.mAmountCharged = paramBundle.getString("amount_charged");
    localReceiptNotificationData.mCreditsUsed = paramBundle.getString("credits_used");
    localReceiptNotificationData.mDriverName = paramBundle.getString("driver_name");
    localReceiptNotificationData.mDriverPhotoUrl = paramBundle.getString("driver_photo_url");
    localReceiptNotificationData.mMapImageUrl = paramBundle.getString("map_image_url");
    localReceiptNotificationData.mTripId = paramBundle.getString("trip_id");
    localReceiptNotificationData.mVehicleExteriorColor = paramBundle.getString("vehicle_exterior_color");
    localReceiptNotificationData.mVehicleLicense = paramBundle.getString("vehicle_license");
    localReceiptNotificationData.mVehicleModel = paramBundle.getString("vehicle_model");
    localReceiptNotificationData.mVehiclePhotoUrl = paramBundle.getString("vehicle_photo_url");
    localReceiptNotificationData.mVehicleViewName = paramBundle.getString("vehicle_view_name");
    return localReceiptNotificationData;
  }

  public String getAmountCharged()
  {
    return this.mAmountCharged;
  }

  public String getCreditsUsed()
  {
    return this.mCreditsUsed;
  }

  public String getDriverName()
  {
    return this.mDriverName;
  }

  public String getDriverPhotoUrl()
  {
    return this.mDriverPhotoUrl;
  }

  public String getMapImageUrl()
  {
    return this.mMapImageUrl;
  }

  public String getTag()
  {
    return this.mTripId;
  }

  public String getTripId()
  {
    return this.mTripId;
  }

  public String getVehicleExteriorColor()
  {
    return this.mVehicleExteriorColor;
  }

  public String getVehicleLicense()
  {
    return this.mVehicleLicense;
  }

  public String getVehicleModel()
  {
    return this.mVehicleModel;
  }

  public String getVehiclePhotoUrl()
  {
    return this.mVehiclePhotoUrl;
  }

  public String getVehicleViewName()
  {
    return this.mVehicleViewName;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.notification.data.ReceiptNotificationData
 * JD-Core Version:    0.6.2
 */