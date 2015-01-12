package com.ubercab.client.feature.employee;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.EditTextPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.PreferenceCategory;
import android.preference.PreferenceFragment;
import android.text.TextUtils;
import android.widget.Toast;
import com.squareup.otto.Bus;
import com.ubercab.client.core.app.RiderApplication;
import com.ubercab.client.core.app.RiderPreferences;
import com.ubercab.client.core.app.RiderPublicActivity;
import com.ubercab.client.core.content.PingProvider;
import com.ubercab.client.core.content.RiderLocationProvider;
import com.ubercab.client.core.content.SessionPreferences;
import com.ubercab.client.core.location.RiderLocation;
import com.ubercab.client.core.model.City;
import com.ubercab.client.core.model.Client;
import com.ubercab.client.core.model.Ping;
import com.ubercab.client.core.model.TripPendingRating;
import com.ubercab.client.core.model.TripPendingRatingDriver;
import com.ubercab.client.core.model.VehicleView;
import com.ubercab.client.core.util.PingUtils;
import com.ubercab.client.feature.employee.event.PreferenceChangedEvent;
import com.ubercab.client.feature.employee.event.ShowFakeArrearsEvent;
import com.ubercab.client.feature.employee.event.ShowFakeLocationSearchEvent;
import com.ubercab.client.feature.employee.event.ShowFakeSmsVerificationEvent;
import com.ubercab.client.feature.employee.event.ShowFakeTokenVerificationEvent;
import com.ubercab.client.feature.employee.event.ShowFakeTripPendingRatingEvent;
import com.ubercab.client.feature.employee.inject.InjectPreference;
import com.ubercab.client.feature.employee.inject.OnPreferenceChange;
import com.ubercab.client.feature.employee.inject.OnPreferenceClick;
import com.ubercab.client.feature.employee.inject.PreferencesInjector;
import com.ubercab.client.feature.mobilemessage.LegacyMobileMessageManager;
import com.ubercab.client.feature.mobilemessage.MobileMessageManager;
import com.ubercab.client.feature.notification.RiderNotificationManager;
import com.ubercab.client.feature.notification.data.FareSplitAcceptedNotificationData;
import com.ubercab.client.feature.notification.data.FareSplitInviteNotificationData;
import com.ubercab.client.feature.notification.data.MessageNotificationData;
import com.ubercab.client.feature.notification.data.ReceiptNotificationData;
import com.ubercab.client.feature.notification.data.SurgeNotificationData;
import com.ubercab.client.feature.notification.data.TripNotificationData;
import com.ubercab.client.feature.payment.VerifyAlipayActivity;
import com.ubercab.library.app.UberPreferences;
import com.ubercab.library.location.model.UberLatLng;
import com.ubercab.library.location.model.UberLocation;
import com.ubercab.library.metrics.analytics.logging.AnalyticsEventListActivity;
import com.ubercab.library.network.log.SendLogsDialogFragment;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;

public class EmployeeSettingsFragment extends PreferenceFragment
{

  @Inject
  Bus mBus;

  @Inject
  ExecutorService mExecutorService;
  private String mKeySurgeFakePrefix;

  @Inject
  LegacyMobileMessageManager mLegacyMobileMessageManager;

  @Inject
  RiderLocationProvider mLocationProvider;

  @Inject
  MobileMessageManager mMobileMessageManager;

  @Inject
  PingProvider mPingProvider;

  @InjectPreference(2131559196)
  CheckBoxPreference mPreferenceBraintreeDevKey;
  private final Preference.OnPreferenceChangeListener mPreferenceChangeListenerSurge = new Preference.OnPreferenceChangeListener()
  {
    public boolean onPreferenceChange(Preference paramAnonymousPreference, Object paramAnonymousObject)
    {
      String str = paramAnonymousPreference.getKey().substring(EmployeeSettingsFragment.this.mKeySurgeFakePrefix.length());
      if (((Boolean)paramAnonymousObject).booleanValue())
        EmployeeSettingsFragment.this.mRiderPreferences.setFakeSurge(str);
      while (true)
      {
        EmployeeSettingsFragment.this.notifyPreferenceChanged();
        return true;
        EmployeeSettingsFragment.this.mRiderPreferences.removeFakeSurge(str);
      }
    }
  };

  @InjectPreference(2131559165)
  CheckBoxPreference mPreferenceDestinationEmphasisEnabled;

  @InjectPreference(2131559158)
  ListPreference mPreferenceDestinationEntry;

  @InjectPreference(2131559197)
  CheckBoxPreference mPreferenceExpenseServiceFake;

  @InjectPreference(2131559179)
  ListPreference mPreferenceFailoverStrategy;

