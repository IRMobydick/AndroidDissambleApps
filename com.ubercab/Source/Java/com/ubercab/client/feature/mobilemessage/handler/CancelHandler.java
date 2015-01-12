package com.ubercab.client.feature.mobilemessage.handler;

import android.content.Context;
import com.ubercab.client.core.model.MobileMessage;
import com.ubercab.client.feature.mobilemessage.HandlerResult;
import com.ubercab.client.feature.mobilemessage.HandlerResult.Builder;
import com.ubercab.client.feature.mobilemessage.NativeUriHandler;

public class CancelHandler
  implements NativeUriHandler
{
  public HandlerResult handle(Context paramContext, MobileMessage paramMobileMessage, String paramString)
  {
    return new HandlerResult.Builder().setSuccess(true).setDismissMessage(true).build();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.mobilemessage.handler.CancelHandler
 * JD-Core Version:    0.6.2
 */