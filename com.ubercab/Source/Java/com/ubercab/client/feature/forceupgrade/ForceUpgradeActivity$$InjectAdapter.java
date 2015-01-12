package com.ubercab.client.feature.forceupgrade;

import android.app.ActionBar;
import com.ubercab.client.core.app.RiderPublicActivity;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import javax.inject.Provider;

public final class ForceUpgradeActivity$$InjectAdapter extends Binding<ForceUpgradeActivity>
  implements Provider<ForceUpgradeActivity>, MembersInjector<ForceUpgradeActivity>
{
  private Binding<ActionBar> mActionBar;
  private Binding<RiderPublicActivity> supertype;

  public ForceUpgradeActivity$$InjectAdapter()
  {
    super("com.ubercab.client.feature.forceupgrade.ForceUpgradeActivity", "members/com.ubercab.client.feature.forceupgrade.ForceUpgradeActivity", false, ForceUpgradeActivity.class);
  }

  public void attach(Linker paramLinker)
  {
    this.mActionBar = paramLinker.requestBinding("android.app.ActionBar", ForceUpgradeActivity.class, getClass().getClassLoader());
    this.supertype = paramLinker.requestBinding("members/com.ubercab.client.core.app.RiderPublicActivity", ForceUpgradeActivity.class, getClass().getClassLoader(), false, true);
  }

  public ForceUpgradeActivity get()
  {
    ForceUpgradeActivity localForceUpgradeActivity = new ForceUpgradeActivity();
    injectMembers(localForceUpgradeActivity);
    return localForceUpgradeActivity;
  }

  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(this.mActionBar);
    paramSet2.add(this.supertype);
  }

  public void injectMembers(ForceUpgradeActivity paramForceUpgradeActivity)
  {
    paramForceUpgradeActivity.mActionBar = ((ActionBar)this.mActionBar.get());
    this.supertype.injectMembers(paramForceUpgradeActivity);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.forceupgrade.ForceUpgradeActivity..InjectAdapter
 * JD-Core Version:    0.6.2
 */