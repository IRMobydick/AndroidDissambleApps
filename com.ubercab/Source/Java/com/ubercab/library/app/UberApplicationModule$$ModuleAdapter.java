package com.ubercab.library.app;

import android.content.Context;
import com.google.gson.Gson;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.otto.Bus;
import com.squareup.picasso.Picasso;
import com.ubercab.geo.GeoManager;
import com.ubercab.geo.GeoRegion;
import com.ubercab.library.location.LocationProvider;
import com.ubercab.library.location.client.LocationClientVendor;
import com.ubercab.library.map.MapVendor;
import com.ubercab.library.metrics.MetricsApi;
import com.ubercab.library.metrics.analytics.AnalyticsClient;
import com.ubercab.library.metrics.analytics.AnalyticsProperties;
import com.ubercab.library.network.UberNetworkModule;
import dagger.internal.Binding;
import dagger.internal.BindingsGroup;
import dagger.internal.Linker;
import dagger.internal.ModuleAdapter;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import javax.inject.Provider;
import retrofit.RestAdapter;

public final class UberApplicationModule$$ModuleAdapter extends ModuleAdapter<UberApplicationModule>
{
  private static final Class<?>[] INCLUDES = { UberNetworkModule.class };
  private static final String[] INJECTS = { "members/com.ubercab.library.ui.ConfirmDialogFragment", "members/com.ubercab.library.ui.MessageDialogFragment", "members/com.ubercab.library.network.log.SendLogsDialogFragment", "members/com.ubercab.library.ui.UberButton", "members/com.ubercab.ui.UberEditText", "members/com.ubercab.ui.UberTextView", "members/com.ubercab.library.ui.ZipEditText" };
  private static final Class<?>[] STATIC_INJECTIONS = new Class[0];

  public UberApplicationModule$$ModuleAdapter()
  {
    super(UberApplicationModule.class, INJECTS, STATIC_INJECTIONS, false, INCLUDES, false, true);
  }

  public void getBindings(BindingsGroup paramBindingsGroup, UberApplicationModule paramUberApplicationModule)
  {
    paramBindingsGroup.contributeProvidesBinding("com.ubercab.library.metrics.MetricsApi", new ProvideMetricsApiProvidesAdapter(paramUberApplicationModule));
    paramBindingsGroup.contributeProvidesBinding("com.ubercab.library.metrics.analytics.AnalyticsClient", new ProvideAnalyticsClientProvidesAdapter(paramUberApplicationModule));
    paramBindingsGroup.contributeProvidesBinding("@com.ubercab.library.app.annotation.ForLibrary()/com.ubercab.library.app.BuildConfigProxy", new ProvideUberBuildConfigProvidesAdapter(paramUberApplicationModule));
    paramBindingsGroup.contributeProvidesBinding("com.squareup.otto.Bus", new ProvideBusProvidesAdapter(paramUberApplicationModule));
    paramBindingsGroup.contributeProvidesBinding("@com.ubercab.library.app.annotation.ForApp()/android.content.Context", new ProvideContextProvidesAdapter(paramUberApplicationModule));
    paramBindingsGroup.contributeProvidesBinding("com.ubercab.geo.GeoManager", new ProvideGeoManagerProvidesAdapter(paramUberApplicationModule));
    paramBindingsGroup.contributeProvidesBinding("com.ubercab.geo.GeoRegion", new ProvideGeoRegionProvidesAdapter(paramUberApplicationModule));
    paramBindingsGroup.contributeProvidesBinding("com.google.gson.Gson", new ProvideGsonProvidesAdapter(paramUberApplicationModule));
    paramBindingsGroup.contributeProvidesBinding("com.ubercab.library.app.LifecycleTracker", new ProvideLifecycleTrackerProvidesAdapter(paramUberApplicationModule));
    paramBindingsGroup.contributeProvidesBinding("com.ubercab.library.location.client.LocationClientVendor", new ProvideLocationClientVendorProviderProvidesAdapter(paramUberApplicationModule));
    paramBindingsGroup.contributeProvidesBinding("com.ubercab.library.location.LocationProvider", new ProvideLocationProviderProvidesAdapter(paramUberApplicationModule));
    paramBindingsGroup.contributeProvidesBinding("com.ubercab.library.map.MapVendor", new ProvideMapVendorProviderProvidesAdapter(paramUberApplicationModule));
    paramBindingsGroup.contributeProvidesBinding("com.squareup.picasso.Picasso", new ProvidePicassoProvidesAdapter(paramUberApplicationModule));
    paramBindingsGroup.contributeProvidesBinding("com.ubercab.library.app.UberPreferences", new ProvideUberPreferencesProvidesAdapter(paramUberApplicationModule));
    paramBindingsGroup.contributeProvidesBinding("java.util.concurrent.ExecutorService", new ProvideExecutorServiceProvidesAdapter(paramUberApplicationModule));
  }

