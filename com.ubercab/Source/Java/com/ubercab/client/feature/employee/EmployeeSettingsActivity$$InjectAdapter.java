package com.ubercab.client.feature.employee;

import com.ubercab.client.core.app.RiderPublicActivity;
import com.ubercab.client.core.content.PingProvider;
import com.ubercab.client.core.content.RiderLocationProvider;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import javax.inject.Provider;

public final class EmployeeSettingsActivity$$InjectAdapter extends Binding<EmployeeSettingsActivity>
  implements Provider<EmployeeSettingsActivity>, MembersInjector<EmployeeSettingsActivity>
{
  private Binding<RiderLocationProvider> mLocationProvider;
  private Binding<PingProvider> mPingProvider;
  private Binding<RiderPublicActivity> supertype;

  public EmployeeSettingsActivity$$InjectAdapter()
  {
    super("com.ubercab.client.feature.employee.EmployeeSettingsActivity", "members/com.ubercab.client.feature.employee.EmployeeSettingsActivity", false, EmployeeSettingsActivity.class);
  }

  public void attach(Linker paramLinker)
  {
    this.mPingProvider = paramLinker.requestBinding("com.ubercab.client.core.content.PingProvider", EmployeeSettingsActivity.class, getClass().getClassLoader());
    this.mLocationProvider = paramLinker.requestBinding("com.ubercab.client.core.content.RiderLocationProvider", EmployeeSettingsActivity.class, getClass().getClassLoader());
    this.supertype = paramLinker.requestBinding("members/com.ubercab.client.core.app.RiderPublicActivity", EmployeeSettingsActivity.class, getClass().getClassLoader(), false, true);
  }

  public EmployeeSettingsActivity get()
  {
    EmployeeSettingsActivity localEmployeeSettingsActivity = new EmployeeSettingsActivity();
    injectMembers(localEmployeeSettingsActivity);
    return localEmployeeSettingsActivity;
  }

  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(this.mPingProvider);
    paramSet2.add(this.mLocationProvider);
    paramSet2.add(this.supertype);
  }

  public void injectMembers(EmployeeSettingsActivity paramEmployeeSettingsActivity)
  {
    paramEmployeeSettingsActivity.mPingProvider = ((PingProvider)this.mPingProvider.get());
    paramEmployeeSettingsActivity.mLocationProvider = ((RiderLocationProvider)this.mLocationProvider.get());
    this.supertype.injectMembers(paramEmployeeSettingsActivity);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.employee.EmployeeSettingsActivity..InjectAdapter
 * JD-Core Version:    0.6.2
 */