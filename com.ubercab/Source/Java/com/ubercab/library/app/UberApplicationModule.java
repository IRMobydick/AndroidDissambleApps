package com.ubercab.library.app;

import android.content.Context;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.otto.Bus;
import com.squareup.picasso.OkHttpDownloader;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Picasso.Builder;
import com.ubercab.geo.GeoManager;
import com.ubercab.geo.GeoRegion;
import com.ubercab.geo.LocationFetcher;
import com.ubercab.library.app.annotation.ForApp;
import com.ubercab.library.app.annotation.ForCn;
import com.ubercab.library.app.annotation.ForLibrary;
import com.ubercab.library.location.LocationProvider;
import com.ubercab.library.location.client.LocationClientVendor;
import com.ubercab.library.map.MapVendor;
import com.ubercab.library.metrics.MetricsApi;
import com.ubercab.library.metrics.analytics.Analytics;
import com.ubercab.library.metrics.analytics.AnalyticsClient;
import com.ubercab.library.metrics.analytics.AnalyticsProperties;
import com.ubercab.library.network.UberNetworkModule;
import com.ubercab.library.network.dispatch.model.DispatchResponse;
import com.ubercab.library.network.log.SendLogsDialogFragment;
import com.ubercab.library.ui.ConfirmDialogFragment;
import com.ubercab.library.ui.MessageDialogFragment;
import com.ubercab.library.ui.UberButton;
import com.ubercab.library.ui.ZipEditText;
import com.ubercab.ui.UberEditText;
import com.ubercab.ui.UberTextView;
import dagger.Module;
import dagger.Provides;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.inject.Named;
import javax.inject.Singleton;
import retrofit.RestAdapter;

@Module(complete=false, includes={UberNetworkModule.class}, injects={ConfirmDialogFragment.class, MessageDialogFragment.class, SendLogsDialogFragment.class, UberButton.class, UberEditText.class, UberTextView.class, ZipEditText.class}, library=true)
public final class UberApplicationModule
{
  private UberApplication mApplication;

  public UberApplicationModule(UberApplication paramUberApplication)
  {
    this.mApplication = paramUberApplication;
  }

  @Provides
  @Singleton
  AnalyticsClient provideAnalyticsClient(@ForApp BuildConfigProxy paramBuildConfigProxy, UberPreferences paramUberPreferences, MetricsApi paramMetricsApi, AnalyticsProperties paramAnalyticsProperties, LocationProvider paramLocationProvider)
  {
    Analytics.init(paramBuildConfigProxy, paramUberPreferences, paramAnalyticsProperties, paramMetricsApi, paramLocationProvider);
    return Analytics.getInstance().getAnalyticsClient();
  }

  @Provides
  @Singleton
  Bus provideBus()
  {
    return new AndroidBus();
  }

  @ForApp
  @Provides
  @Singleton
  Context provideContext()
  {
    return this.mApplication;
  }

  @Provides
  @Singleton
  ExecutorService provideExecutorService()
  {
    return Executors.newCachedThreadPool();
  }

  @Provides
  @Singleton
  GeoManager provideGeoManager(@ForApp Context paramContext, UberPreferences paramUberPreferences, GeoRegion paramGeoRegion)
  {
    GeoManager localGeoManager = new GeoManager(new LocationFetcher(paramContext), paramGeoRegion);
    if (paramUberPreferences.hasFakeGeoEngine())
      localGeoManager.setFakeGeo(paramUberPreferences.getFakeGeoEngine());
    return localGeoManager;
  }

  @Provides
  @Singleton
  GeoRegion provideGeoRegion(@ForApp Context paramContext)
  {
    return new GeoRegion(paramContext);
  }

  @Provides
  @Singleton
  Gson provideGson(@Named("Ping") final Class paramClass)
  {
    GsonBuilder localGsonBuilder = new GsonBuilder().serializeNulls().serializeSpecialFloatingPointValues();
    localGsonBuilder.registerTypeAdapterFactory(new TypeAdapterFactory()
    {
      public <T> TypeAdapter<T> create(final Gson paramAnonymousGson, TypeToken<T> paramAnonymousTypeToken)
      {
        if (paramAnonymousTypeToken.getRawType() == DispatchResponse.class)
          return new TypeAdapter()
          {
            public T read(JsonReader paramAnonymous2JsonReader)
              throws IOException
            {
              return paramAnonymousGson.fromJson(paramAnonymous2JsonReader, UberApplicationModule.1.this.val$pingClass);
            }

            public void write(JsonWriter paramAnonymous2JsonWriter, T paramAnonymous2T)
              throws IOException
            {
              this.val$delegate.write(paramAnonymous2JsonWriter, paramAnonymous2T);
            }
          };
        return null;
      }
    });
    return localGsonBuilder.create();
  }

  @Provides
  @Singleton
  LifecycleTracker provideLifecycleTracker()
  {
    return new LifecycleTracker();
  }

  @Provides
  @Singleton
  LocationClientVendor provideLocationClientVendorProvider(GeoManager paramGeoManager)
  {
    return new LocationClientVendor(paramGeoManager);
  }

  @Provides
  @Singleton
  LocationProvider provideLocationProvider(Bus paramBus)
  {
    LocationProvider localLocationProvider = new LocationProvider(paramBus);
    localLocationProvider.register();
    return localLocationProvider;
  }

  @Provides
  @Singleton
  MapVendor provideMapVendorProvider(GeoManager paramGeoManager)
  {
    return new MapVendor(paramGeoManager);
  }

  @Provides
  @Singleton
  public MetricsApi provideMetricsApi(@ForCn RestAdapter paramRestAdapter)
  {
    return (MetricsApi)paramRestAdapter.create(MetricsApi.class);
  }

  @Provides
  @Singleton
  Picasso providePicasso(OkHttpClient paramOkHttpClient)
  {
    return new Picasso.Builder(this.mApplication).downloader(new OkHttpDownloader(paramOkHttpClient)).build();
  }

  @ForLibrary
  @Provides
  @Singleton
  BuildConfigProxy provideUberBuildConfig()
  {
    return new UberBuildConfig();
  }

  @Provides
  @Singleton
  UberPreferences provideUberPreferences(Gson paramGson)
  {
    return new UberPreferences(this.mApplication, paramGson);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.app.UberApplicationModule
 * JD-Core Version:    0.6.2
 */