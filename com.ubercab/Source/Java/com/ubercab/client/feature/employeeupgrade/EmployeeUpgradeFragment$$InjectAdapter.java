package com.ubercab.client.feature.employeeupgrade;

import com.ubercab.client.core.app.RiderDialogFragment;
import com.ubercab.client.core.app.RiderPreferences;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import javax.inject.Provider;

public final class EmployeeUpgradeFragment$$InjectAdapter extends Binding<EmployeeUpgradeFragment>
  implements Provider<EmployeeUpgradeFragment>, MembersInjector<EmployeeUpgradeFragment>
{
  private Binding<RiderPreferences> mRiderPreferences;
  private Binding<RiderDialogFragment> supertype;

  public EmployeeUpgradeFragment$$InjectAdapter()
  {
    super("com.ubercab.client.feature.employeeupgrade.EmployeeUpgradeFragment", "members/com.ubercab.client.feature.employeeupgrade.EmployeeUpgradeFragment", false, EmployeeUpgradeFragment.class);
  }

  public void attach(Linker paramLinker)
  {
    this.mRiderPreferences = paramLinker.requestBinding("com.ubercab.client.core.app.RiderPreferences", EmployeeUpgradeFragment.class, getClass().getClassLoader());
    this.supertype = paramLinker.requestBinding("members/com.ubercab.client.core.app.RiderDialogFragment", EmployeeUpgradeFragment.class, getClass().getClassLoader(), false, true);
  }

  public EmployeeUpgradeFragment get()
  {
    EmployeeUpgradeFragment localEmployeeUpgradeFragment = new EmployeeUpgradeFragment();
    injectMembers(localEmployeeUpgradeFragment);
    return localEmployeeUpgradeFragment;
  }

  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(this.mRiderPreferences);
    paramSet2.add(this.supertype);
  }

  public void injectMembers(EmployeeUpgradeFragment paramEmployeeUpgradeFragment)
  {
    paramEmployeeUpgradeFragment.mRiderPreferences = ((RiderPreferences)this.mRiderPreferences.get());
    this.supertype.injectMembers(paramEmployeeUpgradeFragment);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.employeeupgrade.EmployeeUpgradeFragment..InjectAdapter
 * JD-Core Version:    0.6.2
 */