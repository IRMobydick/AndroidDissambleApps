package com.ubercab.client.core.model;

import android.text.TextUtils;
import com.ubercab.common.base.Optional;
import com.ubercab.common.base.Predicate;
import com.ubercab.common.collect.Iterables;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Client
{
  public static final String STATUS_DISPATCHING = "Dispatching";
  public static final String STATUS_LOOKING = "Looking";
  public static final String STATUS_ON_TRIP = "OnTrip";
  public static final String STATUS_WAITING_FOR_PICKUP = "WaitingForPickup";
  Map<String, Experiment> activeExperiments = new HashMap();
  List<CreditBalance> creditBalances = new ArrayList();
  String email = "";
  String fareSplitFeeString = "";
  String firstName = "";
  boolean hasAmericanMobile = false;
  boolean hasConfirmedMobile = false;
  boolean hasToOptInSmsNotifications = false;
  List<PaymentProfile> inactivePaymentProfiles;
  boolean isAdmin = false;
  Itinerary lastEstimatedTrip = null;
  TripExpenseInfo lastExpenseInfo = new TripExpenseInfo();
  String lastName = "";
  String lastRequestMsg = "";
  String lastRequestNote = "";
  String lastSelectedPaymentGoogleWalletId = "";
  String lastSelectedPaymentProfileId = "";
  String mobile = "";
  String mobileCountryCode = "";
  int mobileCountryId = 0;
  String mobileCountryIso2 = "";
  String mobileDigits = "";
  List<PaymentProfile> paymentProfiles = new ArrayList();
  String pictureUrl = "";
  String promotion = "";
  List<RecentFareSplitter> recentFareSplitters = new ArrayList();
  String referralCode = "";
  String referralUrl = "";
  ReverseGeocode reverseGeocode = null;
  String role = "";
  String status = "";
  Map<String, ThirdPartyIdentity> thirdPartyIdentities = new HashMap();
  String token = "";
  List<TripBalance> tripBalances = new ArrayList();
  TripPendingRating tripPendingRating = null;
  String uuid = "";

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    Client localClient;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localClient = (Client)paramObject;
      if (this.hasAmericanMobile != localClient.hasAmericanMobile)
        return false;
      if (this.hasConfirmedMobile != localClient.hasConfirmedMobile)
        return false;
      if (this.hasToOptInSmsNotifications != localClient.hasToOptInSmsNotifications)
        return false;
      if (this.isAdmin != localClient.isAdmin)
        return false;
      if (this.mobileCountryId != localClient.mobileCountryId)
        return false;
      if (this.activeExperiments != null)
      {
        if (this.activeExperiments.equals(localClient.activeExperiments));
      }
      else
        while (localClient.activeExperiments != null)
          return false;
      if (this.creditBalances != null)
      {
        if (this.creditBalances.equals(localClient.creditBalances));
      }
      else
        while (localClient.creditBalances != null)
          return false;
      if (this.tripBalances != null)
      {
        if (this.tripBalances.equals(localClient.tripBalances));
      }
      else
        while (localClient.tripBalances != null)
          return false;
      if (this.email != null)
      {
        if (this.email.equals(localClient.email));
      }
      else
        while (localClient.email != null)
          return false;
      if (this.fareSplitFeeString != null)
      {
        if (this.fareSplitFeeString.equals(localClient.fareSplitFeeString));
      }
      else
        while (localClient.fareSplitFeeString != null)
          return false;
      if (this.firstName != null)
      {
        if (this.firstName.equals(localClient.firstName));
      }
      else
        while (localClient.firstName != null)
          return false;
      if (this.uuid != null)
      {
        if (this.uuid.equals(localClient.uuid));
      }
      else
        while (localClient.uuid != null)
          return false;
      if (this.lastEstimatedTrip != null)
      {
        if (this.lastEstimatedTrip.equals(localClient.lastEstimatedTrip));
      }
      else
        while (localClient.lastEstimatedTrip != null)
          return false;
      if (this.lastExpenseInfo != null)
      {
        if (this.lastExpenseInfo.equals(localClient.lastExpenseInfo));
      }
      else
        while (localClient.lastExpenseInfo != null)
          return false;
      if (this.lastName != null)
      {
        if (this.lastName.equals(localClient.lastName));
      }
      else
        while (localClient.lastName != null)
          return false;
      if (this.lastRequestMsg != null)
      {
        if (this.lastRequestMsg.equals(localClient.lastRequestMsg));
      }
      else
        while (localClient.lastRequestMsg != null)
          return false;
      if (this.lastRequestNote != null)
      {
        if (this.lastRequestNote.equals(localClient.lastRequestNote));
      }
      else
        while (localClient.lastRequestNote != null)
          return false;
      if (this.lastSelectedPaymentGoogleWalletId != null)
      {
        if (this.lastSelectedPaymentGoogleWalletId.equals(localClient.lastSelectedPaymentGoogleWalletId));
      }
      else
        while (localClient.lastSelectedPaymentGoogleWalletId != null)
          return false;
      if (this.lastSelectedPaymentProfileId != null)
      {
        if (this.lastSelectedPaymentProfileId.equals(localClient.lastSelectedPaymentProfileId));
      }
      else
        while (localClient.lastSelectedPaymentProfileId != null)
          return false;
      if (this.mobile != null)
      {
        if (this.mobile.equals(localClient.mobile));
      }
      else
        while (localClient.mobile != null)
          return false;
      if (this.mobileCountryCode != null)
      {
        if (this.mobileCountryCode.equals(localClient.mobileCountryCode));
      }
      else
        while (localClient.mobileCountryCode != null)
          return false;
      if (this.mobileCountryIso2 != null)
      {
        if (this.mobileCountryIso2.equals(localClient.mobileCountryIso2));
      }
      else
        while (localClient.mobileCountryIso2 != null)
          return false;
      if (this.mobileDigits != null)
      {
        if (this.mobileDigits.equals(localClient.mobileDigits));
      }
      else
        while (localClient.mobileDigits != null)
          return false;
      if (this.paymentProfiles != null)
      {
        if (this.paymentProfiles.equals(localClient.paymentProfiles));
      }
      else
        while (localClient.paymentProfiles != null)
          return false;
      if (this.inactivePaymentProfiles != null)
      {
        if (this.inactivePaymentProfiles.equals(localClient.inactivePaymentProfiles));
      }
      else
        while (localClient.inactivePaymentProfiles != null)
          return false;
      if (this.pictureUrl != null)
      {
        if (this.pictureUrl.equals(localClient.pictureUrl));
      }
      else
        while (localClient.pictureUrl != null)
          return false;
      if (this.promotion != null)
      {
        if (this.promotion.equals(localClient.promotion));
      }
      else
        while (localClient.promotion != null)
          return false;
      if (this.recentFareSplitters != null)
      {
        if (this.recentFareSplitters.equals(localClient.recentFareSplitters));
      }
      else
        while (localClient.recentFareSplitters != null)
          return false;
      if (this.referralCode != null)
      {
        if (this.referralCode.equals(localClient.referralCode));
      }
      else
        while (localClient.referralCode != null)
          return false;
      if (this.referralUrl != null)
      {
        if (this.referralUrl.equals(localClient.referralUrl));
      }
      else
        while (localClient.referralUrl != null)
          return false;
      if (this.reverseGeocode != null)
      {
        if (this.reverseGeocode.equals(localClient.reverseGeocode));
      }
      else
        while (localClient.reverseGeocode != null)
          return false;
      if (this.role != null)
      {
        if (this.role.equals(localClient.role));
      }
      else
        while (localClient.role != null)
          return false;
      if (this.status != null)
      {
        if (this.status.equals(localClient.status));
      }
      else
        while (localClient.status != null)
          return false;
      if (this.token != null)
      {
        if (this.token.equals(localClient.token));
      }
      else
        while (localClient.token != null)
          return false;
      if (this.thirdPartyIdentities != null)
      {
        if (this.thirdPartyIdentities.equals(localClient.thirdPartyIdentities));
      }
      else
        while (localClient.thirdPartyIdentities != null)
          return false;
      if (this.tripPendingRating == null)
        break;
    }
    while (this.tripPendingRating.equals(localClient.tripPendingRating));
    while (true)
    {
      return false;
      if (localClient.tripPendingRating == null)
        break;
    }
  }

  public PaymentProfile findLastSelectedPaymentProfile()
  {
    if (this.paymentProfiles.size() == 0)
      return null;
    Iterator localIterator = this.paymentProfiles.iterator();
    while (localIterator.hasNext())
    {
      PaymentProfile localPaymentProfile = (PaymentProfile)localIterator.next();
      if (localPaymentProfile.getId().equals(this.lastSelectedPaymentProfileId))
        return localPaymentProfile;
    }
    return (PaymentProfile)this.paymentProfiles.get(0);
  }

  public PaymentProfile findPaymentProfileWithId(final String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      return null;
    return (PaymentProfile)Iterables.tryFind(this.paymentProfiles, new Predicate()
    {
      public boolean apply(PaymentProfile paramAnonymousPaymentProfile)
      {
        return paramAnonymousPaymentProfile.getId().equals(paramString);
      }
    }).orNull();
  }

  public PaymentProfile findPaymentProfileWithUuid(final String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      return null;
    return (PaymentProfile)Iterables.tryFind(this.paymentProfiles, new Predicate()
    {
      public boolean apply(PaymentProfile paramAnonymousPaymentProfile)
      {
        return paramAnonymousPaymentProfile.getUuid().equals(paramString);
      }
    }).orNull();
  }

  public Map<String, Experiment> getActiveExperiments()
  {
    return this.activeExperiments;
  }

  public List<CreditBalance> getCreditBalances()
  {
    return this.creditBalances;
  }

  public String getEmail()
  {
    return this.email;
  }

  public String getFareSplitFeeString()
  {
    return this.fareSplitFeeString;
  }

  public String getFirstName()
  {
    return this.firstName;
  }

  public List<PaymentProfile> getInactivePaymentProfiles()
  {
    return this.inactivePaymentProfiles;
  }

  public Itinerary getLastEstimatedTrip()
  {
    return this.lastEstimatedTrip;
  }

  public TripExpenseInfo getLastExpenseInfo()
  {
    return this.lastExpenseInfo;
  }

  public String getLastName()
  {
    return this.lastName;
  }

  public String getLastRequestMsg()
  {
    return this.lastRequestMsg;
  }

  public String getLastRequestNote()
  {
    return this.lastRequestNote;
  }

  public String getLastSelectedPaymentGoogleWalletId()
  {
    return this.lastSelectedPaymentGoogleWalletId;
  }

  public String getLastSelectedPaymentProfileId()
  {
    return this.lastSelectedPaymentProfileId;
  }

  public String getMobile()
  {
    return this.mobile;
  }

  public String getMobileCountryCode()
  {
    return this.mobileCountryCode;
  }

  public int getMobileCountryId()
  {
    return this.mobileCountryId;
  }

  public String getMobileCountryIso2()
  {
    return this.mobileCountryIso2;
  }

  public String getMobileDigits()
  {
    return this.mobileDigits;
  }

  public List<PaymentProfile> getPaymentProfiles()
  {
    return this.paymentProfiles;
  }

  public String getPictureUrl()
  {
    return this.pictureUrl;
  }

  public String getPromotion()
  {
    return this.promotion;
  }

  public List<RecentFareSplitter> getRecentFareSplitters()
  {
    return this.recentFareSplitters;
  }

  public String getReferralCode()
  {
    return this.referralCode;
  }

  public String getReferralUrl()
  {
    return this.referralUrl;
  }

  public ReverseGeocode getReverseGeocode()
  {
    return this.reverseGeocode;
  }

  public String getRole()
  {
    return this.role;
  }

  public String getStatus()
  {
    return this.status;
  }

  public Map<String, ThirdPartyIdentity> getThirdPartyIdentities()
  {
    return this.thirdPartyIdentities;
  }

  public String getToken()
  {
    return this.token;
  }

  public int getTotalTripBalances()
  {
    int i;
    if (this.tripBalances == null)
      i = 0;
    while (true)
    {
      return i;
      i = 0;
      Iterator localIterator = this.tripBalances.iterator();
      while (localIterator.hasNext())
        i += ((TripBalance)localIterator.next()).getCount().intValue();
    }
  }

  public List<TripBalance> getTripBalances()
  {
    return this.tripBalances;
  }

  public TripPendingRating getTripPendingRating()
  {
    return this.tripPendingRating;
  }

  public String getUuid()
  {
    return this.uuid;
  }

  public boolean hasAmericanMobile()
  {
    return this.hasAmericanMobile;
  }

  public boolean hasConfirmedMobile()
  {
    return this.hasConfirmedMobile;
  }

  public boolean hasToOptInSmsNotifications()
  {
    return this.hasToOptInSmsNotifications;
  }

  public int hashCode()
  {
    int i = 1;
    int j = 31 * this.mobileCountryId;
    int k;
    int n;
    label37: int i2;
    label57: label74: int i5;
    label99: int i7;
    label125: int i9;
    label151: int i11;
    label177: int i13;
    label203: int i15;
    label229: int i17;
    label255: int i19;
    label281: int i21;
    label307: int i23;
    label333: int i25;
    label359: int i27;
    label385: int i29;
    label411: int i31;
    label437: int i33;
    label463: int i35;
    label489: int i37;
    label515: int i39;
    label541: int i41;
    label567: int i43;
    label593: int i45;
    label619: int i47;
    label645: int i49;
    label671: int i51;
    label697: int i53;
    label725: int i55;
    label753: int i57;
    label781: int i59;
    label809: int i61;
    label837: int i62;
    if (this.isAdmin)
    {
      k = i;
      int m = 31 * (j + k);
      if (!this.hasAmericanMobile)
        break label911;
      n = i;
      int i1 = 31 * (m + n);
      if (!this.hasConfirmedMobile)
        break label917;
      i2 = i;
      int i3 = 31 * (i1 + i2);
      if (!this.hasToOptInSmsNotifications)
        break label923;
      int i4 = 31 * (i3 + i);
      if (this.email == null)
        break label928;
      i5 = this.email.hashCode();
      int i6 = 31 * (i4 + i5);
      if (this.fareSplitFeeString == null)
        break label934;
      i7 = this.fareSplitFeeString.hashCode();
      int i8 = 31 * (i6 + i7);
      if (this.firstName == null)
        break label940;
      i9 = this.firstName.hashCode();
      int i10 = 31 * (i8 + i9);
      if (this.uuid == null)
        break label946;
      i11 = this.uuid.hashCode();
      int i12 = 31 * (i10 + i11);
      if (this.lastName == null)
        break label952;
      i13 = this.lastName.hashCode();
      int i14 = 31 * (i12 + i13);
      if (this.lastRequestMsg == null)
        break label958;
      i15 = this.lastRequestMsg.hashCode();
      int i16 = 31 * (i14 + i15);
      if (this.lastRequestNote == null)
        break label964;
      i17 = this.lastRequestNote.hashCode();
      int i18 = 31 * (i16 + i17);
      if (this.mobile == null)
        break label970;
      i19 = this.mobile.hashCode();
      int i20 = 31 * (i18 + i19);
      if (this.mobileCountryCode == null)
        break label976;
      i21 = this.mobileCountryCode.hashCode();
      int i22 = 31 * (i20 + i21);
      if (this.mobileCountryIso2 == null)
        break label982;
      i23 = this.mobileCountryIso2.hashCode();
      int i24 = 31 * (i22 + i23);
      if (this.mobileDigits == null)
        break label988;
      i25 = this.mobileDigits.hashCode();
      int i26 = 31 * (i24 + i25);
      if (this.pictureUrl == null)
        break label994;
      i27 = this.pictureUrl.hashCode();
      int i28 = 31 * (i26 + i27);
      if (this.promotion == null)
        break label1000;
      i29 = this.promotion.hashCode();
      int i30 = 31 * (i28 + i29);
      if (this.referralCode == null)
        break label1006;
      i31 = this.referralCode.hashCode();
      int i32 = 31 * (i30 + i31);
      if (this.referralUrl == null)
        break label1012;
      i33 = this.referralUrl.hashCode();
      int i34 = 31 * (i32 + i33);
      if (this.role == null)
        break label1018;
      i35 = this.role.hashCode();
      int i36 = 31 * (i34 + i35);
      if (this.status == null)
        break label1024;
      i37 = this.status.hashCode();
      int i38 = 31 * (i36 + i37);
      if (this.token == null)
        break label1030;
      i39 = this.token.hashCode();
      int i40 = 31 * (i38 + i39);
      if (this.lastSelectedPaymentProfileId == null)
        break label1036;
      i41 = this.lastSelectedPaymentProfileId.hashCode();
      int i42 = 31 * (i40 + i41);
      if (this.lastSelectedPaymentGoogleWalletId == null)
        break label1042;
      i43 = this.lastSelectedPaymentGoogleWalletId.hashCode();
      int i44 = 31 * (i42 + i43);
      if (this.lastEstimatedTrip == null)
        break label1048;
      i45 = this.lastEstimatedTrip.hashCode();
      int i46 = 31 * (i44 + i45);
      if (this.lastExpenseInfo == null)
        break label1054;
      i47 = this.lastExpenseInfo.hashCode();
      int i48 = 31 * (i46 + i47);
      if (this.reverseGeocode == null)
        break label1060;
      i49 = this.reverseGeocode.hashCode();
      int i50 = 31 * (i48 + i49);
      if (this.tripPendingRating == null)
        break label1066;
      i51 = this.tripPendingRating.hashCode();
      int i52 = 31 * (i50 + i51);
      if (this.creditBalances == null)
        break label1072;
      i53 = this.creditBalances.hashCode();
      int i54 = 31 * (i52 + i53);
      if (this.tripBalances == null)
        break label1078;
      i55 = this.tripBalances.hashCode();
      int i56 = 31 * (i54 + i55);
      if (this.paymentProfiles == null)
        break label1084;
      i57 = this.paymentProfiles.hashCode();
      int i58 = 31 * (i56 + i57);
      if (this.inactivePaymentProfiles == null)
        break label1090;
      i59 = this.inactivePaymentProfiles.hashCode();
      int i60 = 31 * (i58 + i59);
      if (this.recentFareSplitters == null)
        break label1096;
      i61 = this.recentFareSplitters.hashCode();
      i62 = 31 * (i60 + i61);
      if (this.thirdPartyIdentities == null)
        break label1102;
    }
    label911: label917: label923: label928: label934: label940: label946: label952: label958: label964: label970: label1102: for (int i63 = this.thirdPartyIdentities.hashCode(); ; i63 = 0)
    {
      int i64 = 31 * (i62 + i63);
      Map localMap = this.activeExperiments;
      int i65 = 0;
      if (localMap != null)
        i65 = this.activeExperiments.hashCode();
      return i64 + i65;
      k = 0;
      break;
      n = 0;
      break label37;
      i2 = 0;
      break label57;
      i = 0;
      break label74;
      i5 = 0;
      break label99;
      i7 = 0;
      break label125;
      i9 = 0;
      break label151;
      i11 = 0;
      break label177;
      i13 = 0;
      break label203;
      i15 = 0;
      break label229;
      i17 = 0;
      break label255;
      i19 = 0;
      break label281;
      label976: i21 = 0;
      break label307;
      label982: i23 = 0;
      break label333;
      label988: i25 = 0;
      break label359;
      label994: i27 = 0;
      break label385;
      label1000: i29 = 0;
      break label411;
      label1006: i31 = 0;
      break label437;
      label1012: i33 = 0;
      break label463;
      label1018: i35 = 0;
      break label489;
      i37 = 0;
      break label515;
      i39 = 0;
      break label541;
      i41 = 0;
      break label567;
      i43 = 0;
      break label593;
      i45 = 0;
      break label619;
      i47 = 0;
      break label645;
      i49 = 0;
      break label671;
      i51 = 0;
      break label697;
      i53 = 0;
      break label725;
      i55 = 0;
      break label753;
      i57 = 0;
      break label781;
      i59 = 0;
      break label809;
      i61 = 0;
      break label837;
    }
  }

  public boolean isAdmin()
  {
    return this.isAdmin;
  }

  public boolean isLastSelectedPaymentProfileGoogleWallet()
  {
    return (this.lastSelectedPaymentProfileId == null) && (!TextUtils.isEmpty(this.lastSelectedPaymentGoogleWalletId));
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.model.Client
 * JD-Core Version:    0.6.2
 */