package com.ubercab.client.feature.mobilemessage;

import com.squareup.otto.Bus;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;

public final class MobileMessageNativeUrlManager$$InjectAdapter extends Binding<MobileMessageNativeUrlManager>
  implements MembersInjector<MobileMessageNativeUrlManager>
{
  private Binding<Bus> mBus;

  public MobileMessageNativeUrlManager$$InjectAdapter()
  {
    super(null, "members/com.ubercab.client.feature.mobilemessage.MobileMessageNativeUrlManager", false, MobileMessageNativeUrlManager.class);
  }

  public void attach(Linker paramLinker)
  {
    this.mBus = paramLinker.requestBinding("com.squareup.otto.Bus", MobileMessageNativeUrlManager.class, getClass().getClassLoader());
  }

  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(this.mBus);
  }

  public void injectMembers(MobileMessageNativeUrlManager paramMobileMessageNativeUrlManager)
  {
    paramMobileMessageNativeUrlManager.mBus = ((Bus)this.mBus.get());
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.mobilemessage.MobileMessageNativeUrlManager..InjectAdapter
 * JD-Core Version:    0.6.2
 */