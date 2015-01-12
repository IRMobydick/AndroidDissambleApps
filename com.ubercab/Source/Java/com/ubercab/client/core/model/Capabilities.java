package com.ubercab.client.core.model;

public class Capabilities
{
  Boolean music;

  public boolean isMusicEnabled()
  {
    if (this.music == null)
      return false;
    return this.music.booleanValue();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.model.Capabilities
 * JD-Core Version:    0.6.2
 */