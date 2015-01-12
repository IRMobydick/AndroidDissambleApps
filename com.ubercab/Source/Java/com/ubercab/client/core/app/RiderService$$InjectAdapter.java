package com.ubercab.client.core.app;

import com.google.gson.Gson;
import com.squareup.otto.Bus;
import com.ubercab.client.core.analytics.AnalyticsManager;
import com.ubercab.client.core.content.SessionPreferences;
import com.ubercab.client.core.network.RiderClient;
import com.ubercab.library.app.UberPreferences;
import com.ubercab.library.app.UberService;
import com.ubercab.library.network.FailoverStrategy;
import com.ubercab.library.network.UberEndpoint;
import com.ubercab.library.network.dispatch.DispatchClient;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import javax.inject.Provider;

public final class RiderService$$InjectAdapter extends Binding<RiderService>
  implements Provider<RiderService>, MembersInjector<RiderService>
{
  private Binding<AnalyticsManager> mAnalyticsManager;
  private Binding<Bus> mBus;
  private Binding<DispatchClient> mCnClient;
  private Binding<FailoverStrategy> mDefaultFailoverStrategy;
  private Binding<Gson> mGson;
  private Binding<RiderClient> mRiderClient;
  private Binding<SessionPreferences> mSessionPreferences;
  private Binding<UberEndpoint> mUberEndpoint;
  private Binding<UberPreferences> mUberPreferences;
  private Binding<UberService> supertype;

  public RiderService$$InjectAdapter()
  {
    super("com.ubercab.client.core.app.RiderService", "members/com.ubercab.client.core.app.RiderService", false, RiderService.class);
  }

  public void attach(Linker paramLinker)
  {
    this.mAnalyticsManager = paramLinker.requestBinding("com.ubercab.client.core.analytics.AnalyticsManager", RiderService.class, getClass().getClassLoader());
    this.mBus = paramLinker.requestBinding("com.squareup.otto.Bus", RiderService.class, getClass().getClassLoader());
    this.mCnClient = paramLinker.requestBinding("com.ubercab.library.network.dispatch.DispatchClient", RiderService.class, getClass().getClassLoader());
    this.mDefaultFailoverStrategy = paramLinker.requestBinding("@com.ubercab.library.app.annotation.ForCn()/com.ubercab.library.network.FailoverStrategy", RiderService.class, getClass().getClassLoader());
    this.mGson = paramLinker.requestBinding("com.google.gson.Gson", RiderService.class, getClass().getClassLoader());
    this.mRiderClient = paramLinker.requestBinding("com.ubercab.client.core.network.RiderClient", RiderService.class, getClass().getClassLoader());
    this.mSessionPreferences = paramLinker.requestBinding("com.ubercab.client.core.content.SessionPreferences", RiderService.class, getClass().getClassLoader());
    this.mUberPreferences = paramLinker.requestBinding("com.ubercab.library.app.UberPreferences", RiderService.class, getClass().getClassLoader());
    this.mUberEndpoint = paramLinker.requestBinding("@com.ubercab.library.app.annotation.ForCn()/com.ubercab.library.network.UberEndpoint", RiderService.class, getClass().getClassLoader());
    this.supertype = paramLinker.requestBinding("members/com.ubercab.library.app.UberService", RiderService.class, getClass().getClassLoader(), false, true);
  }

  public RiderService get()
  {
    RiderService localRiderService = new RiderService();
    injectMembers(localRiderService);
    return localRiderService;
  }

  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(this.mAnalyticsManager);
    paramSet2.add(this.mBus);
    paramSet2.add(this.mCnClient);
    paramSet2.add(this.mDefaultFailoverStrategy);
    paramSet2.add(this.mGson);
    paramSet2.add(this.mRiderClient);
    paramSet2.add(this.mSessionPreferences);
    paramSet2.add(this.mUberPreferences);
    paramSet2.add(this.mUberEndpoint);
    paramSet2.add(this.supertype);
  }

  public void injectMembers(RiderService paramRiderService)
  {
    paramRiderService.mAnalyticsManager = ((AnalyticsManager)this.mAnalyticsManager.get());
    paramRiderService.mBus = ((Bus)this.mBus.get());
    paramRiderService.mCnClient = ((DispatchClient)this.mCnClient.get());
    paramRiderService.mDefaultFailoverStrategy = ((FailoverStrategy)this.mDefaultFailoverStrategy.get());
    paramRiderService.mGson = ((Gson)this.mGson.get());
    paramRiderService.mRiderClient = ((RiderClient)this.mRiderClient.get());
    paramRiderService.mSessionPreferences = ((SessionPreferences)this.mSessionPreferences.get());
    paramRiderService.mUberPreferences = ((UberPreferences)this.mUberPreferences.get());
    paramRiderService.mUberEndpoint = ((UberEndpoint)this.mUberEndpoint.get());
    this.supertype.injectMembers(paramRiderService);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.app.RiderService..InjectAdapter
 * JD-Core Version:    0.6.2
 */