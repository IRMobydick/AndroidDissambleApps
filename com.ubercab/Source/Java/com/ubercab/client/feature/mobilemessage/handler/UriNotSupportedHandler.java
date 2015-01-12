package com.ubercab.client.feature.mobilemessage.handler;

import android.content.Context;
import com.crashlytics.android.Crashlytics;
import com.ubercab.client.core.model.MobileMessage;
import com.ubercab.client.feature.mobilemessage.HandlerResult;
import com.ubercab.client.feature.mobilemessage.NativeUriHandler;

public class UriNotSupportedHandler
  implements NativeUriHandler
{
  public HandlerResult handle(Context paramContext, MobileMessage paramMobileMessage, String paramString)
  {
    Crashlytics.log("Native Support for [" + paramString + "] in mobile messaging not implemented yet");
    return HandlerResult.ERROR;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.mobilemessage.handler.UriNotSupportedHandler
 * JD-Core Version:    0.6.2
 */