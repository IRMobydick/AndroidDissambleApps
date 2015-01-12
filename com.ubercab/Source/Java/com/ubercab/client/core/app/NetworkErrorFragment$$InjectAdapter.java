package com.ubercab.client.core.app;

import com.ubercab.client.core.content.SessionPreferences;
import com.ubercab.client.core.network.RiderClient;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import javax.inject.Provider;

public final class NetworkErrorFragment$$InjectAdapter extends Binding<NetworkErrorFragment>
  implements Provider<NetworkErrorFragment>, MembersInjector<NetworkErrorFragment>
{
  private Binding<RiderClient> mRiderClient;
  private Binding<SessionPreferences> mSessionPreferences;
  private Binding<RiderDialogFragment> supertype;

  public NetworkErrorFragment$$InjectAdapter()
  {
    super("com.ubercab.client.core.app.NetworkErrorFragment", "members/com.ubercab.client.core.app.NetworkErrorFragment", false, NetworkErrorFragment.class);
  }

  public void attach(Linker paramLinker)
  {
    this.mRiderClient = paramLinker.requestBinding("com.ubercab.client.core.network.RiderClient", NetworkErrorFragment.class, getClass().getClassLoader());
    this.mSessionPreferences = paramLinker.requestBinding("com.ubercab.client.core.content.SessionPreferences", NetworkErrorFragment.class, getClass().getClassLoader());
    this.supertype = paramLinker.requestBinding("members/com.ubercab.client.core.app.RiderDialogFragment", NetworkErrorFragment.class, getClass().getClassLoader(), false, true);
  }

  public NetworkErrorFragment get()
  {
    NetworkErrorFragment localNetworkErrorFragment = new NetworkErrorFragment();
    injectMembers(localNetworkErrorFragment);
    return localNetworkErrorFragment;
  }

  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(this.mRiderClient);
    paramSet2.add(this.mSessionPreferences);
    paramSet2.add(this.supertype);
  }

  public void injectMembers(NetworkErrorFragment paramNetworkErrorFragment)
  {
    paramNetworkErrorFragment.mRiderClient = ((RiderClient)this.mRiderClient.get());
    paramNetworkErrorFragment.mSessionPreferences = ((SessionPreferences)this.mSessionPreferences.get());
    this.supertype.injectMembers(paramNetworkErrorFragment);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.app.NetworkErrorFragment..InjectAdapter
 * JD-Core Version:    0.6.2
 */