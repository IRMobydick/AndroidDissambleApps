package com.ubercab.client.feature.trip.map;

import android.content.Context;
import com.ubercab.client.feature.trip.TripModule;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module(addsTo=TripModule.class, injects={MapFragment.class})
public class MapModule
{
  private final Context mContext;
  private final RiderMap mRiderMap;

  public MapModule(MapFragment paramMapFragment)
  {
    this.mRiderMap = paramMapFragment;
    this.mContext = paramMapFragment.getActivity();
  }

  @Provides
  @Singleton
  public MapCameraStateManager provideMapCameraStateManager()
  {
    return new MapCameraStateManager(this.mContext, this.mRiderMap);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.trip.map.MapModule
 * JD-Core Version:    0.6.2
 */