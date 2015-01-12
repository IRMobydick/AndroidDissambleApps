package com.ubercab.library.app;

import android.content.ComponentCallbacks2;
import android.content.Intent;
import android.content.res.Configuration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class LifecycleTracker
  implements ComponentCallbacks2
{
  private boolean mAppIsInForeground;
  private final List<Listener> mAppLifecycleListeners = new ArrayList();
  private long mForegroundStartTime;

  public Long getForegroundStartTime()
  {
    return Long.valueOf(this.mForegroundStartTime);
  }

  public void onActivityResume(Intent paramIntent)
  {
    onActivityResume(paramIntent, System.currentTimeMillis());
  }

  void onActivityResume(Intent paramIntent, long paramLong)
  {
    if (this.mAppIsInForeground);
    while (true)
    {
      return;
      this.mAppIsInForeground = true;
      this.mForegroundStartTime = paramLong;
      Iterator localIterator = this.mAppLifecycleListeners.iterator();
      while (localIterator.hasNext())
        ((Listener)localIterator.next()).onAppEnteredForeground(paramIntent);
    }
  }

  public void onConfigurationChanged(Configuration paramConfiguration)
  {
  }

  public void onLowMemory()
  {
  }

  public void onTrimMemory(int paramInt)
  {
    if (paramInt == 20)
    {
      this.mAppIsInForeground = false;
      Iterator localIterator = this.mAppLifecycleListeners.iterator();
      while (localIterator.hasNext())
        ((Listener)localIterator.next()).onAppEnteredBackground();
    }
  }

  public void registerListener(Listener paramListener)
  {
    this.mAppLifecycleListeners.add(paramListener);
  }

  public void unregisterListener(Listener paramListener)
  {
    this.mAppLifecycleListeners.remove(paramListener);
  }

  public static abstract interface Listener
  {
    public abstract void onAppEnteredBackground();

    public abstract void onAppEnteredForeground(Intent paramIntent);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.app.LifecycleTracker
 * JD-Core Version:    0.6.2
 */