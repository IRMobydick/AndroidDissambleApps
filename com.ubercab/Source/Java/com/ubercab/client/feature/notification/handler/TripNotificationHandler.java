package com.ubercab.client.feature.notification.handler;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat.BigPictureStyle;
import android.support.v4.app.NotificationCompat.BigTextStyle;
import android.support.v4.app.NotificationCompat.Builder;
import android.support.v4.app.NotificationCompat.InboxStyle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.squareup.otto.Subscribe;
import com.ubercab.client.core.app.RiderPreferences;
import com.ubercab.client.core.app.RiderService;
import com.ubercab.client.core.content.event.PingEvent;
import com.ubercab.client.core.model.Ping;
import com.ubercab.client.core.model.Trip;
import com.ubercab.client.core.network.events.PingClientResponseEvent;
import com.ubercab.client.core.util.PingUtils;
import com.ubercab.client.feature.notification.NotificationPainter;
import com.ubercab.client.feature.notification.data.NotificationData.Source;
import com.ubercab.client.feature.notification.data.TripNotificationData;
import com.ubercab.client.feature.notification.data.TripNotificationData.FareSplitClient;
import com.ubercab.common.base.Function;
import com.ubercab.common.base.Joiner;
import com.ubercab.common.base.Predicate;
import com.ubercab.common.collect.Iterables;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;

public final class TripNotificationHandler extends NotificationHandler<TripNotificationData>
{
  public static final String ACTION_ADD_DESTINATION = "com.ubercab.client.ACTION_TRIP_ADD_DESTINATION";
  public static final String ACTION_CANCEL = "com.ubercab.client.ACTION_TRIP_CANCEL";
  public static final String ACTION_SHARE_ETA = "com.ubercab.client.ACTION_TRIP_SHARE_ETA";
  public static final String ACTION_SHOW_MAP = "com.ubercab.client.ACTION_TRIP_SHOW_MAP";
  public static final String ACTION_SPLIT_FARE = "com.ubercab.client.ACTION_TRIP_SPLIT_FARE";
  private static final String PREF_LAST_DATA = "trip_last_data";

  @Inject
  ExecutorService mExecutorService;

  @Inject
  Gson mGson;
  private boolean mIsServiceBound;
  private TripNotificationData mLastData;

  @Inject
  NotificationPainter mPainter;

  @Inject
  RiderPreferences mPreferences;
  private final ServiceConnection mServiceConnection = new ServiceConnection()
  {
    public void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder)
    {
    }

