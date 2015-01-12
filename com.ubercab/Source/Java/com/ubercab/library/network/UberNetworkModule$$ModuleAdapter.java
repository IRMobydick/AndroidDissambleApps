package com.ubercab.library.network;

import android.content.Context;
import com.google.gson.Gson;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.otto.Bus;
import com.ubercab.library.app.BuildConfigProxy;
import com.ubercab.library.app.UberPreferences;
import com.ubercab.library.location.LocationProvider;
import com.ubercab.library.metrics.monitoring.MonitoringClient;
import com.ubercab.library.metrics.monitoring.MonitoringListener;
import com.ubercab.library.network.cn.CnClient;
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

public final class UberNetworkModule$$ModuleAdapter extends ModuleAdapter<UberNetworkModule>
{
  private static final Class<?>[] INCLUDES = new Class[0];
  private static final String[] INJECTS = new String[0];
  private static final Class<?>[] STATIC_INJECTIONS = new Class[0];

  public UberNetworkModule$$ModuleAdapter()
  {
    super(UberNetworkModule.class, INJECTS, STATIC_INJECTIONS, false, INCLUDES, false, true);
  }

  public void getBindings(BindingsGroup paramBindingsGroup, UberNetworkModule paramUberNetworkModule)
  {
    paramBindingsGroup.contributeProvidesBinding("com.ubercab.library.network.dispatch.DispatchClient", new ProvideDispatchClientProvidesAdapter(paramUberNetworkModule));
    paramBindingsGroup.contributeProvidesBinding("@com.ubercab.library.app.annotation.ForCn()/com.ubercab.library.network.FailoverStrategy", new ProvideFailoverStrategyProvidesAdapter(paramUberNetworkModule));
    paramBindingsGroup.contributeProvidesBinding("com.ubercab.library.metrics.monitoring.MonitoringClient", new ProvideMonitoringClientProvidesAdapter(paramUberNetworkModule));
    paramBindingsGroup.contributeProvidesBinding("com.squareup.okhttp.OkHttpClient", new ProvideOkHttpClientProvidesAdapter(paramUberNetworkModule));
    paramBindingsGroup.contributeProvidesBinding("@com.ubercab.library.app.annotation.ForCn()/retrofit.RestAdapter", new ProvideRestAdapterProvidesAdapter(paramUberNetworkModule));
    paramBindingsGroup.contributeProvidesBinding("@com.ubercab.library.app.annotation.ForCn()/com.ubercab.library.network.UberEndpoint", new ProvideUberEndpointProvidesAdapter(paramUberNetworkModule));
    paramBindingsGroup.contributeProvidesBinding("com.ubercab.library.network.cn.CnClient", new ProvideCnClientProvidesAdapter(paramUberNetworkModule));
    paramBindingsGroup.contributeProvidesBinding("com.ubercab.library.network.NetworkLogger", new ProvideNetworkLoggerProvidesAdapter(paramUberNetworkModule));
    paramBindingsGroup.contributeProvidesBinding("com.ubercab.library.metrics.monitoring.MonitoringListener", new ProvideMonitoringListenerProvidesAdapter(paramUberNetworkModule));
    paramBindingsGroup.contributeProvidesBinding("@com.ubercab.library.app.annotation.ForCn()/com.ubercab.library.network.UberRetrofitClient", new ProvideUberRetrofitClientProvidesAdapter(paramUberNetworkModule));
  }

  public UberNetworkModule newModule()
  {
    return new UberNetworkModule();
  }

