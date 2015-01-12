package com.ubercab.client.feature.legal;

import android.app.ActionBar;
import com.squareup.otto.Bus;
import com.ubercab.client.core.app.RiderFragment;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;

public final class LegalFragment$$InjectAdapter extends Binding<LegalFragment>
  implements MembersInjector<LegalFragment>
{
  private Binding<ActionBar> mActionBar;
  private Binding<Bus> mBus;
  private Binding<RiderFragment> supertype;

  public LegalFragment$$InjectAdapter()
  {
    super(null, "members/com.ubercab.client.feature.legal.LegalFragment", false, LegalFragment.class);
  }

  public void attach(Linker paramLinker)
  {
    this.mBus = paramLinker.requestBinding("com.squareup.otto.Bus", LegalFragment.class, getClass().getClassLoader());
    this.mActionBar = paramLinker.requestBinding("android.app.ActionBar", LegalFragment.class, getClass().getClassLoader());
    this.supertype = paramLinker.requestBinding("members/com.ubercab.client.core.app.RiderFragment", LegalFragment.class, getClass().getClassLoader(), false, true);
  }

  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(this.mBus);
    paramSet2.add(this.mActionBar);
    paramSet2.add(this.supertype);
  }

  public void injectMembers(LegalFragment paramLegalFragment)
  {
    paramLegalFragment.mBus = ((Bus)this.mBus.get());
    paramLegalFragment.mActionBar = ((ActionBar)this.mActionBar.get());
    this.supertype.injectMembers(paramLegalFragment);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.legal.LegalFragment..InjectAdapter
 * JD-Core Version:    0.6.2
 */