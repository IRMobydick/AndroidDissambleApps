package com.ubercab.client.feature.about;

import android.app.ActionBar;
import android.content.Context;
import android.view.LayoutInflater;
import com.squareup.otto.Bus;
import com.ubercab.client.core.app.RiderFragment;
import com.ubercab.client.core.content.RiderLocationProvider;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import javax.inject.Provider;

public final class AboutFragment$$InjectAdapter extends Binding<AboutFragment>
  implements Provider<AboutFragment>, MembersInjector<AboutFragment>
{
  private Binding<ActionBar> mActionBar;
  private Binding<Bus> mBus;
  private Binding<Context> mContext;
  private Binding<LayoutInflater> mLayoutInflater;
  private Binding<RiderLocationProvider> mLocationProvider;
  private Binding<RiderFragment> supertype;

  public AboutFragment$$InjectAdapter()
  {
    super("com.ubercab.client.feature.about.AboutFragment", "members/com.ubercab.client.feature.about.AboutFragment", false, AboutFragment.class);
  }

  public void attach(Linker paramLinker)
  {
    this.mBus = paramLinker.requestBinding("com.squareup.otto.Bus", AboutFragment.class, getClass().getClassLoader());
    this.mActionBar = paramLinker.requestBinding("android.app.ActionBar", AboutFragment.class, getClass().getClassLoader());
    this.mContext = paramLinker.requestBinding("@com.ubercab.library.app.annotation.ForActivity()/android.content.Context", AboutFragment.class, getClass().getClassLoader());
    this.mLayoutInflater = paramLinker.requestBinding("android.view.LayoutInflater", AboutFragment.class, getClass().getClassLoader());
    this.mLocationProvider = paramLinker.requestBinding("com.ubercab.client.core.content.RiderLocationProvider", AboutFragment.class, getClass().getClassLoader());
    this.supertype = paramLinker.requestBinding("members/com.ubercab.client.core.app.RiderFragment", AboutFragment.class, getClass().getClassLoader(), false, true);
  }

  public AboutFragment get()
  {
    AboutFragment localAboutFragment = new AboutFragment();
    injectMembers(localAboutFragment);
    return localAboutFragment;
  }

  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(this.mBus);
    paramSet2.add(this.mActionBar);
    paramSet2.add(this.mContext);
    paramSet2.add(this.mLayoutInflater);
    paramSet2.add(this.mLocationProvider);
    paramSet2.add(this.supertype);
  }

  public void injectMembers(AboutFragment paramAboutFragment)
  {
    paramAboutFragment.mBus = ((Bus)this.mBus.get());
    paramAboutFragment.mActionBar = ((ActionBar)this.mActionBar.get());
    paramAboutFragment.mContext = ((Context)this.mContext.get());
    paramAboutFragment.mLayoutInflater = ((LayoutInflater)this.mLayoutInflater.get());
    paramAboutFragment.mLocationProvider = ((RiderLocationProvider)this.mLocationProvider.get());
    this.supertype.injectMembers(paramAboutFragment);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.about.AboutFragment..InjectAdapter
 * JD-Core Version:    0.6.2
 */