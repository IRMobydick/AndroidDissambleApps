package com.ubercab.client.feature.trip;

import android.content.Context;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.otto.Bus;
import com.ubercab.client.core.analytics.AnalyticsManager;
import com.ubercab.client.core.content.PingProvider;
import com.ubercab.client.core.content.SessionPreferences;
import com.ubercab.client.core.network.FareEstimateClient;
import com.ubercab.client.core.network.LocationClient;
import com.ubercab.library.metrics.analytics.AnalyticsClient;
import dagger.internal.Binding;
import dagger.internal.BindingsGroup;
import dagger.internal.Linker;
import dagger.internal.ModuleAdapter;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import javax.inject.Provider;

public final class TripModule$$ModuleAdapter extends ModuleAdapter<TripModule>
{
  private static final Class<?>[] INCLUDES = new Class[0];
  private static final String[] INJECTS = { "members/com.ubercab.client.feature.trip.rates.BaseRateCardPopupWindow", "members/com.ubercab.client.feature.trip.overlay.DestinationTutorialOverlayView", "members/com.ubercab.client.feature.trip.overlay.DispatchDestinationOverlayView", "members/com.ubercab.client.feature.trip.driver.DriverView", "members/com.ubercab.client.feature.trip.FooterView", "members/com.ubercab.client.feature.trip.HeaderView", "members/com.ubercab.client.feature.trip.LegacyFareEstimateManager", "members/com.ubercab.client.feature.trip.map.MapCameraStateManager", "members/com.ubercab.client.feature.trip.dispatch.TitleView", "members/com.ubercab.client.feature.trip.TripActivity", "members/com.ubercab.client.feature.trip.TripFragment", "members/com.ubercab.client.feature.trip.slider.VehicleBannerBar" };
  private static final Class<?>[] STATIC_INJECTIONS = new Class[0];

  public TripModule$$ModuleAdapter()
  {
    super(TripModule.class, INJECTS, STATIC_INJECTIONS, false, INCLUDES, true, false);
  }

  public void getBindings(BindingsGroup paramBindingsGroup, TripModule paramTripModule)
  {
    paramBindingsGroup.contributeProvidesBinding("com.ubercab.client.feature.trip.TripUIStateManager", new ProvideTripUIManagerProvidesAdapter(paramTripModule));
    paramBindingsGroup.contributeProvidesBinding("com.ubercab.client.feature.trip.LegacyFareEstimateManager", new ProvideFareEstimateManagerProvidesAdapter(paramTripModule));
    paramBindingsGroup.contributeProvidesBinding("com.ubercab.client.feature.trip.MultiFareEstimateManager", new ProvideMultiFareEstimateManagerProvidesAdapter(paramTripModule));
    paramBindingsGroup.contributeProvidesBinding("com.ubercab.client.core.network.FareEstimateClient", new ProvideFareEstimateClientProvidesAdapter(paramTripModule));
  }

  public TripModule newModule()
  {
    return new TripModule();
  }

