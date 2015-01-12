package com.ubercab.client.core.analytics.event;

@Deprecated
public class NotificationEvent extends AnalyticsEvent
{
  private static final String EVENT_APP_OPEN_FROM_PUSH = "AppOpenFromPush";
  private static final String REASON_CANCEL = "cancel";
  private static final String REASON_DELETE = "delete";
  private static final String REASON_FARE_SPLIT = "fare_split";
  private static final String REASON_FARE_SPLIT_INVITE_ACCEPT = "fare_split_invite_accept";
  private static final String REASON_FARE_SPLIT_INVITE_DECLINE = "fare_split_invite_decline";
  private static final String REASON_RATE_DRIVER = "rate_driver";
  private static final String REASON_SHARE_ETA = "share_eta";

  public NotificationEvent(AnalyticsEvent.Listener paramListener)
  {
    super(paramListener);
  }

  private static String getReasonFromAction(String paramString)
  {
    int i = -1;
    switch (paramString.hashCode())
    {
    default:
    case -1869739587:
    case -92089822:
    case -2038445361:
    case -1614102506:
    case 536097183:
    case -2135852769:
    case 1864393129:
    }
    while (true)
      switch (i)
      {
      default:
        return "";
        if (paramString.equals("com.ubercab.client.ACTION_TRIP_CANCEL"))
        {
          i = 0;
          continue;
          if (paramString.equals("com.ubercab.client.ACTION_DELETE"))
          {
            i = 1;
            continue;
            if (paramString.equals("com.ubercab.client.ACTION_TRIP_SHARE_ETA"))
            {
              i = 2;
              continue;
              if (paramString.equals("com.ubercab.client.ACTION_TRIP_SPLIT_FARE"))
              {
                i = 3;
                continue;
                if (paramString.equals("com.ubercab.client.ACTION_FARE_SPLIT_INVITE_ACCEPT"))
                {
                  i = 4;
                  continue;
                  if (paramString.equals("com.ubercab.client.ACTION_FARE_SPLIT_INVITE_DECLINE"))
                  {
                    i = 5;
                    continue;
                    if (paramString.equals("com.ubercab.client.ACTION_RECEIPT_RATE_DRIVER"))
                      i = 6;
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
      }
    return "cancel";
    return "delete";
    return "share_eta";
    return "fare_split";
    return "fare_split_invite_accept";
    return "fare_split_invite_decline";
    return "rate_driver";
  }

  public void openAppFromPush(int paramInt, String paramString)
  {
    sendEvent(new EventBuilder().setEventName("AppOpenFromPush").putParameter("pushType", Integer.valueOf(paramInt)).putParameter("reason", getReasonFromAction(paramString)).build());
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.analytics.event.NotificationEvent
 * JD-Core Version:    0.6.2
 */