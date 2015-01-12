package com.ubercab.client.feature.trip.driver;

import com.squareup.picasso.Picasso;
import com.ubercab.client.core.app.RiderPreferences;
import com.ubercab.client.feature.trip.TripUIStateManager;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;

public final class DriverView$$InjectAdapter extends Binding<DriverView>
  implements MembersInjector<DriverView>
{
  private Binding<Picasso> mPicasso;
  private Binding<RiderPreferences> mRiderPreferences;
  private Binding<TripUIStateManager> mTripUIStateManager;

  public DriverView$$InjectAdapter()
  {
    super(null, "members/com.ubercab.client.feature.trip.driver.DriverView", false, DriverView.class);
  }

  public void attach(Linker paramLinker)
  {
    this.mPicasso = paramLinker.requestBinding("com.squareup.picasso.Picasso", DriverView.class, getClass().getClassLoader());
    this.mTripUIStateManager = paramLinker.requestBinding("com.ubercab.client.feature.trip.TripUIStateManager", DriverView.class, getClass().getClassLoader());
    this.mRiderPreferences = paramLinker.requestBinding("com.ubercab.client.core.app.RiderPreferences", DriverView.class, getClass().getClassLoader());
  }

  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(this.mPicasso);
    paramSet2.add(this.mTripUIStateManager);
    paramSet2.add(this.mRiderPreferences);
  }

  public void injectMembers(DriverView paramDriverView)
  {
    paramDriverView.mPicasso = ((Picasso)this.mPicasso.get());
    paramDriverView.mTripUIStateManager = ((TripUIStateManager)this.mTripUIStateManager.get());
    paramDriverView.mRiderPreferences = ((RiderPreferences)this.mRiderPreferences.get());
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.trip.driver.DriverView..InjectAdapter
 * JD-Core Version:    0.6.2
 */