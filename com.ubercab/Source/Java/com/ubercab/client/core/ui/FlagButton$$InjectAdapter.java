package com.ubercab.client.core.ui;

import com.google.gson.Gson;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;

public final class FlagButton$$InjectAdapter extends Binding<FlagButton>
  implements MembersInjector<FlagButton>
{
  private Binding<Gson> mGson;

  public FlagButton$$InjectAdapter()
  {
    super(null, "members/com.ubercab.client.core.ui.FlagButton", false, FlagButton.class);
  }

  public void attach(Linker paramLinker)
  {
    this.mGson = paramLinker.requestBinding("com.google.gson.Gson", FlagButton.class, getClass().getClassLoader());
  }

  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(this.mGson);
  }

  public void injectMembers(FlagButton paramFlagButton)
  {
    paramFlagButton.mGson = ((Gson)this.mGson.get());
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.ui.FlagButton..InjectAdapter
 * JD-Core Version:    0.6.2
 */