  @InjectPreference(2131559159)
  CheckBoxPreference mPreferenceFakeFavoriteLocationConstraints;

  @InjectPreference(2131559163)
  EditTextPreference mPreferenceFakeImpressionCount;

  @InjectPreference(2131559177)
  CheckBoxPreference mPreferenceFakeLegacyMobileMessage;

  @InjectPreference(2131559209)
  ListPreference mPreferenceFakeSurgeScreenType;

  @InjectPreference(2131559162)
  ListPreference mPreferenceFareEstimateFlowVariant;

  @InjectPreference(2131559164)
  ListPreference mPreferenceFavoriteLocationsVariant;

  @InjectPreference(2131559166)
  CheckBoxPreference mPreferenceFlagEssentialsCartEnabled;

  @InjectPreference(2131559167)
  CheckBoxPreference mPreferenceFlagFroiceSliderEnabled;

  @InjectPreference(2131559169)
  CheckBoxPreference mPreferenceFlagMapAnimations;

  @InjectPreference(2131559170)
  CheckBoxPreference mPreferenceFlagNotificationsClients;

  @InjectPreference(2131559173)
  ListPreference mPreferenceGeoEngine;

  @InjectPreference(2131559198)
  ListPreference mPreferenceGoogleWalletEnvironment;

  @InjectPreference(2131559200)
  CheckBoxPreference mPreferenceLastExpenseInfoFake;

  @InjectPreference(2131559174)
  CheckBoxPreference mPreferenceLocationFake;

  @InjectPreference(2131559168)
  ListPreference mPreferenceLocationSearch;

  @InjectPreference(2131559178)
  CheckBoxPreference mPreferenceMobileMessaging;

  @InjectPreference(2131559180)
  EditTextPreference mPreferenceNetworkServer;

  @InjectPreference(2131559181)
  CheckBoxPreference mPreferenceNetworkSsl;

  @InjectPreference(2131559201)
  ListPreference mPreferencePayPalEnv;

  @InjectPreference(2131559199)
  CheckBoxPreference mPreferencePaymentIndiaWallet;

  @InjectPreference(2131559207)
  ListPreference mPreferenceSliderStyle;

  @InjectPreference(2131559208)
  PreferenceCategory mPreferenceSurgeFake;

  @InjectPreference(2131559193)
  CheckBoxPreference mPreferenceVehiclesShowAll;

  @InjectPreference(2131559211)
  EditTextPreference mPreferencesVersionFake;

  @Inject
  RiderNotificationManager mRiderNotificationManager;

  @Inject
  RiderPreferences mRiderPreferences;

  @Inject
  SessionPreferences mSessionPreferences;

  @Inject
  UberPreferences mUberPreferences;

  public static EmployeeSettingsFragment newInstance()
  {
    return new EmployeeSettingsFragment();
  }

  @OnPreferenceChange(2131559179)
  private void onPreferenceChangeFailoverStrategy(String paramString)
  {
    if (paramString.equals(getString(2131559120)))
      this.mUberPreferences.removeFakeCnFailoverStrategy();
    while (true)
    {
      notifyPreferenceChanged();
      return;
      this.mUberPreferences.setFakeCnFailoverStrategy(paramString);
    }
  }

  @OnPreferenceChange(2131559159)
  private void onPreferenceChangeFakeFavoriteLocationsConstraints(boolean paramBoolean)
  {
    this.mRiderPreferences.setFakeFavoriteLocationDistanceConstraints(paramBoolean);
    notifyPreferenceChanged();
  }

  @OnPreferenceChange(2131559178)
  private void onPreferenceChangeFakeMobileMessage(boolean paramBoolean)
  {
    this.mRiderPreferences.setFakeMobileMessage(paramBoolean);
    notifyPreferenceChanged();
  }

  @OnPreferenceChange(2131559165)
  private void onPreferenceChangeFlagDestinationEmphasis(boolean paramBoolean)
  {
    this.mRiderPreferences.setDestinationEmphasisEnabled(paramBoolean);
    notifyPreferenceChanged();
  }

  @OnPreferenceChange(2131559167)
  private void onPreferenceChangeFlagFroiceSlider(boolean paramBoolean)
  {
    this.mRiderPreferences.setFlagFroiceSliderEnabled(paramBoolean);
    notifyPreferenceChanged();
  }

  @OnPreferenceChange(2131559169)
  private void onPreferenceChangeFlagMapAnimations(boolean paramBoolean)
  {
    this.mRiderPreferences.setFlagMapAnimationsEnabled(paramBoolean);
    notifyPreferenceChanged();
  }

