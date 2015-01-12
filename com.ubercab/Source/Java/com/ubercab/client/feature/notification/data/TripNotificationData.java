package com.ubercab.client.feature.notification.data;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.ubercab.client.core.model.Client;
import com.ubercab.client.core.model.CnLocation;
import com.ubercab.client.core.model.FareSplit;
import com.ubercab.client.core.model.FareSplitClient;
import com.ubercab.client.core.model.Ping;
import com.ubercab.client.core.model.Trip;
import com.ubercab.client.core.model.TripDriver;
import com.ubercab.client.core.model.TripVehicle;
import com.ubercab.client.core.model.TripVehicleType;
import com.ubercab.client.core.model.VehicleView;
import com.ubercab.client.core.util.NumberUtils;
import com.ubercab.client.core.util.PingUtils;
import com.ubercab.common.base.Optional;
import com.ubercab.common.base.Predicate;
import com.ubercab.common.collect.ImmutableList;
import com.ubercab.common.collect.ImmutableList.Builder;
import com.ubercab.common.collect.Iterables;
import com.ubercab.common.collect.Lists;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class TripNotificationData extends NotificationData
{
  private static final String KEY_DESTINATION = "destination";
  private static final String KEY_DRIVER_EXTRA = "driver_extra";
  private static final String KEY_DRIVER_NAME = "driver_name";
  private static final String KEY_DRIVER_PHOTO_URL = "driver_photo_url";
  private static final String KEY_FALLBACK_TEXT = "fallback_text";
  private static final String KEY_FARE_SPLIT_CLIENTS = "fare_split_clients";
  private static final String KEY_IS_MASTER = "is_master";
  private static final String KEY_PICKUP_ADDRESS = "pickup_address";
  private static final String KEY_SURGE_MULTIPLIER = "surge_multiplier";
  private static final String KEY_TRIP_ETA = "trip_eta";
  private static final String KEY_TRIP_ID = "trip_id";
  private static final String KEY_TRIP_STATUS = "trip_status";
  private static final String KEY_VEHICLE_LICENSE = "vehicle_license";
  private static final String KEY_VEHICLE_MAKE = "vehicle_make";
  private static final String KEY_VEHICLE_MODEL = "vehicle_model";
  private static final String KEY_VEHICLE_PHOTO_URL = "vehicle_photo_url";
  private static final String KEY_VEHICLE_VIEW_MONO_IMAGE_URL = "vehicle_view_mono_image_url";
  private static final String KEY_VEHICLE_VIEW_NAME = "vehicle_view_name";
  public static final String STATUS_ACCEPTED = "accepted";
  public static final String STATUS_ARRIVED = "arrived";
  public static final String STATUS_CANCELED = "canceled";
  public static final String STATUS_DISPATCHING = "dispatching";
  public static final String STATUS_ENDED = "ended";
  public static final String STATUS_ON_TRIP = "on_trip";
  public static final String STATUS_REDISPATCHING = "redispatching";
  public static final String TYPE = "trip";
  private TripDestinationData mDestination;
  private String mDriverExtra;
  private String mDriverName;
  private String mDriverPhotoUrl;
  private String mFallbackText;
  private List<FareSplitClient> mFareSplitClients;
  private boolean mIsMaster;
  private String mPickupAddress;
  private float mSurgeMultiplier;
  private int mTripEta;
  private String mTripId;
  private String mTripStatus;
  private String mVehicleLicense;
  private String mVehicleMake;
  private String mVehicleModel;
  private String mVehiclePhotoUrl;
  private String mVehicleViewMonoImageUrl;
  private String mVehicleViewName;

  private TripNotificationData(NotificationData.Source paramSource)
  {
    super("trip", paramSource);
  }

  public static TripNotificationData createFakeData(String paramString, int paramInt1, int paramInt2)
  {
    if (paramInt2 > paramInt1)
      throw new IllegalArgumentException();
    TripNotificationData localTripNotificationData = new TripNotificationData(NotificationData.Source.FAKE);
    localTripNotificationData.mTripId = "fake";
    localTripNotificationData.mTripStatus = paramString;
    localTripNotificationData.mTripEta = 14;
    localTripNotificationData.mIsMaster = true;
    localTripNotificationData.mSurgeMultiplier = 1.5F;
    localTripNotificationData.mVehicleViewName = "uberXL";
    localTripNotificationData.mVehicleViewMonoImageUrl = "http://d1a3f4spazzrp4.cloudfront.net/car-types/mono/mono-uberx.png";
    localTripNotificationData.mVehiclePhotoUrl = "http://uber-mobile.s3.amazonaws.com/android-notification-testing/bounder.jpg";
    localTripNotificationData.mVehicleMake = "Fleetwood";
    localTripNotificationData.mVehicleModel = "Bounder";
    localTripNotificationData.mVehicleLicense = "COOK";
    localTripNotificationData.mPickupAddress = "706 Mission St";
    localTripNotificationData.mDestination = TripDestinationData.createFakeTripDestinationData();
    localTripNotificationData.mDriverExtra = "BASE - xkyksl";
    localTripNotificationData.mDriverName = "Heisenberg";
    localTripNotificationData.mDriverPhotoUrl = "http://uber-mobile.s3.amazonaws.com/android-notification-testing/heisenberg.jpg";
    if (paramInt1 > 0)
    {
      localTripNotificationData.mFareSplitClients = new ArrayList();
      int i = 0;
      if (i < paramInt1)
      {
        if (i < paramInt2);
        for (String str = "Accepted"; ; str = "Pending")
        {
          localTripNotificationData.mFareSplitClients.add(FareSplitClient.createFake(i, str));
          i++;
          break;
        }
      }
    }
    return localTripNotificationData;
  }

  public static TripNotificationData fromGcmBundle(Gson paramGson, Bundle paramBundle)
  {
    TripNotificationData localTripNotificationData = new TripNotificationData(NotificationData.Source.PUSH);
    localTripNotificationData.mTripStatus = paramBundle.getString("trip_status");
    localTripNotificationData.mTripId = paramBundle.getString("trip_id");
    localTripNotificationData.mTripEta = ((int)Math.ceil(NumberUtils.tryParseDouble(paramBundle.getString("trip_eta"), 0.0D) / 60.0D));
    localTripNotificationData.mIsMaster = Boolean.parseBoolean(paramBundle.getString("is_master"));
    localTripNotificationData.mDriverExtra = paramBundle.getString("driver_extra");
    localTripNotificationData.mDriverName = paramBundle.getString("driver_name");
    localTripNotificationData.mDriverPhotoUrl = paramBundle.getString("driver_photo_url");
    localTripNotificationData.mVehicleViewName = paramBundle.getString("vehicle_view_name");
    localTripNotificationData.mVehicleViewMonoImageUrl = paramBundle.getString("vehicle_view_mono_image_url");
    localTripNotificationData.mVehicleMake = paramBundle.getString("vehicle_make");
    localTripNotificationData.mVehicleModel = paramBundle.getString("vehicle_model");
    localTripNotificationData.mVehicleLicense = paramBundle.getString("vehicle_license");
    localTripNotificationData.mVehiclePhotoUrl = paramBundle.getString("vehicle_photo_url");
    localTripNotificationData.mPickupAddress = paramBundle.getString("pickup_address");
    localTripNotificationData.mSurgeMultiplier = NumberUtils.tryParseFloat(paramBundle.getString("surge_multiplier"), 0.0F);
    localTripNotificationData.mFallbackText = paramBundle.getString("fallback_text");
    localTripNotificationData.mDestination = ((TripDestinationData)paramGson.fromJson(paramBundle.getString("destination"), TripDestinationData.class));
    String str = paramBundle.getString("fare_split_clients");
    if (!TextUtils.isEmpty(str))
    {
      localTripNotificationData.mFareSplitClients = ((List)paramGson.fromJson(str, new TypeToken()
      {
      }
      .getType()));
      return localTripNotificationData;
    }
    localTripNotificationData.mFareSplitClients = ImmutableList.of();
    return localTripNotificationData;
  }

  public static TripNotificationData fromPing(Ping paramPing)
  {
    TripNotificationData localTripNotificationData = new TripNotificationData(NotificationData.Source.PING);
    if (!PingUtils.hasTrip(paramPing))
      localTripNotificationData.mTripStatus = "ended";
    while (true)
    {
      return localTripNotificationData;
      if ((!PingUtils.hasFareSplit(paramPing)) || (paramPing.getFareSplit().getClientSelf().isInitiator()));
      for (boolean bool = true; !bool; bool = false)
      {
        localTripNotificationData.mTripStatus = "ended";
        return localTripNotificationData;
      }
      Trip localTrip = paramPing.getTrip();
      TripDriver localTripDriver = localTrip.getDriver();
      TripVehicle localTripVehicle = localTrip.getVehicle();
      localTripNotificationData.mTripStatus = statusFromPing(paramPing);
      localTripNotificationData.mTripId = paramPing.getTrip().getId();
      localTripNotificationData.mTripEta = localTrip.getEta();
      localTripNotificationData.mIsMaster = bool;
      localTripNotificationData.mDriverName = localTripDriver.getName();
      localTripNotificationData.mDriverPhotoUrl = localTripDriver.getPictureUrl();
      localTripNotificationData.mVehicleLicense = localTripVehicle.getLicensePlate();
      TripVehicleType localTripVehicleType = localTripVehicle.getVehicleType();
      if (localTripVehicleType != null)
      {
        localTripNotificationData.mVehicleMake = localTripVehicleType.getMake();
        localTripNotificationData.mVehicleModel = localTripVehicleType.getModel();
      }
      CnLocation localCnLocation1 = localTrip.getPickupLocation();
      if (localCnLocation1 != null)
        localTripNotificationData.mPickupAddress = localCnLocation1.getFormattedAddress();
      CnLocation localCnLocation2 = localTrip.getDestination();
      if (localCnLocation2 != null)
        localTripNotificationData.mDestination = TripDestinationData.fromCnLocation(localCnLocation2);
      VehicleView localVehicleView = paramPing.getTripVehicleView();
      if (localVehicleView != null)
      {
        localTripNotificationData.mVehicleViewName = localVehicleView.getDescription();
        localTripNotificationData.mVehicleViewMonoImageUrl = localVehicleView.getMonoImagePublicUri().toString();
      }
      if (PingUtils.hasFareSplit(paramPing))
      {
        FareSplit localFareSplit = paramPing.getFareSplit();
        localTripNotificationData.mFareSplitClients = new ArrayList();
        Iterator localIterator = localFareSplit.getClients().iterator();
        while (localIterator.hasNext())
        {
          FareSplitClient localFareSplitClient = (FareSplitClient)localIterator.next();
          if (!localFareSplitClient.isSelf())
            localTripNotificationData.mFareSplitClients.add(FareSplitClient.fromFareSplitClient(localFareSplitClient));
        }
      }
    }
  }

  private static String statusFromPing(Ping paramPing)
  {
    String str = paramPing.getClient().getStatus();
    int i = -1;
    switch (str.hashCode())
    {
    default:
    case -1561136888:
    case -1978426120:
    case -1929061692:
    }
    while (true)
      switch (i)
      {
      default:
        return "ended";
        if (str.equals("Dispatching"))
        {
          i = 0;
          continue;
          if (str.equals("WaitingForPickup"))
          {
            i = 1;
            continue;
            if (str.equals("OnTrip"))
              i = 2;
          }
        }
        break;
      case 0:
      case 1:
      case 2:
      }
    return "dispatching";
    if (paramPing.getTrip().getDriver().getStatus().equals("Arrived"))
      return "arrived";
    return "accepted";
    return "on_trip";
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    TripNotificationData localTripNotificationData;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localTripNotificationData = (TripNotificationData)paramObject;
      if (this.mIsMaster != localTripNotificationData.mIsMaster)
        return false;
      if (Float.compare(localTripNotificationData.mSurgeMultiplier, this.mSurgeMultiplier) != 0)
        return false;
      if (this.mTripEta != localTripNotificationData.mTripEta)
        return false;
      if (this.mDestination != null)
      {
        if (this.mDestination.equals(localTripNotificationData.mDestination));
      }
      else
        while (localTripNotificationData.mDestination != null)
          return false;
      if (this.mDriverExtra != null)
      {
        if (this.mDriverExtra.equals(localTripNotificationData.mDriverExtra));
      }
      else
        while (localTripNotificationData.mDriverExtra != null)
          return false;
      if (this.mDriverName != null)
      {
        if (this.mDriverName.equals(localTripNotificationData.mDriverName));
      }
      else
        while (localTripNotificationData.mDriverName != null)
          return false;
      if (this.mDriverPhotoUrl != null)
      {
        if (this.mDriverPhotoUrl.equals(localTripNotificationData.mDriverPhotoUrl));
      }
      else
        while (localTripNotificationData.mDriverPhotoUrl != null)
          return false;
      if (this.mFallbackText != null)
      {
        if (this.mFallbackText.equals(localTripNotificationData.mFallbackText));
      }
      else
        while (localTripNotificationData.mFallbackText != null)
          return false;
      if (this.mFareSplitClients != null)
      {
        if (this.mFareSplitClients.equals(localTripNotificationData.mFareSplitClients));
      }
      else
        while (localTripNotificationData.mFareSplitClients != null)
          return false;
      if (this.mPickupAddress != null)
      {
        if (this.mPickupAddress.equals(localTripNotificationData.mPickupAddress));
      }
      else
        while (localTripNotificationData.mPickupAddress != null)
          return false;
      if (this.mTripId != null)
      {
        if (this.mTripId.equals(localTripNotificationData.mTripId));
      }
      else
        while (localTripNotificationData.mTripId != null)
          return false;
      if (this.mTripStatus != null)
      {
        if (this.mTripStatus.equals(localTripNotificationData.mTripStatus));
      }
      else
        while (localTripNotificationData.mTripStatus != null)
          return false;
      if (this.mVehicleLicense != null)
      {
        if (this.mVehicleLicense.equals(localTripNotificationData.mVehicleLicense));
      }
      else
        while (localTripNotificationData.mVehicleLicense != null)
          return false;
      if (this.mVehicleMake != null)
      {
        if (this.mVehicleMake.equals(localTripNotificationData.mVehicleMake));
      }
      else
        while (localTripNotificationData.mVehicleMake != null)
          return false;
      if (this.mVehicleModel != null)
      {
        if (this.mVehicleModel.equals(localTripNotificationData.mVehicleModel));
      }
      else
        while (localTripNotificationData.mVehicleModel != null)
          return false;
      if (this.mVehiclePhotoUrl != null)
      {
        if (this.mVehiclePhotoUrl.equals(localTripNotificationData.mVehiclePhotoUrl));
      }
      else
        while (localTripNotificationData.mVehiclePhotoUrl != null)
          return false;
      if (this.mVehicleViewMonoImageUrl != null)
      {
        if (this.mVehicleViewMonoImageUrl.equals(localTripNotificationData.mVehicleViewMonoImageUrl));
      }
      else
        while (localTripNotificationData.mVehicleViewMonoImageUrl != null)
          return false;
      if (this.mVehicleViewName == null)
        break;
    }
    while (this.mVehicleViewName.equals(localTripNotificationData.mVehicleViewName));
    while (true)
    {
      return false;
      if (localTripNotificationData.mVehicleViewName == null)
        break;
    }
  }

  public FareSplitClient findClient(final String paramString)
  {
    return (FareSplitClient)Iterables.tryFind(this.mFareSplitClients, new Predicate()
    {
      public boolean apply(TripNotificationData.FareSplitClient paramAnonymousFareSplitClient)
      {
        return paramAnonymousFareSplitClient.getId().equals(paramString);
      }
    }).orNull();
  }

  public List<FareSplitClient> getAcceptedFareSplitClientsSince(final TripNotificationData paramTripNotificationData)
  {
    if ((this.mFareSplitClients == null) || (paramTripNotificationData == null) || (paramTripNotificationData.getFareSplitClients() == null))
      return null;
    ArrayList localArrayList = Lists.newArrayList(Iterables.filter(this.mFareSplitClients, new Predicate()
    {
      public boolean apply(TripNotificationData.FareSplitClient paramAnonymousFareSplitClient)
      {
        TripNotificationData.FareSplitClient localFareSplitClient = paramTripNotificationData.findClient(paramAnonymousFareSplitClient.getId());
        return (localFareSplitClient != null) && (paramAnonymousFareSplitClient.getStatus().equals("Accepted")) && (!localFareSplitClient.getStatus().equals("Accepted"));
      }
    }));
    return new ImmutableList.Builder().addAll(localArrayList).build();
  }

  public String getDriverExtra()
  {
    return this.mDriverExtra;
  }

  public String getDriverName()
  {
    return this.mDriverName;
  }

  public String getDriverPhotoUrl()
  {
    return this.mDriverPhotoUrl;
  }

  public String getFallbackText()
  {
    return this.mFallbackText;
  }

  public List<FareSplitClient> getFareSplitClients()
  {
    return this.mFareSplitClients;
  }

  public int getJoinedFareSplitClientsCount()
  {
    return Iterables.size(Iterables.filter(this.mFareSplitClients, new Predicate()
    {
      public boolean apply(TripNotificationData.FareSplitClient paramAnonymousFareSplitClient)
      {
        return paramAnonymousFareSplitClient.getStatus().equals("Accepted");
      }
    }));
  }

  public String getPickupAddress()
  {
    return this.mPickupAddress;
  }

  public float getSurgeMultiplier()
  {
    return this.mSurgeMultiplier;
  }

  public String getTag()
  {
    return this.mTripId;
  }

  public int getTripEta()
  {
    return this.mTripEta;
  }

  public String getTripId()
  {
    return this.mTripId;
  }

  public String getTripStatus()
  {
    return this.mTripStatus;
  }

  public String getVehicleDisplayName()
  {
    if ((TextUtils.isEmpty(this.mVehicleMake)) || (TextUtils.isEmpty(this.mVehicleModel)))
      return this.mVehicleViewName;
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = this.mVehicleMake;
    arrayOfObject[1] = this.mVehicleModel;
    return String.format("%s %s", arrayOfObject);
  }

  public String getVehicleLicense()
  {
    return this.mVehicleLicense;
  }

  public String getVehicleMake()
  {
    return this.mVehicleMake;
  }

  public String getVehicleModel()
  {
    return this.mVehicleModel;
  }

  public String getVehiclePhotoUrl()
  {
    return this.mVehiclePhotoUrl;
  }

  public String getVehicleViewMonoImageUrl()
  {
    return this.mVehicleViewMonoImageUrl;
  }

  public String getVehicleViewName()
  {
    return this.mVehicleViewName;
  }

  public boolean hasDestination()
  {
    return this.mDestination != null;
  }

  public boolean hasFareSplit()
  {
    return (this.mFareSplitClients != null) && (!this.mFareSplitClients.isEmpty());
  }

  public int hashCode()
  {
    int i;
    int k;
    label35: int n;
    label59: int i2;
    label85: int i4;
    label111: int i6;
    label139: int i8;
    label165: int i10;
    label193: int i12;
    label219: int i14;
    label245: int i16;
    label271: int i18;
    label297: int i20;
    label323: int i22;
    label349: int i24;
    label375: int i25;
    if (this.mDestination != null)
    {
      i = this.mDestination.hashCode();
      int j = i * 31;
      if (this.mDriverExtra == null)
        break label447;
      k = this.mDriverExtra.hashCode();
      int m = 31 * (j + k);
      if (this.mDriverName == null)
        break label452;
      n = this.mDriverName.hashCode();
      int i1 = 31 * (m + n);
      if (this.mDriverPhotoUrl == null)
        break label458;
      i2 = this.mDriverPhotoUrl.hashCode();
      int i3 = 31 * (i1 + i2);
      if (this.mFallbackText == null)
        break label464;
      i4 = this.mFallbackText.hashCode();
      int i5 = 31 * (i3 + i4);
      if (this.mFareSplitClients == null)
        break label470;
      i6 = this.mFareSplitClients.hashCode();
      int i7 = 31 * (i5 + i6);
      if (this.mPickupAddress == null)
        break label476;
      i8 = this.mPickupAddress.hashCode();
      int i9 = 31 * (i7 + i8);
      if (this.mSurgeMultiplier == 0.0F)
        break label482;
      i10 = Float.floatToIntBits(this.mSurgeMultiplier);
      int i11 = 31 * (i9 + i10);
      if (this.mTripId == null)
        break label488;
      i12 = this.mTripId.hashCode();
      int i13 = 31 * (i11 + i12);
      if (this.mTripStatus == null)
        break label494;
      i14 = this.mTripStatus.hashCode();
      int i15 = 31 * (i13 + i14);
      if (this.mVehicleLicense == null)
        break label500;
      i16 = this.mVehicleLicense.hashCode();
      int i17 = 31 * (i15 + i16);
      if (this.mVehicleMake == null)
        break label506;
      i18 = this.mVehicleMake.hashCode();
      int i19 = 31 * (i17 + i18);
      if (this.mVehicleModel == null)
        break label512;
      i20 = this.mVehicleModel.hashCode();
      int i21 = 31 * (i19 + i20);
      if (this.mVehiclePhotoUrl == null)
        break label518;
      i22 = this.mVehiclePhotoUrl.hashCode();
      int i23 = 31 * (i21 + i22);
      if (this.mVehicleViewMonoImageUrl == null)
        break label524;
      i24 = this.mVehicleViewMonoImageUrl.hashCode();
      i25 = 31 * (i23 + i24);
      if (this.mVehicleViewName == null)
        break label530;
    }
    label512: label518: label524: label530: for (int i26 = this.mVehicleViewName.hashCode(); ; i26 = 0)
    {
      int i27 = 31 * (i25 + i26);
      boolean bool = this.mIsMaster;
      int i28 = 0;
      if (bool)
        i28 = 1;
      return 31 * (i27 + i28) + this.mTripEta;
      i = 0;
      break;
      label447: k = 0;
      break label35;
      label452: n = 0;
      break label59;
      label458: i2 = 0;
      break label85;
      label464: i4 = 0;
      break label111;
      label470: i6 = 0;
      break label139;
      label476: i8 = 0;
      break label165;
      label482: i10 = 0;
      break label193;
      label488: i12 = 0;
      break label219;
      label494: i14 = 0;
      break label245;
      label500: i16 = 0;
      break label271;
      label506: i18 = 0;
      break label297;
      i20 = 0;
      break label323;
      i22 = 0;
      break label349;
      i24 = 0;
      break label375;
    }
  }

  public boolean isMaster()
  {
    return this.mIsMaster;
  }

  public void setDriverExtra(String paramString)
  {
    this.mDriverExtra = paramString;
  }

  public void setSurgeMultiplier(float paramFloat)
  {
    this.mSurgeMultiplier = paramFloat;
  }

  public static final class FareSplitClient
    implements Serializable
  {
    private static final List<String> FAKE_NAMES = ImmutableList.of("Skyler", "Jesse", "Hank", "Marie", "Saul");
    public static final String STATUS_ACCEPTED = "Accepted";
    public static final String STATUS_CANCELED = "Canceled";
    public static final String STATUS_DECLINED = "Declined";
    public static final String STATUS_INVALID_NUMBER = "InvalidNumber";
    public static final String STATUS_NO_ACCOUNT = "NoAccount";
    public static final String STATUS_PENDING = "Pending";

    @SerializedName("id")
    private String mId;

    @SerializedName("name")
    private String mName;

    @SerializedName("status")
    private String mStatus;

    public static FareSplitClient createFake(int paramInt, String paramString)
    {
      FareSplitClient localFareSplitClient = new FareSplitClient();
      localFareSplitClient.mId = String.valueOf(paramInt);
      localFareSplitClient.mName = ((String)FAKE_NAMES.get(paramInt));
      localFareSplitClient.mStatus = paramString;
      return localFareSplitClient;
    }

    public static FareSplitClient fromFareSplitClient(FareSplitClient paramFareSplitClient)
    {
      FareSplitClient localFareSplitClient = new FareSplitClient();
      localFareSplitClient.mId = paramFareSplitClient.getMobileDigits();
      localFareSplitClient.mName = paramFareSplitClient.getDisplayName();
      localFareSplitClient.mStatus = paramFareSplitClient.getStatus();
      return localFareSplitClient;
    }

    public String getDisplayStatus(Context paramContext)
    {
      String str = this.mStatus;
      int i = -1;
      switch (str.hashCode())
      {
      default:
      case -2081881145:
      case 632840270:
      case -58529607:
      case -522759168:
      case 1418225932:
      }
      while (true)
        switch (i)
        {
        default:
          return this.mStatus;
          if (str.equals("Accepted"))
          {
            i = 0;
            continue;
            if (str.equals("Declined"))
            {
              i = 1;
              continue;
              if (str.equals("Canceled"))
              {
                i = 2;
                continue;
                if (str.equals("InvalidNumber"))
                {
                  i = 3;
                  continue;
                  if (str.equals("NoAccount"))
                    i = 4;
                }
              }
            }
          }
          break;
        case 0:
        case 1:
        case 2:
        case 3:
        case 4:
        }
      return paramContext.getString(2131558859);
      return paramContext.getString(2131558864);
      return paramContext.getString(2131558860);
      return paramContext.getString(2131558868);
      return paramContext.getString(2131558871);
    }

    public String getId()
    {
      return this.mId;
    }

    public String getName()
    {
      return this.mName;
    }

    public String getStatus()
    {
      return this.mStatus;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.notification.data.TripNotificationData
 * JD-Core Version:    0.6.2
 */