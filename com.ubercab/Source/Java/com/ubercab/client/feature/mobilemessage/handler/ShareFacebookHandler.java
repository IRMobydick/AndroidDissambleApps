package com.ubercab.client.feature.mobilemessage.handler;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;
import com.ubercab.client.core.metrics.analytics.RiderEvents.Tap;
import com.ubercab.client.core.model.MobileMessage;
import com.ubercab.client.core.util.AndroidUtils;
import com.ubercab.client.feature.mobilemessage.HandlerResult;
import com.ubercab.client.feature.mobilemessage.HandlerResult.Builder;
import com.ubercab.client.feature.mobilemessage.NativeUriHandler;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class ShareFacebookHandler
  implements NativeUriHandler
{
  final String FACEBOOK_PNAME = "com.facebook.katana";
  final String FACEBOOK_SHARER_URL_PREFIX = "https://www.facebook.com/sharer/sharer.php?u=";

  public HandlerResult handle(Context paramContext, MobileMessage paramMobileMessage, String paramString)
  {
    String str = Uri.parse(paramString).getQueryParameter("url");
    if (AndroidUtils.isPackageInstalled(paramContext, "com.facebook.katana"))
    {
      Toast.makeText(paramContext, paramContext.getString(2131559061), 0).show();
      Intent localIntent = new Intent("android.intent.action.SEND");
      localIntent.setType("text/plain");
      localIntent.putExtra("android.intent.extra.TEXT", str);
      localIntent.setPackage("com.facebook.katana");
      paramContext.startActivity(localIntent);
      return new HandlerResult.Builder().setAnalyticsEventName(RiderEvents.Tap.MOBILE_MESSAGE_SHARE).setAnalyticsEventValue("facebook_native").setAnalyticsReferrer(paramMobileMessage.getId()).build();
    }
    try
    {
      paramContext.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://www.facebook.com/sharer/sharer.php?u=" + URLEncoder.encode(str, "UTF-8"))));
      HandlerResult localHandlerResult = new HandlerResult.Builder().setAnalyticsEventName(RiderEvents.Tap.MOBILE_MESSAGE_SHARE).setAnalyticsEventValue("facebook_web").setAnalyticsReferrer(paramMobileMessage.getId()).build();
      return localHandlerResult;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
    }
    return HandlerResult.ERROR;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.mobilemessage.handler.ShareFacebookHandler
 * JD-Core Version:    0.6.2
 */