  public static final class ProvideFareEstimateClientProvidesAdapter extends ProvidesBinding<FareEstimateClient>
    implements Provider<FareEstimateClient>
  {
    private Binding<Bus> bus;
    private final TripModule module;
    private Binding<OkHttpClient> okHttpClient;
    private Binding<SessionPreferences> sessionPreferences;

    public ProvideFareEstimateClientProvidesAdapter(TripModule paramTripModule)
    {
      super(true, "com.ubercab.client.feature.trip.TripModule", "provideFareEstimateClient");
      this.module = paramTripModule;
      setLibrary(false);
    }

    public void attach(Linker paramLinker)
    {
      this.bus = paramLinker.requestBinding("com.squareup.otto.Bus", TripModule.class, getClass().getClassLoader());
      this.okHttpClient = paramLinker.requestBinding("com.squareup.okhttp.OkHttpClient", TripModule.class, getClass().getClassLoader());
      this.sessionPreferences = paramLinker.requestBinding("com.ubercab.client.core.content.SessionPreferences", TripModule.class, getClass().getClassLoader());
    }

    public FareEstimateClient get()
    {
      return this.module.provideFareEstimateClient((Bus)this.bus.get(), (OkHttpClient)this.okHttpClient.get(), (SessionPreferences)this.sessionPreferences.get());
    }

    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(this.bus);
      paramSet1.add(this.okHttpClient);
      paramSet1.add(this.sessionPreferences);
    }
  }

  public static final class ProvideFareEstimateManagerProvidesAdapter extends ProvidesBinding<LegacyFareEstimateManager>
    implements Provider<LegacyFareEstimateManager>
  {
    private Binding<Bus> bus;
    private final TripModule module;
    private Binding<PingProvider> pingProvider;
    private Binding<TripUIStateManager> tripUIStateManager;

    public ProvideFareEstimateManagerProvidesAdapter(TripModule paramTripModule)
    {
      super(true, "com.ubercab.client.feature.trip.TripModule", "provideFareEstimateManager");
      this.module = paramTripModule;
      setLibrary(false);
    }

    public void attach(Linker paramLinker)
    {
      this.bus = paramLinker.requestBinding("com.squareup.otto.Bus", TripModule.class, getClass().getClassLoader());
      this.pingProvider = paramLinker.requestBinding("com.ubercab.client.core.content.PingProvider", TripModule.class, getClass().getClassLoader());
      this.tripUIStateManager = paramLinker.requestBinding("com.ubercab.client.feature.trip.TripUIStateManager", TripModule.class, getClass().getClassLoader());
    }

    public LegacyFareEstimateManager get()
    {
      return this.module.provideFareEstimateManager((Bus)this.bus.get(), (PingProvider)this.pingProvider.get(), (TripUIStateManager)this.tripUIStateManager.get());
    }

    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(this.bus);
      paramSet1.add(this.pingProvider);
      paramSet1.add(this.tripUIStateManager);
    }
  }

  public static final class ProvideMultiFareEstimateManagerProvidesAdapter extends ProvidesBinding<MultiFareEstimateManager>
    implements Provider<MultiFareEstimateManager>
  {
    private Binding<Bus> bus;
    private Binding<FareEstimateClient> client;
    private final TripModule module;
    private Binding<PingProvider> pingProvider;
    private Binding<TripUIStateManager> tripUIStateManager;

    public ProvideMultiFareEstimateManagerProvidesAdapter(TripModule paramTripModule)
    {
      super(true, "com.ubercab.client.feature.trip.TripModule", "provideMultiFareEstimateManager");
      this.module = paramTripModule;
      setLibrary(false);
    }

    public void attach(Linker paramLinker)
    {
      this.bus = paramLinker.requestBinding("com.squareup.otto.Bus", TripModule.class, getClass().getClassLoader());
      this.pingProvider = paramLinker.requestBinding("com.ubercab.client.core.content.PingProvider", TripModule.class, getClass().getClassLoader());
      this.client = paramLinker.requestBinding("com.ubercab.client.core.network.FareEstimateClient", TripModule.class, getClass().getClassLoader());
      this.tripUIStateManager = paramLinker.requestBinding("com.ubercab.client.feature.trip.TripUIStateManager", TripModule.class, getClass().getClassLoader());
    }

    public MultiFareEstimateManager get()
    {
      return this.module.provideMultiFareEstimateManager((Bus)this.bus.get(), (PingProvider)this.pingProvider.get(), (FareEstimateClient)this.client.get(), (TripUIStateManager)this.tripUIStateManager.get());
    }

    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(this.bus);
      paramSet1.add(this.pingProvider);
      paramSet1.add(this.client);
      paramSet1.add(this.tripUIStateManager);
    }
  }

  public static final class ProvideTripUIManagerProvidesAdapter extends ProvidesBinding<TripUIStateManager>
    implements Provider<TripUIStateManager>
  {
    private Binding<AnalyticsClient> analyticsClient;
    private Binding<AnalyticsManager> analyticsManager;
    private Binding<Bus> bus;
    private Binding<Context> context;
    private Binding<LocationClient> locationClient;
    private final TripModule module;
    private Binding<PingProvider> pingProvider;
    private Binding<SessionPreferences> sessionPreferences;

    public ProvideTripUIManagerProvidesAdapter(TripModule paramTripModule)
    {
      super(true, "com.ubercab.client.feature.trip.TripModule", "provideTripUIManager");
      this.module = paramTripModule;
      setLibrary(false);
    }

    public void attach(Linker paramLinker)
    {
      this.analyticsClient = paramLinker.requestBinding("com.ubercab.library.metrics.analytics.AnalyticsClient", TripModule.class, getClass().getClassLoader());
      this.analyticsManager = paramLinker.requestBinding("com.ubercab.client.core.analytics.AnalyticsManager", TripModule.class, getClass().getClassLoader());
      this.bus = paramLinker.requestBinding("com.squareup.otto.Bus", TripModule.class, getClass().getClassLoader());
      this.context = paramLinker.requestBinding("android.content.Context", TripModule.class, getClass().getClassLoader());
      this.locationClient = paramLinker.requestBinding("com.ubercab.client.core.network.LocationClient", TripModule.class, getClass().getClassLoader());
      this.pingProvider = paramLinker.requestBinding("com.ubercab.client.core.content.PingProvider", TripModule.class, getClass().getClassLoader());
      this.sessionPreferences = paramLinker.requestBinding("com.ubercab.client.core.content.SessionPreferences", TripModule.class, getClass().getClassLoader());
    }

    public TripUIStateManager get()
    {
      return this.module.provideTripUIManager((AnalyticsClient)this.analyticsClient.get(), (AnalyticsManager)this.analyticsManager.get(), (Bus)this.bus.get(), (Context)this.context.get(), (LocationClient)this.locationClient.get(), (PingProvider)this.pingProvider.get(), (SessionPreferences)this.sessionPreferences.get());
    }

    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(this.analyticsClient);
      paramSet1.add(this.analyticsManager);
      paramSet1.add(this.bus);
      paramSet1.add(this.context);
      paramSet1.add(this.locationClient);
      paramSet1.add(this.pingProvider);
      paramSet1.add(this.sessionPreferences);
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.trip.TripModule..ModuleAdapter
 * JD-Core Version:    0.6.2
 */