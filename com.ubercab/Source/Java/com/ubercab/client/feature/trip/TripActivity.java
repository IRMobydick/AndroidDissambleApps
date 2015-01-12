package com.ubercab.client.feature.trip;

import android.app.ActionBar;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnItemClick;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;
import com.ubercab.client.core.analytics.AnalyticsManager;
import com.ubercab.client.core.analytics.event.FareSplitEvent;
import com.ubercab.client.core.analytics.event.RequestVehicleEvent;
import com.ubercab.client.core.analytics.event.ShareEvent;
import com.ubercab.client.core.app.RiderPingActivity;
import com.ubercab.client.core.content.PingProvider;
import com.ubercab.client.core.content.RiderLocationProvider;
import com.ubercab.client.core.content.event.PingEvent;
import com.ubercab.client.core.drawer.DrawerItem;
import com.ubercab.client.core.drawer.DrawerListAdapter;
import com.ubercab.client.core.location.RiderLocation;
import com.ubercab.client.core.metrics.analytics.RiderEvents.Impression;
import com.ubercab.client.core.metrics.analytics.RiderEvents.Tap;
import com.ubercab.client.core.model.Capabilities;
import com.ubercab.client.core.model.City;
import com.ubercab.client.core.model.Client;
import com.ubercab.client.core.model.EmployeeUpgrade;
import com.ubercab.client.core.model.PaymentProfile;
import com.ubercab.client.core.model.Ping;
import com.ubercab.client.core.model.ReverseGeocode;
import com.ubercab.client.core.model.Trip;
import com.ubercab.client.core.model.TripDriver;
import com.ubercab.client.core.model.TripExpenseInfo;
import com.ubercab.client.core.model.TripPendingRating;
import com.ubercab.client.core.model.TunesProvider;
import com.ubercab.client.core.model.UnpaidBill;
import com.ubercab.client.core.network.RiderClient;
import com.ubercab.client.core.network.TunesClient;
import com.ubercab.client.core.network.events.EmployeeUpgradeResponseEvent;
import com.ubercab.client.core.network.events.FareSplitAcceptResponseEvent;
import com.ubercab.client.core.network.events.PickupResponseEvent;
import com.ubercab.client.core.network.events.TunesProviderResponseEvent;
import com.ubercab.client.core.util.AndroidUtils;
import com.ubercab.client.core.util.PingUtils;
import com.ubercab.client.core.vendor.google.GoogleWalletActivity;
import com.ubercab.client.feature.about.AboutActivity;
import com.ubercab.client.feature.employeeupgrade.EmployeeUpgradeFragment;
import com.ubercab.client.feature.eta.ShareEtaActivity;
import com.ubercab.client.feature.faresplit.master.FareSplitInviteActivity;
import com.ubercab.client.feature.faresplit.master.FareSplitSummaryFragment;
import com.ubercab.client.feature.faresplit.minion.FareSplitInvitationFragment;
import com.ubercab.client.feature.faresplit.minion.event.FareSplitInvitationEvent;
import com.ubercab.client.feature.music.LinkMusicProviderActivity;
import com.ubercab.client.feature.music.event.ConnectToMusicProviderEvent;
import com.ubercab.client.feature.music.event.DownloadAppEvent;
import com.ubercab.client.feature.music.event.OpenAppEvent;
import com.ubercab.client.feature.payment.PaymentActivity;
import com.ubercab.client.feature.payment.VerifyAlipayActivity;
import com.ubercab.client.feature.payment.expense.ExpenseInfoActivity;
import com.ubercab.client.feature.profile.ProfileActivity;
import com.ubercab.client.feature.promo.PromoActivity;
import com.ubercab.client.feature.receipt.ReceiptActivity;
import com.ubercab.client.feature.receipt.event.ShowReceiptEvent;
import com.ubercab.client.feature.share.ShareActivity;
import com.ubercab.client.feature.support.SupportHomeActivity;
import com.ubercab.client.feature.trip.dispatch.TitleView;
import com.ubercab.client.feature.trip.dispatch.TitleView.Listener;
import com.ubercab.client.feature.trip.event.AddBusinessCardExpenseInfoEvent;
import com.ubercab.client.feature.trip.event.AddDestinationEvent;
import com.ubercab.client.feature.trip.event.CancelingTripEvent;
import com.ubercab.client.feature.trip.event.ChangeTripPaymentEvent;
import com.ubercab.client.feature.trip.event.ConfirmClearDestinationEvent;
import com.ubercab.client.feature.trip.event.CreateGoogleWalletPaymentProfileEvent;
import com.ubercab.client.feature.trip.event.DismissFareDetailEvent;
import com.ubercab.client.feature.trip.event.HoldToCancelTripEvent;
import com.ubercab.client.feature.trip.event.SelectPaymentEvent;
import com.ubercab.client.feature.trip.event.ShareEtaEvent;
import com.ubercab.client.feature.trip.event.ShowFareDetailEvent;
import com.ubercab.client.feature.trip.event.SplitFareEvent;
import com.ubercab.client.feature.trip.event.TripFragmentReadyEvent;
import com.ubercab.client.feature.trip.event.TripUIStateChangedEvent;
import com.ubercab.common.collect.ObjectArrays;
import com.ubercab.library.app.BuildConfigProxy;
import com.ubercab.library.app.annotation.ForApp;
import com.ubercab.library.location.event.NoLocationEvent;
import com.ubercab.library.location.model.UberLatLng;
import com.ubercab.library.metrics.analytics.AnalyticsClient;
import com.ubercab.library.ui.ConfirmDialogFragment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Queue;
import javax.inject.Inject;

