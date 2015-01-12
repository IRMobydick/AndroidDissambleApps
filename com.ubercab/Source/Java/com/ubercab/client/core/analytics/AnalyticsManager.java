package com.ubercab.client.core.analytics;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.squareup.okhttp.OkHttpClient;
import com.ubercab.client.core.analytics.event.AddExpenseInfoEvent;
import com.ubercab.client.core.analytics.event.AnalyticsEvent.Listener;
import com.ubercab.client.core.analytics.event.AppEvent;
import com.ubercab.client.core.analytics.event.CancelTripEvent;
import com.ubercab.client.core.analytics.event.ContactDriverEvent;
import com.ubercab.client.core.analytics.event.FareSplitEvent;
import com.ubercab.client.core.analytics.event.LocationEvent;
import com.ubercab.client.core.analytics.event.NearestCabEvent;
import com.ubercab.client.core.analytics.event.NotificationEvent;
import com.ubercab.client.core.analytics.event.PageEvent;
import com.ubercab.client.core.analytics.event.RateDriverEvent;
import com.ubercab.client.core.analytics.event.RequestVehicleEvent;
import com.ubercab.client.core.analytics.event.SessionEvent;
import com.ubercab.client.core.analytics.event.SetUseCreditsEvent;
import com.ubercab.client.core.analytics.event.ShareEvent;
import com.ubercab.client.core.analytics.event.SignInEvent;
import com.ubercab.client.core.analytics.event.SignOutEvent;
import com.ubercab.client.core.analytics.event.SignUpEvent;
import com.ubercab.client.core.analytics.event.SurgeEvent;
import com.ubercab.client.core.analytics.event.TripEvent;
import com.ubercab.client.core.analytics.event.UrlEvent;
import com.ubercab.client.core.content.RiderLocationProvider;
import com.ubercab.client.core.content.SessionPreferences;
import com.ubercab.client.core.location.RiderLocation;
import com.ubercab.library.location.model.UberLatLng;
import com.ubercab.library.location.model.UberLocation;
import com.ubercab.library.metrics.analytics.session.UberSessionGenerator;
import com.ubercab.library.network.CallbackAdapter;
import com.ubercab.library.util.DeviceUtils;
import com.ubercab.library.util.TimeUtils;
import java.util.Map;
import retrofit.RestAdapter;
import retrofit.RestAdapter.Builder;
import retrofit.RestAdapter.LogLevel;
import retrofit.client.OkClient;

