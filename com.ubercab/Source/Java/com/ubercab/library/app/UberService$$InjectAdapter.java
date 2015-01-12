package com.ubercab.library.app;

import com.squareup.otto.Bus;
import com.ubercab.geo.GeoManager;
import com.ubercab.library.location.LocationProvider;
import com.ubercab.library.location.client.LocationClientVendor;
import com.ubercab.library.metrics.analytics.AnalyticsClient;
import com.ubercab.library.metrics.monitoring.MonitoringClient;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import javax.inject.Provider;

public final class UberService$$InjectAdapter extends Binding<UberService>
  implements Provider<UberService>, MembersInjector<UberService>
{
  private Binding<AnalyticsClient> mAnalyticsClient;
  private Binding<Bus> mBus;
  private Binding<GeoManager> mGeoManager;
  private Binding<LocationClientVendor> mLocationClientVendor;
  private Binding<LocationProvider> mLocationProvider;
  private Binding<MonitoringClient> mMonitoringClient;
  private Binding<UberPreferences> mUberPreferences;

  public UberService$$InjectAdapter()
  {
    super("com.ubercab.library.app.UberService", "members/com.ubercab.library.app.UberService", false, UberService.class);
  }

  public void attach(Linker paramLinker)
  {
    this.mBus = paramLinker.requestBinding("com.squareup.otto.Bus", UberService.class, getClass().getClassLoader());
    this.mAnalyticsClient = paramLinker.requestBinding("com.ubercab.library.metrics.analytics.AnalyticsClient", UberService.class, getClass().getClassLoader());
    this.mMonitoringClient = paramLinker.requestBinding("com.ubercab.library.metrics.monitoring.MonitoringClient", UberService.class, getClass().getClassLoader());
    this.mUberPreferences = paramLinker.requestBinding("com.ubercab.library.app.UberPreferences", UberService.class, getClass().getClassLoader());
    this.mLocationProvider = paramLinker.requestBinding("com.ubercab.library.location.LocationProvider", UberService.class, getClass().getClassLoader());
    this.mGeoManager = paramLinker.requestBinding("com.ubercab.geo.GeoManager", UberService.class, getClass().getClassLoader());
    this.mLocationClientVendor = paramLinker.requestBinding("com.ubercab.library.location.client.LocationClientVendor", UberService.class, getClass().getClassLoader());
  }

  public UberService get()
  {
    UberService localUberService = new UberService();
    injectMembers(localUberService);
    return localUberService;
  }

  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(this.mBus);
    paramSet2.add(this.mAnalyticsClient);
    paramSet2.add(this.mMonitoringClient);
    paramSet2.add(this.mUberPreferences);
    paramSet2.add(this.mLocationProvider);
    paramSet2.add(this.mGeoManager);
    paramSet2.add(this.mLocationClientVendor);
  }

  public void injectMembers(UberService paramUberService)
  {
    paramUberService.mBus = ((Bus)this.mBus.get());
    paramUberService.mAnalyticsClient = ((AnalyticsClient)this.mAnalyticsClient.get());
    paramUberService.mMonitoringClient = ((MonitoringClient)this.mMonitoringClient.get());
    paramUberService.mUberPreferences = ((UberPreferences)this.mUberPreferences.get());
    paramUberService.mLocationProvider = ((LocationProvider)this.mLocationProvider.get());
    paramUberService.mGeoManager = ((GeoManager)this.mGeoManager.get());
    paramUberService.mLocationClientVendor = ((LocationClientVendor)this.mLocationClientVendor.get());
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.app.UberService..InjectAdapter
 * JD-Core Version:    0.6.2
 */