  public static final class ProvideCnClientProvidesAdapter extends ProvidesBinding<CnClient>
    implements Provider<CnClient>
  {
    private Binding<BuildConfigProxy> buildConfigProxy;
    private final UberNetworkModule module;
    private Binding<NetworkLogger> networkLogger;
    private Binding<RestAdapter> restAdapter;

    public ProvideCnClientProvidesAdapter(UberNetworkModule paramUberNetworkModule)
    {
      super(true, "com.ubercab.library.network.UberNetworkModule", "provideCnClient");
      this.module = paramUberNetworkModule;
      setLibrary(true);
    }

    public void attach(Linker paramLinker)
    {
      this.buildConfigProxy = paramLinker.requestBinding("@com.ubercab.library.app.annotation.ForApp()/com.ubercab.library.app.BuildConfigProxy", UberNetworkModule.class, getClass().getClassLoader());
      this.restAdapter = paramLinker.requestBinding("@com.ubercab.library.app.annotation.ForCn()/retrofit.RestAdapter", UberNetworkModule.class, getClass().getClassLoader());
      this.networkLogger = paramLinker.requestBinding("com.ubercab.library.network.NetworkLogger", UberNetworkModule.class, getClass().getClassLoader());
    }

    public CnClient get()
    {
      return this.module.provideCnClient((BuildConfigProxy)this.buildConfigProxy.get(), (RestAdapter)this.restAdapter.get(), (NetworkLogger)this.networkLogger.get());
    }

    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(this.buildConfigProxy);
      paramSet1.add(this.restAdapter);
      paramSet1.add(this.networkLogger);
    }
  }

  public static final class ProvideDispatchClientProvidesAdapter extends ProvidesBinding<DispatchClient>
    implements Provider<DispatchClient>
  {
    private Binding<BuildConfigProxy> buildConfig;
    private Binding<Context> context;
    private final UberNetworkModule module;
    private Binding<RestAdapter> restAdapter;
    private Binding<UberEndpoint> uberEndpoint;
    private Binding<UberPreferences> uberPreferences;

    public ProvideDispatchClientProvidesAdapter(UberNetworkModule paramUberNetworkModule)
    {
      super(true, "com.ubercab.library.network.UberNetworkModule", "provideDispatchClient");
      this.module = paramUberNetworkModule;
      setLibrary(true);
    }

    public void attach(Linker paramLinker)
    {
      this.context = paramLinker.requestBinding("@com.ubercab.library.app.annotation.ForApp()/android.content.Context", UberNetworkModule.class, getClass().getClassLoader());
      this.buildConfig = paramLinker.requestBinding("@com.ubercab.library.app.annotation.ForApp()/com.ubercab.library.app.BuildConfigProxy", UberNetworkModule.class, getClass().getClassLoader());
      this.uberPreferences = paramLinker.requestBinding("com.ubercab.library.app.UberPreferences", UberNetworkModule.class, getClass().getClassLoader());
      this.restAdapter = paramLinker.requestBinding("@com.ubercab.library.app.annotation.ForCn()/retrofit.RestAdapter", UberNetworkModule.class, getClass().getClassLoader());
      this.uberEndpoint = paramLinker.requestBinding("@com.ubercab.library.app.annotation.ForCn()/com.ubercab.library.network.UberEndpoint", UberNetworkModule.class, getClass().getClassLoader());
    }

    public DispatchClient get()
    {
      return this.module.provideDispatchClient((Context)this.context.get(), (BuildConfigProxy)this.buildConfig.get(), (UberPreferences)this.uberPreferences.get(), (RestAdapter)this.restAdapter.get(), (UberEndpoint)this.uberEndpoint.get());
    }

    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(this.context);
      paramSet1.add(this.buildConfig);
      paramSet1.add(this.uberPreferences);
      paramSet1.add(this.restAdapter);
      paramSet1.add(this.uberEndpoint);
    }
  }

  public static final class ProvideFailoverStrategyProvidesAdapter extends ProvidesBinding<FailoverStrategy>
    implements Provider<FailoverStrategy>
  {
    private Binding<Context> context;
    private Binding<Gson> gson;
    private final UberNetworkModule module;
    private Binding<UberPreferences> uberPreferences;

    public ProvideFailoverStrategyProvidesAdapter(UberNetworkModule paramUberNetworkModule)
    {
      super(true, "com.ubercab.library.network.UberNetworkModule", "provideFailoverStrategy");
      this.module = paramUberNetworkModule;
      setLibrary(true);
    }

    public void attach(Linker paramLinker)
    {
      this.context = paramLinker.requestBinding("@com.ubercab.library.app.annotation.ForApp()/android.content.Context", UberNetworkModule.class, getClass().getClassLoader());
      this.gson = paramLinker.requestBinding("com.google.gson.Gson", UberNetworkModule.class, getClass().getClassLoader());
      this.uberPreferences = paramLinker.requestBinding("com.ubercab.library.app.UberPreferences", UberNetworkModule.class, getClass().getClassLoader());
    }

    public FailoverStrategy get()
    {
      return this.module.provideFailoverStrategy((Context)this.context.get(), (Gson)this.gson.get(), (UberPreferences)this.uberPreferences.get());
    }

    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(this.context);
      paramSet1.add(this.gson);
      paramSet1.add(this.uberPreferences);
    }
  }

  public static final class ProvideMonitoringClientProvidesAdapter extends ProvidesBinding<MonitoringClient>
    implements Provider<MonitoringClient>
  {
    private Binding<BuildConfigProxy> buildConfig;
    private Binding<Bus> bus;
    private Binding<Context> context;
    private Binding<ExecutorService> executor;
    private Binding<Gson> gson;
    private Binding<LocationProvider> locationProvider;
    private final UberNetworkModule module;
    private Binding<OkHttpClient> okHttpClient;
    private Binding<UberEndpoint> uberEndpoint;
    private Binding<UberPreferences> uberPreferences;

    public ProvideMonitoringClientProvidesAdapter(UberNetworkModule paramUberNetworkModule)
    {
      super(true, "com.ubercab.library.network.UberNetworkModule", "provideMonitoringClient");
      this.module = paramUberNetworkModule;
      setLibrary(true);
    }

    public void attach(Linker paramLinker)
    {
      this.buildConfig = paramLinker.requestBinding("@com.ubercab.library.app.annotation.ForApp()/com.ubercab.library.app.BuildConfigProxy", UberNetworkModule.class, getClass().getClassLoader());
      this.bus = paramLinker.requestBinding("com.squareup.otto.Bus", UberNetworkModule.class, getClass().getClassLoader());
      this.locationProvider = paramLinker.requestBinding("com.ubercab.library.location.LocationProvider", UberNetworkModule.class, getClass().getClassLoader());
      this.gson = paramLinker.requestBinding("com.google.gson.Gson", UberNetworkModule.class, getClass().getClassLoader());
      this.executor = paramLinker.requestBinding("java.util.concurrent.ExecutorService", UberNetworkModule.class, getClass().getClassLoader());
      this.uberEndpoint = paramLinker.requestBinding("@com.ubercab.library.app.annotation.ForCn()/com.ubercab.library.network.UberEndpoint", UberNetworkModule.class, getClass().getClassLoader());
      this.okHttpClient = paramLinker.requestBinding("com.squareup.okhttp.OkHttpClient", UberNetworkModule.class, getClass().getClassLoader());
      this.uberPreferences = paramLinker.requestBinding("com.ubercab.library.app.UberPreferences", UberNetworkModule.class, getClass().getClassLoader());
      this.context = paramLinker.requestBinding("@com.ubercab.library.app.annotation.ForApp()/android.content.Context", UberNetworkModule.class, getClass().getClassLoader());
    }

    public MonitoringClient get()
    {
      return this.module.provideMonitoringClient((BuildConfigProxy)this.buildConfig.get(), (Bus)this.bus.get(), (LocationProvider)this.locationProvider.get(), (Gson)this.gson.get(), (ExecutorService)this.executor.get(), (UberEndpoint)this.uberEndpoint.get(), (OkHttpClient)this.okHttpClient.get(), (UberPreferences)this.uberPreferences.get(), (Context)this.context.get());
    }

    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(this.buildConfig);
      paramSet1.add(this.bus);
      paramSet1.add(this.locationProvider);
      paramSet1.add(this.gson);
      paramSet1.add(this.executor);
      paramSet1.add(this.uberEndpoint);
      paramSet1.add(this.okHttpClient);
      paramSet1.add(this.uberPreferences);
      paramSet1.add(this.context);
    }
  }

  public static final class ProvideMonitoringListenerProvidesAdapter extends ProvidesBinding<MonitoringListener>
    implements Provider<MonitoringListener>
  {
    private final UberNetworkModule module;
    private Binding<MonitoringClient> monitoringClient;

    public ProvideMonitoringListenerProvidesAdapter(UberNetworkModule paramUberNetworkModule)
    {
      super(true, "com.ubercab.library.network.UberNetworkModule", "provideMonitoringListener");
      this.module = paramUberNetworkModule;
      setLibrary(true);
    }

    public void attach(Linker paramLinker)
    {
      this.monitoringClient = paramLinker.requestBinding("com.ubercab.library.metrics.monitoring.MonitoringClient", UberNetworkModule.class, getClass().getClassLoader());
    }

    public MonitoringListener get()
    {
      return this.module.provideMonitoringListener((MonitoringClient)this.monitoringClient.get());
    }

    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(this.monitoringClient);
    }
  }

  public static final class ProvideNetworkLoggerProvidesAdapter extends ProvidesBinding<NetworkLogger>
    implements Provider<NetworkLogger>
  {
    private Binding<BuildConfigProxy> buildConfigProxy;
    private Binding<Context> context;
    private Binding<ExecutorService> executorService;
    private final UberNetworkModule module;

    public ProvideNetworkLoggerProvidesAdapter(UberNetworkModule paramUberNetworkModule)
    {
      super(true, "com.ubercab.library.network.UberNetworkModule", "provideNetworkLogger");
      this.module = paramUberNetworkModule;
      setLibrary(true);
    }

    public void attach(Linker paramLinker)
    {
      this.context = paramLinker.requestBinding("@com.ubercab.library.app.annotation.ForApp()/android.content.Context", UberNetworkModule.class, getClass().getClassLoader());
      this.buildConfigProxy = paramLinker.requestBinding("@com.ubercab.library.app.annotation.ForApp()/com.ubercab.library.app.BuildConfigProxy", UberNetworkModule.class, getClass().getClassLoader());
      this.executorService = paramLinker.requestBinding("java.util.concurrent.ExecutorService", UberNetworkModule.class, getClass().getClassLoader());
    }

    public NetworkLogger get()
    {
      return this.module.provideNetworkLogger((Context)this.context.get(), (BuildConfigProxy)this.buildConfigProxy.get(), (ExecutorService)this.executorService.get());
    }

    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(this.context);
      paramSet1.add(this.buildConfigProxy);
      paramSet1.add(this.executorService);
    }
  }

  public static final class ProvideOkHttpClientProvidesAdapter extends ProvidesBinding<OkHttpClient>
    implements Provider<OkHttpClient>
  {
    private Binding<Context> context;
    private final UberNetworkModule module;
    private Binding<UberPreferences> preferences;

    public ProvideOkHttpClientProvidesAdapter(UberNetworkModule paramUberNetworkModule)
    {
      super(true, "com.ubercab.library.network.UberNetworkModule", "provideOkHttpClient");
      this.module = paramUberNetworkModule;
      setLibrary(true);
    }

    public void attach(Linker paramLinker)
    {
      this.context = paramLinker.requestBinding("@com.ubercab.library.app.annotation.ForApp()/android.content.Context", UberNetworkModule.class, getClass().getClassLoader());
      this.preferences = paramLinker.requestBinding("com.ubercab.library.app.UberPreferences", UberNetworkModule.class, getClass().getClassLoader());
    }

    public OkHttpClient get()
    {
      return this.module.provideOkHttpClient((Context)this.context.get(), (UberPreferences)this.preferences.get());
    }

    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(this.context);
      paramSet1.add(this.preferences);
    }
  }

  public static final class ProvideRestAdapterProvidesAdapter extends ProvidesBinding<RestAdapter>
    implements Provider<RestAdapter>
  {
    private Binding<BuildConfigProxy> buildConfig;
    private Binding<ExecutorService> executor;
    private Binding<Gson> gson;
    private final UberNetworkModule module;
    private Binding<UberRetrofitClient> retrofitClient;
    private Binding<UberEndpoint> uberEndpoint;

    public ProvideRestAdapterProvidesAdapter(UberNetworkModule paramUberNetworkModule)
    {
      super(true, "com.ubercab.library.network.UberNetworkModule", "provideRestAdapter");
      this.module = paramUberNetworkModule;
      setLibrary(true);
    }

    public void attach(Linker paramLinker)
    {
      this.buildConfig = paramLinker.requestBinding("@com.ubercab.library.app.annotation.ForApp()/com.ubercab.library.app.BuildConfigProxy", UberNetworkModule.class, getClass().getClassLoader());
      this.retrofitClient = paramLinker.requestBinding("@com.ubercab.library.app.annotation.ForCn()/com.ubercab.library.network.UberRetrofitClient", UberNetworkModule.class, getClass().getClassLoader());
      this.gson = paramLinker.requestBinding("com.google.gson.Gson", UberNetworkModule.class, getClass().getClassLoader());
      this.uberEndpoint = paramLinker.requestBinding("@com.ubercab.library.app.annotation.ForCn()/com.ubercab.library.network.UberEndpoint", UberNetworkModule.class, getClass().getClassLoader());
      this.executor = paramLinker.requestBinding("java.util.concurrent.ExecutorService", UberNetworkModule.class, getClass().getClassLoader());
    }

    public RestAdapter get()
    {
      return this.module.provideRestAdapter((BuildConfigProxy)this.buildConfig.get(), (UberRetrofitClient)this.retrofitClient.get(), (Gson)this.gson.get(), (UberEndpoint)this.uberEndpoint.get(), (ExecutorService)this.executor.get());
    }

    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(this.buildConfig);
      paramSet1.add(this.retrofitClient);
      paramSet1.add(this.gson);
      paramSet1.add(this.uberEndpoint);
      paramSet1.add(this.executor);
    }
  }

  public static final class ProvideUberEndpointProvidesAdapter extends ProvidesBinding<UberEndpoint>
    implements Provider<UberEndpoint>
  {
    private Binding<FailoverStrategy> failoverStrategy;
    private final UberNetworkModule module;
    private Binding<UberPreferences> uberPreferences;

    public ProvideUberEndpointProvidesAdapter(UberNetworkModule paramUberNetworkModule)
    {
      super(true, "com.ubercab.library.network.UberNetworkModule", "provideUberEndpoint");
      this.module = paramUberNetworkModule;
      setLibrary(true);
    }

    public void attach(Linker paramLinker)
    {
      this.failoverStrategy = paramLinker.requestBinding("@com.ubercab.library.app.annotation.ForCn()/com.ubercab.library.network.FailoverStrategy", UberNetworkModule.class, getClass().getClassLoader());
      this.uberPreferences = paramLinker.requestBinding("com.ubercab.library.app.UberPreferences", UberNetworkModule.class, getClass().getClassLoader());
    }

    public UberEndpoint get()
    {
      return this.module.provideUberEndpoint((FailoverStrategy)this.failoverStrategy.get(), (UberPreferences)this.uberPreferences.get());
    }

    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(this.failoverStrategy);
      paramSet1.add(this.uberPreferences);
    }
  }

  public static final class ProvideUberRetrofitClientProvidesAdapter extends ProvidesBinding<UberRetrofitClient>
    implements Provider<UberRetrofitClient>
  {
    private final UberNetworkModule module;
    private Binding<MonitoringListener> monitoringListener;
    private Binding<NetworkLogger> networkLogger;
    private Binding<OkHttpClient> okHttpClient;
    private Binding<UberEndpoint> uberEndpoint;

    public ProvideUberRetrofitClientProvidesAdapter(UberNetworkModule paramUberNetworkModule)
    {
      super(true, "com.ubercab.library.network.UberNetworkModule", "provideUberRetrofitClient");
      this.module = paramUberNetworkModule;
      setLibrary(true);
    }

    public void attach(Linker paramLinker)
    {
      this.okHttpClient = paramLinker.requestBinding("com.squareup.okhttp.OkHttpClient", UberNetworkModule.class, getClass().getClassLoader());
      this.networkLogger = paramLinker.requestBinding("com.ubercab.library.network.NetworkLogger", UberNetworkModule.class, getClass().getClassLoader());
      this.monitoringListener = paramLinker.requestBinding("com.ubercab.library.metrics.monitoring.MonitoringListener", UberNetworkModule.class, getClass().getClassLoader());
      this.uberEndpoint = paramLinker.requestBinding("@com.ubercab.library.app.annotation.ForCn()/com.ubercab.library.network.UberEndpoint", UberNetworkModule.class, getClass().getClassLoader());
    }

    public UberRetrofitClient get()
    {
      return this.module.provideUberRetrofitClient((OkHttpClient)this.okHttpClient.get(), (NetworkLogger)this.networkLogger.get(), (MonitoringListener)this.monitoringListener.get(), (UberEndpoint)this.uberEndpoint.get());
    }

    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(this.okHttpClient);
      paramSet1.add(this.networkLogger);
      paramSet1.add(this.monitoringListener);
      paramSet1.add(this.uberEndpoint);
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.network.UberNetworkModule..ModuleAdapter
 * JD-Core Version:    0.6.2
 */