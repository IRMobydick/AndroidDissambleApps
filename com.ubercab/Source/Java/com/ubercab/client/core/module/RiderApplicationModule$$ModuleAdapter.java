package com.ubercab.client.core.module;

import android.content.Context;
import android.content.res.Resources;
import com.google.gson.Gson;
import com.inauth.mme.InAuthManager;
import com.mobileapptracker.MobileAppTracker;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.otto.Bus;
import com.ubercab.client.core.analytics.AnalyticsManager;
import com.ubercab.client.core.app.RiderPreferences;
import com.ubercab.client.core.content.CachePreferences;
import com.ubercab.client.core.content.PingProvider;
import com.ubercab.client.core.content.RiderLocationProvider;
import com.ubercab.client.core.content.SessionPreferences;
import com.ubercab.client.core.metrics.monitoring.RiderMonitoringProperties;
import com.ubercab.client.core.network.AppConfigClient;
import com.ubercab.client.core.network.LocationClient;
import com.ubercab.client.core.network.PaymentClient;
import com.ubercab.client.core.network.RiderClient;
import com.ubercab.client.core.network.SignupApi;
import com.ubercab.client.core.network.SignupClient;
import com.ubercab.client.core.network.TunesClient;
import com.ubercab.client.core.push.PushProvider;
import com.ubercab.client.core.push.RiderPushManager;
import com.ubercab.client.feature.mobilemessage.LegacyMobileMessageManager;
import com.ubercab.client.feature.mobilemessage.MobileMessageManager;
import com.ubercab.client.feature.notification.RiderNotificationManager;
import com.ubercab.client.feature.payment.expense.ExpenseLinkResources;
import com.ubercab.library.app.BuildConfigProxy;
import com.ubercab.library.app.LifecycleTracker;
import com.ubercab.library.app.UberPreferences;
import com.ubercab.library.location.LocationProvider;
import com.ubercab.library.metrics.analytics.AnalyticsClient;
import com.ubercab.library.metrics.analytics.AnalyticsProperties;
import com.ubercab.library.metrics.analytics.session.UberSessionGenerator;
import com.ubercab.library.network.RealtimeRestAdapterBuilder;
import com.ubercab.library.network.UberEndpoint;
import com.ubercab.library.network.UberRetrofitClient;
import com.ubercab.library.network.dispatch.DispatchClient;
import dagger.internal.Binding;
import dagger.internal.BindingsGroup;
import dagger.internal.Linker;
import dagger.internal.ModuleAdapter;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import javax.inject.Provider;
import retrofit.RestAdapter;

public final class RiderApplicationModule$$ModuleAdapter extends ModuleAdapter<RiderApplicationModule>
{
  private static final Class<?>[] INCLUDES = new Class[0];
  private static final String[] INJECTS = { "members/com.ubercab.client.feature.about.AboutActivity", "members/com.ubercab.client.feature.payment.AddFundsWebViewActivity", "members/com.ubercab.client.feature.music.overlay.AddMusicOverlayView", "members/com.ubercab.client.feature.trip.address.AddressView", "members/com.ubercab.client.feature.trip.confirm.ConfirmationView", "members/com.ubercab.client.core.ui.CountryButton", "members/com.ubercab.client.feature.payment.CreditsAdapter", "members/com.ubercab.client.feature.payment.ExpenseAdapter", "members/com.ubercab.client.feature.employee.EmployeeSettingsActivity", "members/com.ubercab.client.feature.employee.EmployeeSettingsFragment", "members/com.ubercab.client.core.vendor.facebook.FacebookAuthorizationActivity", "members/com.ubercab.client.core.vendor.facebook.FacebookAuthorizationFragment", "members/com.ubercab.client.feature.faresplit.master.FareSplitChipAdapter", "members/com.ubercab.client.feature.faresplit.master.FareSplitClientViewHolder", "members/com.ubercab.client.feature.faresplit.master.FareSplitContactViewHolder", "members/com.ubercab.client.feature.faresplit.master.FareSplitInviteActivity", "members/com.ubercab.client.feature.faresplit.master.FareSplitSummaryAdapter", "members/com.ubercab.client.feature.receipt.FeedbackAdapter", "members/com.ubercab.client.core.ui.FlagButton", "members/com.ubercab.client.feature.forceupgrade.ForceUpgradeFragment", "members/com.ubercab.client.core.vendor.google.gcm.GcmService", "members/com.ubercab.client.feature.launch.LauncherActivity", "members/com.ubercab.client.feature.trip.overlay.LegacyMobileMessageOverlayView", "members/com.ubercab.client.feature.launch.MagicActivity", "members/com.ubercab.client.feature.verification.MobileVerificationActivity", "members/com.ubercab.client.feature.mobilemessage.MobileMessageManager", "members/com.ubercab.client.feature.mobilemessage.MobileMessageModuleContentView", "members/com.ubercab.client.feature.mobilemessage.MobileMessageNativeUrlManager", "members/com.ubercab.client.feature.mobilemessage.MobileMessagePopupWindow", "members/com.ubercab.client.core.ui.MonthEditText", "members/com.ubercab.client.feature.music.MusicProviderAuthorizationActivity", "members/com.ubercab.client.feature.music.MusicProviderAuthorizationFragment", "members/com.ubercab.client.feature.music.MusicProviderOfferFragment", "members/com.ubercab.client.feature.music.MusicTrayView", "members/com.ubercab.client.core.app.NetworkErrorFragment", "members/com.ubercab.client.feature.trip.overlay.NoLocationOverlayView", "members/com.ubercab.client.feature.notification.NotificationActionReceiver", "members/com.ubercab.client.feature.notification.NotificationPainter", "members/com.ubercab.client.feature.onboarding.OnBoardingFragment", "members/com.ubercab.client.feature.onboarding.OnboardingActivity", "members/com.ubercab.client.feature.payment.PaymentFooterView", "members/com.ubercab.client.feature.payment.PaymentOtpActivity", "members/com.ubercab.client.core.ui.PaymentTextView", "members/com.ubercab.client.feature.payment.PaymentWalletConfirmationFragment", "members/com.ubercab.client.feature.profile.ProfileActivity", "members/com.ubercab.client.feature.promo.PromoActivity", "members/com.ubercab.client.core.app.RiderApplication", "members/com.ubercab.client.core.app.RiderService", "members/com.ubercab.client.feature.share.ShareActivity", "members/com.ubercab.client.feature.eta.ShareEtaActivity", "members/com.ubercab.client.feature.signin.SignInActivity", "members/com.ubercab.client.feature.signin.SignInFragment", "members/com.ubercab.client.core.ui.TripEtaPinPainter", "members/com.ubercab.client.feature.trip.slider.VehicleSeekBar", "members/com.ubercab.client.feature.trip.slider.VehicleSlider", "members/com.ubercab.webclient.app.WebClientActivity", "members/com.ubercab.client.core.ui.YearEditText" };
  private static final Class<?>[] STATIC_INJECTIONS = new Class[0];