    public void onServiceDisconnected(ComponentName paramAnonymousComponentName)
    {
    }
  };

  public TripNotificationHandler(Context paramContext)
  {
    super(paramContext);
  }

  private void addActionAddDestination(NotificationCompat.Builder paramBuilder, int paramInt)
  {
    PendingIntent localPendingIntent = createPendingIntent(paramInt, "com.ubercab.client.ACTION_TRIP_ADD_DESTINATION");
    paramBuilder.addAction(2130837766, getContext().getString(2131558424), localPendingIntent);
  }

  private void addActionCancel(NotificationCompat.Builder paramBuilder, int paramInt)
  {
    PendingIntent localPendingIntent = createPendingIntent(paramInt, "com.ubercab.client.ACTION_TRIP_CANCEL");
    paramBuilder.addAction(2130837765, getContext().getString(2131558467), localPendingIntent);
  }

  private void addActionShareEta(NotificationCompat.Builder paramBuilder, int paramInt)
  {
    PendingIntent localPendingIntent = createPendingIntent(paramInt, "com.ubercab.client.ACTION_TRIP_SHARE_ETA");
    paramBuilder.addAction(2130837768, getContext().getString(2131559060), localPendingIntent);
  }

  private void addActionSplitFare(NotificationCompat.Builder paramBuilder, int paramInt)
  {
    PendingIntent localPendingIntent = createPendingIntent(paramInt, "com.ubercab.client.ACTION_TRIP_SPLIT_FARE");
    paramBuilder.addAction(2130837769, getContext().getString(2131559078), localPendingIntent);
  }

  private void addTripActions(NotificationCompat.Builder paramBuilder, TripNotificationData paramTripNotificationData, int paramInt)
  {
    if (!paramTripNotificationData.isMaster())
      return;
    if ((!paramTripNotificationData.getTripStatus().equals("on_trip")) && (!paramTripNotificationData.hasDestination()))
    {
      addActionAddDestination(paramBuilder, paramInt);
      return;
    }
    addActionShareEta(paramBuilder, paramInt);
    addActionSplitFare(paramBuilder, paramInt);
  }

  private NotificationCompat.BigPictureStyle buildStyleBigPicture(NotificationCompat.Builder paramBuilder, TripNotificationData paramTripNotificationData, String paramString)
  {
    return new NotificationCompat.BigPictureStyle(paramBuilder).setSummaryText(paramString).bigPicture(this.mPainter.drawTripBigPicture(paramTripNotificationData, paramTripNotificationData.isMaster()));
  }

  private NotificationCompat.InboxStyle buildStyleInbox(NotificationCompat.Builder paramBuilder, TripNotificationData paramTripNotificationData, String paramString)
  {
    NotificationCompat.InboxStyle localInboxStyle = new NotificationCompat.InboxStyle(paramBuilder).setSummaryText(paramString);
    Iterator localIterator = paramTripNotificationData.getFareSplitClients().iterator();
    while (localIterator.hasNext())
    {
      TripNotificationData.FareSplitClient localFareSplitClient = (TripNotificationData.FareSplitClient)localIterator.next();
      SpannableString localSpannableString = new SpannableString(localFareSplitClient.getName());
      localSpannableString.setSpan(new StyleSpan(1), 0, localSpannableString.length(), 33);
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
      localSpannableStringBuilder.append(localSpannableString);
      localSpannableStringBuilder.append(" ");
      localSpannableStringBuilder.append(localFareSplitClient.getDisplayStatus(getContext()));
      localInboxStyle.addLine(localSpannableStringBuilder);
    }
    return localInboxStyle;
  }

  private void cleanUpNotification(TripNotificationData paramTripNotificationData)
  {
    if (paramTripNotificationData == null)
      return;
    cancel(1, paramTripNotificationData.getTag());
    stopBackgroundPing();
    setLastData(null);
  }

  private void displayCanceledNotification(TripNotificationData paramTripNotificationData)
  {
    Context localContext = getContext();
    PendingIntent localPendingIntent = createPendingIntent(paramTripNotificationData.getMessageIdentifier(), "com.ubercab.client.ACTION_TRIP_SHOW_MAP");
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = paramTripNotificationData.getDriverName();
    String str1 = localContext.getString(2131558957, arrayOfObject);
    String str2 = localContext.getString(2131558955);
    String str3 = localContext.getString(2131558956, new Object[] { str1, str2 });
    NotificationCompat.Builder localBuilder = new NotificationCompat.Builder(getContext()).setSmallIcon(2130837771).setWhen(0L).setAutoCancel(true).setContentTitle(str1).setContentText(str2).setContentIntent(localPendingIntent).setDeleteIntent(createDeletePendingIntent(7, null)).setTicker(str3);
    localBuilder.setStyle(new NotificationCompat.BigTextStyle(localBuilder).setBigContentTitle(str1).bigText(str2));
    notify(7, paramTripNotificationData.getTag(), localBuilder.build());
  }

  private void displayTripNotification(TripNotificationData paramTripNotificationData)
  {
    PendingIntent localPendingIntent = createPendingIntent(paramTripNotificationData.getMessageIdentifier(), "com.ubercab.client.ACTION_TRIP_SHOW_MAP");
    NotificationCompat.Builder localBuilder = new NotificationCompat.Builder(getContext()).setSmallIcon(2130837771).setContentIntent(localPendingIntent).setDeleteIntent(createDeletePendingIntent(1, null)).setWhen(0L);
    String str = paramTripNotificationData.getFallbackText();
    if (!TextUtils.isEmpty(str))
    {
      localBuilder.setContentText(str);
      localBuilder.setTicker(str);
    }
    while (populateNotification(localBuilder, paramTripNotificationData))
    {
      Notification localNotification = localBuilder.build();
      if (paramTripNotificationData.getSource() != NotificationData.Source.PUSH)
      {
        localNotification.defaults = 0;
        localNotification.sound = null;
        localNotification.vibrate = null;
      }
      notify(1, paramTripNotificationData.getTag(), localNotification);
      return;
    }
    cancel(1, paramTripNotificationData.getTag());
  }

  private String getContentText(TripNotificationData paramTripNotificationData, boolean paramBoolean)
  {
    Context localContext = getContext();
    ArrayList localArrayList = new ArrayList();
    String str1 = paramTripNotificationData.getTripStatus();
    int i = -1;
    switch (str1.hashCode())
    {
    default:
      switch (i)
      {
      default:
      case 0:
      case 1:
      case 2:
      case 3:
      case 4:
      }
      break;
    case 1065961768:
    case -2146525273:
    case -734206867:
    case -1325796731:
    case 2130210069:
    }
    while (true)
    {
      return Joiner.on(" • ").join(Iterables.filter(localArrayList, new Predicate()
      {
        public boolean apply(String paramAnonymousString)
        {
          return !TextUtils.isEmpty(paramAnonymousString);
        }
      }));
      if (!str1.equals("dispatching"))
        break;
      i = 0;
      break;
      if (!str1.equals("accepted"))
        break;
      i = 1;
      break;
      if (!str1.equals("arrived"))
        break;
      i = 2;
      break;
      if (!str1.equals("on_trip"))
        break;
      i = 3;
      break;
      if (!str1.equals("redispatching"))
        break;
      i = 4;
      break;
      String str2 = paramTripNotificationData.getPickupAddress();
      if (!TextUtils.isEmpty(str2))
      {
        localArrayList.add(localContext.getString(2131558958, new Object[] { str2 }));
        continue;
        if (paramTripNotificationData.getSurgeMultiplier() > 1.0F)
        {
          Object[] arrayOfObject = new Object[1];
          arrayOfObject[0] = Float.valueOf(paramTripNotificationData.getSurgeMultiplier());
          localArrayList.add(localContext.getString(2131558972, arrayOfObject));
        }
        if (!paramBoolean)
          localArrayList.add(paramTripNotificationData.getVehicleDisplayName());
        if (paramTripNotificationData.getVehicleLicense() != null)
        {
          localArrayList.add(paramTripNotificationData.getVehicleLicense());
          continue;
          localArrayList.add(paramTripNotificationData.getDriverName());
          if (paramTripNotificationData.getVehicleLicense() != null)
          {
            localArrayList.add(paramTripNotificationData.getVehicleLicense());
            continue;
            localArrayList.add(localContext.getString(2131558969));
          }
        }
      }
    }
  }

  private CharSequence getContentTextFareSplit(TripNotificationData paramTripNotificationData)
  {
    int i = paramTripNotificationData.getJoinedFareSplitClientsCount();
    int j = paramTripNotificationData.getFareSplitClients().size();
    Context localContext = getContext();
    if (i == 0)
      return localContext.getString(2131558962);
    if (i != j)
    {
      Object[] arrayOfObject3 = new Object[2];
      arrayOfObject3[0] = Integer.valueOf(i);
      arrayOfObject3[1] = Integer.valueOf(j);
      return localContext.getString(2131558961, arrayOfObject3);
    }
    if (j == 1)
    {
      Object[] arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = Integer.valueOf(j);
      return localContext.getString(2131558963, arrayOfObject2);
    }
    Object[] arrayOfObject1 = new Object[2];
    arrayOfObject1[0] = Integer.valueOf(i);
    arrayOfObject1[1] = Integer.valueOf(j);
    return localContext.getString(2131558961, arrayOfObject1);
  }

  private boolean populateNotification(NotificationCompat.Builder paramBuilder, TripNotificationData paramTripNotificationData)
  {
    ArrayList localArrayList = new ArrayList();
    String str1 = getContentText(paramTripNotificationData, false);
    String str2 = getContentText(paramTripNotificationData, true);
    Context localContext = getContext();
    int i = paramTripNotificationData.getMessageIdentifier();
    String str3 = paramTripNotificationData.getTripStatus();
    int j = -1;
    switch (str3.hashCode())
    {
    default:
    case 1065961768:
    case -2146525273:
    case -734206867:
    case -1325796731:
    case 2130210069:
    }
    while (true)
      switch (j)
      {
      default:
        return false;
        if (str3.equals("dispatching"))
        {
          j = 0;
          continue;
          if (str3.equals("accepted"))
          {
            j = 1;
            continue;
            if (str3.equals("arrived"))
            {
              j = 2;
              continue;
              if (str3.equals("on_trip"))
              {
                j = 3;
                continue;
                if (str3.equals("redispatching"))
                  j = 4;
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
      }
    String str7 = localContext.getString(2131558959);
    localArrayList.add(str7);
    paramBuilder.setLargeIcon(this.mPainter.loadMonoBitmap(paramTripNotificationData.getVehicleViewMonoImageUrl(), this.mPainter.getIconSizeLarge(), true));
    paramBuilder.setContentTitle(str7);
    paramBuilder.setProgress(0, 0, true);
    addActionCancel(paramBuilder, i);
    if (paramTripNotificationData.getSource() == NotificationData.Source.PING)
      localArrayList.clear();
    boolean bool = this.mPreferences.isFlagNotificationsClientsEnabled();
    if (bool)
    {
      List localList = paramTripNotificationData.getAcceptedFareSplitClientsSince(this.mLastData);
      if ((localList != null) && (!localList.isEmpty()))
        localArrayList.add(localContext.getString(2131558965, new Object[] { Joiner.on(", ").join(Iterables.transform(localList, new Function()
        {
          public String apply(TripNotificationData.FareSplitClient paramAnonymousFareSplitClient)
          {
            return paramAnonymousFareSplitClient.getName();
          }
        })) }));
    }
    if (!localArrayList.isEmpty())
      paramBuilder.setTicker(Joiner.on("\n").join(localArrayList));
    int k;
    if ((str3.equals("accepted")) || (str3.equals("arrived")))
    {
      k = 1;
      label435: if ((!bool) || (!paramTripNotificationData.hasFareSplit()) || (!paramTripNotificationData.isMaster()))
        break label765;
      paramBuilder.setContentText(getContentTextFareSplit(paramTripNotificationData));
      paramBuilder.setStyle(buildStyleInbox(paramBuilder, paramTripNotificationData, str2));
    }
    while (true)
    {
      return true;
      String str6 = localContext.getString(2131558952);
      if (paramTripNotificationData.getSurgeMultiplier() > 1.0F)
      {
        Object[] arrayOfObject2 = new Object[1];
        arrayOfObject2[0] = Float.valueOf(paramTripNotificationData.getSurgeMultiplier());
        localArrayList.add(localContext.getString(2131558953, arrayOfObject2));
      }
      while (true)
      {
        paramBuilder.setLargeIcon(this.mPainter.drawEtaBitmap(paramTripNotificationData.getTripEta()));
        paramBuilder.setContentTitle(str6);
        addTripActions(paramBuilder, paramTripNotificationData, i);
        break;
        localArrayList.add(str6);
      }
      String str5 = localContext.getString(2131558954);
      localArrayList.add(str5);
      paramBuilder.setLargeIcon(this.mPainter.drawEtaBitmap(paramTripNotificationData.getTripEta()));
      paramBuilder.setContentTitle(str5);
      addTripActions(paramBuilder, paramTripNotificationData, i);
      break;
      paramBuilder.setContentTitle(localContext.getString(2131558964));
      addTripActions(paramBuilder, paramTripNotificationData, i);
      break;
      Object[] arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = paramTripNotificationData.getDriverName();
      String str4 = localContext.getString(2131558971, arrayOfObject1);
      localArrayList.add(localContext.getString(2131558970, new Object[] { str4, str1 }));
      paramBuilder.setLargeIcon(this.mPainter.loadMonoBitmap(paramTripNotificationData.getVehicleViewMonoImageUrl(), this.mPainter.getIconSizeLarge(), true));
      paramBuilder.setContentTitle(str4);
      paramBuilder.setProgress(0, 0, true);
      addActionCancel(paramBuilder, i);
      break;
      k = 0;
      break label435;
      label765: if (k != 0)
      {
        paramBuilder.setContentText(str1);
        paramBuilder.setStyle(buildStyleBigPicture(paramBuilder, paramTripNotificationData, str2));
      }
      else
      {
        paramBuilder.setContentText(str1);
      }
    }
  }

  private void setLastData(TripNotificationData paramTripNotificationData)
  {
    this.mLastData = paramTripNotificationData;
    SharedPreferences.Editor localEditor = getPreferences().edit();
    if (paramTripNotificationData == null)
      localEditor.remove("trip_last_data");
    while (true)
    {
      localEditor.apply();
      return;
      try
      {
        localEditor.putString("trip_last_data", this.mGson.toJson(paramTripNotificationData));
      }
      catch (JsonParseException localJsonParseException)
      {
        localEditor.remove("trip_last_data");
      }
    }
  }

  private void startBackgroundPing()
  {
    if (!this.mIsServiceBound)
    {
      this.mIsServiceBound = true;
      Intent localIntent = new Intent(getContext(), RiderService.class);
      getContext().bindService(localIntent, this.mServiceConnection, 1);
    }
  }

  private void stopBackgroundPing()
  {
    if (this.mIsServiceBound)
    {
      this.mIsServiceBound = false;
      getContext().unbindService(this.mServiceConnection);
    }
  }

  public void handleNotification(TripNotificationData paramTripNotificationData)
  {
    String str = paramTripNotificationData.getTripStatus();
    if (TextUtils.isEmpty(str));
    TripNotificationData localTripNotificationData;
    do
    {
      return;
      localTripNotificationData = this.mLastData;
      if ((localTripNotificationData != null) && (!localTripNotificationData.getTripId().equals(paramTripNotificationData.getTripId())))
      {
        cancel(1, localTripNotificationData.getTripId());
        cancel(7, localTripNotificationData.getTripId());
        setLastData(null);
      }
    }
    while ((localTripNotificationData != null) && (localTripNotificationData.equals(paramTripNotificationData)));
    if (str.equals("canceled"))
      displayCanceledNotification(paramTripNotificationData);
    int i;
    int j;
    if ((str.equals("accepted")) || (str.equals("arrived")))
    {
      i = 1;
      if ((!str.equals("ended")) && (!str.equals("canceled")))
        break label159;
      j = 1;
      label133: if (i == 0)
        break label165;
      startBackgroundPing();
    }
    while (true)
    {
      displayTripNotification(paramTripNotificationData);
      setLastData(paramTripNotificationData);
      return;
      i = 0;
      break;
      label159: j = 0;
      break label133;
      label165: if (j != 0)
        break label177;
      stopBackgroundPing();
    }
    label177: cleanUpNotification(paramTripNotificationData);
  }

  public void handleNotificationDeleted(int paramInt, String paramString)
  {
    stopBackgroundPing();
    setLastData(null);
  }

  @Subscribe
  public void onPingClientResponseEvent(PingClientResponseEvent paramPingClientResponseEvent)
  {
    if (this.mLastData == null);
    while (paramPingClientResponseEvent.isSuccess())
      return;
    stopBackgroundPing();
    Context localContext = getContext();
    NotificationCompat.Builder localBuilder = new NotificationCompat.Builder(localContext).setSmallIcon(2130837771).setContentIntent(createPendingIntent(this.mLastData.getMessageIdentifier(), "com.ubercab.client.ACTION_TRIP_SHOW_MAP")).setContentTitle(localContext.getString(2131558947)).setContentText(localContext.getString(2131558946)).setDeleteIntent(createDeletePendingIntent(1, null)).setWhen(0L).setVibrate(null).setSound(null);
    notify(1, this.mLastData.getTag(), localBuilder.build());
  }

  @Subscribe
  public void onPingEvent(PingEvent paramPingEvent)
  {
    Ping localPing = paramPingEvent.getPing();
    TripNotificationData localTripNotificationData1 = this.mLastData;
    if (localTripNotificationData1 == null)
      return;
    if (!PingUtils.hasTrip(localPing))
    {
      cleanUpNotification(this.mLastData);
      return;
    }
    Trip localTrip;
    label44: int i;
    label67: int j;
    if (PingUtils.hasTrip(localPing))
    {
      localTrip = localPing.getTrip();
      if ((localTrip == null) || (localTrip.getEta() == this.mLastData.getTripEta()))
        break label178;
      i = 1;
      if ((!PingUtils.hasTripDestination(localPing)) || (localTripNotificationData1.hasDestination()))
        break label184;
      j = 1;
      label84: if ((!localTripNotificationData1.getTripStatus().equals("accepted")) && (!localTripNotificationData1.getTripStatus().equals("arrived")))
        break label190;
    }
    label178: label184: label190: for (int k = 1; ; k = 0)
    {
      final TripNotificationData localTripNotificationData2 = TripNotificationData.fromPing(localPing);
      if ((k == 0) || ((i == 0) && (j == 0)))
        break;
      localTripNotificationData2.setSurgeMultiplier(localTripNotificationData1.getSurgeMultiplier());
      localTripNotificationData2.setDriverExtra(localTripNotificationData1.getDriverExtra());
      this.mExecutorService.execute(new Runnable()
      {
        public void run()
        {
          TripNotificationHandler.this.handleNotification(localTripNotificationData2);
        }
      });
      return;
      localTrip = null;
      break label44;
      i = 0;
      break label67;
      j = 0;
      break label84;
    }
  }

  public void start()
  {
    super.start();
    SharedPreferences localSharedPreferences = getPreferences();
    if (localSharedPreferences.contains("trip_last_data"));
    try
    {
      this.mLastData = ((TripNotificationData)this.mGson.fromJson(localSharedPreferences.getString("trip_last_data", null), TripNotificationData.class));
      return;
    }
    catch (JsonParseException localJsonParseException)
    {
    }
  }

  public void stop()
  {
    super.stop();
    setLastData(null);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.notification.handler.TripNotificationHandler
 * JD-Core Version:    0.6.2
 */