  @OnPreferenceChange(2131559177)
  private void onPreferenceChangeFlagMobileMessagesLegacy(boolean paramBoolean)
  {
    this.mRiderPreferences.setFakeLegacyMobileMessage(paramBoolean);
    notifyPreferenceChanged();
  }

  @OnPreferenceChange(2131559170)
  private void onPreferenceChangeFlagNotificationsClients(boolean paramBoolean)
  {
    this.mRiderPreferences.setFlagNotificationsClientsEnabled(paramBoolean);
    notifyPreferenceChanged();
  }

  @OnPreferenceChange(2131559173)
  private void onPreferenceChangeGeoEngine(String paramString)
  {
    if (paramString.equals(getString(2131559153)))
      this.mUberPreferences.removeFakeGeoEngine();
    while (true)
    {
      notifyPreferenceChanged();
      Toast.makeText(getActivity(), "Restart app for changes to take effect!", 1).show();
      return;
      if (paramString.equals(getString(2131559154)))
        this.mUberPreferences.setFakeGeoEngine(3);
      else if (paramString.equals(getString(2131559155)))
        this.mUberPreferences.setFakeGeoEngine(2);
    }
  }

  @OnPreferenceChange(2131559156)
  private void onPreferenceChangedAnalyticsLogging(boolean paramBoolean)
  {
    this.mUberPreferences.setAnalyticsV2Logging(paramBoolean);
  }

  @OnPreferenceChange(2131559196)
  private void onPreferenceChangedBraintreeDevKey(boolean paramBoolean)
  {
    if (paramBoolean)
      this.mRiderPreferences.setUseBraintreeDevKey();
    while (true)
    {
      notifyPreferenceChanged();
      return;
      this.mRiderPreferences.setUseBraintreeProdKey();
    }
  }

  @OnPreferenceChange(2131559158)
  private void onPreferenceChangedDestinationEntry(String paramString)
  {
    this.mRiderPreferences.setDestinationEntry(paramString);
    notifyPreferenceChanged();
  }

  @OnPreferenceChange(2131559166)
  private void onPreferenceChangedEssentialsCartEnabled(boolean paramBoolean)
  {
    this.mRiderPreferences.setEssentialsCartFeatureFlag(paramBoolean);
    notifyPreferenceChanged();
  }

  @OnPreferenceChange(2131559197)
  private void onPreferenceChangedFakeExpenseService(boolean paramBoolean)
  {
    this.mRiderPreferences.setFakeExpenseService(paramBoolean);
    notifyPreferenceChanged();
  }

  @OnPreferenceChange(2131559200)
  private void onPreferenceChangedFakeLastExpenseInfo(boolean paramBoolean)
  {
    this.mRiderPreferences.setFakeLastExpenseInfo(paramBoolean);
    notifyPreferenceChanged();
  }

