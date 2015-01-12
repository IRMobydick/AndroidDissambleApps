package com.ubercab.client.core.locale;

import com.google.gson.Gson;
import com.ubercab.client.core.app.RiderFragment;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import javax.inject.Provider;

public final class SelectCountryFragment$$InjectAdapter extends Binding<SelectCountryFragment>
  implements Provider<SelectCountryFragment>, MembersInjector<SelectCountryFragment>
{
  private Binding<Gson> mGson;
  private Binding<RiderFragment> supertype;

  public SelectCountryFragment$$InjectAdapter()
  {
    super("com.ubercab.client.core.locale.SelectCountryFragment", "members/com.ubercab.client.core.locale.SelectCountryFragment", false, SelectCountryFragment.class);
  }

  public void attach(Linker paramLinker)
  {
    this.mGson = paramLinker.requestBinding("com.google.gson.Gson", SelectCountryFragment.class, getClass().getClassLoader());
    this.supertype = paramLinker.requestBinding("members/com.ubercab.client.core.app.RiderFragment", SelectCountryFragment.class, getClass().getClassLoader(), false, true);
  }

  public SelectCountryFragment get()
  {
    SelectCountryFragment localSelectCountryFragment = new SelectCountryFragment();
    injectMembers(localSelectCountryFragment);
    return localSelectCountryFragment;
  }

  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(this.mGson);
    paramSet2.add(this.supertype);
  }

  public void injectMembers(SelectCountryFragment paramSelectCountryFragment)
  {
    paramSelectCountryFragment.mGson = ((Gson)this.mGson.get());
    this.supertype.injectMembers(paramSelectCountryFragment);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.locale.SelectCountryFragment..InjectAdapter
 * JD-Core Version:    0.6.2
 */