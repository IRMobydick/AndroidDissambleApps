package com.ubercab.client.feature.mobilemessage.handler;

import android.content.Context;
import android.os.Handler;
import com.squareup.otto.Bus;
import com.ubercab.client.core.metrics.analytics.RiderEvents.Tap;
import com.ubercab.client.core.model.MobileMessage;
import com.ubercab.client.feature.mobilemessage.HandlerResult;
import com.ubercab.client.feature.mobilemessage.HandlerResult.Builder;
import com.ubercab.client.feature.mobilemessage.NativeUriHandler;
import com.ubercab.client.feature.mobilemessage.event.MobileMessageConfirmActionEvent;

public class ConfirmActionHandler
  implements NativeUriHandler
{
  private final Bus mBus;
  private final Handler mHandler = new Handler();

  public ConfirmActionHandler(Bus paramBus)
  {
    this.mBus = paramBus;
  }

  public HandlerResult handle(Context paramContext, final MobileMessage paramMobileMessage, String paramString)
  {
    this.mHandler.post(new Runnable()
    {
      public void run()
      {
        ConfirmActionHandler.this.mBus.post(new MobileMessageConfirmActionEvent(paramMobileMessage));
      }
    });
    return new HandlerResult.Builder().setSuccess(true).setDismissMessage(true).setAnalyticsEventName(RiderEvents.Tap.MOBILE_MESSAGE_CONFIRM).setAnalyticsReferrer(paramMobileMessage.getId()).build();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.mobilemessage.handler.ConfirmActionHandler
 * JD-Core Version:    0.6.2
 */