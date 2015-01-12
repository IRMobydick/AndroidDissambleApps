package com.ubercab.library.network;

import android.content.Context;
import android.net.SSLCertificateSocketFactory;
import com.google.gson.Gson;
import com.squareup.okhttp.Cache;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.otto.Bus;
import com.ubercab.library.app.BuildConfigProxy;
import com.ubercab.library.app.UberPreferences;
import com.ubercab.library.app.annotation.ForApp;
import com.ubercab.library.app.annotation.ForCn;
import com.ubercab.library.location.LocationProvider;
import com.ubercab.library.metrics.Device;
import com.ubercab.library.metrics.MetricsApi;
import com.ubercab.library.metrics.monitoring.MonitoringClient;
import com.ubercab.library.metrics.monitoring.MonitoringListener;
import com.ubercab.library.network.cn.CnApi;
import com.ubercab.library.network.cn.CnClient;
import com.ubercab.library.network.cn.strategy.CnListFailoverStrategy;
import com.ubercab.library.network.cn.strategy.CnRedirectFailoverStrategy;
import com.ubercab.library.network.dispatch.DispatchApi;
import com.ubercab.library.network.dispatch.DispatchClient;
import dagger.Module;
import dagger.Provides;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import javax.inject.Singleton;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;
import retrofit.RequestInterceptor;
import retrofit.RequestInterceptor.RequestFacade;
import retrofit.RestAdapter;
import retrofit.RestAdapter.Builder;
import retrofit.RestAdapter.LogLevel;
import retrofit.client.OkClient;
import retrofit.converter.GsonConverter;
import timber.log.Timber;

@Module(complete=false, library=true)
public class UberNetworkModule
{
  private static final long HTTP_RESPONSE_CACHE = 10485760L;
  private static final int HTTP_TIMEOUT_MS = 30000;

  @Provides
  @Singleton
  CnClient provideCnClient(@ForApp BuildConfigProxy paramBuildConfigProxy, @ForCn RestAdapter paramRestAdapter, NetworkLogger paramNetworkLogger)
  {
    return new CnClient(paramBuildConfigProxy, (CnApi)paramRestAdapter.create(CnApi.class), paramNetworkLogger);
  }

  @Provides
  @Singleton
  DispatchClient provideDispatchClient(@ForApp Context paramContext, @ForApp BuildConfigProxy paramBuildConfigProxy, UberPreferences paramUberPreferences, @ForCn RestAdapter paramRestAdapter, @ForCn UberEndpoint paramUberEndpoint)
  {
    return new DispatchClient(paramContext, (DispatchApi)paramRestAdapter.create(DispatchApi.class), paramUberEndpoint, paramBuildConfigProxy, paramUberPreferences);
  }

  @ForCn
  @Provides
  @Singleton
  FailoverStrategy provideFailoverStrategy(@ForApp Context paramContext, Gson paramGson, UberPreferences paramUberPreferences)
  {
    if (paramUberPreferences.hasFakeCnFailoverStrategy())
    {
      if (paramUberPreferences.getFakeCnFailoverStrategy().equals("cnList"))
        return new CnListFailoverStrategy(paramContext, paramGson);
      return new CnRedirectFailoverStrategy();
    }
    return new CnRedirectFailoverStrategy();
  }

  @Provides
  @Singleton
  MonitoringClient provideMonitoringClient(@ForApp final BuildConfigProxy paramBuildConfigProxy, Bus paramBus, LocationProvider paramLocationProvider, Gson paramGson, ExecutorService paramExecutorService, @ForCn UberEndpoint paramUberEndpoint, OkHttpClient paramOkHttpClient, UberPreferences paramUberPreferences, @ForApp Context paramContext)
  {
    UberRetrofitClient localUberRetrofitClient = new UberRetrofitClient(new OkClient(paramOkHttpClient), paramUberEndpoint);
    RequestInterceptor local1 = new RequestInterceptor()
    {
      public void intercept(RequestInterceptor.RequestFacade paramAnonymousRequestFacade)
      {
        paramAnonymousRequestFacade.addHeader("User-Agent", paramBuildConfigProxy.getAppName() + "/android/" + paramBuildConfigProxy.getVersionName());
        paramAnonymousRequestFacade.addHeader("Content-Type", "application/json; charset=utf-8");
      }
    };
    return new MonitoringClient(paramBuildConfigProxy, paramUberPreferences, (MetricsApi)new RestAdapter.Builder().setRequestInterceptor(local1).setLogLevel(RestAdapter.LogLevel.NONE).setConverter(new GsonConverter(paramGson)).setExecutors(paramExecutorService, paramExecutorService).setEndpoint(paramUberEndpoint).setClient(localUberRetrofitClient).build().create(MetricsApi.class), paramLocationProvider, new Device(paramContext));
  }

