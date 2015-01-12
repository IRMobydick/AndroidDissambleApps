package com.ubercab.client.core.network;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.inauth.mme.InAuthManager;
import com.mobileapptracker.MobileAppTracker;
import com.squareup.otto.Bus;
import com.ubercab.client.core.app.RiderPreferences;
import com.ubercab.client.core.content.PingProvider;
import com.ubercab.client.core.content.RiderLocationProvider;
import com.ubercab.client.core.content.SessionPreferences;
import com.ubercab.client.core.location.RiderLocation;
import com.ubercab.client.core.model.AppConfig;
import com.ubercab.client.core.model.City;
import com.ubercab.client.core.model.Client;
import com.ubercab.client.core.model.CnLocation;
import com.ubercab.client.core.model.DropNotification;
import com.ubercab.client.core.model.Experiment;
import com.ubercab.client.core.model.FavoriteLocationDistanceConstraints;
import com.ubercab.client.core.model.LegacyMobileMessage;
import com.ubercab.client.core.model.MobileMessage;
import com.ubercab.client.core.model.MobileMessageDisplayProperties;
import com.ubercab.client.core.model.MobileMessageModule;
import com.ubercab.client.core.model.Ping;
import com.ubercab.client.core.model.RiderAppConfig;
import com.ubercab.client.core.model.Surge;
import com.ubercab.client.core.model.ThirdPartyIdentity;
import com.ubercab.client.core.model.TripExpenseInfo;
import com.ubercab.client.core.model.VehicleView;
import com.ubercab.client.core.network.events.AddExpenseInfoResponseEvent;
import com.ubercab.client.core.network.events.ApplyPromoResponseEvent;
import com.ubercab.client.core.network.events.ClientUpdateResponseEvent;
import com.ubercab.client.core.network.events.ConfirmMobileResponseEvent;
import com.ubercab.client.core.network.events.CreatePaymentProfileResponseEvent;
import com.ubercab.client.core.network.events.DeletePaymentProfileResponseEvent;
import com.ubercab.client.core.network.events.EmployeeUpgradeResponseEvent;
import com.ubercab.client.core.network.events.FareSplitAcceptResponseEvent;
import com.ubercab.client.core.network.events.FareSplitDeclineResponseEvent;
import com.ubercab.client.core.network.events.FareSplitInviteResponseEvent;
import com.ubercab.client.core.network.events.FareSplitUnInviteResponseEvent;
import com.ubercab.client.core.network.events.LoginGoogleResponseEvent;
import com.ubercab.client.core.network.events.LoginResponseEvent;
import com.ubercab.client.core.network.events.PayBillResponseEvent;
import com.ubercab.client.core.network.events.PickupCancelClientResponseEvent;
import com.ubercab.client.core.network.events.PickupResponseEvent;
import com.ubercab.client.core.network.events.PingClientResponseEvent;
import com.ubercab.client.core.network.events.PingLocationsResponseEvent;
import com.ubercab.client.core.network.events.RatingDriverResponseEvent;
import com.ubercab.client.core.network.events.RequestMobileConfirmationResponseEvent;
import com.ubercab.client.core.network.events.RewardsEnrollmentUpdateResponseEvent;
import com.ubercab.client.core.network.events.ScheduleSurgeDropNotificationResponseEvent;
import com.ubercab.client.core.network.events.SelectPaymentProfileResponseEvent;
import com.ubercab.client.core.network.events.SetDestinationResponseEvent;
import com.ubercab.client.core.network.events.SetUseCreditsResponseEvent;
import com.ubercab.client.core.network.events.ShareYoRideResponseEvent;
import com.ubercab.client.core.network.events.ThirdPartyAuthResponseEvent;
import com.ubercab.client.core.network.events.ThirdPartyDeleteResponseEvent;
import com.ubercab.client.core.network.events.UpdatePaymentProfileResponseEvent;
import com.ubercab.client.core.network.events.ValidatePromoResponseEvent;
import com.ubercab.client.core.util.NumberUtils;
import com.ubercab.client.core.util.PingUtils;
import com.ubercab.client.feature.mobilemessage.MobileMessageManager;
import com.ubercab.client.feature.payment.expense.ExpenseLink;
import com.ubercab.common.collect.ImmutableMap;
import com.ubercab.common.io.IOUtils;
import com.ubercab.library.app.UberPreferences;
import com.ubercab.library.location.model.UberLatLng;
import com.ubercab.library.location.model.UberLocation;
import com.ubercab.library.network.dispatch.DispatchCallback;
import com.ubercab.library.network.dispatch.DispatchClient;
import com.ubercab.library.network.dispatch.DispatchParameterInterceptor;
import com.ubercab.library.network.dispatch.DispatchRequest;
import com.ubercab.library.network.dispatch.DispatchRequest.Builder;
import com.ubercab.library.network.dispatch.model.DispatchResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;
import retrofit.RetrofitError;
import retrofit.client.Response;
import timber.log.Timber;