  @OnPreferenceChange(2131559174)
  private void onPreferenceChangedFakeLocation(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mBus.post(new ShowFakeLocationSearchEvent());
      return;
    }
    this.mUberPreferences.removeFakeLocation();
    notifyPreferenceChanged();
  }

  @OnPreferenceChange(2131559209)
  private void onPreferenceChangedFakeSurgeScreenType(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      this.mRiderPreferences.removeFakeSurgeScreenType();
    while (true)
    {
      notifyPreferenceChanged();
      return;
      this.mRiderPreferences.setFakeSurgeScreenType(paramString);
    }
  }

  @OnPreferenceChange(2131559163)
  private void onPreferenceChangedFavoriteLocationImpressionCount(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      Toast.makeText(getActivity(), "Enter a count please.", 0).show();
      return;
    }
    int i;
    try
    {
      i = Integer.valueOf(paramString).intValue();
      if (i < 0)
      {
        Toast.makeText(getActivity(), "Enter a count value >= 0.", 0).show();
        return;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      Toast.makeText(getActivity(), "Invalid count value.", 0).show();
      return;
    }
    this.mRiderPreferences.setFavoriteLocationImpressionCount(i);
    notifyPreferenceChanged();
  }

  @OnPreferenceChange(2131559164)
  private void onPreferenceChangedFavoriteLocationsVariant(String paramString)
  {
    this.mRiderPreferences.setFakeFavoriteLocationsVariant(paramString);
    notifyPreferenceChanged();
  }

  @OnPreferenceChange(2131559198)
  private void onPreferenceChangedGoogleWalletEnvironment(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      this.mRiderPreferences.setGoogleWalletEnvironment(1);
    while (true)
    {
      notifyPreferenceChanged();
      return;
      this.mRiderPreferences.setGoogleWalletEnvironment(Integer.valueOf(paramString).intValue());
    }
  }

  @OnPreferenceChange(2131559168)
  private void onPreferenceChangedLocationSearch(String paramString)
  {
    this.mRiderPreferences.setFlagLocationSearch(paramString);
    notifyPreferenceChanged();
  }

  @OnPreferenceChange(2131559180)
  private void onPreferenceChangedNetworkServer(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      this.mUberPreferences.removeCnEndpoint();
    while (true)
    {
      notifyPreferenceChanged();
      RiderApplication.get(getActivity()).signout();
      return;
      if ((!paramString.startsWith("https://")) && (!paramString.startsWith("http://")))
        break;
      this.mUberPreferences.setCnEndpoint(paramString);
    }
    if (this.mUberPreferences.isCnSslVerificationDisabled());
    for (String str1 = "http://"; ; str1 = "https://")
    {
      String str2 = "";
      if ("amex".equals(paramString))
        str2 = ":8000";
      this.mUberPreferences.setCnEndpoint(String.format("%scn.%s.dev.uber.com%s", new Object[] { str1, paramString, str2 }));
      break;
    }
  }

  @OnPreferenceChange(2131559181)
  private void onPreferenceChangedNetworkSsl(boolean paramBoolean)
  {
    String str = this.mUberPreferences.getCnEndpoint();
    if (paramBoolean)
    {
      this.mUberPreferences.disableCnSslVerfification();
      this.mUberPreferences.setCnEndpoint(str.replaceFirst("https://", "http://"));
    }
    while (true)
    {
      notifyPreferenceChanged();
      return;
      this.mUberPreferences.enableCnSslVerification();
      this.mUberPreferences.setCnEndpoint(str.replaceFirst("http://", "https://"));
    }
  }

  @OnPreferenceChange(2131559189)
  private void onPreferenceChangedNotificationTrip(String paramString)
  {
    onPreferenceChangedNotificationTrip(paramString, false);
  }

  private void onPreferenceChangedNotificationTrip(final String paramString, final boolean paramBoolean)
  {
    this.mExecutorService.execute(new Runnable()
    {
      public void run()
      {
        boolean bool = paramBoolean;
        int i = 0;
        int j = 0;
        String str;
        int k;
        if (bool)
        {
          str = paramString;
          k = -1;
          switch (str.hashCode())
          {
          default:
            i = 0;
            j = 0;
            switch (k)
            {
            default:
            case 0:
            case 1:
            case 2:
            }
            break;
          case -2146525273:
          case -734206867:
          case -1325796731:
          }
        }
        while (true)
        {
          TripNotificationData localTripNotificationData = TripNotificationData.createFakeData(paramString, j, i);
          EmployeeSettingsFragment.this.mRiderNotificationManager.handleNotification(localTripNotificationData);
          return;
          if (!str.equals("accepted"))
            break;
          k = 0;
          break;
          if (!str.equals("arrived"))
            break;
          k = 1;
          break;
          if (!str.equals("on_trip"))
            break;
          k = 2;
          break;
          j = 1;
          i = 0;
          continue;
          j = 1;
          i = 1;
          continue;
          j = 3;
          i = 2;
        }
      }
    });
  }

  @OnPreferenceChange(2131559190)
  private void onPreferenceChangedNotificationTripSplit(String paramString)
  {
    onPreferenceChangedNotificationTrip(paramString, true);
  }

  @OnPreferenceChange(2131559201)
  private void onPreferenceChangedPayPalEnv(String paramString)
  {
    this.mRiderPreferences.setPayPalEnvironment(paramString);
    notifyPreferenceChanged();
  }

  @OnPreferenceChange(2131559199)
  private void onPreferenceChangedPaymentPayTm(boolean paramBoolean)
  {
    this.mRiderPreferences.setPayTmSignupEnabled(paramBoolean);
    this.mRiderPreferences.setPayTmEnabled(paramBoolean);
    notifyPreferenceChanged();
  }

  @OnPreferenceChange(2131559162)
  private void onPreferenceChangedRateCardVariant(String paramString)
  {
    this.mRiderPreferences.setFakeFareEstimateFlowVariant(paramString);
    notifyPreferenceChanged();
  }

  @OnPreferenceChange(2131559207)
  private void onPreferenceChangedSliderStyle(String paramString)
  {
    this.mRiderPreferences.setKeySliderStyle(paramString);
    notifyPreferenceChanged();
  }

  @OnPreferenceChange(2131559193)
  private void onPreferenceChangedVehiclesShowAll(boolean paramBoolean)
  {
    this.mRiderPreferences.setShowAllVehicles(paramBoolean);
    notifyPreferenceChanged();
  }

  @OnPreferenceChange(2131559211)
  private void onPreferenceChangedVersionFake(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      this.mUberPreferences.removeFakeVersion();
    while (true)
    {
      notifyPreferenceChanged();
      return;
      this.mUberPreferences.setFakeVersion(paramString);
    }
  }

  @OnPreferenceClick(2131559157)
  private void onPreferenceClickAnalyticsLogs()
  {
    startActivity(new Intent(getActivity(), AnalyticsEventListActivity.class));
  }

  @OnPreferenceClick(2131559176)
  private void onPreferenceClickClearMobileMessage()
  {
    this.mLegacyMobileMessageManager.clearSeenMobileMessages();
    this.mMobileMessageManager.clearSeenMessages();
  }

  @OnPreferenceClick(2131559269)
  private void onPreferenceClickFakeAlipay()
  {
    startActivity(new Intent(getActivity(), VerifyAlipayActivity.class));
  }

  @OnPreferenceClick(2131559192)
  private void onPreferenceClickFakeArrears()
  {
    this.mBus.post(new ShowFakeArrearsEvent());
  }

  @OnPreferenceClick(2131559172)
  private void onPreferenceClickForceCrash()
  {
    throw new RuntimeException("Fake Employee Settings Crash");
  }

  @OnPreferenceClick(2131559184)
  private void onPreferenceClickNotificationFareSplitAccepted()
  {
    this.mExecutorService.execute(new Runnable()
    {
      public void run()
      {
        EmployeeSettingsFragment.this.mRiderNotificationManager.handleNotification(FareSplitAcceptedNotificationData.createFakeData());
      }
    });
  }

  @OnPreferenceClick(2131559185)
  private void onPreferenceClickNotificationFareSplitInvite()
  {
    this.mExecutorService.execute(new Runnable()
    {
      public void run()
      {
        EmployeeSettingsFragment.this.mRiderNotificationManager.handleNotification(FareSplitInviteNotificationData.createFakeData());
      }
    });
  }

  @OnPreferenceClick(2131559186)
  private void onPreferenceClickNotificationMessage()
  {
    this.mExecutorService.execute(new Runnable()
    {
      public void run()
      {
        EmployeeSettingsFragment.this.mRiderNotificationManager.handleNotification(MessageNotificationData.createFakeData());
      }
    });
  }

  @OnPreferenceClick(2131559187)
  private void onPreferenceClickNotificationReceipt()
  {
    this.mExecutorService.execute(new Runnable()
    {
      public void run()
      {
        EmployeeSettingsFragment.this.mRiderNotificationManager.handleNotification(ReceiptNotificationData.createFakeData());
      }
    });
  }

  @OnPreferenceClick(2131559188)
  private void onPreferenceClickNotificationSurge()
  {
    this.mExecutorService.execute(new Runnable()
    {
      public void run()
      {
        EmployeeSettingsFragment.this.mRiderNotificationManager.handleNotification(SurgeNotificationData.createFakeData());
      }
    });
  }

  @OnPreferenceClick(2131559204)
  private void onPreferenceClickResetAddMusicOverlay()
  {
    this.mSessionPreferences.setAddMusicDismissed(false);
  }

  @OnPreferenceClick(2131559205)
  private void onPreferenceClickResetDestinationTutorial()
  {
    this.mSessionPreferences.setDestinationTutorialDismissed(false);
  }

  @OnPreferenceClick(2131559206)
  private void onPreferenceClickSendMobileLogs()
  {
    Ping localPing = this.mPingProvider.get();
    String str1 = "none";
    String str2 = "none";
    if (PingUtils.hasClient(localPing))
    {
      Client localClient = localPing.getClient();
      str1 = localClient.getUuid();
      str2 = localClient.getToken();
    }
    SendLogsDialogFragment.show(getActivity(), str1, str2);
  }

  @OnPreferenceClick(2131559194)
  private void onPreferenceClickShowFakeSmsVerification()
  {
    this.mBus.post(new ShowFakeSmsVerificationEvent());
  }

  @OnPreferenceClick(2131559195)
  private void onPreferenceClickShowFakeTokenVerification()
  {
    this.mBus.post(new ShowFakeTokenVerificationEvent());
  }

  @OnPreferenceClick(2131559160)
  private void onPreferenceClickShowFakeTripPendingRating()
  {
    City localCity = this.mPingProvider.get().getCity();
    VehicleView localVehicleView = localCity.findVehicleView(localCity.getDefaultVehicleViewId());
    TripPendingRatingDriver localTripPendingRatingDriver = new TripPendingRatingDriver();
    localTripPendingRatingDriver.setName(getString(2131559150));
    localTripPendingRatingDriver.setPictureUrl(getString(2131559149));
    TripPendingRating localTripPendingRating = new TripPendingRating();
    localTripPendingRating.setId(getString(2131559152));
    String str = getString(2131559151);
    localTripPendingRating.setFareString(str);
    localTripPendingRating.setFareBilledToCardString(str);
    localTripPendingRating.setDropOffEpoch(Long.valueOf(new Date().getTime()));
    localTripPendingRating.setVehicleView(localVehicleView);
    localTripPendingRating.setDriver(localTripPendingRatingDriver);
    localTripPendingRating.setFeedbackTypes(new ArrayList());
    this.mBus.post(new ShowFakeTripPendingRatingEvent(localTripPendingRating));
  }

  private void updateFavoriteLocationImpressionsCount()
  {
    int i = getResources().getInteger(2131492874);
    int j = this.mRiderPreferences.getFavoriteLocationImpressionCount();
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = Integer.valueOf(i);
    arrayOfObject[1] = Integer.valueOf(j);
    String str = getString(2131559212, arrayOfObject);
    this.mPreferenceFakeImpressionCount.setDialogMessage(str);
  }

  private void updatePreferenceBraintreeDevKey()
  {
    this.mPreferenceBraintreeDevKey.setChecked(this.mRiderPreferences.isUseBraintreeDevKey());
  }

  private void updatePreferenceDestinationEntry()
  {
    this.mPreferenceDestinationEntry.setValue(this.mRiderPreferences.getDestinationEntry());
    this.mPreferenceDestinationEntry.setSummary(this.mPreferenceDestinationEntry.getEntry());
  }

  private void updatePreferenceEssentialsCartEnabled()
  {
    this.mPreferenceFlagEssentialsCartEnabled.setChecked(this.mRiderPreferences.isEssentialsCartFeatureFlagEnabled());
  }

  private void updatePreferenceFailoverStrategy()
  {
    if (this.mUberPreferences.hasFakeCnFailoverStrategy())
    {
      this.mPreferenceFailoverStrategy.setValue(this.mUberPreferences.getFakeCnFailoverStrategy());
      this.mPreferenceFailoverStrategy.setSummary(this.mUberPreferences.getFakeCnFailoverStrategy());
      return;
    }
    this.mPreferenceFailoverStrategy.setValue(getString(2131559120));
    this.mPreferenceFailoverStrategy.setSummary(getString(2131559120));
  }

  private void updatePreferenceFakeExpenseService()
  {
    this.mPreferenceExpenseServiceFake.setChecked(this.mRiderPreferences.hasFakeExpenseService());
  }

  private void updatePreferenceFakeFavoriteLocationConstraints()
  {
    boolean bool = this.mRiderPreferences.hasFakeFavoriteLocationDistanceConstraints();
    this.mPreferenceFakeFavoriteLocationConstraints.setChecked(bool);
  }

  private void updatePreferenceFakeLastExpenseInfo()
  {
    this.mPreferenceLastExpenseInfoFake.setChecked(this.mRiderPreferences.hasFakeLastExpenseInfo());
  }

  private void updatePreferenceFakeLocation()
  {
    if (this.mUberPreferences.hasFakeLocation())
    {
      UberLocation localUberLocation = this.mUberPreferences.getFakeLocation();
      Locale localLocale = Locale.US;
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = Double.valueOf(localUberLocation.getUberLatLng().getLatitude());
      arrayOfObject[1] = Double.valueOf(localUberLocation.getUberLatLng().getLongitude());
      String str = String.format(localLocale, "(%.4f, %.4f)", arrayOfObject);
      this.mPreferenceLocationFake.setChecked(true);
      this.mPreferenceLocationFake.setSummary(str);
      return;
    }
    this.mPreferenceLocationFake.setChecked(false);
    this.mPreferenceLocationFake.setSummary(null);
  }

  private void updatePreferenceFakeMobileMessage()
  {
    this.mPreferenceFakeLegacyMobileMessage.setChecked(this.mRiderPreferences.hasFakeLegacyMobileMessage());
    this.mPreferenceMobileMessaging.setChecked(this.mRiderPreferences.hasFakeMobileMessage());
  }

  private void updatePreferenceFakeSurge()
  {
    Ping localPing = this.mPingProvider.get();
    if (!PingUtils.hasVehicleViews(localPing));
    while (true)
    {
      return;
      Iterator localIterator = localPing.getCity().getVehicleViews().values().iterator();
      while (localIterator.hasNext())
      {
        VehicleView localVehicleView = (VehicleView)localIterator.next();
        String str = this.mKeySurgeFakePrefix + String.valueOf(localVehicleView.getId());
        boolean bool = this.mRiderPreferences.hasSurgeFake(localVehicleView.getId());
        CheckBoxPreference localCheckBoxPreference1 = (CheckBoxPreference)this.mPreferenceSurgeFake.findPreference(str);
        if (localCheckBoxPreference1 == null)
        {
          CheckBoxPreference localCheckBoxPreference2 = new CheckBoxPreference(getActivity());
          localCheckBoxPreference2.setKey(str);
          localCheckBoxPreference2.setOnPreferenceChangeListener(this.mPreferenceChangeListenerSurge);
          localCheckBoxPreference2.setTitle(localVehicleView.getDescription());
          localCheckBoxPreference2.setPersistent(false);
          localCheckBoxPreference2.setChecked(bool);
          this.mPreferenceSurgeFake.addPreference(localCheckBoxPreference2);
        }
        else
        {
          localCheckBoxPreference1.setChecked(bool);
        }
      }
    }
  }

  private void updatePreferenceFakeSurgeScreenType()
  {
    if (this.mRiderPreferences.hasFakeSurgeScreenType())
    {
      String str = this.mRiderPreferences.getFakeSurgeScreenType();
      int i = this.mPreferenceFakeSurgeScreenType.findIndexOfValue(str);
      CharSequence localCharSequence = this.mPreferenceFakeSurgeScreenType.getEntries()[i];
      this.mPreferenceFakeSurgeScreenType.setValue(str);
      this.mPreferenceFakeSurgeScreenType.setSummary(localCharSequence);
      return;
    }
    this.mPreferenceFakeSurgeScreenType.setValue(null);
    this.mPreferenceFakeSurgeScreenType.setSummary(null);
  }

  private void updatePreferenceFareEstimateFlowVariant()
  {
    String str = this.mRiderPreferences.getFakeFareEstimateFlowVariant();
    if (TextUtils.isEmpty(str))
      return;
    int i = this.mPreferenceFareEstimateFlowVariant.findIndexOfValue(str);
    CharSequence localCharSequence = this.mPreferenceFareEstimateFlowVariant.getEntries()[i];
    this.mPreferenceFareEstimateFlowVariant.setValue(str);
    this.mPreferenceFareEstimateFlowVariant.setSummary(localCharSequence);
  }

  private void updatePreferenceFavoriteLocationsVariant()
  {
    String str = this.mRiderPreferences.getFakeFavoriteLocationsVariant();
    if (TextUtils.isEmpty(str))
      return;
    int i = this.mPreferenceFavoriteLocationsVariant.findIndexOfValue(str);
    CharSequence localCharSequence = this.mPreferenceFavoriteLocationsVariant.getEntries()[i];
    this.mPreferenceFavoriteLocationsVariant.setValue(str);
    this.mPreferenceFavoriteLocationsVariant.setSummary(localCharSequence);
  }

  private void updatePreferenceFlags()
  {
    this.mPreferenceDestinationEmphasisEnabled.setChecked(this.mRiderPreferences.isDestinationEmphasisEnabled());
    this.mPreferenceFlagMapAnimations.setChecked(this.mRiderPreferences.isFlagMapAnimationsEnabled());
    this.mPreferenceFlagNotificationsClients.setChecked(this.mRiderPreferences.isFlagNotificationsClientsEnabled());
  }

  private void updatePreferenceFroiceSliderEnabled()
  {
    this.mPreferenceFlagFroiceSliderEnabled.setChecked(this.mRiderPreferences.isFlagFroiceSliderEnabled());
  }

  private void updatePreferenceGeoEngine()
  {
    String str = getString(2131559153);
    if (this.mUberPreferences.hasFakeGeoEngine())
      switch (this.mUberPreferences.getFakeGeoEngine())
      {
      default:
      case 3:
      case 2:
      }
    while (true)
    {
      this.mPreferenceGeoEngine.setValue(str);
      this.mPreferenceGeoEngine.setSummary(str);
      return;
      str = getString(2131559154);
      continue;
      str = getString(2131559155);
    }
  }

  private void updatePreferenceGoogleWalletEnvironment()
  {
    int i = this.mRiderPreferences.getGoogleWalletEnvironment();
    if (i == 0)
    {
      this.mPreferenceGoogleWalletEnvironment.setValue(Integer.toString(0));
      this.mPreferenceGoogleWalletEnvironment.setSummary(getString(2131559304));
      return;
    }
    if (i == 2)
    {
      this.mPreferenceGoogleWalletEnvironment.setValue(Integer.toString(2));
      this.mPreferenceGoogleWalletEnvironment.setSummary(getString(2131559307));
      return;
    }
    this.mPreferenceGoogleWalletEnvironment.setValue(Integer.toString(1));
    this.mPreferenceGoogleWalletEnvironment.setSummary(getString(2131559303));
  }

  private void updatePreferenceLocationSearch()
  {
    this.mPreferenceLocationSearch.setValue(this.mRiderPreferences.getFlagLocationSearch());
    this.mPreferenceLocationSearch.setSummary(this.mPreferenceLocationSearch.getEntry());
  }

  private void updatePreferencePayPalEnv()
  {
    this.mPreferencePayPalEnv.setValue(this.mRiderPreferences.getPayPalEnvironment());
    this.mPreferencePayPalEnv.setSummary(this.mPreferencePayPalEnv.getEntry());
  }

  private void updatePreferencePaymentPayTm()
  {
    CheckBoxPreference localCheckBoxPreference = this.mPreferencePaymentIndiaWallet;
    if ((this.mRiderPreferences.isPayTmSignupEnabled()) && (this.mRiderPreferences.isPayTmEnabled()));
    for (boolean bool = true; ; bool = false)
    {
      localCheckBoxPreference.setChecked(bool);
      return;
    }
  }

  private void updatePreferenceServer()
  {
    String str1 = this.mUberPreferences.getCnEndpoint();
    if (TextUtils.isEmpty(str1))
    {
      String str2 = getString(2131559218);
      this.mPreferenceNetworkServer.setSummary(str2);
      return;
    }
    this.mPreferenceNetworkServer.setSummary(str1);
  }

  private void updatePreferenceSliderStyle()
  {
    String str = this.mRiderPreferences.getKeySliderStyle();
    int i = this.mPreferenceSliderStyle.findIndexOfValue(str);
    CharSequence localCharSequence = this.mPreferenceSliderStyle.getEntries()[i];
    this.mPreferenceSliderStyle.setValue(str);
    this.mPreferenceSliderStyle.setSummary(localCharSequence);
  }

  private void updatePreferenceSsl()
  {
    this.mPreferenceNetworkSsl.setChecked(this.mUberPreferences.isCnSslVerificationDisabled());
  }

  private void updatePreferenceVehiclesShowAll()
  {
    this.mPreferenceVehiclesShowAll.setChecked(this.mRiderPreferences.isShowingAllVehicles());
  }

  private void updatePreferenceVersionFake()
  {
    if (this.mUberPreferences.hasFakeVersion())
    {
      this.mPreferencesVersionFake.setSummary(this.mUberPreferences.getFakeVersion());
      return;
    }
    this.mPreferencesVersionFake.setSummary(null);
  }

  private void updatePreferences()
  {
    updatePreferenceBraintreeDevKey();
    updatePreferenceDestinationEntry();
    updatePreferenceEssentialsCartEnabled();
    updatePreferenceFailoverStrategy();
    updatePreferenceFakeExpenseService();
    updatePreferenceFakeFavoriteLocationConstraints();
    updatePreferenceFakeLastExpenseInfo();
    updatePreferenceFakeLocation();
    updatePreferenceFakeMobileMessage();
    updatePreferenceFakeSurge();
    updatePreferenceFakeSurgeScreenType();
    updatePreferenceFlags();
    updatePreferenceFroiceSliderEnabled();
    updatePreferenceGeoEngine();
    updatePreferenceGoogleWalletEnvironment();
    updatePreferenceLocationSearch();
    updatePreferencePaymentPayTm();
    updatePreferencePayPalEnv();
    updatePreferenceFareEstimateFlowVariant();
    updatePreferenceFavoriteLocationsVariant();
    updatePreferenceSliderStyle();
    updatePreferenceServer();
    updatePreferenceSsl();
    updatePreferenceVehiclesShowAll();
    updatePreferenceVersionFake();
    updateFavoriteLocationImpressionsCount();
  }

  public void notifyPreferenceChanged()
  {
    updatePreferences();
    this.mBus.post(new PreferenceChangedEvent());
  }

  public void onCreate(Bundle paramBundle)
  {
    ((RiderPublicActivity)getActivity()).inject(this);
    super.onCreate(paramBundle);
    this.mKeySurgeFakePrefix = getString(2131559210);
    addPreferencesFromResource(2131034112);
    PreferencesInjector.inject(this);
  }

  protected void onPreferenceChangedFakeLocation(RiderLocation paramRiderLocation)
  {
    this.mUberPreferences.setFakeLocation(paramRiderLocation);
    this.mLocationProvider.updateDeviceLocation(paramRiderLocation);
    notifyPreferenceChanged();
  }

  public void onResume()
  {
    super.onResume();
    getActivity().getActionBar().setDisplayShowCustomEnabled(false);
    getActivity().getActionBar().setTitle(getString(2131559215));
    updatePreferences();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.employee.EmployeeSettingsFragment
 * JD-Core Version:    0.6.2
 */