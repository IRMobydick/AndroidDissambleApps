package com.ubercab.client.feature.music;

import android.app.ActionBar;
import com.ubercab.client.core.app.RiderPublicActivity;
import com.ubercab.client.core.network.RiderClient;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import javax.inject.Provider;

public final class DisconnectMusicProviderActivity$$InjectAdapter extends Binding<DisconnectMusicProviderActivity>
  implements Provider<DisconnectMusicProviderActivity>, MembersInjector<DisconnectMusicProviderActivity>
{
  private Binding<ActionBar> mActionBar;
  private Binding<RiderClient> mRiderClient;
  private Binding<RiderPublicActivity> supertype;

  public DisconnectMusicProviderActivity$$InjectAdapter()
  {
    super("com.ubercab.client.feature.music.DisconnectMusicProviderActivity", "members/com.ubercab.client.feature.music.DisconnectMusicProviderActivity", false, DisconnectMusicProviderActivity.class);
  }

  public void attach(Linker paramLinker)
  {
    this.mActionBar = paramLinker.requestBinding("android.app.ActionBar", DisconnectMusicProviderActivity.class, getClass().getClassLoader());
    this.mRiderClient = paramLinker.requestBinding("com.ubercab.client.core.network.RiderClient", DisconnectMusicProviderActivity.class, getClass().getClassLoader());
    this.supertype = paramLinker.requestBinding("members/com.ubercab.client.core.app.RiderPublicActivity", DisconnectMusicProviderActivity.class, getClass().getClassLoader(), false, true);
  }

  public DisconnectMusicProviderActivity get()
  {
    DisconnectMusicProviderActivity localDisconnectMusicProviderActivity = new DisconnectMusicProviderActivity();
    injectMembers(localDisconnectMusicProviderActivity);
    return localDisconnectMusicProviderActivity;
  }

  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(this.mActionBar);
    paramSet2.add(this.mRiderClient);
    paramSet2.add(this.supertype);
  }

  public void injectMembers(DisconnectMusicProviderActivity paramDisconnectMusicProviderActivity)
  {
    paramDisconnectMusicProviderActivity.mActionBar = ((ActionBar)this.mActionBar.get());
    paramDisconnectMusicProviderActivity.mRiderClient = ((RiderClient)this.mRiderClient.get());
    this.supertype.injectMembers(paramDisconnectMusicProviderActivity);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.music.DisconnectMusicProviderActivity..InjectAdapter
 * JD-Core Version:    0.6.2
 */