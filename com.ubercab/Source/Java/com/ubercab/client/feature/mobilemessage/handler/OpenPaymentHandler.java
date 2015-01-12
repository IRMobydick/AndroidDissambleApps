package com.ubercab.client.feature.mobilemessage.handler;

import android.content.Context;
import android.content.Intent;
import com.ubercab.client.core.metrics.analytics.RiderEvents.Tap;
import com.ubercab.client.core.model.MobileMessage;
import com.ubercab.client.feature.mobilemessage.HandlerResult;
import com.ubercab.client.feature.mobilemessage.HandlerResult.Builder;
import com.ubercab.client.feature.mobilemessage.NativeUriHandler;
import com.ubercab.client.feature.payment.AddPaymentActivity;

public class OpenPaymentHandler
  implements NativeUriHandler
{
  public HandlerResult handle(Context paramContext, MobileMessage paramMobileMessage, String paramString)
  {
    paramContext.startActivity(new Intent(paramContext, AddPaymentActivity.class));
    return new HandlerResult.Builder().setSuccess(true).setDismissMessage(true).setAnalyticsEventName(RiderEvents.Tap.MOBILE_MESSAGE_OPEN_PAYMENT).setAnalyticsReferrer(paramMobileMessage.getId()).build();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.mobilemessage.handler.OpenPaymentHandler
 * JD-Core Version:    0.6.2
 */