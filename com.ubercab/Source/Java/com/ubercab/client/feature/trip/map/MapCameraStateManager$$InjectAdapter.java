package com.ubercab.client.feature.trip.map;

import com.squareup.otto.Bus;
import com.ubercab.client.core.app.RiderPreferences;
import com.ubercab.client.core.content.PingProvider;
import com.ubercab.client.core.content.RiderLocationProvider;
import com.ubercab.client.core.content.SessionPreferences;
import com.ubercab.client.feature.trip.TripUIStateManager;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;

public final class MapCameraStateManager$$InjectAdapter extends Binding<MapCameraStateManager>
  implements MembersInjector<MapCameraStateManager>
{
  private Binding<Bus> mBus;
  private Binding<RiderLocationProvider> mLocationProvider;
  private Binding<PingProvider> mPingProvider;
  private Binding<RiderPreferences> mRiderPreferences;
  private Binding<SessionPreferences> mSessionPreferences;
  private Binding<TripUIStateManager> mTripUIStateManager;

  public MapCameraStateManager$$InjectAdapter()
  {
    super(null, "members/com.ubercab.client.feature.trip.map.MapCameraStateManager", false, MapCameraStateManager.class);
  }

  public void attach(Linker paramLinker)
  {
    this.mBus = paramLinker.requestBinding("com.squareup.otto.Bus", MapCameraStateManager.class, getClass().getClassLoader());
    this.mPingProvider = paramLinker.requestBinding("com.ubercab.client.core.content.PingProvider", MapCameraStateManager.class, getClass().getClassLoader());
    this.mLocationProvider = paramLinker.requestBinding("com.ubercab.client.core.content.RiderLocationProvider", MapCameraStateManager.class, getClass().getClassLoader());
    this.mRiderPreferences = paramLinker.requestBinding("com.ubercab.client.core.app.RiderPreferences", MapCameraStateManager.class, getClass().getClassLoader());
    this.mSessionPreferences = paramLinker.requestBinding("com.ubercab.client.core.content.SessionPreferences", MapCameraStateManager.class, getClass().getClassLoader());
    this.mTripUIStateManager = paramLinker.requestBinding("com.ubercab.client.feature.trip.TripUIStateManager", MapCameraStateManager.class, getClass().getClassLoader());
  }

  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(this.mBus);
    paramSet2.add(this.mPingProvider);
    paramSet2.add(this.mLocationProvider);
    paramSet2.add(this.mRiderPreferences);
    paramSet2.add(this.mSessionPreferences);
    paramSet2.add(this.mTripUIStateManager);
  }

  public void injectMembers(MapCameraStateManager paramMapCameraStateManager)
  {
    paramMapCameraStateManager.mBus = ((Bus)this.mBus.get());
    paramMapCameraStateManager.mPingProvider = ((PingProvider)this.mPingProvider.get());
    paramMapCameraStateManager.mLocationProvider = ((RiderLocationProvider)this.mLocationProvider.get());
    paramMapCameraStateManager.mRiderPreferences = ((RiderPreferences)this.mRiderPreferences.get());
    paramMapCameraStateManager.mSessionPreferences = ((SessionPreferences)this.mSessionPreferences.get());
    paramMapCameraStateManager.mTripUIStateManager = ((TripUIStateManager)this.mTripUIStateManager.get());
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.trip.map.MapCameraStateManager..InjectAdapter
 * JD-Core Version:    0.6.2
 */