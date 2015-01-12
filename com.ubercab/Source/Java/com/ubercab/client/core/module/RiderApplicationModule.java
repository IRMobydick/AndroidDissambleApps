package com.ubercab.client.core.module;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import com.google.gson.Gson;
import com.inauth.mme.InAuthManager;
import com.mobileapptracker.MobileAppTracker;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.otto.Bus;
import com.ubercab.client.core.analytics.AnalyticsManager;
import com.ubercab.client.core.app.NetworkErrorFragment;
import com.ubercab.client.core.app.RiderApplication;
import com.ubercab.client.core.app.RiderBuildConfig;
import com.ubercab.client.core.app.RiderPreferences;
import com.ubercab.client.core.app.RiderService;
import com.ubercab.client.core.content.CachePreferences;
import com.ubercab.client.core.content.PingProvider;
import com.ubercab.client.core.content.RiderLocationProvider;
import com.ubercab.client.core.content.SessionPreferences;
import com.ubercab.client.core.metrics.analytics.model.RiderEventsProperties;
import com.ubercab.client.core.metrics.monitoring.RiderMonitoringProperties;
import com.ubercab.client.core.model.Ping;
import com.ubercab.client.core.network.AppConfigApi;
import com.ubercab.client.core.network.AppConfigClient;
import com.ubercab.client.core.network.LegacyLocationApi;
import com.ubercab.client.core.network.LocationApi;
import com.ubercab.client.core.network.LocationClient;
import com.ubercab.client.core.network.LocationClientImpl;
import com.ubercab.client.core.network.PaymentApi;
import com.ubercab.client.core.network.PaymentClient;
import com.ubercab.client.core.network.RiderClient;
import com.ubercab.client.core.network.RiderClientImpl;
import com.ubercab.client.core.network.SignupApi;
import com.ubercab.client.core.network.SignupClient;
import com.ubercab.client.core.network.TunesApi;
import com.ubercab.client.core.network.TunesClient;
import com.ubercab.client.core.push.PushProvider;
import com.ubercab.client.core.push.RiderPushManager;
import com.ubercab.client.core.ui.CountryButton;
import com.ubercab.client.core.ui.FlagButton;
import com.ubercab.client.core.ui.MonthEditText;
import com.ubercab.client.core.ui.PaymentTextView;
import com.ubercab.client.core.ui.TripEtaPinPainter;
import com.ubercab.client.core.ui.YearEditText;
import com.ubercab.client.core.vendor.facebook.FacebookAuthorizationActivity;
import com.ubercab.client.core.vendor.facebook.FacebookAuthorizationFragment;
import com.ubercab.client.core.vendor.google.gcm.GcmPushProvider;
import com.ubercab.client.core.vendor.google.gcm.GcmService;
import com.ubercab.client.feature.about.AboutActivity;
import com.ubercab.client.feature.employee.EmployeeSettingsActivity;
import com.ubercab.client.feature.employee.EmployeeSettingsFragment;
import com.ubercab.client.feature.eta.ShareEtaActivity;
import com.ubercab.client.feature.faresplit.master.FareSplitChipAdapter;
import com.ubercab.client.feature.faresplit.master.FareSplitClientViewHolder;
import com.ubercab.client.feature.faresplit.master.FareSplitContactViewHolder;
import com.ubercab.client.feature.faresplit.master.FareSplitInviteActivity;
import com.ubercab.client.feature.faresplit.master.FareSplitSummaryAdapter;
import com.ubercab.client.feature.forceupgrade.ForceUpgradeFragment;
import com.ubercab.client.feature.launch.LauncherActivity;
import com.ubercab.client.feature.launch.MagicActivity;
import com.ubercab.client.feature.mobilemessage.LegacyMobileMessageManager;
import com.ubercab.client.feature.mobilemessage.MobileMessageManager;
import com.ubercab.client.feature.mobilemessage.MobileMessageModuleContentView;
import com.ubercab.client.feature.mobilemessage.MobileMessageNativeUrlManager;
import com.ubercab.client.feature.mobilemessage.MobileMessagePopupWindow;
import com.ubercab.client.feature.music.MusicProviderAuthorizationActivity;
import com.ubercab.client.feature.music.MusicProviderAuthorizationFragment;
import com.ubercab.client.feature.music.MusicProviderOfferFragment;
import com.ubercab.client.feature.music.MusicTrayView;
import com.ubercab.client.feature.music.overlay.AddMusicOverlayView;
import com.ubercab.client.feature.notification.NotificationActionReceiver;
import com.ubercab.client.feature.notification.NotificationPainter;
import com.ubercab.client.feature.notification.RiderNotificationManager;
import com.ubercab.client.feature.onboarding.OnBoardingFragment;
import com.ubercab.client.feature.onboarding.OnboardingActivity;
import com.ubercab.client.feature.payment.AddFundsWebViewActivity;
import com.ubercab.client.feature.payment.CreditsAdapter;
import com.ubercab.client.feature.payment.ExpenseAdapter;
import com.ubercab.client.feature.payment.PaymentFooterView;
import com.ubercab.client.feature.payment.PaymentOtpActivity;
import com.ubercab.client.feature.payment.PaymentWalletConfirmationFragment;
import com.ubercab.client.feature.payment.expense.ExpenseLinkResources;
import com.ubercab.client.feature.profile.ProfileActivity;
import com.ubercab.client.feature.promo.PromoActivity;
import com.ubercab.client.feature.receipt.FeedbackAdapter;
import com.ubercab.client.feature.share.ShareActivity;
import com.ubercab.client.feature.signin.SignInActivity;
import com.ubercab.client.feature.signin.SignInFragment;
import com.ubercab.client.feature.trip.address.AddressView;
import com.ubercab.client.feature.trip.confirm.ConfirmationView;
import com.ubercab.client.feature.trip.overlay.LegacyMobileMessageOverlayView;
import com.ubercab.client.feature.trip.overlay.NoLocationOverlayView;
import com.ubercab.client.feature.trip.slider.VehicleSeekBar;
import com.ubercab.client.feature.trip.slider.VehicleSlider;
import com.ubercab.client.feature.verification.MobileVerificationActivity;
import com.ubercab.library.app.BuildConfigProxy;
import com.ubercab.library.app.LifecycleTracker;
import com.ubercab.library.app.UberApplicationModule;
import com.ubercab.library.app.UberPreferences;
import com.ubercab.library.app.annotation.ForApp;
import com.ubercab.library.app.annotation.ForCn;
import com.ubercab.library.location.LocationProvider;
import com.ubercab.library.metrics.analytics.AnalyticsClient;
import com.ubercab.library.metrics.analytics.AnalyticsProperties;
import com.ubercab.library.metrics.analytics.session.UberSessionGenerator;
import com.ubercab.library.network.RealtimeRestAdapterBuilder;
import com.ubercab.library.network.RealtimeRestAdapterBuilder.UserDataProvider;
import com.ubercab.library.network.UberEndpoint;
import com.ubercab.library.network.UberRetrofitClient;
import com.ubercab.library.network.dispatch.DispatchClient;
import com.ubercab.webclient.app.WebClientActivity;
import dagger.Module;
import dagger.Provides;
import java.util.concurrent.ExecutorService;
import javax.inject.Named;
import javax.inject.Singleton;
import retrofit.RestAdapter;

