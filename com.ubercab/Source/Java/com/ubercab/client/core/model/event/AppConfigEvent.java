package com.ubercab.client.core.model.event;

import com.ubercab.client.core.model.AppConfig;

public final class AppConfigEvent
{
  private final AppConfig mAppConfig;

  public AppConfigEvent(AppConfig paramAppConfig)
  {
    this.mAppConfig = paramAppConfig;
  }

  public AppConfig getAppConfig()
  {
    return this.mAppConfig;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.model.event.AppConfigEvent
 * JD-Core Version:    0.6.2
 */