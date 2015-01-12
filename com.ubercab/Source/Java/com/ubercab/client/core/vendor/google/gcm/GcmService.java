package com.ubercab.client.core.vendor.google.gcm;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.google.gson.Gson;
import com.ubercab.client.feature.notification.RiderNotificationManager;
import com.ubercab.client.feature.notification.data.NotificationData;
import com.ubercab.library.app.UberApplication;
import javax.inject.Inject;
import timber.log.Timber;
import timber.log.Timber.Tree;

public class GcmService extends IntentService
{
  private static final String TAG = "GcmService";

  @Inject
  Gson mGson;

  @Inject
  RiderNotificationManager mRiderNotificationManager;

  public GcmService()
  {
    super("GcmService");
  }

  public void onCreate()
  {
    super.onCreate();
    UberApplication.get(this).inject(this);
  }

  protected void onHandleIntent(Intent paramIntent)
  {
    try
    {
      String str = GoogleCloudMessaging.getInstance(this).getMessageType(paramIntent);
      Bundle localBundle = paramIntent.getExtras();
      int j;
      if (!localBundle.isEmpty())
      {
        int i = str.hashCode();
        switch (i)
        {
        default:
          j = -1;
          label55: switch (j)
          {
          default:
          case 0:
          }
          break;
        case 102161:
        }
      }
      while (true)
      {
        return;
        if (!str.equals("gcm"))
          break;
        j = 0;
        break label55;
        NotificationData localNotificationData = NotificationData.fromGcmBundle(this.mGson, localBundle);
        if (localNotificationData == null)
          return;
        this.mRiderNotificationManager.handleNotification(localNotificationData);
      }
    }
    catch (Exception localException)
    {
      Timber.tag("GcmService").e(localException, "Failed to handle GCM intent", new Object[0]);
      return;
    }
    finally
    {
      GcmReceiver.completeWakefulIntent(paramIntent);
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.vendor.google.gcm.GcmService
 * JD-Core Version:    0.6.2
 */