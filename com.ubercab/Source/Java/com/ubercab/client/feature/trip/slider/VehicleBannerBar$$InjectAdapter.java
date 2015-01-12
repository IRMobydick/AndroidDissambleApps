package com.ubercab.client.feature.trip.slider;

import com.ubercab.client.feature.trip.TripUIStateManager;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;

public final class VehicleBannerBar$$InjectAdapter extends Binding<VehicleBannerBar>
  implements MembersInjector<VehicleBannerBar>
{
  private Binding<TripUIStateManager> mTripUIStateManager;

  public VehicleBannerBar$$InjectAdapter()
  {
    super(null, "members/com.ubercab.client.feature.trip.slider.VehicleBannerBar", false, VehicleBannerBar.class);
  }

  public void attach(Linker paramLinker)
  {
    this.mTripUIStateManager = paramLinker.requestBinding("com.ubercab.client.feature.trip.TripUIStateManager", VehicleBannerBar.class, getClass().getClassLoader());
  }

  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(this.mTripUIStateManager);
  }

  public void injectMembers(VehicleBannerBar paramVehicleBannerBar)
  {
    paramVehicleBannerBar.mTripUIStateManager = ((TripUIStateManager)this.mTripUIStateManager.get());
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.trip.slider.VehicleBannerBar..InjectAdapter
 * JD-Core Version:    0.6.2
 */