package com.ubercab.library.metrics.analytics;

import com.ubercab.library.metrics.analytics.event.LifecycleEventName;

public class LibraryEvents
{
  public static enum Lifecycle
    implements LifecycleEventName
  {
    static
    {
      Lifecycle[] arrayOfLifecycle = new Lifecycle[2];
      arrayOfLifecycle[0] = BACKGROUND;
      arrayOfLifecycle[1] = FOREGROUND;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.metrics.analytics.LibraryEvents
 * JD-Core Version:    0.6.2
 */