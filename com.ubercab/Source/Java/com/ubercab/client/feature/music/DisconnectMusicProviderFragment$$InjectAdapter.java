package com.ubercab.client.feature.music;

import com.squareup.otto.Bus;
import com.ubercab.library.app.UberFragment;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import javax.inject.Provider;

public final class DisconnectMusicProviderFragment$$InjectAdapter extends Binding<DisconnectMusicProviderFragment>
  implements Provider<DisconnectMusicProviderFragment>, MembersInjector<DisconnectMusicProviderFragment>
{
  private Binding<Bus> mBus;
  private Binding<UberFragment> supertype;

  public DisconnectMusicProviderFragment$$InjectAdapter()
  {
    super("com.ubercab.client.feature.music.DisconnectMusicProviderFragment", "members/com.ubercab.client.feature.music.DisconnectMusicProviderFragment", false, DisconnectMusicProviderFragment.class);
  }

  public void attach(Linker paramLinker)
  {
    this.mBus = paramLinker.requestBinding("com.squareup.otto.Bus", DisconnectMusicProviderFragment.class, getClass().getClassLoader());
    this.supertype = paramLinker.requestBinding("members/com.ubercab.library.app.UberFragment", DisconnectMusicProviderFragment.class, getClass().getClassLoader(), false, true);
  }

  public DisconnectMusicProviderFragment get()
  {
    DisconnectMusicProviderFragment localDisconnectMusicProviderFragment = new DisconnectMusicProviderFragment();
    injectMembers(localDisconnectMusicProviderFragment);
    return localDisconnectMusicProviderFragment;
  }

  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(this.mBus);
    paramSet2.add(this.supertype);
  }

  public void injectMembers(DisconnectMusicProviderFragment paramDisconnectMusicProviderFragment)
  {
    paramDisconnectMusicProviderFragment.mBus = ((Bus)this.mBus.get());
    this.supertype.injectMembers(paramDisconnectMusicProviderFragment);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.music.DisconnectMusicProviderFragment..InjectAdapter
 * JD-Core Version:    0.6.2
 */