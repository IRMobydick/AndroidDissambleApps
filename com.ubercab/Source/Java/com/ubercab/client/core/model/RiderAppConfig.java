package com.ubercab.client.core.model;

import com.ubercab.common.base.Objects;

public class RiderAppConfig
{
  public static final String FARE_ESTIMATE_FLOW_NONE = "none";
  public static final String FARE_ESTIMATE_FLOW_RATE_CARD_1_NEW_CONFIRMATION = "rateCardVariant1NewConfirmation";
  public static final String FARE_ESTIMATE_FLOW_RATE_CARD_1_OLD_CONFIRMATION = "rateCardVariant1OldConfirmation";
  public static final String FARE_ESTIMATE_FLOW_RATE_CARD_2_NEW_CONFIRMATION = "rateCardVariant2NewConfirmation";
  public static final String FARE_ESTIMATE_FLOW_RATE_CARD_2_OLD_CONFIRMATION = "rateCardVariant2OldConfirmation";
  public static final String FAVORITE_LOCATIONS_HOME_WORK = "homeAndWork";
  public static final String FAVORITE_LOCATIONS_NONE = "none";
  public static final String SETTING_LOCATION_SEARCH_RTAPI = "rtapi";
  public static final String SETTING_SLIDER_STYLE_STACKED = "stacked";
  public static final String SETTING_SLIDER_STYLE_STACKED_USE_GROUP = "stacked_use_group";
  public static final String SETTING_SLIDER_STYLE_STACKED_USE_PARENT = "stacked_use_parent";
  private AddFundsDefaultValues addFundsDefaultValues;
  private Boolean androidNotifications;
  private Boolean enablePayTM;
  private String fareEstimateFlowVariant;
  private FavoriteLocationDistanceConstraints favoriteLocationDistanceConstraints;
  private String favoriteLocations;
  private String locationSearch;
  private Boolean mobileMessagingEnabled;
  private Boolean newConfirmation;
  String sliderStyle;

