package com.ubercab.client.feature.mobilemessage;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.squareup.otto.Bus;
import com.squareup.otto.Produce;
import com.squareup.otto.Subscribe;
import com.ubercab.client.core.content.PingProvider;
import com.ubercab.client.core.content.event.PingEvent;
import com.ubercab.client.core.model.City;
import com.ubercab.client.core.model.LegacyMobileMessage;
import com.ubercab.client.core.model.Ping;
import com.ubercab.client.core.util.PingUtils;
import com.ubercab.client.feature.mobilemessage.event.LegacyMobileMessageEvent;
import java.util.HashSet;
import java.util.Set;

public class LegacyMobileMessageManager
{
  private static final String PREFERENCES_KEY_VIEWED = "mobile_messages_viewed";
  public static final String SHARED_PREFERENCES_KEY = "mobile_messages";
  private final Bus mBus;
  private final Context mContext;
  private final PingProvider mPingProvider;

  public LegacyMobileMessageManager(Context paramContext, Bus paramBus, PingProvider paramPingProvider)
  {
    this.mBus = paramBus;
    this.mContext = paramContext;
    this.mPingProvider = paramPingProvider;
  }

  private SharedPreferences getPreferences()
  {
    return this.mContext.getSharedPreferences("mobile_messages", 0);
  }

  private Set<String> getSeenMobileMessages()
  {
    return getPreferences().getStringSet("mobile_messages_viewed", new HashSet());
  }

  private boolean isMobileMessageSeen(String paramString)
  {
    Set localSet = getSeenMobileMessages();
    if (localSet == null)
      return false;
    return localSet.contains(paramString);
  }

  public void clearSeenMobileMessages()
  {
    getPreferences().edit().remove("mobile_messages_viewed").apply();
  }

  public void init()
  {
    this.mBus.register(this);
  }

  @Subscribe
  public void onPingEvent(PingEvent paramPingEvent)
  {
    LegacyMobileMessageEvent localLegacyMobileMessageEvent = produceMobileMessageEvent();
    if (localLegacyMobileMessageEvent != null)
      this.mBus.post(localLegacyMobileMessageEvent);
  }

  @Produce
  public LegacyMobileMessageEvent produceMobileMessageEvent()
  {
    Ping localPing = this.mPingProvider.get();
    if (!PingUtils.hasLegacyMobileMessage(localPing));
    LegacyMobileMessage localLegacyMobileMessage;
    do
    {
      return null;
      localLegacyMobileMessage = localPing.getCity().getEvent();
    }
    while ((localLegacyMobileMessage == null) || (isMobileMessageSeen(localLegacyMobileMessage.getId())));
    return new LegacyMobileMessageEvent(localLegacyMobileMessage);
  }

  public void setMobileMessageSeen(String paramString)
  {
    if (isMobileMessageSeen(paramString))
      return;
    HashSet localHashSet = new HashSet(getSeenMobileMessages());
    localHashSet.add(paramString);
    getPreferences().edit().putStringSet("mobile_messages_viewed", localHashSet).apply();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.mobilemessage.LegacyMobileMessageManager
 * JD-Core Version:    0.6.2
 */