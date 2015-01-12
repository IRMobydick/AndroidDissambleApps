package com.ubercab.client.feature.mobilemessage.handler;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.ubercab.client.core.metrics.analytics.RiderEvents.Tap;
import com.ubercab.client.core.model.MobileMessage;
import com.ubercab.client.feature.mobilemessage.HandlerResult;
import com.ubercab.client.feature.mobilemessage.HandlerResult.Builder;
import com.ubercab.client.feature.mobilemessage.NativeUriHandler;

public class ShareGenericHandler
  implements NativeUriHandler
{
  public HandlerResult handle(Context paramContext, MobileMessage paramMobileMessage, String paramString)
  {
    Uri localUri = Uri.parse(paramString);
    String str = localUri.getQueryParameter("message");
    if (str == null)
      str = localUri.getQueryParameter("url");
    if (str == null)
      return HandlerResult.ERROR;
    Intent localIntent = new Intent("android.intent.action.SEND");
    localIntent.setType("text/plain");
    localIntent.putExtra("android.intent.extra.TEXT", str);
    paramContext.startActivity(Intent.createChooser(localIntent, paramContext.getString(2131559055)));
    return new HandlerResult.Builder().setAnalyticsEventName(RiderEvents.Tap.MOBILE_MESSAGE_SHARE).setAnalyticsEventValue("generic").setAnalyticsReferrer(paramMobileMessage.getId()).build();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.mobilemessage.handler.ShareGenericHandler
 * JD-Core Version:    0.6.2
 */