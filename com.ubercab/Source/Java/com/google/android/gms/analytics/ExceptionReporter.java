package com.google.android.gms.analytics;

import android.content.Context;
import java.util.ArrayList;

public class ExceptionReporter
  implements Thread.UncaughtExceptionHandler
{
  private final Context mContext;
  private final Thread.UncaughtExceptionHandler xX;
  private final Tracker xY;
  private ExceptionParser xZ;

  public ExceptionReporter(Tracker paramTracker, Thread.UncaughtExceptionHandler paramUncaughtExceptionHandler, Context paramContext)
  {
    if (paramTracker == null)
      throw new NullPointerException("tracker cannot be null");
    if (paramContext == null)
      throw new NullPointerException("context cannot be null");
    this.xX = paramUncaughtExceptionHandler;
    this.xY = paramTracker;
    this.xZ = new StandardExceptionParser(paramContext, new ArrayList());
    this.mContext = paramContext.getApplicationContext();
    StringBuilder localStringBuilder = new StringBuilder().append("ExceptionReporter created, original handler is ");
    if (paramUncaughtExceptionHandler == null);
    for (String str = "null"; ; str = paramUncaughtExceptionHandler.getClass().getName())
    {
      z.V(str);
      return;
    }
  }

  Thread.UncaughtExceptionHandler dY()
  {
    return this.xX;
  }

  public ExceptionParser getExceptionParser()
  {
    return this.xZ;
  }

  public void setExceptionParser(ExceptionParser paramExceptionParser)
  {
    this.xZ = paramExceptionParser;
  }

  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    String str1 = "UncaughtException";
    if (this.xZ != null)
      if (paramThread == null)
        break label114;
    label114: for (String str2 = paramThread.getName(); ; str2 = null)
    {
      str1 = this.xZ.getDescription(str2, paramThrowable);
      z.V("Tracking Exception: " + str1);
      this.xY.send(new HitBuilders.ExceptionBuilder().setDescription(str1).setFatal(true).build());
      GoogleAnalytics.getInstance(this.mContext).dispatchLocalHits();
      if (this.xX != null)
      {
        z.V("Passing exception to original handler.");
        this.xX.uncaughtException(paramThread, paramThrowable);
      }
      return;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.analytics.ExceptionReporter
 * JD-Core Version:    0.6.2
 */