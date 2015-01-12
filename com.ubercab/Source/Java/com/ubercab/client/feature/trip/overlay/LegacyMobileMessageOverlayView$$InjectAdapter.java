package com.ubercab.client.feature.trip.overlay;

import com.ubercab.client.feature.mobilemessage.LegacyMobileMessageManager;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;

public final class LegacyMobileMessageOverlayView$$InjectAdapter extends Binding<LegacyMobileMessageOverlayView>
  implements MembersInjector<LegacyMobileMessageOverlayView>
{
  private Binding<LegacyMobileMessageManager> mLegacyMobileMessageManager;

  public LegacyMobileMessageOverlayView$$InjectAdapter()
  {
    super(null, "members/com.ubercab.client.feature.trip.overlay.LegacyMobileMessageOverlayView", false, LegacyMobileMessageOverlayView.class);
  }

  public void attach(Linker paramLinker)
  {
    this.mLegacyMobileMessageManager = paramLinker.requestBinding("com.ubercab.client.feature.mobilemessage.LegacyMobileMessageManager", LegacyMobileMessageOverlayView.class, getClass().getClassLoader());
  }

  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(this.mLegacyMobileMessageManager);
  }

  public void injectMembers(LegacyMobileMessageOverlayView paramLegacyMobileMessageOverlayView)
  {
    paramLegacyMobileMessageOverlayView.mLegacyMobileMessageManager = ((LegacyMobileMessageManager)this.mLegacyMobileMessageManager.get());
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.trip.overlay.LegacyMobileMessageOverlayView..InjectAdapter
 * JD-Core Version:    0.6.2
 */