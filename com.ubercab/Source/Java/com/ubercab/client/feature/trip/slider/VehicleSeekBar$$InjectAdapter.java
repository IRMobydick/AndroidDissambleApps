package com.ubercab.client.feature.trip.slider;

import com.squareup.picasso.Picasso;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;

public final class VehicleSeekBar$$InjectAdapter extends Binding<VehicleSeekBar>
  implements MembersInjector<VehicleSeekBar>
{
  private Binding<Picasso> mPicasso;

  public VehicleSeekBar$$InjectAdapter()
  {
    super(null, "members/com.ubercab.client.feature.trip.slider.VehicleSeekBar", false, VehicleSeekBar.class);
  }

  public void attach(Linker paramLinker)
  {
    this.mPicasso = paramLinker.requestBinding("com.squareup.picasso.Picasso", VehicleSeekBar.class, getClass().getClassLoader());
  }

  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(this.mPicasso);
  }

  public void injectMembers(VehicleSeekBar paramVehicleSeekBar)
  {
    paramVehicleSeekBar.mPicasso = ((Picasso)this.mPicasso.get());
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.trip.slider.VehicleSeekBar..InjectAdapter
 * JD-Core Version:    0.6.2
 */