  @Provides
  @Singleton
  MonitoringListener provideMonitoringListener(MonitoringClient paramMonitoringClient)
  {
    return new MonitoringListener(paramMonitoringClient);
  }

  @Provides
  @Singleton
  NetworkLogger provideNetworkLogger(@ForApp Context paramContext, @ForApp BuildConfigProxy paramBuildConfigProxy, ExecutorService paramExecutorService)
  {
    return new NetworkLogger(paramContext, paramExecutorService, paramBuildConfigProxy);
  }

  @Provides
  @Singleton
  OkHttpClient provideOkHttpClient(@ForApp Context paramContext, UberPreferences paramUberPreferences)
  {
    OkHttpClient localOkHttpClient = new OkHttpClient();
    localOkHttpClient.setConnectTimeout(30000L, TimeUnit.MILLISECONDS);
    localOkHttpClient.setReadTimeout(30000L, TimeUnit.MILLISECONDS);
    try
    {
      localOkHttpClient.setCache(new Cache(paramContext.getCacheDir(), 10485760L));
      if (paramUberPreferences.isCnSslVerificationDisabled())
      {
        localOkHttpClient.setHostnameVerifier(new HostnameVerifier()
        {
          public boolean verify(String paramAnonymousString, SSLSession paramAnonymousSSLSession)
          {
            return true;
          }
        });
        localOkHttpClient.setSslSocketFactory(SSLCertificateSocketFactory.getInsecure(0, null));
      }
      return localOkHttpClient;
    }
    catch (IOException localIOException)
    {
      while (true)
        Timber.e(localIOException, "Failed to set OkHttpClient response cache.", new Object[0]);
    }
  }

  @ForCn
  @Provides
  @Singleton
  RestAdapter provideRestAdapter(@ForApp final BuildConfigProxy paramBuildConfigProxy, @ForCn UberRetrofitClient paramUberRetrofitClient, Gson paramGson, @ForCn UberEndpoint paramUberEndpoint, ExecutorService paramExecutorService)
  {
    RequestInterceptor local3 = new RequestInterceptor()
    {
      public void intercept(RequestInterceptor.RequestFacade paramAnonymousRequestFacade)
      {
        paramAnonymousRequestFacade.addHeader("User-Agent", paramBuildConfigProxy.getAppName() + "/android/" + paramBuildConfigProxy.getVersionName());
        paramAnonymousRequestFacade.addHeader("Content-Type", "application/json; charset=utf-8");
        paramAnonymousRequestFacade.addHeader("X-Uber-Origin", "android-" + paramBuildConfigProxy.getAppName());
      }
    };
    return new RestAdapter.Builder().setRequestInterceptor(local3).setLogLevel(RestAdapter.LogLevel.NONE).setConverter(new GsonConverter(paramGson)).setExecutors(paramExecutorService, paramExecutorService).setEndpoint(paramUberEndpoint).setClient(paramUberRetrofitClient).build();
  }

  @ForCn
  @Provides
  @Singleton
  UberEndpoint provideUberEndpoint(@ForCn FailoverStrategy paramFailoverStrategy, UberPreferences paramUberPreferences)
  {
    return new UberEndpoint(paramUberPreferences, paramFailoverStrategy);
  }

  @ForCn
  @Provides
  @Singleton
  UberRetrofitClient provideUberRetrofitClient(OkHttpClient paramOkHttpClient, NetworkLogger paramNetworkLogger, MonitoringListener paramMonitoringListener, @ForCn UberEndpoint paramUberEndpoint)
  {
    UberRetrofitClient localUberRetrofitClient = new UberRetrofitClient(new OkClient(paramOkHttpClient), paramUberEndpoint);
    localUberRetrofitClient.addListener(paramNetworkLogger);
    localUberRetrofitClient.addListener(paramMonitoringListener);
    return localUberRetrofitClient;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.network.UberNetworkModule
 * JD-Core Version:    0.6.2
 */