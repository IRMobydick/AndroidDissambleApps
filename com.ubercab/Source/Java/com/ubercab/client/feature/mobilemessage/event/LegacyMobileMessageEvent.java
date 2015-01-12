package com.ubercab.client.feature.mobilemessage.event;

import com.ubercab.client.core.model.LegacyMobileMessage;

public final class LegacyMobileMessageEvent
{
  private LegacyMobileMessage mLegacyMobileMessage;

  public LegacyMobileMessageEvent(LegacyMobileMessage paramLegacyMobileMessage)
  {
    this.mLegacyMobileMessage = paramLegacyMobileMessage;
  }

  public LegacyMobileMessage getLegacyMobileMessage()
  {
    return this.mLegacyMobileMessage;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.mobilemessage.event.LegacyMobileMessageEvent
 * JD-Core Version:    0.6.2
 */