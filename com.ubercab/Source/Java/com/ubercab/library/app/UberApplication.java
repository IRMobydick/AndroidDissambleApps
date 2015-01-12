package com.ubercab.library.app;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.widget.Toast;
import com.crashlytics.android.Crashlytics;
import com.ubercab.common.collect.ObjectArrays;
import com.ubercab.library.app.annotation.ForApp;
import com.ubercab.library.map.MapVendor;
import com.ubercab.library.map.UberMapInitializer;
import com.ubercab.library.metrics.analytics.AnalyticsClient;
import com.ubercab.library.metrics.analytics.AnalyticsClient.Listener;
import com.ubercab.library.metrics.analytics.AnalyticsEvent;
import com.ubercab.library.metrics.analytics.AnalyticsEvent.Builder;
import com.ubercab.library.metrics.analytics.AnalyticsUtils;
import com.ubercab.library.metrics.analytics.LibraryEvents.Lifecycle;
import com.ubercab.library.metrics.analytics.event.EventName;
import com.ubercab.library.metrics.analytics.session.ForegroundIntentName;
import com.ubercab.library.network.UberNetworkModule;
import dagger.ObjectGraph;
import javax.inject.Inject;
import timber.log.Timber;
import timber.log.Timber.Tree;

public abstract class UberApplication extends Application
  implements LifecycleTracker.Listener
{

  @Inject
  AnalyticsClient mAnalyticsClient;

  @ForApp
  @Inject
  BuildConfigProxy mAppBuildConfig;

  @Inject
  LifecycleTracker mAppLifecycleTracker;
  private ObjectGraph mApplicationGraph;

  @Inject
  MapVendor mMapVendor;

  public static UberApplication get(Context paramContext)
  {
    return (UberApplication)paramContext.getApplicationContext();
  }

  private void initAnalytics()
  {
    this.mAnalyticsClient.addListener(new AnalyticsClient.Listener()
    {
      public void onEventAdded(EventName paramAnonymousEventName, String paramAnonymousString)
      {
        String str = paramAnonymousString + ": " + paramAnonymousEventName.name().toLowerCase();
        Toast.makeText(UberApplication.this.getApplicationContext(), str, 0).show();
      }
    });
  }

  private void initAppLifecycleTracking()
  {
    registerComponentCallbacks(this.mAppLifecycleTracker);
    this.mAppLifecycleTracker.registerListener(this);
  }

  private void initTimberTree()
  {
    if ((0x100 & getApplicationInfo().flags) != 0);
    for (int i = 1; ; i = 0)
    {
      if ((!this.mAppBuildConfig.isDebug()) && (i == 0))
        Crashlytics.start(this);
      Timber.plant(getLoggingTree());
      return;
    }
  }

  private void initUberMaps()
  {
    UberMapInitializer.initialize(this.mMapVendor);
  }

  public ObjectGraph getApplicationGraph()
  {
    return this.mApplicationGraph;
  }

  protected abstract Timber.Tree getLoggingTree();

  protected Object[] getModules()
  {
    return new Object[0];
  }

  protected void initObjectGraph()
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = new UberApplicationModule(this);
    arrayOfObject[1] = new UberNetworkModule();
    this.mApplicationGraph = ObjectGraph.create(ObjectArrays.concat(arrayOfObject, getModules(), Object.class));
    this.mApplicationGraph.inject(this);
  }

  public void inject(Object paramObject)
  {
    this.mApplicationGraph.inject(paramObject);
  }

  public void onAppEnteredBackground()
  {
    AnalyticsEvent localAnalyticsEvent = new AnalyticsEvent.Builder("lifecycle").setName(LibraryEvents.Lifecycle.BACKGROUND).build();
    this.mAnalyticsClient.addEvent(localAnalyticsEvent);
  }

  public void onAppEnteredForeground(Intent paramIntent)
  {
    this.mAnalyticsClient.setForegroundStartTime(System.currentTimeMillis());
    AnalyticsEvent.Builder localBuilder = new AnalyticsEvent.Builder("lifecycle");
    ForegroundIntentName localForegroundIntentName = AnalyticsUtils.getNameForForeground(paramIntent);
    localBuilder.setName(LibraryEvents.Lifecycle.FOREGROUND);
    localBuilder.setReferrer(localForegroundIntentName.getValue());
    localBuilder.setUrl(paramIntent.getDataString());
    this.mAnalyticsClient.addEvent(localBuilder.build());
  }

  public void onCreate()
  {
    super.onCreate();
    initObjectGraph();
    initTimberTree();
    initAnalytics();
    initAppLifecycleTracking();
    initUberMaps();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.app.UberApplication
 * JD-Core Version:    0.6.2
 */