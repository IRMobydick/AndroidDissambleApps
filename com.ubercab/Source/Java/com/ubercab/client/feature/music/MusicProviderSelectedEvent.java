package com.ubercab.client.feature.music;

import com.ubercab.client.core.model.MusicProvider;

public final class MusicProviderSelectedEvent
{
  private final MusicProvider mMusicProvider;

  public MusicProviderSelectedEvent(MusicProvider paramMusicProvider)
  {
    this.mMusicProvider = paramMusicProvider;
  }

  public MusicProvider getMusicProvider()
  {
    return this.mMusicProvider;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.music.MusicProviderSelectedEvent
 * JD-Core Version:    0.6.2
 */