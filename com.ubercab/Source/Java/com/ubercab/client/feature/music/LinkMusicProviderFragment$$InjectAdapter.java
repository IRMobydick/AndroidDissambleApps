package com.ubercab.client.feature.music;

import android.app.ActionBar;
import com.ubercab.client.core.app.RiderFragment;
import com.ubercab.client.core.network.RiderClient;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import javax.inject.Provider;

public final class LinkMusicProviderFragment$$InjectAdapter extends Binding<LinkMusicProviderFragment>
  implements Provider<LinkMusicProviderFragment>, MembersInjector<LinkMusicProviderFragment>
{
  private Binding<ActionBar> mActionBar;
  private Binding<RiderClient> mRiderClient;
  private Binding<RiderFragment> supertype;

  public LinkMusicProviderFragment$$InjectAdapter()
  {
    super("com.ubercab.client.feature.music.LinkMusicProviderFragment", "members/com.ubercab.client.feature.music.LinkMusicProviderFragment", false, LinkMusicProviderFragment.class);
  }

  public void attach(Linker paramLinker)
  {
    this.mActionBar = paramLinker.requestBinding("android.app.ActionBar", LinkMusicProviderFragment.class, getClass().getClassLoader());
    this.mRiderClient = paramLinker.requestBinding("com.ubercab.client.core.network.RiderClient", LinkMusicProviderFragment.class, getClass().getClassLoader());
    this.supertype = paramLinker.requestBinding("members/com.ubercab.client.core.app.RiderFragment", LinkMusicProviderFragment.class, getClass().getClassLoader(), false, true);
  }

  public LinkMusicProviderFragment get()
  {
    LinkMusicProviderFragment localLinkMusicProviderFragment = new LinkMusicProviderFragment();
    injectMembers(localLinkMusicProviderFragment);
    return localLinkMusicProviderFragment;
  }

  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(this.mActionBar);
    paramSet2.add(this.mRiderClient);
    paramSet2.add(this.supertype);
  }

  public void injectMembers(LinkMusicProviderFragment paramLinkMusicProviderFragment)
  {
    paramLinkMusicProviderFragment.mActionBar = ((ActionBar)this.mActionBar.get());
    paramLinkMusicProviderFragment.mRiderClient = ((RiderClient)this.mRiderClient.get());
    this.supertype.injectMembers(paramLinkMusicProviderFragment);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.music.LinkMusicProviderFragment..InjectAdapter
 * JD-Core Version:    0.6.2
 */