  public static final class ProvideAnalyticsClientProvidesAdapter extends ProvidesBinding<AnalyticsClient>
    implements Provider<AnalyticsClient>
  {
    private Binding<AnalyticsProperties> analyticsProperties;
    private Binding<BuildConfigProxy> buildConfig;
    private Binding<LocationProvider> locationProvider;
    private Binding<MetricsApi> metricsApi;
    private final UberApplicationModule module;
    private Binding<UberPreferences> uberPreferences;

    public ProvideAnalyticsClientProvidesAdapter(UberApplicationModule paramUberApplicationModule)
    {
      super(true, "com.ubercab.library.app.UberApplicationModule", "provideAnalyticsClient");
      this.module = paramUberApplicationModule;
      setLibrary(true);
    }

    public void attach(Linker paramLinker)
    {
      this.buildConfig = paramLinker.requestBinding("@com.ubercab.library.app.annotation.ForApp()/com.ubercab.library.app.BuildConfigProxy", UberApplicationModule.class, getClass().getClassLoader());
      this.uberPreferences = paramLinker.requestBinding("com.ubercab.library.app.UberPreferences", UberApplicationModule.class, getClass().getClassLoader());
      this.metricsApi = paramLinker.requestBinding("com.ubercab.library.metrics.MetricsApi", UberApplicationModule.class, getClass().getClassLoader());
      this.analyticsProperties = paramLinker.requestBinding("com.ubercab.library.metrics.analytics.AnalyticsProperties", UberApplicationModule.class, getClass().getClassLoader());
      this.locationProvider = paramLinker.requestBinding("com.ubercab.library.location.LocationProvider", UberApplicationModule.class, getClass().getClassLoader());
    }

    public AnalyticsClient get()
    {
      return this.module.provideAnalyticsClient((BuildConfigProxy)this.buildConfig.get(), (UberPreferences)this.uberPreferences.get(), (MetricsApi)this.metricsApi.get(), (AnalyticsProperties)this.analyticsProperties.get(), (LocationProvider)this.locationProvider.get());
    }

    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(this.buildConfig);
      paramSet1.add(this.uberPreferences);
      paramSet1.add(this.metricsApi);
      paramSet1.add(this.analyticsProperties);
      paramSet1.add(this.locationProvider);
    }
  }

  public static final class ProvideBusProvidesAdapter extends ProvidesBinding<Bus>
    implements Provider<Bus>
  {
    private final UberApplicationModule module;

    public ProvideBusProvidesAdapter(UberApplicationModule paramUberApplicationModule)
    {
      super(true, "com.ubercab.library.app.UberApplicationModule", "provideBus");
      this.module = paramUberApplicationModule;
      setLibrary(true);
    }

    public Bus get()
    {
      return this.module.provideBus();
    }
  }

  public static final class ProvideContextProvidesAdapter extends ProvidesBinding<Context>
    implements Provider<Context>
  {
    private final UberApplicationModule module;

    public ProvideContextProvidesAdapter(UberApplicationModule paramUberApplicationModule)
    {
      super(true, "com.ubercab.library.app.UberApplicationModule", "provideContext");
      this.module = paramUberApplicationModule;
      setLibrary(true);
    }

    public Context get()
    {
      return this.module.provideContext();
    }
  }

  public static final class ProvideExecutorServiceProvidesAdapter extends ProvidesBinding<ExecutorService>
    implements Provider<ExecutorService>
  {
    private final UberApplicationModule module;

    public ProvideExecutorServiceProvidesAdapter(UberApplicationModule paramUberApplicationModule)
    {
      super(true, "com.ubercab.library.app.UberApplicationModule", "provideExecutorService");
      this.module = paramUberApplicationModule;
      setLibrary(true);
    }

    public ExecutorService get()
    {
      return this.module.provideExecutorService();
    }
  }

  public static final class ProvideGeoManagerProvidesAdapter extends ProvidesBinding<GeoManager>
    implements Provider<GeoManager>
  {
    private Binding<Context> context;
    private Binding<GeoRegion> geoRegion;
    private final UberApplicationModule module;
    private Binding<UberPreferences> preferences;

    public ProvideGeoManagerProvidesAdapter(UberApplicationModule paramUberApplicationModule)
    {
      super(true, "com.ubercab.library.app.UberApplicationModule", "provideGeoManager");
      this.module = paramUberApplicationModule;
      setLibrary(true);
    }

    public void attach(Linker paramLinker)
    {
      this.context = paramLinker.requestBinding("@com.ubercab.library.app.annotation.ForApp()/android.content.Context", UberApplicationModule.class, getClass().getClassLoader());
      this.preferences = paramLinker.requestBinding("com.ubercab.library.app.UberPreferences", UberApplicationModule.class, getClass().getClassLoader());
      this.geoRegion = paramLinker.requestBinding("com.ubercab.geo.GeoRegion", UberApplicationModule.class, getClass().getClassLoader());
    }

    public GeoManager get()
    {
      return this.module.provideGeoManager((Context)this.context.get(), (UberPreferences)this.preferences.get(), (GeoRegion)this.geoRegion.get());
    }

    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(this.context);
      paramSet1.add(this.preferences);
      paramSet1.add(this.geoRegion);
    }
  }

  public static final class ProvideGeoRegionProvidesAdapter extends ProvidesBinding<GeoRegion>
    implements Provider<GeoRegion>
  {
    private Binding<Context> context;
    private final UberApplicationModule module;

    public ProvideGeoRegionProvidesAdapter(UberApplicationModule paramUberApplicationModule)
    {
      super(true, "com.ubercab.library.app.UberApplicationModule", "provideGeoRegion");
      this.module = paramUberApplicationModule;
      setLibrary(true);
    }

    public void attach(Linker paramLinker)
    {
      this.context = paramLinker.requestBinding("@com.ubercab.library.app.annotation.ForApp()/android.content.Context", UberApplicationModule.class, getClass().getClassLoader());
    }

    public GeoRegion get()
    {
      return this.module.provideGeoRegion((Context)this.context.get());
    }

    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(this.context);
    }
  }

  public static final class ProvideGsonProvidesAdapter extends ProvidesBinding<Gson>
    implements Provider<Gson>
  {
    private final UberApplicationModule module;
    private Binding<Class> pingClass;

    public ProvideGsonProvidesAdapter(UberApplicationModule paramUberApplicationModule)
    {
      super(true, "com.ubercab.library.app.UberApplicationModule", "provideGson");
      this.module = paramUberApplicationModule;
      setLibrary(true);
    }

    public void attach(Linker paramLinker)
    {
      this.pingClass = paramLinker.requestBinding("@javax.inject.Named(value=Ping)/java.lang.Class", UberApplicationModule.class, getClass().getClassLoader());
    }

    public Gson get()
    {
      return this.module.provideGson((Class)this.pingClass.get());
    }

    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(this.pingClass);
    }
  }

  public static final class ProvideLifecycleTrackerProvidesAdapter extends ProvidesBinding<LifecycleTracker>
    implements Provider<LifecycleTracker>
  {
    private final UberApplicationModule module;

    public ProvideLifecycleTrackerProvidesAdapter(UberApplicationModule paramUberApplicationModule)
    {
      super(true, "com.ubercab.library.app.UberApplicationModule", "provideLifecycleTracker");
      this.module = paramUberApplicationModule;
      setLibrary(true);
    }

    public LifecycleTracker get()
    {
      return this.module.provideLifecycleTracker();
    }
  }

  public static final class ProvideLocationClientVendorProviderProvidesAdapter extends ProvidesBinding<LocationClientVendor>
    implements Provider<LocationClientVendor>
  {
    private Binding<GeoManager> geoManager;
    private final UberApplicationModule module;

    public ProvideLocationClientVendorProviderProvidesAdapter(UberApplicationModule paramUberApplicationModule)
    {
      super(true, "com.ubercab.library.app.UberApplicationModule", "provideLocationClientVendorProvider");
      this.module = paramUberApplicationModule;
      setLibrary(true);
    }

    public void attach(Linker paramLinker)
    {
      this.geoManager = paramLinker.requestBinding("com.ubercab.geo.GeoManager", UberApplicationModule.class, getClass().getClassLoader());
    }

    public LocationClientVendor get()
    {
      return this.module.provideLocationClientVendorProvider((GeoManager)this.geoManager.get());
    }

    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(this.geoManager);
    }
  }

  public static final class ProvideLocationProviderProvidesAdapter extends ProvidesBinding<LocationProvider>
    implements Provider<LocationProvider>
  {
    private Binding<Bus> bus;
    private final UberApplicationModule module;

    public ProvideLocationProviderProvidesAdapter(UberApplicationModule paramUberApplicationModule)
    {
      super(true, "com.ubercab.library.app.UberApplicationModule", "provideLocationProvider");
      this.module = paramUberApplicationModule;
      setLibrary(true);
    }

    public void attach(Linker paramLinker)
    {
      this.bus = paramLinker.requestBinding("com.squareup.otto.Bus", UberApplicationModule.class, getClass().getClassLoader());
    }

    public LocationProvider get()
    {
      return this.module.provideLocationProvider((Bus)this.bus.get());
    }

    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(this.bus);
    }
  }

  public static final class ProvideMapVendorProviderProvidesAdapter extends ProvidesBinding<MapVendor>
    implements Provider<MapVendor>
  {
    private Binding<GeoManager> geoManager;
    private final UberApplicationModule module;

    public ProvideMapVendorProviderProvidesAdapter(UberApplicationModule paramUberApplicationModule)
    {
      super(true, "com.ubercab.library.app.UberApplicationModule", "provideMapVendorProvider");
      this.module = paramUberApplicationModule;
      setLibrary(true);
    }

    public void attach(Linker paramLinker)
    {
      this.geoManager = paramLinker.requestBinding("com.ubercab.geo.GeoManager", UberApplicationModule.class, getClass().getClassLoader());
    }

    public MapVendor get()
    {
      return this.module.provideMapVendorProvider((GeoManager)this.geoManager.get());
    }

    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(this.geoManager);
    }
  }

  public static final class ProvideMetricsApiProvidesAdapter extends ProvidesBinding<MetricsApi>
    implements Provider<MetricsApi>
  {
    private final UberApplicationModule module;
    private Binding<RestAdapter> restAdapter;

    public ProvideMetricsApiProvidesAdapter(UberApplicationModule paramUberApplicationModule)
    {
      super(true, "com.ubercab.library.app.UberApplicationModule", "provideMetricsApi");
      this.module = paramUberApplicationModule;
      setLibrary(true);
    }

    public void attach(Linker paramLinker)
    {
      this.restAdapter = paramLinker.requestBinding("@com.ubercab.library.app.annotation.ForCn()/retrofit.RestAdapter", UberApplicationModule.class, getClass().getClassLoader());
    }

    public MetricsApi get()
    {
      return this.module.provideMetricsApi((RestAdapter)this.restAdapter.get());
    }

    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(this.restAdapter);
    }
  }

  public static final class ProvidePicassoProvidesAdapter extends ProvidesBinding<Picasso>
    implements Provider<Picasso>
  {
    private final UberApplicationModule module;
    private Binding<OkHttpClient> okHttpClient;

    public ProvidePicassoProvidesAdapter(UberApplicationModule paramUberApplicationModule)
    {
      super(true, "com.ubercab.library.app.UberApplicationModule", "providePicasso");
      this.module = paramUberApplicationModule;
      setLibrary(true);
    }

    public void attach(Linker paramLinker)
    {
      this.okHttpClient = paramLinker.requestBinding("com.squareup.okhttp.OkHttpClient", UberApplicationModule.class, getClass().getClassLoader());
    }

    public Picasso get()
    {
      return this.module.providePicasso((OkHttpClient)this.okHttpClient.get());
    }

    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(this.okHttpClient);
    }
  }

  public static final class ProvideUberBuildConfigProvidesAdapter extends ProvidesBinding<BuildConfigProxy>
    implements Provider<BuildConfigProxy>
  {
    private final UberApplicationModule module;

    public ProvideUberBuildConfigProvidesAdapter(UberApplicationModule paramUberApplicationModule)
    {
      super(true, "com.ubercab.library.app.UberApplicationModule", "provideUberBuildConfig");
      this.module = paramUberApplicationModule;
      setLibrary(true);
    }

    public BuildConfigProxy get()
    {
      return this.module.provideUberBuildConfig();
    }
  }

  public static final class ProvideUberPreferencesProvidesAdapter extends ProvidesBinding<UberPreferences>
    implements Provider<UberPreferences>
  {
    private Binding<Gson> gson;
    private final UberApplicationModule module;

    public ProvideUberPreferencesProvidesAdapter(UberApplicationModule paramUberApplicationModule)
    {
      super(true, "com.ubercab.library.app.UberApplicationModule", "provideUberPreferences");
      this.module = paramUberApplicationModule;
      setLibrary(true);
    }

    public void attach(Linker paramLinker)
    {
      this.gson = paramLinker.requestBinding("com.google.gson.Gson", UberApplicationModule.class, getClass().getClassLoader());
    }

    public UberPreferences get()
    {
      return this.module.provideUberPreferences((Gson)this.gson.get());
    }

    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(this.gson);
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.app.UberApplicationModule..ModuleAdapter
 * JD-Core Version:    0.6.2
 */