package com.ubercab.client.feature.music.overlay;

import com.ubercab.client.core.content.SessionPreferences;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;

public final class AddMusicOverlayView$$InjectAdapter extends Binding<AddMusicOverlayView>
  implements MembersInjector<AddMusicOverlayView>
{
  private Binding<SessionPreferences> mSessionPreferences;

  public AddMusicOverlayView$$InjectAdapter()
  {
    super(null, "members/com.ubercab.client.feature.music.overlay.AddMusicOverlayView", false, AddMusicOverlayView.class);
  }

  public void attach(Linker paramLinker)
  {
    this.mSessionPreferences = paramLinker.requestBinding("com.ubercab.client.core.content.SessionPreferences", AddMusicOverlayView.class, getClass().getClassLoader());
  }

  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(this.mSessionPreferences);
  }

  public void injectMembers(AddMusicOverlayView paramAddMusicOverlayView)
  {
    paramAddMusicOverlayView.mSessionPreferences = ((SessionPreferences)this.mSessionPreferences.get());
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.music.overlay.AddMusicOverlayView..InjectAdapter
 * JD-Core Version:    0.6.2
 */