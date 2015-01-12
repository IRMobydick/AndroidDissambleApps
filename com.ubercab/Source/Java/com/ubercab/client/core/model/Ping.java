package com.ubercab.client.core.model;

import com.ubercab.client.feature.payment.expense.ExpenseLink;
import com.ubercab.common.base.Objects;
import com.ubercab.library.network.dispatch.model.DispatchResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Ping extends DispatchResponse
{
  public static final int ERROR_CODE_ARREARS = 430;
  public static final int ERROR_CODE_INSUFFICIENT_BALANCE = 402;
  ApiResponse apiResponse;
  AppConfig appConfig = new AppConfig();
  City city = new City();
  Client client = new Client();
  List<Map<String, Object>> errorObj;
  FareSplit fareSplit = new FareSplit();
  boolean forceUpgrade;
  String forceUpgradeUrl;
  long mapFittingMobileAppDelayWindowMs;
  List<CnLocation> nearby = new ArrayList();
  Map<String, NearbyVehicle> nearbyVehicles = new HashMap();
  List<CnLocation> places = new ArrayList();
  List<CnLocation> recent = new ArrayList();
  Session session;
  SignupRequired signupRequired;
  boolean thirdPartyConnected;
  Trip trip;

  public boolean canInviteMoreToFareSplit(int paramInt)
  {
    int i = getMaxFareSplits();
    return paramInt + Math.max(1, this.fareSplit.getClients().size()) <= i;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    Ping localPing;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      if (!super.equals(paramObject))
        return false;
      localPing = (Ping)paramObject;
      if (this.forceUpgrade != localPing.forceUpgrade)
        return false;
      if (this.mapFittingMobileAppDelayWindowMs != localPing.mapFittingMobileAppDelayWindowMs)
        return false;
      if (this.apiResponse != null)
      {
        if (this.apiResponse.equals(localPing.apiResponse));
      }
      else
        while (localPing.apiResponse != null)
          return false;
      if (this.appConfig != null)
      {
        if (this.appConfig.equals(localPing.appConfig));
      }
      else
        while (localPing.appConfig != null)
          return false;
      if (this.city != null)
      {
        if (this.city.equals(localPing.city));
      }
      else
        while (localPing.city != null)
          return false;
      if (this.client != null)
      {
        if (this.client.equals(localPing.client));
      }
      else
        while (localPing.client != null)
          return false;
      if (this.errorObj != null)
      {
        if (this.errorObj.equals(localPing.errorObj));
      }
      else
        while (localPing.errorObj != null)
          return false;
      if (this.fareSplit != null)
      {
        if (this.fareSplit.equals(localPing.fareSplit));
      }
      else
        while (localPing.fareSplit != null)
          return false;
      if (this.forceUpgradeUrl != null)
      {
        if (this.forceUpgradeUrl.equals(localPing.forceUpgradeUrl));
      }
      else
        while (localPing.forceUpgradeUrl != null)
          return false;
      if (this.nearby != null)
      {
        if (this.nearby.equals(localPing.nearby));
      }
      else
        while (localPing.nearby != null)
          return false;
      if (this.nearbyVehicles != null)
      {
        if (this.nearbyVehicles.equals(localPing.nearbyVehicles));
      }
      else
        while (localPing.nearbyVehicles != null)
          return false;
      if (this.places != null)
      {
        if (this.places.equals(localPing.places));
      }
      else
        while (localPing.places != null)
          return false;
      if (this.recent != null)
      {
        if (this.recent.equals(localPing.recent));
      }
      else
        while (localPing.recent != null)
          return false;
      if (this.session != null)
      {
        if (this.session.equals(localPing.session));
      }
      else
        while (localPing.session != null)
          return false;
      if (!Objects.equal(this.signupRequired, localPing.signupRequired))
        return false;
      if (this.thirdPartyConnected != localPing.thirdPartyConnected)
        return false;
      if (this.trip == null)
        break;
    }
    while (this.trip.equals(localPing.trip));
    while (true)
    {
      return false;
      if (localPing.trip == null)
        break;
    }
  }

  public CreditBalance findCreditBalanceForCity()
  {
    String str = this.city.getCurrencyCode();
    Iterator localIterator = this.client.getCreditBalances().iterator();
    while (localIterator.hasNext())
    {
      CreditBalance localCreditBalance = (CreditBalance)localIterator.next();
      if (localCreditBalance.getDisplayName().equals(str))
        return localCreditBalance;
    }
    return null;
  }

  public List<CnLocation> getAllLocations()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.recent);
    localArrayList.addAll(this.nearby);
    localArrayList.addAll(this.places);
    return localArrayList;
  }

  public ApiResponse getApiResponse()
  {
    return this.apiResponse;
  }

  public AppConfig getAppConfig()
  {
    return this.appConfig;
  }

  public City getCity()
  {
    return this.city;
  }

  public Client getClient()
  {
    return this.client;
  }

  public List<Map<String, Object>> getErrorObj()
  {
    return this.errorObj;
  }

  public String getExpenseLinkType()
  {
    if (this.client != null)
    {
      Iterator localIterator = this.client.getThirdPartyIdentities().keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (ExpenseLink.isValidExpenseLink(str))
          return str;
      }
    }
    return null;
  }

  public FareSplit getFareSplit()
  {
    return this.fareSplit;
  }

  public String getForceUpgradeUrl()
  {
    return this.forceUpgradeUrl;
  }

  public long getMapFittingMobileAppDelayWindowMs()
  {
    return this.mapFittingMobileAppDelayWindowMs;
  }

  public int getMaxFareSplits()
  {
    VehicleView localVehicleView = getTripVehicleView();
    if (localVehicleView == null)
      return 0;
    return localVehicleView.getMaxFareSplits();
  }

  public List<CnLocation> getNearby()
  {
    return this.nearby;
  }

  public Map<String, NearbyVehicle> getNearbyVehicles()
  {
    return this.nearbyVehicles;
  }

  public List<CnLocation> getPlaces()
  {
    return this.places;
  }

  public List<CnLocation> getRecent()
  {
    return this.recent;
  }

  public Session getSession()
  {
    return this.session;
  }

  public Map<String, String> getSignupFieldsRequired()
  {
    return this.signupRequired.getFields();
  }

  public boolean getThirdPartyConnected()
  {
    return this.thirdPartyConnected;
  }

  public Trip getTrip()
  {
    return this.trip;
  }

  public VehicleView getTripVehicleView()
  {
    if ((this.trip == null) || (this.city == null))
      return null;
    String str = this.trip.getVehicle().getVehicleViewId();
    if (this.city.findVehicleView(str) == null)
      str = this.city.getDefaultVehicleViewId();
    return this.city.findVehicleView(str);
  }

  public int hashCode()
  {
    int i = 1;
    int j = 31 * super.hashCode();
    int k;
    int n;
    label60: int i2;
    label86: int i4;
    label112: int i6;
    label138: int i8;
    label164: int i10;
    label190: int i12;
    label218: int i14;
    label244: int i16;
    label270: label287: int i19;
    label314: int i21;
    label342: int i23;
    label370: int i24;
    if (this.forceUpgrade)
    {
      k = i;
      int m = 31 * (31 * (j + k) + (int)(this.mapFittingMobileAppDelayWindowMs ^ this.mapFittingMobileAppDelayWindowMs >>> 32));
      if (this.forceUpgradeUrl == null)
        break label442;
      n = this.forceUpgradeUrl.hashCode();
      int i1 = 31 * (m + n);
      if (this.city == null)
        break label448;
      i2 = this.city.hashCode();
      int i3 = 31 * (i1 + i2);
      if (this.trip == null)
        break label454;
      i4 = this.trip.hashCode();
      int i5 = 31 * (i3 + i4);
      if (this.client == null)
        break label460;
      i6 = this.client.hashCode();
      int i7 = 31 * (i5 + i6);
      if (this.fareSplit == null)
        break label466;
      i8 = this.fareSplit.hashCode();
      int i9 = 31 * (i7 + i8);
      if (this.appConfig == null)
        break label472;
      i10 = this.appConfig.hashCode();
      int i11 = 31 * (i9 + i10);
      if (this.nearbyVehicles == null)
        break label478;
      i12 = this.nearbyVehicles.hashCode();
      int i13 = 31 * (i11 + i12);
      if (this.session == null)
        break label484;
      i14 = this.session.hashCode();
      int i15 = 31 * (i13 + i14);
      if (this.signupRequired == null)
        break label490;
      i16 = this.signupRequired.hashCode();
      int i17 = 31 * (i15 + i16);
      if (!this.thirdPartyConnected)
        break label496;
      int i18 = 31 * (i17 + i);
      if (this.places == null)
        break label501;
      i19 = this.places.hashCode();
      int i20 = 31 * (i18 + i19);
      if (this.recent == null)
        break label507;
      i21 = this.recent.hashCode();
      int i22 = 31 * (i20 + i21);
      if (this.nearby == null)
        break label513;
      i23 = this.nearby.hashCode();
      i24 = 31 * (i22 + i23);
      if (this.apiResponse == null)
        break label519;
    }
    label513: label519: for (int i25 = this.apiResponse.hashCode(); ; i25 = 0)
    {
      int i26 = 31 * (i24 + i25);
      List localList = this.errorObj;
      int i27 = 0;
      if (localList != null)
        i27 = this.errorObj.hashCode();
      return i26 + i27;
      k = 0;
      break;
      label442: n = 0;
      break label60;
      label448: i2 = 0;
      break label86;
      label454: i4 = 0;
      break label112;
      label460: i6 = 0;
      break label138;
      label466: i8 = 0;
      break label164;
      label472: i10 = 0;
      break label190;
      label478: i12 = 0;
      break label218;
      label484: i14 = 0;
      break label244;
      label490: i16 = 0;
      break label270;
      label496: i = 0;
      break label287;
      label501: i19 = 0;
      break label314;
      label507: i21 = 0;
      break label342;
      i23 = 0;
      break label370;
    }
  }

  public boolean isForceUpgrade()
  {
    return this.forceUpgrade;
  }

  public boolean lastIsSendExpense()
  {
    if ((this.client == null) || (getExpenseLinkType() == null) || (this.client.getLastExpenseInfo() == null))
      return false;
    return this.client.getLastExpenseInfo().isExpenseTrip();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.model.Ping
 * JD-Core Version:    0.6.2
 */