@Module(addsTo=UberApplicationModule.class, injects={AboutActivity.class, AddFundsWebViewActivity.class, AddMusicOverlayView.class, AddressView.class, ConfirmationView.class, CountryButton.class, CreditsAdapter.class, ExpenseAdapter.class, EmployeeSettingsActivity.class, EmployeeSettingsFragment.class, FacebookAuthorizationActivity.class, FacebookAuthorizationFragment.class, FareSplitChipAdapter.class, FareSplitClientViewHolder.class, FareSplitContactViewHolder.class, FareSplitInviteActivity.class, FareSplitSummaryAdapter.class, FeedbackAdapter.class, FlagButton.class, ForceUpgradeFragment.class, GcmService.class, LauncherActivity.class, LegacyMobileMessageOverlayView.class, MagicActivity.class, MobileVerificationActivity.class, MobileMessageManager.class, MobileMessageModuleContentView.class, MobileMessageNativeUrlManager.class, MobileMessagePopupWindow.class, MonthEditText.class, MusicProviderAuthorizationActivity.class, MusicProviderAuthorizationFragment.class, MusicProviderOfferFragment.class, MusicTrayView.class, NetworkErrorFragment.class, NoLocationOverlayView.class, NotificationActionReceiver.class, NotificationPainter.class, OnBoardingFragment.class, OnboardingActivity.class, PaymentFooterView.class, PaymentOtpActivity.class, PaymentTextView.class, PaymentWalletConfirmationFragment.class, ProfileActivity.class, PromoActivity.class, RiderApplication.class, RiderService.class, ShareActivity.class, ShareEtaActivity.class, SignInActivity.class, SignInFragment.class, TripEtaPinPainter.class, VehicleSeekBar.class, VehicleSlider.class, WebClientActivity.class, YearEditText.class}, library=true)
public final class RiderApplicationModule
{
  private final RiderApplication mApplication;

  public RiderApplicationModule(RiderApplication paramRiderApplication)
  {
    this.mApplication = paramRiderApplication;
  }

