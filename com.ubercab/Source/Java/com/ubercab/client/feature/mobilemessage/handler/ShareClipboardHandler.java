package com.ubercab.client.feature.mobilemessage.handler;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.Toast;
import com.ubercab.client.core.metrics.analytics.RiderEvents.Tap;
import com.ubercab.client.core.model.MobileMessage;
import com.ubercab.client.feature.mobilemessage.HandlerResult;
import com.ubercab.client.feature.mobilemessage.HandlerResult.Builder;
import com.ubercab.client.feature.mobilemessage.NativeUriHandler;

public class ShareClipboardHandler
  implements NativeUriHandler
{
  public HandlerResult handle(Context paramContext, MobileMessage paramMobileMessage, String paramString)
  {
    String str = Uri.parse(paramString).getQueryParameter("text");
    if (TextUtils.isEmpty(str))
      return HandlerResult.ERROR;
    ((ClipboardManager)paramContext.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(paramContext.getString(2131559057), str));
    Toast.makeText(paramContext, paramContext.getString(2131559058), 0).show();
    return new HandlerResult.Builder().setAnalyticsEventName(RiderEvents.Tap.MOBILE_MESSAGE_SHARE).setAnalyticsEventValue("clipboard").setAnalyticsReferrer(paramMobileMessage.getId()).build();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.mobilemessage.handler.ShareClipboardHandler
 * JD-Core Version:    0.6.2
 */