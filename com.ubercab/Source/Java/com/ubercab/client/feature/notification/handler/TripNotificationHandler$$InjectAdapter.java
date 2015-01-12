package com.ubercab.client.feature.notification.handler;

import com.google.gson.Gson;
import com.ubercab.client.core.app.RiderPreferences;
import com.ubercab.client.feature.notification.NotificationPainter;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import java.util.concurrent.ExecutorService;

public final class TripNotificationHandler$$InjectAdapter extends Binding<TripNotificationHandler>
  implements MembersInjector<TripNotificationHandler>
{
  private Binding<ExecutorService> mExecutorService;
  private Binding<Gson> mGson;
  private Binding<NotificationPainter> mPainter;
  private Binding<RiderPreferences> mPreferences;
  private Binding<NotificationHandler> supertype;

  public TripNotificationHandler$$InjectAdapter()
  {
    super(null, "members/com.ubercab.client.feature.notification.handler.TripNotificationHandler", false, TripNotificationHandler.class);
  }

  public void attach(Linker paramLinker)
  {
    this.mGson = paramLinker.requestBinding("com.google.gson.Gson", TripNotificationHandler.class, getClass().getClassLoader());
    this.mExecutorService = paramLinker.requestBinding("java.util.concurrent.ExecutorService", TripNotificationHandler.class, getClass().getClassLoader());
    this.mPainter = paramLinker.requestBinding("com.ubercab.client.feature.notification.NotificationPainter", TripNotificationHandler.class, getClass().getClassLoader());
    this.mPreferences = paramLinker.requestBinding("com.ubercab.client.core.app.RiderPreferences", TripNotificationHandler.class, getClass().getClassLoader());
    this.supertype = paramLinker.requestBinding("members/com.ubercab.client.feature.notification.handler.NotificationHandler", TripNotificationHandler.class, getClass().getClassLoader(), false, true);
  }

  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(this.mGson);
    paramSet2.add(this.mExecutorService);
    paramSet2.add(this.mPainter);
    paramSet2.add(this.mPreferences);
    paramSet2.add(this.supertype);
  }

  public void injectMembers(TripNotificationHandler paramTripNotificationHandler)
  {
    paramTripNotificationHandler.mGson = ((Gson)this.mGson.get());
    paramTripNotificationHandler.mExecutorService = ((ExecutorService)this.mExecutorService.get());
    paramTripNotificationHandler.mPainter = ((NotificationPainter)this.mPainter.get());
    paramTripNotificationHandler.mPreferences = ((RiderPreferences)this.mPreferences.get());
    this.supertype.injectMembers(paramTripNotificationHandler);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.notification.handler.TripNotificationHandler..InjectAdapter
 * JD-Core Version:    0.6.2
 */