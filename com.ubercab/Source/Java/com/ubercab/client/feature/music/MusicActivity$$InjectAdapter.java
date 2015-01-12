package com.ubercab.client.feature.music;

import android.app.ActionBar;
import com.ubercab.client.core.app.RiderPublicActivity;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import javax.inject.Provider;

public final class MusicActivity$$InjectAdapter extends Binding<MusicActivity>
  implements Provider<MusicActivity>, MembersInjector<MusicActivity>
{
  private Binding<ActionBar> mActionBar;
  private Binding<RiderPublicActivity> supertype;

  public MusicActivity$$InjectAdapter()
  {
    super("com.ubercab.client.feature.music.MusicActivity", "members/com.ubercab.client.feature.music.MusicActivity", false, MusicActivity.class);
  }

  public void attach(Linker paramLinker)
  {
    this.mActionBar = paramLinker.requestBinding("android.app.ActionBar", MusicActivity.class, getClass().getClassLoader());
    this.supertype = paramLinker.requestBinding("members/com.ubercab.client.core.app.RiderPublicActivity", MusicActivity.class, getClass().getClassLoader(), false, true);
  }

  public MusicActivity get()
  {
    MusicActivity localMusicActivity = new MusicActivity();
    injectMembers(localMusicActivity);
    return localMusicActivity;
  }

  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(this.mActionBar);
    paramSet2.add(this.supertype);
  }

  public void injectMembers(MusicActivity paramMusicActivity)
  {
    paramMusicActivity.mActionBar = ((ActionBar)this.mActionBar.get());
    this.supertype.injectMembers(paramMusicActivity);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.music.MusicActivity..InjectAdapter
 * JD-Core Version:    0.6.2
 */