  @Provides
  @Singleton
  AnalyticsManager provideAnalyticsManager(SessionPreferences paramSessionPreferences, RiderLocationProvider paramRiderLocationProvider, OkHttpClient paramOkHttpClient, UberSessionGenerator paramUberSessionGenerator)
  {
    return new AnalyticsManager(this.mApplication, paramSessionPreferences, paramRiderLocationProvider, paramOkHttpClient, paramUberSessionGenerator);
  }

  @Provides
  @Singleton
  AnalyticsProperties provideAnalyticsProperties(Bus paramBus, SessionPreferences paramSessionPreferences, Gson paramGson, PingProvider paramPingProvider)
  {
    RiderEventsProperties localRiderEventsProperties = new RiderEventsProperties(this.mApplication, paramSessionPreferences, paramGson, paramPingProvider);
    localRiderEventsProperties.register(paramBus);
    return localRiderEventsProperties;
  }

  @Provides
  @Singleton
  UberSessionGenerator provideAnalyticsSession(AnalyticsClient paramAnalyticsClient, LifecycleTracker paramLifecycleTracker, UberPreferences paramUberPreferences)
  {
    return new UberSessionGenerator(paramAnalyticsClient, paramLifecycleTracker, paramUberPreferences);
  }

  @Provides
  @Singleton
  AppConfigClient provideAppConfigClient(Bus paramBus, RealtimeRestAdapterBuilder paramRealtimeRestAdapterBuilder, RiderPreferences paramRiderPreferences)
  {
    return new AppConfigClient(paramBus, (AppConfigApi)paramRealtimeRestAdapterBuilder.build().create(AppConfigApi.class), paramRiderPreferences);
  }

  @Provides
  @Singleton
  CachePreferences provideCache(Gson paramGson)
  {
    return new CachePreferences(this.mApplication.getSharedPreferences(".storage", 0), paramGson);
  }

  @Provides
  Context provideContext()
  {
    return this.mApplication;
  }

  @Provides
  @Singleton
  InAuthManager provideInAuthManager()
  {
    InAuthManager localInAuthManager = InAuthManager.getInstance();
    localInAuthManager.initOffline(this.mApplication, null);
    return localInAuthManager;
  }

  @Provides
  @Singleton
  LegacyMobileMessageManager provideLegacyMobileMessagingManager(Bus paramBus, PingProvider paramPingProvider)
  {
    return new LegacyMobileMessageManager(this.mApplication, paramBus, paramPingProvider);
  }

  @Provides
  @Singleton
  LocationClient provideLocationClient(@ForCn RestAdapter paramRestAdapter, Bus paramBus, RealtimeRestAdapterBuilder paramRealtimeRestAdapterBuilder, RiderPreferences paramRiderPreferences, SessionPreferences paramSessionPreferences)
  {
    return new LocationClientImpl(paramBus, (LegacyLocationApi)paramRestAdapter.create(LegacyLocationApi.class), (LocationApi)paramRealtimeRestAdapterBuilder.build().create(LocationApi.class), paramRiderPreferences, paramSessionPreferences);
  }

  @Provides
  @Singleton
  RiderLocationProvider provideLocationProvider(Bus paramBus, LocationProvider paramLocationProvider)
  {
    RiderLocationProvider localRiderLocationProvider = new RiderLocationProvider(paramLocationProvider, paramBus);
    localRiderLocationProvider.register();
    return localRiderLocationProvider;
  }

  @Provides
  @Singleton
  MobileAppTracker provideMobileAppTracker()
  {
    String str1 = this.mApplication.getString(2131559287);
    String str2 = this.mApplication.getString(2131559288);
    MobileAppTracker.init(this.mApplication, str1, str2);
    MobileAppTracker localMobileAppTracker = MobileAppTracker.getInstance();
    localMobileAppTracker.setAllowDuplicates(true);
    localMobileAppTracker.setDebugMode(false);
    return localMobileAppTracker;
  }

  @Provides
  @Singleton
  MobileMessageManager provideMobileMessagingManager(Bus paramBus, PingProvider paramPingProvider)
  {
    return new MobileMessageManager(this.mApplication, paramBus, paramPingProvider);
  }

  @Provides
  @Singleton
  PaymentClient providePaymentClient(Bus paramBus, SessionPreferences paramSessionPreferences, RealtimeRestAdapterBuilder paramRealtimeRestAdapterBuilder)
  {
    return new PaymentClient(paramBus, paramSessionPreferences, (PaymentApi)paramRealtimeRestAdapterBuilder.build().create(PaymentApi.class));
  }

  @Provides
  @Named("Ping")
  Class providePingClass()
  {
    return Ping.class;
  }

