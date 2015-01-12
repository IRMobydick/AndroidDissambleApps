package com.ubercab.client.core.model;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import java.util.List;
import java.util.Map;

public class VehicleView
{
  public static final String CONFIRMATION_TYPE_FARE_ESTIMATE_TAGLINE = "FareEstimateTagline";
  static final String DESTINATION_HIDDEN = "hidden";
  static final String DESTINATION_OPTIONAL = "optional";
  static final String DESTINATION_REQUIRED_NOT_EDITABLE = "requiredNotEditable";
  Boolean allowFareEstimate;
  Integer capacity;
  String confirmPickupButtonString;
  String confirmationType;
  String description;
  String destinationEntry;
  String discountRangeString;
  String discountType;
  Fare fare;
  String fareDetailsUrl;
  String fareMessage;
  String groupDisplayName;
  String groupId;
  String id;
  String inventoryUrl;
  Boolean isCashOnly;
  Boolean isDestinationRequired;
  List<VehicleViewImage> mapImages;
  Integer maxFareSplits;
  List<VehicleViewImage> monoImages;
  String noneAvailableString;
  String parentId;
  String pickupButtonString;
  String pickupEtaString;
  String requestPickupButtonString;
  String setPickupLocationString;
  Surge surge;
  String surgeTitle;
  VehicleViewTagline tagline;
  Map<String, VehicleViewTripOption> tripOptions;
  String uuid;

