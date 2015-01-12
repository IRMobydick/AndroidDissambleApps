package com.ubercab.client.feature.music;

import com.squareup.otto.Bus;
import com.ubercab.library.app.UberFragment;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import javax.inject.Provider;

public final class MusicProviderAuthorizationFragment$$InjectAdapter extends Binding<MusicProviderAuthorizationFragment>
  implements Provider<MusicProviderAuthorizationFragment>, MembersInjector<MusicProviderAuthorizationFragment>
{
  private Binding<Bus> mBus;
  private Binding<UberFragment> supertype;

  public MusicProviderAuthorizationFragment$$InjectAdapter()
  {
    super("com.ubercab.client.feature.music.MusicProviderAuthorizationFragment", "members/com.ubercab.client.feature.music.MusicProviderAuthorizationFragment", false, MusicProviderAuthorizationFragment.class);
  }

  public void attach(Linker paramLinker)
  {
    this.mBus = paramLinker.requestBinding("com.squareup.otto.Bus", MusicProviderAuthorizationFragment.class, getClass().getClassLoader());
    this.supertype = paramLinker.requestBinding("members/com.ubercab.library.app.UberFragment", MusicProviderAuthorizationFragment.class, getClass().getClassLoader(), false, true);
  }

  public MusicProviderAuthorizationFragment get()
  {
    MusicProviderAuthorizationFragment localMusicProviderAuthorizationFragment = new MusicProviderAuthorizationFragment();
    injectMembers(localMusicProviderAuthorizationFragment);
    return localMusicProviderAuthorizationFragment;
  }

  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(this.mBus);
    paramSet2.add(this.supertype);
  }

  public void injectMembers(MusicProviderAuthorizationFragment paramMusicProviderAuthorizationFragment)
  {
    paramMusicProviderAuthorizationFragment.mBus = ((Bus)this.mBus.get());
    this.supertype.injectMembers(paramMusicProviderAuthorizationFragment);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.music.MusicProviderAuthorizationFragment..InjectAdapter
 * JD-Core Version:    0.6.2
 */