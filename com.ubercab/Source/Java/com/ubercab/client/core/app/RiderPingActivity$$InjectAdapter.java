package com.ubercab.client.core.app;

import com.ubercab.client.core.content.PingProvider;
import com.ubercab.client.core.content.SessionPreferences;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;

public final class RiderPingActivity$$InjectAdapter extends Binding<RiderPingActivity>
  implements MembersInjector<RiderPingActivity>
{
  private Binding<PingProvider> mPingProvider;
  private Binding<SessionPreferences> mSessionPreferences;
  private Binding<RiderActivity> supertype;

  public RiderPingActivity$$InjectAdapter()
  {
    super(null, "members/com.ubercab.client.core.app.RiderPingActivity", false, RiderPingActivity.class);
  }

  public void attach(Linker paramLinker)
  {
    this.mSessionPreferences = paramLinker.requestBinding("com.ubercab.client.core.content.SessionPreferences", RiderPingActivity.class, getClass().getClassLoader());
    this.mPingProvider = paramLinker.requestBinding("com.ubercab.client.core.content.PingProvider", RiderPingActivity.class, getClass().getClassLoader());
    this.supertype = paramLinker.requestBinding("members/com.ubercab.client.core.app.RiderActivity", RiderPingActivity.class, getClass().getClassLoader(), false, true);
  }

  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(this.mSessionPreferences);
    paramSet2.add(this.mPingProvider);
    paramSet2.add(this.supertype);
  }

  public void injectMembers(RiderPingActivity paramRiderPingActivity)
  {
    paramRiderPingActivity.mSessionPreferences = ((SessionPreferences)this.mSessionPreferences.get());
    paramRiderPingActivity.mPingProvider = ((PingProvider)this.mPingProvider.get());
    this.supertype.injectMembers(paramRiderPingActivity);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.app.RiderPingActivity..InjectAdapter
 * JD-Core Version:    0.6.2
 */