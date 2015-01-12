package com.ubercab.client.feature.mobilemessage.handler;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.provider.Telephony.Sms;
import com.ubercab.client.core.metrics.analytics.RiderEvents.Tap;
import com.ubercab.client.core.model.MobileMessage;
import com.ubercab.client.core.util.AndroidUtils;
import com.ubercab.client.feature.mobilemessage.HandlerResult;
import com.ubercab.client.feature.mobilemessage.HandlerResult.Builder;
import com.ubercab.client.feature.mobilemessage.NativeUriHandler;
import com.ubercab.common.collect.ImmutableList.Builder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ShareMessageHandler
  implements NativeUriHandler
{
  private static final List<String> DEFAULT_PRIORITY_PACKAGE_NAMES = new ImmutableList.Builder().add("com.google.android.talk").add("com.android.mms").add("com.facebook.orca").add("com.whatsapp").add("com.tencent.mm").add("jp.naver.line.android").add("com.kakao.talk").build();

  private boolean addIntentForPackage(Context paramContext, ArrayList<Intent> paramArrayList, String paramString1, String paramString2)
  {
    if (!AndroidUtils.isPackageInstalled(paramContext, paramString2))
      return false;
    Intent localIntent = new Intent("android.intent.action.SEND");
    localIntent.setType("text/plain");
    localIntent.setPackage(paramString2);
    localIntent.putExtra("android.intent.extra.TEXT", paramString1);
    paramArrayList.add(localIntent);
    return true;
  }

  @TargetApi(19)
  private String getDefaultSmsPackage(Context paramContext)
  {
    return Telephony.Sms.getDefaultSmsPackage(paramContext);
  }

  public HandlerResult handle(Context paramContext, MobileMessage paramMobileMessage, String paramString)
  {
    String str1 = Uri.parse(paramString).getQueryParameter("message");
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = DEFAULT_PRIORITY_PACKAGE_NAMES.iterator();
    while (localIterator.hasNext())
      addIntentForPackage(paramContext, localArrayList, str1, (String)localIterator.next());
    if (Build.VERSION.SDK_INT >= 19)
    {
      String str2 = getDefaultSmsPackage(paramContext);
      if ((str2 != null) && (!DEFAULT_PRIORITY_PACKAGE_NAMES.contains(str2)))
        addIntentForPackage(paramContext, localArrayList, str1, str2);
    }
    while (localArrayList.isEmpty())
    {
      return HandlerResult.ERROR;
      Intent localIntent1 = new Intent("android.intent.action.VIEW");
      localIntent1.setData(Uri.parse("sms:"));
      localIntent1.putExtra("sms_body", str1);
      localArrayList.add(localIntent1);
    }
    Intent localIntent2 = Intent.createChooser((Intent)localArrayList.get(0), paramContext.getString(2131559055));
    if (localArrayList.size() > 1)
    {
      localArrayList.remove(0);
      localIntent2.putExtra("android.intent.extra.INITIAL_INTENTS", (Intent[])localArrayList.toArray(new Intent[localArrayList.size()]));
    }
    paramContext.startActivity(localIntent2);
    return new HandlerResult.Builder().setAnalyticsEventName(RiderEvents.Tap.MOBILE_MESSAGE_SHARE).setAnalyticsEventValue("message").setAnalyticsReferrer(paramMobileMessage.getId()).build();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.mobilemessage.handler.ShareMessageHandler
 * JD-Core Version:    0.6.2
 */