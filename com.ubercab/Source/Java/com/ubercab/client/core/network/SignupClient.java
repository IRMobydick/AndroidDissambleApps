package com.ubercab.client.core.network;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.mobileapptracker.MobileAppTracker;
import com.squareup.otto.Bus;
import com.ubercab.client.core.content.RiderLocationProvider;
import com.ubercab.client.core.location.RiderLocation;
import com.ubercab.client.core.model.ClientSignupResponse;
import com.ubercab.client.core.network.events.ClientSignupResponseEvent;
import com.ubercab.client.core.network.events.ValidateAccountResponseEvent;
import com.ubercab.common.collect.ImmutableMap;
import com.ubercab.library.app.BuildConfigProxy;
import com.ubercab.library.app.UberPreferences;
import com.ubercab.library.location.model.UberLatLng;
import com.ubercab.library.location.model.UberLocation;
import com.ubercab.library.network.BaseRetryCallback;
import com.ubercab.library.util.DeviceUtils;
import com.ubercab.library.util.StringUtils;
import com.ubercab.library.util.TimeUtils;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class SignupClient
{
  static final String ANDROID_FORM_VALUE = "android";
  static final String PARAM_ALIPAY_ID = "alipay_id";
  static final String PARAM_ALIPAY_MOBILE = "alipay_mobile";
  static final String PARAM_API_GOOGLE_OAUTH_TOKEN_TYPE_JWT = "jwt";
  static final String PARAM_API_TOKEN_TYPE_ALIPAY = "alipay";
  static final String PARAM_API_TOKEN_TYPE_PAYPAL = "paypal";
  static final String PARAM_API_TOKEN_TYPE_PAYTM = "paytm";
  static final String PARAM_AUTH_GOOGLE_TOKEN = "google_oauth_token";
  static final String PARAM_AUTH_GOOGLE_TOKEN_TYPE = "google_oauth_token_type";
  static final String PARAM_AUTH_THIRD_PARTY_ACCESS_TOKEN = "third_party_access_token";
  static final String PARAM_AUTH_THIRD_PARTY_IDENTITY_TYPE = "third_party_identity_type";
  static final String PARAM_AUTH_THIRD_PARTY_TOKEN_EXPIRES_MS = "third_party_access_token_expiry";
  static final String PARAM_BILLING_CARD_CODE = "card_code";
  static final String PARAM_BILLING_CARD_EXPIRATION_MONTH = "card_expiration_month";
  static final String PARAM_BILLING_CARD_EXPIRATION_YEAR = "card_expiration_year";
  static final String PARAM_BILLING_CARD_NUMBER = "card_number";
  static final String PARAM_BILLING_COUNTRY = "billing_country_iso2";
  static final String PARAM_BILLING_POSTAL_CODE = "billing_zip";
  static final String PARAM_BILLING_PROMOTION_CODE = "promotion_code";
  static final String PARAM_BILLING_THIRD_PARTY_TOKEN_DATA = "token_data";
  static final String PARAM_BILLING_THIRD_PARTY_TOKEN_TYPE = "token_type";
  static final String PARAM_BILLING_USE_CASE = "use_case";
  static final String PARAM_BILLING_USING_CARD_IO = "cardio";
  static final String PARAM_GLOBAL_APP = "app";
  static final String PARAM_GLOBAL_DEVICE = "device";
  static final String PARAM_GLOBAL_DEVICE_ID = "device_id";
  static final String PARAM_GLOBAL_DEVICE_IDS = "device_ids";
  static final String PARAM_GLOBAL_DEVICE_MOBILE_COUNTRY_CODE = "device_mobile_country_iso2";
  static final String PARAM_GLOBAL_DEVICE_MOBILE_DIGITS = "device_mobile_digits";
  static final String PARAM_GLOBAL_DEVICE_MODEL = "device_model";
  static final String PARAM_GLOBAL_DEVICE_OS = "device_os";
  static final String PARAM_GLOBAL_DEVICE_SERIAL_NUMBER = "device_serial_number";
  static final String PARAM_GLOBAL_EPOCH = "epoch";
  static final String PARAM_GLOBAL_LANGUAGE = "language";
  static final String PARAM_GLOBAL_VERSION = "version";
  static final String PARAM_GOOGLE_ADVERTISING_ID = "googleAdvertisingId";
  static final String PARAM_LOCATION_ALTITUDE = "altitude";
  static final String PARAM_LOCATION_COURSE = "course";
  static final String PARAM_LOCATION_HORIZONTAL_ACCURACY = "horizontal_accuracy";
  static final String PARAM_LOCATION_LATITUDE = "latitude";
  static final String PARAM_LOCATION_LONGITUDE = "longitude";
  static final String PARAM_LOCATION_SPEED = "speed";
  static final String PARAM_PAYPAL_CORRELATION_ID = "paypal_correlation_id";
  static final String PARAM_PAYTM_EMAIL = "paytm_email";
  static final String PARAM_PAYTM_MOBILE = "paytm_mobile";
  static final String PARAM_SIGNUP_EMAIL = "email";
  static final String PARAM_SIGNUP_FIRST_NAME = "first_name";
  static final String PARAM_SIGNUP_FORM = "signup_form";
  static final String PARAM_SIGNUP_LAST_NAME = "last_name";
  static final String PARAM_SIGNUP_MOBILE = "mobile";
  static final String PARAM_SIGNUP_MOBILE_COUNTRY_CODE = "mobile_country_iso2";
  static final String PARAM_SIGNUP_PASSWORD = "password";
  private final SignupApi mApi;
  private final BuildConfigProxy mAppBuildConfig;
  private final Bus mBus;
  private final Context mContext;
  private final RiderLocationProvider mLocationProvider;
  private final MobileAppTracker mMobileAppTracker;
  private final UberPreferences mPreferences;

  public SignupClient(Bus paramBus, Context paramContext, BuildConfigProxy paramBuildConfigProxy, SignupApi paramSignupApi, RiderLocationProvider paramRiderLocationProvider, MobileAppTracker paramMobileAppTracker, UberPreferences paramUberPreferences)
  {
    this.mApi = paramSignupApi;
    this.mAppBuildConfig = paramBuildConfigProxy;
    this.mBus = paramBus;
    this.mContext = paramContext;
    this.mLocationProvider = paramRiderLocationProvider;
    this.mMobileAppTracker = paramMobileAppTracker;
    this.mPreferences = paramUberPreferences;
  }

  private SignupCallback buildSignupCallback(final Map<String, Object> paramMap)
  {
    final SignupCallback localSignupCallback = new SignupCallback();
    localSignupCallback.setRetryRunnable(new Runnable()
    {
      public void run()
      {
        SignupClient.this.create(paramMap, localSignupCallback);
      }
    });
    return localSignupCallback;
  }

  private ValidateCallback buildValidateCallback(final Map<String, Object> paramMap)
  {
    final ValidateCallback localValidateCallback = new ValidateCallback();
    localValidateCallback.setRetryRunnable(new Runnable()
    {
      public void run()
      {
        SignupClient.this.validate(paramMap, localValidateCallback);
      }
    });
    return localValidateCallback;
  }

  private void create(Map<String, Object> paramMap, SignupCallback paramSignupCallback)
  {
    this.mApi.create(paramMap, paramSignupCallback);
  }

  private String createAlipayToken(String paramString1, String paramString2)
  {
    return new JSONObject(ImmutableMap.of("alipay_id", paramString1, "alipay_mobile", paramString2)).toString();
  }

  private String createPaytmToken(String paramString1, String paramString2)
  {
    return new JSONObject(ImmutableMap.of("paytm_email", paramString1, "paytm_mobile", paramString2)).toString();
  }

  private String getDeviceIdMd5()
  {
    return StringUtils.md5(DeviceUtils.getDeviceId(this.mContext));
  }

  private void validate(Map<String, Object> paramMap, ValidateCallback paramValidateCallback)
  {
    this.mApi.validate(paramMap, paramValidateCallback);
  }

  void addGlobalParameters(Map<String, Object> paramMap)
  {
    paramMap.put("app", this.mAppBuildConfig.getAppName());
    paramMap.put("device", "android");
    paramMap.put("device_id", StringUtils.md5(DeviceUtils.getDeviceId(this.mContext)));
    paramMap.put("device_mobile_digits", DeviceUtils.getPhoneNumber(this.mContext));
    paramMap.put("device_mobile_country_iso2", DeviceUtils.getPhoneNumberCountryIso2(this.mContext));
    paramMap.put("device_model", Build.MODEL);
    paramMap.put("device_os", Build.VERSION.RELEASE);
    paramMap.put("device_serial_number", Build.SERIAL);
    paramMap.put("epoch", Long.valueOf(TimeUtils.getEpochTimeMs()));
    paramMap.put("language", DeviceUtils.getDeviceLanguage());
    if (this.mPreferences.hasFakeVersion())
      paramMap.put("version", this.mPreferences.getFakeVersion());
    while (true)
    {
      RiderLocation localRiderLocation = this.mLocationProvider.getDeviceLocation();
      if (localRiderLocation != null)
      {
        paramMap.put("altitude", Double.valueOf(localRiderLocation.getAltitude()));
        paramMap.put("course", Float.valueOf(localRiderLocation.getBearing()));
        paramMap.put("horizontal_accuracy", Float.valueOf(localRiderLocation.getAccuracy()));
        paramMap.put("latitude", Double.valueOf(localRiderLocation.getUberLatLng().getLatitude()));
        paramMap.put("longitude", Double.valueOf(localRiderLocation.getUberLatLng().getLongitude()));
        paramMap.put("speed", Float.valueOf(localRiderLocation.getSpeed()));
      }
      String str = this.mMobileAppTracker.getGoogleAdvertisingId();
      if ((str != null) && (!str.isEmpty()))
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("googleAdvertisingId", str);
        paramMap.put("device_ids", localHashMap);
      }
      return;
      paramMap.put("version", this.mAppBuildConfig.getVersionName());
    }
  }

  Map<String, Object> createBaseSignUpParams(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, long paramLong)
  {
    if (TextUtils.isEmpty(paramString6))
      paramString6 = "";
    HashMap localHashMap = new HashMap();
    addGlobalParameters(localHashMap);
    localHashMap.put("email", paramString1);
    localHashMap.put("mobile", paramString2);
    localHashMap.put("first_name", paramString4);
    localHashMap.put("last_name", paramString5);
    localHashMap.put("mobile_country_iso2", paramString3.toUpperCase(Locale.US));
    localHashMap.put("signup_form", "android");
    localHashMap.put("promotion_code", paramString6);
    if (!TextUtils.isEmpty(paramString10))
    {
      localHashMap.put("third_party_identity_type", paramString9);
      localHashMap.put("third_party_access_token", paramString10);
      localHashMap.put("third_party_access_token_expiry", Long.valueOf(paramLong));
      return localHashMap;
    }
    if (!TextUtils.isEmpty(paramString8))
    {
      localHashMap.put("google_oauth_token_type", "jwt");
      localHashMap.put("google_oauth_token", paramString8);
      return localHashMap;
    }
    localHashMap.put("password", paramString7);
    return localHashMap;
  }

  public void signUpWithCreditCard(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, boolean paramBoolean, String paramString14, String paramString15, String paramString16, String paramString17, long paramLong)
  {
    Map localMap = createBaseSignUpParams(paramString1, paramString2, paramString3, paramString4, paramString5, paramString13, paramString14, paramString15, paramString16, paramString17, paramLong);
    localMap.put("card_number", paramString6);
    localMap.put("card_code", paramString7);
    localMap.put("card_expiration_month", paramString8);
    localMap.put("card_expiration_year", paramString9);
    localMap.put("cardio", Boolean.valueOf(paramBoolean));
    localMap.put("billing_zip", paramString10);
    localMap.put("billing_country_iso2", paramString11.toUpperCase(Locale.US));
    localMap.put("use_case", paramString12);
    create(localMap, buildSignupCallback(localMap));
  }

  public void signUpWithGoogleWallet(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, long paramLong)
  {
    Map localMap = createBaseSignUpParams(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8, paramString9, paramString10, paramLong);
    create(localMap, buildSignupCallback(localMap));
  }

  public void signUpWithPayTm(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, long paramLong)
  {
    Map localMap = createBaseSignUpParams(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8, paramString9, paramString10, paramLong);
    localMap.put("token_type", "paytm");
    localMap.put("token_data", createPaytmToken(paramString1, paramString2));
    create(localMap, buildSignupCallback(localMap));
  }

  public void signUpWithPaypal(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, long paramLong, String paramString12)
  {
    Map localMap = createBaseSignUpParams(paramString1, paramString2, paramString3, paramString4, paramString5, paramString7, paramString8, paramString9, paramString10, paramString11, paramLong);
    localMap.put("token_type", "paypal");
    localMap.put("token_data", paramString6);
    localMap.put("paypal_correlation_id", paramString12);
    create(localMap, buildSignupCallback(localMap));
  }

  public void signupWithAlipay(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    Map localMap = createBaseSignUpParams(paramString1, paramString2, paramString3, paramString4, paramString5, paramString8, paramString9, null, null, null, 0L);
    localMap.put("token_type", "alipay");
    localMap.put("token_data", createAlipayToken(paramString6, paramString7));
    create(localMap, buildSignupCallback(localMap));
  }

  public void validateAccount(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("email", paramString1);
    localHashMap.put("mobile", paramString2);
    localHashMap.put("mobile_country_iso2", paramString3.toUpperCase(Locale.US));
    localHashMap.put("password", paramString4);
    localHashMap.put("device", "android");
    localHashMap.put("device_id", getDeviceIdMd5());
    addGlobalParameters(localHashMap);
    validate(localHashMap, buildValidateCallback(localHashMap));
  }

  class SignupCallback extends BaseRetryCallback<ClientSignupResponse>
  {
    SignupCallback()
    {
    }

    public void errorRetryFailed(RetrofitError paramRetrofitError)
    {
      SignupClient.this.mBus.post(new ClientSignupResponseEvent(paramRetrofitError));
    }

    public void success(ClientSignupResponse paramClientSignupResponse, Response paramResponse)
    {
      SignupClient.this.mBus.post(new ClientSignupResponseEvent(paramClientSignupResponse, paramResponse));
    }
  }

  class ValidateCallback extends BaseRetryCallback<Map<String, Object>>
  {
    ValidateCallback()
    {
    }

    public void errorRetryFailed(RetrofitError paramRetrofitError)
    {
      SignupClient.this.mBus.post(new ValidateAccountResponseEvent(paramRetrofitError));
    }

    public void success(Map<String, Object> paramMap, Response paramResponse)
    {
      SignupClient.this.mBus.post(new ValidateAccountResponseEvent(paramMap, paramResponse));
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.network.SignupClient
 * JD-Core Version:    0.6.2
 */