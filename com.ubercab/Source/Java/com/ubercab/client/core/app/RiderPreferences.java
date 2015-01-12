package com.ubercab.client.core.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.ubercab.client.core.model.LocationSearchResult;
import com.ubercab.common.base.Objects;
import com.ubercab.library.content.SharedPreferencesWrapperUtil;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class RiderPreferences
{
  private static final long CURRENT_VERSION = 1L;
  private static final String FAKE_SURGE_KEY_FORMAT = "employee.settings.surge.fake.view_format_";
  static final String KEY_ENABLE_PAYTM = "enabled_paytm";
  static final String KEY_FAKE_LEGACY_MOBILE_MESSAGES_IN_PING = "fake_legacy_mobile_message";
  static final String KEY_FAKE_SURGE_VIEW_FORMAT = "employee.settings.surge.fake.view_format_%s";
  static final String KEY_FAVORITE_LOCATION_EMPTY_IMPRESSIONS_COUNT = "favorite_location_empty_impressions_count";
  static final String KEY_FAVORITE_LOCATION_PREFIX = "favorite_location_%s";
  static final String KEY_HAS_TRACKED_INSTALL = "has_tracked_install";
  static final String KEY_LAST_DOWNLOADED_EMPLOYEE_UPGRADE_URI = "last_downloaded_employee_upgrade_uri";
  static final String KEY_LOCATION_SEARCH = "location_search";
  static final String KEY_NEW_CONFIRMATION_ENABLED = "new_confirmation_enabled";
  static final String KEY_NOTIFICATIONS_ENABLED = "notifications_enabled";
  private static final String KEY_PREFERENCES_VERSION = "preferences_version";
  static final String KEY_REGISTERED_WITH_NOTIFIER = "registered_with_notifier";
  public static final String PAYPAL_ENVIRONMENT_MOCK = "mock";
  public static final String PAYPAL_ENVIRONMENT_PRODUCTION = "live";
  public static final String PAYPAL_ENVIRONMENT_SANDBOX = "sandbox";
  public static final String PREFERENCES_FILE_NAME = ".rider_preferences";
  private static final long UNDEFINED_VERSION;
  private Gson mGson;
  final String mKeyBraintreeEnv;
  final String mKeyDestinationEntry;
  final String mKeyFakeExpenseService;
  final String mKeyFakeFareEstimateFlowVariant;
  final String mKeyFakeFavoriteLocationsConstraints;
  final String mKeyFakeFavoriteLocationsVariant;
  final String mKeyFakeLastExpenseInfo;
  final String mKeyFakeSurgeScreenType;
  final String mKeyFlagDestinationEmphasisEnabled;
  final String mKeyFlagEssentialsCartEnabled;
  final String mKeyFlagFroiceSliderEnabled;
  final String mKeyFlagIndiaWallet;
  final String mKeyFlagLocationSearch;
  final String mKeyFlagMapAnimations;
  final String mKeyFlagNotificationsClients;
  final String mKeyGoogleWalletEnv;
  final String mKeyMobileMessaging;
  final String mKeyPayPalEnv;
  final String mKeyShowAllVehicles;
  final String mKeySliderStyle;
  private SharedPreferences mSharedPreferences;

  public RiderPreferences(Context paramContext, SharedPreferences paramSharedPreferences, Gson paramGson)
  {
    this.mSharedPreferences = paramSharedPreferences;
    this.mGson = paramGson;
    this.mKeyBraintreeEnv = paramContext.getString(2131559196);
    this.mKeyDestinationEntry = paramContext.getString(2131559158);
    this.mKeyFakeExpenseService = paramContext.getString(2131559197);
    this.mKeyFakeLastExpenseInfo = paramContext.getString(2131559200);
    this.mKeyFakeSurgeScreenType = paramContext.getString(2131559209);
    this.mKeyFakeFavoriteLocationsConstraints = paramContext.getString(2131559159);
    this.mKeyFakeFavoriteLocationsVariant = paramContext.getString(2131559164);
    this.mKeyFlagDestinationEmphasisEnabled = paramContext.getString(2131559165);
    this.mKeyFlagEssentialsCartEnabled = paramContext.getString(2131559166);
    this.mKeyFlagFroiceSliderEnabled = paramContext.getString(2131559167);
    this.mKeyFlagIndiaWallet = paramContext.getString(2131559199);
    this.mKeyFlagLocationSearch = paramContext.getString(2131559168);
    this.mKeyFlagMapAnimations = paramContext.getString(2131559169);
    this.mKeyFlagNotificationsClients = paramContext.getString(2131559170);
    this.mKeyFakeFareEstimateFlowVariant = paramContext.getString(2131559162);
    this.mKeyMobileMessaging = paramContext.getString(2131559175);
    this.mKeyGoogleWalletEnv = paramContext.getString(2131559198);
    this.mKeyPayPalEnv = paramContext.getString(2131559201);
    this.mKeyShowAllVehicles = paramContext.getString(2131559193);
    this.mKeySliderStyle = paramContext.getString(2131559207);
    runMigrations();
  }

  private long getPreferencesVersion()
  {
    return this.mSharedPreferences.getLong("preferences_version", 0L);
  }

  private void migrate(long paramLong1, long paramLong2)
  {
    if ((paramLong1 == 0L) && (paramLong2 == 1L))
    {
      SharedPreferencesWrapperUtil.upgradeStringToBool(this.mSharedPreferences, "fake_legacy_mobile_message");
      SharedPreferencesWrapperUtil.upgradeStringToBool(this.mSharedPreferences, "has_tracked_install");
      SharedPreferencesWrapperUtil.upgradeStringToBool(this.mSharedPreferences, "new_confirmation_enabled");
      SharedPreferencesWrapperUtil.upgradeStringToBool(this.mSharedPreferences, "notifications_enabled");
      SharedPreferencesWrapperUtil.upgradeStringToBool(this.mSharedPreferences, "registered_with_notifier");
      SharedPreferencesWrapperUtil.upgradeStringToBool(this.mSharedPreferences, this.mKeyBraintreeEnv);
      SharedPreferencesWrapperUtil.upgradeStringToBool(this.mSharedPreferences, this.mKeyFakeExpenseService);
      SharedPreferencesWrapperUtil.upgradeStringToBool(this.mSharedPreferences, this.mKeyFakeLastExpenseInfo);
      SharedPreferencesWrapperUtil.upgradeStringToBool(this.mSharedPreferences, this.mKeyFlagDestinationEmphasisEnabled);
      SharedPreferencesWrapperUtil.upgradeStringToBool(this.mSharedPreferences, this.mKeyFlagEssentialsCartEnabled);
      SharedPreferencesWrapperUtil.upgradeStringToBool(this.mSharedPreferences, this.mKeyFlagIndiaWallet);
      SharedPreferencesWrapperUtil.upgradeStringToBool(this.mSharedPreferences, this.mKeyFlagLocationSearch);
      SharedPreferencesWrapperUtil.upgradeStringToBool(this.mSharedPreferences, this.mKeyFlagMapAnimations);
      SharedPreferencesWrapperUtil.upgradeStringToBool(this.mSharedPreferences, this.mKeyFlagNotificationsClients);
      SharedPreferencesWrapperUtil.upgradeStringToBool(this.mSharedPreferences, this.mKeyMobileMessaging);
      SharedPreferencesWrapperUtil.upgradeStringToBool(this.mSharedPreferences, this.mKeyShowAllVehicles);
      String str1 = this.mSharedPreferences.getString(this.mKeyGoogleWalletEnv, "");
      try
      {
        int i = Integer.parseInt(str1);
        this.mSharedPreferences.edit().putInt(this.mKeyGoogleWalletEnv, i).apply();
        Iterator localIterator = this.mSharedPreferences.getAll().keySet().iterator();
        while (localIterator.hasNext())
        {
          String str2 = (String)localIterator.next();
          if (str2.contains("employee.settings.surge.fake.view_format_"))
            this.mSharedPreferences.edit().remove(str2).apply();
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        while (true)
          this.mSharedPreferences.edit().remove(this.mKeyGoogleWalletEnv).apply();
      }
    }
  }

  private void runMigrations()
  {
    long l = getPreferencesVersion();
    while (l < 1L)
    {
      migrate(l, l + 1L);
      l += 1L;
      this.mSharedPreferences.edit().putLong("preferences_version", l).apply();
    }
  }

  public void clear()
  {
    clearFavoriteLocationImpressionCount();
  }

  public void clearFavoriteLocationImpressionCount()
  {
    this.mSharedPreferences.edit().remove("favorite_location_empty_impressions_count").apply();
  }

  public String getDestinationEntry()
  {
    return this.mSharedPreferences.getString(this.mKeyDestinationEntry, "");
  }

  public String getFakeFareEstimateFlowVariant()
  {
    return this.mSharedPreferences.getString(this.mKeyFakeFareEstimateFlowVariant, "");
  }

  public String getFakeFavoriteLocationsVariant()
  {
    return this.mSharedPreferences.getString(this.mKeyFakeFavoriteLocationsVariant, "");
  }

  public String getFakeSurgeScreenType()
  {
    return this.mSharedPreferences.getString(this.mKeyFakeSurgeScreenType, "");
  }

  public LocationSearchResult getFavoriteLocation(String paramString)
  {
    String str1 = String.format("favorite_location_%s", new Object[] { paramString });
    String str2 = this.mSharedPreferences.getString(str1, null);
    if (str2 == null)
      return null;
    return (LocationSearchResult)this.mGson.fromJson(str2, LocationSearchResult.class);
  }

  public int getFavoriteLocationImpressionCount()
  {
    return this.mSharedPreferences.getInt("favorite_location_empty_impressions_count", 0);
  }

  public String getFlagLocationSearch()
  {
    return this.mSharedPreferences.getString(this.mKeyFlagLocationSearch, "");
  }

  public int getGoogleWalletEnvironment()
  {
    return this.mSharedPreferences.getInt(this.mKeyGoogleWalletEnv, 1);
  }

  public String getKeySliderStyle()
  {
    return this.mSharedPreferences.getString(this.mKeySliderStyle, "");
  }

  public String getLastDownloadedEmployeeUpgradeUri()
  {
    return this.mSharedPreferences.getString("last_downloaded_employee_upgrade_uri", "");
  }

  public String getLocationSearch()
  {
    return this.mSharedPreferences.getString("location_search", "");
  }

  public String getPayPalEnvironment()
  {
    String str = this.mSharedPreferences.getString(this.mKeyPayPalEnv, "");
    if (TextUtils.isEmpty(str))
      str = "live";
    return str;
  }

  public boolean hasDestinationEntry()
  {
    return !TextUtils.isEmpty(getDestinationEntry());
  }

  public boolean hasFakeExpenseService()
  {
    return this.mSharedPreferences.getBoolean(this.mKeyFakeExpenseService, false);
  }

  public boolean hasFakeFavoriteLocationDistanceConstraints()
  {
    return this.mSharedPreferences.getBoolean(this.mKeyFakeFavoriteLocationsConstraints, false);
  }

  public boolean hasFakeLastExpenseInfo()
  {
    return this.mSharedPreferences.getBoolean(this.mKeyFakeLastExpenseInfo, false);
  }

  public boolean hasFakeLegacyMobileMessage()
  {
    return this.mSharedPreferences.getBoolean("fake_legacy_mobile_message", false);
  }

  public boolean hasFakeMobileMessage()
  {
    return this.mSharedPreferences.getBoolean(this.mKeyMobileMessaging, false);
  }

  public boolean hasFakeSurgeScreenType()
  {
    return !TextUtils.isEmpty(this.mSharedPreferences.getString(this.mKeyFakeSurgeScreenType, ""));
  }

  public boolean hasFlagLocationSearch()
  {
    return !TextUtils.isEmpty(this.mSharedPreferences.getString(this.mKeyFlagLocationSearch, ""));
  }

  public boolean hasSurgeFake(String paramString)
  {
    return this.mSharedPreferences.getBoolean(String.format("employee.settings.surge.fake.view_format_%s", new Object[] { paramString }), false);
  }

  public boolean hasTrackedInstall()
  {
    return this.mSharedPreferences.getBoolean("has_tracked_install", false);
  }

  public void incrementFavoriteLocationImpressionCount()
  {
    int i = getFavoriteLocationImpressionCount();
    this.mSharedPreferences.edit().putInt("favorite_location_empty_impressions_count", i + 1).apply();
  }

  public boolean isDestinationEmphasisEnabled()
  {
    return this.mSharedPreferences.getBoolean(this.mKeyFlagDestinationEmphasisEnabled, false);
  }

  public boolean isEssentialsCartFeatureFlagEnabled()
  {
    return this.mSharedPreferences.getBoolean(this.mKeyFlagEssentialsCartEnabled, false);
  }

  public boolean isFakeFavoriteLocationsEnabledForHomeWork()
  {
    return Objects.equal(this.mSharedPreferences.getString(this.mKeyFakeFavoriteLocationsVariant, ""), "homeAndWork");
  }

  public boolean isFlagFroiceSliderEnabled()
  {
    return this.mSharedPreferences.getBoolean(this.mKeyFlagFroiceSliderEnabled, false);
  }

  public boolean isFlagMapAnimationsEnabled()
  {
    return this.mSharedPreferences.getBoolean(this.mKeyFlagMapAnimations, false);
  }

  public boolean isFlagNotificationsClientsEnabled()
  {
    return this.mSharedPreferences.getBoolean(this.mKeyFlagNotificationsClients, false);
  }

  public boolean isNewConfirmationEnabled()
  {
    return this.mSharedPreferences.getBoolean("new_confirmation_enabled", false);
  }

  public boolean isNotificationsEnabled()
  {
    return this.mSharedPreferences.getBoolean("notifications_enabled", false);
  }

  public boolean isPayTmEnabled()
  {
    return this.mSharedPreferences.getBoolean("enabled_paytm", false);
  }

  public boolean isPayTmSignupEnabled()
  {
    return this.mSharedPreferences.getBoolean(this.mKeyFlagIndiaWallet, false);
  }

  public boolean isRegisteredWithNotifier()
  {
    return this.mSharedPreferences.getBoolean("registered_with_notifier", false);
  }

  public boolean isShowingAllVehicles()
  {
    return this.mSharedPreferences.getBoolean(this.mKeyShowAllVehicles, false);
  }

  public boolean isUseBraintreeDevKey()
  {
    return this.mSharedPreferences.getBoolean(this.mKeyBraintreeEnv, false);
  }

  public boolean isUseBraintreeProdKey()
  {
    return !isUseBraintreeDevKey();
  }

  public void removeFakeSurge(String paramString)
  {
    this.mSharedPreferences.edit().putBoolean(String.format("employee.settings.surge.fake.view_format_%s", new Object[] { paramString }), false).apply();
  }

  public void removeFakeSurgeScreenType()
  {
    this.mSharedPreferences.edit().remove(this.mKeyFakeSurgeScreenType).apply();
  }

  public void removeFavoriteLocation(String paramString)
  {
    String str = String.format("favorite_location_%s", new Object[] { paramString });
    this.mSharedPreferences.edit().remove(str).apply();
  }

  public void removeGoogleWalletEnvironment()
  {
    this.mSharedPreferences.edit().remove(this.mKeyGoogleWalletEnv).apply();
  }

  public void removePayPalEnvironment()
  {
    this.mSharedPreferences.edit().remove(this.mKeyPayPalEnv).apply();
  }

  public void reset()
  {
    this.mSharedPreferences.edit().clear().apply();
  }

  public void setDestinationEmphasisEnabled(boolean paramBoolean)
  {
    this.mSharedPreferences.edit().putBoolean(this.mKeyFlagDestinationEmphasisEnabled, paramBoolean).apply();
  }

  public void setDestinationEntry(String paramString)
  {
    this.mSharedPreferences.edit().putString(this.mKeyDestinationEntry, paramString).apply();
  }

  public void setEssentialsCartFeatureFlag(boolean paramBoolean)
  {
    this.mSharedPreferences.edit().putBoolean(this.mKeyFlagEssentialsCartEnabled, paramBoolean).apply();
  }

  public void setFakeExpenseService(boolean paramBoolean)
  {
    this.mSharedPreferences.edit().putBoolean(this.mKeyFakeExpenseService, paramBoolean).apply();
  }

  public void setFakeFareEstimateFlowVariant(String paramString)
  {
    this.mSharedPreferences.edit().putString(this.mKeyFakeFareEstimateFlowVariant, paramString).apply();
  }

  public void setFakeFavoriteLocationDistanceConstraints(boolean paramBoolean)
  {
    this.mSharedPreferences.edit().putBoolean(this.mKeyFakeFavoriteLocationsConstraints, paramBoolean).apply();
  }

  public void setFakeFavoriteLocationsVariant(String paramString)
  {
    this.mSharedPreferences.edit().putString(this.mKeyFakeFavoriteLocationsVariant, paramString).apply();
  }

  public void setFakeLastExpenseInfo(boolean paramBoolean)
  {
    this.mSharedPreferences.edit().putBoolean(this.mKeyFakeLastExpenseInfo, paramBoolean).apply();
  }

  public void setFakeLegacyMobileMessage(boolean paramBoolean)
  {
    this.mSharedPreferences.edit().putBoolean("fake_legacy_mobile_message", paramBoolean).apply();
  }

  public void setFakeMobileMessage(boolean paramBoolean)
  {
    this.mSharedPreferences.edit().putBoolean(this.mKeyMobileMessaging, paramBoolean).apply();
  }

  public void setFakeSurge(String paramString)
  {
    this.mSharedPreferences.edit().putBoolean(String.format("employee.settings.surge.fake.view_format_%s", new Object[] { paramString }), true).apply();
  }

  public void setFakeSurgeScreenType(String paramString)
  {
    this.mSharedPreferences.edit().putString(this.mKeyFakeSurgeScreenType, paramString).apply();
  }

  public void setFavoriteLocation(String paramString, LocationSearchResult paramLocationSearchResult)
  {
    if (paramLocationSearchResult == null)
      return;
    String str1 = this.mGson.toJson(paramLocationSearchResult, LocationSearchResult.class);
    String str2 = String.format("favorite_location_%s", new Object[] { paramString });
    this.mSharedPreferences.edit().putString(str2, str1).apply();
  }

  public void setFavoriteLocationImpressionCount(int paramInt)
  {
    this.mSharedPreferences.edit().putInt("favorite_location_empty_impressions_count", paramInt).apply();
  }

  public void setFlagFroiceSliderEnabled(boolean paramBoolean)
  {
    this.mSharedPreferences.edit().putBoolean(this.mKeyFlagFroiceSliderEnabled, paramBoolean).apply();
  }

  public void setFlagLocationSearch(String paramString)
  {
    this.mSharedPreferences.edit().putString(this.mKeyFlagLocationSearch, paramString).apply();
  }

  public void setFlagMapAnimationsEnabled(boolean paramBoolean)
  {
    this.mSharedPreferences.edit().putBoolean(this.mKeyFlagMapAnimations, paramBoolean).apply();
  }

  public void setFlagNotificationsClientsEnabled(boolean paramBoolean)
  {
    this.mSharedPreferences.edit().putBoolean(this.mKeyFlagNotificationsClients, paramBoolean).apply();
  }

  public void setGoogleWalletEnvironment(int paramInt)
  {
    if (paramInt == 0)
    {
      this.mSharedPreferences.edit().putInt(this.mKeyGoogleWalletEnv, paramInt).apply();
      return;
    }
    if (paramInt == 2)
    {
      this.mSharedPreferences.edit().putInt(this.mKeyGoogleWalletEnv, paramInt).apply();
      return;
    }
    this.mSharedPreferences.edit().remove(this.mKeyGoogleWalletEnv).apply();
  }

  public void setKeySliderStyle(String paramString)
  {
    this.mSharedPreferences.edit().putString(this.mKeySliderStyle, paramString).apply();
  }

  public void setLastDownloadedEmployeeUpgradeUri(String paramString)
  {
    this.mSharedPreferences.edit().putString("last_downloaded_employee_upgrade_uri", paramString).apply();
  }

  public void setLocationSearch(String paramString)
  {
    this.mSharedPreferences.edit().putString("location_search", paramString).apply();
  }

  public void setNewConfirmationEnabled(boolean paramBoolean)
  {
    this.mSharedPreferences.edit().putBoolean("new_confirmation_enabled", paramBoolean).apply();
  }

  public void setNotificationsEnabled(boolean paramBoolean)
  {
    this.mSharedPreferences.edit().putBoolean("notifications_enabled", paramBoolean).apply();
  }

  public void setPayPalEnvironment(String paramString)
  {
    this.mSharedPreferences.edit().putString(this.mKeyPayPalEnv, paramString).apply();
  }

  public void setPayTmEnabled(boolean paramBoolean)
  {
    this.mSharedPreferences.edit().putBoolean("enabled_paytm", paramBoolean).apply();
  }

  public void setPayTmSignupEnabled(boolean paramBoolean)
  {
    this.mSharedPreferences.edit().putBoolean(this.mKeyFlagIndiaWallet, paramBoolean).apply();
  }

  public void setRegisteredWithNotifier(boolean paramBoolean)
  {
    this.mSharedPreferences.edit().putBoolean("registered_with_notifier", paramBoolean).apply();
  }

  public void setShowAllVehicles(boolean paramBoolean)
  {
    this.mSharedPreferences.edit().putBoolean(this.mKeyShowAllVehicles, paramBoolean).apply();
  }

  public void setTrackedInstall(boolean paramBoolean)
  {
    this.mSharedPreferences.edit().putBoolean("has_tracked_install", paramBoolean).apply();
  }

  public void setUseBraintreeDevKey()
  {
    this.mSharedPreferences.edit().putBoolean(this.mKeyBraintreeEnv, true).apply();
  }

  public void setUseBraintreeProdKey()
  {
    this.mSharedPreferences.edit().putBoolean(this.mKeyBraintreeEnv, false).apply();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.app.RiderPreferences
 * JD-Core Version:    0.6.2
 */