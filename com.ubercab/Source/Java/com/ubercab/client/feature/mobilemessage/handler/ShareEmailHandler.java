package com.ubercab.client.feature.mobilemessage.handler;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.ubercab.client.core.metrics.analytics.RiderEvents.Tap;
import com.ubercab.client.core.model.MobileMessage;
import com.ubercab.client.core.util.AndroidUtils;
import com.ubercab.client.feature.mobilemessage.HandlerResult;
import com.ubercab.client.feature.mobilemessage.HandlerResult.Builder;
import com.ubercab.client.feature.mobilemessage.NativeUriHandler;
import java.util.Locale;

public class ShareEmailHandler
  implements NativeUriHandler
{
  final String COUNTRY_US = "US";
  final String GMAIL_COMPOSE_ACTIVITY = "com.google.android.gm.ComposeActivityGmail";
  final String GMAIL_PNAME = "com.google.android.gm";

  public HandlerResult handle(Context paramContext, MobileMessage paramMobileMessage, String paramString)
  {
    Uri localUri = Uri.parse(paramString);
    String str1 = localUri.getQueryParameter("subject");
    String str2 = localUri.getQueryParameter("body");
    Intent localIntent = new Intent("android.intent.action.SENDTO");
    localIntent.setData(Uri.parse("mailto:?subject=" + str1));
    if ((AndroidUtils.isPackageInstalled(paramContext, "com.google.android.gm")) && ("US".equals(Locale.getDefault().getCountry())))
      localIntent.setClassName("com.google.android.gm", "com.google.android.gm.ComposeActivityGmail");
    if (str2 != null)
      localIntent.putExtra("android.intent.extra.TEXT", str2);
    paramContext.startActivity(Intent.createChooser(localIntent, paramContext.getString(2131559054)));
    return new HandlerResult.Builder().setAnalyticsEventName(RiderEvents.Tap.MOBILE_MESSAGE_SHARE).setAnalyticsEventValue("email").setAnalyticsReferrer(paramMobileMessage.getId()).build();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.mobilemessage.handler.ShareEmailHandler
 * JD-Core Version:    0.6.2
 */