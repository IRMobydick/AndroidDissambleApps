package com.crashlytics.android.internal;

import android.annotation.TargetApi;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import java.util.concurrent.ScheduledExecutorService;

@TargetApi(14)
final class F extends O
{
  private final Application b;
  private final Application.ActivityLifecycleCallbacks c = new G(this);

  public F(Application paramApplication, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, K paramK, av paramav)
  {
    this(paramApplication, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramK, ah.b("Crashlytics Trace Manager"), paramav);
  }

  private F(Application paramApplication, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, K paramK, ScheduledExecutorService paramScheduledExecutorService, av paramav)
  {
    super(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramK, paramScheduledExecutorService, paramav);
    this.b = paramApplication;
    ab.c("Registering activity lifecycle callbacks for session analytics.");
    paramApplication.registerActivityLifecycleCallbacks(this.c);
  }

  final void a()
  {
    ab.c("Unregistering activity lifecycle callbacks for session analytics");
    this.b.unregisterActivityLifecycleCallbacks(this.c);
    super.a();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.crashlytics.android.internal.F
 * JD-Core Version:    0.6.2
 */