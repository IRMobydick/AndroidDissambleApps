package com.ubercab.client.feature.mobilemessage.handler;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import com.ubercab.client.core.metrics.analytics.RiderEvents.Tap;
import com.ubercab.client.core.model.MobileMessage;
import com.ubercab.client.core.util.AndroidUtils;
import com.ubercab.client.feature.mobilemessage.HandlerResult;
import com.ubercab.client.feature.mobilemessage.HandlerResult.Builder;
import com.ubercab.client.feature.mobilemessage.NativeUriHandler;

public class ShareTwitterHandler
  implements NativeUriHandler
{
  final String TWITTER_PNAME = "com.twitter.android";

  public HandlerResult handle(Context paramContext, MobileMessage paramMobileMessage, String paramString)
  {
    Uri localUri = Uri.parse(paramString);
    String str1 = localUri.getQueryParameter("message");
    String str2 = localUri.getQueryParameter("url");
    Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse(new Uri.Builder().scheme("https").authority("twitter.com").appendPath("intent").appendPath("tweet").appendQueryParameter("text", str1).appendQueryParameter("url", str2).build().toString()));
    if (AndroidUtils.isPackageInstalled(paramContext, "com.twitter.android"))
    {
      localIntent.setPackage("com.twitter.android");
      paramContext.startActivity(localIntent);
      return new HandlerResult.Builder().setAnalyticsEventName(RiderEvents.Tap.MOBILE_MESSAGE_SHARE).setAnalyticsEventValue("twitter_native").setAnalyticsReferrer(paramMobileMessage.getId()).build();
    }
    paramContext.startActivity(Intent.createChooser(localIntent, paramContext.getString(2131559056)));
    return new HandlerResult.Builder().setAnalyticsEventName(RiderEvents.Tap.MOBILE_MESSAGE_SHARE).setAnalyticsEventValue("twitter_web").setAnalyticsReferrer(paramMobileMessage.getId()).build();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.mobilemessage.handler.ShareTwitterHandler
 * JD-Core Version:    0.6.2
 */