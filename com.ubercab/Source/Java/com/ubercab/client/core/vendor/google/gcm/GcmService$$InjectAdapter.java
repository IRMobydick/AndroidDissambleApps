package com.ubercab.client.core.vendor.google.gcm;

import com.google.gson.Gson;
import com.ubercab.client.feature.notification.RiderNotificationManager;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import javax.inject.Provider;

public final class GcmService$$InjectAdapter extends Binding<GcmService>
  implements Provider<GcmService>, MembersInjector<GcmService>
{
  private Binding<Gson> mGson;
  private Binding<RiderNotificationManager> mRiderNotificationManager;

  public GcmService$$InjectAdapter()
  {
    super("com.ubercab.client.core.vendor.google.gcm.GcmService", "members/com.ubercab.client.core.vendor.google.gcm.GcmService", false, GcmService.class);
  }

  public void attach(Linker paramLinker)
  {
    this.mGson = paramLinker.requestBinding("com.google.gson.Gson", GcmService.class, getClass().getClassLoader());
    this.mRiderNotificationManager = paramLinker.requestBinding("com.ubercab.client.feature.notification.RiderNotificationManager", GcmService.class, getClass().getClassLoader());
  }

  public GcmService get()
  {
    GcmService localGcmService = new GcmService();
    injectMembers(localGcmService);
    return localGcmService;
  }

  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(this.mGson);
    paramSet2.add(this.mRiderNotificationManager);
  }

  public void injectMembers(GcmService paramGcmService)
  {
    paramGcmService.mGson = ((Gson)this.mGson.get());
    paramGcmService.mRiderNotificationManager = ((RiderNotificationManager)this.mRiderNotificationManager.get());
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.vendor.google.gcm.GcmService..InjectAdapter
 * JD-Core Version:    0.6.2
 */