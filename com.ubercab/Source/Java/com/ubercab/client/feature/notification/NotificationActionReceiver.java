package com.ubercab.client.feature.notification;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.WakefulBroadcastReceiver;
import com.ubercab.client.core.analytics.AnalyticsManager;
import com.ubercab.client.core.analytics.event.NotificationEvent;
import com.ubercab.client.core.app.RiderApplication;
import com.ubercab.client.core.content.PingProvider;
import com.ubercab.client.core.model.Client;
import com.ubercab.client.core.model.PaymentProfile;
import com.ubercab.client.core.model.Ping;
import com.ubercab.client.core.network.RiderClient;
import com.ubercab.client.core.util.PingUtils;
import com.ubercab.client.core.vendor.paypal.PayPalUtils;
import com.ubercab.client.feature.trip.TripActivity;
import javax.inject.Inject;

public class NotificationActionReceiver extends WakefulBroadcastReceiver
{

  @Inject
  AnalyticsManager mAnalyticsManager;
  private boolean mInjected;

  @Inject
  PingProvider mPingProvider;

  @Inject
  RiderClient mRiderClient;

  @Inject
  RiderNotificationManager mRiderNotificationManager;

  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (!this.mInjected)
    {
      RiderApplication.get(paramContext).inject(this);
      this.mInjected = true;
    }
    if (!"com.ubercab.client.ACTION_CLICK".equals(paramIntent.getAction()))
    {
      String str5 = paramIntent.getAction();
      int m = paramIntent.getIntExtra("com.ubercab.client.EXTRA_MESSAGE_IDENTIFIER", 0);
      this.mAnalyticsManager.notificationEvent().openAppFromPush(m, str5);
    }
    String str1 = paramIntent.getAction();
    int i = -1;
    switch (str1.hashCode())
    {
    default:
    case 689048081:
    case -92089822:
    case 440339789:
    case -1869739587:
    case -2038445361:
    case -1737783427:
    case -1614102506:
    case 1864393129:
    case 536097183:
    case -2135852769:
    }
    while (true)
      switch (i)
      {
      default:
        return;
        if (str1.equals("com.ubercab.client.ACTION_CLICK"))
        {
          i = 0;
          continue;
          if (str1.equals("com.ubercab.client.ACTION_DELETE"))
          {
            i = 1;
            continue;
            if (str1.equals("com.ubercab.client.ACTION_TRIP_ADD_DESTINATION"))
            {
              i = 2;
              continue;
              if (str1.equals("com.ubercab.client.ACTION_TRIP_CANCEL"))
              {
                i = 3;
                continue;
                if (str1.equals("com.ubercab.client.ACTION_TRIP_SHARE_ETA"))
                {
                  i = 4;
                  continue;
                  if (str1.equals("com.ubercab.client.ACTION_TRIP_SHOW_MAP"))
                  {
                    i = 5;
                    continue;
                    if (str1.equals("com.ubercab.client.ACTION_TRIP_SPLIT_FARE"))
                    {
                      i = 6;
                      continue;
                      if (str1.equals("com.ubercab.client.ACTION_RECEIPT_RATE_DRIVER"))
                      {
                        i = 7;
                        continue;
                        if (str1.equals("com.ubercab.client.ACTION_FARE_SPLIT_INVITE_ACCEPT"))
                        {
                          i = 8;
                          continue;
                          if (str1.equals("com.ubercab.client.ACTION_FARE_SPLIT_INVITE_DECLINE"))
                            i = 9;
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
        break;
      case 0:
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      case 6:
      case 7:
      case 8:
      case 9:
      }
    Intent localIntent2 = new Intent();
    int k = paramIntent.getIntExtra("com.ubercab.client.EXTRA_MESSAGE_IDENTIFIER", 0);
    localIntent2.setAction(paramIntent.getStringExtra("com.ubercab.client.EXTRA_ACTION"));
    localIntent2.putExtra("com.ubercab.client.EXTRA_MESSAGE_IDENTIFIER", k);
    paramContext.sendOrderedBroadcast(localIntent2, null);
    return;
    int j = paramIntent.getIntExtra("com.ubercab.client.EXTRA_ID", 0);
    String str4 = paramIntent.getStringExtra("com.ubercab.client.EXTRA_TAG");
    this.mRiderNotificationManager.handleNotificationDeleted(j, str4);
    return;
    Intent localIntent1 = new Intent(paramContext, TripActivity.class);
    localIntent1.setAction(paramIntent.getAction());
    localIntent1.setFlags(335544320);
    paramContext.startActivity(localIntent1);
    return;
    Ping localPing = this.mPingProvider.get();
    boolean bool1 = PingUtils.hasLastSelectedPaymentProfileId(localPing);
    String str2 = null;
    String str3 = null;
    if (bool1)
    {
      boolean bool2 = PingUtils.hasClientPaymentProfiles(localPing);
      str2 = null;
      str3 = null;
      if (bool2)
      {
        Client localClient = localPing.getClient();
        PaymentProfile localPaymentProfile = localClient.findPaymentProfileWithId(localClient.getLastSelectedPaymentProfileId());
        boolean bool3 = "PayPal".equals(localPaymentProfile.getTokenType());
        str2 = null;
        str3 = null;
        if (bool3)
        {
          str2 = localPaymentProfile.getId();
          str3 = PayPalUtils.getCorrelationId((Activity)paramContext);
        }
      }
    }
    this.mRiderClient.fareSplitAccept(str2, str3);
    return;
    this.mRiderClient.fareSplitDecline();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.notification.NotificationActionReceiver
 * JD-Core Version:    0.6.2
 */