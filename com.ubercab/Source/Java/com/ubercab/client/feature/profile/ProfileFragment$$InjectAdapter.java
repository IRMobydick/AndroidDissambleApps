package com.ubercab.client.feature.profile;

import android.app.ActionBar;
import android.content.Context;
import android.view.LayoutInflater;
import com.squareup.otto.Bus;
import com.squareup.picasso.Picasso;
import com.ubercab.client.core.app.RiderFragment;
import com.ubercab.client.core.app.RiderPreferences;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import javax.inject.Provider;

public final class ProfileFragment$$InjectAdapter extends Binding<ProfileFragment>
  implements Provider<ProfileFragment>, MembersInjector<ProfileFragment>
{
  private Binding<ActionBar> mActionBar;
  private Binding<Bus> mBus;
  private Binding<Context> mContext;
  private Binding<LayoutInflater> mLayoutInflater;
  private Binding<Picasso> mPicasso;
  private Binding<RiderPreferences> mRiderPreferences;
  private Binding<RiderFragment> supertype;

  public ProfileFragment$$InjectAdapter()
  {
    super("com.ubercab.client.feature.profile.ProfileFragment", "members/com.ubercab.client.feature.profile.ProfileFragment", false, ProfileFragment.class);
  }

  public void attach(Linker paramLinker)
  {
    this.mActionBar = paramLinker.requestBinding("android.app.ActionBar", ProfileFragment.class, getClass().getClassLoader());
    this.mBus = paramLinker.requestBinding("com.squareup.otto.Bus", ProfileFragment.class, getClass().getClassLoader());
    this.mContext = paramLinker.requestBinding("@com.ubercab.library.app.annotation.ForActivity()/android.content.Context", ProfileFragment.class, getClass().getClassLoader());
    this.mLayoutInflater = paramLinker.requestBinding("android.view.LayoutInflater", ProfileFragment.class, getClass().getClassLoader());
    this.mPicasso = paramLinker.requestBinding("com.squareup.picasso.Picasso", ProfileFragment.class, getClass().getClassLoader());
    this.mRiderPreferences = paramLinker.requestBinding("com.ubercab.client.core.app.RiderPreferences", ProfileFragment.class, getClass().getClassLoader());
    this.supertype = paramLinker.requestBinding("members/com.ubercab.client.core.app.RiderFragment", ProfileFragment.class, getClass().getClassLoader(), false, true);
  }

  public ProfileFragment get()
  {
    ProfileFragment localProfileFragment = new ProfileFragment();
    injectMembers(localProfileFragment);
    return localProfileFragment;
  }

  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(this.mActionBar);
    paramSet2.add(this.mBus);
    paramSet2.add(this.mContext);
    paramSet2.add(this.mLayoutInflater);
    paramSet2.add(this.mPicasso);
    paramSet2.add(this.mRiderPreferences);
    paramSet2.add(this.supertype);
  }

  public void injectMembers(ProfileFragment paramProfileFragment)
  {
    paramProfileFragment.mActionBar = ((ActionBar)this.mActionBar.get());
    paramProfileFragment.mBus = ((Bus)this.mBus.get());
    paramProfileFragment.mContext = ((Context)this.mContext.get());
    paramProfileFragment.mLayoutInflater = ((LayoutInflater)this.mLayoutInflater.get());
    paramProfileFragment.mPicasso = ((Picasso)this.mPicasso.get());
    paramProfileFragment.mRiderPreferences = ((RiderPreferences)this.mRiderPreferences.get());
    this.supertype.injectMembers(paramProfileFragment);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.profile.ProfileFragment..InjectAdapter
 * JD-Core Version:    0.6.2
 */