@Deprecated
public final class AnalyticsManager
  implements AnalyticsEvent.Listener
{
  private AddExpenseInfoEvent mAddExpenseInfoEvent;
  private AnalyticsApi mAnalyticsApi;
  private AppEvent mAppEvent;
  private CallbackAdapter<Void> mCallback;
  private CancelTripEvent mCancelTripEvent;
  private ContactDriverEvent mContactDriverEvent;
  private Context mContext;
  private FareSplitEvent mFareSplitEvent;
  private boolean mIsProductDetailShowing;
  private LocationEvent mLocationEvent;
  private RiderLocationProvider mLocationProvider;
  private NearestCabEvent mNearestCabEvent;
  private NotificationEvent mNotificationEvent;
  private PageEvent mPageEvent;
  private RateDriverEvent mRateDriverEvent;
  private RequestVehicleEvent mRequestVehicleEvent;
  private SessionEvent mSessionEvent;
  private SessionPreferences mSessionPreferences;
  private SetUseCreditsEvent mSetUseCreditsEvent;
  private ShareEvent mShareEvent;
  private SignInEvent mSignInEvent;
  private SignOutEvent mSignOutEvent;
  private SignUpEvent mSignUpEvent;
  private SurgeEvent mSurgeEvent;
  private TripEvent mTripEvent;
  private UberSessionGenerator mUberSessionGenerator;
  private UrlEvent mUrlEvent;

  public AnalyticsManager(Context paramContext, SessionPreferences paramSessionPreferences, RiderLocationProvider paramRiderLocationProvider, OkHttpClient paramOkHttpClient, UberSessionGenerator paramUberSessionGenerator)
  {
    this(paramContext, paramSessionPreferences, paramRiderLocationProvider, createAnalyticsApi(paramOkHttpClient), paramUberSessionGenerator);
  }

  public AnalyticsManager(Context paramContext, SessionPreferences paramSessionPreferences, RiderLocationProvider paramRiderLocationProvider, AnalyticsApi paramAnalyticsApi, UberSessionGenerator paramUberSessionGenerator)
  {
    this.mContext = paramContext;
    this.mSessionPreferences = paramSessionPreferences;
    this.mLocationProvider = paramRiderLocationProvider;
    this.mAnalyticsApi = paramAnalyticsApi;
    this.mUberSessionGenerator = paramUberSessionGenerator;
    this.mCallback = new CallbackAdapter()
    {
    };
    this.mIsProductDetailShowing = false;
    this.mUrlEvent = new UrlEvent(this);
    this.mPageEvent = new PageEvent(this);
    this.mAddExpenseInfoEvent = new AddExpenseInfoEvent(this);
    this.mAppEvent = new AppEvent(this);
    this.mSurgeEvent = new SurgeEvent(this);
    this.mShareEvent = new ShareEvent(this);
    this.mSignInEvent = new SignInEvent(this);
    this.mSignUpEvent = new SignUpEvent(this);
    this.mTripEvent = new TripEvent(this);
    this.mLocationEvent = new LocationEvent(this);
    this.mSessionEvent = new SessionEvent(this);
    this.mSignOutEvent = new SignOutEvent(this);
    this.mFareSplitEvent = new FareSplitEvent(this);
    this.mCancelTripEvent = new CancelTripEvent(this);
    this.mNearestCabEvent = new NearestCabEvent(this);
    this.mRateDriverEvent = new RateDriverEvent(this);
    this.mNotificationEvent = new NotificationEvent(this);
    this.mContactDriverEvent = new ContactDriverEvent(this);
    this.mSetUseCreditsEvent = new SetUseCreditsEvent(this);
    this.mRequestVehicleEvent = new RequestVehicleEvent(this);
  }

  private static AnalyticsApi createAnalyticsApi(OkHttpClient paramOkHttpClient)
  {
    return (AnalyticsApi)new RestAdapter.Builder().setClient(new OkClient(paramOkHttpClient)).setLogLevel(RestAdapter.LogLevel.NONE).setEndpoint("https://events.uber.com").build().create(AnalyticsApi.class);
  }

  public AddExpenseInfoEvent addExpenseInfoEvent()
  {
    return this.mAddExpenseInfoEvent;
  }

  public AppEvent appEvent()
  {
    return this.mAppEvent;
  }

  public CancelTripEvent cancelTripEvent()
  {
    return this.mCancelTripEvent;
  }

  public ContactDriverEvent contactDriverEvent()
  {
    return this.mContactDriverEvent;
  }

  public FareSplitEvent fareSplitEvent()
  {
    return this.mFareSplitEvent;
  }

  @Deprecated
  public boolean isProductDetailShowing()
  {
    return this.mIsProductDetailShowing;
  }

  public LocationEvent locationEvent()
  {
    return this.mLocationEvent;
  }

  public NearestCabEvent nearestCabEvent()
  {
    return this.mNearestCabEvent;
  }

  public NotificationEvent notificationEvent()
  {
    return this.mNotificationEvent;
  }

  public void onSendEvent(Map<String, Object> paramMap)
  {
    String str = this.mSessionPreferences.getUserUuid();
    paramMap.put("app", "client");
    if (TextUtils.isEmpty(str))
      str = null;
    paramMap.put("clientUuid", str);
    paramMap.put("device", "android");
    paramMap.put("deviceId", DeviceUtils.getDeviceId(this.mContext));
    paramMap.put("deviceLanguage", DeviceUtils.getDeviceLanguage());
    paramMap.put("deviceModel", Build.MODEL);
    paramMap.put("deviceOS", Build.VERSION.RELEASE);
    paramMap.put("epoch", Long.valueOf(TimeUtils.getEpochTimeMs()));
    paramMap.put("libraryVersion", "3.23.2");
    paramMap.put("sessionHash", this.mSessionPreferences.getSessionHash());
    paramMap.put("analyticsV2SessionId", this.mUberSessionGenerator.getId());
    paramMap.put("version", "3.23.2");
    RiderLocation localRiderLocation = this.mLocationProvider.getDeviceLocation();
    if (localRiderLocation != null)
    {
      UberLatLng localUberLatLng = localRiderLocation.getUberLatLng();
      double[] arrayOfDouble = new double[2];
      arrayOfDouble[0] = localUberLatLng.getLongitude();
      arrayOfDouble[1] = localUberLatLng.getLatitude();
      paramMap.put("location", arrayOfDouble);
      paramMap.put("locationAltitude", Double.valueOf(localRiderLocation.getAltitude()));
      paramMap.put("locationHorizontalAccuracy", Float.valueOf(localRiderLocation.getAccuracy()));
      paramMap.put("locationVerticalAccuracy", Float.valueOf(localRiderLocation.getAccuracy()));
    }
    this.mAnalyticsApi.event(paramMap, this.mCallback);
  }

  public PageEvent pageEvent()
  {
    return this.mPageEvent;
  }

  public RateDriverEvent rateDriverEvent()
  {
    return this.mRateDriverEvent;
  }

  public RequestVehicleEvent requestVehicleEvent()
  {
    return this.mRequestVehicleEvent;
  }

  public SessionEvent sessionEvent()
  {
    return this.mSessionEvent;
  }

  @Deprecated
  public void setProductDetailShowing(boolean paramBoolean)
  {
    this.mIsProductDetailShowing = paramBoolean;
  }

  public SetUseCreditsEvent setUseCreditsEvent()
  {
    return this.mSetUseCreditsEvent;
  }

  public ShareEvent shareEvent()
  {
    return this.mShareEvent;
  }

  public SignInEvent signInEvent()
  {
    return this.mSignInEvent;
  }

  public SignOutEvent signOutEvent()
  {
    return this.mSignOutEvent;
  }

  public SignUpEvent signUpEvent()
  {
    return this.mSignUpEvent;
  }

  public SurgeEvent surgeEvent()
  {
    return this.mSurgeEvent;
  }

  public TripEvent tripEvent()
  {
    return this.mTripEvent;
  }

  public UrlEvent urlEvent()
  {
    return this.mUrlEvent;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.analytics.AnalyticsManager
 * JD-Core Version:    0.6.2
 */