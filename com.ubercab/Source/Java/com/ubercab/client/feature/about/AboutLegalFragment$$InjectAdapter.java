package com.ubercab.client.feature.about;

import com.ubercab.client.core.content.RiderLocationProvider;
import com.ubercab.client.feature.legal.LegalFragment;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import javax.inject.Provider;

public final class AboutLegalFragment$$InjectAdapter extends Binding<AboutLegalFragment>
  implements Provider<AboutLegalFragment>, MembersInjector<AboutLegalFragment>
{
  private Binding<RiderLocationProvider> mLocationProvider;
  private Binding<LegalFragment> supertype;

  public AboutLegalFragment$$InjectAdapter()
  {
    super("com.ubercab.client.feature.about.AboutLegalFragment", "members/com.ubercab.client.feature.about.AboutLegalFragment", false, AboutLegalFragment.class);
  }

  public void attach(Linker paramLinker)
  {
    this.mLocationProvider = paramLinker.requestBinding("com.ubercab.client.core.content.RiderLocationProvider", AboutLegalFragment.class, getClass().getClassLoader());
    this.supertype = paramLinker.requestBinding("members/com.ubercab.client.feature.legal.LegalFragment", AboutLegalFragment.class, getClass().getClassLoader(), false, true);
  }

  public AboutLegalFragment get()
  {
    AboutLegalFragment localAboutLegalFragment = new AboutLegalFragment();
    injectMembers(localAboutLegalFragment);
    return localAboutLegalFragment;
  }

  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(this.mLocationProvider);
    paramSet2.add(this.supertype);
  }

  public void injectMembers(AboutLegalFragment paramAboutLegalFragment)
  {
    paramAboutLegalFragment.mLocationProvider = ((RiderLocationProvider)this.mLocationProvider.get());
    this.supertype.injectMembers(paramAboutLegalFragment);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.about.AboutLegalFragment..InjectAdapter
 * JD-Core Version:    0.6.2
 */