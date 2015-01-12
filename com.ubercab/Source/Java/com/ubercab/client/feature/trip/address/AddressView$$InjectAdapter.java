package com.ubercab.client.feature.trip.address;

import com.ubercab.client.core.app.RiderPreferences;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;

public final class AddressView$$InjectAdapter extends Binding<AddressView>
  implements MembersInjector<AddressView>
{
  private Binding<RiderPreferences> mRiderPreferences;

  public AddressView$$InjectAdapter()
  {
    super(null, "members/com.ubercab.client.feature.trip.address.AddressView", false, AddressView.class);
  }

  public void attach(Linker paramLinker)
  {
    this.mRiderPreferences = paramLinker.requestBinding("com.ubercab.client.core.app.RiderPreferences", AddressView.class, getClass().getClassLoader());
  }

  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(this.mRiderPreferences);
  }

  public void injectMembers(AddressView paramAddressView)
  {
    paramAddressView.mRiderPreferences = ((RiderPreferences)this.mRiderPreferences.get());
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.trip.address.AddressView..InjectAdapter
 * JD-Core Version:    0.6.2
 */