  public RiderApplicationModule$$ModuleAdapter()
  {
    super(RiderApplicationModule.class, INJECTS, STATIC_INJECTIONS, false, INCLUDES, true, true);
  }

  public void getBindings(BindingsGroup paramBindingsGroup, RiderApplicationModule paramRiderApplicationModule)
  {
    paramBindingsGroup.contributeProvidesBinding("android.content.Context", new ProvideContextProvidesAdapter(paramRiderApplicationModule));
    paramBindingsGroup.contributeProvidesBinding("com.ubercab.library.metrics.analytics.AnalyticsProperties", new ProvideAnalyticsPropertiesProvidesAdapter(paramRiderApplicationModule));
    paramBindingsGroup.contributeProvidesBinding("com.ubercab.library.metrics.analytics.session.UberSessionGenerator", new ProvideAnalyticsSessionProvidesAdapter(paramRiderApplicationModule));
    paramBindingsGroup.contributeProvidesBinding("com.ubercab.client.core.analytics.AnalyticsManager", new ProvideAnalyticsManagerProvidesAdapter(paramRiderApplicationModule));
    paramBindingsGroup.contributeProvidesBinding("com.ubercab.client.core.network.AppConfigClient", new ProvideAppConfigClientProvidesAdapter(paramRiderApplicationModule));
    paramBindingsGroup.contributeProvidesBinding("android.content.res.Resources", new ProvideResourcesProvidesAdapter(paramRiderApplicationModule));
    paramBindingsGroup.contributeProvidesBinding("@javax.inject.Named(value=Ping)/java.lang.Class", new ProvidePingClassProvidesAdapter(paramRiderApplicationModule));
    paramBindingsGroup.contributeProvidesBinding("com.ubercab.client.core.content.SessionPreferences", new ProvideSessionPreferencesProvidesAdapter(paramRiderApplicationModule));
    paramBindingsGroup.contributeProvidesBinding("com.ubercab.client.core.content.CachePreferences", new ProvideCacheProvidesAdapter(paramRiderApplicationModule));
    paramBindingsGroup.contributeProvidesBinding("com.ubercab.client.core.app.RiderPreferences", new ProvideRiderSettingsProvidesAdapter(paramRiderApplicationModule));
    paramBindingsGroup.contributeProvidesBinding("com.ubercab.client.core.content.PingProvider", new ProvidePingProviderProvidesAdapter(paramRiderApplicationModule));
    paramBindingsGroup.contributeProvidesBinding("com.ubercab.client.feature.payment.expense.ExpenseLinkResources", new ProvidesExpenseLinkResourcesProvidesAdapter(paramRiderApplicationModule));
    paramBindingsGroup.contributeProvidesBinding("com.ubercab.client.core.content.RiderLocationProvider", new ProvideLocationProviderProvidesAdapter(paramRiderApplicationModule));
    paramBindingsGroup.contributeProvidesBinding("@com.ubercab.library.app.annotation.ForApp()/com.ubercab.library.app.BuildConfigProxy", new ProvideRiderBuildConfigProvidesAdapter(paramRiderApplicationModule));
    paramBindingsGroup.contributeProvidesBinding("com.mobileapptracker.MobileAppTracker", new ProvideMobileAppTrackerProvidesAdapter(paramRiderApplicationModule));
    paramBindingsGroup.contributeProvidesBinding("com.ubercab.library.network.RealtimeRestAdapterBuilder", new ProvideRealtimeRestAdapterBuilderProvidesAdapter(paramRiderApplicationModule));
    paramBindingsGroup.contributeProvidesBinding("com.ubercab.client.core.network.RiderClient", new ProvideRiderClientProvidesAdapter(paramRiderApplicationModule));
    paramBindingsGroup.contributeProvidesBinding("com.ubercab.client.core.network.SignupApi", new ProvideSignupApiProvidesAdapter(paramRiderApplicationModule));
    paramBindingsGroup.contributeProvidesBinding("com.ubercab.client.core.network.SignupClient", new ProvideSignUpClientProvidesAdapter(paramRiderApplicationModule));
    paramBindingsGroup.contributeProvidesBinding("com.ubercab.client.core.network.PaymentClient", new ProvidePaymentClientProvidesAdapter(paramRiderApplicationModule));
    paramBindingsGroup.contributeProvidesBinding("com.ubercab.client.core.network.LocationClient", new ProvideLocationClientProvidesAdapter(paramRiderApplicationModule));
    paramBindingsGroup.contributeProvidesBinding("com.ubercab.client.core.network.TunesClient", new ProvideTunesClientProvidesAdapter(paramRiderApplicationModule));
    paramBindingsGroup.contributeProvidesBinding("com.ubercab.client.core.push.PushProvider", new ProvidePushProviderProvidesAdapter(paramRiderApplicationModule));
    paramBindingsGroup.contributeProvidesBinding("com.ubercab.client.core.metrics.monitoring.RiderMonitoringProperties", new ProvideRiderMonitoringPropertiesProvidesAdapter(paramRiderApplicationModule));
    paramBindingsGroup.contributeProvidesBinding("com.ubercab.client.core.push.RiderPushManager", new ProvideRiderPushManagerProvidesAdapter(paramRiderApplicationModule));
    paramBindingsGroup.contributeProvidesBinding("com.ubercab.client.feature.notification.RiderNotificationManager", new ProvideRiderNotificationManagerProvidesAdapter(paramRiderApplicationModule));
    paramBindingsGroup.contributeProvidesBinding("com.ubercab.client.feature.mobilemessage.LegacyMobileMessageManager", new ProvideLegacyMobileMessagingManagerProvidesAdapter(paramRiderApplicationModule));
    paramBindingsGroup.contributeProvidesBinding("com.ubercab.client.feature.mobilemessage.MobileMessageManager", new ProvideMobileMessagingManagerProvidesAdapter(paramRiderApplicationModule));
    paramBindingsGroup.contributeProvidesBinding("com.inauth.mme.InAuthManager", new ProvideInAuthManagerProvidesAdapter(paramRiderApplicationModule));
  }