  @Provides
  @Singleton
  PingProvider providePingProvider(Bus paramBus)
  {
    PingProvider localPingProvider = new PingProvider(paramBus);
    localPingProvider.register();
    return localPingProvider;
  }

  @Provides
  @Singleton
  PushProvider providePushProvider(ExecutorService paramExecutorService)
  {
    return new GcmPushProvider(this.mApplication, paramExecutorService);
  }

  @Provides
  RealtimeRestAdapterBuilder provideRealtimeRestAdapterBuilder(@ForCn UberRetrofitClient paramUberRetrofitClient, @ForApp BuildConfigProxy paramBuildConfigProxy, @ForCn UberEndpoint paramUberEndpoint, Gson paramGson, ExecutorService paramExecutorService, final SessionPreferences paramSessionPreferences)
  {
    return new RealtimeRestAdapterBuilder(paramUberRetrofitClient, paramBuildConfigProxy, paramUberEndpoint, paramExecutorService, paramGson).setUserDataProvider(new RealtimeRestAdapterBuilder.UserDataProvider()
    {
      public String getToken()
      {
        return paramSessionPreferences.getToken();
      }

      public String getUserUuid()
      {
        return paramSessionPreferences.getUserUuid();
      }
    });
  }

  @Provides
  Resources provideResources()
  {
    return this.mApplication.getResources();
  }

  @ForApp
  @Provides
  @Singleton
  BuildConfigProxy provideRiderBuildConfig()
  {
    return new RiderBuildConfig();
  }

  @Provides
  @Singleton
  RiderClient provideRiderClient(Bus paramBus, DispatchClient paramDispatchClient, PingProvider paramPingProvider, RiderLocationProvider paramRiderLocationProvider, RiderPreferences paramRiderPreferences, UberPreferences paramUberPreferences, SessionPreferences paramSessionPreferences, MobileAppTracker paramMobileAppTracker, MobileMessageManager paramMobileMessageManager, InAuthManager paramInAuthManager)
  {
    return new RiderClientImpl(paramBus, this.mApplication, paramDispatchClient, paramPingProvider, paramRiderLocationProvider, paramRiderPreferences, paramUberPreferences, paramSessionPreferences, paramMobileAppTracker, paramMobileMessageManager, paramInAuthManager);
  }

  @Provides
  @Singleton
  RiderMonitoringProperties provideRiderMonitoringProperties(PingProvider paramPingProvider)
  {
    return new RiderMonitoringProperties(paramPingProvider);
  }

  @Provides
  @Singleton
  RiderNotificationManager provideRiderNotificationManager()
  {
    return new RiderNotificationManager(this.mApplication);
  }

  @Provides
  @Singleton
  RiderPushManager provideRiderPushManager(RiderClient paramRiderClient, PushProvider paramPushProvider, RiderPreferences paramRiderPreferences)
  {
    return new RiderPushManager(paramRiderClient, paramPushProvider, paramRiderPreferences);
  }

  @Provides
  @Singleton
  RiderPreferences provideRiderSettings(Gson paramGson)
  {
    SharedPreferences localSharedPreferences = this.mApplication.getSharedPreferences(".rider_preferences", 0);
    return new RiderPreferences(this.mApplication, localSharedPreferences, paramGson);
  }

  @Provides
  @Singleton
  SessionPreferences provideSessionPreferences()
  {
    return new SessionPreferences(this.mApplication.getSharedPreferences(".session", 0));
  }

  @Provides
  @Singleton
  SignupClient provideSignUpClient(Bus paramBus, @ForApp BuildConfigProxy paramBuildConfigProxy, RiderLocationProvider paramRiderLocationProvider, MobileAppTracker paramMobileAppTracker, UberPreferences paramUberPreferences, SignupApi paramSignupApi)
  {
    return new SignupClient(paramBus, this.mApplication, paramBuildConfigProxy, paramSignupApi, paramRiderLocationProvider, paramMobileAppTracker, paramUberPreferences);
  }

  @Provides
  @Singleton
  SignupApi provideSignupApi(@ForCn RestAdapter paramRestAdapter)
  {
    return (SignupApi)paramRestAdapter.create(SignupApi.class);
  }

  @Provides
  @Singleton
  TunesClient provideTunesClient(Bus paramBus, RiderLocationProvider paramRiderLocationProvider, RealtimeRestAdapterBuilder paramRealtimeRestAdapterBuilder)
  {
    return new TunesClient(paramBus, (TunesApi)paramRealtimeRestAdapterBuilder.build().create(TunesApi.class), paramRiderLocationProvider);
  }

  @Provides
  @Singleton
  ExpenseLinkResources providesExpenseLinkResources()
  {
    return new ExpenseLinkResources(this.mApplication);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.module.RiderApplicationModule
 * JD-Core Version:    0.6.2
 */