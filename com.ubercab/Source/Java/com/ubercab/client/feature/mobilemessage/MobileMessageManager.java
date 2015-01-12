package com.ubercab.client.feature.mobilemessage;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.squareup.otto.Bus;
import com.squareup.otto.Produce;
import com.squareup.otto.Subscribe;
import com.ubercab.client.core.content.PingProvider;
import com.ubercab.client.core.content.event.PingEvent;
import com.ubercab.client.core.model.AppConfig;
import com.ubercab.client.core.model.City;
import com.ubercab.client.core.model.MobileMessage;
import com.ubercab.client.core.model.MobileMessageDisplayProperties;
import com.ubercab.client.core.model.MobileMessageModule;
import com.ubercab.client.core.model.Ping;
import com.ubercab.client.core.model.RiderAppConfig;
import com.ubercab.client.core.util.PingUtils;
import com.ubercab.client.feature.mobilemessage.event.MobileMessageForLookingEvent;
import com.ubercab.client.feature.trip.slider.VehicleTextBitmap;
import com.ubercab.client.feature.trip.slider.VehicleTextBitmapsEvent;
import com.ubercab.common.base.Optional;
import com.ubercab.common.base.Predicate;
import com.ubercab.common.collect.ImmutableMap.Builder;
import com.ubercab.common.collect.Iterables;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MobileMessageManager
{
  static final String DIPLAY_PROPS_VERSION = "0.1";
  private static Map<String, String> DISPLAY_PROPS_VALUES_MAP = new ImmutableMap.Builder().put("supportVersion", "0.1").build();
  static final String LEGACY_PREFERENCES_KEY_VIEWED = "mobile_messages_viewed";
  static final String LEGACY_SHARED_PREFERENCES_KEY = "mobile_messages";
  static final String MOBILE_MESSAGES_VERSION = "0.1";
  static final String PARAM_DISPLAY_PROPS = "displayProps";
  static final String PARAM_DISPLAY_PROPS_VERSION = "supportVersion";
  static final String PARAM_ETAGS = "eTags";
  static final String PARAM_VERSION = "version";
  static final String PREF_LAST_REQUEST_VEHICLE_PREFIX_KEY = "message.lastrequest.";
  static final String PREF_LEGACY_MIGRATED_KEY = "messages.migrated";
  static final String PREF_SEEN_IDS_KEY = "messages.seen.ids";
  static final String SHARED_PREFERENCES_NAME = ".mobile_messages";
  private final Bus mBus;
  private Map<String, Object> mCachedParams;
  private final Context mContext;
  private MobileMessage mLastMessage;
  private final Map<String, MobileMessage> mMobileMessagesCache = new LinkedHashMap();
  private final Set<MobileMessageModuleView> mModulesPreloadCache = new HashSet();
  private final PingProvider mPingProvider;
  private final Set<String> mPreloadedMessages = new HashSet();
  private final Map<String, VehicleTextBitmap> mVehicleTextBitmaps = new HashMap();

  public MobileMessageManager(Context paramContext, Bus paramBus, PingProvider paramPingProvider)
  {
    this.mBus = paramBus;
    this.mContext = paramContext;
    this.mPingProvider = paramPingProvider;
  }

  private boolean expired(long paramLong1, long paramLong2)
  {
    if ((paramLong1 == 0L) || (paramLong2 == 0L));
    while (this.mPingProvider.getEpochTime() > paramLong1 + paramLong2)
      return true;
    return false;
  }

  private long getLastRequestTime(MobileMessage paramMobileMessage)
  {
    if ((paramMobileMessage == null) || (paramMobileMessage.getDisplayProps() == null))
      return 0L;
    return getPreferences().getLong("message.lastrequest." + paramMobileMessage.getId(), 0L);
  }

  private SharedPreferences getLegacyPreferences()
  {
    return this.mContext.getSharedPreferences("mobile_messages", 0);
  }

  private SharedPreferences getPreferences()
  {
    return this.mContext.getSharedPreferences(".mobile_messages", 0);
  }

  private boolean isMessageSeen(MobileMessage paramMobileMessage)
  {
    return (paramMobileMessage != null) && (getSeenIds().contains(paramMobileMessage.getId()));
  }

  private boolean isMigrationNeeded()
  {
    return getPreferences().getBoolean("messages.migrated", true);
  }

  private void migrateLegacyMessages()
  {
    Iterator localIterator = getLegacyPreferences().getStringSet("mobile_messages_viewed", new HashSet()).iterator();
    while (localIterator.hasNext())
      setMobileMessageSeen((String)localIterator.next());
    getPreferences().edit().putBoolean("messages.migrated", false).commit();
  }

  private void preload(MobileMessage paramMobileMessage)
  {
    if ((paramMobileMessage.getModules() == null) || (paramMobileMessage.getModules().isEmpty()));
    MobileMessageDisplayProperties localMobileMessageDisplayProperties;
    do
    {
      return;
      localMobileMessageDisplayProperties = paramMobileMessage.getDisplayProps();
    }
    while ((localMobileMessageDisplayProperties == null) || ((localMobileMessageDisplayProperties.getShowAfterRequestingVehicleViewId() == null) && (localMobileMessageDisplayProperties.getShowAsFareEstimateInfoForVehicleViewId() == null)));
    final MobileMessageModuleView localMobileMessageModuleView = new MobileMessageModuleView(this.mContext);
    localMobileMessageModuleView.setListener(new MobileMessageModuleView.Listener()
    {
      public void onReadyForDisplay()
      {
        MobileMessageManager.this.mModulesPreloadCache.remove(localMobileMessageModuleView);
        MobileMessageManager.this.mPreloadedMessages.add(localMobileMessageModuleView.getMessageId());
      }

      public void onUrlClicked(String paramAnonymousString)
      {
      }
    });
    this.mModulesPreloadCache.add(localMobileMessageModuleView);
    localMobileMessageModuleView.loadModule(paramMobileMessage.getId(), (MobileMessageModule)paramMobileMessage.getModules().get(0), this.mPingProvider.get());
  }

  private void resetCachedParams()
  {
    this.mCachedParams = null;
  }

  private boolean setMobileMessageSeen(String paramString)
  {
    if (paramString == null)
      return false;
    HashSet localHashSet = new HashSet(getSeenIds());
    localHashSet.add(paramString);
    SharedPreferences.Editor localEditor = getPreferences().edit();
    localEditor.putStringSet("messages.seen.ids", localHashSet);
    localEditor.putLong("message.lastrequest." + paramString, this.mPingProvider.getEpochTime());
    localEditor.apply();
    return true;
  }

  public void clearSeenMessages()
  {
    SharedPreferences.Editor localEditor = getPreferences().edit();
    localEditor.remove("messages.seen.ids");
    localEditor.apply();
    resetCachedParams();
    this.mMobileMessagesCache.clear();
    this.mLastMessage = null;
  }

  public MobileMessage findMessageForVehicleView(final String paramString, final boolean paramBoolean)
  {
    return (MobileMessage)Iterables.tryFind(this.mMobileMessagesCache.values(), new Predicate()
    {
      public boolean apply(MobileMessage paramAnonymousMobileMessage)
      {
        return (paramString.equals(paramAnonymousMobileMessage.getVehicleViewId())) && ((!paramBoolean) || (!MobileMessageManager.this.isMessageSeen(paramAnonymousMobileMessage)));
      }
    }).orNull();
  }

  public MobileMessage findMessageForVehicleViewAfterRequesting(final String paramString)
  {
    return (MobileMessage)Iterables.tryFind(this.mMobileMessagesCache.values(), new Predicate()
    {
      public boolean apply(MobileMessage paramAnonymousMobileMessage)
      {
        MobileMessageDisplayProperties localMobileMessageDisplayProperties = paramAnonymousMobileMessage.getDisplayProps();
        if (localMobileMessageDisplayProperties == null);
        long l1;
        long l2;
        do
        {
          return false;
          l1 = localMobileMessageDisplayProperties.getShowAsPersistentAfterRequestingWithTimeout();
          l2 = MobileMessageManager.this.getLastRequestTime(paramAnonymousMobileMessage);
        }
        while ((!paramString.equals(localMobileMessageDisplayProperties.getShowAfterRequestingVehicleViewId())) || (!MobileMessageManager.this.expired(l2, l1)));
        return true;
      }
    }).orNull();
  }

  public MobileMessage findMessageForVehicleViewFareEstimate(final String paramString)
  {
    return (MobileMessage)Iterables.tryFind(this.mMobileMessagesCache.values(), new Predicate()
    {
      public boolean apply(MobileMessage paramAnonymousMobileMessage)
      {
        MobileMessageDisplayProperties localMobileMessageDisplayProperties = paramAnonymousMobileMessage.getDisplayProps();
        if (localMobileMessageDisplayProperties == null);
        for (Object localObject = null; (localObject != null) && (paramString.equals(localObject)); localObject = localMobileMessageDisplayProperties.getShowAsFareEstimateInfoForVehicleViewId())
          return true;
        return false;
      }
    }).orNull();
  }

  public Map<String, Object> getCachedMessagesParams()
  {
    if (this.mCachedParams == null)
    {
      HashMap localHashMap1 = new HashMap();
      Iterator localIterator = this.mMobileMessagesCache.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str1 = (String)localIterator.next();
        String str2 = ((MobileMessage)this.mMobileMessagesCache.get(str1)).getETag();
        if (str2 != null)
          try
          {
            localHashMap1.put(str1, Long.valueOf(Long.parseLong(str2)));
          }
          catch (NumberFormatException localNumberFormatException)
          {
          }
      }
      HashMap localHashMap2 = new HashMap();
      localHashMap2.put("version", "0.1");
      localHashMap2.put("displayProps", DISPLAY_PROPS_VALUES_MAP);
      localHashMap2.put("eTags", localHashMap1);
      this.mCachedParams = localHashMap2;
    }
    return this.mCachedParams;
  }

  protected Set<String> getSeenIds()
  {
    return getPreferences().getStringSet("messages.seen.ids", Collections.emptySet());
  }

  public void init()
  {
    this.mBus.register(this);
    if (isMigrationNeeded())
      migrateLegacyMessages();
  }

  public boolean isPreloaded(String paramString)
  {
    return this.mPreloadedMessages.contains(paramString);
  }

  @Subscribe
  public void onPingEvent(PingEvent paramPingEvent)
  {
    Ping localPing = paramPingEvent.getPing();
    if (!PingUtils.hasMobileMessages(localPing));
    Object localObject;
    do
    {
      return;
      if ((!PingUtils.hasRiderAppConfig(localPing)) || (!localPing.getAppConfig().getRiderConfig().isMobileMessagingEnabled()))
      {
        this.mLastMessage = null;
        return;
      }
      localObject = null;
      Iterator localIterator = localPing.getCity().getMessages().iterator();
      while (localIterator.hasNext())
      {
        MobileMessage localMobileMessage = (MobileMessage)localIterator.next();
        if (!localMobileMessage.isStub())
        {
          if ((localObject == null) && (localMobileMessage.isShowAsModalOverRequestView()) && (!isMessageSeen(localMobileMessage)))
            localObject = localMobileMessage;
          resetCachedParams();
          this.mMobileMessagesCache.put(localMobileMessage.getId(), localMobileMessage);
          preload(localMobileMessage);
        }
      }
    }
    while (localObject == null);
    this.mLastMessage = localObject;
    this.mBus.post(new MobileMessageForLookingEvent(this.mLastMessage));
  }

  @Produce
  public MobileMessageForLookingEvent produceMobileMessageForLookingEvent()
  {
    if ((this.mLastMessage != null) && (!isMessageSeen(this.mLastMessage)))
      return new MobileMessageForLookingEvent(this.mLastMessage);
    return null;
  }

  @Produce
  public VehicleTextBitmapsEvent produceVehiclePositions()
  {
    return new VehicleTextBitmapsEvent(this.mVehicleTextBitmaps);
  }

  public boolean setMobileMessageSeen(MobileMessage paramMobileMessage)
  {
    if (paramMobileMessage == null)
      return false;
    return setMobileMessageSeen(paramMobileMessage.getId());
  }

  public void setVehicleTextBitmaps(Collection<VehicleTextBitmap> paramCollection)
  {
    this.mVehicleTextBitmaps.clear();
    if (paramCollection != null)
    {
      Iterator localIterator = paramCollection.iterator();
      while (localIterator.hasNext())
      {
        VehicleTextBitmap localVehicleTextBitmap = (VehicleTextBitmap)localIterator.next();
        this.mVehicleTextBitmaps.put(localVehicleTextBitmap.getVehicleId(), localVehicleTextBitmap);
      }
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.mobilemessage.MobileMessageManager
 * JD-Core Version:    0.6.2
 */