  private String getDestinationEntry()
  {
    if (!TextUtils.isEmpty(this.destinationEntry))
      return this.destinationEntry;
    if ((this.isDestinationRequired != null) && (this.isDestinationRequired.booleanValue()))
      return "requiredNotEditable";
    return "optional";
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    VehicleView localVehicleView;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localVehicleView = (VehicleView)paramObject;
      if (this.allowFareEstimate != null)
      {
        if (this.allowFareEstimate.equals(localVehicleView.allowFareEstimate));
      }
      else
        while (localVehicleView.allowFareEstimate != null)
          return false;
      if (this.capacity != null)
      {
        if (this.capacity.equals(localVehicleView.capacity));
      }
      else
        while (localVehicleView.capacity != null)
          return false;
      if (this.confirmationType != null)
      {
        if (this.confirmationType.equals(localVehicleView.confirmationType));
      }
      else
        while (localVehicleView.confirmationType != null)
          return false;
      if (this.confirmPickupButtonString != null)
      {
        if (this.confirmPickupButtonString.equals(localVehicleView.confirmPickupButtonString));
      }
      else
        while (localVehicleView.confirmPickupButtonString != null)
          return false;
      if (this.description != null)
      {
        if (this.description.equals(localVehicleView.description));
      }
      else
        while (localVehicleView.description != null)
          return false;
      if (this.destinationEntry != null)
      {
        if (this.destinationEntry.equals(localVehicleView.destinationEntry));
      }
      else
        while (localVehicleView.destinationEntry != null)
          return false;
      if (this.discountRangeString != null)
      {
        if (this.discountRangeString.equals(localVehicleView.discountRangeString));
      }
      else
        while (localVehicleView.discountRangeString != null)
          return false;
      if (this.discountType != null)
      {
        if (this.discountType.equals(localVehicleView.discountType));
      }
      else
        while (localVehicleView.discountType != null)
          return false;
      if (this.fare != null)
      {
        if (this.fare.equals(localVehicleView.fare));
      }
      else
        while (localVehicleView.fare != null)
          return false;
      if (this.fareDetailsUrl != null)
      {
        if (this.fareDetailsUrl.equals(localVehicleView.fareDetailsUrl));
      }
      else
        while (localVehicleView.fareDetailsUrl != null)
          return false;
      if (this.fareMessage != null)
      {
        if (this.fareMessage.equals(localVehicleView.fareMessage));
      }
      else
        while (localVehicleView.fareMessage != null)
          return false;
      if (this.groupDisplayName != null)
      {
        if (this.groupDisplayName.equals(localVehicleView.groupDisplayName));
      }
      else
        while (localVehicleView.groupDisplayName != null)
          return false;
      if (this.groupId != null)
      {
        if (this.groupId.equals(localVehicleView.groupId));
      }
      else
        while (localVehicleView.groupId != null)
          return false;
      if (this.id != null)
      {
        if (this.id.equals(localVehicleView.id));
      }
      else
        while (localVehicleView.id != null)
          return false;
      if (this.inventoryUrl != null)
      {
        if (this.inventoryUrl.equals(localVehicleView.inventoryUrl));
      }
      else
        while (localVehicleView.inventoryUrl != null)
          return false;
      if (this.isCashOnly != null)
      {
        if (this.isCashOnly.equals(localVehicleView.isCashOnly));
      }
      else
        while (localVehicleView.isCashOnly != null)
          return false;
      if (this.isDestinationRequired != null)
      {
        if (this.isDestinationRequired.equals(localVehicleView.isDestinationRequired));
      }
      else
        while (localVehicleView.isDestinationRequired != null)
          return false;
      if (this.mapImages != null)
      {
        if (this.mapImages.equals(localVehicleView.mapImages));
      }
      else
        while (localVehicleView.mapImages != null)
          return false;
      if (this.maxFareSplits != null)
      {
        if (this.maxFareSplits.equals(this.maxFareSplits));
      }
      else
        while (localVehicleView.maxFareSplits != null)
          return false;
      if (this.monoImages != null)
      {
        if (this.monoImages.equals(localVehicleView.monoImages));
      }
      else
        while (localVehicleView.monoImages != null)
          return false;
      if (this.noneAvailableString != null)
      {
        if (this.noneAvailableString.equals(localVehicleView.noneAvailableString));
      }
      else
        while (localVehicleView.noneAvailableString != null)
          return false;
      if (this.parentId != null)
      {
        if (this.parentId.equals(localVehicleView.parentId));
      }
      else
        while (localVehicleView.parentId != null)
          return false;
      if (this.pickupButtonString != null)
      {
        if (this.pickupButtonString.equals(localVehicleView.pickupButtonString));
      }
      else
        while (localVehicleView.pickupButtonString != null)
          return false;
      if (this.pickupEtaString != null)
      {
        if (this.pickupEtaString.equals(localVehicleView.pickupEtaString));
      }
      else
        while (localVehicleView.pickupEtaString != null)
          return false;
      if (this.requestPickupButtonString != null)
      {
        if (this.requestPickupButtonString.equals(localVehicleView.requestPickupButtonString));
      }
      else
        while (localVehicleView.requestPickupButtonString != null)
          return false;
      if (this.setPickupLocationString != null)
      {
        if (this.setPickupLocationString.equals(localVehicleView.setPickupLocationString));
      }
      else
        while (localVehicleView.setPickupLocationString != null)
          return false;
      if (this.surge != null)
      {
        if (this.surge.equals(localVehicleView.surge));
      }
      else
        while (localVehicleView.surge != null)
          return false;
      if (this.surgeTitle != null)
      {
        if (this.surgeTitle.equals(localVehicleView.surgeTitle));
      }
      else
        while (localVehicleView.surgeTitle != null)
          return false;
      if (this.tagline != null)
      {
        if (this.tagline.equals(localVehicleView.tagline));
      }
      else
        while (localVehicleView.tagline != null)
          return false;
      if (this.tripOptions != null)
      {
        if (this.tripOptions.equals(localVehicleView.tripOptions));
      }
      else
        while (localVehicleView.tripOptions != null)
          return false;
      if (this.uuid == null)
        break;
    }
    while (this.uuid.equals(localVehicleView.uuid));
    while (true)
    {
      return false;
      if (localVehicleView.uuid == null)
        break;
    }
  }

  public int getCapacity()
  {
    if (this.capacity == null)
      return 0;
    return this.capacity.intValue();
  }

  public String getConfirmPickupButtonString()
  {
    return this.confirmPickupButtonString;
  }

  public String getConfirmationType()
  {
    return this.confirmationType;
  }

  public String getDescription()
  {
    return this.description;
  }

  public String getDiscountRangeString()
  {
    return this.discountRangeString;
  }

  public String getDiscountType()
  {
    return this.discountType;
  }

  public Fare getFare()
  {
    return this.fare;
  }

  public String getFareDetailsUrl()
  {
    return this.fareDetailsUrl;
  }

  public String getFareMessage()
  {
    return this.fareMessage;
  }

  public String getFormattedPickupEtaString(String paramString)
  {
    if (TextUtils.isEmpty(getPickupEtaString()))
      return null;
    return getPickupEtaString().replace("{string}", paramString);
  }

  public String getFormattedRequestPickupButtonString()
  {
    if ((TextUtils.isEmpty(getRequestPickupButtonString())) || (TextUtils.isEmpty(getDescription())))
      return null;
    return getRequestPickupButtonString().replace("{string}", getDescription());
  }

  public String getGroupDisplayName()
  {
    if (TextUtils.isEmpty(this.groupDisplayName))
      this.groupDisplayName = getDescription();
    return this.groupDisplayName;
  }

  public String getGroupId()
  {
    if (TextUtils.isEmpty(this.groupId))
      this.groupId = ("solo_group_" + getId());
    return this.groupId;
  }

  public String getId()
  {
    return this.id;
  }

  public String getInventoryUrl()
  {
    return this.inventoryUrl;
  }

  public Uri getMapImagePublicUri()
  {
    if ((this.mapImages == null) || (this.mapImages.isEmpty()))
      return Uri.EMPTY;
    return ((VehicleViewImage)this.mapImages.get(0)).getPublicUri();
  }

  public Uri getMapImageResourceUri(Context paramContext)
  {
    if ((this.mapImages == null) || (this.mapImages.isEmpty()))
      return Uri.EMPTY;
    return ((VehicleViewImage)this.mapImages.get(0)).getResourceUri(paramContext);
  }

  public List<VehicleViewImage> getMapImages()
  {
    return this.mapImages;
  }

  public int getMaxFareSplits()
  {
    if (this.maxFareSplits == null)
      return 0;
    return this.maxFareSplits.intValue();
  }

  public Uri getMonoImagePublicUri()
  {
    if ((this.monoImages == null) || (this.monoImages.isEmpty()))
      return Uri.EMPTY;
    return ((VehicleViewImage)this.monoImages.get(0)).getPublicUri();
  }

  public Uri getMonoImageResourceUri(Context paramContext)
  {
    if ((this.monoImages == null) || (this.monoImages.isEmpty()))
      return Uri.EMPTY;
    return ((VehicleViewImage)this.monoImages.get(0)).getResourceUri(paramContext);
  }

  public List<VehicleViewImage> getMonoImages()
  {
    return this.monoImages;
  }

  public String getNoneAvailableString()
  {
    return this.noneAvailableString;
  }

  public String getParentId()
  {
    return this.parentId;
  }

  public String getPickupButtonString()
  {
    return this.pickupButtonString;
  }

  public String getPickupEtaString()
  {
    return this.pickupEtaString;
  }

  public String getRequestPickupButtonString()
  {
    return this.requestPickupButtonString;
  }

  public String getSetPickupLocationString()
  {
    return this.setPickupLocationString;
  }

  public Surge getSurge()
  {
    if (this.surge == null)
      this.surge = new Surge();
    return this.surge;
  }

  public String getSurgeTitle()
  {
    return this.surgeTitle;
  }

  public VehicleViewTagline getTagline()
  {
    return this.tagline;
  }

  public Map<String, VehicleViewTripOption> getTripOptions()
  {
    return this.tripOptions;
  }

  public String getUuid()
  {
    return this.uuid;
  }

  public boolean hasInventoryUrl()
  {
    return !TextUtils.isEmpty(this.inventoryUrl);
  }

  public boolean hasValidTagline()
  {
    return (this.tagline != null) && (!TextUtils.isEmpty(this.tagline.getTitle())) && (!TextUtils.isEmpty(this.tagline.getDetail()));
  }

  public int hashCode()
  {
    int i;
    int k;
    label35: int n;
    label59: int i2;
    label85: int i4;
    label111: int i6;
    label137: int i8;
    label163: int i10;
    label189: int i12;
    label215: int i14;
    label241: int i16;
    label267: int i18;
    label293: int i20;
    label319: int i22;
    label345: int i24;
    label371: int i26;
    label397: int i28;
    label425: int i30;
    label451: int i32;
    label479: int i34;
    label505: int i36;
    label531: int i38;
    label557: int i40;
    label583: int i42;
    label609: int i44;
    label635: int i46;
    label661: int i48;
    label687: int i50;
    label713: int i52;
    label739: int i53;
    if (this.allowFareEstimate != null)
    {
      i = this.allowFareEstimate.hashCode();
      int j = i * 31;
      if (this.capacity == null)
        break label811;
      k = this.capacity.hashCode();
      int m = 31 * (j + k);
      if (this.confirmationType == null)
        break label816;
      n = this.confirmationType.hashCode();
      int i1 = 31 * (m + n);
      if (this.confirmPickupButtonString == null)
        break label822;
      i2 = this.confirmPickupButtonString.hashCode();
      int i3 = 31 * (i1 + i2);
      if (this.description == null)
        break label828;
      i4 = this.description.hashCode();
      int i5 = 31 * (i3 + i4);
      if (this.destinationEntry == null)
        break label834;
      i6 = this.destinationEntry.hashCode();
      int i7 = 31 * (i5 + i6);
      if (this.discountRangeString == null)
        break label840;
      i8 = this.discountRangeString.hashCode();
      int i9 = 31 * (i7 + i8);
      if (this.discountType == null)
        break label846;
      i10 = this.discountType.hashCode();
      int i11 = 31 * (i9 + i10);
      if (this.fare == null)
        break label852;
      i12 = this.fare.hashCode();
      int i13 = 31 * (i11 + i12);
      if (this.fareDetailsUrl == null)
        break label858;
      i14 = this.fareDetailsUrl.hashCode();
      int i15 = 31 * (i13 + i14);
      if (this.fareMessage == null)
        break label864;
      i16 = this.fareMessage.hashCode();
      int i17 = 31 * (i15 + i16);
      if (this.groupDisplayName == null)
        break label870;
      i18 = this.groupDisplayName.hashCode();
      int i19 = 31 * (i17 + i18);
      if (this.groupId == null)
        break label876;
      i20 = this.groupId.hashCode();
      int i21 = 31 * (i19 + i20);
      if (this.id == null)
        break label882;
      i22 = this.id.hashCode();
      int i23 = 31 * (i21 + i22);
      if (this.isCashOnly == null)
        break label888;
      i24 = this.isCashOnly.hashCode();
      int i25 = 31 * (i23 + i24);
      if (this.isDestinationRequired == null)
        break label894;
      i26 = this.isDestinationRequired.hashCode();
      int i27 = 31 * (i25 + i26);
      if (this.mapImages == null)
        break label900;
      i28 = this.mapImages.hashCode();
      int i29 = 31 * (i27 + i28);
      if (this.maxFareSplits == null)
        break label906;
      i30 = this.maxFareSplits.hashCode();
      int i31 = 31 * (i29 + i30);
      if (this.monoImages == null)
        break label912;
      i32 = this.monoImages.hashCode();
      int i33 = 31 * (i31 + i32);
      if (this.inventoryUrl == null)
        break label918;
      i34 = this.inventoryUrl.hashCode();
      int i35 = 31 * (i33 + i34);
      if (this.noneAvailableString == null)
        break label924;
      i36 = this.noneAvailableString.hashCode();
      int i37 = 31 * (i35 + i36);
      if (this.parentId == null)
        break label930;
      i38 = this.parentId.hashCode();
      int i39 = 31 * (i37 + i38);
      if (this.pickupButtonString == null)
        break label936;
      i40 = this.pickupButtonString.hashCode();
      int i41 = 31 * (i39 + i40);
      if (this.pickupEtaString == null)
        break label942;
      i42 = this.pickupEtaString.hashCode();
      int i43 = 31 * (i41 + i42);
      if (this.requestPickupButtonString == null)
        break label948;
      i44 = this.requestPickupButtonString.hashCode();
      int i45 = 31 * (i43 + i44);
      if (this.setPickupLocationString == null)
        break label954;
      i46 = this.setPickupLocationString.hashCode();
      int i47 = 31 * (i45 + i46);
      if (this.surge == null)
        break label960;
      i48 = this.surge.hashCode();
      int i49 = 31 * (i47 + i48);
      if (this.surgeTitle == null)
        break label966;
      i50 = this.surgeTitle.hashCode();
      int i51 = 31 * (i49 + i50);
      if (this.tagline == null)
        break label972;
      i52 = this.tagline.hashCode();
      i53 = 31 * (i51 + i52);
      if (this.tripOptions == null)
        break label978;
    }
    label811: label816: label822: label828: label834: label840: label846: label978: for (int i54 = this.tripOptions.hashCode(); ; i54 = 0)
    {
      int i55 = 31 * (i53 + i54);
      String str = this.uuid;
      int i56 = 0;
      if (str != null)
        i56 = this.uuid.hashCode();
      return i55 + i56;
      i = 0;
      break;
      k = 0;
      break label35;
      n = 0;
      break label59;
      i2 = 0;
      break label85;
      i4 = 0;
      break label111;
      i6 = 0;
      break label137;
      i8 = 0;
      break label163;
      i10 = 0;
      break label189;
      label852: i12 = 0;
      break label215;
      label858: i14 = 0;
      break label241;
      label864: i16 = 0;
      break label267;
      label870: i18 = 0;
      break label293;
      label876: i20 = 0;
      break label319;
      label882: i22 = 0;
      break label345;
      label888: i24 = 0;
      break label371;
      label894: i26 = 0;
      break label397;
      i28 = 0;
      break label425;
      i30 = 0;
      break label451;
      i32 = 0;
      break label479;
      i34 = 0;
      break label505;
      i36 = 0;
      break label531;
      i38 = 0;
      break label557;
      i40 = 0;
      break label583;
      i42 = 0;
      break label609;
      i44 = 0;
      break label635;
      i46 = 0;
      break label661;
      i48 = 0;
      break label687;
      i50 = 0;
      break label713;
      i52 = 0;
      break label739;
    }
  }

  public boolean isAllowFareEstimate()
  {
    return (this.allowFareEstimate != null) && (this.allowFareEstimate.booleanValue());
  }

  public boolean isCashOnly()
  {
    return (this.isCashOnly != null) && (this.isCashOnly.booleanValue());
  }

  public boolean isDestinationEnabled()
  {
    return !"hidden".equals(getDestinationEntry());
  }

  public boolean isDestinationRequired()
  {
    return "requiredNotEditable".equals(getDestinationEntry());
  }

  public boolean isSurging()
  {
    return (this.surge != null) && (this.surge.getMultiplier() > 1.0F);
  }

  public void setDestinationEntry(String paramString)
  {
    this.destinationEntry = paramString;
  }

  public void setGroupId(String paramString)
  {
    this.groupId = paramString;
  }

  void setId(String paramString)
  {
    this.id = paramString;
  }

  public void setInventoryUrl(String paramString)
  {
    this.inventoryUrl = paramString;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.model.VehicleView
 * JD-Core Version:    0.6.2
 */