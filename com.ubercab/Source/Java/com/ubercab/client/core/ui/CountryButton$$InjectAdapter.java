package com.ubercab.client.core.ui;

import com.google.gson.Gson;
import com.ubercab.ui.UberTextView;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;

public final class CountryButton$$InjectAdapter extends Binding<CountryButton>
  implements MembersInjector<CountryButton>
{
  private Binding<Gson> mGson;
  private Binding<UberTextView> supertype;

  public CountryButton$$InjectAdapter()
  {
    super(null, "members/com.ubercab.client.core.ui.CountryButton", false, CountryButton.class);
  }

  public void attach(Linker paramLinker)
  {
    this.mGson = paramLinker.requestBinding("com.google.gson.Gson", CountryButton.class, getClass().getClassLoader());
    this.supertype = paramLinker.requestBinding("members/com.ubercab.ui.UberTextView", CountryButton.class, getClass().getClassLoader(), false, true);
  }

  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(this.mGson);
    paramSet2.add(this.supertype);
  }

  public void injectMembers(CountryButton paramCountryButton)
  {
    paramCountryButton.mGson = ((Gson)this.mGson.get());
    this.supertype.injectMembers(paramCountryButton);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.ui.CountryButton..InjectAdapter
 * JD-Core Version:    0.6.2
 */