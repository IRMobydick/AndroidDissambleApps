package com.ubercab.client.feature.employee;

import com.squareup.otto.Bus;
import com.ubercab.client.core.app.RiderPreferences;
import com.ubercab.client.core.content.PingProvider;
import com.ubercab.client.core.content.RiderLocationProvider;
import com.ubercab.client.core.content.SessionPreferences;
import com.ubercab.client.feature.mobilemessage.LegacyMobileMessageManager;
import com.ubercab.client.feature.mobilemessage.MobileMessageManager;
import com.ubercab.client.feature.notification.RiderNotificationManager;
import com.ubercab.library.app.UberPreferences;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import javax.inject.Provider;

public final class EmployeeSettingsFragment$$InjectAdapter extends Binding<EmployeeSettingsFragment>
  implements Provider<EmployeeSettingsFragment>, MembersInjector<EmployeeSettingsFragment>
{
  private Binding<Bus> mBus;
  private Binding<ExecutorService> mExecutorService;
  private Binding<LegacyMobileMessageManager> mLegacyMobileMessageManager;
  private Binding<RiderLocationProvider> mLocationProvider;
  private Binding<MobileMessageManager> mMobileMessageManager;
  private Binding<PingProvider> mPingProvider;
  private Binding<RiderNotificationManager> mRiderNotificationManager;
  private Binding<RiderPreferences> mRiderPreferences;
  private Binding<SessionPreferences> mSessionPreferences;
  private Binding<UberPreferences> mUberPreferences;

  public EmployeeSettingsFragment$$InjectAdapter()
  {
    super("com.ubercab.client.feature.employee.EmployeeSettingsFragment", "members/com.ubercab.client.feature.employee.EmployeeSettingsFragment", false, EmployeeSettingsFragment.class);
  }

  public void attach(Linker paramLinker)
  {
    this.mBus = paramLinker.requestBinding("com.squareup.otto.Bus", EmployeeSettingsFragment.class, getClass().getClassLoader());
    this.mExecutorService = paramLinker.requestBinding("java.util.concurrent.ExecutorService", EmployeeSettingsFragment.class, getClass().getClassLoader());
    this.mLegacyMobileMessageManager = paramLinker.requestBinding("com.ubercab.client.feature.mobilemessage.LegacyMobileMessageManager", EmployeeSettingsFragment.class, getClass().getClassLoader());
    this.mMobileMessageManager = paramLinker.requestBinding("com.ubercab.client.feature.mobilemessage.MobileMessageManager", EmployeeSettingsFragment.class, getClass().getClassLoader());
    this.mPingProvider = paramLinker.requestBinding("com.ubercab.client.core.content.PingProvider", EmployeeSettingsFragment.class, getClass().getClassLoader());
    this.mLocationProvider = paramLinker.requestBinding("com.ubercab.client.core.content.RiderLocationProvider", EmployeeSettingsFragment.class, getClass().getClassLoader());
    this.mRiderNotificationManager = paramLinker.requestBinding("com.ubercab.client.feature.notification.RiderNotificationManager", EmployeeSettingsFragment.class, getClass().getClassLoader());
    this.mRiderPreferences = paramLinker.requestBinding("com.ubercab.client.core.app.RiderPreferences", EmployeeSettingsFragment.class, getClass().getClassLoader());
    this.mSessionPreferences = paramLinker.requestBinding("com.ubercab.client.core.content.SessionPreferences", EmployeeSettingsFragment.class, getClass().getClassLoader());
    this.mUberPreferences = paramLinker.requestBinding("com.ubercab.library.app.UberPreferences", EmployeeSettingsFragment.class, getClass().getClassLoader());
  }

  public EmployeeSettingsFragment get()
  {
    EmployeeSettingsFragment localEmployeeSettingsFragment = new EmployeeSettingsFragment();
    injectMembers(localEmployeeSettingsFragment);
    return localEmployeeSettingsFragment;
  }

  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(this.mBus);
    paramSet2.add(this.mExecutorService);
    paramSet2.add(this.mLegacyMobileMessageManager);
    paramSet2.add(this.mMobileMessageManager);
    paramSet2.add(this.mPingProvider);
    paramSet2.add(this.mLocationProvider);
    paramSet2.add(this.mRiderNotificationManager);
    paramSet2.add(this.mRiderPreferences);
    paramSet2.add(this.mSessionPreferences);
    paramSet2.add(this.mUberPreferences);
  }

  public void injectMembers(EmployeeSettingsFragment paramEmployeeSettingsFragment)
  {
    paramEmployeeSettingsFragment.mBus = ((Bus)this.mBus.get());
    paramEmployeeSettingsFragment.mExecutorService = ((ExecutorService)this.mExecutorService.get());
    paramEmployeeSettingsFragment.mLegacyMobileMessageManager = ((LegacyMobileMessageManager)this.mLegacyMobileMessageManager.get());
    paramEmployeeSettingsFragment.mMobileMessageManager = ((MobileMessageManager)this.mMobileMessageManager.get());
    paramEmployeeSettingsFragment.mPingProvider = ((PingProvider)this.mPingProvider.get());
    paramEmployeeSettingsFragment.mLocationProvider = ((RiderLocationProvider)this.mLocationProvider.get());
    paramEmployeeSettingsFragment.mRiderNotificationManager = ((RiderNotificationManager)this.mRiderNotificationManager.get());
    paramEmployeeSettingsFragment.mRiderPreferences = ((RiderPreferences)this.mRiderPreferences.get());
    paramEmployeeSettingsFragment.mSessionPreferences = ((SessionPreferences)this.mSessionPreferences.get());
    paramEmployeeSettingsFragment.mUberPreferences = ((UberPreferences)this.mUberPreferences.get());
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.employee.EmployeeSettingsFragment..InjectAdapter
 * JD-Core Version:    0.6.2
 */