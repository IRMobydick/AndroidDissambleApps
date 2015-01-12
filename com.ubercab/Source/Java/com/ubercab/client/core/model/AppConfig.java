package com.ubercab.client.core.model;

public class AppConfig
{
  public static final String GEOPROJECTION_GCJ02 = "GCJ02";
  public static final String GEOPROJECTION_WGS84 = "WGS84";
  private String coordinateSystem;
  private Boolean disableAnalyticsV2;
  private Boolean disableCalling;
  Boolean disableSpotifyLinkAndUnlink;
  private Boolean disableTextMessaging;
  Boolean enableMusicBar;
  private Boolean enableNetworkMonitoring;
  private String failoverStrategy;
  private Boolean payTMSignupEnabled;
  private Long pingUpdateIntervalMs;
  RiderAppConfig rider;
  Boolean useTripLegs;

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    AppConfig localAppConfig;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localAppConfig = (AppConfig)paramObject;
      if (this.coordinateSystem != null)
      {
        if (this.coordinateSystem.equals(localAppConfig.coordinateSystem));
      }
      else
        while (localAppConfig.coordinateSystem != null)
          return false;
      if (this.disableAnalyticsV2 != null)
      {
        if (this.disableAnalyticsV2.equals(localAppConfig.disableAnalyticsV2));
      }
      else
        while (localAppConfig.disableAnalyticsV2 != null)
          return false;
      if (this.disableSpotifyLinkAndUnlink != null)
      {
        if (this.disableSpotifyLinkAndUnlink.equals(localAppConfig.disableSpotifyLinkAndUnlink));
      }
      else
        while (localAppConfig.disableSpotifyLinkAndUnlink != null)
          return false;
      if (this.enableNetworkMonitoring != null)
      {
        if (this.enableNetworkMonitoring.equals(localAppConfig.enableNetworkMonitoring));
      }
      else
        while (localAppConfig.enableNetworkMonitoring != null)
          return false;
      if (this.failoverStrategy != null)
      {
        if (this.failoverStrategy.equals(localAppConfig.failoverStrategy));
      }
      else
        while (localAppConfig.failoverStrategy != null)
          return false;
      if (this.payTMSignupEnabled != null)
      {
        if (this.payTMSignupEnabled.equals(localAppConfig.payTMSignupEnabled));
      }
      else
        while (localAppConfig.payTMSignupEnabled != null)
          return false;
      if (this.pingUpdateIntervalMs != null)
      {
        if (this.pingUpdateIntervalMs.equals(localAppConfig.pingUpdateIntervalMs));
      }
      else
        while (localAppConfig.pingUpdateIntervalMs != null)
          return false;
      if (this.rider != null)
      {
        if (this.rider.equals(localAppConfig.rider));
      }
      else
        while (localAppConfig.rider != null)
          return false;
      if (this.useTripLegs != null)
      {
        if (this.useTripLegs.equals(localAppConfig.useTripLegs));
      }
      else
        while (localAppConfig.useTripLegs != null)
          return false;
      if (this.disableTextMessaging != null)
      {
        if (this.disableTextMessaging.equals(localAppConfig.disableTextMessaging));
      }
      else
        while (localAppConfig.disableTextMessaging != null)
          return false;
      if (this.disableCalling == null)
        break;
    }
    while (this.disableCalling.equals(localAppConfig.disableCalling));
    while (true)
    {
      return false;
      if (localAppConfig.disableCalling == null)
        break;
    }
  }

  public boolean getAnalyticsV2Disabled()
  {
    if (this.disableAnalyticsV2 == null)
      return false;
    return this.disableAnalyticsV2.booleanValue();
  }

  public String getFailoverStrategy()
  {
    if (this.failoverStrategy == null)
      return "cnRedirect";
    return this.failoverStrategy;
  }

  public boolean getMusicTrayEnabled()
  {
    if (this.enableMusicBar == null)
      return false;
    return this.enableMusicBar.booleanValue();
  }

  public Long getPingUpdateIntervalMs()
  {
    return this.pingUpdateIntervalMs;
  }

  public RiderAppConfig getRiderConfig()
  {
    return this.rider;
  }

  public boolean getSpotifyLinkAndUnlinkDisabled()
  {
    if (this.disableSpotifyLinkAndUnlink == null)
      return true;
    return this.disableSpotifyLinkAndUnlink.booleanValue();
  }

  public boolean getUseTripLegs()
  {
    if (this.useTripLegs != null)
      return this.useTripLegs.booleanValue();
    return true;
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
    label215: int i13;
    if (this.rider != null)
    {
      i = this.rider.hashCode();
      int j = i * 31;
      if (this.pingUpdateIntervalMs == null)
        break label285;
      k = this.pingUpdateIntervalMs.hashCode();
      int m = 31 * (j + k);
      if (this.disableAnalyticsV2 == null)
        break label290;
      n = this.disableAnalyticsV2.hashCode();
      int i1 = 31 * (m + n);
      if (this.disableSpotifyLinkAndUnlink == null)
        break label296;
      i2 = this.disableSpotifyLinkAndUnlink.hashCode();
      int i3 = 31 * (i1 + i2);
      if (this.enableNetworkMonitoring == null)
        break label302;
      i4 = this.enableNetworkMonitoring.hashCode();
      int i5 = 31 * (i3 + i4);
      if (this.coordinateSystem == null)
        break label308;
      i6 = this.coordinateSystem.hashCode();
      int i7 = 31 * (i5 + i6);
      if (this.failoverStrategy == null)
        break label314;
      i8 = this.failoverStrategy.hashCode();
      int i9 = 31 * (i7 + i8);
      if (this.payTMSignupEnabled == null)
        break label320;
      i10 = this.payTMSignupEnabled.hashCode();
      int i11 = 31 * (i9 + i10);
      if (this.useTripLegs == null)
        break label326;
      i12 = this.useTripLegs.hashCode();
      i13 = 31 * (i11 + i12);
      if (this.disableTextMessaging == null)
        break label332;
    }
    label285: label290: label296: label302: label308: label314: label320: label326: label332: for (int i14 = this.disableTextMessaging.hashCode(); ; i14 = 0)
    {
      int i15 = 31 * (i13 + i14);
      Boolean localBoolean = this.disableCalling;
      int i16 = 0;
      if (localBoolean != null)
        i16 = this.disableCalling.hashCode();
      return i15 + i16;
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
      i12 = 0;
      break label215;
    }
  }

  public boolean isCallingDisabled()
  {
    if (this.disableCalling == null)
      return false;
    return this.disableCalling.booleanValue();
  }

  public boolean isNetworkMonitoringEnabled()
  {
    if (this.enableNetworkMonitoring == null)
      return false;
    return this.enableNetworkMonitoring.booleanValue();
  }

  public Boolean isPayTmSignupEnabled()
  {
    if (this.payTMSignupEnabled != null);
    for (boolean bool = this.payTMSignupEnabled.booleanValue(); ; bool = false)
      return Boolean.valueOf(bool);
  }

  public boolean isTextMessagingDisabled()
  {
    if (this.disableTextMessaging == null)
      return false;
    return this.disableTextMessaging.booleanValue();
  }

  public void setFailoverStrategy(String paramString)
  {
    this.failoverStrategy = paramString;
  }

  public void setPayTmSignupEnabled(boolean paramBoolean)
  {
    this.payTMSignupEnabled = Boolean.valueOf(paramBoolean);
  }

  public void setRiderConfig(RiderAppConfig paramRiderAppConfig)
  {
    this.rider = paramRiderAppConfig;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.model.AppConfig
 * JD-Core Version:    0.6.2
 */