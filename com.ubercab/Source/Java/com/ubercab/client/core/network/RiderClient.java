package com.ubercab.client.core.network;

import com.ubercab.client.core.model.CnLocation;
import com.ubercab.client.core.model.Ping;
import com.ubercab.client.core.model.TripExpenseInfo;
import com.ubercab.library.network.dispatch.DispatchCallback;
import java.util.List;

public abstract interface RiderClient
{
  public static final String MESSAGE_TYPE_ADD_EXPENSE_INFO = "AddExpenseInfo";
  public static final String MESSAGE_TYPE_API_COMMAND = "ApiCommand";
  public static final String MESSAGE_TYPE_FARE_SPLIT_ACCEPT = "FareSplitAccept";
  public static final String MESSAGE_TYPE_FARE_SPLIT_DECLINE = "FareSplitDecline";
  public static final String MESSAGE_TYPE_FARE_SPLIT_INVITE = "FareSplitInvite";
  public static final String MESSAGE_TYPE_FARE_SPLIT_UNINVITE = "FareSplitUninvite";
  public static final String MESSAGE_TYPE_LOCATION_SEARCH = "LocationSearch";
  public static final String MESSAGE_TYPE_LOGIN = "Login";
  public static final String MESSAGE_TYPE_OPT_IN_NOTIFICATION = "OptInNotification";
  public static final String MESSAGE_TYPE_PICKUP = "Pickup";
  public static final String MESSAGE_TYPE_PICKUP_CANCELED_CLIENT = "PickupCanceledClient";
  public static final String MESSAGE_TYPE_PING_CLIENT = "PingClient";
  public static final String MESSAGE_TYPE_RATE_DRIVER = "RatingDriver";
  public static final String MESSAGE_TYPE_REGISTER_PUSH_TOKEN = "RegisterPushToken";
  public static final String MESSAGE_TYPE_SELECT_PAYMENT_PROFILE = "SelectPaymentProfile";
  public static final String MESSAGE_TYPE_SET_DESTINATION = "SetDestination";
  public static final String MESSAGE_TYPE_SET_USE_CREDITS = "SetUseCredits";
  public static final String MESSAGE_TYPE_SHARE_YO_RIDE = "ShareYoRide";
  public static final String MESSAGE_TYPE_SIGN_UP_CLIENT = "SignUpClient";
  public static final String MESSAGE_TYPE_THIRD_PARTY_AUTH = "AuthenticateThirdParty";
  public static final String MESSAGE_TYPE_UNREGISTER_PUSH_TOKEN = "UnregisterPushToken";
  public static final String PARAM_DEVICE_TOKEN = "deviceToken";
  public static final String PARAM_DEVICE_TOKEN_TYPE = "deviceTokenType";
  public static final String PARAM_USE_CASE_PERSONAL = "personal";

  public abstract void addExpenseInfo(TripExpenseInfo paramTripExpenseInfo);

  public abstract void applyPromo(String paramString, boolean paramBoolean);

  public abstract void authenticateWithThirdParty(String paramString1, String paramString2);

  public abstract void checkForEmployeeUpgrade();

  public abstract void confirmMobile(String paramString);

  public abstract void createPaymentProfile(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, boolean paramBoolean1, boolean paramBoolean2);

  public abstract void createPaymentProfileAlipay(String paramString1, String paramString2);

  public abstract void createPaymentProfilePayPal(String paramString1, String paramString2);

  public abstract void createPaymentProfilePayTm(String paramString1, String paramString2);

  public abstract void createThirdPartyIdentity(String paramString1, String paramString2);

  public abstract void deletePaymentProfile(String paramString);

  public abstract void deleteThirdPartyIdentity(String paramString);

  public abstract void fareSplitAccept(String paramString1, String paramString2);

  public abstract void fareSplitDecline();

  public abstract void fareSplitInvite(List<String> paramList);

  public abstract void fareSplitUninvite(String paramString);

  public abstract void locationSearch(String paramString, String[] paramArrayOfString);

  public abstract void login(String paramString1, String paramString2);

  public abstract void loginGoogle(String paramString1, String paramString2);

  public abstract void manualRefresh();

  public abstract void payBill(int paramInt, String paramString);

  public abstract void pickup(CnLocation paramCnLocation1, CnLocation paramCnLocation2, CnLocation paramCnLocation3, int paramInt, long paramLong, String paramString1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, TripExpenseInfo paramTripExpenseInfo, String paramString2);

  public abstract void pickupCancelClient();

  public abstract void pingClient();

  public abstract void rateDriver(String paramString1, int paramInt1, int paramInt2, String paramString2);

  public abstract void registerPushToken(String paramString1, String paramString2, DispatchCallback<Ping> paramDispatchCallback);

  public abstract void requestMobileConfirmation();

  public abstract void scheduleSurgeDropNotification(long paramLong, int paramInt, CnLocation paramCnLocation);

  public abstract void selectPaymentProfile(String paramString1, boolean paramBoolean, String paramString2);

  public abstract void setDestination(int paramInt, long paramLong, CnLocation paramCnLocation1, CnLocation paramCnLocation2);

  public abstract void setUseCredits(boolean paramBoolean);

  public abstract void shareYoRide();

  public abstract void unregisterPushToken(String paramString1, String paramString2, String paramString3, DispatchCallback<Ping> paramDispatchCallback);

  public abstract void updateMobileNumber(String paramString1, String paramString2);

  public abstract void updatePaymentProfile(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7);

  public abstract void updateRewardData(String paramString, Boolean paramBoolean1, Boolean paramBoolean2);

  public abstract void validatePromo(String paramString, boolean paramBoolean);
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.network.RiderClient
 * JD-Core Version:    0.6.2
 */