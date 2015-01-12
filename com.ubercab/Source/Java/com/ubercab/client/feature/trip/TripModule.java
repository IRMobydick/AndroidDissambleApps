package com.ubercab.client.feature.trip;

import android.content.Context;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.otto.Bus;
import com.ubercab.client.core.analytics.AnalyticsManager;
import com.ubercab.client.core.content.PingProvider;
import com.ubercab.client.core.content.SessionPreferences;
import com.ubercab.client.core.module.RiderActivityModule;
import com.ubercab.client.core.network.FareEstimateClient;
import com.ubercab.client.core.network.LocationClient;
import com.ubercab.client.feature.trip.dispatch.TitleView;
import com.ubercab.client.feature.trip.driver.DriverView;
import com.ubercab.client.feature.trip.map.MapCameraStateManager;
import com.ubercab.client.feature.trip.overlay.DestinationTutorialOverlayView;
import com.ubercab.client.feature.trip.overlay.DispatchDestinationOverlayView;
import com.ubercab.client.feature.trip.rates.BaseRateCardPopupWindow;
import com.ubercab.client.feature.trip.slider.VehicleBannerBar;
import com.ubercab.library.metrics.analytics.AnalyticsClient;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module(addsTo=RiderActivityModule.class, injects={BaseRateCardPopupWindow.class, DestinationTutorialOverlayView.class, DispatchDestinationOverlayView.class, DriverView.class, FooterView.class, HeaderView.class, LegacyFareEstimateManager.class, MapCameraStateManager.class, TitleView.class, TripActivity.class, TripFragment.class, VehicleBannerBar.class})
public class TripModule
{
  @Provides
  @Singleton
  public FareEstimateClient provideFareEstimateClient(Bus paramBus, OkHttpClient paramOkHttpClient, SessionPreferences paramSessionPreferences)
  {
    return new FareEstimateClient(paramBus, paramOkHttpClient, paramSessionPreferences);
  }

  @Provides
  @Singleton
  public LegacyFareEstimateManager provideFareEstimateManager(Bus paramBus, PingProvider paramPingProvider, TripUIStateManager paramTripUIStateManager)
  {
    return new LegacyFareEstimateManager(paramBus, paramPingProvider, paramTripUIStateManager);
  }

  @Provides
  @Singleton
  public MultiFareEstimateManager provideMultiFareEstimateManager(Bus paramBus, PingProvider paramPingProvider, FareEstimateClient paramFareEstimateClient, TripUIStateManager paramTripUIStateManager)
  {
    return new MultiFareEstimateManager(paramBus, paramFareEstimateClient, paramPingProvider, paramTripUIStateManager);
  }

  @Provides
  @Singleton
  public TripUIStateManager provideTripUIManager(AnalyticsClient paramAnalyticsClient, AnalyticsManager paramAnalyticsManager, Bus paramBus, Context paramContext, LocationClient paramLocationClient, PingProvider paramPingProvider, SessionPreferences paramSessionPreferences)
  {
    return new TripUIStateManager(paramAnalyticsClient, paramAnalyticsManager, paramBus, paramContext, paramLocationClient, paramPingProvider, paramSessionPreferences);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.trip.TripModule
 * JD-Core Version:    0.6.2
 */