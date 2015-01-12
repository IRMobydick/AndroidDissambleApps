package com.ubercab.client.feature.trip.overlay;

import com.ubercab.client.core.app.RiderPreferences;
import com.ubercab.client.core.content.SessionPreferences;
import com.ubercab.client.feature.trip.TripUIStateManager;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;

public final class DispatchDestinationOverlayView$$InjectAdapter extends Binding<DispatchDestinationOverlayView>
  implements MembersInjector<DispatchDestinationOverlayView>
{
  private Binding<RiderPreferences> mRiderPreferences;
  private Binding<SessionPreferences> mSessionPreferences;
  private Binding<TripUIStateManager> mTripUIStateManager;

  public DispatchDestinationOverlayView$$InjectAdapter()
  {
    super(null, "members/com.ubercab.client.feature.trip.overlay.DispatchDestinationOverlayView", false, DispatchDestinationOverlayView.class);
  }

  public void attach(Linker paramLinker)
  {
    this.mRiderPreferences = paramLinker.requestBinding("com.ubercab.client.core.app.RiderPreferences", DispatchDestinationOverlayView.class, getClass().getClassLoader());
    this.mSessionPreferences = paramLinker.requestBinding("com.ubercab.client.core.content.SessionPreferences", DispatchDestinationOverlayView.class, getClass().getClassLoader());
    this.mTripUIStateManager = paramLinker.requestBinding("com.ubercab.client.feature.trip.TripUIStateManager", DispatchDestinationOverlayView.class, getClass().getClassLoader());
  }

  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(this.mRiderPreferences);
    paramSet2.add(this.mSessionPreferences);
    paramSet2.add(this.mTripUIStateManager);
  }

  public void injectMembers(DispatchDestinationOverlayView paramDispatchDestinationOverlayView)
  {
    paramDispatchDestinationOverlayView.mRiderPreferences = ((RiderPreferences)this.mRiderPreferences.get());
    paramDispatchDestinationOverlayView.mSessionPreferences = ((SessionPreferences)this.mSessionPreferences.get());
    paramDispatchDestinationOverlayView.mTripUIStateManager = ((TripUIStateManager)this.mTripUIStateManager.get());
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.trip.overlay.DispatchDestinationOverlayView..InjectAdapter
 * JD-Core Version:    0.6.2
 */