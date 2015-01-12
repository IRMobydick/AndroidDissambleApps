package com.ubercab.client.core.vendor.facebook;

import com.squareup.otto.Bus;
import com.ubercab.client.core.app.RiderFragment;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import javax.inject.Provider;

public final class FacebookAuthorizationFragment$$InjectAdapter extends Binding<FacebookAuthorizationFragment>
  implements Provider<FacebookAuthorizationFragment>, MembersInjector<FacebookAuthorizationFragment>
{
  private Binding<Bus> mBus;
  private Binding<RiderFragment> supertype;

  public FacebookAuthorizationFragment$$InjectAdapter()
  {
    super("com.ubercab.client.core.vendor.facebook.FacebookAuthorizationFragment", "members/com.ubercab.client.core.vendor.facebook.FacebookAuthorizationFragment", false, FacebookAuthorizationFragment.class);
  }

  public void attach(Linker paramLinker)
  {
    this.mBus = paramLinker.requestBinding("com.squareup.otto.Bus", FacebookAuthorizationFragment.class, getClass().getClassLoader());
    this.supertype = paramLinker.requestBinding("members/com.ubercab.client.core.app.RiderFragment", FacebookAuthorizationFragment.class, getClass().getClassLoader(), false, true);
  }

  public FacebookAuthorizationFragment get()
  {
    FacebookAuthorizationFragment localFacebookAuthorizationFragment = new FacebookAuthorizationFragment();
    injectMembers(localFacebookAuthorizationFragment);
    return localFacebookAuthorizationFragment;
  }

  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(this.mBus);
    paramSet2.add(this.supertype);
  }

  public void injectMembers(FacebookAuthorizationFragment paramFacebookAuthorizationFragment)
  {
    paramFacebookAuthorizationFragment.mBus = ((Bus)this.mBus.get());
    this.supertype.injectMembers(paramFacebookAuthorizationFragment);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.vendor.facebook.FacebookAuthorizationFragment..InjectAdapter
 * JD-Core Version:    0.6.2
 */