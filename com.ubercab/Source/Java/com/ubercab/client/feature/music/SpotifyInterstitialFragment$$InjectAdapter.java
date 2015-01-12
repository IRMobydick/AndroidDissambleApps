package com.ubercab.client.feature.music;

import android.app.ActionBar;
import com.squareup.otto.Bus;
import com.ubercab.client.core.app.RiderFragment;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import javax.inject.Provider;

public final class SpotifyInterstitialFragment$$InjectAdapter extends Binding<SpotifyInterstitialFragment>
  implements Provider<SpotifyInterstitialFragment>, MembersInjector<SpotifyInterstitialFragment>
{
  private Binding<ActionBar> mActionBar;
  private Binding<Bus> mBus;
  private Binding<RiderFragment> supertype;

  public SpotifyInterstitialFragment$$InjectAdapter()
  {
    super("com.ubercab.client.feature.music.SpotifyInterstitialFragment", "members/com.ubercab.client.feature.music.SpotifyInterstitialFragment", false, SpotifyInterstitialFragment.class);
  }

  public void attach(Linker paramLinker)
  {
    this.mActionBar = paramLinker.requestBinding("android.app.ActionBar", SpotifyInterstitialFragment.class, getClass().getClassLoader());
    this.mBus = paramLinker.requestBinding("com.squareup.otto.Bus", SpotifyInterstitialFragment.class, getClass().getClassLoader());
    this.supertype = paramLinker.requestBinding("members/com.ubercab.client.core.app.RiderFragment", SpotifyInterstitialFragment.class, getClass().getClassLoader(), false, true);
  }

  public SpotifyInterstitialFragment get()
  {
    SpotifyInterstitialFragment localSpotifyInterstitialFragment = new SpotifyInterstitialFragment();
    injectMembers(localSpotifyInterstitialFragment);
    return localSpotifyInterstitialFragment;
  }

  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(this.mActionBar);
    paramSet2.add(this.mBus);
    paramSet2.add(this.supertype);
  }

  public void injectMembers(SpotifyInterstitialFragment paramSpotifyInterstitialFragment)
  {
    paramSpotifyInterstitialFragment.mActionBar = ((ActionBar)this.mActionBar.get());
    paramSpotifyInterstitialFragment.mBus = ((Bus)this.mBus.get());
    this.supertype.injectMembers(paramSpotifyInterstitialFragment);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.music.SpotifyInterstitialFragment..InjectAdapter
 * JD-Core Version:    0.6.2
 */