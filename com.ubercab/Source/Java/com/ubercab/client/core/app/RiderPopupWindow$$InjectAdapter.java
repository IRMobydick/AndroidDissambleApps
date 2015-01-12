package com.ubercab.client.core.app;

import com.squareup.otto.Bus;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;

public final class RiderPopupWindow$$InjectAdapter extends Binding<RiderPopupWindow>
  implements MembersInjector<RiderPopupWindow>
{
  private Binding<Bus> mBus;

  public RiderPopupWindow$$InjectAdapter()
  {
    super(null, "members/com.ubercab.client.core.app.RiderPopupWindow", false, RiderPopupWindow.class);
  }

  public void attach(Linker paramLinker)
  {
    this.mBus = paramLinker.requestBinding("com.squareup.otto.Bus", RiderPopupWindow.class, getClass().getClassLoader());
  }

  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(this.mBus);
  }

  public void injectMembers(RiderPopupWindow paramRiderPopupWindow)
  {
    paramRiderPopupWindow.mBus = ((Bus)this.mBus.get());
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.app.RiderPopupWindow..InjectAdapter
 * JD-Core Version:    0.6.2
 */