public class TripActivity extends RiderPingActivity
  implements TitleView.Listener
{
  private static final String BUNDLE_EMPLOYEE_UPGRADE_CHECKED = "com.ubercab.EMPLOYEE_UPGRADE_CHECKED";
  private static final String BUNDLE_HANDSHAKE_TRIP_ID = "com.ubercab.HANDSHAKE_TRIP_ID";
  private static final String BUNDLE_IS_CANCELING_DISPATCH = "com.ubercab.IS_CANCELING_DISPATCH";
  private static final int EMPLOYEE_UPGRADE_STATUS_CHECKED = 2;
  private static final int EMPLOYEE_UPGRADE_STATUS_CHECKING = 1;
  private static final int EMPLOYEE_UPGRADE_STATUS_NOT_CHECKED = 0;
  private static final int MENU_ABOUT = 4;
  private static final int MENU_PAYMENT = 1;
  private static final int MENU_PROFILE = 0;
  private static final int MENU_PROMO = 2;
  private static final int MENU_SHARE = 3;
  private static final int MENU_SUPPORT = 5;
  private static final int NAV_DRAWER_LAUNCH_DELAY = 250;
  private static final String PRODUCTION_PACKAGE_NAME = "com.ubercab";
  private static final int REQUEST_CODE_ADD_EXPENSE_INFO = 2011;
  private static final int REQUEST_CODE_CANCEL_TRIP = 2009;
  private static final int REQUEST_CODE_CHANGE_PAYMENT = 2006;
  private static final int REQUEST_CODE_CONFIRM_CLEAR_DESTINATION = 2011;
  private static final int REQUEST_CODE_CREATE_GOOGLE_WALLET_PAYMENT_PROFILE_ID = 2007;
  private static final int REQUEST_CODE_DISPATCH = 1050;
  private static final int REQUEST_CODE_FARE_SPLIT = 2010;
  private static final int REQUEST_CODE_INSUFFICIENT_BALANCE = 2012;
  private static final int REQUEST_CODE_MANAGE_PAYMENT = 2001;
  private static final int REQUEST_CODE_RECEIPT = 2008;
  private static final int REQUEST_CODE_SELECT_PAYMENT = 2005;
  private static final Uri SUPPORT_URI = Uri.parse("http://support.uber.com");

  @Inject
  AnalyticsClient mAnalyticsClient;

  @Inject
  AnalyticsManager mAnalyticsManager;

  @ForApp
  @Inject
  BuildConfigProxy mBuildConfig;

  @Inject
  Bus mBus;

  @InjectView(2131427769)
  DrawerLayout mDrawerLayout;
  private ActionBarDrawerToggle mDrawerToggle;
  private int mEmployeeUpgradeStatus;
  private String mGooglePaymentProfileIdForRequest;

  @Inject
  Gson mGson;
  private Handler mHandler;
  private String mHandshakeTripId;
  private boolean mIsCancelingDispatch;
  private int mLastTripUIState = -1;

  @InjectView(2131427771)
  ListView mListViewDrawer;

  @Inject
  RiderLocationProvider mLocationProvider;
  private MaskedWallet mMaskedWallet;

  @Inject
  PingProvider mPingProvider;
  private final Queue<Object> mQueuePendingEvents = new LinkedList();
  private BroadcastReceiver mReceiverNotificationAction = new NotificationActionReceiver(null);

  @Inject
  RiderClient mRiderClient;
  private TitleView mTitleView;

  @Inject
  TripUIStateManager mTripUIStateManager;

  @Inject
  TunesClient mTunesClient;

  private void checkForGoogleWalletPickupRequest()
  {
    if (this.mGooglePaymentProfileIdForRequest == null)
      return;
    ((TripFragment)findFragment(TripFragment.class)).sendPickupRequest(this.mGooglePaymentProfileIdForRequest, true);
    this.mGooglePaymentProfileIdForRequest = null;
  }

  private String getTitleForTripUIState(int paramInt)
  {
    switch (paramInt)
    {
    case 2:
    default:
      return null;
    case 1:
      return getString(2131558515).toUpperCase(Locale.getDefault());
    case 3:
      return getString(2131558817).toUpperCase(Locale.getDefault());
    case 4:
      return getString(2131558459).toUpperCase(Locale.getDefault());
    case 5:
    }
    return getString(2131558974).toUpperCase(Locale.getDefault());
  }

  private void handleNotificationIntent(Intent paramIntent)
  {
    String str;
    int i;
    if (paramIntent.getAction() != null)
    {
      str = paramIntent.getAction();
      i = -1;
      switch (str.hashCode())
      {
      default:
      case 440339789:
      case -1869739587:
      case -2038445361:
      case -1614102506:
      }
    }
    while (true)
      switch (i)
      {
      default:
        return;
        if (str.equals("com.ubercab.client.ACTION_TRIP_ADD_DESTINATION"))
        {
          i = 0;
          continue;
          if (str.equals("com.ubercab.client.ACTION_TRIP_CANCEL"))
          {
            i = 1;
            continue;
            if (str.equals("com.ubercab.client.ACTION_TRIP_SHARE_ETA"))
            {
              i = 2;
              continue;
              if (str.equals("com.ubercab.client.ACTION_TRIP_SPLIT_FARE"))
                i = 3;
            }
          }
        }
        break;
      case 0:
      case 1:
      case 2:
      case 3:
      }
    this.mQueuePendingEvents.add(new AddDestinationEvent());
    return;
    this.mQueuePendingEvents.add(new com.ubercab.client.feature.trip.event.CancelTripEvent());
    return;
    this.mQueuePendingEvents.add(new ShareEtaEvent());
    return;
    this.mQueuePendingEvents.add(new SplitFareEvent());
  }

  private void initActionBar()
  {
    ActionBar localActionBar = getActionBar();
    localActionBar.setDisplayHomeAsUpEnabled(true);
    localActionBar.setHomeButtonEnabled(true);
    localActionBar.setDisplayShowTitleEnabled(false);
    localActionBar.setCustomView(2130903208);
    localActionBar.setDisplayShowCustomEnabled(false);
    this.mTitleView = ((TitleView)localActionBar.getCustomView());
    this.mTitleView.addListener(this);
  }

  private void initMenuDrawer()
  {
    this.mDrawerToggle = new ActionBarDrawerToggle(this, this.mDrawerLayout, 2130837585, 2131559270, 2131559270)
    {
      public void onDrawerClosed(View paramAnonymousView)
      {
        super.onDrawerClosed(paramAnonymousView);
        TripActivity.this.mAnalyticsClient.sendTapEvent(RiderEvents.Tap.MENU_CLOSE);
      }

      public void onDrawerOpened(View paramAnonymousView)
      {
        super.onDrawerOpened(paramAnonymousView);
        TripActivity.this.mAnalyticsClient.sendTapEvent(RiderEvents.Tap.MENU_OPEN);
      }
    };
    this.mDrawerLayout.setDrawerListener(this.mDrawerToggle);
    this.mDrawerLayout.setScrimColor(getResources().getColor(2131296318));
    DrawerListAdapter localDrawerListAdapter = new DrawerListAdapter(this);
    Drawable localDrawable1 = getResources().getDrawable(2130837818);
    localDrawerListAdapter.add(new DrawerItem(0, getString(2131559013), localDrawable1));
    Drawable localDrawable2 = getResources().getDrawable(2130837817);
    localDrawerListAdapter.add(new DrawerItem(1, getString(2131558985), localDrawable2));
    Drawable localDrawable3 = getResources().getDrawable(2130837819);
    localDrawerListAdapter.add(new DrawerItem(2, getString(2131559017), localDrawable3));
    Drawable localDrawable4 = getResources().getDrawable(2130837820);
    localDrawerListAdapter.add(new DrawerItem(3, getString(2131559053), localDrawable4));
    Drawable localDrawable5 = getResources().getDrawable(2130837821);
    localDrawerListAdapter.add(new DrawerItem(5, getString(2131559090), localDrawable5));
    Drawable localDrawable6 = getResources().getDrawable(2130837815);
    localDrawerListAdapter.add(new DrawerItem(4, getString(2131558415), localDrawable6));
    this.mListViewDrawer.setCacheColorHint(0);
    this.mListViewDrawer.setAdapter(localDrawerListAdapter);
  }

  private void postPendingEvents()
  {
    if (isFinishing());
    while (true)
    {
      return;
      while (!this.mQueuePendingEvents.isEmpty())
        this.mBus.post(this.mQueuePendingEvents.remove());
    }
  }

  private void putTripFragment()
  {
    if (findFragment(TripFragment.class) == null)
      putFragment(2131427770, TripFragment.newInstance(), true);
  }

  private void sendUserToArrears(Ping paramPing)
  {
    if (!PingUtils.hasClient(paramPing))
      return;
    List localList = paramPing.getErrorObj();
    ArrayList localArrayList;
    Client localClient;
    if (localList != null)
    {
      String str = this.mGson.toJson(localList);
      TypeToken local3 = new TypeToken()
      {
      };
      localArrayList = (ArrayList)this.mGson.fromJson(str, local3.getType());
      localClient = paramPing.getClient();
      if (TextUtils.isEmpty(localClient.getLastSelectedPaymentGoogleWalletId()))
        break label151;
    }
    label151: for (PaymentProfile localPaymentProfile = PaymentProfile.GOOGLE_WALLET; ; localPaymentProfile = localClient.findLastSelectedPaymentProfile())
    {
      Intent localIntent = new Intent(this, PaymentActivity.class);
      localIntent.setAction("com.ubercab.ACTION_ARREARS");
      localIntent.putExtra("com.google.android.gms.wallet.EXTRA_MASKED_WALLET", this.mMaskedWallet);
      localIntent.putExtra("com.ubercab.PAYMENT_PROFILE", localPaymentProfile);
      localIntent.putParcelableArrayListExtra("com.ubercab.UNPAID_BILLS", localArrayList);
      startActivity(localIntent);
      return;
      localArrayList = new ArrayList();
      break;
    }
  }

  private void setExpenseInfoForTripFragment(Intent paramIntent)
  {
    if (paramIntent != null)
    {
      TripFragment localTripFragment = (TripFragment)findFragment(TripFragment.class);
      if (paramIntent.hasExtra("EXTRA_ACTIVITY_STARTED"))
        localTripFragment.setExpenseScreenShown(true);
      if (paramIntent.hasExtra("com.ubercab.EXPENSE_INFO"))
        localTripFragment.setExpenseInfo((TripExpenseInfo)paramIntent.getParcelableExtra("com.ubercab.EXPENSE_INFO"));
    }
  }

  private void showFareSplitDialog()
  {
    new FareSplitSummaryFragment().show(getFragmentManager(), FareSplitSummaryFragment.class.getName());
    this.mAnalyticsClient.sendTapEvent(RiderEvents.Tap.FARE_SPLIT_OPEN);
  }

  protected Object[] getModules()
  {
    return ObjectArrays.concat(super.getModules(), new TripModule());
  }

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 2008) && (paramInt2 == 0))
      onBackPressed();
    do
    {
      TripFragment localTripFragment;
      do
      {
        return;
        if ((paramInt1 == 1050) && (paramInt2 == 0))
        {
          finish();
          return;
        }
        if ((paramInt1 == 2001) && (paramInt2 == -1))
        {
          this.mMaskedWallet = ((MaskedWallet)paramIntent.getParcelableExtra("com.google.android.gms.wallet.EXTRA_MASKED_WALLET"));
          return;
        }
        if (paramInt1 != 2005)
          break;
        setExpenseInfoForTripFragment(paramIntent);
        if (paramInt2 != -1)
          break;
        this.mMaskedWallet = ((MaskedWallet)paramIntent.getParcelableExtra("com.google.android.gms.wallet.EXTRA_MASKED_WALLET"));
        localTripFragment = (TripFragment)findFragment(TripFragment.class);
        if (paramIntent.hasExtra("com.ubercab.PAYMENT_PROFILE"))
          localTripFragment.setSelectedPaymentProfile((PaymentProfile)paramIntent.getParcelableExtra("com.ubercab.PAYMENT_PROFILE"));
        if (paramIntent.hasExtra("com.ubercab.USE_CREDITS"))
          localTripFragment.setIsUsingCredits(paramIntent.getBooleanExtra("com.ubercab.USE_CREDITS", true));
      }
      while (!paramIntent.hasExtra("com.ubercab.USE_POINTS"));
      localTripFragment.setIsUsingPoints(paramIntent.getBooleanExtra("com.ubercab.USE_POINTS", false));
      return;
      if (paramInt1 == 2006)
      {
        setExpenseInfoForTripFragment(paramIntent);
        if (paramInt2 == -1)
        {
          PaymentProfile localPaymentProfile = (PaymentProfile)paramIntent.getParcelableExtra("com.ubercab.PAYMENT_PROFILE");
          ((TripFragment)findFragment(TripFragment.class)).setSelectedPaymentProfile(localPaymentProfile);
          return;
        }
      }
      if ((paramInt1 == 2007) && (paramInt2 == -1))
      {
        this.mMaskedWallet = ((MaskedWallet)paramIntent.getParcelableExtra("com.google.android.gms.wallet.EXTRA_MASKED_WALLET"));
        this.mGooglePaymentProfileIdForRequest = paramIntent.getStringExtra("com.ubercab.PAYMENT_PROFILE_ID");
        return;
      }
      if ((paramInt1 == 2011) && (paramInt2 == -1))
      {
        setExpenseInfoForTripFragment(paramIntent);
        ((TripFragment)findFragment(TripFragment.class)).sendPickupRequest(paramIntent.getStringExtra("EXTRA_PAYMENT_PROFILE_ID"), false);
      }
    }
    while ((paramInt1 != 2010) || (paramInt2 != -1));
    showFareSplitDialog();
  }

  @Subscribe
  public void onAddExpenseInfoBusinessCardEvent(AddBusinessCardExpenseInfoEvent paramAddBusinessCardExpenseInfoEvent)
  {
    startActivityForResult(ExpenseInfoActivity.newIntent(this, paramAddBusinessCardExpenseInfoEvent.getExpenseInfo(), paramAddBusinessCardExpenseInfoEvent.isShowSkipButton(), paramAddBusinessCardExpenseInfoEvent.getPaymentProfile()), 2011);
  }

  public void onBackPressed()
  {
    if (this.mDrawerLayout.isDrawerOpen(this.mListViewDrawer))
      this.mDrawerLayout.closeDrawers();
    TripFragment localTripFragment;
    do
    {
      return;
      localTripFragment = (TripFragment)findFragment(TripFragment.class);
    }
    while ((findFragment(TripFragment.class) != null) && (localTripFragment.onBackPressed()));
    super.onBackPressed();
  }

  public void onCancelAnimationElapsed()
  {
    this.mRiderClient.pickupCancelClient();
    this.mAnalyticsManager.cancelTripEvent().cancelTripRequest(this.mPingProvider.get().getClient().getStatus());
    this.mAnalyticsClient.sendTapEvent(RiderEvents.Tap.DISPATCH_CANCEL);
    this.mBus.post(new CancelingTripEvent());
  }

  @Subscribe
  public void onCancelTripEvent(com.ubercab.client.feature.trip.event.CancelTripEvent paramCancelTripEvent)
  {
    ConfirmDialogFragment.show(this, 2009, null, getString(2131558468), getString(2131559349), getString(2131558937));
    this.mAnalyticsClient.sendImpressionEvent(RiderEvents.Impression.TRIP_CANCEL_CONFIRMATION);
  }

  @Subscribe
  public void onCancelingTripEvent(CancelingTripEvent paramCancelingTripEvent)
  {
    this.mIsCancelingDispatch = true;
  }

  @Subscribe
  public void onChangeTripPaymentEvent(ChangeTripPaymentEvent paramChangeTripPaymentEvent)
  {
    Intent localIntent = new Intent(this, PaymentActivity.class);
    localIntent.setAction("com.ubercab.CHANGE_PAYMENT");
    localIntent.putExtra("com.ubercab.EXPENSE_INFO", paramChangeTripPaymentEvent.getExpenseInfo());
    startActivityForResult(localIntent, 2006);
  }

  @Subscribe
  public void onClearDestinationEvent(ConfirmClearDestinationEvent paramConfirmClearDestinationEvent)
  {
    ConfirmDialogFragment.show(this, 2011, getString(2131559026), getString(2131559025), getString(2131558973), getString(2131558467));
  }

  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    this.mDrawerToggle.onConfigurationChanged(paramConfiguration);
  }

  @Subscribe
  public void onConnectMusicProviderEvent(ConnectToMusicProviderEvent paramConnectToMusicProviderEvent)
  {
    startActivity(new Intent(this, LinkMusicProviderActivity.class));
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    initActionBar();
    setContentView(2130903191);
    ButterKnife.inject(this);
    initMenuDrawer();
    putTripFragment();
    this.mTripUIStateManager.restoreInstanceState(paramBundle);
    this.mHandler = new Handler();
    if (paramBundle == null)
      handleNotificationIntent(getIntent());
  }

  @Subscribe
  public void onCreateGoogleWalletPaymentProfileEvent(CreateGoogleWalletPaymentProfileEvent paramCreateGoogleWalletPaymentProfileEvent)
  {
    Intent localIntent = new Intent(this, GoogleWalletActivity.class);
    localIntent.setAction("com.ubercab.ACTION_CREATE_PAYMENT_PROFILE");
    localIntent.putExtra("com.google.android.gms.wallet.EXTRA_MASKED_WALLET", this.mMaskedWallet);
    startActivityForResult(localIntent, 2007);
  }

  public void onDialogResult(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    super.onDialogResult(paramInt1, paramInt2, paramBundle);
    if (paramInt1 == 2009)
      if (paramInt2 == -1)
      {
        ((TripFragment)findFragment(TripFragment.class)).sendCancelTripRequest();
        this.mAnalyticsClient.sendTapEvent(RiderEvents.Tap.TRIP_CANCEL_CONFIRMATION_CONFIRM);
      }
    do
    {
      TripFragment localTripFragment1;
      do
      {
        do
        {
          return;
          this.mAnalyticsClient.sendTapEvent(RiderEvents.Tap.TRIP_CANCEL_CONFIRMATION_CANCEL);
          return;
          if ((paramInt1 == 2011) && (paramInt2 == -1))
          {
            TripFragment localTripFragment2 = (TripFragment)findFragment(TripFragment.class);
            localTripFragment2.clearDestination();
            localTripFragment2.sendSetDestinationRequest(null);
          }
        }
        while (paramInt1 != 2012);
        if (paramInt2 != -1)
          break;
        this.mAnalyticsClient.sendTapEvent(RiderEvents.Tap.WALLET_LOW_BALANCE_ADD_MONEY);
        localTripFragment1 = (TripFragment)findFragment(TripFragment.class);
      }
      while (localTripFragment1 == null);
      localTripFragment1.showAddFunds();
      return;
    }
    while (paramInt2 != 0);
    this.mAnalyticsClient.sendTapEvent(RiderEvents.Tap.WALLET_LOW_BALANCE_CANCEL);
  }

  @Subscribe
  public void onDismissFareDetailEvent(DismissFareDetailEvent paramDismissFareDetailEvent)
  {
    this.mDrawerLayout.setDrawerLockMode(0);
  }

  @Subscribe
  public void onDownloadMusicAppEvent(DownloadAppEvent paramDownloadAppEvent)
  {
    startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + paramDownloadAppEvent.getPackageName())));
  }

  @Subscribe
  public void onEmployeeUpgradeEvent(EmployeeUpgradeResponseEvent paramEmployeeUpgradeResponseEvent)
  {
    if (paramEmployeeUpgradeResponseEvent.isApiSuccess())
    {
      this.mEmployeeUpgradeStatus = 2;
      EmployeeUpgrade localEmployeeUpgrade = paramEmployeeUpgradeResponseEvent.getDefaultEmployeeUpgrade();
      if ((localEmployeeUpgrade != null) && (AndroidUtils.versionCompare(localEmployeeUpgrade.getVersion(), "3.23.2").intValue() > 0))
      {
        EmployeeUpgradeFragment localEmployeeUpgradeFragment = EmployeeUpgradeFragment.newInstance(localEmployeeUpgrade);
        localEmployeeUpgradeFragment.setCancelable(false);
        localEmployeeUpgradeFragment.show(getFragmentManager(), EmployeeUpgradeFragment.TAG);
      }
      return;
    }
    this.mEmployeeUpgradeStatus = 0;
  }

  @Subscribe
  public void onFareSplitAcceptResponseEvent(FareSplitAcceptResponseEvent paramFareSplitAcceptResponseEvent)
  {
    if ((!paramFareSplitAcceptResponseEvent.isSuccess()) && (PingUtils.hasErrorCode((Ping)paramFareSplitAcceptResponseEvent.getModel(), 430)))
      sendUserToArrears((Ping)paramFareSplitAcceptResponseEvent.getModel());
  }

  @Subscribe
  public void onFareSplitInvitationEvent(FareSplitInvitationEvent paramFareSplitInvitationEvent)
  {
    if (findFragment(FareSplitInvitationFragment.class) == null)
    {
      FareSplitInvitationFragment localFareSplitInvitationFragment = new FareSplitInvitationFragment();
      Ping localPing = this.mPingProvider.get();
      if ((PingUtils.hasLastSelectedPaymentProfileId(localPing)) && (PingUtils.hasClientPaymentProfiles(localPing)))
      {
        Client localClient = localPing.getClient();
        localFareSplitInvitationFragment.setPaymentProfile(localClient.findPaymentProfileWithId(localClient.getLastSelectedPaymentProfileId()));
      }
      localFareSplitInvitationFragment.show(getFragmentManager(), FareSplitInvitationFragment.class.getName());
    }
  }

  @OnItemClick({2131427771})
  public void onItemClick(final long paramLong)
  {
    this.mHandler.postDelayed(new Runnable()
    {
      public void run()
      {
        switch ((int)paramLong)
        {
        default:
          return;
        case 4:
          TripActivity.this.startActivity(new Intent(TripActivity.this, AboutActivity.class));
          return;
        case 1:
          Intent localIntent2 = new Intent(TripActivity.this, PaymentActivity.class);
          localIntent2.setAction("com.ubercab.MANAGE_PAYMENT");
          localIntent2.putExtra("com.google.android.gms.wallet.EXTRA_MASKED_WALLET", TripActivity.this.mMaskedWallet);
          TripActivity.this.startActivityForResult(localIntent2, 2001);
          TripActivity.this.mAnalyticsClient.sendTapEvent(RiderEvents.Tap.PAYMENT_BUTTON_MENU);
          return;
        case 0:
          TripActivity.this.startActivity(new Intent(TripActivity.this, ProfileActivity.class));
          return;
        case 2:
          TripActivity.this.startActivity(new Intent(TripActivity.this, PromoActivity.class));
          TripActivity.this.mAnalyticsClient.sendTapEvent(RiderEvents.Tap.PROMO_CODE_OPEN_MENU);
          return;
        case 3:
          TripActivity.this.startActivity(new Intent(TripActivity.this, ShareActivity.class));
          return;
        case 5:
        }
        if (TripActivity.this.getResources().getBoolean(2131230729))
        {
          TripActivity.this.startActivity(new Intent(TripActivity.this, SupportHomeActivity.class));
          return;
        }
        Intent localIntent1 = new Intent("android.intent.action.VIEW", TripActivity.SUPPORT_URI);
        localIntent1.setFlags(268435456);
        TripActivity.this.startActivity(localIntent1);
      }
    }
    , 250L);
    this.mDrawerLayout.closeDrawers();
  }

  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    handleNotificationIntent(paramIntent);
  }

  @Subscribe
  public void onNoLocationEvent(NoLocationEvent paramNoLocationEvent)
  {
    alertIfLocationServicesDisabled();
  }

  @Subscribe
  public void onOpenMusicAppEvent(OpenAppEvent paramOpenAppEvent)
  {
    startActivity(getPackageManager().getLaunchIntentForPackage(paramOpenAppEvent.getPackageName()));
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (this.mDrawerToggle.onOptionsItemSelected(paramMenuItem));
    while ((paramMenuItem.getItemId() != 16908332) && (super.onOptionsItemSelected(paramMenuItem)))
      return true;
    return false;
  }

  public void onPause()
  {
    super.onPause();
    unregisterReceiver(this.mReceiverNotificationAction);
    this.mTripUIStateManager.stop();
  }

  @Subscribe
  public void onPickupResponseEvent(PickupResponseEvent paramPickupResponseEvent)
  {
    if (!paramPickupResponseEvent.isSuccess())
    {
      if (!PingUtils.hasErrorCode((Ping)paramPickupResponseEvent.getModel(), 430))
        break label49;
      sendUserToArrears((Ping)paramPickupResponseEvent.getModel());
    }
    while (true)
    {
      this.mAnalyticsManager.requestVehicleEvent().requestVehicleResponse(paramPickupResponseEvent.getStatusCode());
      return;
      label49: if (PingUtils.hasErrorCode((Ping)paramPickupResponseEvent.getModel(), 402))
      {
        this.mAnalyticsClient.sendImpressionEvent(RiderEvents.Impression.WALLET_LOW_BALANCE_ALERT);
        ConfirmDialogFragment.show(this, 2012, getString(2131558898), getString(2131558897), getString(2131558434), getString(2131558467));
      }
    }
  }

  @Subscribe
  public void onPingEvent(PingEvent paramPingEvent)
  {
    if (isFinishing());
    Ping localPing;
    String str;
    do
    {
      return;
      localPing = paramPingEvent.getPing();
      if (!PingUtils.hasClient(localPing))
        break;
      if (PingUtils.hasInactivePaymentProfiles(localPing))
      {
        Iterator localIterator = localPing.getClient().getInactivePaymentProfiles().iterator();
        while (localIterator.hasNext())
          if (((PaymentProfile)localIterator.next()).getCardType().equals("Alipay"))
          {
            startActivity(new Intent(this, VerifyAlipayActivity.class).setFlags(268468224));
            return;
          }
      }
      if ((localPing.getClient().isAdmin()) && (this.mEmployeeUpgradeStatus == 0) && (this.mBuildConfig.getPackageName().equals("com.ubercab")) && (!this.mBuildConfig.isDebug()))
      {
        this.mEmployeeUpgradeStatus = 1;
        this.mRiderClient.checkForEmployeeUpgrade();
      }
      str = localPing.getClient().getStatus();
    }
    while ("Dispatching".equals(str));
    this.mIsCancelingDispatch = false;
    label212: int i;
    switch (str.hashCode())
    {
    default:
      i = -1;
      label215: switch (i)
      {
      default:
      case 0:
      case 1:
      }
      break;
    case 2014441667:
    case -1929061692:
    }
    while (true)
    {
      if ((PingUtils.hasTripDriver(localPing)) && (PingUtils.hasCity(localPing)) && (PingUtils.hasClient(localPing)) && (localPing.getTrip().getDriver().getCapabilities() != null) && (localPing.getTrip().getDriver().getCapabilities().isMusicEnabled()) && (localPing.getClient().getThirdPartyIdentities().containsKey("spotify")) && (!localPing.getTrip().getId().equals(this.mHandshakeTripId)))
        this.mTunesClient.provider("spotify", localPing.getCity().getCityName());
      if (!PingUtils.hasTripPendingRating(localPing))
        break;
      TripPendingRating localTripPendingRating = localPing.getClient().getTripPendingRating();
      this.mBus.post(new ShowReceiptEvent(localTripPendingRating.getId()));
      return;
      if (!str.equals("Looking"))
        break label212;
      i = 0;
      break label215;
      if (!str.equals("OnTrip"))
        break label212;
      i = 1;
      break label215;
      if (this.mLocationProvider.getPinLocation() == null)
      {
        Object localObject = this.mLocationProvider.getDeviceLocation();
        ReverseGeocode localReverseGeocode = localPing.getClient().getReverseGeocode();
        if ((localObject != null) && (localReverseGeocode != null))
        {
          RiderLocation localRiderLocation = RiderLocation.create(localReverseGeocode);
          if (((RiderLocation)localObject).getUberLatLng().equals(localRiderLocation.getUberLatLng()))
            localObject = localRiderLocation;
        }
        this.mLocationProvider.updatePinLocation((RiderLocation)localObject);
        continue;
        this.mLocationProvider.clearPinLocation();
      }
    }
  }

  protected void onPostCreate(Bundle paramBundle)
  {
    super.onPostCreate(paramBundle);
    this.mDrawerToggle.syncState();
  }

  protected void onRestoreInstanceState(Bundle paramBundle)
  {
    super.onRestoreInstanceState(paramBundle);
    this.mMaskedWallet = ((MaskedWallet)paramBundle.getParcelable("com.google.android.gms.wallet.EXTRA_MASKED_WALLET"));
    this.mIsCancelingDispatch = paramBundle.getBoolean("com.ubercab.IS_CANCELING_DISPATCH");
    this.mEmployeeUpgradeStatus = paramBundle.getInt("com.ubercab.EMPLOYEE_UPGRADE_CHECKED");
    this.mHandshakeTripId = paramBundle.getString("com.ubercab.HANDSHAKE_TRIP_ID");
  }

  public void onResume()
  {
    super.onResume();
    checkForGoogleWalletPickupRequest();
    this.mEmployeeUpgradeStatus = 0;
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.ubercab.client.ACTION_TRIP_ADD_DESTINATION");
    localIntentFilter.addAction("com.ubercab.client.ACTION_TRIP_CANCEL");
    localIntentFilter.addAction("com.ubercab.client.ACTION_TRIP_SHARE_ETA");
    localIntentFilter.addAction("com.ubercab.client.ACTION_TRIP_SPLIT_FARE");
    localIntentFilter.setPriority(100000);
    registerReceiver(this.mReceiverNotificationAction, localIntentFilter);
    this.mTripUIStateManager.start();
  }

  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putParcelable("com.google.android.gms.wallet.EXTRA_MASKED_WALLET", this.mMaskedWallet);
    paramBundle.putBoolean("com.ubercab.IS_CANCELING_DISPATCH", this.mIsCancelingDispatch);
    paramBundle.putInt("com.ubercab.EMPLOYEE_UPGRADE_CHECKED", this.mEmployeeUpgradeStatus);
    paramBundle.putString("com.ubercab.HANDSHAKE_TRIP_ID", this.mHandshakeTripId);
    this.mTripUIStateManager.saveInstanceState(paramBundle);
  }

  @Subscribe
  public void onSelectPaymentEvent(SelectPaymentEvent paramSelectPaymentEvent)
  {
    Intent localIntent = new Intent(this, PaymentActivity.class);
    localIntent.setAction("com.ubercab.SELECT_PAYMENT");
    localIntent.putExtra("com.ubercab.EXPENSE_INFO", paramSelectPaymentEvent.getExpenseInfo());
    localIntent.putExtra("com.google.android.gms.wallet.EXTRA_MASKED_WALLET", this.mMaskedWallet);
    localIntent.putExtra("com.ubercab.PAYMENT_PROFILE", paramSelectPaymentEvent.getCurrentPaymentProfile());
    localIntent.putExtra("com.ubercab.USE_CREDITS", paramSelectPaymentEvent.isUsingCredits());
    localIntent.putExtra("com.ubercab.USE_POINTS", paramSelectPaymentEvent.isUsingPoints());
    localIntent.putExtra("com.ubercab.SHOW_PROMO", this.mTripUIStateManager.showNewConfirmation());
    startActivityForResult(localIntent, 2005);
  }

  @Subscribe
  public void onShareEtaEvent(ShareEtaEvent paramShareEtaEvent)
  {
    startActivity(new Intent(this, ShareEtaActivity.class));
    this.mAnalyticsManager.shareEvent().shareEtaOpen();
    this.mAnalyticsClient.sendTapEvent(RiderEvents.Tap.SHARE_ETA_OPEN);
  }

  @Subscribe
  public void onShowFareDetailEvent(ShowFareDetailEvent paramShowFareDetailEvent)
  {
    this.mDrawerLayout.setDrawerLockMode(1);
  }

  @Subscribe
  public void onShowReceiptEvent(ShowReceiptEvent paramShowReceiptEvent)
  {
    startActivityForResult(new Intent(this, ReceiptActivity.class), 2008);
  }

  @Subscribe
  public void onSplitFareEvent(SplitFareEvent paramSplitFareEvent)
  {
    if (!PingUtils.hasFareSplit(this.mPingProvider.get()))
      startActivityForResult(new Intent(this, FareSplitInviteActivity.class), 2010);
    while (true)
    {
      this.mAnalyticsManager.fareSplitEvent().open(PingUtils.isTripMaster(this.mPingProvider.get()));
      return;
      showFareSplitDialog();
    }
  }

  @Subscribe
  public void onToggleCancelTripTimerEvent(HoldToCancelTripEvent paramHoldToCancelTripEvent)
  {
    if (paramHoldToCancelTripEvent.isCanceling())
    {
      this.mTitleView.startCancelAnimation();
      return;
    }
    this.mTitleView.stopCancelAnimation();
  }

  @Subscribe
  public void onTripFragmentReadyEvent(TripFragmentReadyEvent paramTripFragmentReadyEvent)
  {
    postPendingEvents();
  }

  @Subscribe
  public void onTripUIStatusChangedEvent(TripUIStateChangedEvent paramTripUIStateChangedEvent)
  {
    int i = 1;
    ActionBar localActionBar = getActionBar();
    if (localActionBar == null);
    while (this.mLastTripUIState == paramTripUIStateChangedEvent.getState())
      return;
    this.mLastTripUIState = paramTripUIStateChangedEvent.getState();
    String str;
    switch (paramTripUIStateChangedEvent.getState())
    {
    default:
      localActionBar.setDisplayShowHomeEnabled(i);
      localActionBar.setDisplayShowCustomEnabled(false);
      localActionBar.setDisplayHomeAsUpEnabled(i);
      this.mDrawerToggle.setDrawerIndicatorEnabled(i);
      this.mDrawerLayout.setDrawerLockMode(0);
      str = getTitleForTripUIState(paramTripUIStateChangedEvent.getState());
      if (TextUtils.isEmpty(str))
        break;
    case 1:
    case 2:
    }
    while (true)
    {
      localActionBar.setDisplayShowTitleEnabled(i);
      localActionBar.setTitle(str);
      return;
      localActionBar.setDisplayShowCustomEnabled(false);
      localActionBar.setDisplayShowHomeEnabled(i);
      localActionBar.setDisplayHomeAsUpEnabled(i);
      this.mDrawerToggle.setDrawerIndicatorEnabled(false);
      this.mDrawerLayout.setDrawerLockMode(i);
      break;
      this.mTitleView.reset();
      localActionBar.setDisplayShowCustomEnabled(i);
      this.mDrawerToggle.setDrawerIndicatorEnabled(false);
      this.mDrawerLayout.setDrawerLockMode(i);
      localActionBar.setDisplayShowHomeEnabled(false);
      localActionBar.setDisplayHomeAsUpEnabled(false);
      break;
      int j = 0;
    }
  }

  @Subscribe
  public void onTunesProviderResponseEvent(TunesProviderResponseEvent paramTunesProviderResponseEvent)
  {
    if (paramTunesProviderResponseEvent.isSuccess())
    {
      Ping localPing = this.mPingProvider.get();
      if ((PingUtils.hasTripDriver(localPing)) && (localPing.getTrip().getDriver().getCapabilities() != null) && (localPing.getTrip().getDriver().getCapabilities().isMusicEnabled()))
      {
        TunesProvider localTunesProvider = (TunesProvider)paramTunesProviderResponseEvent.getModel();
        this.mHandshakeTripId = localPing.getTrip().getId();
        this.mTunesClient.handshake(this.mHandshakeTripId, localTunesProvider.getId(), localTunesProvider.getAccessToken());
      }
    }
  }

  private class NotificationActionReceiver extends BroadcastReceiver
  {
    private NotificationActionReceiver()
    {
    }

    public void onReceive(Context paramContext, Intent paramIntent)
    {
      TripActivity.this.handleNotificationIntent(paramIntent);
      TripActivity.this.postPendingEvents();
      abortBroadcast();
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.trip.TripActivity
 * JD-Core Version:    0.6.2
 */