  public boolean androidNotificationsEnabled()
  {
    if (this.androidNotifications == null)
      return false;
    return this.androidNotifications.booleanValue();
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    RiderAppConfig localRiderAppConfig;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localRiderAppConfig = (RiderAppConfig)paramObject;
      if (this.addFundsDefaultValues != null)
      {
        if (this.addFundsDefaultValues.equals(localRiderAppConfig.addFundsDefaultValues));
      }
      else
        while (localRiderAppConfig.addFundsDefaultValues != null)
          return false;
      if (this.androidNotifications != null)
      {
        if (this.androidNotifications.equals(localRiderAppConfig.androidNotifications));
      }
      else
        while (localRiderAppConfig.androidNotifications != null)
          return false;
      if (this.enablePayTM != null)
      {
        if (this.enablePayTM.equals(localRiderAppConfig.enablePayTM));
      }
      else
        while (localRiderAppConfig.enablePayTM != null)
          return false;
      if (this.fareEstimateFlowVariant != null)
      {
        if (this.fareEstimateFlowVariant.equals(localRiderAppConfig.fareEstimateFlowVariant));
      }
      else
        while (localRiderAppConfig.fareEstimateFlowVariant != null)
          return false;
      if (this.favoriteLocationDistanceConstraints != null)
      {
        if (this.favoriteLocationDistanceConstraints.equals(localRiderAppConfig.favoriteLocationDistanceConstraints));
      }
      else
        while (localRiderAppConfig.favoriteLocationDistanceConstraints != null)
          return false;
      if (this.favoriteLocations != null)
      {
        if (this.favoriteLocations.equals(localRiderAppConfig.favoriteLocations));
      }
      else
        while (localRiderAppConfig.favoriteLocations != null)
          return false;
      if (this.locationSearch != null)
      {
        if (this.locationSearch.equals(localRiderAppConfig.locationSearch));
      }
      else
        while (localRiderAppConfig.locationSearch != null)
          return false;
      if (this.mobileMessagingEnabled != null)
      {
        if (this.mobileMessagingEnabled.equals(localRiderAppConfig.mobileMessagingEnabled));
      }
      else
        while (localRiderAppConfig.mobileMessagingEnabled != null)
          return false;
      if (this.newConfirmation != null)
      {
        if (this.newConfirmation.equals(localRiderAppConfig.newConfirmation));
      }
      else
        while (localRiderAppConfig.newConfirmation != null)
          return false;
      if (this.sliderStyle == null)
        break;
    }
    while (this.sliderStyle.equals(localRiderAppConfig.sliderStyle));
    while (true)
    {
      return false;
      if (localRiderAppConfig.sliderStyle == null)
        break;
    }
  }

  public AddFundsDefaultValues getAddFundsDefaultValues()
  {
    return this.addFundsDefaultValues;
  }

  public String getFareEstimateFlowVariant()
  {
    if (this.fareEstimateFlowVariant == null)
      return "none";
    return this.fareEstimateFlowVariant;
  }

  public FavoriteLocationDistanceConstraints getFavoriteLocationDistanceConstraints()
  {
    return this.favoriteLocationDistanceConstraints;
  }

  public String getFavoriteLocationsVariant()
  {
    if (this.favoriteLocations == null)
      return "none";
    return this.favoriteLocations;
  }

  public String getLocationSearch()
  {
    return this.locationSearch;
  }

  public String getSliderStyle()
  {
    return this.sliderStyle;
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
    label189: int i11;
    if (this.sliderStyle != null)
    {
      i = this.sliderStyle.hashCode();
      int j = i * 31;
      if (this.androidNotifications == null)
        break label259;
      k = this.androidNotifications.hashCode();
      int m = 31 * (j + k);
      if (this.enablePayTM == null)
        break label264;
      n = this.enablePayTM.hashCode();
      int i1 = 31 * (m + n);
      if (this.fareEstimateFlowVariant == null)
        break label270;
      i2 = this.fareEstimateFlowVariant.hashCode();
      int i3 = 31 * (i1 + i2);
      if (this.favoriteLocations == null)
        break label276;
      i4 = this.favoriteLocations.hashCode();
      int i5 = 31 * (i3 + i4);
      if (this.locationSearch == null)
        break label282;
      i6 = this.locationSearch.hashCode();
      int i7 = 31 * (i5 + i6);
      if (this.mobileMessagingEnabled == null)
        break label288;
      i8 = this.mobileMessagingEnabled.hashCode();
      int i9 = 31 * (i7 + i8);
      if (this.newConfirmation == null)
        break label294;
      i10 = this.newConfirmation.hashCode();
      i11 = 31 * (i9 + i10);
      if (this.addFundsDefaultValues == null)
        break label300;
    }
    label259: label264: label270: label276: label282: label288: label294: label300: for (int i12 = this.addFundsDefaultValues.hashCode(); ; i12 = 0)
    {
      int i13 = 31 * (i11 + i12);
      FavoriteLocationDistanceConstraints localFavoriteLocationDistanceConstraints = this.favoriteLocationDistanceConstraints;
      int i14 = 0;
      if (localFavoriteLocationDistanceConstraints != null)
        i14 = this.favoriteLocationDistanceConstraints.hashCode();
      return i13 + i14;
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
    }
  }

  public boolean isFavoriteLocationsEnabledForHomeWork()
  {
    return Objects.equal(this.favoriteLocations, "homeAndWork");
  }

  public boolean isMobileMessagingEnabled()
  {
    if (this.mobileMessagingEnabled == null)
      return true;
    return this.mobileMessagingEnabled.booleanValue();
  }

  public boolean isNewConfirmationEnabled()
  {
    if (this.newConfirmation == null)
      return false;
    return this.newConfirmation.booleanValue();
  }

  public boolean isNewConfirmationEnabledInFareEstimateFlow()
  {
    return (Objects.equal(this.fareEstimateFlowVariant, "rateCardVariant1NewConfirmation")) || (Objects.equal(this.fareEstimateFlowVariant, "rateCardVariant2NewConfirmation"));
  }

  public boolean isPayTmEnabled()
  {
    if (this.enablePayTM != null)
      return this.enablePayTM.booleanValue();
    return false;
  }

  public void setFareEstimateFlowVariant(String paramString)
  {
    this.fareEstimateFlowVariant = paramString;
  }

  public void setFavoriteLocationDistanceConstraints(FavoriteLocationDistanceConstraints paramFavoriteLocationDistanceConstraints)
  {
    this.favoriteLocationDistanceConstraints = paramFavoriteLocationDistanceConstraints;
  }

  public void setFavoriteLocationsVariant(String paramString)
  {
    this.favoriteLocations = paramString;
  }

  public void setLocationSearch(String paramString)
  {
    this.locationSearch = paramString;
  }

  public void setMobileMessagingEnabled(Boolean paramBoolean)
  {
    this.mobileMessagingEnabled = paramBoolean;
  }

  public void setNewConfirmationEnabled(boolean paramBoolean)
  {
    this.newConfirmation = Boolean.valueOf(paramBoolean);
  }

  public void setPayTmEnabled(boolean paramBoolean)
  {
    this.enablePayTM = Boolean.valueOf(paramBoolean);
  }

  public void setSliderStyle(String paramString)
  {
    this.sliderStyle = paramString;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.model.RiderAppConfig
 * JD-Core Version:    0.6.2
 */