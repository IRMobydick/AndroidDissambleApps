package com.ubercab.client.feature.notification;

import android.content.Context;
import android.os.Looper;
import com.ubercab.client.core.app.RiderApplication;
import com.ubercab.client.feature.notification.data.NotificationData;
import com.ubercab.client.feature.notification.handler.FareSplitAcceptedNotificationHandler;
import com.ubercab.client.feature.notification.handler.FareSplitInviteNotificationHandler;
import com.ubercab.client.feature.notification.handler.MessageNotificationHandler;
import com.ubercab.client.feature.notification.handler.NotificationHandler;
import com.ubercab.client.feature.notification.handler.ReceiptNotificationHandler;
import com.ubercab.client.feature.notification.handler.SurgeNotificationHandler;
import com.ubercab.client.feature.notification.handler.TripNotificationHandler;
import com.ubercab.common.collect.ImmutableMap.Builder;
import dagger.ObjectGraph;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import timber.log.Timber;
import timber.log.Timber.Tree;

public class RiderNotificationManager
{
  public static final int NOTIFICATION_ID_CANCELED = 7;
  public static final int NOTIFICATION_ID_FARESPLIT_ACCEPTED = 5;
  public static final int NOTIFICATION_ID_FARESPLIT_INVITE = 4;
  public static final int NOTIFICATION_ID_MESSAGE = 6;
  public static final int NOTIFICATION_ID_RECEIPT = 2;
  public static final int NOTIFICATION_ID_SURGE = 3;
  public static final int NOTIFICATION_ID_TRIP = 1;
  private static final String TAG = "RiderNotificationManager";
  private static final Map<Integer, String> TYPES_FOR_ID = new ImmutableMap.Builder().put(Integer.valueOf(7), "trip").put(Integer.valueOf(5), "fare_split_accepted").put(Integer.valueOf(6), "message").put(Integer.valueOf(3), "surge").put(Integer.valueOf(1), "trip").put(Integer.valueOf(4), "fare_split_invite").put(Integer.valueOf(2), "receipt").build();
  private final Map<String, NotificationHandler> mHandlers;
  private boolean mStarted;

  public RiderNotificationManager(Context paramContext)
  {
    this.mHandlers = new ImmutableMap.Builder().put("fare_split_accepted", new FareSplitAcceptedNotificationHandler(paramContext)).put("fare_split_invite", new FareSplitInviteNotificationHandler(paramContext)).put("message", new MessageNotificationHandler(paramContext)).put("surge", new SurgeNotificationHandler(paramContext)).put("trip", new TripNotificationHandler(paramContext)).put("receipt", new ReceiptNotificationHandler(paramContext)).build();
    ObjectGraph localObjectGraph1 = RiderApplication.get(paramContext).getApplicationGraph();
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = new NotificationsModule(paramContext);
    ObjectGraph localObjectGraph2 = localObjectGraph1.plus(arrayOfObject);
    Iterator localIterator = this.mHandlers.values().iterator();
    while (localIterator.hasNext())
      localObjectGraph2.inject((NotificationHandler)localIterator.next());
  }

  public void handleNotification(NotificationData paramNotificationData)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
      throw new IllegalStateException("Must be called on background thread.");
    if (!this.mStarted);
    while (!this.mHandlers.containsKey(paramNotificationData.getType()))
      return;
    try
    {
      ((NotificationHandler)this.mHandlers.get(paramNotificationData.getType())).handleNotification(paramNotificationData);
      return;
    }
    catch (Exception localException)
    {
      Timber.tag("RiderNotificationManager").e(localException, "Failed to handle notification: %s", new Object[] { paramNotificationData });
    }
  }

  public void handleNotificationDeleted(int paramInt, String paramString)
  {
    String str = (String)TYPES_FOR_ID.get(Integer.valueOf(paramInt));
    if (str == null);
    NotificationHandler localNotificationHandler;
    do
    {
      return;
      localNotificationHandler = (NotificationHandler)this.mHandlers.get(str);
    }
    while (localNotificationHandler == null);
    localNotificationHandler.handleNotificationDeleted(paramInt, paramString);
  }

  public void start()
  {
    if (this.mStarted)
      return;
    Iterator localIterator = this.mHandlers.values().iterator();
    while (localIterator.hasNext())
      ((NotificationHandler)localIterator.next()).start();
    this.mStarted = true;
  }

  public void stop()
  {
    if (!this.mStarted)
      return;
    Iterator localIterator = this.mHandlers.values().iterator();
    while (localIterator.hasNext())
      ((NotificationHandler)localIterator.next()).stop();
    this.mStarted = false;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.notification.RiderNotificationManager
 * JD-Core Version:    0.6.2
 */