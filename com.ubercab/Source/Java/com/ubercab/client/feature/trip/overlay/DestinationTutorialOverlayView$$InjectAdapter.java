package com.ubercab.client.feature.trip.overlay;

import com.ubercab.client.core.analytics.AnalyticsManager;
import com.ubercab.client.core.content.SessionPreferences;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;

public final class DestinationTutorialOverlayView$$InjectAdapter extends Binding<DestinationTutorialOverlayView>
  implements MembersInjector<DestinationTutorialOverlayView>
{
  private Binding<AnalyticsManager> mAnalyticsManager;
  private Binding<SessionPreferences> mSessionPreferences;

  public DestinationTutorialOverlayView$$InjectAdapter()
  {
    super(null, "members/com.ubercab.client.feature.trip.overlay.DestinationTutorialOverlayView", false, DestinationTutorialOverlayView.class);
  }

  public void attach(Linker paramLinker)
  {
    this.mAnalyticsManager = paramLinker.requestBinding("com.ubercab.client.core.analytics.AnalyticsManager", DestinationTutorialOverlayView.class, getClass().getClassLoader());
    this.mSessionPreferences = paramLinker.requestBinding("com.ubercab.client.core.content.SessionPreferences", DestinationTutorialOverlayView.class, getClass().getClassLoader());
  }

  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(this.mAnalyticsManager);
    paramSet2.add(this.mSessionPreferences);
  }

  public void injectMembers(DestinationTutorialOverlayView paramDestinationTutorialOverlayView)
  {
    paramDestinationTutorialOverlayView.mAnalyticsManager = ((AnalyticsManager)this.mAnalyticsManager.get());
    paramDestinationTutorialOverlayView.mSessionPreferences = ((SessionPreferences)this.mSessionPreferences.get());
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.trip.overlay.DestinationTutorialOverlayView..InjectAdapter
 * JD-Core Version:    0.6.2
 */