public class RiderClientImpl
  implements RiderClient, DispatchCallback, DispatchParameterInterceptor
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
  public static final String MESSAGE_TYPE_PAYMENT_REWARD_UPDATE = "PaymentRewardUpdate";
  public static final String MESSAGE_TYPE_PICKUP = "Pickup";
  public static final String MESSAGE_TYPE_PICKUP_CANCELED_CLIENT = "PickupCanceledClient";
  public static final String MESSAGE_TYPE_PING_CLIENT = "PingClient";
  public static final String MESSAGE_TYPE_RATE_DRIVER = "RatingDriver";
  public static final String MESSAGE_TYPE_REGISTER_PUSH_TOKEN = "RegisterPushToken";
  public static final String MESSAGE_TYPE_SELECT_PAYMENT_PROFILE = "SelectPaymentProfile";
  public static final String MESSAGE_TYPE_SET_DESTINATION = "SetDestination";
  public static final String MESSAGE_TYPE_SET_USE_CREDITS = "SetUseCredits";
  public static final String MESSAGE_TYPE_SHARE_YO_RIDE = "ShareYoRide";
  public static final String MESSAGE_TYPE_THIRD_PARTY_AUTH = "AuthenticateThirdParty";
  public static final String MESSAGE_TYPE_UNREGISTER_PUSH_TOKEN = "UnregisterPushToken";
  private static final String PARAM_ALIPAY_ID = "alipay_id";
  private static final String PARAM_ALIPAY_MOBILE = "alipay_mobile";
  private static final String PARAM_ALTITUDE = "altitude";
  private static final String PARAM_AMEX_REWARD = "amex_reward";
  private static final String PARAM_API_APP_NAME = "appName";
  private static final String PARAM_API_BILLING_COUNTRY_ISO2 = "billing_country_iso2";
  private static final String PARAM_API_BILLING_ZIP = "billing_zip";
  private static final String PARAM_API_CARD_CODE = "card_code";
  private static final String PARAM_API_CARD_EXPIRATION_MONTH = "card_expiration_month";
  private static final String PARAM_API_CARD_EXPIRATION_YEAR = "card_expiration_year";
  private static final String PARAM_API_CARD_NUMBER = "card_number";
  private static final String PARAM_API_CODE = "code";
  private static final String PARAM_API_CONFIRMED = "confirmed";
  private static final String PARAM_API_DEVICE = "device";
  private static final String PARAM_API_IS_CARD_IO = "cardio";
  private static final String PARAM_API_IS_GOOGLE_WALLET = "is_google_wallet";
  private static final String PARAM_API_MOBILE_TOKEN = "mobile_token";
  private static final String PARAM_API_PAYMENT_PROFILE_ID = "payment_profile_id";
  private static final String PARAM_API_PROMOTION_CODE = "promotion_code";
  private static final String PARAM_API_THIRD_PARTY_IDENTITIES = "/third_party_identities";
  private static final String PARAM_API_TOKEN_DATA = "token_data";
  private static final String PARAM_API_TOKEN_TYPE = "token_type";
  private static final String PARAM_API_TOKEN_TYPE_ALIPAY = "alipay";
  private static final String PARAM_API_TOKEN_TYPE_PAYPAL = "paypal";
  private static final String PARAM_API_TOKEN_TYPE_PAYTM = "paytm";
  private static final String PARAM_API_URL_CLIENTS = "/clients/%s";
  private static final String PARAM_API_URL_CLIENTS_BILLS = "/client_bills";
  private static final String PARAM_API_URL_CLIENTS_PROMOTIONS = "/clients_promotions";
  private static final String PARAM_API_URL_CONFIRM_MOBILE = "/clients/%s/confirm_mobile";
  private static final String PARAM_API_URL_LOOKUP_UPGRADE = "/upgrades/lookup_upgrade";
  private static final String PARAM_API_URL_PAYMENT_PROFILES = "/payment_profiles";
  private static final String PARAM_API_URL_REQUEST_MOBILE_CONFIRMATION = "/clients/%s/request_mobile_confirmation";
  private static final String PARAM_API_USE_CASE = "use_case";
  private static final String PARAM_API_VALIDATE_PROMOTION = "/validate/promotion";
  private static final String PARAM_AUTH_ID = "authId";
  private static final String PARAM_CACHED_MOBILE_MESSAGES = "cachedMessages";
  private static final String PARAM_CERTIFICATE = "certificate";
  private static final String PARAM_CERTIFICATE_ENTERPRISE = "enterprise";
  private static final String PARAM_COURSE = "course";
  private static final String PARAM_DESTINATION = "destination";
  private static final String PARAM_DEVICE_IDS = "deviceIds";
  public static final String PARAM_DEVICE_TOKEN = "deviceToken";
  public static final String PARAM_DEVICE_TOKEN_TYPE = "deviceTokenType";
  private static final String PARAM_EMAIL = "email";
  private static final String PARAM_EXPENSE_CODE = "code";
  private static final String PARAM_EXPENSE_INFO = "expenseInfo";
  private static final String PARAM_EXPENSE_MEMO = "memo";
  private static final String PARAM_EXTRA_PAYMENT_DATA = "extraPaymentData";
  private static final String PARAM_FARE_ID = "fareId";
  private static final String PARAM_FEEDBACK = "feedback";
  private static final String PARAM_FEEDBACK_ID = "feedbackId";
  private static final String PARAM_GOOGLE_ADVERTISING_ID = "googleAdvertisingId";
  private static final String PARAM_GOOGLE_OAUTH_TOKEN = "googleOauthToken";
  private static final String PARAM_GOOGLE_OAUTH_TOKEN_TYPE = "googleOauthTokenType";
  private static final String PARAM_GOOGLE_OAUTH_TOKEN_TYPE_JWT = "jwt";
  private static final String PARAM_HORIZONTAL_ACCURACY = "horizontalAccuracy";
  private static final String PARAM_INVITEE = "invitee";
  private static final String PARAM_INVITEES = "invitees";
  private static final String PARAM_IS_GOOGLE_WALLET_REQUEST = "isGoogleWalletRequest";
  private static final String PARAM_LATITUDE = "latitude";
  private static final String PARAM_LONGITUDE = "longitude";
  private static final String PARAM_MOBILE = "mobile";
  private static final String PARAM_MOBILE_COUNTRY_ISO2 = "mobileCountryIso2";
  private static final String PARAM_NOTIFICATION_NAME = "notificationName";
  private static final String PARAM_NOTIFICATION_NAME_SURGE_DROP = "SurgeDrop";
  private static final String PARAM_PASSWORD = "password";
  private static final String PARAM_PAYMENT_PROFILE_ID = "paymentProfileId";
  private static final String PARAM_PAYMENT_REWARD_DATA = "rewardData";
  private static final String PARAM_PAYMENT_REWARD_DATA_ENABLE = "enable";
  private static final String PARAM_PAYMENT_REWARD_DATA_ENROLL = "enroll";
  private static final String PARAM_PAYMENT_REWARD_DATA_TYPE = "type";
  private static final String PARAM_PAYPAL_CORRELATION_ID = "payPalCorrelationId";
  private static final String PARAM_PAYPAL_CORRELATION_ID_API = "paypal_correlation_id";
  private static final String PARAM_PAYTM_EMAIL = "paytm_email";
  private static final String PARAM_PAYTM_MOBILE = "paytm_mobile";
  private static final String PARAM_PERFORM_FARE_ESTIMATE = "performFareEstimate";
  private static final String PARAM_PICKUP_LOCATION = "pickupLocation";
  private static final String PARAM_QUERY = "query";
  private static final String PARAM_RATING = "rating";
  private static final String PARAM_SEARCH_TYPES = "searchTypes";
  private static final String PARAM_SEND_EXPENSE = "expenseTrip";
  private static final String PARAM_SPEED = "speed";
  private static final String PARAM_THIRD_PARTY_ACCESS_TOKEN_CODE = "access_token_code";
  private static final String PARAM_THIRD_PARTY_CREDENTIALS = "credentials";
  private static final String PARAM_THIRD_PARTY_IDENTITY_TYPE = "identity_type";
  private static final String PARAM_THIRD_PARTY_TOKEN = "accessToken";
  private static final String PARAM_THIRD_PARTY_TYPE = "type";
  private static final String PARAM_TOKEN_DATA = "token_data";
  private static final String PARAM_TOKEN_TYPE = "token_type";
  private static final String PARAM_TRIP_ID = "tripId";
  private static final String PARAM_USER_LOCATION = "userLocation";
  private static final String PARAM_USE_AMEX_REWARD = "useAmexReward";
  private static final String PARAM_USE_CREDITS = "useCredits";
  private static final String PARAM_VEHICLE_VIEW_ID = "vehicleViewId";
  private Bus mBus;
  private Context mContext;
  private DispatchClient mDispatchClient;
  private InAuthManager mInAuthManager;
  private RiderLocationProvider mLocationProvider;
  private MobileAppTracker mMobileAppTracker;
  private MobileMessageManager mMobileMessageManager;
  private PingProvider mPingProvider;
  private RiderPreferences mRiderPreferences;
  private SessionPreferences mSessionPreferences;
  private UberPreferences mUberPreferences;

  public RiderClientImpl(Bus paramBus, Context paramContext, DispatchClient paramDispatchClient, PingProvider paramPingProvider, RiderLocationProvider paramRiderLocationProvider, RiderPreferences paramRiderPreferences, UberPreferences paramUberPreferences, SessionPreferences paramSessionPreferences, MobileAppTracker paramMobileAppTracker, MobileMessageManager paramMobileMessageManager, InAuthManager paramInAuthManager)
  {
    this.mBus = paramBus;
    this.mContext = paramContext;
    this.mDispatchClient = paramDispatchClient;
    this.mMobileAppTracker = paramMobileAppTracker;
    this.mSessionPreferences = paramSessionPreferences;
    this.mPingProvider = paramPingProvider;
    this.mRiderPreferences = paramRiderPreferences;
    this.mUberPreferences = paramUberPreferences;
    this.mLocationProvider = paramRiderLocationProvider;
    this.mMobileMessageManager = paramMobileMessageManager;
    this.mInAuthManager = paramInAuthManager;
    this.mDispatchClient.addParameterInterceptor(this);
    this.mDispatchClient.addCallback(this);
  }

  private void addFakeMessage(List<MobileMessage> paramList, String paramString, int paramInt1, int paramInt2)
  {
    try
    {
      addFakeMessage(paramList, paramString, IOUtils.toString(this.mContext.getResources().openRawResource(paramInt1)), IOUtils.toString(this.mContext.getResources().openRawResource(paramInt2)));
      return;
    }
    catch (IOException localIOException)
    {
    }
  }

  private void addFakeMessage(List<MobileMessage> paramList, String paramString1, String paramString2, String paramString3)
  {
    MobileMessage localMobileMessage = new MobileMessage();
    String str = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
    localMobileMessage.setId(paramString1 + str);
    localMobileMessage.setETag(str);
    MobileMessageDisplayProperties localMobileMessageDisplayProperties = new MobileMessageDisplayProperties();
    localMobileMessageDisplayProperties.setShowAsModalOverRequestView(true);
    localMobileMessage.setDisplayProps(localMobileMessageDisplayProperties);
    MobileMessageModule localMobileMessageModule1 = new MobileMessageModule();
    localMobileMessageModule1.addHtmlPage(paramString2);
    localMobileMessage.addModule(localMobileMessageModule1);
    MobileMessageModule localMobileMessageModule2 = new MobileMessageModule();
    localMobileMessageModule2.addHtmlPage(paramString3);
    localMobileMessage.addModule(localMobileMessageModule2);
    paramList.add(localMobileMessage);
  }

  private String createAlipayToken(String paramString1, String paramString2)
  {
    return new JSONObject(ImmutableMap.of("alipay_id", paramString1, "alipay_mobile", paramString2)).toString();
  }

  private static ImmutableMap<String, ?> createExtraPaymentDataWithPayPalCorrelationId(String paramString1, String paramString2)
  {
    return ImmutableMap.of("paymentProfileId", paramString1, "payPalCorrelationId", paramString2);
  }

  private String createPaytmToken(String paramString1, String paramString2)
  {
    return new JSONObject(ImmutableMap.of("paytm_email", paramString1, "paytm_mobile", paramString2)).toString();
  }

  private FavoriteLocationDistanceConstraints getFakeFavoriteLocationConstraints()
  {
    if (!this.mRiderPreferences.hasFakeFavoriteLocationDistanceConstraints())
      return null;
    FavoriteLocationDistanceConstraints localFavoriteLocationDistanceConstraints = new FavoriteLocationDistanceConstraints();
    localFavoriteLocationDistanceConstraints.setMaximumDropoffDistanceInMeters(120701);
    localFavoriteLocationDistanceConstraints.setMinimumDropoffDistanceInMeters(402);
    localFavoriteLocationDistanceConstraints.setMaximumPickupDistanceInMeters(8046);
    return localFavoriteLocationDistanceConstraints;
  }

  private void injectEmployeePingData(Ping paramPing)
  {
    injectFakeExperiments(paramPing);
    injectFakeAppConfig(paramPing);
    injectFakeSurgeData(paramPing);
    injectFakeExpenseData(paramPing);
    injectFakeVehicleConfig(paramPing);
    injectFakeLegacyMobileMessageData(paramPing);
    injectFakeMobileMessages(paramPing);
    injectFakeTripBalance(paramPing);
  }

  private void injectFakeAppConfig(Ping paramPing)
  {
    if (paramPing == null);
    AppConfig localAppConfig;
    do
    {
      return;
      localAppConfig = paramPing.getAppConfig();
    }
    while (localAppConfig == null);
    if (this.mUberPreferences.hasFakeCnFailoverStrategy())
      localAppConfig.setFailoverStrategy(this.mUberPreferences.getFakeCnFailoverStrategy());
    RiderAppConfig localRiderAppConfig = paramPing.getAppConfig().getRiderConfig();
    if (localRiderAppConfig == null)
    {
      localRiderAppConfig = new RiderAppConfig();
      paramPing.getAppConfig().setRiderConfig(localRiderAppConfig);
    }
    if ((localRiderAppConfig.isPayTmEnabled()) || (this.mRiderPreferences.isPayTmEnabled()));
    for (boolean bool = true; ; bool = false)
    {
      localRiderAppConfig.setPayTmEnabled(bool);
      localRiderAppConfig.setNewConfirmationEnabled(localRiderAppConfig.isNewConfirmationEnabled());
      if (!TextUtils.isEmpty(this.mRiderPreferences.getFakeFareEstimateFlowVariant()))
        localRiderAppConfig.setFareEstimateFlowVariant(this.mRiderPreferences.getFakeFareEstimateFlowVariant());
      String str = this.mRiderPreferences.getKeySliderStyle();
      if (!TextUtils.isEmpty(str))
      {
        Timber.d("Overriding slider style from [%s] to [%s]", new Object[] { localRiderAppConfig.getSliderStyle(), str });
        localRiderAppConfig.setSliderStyle(str);
      }
      if (this.mRiderPreferences.hasFlagLocationSearch())
        localRiderAppConfig.setLocationSearch(this.mRiderPreferences.getFlagLocationSearch());
      if (localRiderAppConfig.getFavoriteLocationDistanceConstraints() != null)
        break;
      localRiderAppConfig.setFavoriteLocationDistanceConstraints(getFakeFavoriteLocationConstraints());
      return;
    }
  }

  private void injectFakeExpenseData(Ping paramPing)
  {
    if (paramPing == null);
    do
    {
      return;
      if (this.mRiderPreferences.hasFakeExpenseService())
      {
        Map localMap = paramPing.getClient().getThirdPartyIdentities();
        localMap.clear();
        localMap.put(ExpenseLink.CONCUR.getTypeName(), new ThirdPartyIdentity());
      }
    }
    while (!this.mRiderPreferences.hasFakeLastExpenseInfo());
    TripExpenseInfo localTripExpenseInfo = paramPing.getClient().getLastExpenseInfo();
    localTripExpenseInfo.setExpenseTrip(true);
    localTripExpenseInfo.setMemo("EMPLOYEE TEST MEMO");
    localTripExpenseInfo.setCode("EMPLOYEE_TEST_CODE123");
  }

  private void injectFakeExperiments(Ping paramPing)
  {
    if (this.mRiderPreferences.isDestinationEmphasisEnabled())
    {
      Experiment localExperiment = new Experiment();
      localExperiment.setGroupSerial(1);
      paramPing.getClient().getActiveExperiments().put("destination_not_set_highlight", localExperiment);
    }
  }

  private void injectFakeLegacyMobileMessageData(Ping paramPing)
  {
    if ((!PingUtils.hasCity(paramPing)) || (!this.mRiderPreferences.hasFakeLegacyMobileMessage()))
      return;
    paramPing.getCity().setEvent(LegacyMobileMessage.createFakeLegacyMobileMessage(this.mContext));
  }

  private void injectFakeMobileMessages(Ping paramPing)
  {
    if ((!PingUtils.hasCity(paramPing)) || (!this.mRiderPreferences.hasFakeMobileMessage()))
      return;
    City localCity = paramPing.getCity();
    ArrayList localArrayList = new ArrayList();
    int i = this.mContext.getResources().getIdentifier("mobile_message_header_test", "raw", this.mContext.getPackageName());
    int j = this.mContext.getResources().getIdentifier("mobile_message_body_test", "raw", this.mContext.getPackageName());
    if ((i > 0) && (j > 0))
      addFakeMessage(localArrayList, "test1_", i, j);
    localCity.setMessages(localArrayList);
  }

  private void injectFakeSurgeData(Ping paramPing)
  {
    if (!PingUtils.hasVehicleViews(paramPing));
    while (true)
    {
      return;
      Iterator localIterator = paramPing.getCity().getVehicleViews().keySet().iterator();
      while (localIterator.hasNext())
      {
        String str1 = (String)localIterator.next();
        if (this.mRiderPreferences.hasSurgeFake(str1))
        {
          VehicleView localVehicleView = (VehicleView)paramPing.getCity().getVehicleViews().get(str1);
          Surge localSurge = localVehicleView.getSurge();
          if (localSurge.getMultiplier() == 1.0F)
          {
            localSurge.setMultiplier(1.75F);
            localSurge.setExpirationTime(120L);
            localSurge.setFareId(12345L);
            localSurge.setSpeedThresholdMps(5.0F);
            localSurge.setPerMinute("$1.23");
            localSurge.setBase("$12");
            localSurge.setPerDistanceUnit("4.56");
            localSurge.setDistanceUnit("mile");
            localSurge.setMinimum("$23.45");
            localSurge.setShowRates(true);
            if (localSurge.getDropNotification() == null)
              localSurge.setDropNotification(new DropNotification());
            localSurge.getDropNotification().setEnabled(true);
            localSurge.getDropNotification().setDefaultExpirationTime(1800.0D);
            String str2 = this.mRiderPreferences.getFakeSurgeScreenType();
            localVehicleView.getSurge().setScreenType(str2);
          }
        }
      }
    }
  }

  private void injectFakeTripBalance(Ping paramPing)
  {
  }

  private void injectFakeVehicleConfig(Ping paramPing)
  {
    if (this.mRiderPreferences.hasDestinationEntry())
    {
      Iterator localIterator = paramPing.getCity().getVehicleViews().keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        ((VehicleView)paramPing.getCity().getVehicleViews().get(str)).setDestinationEntry(this.mRiderPreferences.getDestinationEntry());
      }
    }
  }

  public void addExpenseInfo(TripExpenseInfo paramTripExpenseInfo)
  {
    String str = ensureToken();
    DispatchCallbackBusAdapter localDispatchCallbackBusAdapter = new DispatchCallbackBusAdapter(this.mBus, AddExpenseInfoResponseEvent.class);
    DispatchRequest localDispatchRequest = new DispatchRequest.Builder().setMode(1).setMessageType("AddExpenseInfo").setExpectsPingResults().setCallback(localDispatchCallbackBusAdapter).setParameter("expenseTrip", Boolean.valueOf(paramTripExpenseInfo.isExpenseTrip())).setParameter("code", paramTripExpenseInfo.getCode()).setParameter("memo", paramTripExpenseInfo.getMemo()).setParameter("token", str).build();
    this.mDispatchClient.execute(localDispatchRequest);
  }

  public void applyPromo(String paramString, boolean paramBoolean)
  {
    String str = ensureToken();
    DispatchCallbackBusAdapter localDispatchCallbackBusAdapter = new DispatchCallbackBusAdapter(this.mBus, ApplyPromoResponseEvent.class);
    ImmutableMap localImmutableMap = ImmutableMap.of("token", str, "code", paramString, "confirmed", Boolean.valueOf(paramBoolean));
    DispatchRequest localDispatchRequest = new DispatchRequest.Builder().setMode(1).setMessageType("ApiCommand").setExpectsPingResults().setParameter("token", str).setParameter("apiUrl", "/clients_promotions").setParameter("apiMethod", "POST").setParameter("apiParameters", localImmutableMap).setCallback(localDispatchCallbackBusAdapter).build();
    this.mDispatchClient.execute(localDispatchRequest);
  }

  public void authenticateWithThirdParty(String paramString1, String paramString2)
  {
    DispatchCallbackBusAdapter localDispatchCallbackBusAdapter = new DispatchCallbackBusAdapter(this.mBus, ThirdPartyAuthResponseEvent.class);
    ImmutableMap localImmutableMap = ImmutableMap.of("type", paramString1, "accessToken", paramString2);
    DispatchRequest localDispatchRequest = new DispatchRequest.Builder().setMode(1).setMessageType("AuthenticateThirdParty").setExpectsPingResults().setCallback(localDispatchCallbackBusAdapter).setParameter("credentials", localImmutableMap).build();
    this.mDispatchClient.execute(localDispatchRequest);
  }

  public void checkForEmployeeUpgrade()
  {
    String str = ensureToken();
    ImmutableMap localImmutableMap = ImmutableMap.of("appName", "rider", "device", "android");
    DispatchCallbackBusAdapter localDispatchCallbackBusAdapter = new DispatchCallbackBusAdapter(this.mBus, EmployeeUpgradeResponseEvent.class);
    DispatchRequest localDispatchRequest = new DispatchRequest.Builder().setMode(1).setMessageType("ApiCommand").setParameter("token", str).setParameter("apiMethod", "GET").setParameter("apiUrl", "/upgrades/lookup_upgrade").setParameter("apiParameters", localImmutableMap).setCallback(localDispatchCallbackBusAdapter).build();
    this.mDispatchClient.execute(localDispatchRequest);
  }

  public void confirmMobile(String paramString)
  {
    String str1 = ensureToken();
    DispatchCallbackBusAdapter localDispatchCallbackBusAdapter = new DispatchCallbackBusAdapter(this.mBus, ConfirmMobileResponseEvent.class);
    ImmutableMap localImmutableMap = ImmutableMap.of("token", str1, "mobile_token", paramString);
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = this.mSessionPreferences.getUserUuid();
    String str2 = String.format("/clients/%s/confirm_mobile", arrayOfObject);
    DispatchRequest localDispatchRequest = new DispatchRequest.Builder().setMode(1).setMessageType("ApiCommand").setExpectsPingResults().setParameter("token", str1).setParameter("apiMethod", "PUT").setParameter("apiUrl", str2).setParameter("apiParameters", localImmutableMap).setCallback(localDispatchCallbackBusAdapter).build();
    this.mDispatchClient.execute(localDispatchRequest);
  }

  public void createPaymentProfile(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, boolean paramBoolean1, boolean paramBoolean2)
  {
    String str = ensureToken();
    DispatchCallbackBusAdapter localDispatchCallbackBusAdapter = new DispatchCallbackBusAdapter(this.mBus, CreatePaymentProfileResponseEvent.class);
    HashMap localHashMap = new HashMap();
    localHashMap.put("token", str);
    localHashMap.put("card_code", paramString4);
    localHashMap.put("use_case", paramString7);
    localHashMap.put("card_number", paramString1);
    localHashMap.put("billing_zip", paramString6);
    localHashMap.put("card_expiration_year", paramString3);
    localHashMap.put("card_expiration_month", paramString2);
    localHashMap.put("billing_country_iso2", paramString5.toUpperCase(Locale.US));
    localHashMap.put("is_google_wallet", Boolean.valueOf(paramBoolean1));
    localHashMap.put("cardio", Boolean.valueOf(paramBoolean2));
    DispatchRequest localDispatchRequest = new DispatchRequest.Builder().setMode(1).setMessageType("ApiCommand").setExpectsPingResults().setCallback(localDispatchCallbackBusAdapter).setParameter("token", str).setParameter("apiMethod", "POST").setParameter("apiUrl", "/payment_profiles").setParameter("apiParameters", localHashMap).build();
    this.mDispatchClient.execute(localDispatchRequest);
  }

  public void createPaymentProfileAlipay(String paramString1, String paramString2)
  {
    String str = ensureToken();
    DispatchCallbackBusAdapter localDispatchCallbackBusAdapter = new DispatchCallbackBusAdapter(this.mBus, CreatePaymentProfileResponseEvent.class);
    HashMap localHashMap = new HashMap();
    localHashMap.put("token", str);
    localHashMap.put("token_type", "alipay");
    localHashMap.put("token_data", createAlipayToken(paramString1, paramString2));
    DispatchRequest localDispatchRequest = new DispatchRequest.Builder().setMode(1).setMessageType("ApiCommand").setExpectsPingResults().setCallback(localDispatchCallbackBusAdapter).setParameter("token", str).setParameter("apiMethod", "POST").setParameter("apiUrl", "/payment_profiles").setParameter("apiParameters", localHashMap).build();
    this.mDispatchClient.execute(localDispatchRequest);
  }

  public void createPaymentProfilePayPal(String paramString1, String paramString2)
  {
    String str = ensureToken();
    DispatchCallbackBusAdapter localDispatchCallbackBusAdapter = new DispatchCallbackBusAdapter(this.mBus, CreatePaymentProfileResponseEvent.class);
    HashMap localHashMap = new HashMap();
    localHashMap.put("token", str);
    localHashMap.put("token_type", "paypal");
    localHashMap.put("token_data", paramString1);
    localHashMap.put("paypal_correlation_id", paramString2);
    DispatchRequest localDispatchRequest = new DispatchRequest.Builder().setMode(1).setMessageType("ApiCommand").setExpectsPingResults().setCallback(localDispatchCallbackBusAdapter).setParameter("token", str).setParameter("apiMethod", "POST").setParameter("apiUrl", "/payment_profiles").setParameter("apiParameters", localHashMap).build();
    this.mDispatchClient.execute(localDispatchRequest);
  }

  public void createPaymentProfilePayTm(String paramString1, String paramString2)
  {
    String str = ensureToken();
    DispatchCallbackBusAdapter localDispatchCallbackBusAdapter = new DispatchCallbackBusAdapter(this.mBus, CreatePaymentProfileResponseEvent.class);
    HashMap localHashMap = new HashMap();
    localHashMap.put("token", str);
    localHashMap.put("token_type", "paytm");
    localHashMap.put("token_data", createPaytmToken(paramString1, paramString2));
    DispatchRequest localDispatchRequest = new DispatchRequest.Builder().setMode(1).setMessageType("ApiCommand").setExpectsPingResults().setCallback(localDispatchCallbackBusAdapter).setParameter("token", str).setParameter("apiMethod", "POST").setParameter("apiUrl", "/payment_profiles").setParameter("apiParameters", localHashMap).build();
    this.mDispatchClient.execute(localDispatchRequest);
  }

  public void createThirdPartyIdentity(String paramString1, String paramString2)
  {
    String str = ensureToken();
    ImmutableMap localImmutableMap = ImmutableMap.of("token", str, "identity_type", paramString1, "access_token_code", paramString2);
    DispatchRequest localDispatchRequest = new DispatchRequest.Builder().setMode(1).setMessageType("ApiCommand").setExpectsPingResults().setParameter("apiMethod", "POST").setParameter("apiUrl", "/third_party_identities").setParameter("token", str).setParameter("apiParameters", localImmutableMap).setCallback(new DispatchCallbackBusAdapter(this.mBus, ThirdPartyAuthResponseEvent.class)).build();
    this.mDispatchClient.execute(localDispatchRequest);
  }

  public void deletePaymentProfile(String paramString)
  {
    String str = ensureToken();
    DispatchCallbackBusAdapter localDispatchCallbackBusAdapter = new DispatchCallbackBusAdapter(this.mBus, DeletePaymentProfileResponseEvent.class);
    HashMap localHashMap = new HashMap();
    localHashMap.put("token", str);
    DispatchRequest localDispatchRequest = new DispatchRequest.Builder().setMode(1).setMessageType("ApiCommand").setExpectsPingResults().setCallback(localDispatchCallbackBusAdapter).setParameter("token", str).setParameter("apiUrl", "/payment_profiles/" + paramString).setParameter("apiMethod", "DELETE").setParameter("apiParameters", localHashMap).build();
    this.mDispatchClient.execute(localDispatchRequest);
  }

  public void deleteThirdPartyIdentity(String paramString)
  {
    String str = ensureToken();
    ImmutableMap localImmutableMap = ImmutableMap.of("token", str);
    DispatchRequest localDispatchRequest = new DispatchRequest.Builder().setMode(1).setMessageType("ApiCommand").setExpectsPingResults().setParameter("apiMethod", "DELETE").setParameter("apiUrl", "/third_party_identities/" + paramString).setParameter("token", str).setParameter("apiParameters", localImmutableMap).setCallback(new DispatchCallbackBusAdapter(this.mBus, ThirdPartyDeleteResponseEvent.class)).build();
    this.mDispatchClient.execute(localDispatchRequest);
  }

  public String ensureToken()
  {
    String str = this.mSessionPreferences.getToken();
    if (TextUtils.isEmpty(str))
      throw new IllegalStateException("Token is required");
    return str;
  }

  public void fareSplitAccept(String paramString1, String paramString2)
  {
    String str = ensureToken();
    DispatchCallbackBusAdapter localDispatchCallbackBusAdapter = new DispatchCallbackBusAdapter(this.mBus, FareSplitAcceptResponseEvent.class);
    DispatchRequest.Builder localBuilder = new DispatchRequest.Builder().setMode(1).setMessageType("FareSplitAccept").setExpectsPingResults().setCallback(localDispatchCallbackBusAdapter).setParameter("token", str).setParameter("useCredits", Boolean.valueOf(true));
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
      localBuilder.setParameter("extraPaymentData", createExtraPaymentDataWithPayPalCorrelationId(paramString1, paramString2));
    this.mDispatchClient.execute(localBuilder.build());
  }

  public void fareSplitDecline()
  {
    String str = ensureToken();
    DispatchCallbackBusAdapter localDispatchCallbackBusAdapter = new DispatchCallbackBusAdapter(this.mBus, FareSplitDeclineResponseEvent.class);
    DispatchRequest localDispatchRequest = new DispatchRequest.Builder().setMode(1).setMessageType("FareSplitDecline").setExpectsPingResults().setCallback(localDispatchCallbackBusAdapter).setParameter("token", str).build();
    this.mDispatchClient.execute(localDispatchRequest);
  }

  public void fareSplitInvite(List<String> paramList)
  {
    String str = ensureToken();
    DispatchCallbackBusAdapter localDispatchCallbackBusAdapter = new DispatchCallbackBusAdapter(this.mBus, FareSplitInviteResponseEvent.class);
    DispatchRequest localDispatchRequest = new DispatchRequest.Builder().setMode(1).setMessageType("FareSplitInvite").setExpectsPingResults().setCallback(localDispatchCallbackBusAdapter).setParameter("token", str).setParameter("invitees", paramList).build();
    this.mDispatchClient.execute(localDispatchRequest);
  }

  public void fareSplitUninvite(String paramString)
  {
    String str = ensureToken();
    DispatchCallbackBusAdapter localDispatchCallbackBusAdapter = new DispatchCallbackBusAdapter(this.mBus, FareSplitUnInviteResponseEvent.class);
    DispatchRequest localDispatchRequest = new DispatchRequest.Builder().setMode(1).setMessageType("FareSplitUninvite").setExpectsPingResults().setCallback(localDispatchCallbackBusAdapter).setParameter("token", str).setParameter("invitee", paramString).build();
    this.mDispatchClient.execute(localDispatchRequest);
  }

  public void locationSearch(String paramString, String[] paramArrayOfString)
  {
    String str = ensureToken();
    DispatchCallbackBusAdapter localDispatchCallbackBusAdapter = new DispatchCallbackBusAdapter(this.mBus, PingLocationsResponseEvent.class);
    DispatchRequest.Builder localBuilder = new DispatchRequest.Builder().setMessageType("LocationSearch").setMode(0).setCallback(localDispatchCallbackBusAdapter).setParameter("token", str).setParameter("searchTypes", paramArrayOfString);
    if (!TextUtils.isEmpty(paramString))
      localBuilder.setParameter("query", paramString);
    this.mDispatchClient.execute(localBuilder.build());
  }

  public void login(String paramString1, String paramString2)
  {
    DispatchCallbackBusAdapter localDispatchCallbackBusAdapter = new DispatchCallbackBusAdapter(this.mBus, LoginResponseEvent.class);
    DispatchRequest localDispatchRequest = new DispatchRequest.Builder().setMode(1).setMessageType("Login").setExpectsPingResults().setCallback(localDispatchCallbackBusAdapter).setParameter("email", paramString1).setParameter("password", paramString2).build();
    this.mDispatchClient.execute(localDispatchRequest);
  }

  public void loginGoogle(String paramString1, String paramString2)
  {
    DispatchCallbackBusAdapter localDispatchCallbackBusAdapter = new DispatchCallbackBusAdapter(this.mBus, LoginGoogleResponseEvent.class);
    DispatchRequest localDispatchRequest = new DispatchRequest.Builder().setMode(1).setMessageType("Login").setExpectsPingResults().setCallback(localDispatchCallbackBusAdapter).setParameter("email", paramString1).setParameter("googleOauthToken", paramString2).setParameter("googleOauthTokenType", "jwt").build();
    this.mDispatchClient.execute(localDispatchRequest);
  }

  public void manualRefresh()
  {
    String str = ensureToken();
    ImmutableMap localImmutableMap = ImmutableMap.of("token", str);
    DispatchCallbackBusAdapter localDispatchCallbackBusAdapter = new DispatchCallbackBusAdapter(this.mBus, ClientUpdateResponseEvent.class);
    DispatchRequest.Builder localBuilder = new DispatchRequest.Builder().setMode(1).setMessageType("ApiCommand").setExpectsPingResults().setParameter("token", str);
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = this.mSessionPreferences.getUserUuid();
    DispatchRequest localDispatchRequest = localBuilder.setParameter("apiUrl", String.format("/clients/%s", arrayOfObject)).setParameter("apiMethod", "PUT").setParameter("apiParameters", localImmutableMap).setCallback(localDispatchCallbackBusAdapter).build();
    this.mDispatchClient.execute(localDispatchRequest);
  }

  public void onDispatchError(DispatchRequest paramDispatchRequest, DispatchResponse paramDispatchResponse, Response paramResponse)
  {
  }

  public void onDispatchNetworkError(DispatchRequest paramDispatchRequest, RetrofitError paramRetrofitError)
  {
  }

  public void onDispatchSuccess(DispatchRequest paramDispatchRequest, DispatchResponse paramDispatchResponse, Response paramResponse)
  {
    if (!(paramDispatchResponse instanceof Ping));
    Ping localPing;
    do
    {
      return;
      localPing = (Ping)paramDispatchResponse;
      injectEmployeePingData(localPing);
    }
    while (!paramDispatchRequest.isExpectingPingResults());
    this.mPingProvider.update(localPing);
  }

  public void onInterceptRequestParameters(Map<String, Object> paramMap)
  {
    RiderLocation localRiderLocation1 = this.mLocationProvider.getPinLocation();
    RiderLocation localRiderLocation2 = this.mLocationProvider.getDeviceLocation();
    if (localRiderLocation1 != null)
    {
      paramMap.put("latitude", Double.valueOf(localRiderLocation1.getUberLatLng().getLatitude()));
      paramMap.put("longitude", Double.valueOf(localRiderLocation1.getUberLatLng().getLongitude()));
    }
    while (true)
    {
      String str1 = this.mInAuthManager.getInAuthPID();
      if (!TextUtils.isEmpty(str1))
        paramMap.put("authId", str1);
      HashMap localHashMap = new HashMap();
      String str2 = this.mMobileAppTracker.getGoogleAdvertisingId();
      if (!TextUtils.isEmpty(str2))
        localHashMap.put("googleAdvertisingId", str2);
      if (!localHashMap.isEmpty())
        paramMap.put("deviceIds", new JSONObject(localHashMap));
      Ping localPing = this.mPingProvider.get();
      if ((!PingUtils.hasRiderAppConfig(localPing)) || (localPing.getAppConfig().getRiderConfig().isMobileMessagingEnabled()))
      {
        Map localMap = this.mMobileMessageManager.getCachedMessagesParams();
        if (localMap != null)
          paramMap.put("cachedMessages", localMap);
      }
      return;
      if (localRiderLocation2 != null)
      {
        paramMap.put("altitude", Double.valueOf(localRiderLocation2.getAltitude()));
        paramMap.put("course", Float.valueOf(localRiderLocation2.getBearing()));
        paramMap.put("horizontalAccuracy", Float.valueOf(localRiderLocation2.getAccuracy()));
        paramMap.put("latitude", Double.valueOf(localRiderLocation2.getUberLatLng().getLatitude()));
        paramMap.put("longitude", Double.valueOf(localRiderLocation2.getUberLatLng().getLongitude()));
        paramMap.put("speed", Float.valueOf(localRiderLocation2.getSpeed()));
      }
    }
  }

  public void payBill(int paramInt, String paramString)
  {
    String str = ensureToken();
    DispatchCallbackBusAdapter localDispatchCallbackBusAdapter = new DispatchCallbackBusAdapter(this.mBus, PayBillResponseEvent.class);
    ImmutableMap localImmutableMap = ImmutableMap.of("token", str, "payment_profile_id", paramString);
    DispatchRequest localDispatchRequest = new DispatchRequest.Builder().setMode(1).setMessageType("ApiCommand").setExpectsPingResults().setParameter("token", str).setParameter("apiMethod", "PUT").setParameter("apiUrl", "/client_bills/" + paramInt).setParameter("apiParameters", localImmutableMap).setCallback(localDispatchCallbackBusAdapter).build();
    this.mDispatchClient.execute(localDispatchRequest);
  }

  public void pickup(CnLocation paramCnLocation1, CnLocation paramCnLocation2, CnLocation paramCnLocation3, int paramInt, long paramLong, String paramString1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, TripExpenseInfo paramTripExpenseInfo, String paramString2)
  {
    String str = ensureToken();
    DispatchCallbackBusAdapter localDispatchCallbackBusAdapter = new DispatchCallbackBusAdapter(this.mBus, PickupResponseEvent.class);
    DispatchRequest.Builder localBuilder = new DispatchRequest.Builder().setMode(1).setMessageType("Pickup").setExpectsPingResults().setCallback(localDispatchCallbackBusAdapter).setParameter("token", str).setParameter("pickupLocation", paramCnLocation2).setParameter("destination", paramCnLocation3).setParameter("paymentProfileId", paramString1).setParameter("useCredits", Boolean.valueOf(paramBoolean2)).setParameter("vehicleViewId", Integer.valueOf(paramInt)).setParameter("userLocation", paramCnLocation1).setParameter("isGoogleWalletRequest", Boolean.valueOf(paramBoolean1)).setParameter("expenseInfo", paramTripExpenseInfo);
    if (paramLong > 0L)
      localBuilder.setParameter("fareId", Long.valueOf(paramLong));
    if (!TextUtils.isEmpty(paramString2));
    for (int i = 1; ; i = 0)
    {
      if ((paramBoolean3) || (i != 0))
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("paymentProfileId", paramString1);
        if (paramBoolean3)
          localHashMap.put("useAmexReward", Boolean.valueOf(true));
        if (i != 0)
          localHashMap.put("payPalCorrelationId", paramString2);
        localBuilder.setParameter("extraPaymentData", localHashMap);
      }
      this.mDispatchClient.execute(localBuilder.build());
      return;
    }
  }

  public void pickupCancelClient()
  {
    String str = ensureToken();
    DispatchCallbackBusAdapter localDispatchCallbackBusAdapter = new DispatchCallbackBusAdapter(this.mBus, PickupCancelClientResponseEvent.class);
    DispatchRequest localDispatchRequest = new DispatchRequest.Builder().setMode(1).setMessageType("PickupCanceledClient").setExpectsPingResults().setCallback(localDispatchCallbackBusAdapter).setParameter("token", str).build();
    this.mDispatchClient.execute(localDispatchRequest);
  }

  public void pingClient()
  {
    String str = ensureToken();
    DispatchCallbackBusAdapter localDispatchCallbackBusAdapter = new DispatchCallbackBusAdapter(this.mBus, PingClientResponseEvent.class);
    DispatchRequest localDispatchRequest = new DispatchRequest.Builder().setMode(2).setMessageType("PingClient").setExpectsPingResults().setCallback(localDispatchCallbackBusAdapter).setParameter("token", str).build();
    this.mDispatchClient.execute(localDispatchRequest);
  }

  public void rateDriver(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    String str = ensureToken();
    DispatchCallbackBusAdapter localDispatchCallbackBusAdapter = new DispatchCallbackBusAdapter(this.mBus, RatingDriverResponseEvent.class);
    DispatchRequest.Builder localBuilder = new DispatchRequest.Builder().setMode(1).setMessageType("RatingDriver").setExpectsPingResults().setCallback(localDispatchCallbackBusAdapter).setParameter("token", str).setParameter("tripId", paramString1).setParameter("rating", Integer.valueOf(paramInt1));
    if (paramInt2 > 0)
      localBuilder.setParameter("feedbackId", Integer.valueOf(paramInt2));
    if (!TextUtils.isEmpty(paramString2))
      localBuilder.setParameter("feedback", paramString2);
    this.mDispatchClient.execute(localBuilder.build());
  }

  public void registerPushToken(String paramString1, String paramString2, DispatchCallback<Ping> paramDispatchCallback)
  {
    String str = ensureToken();
    DispatchRequest localDispatchRequest = new DispatchRequest.Builder().setMode(0).setMessageType("RegisterPushToken").setParameter("token", str).setParameter("deviceTokenType", paramString1).setParameter("deviceToken", paramString2).setParameter("certificate", "enterprise").setCallback(paramDispatchCallback).build();
    this.mDispatchClient.execute(localDispatchRequest);
  }

  public void requestMobileConfirmation()
  {
    String str1 = ensureToken();
    DispatchCallbackBusAdapter localDispatchCallbackBusAdapter = new DispatchCallbackBusAdapter(this.mBus, RequestMobileConfirmationResponseEvent.class);
    ImmutableMap localImmutableMap = ImmutableMap.of("token", str1);
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = this.mSessionPreferences.getUserUuid();
    String str2 = String.format("/clients/%s/request_mobile_confirmation", arrayOfObject);
    DispatchRequest localDispatchRequest = new DispatchRequest.Builder().setMode(1).setMessageType("ApiCommand").setExpectsPingResults().setParameter("token", str1).setParameter("apiMethod", "PUT").setParameter("apiUrl", str2).setParameter("apiParameters", localImmutableMap).setCallback(localDispatchCallbackBusAdapter).build();
    this.mDispatchClient.execute(localDispatchRequest);
  }

  public void scheduleSurgeDropNotification(long paramLong, int paramInt, CnLocation paramCnLocation)
  {
    String str = ensureToken();
    DispatchCallbackBusAdapter localDispatchCallbackBusAdapter = new DispatchCallbackBusAdapter(this.mBus, ScheduleSurgeDropNotificationResponseEvent.class);
    DispatchRequest localDispatchRequest = new DispatchRequest.Builder().setMode(1).setMessageType("OptInNotification").setCallback(localDispatchCallbackBusAdapter).setParameter("token", str).setParameter("pickupLocation", paramCnLocation).setParameter("notificationName", "SurgeDrop").setParameter("fareId", Long.valueOf(paramLong)).setParameter("vehicleViewId", Integer.valueOf(paramInt)).build();
    this.mDispatchClient.execute(localDispatchRequest);
  }

  public void selectPaymentProfile(String paramString1, boolean paramBoolean, String paramString2)
  {
    String str = ensureToken();
    DispatchCallbackBusAdapter localDispatchCallbackBusAdapter = new DispatchCallbackBusAdapter(this.mBus, SelectPaymentProfileResponseEvent.class);
    DispatchRequest.Builder localBuilder = new DispatchRequest.Builder().setMode(1).setMessageType("SelectPaymentProfile").setExpectsPingResults().setCallback(localDispatchCallbackBusAdapter).setParameter("token", str).setParameter("paymentProfileId", paramString1).setParameter("isGoogleWalletRequest", Boolean.valueOf(paramBoolean));
    if (!TextUtils.isEmpty(paramString2))
      localBuilder.setParameter("extraPaymentData", createExtraPaymentDataWithPayPalCorrelationId(paramString1, paramString2));
    this.mDispatchClient.execute(localBuilder.build());
  }

  public void setDestination(int paramInt, long paramLong, CnLocation paramCnLocation1, CnLocation paramCnLocation2)
  {
    String str = ensureToken();
    DispatchCallbackBusAdapter localDispatchCallbackBusAdapter = new DispatchCallbackBusAdapter(this.mBus, SetDestinationResponseEvent.class);
    DispatchRequest.Builder localBuilder = new DispatchRequest.Builder().setMode(1).setMessageType("SetDestination").setExpectsPingResults().setParameter("token", str).setParameter("vehicleViewId", Integer.valueOf(paramInt)).setParameter("performFareEstimate", Boolean.valueOf(true)).setParameter("pickupLocation", paramCnLocation1).setParameter("destination", paramCnLocation2).setParameter("fareId", Long.valueOf(paramLong)).setCallback(localDispatchCallbackBusAdapter);
    if (paramLong > 0L)
      localBuilder.setParameter("fareId", Long.valueOf(paramLong));
    this.mDispatchClient.execute(localBuilder.build());
  }

  public void setUseCredits(boolean paramBoolean)
  {
    String str = ensureToken();
    DispatchCallbackBusAdapter localDispatchCallbackBusAdapter = new DispatchCallbackBusAdapter(this.mBus, SetUseCreditsResponseEvent.class);
    DispatchRequest localDispatchRequest = new DispatchRequest.Builder().setMode(1).setMessageType("SetUseCredits").setExpectsPingResults().setCallback(localDispatchCallbackBusAdapter).setParameter("token", str).setParameter("useCredits", Boolean.valueOf(paramBoolean)).build();
    this.mDispatchClient.execute(localDispatchRequest);
  }

  public void shareYoRide()
  {
    String str = ensureToken();
    DispatchCallbackBusAdapter localDispatchCallbackBusAdapter = new DispatchCallbackBusAdapter(this.mBus, ShareYoRideResponseEvent.class);
    DispatchRequest localDispatchRequest = new DispatchRequest.Builder().setMessageType("ShareYoRide").setExpectsPingResults().setParameter("token", str).setCallback(localDispatchCallbackBusAdapter).build();
    this.mDispatchClient.execute(localDispatchRequest);
  }

  public void unregisterPushToken(String paramString1, String paramString2, String paramString3, DispatchCallback<Ping> paramDispatchCallback)
  {
    DispatchRequest localDispatchRequest = new DispatchRequest.Builder().setMode(0).setMessageType("UnregisterPushToken").setParameter("token", paramString1).setParameter("deviceTokenType", paramString2).setParameter("deviceToken", paramString3).setParameter("certificate", "enterprise").setCallback(paramDispatchCallback).build();
    this.mDispatchClient.execute(localDispatchRequest);
  }

  public void updateMobileNumber(String paramString1, String paramString2)
  {
    String str = ensureToken();
    ImmutableMap localImmutableMap = ImmutableMap.of("token", str, "mobile", paramString1, "mobileCountryIso2", paramString2);
    DispatchCallbackBusAdapter localDispatchCallbackBusAdapter = new DispatchCallbackBusAdapter(this.mBus, ClientUpdateResponseEvent.class);
    DispatchRequest.Builder localBuilder = new DispatchRequest.Builder().setMode(1).setMessageType("ApiCommand").setExpectsPingResults().setParameter("token", str);
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = this.mSessionPreferences.getUserUuid();
    DispatchRequest localDispatchRequest = localBuilder.setParameter("apiUrl", String.format("/clients/%s", arrayOfObject)).setParameter("apiMethod", "PUT").setParameter("apiParameters", localImmutableMap).setCallback(localDispatchCallbackBusAdapter).build();
    this.mDispatchClient.execute(localDispatchRequest);
  }

  public void updatePaymentProfile(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    String str = ensureToken();
    DispatchCallbackBusAdapter localDispatchCallbackBusAdapter = new DispatchCallbackBusAdapter(this.mBus, UpdatePaymentProfileResponseEvent.class);
    HashMap localHashMap = new HashMap();
    localHashMap.put("token", str);
    localHashMap.put("card_code", paramString4);
    localHashMap.put("use_case", paramString7);
    localHashMap.put("billing_zip", paramString6);
    localHashMap.put("card_expiration_year", paramString3);
    localHashMap.put("card_expiration_month", paramString2);
    localHashMap.put("billing_country_iso2", paramString5.toUpperCase(Locale.US));
    DispatchRequest localDispatchRequest = new DispatchRequest.Builder().setMode(1).setMessageType("ApiCommand").setExpectsPingResults().setCallback(localDispatchCallbackBusAdapter).setParameter("token", str).setParameter("apiMethod", "PUT").setParameter("apiUrl", "/payment_profiles/" + paramString1).setParameter("apiParameters", localHashMap).build();
    this.mDispatchClient.execute(localDispatchRequest);
  }

  public void updateRewardData(String paramString, Boolean paramBoolean1, Boolean paramBoolean2)
  {
    String str = ensureToken();
    HashMap localHashMap = new HashMap();
    localHashMap.put("type", "amex_reward");
    DispatchCallbackBusAdapter localDispatchCallbackBusAdapter = null;
    if (paramBoolean1 != null)
    {
      localHashMap.put("enroll", paramBoolean1);
      localDispatchCallbackBusAdapter = new DispatchCallbackBusAdapter(this.mBus, RewardsEnrollmentUpdateResponseEvent.class);
    }
    if (paramBoolean2 != null)
      localHashMap.put("enable", paramBoolean2);
    int i = NumberUtils.tryParseInteger(paramString, -1);
    DispatchRequest.Builder localBuilder1 = new DispatchRequest.Builder().setMode(1).setMessageType("PaymentRewardUpdate").setExpectsPingResults().setParameter("token", str);
    if (i != -1)
      paramString = Integer.valueOf(i);
    DispatchRequest.Builder localBuilder2 = localBuilder1.setParameter("paymentProfileId", paramString).setParameter("rewardData", localHashMap);
    if (localDispatchCallbackBusAdapter != null)
      localBuilder2.setCallback(localDispatchCallbackBusAdapter);
    this.mDispatchClient.execute(localBuilder2.build());
  }

  public void validatePromo(String paramString, boolean paramBoolean)
  {
    DispatchCallbackBusAdapter localDispatchCallbackBusAdapter = new DispatchCallbackBusAdapter(this.mBus, ValidatePromoResponseEvent.class);
    HashMap localHashMap = new HashMap();
    localHashMap.put("promotion_code", paramString);
    if (paramBoolean);
    for (int i = 1; ; i = 0)
    {
      localHashMap.put("confirmed", Integer.valueOf(i));
      RiderLocation localRiderLocation = this.mLocationProvider.getDeviceLocation();
      if (localRiderLocation != null)
      {
        localHashMap.put("latitude", Double.valueOf(localRiderLocation.getUberLatLng().getLatitude()));
        localHashMap.put("longitude", Double.valueOf(localRiderLocation.getUberLatLng().getLongitude()));
      }
      DispatchRequest localDispatchRequest = new DispatchRequest.Builder().setMode(1).setMessageType("ApiCommand").setParameter("apiUrl", "/validate/promotion").setParameter("apiMethod", "GET").setParameter("apiParameters", localHashMap).setCallback(localDispatchCallbackBusAdapter).build();
      this.mDispatchClient.execute(localDispatchRequest);
      return;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.network.RiderClientImpl
 * JD-Core Version:    0.6.2
 */