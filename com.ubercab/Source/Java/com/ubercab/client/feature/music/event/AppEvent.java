package com.ubercab.client.feature.music.event;

abstract class AppEvent
{
  private final String mPackageName;

  AppEvent(String paramString)
  {
    this.mPackageName = paramString;
  }

  public String getPackageName()
  {
    return this.mPackageName;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.music.event.AppEvent
 * JD-Core Version:    0.6.2
 */