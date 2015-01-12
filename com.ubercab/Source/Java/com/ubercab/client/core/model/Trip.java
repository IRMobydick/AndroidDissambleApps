package com.ubercab.client.core.model;

import android.text.TextUtils;
import com.ubercab.common.base.Objects;
import com.ubercab.common.base.Predicate;
import com.ubercab.common.collect.ImmutableList;
import com.ubercab.common.collect.Iterables;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Trip
{
  public static final String PROMO_STRING_KEY = "promoString";
  public static final String STATE_UBERPOOL_MATCHED = "UberPoolMatched";
  public static final String STATE_UBERPOOL_MATCHING = "UberPoolMatching";
  public static final String STATE_UBERPOOL_NOT_MATCHED = "UberPoolNotMatched";
  Boolean canShareETA;
  Boolean canSplitFare;
  String cancelDialog = "";
  Integer currentLegIndex;
  String currentLegStatus;
  CnLocation destination;
  float dispatchPercent;
  TripDriver driver = new TripDriver();
  Map<String, TripEntity> entities;
  int eta;
  String etaString = "";
  String etaStringShort = "";
  Integer etaToDestination;
  TripExpenseInfo expense = new TripExpenseInfo();
  Map<String, Map<String, String>> extraStates;
  String fareSplitCode = "";
  String id;
  boolean isZeroTolerance;
  List<TripLeg> legs;
  Map<String, CnLocation> locations;
  String paymentProfileId = "";
  CnLocation pickupLocation = new CnLocation();
  String promoString;
  String routeToDestination;
  String shareUrl = "";
  boolean useCredits;
  TripVehicle vehicle = new TripVehicle();

  private boolean hasActionTypeBeforeLegForUser(String paramString1, TripLeg paramTripLeg, String paramString2)
  {
    if (this.legs == null);
    TripLeg localTripLeg;
    do
      do
      {
        Iterator localIterator;
        do
        {
          return false;
          localIterator = this.legs.iterator();
        }
        while (!localIterator.hasNext());
        localTripLeg = (TripLeg)localIterator.next();
      }
      while (paramTripLeg == localTripLeg);
    while (!legHasActionAndUser(localTripLeg, paramString1, paramString2));
    return true;
  }

  private boolean legHasActionAndUser(TripLeg paramTripLeg, final String paramString1, final String paramString2)
  {
    if ((this.entities == null) || (paramTripLeg.getActions() == null))
      return false;
    return Iterables.any(paramTripLeg.getActions(), new Predicate()
    {
      public boolean apply(TripLegAction paramAnonymousTripLegAction)
      {
        TripEntity localTripEntity = (TripEntity)Trip.this.entities.get(paramAnonymousTripLegAction.getEntityRef());
        return (paramString1.equals(paramAnonymousTripLegAction.getType())) && (localTripEntity != null) && (paramString2.equals(localTripEntity.getUuid()));
      }
    });
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    Trip localTrip;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localTrip = (Trip)paramObject;
      if (Float.compare(localTrip.dispatchPercent, this.dispatchPercent) != 0)
        return false;
      if (this.eta != localTrip.eta)
        return false;
      if (this.isZeroTolerance != localTrip.isZeroTolerance)
        return false;
      if (this.useCredits != localTrip.useCredits)
        return false;
      if (this.canShareETA != null)
      {
        if (this.canShareETA.equals(localTrip.canShareETA));
      }
      else
        while (localTrip.canShareETA != null)
          return false;
      if (this.canSplitFare != null)
      {
        if (this.canSplitFare.equals(localTrip.canSplitFare));
      }
      else
        while (localTrip.canSplitFare != null)
          return false;
      if (this.cancelDialog != null)
      {
        if (this.cancelDialog.equals(localTrip.cancelDialog));
      }
      else
        while (localTrip.cancelDialog != null)
          return false;
      if (this.currentLegIndex != null)
      {
        if (this.currentLegIndex.equals(localTrip.currentLegIndex));
      }
      else
        while (localTrip.currentLegIndex != null)
          return false;
      if (this.currentLegStatus != null)
      {
        if (this.currentLegStatus.equals(localTrip.currentLegStatus));
      }
      else
        while (localTrip.currentLegStatus != null)
          return false;
      if (this.destination != null)
      {
        if (this.destination.equals(localTrip.destination));
      }
      else
        while (localTrip.destination != null)
          return false;
      if (this.driver != null)
      {
        if (this.driver.equals(localTrip.driver));
      }
      else
        while (localTrip.driver != null)
          return false;
      if (this.entities != null)
      {
        if (this.entities.equals(localTrip.entities));
      }
      else
        while (localTrip.entities != null)
          return false;
      if (this.etaString != null)
      {
        if (this.etaString.equals(localTrip.etaString));
      }
      else
        while (localTrip.etaString != null)
          return false;
      if (this.etaStringShort != null)
      {
        if (this.etaStringShort.equals(localTrip.etaStringShort));
      }
      else
        while (localTrip.etaStringShort != null)
          return false;
      if (this.etaToDestination != null)
      {
        if (this.etaToDestination.equals(localTrip.etaToDestination));
      }
      else
        while (localTrip.etaToDestination != null)
          return false;
      if (this.expense != null)
      {
        if (this.expense.equals(localTrip.expense));
      }
      else
        while (localTrip.expense != null)
          return false;
      if (this.extraStates != null)
      {
        if (this.extraStates.equals(localTrip.extraStates));
      }
      else
        while (localTrip.extraStates != null)
          return false;
      if (this.fareSplitCode != null)
      {
        if (this.fareSplitCode.equals(localTrip.fareSplitCode));
      }
      else
        while (localTrip.fareSplitCode != null)
          return false;
      if (this.id != null)
      {
        if (this.id.equals(localTrip.id));
      }
      else
        while (localTrip.id != null)
          return false;
      if (this.legs != null)
      {
        if (this.legs.equals(localTrip.legs));
      }
      else
        while (localTrip.legs != null)
          return false;
      if (this.locations != null)
      {
        if (this.locations.equals(localTrip.locations));
      }
      else
        while (localTrip.locations != null)
          return false;
      if (this.paymentProfileId != null)
      {
        if (this.paymentProfileId.equals(localTrip.paymentProfileId));
      }
      else
        while (localTrip.paymentProfileId != null)
          return false;
      if (this.pickupLocation != null)
      {
        if (this.pickupLocation.equals(localTrip.pickupLocation));
      }
      else
        while (localTrip.pickupLocation != null)
          return false;
      if (this.promoString != null)
      {
        if (this.promoString.equals(localTrip.promoString));
      }
      else
        while (localTrip.promoString != null)
          return false;
      if (this.routeToDestination != null)
      {
        if (this.routeToDestination.equals(localTrip.routeToDestination));
      }
      else
        while (localTrip.routeToDestination != null)
          return false;
      if (this.shareUrl != null)
      {
        if (this.shareUrl.equals(localTrip.shareUrl));
      }
      else
        while (localTrip.shareUrl != null)
          return false;
      if (this.vehicle == null)
        break;
    }
    while (this.vehicle.equals(localTrip.vehicle));
    while (true)
    {
      return false;
      if (localTrip.vehicle == null)
        break;
    }
  }

  public boolean getCanShareETA()
  {
    if (this.canShareETA != null)
      return this.canShareETA.booleanValue();
    return true;
  }

  public boolean getCanSplitFare()
  {
    if (this.canSplitFare != null)
      return this.canSplitFare.booleanValue();
    return true;
  }

  public String getCancelDialog()
  {
    return this.cancelDialog;
  }

  public Integer getCurrentLeg()
  {
    return this.currentLegIndex;
  }

  public String getCurrentLegStatus()
  {
    return this.currentLegStatus;
  }

  public CnLocation getDestination()
  {
    return this.destination;
  }

  public float getDispatchPercent()
  {
    return this.dispatchPercent;
  }

  public TripDriver getDriver()
  {
    return this.driver;
  }

  public Map<String, TripEntity> getEntities()
  {
    return this.entities;
  }

  public TripEntity getEntity(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.entities == null))
      return null;
    return (TripEntity)this.entities.get(paramString);
  }

  public int getEta()
  {
    return this.eta;
  }

  public String getEtaString()
  {
    return this.etaString;
  }

  public String getEtaStringShort()
  {
    return this.etaStringShort;
  }

  public Integer getEtaToDestination()
  {
    return this.etaToDestination;
  }

  public TripExpenseInfo getExpense()
  {
    return this.expense;
  }

  public Map<String, Map<String, String>> getExtraStates()
  {
    return this.extraStates;
  }

  public String getFareSplitCode()
  {
    return this.fareSplitCode;
  }

  public String getId()
  {
    return this.id;
  }

  public boolean getIsZeroTolerance()
  {
    return this.isZeroTolerance;
  }

  public List<TripLeg> getLegs()
  {
    return this.legs;
  }

  public List<TripLeg> getLegsBetweenCurrentLegAndPickup(Client paramClient)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = getRemainingLegs().iterator();
    while (localIterator.hasNext())
    {
      TripLeg localTripLeg = (TripLeg)localIterator.next();
      if (isUserInVehicleForLeg(localTripLeg, paramClient.getUuid()))
        break;
      localArrayList.add(localTripLeg);
    }
    return localArrayList;
  }

  public CnLocation getLocation(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.locations == null))
      return null;
    return (CnLocation)this.locations.get(paramString);
  }

  public Map<String, CnLocation> getLocations()
  {
    return this.locations;
  }

  public String getPaymentProfileId()
  {
    return this.paymentProfileId;
  }

  public CnLocation getPickupLocation()
  {
    return this.pickupLocation;
  }

  public String getPromoString()
  {
    return this.promoString;
  }

  public List<TripLeg> getRemainingLegs()
  {
    if ((this.legs != null) && (this.currentLegIndex.intValue() < this.legs.size()))
      return this.legs.subList(this.currentLegIndex.intValue(), this.legs.size());
    return ImmutableList.of();
  }

  public String getRouteToDestination()
  {
    return this.routeToDestination;
  }

  public String getShareUrl()
  {
    return this.shareUrl;
  }

  public TripVehicle getVehicle()
  {
    return this.vehicle;
  }

  public int hashCode()
  {
    int i = 1;
    int j = 31 * this.eta;
    int k;
    int n;
    label51: int i2;
    label77: int i4;
    label103: int i6;
    label123: int i9;
    label140: label165: int i11;
    label191: int i13;
    label217: int i15;
    label243: int i17;
    label269: int i19;
    label295: int i21;
    label321: int i23;
    label347: int i25;
    label373: int i27;
    label399: int i29;
    label425: int i31;
    label453: int i33;
    label479: int i35;
    label505: int i37;
    label533: int i39;
    label561: int i41;
    label589: int i43;
    label615: int i44;
    if (this.etaToDestination != null)
    {
      k = this.etaToDestination.hashCode();
      int m = 31 * (j + k);
      if (this.dispatchPercent == 0.0F)
        break label685;
      n = Float.floatToIntBits(this.dispatchPercent);
      int i1 = 31 * (m + n);
      if (this.canSplitFare == null)
        break label691;
      i2 = this.canSplitFare.hashCode();
      int i3 = 31 * (i1 + i2);
      if (this.canShareETA == null)
        break label697;
      i4 = this.canShareETA.hashCode();
      int i5 = 31 * (i3 + i4);
      if (!this.useCredits)
        break label703;
      i6 = i;
      int i7 = 31 * (i5 + i6);
      if (!this.isZeroTolerance)
        break label709;
      int i8 = 31 * (i7 + i);
      if (this.id == null)
        break label714;
      i9 = this.id.hashCode();
      int i10 = 31 * (i8 + i9);
      if (this.paymentProfileId == null)
        break label720;
      i11 = this.paymentProfileId.hashCode();
      int i12 = 31 * (i10 + i11);
      if (this.promoString == null)
        break label726;
      i13 = this.promoString.hashCode();
      int i14 = 31 * (i12 + i13);
      if (this.cancelDialog == null)
        break label732;
      i15 = this.cancelDialog.hashCode();
      int i16 = 31 * (i14 + i15);
      if (this.currentLegStatus == null)
        break label738;
      i17 = this.currentLegStatus.hashCode();
      int i18 = 31 * (i16 + i17);
      if (this.etaString == null)
        break label744;
      i19 = this.etaString.hashCode();
      int i20 = 31 * (i18 + i19);
      if (this.etaStringShort == null)
        break label750;
      i21 = this.etaStringShort.hashCode();
      int i22 = 31 * (i20 + i21);
      if (this.fareSplitCode == null)
        break label756;
      i23 = this.fareSplitCode.hashCode();
      int i24 = 31 * (i22 + i23);
      if (this.routeToDestination == null)
        break label762;
      i25 = this.routeToDestination.hashCode();
      int i26 = 31 * (i24 + i25);
      if (this.shareUrl == null)
        break label768;
      i27 = this.shareUrl.hashCode();
      int i28 = 31 * (i26 + i27);
      if (this.destination == null)
        break label774;
      i29 = this.destination.hashCode();
      int i30 = 31 * (i28 + i29);
      if (this.extraStates == null)
        break label780;
      i31 = this.extraStates.hashCode();
      int i32 = 31 * (i30 + i31);
      if (this.pickupLocation == null)
        break label786;
      i33 = this.pickupLocation.hashCode();
      int i34 = 31 * (i32 + i33);
      if (this.currentLegIndex == null)
        break label792;
      i35 = this.currentLegIndex.hashCode();
      int i36 = 31 * (i34 + i35);
      if (this.legs == null)
        break label798;
      i37 = this.legs.hashCode();
      int i38 = 31 * (i36 + i37);
      if (this.locations == null)
        break label804;
      i39 = this.locations.hashCode();
      int i40 = 31 * (i38 + i39);
      if (this.entities == null)
        break label810;
      i41 = this.entities.hashCode();
      int i42 = 31 * (i40 + i41);
      if (this.driver == null)
        break label816;
      i43 = this.driver.hashCode();
      i44 = 31 * (i42 + i43);
      if (this.expense == null)
        break label822;
    }
    label685: label691: label822: for (int i45 = this.expense.hashCode(); ; i45 = 0)
    {
      int i46 = 31 * (i44 + i45);
      TripVehicle localTripVehicle = this.vehicle;
      int i47 = 0;
      if (localTripVehicle != null)
        i47 = this.vehicle.hashCode();
      return i46 + i47;
      k = 0;
      break;
      n = 0;
      break label51;
      i2 = 0;
      break label77;
      label697: i4 = 0;
      break label103;
      label703: i6 = 0;
      break label123;
      label709: i = 0;
      break label140;
      label714: i9 = 0;
      break label165;
      label720: i11 = 0;
      break label191;
      label726: i13 = 0;
      break label217;
      label732: i15 = 0;
      break label243;
      label738: i17 = 0;
      break label269;
      label744: i19 = 0;
      break label295;
      label750: i21 = 0;
      break label321;
      label756: i23 = 0;
      break label347;
      label762: i25 = 0;
      break label373;
      i27 = 0;
      break label399;
      i29 = 0;
      break label425;
      i31 = 0;
      break label453;
      i33 = 0;
      break label479;
      i35 = 0;
      break label505;
      i37 = 0;
      break label533;
      i39 = 0;
      break label561;
      i41 = 0;
      break label589;
      i43 = 0;
      break label615;
    }
  }

  public boolean isLegForUser(TripLeg paramTripLeg, String paramString)
  {
    if ((paramTripLeg.getActions() == null) || (this.entities == null));
    TripEntity localTripEntity;
    do
    {
      Iterator localIterator;
      while (!localIterator.hasNext())
      {
        return false;
        localIterator = paramTripLeg.getActions().iterator();
      }
      TripLegAction localTripLegAction = (TripLegAction)localIterator.next();
      localTripEntity = (TripEntity)this.entities.get(localTripLegAction.getEntityRef());
    }
    while ((localTripEntity == null) || (!Objects.equal(localTripEntity.getUuid(), paramString)));
    return true;
  }

  public boolean isUseCredits()
  {
    return this.useCredits;
  }

  public boolean isUserInVehicleForLeg(TripLeg paramTripLeg, String paramString)
  {
    boolean bool1 = hasActionTypeBeforeLegForUser("Pickup", paramTripLeg, paramString);
    boolean bool2 = hasActionTypeBeforeLegForUser("Dropoff", paramTripLeg, paramString);
    return (bool1) && (!bool2);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.model.Trip
 * JD-Core Version:    0.6.2
 */