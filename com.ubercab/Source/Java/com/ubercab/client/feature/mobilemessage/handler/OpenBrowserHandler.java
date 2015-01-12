package com.ubercab.client.feature.mobilemessage.handler;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.ubercab.client.core.metrics.analytics.RiderEvents.Tap;
import com.ubercab.client.core.model.MobileMessage;
import com.ubercab.client.feature.mobilemessage.HandlerResult;
import com.ubercab.client.feature.mobilemessage.HandlerResult.Builder;
import com.ubercab.client.feature.mobilemessage.NativeUriHandler;

public class OpenBrowserHandler
  implements NativeUriHandler
{
  public HandlerResult handle(Context paramContext, MobileMessage paramMobileMessage, String paramString)
  {
    String str = Uri.parse(paramString).getQueryParameter("url");
    if (str == null)
      return HandlerResult.ERROR;
    if ((!str.startsWith("http://")) && (!str.startsWith("https://")))
      str = "http://" + str;
    try
    {
      paramContext.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
      return new HandlerResult.Builder().setAnalyticsEventName(RiderEvents.Tap.MOBILE_MESSAGE_BROWSE).setAnalyticsEventValue(str).setAnalyticsReferrer(paramMobileMessage.getId()).build();
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
    }
    return HandlerResult.ERROR;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.mobilemessage.handler.OpenBrowserHandler
 * JD-Core Version:    0.6.2
 */