package com.ubercab.client.feature.music;

import com.squareup.picasso.Picasso;
import com.ubercab.library.app.UberFragment;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import javax.inject.Provider;

public final class BrowseFragment$$InjectAdapter extends Binding<BrowseFragment>
  implements Provider<BrowseFragment>, MembersInjector<BrowseFragment>
{
  private Binding<Picasso> mPicasso;
  private Binding<UberFragment> supertype;

  public BrowseFragment$$InjectAdapter()
  {
    super("com.ubercab.client.feature.music.BrowseFragment", "members/com.ubercab.client.feature.music.BrowseFragment", false, BrowseFragment.class);
  }

  public void attach(Linker paramLinker)
  {
    this.mPicasso = paramLinker.requestBinding("com.squareup.picasso.Picasso", BrowseFragment.class, getClass().getClassLoader());
    this.supertype = paramLinker.requestBinding("members/com.ubercab.library.app.UberFragment", BrowseFragment.class, getClass().getClassLoader(), false, true);
  }

  public BrowseFragment get()
  {
    BrowseFragment localBrowseFragment = new BrowseFragment();
    injectMembers(localBrowseFragment);
    return localBrowseFragment;
  }

  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(this.mPicasso);
    paramSet2.add(this.supertype);
  }

  public void injectMembers(BrowseFragment paramBrowseFragment)
  {
    paramBrowseFragment.mPicasso = ((Picasso)this.mPicasso.get());
    this.supertype.injectMembers(paramBrowseFragment);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.music.BrowseFragment..InjectAdapter
 * JD-Core Version:    0.6.2
 */