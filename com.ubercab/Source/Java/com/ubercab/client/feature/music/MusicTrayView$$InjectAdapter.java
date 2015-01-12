package com.ubercab.client.feature.music;

import com.squareup.otto.Bus;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;

public final class MusicTrayView$$InjectAdapter extends Binding<MusicTrayView>
  implements MembersInjector<MusicTrayView>
{
  private Binding<Bus> mBus;

  public MusicTrayView$$InjectAdapter()
  {
    super(null, "members/com.ubercab.client.feature.music.MusicTrayView", false, MusicTrayView.class);
  }

  public void attach(Linker paramLinker)
  {
    this.mBus = paramLinker.requestBinding("com.squareup.otto.Bus", MusicTrayView.class, getClass().getClassLoader());
  }

  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(this.mBus);
  }

  public void injectMembers(MusicTrayView paramMusicTrayView)
  {
    paramMusicTrayView.mBus = ((Bus)this.mBus.get());
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.music.MusicTrayView..InjectAdapter
 * JD-Core Version:    0.6.2
 */