  public static final class ProvideAnalyticsManagerProvidesAdapter extends ProvidesBinding<AnalyticsManager>
    implements Provider<AnalyticsManager>
  {
    private final RiderApplicationModule module;
    private Binding<OkHttpClient> okHttpClient;
    private Binding<RiderLocationProvider> provider;
    private Binding<UberSessionGenerator> sessionGenerator;
    private Binding<SessionPreferences> sessionPreferences;

    public ProvideAnalyticsManagerProvidesAdapter(RiderApplicationModule paramRiderApplicationModule)
    {
      super(true, "com.ubercab.client.core.module.RiderApplicationModule", "provideAnalyticsManager");
      this.module = paramRiderApplicationModule;
      setLibrary(true);
    }

    public void attach(Linker paramLinker)
    {
      this.sessionPreferences = paramLinker.requestBinding("com.ubercab.client.core.content.SessionPreferences", RiderApplicationModule.class, getClass().getClassLoader());
      this.provider = paramLinker.requestBinding("com.ubercab.client.core.content.RiderLocationProvider", RiderApplicationModule.class, getClass().getClassLoader());
      this.okHttpClient = paramLinker.requestBinding("com.squareup.okhttp.OkHttpClient", RiderApplicationModule.class, getClass().getClassLoader());
      this.sessionGenerator = paramLinker.requestBinding("com.ubercab.library.metrics.analytics.session.UberSessionGenerator", RiderApplicationModule.class, getClass().getClassLoader());
    }

    public AnalyticsManager get()
    {
      return this.module.provideAnalyticsManager((SessionPreferences)this.sessionPreferences.get(), (RiderLocationProvider)this.provider.get(), (OkHttpClient)this.okHttpClient.get(), (UberSessionGenerator)this.sessionGenerator.get());
    }

    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(this.sessionPreferences);
      paramSet1.add(this.provider);
      paramSet1.add(this.okHttpClient);
      paramSet1.add(this.sessionGenerator);
    }
  }

  public static final class ProvideAnalyticsPropertiesProvidesAdapter extends ProvidesBinding<AnalyticsProperties>
    implements Provider<AnalyticsProperties>
  {
    private Binding<Bus> bus;
    private Binding<Gson> gson;
    private final RiderApplicationModule module;
    private Binding<PingProvider> pingProvider;
    private Binding<SessionPreferences> sessionPreferences;

    public ProvideAnalyticsPropertiesProvidesAdapter(RiderApplicationModule paramRiderApplicationModule)
    {
      super(true, "com.ubercab.client.core.module.RiderApplicationModule", "provideAnalyticsProperties");
      this.module = paramRiderApplicationModule;
      setLibrary(true);
    }

    public void attach(Linker paramLinker)
    {
      this.bus = paramLinker.requestBinding("com.squareup.otto.Bus", RiderApplicationModule.class, getClass().getClassLoader());
      this.sessionPreferences = paramLinker.requestBinding("com.ubercab.client.core.content.SessionPreferences", RiderApplicationModule.class, getClass().getClassLoader());
      this.gson = paramLinker.requestBinding("com.google.gson.Gson", RiderApplicationModule.class, getClass().getClassLoader());
      this.pingProvider = paramLinker.requestBinding("com.ubercab.client.core.content.PingProvider", RiderApplicationModule.class, getClass().getClassLoader());
    }

    public AnalyticsProperties get()
    {
      return this.module.provideAnalyticsProperties((Bus)this.bus.get(), (SessionPreferences)this.sessionPreferences.get(), (Gson)this.gson.get(), (PingProvider)this.pingProvider.get());
    }

    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(this.bus);
      paramSet1.add(this.sessionPreferences);
      paramSet1.add(this.gson);
      paramSet1.add(this.pingProvider);
    }
  }

  public static final class ProvideAnalyticsSessionProvidesAdapter extends ProvidesBinding<UberSessionGenerator>
    implements Provider<UberSessionGenerator>
  {
    private Binding<AnalyticsClient> analyticsClient;
    private Binding<LifecycleTracker> lifecycleTracker;
    private final RiderApplicationModule module;
    private Binding<UberPreferences> uberPreferences;

    public ProvideAnalyticsSessionProvidesAdapter(RiderApplicationModule paramRiderApplicationModule)
    {
      super(true, "com.ubercab.client.core.module.RiderApplicationModule", "provideAnalyticsSession");
      this.module = paramRiderApplicationModule;
      setLibrary(true);
    }

    public void attach(Linker paramLinker)
    {
      this.analyticsClient = paramLinker.requestBinding("com.ubercab.library.metrics.analytics.AnalyticsClient", RiderApplicationModule.class, getClass().getClassLoader());
      this.lifecycleTracker = paramLinker.requestBinding("com.ubercab.library.app.LifecycleTracker", RiderApplicationModule.class, getClass().getClassLoader());
      this.uberPreferences = paramLinker.requestBinding("com.ubercab.library.app.UberPreferences", RiderApplicationModule.class, getClass().getClassLoader());
    }

    public UberSessionGenerator get()
    {
      return this.module.provideAnalyticsSession((AnalyticsClient)this.analyticsClient.get(), (LifecycleTracker)this.lifecycleTracker.get(), (UberPreferences)this.uberPreferences.get());
    }

    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(this.analyticsClient);
      paramSet1.add(this.lifecycleTracker);
      paramSet1.add(this.uberPreferences);
    }
  }

  public static final class ProvideAppConfigClientProvidesAdapter extends ProvidesBinding<AppConfigClient>
    implements Provider<AppConfigClient>
  {
    private Binding<Bus> bus;
    private final RiderApplicationModule module;
    private Binding<RealtimeRestAdapterBuilder> restAdapterBuilder;
    private Binding<RiderPreferences> riderPreferences;

    public ProvideAppConfigClientProvidesAdapter(RiderApplicationModule paramRiderApplicationModule)
    {
      super(true, "com.ubercab.client.core.module.RiderApplicationModule", "provideAppConfigClient");
      this.module = paramRiderApplicationModule;
      setLibrary(true);
    }

    public void attach(Linker paramLinker)
    {
      this.bus = paramLinker.requestBinding("com.squareup.otto.Bus", RiderApplicationModule.class, getClass().getClassLoader());
      this.restAdapterBuilder = paramLinker.requestBinding("com.ubercab.library.network.RealtimeRestAdapterBuilder", RiderApplicationModule.class, getClass().getClassLoader());
      this.riderPreferences = paramLinker.requestBinding("com.ubercab.client.core.app.RiderPreferences", RiderApplicationModule.class, getClass().getClassLoader());
    }

    public AppConfigClient get()
    {
      return this.module.provideAppConfigClient((Bus)this.bus.get(), (RealtimeRestAdapterBuilder)this.restAdapterBuilder.get(), (RiderPreferences)this.riderPreferences.get());
    }

    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(this.bus);
      paramSet1.add(this.restAdapterBuilder);
      paramSet1.add(this.riderPreferences);
    }
  }

  public static final class ProvideCacheProvidesAdapter extends ProvidesBinding<CachePreferences>
    implements Provider<CachePreferences>
  {
    private Binding<Gson> gson;
    private final RiderApplicationModule module;

    public ProvideCacheProvidesAdapter(RiderApplicationModule paramRiderApplicationModule)
    {
      super(true, "com.ubercab.client.core.module.RiderApplicationModule", "provideCache");
      this.module = paramRiderApplicationModule;
      setLibrary(true);
    }

    public void attach(Linker paramLinker)
    {
      this.gson = paramLinker.requestBinding("com.google.gson.Gson", RiderApplicationModule.class, getClass().getClassLoader());
    }

    public CachePreferences get()
    {
      return this.module.provideCache((Gson)this.gson.get());
    }

    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(this.gson);
    }
  }

  public static final class ProvideContextProvidesAdapter extends ProvidesBinding<Context>
    implements Provider<Context>
  {
    private final RiderApplicationModule module;

    public ProvideContextProvidesAdapter(RiderApplicationModule paramRiderApplicationModule)
    {
      super(false, "com.ubercab.client.core.module.RiderApplicationModule", "provideContext");
      this.module = paramRiderApplicationModule;
      setLibrary(true);
    }

    public Context get()
    {
      return this.module.provideContext();
    }
  }

  public static final class ProvideInAuthManagerProvidesAdapter extends ProvidesBinding<InAuthManager>
    implements Provider<InAuthManager>
  {
    private final RiderApplicationModule module;

    public ProvideInAuthManagerProvidesAdapter(RiderApplicationModule paramRiderApplicationModule)
    {
      super(true, "com.ubercab.client.core.module.RiderApplicationModule", "provideInAuthManager");
      this.module = paramRiderApplicationModule;
      setLibrary(true);
    }

    public InAuthManager get()
    {
      return this.module.provideInAuthManager();
    }
  }

  public static final class ProvideLegacyMobileMessagingManagerProvidesAdapter extends ProvidesBinding<LegacyMobileMessageManager>
    implements Provider<LegacyMobileMessageManager>
  {
    private Binding<Bus> bus;
    private final RiderApplicationModule module;
    private Binding<PingProvider> pingProvider;

    public ProvideLegacyMobileMessagingManagerProvidesAdapter(RiderApplicationModule paramRiderApplicationModule)
    {
      super(true, "com.ubercab.client.core.module.RiderApplicationModule", "provideLegacyMobileMessagingManager");
      this.module = paramRiderApplicationModule;
      setLibrary(true);
    }

    public void attach(Linker paramLinker)
    {
      this.bus = paramLinker.requestBinding("com.squareup.otto.Bus", RiderApplicationModule.class, getClass().getClassLoader());
      this.pingProvider = paramLinker.requestBinding("com.ubercab.client.core.content.PingProvider", RiderApplicationModule.class, getClass().getClassLoader());
    }

    public LegacyMobileMessageManager get()
    {
      return this.module.provideLegacyMobileMessagingManager((Bus)this.bus.get(), (PingProvider)this.pingProvider.get());
    }

    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(this.bus);
      paramSet1.add(this.pingProvider);
    }
  }

  public static final class ProvideLocationClientProvidesAdapter extends ProvidesBinding<LocationClient>
    implements Provider<LocationClient>
  {
    private Binding<Bus> bus;
    private final RiderApplicationModule module;
    private Binding<RealtimeRestAdapterBuilder> realtimeRestAdapterBuilder;
    private Binding<RestAdapter> restAdapter;
    private Binding<RiderPreferences> riderPreferences;
    private Binding<SessionPreferences> session;

    public ProvideLocationClientProvidesAdapter(RiderApplicationModule paramRiderApplicationModule)
    {
      super(true, "com.ubercab.client.core.module.RiderApplicationModule", "provideLocationClient");
      this.module = paramRiderApplicationModule;
      setLibrary(true);
    }

    public void attach(Linker paramLinker)
    {
      this.restAdapter = paramLinker.requestBinding("@com.ubercab.library.app.annotation.ForCn()/retrofit.RestAdapter", RiderApplicationModule.class, getClass().getClassLoader());
      this.bus = paramLinker.requestBinding("com.squareup.otto.Bus", RiderApplicationModule.class, getClass().getClassLoader());
      this.realtimeRestAdapterBuilder = paramLinker.requestBinding("com.ubercab.library.network.RealtimeRestAdapterBuilder", RiderApplicationModule.class, getClass().getClassLoader());
      this.riderPreferences = paramLinker.requestBinding("com.ubercab.client.core.app.RiderPreferences", RiderApplicationModule.class, getClass().getClassLoader());
      this.session = paramLinker.requestBinding("com.ubercab.client.core.content.SessionPreferences", RiderApplicationModule.class, getClass().getClassLoader());
    }

    public LocationClient get()
    {
      return this.module.provideLocationClient((RestAdapter)this.restAdapter.get(), (Bus)this.bus.get(), (RealtimeRestAdapterBuilder)this.realtimeRestAdapterBuilder.get(), (RiderPreferences)this.riderPreferences.get(), (SessionPreferences)this.session.get());
    }

    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(this.restAdapter);
      paramSet1.add(this.bus);
      paramSet1.add(this.realtimeRestAdapterBuilder);
      paramSet1.add(this.riderPreferences);
      paramSet1.add(this.session);
    }
  }

  public static final class ProvideLocationProviderProvidesAdapter extends ProvidesBinding<RiderLocationProvider>
    implements Provider<RiderLocationProvider>
  {
    private Binding<Bus> bus;
    private Binding<LocationProvider> locationProvider;
    private final RiderApplicationModule module;

    public ProvideLocationProviderProvidesAdapter(RiderApplicationModule paramRiderApplicationModule)
    {
      super(true, "com.ubercab.client.core.module.RiderApplicationModule", "provideLocationProvider");
      this.module = paramRiderApplicationModule;
      setLibrary(true);
    }

    public void attach(Linker paramLinker)
    {
      this.bus = paramLinker.requestBinding("com.squareup.otto.Bus", RiderApplicationModule.class, getClass().getClassLoader());
      this.locationProvider = paramLinker.requestBinding("com.ubercab.library.location.LocationProvider", RiderApplicationModule.class, getClass().getClassLoader());
    }

    public RiderLocationProvider get()
    {
      return this.module.provideLocationProvider((Bus)this.bus.get(), (LocationProvider)this.locationProvider.get());
    }

    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(this.bus);
      paramSet1.add(this.locationProvider);
    }
  }

  public static final class ProvideMobileAppTrackerProvidesAdapter extends ProvidesBinding<MobileAppTracker>
    implements Provider<MobileAppTracker>
  {
    private final RiderApplicationModule module;

    public ProvideMobileAppTrackerProvidesAdapter(RiderApplicationModule paramRiderApplicationModule)
    {
      super(true, "com.ubercab.client.core.module.RiderApplicationModule", "provideMobileAppTracker");
      this.module = paramRiderApplicationModule;
      setLibrary(true);
    }

    public MobileAppTracker get()
    {
      return this.module.provideMobileAppTracker();
    }
  }

  public static final class ProvideMobileMessagingManagerProvidesAdapter extends ProvidesBinding<MobileMessageManager>
    implements Provider<MobileMessageManager>
  {
    private Binding<Bus> bus;
    private final RiderApplicationModule module;
    private Binding<PingProvider> pingProvider;

    public ProvideMobileMessagingManagerProvidesAdapter(RiderApplicationModule paramRiderApplicationModule)
    {
      super(true, "com.ubercab.client.core.module.RiderApplicationModule", "provideMobileMessagingManager");
      this.module = paramRiderApplicationModule;
      setLibrary(true);
    }

    public void attach(Linker paramLinker)
    {
      this.bus = paramLinker.requestBinding("com.squareup.otto.Bus", RiderApplicationModule.class, getClass().getClassLoader());
      this.pingProvider = paramLinker.requestBinding("com.ubercab.client.core.content.PingProvider", RiderApplicationModule.class, getClass().getClassLoader());
    }

    public MobileMessageManager get()
    {
      return this.module.provideMobileMessagingManager((Bus)this.bus.get(), (PingProvider)this.pingProvider.get());
    }

    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(this.bus);
      paramSet1.add(this.pingProvider);
    }
  }

  public static final class ProvidePaymentClientProvidesAdapter extends ProvidesBinding<PaymentClient>
    implements Provider<PaymentClient>
  {
    private Binding<Bus> bus;
    private final RiderApplicationModule module;
    private Binding<RealtimeRestAdapterBuilder> restAdapterBuilder;
    private Binding<SessionPreferences> sessionPreferences;

    public ProvidePaymentClientProvidesAdapter(RiderApplicationModule paramRiderApplicationModule)
    {
      super(true, "com.ubercab.client.core.module.RiderApplicationModule", "providePaymentClient");
      this.module = paramRiderApplicationModule;
      setLibrary(true);
    }

    public void attach(Linker paramLinker)
    {
      this.bus = paramLinker.requestBinding("com.squareup.otto.Bus", RiderApplicationModule.class, getClass().getClassLoader());
      this.sessionPreferences = paramLinker.requestBinding("com.ubercab.client.core.content.SessionPreferences", RiderApplicationModule.class, getClass().getClassLoader());
      this.restAdapterBuilder = paramLinker.requestBinding("com.ubercab.library.network.RealtimeRestAdapterBuilder", RiderApplicationModule.class, getClass().getClassLoader());
    }

    public PaymentClient get()
    {
      return this.module.providePaymentClient((Bus)this.bus.get(), (SessionPreferences)this.sessionPreferences.get(), (RealtimeRestAdapterBuilder)this.restAdapterBuilder.get());
    }

    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(this.bus);
      paramSet1.add(this.sessionPreferences);
      paramSet1.add(this.restAdapterBuilder);
    }
  }

  public static final class ProvidePingClassProvidesAdapter extends ProvidesBinding<Class>
    implements Provider<Class>
  {
    private final RiderApplicationModule module;

    public ProvidePingClassProvidesAdapter(RiderApplicationModule paramRiderApplicationModule)
    {
      super(false, "com.ubercab.client.core.module.RiderApplicationModule", "providePingClass");
      this.module = paramRiderApplicationModule;
      setLibrary(true);
    }

    public Class get()
    {
      return this.module.providePingClass();
    }
  }

  public static final class ProvidePingProviderProvidesAdapter extends ProvidesBinding<PingProvider>
    implements Provider<PingProvider>
  {
    private Binding<Bus> bus;
    private final RiderApplicationModule module;

    public ProvidePingProviderProvidesAdapter(RiderApplicationModule paramRiderApplicationModule)
    {
      super(true, "com.ubercab.client.core.module.RiderApplicationModule", "providePingProvider");
      this.module = paramRiderApplicationModule;
      setLibrary(true);
    }

    public void attach(Linker paramLinker)
    {
      this.bus = paramLinker.requestBinding("com.squareup.otto.Bus", RiderApplicationModule.class, getClass().getClassLoader());
    }

    public PingProvider get()
    {
      return this.module.providePingProvider((Bus)this.bus.get());
    }

    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(this.bus);
    }
  }

  public static final class ProvidePushProviderProvidesAdapter extends ProvidesBinding<PushProvider>
    implements Provider<PushProvider>
  {
    private Binding<ExecutorService> executorService;
    private final RiderApplicationModule module;

    public ProvidePushProviderProvidesAdapter(RiderApplicationModule paramRiderApplicationModule)
    {
      super(true, "com.ubercab.client.core.module.RiderApplicationModule", "providePushProvider");
      this.module = paramRiderApplicationModule;
      setLibrary(true);
    }

    public void attach(Linker paramLinker)
    {
      this.executorService = paramLinker.requestBinding("java.util.concurrent.ExecutorService", RiderApplicationModule.class, getClass().getClassLoader());
    }

    public PushProvider get()
    {
      return this.module.providePushProvider((ExecutorService)this.executorService.get());
    }

    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(this.executorService);
    }
  }

  public static final class ProvideRealtimeRestAdapterBuilderProvidesAdapter extends ProvidesBinding<RealtimeRestAdapterBuilder>
    implements Provider<RealtimeRestAdapterBuilder>
  {
    private Binding<BuildConfigProxy> buildConfig;
    private Binding<ExecutorService> executorService;
    private Binding<Gson> gson;
    private final RiderApplicationModule module;
    private Binding<SessionPreferences> sessionPreferences;
    private Binding<UberEndpoint> uberEndpoint;
    private Binding<UberRetrofitClient> uberRetrofitClient;

    public ProvideRealtimeRestAdapterBuilderProvidesAdapter(RiderApplicationModule paramRiderApplicationModule)
    {
      super(false, "com.ubercab.client.core.module.RiderApplicationModule", "provideRealtimeRestAdapterBuilder");
      this.module = paramRiderApplicationModule;
      setLibrary(true);
    }

    public void attach(Linker paramLinker)
    {
      this.uberRetrofitClient = paramLinker.requestBinding("@com.ubercab.library.app.annotation.ForCn()/com.ubercab.library.network.UberRetrofitClient", RiderApplicationModule.class, getClass().getClassLoader());
      this.buildConfig = paramLinker.requestBinding("@com.ubercab.library.app.annotation.ForApp()/com.ubercab.library.app.BuildConfigProxy", RiderApplicationModule.class, getClass().getClassLoader());
      this.uberEndpoint = paramLinker.requestBinding("@com.ubercab.library.app.annotation.ForCn()/com.ubercab.library.network.UberEndpoint", RiderApplicationModule.class, getClass().getClassLoader());
      this.gson = paramLinker.requestBinding("com.google.gson.Gson", RiderApplicationModule.class, getClass().getClassLoader());
      this.executorService = paramLinker.requestBinding("java.util.concurrent.ExecutorService", RiderApplicationModule.class, getClass().getClassLoader());
      this.sessionPreferences = paramLinker.requestBinding("com.ubercab.client.core.content.SessionPreferences", RiderApplicationModule.class, getClass().getClassLoader());
    }

    public RealtimeRestAdapterBuilder get()
    {
      return this.module.provideRealtimeRestAdapterBuilder((UberRetrofitClient)this.uberRetrofitClient.get(), (BuildConfigProxy)this.buildConfig.get(), (UberEndpoint)this.uberEndpoint.get(), (Gson)this.gson.get(), (ExecutorService)this.executorService.get(), (SessionPreferences)this.sessionPreferences.get());
    }

    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(this.uberRetrofitClient);
      paramSet1.add(this.buildConfig);
      paramSet1.add(this.uberEndpoint);
      paramSet1.add(this.gson);
      paramSet1.add(this.executorService);
      paramSet1.add(this.sessionPreferences);
    }
  }

  public static final class ProvideResourcesProvidesAdapter extends ProvidesBinding<Resources>
    implements Provider<Resources>
  {
    private final RiderApplicationModule module;

    public ProvideResourcesProvidesAdapter(RiderApplicationModule paramRiderApplicationModule)
    {
      super(false, "com.ubercab.client.core.module.RiderApplicationModule", "provideResources");
      this.module = paramRiderApplicationModule;
      setLibrary(true);
    }

    public Resources get()
    {
      return this.module.provideResources();
    }
  }

  public static final class ProvideRiderBuildConfigProvidesAdapter extends ProvidesBinding<BuildConfigProxy>
    implements Provider<BuildConfigProxy>
  {
    private final RiderApplicationModule module;

    public ProvideRiderBuildConfigProvidesAdapter(RiderApplicationModule paramRiderApplicationModule)
    {
      super(true, "com.ubercab.client.core.module.RiderApplicationModule", "provideRiderBuildConfig");
      this.module = paramRiderApplicationModule;
      setLibrary(true);
    }

    public BuildConfigProxy get()
    {
      return this.module.provideRiderBuildConfig();
    }
  }

  public static final class ProvideRiderClientProvidesAdapter extends ProvidesBinding<RiderClient>
    implements Provider<RiderClient>
  {
    private Binding<Bus> bus;
    private Binding<DispatchClient> dispatchClient;
    private Binding<InAuthManager> inAuthManager;
    private Binding<RiderLocationProvider> locationProvider;
    private Binding<MobileAppTracker> mobileAppTracker;
    private Binding<MobileMessageManager> mobileMessageManager;
    private final RiderApplicationModule module;
    private Binding<PingProvider> pingProvider;
    private Binding<RiderPreferences> riderPreferences;
    private Binding<SessionPreferences> sessionPreferenes;
    private Binding<UberPreferences> uberPreferences;

    public ProvideRiderClientProvidesAdapter(RiderApplicationModule paramRiderApplicationModule)
    {
      super(true, "com.ubercab.client.core.module.RiderApplicationModule", "provideRiderClient");
      this.module = paramRiderApplicationModule;
      setLibrary(true);
    }

    public void attach(Linker paramLinker)
    {
      this.bus = paramLinker.requestBinding("com.squareup.otto.Bus", RiderApplicationModule.class, getClass().getClassLoader());
      this.dispatchClient = paramLinker.requestBinding("com.ubercab.library.network.dispatch.DispatchClient", RiderApplicationModule.class, getClass().getClassLoader());
      this.pingProvider = paramLinker.requestBinding("com.ubercab.client.core.content.PingProvider", RiderApplicationModule.class, getClass().getClassLoader());
      this.locationProvider = paramLinker.requestBinding("com.ubercab.client.core.content.RiderLocationProvider", RiderApplicationModule.class, getClass().getClassLoader());
      this.riderPreferences = paramLinker.requestBinding("com.ubercab.client.core.app.RiderPreferences", RiderApplicationModule.class, getClass().getClassLoader());
      this.uberPreferences = paramLinker.requestBinding("com.ubercab.library.app.UberPreferences", RiderApplicationModule.class, getClass().getClassLoader());
      this.sessionPreferenes = paramLinker.requestBinding("com.ubercab.client.core.content.SessionPreferences", RiderApplicationModule.class, getClass().getClassLoader());
      this.mobileAppTracker = paramLinker.requestBinding("com.mobileapptracker.MobileAppTracker", RiderApplicationModule.class, getClass().getClassLoader());
      this.mobileMessageManager = paramLinker.requestBinding("com.ubercab.client.feature.mobilemessage.MobileMessageManager", RiderApplicationModule.class, getClass().getClassLoader());
      this.inAuthManager = paramLinker.requestBinding("com.inauth.mme.InAuthManager", RiderApplicationModule.class, getClass().getClassLoader());
    }

    public RiderClient get()
    {
      return this.module.provideRiderClient((Bus)this.bus.get(), (DispatchClient)this.dispatchClient.get(), (PingProvider)this.pingProvider.get(), (RiderLocationProvider)this.locationProvider.get(), (RiderPreferences)this.riderPreferences.get(), (UberPreferences)this.uberPreferences.get(), (SessionPreferences)this.sessionPreferenes.get(), (MobileAppTracker)this.mobileAppTracker.get(), (MobileMessageManager)this.mobileMessageManager.get(), (InAuthManager)this.inAuthManager.get());
    }

    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(this.bus);
      paramSet1.add(this.dispatchClient);
      paramSet1.add(this.pingProvider);
      paramSet1.add(this.locationProvider);
      paramSet1.add(this.riderPreferences);
      paramSet1.add(this.uberPreferences);
      paramSet1.add(this.sessionPreferenes);
      paramSet1.add(this.mobileAppTracker);
      paramSet1.add(this.mobileMessageManager);
      paramSet1.add(this.inAuthManager);
    }
  }

  public static final class ProvideRiderMonitoringPropertiesProvidesAdapter extends ProvidesBinding<RiderMonitoringProperties>
    implements Provider<RiderMonitoringProperties>
  {
    private final RiderApplicationModule module;
    private Binding<PingProvider> pingProvider;

    public ProvideRiderMonitoringPropertiesProvidesAdapter(RiderApplicationModule paramRiderApplicationModule)
    {
      super(true, "com.ubercab.client.core.module.RiderApplicationModule", "provideRiderMonitoringProperties");
      this.module = paramRiderApplicationModule;
      setLibrary(true);
    }

    public void attach(Linker paramLinker)
    {
      this.pingProvider = paramLinker.requestBinding("com.ubercab.client.core.content.PingProvider", RiderApplicationModule.class, getClass().getClassLoader());
    }

    public RiderMonitoringProperties get()
    {
      return this.module.provideRiderMonitoringProperties((PingProvider)this.pingProvider.get());
    }

    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(this.pingProvider);
    }
  }

  public static final class ProvideRiderNotificationManagerProvidesAdapter extends ProvidesBinding<RiderNotificationManager>
    implements Provider<RiderNotificationManager>
  {
    private final RiderApplicationModule module;

    public ProvideRiderNotificationManagerProvidesAdapter(RiderApplicationModule paramRiderApplicationModule)
    {
      super(true, "com.ubercab.client.core.module.RiderApplicationModule", "provideRiderNotificationManager");
      this.module = paramRiderApplicationModule;
      setLibrary(true);
    }

    public RiderNotificationManager get()
    {
      return this.module.provideRiderNotificationManager();
    }
  }

  public static final class ProvideRiderPushManagerProvidesAdapter extends ProvidesBinding<RiderPushManager>
    implements Provider<RiderPushManager>
  {
    private final RiderApplicationModule module;
    private Binding<RiderPreferences> preferences;
    private Binding<PushProvider> pushProvider;
    private Binding<RiderClient> riderClient;

    public ProvideRiderPushManagerProvidesAdapter(RiderApplicationModule paramRiderApplicationModule)
    {
      super(true, "com.ubercab.client.core.module.RiderApplicationModule", "provideRiderPushManager");
      this.module = paramRiderApplicationModule;
      setLibrary(true);
    }

    public void attach(Linker paramLinker)
    {
      this.riderClient = paramLinker.requestBinding("com.ubercab.client.core.network.RiderClient", RiderApplicationModule.class, getClass().getClassLoader());
      this.pushProvider = paramLinker.requestBinding("com.ubercab.client.core.push.PushProvider", RiderApplicationModule.class, getClass().getClassLoader());
      this.preferences = paramLinker.requestBinding("com.ubercab.client.core.app.RiderPreferences", RiderApplicationModule.class, getClass().getClassLoader());
    }

    public RiderPushManager get()
    {
      return this.module.provideRiderPushManager((RiderClient)this.riderClient.get(), (PushProvider)this.pushProvider.get(), (RiderPreferences)this.preferences.get());
    }

    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(this.riderClient);
      paramSet1.add(this.pushProvider);
      paramSet1.add(this.preferences);
    }
  }

  public static final class ProvideRiderSettingsProvidesAdapter extends ProvidesBinding<RiderPreferences>
    implements Provider<RiderPreferences>
  {
    private Binding<Gson> gson;
    private final RiderApplicationModule module;

    public ProvideRiderSettingsProvidesAdapter(RiderApplicationModule paramRiderApplicationModule)
    {
      super(true, "com.ubercab.client.core.module.RiderApplicationModule", "provideRiderSettings");
      this.module = paramRiderApplicationModule;
      setLibrary(true);
    }

    public void attach(Linker paramLinker)
    {
      this.gson = paramLinker.requestBinding("com.google.gson.Gson", RiderApplicationModule.class, getClass().getClassLoader());
    }

    public RiderPreferences get()
    {
      return this.module.provideRiderSettings((Gson)this.gson.get());
    }

    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(this.gson);
    }
  }

  public static final class ProvideSessionPreferencesProvidesAdapter extends ProvidesBinding<SessionPreferences>
    implements Provider<SessionPreferences>
  {
    private final RiderApplicationModule module;

    public ProvideSessionPreferencesProvidesAdapter(RiderApplicationModule paramRiderApplicationModule)
    {
      super(true, "com.ubercab.client.core.module.RiderApplicationModule", "provideSessionPreferences");
      this.module = paramRiderApplicationModule;
      setLibrary(true);
    }

    public SessionPreferences get()
    {
      return this.module.provideSessionPreferences();
    }
  }

  public static final class ProvideSignUpClientProvidesAdapter extends ProvidesBinding<SignupClient>
    implements Provider<SignupClient>
  {
    private Binding<Bus> bus;
    private Binding<RiderLocationProvider> locationProvider;
    private Binding<MobileAppTracker> mobileAppTracker;
    private final RiderApplicationModule module;
    private Binding<BuildConfigProxy> riderBuildConfig;
    private Binding<SignupApi> signupApi;
    private Binding<UberPreferences> uberPreferences;

    public ProvideSignUpClientProvidesAdapter(RiderApplicationModule paramRiderApplicationModule)
    {
      super(true, "com.ubercab.client.core.module.RiderApplicationModule", "provideSignUpClient");
      this.module = paramRiderApplicationModule;
      setLibrary(true);
    }

    public void attach(Linker paramLinker)
    {
      this.bus = paramLinker.requestBinding("com.squareup.otto.Bus", RiderApplicationModule.class, getClass().getClassLoader());
      this.riderBuildConfig = paramLinker.requestBinding("@com.ubercab.library.app.annotation.ForApp()/com.ubercab.library.app.BuildConfigProxy", RiderApplicationModule.class, getClass().getClassLoader());
      this.locationProvider = paramLinker.requestBinding("com.ubercab.client.core.content.RiderLocationProvider", RiderApplicationModule.class, getClass().getClassLoader());
      this.mobileAppTracker = paramLinker.requestBinding("com.mobileapptracker.MobileAppTracker", RiderApplicationModule.class, getClass().getClassLoader());
      this.uberPreferences = paramLinker.requestBinding("com.ubercab.library.app.UberPreferences", RiderApplicationModule.class, getClass().getClassLoader());
      this.signupApi = paramLinker.requestBinding("com.ubercab.client.core.network.SignupApi", RiderApplicationModule.class, getClass().getClassLoader());
    }

    public SignupClient get()
    {
      return this.module.provideSignUpClient((Bus)this.bus.get(), (BuildConfigProxy)this.riderBuildConfig.get(), (RiderLocationProvider)this.locationProvider.get(), (MobileAppTracker)this.mobileAppTracker.get(), (UberPreferences)this.uberPreferences.get(), (SignupApi)this.signupApi.get());
    }

    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(this.bus);
      paramSet1.add(this.riderBuildConfig);
      paramSet1.add(this.locationProvider);
      paramSet1.add(this.mobileAppTracker);
      paramSet1.add(this.uberPreferences);
      paramSet1.add(this.signupApi);
    }
  }

  public static final class ProvideSignupApiProvidesAdapter extends ProvidesBinding<SignupApi>
    implements Provider<SignupApi>
  {
    private final RiderApplicationModule module;
    private Binding<RestAdapter> restAdapter;

    public ProvideSignupApiProvidesAdapter(RiderApplicationModule paramRiderApplicationModule)
    {
      super(true, "com.ubercab.client.core.module.RiderApplicationModule", "provideSignupApi");
      this.module = paramRiderApplicationModule;
      setLibrary(true);
    }

    public void attach(Linker paramLinker)
    {
      this.restAdapter = paramLinker.requestBinding("@com.ubercab.library.app.annotation.ForCn()/retrofit.RestAdapter", RiderApplicationModule.class, getClass().getClassLoader());
    }

    public SignupApi get()
    {
      return this.module.provideSignupApi((RestAdapter)this.restAdapter.get());
    }

    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(this.restAdapter);
    }
  }

  public static final class ProvideTunesClientProvidesAdapter extends ProvidesBinding<TunesClient>
    implements Provider<TunesClient>
  {
    private Binding<Bus> bus;
    private Binding<RiderLocationProvider> locationProvider;
    private final RiderApplicationModule module;
    private Binding<RealtimeRestAdapterBuilder> restAdapterBuilder;

    public ProvideTunesClientProvidesAdapter(RiderApplicationModule paramRiderApplicationModule)
    {
      super(true, "com.ubercab.client.core.module.RiderApplicationModule", "provideTunesClient");
      this.module = paramRiderApplicationModule;
      setLibrary(true);
    }

    public void attach(Linker paramLinker)
    {
      this.bus = paramLinker.requestBinding("com.squareup.otto.Bus", RiderApplicationModule.class, getClass().getClassLoader());
      this.locationProvider = paramLinker.requestBinding("com.ubercab.client.core.content.RiderLocationProvider", RiderApplicationModule.class, getClass().getClassLoader());
      this.restAdapterBuilder = paramLinker.requestBinding("com.ubercab.library.network.RealtimeRestAdapterBuilder", RiderApplicationModule.class, getClass().getClassLoader());
    }

    public TunesClient get()
    {
      return this.module.provideTunesClient((Bus)this.bus.get(), (RiderLocationProvider)this.locationProvider.get(), (RealtimeRestAdapterBuilder)this.restAdapterBuilder.get());
    }

    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(this.bus);
      paramSet1.add(this.locationProvider);
      paramSet1.add(this.restAdapterBuilder);
    }
  }

  public static final class ProvidesExpenseLinkResourcesProvidesAdapter extends ProvidesBinding<ExpenseLinkResources>
    implements Provider<ExpenseLinkResources>
  {
    private final RiderApplicationModule module;

    public ProvidesExpenseLinkResourcesProvidesAdapter(RiderApplicationModule paramRiderApplicationModule)
    {
      super(true, "com.ubercab.client.core.module.RiderApplicationModule", "providesExpenseLinkResources");
      this.module = paramRiderApplicationModule;
      setLibrary(true);
    }

    public ExpenseLinkResources get()
    {
      return this.module.providesExpenseLinkResources();
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.module.RiderApplicationModule..ModuleAdapter
 * JD-Core Version:    0.6.2
 */