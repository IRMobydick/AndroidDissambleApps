package com.ubercab.client.feature.trip.slider;

import com.ubercab.client.core.app.RiderPreferences;
import com.ubercab.library.metrics.analytics.AnalyticsClient;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;

public final class VehicleSlider$$InjectAdapter extends Binding<VehicleSlider>
  implements MembersInjector<VehicleSlider>
{
  private Binding<AnalyticsClient> mAnalyticsClient;
  private Binding<RiderPreferences> mRiderPreferences;

  public VehicleSlider$$InjectAdapter()
  {
    super(null, "members/com.ubercab.client.feature.trip.slider.VehicleSlider", false, VehicleSlider.class);
  }

  public void attach(Linker paramLinker)
  {
    this.mAnalyticsClient = paramLinker.requestBinding("com.ubercab.library.metrics.analytics.AnalyticsClient", VehicleSlider.class, getClass().getClassLoader());
    this.mRiderPreferences = paramLinker.requestBinding("com.ubercab.client.core.app.RiderPreferences", VehicleSlider.class, getClass().getClassLoader());
  }

  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(this.mAnalyticsClient);
    paramSet2.add(this.mRiderPreferences);
  }

  public void injectMembers(VehicleSlider paramVehicleSlider)
  {
    paramVehicleSlider.mAnalyticsClient = ((AnalyticsClient)this.mAnalyticsClient.get());
    paramVehicleSlider.mRiderPreferences = ((RiderPreferences)this.mRiderPreferences.get());
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.trip.slider.VehicleSlider..InjectAdapter
 * JD-Core Version:    0.6.2
 */