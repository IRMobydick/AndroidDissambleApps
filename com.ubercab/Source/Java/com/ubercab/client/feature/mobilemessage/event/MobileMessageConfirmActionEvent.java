package com.ubercab.client.feature.mobilemessage.event;

import com.ubercab.client.core.model.MobileMessage;

public final class MobileMessageConfirmActionEvent
{
  private final MobileMessage mMessage;

  public MobileMessageConfirmActionEvent(MobileMessage paramMobileMessage)
  {
    this.mMessage = paramMobileMessage;
  }

  public MobileMessage getMessage()
  {
    return this.mMessage;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.mobilemessage.event.MobileMessageConfirmActionEvent
 * JD-Core Version:    0.6.2
 */